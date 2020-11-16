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
    private CommonEmptyView bnY;
    private View fPU;
    private View.OnClickListener fhp;
    private TextView hJA;
    private TextView hJB;
    private LinearLayout hJC;
    private boolean hJD;
    private boolean hJE;
    private int hJF;
    private boolean hJG;
    private AlertDialog hJH;
    private Dialog hJI;
    private a.InterfaceC0705a hJJ;
    private CustomMessageListener hJK;
    private View.OnTouchListener hJL;
    private a hJw;
    private b hJx;
    private TextView hJy;
    private ImageView hJz;
    private Context mContext;
    private BdListView mListView;
    private View mRootView;

    public LiveFreeTaskLayer(@NonNull Context context) {
        super(context);
        this.hJD = false;
        this.hJJ = new a.InterfaceC0705a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5
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
                    LiveFreeTaskLayer.this.hJx.setData(anVar.aMd);
                }
                LiveFreeTaskLayer.this.cky();
            }

            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0705a
            public void aC(int i, String str) {
                LiveFreeTaskLayer.this.bnY.reset();
                LiveFreeTaskLayer.this.bnY.setTitle(a.h.ala_task_empty_msg);
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    LiveFreeTaskLayer.this.bnY.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
                } else {
                    LiveFreeTaskLayer.this.bnY.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LiveFreeTaskLayer.this.bCq();
                        }
                    });
                    LiveFreeTaskLayer.this.bnY.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
                }
                LiveFreeTaskLayer.this.bnY.setVisibility(0);
                if (i != 146021) {
                    if (LiveFreeTaskLayer.this.hJw.ckC() != null && ListUtils.getCount(LiveFreeTaskLayer.this.hJw.ckC().aMd) > 0) {
                        BdUtilHelper.showToast(LiveFreeTaskLayer.this.getContext(), str);
                        return;
                    }
                    return;
                }
                LiveFreeTaskLayer.this.ckz();
            }
        };
        this.hJK = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    LiveFreeTaskLayer.this.hJx.m((Integer) customResponsedMessage.getData());
                }
            }
        };
        this.hJL = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (view == LiveFreeTaskLayer.this.hJC) {
                        if (LiveFreeTaskLayer.this.hJD) {
                            LiveFreeTaskLayer.this.hideTip();
                            return true;
                        }
                        return true;
                    }
                    LiveFreeTaskLayer.this.ckA();
                    return true;
                }
                return true;
            }
        };
        this.fhp = new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == LiveFreeTaskLayer.this.hJz) {
                    if (LiveFreeTaskLayer.this.hJD) {
                        LiveFreeTaskLayer.this.hideTip();
                    } else {
                        LiveFreeTaskLayer.this.ckB();
                    }
                }
            }
        };
        init(context);
    }

    public LiveFreeTaskLayer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hJD = false;
        this.hJJ = new a.InterfaceC0705a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5
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
                    LiveFreeTaskLayer.this.hJx.setData(anVar.aMd);
                }
                LiveFreeTaskLayer.this.cky();
            }

            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0705a
            public void aC(int i, String str) {
                LiveFreeTaskLayer.this.bnY.reset();
                LiveFreeTaskLayer.this.bnY.setTitle(a.h.ala_task_empty_msg);
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    LiveFreeTaskLayer.this.bnY.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
                } else {
                    LiveFreeTaskLayer.this.bnY.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LiveFreeTaskLayer.this.bCq();
                        }
                    });
                    LiveFreeTaskLayer.this.bnY.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
                }
                LiveFreeTaskLayer.this.bnY.setVisibility(0);
                if (i != 146021) {
                    if (LiveFreeTaskLayer.this.hJw.ckC() != null && ListUtils.getCount(LiveFreeTaskLayer.this.hJw.ckC().aMd) > 0) {
                        BdUtilHelper.showToast(LiveFreeTaskLayer.this.getContext(), str);
                        return;
                    }
                    return;
                }
                LiveFreeTaskLayer.this.ckz();
            }
        };
        this.hJK = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    LiveFreeTaskLayer.this.hJx.m((Integer) customResponsedMessage.getData());
                }
            }
        };
        this.hJL = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (view == LiveFreeTaskLayer.this.hJC) {
                        if (LiveFreeTaskLayer.this.hJD) {
                            LiveFreeTaskLayer.this.hideTip();
                            return true;
                        }
                        return true;
                    }
                    LiveFreeTaskLayer.this.ckA();
                    return true;
                }
                return true;
            }
        };
        this.fhp = new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == LiveFreeTaskLayer.this.hJz) {
                    if (LiveFreeTaskLayer.this.hJD) {
                        LiveFreeTaskLayer.this.hideTip();
                    } else {
                        LiveFreeTaskLayer.this.ckB();
                    }
                }
            }
        };
        init(context);
    }

    public LiveFreeTaskLayer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hJD = false;
        this.hJJ = new a.InterfaceC0705a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5
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
                    LiveFreeTaskLayer.this.hJx.setData(anVar.aMd);
                }
                LiveFreeTaskLayer.this.cky();
            }

            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0705a
            public void aC(int i2, String str) {
                LiveFreeTaskLayer.this.bnY.reset();
                LiveFreeTaskLayer.this.bnY.setTitle(a.h.ala_task_empty_msg);
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    LiveFreeTaskLayer.this.bnY.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
                } else {
                    LiveFreeTaskLayer.this.bnY.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LiveFreeTaskLayer.this.bCq();
                        }
                    });
                    LiveFreeTaskLayer.this.bnY.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
                }
                LiveFreeTaskLayer.this.bnY.setVisibility(0);
                if (i2 != 146021) {
                    if (LiveFreeTaskLayer.this.hJw.ckC() != null && ListUtils.getCount(LiveFreeTaskLayer.this.hJw.ckC().aMd) > 0) {
                        BdUtilHelper.showToast(LiveFreeTaskLayer.this.getContext(), str);
                        return;
                    }
                    return;
                }
                LiveFreeTaskLayer.this.ckz();
            }
        };
        this.hJK = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    LiveFreeTaskLayer.this.hJx.m((Integer) customResponsedMessage.getData());
                }
            }
        };
        this.hJL = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (view == LiveFreeTaskLayer.this.hJC) {
                        if (LiveFreeTaskLayer.this.hJD) {
                            LiveFreeTaskLayer.this.hideTip();
                            return true;
                        }
                        return true;
                    }
                    LiveFreeTaskLayer.this.ckA();
                    return true;
                }
                return true;
            }
        };
        this.fhp = new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == LiveFreeTaskLayer.this.hJz) {
                    if (LiveFreeTaskLayer.this.hJD) {
                        LiveFreeTaskLayer.this.hideTip();
                    } else {
                        LiveFreeTaskLayer.this.ckB();
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = View.inflate(getContext(), a.g.ala_task_list_layout, this);
        this.hJC = (LinearLayout) this.mRootView.findViewById(a.f.layout_content);
        this.hJy = (TextView) this.mRootView.findViewById(a.f.tv_flower_task_title);
        this.hJz = (ImageView) this.mRootView.findViewById(a.f.img_flower_help);
        this.fPU = this.mRootView.findViewById(a.f.divider);
        this.hJA = (TextView) this.mRootView.findViewById(a.f.tv_flower_count);
        this.hJB = (TextView) this.mRootView.findViewById(a.f.tv_task_help_tips);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.detail_list);
        this.bnY = (CommonEmptyView) this.mRootView.findViewById(a.f.emptyView);
        this.hJx = new b(getContext(), new com.baidu.tieba.ala.tasklist.a.a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.1
            @Override // com.baidu.tieba.ala.tasklist.a.a
            public void xc(int i) {
                if (LiveFreeTaskLayer.this.hJw != null) {
                    LiveFreeTaskLayer.this.hJw.xc(i);
                }
            }
        });
        this.mListView.setAdapter((ListAdapter) this.hJx);
        this.mListView.setEmptyView(this.bnY);
        this.mRootView.setOnTouchListener(this.hJL);
        this.hJC.setOnTouchListener(this.hJL);
        this.hJz.setOnClickListener(this.fhp);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
        if (screenDimensions[1] > screenDimensions[0]) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hJC.getLayoutParams();
            layoutParams.height = (int) (screenDimensions[1] * 0.618d);
            this.hJC.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Di() {
        this.hJw = new com.baidu.tieba.ala.tasklist.model.a();
        this.hJw.a(this.hJJ);
        MessageManager.getInstance().registerListener(this.hJK);
        bCq();
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Dj() {
        if (this.hJw != null) {
            this.hJw.onDestroy();
            this.hJw = null;
        }
        MessageManager.getInstance().unRegisterListener(this.hJK);
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Dk() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Dl() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void release() {
        super.release();
        if (this.hJw != null) {
            this.hJw.onDestroy();
            this.hJw = null;
        }
        if (this.hJI != null && this.hJI.isShowing()) {
            this.hJI.dismiss();
            this.hJI = null;
        }
        if (this.hJH != null && this.hJH.isShowing()) {
            this.hJH.dismiss();
            this.hJH = null;
        }
        MessageManager.getInstance().unRegisterListener(this.hJK);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            if (this.hJI != null && this.hJI.isShowing()) {
                this.hJI.dismiss();
                this.hJI = null;
            }
            if (this.hJH != null && this.hJH.isShowing()) {
                this.hJH.dismiss();
                this.hJH = null;
            }
            com.baidu.live.core.layer.b.Do().e(this);
        }
    }

    public void setIsFromFlowerGuide(boolean z) {
        this.hJE = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCq() {
        this.bnY.setVisibility(8);
        this.hJw.ckF();
    }

    private void xc(int i) {
        this.hJw.xc(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cky() {
        am DZ;
        if (this.hJE && this.hJF < 3 && (DZ = this.hJx.DZ()) != null) {
            if (DZ.status == 2) {
                xc(DZ.aLV);
                this.hJF++;
                this.hJG = true;
                return;
            }
            this.hJE = false;
            if (this.hJG) {
                this.hJG = false;
                xd(DZ.aMa);
            }
        }
    }

    private void xd(int i) {
        if (this.hJI != null && this.hJI.isShowing()) {
            this.hJI.dismiss();
        }
        this.hJI = null;
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.dialog_flower_guide_result, (ViewGroup) null);
        this.hJI = new Dialog(this.mContext, a.i.FlowerGuideResultDialogStyle);
        this.hJI.requestWindowFeature(1);
        this.hJI.setCancelable(false);
        this.hJI.setContentView(inflate);
        this.hJI.setCanceledOnTouchOutside(false);
        ((TextView) inflate.findViewById(a.f.flowerNum_textView)).setText(String.format("恭喜获得%s鲜花", Integer.valueOf(i)));
        ((ImageView) inflate.findViewById(a.f.close_imageView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    LiveFreeTaskLayer.this.hJI.dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((TextView) inflate.findViewById(a.f.toGift_textView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    LiveFreeTaskLayer.this.hJI.dismiss();
                    LiveFreeTaskLayer.this.bQu();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.hJI.show();
    }

    public void ckz() {
        ColorStateList colorStateList;
        if (this.hJH != null && this.hJH.isShowing()) {
            this.hJH.dismiss();
        }
        this.hJH = null;
        this.hJH = new AlertDialog.Builder(this.mContext, a.i.sdk_dialog_window).create();
        this.hJH.show();
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.ala_flower_over_limit_dialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(a.f.tv_task_failed_content)).setText(getFlowerOverLimitContent());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LiveFreeTaskLayer.this.hJH.dismiss();
            }
        });
        inflate.findViewById(a.f.close_img).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LiveFreeTaskLayer.this.hJH.dismiss();
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
                LiveFreeTaskLayer.this.hJH.dismiss();
                LiveFreeTaskLayer.this.bQu();
            }
        });
        Window window = this.hJH.getWindow();
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
    public void bQu() {
        cf cfVar;
        com.baidu.live.core.layer.b.Do().e(this);
        int i = -1;
        bn bnVar = com.baidu.live.aa.a.Ph().bsh;
        if (bnVar != null && bnVar.aNM != null && (cfVar = bnVar.aNM.aPg) != null) {
            i = cfVar.aPt;
        }
        ah ahVar = new ah();
        ahVar.aIH = i;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, ahVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckA() {
        com.baidu.live.core.layer.b.Do().e(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(String str, boolean z) {
        this.hJA.setVisibility(z ? 0 : 8);
        this.hJA.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckB() {
        this.hJD = true;
        this.fPU.setVisibility(8);
        this.hJB.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTip() {
        this.hJD = false;
        this.fPU.setVisibility(0);
        this.hJB.setVisibility(8);
    }
}
