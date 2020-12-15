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
import com.baidu.live.data.ai;
import com.baidu.live.data.an;
import com.baidu.live.data.ao;
import com.baidu.live.data.bo;
import com.baidu.live.data.ch;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.tieba.ala.tasklist.a.b;
import com.baidu.tieba.ala.tasklist.model.a;
/* loaded from: classes4.dex */
public class LiveFreeTaskLayer extends LayerChildView {
    private CommonEmptyView btg;
    private View fYf;
    private View.OnClickListener foP;
    private boolean hUA;
    private int hUB;
    private boolean hUC;
    private AlertDialog hUD;
    private Dialog hUE;
    private a.InterfaceC0719a hUF;
    private CustomMessageListener hUG;
    private View.OnTouchListener hUH;
    private a hUs;
    private b hUt;
    private TextView hUu;
    private ImageView hUv;
    private TextView hUw;
    private TextView hUx;
    private LinearLayout hUy;
    private boolean hUz;
    private Context mContext;
    private BdListView mListView;
    private View mRootView;

    public LiveFreeTaskLayer(@NonNull Context context) {
        super(context);
        this.hUz = false;
        this.hUF = new a.InterfaceC0719a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5
            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0719a
            public void a(AlaLiveUserInfoData alaLiveUserInfoData, ao aoVar) {
                if (alaLiveUserInfoData != null) {
                    LiveFreeTaskLayer.this.aH(String.valueOf(alaLiveUserInfoData.petalNum), true);
                    TbadkCoreApplication.getInst().currentAccountFlowerNum = alaLiveUserInfoData.petalNum;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                } else {
                    LiveFreeTaskLayer.this.aH("", false);
                }
                if (aoVar != null) {
                    LiveFreeTaskLayer.this.hUt.setData(aoVar.aPa);
                }
                LiveFreeTaskLayer.this.coO();
            }

            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0719a
            public void aC(int i, String str) {
                LiveFreeTaskLayer.this.btg.reset();
                LiveFreeTaskLayer.this.btg.setTitle(a.h.ala_task_empty_msg);
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    LiveFreeTaskLayer.this.btg.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
                } else {
                    LiveFreeTaskLayer.this.btg.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LiveFreeTaskLayer.this.bFR();
                        }
                    });
                    LiveFreeTaskLayer.this.btg.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
                }
                LiveFreeTaskLayer.this.btg.setVisibility(0);
                if (i != 146021) {
                    if (LiveFreeTaskLayer.this.hUs.coS() != null && ListUtils.getCount(LiveFreeTaskLayer.this.hUs.coS().aPa) > 0) {
                        BdUtilHelper.showToast(LiveFreeTaskLayer.this.getContext(), str);
                        return;
                    }
                    return;
                }
                LiveFreeTaskLayer.this.coP();
            }
        };
        this.hUG = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    LiveFreeTaskLayer.this.hUt.m((Integer) customResponsedMessage.getData());
                }
            }
        };
        this.hUH = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (view == LiveFreeTaskLayer.this.hUy) {
                        if (LiveFreeTaskLayer.this.hUz) {
                            LiveFreeTaskLayer.this.hideTip();
                            return true;
                        }
                        return true;
                    }
                    LiveFreeTaskLayer.this.coQ();
                    return true;
                }
                return true;
            }
        };
        this.foP = new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == LiveFreeTaskLayer.this.hUv) {
                    if (LiveFreeTaskLayer.this.hUz) {
                        LiveFreeTaskLayer.this.hideTip();
                    } else {
                        LiveFreeTaskLayer.this.coR();
                    }
                }
            }
        };
        init(context);
    }

    public LiveFreeTaskLayer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hUz = false;
        this.hUF = new a.InterfaceC0719a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5
            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0719a
            public void a(AlaLiveUserInfoData alaLiveUserInfoData, ao aoVar) {
                if (alaLiveUserInfoData != null) {
                    LiveFreeTaskLayer.this.aH(String.valueOf(alaLiveUserInfoData.petalNum), true);
                    TbadkCoreApplication.getInst().currentAccountFlowerNum = alaLiveUserInfoData.petalNum;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                } else {
                    LiveFreeTaskLayer.this.aH("", false);
                }
                if (aoVar != null) {
                    LiveFreeTaskLayer.this.hUt.setData(aoVar.aPa);
                }
                LiveFreeTaskLayer.this.coO();
            }

            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0719a
            public void aC(int i, String str) {
                LiveFreeTaskLayer.this.btg.reset();
                LiveFreeTaskLayer.this.btg.setTitle(a.h.ala_task_empty_msg);
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    LiveFreeTaskLayer.this.btg.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
                } else {
                    LiveFreeTaskLayer.this.btg.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LiveFreeTaskLayer.this.bFR();
                        }
                    });
                    LiveFreeTaskLayer.this.btg.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
                }
                LiveFreeTaskLayer.this.btg.setVisibility(0);
                if (i != 146021) {
                    if (LiveFreeTaskLayer.this.hUs.coS() != null && ListUtils.getCount(LiveFreeTaskLayer.this.hUs.coS().aPa) > 0) {
                        BdUtilHelper.showToast(LiveFreeTaskLayer.this.getContext(), str);
                        return;
                    }
                    return;
                }
                LiveFreeTaskLayer.this.coP();
            }
        };
        this.hUG = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    LiveFreeTaskLayer.this.hUt.m((Integer) customResponsedMessage.getData());
                }
            }
        };
        this.hUH = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (view == LiveFreeTaskLayer.this.hUy) {
                        if (LiveFreeTaskLayer.this.hUz) {
                            LiveFreeTaskLayer.this.hideTip();
                            return true;
                        }
                        return true;
                    }
                    LiveFreeTaskLayer.this.coQ();
                    return true;
                }
                return true;
            }
        };
        this.foP = new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == LiveFreeTaskLayer.this.hUv) {
                    if (LiveFreeTaskLayer.this.hUz) {
                        LiveFreeTaskLayer.this.hideTip();
                    } else {
                        LiveFreeTaskLayer.this.coR();
                    }
                }
            }
        };
        init(context);
    }

    public LiveFreeTaskLayer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hUz = false;
        this.hUF = new a.InterfaceC0719a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5
            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0719a
            public void a(AlaLiveUserInfoData alaLiveUserInfoData, ao aoVar) {
                if (alaLiveUserInfoData != null) {
                    LiveFreeTaskLayer.this.aH(String.valueOf(alaLiveUserInfoData.petalNum), true);
                    TbadkCoreApplication.getInst().currentAccountFlowerNum = alaLiveUserInfoData.petalNum;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                } else {
                    LiveFreeTaskLayer.this.aH("", false);
                }
                if (aoVar != null) {
                    LiveFreeTaskLayer.this.hUt.setData(aoVar.aPa);
                }
                LiveFreeTaskLayer.this.coO();
            }

            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0719a
            public void aC(int i2, String str) {
                LiveFreeTaskLayer.this.btg.reset();
                LiveFreeTaskLayer.this.btg.setTitle(a.h.ala_task_empty_msg);
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    LiveFreeTaskLayer.this.btg.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
                } else {
                    LiveFreeTaskLayer.this.btg.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LiveFreeTaskLayer.this.bFR();
                        }
                    });
                    LiveFreeTaskLayer.this.btg.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
                }
                LiveFreeTaskLayer.this.btg.setVisibility(0);
                if (i2 != 146021) {
                    if (LiveFreeTaskLayer.this.hUs.coS() != null && ListUtils.getCount(LiveFreeTaskLayer.this.hUs.coS().aPa) > 0) {
                        BdUtilHelper.showToast(LiveFreeTaskLayer.this.getContext(), str);
                        return;
                    }
                    return;
                }
                LiveFreeTaskLayer.this.coP();
            }
        };
        this.hUG = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    LiveFreeTaskLayer.this.hUt.m((Integer) customResponsedMessage.getData());
                }
            }
        };
        this.hUH = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (view == LiveFreeTaskLayer.this.hUy) {
                        if (LiveFreeTaskLayer.this.hUz) {
                            LiveFreeTaskLayer.this.hideTip();
                            return true;
                        }
                        return true;
                    }
                    LiveFreeTaskLayer.this.coQ();
                    return true;
                }
                return true;
            }
        };
        this.foP = new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == LiveFreeTaskLayer.this.hUv) {
                    if (LiveFreeTaskLayer.this.hUz) {
                        LiveFreeTaskLayer.this.hideTip();
                    } else {
                        LiveFreeTaskLayer.this.coR();
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = View.inflate(getContext(), a.g.ala_task_list_layout, this);
        this.hUy = (LinearLayout) this.mRootView.findViewById(a.f.layout_content);
        this.hUu = (TextView) this.mRootView.findViewById(a.f.tv_flower_task_title);
        this.hUv = (ImageView) this.mRootView.findViewById(a.f.img_flower_help);
        this.fYf = this.mRootView.findViewById(a.f.divider);
        this.hUw = (TextView) this.mRootView.findViewById(a.f.tv_flower_count);
        this.hUx = (TextView) this.mRootView.findViewById(a.f.tv_task_help_tips);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.detail_list);
        this.btg = (CommonEmptyView) this.mRootView.findViewById(a.f.emptyView);
        this.hUt = new b(getContext(), new com.baidu.tieba.ala.tasklist.a.a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.1
            @Override // com.baidu.tieba.ala.tasklist.a.a
            public void xI(int i) {
                if (LiveFreeTaskLayer.this.hUs != null) {
                    LiveFreeTaskLayer.this.hUs.xI(i);
                }
            }
        });
        this.mListView.setAdapter((ListAdapter) this.hUt);
        this.mListView.setEmptyView(this.btg);
        this.mRootView.setOnTouchListener(this.hUH);
        this.hUy.setOnTouchListener(this.hUH);
        this.hUv.setOnClickListener(this.foP);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
        if (screenDimensions[1] > screenDimensions[0]) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hUy.getLayoutParams();
            layoutParams.height = (int) (screenDimensions[1] * 0.618d);
            this.hUy.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void ES() {
        this.hUs = new com.baidu.tieba.ala.tasklist.model.a();
        this.hUs.a(this.hUF);
        MessageManager.getInstance().registerListener(this.hUG);
        bFR();
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void ET() {
        if (this.hUs != null) {
            this.hUs.onDestroy();
            this.hUs = null;
        }
        MessageManager.getInstance().unRegisterListener(this.hUG);
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void EU() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void EV() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void release() {
        super.release();
        if (this.hUs != null) {
            this.hUs.onDestroy();
            this.hUs = null;
        }
        if (this.hUE != null && this.hUE.isShowing()) {
            this.hUE.dismiss();
            this.hUE = null;
        }
        if (this.hUD != null && this.hUD.isShowing()) {
            this.hUD.dismiss();
            this.hUD = null;
        }
        MessageManager.getInstance().unRegisterListener(this.hUG);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            if (this.hUE != null && this.hUE.isShowing()) {
                this.hUE.dismiss();
                this.hUE = null;
            }
            if (this.hUD != null && this.hUD.isShowing()) {
                this.hUD.dismiss();
                this.hUD = null;
            }
            com.baidu.live.core.layer.b.EY().e(this);
        }
    }

    public void setIsFromFlowerGuide(boolean z) {
        this.hUA = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFR() {
        this.btg.setVisibility(8);
        this.hUs.coV();
    }

    private void xI(int i) {
        this.hUs.xI(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coO() {
        an FK;
        if (this.hUA && this.hUB < 3 && (FK = this.hUt.FK()) != null) {
            if (FK.status == 2) {
                xI(FK.aOS);
                this.hUB++;
                this.hUC = true;
                return;
            }
            this.hUA = false;
            if (this.hUC) {
                this.hUC = false;
                xJ(FK.aOX);
            }
        }
    }

    private void xJ(int i) {
        if (this.hUE != null && this.hUE.isShowing()) {
            this.hUE.dismiss();
        }
        this.hUE = null;
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.dialog_flower_guide_result, (ViewGroup) null);
        this.hUE = new Dialog(this.mContext, a.i.FlowerGuideResultDialogStyle);
        this.hUE.requestWindowFeature(1);
        this.hUE.setCancelable(false);
        this.hUE.setContentView(inflate);
        this.hUE.setCanceledOnTouchOutside(false);
        ((TextView) inflate.findViewById(a.f.flowerNum_textView)).setText(String.format("恭喜获得%s鲜花", Integer.valueOf(i)));
        ((ImageView) inflate.findViewById(a.f.close_imageView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    LiveFreeTaskLayer.this.hUE.dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((TextView) inflate.findViewById(a.f.toGift_textView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    LiveFreeTaskLayer.this.hUE.dismiss();
                    LiveFreeTaskLayer.this.bUf();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.hUE.show();
    }

    public void coP() {
        ColorStateList colorStateList;
        if (this.hUD != null && this.hUD.isShowing()) {
            this.hUD.dismiss();
        }
        this.hUD = null;
        this.hUD = new AlertDialog.Builder(this.mContext, a.i.sdk_dialog_window).create();
        this.hUD.show();
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.ala_flower_over_limit_dialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(a.f.tv_task_failed_content)).setText(getFlowerOverLimitContent());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LiveFreeTaskLayer.this.hUD.dismiss();
            }
        });
        inflate.findViewById(a.f.close_img).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LiveFreeTaskLayer.this.hUD.dismiss();
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
                LiveFreeTaskLayer.this.hUD.dismiss();
                LiveFreeTaskLayer.this.bUf();
            }
        });
        Window window = this.hUD.getWindow();
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
    public void bUf() {
        ch chVar;
        com.baidu.live.core.layer.b.EY().e(this);
        int i = -1;
        bo boVar = com.baidu.live.ae.a.RB().bxq;
        if (boVar != null && boVar.aQM != null && (chVar = boVar.aQM.aSi) != null) {
            i = chVar.aSv;
        }
        ai aiVar = new ai();
        aiVar.aLA = i;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aiVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coQ() {
        com.baidu.live.core.layer.b.EY().e(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(String str, boolean z) {
        this.hUw.setVisibility(z ? 0 : 8);
        this.hUw.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coR() {
        this.hUz = true;
        this.fYf.setVisibility(8);
        this.hUx.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTip() {
        this.hUz = false;
        this.fYf.setVisibility(0);
        this.hUx.setVisibility(8);
    }
}
