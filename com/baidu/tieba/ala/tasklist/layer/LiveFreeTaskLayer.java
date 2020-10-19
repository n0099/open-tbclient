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
    private CommonEmptyView bmS;
    private View.OnClickListener eTU;
    private View fCa;
    private a hrY;
    private b hrZ;
    private TextView hsa;
    private ImageView hsb;
    private TextView hsc;
    private TextView hsd;
    private LinearLayout hse;
    private boolean hsf;
    private boolean hsg;
    private int hsh;
    private boolean hsi;
    private AlertDialog hsj;
    private Dialog hsk;
    private a.InterfaceC0675a hsl;
    private CustomMessageListener hsm;
    private View.OnTouchListener hsn;
    private Context mContext;
    private BdListView mListView;
    private View mRootView;

    public LiveFreeTaskLayer(@NonNull Context context) {
        super(context);
        this.hsf = false;
        this.hsl = new a.InterfaceC0675a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5
            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0675a
            public void a(AlaLiveUserInfoData alaLiveUserInfoData, aj ajVar) {
                if (alaLiveUserInfoData != null) {
                    LiveFreeTaskLayer.this.aE(String.valueOf(alaLiveUserInfoData.petalNum), true);
                    TbadkCoreApplication.getInst().currentAccountFlowerNum = alaLiveUserInfoData.petalNum;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                } else {
                    LiveFreeTaskLayer.this.aE("", false);
                }
                if (ajVar != null) {
                    LiveFreeTaskLayer.this.hrZ.setData(ajVar.aMh);
                }
                LiveFreeTaskLayer.this.cfC();
            }

            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0675a
            public void ay(int i, String str) {
                LiveFreeTaskLayer.this.bmS.reset();
                LiveFreeTaskLayer.this.bmS.setTitle(a.i.ala_task_empty_msg);
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    LiveFreeTaskLayer.this.bmS.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
                } else {
                    LiveFreeTaskLayer.this.bmS.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LiveFreeTaskLayer.this.byF();
                        }
                    });
                    LiveFreeTaskLayer.this.bmS.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
                }
                LiveFreeTaskLayer.this.bmS.setVisibility(0);
                if (i != 146021) {
                    if (LiveFreeTaskLayer.this.hrY.cfG() != null && ListUtils.getCount(LiveFreeTaskLayer.this.hrY.cfG().aMh) > 0) {
                        BdUtilHelper.showToast(LiveFreeTaskLayer.this.getContext(), str);
                        return;
                    }
                    return;
                }
                LiveFreeTaskLayer.this.cfD();
            }
        };
        this.hsm = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    LiveFreeTaskLayer.this.hrZ.m((Integer) customResponsedMessage.getData());
                }
            }
        };
        this.hsn = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (view == LiveFreeTaskLayer.this.hse) {
                        if (LiveFreeTaskLayer.this.hsf) {
                            LiveFreeTaskLayer.this.hideTip();
                            return true;
                        }
                        return true;
                    }
                    LiveFreeTaskLayer.this.cfE();
                    return true;
                }
                return true;
            }
        };
        this.eTU = new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == LiveFreeTaskLayer.this.hsb) {
                    if (LiveFreeTaskLayer.this.hsf) {
                        LiveFreeTaskLayer.this.hideTip();
                    } else {
                        LiveFreeTaskLayer.this.cfF();
                    }
                }
            }
        };
        init(context);
    }

    public LiveFreeTaskLayer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hsf = false;
        this.hsl = new a.InterfaceC0675a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5
            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0675a
            public void a(AlaLiveUserInfoData alaLiveUserInfoData, aj ajVar) {
                if (alaLiveUserInfoData != null) {
                    LiveFreeTaskLayer.this.aE(String.valueOf(alaLiveUserInfoData.petalNum), true);
                    TbadkCoreApplication.getInst().currentAccountFlowerNum = alaLiveUserInfoData.petalNum;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                } else {
                    LiveFreeTaskLayer.this.aE("", false);
                }
                if (ajVar != null) {
                    LiveFreeTaskLayer.this.hrZ.setData(ajVar.aMh);
                }
                LiveFreeTaskLayer.this.cfC();
            }

            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0675a
            public void ay(int i, String str) {
                LiveFreeTaskLayer.this.bmS.reset();
                LiveFreeTaskLayer.this.bmS.setTitle(a.i.ala_task_empty_msg);
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    LiveFreeTaskLayer.this.bmS.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
                } else {
                    LiveFreeTaskLayer.this.bmS.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LiveFreeTaskLayer.this.byF();
                        }
                    });
                    LiveFreeTaskLayer.this.bmS.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
                }
                LiveFreeTaskLayer.this.bmS.setVisibility(0);
                if (i != 146021) {
                    if (LiveFreeTaskLayer.this.hrY.cfG() != null && ListUtils.getCount(LiveFreeTaskLayer.this.hrY.cfG().aMh) > 0) {
                        BdUtilHelper.showToast(LiveFreeTaskLayer.this.getContext(), str);
                        return;
                    }
                    return;
                }
                LiveFreeTaskLayer.this.cfD();
            }
        };
        this.hsm = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    LiveFreeTaskLayer.this.hrZ.m((Integer) customResponsedMessage.getData());
                }
            }
        };
        this.hsn = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (view == LiveFreeTaskLayer.this.hse) {
                        if (LiveFreeTaskLayer.this.hsf) {
                            LiveFreeTaskLayer.this.hideTip();
                            return true;
                        }
                        return true;
                    }
                    LiveFreeTaskLayer.this.cfE();
                    return true;
                }
                return true;
            }
        };
        this.eTU = new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == LiveFreeTaskLayer.this.hsb) {
                    if (LiveFreeTaskLayer.this.hsf) {
                        LiveFreeTaskLayer.this.hideTip();
                    } else {
                        LiveFreeTaskLayer.this.cfF();
                    }
                }
            }
        };
        init(context);
    }

    public LiveFreeTaskLayer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hsf = false;
        this.hsl = new a.InterfaceC0675a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5
            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0675a
            public void a(AlaLiveUserInfoData alaLiveUserInfoData, aj ajVar) {
                if (alaLiveUserInfoData != null) {
                    LiveFreeTaskLayer.this.aE(String.valueOf(alaLiveUserInfoData.petalNum), true);
                    TbadkCoreApplication.getInst().currentAccountFlowerNum = alaLiveUserInfoData.petalNum;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                } else {
                    LiveFreeTaskLayer.this.aE("", false);
                }
                if (ajVar != null) {
                    LiveFreeTaskLayer.this.hrZ.setData(ajVar.aMh);
                }
                LiveFreeTaskLayer.this.cfC();
            }

            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0675a
            public void ay(int i2, String str) {
                LiveFreeTaskLayer.this.bmS.reset();
                LiveFreeTaskLayer.this.bmS.setTitle(a.i.ala_task_empty_msg);
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    LiveFreeTaskLayer.this.bmS.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
                } else {
                    LiveFreeTaskLayer.this.bmS.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LiveFreeTaskLayer.this.byF();
                        }
                    });
                    LiveFreeTaskLayer.this.bmS.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
                }
                LiveFreeTaskLayer.this.bmS.setVisibility(0);
                if (i2 != 146021) {
                    if (LiveFreeTaskLayer.this.hrY.cfG() != null && ListUtils.getCount(LiveFreeTaskLayer.this.hrY.cfG().aMh) > 0) {
                        BdUtilHelper.showToast(LiveFreeTaskLayer.this.getContext(), str);
                        return;
                    }
                    return;
                }
                LiveFreeTaskLayer.this.cfD();
            }
        };
        this.hsm = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    LiveFreeTaskLayer.this.hrZ.m((Integer) customResponsedMessage.getData());
                }
            }
        };
        this.hsn = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (view == LiveFreeTaskLayer.this.hse) {
                        if (LiveFreeTaskLayer.this.hsf) {
                            LiveFreeTaskLayer.this.hideTip();
                            return true;
                        }
                        return true;
                    }
                    LiveFreeTaskLayer.this.cfE();
                    return true;
                }
                return true;
            }
        };
        this.eTU = new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == LiveFreeTaskLayer.this.hsb) {
                    if (LiveFreeTaskLayer.this.hsf) {
                        LiveFreeTaskLayer.this.hideTip();
                    } else {
                        LiveFreeTaskLayer.this.cfF();
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = View.inflate(getContext(), a.h.ala_task_list_layout, this);
        this.hse = (LinearLayout) this.mRootView.findViewById(a.g.layout_content);
        this.hsa = (TextView) this.mRootView.findViewById(a.g.tv_flower_task_title);
        this.hsb = (ImageView) this.mRootView.findViewById(a.g.img_flower_help);
        this.fCa = this.mRootView.findViewById(a.g.divider);
        this.hsc = (TextView) this.mRootView.findViewById(a.g.tv_flower_count);
        this.hsd = (TextView) this.mRootView.findViewById(a.g.tv_task_help_tips);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.detail_list);
        this.bmS = (CommonEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.hrZ = new b(getContext(), new com.baidu.tieba.ala.tasklist.a.a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.1
            @Override // com.baidu.tieba.ala.tasklist.a.a
            public void vX(int i) {
                if (LiveFreeTaskLayer.this.hrY != null) {
                    LiveFreeTaskLayer.this.hrY.vX(i);
                }
            }
        });
        this.mListView.setAdapter((ListAdapter) this.hrZ);
        this.mListView.setEmptyView(this.bmS);
        this.mRootView.setOnTouchListener(this.hsn);
        this.hse.setOnTouchListener(this.hsn);
        this.hsb.setOnClickListener(this.eTU);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
        if (screenDimensions[1] > screenDimensions[0]) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hse.getLayoutParams();
            layoutParams.height = (int) (screenDimensions[1] * 0.618d);
            this.hse.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Dr() {
        this.hrY = new com.baidu.tieba.ala.tasklist.model.a();
        this.hrY.a(this.hsl);
        MessageManager.getInstance().registerListener(this.hsm);
        byF();
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Ds() {
        if (this.hrY != null) {
            this.hrY.onDestroy();
            this.hrY = null;
        }
        MessageManager.getInstance().unRegisterListener(this.hsm);
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Dt() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Du() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void release() {
        super.release();
        if (this.hrY != null) {
            this.hrY.onDestroy();
            this.hrY = null;
        }
        if (this.hsk != null && this.hsk.isShowing()) {
            this.hsk.dismiss();
            this.hsk = null;
        }
        if (this.hsj != null && this.hsj.isShowing()) {
            this.hsj.dismiss();
            this.hsj = null;
        }
        MessageManager.getInstance().unRegisterListener(this.hsm);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            if (this.hsk != null && this.hsk.isShowing()) {
                this.hsk.dismiss();
                this.hsk = null;
            }
            if (this.hsj != null && this.hsj.isShowing()) {
                this.hsj.dismiss();
                this.hsj = null;
            }
            com.baidu.live.core.layer.b.Dx().e(this);
        }
    }

    public void setIsFromFlowerGuide(boolean z) {
        this.hsg = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byF() {
        this.bmS.setVisibility(8);
        this.hrY.cfJ();
    }

    private void vX(int i) {
        this.hrY.vX(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfC() {
        ai Ed;
        if (this.hsg && this.hsh < 3 && (Ed = this.hrZ.Ed()) != null) {
            if (Ed.status == 2) {
                vX(Ed.aLZ);
                this.hsh++;
                this.hsi = true;
                return;
            }
            this.hsg = false;
            if (this.hsi) {
                this.hsi = false;
                vY(Ed.aMe);
            }
        }
    }

    private void vY(int i) {
        if (this.hsk != null && this.hsk.isShowing()) {
            this.hsk.dismiss();
        }
        this.hsk = null;
        View inflate = LayoutInflater.from(this.mContext).inflate(a.h.dialog_flower_guide_result, (ViewGroup) null);
        this.hsk = new Dialog(this.mContext, a.j.FlowerGuideResultDialogStyle);
        this.hsk.requestWindowFeature(1);
        this.hsk.setCancelable(false);
        this.hsk.setContentView(inflate);
        this.hsk.setCanceledOnTouchOutside(false);
        ((TextView) inflate.findViewById(a.g.flowerNum_textView)).setText(String.format("恭喜获得%s鲜花", Integer.valueOf(i)));
        ((ImageView) inflate.findViewById(a.g.close_imageView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    LiveFreeTaskLayer.this.hsk.dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((TextView) inflate.findViewById(a.g.toGift_textView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    LiveFreeTaskLayer.this.hsk.dismiss();
                    LiveFreeTaskLayer.this.bLZ();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.hsk.show();
    }

    public void cfD() {
        ColorStateList colorStateList;
        if (this.hsj != null && this.hsj.isShowing()) {
            this.hsj.dismiss();
        }
        this.hsj = null;
        this.hsj = new AlertDialog.Builder(this.mContext, a.j.sdk_dialog_window).create();
        this.hsj.show();
        View inflate = LayoutInflater.from(this.mContext).inflate(a.h.ala_flower_over_limit_dialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(a.g.tv_task_failed_content)).setText(getFlowerOverLimitContent());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LiveFreeTaskLayer.this.hsj.dismiss();
            }
        });
        inflate.findViewById(a.g.close_img).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LiveFreeTaskLayer.this.hsj.dismiss();
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
                LiveFreeTaskLayer.this.hsj.dismiss();
                LiveFreeTaskLayer.this.bLZ();
            }
        });
        Window window = this.hsj.getWindow();
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
    public void bLZ() {
        by byVar;
        com.baidu.live.core.layer.b.Dx().e(this);
        int i = -1;
        bj bjVar = com.baidu.live.x.a.OS().bqJ;
        if (bjVar != null && bjVar.aNV != null && (byVar = bjVar.aNV.aPf) != null) {
            i = byVar.aPs;
        }
        ad adVar = new ad();
        adVar.aIQ = i;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, adVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfE() {
        com.baidu.live.core.layer.b.Dx().e(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(String str, boolean z) {
        this.hsc.setVisibility(z ? 0 : 8);
        this.hsc.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfF() {
        this.hsf = true;
        this.fCa.setVisibility(8);
        this.hsd.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTip() {
        this.hsf = false;
        this.fCa.setVisibility(0);
        this.hsd.setVisibility(8);
    }
}
