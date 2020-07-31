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
import com.baidu.live.data.ab;
import com.baidu.live.data.ac;
import com.baidu.live.data.bc;
import com.baidu.live.data.bo;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.tieba.ala.tasklist.a.b;
import com.baidu.tieba.ala.tasklist.model.a;
/* loaded from: classes4.dex */
public class LiveFreeTaskLayer extends LayerChildView {
    private CommonEmptyView baQ;
    private View.OnClickListener eve;
    private View fbk;
    private a gMa;
    private b gMb;
    private TextView gMc;
    private ImageView gMd;
    private TextView gMe;
    private TextView gMf;
    private LinearLayout gMg;
    private boolean gMh;
    private boolean gMi;
    private int gMj;
    private boolean gMk;
    private AlertDialog gMl;
    private Dialog gMm;
    private a.InterfaceC0610a gMn;
    private CustomMessageListener gMo;
    private View.OnTouchListener gMp;
    private Context mContext;
    private BdListView mListView;
    private View mRootView;

    public LiveFreeTaskLayer(@NonNull Context context) {
        super(context);
        this.gMh = false;
        this.gMn = new a.InterfaceC0610a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5
            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0610a
            public void a(AlaLiveUserInfoData alaLiveUserInfoData, ac acVar) {
                if (alaLiveUserInfoData != null) {
                    LiveFreeTaskLayer.this.aw(String.valueOf(alaLiveUserInfoData.petalNum), true);
                    TbadkCoreApplication.getInst().currentAccountFlowerNum = alaLiveUserInfoData.petalNum;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                } else {
                    LiveFreeTaskLayer.this.aw("", false);
                }
                if (acVar != null) {
                    LiveFreeTaskLayer.this.gMb.setData(acVar.aCw);
                }
                LiveFreeTaskLayer.this.bPK();
            }

            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0610a
            public void ao(int i, String str) {
                LiveFreeTaskLayer.this.baQ.reset();
                LiveFreeTaskLayer.this.baQ.setTitle(a.i.ala_task_empty_msg);
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    LiveFreeTaskLayer.this.baQ.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
                } else {
                    LiveFreeTaskLayer.this.baQ.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LiveFreeTaskLayer.this.bmd();
                        }
                    });
                    LiveFreeTaskLayer.this.baQ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
                }
                LiveFreeTaskLayer.this.baQ.setVisibility(0);
                if (i != 146021) {
                    if (LiveFreeTaskLayer.this.gMa.bPO() != null && ListUtils.getCount(LiveFreeTaskLayer.this.gMa.bPO().aCw) > 0) {
                        BdUtilHelper.showToast(LiveFreeTaskLayer.this.getContext(), str);
                        return;
                    }
                    return;
                }
                LiveFreeTaskLayer.this.bPL();
            }
        };
        this.gMo = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    LiveFreeTaskLayer.this.gMb.j((Integer) customResponsedMessage.getData());
                }
            }
        };
        this.gMp = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (view == LiveFreeTaskLayer.this.gMg) {
                        if (LiveFreeTaskLayer.this.gMh) {
                            LiveFreeTaskLayer.this.hideTip();
                            return true;
                        }
                        return true;
                    }
                    LiveFreeTaskLayer.this.bPM();
                    return true;
                }
                return true;
            }
        };
        this.eve = new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == LiveFreeTaskLayer.this.gMd) {
                    if (LiveFreeTaskLayer.this.gMh) {
                        LiveFreeTaskLayer.this.hideTip();
                    } else {
                        LiveFreeTaskLayer.this.bPN();
                    }
                }
            }
        };
        init(context);
    }

    public LiveFreeTaskLayer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gMh = false;
        this.gMn = new a.InterfaceC0610a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5
            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0610a
            public void a(AlaLiveUserInfoData alaLiveUserInfoData, ac acVar) {
                if (alaLiveUserInfoData != null) {
                    LiveFreeTaskLayer.this.aw(String.valueOf(alaLiveUserInfoData.petalNum), true);
                    TbadkCoreApplication.getInst().currentAccountFlowerNum = alaLiveUserInfoData.petalNum;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                } else {
                    LiveFreeTaskLayer.this.aw("", false);
                }
                if (acVar != null) {
                    LiveFreeTaskLayer.this.gMb.setData(acVar.aCw);
                }
                LiveFreeTaskLayer.this.bPK();
            }

            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0610a
            public void ao(int i, String str) {
                LiveFreeTaskLayer.this.baQ.reset();
                LiveFreeTaskLayer.this.baQ.setTitle(a.i.ala_task_empty_msg);
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    LiveFreeTaskLayer.this.baQ.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
                } else {
                    LiveFreeTaskLayer.this.baQ.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LiveFreeTaskLayer.this.bmd();
                        }
                    });
                    LiveFreeTaskLayer.this.baQ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
                }
                LiveFreeTaskLayer.this.baQ.setVisibility(0);
                if (i != 146021) {
                    if (LiveFreeTaskLayer.this.gMa.bPO() != null && ListUtils.getCount(LiveFreeTaskLayer.this.gMa.bPO().aCw) > 0) {
                        BdUtilHelper.showToast(LiveFreeTaskLayer.this.getContext(), str);
                        return;
                    }
                    return;
                }
                LiveFreeTaskLayer.this.bPL();
            }
        };
        this.gMo = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    LiveFreeTaskLayer.this.gMb.j((Integer) customResponsedMessage.getData());
                }
            }
        };
        this.gMp = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (view == LiveFreeTaskLayer.this.gMg) {
                        if (LiveFreeTaskLayer.this.gMh) {
                            LiveFreeTaskLayer.this.hideTip();
                            return true;
                        }
                        return true;
                    }
                    LiveFreeTaskLayer.this.bPM();
                    return true;
                }
                return true;
            }
        };
        this.eve = new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == LiveFreeTaskLayer.this.gMd) {
                    if (LiveFreeTaskLayer.this.gMh) {
                        LiveFreeTaskLayer.this.hideTip();
                    } else {
                        LiveFreeTaskLayer.this.bPN();
                    }
                }
            }
        };
        init(context);
    }

    public LiveFreeTaskLayer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gMh = false;
        this.gMn = new a.InterfaceC0610a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5
            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0610a
            public void a(AlaLiveUserInfoData alaLiveUserInfoData, ac acVar) {
                if (alaLiveUserInfoData != null) {
                    LiveFreeTaskLayer.this.aw(String.valueOf(alaLiveUserInfoData.petalNum), true);
                    TbadkCoreApplication.getInst().currentAccountFlowerNum = alaLiveUserInfoData.petalNum;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                } else {
                    LiveFreeTaskLayer.this.aw("", false);
                }
                if (acVar != null) {
                    LiveFreeTaskLayer.this.gMb.setData(acVar.aCw);
                }
                LiveFreeTaskLayer.this.bPK();
            }

            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0610a
            public void ao(int i2, String str) {
                LiveFreeTaskLayer.this.baQ.reset();
                LiveFreeTaskLayer.this.baQ.setTitle(a.i.ala_task_empty_msg);
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    LiveFreeTaskLayer.this.baQ.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
                } else {
                    LiveFreeTaskLayer.this.baQ.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LiveFreeTaskLayer.this.bmd();
                        }
                    });
                    LiveFreeTaskLayer.this.baQ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
                }
                LiveFreeTaskLayer.this.baQ.setVisibility(0);
                if (i2 != 146021) {
                    if (LiveFreeTaskLayer.this.gMa.bPO() != null && ListUtils.getCount(LiveFreeTaskLayer.this.gMa.bPO().aCw) > 0) {
                        BdUtilHelper.showToast(LiveFreeTaskLayer.this.getContext(), str);
                        return;
                    }
                    return;
                }
                LiveFreeTaskLayer.this.bPL();
            }
        };
        this.gMo = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    LiveFreeTaskLayer.this.gMb.j((Integer) customResponsedMessage.getData());
                }
            }
        };
        this.gMp = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (view == LiveFreeTaskLayer.this.gMg) {
                        if (LiveFreeTaskLayer.this.gMh) {
                            LiveFreeTaskLayer.this.hideTip();
                            return true;
                        }
                        return true;
                    }
                    LiveFreeTaskLayer.this.bPM();
                    return true;
                }
                return true;
            }
        };
        this.eve = new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == LiveFreeTaskLayer.this.gMd) {
                    if (LiveFreeTaskLayer.this.gMh) {
                        LiveFreeTaskLayer.this.hideTip();
                    } else {
                        LiveFreeTaskLayer.this.bPN();
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = View.inflate(getContext(), a.h.ala_task_list_layout, this);
        this.gMg = (LinearLayout) this.mRootView.findViewById(a.g.layout_content);
        this.gMc = (TextView) this.mRootView.findViewById(a.g.tv_flower_task_title);
        this.gMd = (ImageView) this.mRootView.findViewById(a.g.img_flower_help);
        this.fbk = this.mRootView.findViewById(a.g.divider);
        this.gMe = (TextView) this.mRootView.findViewById(a.g.tv_flower_count);
        this.gMf = (TextView) this.mRootView.findViewById(a.g.tv_task_help_tips);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.detail_list);
        this.baQ = (CommonEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.gMb = new b(getContext(), new com.baidu.tieba.ala.tasklist.a.a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.1
            @Override // com.baidu.tieba.ala.tasklist.a.a
            public void sK(int i) {
                if (LiveFreeTaskLayer.this.gMa != null) {
                    LiveFreeTaskLayer.this.gMa.sK(i);
                }
            }
        });
        this.mListView.setAdapter((ListAdapter) this.gMb);
        this.mListView.setEmptyView(this.baQ);
        this.mRootView.setOnTouchListener(this.gMp);
        this.gMg.setOnTouchListener(this.gMp);
        this.gMd.setOnClickListener(this.eve);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
        if (screenDimensions[1] > screenDimensions[0]) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gMg.getLayoutParams();
            layoutParams.height = (int) (screenDimensions[1] * 0.618d);
            this.gMg.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void wH() {
        this.gMa = new com.baidu.tieba.ala.tasklist.model.a();
        this.gMa.a(this.gMn);
        MessageManager.getInstance().registerListener(this.gMo);
        bmd();
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void wI() {
        if (this.gMa != null) {
            this.gMa.onDestroy();
            this.gMa = null;
        }
        MessageManager.getInstance().unRegisterListener(this.gMo);
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void wJ() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void wK() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void release() {
        super.release();
        if (this.gMa != null) {
            this.gMa.onDestroy();
            this.gMa = null;
        }
        if (this.gMm != null && this.gMm.isShowing()) {
            this.gMm.dismiss();
            this.gMm = null;
        }
        if (this.gMl != null && this.gMl.isShowing()) {
            this.gMl.dismiss();
            this.gMl = null;
        }
        MessageManager.getInstance().unRegisterListener(this.gMo);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            if (this.gMm != null && this.gMm.isShowing()) {
                this.gMm.dismiss();
                this.gMm = null;
            }
            if (this.gMl != null && this.gMl.isShowing()) {
                this.gMl.dismiss();
                this.gMl = null;
            }
            com.baidu.live.core.layer.b.wN().e(this);
        }
    }

    public void setIsFromFlowerGuide(boolean z) {
        this.gMi = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmd() {
        this.baQ.setVisibility(8);
        this.gMa.bPR();
    }

    private void sK(int i) {
        this.gMa.sK(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPK() {
        ab xn;
        if (this.gMi && this.gMj < 3 && (xn = this.gMb.xn()) != null) {
            if (xn.status == 2) {
                sK(xn.aCo);
                this.gMj++;
                this.gMk = true;
                return;
            }
            this.gMi = false;
            if (this.gMk) {
                this.gMk = false;
                sL(xn.aCt);
            }
        }
    }

    private void sL(int i) {
        if (this.gMm != null && this.gMm.isShowing()) {
            this.gMm.dismiss();
        }
        this.gMm = null;
        View inflate = LayoutInflater.from(this.mContext).inflate(a.h.dialog_flower_guide_result, (ViewGroup) null);
        this.gMm = new Dialog(this.mContext, a.j.FlowerGuideResultDialogStyle);
        this.gMm.requestWindowFeature(1);
        this.gMm.setCancelable(false);
        this.gMm.setContentView(inflate);
        this.gMm.setCanceledOnTouchOutside(false);
        ((TextView) inflate.findViewById(a.g.flowerNum_textView)).setText(String.format("恭喜获得%s鲜花", Integer.valueOf(i)));
        ((ImageView) inflate.findViewById(a.g.close_imageView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    LiveFreeTaskLayer.this.gMm.dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((TextView) inflate.findViewById(a.g.toGift_textView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    LiveFreeTaskLayer.this.gMm.dismiss();
                    LiveFreeTaskLayer.this.bzd();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.gMm.show();
    }

    public void bPL() {
        ColorStateList colorStateList;
        if (this.gMl != null && this.gMl.isShowing()) {
            this.gMl.dismiss();
        }
        this.gMl = null;
        this.gMl = new AlertDialog.Builder(this.mContext, a.j.sdk_dialog_window).create();
        this.gMl.show();
        View inflate = LayoutInflater.from(this.mContext).inflate(a.h.ala_flower_over_limit_dialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(a.g.tv_task_failed_content)).setText(getFlowerOverLimitContent());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LiveFreeTaskLayer.this.gMl.dismiss();
            }
        });
        inflate.findViewById(a.g.close_img).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LiveFreeTaskLayer.this.gMl.dismiss();
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
                LiveFreeTaskLayer.this.gMl.dismiss();
                LiveFreeTaskLayer.this.bzd();
            }
        });
        Window window = this.gMl.getWindow();
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
    public void bzd() {
        bo boVar;
        com.baidu.live.core.layer.b.wN().e(this);
        int i = -1;
        bc bcVar = com.baidu.live.v.a.Hs().beo;
        if (bcVar != null && bcVar.aEo != null && (boVar = bcVar.aEo.aFj) != null) {
            i = boVar.aFu;
        }
        w wVar = new w();
        wVar.azo = i;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, wVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPM() {
        com.baidu.live.core.layer.b.wN().e(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aw(String str, boolean z) {
        this.gMe.setVisibility(z ? 0 : 8);
        this.gMe.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPN() {
        this.gMh = true;
        this.fbk.setVisibility(8);
        this.gMf.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTip() {
        this.gMh = false;
        this.fbk.setVisibility(0);
        this.gMf.setVisibility(8);
    }
}
