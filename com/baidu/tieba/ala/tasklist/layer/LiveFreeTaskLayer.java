package com.baidu.tieba.ala.tasklist.layer;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.core.layer.LayerChildView;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.ad;
import com.baidu.live.data.ai;
import com.baidu.live.data.aj;
import com.baidu.live.data.bj;
import com.baidu.live.data.by;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.tieba.ala.tasklist.a.b;
import com.baidu.tieba.ala.tasklist.model.a;
/* loaded from: classes4.dex */
public class LiveFreeTaskLayer extends LayerChildView {
    private CommonEmptyView bjf;
    private View.OnClickListener eHN;
    private View fpN;
    private a hcV;
    private b hcW;
    private TextView hcX;
    private ImageView hcY;
    private TextView hcZ;
    private TextView hda;
    private LinearLayout hdb;
    private boolean hdc;
    private boolean hdd;
    private int hde;
    private boolean hdf;
    private AlertDialog hdg;
    private Dialog hdh;
    private a.InterfaceC0657a hdi;
    private CustomMessageListener hdj;
    private View.OnTouchListener hdk;
    private Context mContext;
    private BdListView mListView;
    private View mRootView;

    public LiveFreeTaskLayer(@NonNull Context context) {
        super(context);
        this.hdc = false;
        this.hdi = new a.InterfaceC0657a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5
            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0657a
            public void a(AlaLiveUserInfoData alaLiveUserInfoData, aj ajVar) {
                if (alaLiveUserInfoData != null) {
                    LiveFreeTaskLayer.this.aA(String.valueOf(alaLiveUserInfoData.petalNum), true);
                    TbadkCoreApplication.getInst().currentAccountFlowerNum = alaLiveUserInfoData.petalNum;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                } else {
                    LiveFreeTaskLayer.this.aA("", false);
                }
                if (ajVar != null) {
                    LiveFreeTaskLayer.this.hcW.setData(ajVar.aJc);
                }
                LiveFreeTaskLayer.this.ccg();
            }

            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0657a
            public void an(int i, String str) {
                LiveFreeTaskLayer.this.bjf.reset();
                LiveFreeTaskLayer.this.bjf.setTitle(a.i.ala_task_empty_msg);
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    LiveFreeTaskLayer.this.bjf.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
                } else {
                    LiveFreeTaskLayer.this.bjf.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LiveFreeTaskLayer.this.bvV();
                        }
                    });
                    LiveFreeTaskLayer.this.bjf.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
                }
                LiveFreeTaskLayer.this.bjf.setVisibility(0);
                if (i != 146021) {
                    if (LiveFreeTaskLayer.this.hcV.cck() != null && ListUtils.getCount(LiveFreeTaskLayer.this.hcV.cck().aJc) > 0) {
                        BdUtilHelper.showToast(LiveFreeTaskLayer.this.getContext(), str);
                        return;
                    }
                    return;
                }
                LiveFreeTaskLayer.this.cch();
            }
        };
        this.hdj = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    LiveFreeTaskLayer.this.hcW.k((Integer) customResponsedMessage.getData());
                }
            }
        };
        this.hdk = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (view == LiveFreeTaskLayer.this.hdb) {
                        if (LiveFreeTaskLayer.this.hdc) {
                            LiveFreeTaskLayer.this.hideTip();
                            return true;
                        }
                        return true;
                    }
                    LiveFreeTaskLayer.this.cci();
                    return true;
                }
                return true;
            }
        };
        this.eHN = new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == LiveFreeTaskLayer.this.hcY) {
                    if (LiveFreeTaskLayer.this.hdc) {
                        LiveFreeTaskLayer.this.hideTip();
                    } else {
                        LiveFreeTaskLayer.this.ccj();
                    }
                }
            }
        };
        init(context);
    }

    public LiveFreeTaskLayer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hdc = false;
        this.hdi = new a.InterfaceC0657a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5
            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0657a
            public void a(AlaLiveUserInfoData alaLiveUserInfoData, aj ajVar) {
                if (alaLiveUserInfoData != null) {
                    LiveFreeTaskLayer.this.aA(String.valueOf(alaLiveUserInfoData.petalNum), true);
                    TbadkCoreApplication.getInst().currentAccountFlowerNum = alaLiveUserInfoData.petalNum;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                } else {
                    LiveFreeTaskLayer.this.aA("", false);
                }
                if (ajVar != null) {
                    LiveFreeTaskLayer.this.hcW.setData(ajVar.aJc);
                }
                LiveFreeTaskLayer.this.ccg();
            }

            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0657a
            public void an(int i, String str) {
                LiveFreeTaskLayer.this.bjf.reset();
                LiveFreeTaskLayer.this.bjf.setTitle(a.i.ala_task_empty_msg);
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    LiveFreeTaskLayer.this.bjf.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
                } else {
                    LiveFreeTaskLayer.this.bjf.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LiveFreeTaskLayer.this.bvV();
                        }
                    });
                    LiveFreeTaskLayer.this.bjf.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
                }
                LiveFreeTaskLayer.this.bjf.setVisibility(0);
                if (i != 146021) {
                    if (LiveFreeTaskLayer.this.hcV.cck() != null && ListUtils.getCount(LiveFreeTaskLayer.this.hcV.cck().aJc) > 0) {
                        BdUtilHelper.showToast(LiveFreeTaskLayer.this.getContext(), str);
                        return;
                    }
                    return;
                }
                LiveFreeTaskLayer.this.cch();
            }
        };
        this.hdj = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    LiveFreeTaskLayer.this.hcW.k((Integer) customResponsedMessage.getData());
                }
            }
        };
        this.hdk = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (view == LiveFreeTaskLayer.this.hdb) {
                        if (LiveFreeTaskLayer.this.hdc) {
                            LiveFreeTaskLayer.this.hideTip();
                            return true;
                        }
                        return true;
                    }
                    LiveFreeTaskLayer.this.cci();
                    return true;
                }
                return true;
            }
        };
        this.eHN = new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == LiveFreeTaskLayer.this.hcY) {
                    if (LiveFreeTaskLayer.this.hdc) {
                        LiveFreeTaskLayer.this.hideTip();
                    } else {
                        LiveFreeTaskLayer.this.ccj();
                    }
                }
            }
        };
        init(context);
    }

    public LiveFreeTaskLayer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hdc = false;
        this.hdi = new a.InterfaceC0657a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5
            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0657a
            public void a(AlaLiveUserInfoData alaLiveUserInfoData, aj ajVar) {
                if (alaLiveUserInfoData != null) {
                    LiveFreeTaskLayer.this.aA(String.valueOf(alaLiveUserInfoData.petalNum), true);
                    TbadkCoreApplication.getInst().currentAccountFlowerNum = alaLiveUserInfoData.petalNum;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                } else {
                    LiveFreeTaskLayer.this.aA("", false);
                }
                if (ajVar != null) {
                    LiveFreeTaskLayer.this.hcW.setData(ajVar.aJc);
                }
                LiveFreeTaskLayer.this.ccg();
            }

            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0657a
            public void an(int i2, String str) {
                LiveFreeTaskLayer.this.bjf.reset();
                LiveFreeTaskLayer.this.bjf.setTitle(a.i.ala_task_empty_msg);
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    LiveFreeTaskLayer.this.bjf.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
                } else {
                    LiveFreeTaskLayer.this.bjf.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LiveFreeTaskLayer.this.bvV();
                        }
                    });
                    LiveFreeTaskLayer.this.bjf.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
                }
                LiveFreeTaskLayer.this.bjf.setVisibility(0);
                if (i2 != 146021) {
                    if (LiveFreeTaskLayer.this.hcV.cck() != null && ListUtils.getCount(LiveFreeTaskLayer.this.hcV.cck().aJc) > 0) {
                        BdUtilHelper.showToast(LiveFreeTaskLayer.this.getContext(), str);
                        return;
                    }
                    return;
                }
                LiveFreeTaskLayer.this.cch();
            }
        };
        this.hdj = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    LiveFreeTaskLayer.this.hcW.k((Integer) customResponsedMessage.getData());
                }
            }
        };
        this.hdk = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (view == LiveFreeTaskLayer.this.hdb) {
                        if (LiveFreeTaskLayer.this.hdc) {
                            LiveFreeTaskLayer.this.hideTip();
                            return true;
                        }
                        return true;
                    }
                    LiveFreeTaskLayer.this.cci();
                    return true;
                }
                return true;
            }
        };
        this.eHN = new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == LiveFreeTaskLayer.this.hcY) {
                    if (LiveFreeTaskLayer.this.hdc) {
                        LiveFreeTaskLayer.this.hideTip();
                    } else {
                        LiveFreeTaskLayer.this.ccj();
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = View.inflate(getContext(), a.h.ala_task_list_layout, this);
        this.hdb = (LinearLayout) this.mRootView.findViewById(a.g.layout_content);
        this.hcX = (TextView) this.mRootView.findViewById(a.g.tv_flower_task_title);
        this.hcY = (ImageView) this.mRootView.findViewById(a.g.img_flower_help);
        this.fpN = this.mRootView.findViewById(a.g.divider);
        this.hcZ = (TextView) this.mRootView.findViewById(a.g.tv_flower_count);
        this.hda = (TextView) this.mRootView.findViewById(a.g.tv_task_help_tips);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.detail_list);
        this.bjf = (CommonEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.hcW = new b(getContext(), new com.baidu.tieba.ala.tasklist.a.a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.1
            @Override // com.baidu.tieba.ala.tasklist.a.a
            public void vr(int i) {
                if (LiveFreeTaskLayer.this.hcV != null) {
                    LiveFreeTaskLayer.this.hcV.vr(i);
                }
            }
        });
        this.mListView.setAdapter((ListAdapter) this.hcW);
        this.mListView.setEmptyView(this.bjf);
        this.mRootView.setOnTouchListener(this.hdk);
        this.hdb.setOnTouchListener(this.hdk);
        this.hcY.setOnClickListener(this.eHN);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
        if (screenDimensions[1] > screenDimensions[0]) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hdb.getLayoutParams();
            layoutParams.height = (int) (screenDimensions[1] * 0.618d);
            this.hdb.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Cu() {
        this.hcV = new com.baidu.tieba.ala.tasklist.model.a();
        this.hcV.a(this.hdi);
        MessageManager.getInstance().registerListener(this.hdj);
        bvV();
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Cv() {
        if (this.hcV != null) {
            this.hcV.onDestroy();
            this.hcV = null;
        }
        MessageManager.getInstance().unRegisterListener(this.hdj);
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Cw() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Cx() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void release() {
        super.release();
        if (this.hcV != null) {
            this.hcV.onDestroy();
            this.hcV = null;
        }
        if (this.hdh != null && this.hdh.isShowing()) {
            this.hdh.dismiss();
            this.hdh = null;
        }
        if (this.hdg != null && this.hdg.isShowing()) {
            this.hdg.dismiss();
            this.hdg = null;
        }
        MessageManager.getInstance().unRegisterListener(this.hdj);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            if (this.hdh != null && this.hdh.isShowing()) {
                this.hdh.dismiss();
                this.hdh = null;
            }
            if (this.hdg != null && this.hdg.isShowing()) {
                this.hdg.dismiss();
                this.hdg = null;
            }
            com.baidu.live.core.layer.b.CA().e(this);
        }
    }

    public void setIsFromFlowerGuide(boolean z) {
        this.hdd = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvV() {
        this.bjf.setVisibility(8);
        this.hcV.ccn();
    }

    private void vr(int i) {
        this.hcV.vr(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccg() {
        ai Dg;
        if (this.hdd && this.hde < 3 && (Dg = this.hcW.Dg()) != null) {
            if (Dg.status == 2) {
                vr(Dg.aIU);
                this.hde++;
                this.hdf = true;
                return;
            }
            this.hdd = false;
            if (this.hdf) {
                this.hdf = false;
                vs(Dg.aIZ);
            }
        }
    }

    private void vs(int i) {
        if (this.hdh != null && this.hdh.isShowing()) {
            this.hdh.dismiss();
        }
        this.hdh = null;
        View inflate = LayoutInflater.from(this.mContext).inflate(a.h.dialog_flower_guide_result, (ViewGroup) null);
        this.hdh = new Dialog(this.mContext, a.j.FlowerGuideResultDialogStyle);
        this.hdh.requestWindowFeature(1);
        this.hdh.setCancelable(false);
        this.hdh.setContentView(inflate);
        this.hdh.setCanceledOnTouchOutside(false);
        ((TextView) inflate.findViewById(a.g.flowerNum_textView)).setText(String.format("恭喜获得%s鲜花", Integer.valueOf(i)));
        ((ImageView) inflate.findViewById(a.g.close_imageView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    LiveFreeTaskLayer.this.hdh.dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((TextView) inflate.findViewById(a.g.toGift_textView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    LiveFreeTaskLayer.this.hdh.dismiss();
                    LiveFreeTaskLayer.this.bJp();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.hdh.show();
    }

    public void cch() {
        ColorStateList colorStateList;
        if (this.hdg != null && this.hdg.isShowing()) {
            this.hdg.dismiss();
        }
        this.hdg = null;
        this.hdg = new AlertDialog.Builder(this.mContext, a.j.sdk_dialog_window).create();
        this.hdg.show();
        View inflate = LayoutInflater.from(this.mContext).inflate(a.h.ala_flower_over_limit_dialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(a.g.tv_task_failed_content)).setText(getFlowerOverLimitContent());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LiveFreeTaskLayer.this.hdg.dismiss();
            }
        });
        inflate.findViewById(a.g.close_img).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LiveFreeTaskLayer.this.hdg.dismiss();
            }
        });
        TextView textView = (TextView) inflate.findViewById(a.g.btn_to_send_gift);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            colorStateList = this.mContext.getResources().getColorStateList(a.f.ala_btn_bg_gift_text_color_s_shoubai);
        } else {
            colorStateList = this.mContext.getResources().getColorStateList(a.f.ala_btn_bg_gift_text_color_s);
        }
        textView.setTextColor(colorStateList);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LiveFreeTaskLayer.this.hdg.dismiss();
                LiveFreeTaskLayer.this.bJp();
            }
        });
        Window window = this.hdg.getWindow();
        window.setGravity(17);
        window.setBackgroundDrawableResource(17170445);
        window.setContentView(inflate);
    }

    public SpannableStringBuilder getFlowerOverLimitContent() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) SpannableString.valueOf(this.mContext.getString(a.i.get_task_reward_failed_1)));
        SpannableString valueOf = SpannableString.valueOf(this.mContext.getString(a.i.get_task_reward_failed_2));
        valueOf.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(a.d.sdk_cp_link_tip_a)), 0, valueOf.length(), 33);
        spannableStringBuilder.append((CharSequence) valueOf);
        spannableStringBuilder.append((CharSequence) SpannableString.valueOf(this.mContext.getString(a.i.get_task_reward_failed_3)));
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJp() {
        by byVar;
        com.baidu.live.core.layer.b.CA().e(this);
        int i = -1;
        bj bjVar = com.baidu.live.x.a.NN().bmW;
        if (bjVar != null && bjVar.aKQ != null && (byVar = bjVar.aKQ.aMa) != null) {
            i = byVar.aMn;
        }
        ad adVar = new ad();
        adVar.aFM = i;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, adVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cci() {
        com.baidu.live.core.layer.b.CA().e(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aA(String str, boolean z) {
        this.hcZ.setVisibility(z ? 0 : 8);
        this.hcZ.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccj() {
        this.hdc = true;
        this.fpN.setVisibility(8);
        this.hda.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTip() {
        this.hdc = false;
        this.fpN.setVisibility(0);
        this.hda.setVisibility(8);
    }
}
