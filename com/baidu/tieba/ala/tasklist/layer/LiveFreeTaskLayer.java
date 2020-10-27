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
import com.baidu.live.data.ag;
import com.baidu.live.data.al;
import com.baidu.live.data.am;
import com.baidu.live.data.bm;
import com.baidu.live.data.cd;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.tieba.ala.tasklist.a.b;
import com.baidu.tieba.ala.tasklist.model.a;
/* loaded from: classes4.dex */
public class LiveFreeTaskLayer extends LayerChildView {
    private CommonEmptyView boq;
    private View fKv;
    private View.OnClickListener fcr;
    private a hDS;
    private b hDT;
    private TextView hDU;
    private ImageView hDV;
    private TextView hDW;
    private TextView hDX;
    private LinearLayout hDY;
    private boolean hDZ;
    private boolean hEa;
    private int hEb;
    private boolean hEc;
    private AlertDialog hEd;
    private Dialog hEe;
    private a.InterfaceC0691a hEf;
    private CustomMessageListener hEg;
    private View.OnTouchListener hEh;
    private Context mContext;
    private BdListView mListView;
    private View mRootView;

    public LiveFreeTaskLayer(@NonNull Context context) {
        super(context);
        this.hDZ = false;
        this.hEf = new a.InterfaceC0691a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5
            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0691a
            public void a(AlaLiveUserInfoData alaLiveUserInfoData, am amVar) {
                if (alaLiveUserInfoData != null) {
                    LiveFreeTaskLayer.this.aG(String.valueOf(alaLiveUserInfoData.petalNum), true);
                    TbadkCoreApplication.getInst().currentAccountFlowerNum = alaLiveUserInfoData.petalNum;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                } else {
                    LiveFreeTaskLayer.this.aG("", false);
                }
                if (amVar != null) {
                    LiveFreeTaskLayer.this.hDT.setData(amVar.aMM);
                }
                LiveFreeTaskLayer.this.ciD();
            }

            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0691a
            public void aA(int i, String str) {
                LiveFreeTaskLayer.this.boq.reset();
                LiveFreeTaskLayer.this.boq.setTitle(a.i.ala_task_empty_msg);
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    LiveFreeTaskLayer.this.boq.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
                } else {
                    LiveFreeTaskLayer.this.boq.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LiveFreeTaskLayer.this.bAy();
                        }
                    });
                    LiveFreeTaskLayer.this.boq.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
                }
                LiveFreeTaskLayer.this.boq.setVisibility(0);
                if (i != 146021) {
                    if (LiveFreeTaskLayer.this.hDS.ciH() != null && ListUtils.getCount(LiveFreeTaskLayer.this.hDS.ciH().aMM) > 0) {
                        BdUtilHelper.showToast(LiveFreeTaskLayer.this.getContext(), str);
                        return;
                    }
                    return;
                }
                LiveFreeTaskLayer.this.ciE();
            }
        };
        this.hEg = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    LiveFreeTaskLayer.this.hDT.m((Integer) customResponsedMessage.getData());
                }
            }
        };
        this.hEh = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (view == LiveFreeTaskLayer.this.hDY) {
                        if (LiveFreeTaskLayer.this.hDZ) {
                            LiveFreeTaskLayer.this.hideTip();
                            return true;
                        }
                        return true;
                    }
                    LiveFreeTaskLayer.this.ciF();
                    return true;
                }
                return true;
            }
        };
        this.fcr = new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == LiveFreeTaskLayer.this.hDV) {
                    if (LiveFreeTaskLayer.this.hDZ) {
                        LiveFreeTaskLayer.this.hideTip();
                    } else {
                        LiveFreeTaskLayer.this.ciG();
                    }
                }
            }
        };
        init(context);
    }

    public LiveFreeTaskLayer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hDZ = false;
        this.hEf = new a.InterfaceC0691a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5
            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0691a
            public void a(AlaLiveUserInfoData alaLiveUserInfoData, am amVar) {
                if (alaLiveUserInfoData != null) {
                    LiveFreeTaskLayer.this.aG(String.valueOf(alaLiveUserInfoData.petalNum), true);
                    TbadkCoreApplication.getInst().currentAccountFlowerNum = alaLiveUserInfoData.petalNum;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                } else {
                    LiveFreeTaskLayer.this.aG("", false);
                }
                if (amVar != null) {
                    LiveFreeTaskLayer.this.hDT.setData(amVar.aMM);
                }
                LiveFreeTaskLayer.this.ciD();
            }

            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0691a
            public void aA(int i, String str) {
                LiveFreeTaskLayer.this.boq.reset();
                LiveFreeTaskLayer.this.boq.setTitle(a.i.ala_task_empty_msg);
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    LiveFreeTaskLayer.this.boq.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
                } else {
                    LiveFreeTaskLayer.this.boq.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LiveFreeTaskLayer.this.bAy();
                        }
                    });
                    LiveFreeTaskLayer.this.boq.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
                }
                LiveFreeTaskLayer.this.boq.setVisibility(0);
                if (i != 146021) {
                    if (LiveFreeTaskLayer.this.hDS.ciH() != null && ListUtils.getCount(LiveFreeTaskLayer.this.hDS.ciH().aMM) > 0) {
                        BdUtilHelper.showToast(LiveFreeTaskLayer.this.getContext(), str);
                        return;
                    }
                    return;
                }
                LiveFreeTaskLayer.this.ciE();
            }
        };
        this.hEg = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    LiveFreeTaskLayer.this.hDT.m((Integer) customResponsedMessage.getData());
                }
            }
        };
        this.hEh = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (view == LiveFreeTaskLayer.this.hDY) {
                        if (LiveFreeTaskLayer.this.hDZ) {
                            LiveFreeTaskLayer.this.hideTip();
                            return true;
                        }
                        return true;
                    }
                    LiveFreeTaskLayer.this.ciF();
                    return true;
                }
                return true;
            }
        };
        this.fcr = new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == LiveFreeTaskLayer.this.hDV) {
                    if (LiveFreeTaskLayer.this.hDZ) {
                        LiveFreeTaskLayer.this.hideTip();
                    } else {
                        LiveFreeTaskLayer.this.ciG();
                    }
                }
            }
        };
        init(context);
    }

    public LiveFreeTaskLayer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hDZ = false;
        this.hEf = new a.InterfaceC0691a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5
            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0691a
            public void a(AlaLiveUserInfoData alaLiveUserInfoData, am amVar) {
                if (alaLiveUserInfoData != null) {
                    LiveFreeTaskLayer.this.aG(String.valueOf(alaLiveUserInfoData.petalNum), true);
                    TbadkCoreApplication.getInst().currentAccountFlowerNum = alaLiveUserInfoData.petalNum;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                } else {
                    LiveFreeTaskLayer.this.aG("", false);
                }
                if (amVar != null) {
                    LiveFreeTaskLayer.this.hDT.setData(amVar.aMM);
                }
                LiveFreeTaskLayer.this.ciD();
            }

            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0691a
            public void aA(int i2, String str) {
                LiveFreeTaskLayer.this.boq.reset();
                LiveFreeTaskLayer.this.boq.setTitle(a.i.ala_task_empty_msg);
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    LiveFreeTaskLayer.this.boq.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
                } else {
                    LiveFreeTaskLayer.this.boq.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LiveFreeTaskLayer.this.bAy();
                        }
                    });
                    LiveFreeTaskLayer.this.boq.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
                }
                LiveFreeTaskLayer.this.boq.setVisibility(0);
                if (i2 != 146021) {
                    if (LiveFreeTaskLayer.this.hDS.ciH() != null && ListUtils.getCount(LiveFreeTaskLayer.this.hDS.ciH().aMM) > 0) {
                        BdUtilHelper.showToast(LiveFreeTaskLayer.this.getContext(), str);
                        return;
                    }
                    return;
                }
                LiveFreeTaskLayer.this.ciE();
            }
        };
        this.hEg = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    LiveFreeTaskLayer.this.hDT.m((Integer) customResponsedMessage.getData());
                }
            }
        };
        this.hEh = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (view == LiveFreeTaskLayer.this.hDY) {
                        if (LiveFreeTaskLayer.this.hDZ) {
                            LiveFreeTaskLayer.this.hideTip();
                            return true;
                        }
                        return true;
                    }
                    LiveFreeTaskLayer.this.ciF();
                    return true;
                }
                return true;
            }
        };
        this.fcr = new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == LiveFreeTaskLayer.this.hDV) {
                    if (LiveFreeTaskLayer.this.hDZ) {
                        LiveFreeTaskLayer.this.hideTip();
                    } else {
                        LiveFreeTaskLayer.this.ciG();
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = View.inflate(getContext(), a.h.ala_task_list_layout, this);
        this.hDY = (LinearLayout) this.mRootView.findViewById(a.g.layout_content);
        this.hDU = (TextView) this.mRootView.findViewById(a.g.tv_flower_task_title);
        this.hDV = (ImageView) this.mRootView.findViewById(a.g.img_flower_help);
        this.fKv = this.mRootView.findViewById(a.g.divider);
        this.hDW = (TextView) this.mRootView.findViewById(a.g.tv_flower_count);
        this.hDX = (TextView) this.mRootView.findViewById(a.g.tv_task_help_tips);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.detail_list);
        this.boq = (CommonEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.hDT = new b(getContext(), new com.baidu.tieba.ala.tasklist.a.a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.1
            @Override // com.baidu.tieba.ala.tasklist.a.a
            public void wr(int i) {
                if (LiveFreeTaskLayer.this.hDS != null) {
                    LiveFreeTaskLayer.this.hDS.wr(i);
                }
            }
        });
        this.mListView.setAdapter((ListAdapter) this.hDT);
        this.mListView.setEmptyView(this.boq);
        this.mRootView.setOnTouchListener(this.hEh);
        this.hDY.setOnTouchListener(this.hEh);
        this.hDV.setOnClickListener(this.fcr);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
        if (screenDimensions[1] > screenDimensions[0]) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hDY.getLayoutParams();
            layoutParams.height = (int) (screenDimensions[1] * 0.618d);
            this.hDY.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Dy() {
        this.hDS = new com.baidu.tieba.ala.tasklist.model.a();
        this.hDS.a(this.hEf);
        MessageManager.getInstance().registerListener(this.hEg);
        bAy();
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Dz() {
        if (this.hDS != null) {
            this.hDS.onDestroy();
            this.hDS = null;
        }
        MessageManager.getInstance().unRegisterListener(this.hEg);
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void DA() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void DB() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void release() {
        super.release();
        if (this.hDS != null) {
            this.hDS.onDestroy();
            this.hDS = null;
        }
        if (this.hEe != null && this.hEe.isShowing()) {
            this.hEe.dismiss();
            this.hEe = null;
        }
        if (this.hEd != null && this.hEd.isShowing()) {
            this.hEd.dismiss();
            this.hEd = null;
        }
        MessageManager.getInstance().unRegisterListener(this.hEg);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            if (this.hEe != null && this.hEe.isShowing()) {
                this.hEe.dismiss();
                this.hEe = null;
            }
            if (this.hEd != null && this.hEd.isShowing()) {
                this.hEd.dismiss();
                this.hEd = null;
            }
            com.baidu.live.core.layer.b.DE().e(this);
        }
    }

    public void setIsFromFlowerGuide(boolean z) {
        this.hEa = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAy() {
        this.boq.setVisibility(8);
        this.hDS.ciK();
    }

    private void wr(int i) {
        this.hDS.wr(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciD() {
        al Em;
        if (this.hEa && this.hEb < 3 && (Em = this.hDT.Em()) != null) {
            if (Em.status == 2) {
                wr(Em.aME);
                this.hEb++;
                this.hEc = true;
                return;
            }
            this.hEa = false;
            if (this.hEc) {
                this.hEc = false;
                ws(Em.aMJ);
            }
        }
    }

    private void ws(int i) {
        if (this.hEe != null && this.hEe.isShowing()) {
            this.hEe.dismiss();
        }
        this.hEe = null;
        View inflate = LayoutInflater.from(this.mContext).inflate(a.h.dialog_flower_guide_result, (ViewGroup) null);
        this.hEe = new Dialog(this.mContext, a.j.FlowerGuideResultDialogStyle);
        this.hEe.requestWindowFeature(1);
        this.hEe.setCancelable(false);
        this.hEe.setContentView(inflate);
        this.hEe.setCanceledOnTouchOutside(false);
        ((TextView) inflate.findViewById(a.g.flowerNum_textView)).setText(String.format("恭喜获得%s鲜花", Integer.valueOf(i)));
        ((ImageView) inflate.findViewById(a.g.close_imageView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    LiveFreeTaskLayer.this.hEe.dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((TextView) inflate.findViewById(a.g.toGift_textView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    LiveFreeTaskLayer.this.hEe.dismiss();
                    LiveFreeTaskLayer.this.bOB();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.hEe.show();
    }

    public void ciE() {
        ColorStateList colorStateList;
        if (this.hEd != null && this.hEd.isShowing()) {
            this.hEd.dismiss();
        }
        this.hEd = null;
        this.hEd = new AlertDialog.Builder(this.mContext, a.j.sdk_dialog_window).create();
        this.hEd.show();
        View inflate = LayoutInflater.from(this.mContext).inflate(a.h.ala_flower_over_limit_dialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(a.g.tv_task_failed_content)).setText(getFlowerOverLimitContent());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LiveFreeTaskLayer.this.hEd.dismiss();
            }
        });
        inflate.findViewById(a.g.close_img).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LiveFreeTaskLayer.this.hEd.dismiss();
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
                LiveFreeTaskLayer.this.hEd.dismiss();
                LiveFreeTaskLayer.this.bOB();
            }
        });
        Window window = this.hEd.getWindow();
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
    public void bOB() {
        cd cdVar;
        com.baidu.live.core.layer.b.DE().e(this);
        int i = -1;
        bm bmVar = com.baidu.live.z.a.Pq().bsy;
        if (bmVar != null && bmVar.aOA != null && (cdVar = bmVar.aOA.aPP) != null) {
            i = cdVar.aQc;
        }
        ag agVar = new ag();
        agVar.aJs = i;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, agVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciF() {
        com.baidu.live.core.layer.b.DE().e(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(String str, boolean z) {
        this.hDW.setVisibility(z ? 0 : 8);
        this.hDW.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciG() {
        this.hDZ = true;
        this.fKv.setVisibility(8);
        this.hDX.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTip() {
        this.hDZ = false;
        this.fKv.setVisibility(0);
        this.hDX.setVisibility(8);
    }
}
