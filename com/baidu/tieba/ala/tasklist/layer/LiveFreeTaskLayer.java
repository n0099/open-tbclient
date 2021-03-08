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
/* loaded from: classes10.dex */
public class LiveFreeTaskLayer extends LayerChildView {
    private CommonEmptyView byj;
    private View ghb;
    private a iiX;
    private b iiY;
    private TextView iiZ;
    private ImageView ija;
    private TextView ijb;
    private TextView ijc;
    private LinearLayout ijd;
    private boolean ije;
    private boolean ijf;
    private int ijg;
    private boolean ijh;
    private AlertDialog iji;
    private Dialog ijj;
    private a.InterfaceC0701a ijk;
    private CustomMessageListener ijl;
    private View.OnTouchListener ijm;
    private Context mContext;
    private BdListView mListView;
    private View mRootView;
    private View.OnClickListener onClickListener;

    public LiveFreeTaskLayer(@NonNull Context context) {
        super(context);
        this.ije = false;
        this.ijk = new a.InterfaceC0701a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5
            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0701a
            public void a(AlaLiveUserInfoData alaLiveUserInfoData, au auVar) {
                if (alaLiveUserInfoData != null) {
                    LiveFreeTaskLayer.this.aH(String.valueOf(alaLiveUserInfoData.petalNum), true);
                    TbadkCoreApplication.getInst().currentAccountFlowerNum = alaLiveUserInfoData.petalNum;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                } else {
                    LiveFreeTaskLayer.this.aH("", false);
                }
                if (auVar != null) {
                    LiveFreeTaskLayer.this.iiY.setData(auVar.aPq);
                }
                LiveFreeTaskLayer.this.cpi();
            }

            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0701a
            public void aJ(int i, String str) {
                LiveFreeTaskLayer.this.byj.reset();
                LiveFreeTaskLayer.this.byj.setTitle(a.h.ala_task_empty_msg);
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    LiveFreeTaskLayer.this.byj.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
                } else {
                    LiveFreeTaskLayer.this.byj.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LiveFreeTaskLayer.this.bER();
                        }
                    });
                    LiveFreeTaskLayer.this.byj.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
                }
                LiveFreeTaskLayer.this.byj.setVisibility(0);
                if (i != 146021) {
                    if (LiveFreeTaskLayer.this.iiX.cpm() != null && ListUtils.getCount(LiveFreeTaskLayer.this.iiX.cpm().aPq) > 0) {
                        BdUtilHelper.showToast(LiveFreeTaskLayer.this.getContext(), str);
                        return;
                    }
                    return;
                }
                LiveFreeTaskLayer.this.cpj();
            }
        };
        this.ijl = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    LiveFreeTaskLayer.this.iiY.o((Integer) customResponsedMessage.getData());
                }
            }
        };
        this.ijm = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (view == LiveFreeTaskLayer.this.ijd) {
                        if (LiveFreeTaskLayer.this.ije) {
                            LiveFreeTaskLayer.this.hideTip();
                            return true;
                        }
                        return true;
                    }
                    LiveFreeTaskLayer.this.cpk();
                    return true;
                }
                return true;
            }
        };
        this.onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == LiveFreeTaskLayer.this.ija) {
                    if (LiveFreeTaskLayer.this.ije) {
                        LiveFreeTaskLayer.this.hideTip();
                    } else {
                        LiveFreeTaskLayer.this.cpl();
                    }
                }
            }
        };
        init(context);
    }

    public LiveFreeTaskLayer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ije = false;
        this.ijk = new a.InterfaceC0701a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5
            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0701a
            public void a(AlaLiveUserInfoData alaLiveUserInfoData, au auVar) {
                if (alaLiveUserInfoData != null) {
                    LiveFreeTaskLayer.this.aH(String.valueOf(alaLiveUserInfoData.petalNum), true);
                    TbadkCoreApplication.getInst().currentAccountFlowerNum = alaLiveUserInfoData.petalNum;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                } else {
                    LiveFreeTaskLayer.this.aH("", false);
                }
                if (auVar != null) {
                    LiveFreeTaskLayer.this.iiY.setData(auVar.aPq);
                }
                LiveFreeTaskLayer.this.cpi();
            }

            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0701a
            public void aJ(int i, String str) {
                LiveFreeTaskLayer.this.byj.reset();
                LiveFreeTaskLayer.this.byj.setTitle(a.h.ala_task_empty_msg);
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    LiveFreeTaskLayer.this.byj.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
                } else {
                    LiveFreeTaskLayer.this.byj.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LiveFreeTaskLayer.this.bER();
                        }
                    });
                    LiveFreeTaskLayer.this.byj.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
                }
                LiveFreeTaskLayer.this.byj.setVisibility(0);
                if (i != 146021) {
                    if (LiveFreeTaskLayer.this.iiX.cpm() != null && ListUtils.getCount(LiveFreeTaskLayer.this.iiX.cpm().aPq) > 0) {
                        BdUtilHelper.showToast(LiveFreeTaskLayer.this.getContext(), str);
                        return;
                    }
                    return;
                }
                LiveFreeTaskLayer.this.cpj();
            }
        };
        this.ijl = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    LiveFreeTaskLayer.this.iiY.o((Integer) customResponsedMessage.getData());
                }
            }
        };
        this.ijm = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (view == LiveFreeTaskLayer.this.ijd) {
                        if (LiveFreeTaskLayer.this.ije) {
                            LiveFreeTaskLayer.this.hideTip();
                            return true;
                        }
                        return true;
                    }
                    LiveFreeTaskLayer.this.cpk();
                    return true;
                }
                return true;
            }
        };
        this.onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == LiveFreeTaskLayer.this.ija) {
                    if (LiveFreeTaskLayer.this.ije) {
                        LiveFreeTaskLayer.this.hideTip();
                    } else {
                        LiveFreeTaskLayer.this.cpl();
                    }
                }
            }
        };
        init(context);
    }

    public LiveFreeTaskLayer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ije = false;
        this.ijk = new a.InterfaceC0701a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5
            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0701a
            public void a(AlaLiveUserInfoData alaLiveUserInfoData, au auVar) {
                if (alaLiveUserInfoData != null) {
                    LiveFreeTaskLayer.this.aH(String.valueOf(alaLiveUserInfoData.petalNum), true);
                    TbadkCoreApplication.getInst().currentAccountFlowerNum = alaLiveUserInfoData.petalNum;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                } else {
                    LiveFreeTaskLayer.this.aH("", false);
                }
                if (auVar != null) {
                    LiveFreeTaskLayer.this.iiY.setData(auVar.aPq);
                }
                LiveFreeTaskLayer.this.cpi();
            }

            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0701a
            public void aJ(int i2, String str) {
                LiveFreeTaskLayer.this.byj.reset();
                LiveFreeTaskLayer.this.byj.setTitle(a.h.ala_task_empty_msg);
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    LiveFreeTaskLayer.this.byj.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
                } else {
                    LiveFreeTaskLayer.this.byj.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LiveFreeTaskLayer.this.bER();
                        }
                    });
                    LiveFreeTaskLayer.this.byj.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
                }
                LiveFreeTaskLayer.this.byj.setVisibility(0);
                if (i2 != 146021) {
                    if (LiveFreeTaskLayer.this.iiX.cpm() != null && ListUtils.getCount(LiveFreeTaskLayer.this.iiX.cpm().aPq) > 0) {
                        BdUtilHelper.showToast(LiveFreeTaskLayer.this.getContext(), str);
                        return;
                    }
                    return;
                }
                LiveFreeTaskLayer.this.cpj();
            }
        };
        this.ijl = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    LiveFreeTaskLayer.this.iiY.o((Integer) customResponsedMessage.getData());
                }
            }
        };
        this.ijm = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (view == LiveFreeTaskLayer.this.ijd) {
                        if (LiveFreeTaskLayer.this.ije) {
                            LiveFreeTaskLayer.this.hideTip();
                            return true;
                        }
                        return true;
                    }
                    LiveFreeTaskLayer.this.cpk();
                    return true;
                }
                return true;
            }
        };
        this.onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == LiveFreeTaskLayer.this.ija) {
                    if (LiveFreeTaskLayer.this.ije) {
                        LiveFreeTaskLayer.this.hideTip();
                    } else {
                        LiveFreeTaskLayer.this.cpl();
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = View.inflate(getContext(), a.g.ala_task_list_layout, this);
        this.ijd = (LinearLayout) this.mRootView.findViewById(a.f.layout_content);
        this.iiZ = (TextView) this.mRootView.findViewById(a.f.tv_flower_task_title);
        this.ija = (ImageView) this.mRootView.findViewById(a.f.img_flower_help);
        this.ghb = this.mRootView.findViewById(a.f.divider);
        this.ijb = (TextView) this.mRootView.findViewById(a.f.tv_flower_count);
        this.ijc = (TextView) this.mRootView.findViewById(a.f.tv_task_help_tips);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.detail_list);
        this.byj = (CommonEmptyView) this.mRootView.findViewById(a.f.emptyView);
        this.iiY = new b(getContext(), new com.baidu.tieba.ala.tasklist.a.a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.1
            @Override // com.baidu.tieba.ala.tasklist.a.a
            public void wB(int i) {
                if (LiveFreeTaskLayer.this.iiX != null) {
                    LiveFreeTaskLayer.this.iiX.wB(i);
                }
            }
        });
        this.mListView.setAdapter((ListAdapter) this.iiY);
        this.mListView.setEmptyView(this.byj);
        this.mRootView.setOnTouchListener(this.ijm);
        this.ijd.setOnTouchListener(this.ijm);
        this.ija.setOnClickListener(this.onClickListener);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
        if (screenDimensions[1] > screenDimensions[0]) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ijd.getLayoutParams();
            layoutParams.height = (int) (screenDimensions[1] * 0.618d);
            this.ijd.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void AZ() {
        this.iiX = new com.baidu.tieba.ala.tasklist.model.a();
        this.iiX.a(this.ijk);
        MessageManager.getInstance().registerListener(this.ijl);
        bER();
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Ba() {
        if (this.iiX != null) {
            this.iiX.onDestroy();
            this.iiX = null;
        }
        MessageManager.getInstance().unRegisterListener(this.ijl);
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Bb() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Bc() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void release() {
        super.release();
        if (this.iiX != null) {
            this.iiX.onDestroy();
            this.iiX = null;
        }
        if (this.ijj != null && this.ijj.isShowing()) {
            this.ijj.dismiss();
            this.ijj = null;
        }
        if (this.iji != null && this.iji.isShowing()) {
            this.iji.dismiss();
            this.iji = null;
        }
        MessageManager.getInstance().unRegisterListener(this.ijl);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            if (this.ijj != null && this.ijj.isShowing()) {
                this.ijj.dismiss();
                this.ijj = null;
            }
            if (this.iji != null && this.iji.isShowing()) {
                this.iji.dismiss();
                this.iji = null;
            }
            com.baidu.live.core.layer.b.Bf().e(this);
        }
    }

    public void setIsFromFlowerGuide(boolean z) {
        this.ijf = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bER() {
        this.byj.setVisibility(8);
        this.iiX.cpp();
    }

    private void wB(int i) {
        this.iiX.wB(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpi() {
        at Cv;
        if (this.ijf && this.ijg < 3 && (Cv = this.iiY.Cv()) != null) {
            if (Cv.status == 2) {
                wB(Cv.aPi);
                this.ijg++;
                this.ijh = true;
                return;
            }
            this.ijf = false;
            if (this.ijh) {
                this.ijh = false;
                wC(Cv.aPn);
            }
        }
    }

    private void wC(int i) {
        if (this.ijj != null && this.ijj.isShowing()) {
            this.ijj.dismiss();
        }
        this.ijj = null;
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.dialog_flower_guide_result, (ViewGroup) null);
        this.ijj = new Dialog(this.mContext, a.i.FlowerGuideResultDialogStyle);
        this.ijj.requestWindowFeature(1);
        this.ijj.setCancelable(false);
        this.ijj.setContentView(inflate);
        this.ijj.setCanceledOnTouchOutside(false);
        ((TextView) inflate.findViewById(a.f.flowerNum_textView)).setText(String.format("恭喜获得%s鲜花", Integer.valueOf(i)));
        ((ImageView) inflate.findViewById(a.f.close_imageView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    LiveFreeTaskLayer.this.ijj.dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((TextView) inflate.findViewById(a.f.toGift_textView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    LiveFreeTaskLayer.this.ijj.dismiss();
                    LiveFreeTaskLayer.this.bTJ();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.ijj.show();
    }

    public void cpj() {
        ColorStateList colorStateList;
        if (this.iji != null && this.iji.isShowing()) {
            this.iji.dismiss();
        }
        this.iji = null;
        this.iji = new AlertDialog.Builder(this.mContext, a.i.sdk_dialog_window).create();
        this.iji.show();
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.ala_flower_over_limit_dialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(a.f.tv_task_failed_content)).setText(getFlowerOverLimitContent());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LiveFreeTaskLayer.this.iji.dismiss();
            }
        });
        inflate.findViewById(a.f.close_img).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LiveFreeTaskLayer.this.iji.dismiss();
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
                LiveFreeTaskLayer.this.iji.dismiss();
                LiveFreeTaskLayer.this.bTJ();
            }
        });
        Window window = this.iji.getWindow();
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
    public void bTJ() {
        cq cqVar;
        com.baidu.live.core.layer.b.Bf().e(this);
        int i = -1;
        bv bvVar = com.baidu.live.ae.a.Qm().bCs;
        if (bvVar != null && bvVar.aRm != null && (cqVar = bvVar.aRm.aST) != null) {
            i = cqVar.aTi;
        }
        ao aoVar = new ao();
        aoVar.aLw = i;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aoVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpk() {
        com.baidu.live.core.layer.b.Bf().e(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(String str, boolean z) {
        this.ijb.setVisibility(z ? 0 : 8);
        this.ijb.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpl() {
        this.ije = true;
        this.ghb.setVisibility(8);
        this.ijc.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTip() {
        this.ije = false;
        this.ghb.setVisibility(0);
        this.ijc.setVisibility(8);
    }
}
