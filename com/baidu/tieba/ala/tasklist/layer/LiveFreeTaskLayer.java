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
import com.baidu.live.data.ao;
import com.baidu.live.data.at;
import com.baidu.live.data.au;
import com.baidu.live.data.bv;
import com.baidu.live.data.cq;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.tieba.ala.tasklist.a.b;
import com.baidu.tieba.ala.tasklist.model.a;
/* loaded from: classes11.dex */
public class LiveFreeTaskLayer extends LayerChildView {
    private CommonEmptyView bwJ;
    private View gft;
    private a iha;
    private b ihb;
    private TextView ihc;
    private ImageView ihd;
    private TextView ihe;
    private TextView ihf;
    private LinearLayout ihg;
    private boolean ihh;
    private boolean ihi;
    private int ihj;
    private boolean ihk;
    private AlertDialog ihl;
    private Dialog ihm;
    private a.InterfaceC0694a ihn;
    private CustomMessageListener iho;
    private View.OnTouchListener ihp;
    private Context mContext;
    private BdListView mListView;
    private View mRootView;
    private View.OnClickListener onClickListener;

    public LiveFreeTaskLayer(@NonNull Context context) {
        super(context);
        this.ihh = false;
        this.ihn = new a.InterfaceC0694a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5
            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0694a
            public void a(AlaLiveUserInfoData alaLiveUserInfoData, au auVar) {
                if (alaLiveUserInfoData != null) {
                    LiveFreeTaskLayer.this.aH(String.valueOf(alaLiveUserInfoData.petalNum), true);
                    TbadkCoreApplication.getInst().currentAccountFlowerNum = alaLiveUserInfoData.petalNum;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                } else {
                    LiveFreeTaskLayer.this.aH("", false);
                }
                if (auVar != null) {
                    LiveFreeTaskLayer.this.ihb.setData(auVar.aNQ);
                }
                LiveFreeTaskLayer.this.coV();
            }

            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0694a
            public void aJ(int i, String str) {
                LiveFreeTaskLayer.this.bwJ.reset();
                LiveFreeTaskLayer.this.bwJ.setTitle(a.h.ala_task_empty_msg);
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    LiveFreeTaskLayer.this.bwJ.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
                } else {
                    LiveFreeTaskLayer.this.bwJ.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LiveFreeTaskLayer.this.bEN();
                        }
                    });
                    LiveFreeTaskLayer.this.bwJ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
                }
                LiveFreeTaskLayer.this.bwJ.setVisibility(0);
                if (i != 146021) {
                    if (LiveFreeTaskLayer.this.iha.coZ() != null && ListUtils.getCount(LiveFreeTaskLayer.this.iha.coZ().aNQ) > 0) {
                        BdUtilHelper.showToast(LiveFreeTaskLayer.this.getContext(), str);
                        return;
                    }
                    return;
                }
                LiveFreeTaskLayer.this.coW();
            }
        };
        this.iho = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    LiveFreeTaskLayer.this.ihb.o((Integer) customResponsedMessage.getData());
                }
            }
        };
        this.ihp = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (view == LiveFreeTaskLayer.this.ihg) {
                        if (LiveFreeTaskLayer.this.ihh) {
                            LiveFreeTaskLayer.this.hideTip();
                            return true;
                        }
                        return true;
                    }
                    LiveFreeTaskLayer.this.coX();
                    return true;
                }
                return true;
            }
        };
        this.onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == LiveFreeTaskLayer.this.ihd) {
                    if (LiveFreeTaskLayer.this.ihh) {
                        LiveFreeTaskLayer.this.hideTip();
                    } else {
                        LiveFreeTaskLayer.this.coY();
                    }
                }
            }
        };
        init(context);
    }

    public LiveFreeTaskLayer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ihh = false;
        this.ihn = new a.InterfaceC0694a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5
            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0694a
            public void a(AlaLiveUserInfoData alaLiveUserInfoData, au auVar) {
                if (alaLiveUserInfoData != null) {
                    LiveFreeTaskLayer.this.aH(String.valueOf(alaLiveUserInfoData.petalNum), true);
                    TbadkCoreApplication.getInst().currentAccountFlowerNum = alaLiveUserInfoData.petalNum;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                } else {
                    LiveFreeTaskLayer.this.aH("", false);
                }
                if (auVar != null) {
                    LiveFreeTaskLayer.this.ihb.setData(auVar.aNQ);
                }
                LiveFreeTaskLayer.this.coV();
            }

            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0694a
            public void aJ(int i, String str) {
                LiveFreeTaskLayer.this.bwJ.reset();
                LiveFreeTaskLayer.this.bwJ.setTitle(a.h.ala_task_empty_msg);
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    LiveFreeTaskLayer.this.bwJ.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
                } else {
                    LiveFreeTaskLayer.this.bwJ.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LiveFreeTaskLayer.this.bEN();
                        }
                    });
                    LiveFreeTaskLayer.this.bwJ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
                }
                LiveFreeTaskLayer.this.bwJ.setVisibility(0);
                if (i != 146021) {
                    if (LiveFreeTaskLayer.this.iha.coZ() != null && ListUtils.getCount(LiveFreeTaskLayer.this.iha.coZ().aNQ) > 0) {
                        BdUtilHelper.showToast(LiveFreeTaskLayer.this.getContext(), str);
                        return;
                    }
                    return;
                }
                LiveFreeTaskLayer.this.coW();
            }
        };
        this.iho = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    LiveFreeTaskLayer.this.ihb.o((Integer) customResponsedMessage.getData());
                }
            }
        };
        this.ihp = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (view == LiveFreeTaskLayer.this.ihg) {
                        if (LiveFreeTaskLayer.this.ihh) {
                            LiveFreeTaskLayer.this.hideTip();
                            return true;
                        }
                        return true;
                    }
                    LiveFreeTaskLayer.this.coX();
                    return true;
                }
                return true;
            }
        };
        this.onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == LiveFreeTaskLayer.this.ihd) {
                    if (LiveFreeTaskLayer.this.ihh) {
                        LiveFreeTaskLayer.this.hideTip();
                    } else {
                        LiveFreeTaskLayer.this.coY();
                    }
                }
            }
        };
        init(context);
    }

    public LiveFreeTaskLayer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ihh = false;
        this.ihn = new a.InterfaceC0694a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5
            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0694a
            public void a(AlaLiveUserInfoData alaLiveUserInfoData, au auVar) {
                if (alaLiveUserInfoData != null) {
                    LiveFreeTaskLayer.this.aH(String.valueOf(alaLiveUserInfoData.petalNum), true);
                    TbadkCoreApplication.getInst().currentAccountFlowerNum = alaLiveUserInfoData.petalNum;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                } else {
                    LiveFreeTaskLayer.this.aH("", false);
                }
                if (auVar != null) {
                    LiveFreeTaskLayer.this.ihb.setData(auVar.aNQ);
                }
                LiveFreeTaskLayer.this.coV();
            }

            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0694a
            public void aJ(int i2, String str) {
                LiveFreeTaskLayer.this.bwJ.reset();
                LiveFreeTaskLayer.this.bwJ.setTitle(a.h.ala_task_empty_msg);
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    LiveFreeTaskLayer.this.bwJ.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
                } else {
                    LiveFreeTaskLayer.this.bwJ.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LiveFreeTaskLayer.this.bEN();
                        }
                    });
                    LiveFreeTaskLayer.this.bwJ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
                }
                LiveFreeTaskLayer.this.bwJ.setVisibility(0);
                if (i2 != 146021) {
                    if (LiveFreeTaskLayer.this.iha.coZ() != null && ListUtils.getCount(LiveFreeTaskLayer.this.iha.coZ().aNQ) > 0) {
                        BdUtilHelper.showToast(LiveFreeTaskLayer.this.getContext(), str);
                        return;
                    }
                    return;
                }
                LiveFreeTaskLayer.this.coW();
            }
        };
        this.iho = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    LiveFreeTaskLayer.this.ihb.o((Integer) customResponsedMessage.getData());
                }
            }
        };
        this.ihp = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (view == LiveFreeTaskLayer.this.ihg) {
                        if (LiveFreeTaskLayer.this.ihh) {
                            LiveFreeTaskLayer.this.hideTip();
                            return true;
                        }
                        return true;
                    }
                    LiveFreeTaskLayer.this.coX();
                    return true;
                }
                return true;
            }
        };
        this.onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == LiveFreeTaskLayer.this.ihd) {
                    if (LiveFreeTaskLayer.this.ihh) {
                        LiveFreeTaskLayer.this.hideTip();
                    } else {
                        LiveFreeTaskLayer.this.coY();
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = View.inflate(getContext(), a.g.ala_task_list_layout, this);
        this.ihg = (LinearLayout) this.mRootView.findViewById(a.f.layout_content);
        this.ihc = (TextView) this.mRootView.findViewById(a.f.tv_flower_task_title);
        this.ihd = (ImageView) this.mRootView.findViewById(a.f.img_flower_help);
        this.gft = this.mRootView.findViewById(a.f.divider);
        this.ihe = (TextView) this.mRootView.findViewById(a.f.tv_flower_count);
        this.ihf = (TextView) this.mRootView.findViewById(a.f.tv_task_help_tips);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.detail_list);
        this.bwJ = (CommonEmptyView) this.mRootView.findViewById(a.f.emptyView);
        this.ihb = new b(getContext(), new com.baidu.tieba.ala.tasklist.a.a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.1
            @Override // com.baidu.tieba.ala.tasklist.a.a
            public void wA(int i) {
                if (LiveFreeTaskLayer.this.iha != null) {
                    LiveFreeTaskLayer.this.iha.wA(i);
                }
            }
        });
        this.mListView.setAdapter((ListAdapter) this.ihb);
        this.mListView.setEmptyView(this.bwJ);
        this.mRootView.setOnTouchListener(this.ihp);
        this.ihg.setOnTouchListener(this.ihp);
        this.ihd.setOnClickListener(this.onClickListener);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
        if (screenDimensions[1] > screenDimensions[0]) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ihg.getLayoutParams();
            layoutParams.height = (int) (screenDimensions[1] * 0.618d);
            this.ihg.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void AW() {
        this.iha = new com.baidu.tieba.ala.tasklist.model.a();
        this.iha.a(this.ihn);
        MessageManager.getInstance().registerListener(this.iho);
        bEN();
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void AX() {
        if (this.iha != null) {
            this.iha.onDestroy();
            this.iha = null;
        }
        MessageManager.getInstance().unRegisterListener(this.iho);
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void AY() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void AZ() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void release() {
        super.release();
        if (this.iha != null) {
            this.iha.onDestroy();
            this.iha = null;
        }
        if (this.ihm != null && this.ihm.isShowing()) {
            this.ihm.dismiss();
            this.ihm = null;
        }
        if (this.ihl != null && this.ihl.isShowing()) {
            this.ihl.dismiss();
            this.ihl = null;
        }
        MessageManager.getInstance().unRegisterListener(this.iho);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            if (this.ihm != null && this.ihm.isShowing()) {
                this.ihm.dismiss();
                this.ihm = null;
            }
            if (this.ihl != null && this.ihl.isShowing()) {
                this.ihl.dismiss();
                this.ihl = null;
            }
            com.baidu.live.core.layer.b.Bc().e(this);
        }
    }

    public void setIsFromFlowerGuide(boolean z) {
        this.ihi = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEN() {
        this.bwJ.setVisibility(8);
        this.iha.cpc();
    }

    private void wA(int i) {
        this.iha.wA(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coV() {
        at Cs;
        if (this.ihi && this.ihj < 3 && (Cs = this.ihb.Cs()) != null) {
            if (Cs.status == 2) {
                wA(Cs.aNI);
                this.ihj++;
                this.ihk = true;
                return;
            }
            this.ihi = false;
            if (this.ihk) {
                this.ihk = false;
                wB(Cs.aNN);
            }
        }
    }

    private void wB(int i) {
        if (this.ihm != null && this.ihm.isShowing()) {
            this.ihm.dismiss();
        }
        this.ihm = null;
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.dialog_flower_guide_result, (ViewGroup) null);
        this.ihm = new Dialog(this.mContext, a.i.FlowerGuideResultDialogStyle);
        this.ihm.requestWindowFeature(1);
        this.ihm.setCancelable(false);
        this.ihm.setContentView(inflate);
        this.ihm.setCanceledOnTouchOutside(false);
        ((TextView) inflate.findViewById(a.f.flowerNum_textView)).setText(String.format("恭喜获得%s鲜花", Integer.valueOf(i)));
        ((ImageView) inflate.findViewById(a.f.close_imageView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    LiveFreeTaskLayer.this.ihm.dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((TextView) inflate.findViewById(a.f.toGift_textView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    LiveFreeTaskLayer.this.ihm.dismiss();
                    LiveFreeTaskLayer.this.bTw();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.ihm.show();
    }

    public void coW() {
        ColorStateList colorStateList;
        if (this.ihl != null && this.ihl.isShowing()) {
            this.ihl.dismiss();
        }
        this.ihl = null;
        this.ihl = new AlertDialog.Builder(this.mContext, a.i.sdk_dialog_window).create();
        this.ihl.show();
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.ala_flower_over_limit_dialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(a.f.tv_task_failed_content)).setText(getFlowerOverLimitContent());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LiveFreeTaskLayer.this.ihl.dismiss();
            }
        });
        inflate.findViewById(a.f.close_img).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LiveFreeTaskLayer.this.ihl.dismiss();
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
                LiveFreeTaskLayer.this.ihl.dismiss();
                LiveFreeTaskLayer.this.bTw();
            }
        });
        Window window = this.ihl.getWindow();
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
    public void bTw() {
        cq cqVar;
        com.baidu.live.core.layer.b.Bc().e(this);
        int i = -1;
        bv bvVar = com.baidu.live.ae.a.Qj().bAS;
        if (bvVar != null && bvVar.aPM != null && (cqVar = bvVar.aPM.aRt) != null) {
            i = cqVar.aRI;
        }
        ao aoVar = new ao();
        aoVar.aJW = i;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aoVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coX() {
        com.baidu.live.core.layer.b.Bc().e(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(String str, boolean z) {
        this.ihe.setVisibility(z ? 0 : 8);
        this.ihe.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coY() {
        this.ihh = true;
        this.gft.setVisibility(8);
        this.ihf.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTip() {
        this.ihh = false;
        this.gft.setVisibility(0);
        this.ihf.setVisibility(8);
    }
}
