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
    private View gfy;
    private Dialog ihA;
    private a.InterfaceC0695a ihB;
    private CustomMessageListener ihC;
    private View.OnTouchListener ihD;
    private a iho;
    private b ihp;
    private TextView ihq;
    private ImageView ihr;
    private TextView ihs;
    private TextView iht;
    private LinearLayout ihu;
    private boolean ihv;
    private boolean ihw;
    private int ihx;
    private boolean ihy;
    private AlertDialog ihz;
    private Context mContext;
    private BdListView mListView;
    private View mRootView;
    private View.OnClickListener onClickListener;

    public LiveFreeTaskLayer(@NonNull Context context) {
        super(context);
        this.ihv = false;
        this.ihB = new a.InterfaceC0695a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5
            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0695a
            public void a(AlaLiveUserInfoData alaLiveUserInfoData, au auVar) {
                if (alaLiveUserInfoData != null) {
                    LiveFreeTaskLayer.this.aH(String.valueOf(alaLiveUserInfoData.petalNum), true);
                    TbadkCoreApplication.getInst().currentAccountFlowerNum = alaLiveUserInfoData.petalNum;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                } else {
                    LiveFreeTaskLayer.this.aH("", false);
                }
                if (auVar != null) {
                    LiveFreeTaskLayer.this.ihp.setData(auVar.aNQ);
                }
                LiveFreeTaskLayer.this.cpc();
            }

            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0695a
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
                    if (LiveFreeTaskLayer.this.iho.cpg() != null && ListUtils.getCount(LiveFreeTaskLayer.this.iho.cpg().aNQ) > 0) {
                        BdUtilHelper.showToast(LiveFreeTaskLayer.this.getContext(), str);
                        return;
                    }
                    return;
                }
                LiveFreeTaskLayer.this.cpd();
            }
        };
        this.ihC = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    LiveFreeTaskLayer.this.ihp.o((Integer) customResponsedMessage.getData());
                }
            }
        };
        this.ihD = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (view == LiveFreeTaskLayer.this.ihu) {
                        if (LiveFreeTaskLayer.this.ihv) {
                            LiveFreeTaskLayer.this.hideTip();
                            return true;
                        }
                        return true;
                    }
                    LiveFreeTaskLayer.this.cpe();
                    return true;
                }
                return true;
            }
        };
        this.onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == LiveFreeTaskLayer.this.ihr) {
                    if (LiveFreeTaskLayer.this.ihv) {
                        LiveFreeTaskLayer.this.hideTip();
                    } else {
                        LiveFreeTaskLayer.this.cpf();
                    }
                }
            }
        };
        init(context);
    }

    public LiveFreeTaskLayer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ihv = false;
        this.ihB = new a.InterfaceC0695a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5
            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0695a
            public void a(AlaLiveUserInfoData alaLiveUserInfoData, au auVar) {
                if (alaLiveUserInfoData != null) {
                    LiveFreeTaskLayer.this.aH(String.valueOf(alaLiveUserInfoData.petalNum), true);
                    TbadkCoreApplication.getInst().currentAccountFlowerNum = alaLiveUserInfoData.petalNum;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                } else {
                    LiveFreeTaskLayer.this.aH("", false);
                }
                if (auVar != null) {
                    LiveFreeTaskLayer.this.ihp.setData(auVar.aNQ);
                }
                LiveFreeTaskLayer.this.cpc();
            }

            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0695a
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
                    if (LiveFreeTaskLayer.this.iho.cpg() != null && ListUtils.getCount(LiveFreeTaskLayer.this.iho.cpg().aNQ) > 0) {
                        BdUtilHelper.showToast(LiveFreeTaskLayer.this.getContext(), str);
                        return;
                    }
                    return;
                }
                LiveFreeTaskLayer.this.cpd();
            }
        };
        this.ihC = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    LiveFreeTaskLayer.this.ihp.o((Integer) customResponsedMessage.getData());
                }
            }
        };
        this.ihD = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (view == LiveFreeTaskLayer.this.ihu) {
                        if (LiveFreeTaskLayer.this.ihv) {
                            LiveFreeTaskLayer.this.hideTip();
                            return true;
                        }
                        return true;
                    }
                    LiveFreeTaskLayer.this.cpe();
                    return true;
                }
                return true;
            }
        };
        this.onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == LiveFreeTaskLayer.this.ihr) {
                    if (LiveFreeTaskLayer.this.ihv) {
                        LiveFreeTaskLayer.this.hideTip();
                    } else {
                        LiveFreeTaskLayer.this.cpf();
                    }
                }
            }
        };
        init(context);
    }

    public LiveFreeTaskLayer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ihv = false;
        this.ihB = new a.InterfaceC0695a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5
            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0695a
            public void a(AlaLiveUserInfoData alaLiveUserInfoData, au auVar) {
                if (alaLiveUserInfoData != null) {
                    LiveFreeTaskLayer.this.aH(String.valueOf(alaLiveUserInfoData.petalNum), true);
                    TbadkCoreApplication.getInst().currentAccountFlowerNum = alaLiveUserInfoData.petalNum;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                } else {
                    LiveFreeTaskLayer.this.aH("", false);
                }
                if (auVar != null) {
                    LiveFreeTaskLayer.this.ihp.setData(auVar.aNQ);
                }
                LiveFreeTaskLayer.this.cpc();
            }

            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0695a
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
                    if (LiveFreeTaskLayer.this.iho.cpg() != null && ListUtils.getCount(LiveFreeTaskLayer.this.iho.cpg().aNQ) > 0) {
                        BdUtilHelper.showToast(LiveFreeTaskLayer.this.getContext(), str);
                        return;
                    }
                    return;
                }
                LiveFreeTaskLayer.this.cpd();
            }
        };
        this.ihC = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    LiveFreeTaskLayer.this.ihp.o((Integer) customResponsedMessage.getData());
                }
            }
        };
        this.ihD = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (view == LiveFreeTaskLayer.this.ihu) {
                        if (LiveFreeTaskLayer.this.ihv) {
                            LiveFreeTaskLayer.this.hideTip();
                            return true;
                        }
                        return true;
                    }
                    LiveFreeTaskLayer.this.cpe();
                    return true;
                }
                return true;
            }
        };
        this.onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == LiveFreeTaskLayer.this.ihr) {
                    if (LiveFreeTaskLayer.this.ihv) {
                        LiveFreeTaskLayer.this.hideTip();
                    } else {
                        LiveFreeTaskLayer.this.cpf();
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = View.inflate(getContext(), a.g.ala_task_list_layout, this);
        this.ihu = (LinearLayout) this.mRootView.findViewById(a.f.layout_content);
        this.ihq = (TextView) this.mRootView.findViewById(a.f.tv_flower_task_title);
        this.ihr = (ImageView) this.mRootView.findViewById(a.f.img_flower_help);
        this.gfy = this.mRootView.findViewById(a.f.divider);
        this.ihs = (TextView) this.mRootView.findViewById(a.f.tv_flower_count);
        this.iht = (TextView) this.mRootView.findViewById(a.f.tv_task_help_tips);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.detail_list);
        this.bwJ = (CommonEmptyView) this.mRootView.findViewById(a.f.emptyView);
        this.ihp = new b(getContext(), new com.baidu.tieba.ala.tasklist.a.a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.1
            @Override // com.baidu.tieba.ala.tasklist.a.a
            public void wA(int i) {
                if (LiveFreeTaskLayer.this.iho != null) {
                    LiveFreeTaskLayer.this.iho.wA(i);
                }
            }
        });
        this.mListView.setAdapter((ListAdapter) this.ihp);
        this.mListView.setEmptyView(this.bwJ);
        this.mRootView.setOnTouchListener(this.ihD);
        this.ihu.setOnTouchListener(this.ihD);
        this.ihr.setOnClickListener(this.onClickListener);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
        if (screenDimensions[1] > screenDimensions[0]) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ihu.getLayoutParams();
            layoutParams.height = (int) (screenDimensions[1] * 0.618d);
            this.ihu.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void AW() {
        this.iho = new com.baidu.tieba.ala.tasklist.model.a();
        this.iho.a(this.ihB);
        MessageManager.getInstance().registerListener(this.ihC);
        bEN();
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void AX() {
        if (this.iho != null) {
            this.iho.onDestroy();
            this.iho = null;
        }
        MessageManager.getInstance().unRegisterListener(this.ihC);
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
        if (this.iho != null) {
            this.iho.onDestroy();
            this.iho = null;
        }
        if (this.ihA != null && this.ihA.isShowing()) {
            this.ihA.dismiss();
            this.ihA = null;
        }
        if (this.ihz != null && this.ihz.isShowing()) {
            this.ihz.dismiss();
            this.ihz = null;
        }
        MessageManager.getInstance().unRegisterListener(this.ihC);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            if (this.ihA != null && this.ihA.isShowing()) {
                this.ihA.dismiss();
                this.ihA = null;
            }
            if (this.ihz != null && this.ihz.isShowing()) {
                this.ihz.dismiss();
                this.ihz = null;
            }
            com.baidu.live.core.layer.b.Bc().e(this);
        }
    }

    public void setIsFromFlowerGuide(boolean z) {
        this.ihw = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEN() {
        this.bwJ.setVisibility(8);
        this.iho.cpj();
    }

    private void wA(int i) {
        this.iho.wA(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpc() {
        at Cs;
        if (this.ihw && this.ihx < 3 && (Cs = this.ihp.Cs()) != null) {
            if (Cs.status == 2) {
                wA(Cs.aNI);
                this.ihx++;
                this.ihy = true;
                return;
            }
            this.ihw = false;
            if (this.ihy) {
                this.ihy = false;
                wB(Cs.aNN);
            }
        }
    }

    private void wB(int i) {
        if (this.ihA != null && this.ihA.isShowing()) {
            this.ihA.dismiss();
        }
        this.ihA = null;
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.dialog_flower_guide_result, (ViewGroup) null);
        this.ihA = new Dialog(this.mContext, a.i.FlowerGuideResultDialogStyle);
        this.ihA.requestWindowFeature(1);
        this.ihA.setCancelable(false);
        this.ihA.setContentView(inflate);
        this.ihA.setCanceledOnTouchOutside(false);
        ((TextView) inflate.findViewById(a.f.flowerNum_textView)).setText(String.format("恭喜获得%s鲜花", Integer.valueOf(i)));
        ((ImageView) inflate.findViewById(a.f.close_imageView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    LiveFreeTaskLayer.this.ihA.dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((TextView) inflate.findViewById(a.f.toGift_textView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    LiveFreeTaskLayer.this.ihA.dismiss();
                    LiveFreeTaskLayer.this.bTD();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.ihA.show();
    }

    public void cpd() {
        ColorStateList colorStateList;
        if (this.ihz != null && this.ihz.isShowing()) {
            this.ihz.dismiss();
        }
        this.ihz = null;
        this.ihz = new AlertDialog.Builder(this.mContext, a.i.sdk_dialog_window).create();
        this.ihz.show();
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.ala_flower_over_limit_dialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(a.f.tv_task_failed_content)).setText(getFlowerOverLimitContent());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LiveFreeTaskLayer.this.ihz.dismiss();
            }
        });
        inflate.findViewById(a.f.close_img).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LiveFreeTaskLayer.this.ihz.dismiss();
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
                LiveFreeTaskLayer.this.ihz.dismiss();
                LiveFreeTaskLayer.this.bTD();
            }
        });
        Window window = this.ihz.getWindow();
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
    public void bTD() {
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
    public void cpe() {
        com.baidu.live.core.layer.b.Bc().e(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(String str, boolean z) {
        this.ihs.setVisibility(z ? 0 : 8);
        this.ihs.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpf() {
        this.ihv = true;
        this.gfy.setVisibility(8);
        this.iht.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTip() {
        this.ihv = false;
        this.gfy.setVisibility(0);
        this.iht.setVisibility(8);
    }
}
