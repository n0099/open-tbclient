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
/* loaded from: classes11.dex */
public class LiveFreeTaskLayer extends LayerChildView {
    private CommonEmptyView bxT;
    private View ghM;
    private a igS;
    private b igT;
    private TextView igU;
    private ImageView igV;
    private TextView igW;
    private TextView igX;
    private LinearLayout igY;
    private boolean igZ;
    private boolean iha;
    private int ihb;
    private boolean ihc;
    private AlertDialog ihd;
    private Dialog ihe;
    private a.InterfaceC0711a ihf;
    private CustomMessageListener ihg;
    private View.OnTouchListener ihh;
    private Context mContext;
    private BdListView mListView;
    private View mRootView;
    private View.OnClickListener onClickListener;

    public LiveFreeTaskLayer(@NonNull Context context) {
        super(context);
        this.igZ = false;
        this.ihf = new a.InterfaceC0711a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5
            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0711a
            public void a(AlaLiveUserInfoData alaLiveUserInfoData, aq aqVar) {
                if (alaLiveUserInfoData != null) {
                    LiveFreeTaskLayer.this.aI(String.valueOf(alaLiveUserInfoData.petalNum), true);
                    TbadkCoreApplication.getInst().currentAccountFlowerNum = alaLiveUserInfoData.petalNum;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                } else {
                    LiveFreeTaskLayer.this.aI("", false);
                }
                if (aqVar != null) {
                    LiveFreeTaskLayer.this.igT.setData(aqVar.aPH);
                }
                LiveFreeTaskLayer.this.crH();
            }

            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0711a
            public void aE(int i, String str) {
                LiveFreeTaskLayer.this.bxT.reset();
                LiveFreeTaskLayer.this.bxT.setTitle(a.h.ala_task_empty_msg);
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    LiveFreeTaskLayer.this.bxT.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
                } else {
                    LiveFreeTaskLayer.this.bxT.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LiveFreeTaskLayer.this.bIm();
                        }
                    });
                    LiveFreeTaskLayer.this.bxT.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
                }
                LiveFreeTaskLayer.this.bxT.setVisibility(0);
                if (i != 146021) {
                    if (LiveFreeTaskLayer.this.igS.crL() != null && ListUtils.getCount(LiveFreeTaskLayer.this.igS.crL().aPH) > 0) {
                        BdUtilHelper.showToast(LiveFreeTaskLayer.this.getContext(), str);
                        return;
                    }
                    return;
                }
                LiveFreeTaskLayer.this.crI();
            }
        };
        this.ihg = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    LiveFreeTaskLayer.this.igT.o((Integer) customResponsedMessage.getData());
                }
            }
        };
        this.ihh = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (view == LiveFreeTaskLayer.this.igY) {
                        if (LiveFreeTaskLayer.this.igZ) {
                            LiveFreeTaskLayer.this.hideTip();
                            return true;
                        }
                        return true;
                    }
                    LiveFreeTaskLayer.this.crJ();
                    return true;
                }
                return true;
            }
        };
        this.onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == LiveFreeTaskLayer.this.igV) {
                    if (LiveFreeTaskLayer.this.igZ) {
                        LiveFreeTaskLayer.this.hideTip();
                    } else {
                        LiveFreeTaskLayer.this.crK();
                    }
                }
            }
        };
        init(context);
    }

    public LiveFreeTaskLayer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.igZ = false;
        this.ihf = new a.InterfaceC0711a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5
            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0711a
            public void a(AlaLiveUserInfoData alaLiveUserInfoData, aq aqVar) {
                if (alaLiveUserInfoData != null) {
                    LiveFreeTaskLayer.this.aI(String.valueOf(alaLiveUserInfoData.petalNum), true);
                    TbadkCoreApplication.getInst().currentAccountFlowerNum = alaLiveUserInfoData.petalNum;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                } else {
                    LiveFreeTaskLayer.this.aI("", false);
                }
                if (aqVar != null) {
                    LiveFreeTaskLayer.this.igT.setData(aqVar.aPH);
                }
                LiveFreeTaskLayer.this.crH();
            }

            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0711a
            public void aE(int i, String str) {
                LiveFreeTaskLayer.this.bxT.reset();
                LiveFreeTaskLayer.this.bxT.setTitle(a.h.ala_task_empty_msg);
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    LiveFreeTaskLayer.this.bxT.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
                } else {
                    LiveFreeTaskLayer.this.bxT.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LiveFreeTaskLayer.this.bIm();
                        }
                    });
                    LiveFreeTaskLayer.this.bxT.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
                }
                LiveFreeTaskLayer.this.bxT.setVisibility(0);
                if (i != 146021) {
                    if (LiveFreeTaskLayer.this.igS.crL() != null && ListUtils.getCount(LiveFreeTaskLayer.this.igS.crL().aPH) > 0) {
                        BdUtilHelper.showToast(LiveFreeTaskLayer.this.getContext(), str);
                        return;
                    }
                    return;
                }
                LiveFreeTaskLayer.this.crI();
            }
        };
        this.ihg = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    LiveFreeTaskLayer.this.igT.o((Integer) customResponsedMessage.getData());
                }
            }
        };
        this.ihh = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (view == LiveFreeTaskLayer.this.igY) {
                        if (LiveFreeTaskLayer.this.igZ) {
                            LiveFreeTaskLayer.this.hideTip();
                            return true;
                        }
                        return true;
                    }
                    LiveFreeTaskLayer.this.crJ();
                    return true;
                }
                return true;
            }
        };
        this.onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == LiveFreeTaskLayer.this.igV) {
                    if (LiveFreeTaskLayer.this.igZ) {
                        LiveFreeTaskLayer.this.hideTip();
                    } else {
                        LiveFreeTaskLayer.this.crK();
                    }
                }
            }
        };
        init(context);
    }

    public LiveFreeTaskLayer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.igZ = false;
        this.ihf = new a.InterfaceC0711a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5
            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0711a
            public void a(AlaLiveUserInfoData alaLiveUserInfoData, aq aqVar) {
                if (alaLiveUserInfoData != null) {
                    LiveFreeTaskLayer.this.aI(String.valueOf(alaLiveUserInfoData.petalNum), true);
                    TbadkCoreApplication.getInst().currentAccountFlowerNum = alaLiveUserInfoData.petalNum;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                } else {
                    LiveFreeTaskLayer.this.aI("", false);
                }
                if (aqVar != null) {
                    LiveFreeTaskLayer.this.igT.setData(aqVar.aPH);
                }
                LiveFreeTaskLayer.this.crH();
            }

            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0711a
            public void aE(int i2, String str) {
                LiveFreeTaskLayer.this.bxT.reset();
                LiveFreeTaskLayer.this.bxT.setTitle(a.h.ala_task_empty_msg);
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    LiveFreeTaskLayer.this.bxT.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
                } else {
                    LiveFreeTaskLayer.this.bxT.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LiveFreeTaskLayer.this.bIm();
                        }
                    });
                    LiveFreeTaskLayer.this.bxT.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
                }
                LiveFreeTaskLayer.this.bxT.setVisibility(0);
                if (i2 != 146021) {
                    if (LiveFreeTaskLayer.this.igS.crL() != null && ListUtils.getCount(LiveFreeTaskLayer.this.igS.crL().aPH) > 0) {
                        BdUtilHelper.showToast(LiveFreeTaskLayer.this.getContext(), str);
                        return;
                    }
                    return;
                }
                LiveFreeTaskLayer.this.crI();
            }
        };
        this.ihg = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    LiveFreeTaskLayer.this.igT.o((Integer) customResponsedMessage.getData());
                }
            }
        };
        this.ihh = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (view == LiveFreeTaskLayer.this.igY) {
                        if (LiveFreeTaskLayer.this.igZ) {
                            LiveFreeTaskLayer.this.hideTip();
                            return true;
                        }
                        return true;
                    }
                    LiveFreeTaskLayer.this.crJ();
                    return true;
                }
                return true;
            }
        };
        this.onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == LiveFreeTaskLayer.this.igV) {
                    if (LiveFreeTaskLayer.this.igZ) {
                        LiveFreeTaskLayer.this.hideTip();
                    } else {
                        LiveFreeTaskLayer.this.crK();
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = View.inflate(getContext(), a.g.ala_task_list_layout, this);
        this.igY = (LinearLayout) this.mRootView.findViewById(a.f.layout_content);
        this.igU = (TextView) this.mRootView.findViewById(a.f.tv_flower_task_title);
        this.igV = (ImageView) this.mRootView.findViewById(a.f.img_flower_help);
        this.ghM = this.mRootView.findViewById(a.f.divider);
        this.igW = (TextView) this.mRootView.findViewById(a.f.tv_flower_count);
        this.igX = (TextView) this.mRootView.findViewById(a.f.tv_task_help_tips);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.detail_list);
        this.bxT = (CommonEmptyView) this.mRootView.findViewById(a.f.emptyView);
        this.igT = new b(getContext(), new com.baidu.tieba.ala.tasklist.a.a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.1
            @Override // com.baidu.tieba.ala.tasklist.a.a
            public void xV(int i) {
                if (LiveFreeTaskLayer.this.igS != null) {
                    LiveFreeTaskLayer.this.igS.xV(i);
                }
            }
        });
        this.mListView.setAdapter((ListAdapter) this.igT);
        this.mListView.setEmptyView(this.bxT);
        this.mRootView.setOnTouchListener(this.ihh);
        this.igY.setOnTouchListener(this.ihh);
        this.igV.setOnClickListener(this.onClickListener);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
        if (screenDimensions[1] > screenDimensions[0]) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.igY.getLayoutParams();
            layoutParams.height = (int) (screenDimensions[1] * 0.618d);
            this.igY.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Eh() {
        this.igS = new com.baidu.tieba.ala.tasklist.model.a();
        this.igS.a(this.ihf);
        MessageManager.getInstance().registerListener(this.ihg);
        bIm();
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Ei() {
        if (this.igS != null) {
            this.igS.onDestroy();
            this.igS = null;
        }
        MessageManager.getInstance().unRegisterListener(this.ihg);
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Ej() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Ek() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void release() {
        super.release();
        if (this.igS != null) {
            this.igS.onDestroy();
            this.igS = null;
        }
        if (this.ihe != null && this.ihe.isShowing()) {
            this.ihe.dismiss();
            this.ihe = null;
        }
        if (this.ihd != null && this.ihd.isShowing()) {
            this.ihd.dismiss();
            this.ihd = null;
        }
        MessageManager.getInstance().unRegisterListener(this.ihg);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            if (this.ihe != null && this.ihe.isShowing()) {
                this.ihe.dismiss();
                this.ihe = null;
            }
            if (this.ihd != null && this.ihd.isShowing()) {
                this.ihd.dismiss();
                this.ihd = null;
            }
            com.baidu.live.core.layer.b.En().e(this);
        }
    }

    public void setIsFromFlowerGuide(boolean z) {
        this.iha = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIm() {
        this.bxT.setVisibility(8);
        this.igS.crO();
    }

    private void xV(int i) {
        this.igS.xV(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crH() {
        ap Fa;
        if (this.iha && this.ihb < 3 && (Fa = this.igT.Fa()) != null) {
            if (Fa.status == 2) {
                xV(Fa.aPz);
                this.ihb++;
                this.ihc = true;
                return;
            }
            this.iha = false;
            if (this.ihc) {
                this.ihc = false;
                xW(Fa.aPE);
            }
        }
    }

    private void xW(int i) {
        if (this.ihe != null && this.ihe.isShowing()) {
            this.ihe.dismiss();
        }
        this.ihe = null;
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.dialog_flower_guide_result, (ViewGroup) null);
        this.ihe = new Dialog(this.mContext, a.i.FlowerGuideResultDialogStyle);
        this.ihe.requestWindowFeature(1);
        this.ihe.setCancelable(false);
        this.ihe.setContentView(inflate);
        this.ihe.setCanceledOnTouchOutside(false);
        ((TextView) inflate.findViewById(a.f.flowerNum_textView)).setText(String.format("恭喜获得%s鲜花", Integer.valueOf(i)));
        ((ImageView) inflate.findViewById(a.f.close_imageView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    LiveFreeTaskLayer.this.ihe.dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((TextView) inflate.findViewById(a.f.toGift_textView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    LiveFreeTaskLayer.this.ihe.dismiss();
                    LiveFreeTaskLayer.this.bWK();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.ihe.show();
    }

    public void crI() {
        ColorStateList colorStateList;
        if (this.ihd != null && this.ihd.isShowing()) {
            this.ihd.dismiss();
        }
        this.ihd = null;
        this.ihd = new AlertDialog.Builder(this.mContext, a.i.sdk_dialog_window).create();
        this.ihd.show();
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.ala_flower_over_limit_dialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(a.f.tv_task_failed_content)).setText(getFlowerOverLimitContent());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LiveFreeTaskLayer.this.ihd.dismiss();
            }
        });
        inflate.findViewById(a.f.close_img).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LiveFreeTaskLayer.this.ihd.dismiss();
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
                LiveFreeTaskLayer.this.ihd.dismiss();
                LiveFreeTaskLayer.this.bWK();
            }
        });
        Window window = this.ihd.getWindow();
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
    public void bWK() {
        cj cjVar;
        com.baidu.live.core.layer.b.En().e(this);
        int i = -1;
        bq bqVar = com.baidu.live.af.a.SE().bCb;
        if (bqVar != null && bqVar.aRB != null && (cjVar = bqVar.aRB.aTd) != null) {
            i = cjVar.aTt;
        }
        ak akVar = new ak();
        akVar.aMe = i;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, akVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crJ() {
        com.baidu.live.core.layer.b.En().e(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI(String str, boolean z) {
        this.igW.setVisibility(z ? 0 : 8);
        this.igW.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crK() {
        this.igZ = true;
        this.ghM.setVisibility(8);
        this.igX.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTip() {
        this.igZ = false;
        this.ghM.setVisibility(0);
        this.igX.setVisibility(8);
    }
}
