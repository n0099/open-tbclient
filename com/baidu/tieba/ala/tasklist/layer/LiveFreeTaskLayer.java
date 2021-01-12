package com.baidu.tieba.ala.tasklist.layer;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.core.layer.LayerChildView;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.ak;
import com.baidu.live.data.ap;
import com.baidu.live.data.aq;
import com.baidu.live.data.bq;
import com.baidu.live.data.cj;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.tieba.ala.tasklist.a.b;
import com.baidu.tieba.ala.tasklist.model.a;
/* loaded from: classes10.dex */
public class LiveFreeTaskLayer extends LayerChildView {
    private CommonEmptyView btf;
    private View gde;
    private a ich;
    private b ici;
    private TextView icj;
    private ImageView ick;
    private TextView icl;
    private TextView icm;
    private LinearLayout icn;
    private boolean ico;
    private boolean icp;
    private int icq;
    private boolean icr;
    private AlertDialog ics;
    private Dialog ict;
    private a.InterfaceC0694a icu;
    private CustomMessageListener icv;
    private View.OnTouchListener icw;
    private Context mContext;
    private BdListView mListView;
    private View mRootView;
    private View.OnClickListener onClickListener;

    public LiveFreeTaskLayer(@NonNull Context context) {
        super(context);
        this.ico = false;
        this.icu = new a.InterfaceC0694a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5
            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0694a
            public void a(AlaLiveUserInfoData alaLiveUserInfoData, aq aqVar) {
                if (alaLiveUserInfoData != null) {
                    LiveFreeTaskLayer.this.aI(String.valueOf(alaLiveUserInfoData.petalNum), true);
                    TbadkCoreApplication.getInst().currentAccountFlowerNum = alaLiveUserInfoData.petalNum;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                } else {
                    LiveFreeTaskLayer.this.aI("", false);
                }
                if (aqVar != null) {
                    LiveFreeTaskLayer.this.ici.setData(aqVar.aKU);
                }
                LiveFreeTaskLayer.this.cnQ();
            }

            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0694a
            public void aF(int i, String str) {
                LiveFreeTaskLayer.this.btf.reset();
                LiveFreeTaskLayer.this.btf.setTitle(a.h.ala_task_empty_msg);
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    LiveFreeTaskLayer.this.btf.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
                } else {
                    LiveFreeTaskLayer.this.btf.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LiveFreeTaskLayer.this.bEv();
                        }
                    });
                    LiveFreeTaskLayer.this.btf.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
                }
                LiveFreeTaskLayer.this.btf.setVisibility(0);
                if (i != 146021) {
                    if (LiveFreeTaskLayer.this.ich.cnU() != null && ListUtils.getCount(LiveFreeTaskLayer.this.ich.cnU().aKU) > 0) {
                        BdUtilHelper.showToast(LiveFreeTaskLayer.this.getContext(), str);
                        return;
                    }
                    return;
                }
                LiveFreeTaskLayer.this.cnR();
            }
        };
        this.icv = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    LiveFreeTaskLayer.this.ici.o((Integer) customResponsedMessage.getData());
                }
            }
        };
        this.icw = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (view == LiveFreeTaskLayer.this.icn) {
                        if (LiveFreeTaskLayer.this.ico) {
                            LiveFreeTaskLayer.this.hideTip();
                            return true;
                        }
                        return true;
                    }
                    LiveFreeTaskLayer.this.cnS();
                    return true;
                }
                return true;
            }
        };
        this.onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == LiveFreeTaskLayer.this.ick) {
                    if (LiveFreeTaskLayer.this.ico) {
                        LiveFreeTaskLayer.this.hideTip();
                    } else {
                        LiveFreeTaskLayer.this.cnT();
                    }
                }
            }
        };
        init(context);
    }

    public LiveFreeTaskLayer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ico = false;
        this.icu = new a.InterfaceC0694a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5
            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0694a
            public void a(AlaLiveUserInfoData alaLiveUserInfoData, aq aqVar) {
                if (alaLiveUserInfoData != null) {
                    LiveFreeTaskLayer.this.aI(String.valueOf(alaLiveUserInfoData.petalNum), true);
                    TbadkCoreApplication.getInst().currentAccountFlowerNum = alaLiveUserInfoData.petalNum;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                } else {
                    LiveFreeTaskLayer.this.aI("", false);
                }
                if (aqVar != null) {
                    LiveFreeTaskLayer.this.ici.setData(aqVar.aKU);
                }
                LiveFreeTaskLayer.this.cnQ();
            }

            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0694a
            public void aF(int i, String str) {
                LiveFreeTaskLayer.this.btf.reset();
                LiveFreeTaskLayer.this.btf.setTitle(a.h.ala_task_empty_msg);
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    LiveFreeTaskLayer.this.btf.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
                } else {
                    LiveFreeTaskLayer.this.btf.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LiveFreeTaskLayer.this.bEv();
                        }
                    });
                    LiveFreeTaskLayer.this.btf.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
                }
                LiveFreeTaskLayer.this.btf.setVisibility(0);
                if (i != 146021) {
                    if (LiveFreeTaskLayer.this.ich.cnU() != null && ListUtils.getCount(LiveFreeTaskLayer.this.ich.cnU().aKU) > 0) {
                        BdUtilHelper.showToast(LiveFreeTaskLayer.this.getContext(), str);
                        return;
                    }
                    return;
                }
                LiveFreeTaskLayer.this.cnR();
            }
        };
        this.icv = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    LiveFreeTaskLayer.this.ici.o((Integer) customResponsedMessage.getData());
                }
            }
        };
        this.icw = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (view == LiveFreeTaskLayer.this.icn) {
                        if (LiveFreeTaskLayer.this.ico) {
                            LiveFreeTaskLayer.this.hideTip();
                            return true;
                        }
                        return true;
                    }
                    LiveFreeTaskLayer.this.cnS();
                    return true;
                }
                return true;
            }
        };
        this.onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == LiveFreeTaskLayer.this.ick) {
                    if (LiveFreeTaskLayer.this.ico) {
                        LiveFreeTaskLayer.this.hideTip();
                    } else {
                        LiveFreeTaskLayer.this.cnT();
                    }
                }
            }
        };
        init(context);
    }

    public LiveFreeTaskLayer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ico = false;
        this.icu = new a.InterfaceC0694a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5
            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0694a
            public void a(AlaLiveUserInfoData alaLiveUserInfoData, aq aqVar) {
                if (alaLiveUserInfoData != null) {
                    LiveFreeTaskLayer.this.aI(String.valueOf(alaLiveUserInfoData.petalNum), true);
                    TbadkCoreApplication.getInst().currentAccountFlowerNum = alaLiveUserInfoData.petalNum;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                } else {
                    LiveFreeTaskLayer.this.aI("", false);
                }
                if (aqVar != null) {
                    LiveFreeTaskLayer.this.ici.setData(aqVar.aKU);
                }
                LiveFreeTaskLayer.this.cnQ();
            }

            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0694a
            public void aF(int i2, String str) {
                LiveFreeTaskLayer.this.btf.reset();
                LiveFreeTaskLayer.this.btf.setTitle(a.h.ala_task_empty_msg);
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    LiveFreeTaskLayer.this.btf.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
                } else {
                    LiveFreeTaskLayer.this.btf.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LiveFreeTaskLayer.this.bEv();
                        }
                    });
                    LiveFreeTaskLayer.this.btf.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
                }
                LiveFreeTaskLayer.this.btf.setVisibility(0);
                if (i2 != 146021) {
                    if (LiveFreeTaskLayer.this.ich.cnU() != null && ListUtils.getCount(LiveFreeTaskLayer.this.ich.cnU().aKU) > 0) {
                        BdUtilHelper.showToast(LiveFreeTaskLayer.this.getContext(), str);
                        return;
                    }
                    return;
                }
                LiveFreeTaskLayer.this.cnR();
            }
        };
        this.icv = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    LiveFreeTaskLayer.this.ici.o((Integer) customResponsedMessage.getData());
                }
            }
        };
        this.icw = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (view == LiveFreeTaskLayer.this.icn) {
                        if (LiveFreeTaskLayer.this.ico) {
                            LiveFreeTaskLayer.this.hideTip();
                            return true;
                        }
                        return true;
                    }
                    LiveFreeTaskLayer.this.cnS();
                    return true;
                }
                return true;
            }
        };
        this.onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == LiveFreeTaskLayer.this.ick) {
                    if (LiveFreeTaskLayer.this.ico) {
                        LiveFreeTaskLayer.this.hideTip();
                    } else {
                        LiveFreeTaskLayer.this.cnT();
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = View.inflate(getContext(), a.g.ala_task_list_layout, this);
        this.icn = (LinearLayout) this.mRootView.findViewById(a.f.layout_content);
        this.icj = (TextView) this.mRootView.findViewById(a.f.tv_flower_task_title);
        this.ick = (ImageView) this.mRootView.findViewById(a.f.img_flower_help);
        this.gde = this.mRootView.findViewById(a.f.divider);
        this.icl = (TextView) this.mRootView.findViewById(a.f.tv_flower_count);
        this.icm = (TextView) this.mRootView.findViewById(a.f.tv_task_help_tips);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.detail_list);
        this.btf = (CommonEmptyView) this.mRootView.findViewById(a.f.emptyView);
        this.ici = new b(getContext(), new com.baidu.tieba.ala.tasklist.a.a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.1
            @Override // com.baidu.tieba.ala.tasklist.a.a
            public void wp(int i) {
                if (LiveFreeTaskLayer.this.ich != null) {
                    LiveFreeTaskLayer.this.ich.wp(i);
                }
            }
        });
        this.mListView.setAdapter((ListAdapter) this.ici);
        this.mListView.setEmptyView(this.btf);
        this.mRootView.setOnTouchListener(this.icw);
        this.icn.setOnTouchListener(this.icw);
        this.ick.setOnClickListener(this.onClickListener);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
        if (screenDimensions[1] > screenDimensions[0]) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.icn.getLayoutParams();
            layoutParams.height = (int) (screenDimensions[1] * 0.618d);
            this.icn.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Am() {
        this.ich = new com.baidu.tieba.ala.tasklist.model.a();
        this.ich.a(this.icu);
        MessageManager.getInstance().registerListener(this.icv);
        bEv();
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void An() {
        if (this.ich != null) {
            this.ich.onDestroy();
            this.ich = null;
        }
        MessageManager.getInstance().unRegisterListener(this.icv);
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Ao() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Ap() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void release() {
        super.release();
        if (this.ich != null) {
            this.ich.onDestroy();
            this.ich = null;
        }
        if (this.ict != null && this.ict.isShowing()) {
            this.ict.dismiss();
            this.ict = null;
        }
        if (this.ics != null && this.ics.isShowing()) {
            this.ics.dismiss();
            this.ics = null;
        }
        MessageManager.getInstance().unRegisterListener(this.icv);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            if (this.ict != null && this.ict.isShowing()) {
                this.ict.dismiss();
                this.ict = null;
            }
            if (this.ics != null && this.ics.isShowing()) {
                this.ics.dismiss();
                this.ics = null;
            }
            com.baidu.live.core.layer.b.As().e(this);
        }
    }

    public void setIsFromFlowerGuide(boolean z) {
        this.icp = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEv() {
        this.btf.setVisibility(8);
        this.ich.cnX();
    }

    private void wp(int i) {
        this.ich.wp(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnQ() {
        ap Bf;
        if (this.icp && this.icq < 3 && (Bf = this.ici.Bf()) != null) {
            if (Bf.status == 2) {
                wp(Bf.aKM);
                this.icq++;
                this.icr = true;
                return;
            }
            this.icp = false;
            if (this.icr) {
                this.icr = false;
                wq(Bf.aKR);
            }
        }
    }

    private void wq(int i) {
        if (this.ict != null && this.ict.isShowing()) {
            this.ict.dismiss();
        }
        this.ict = null;
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.dialog_flower_guide_result, (ViewGroup) null);
        this.ict = new Dialog(this.mContext, a.i.FlowerGuideResultDialogStyle);
        this.ict.requestWindowFeature(1);
        this.ict.setCancelable(false);
        this.ict.setContentView(inflate);
        this.ict.setCanceledOnTouchOutside(false);
        ((TextView) inflate.findViewById(a.f.flowerNum_textView)).setText(String.format("恭喜获得%s鲜花", Integer.valueOf(i)));
        ((ImageView) inflate.findViewById(a.f.close_imageView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    LiveFreeTaskLayer.this.ict.dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((TextView) inflate.findViewById(a.f.toGift_textView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    LiveFreeTaskLayer.this.ict.dismiss();
                    LiveFreeTaskLayer.this.bST();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.ict.show();
    }

    public void cnR() {
        ColorStateList colorStateList;
        if (this.ics != null && this.ics.isShowing()) {
            this.ics.dismiss();
        }
        this.ics = null;
        this.ics = new AlertDialog.Builder(this.mContext, a.i.sdk_dialog_window).create();
        this.ics.show();
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.ala_flower_over_limit_dialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(a.f.tv_task_failed_content)).setText(getFlowerOverLimitContent());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LiveFreeTaskLayer.this.ics.dismiss();
            }
        });
        inflate.findViewById(a.f.close_img).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LiveFreeTaskLayer.this.ics.dismiss();
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
                LiveFreeTaskLayer.this.ics.dismiss();
                LiveFreeTaskLayer.this.bST();
            }
        });
        Window window = this.ics.getWindow();
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
    public void bST() {
        cj cjVar;
        com.baidu.live.core.layer.b.As().e(this);
        int i = -1;
        bq bqVar = com.baidu.live.af.a.OJ().bxp;
        if (bqVar != null && bqVar.aMO != null && (cjVar = bqVar.aMO.aOq) != null) {
            i = cjVar.aOG;
        }
        ak akVar = new ak();
        akVar.aHr = i;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, akVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnS() {
        com.baidu.live.core.layer.b.As().e(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI(String str, boolean z) {
        this.icl.setVisibility(z ? 0 : 8);
        this.icl.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnT() {
        this.ico = true;
        this.gde.setVisibility(8);
        this.icm.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTip() {
        this.ico = false;
        this.gde.setVisibility(0);
        this.icm.setVisibility(8);
    }
}
