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
import com.baidu.live.data.ah;
import com.baidu.live.data.am;
import com.baidu.live.data.an;
import com.baidu.live.data.bn;
import com.baidu.live.data.cf;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.tieba.ala.tasklist.a.b;
import com.baidu.tieba.ala.tasklist.model.a;
/* loaded from: classes4.dex */
public class LiveFreeTaskLayer extends LayerChildView {
    private CommonEmptyView bpJ;
    private View fQl;
    private View.OnClickListener fii;
    private a hJP;
    private b hJQ;
    private TextView hJR;
    private ImageView hJS;
    private TextView hJT;
    private TextView hJU;
    private LinearLayout hJV;
    private boolean hJW;
    private boolean hJX;
    private int hJY;
    private boolean hJZ;
    private AlertDialog hKa;
    private Dialog hKb;
    private a.InterfaceC0705a hKc;
    private CustomMessageListener hKd;
    private View.OnTouchListener hKe;
    private Context mContext;
    private BdListView mListView;
    private View mRootView;

    public LiveFreeTaskLayer(@NonNull Context context) {
        super(context);
        this.hJW = false;
        this.hKc = new a.InterfaceC0705a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5
            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0705a
            public void a(AlaLiveUserInfoData alaLiveUserInfoData, an anVar) {
                if (alaLiveUserInfoData != null) {
                    LiveFreeTaskLayer.this.aG(String.valueOf(alaLiveUserInfoData.petalNum), true);
                    TbadkCoreApplication.getInst().currentAccountFlowerNum = alaLiveUserInfoData.petalNum;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                } else {
                    LiveFreeTaskLayer.this.aG("", false);
                }
                if (anVar != null) {
                    LiveFreeTaskLayer.this.hJQ.setData(anVar.aNO);
                }
                LiveFreeTaskLayer.this.clf();
            }

            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0705a
            public void aE(int i, String str) {
                LiveFreeTaskLayer.this.bpJ.reset();
                LiveFreeTaskLayer.this.bpJ.setTitle(a.h.ala_task_empty_msg);
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    LiveFreeTaskLayer.this.bpJ.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
                } else {
                    LiveFreeTaskLayer.this.bpJ.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LiveFreeTaskLayer.this.bCX();
                        }
                    });
                    LiveFreeTaskLayer.this.bpJ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
                }
                LiveFreeTaskLayer.this.bpJ.setVisibility(0);
                if (i != 146021) {
                    if (LiveFreeTaskLayer.this.hJP.clj() != null && ListUtils.getCount(LiveFreeTaskLayer.this.hJP.clj().aNO) > 0) {
                        BdUtilHelper.showToast(LiveFreeTaskLayer.this.getContext(), str);
                        return;
                    }
                    return;
                }
                LiveFreeTaskLayer.this.clg();
            }
        };
        this.hKd = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    LiveFreeTaskLayer.this.hJQ.m((Integer) customResponsedMessage.getData());
                }
            }
        };
        this.hKe = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (view == LiveFreeTaskLayer.this.hJV) {
                        if (LiveFreeTaskLayer.this.hJW) {
                            LiveFreeTaskLayer.this.hideTip();
                            return true;
                        }
                        return true;
                    }
                    LiveFreeTaskLayer.this.clh();
                    return true;
                }
                return true;
            }
        };
        this.fii = new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == LiveFreeTaskLayer.this.hJS) {
                    if (LiveFreeTaskLayer.this.hJW) {
                        LiveFreeTaskLayer.this.hideTip();
                    } else {
                        LiveFreeTaskLayer.this.cli();
                    }
                }
            }
        };
        init(context);
    }

    public LiveFreeTaskLayer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hJW = false;
        this.hKc = new a.InterfaceC0705a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5
            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0705a
            public void a(AlaLiveUserInfoData alaLiveUserInfoData, an anVar) {
                if (alaLiveUserInfoData != null) {
                    LiveFreeTaskLayer.this.aG(String.valueOf(alaLiveUserInfoData.petalNum), true);
                    TbadkCoreApplication.getInst().currentAccountFlowerNum = alaLiveUserInfoData.petalNum;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                } else {
                    LiveFreeTaskLayer.this.aG("", false);
                }
                if (anVar != null) {
                    LiveFreeTaskLayer.this.hJQ.setData(anVar.aNO);
                }
                LiveFreeTaskLayer.this.clf();
            }

            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0705a
            public void aE(int i, String str) {
                LiveFreeTaskLayer.this.bpJ.reset();
                LiveFreeTaskLayer.this.bpJ.setTitle(a.h.ala_task_empty_msg);
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    LiveFreeTaskLayer.this.bpJ.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
                } else {
                    LiveFreeTaskLayer.this.bpJ.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LiveFreeTaskLayer.this.bCX();
                        }
                    });
                    LiveFreeTaskLayer.this.bpJ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
                }
                LiveFreeTaskLayer.this.bpJ.setVisibility(0);
                if (i != 146021) {
                    if (LiveFreeTaskLayer.this.hJP.clj() != null && ListUtils.getCount(LiveFreeTaskLayer.this.hJP.clj().aNO) > 0) {
                        BdUtilHelper.showToast(LiveFreeTaskLayer.this.getContext(), str);
                        return;
                    }
                    return;
                }
                LiveFreeTaskLayer.this.clg();
            }
        };
        this.hKd = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    LiveFreeTaskLayer.this.hJQ.m((Integer) customResponsedMessage.getData());
                }
            }
        };
        this.hKe = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (view == LiveFreeTaskLayer.this.hJV) {
                        if (LiveFreeTaskLayer.this.hJW) {
                            LiveFreeTaskLayer.this.hideTip();
                            return true;
                        }
                        return true;
                    }
                    LiveFreeTaskLayer.this.clh();
                    return true;
                }
                return true;
            }
        };
        this.fii = new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == LiveFreeTaskLayer.this.hJS) {
                    if (LiveFreeTaskLayer.this.hJW) {
                        LiveFreeTaskLayer.this.hideTip();
                    } else {
                        LiveFreeTaskLayer.this.cli();
                    }
                }
            }
        };
        init(context);
    }

    public LiveFreeTaskLayer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hJW = false;
        this.hKc = new a.InterfaceC0705a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5
            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0705a
            public void a(AlaLiveUserInfoData alaLiveUserInfoData, an anVar) {
                if (alaLiveUserInfoData != null) {
                    LiveFreeTaskLayer.this.aG(String.valueOf(alaLiveUserInfoData.petalNum), true);
                    TbadkCoreApplication.getInst().currentAccountFlowerNum = alaLiveUserInfoData.petalNum;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                } else {
                    LiveFreeTaskLayer.this.aG("", false);
                }
                if (anVar != null) {
                    LiveFreeTaskLayer.this.hJQ.setData(anVar.aNO);
                }
                LiveFreeTaskLayer.this.clf();
            }

            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0705a
            public void aE(int i2, String str) {
                LiveFreeTaskLayer.this.bpJ.reset();
                LiveFreeTaskLayer.this.bpJ.setTitle(a.h.ala_task_empty_msg);
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    LiveFreeTaskLayer.this.bpJ.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
                } else {
                    LiveFreeTaskLayer.this.bpJ.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LiveFreeTaskLayer.this.bCX();
                        }
                    });
                    LiveFreeTaskLayer.this.bpJ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
                }
                LiveFreeTaskLayer.this.bpJ.setVisibility(0);
                if (i2 != 146021) {
                    if (LiveFreeTaskLayer.this.hJP.clj() != null && ListUtils.getCount(LiveFreeTaskLayer.this.hJP.clj().aNO) > 0) {
                        BdUtilHelper.showToast(LiveFreeTaskLayer.this.getContext(), str);
                        return;
                    }
                    return;
                }
                LiveFreeTaskLayer.this.clg();
            }
        };
        this.hKd = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    LiveFreeTaskLayer.this.hJQ.m((Integer) customResponsedMessage.getData());
                }
            }
        };
        this.hKe = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (view == LiveFreeTaskLayer.this.hJV) {
                        if (LiveFreeTaskLayer.this.hJW) {
                            LiveFreeTaskLayer.this.hideTip();
                            return true;
                        }
                        return true;
                    }
                    LiveFreeTaskLayer.this.clh();
                    return true;
                }
                return true;
            }
        };
        this.fii = new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == LiveFreeTaskLayer.this.hJS) {
                    if (LiveFreeTaskLayer.this.hJW) {
                        LiveFreeTaskLayer.this.hideTip();
                    } else {
                        LiveFreeTaskLayer.this.cli();
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = View.inflate(getContext(), a.g.ala_task_list_layout, this);
        this.hJV = (LinearLayout) this.mRootView.findViewById(a.f.layout_content);
        this.hJR = (TextView) this.mRootView.findViewById(a.f.tv_flower_task_title);
        this.hJS = (ImageView) this.mRootView.findViewById(a.f.img_flower_help);
        this.fQl = this.mRootView.findViewById(a.f.divider);
        this.hJT = (TextView) this.mRootView.findViewById(a.f.tv_flower_count);
        this.hJU = (TextView) this.mRootView.findViewById(a.f.tv_task_help_tips);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.detail_list);
        this.bpJ = (CommonEmptyView) this.mRootView.findViewById(a.f.emptyView);
        this.hJQ = new b(getContext(), new com.baidu.tieba.ala.tasklist.a.a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.1
            @Override // com.baidu.tieba.ala.tasklist.a.a
            public void wE(int i) {
                if (LiveFreeTaskLayer.this.hJP != null) {
                    LiveFreeTaskLayer.this.hJP.wE(i);
                }
            }
        });
        this.mListView.setAdapter((ListAdapter) this.hJQ);
        this.mListView.setEmptyView(this.bpJ);
        this.mRootView.setOnTouchListener(this.hKe);
        this.hJV.setOnTouchListener(this.hKe);
        this.hJS.setOnClickListener(this.fii);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
        if (screenDimensions[1] > screenDimensions[0]) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hJV.getLayoutParams();
            layoutParams.height = (int) (screenDimensions[1] * 0.618d);
            this.hJV.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void DR() {
        this.hJP = new com.baidu.tieba.ala.tasklist.model.a();
        this.hJP.a(this.hKc);
        MessageManager.getInstance().registerListener(this.hKd);
        bCX();
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void DS() {
        if (this.hJP != null) {
            this.hJP.onDestroy();
            this.hJP = null;
        }
        MessageManager.getInstance().unRegisterListener(this.hKd);
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void DT() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void DU() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void release() {
        super.release();
        if (this.hJP != null) {
            this.hJP.onDestroy();
            this.hJP = null;
        }
        if (this.hKb != null && this.hKb.isShowing()) {
            this.hKb.dismiss();
            this.hKb = null;
        }
        if (this.hKa != null && this.hKa.isShowing()) {
            this.hKa.dismiss();
            this.hKa = null;
        }
        MessageManager.getInstance().unRegisterListener(this.hKd);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            if (this.hKb != null && this.hKb.isShowing()) {
                this.hKb.dismiss();
                this.hKb = null;
            }
            if (this.hKa != null && this.hKa.isShowing()) {
                this.hKa.dismiss();
                this.hKa = null;
            }
            com.baidu.live.core.layer.b.DX().e(this);
        }
    }

    public void setIsFromFlowerGuide(boolean z) {
        this.hJX = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCX() {
        this.bpJ.setVisibility(8);
        this.hJP.clm();
    }

    private void wE(int i) {
        this.hJP.wE(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clf() {
        am EI;
        if (this.hJX && this.hJY < 3 && (EI = this.hJQ.EI()) != null) {
            if (EI.status == 2) {
                wE(EI.aNG);
                this.hJY++;
                this.hJZ = true;
                return;
            }
            this.hJX = false;
            if (this.hJZ) {
                this.hJZ = false;
                wF(EI.aNL);
            }
        }
    }

    private void wF(int i) {
        if (this.hKb != null && this.hKb.isShowing()) {
            this.hKb.dismiss();
        }
        this.hKb = null;
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.dialog_flower_guide_result, (ViewGroup) null);
        this.hKb = new Dialog(this.mContext, a.i.FlowerGuideResultDialogStyle);
        this.hKb.requestWindowFeature(1);
        this.hKb.setCancelable(false);
        this.hKb.setContentView(inflate);
        this.hKb.setCanceledOnTouchOutside(false);
        ((TextView) inflate.findViewById(a.f.flowerNum_textView)).setText(String.format("恭喜获得%s鲜花", Integer.valueOf(i)));
        ((ImageView) inflate.findViewById(a.f.close_imageView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    LiveFreeTaskLayer.this.hKb.dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((TextView) inflate.findViewById(a.f.toGift_textView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    LiveFreeTaskLayer.this.hKb.dismiss();
                    LiveFreeTaskLayer.this.bRb();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.hKb.show();
    }

    public void clg() {
        ColorStateList colorStateList;
        if (this.hKa != null && this.hKa.isShowing()) {
            this.hKa.dismiss();
        }
        this.hKa = null;
        this.hKa = new AlertDialog.Builder(this.mContext, a.i.sdk_dialog_window).create();
        this.hKa.show();
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.ala_flower_over_limit_dialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(a.f.tv_task_failed_content)).setText(getFlowerOverLimitContent());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LiveFreeTaskLayer.this.hKa.dismiss();
            }
        });
        inflate.findViewById(a.f.close_img).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LiveFreeTaskLayer.this.hKa.dismiss();
            }
        });
        TextView textView = (TextView) inflate.findViewById(a.f.btn_to_send_gift);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            colorStateList = this.mContext.getResources().getColorStateList(a.e.ala_btn_bg_gift_text_color_s_shoubai);
        } else {
            colorStateList = this.mContext.getResources().getColorStateList(a.e.ala_btn_bg_gift_text_color_s);
        }
        textView.setTextColor(colorStateList);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LiveFreeTaskLayer.this.hKa.dismiss();
                LiveFreeTaskLayer.this.bRb();
            }
        });
        Window window = this.hKa.getWindow();
        window.setGravity(17);
        window.setBackgroundDrawableResource(17170445);
        window.setContentView(inflate);
    }

    public SpannableStringBuilder getFlowerOverLimitContent() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) SpannableString.valueOf(this.mContext.getString(a.h.get_task_reward_failed_1)));
        SpannableString valueOf = SpannableString.valueOf(this.mContext.getString(a.h.get_task_reward_failed_2));
        valueOf.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(a.c.sdk_cp_link_tip_a)), 0, valueOf.length(), 33);
        spannableStringBuilder.append((CharSequence) valueOf);
        spannableStringBuilder.append((CharSequence) SpannableString.valueOf(this.mContext.getString(a.h.get_task_reward_failed_3)));
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRb() {
        cf cfVar;
        com.baidu.live.core.layer.b.DX().e(this);
        int i = -1;
        bn bnVar = com.baidu.live.aa.a.PQ().btT;
        if (bnVar != null && bnVar.aPx != null && (cfVar = bnVar.aPx.aQR) != null) {
            i = cfVar.aRe;
        }
        ah ahVar = new ah();
        ahVar.aKs = i;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, ahVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clh() {
        com.baidu.live.core.layer.b.DX().e(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(String str, boolean z) {
        this.hJT.setVisibility(z ? 0 : 8);
        this.hJT.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cli() {
        this.hJW = true;
        this.fQl.setVisibility(8);
        this.hJU.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTip() {
        this.hJW = false;
        this.fQl.setVisibility(0);
        this.hJU.setVisibility(8);
    }
}
