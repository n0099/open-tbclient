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
import com.baidu.live.data.ae;
import com.baidu.live.data.be;
import com.baidu.live.data.bq;
import com.baidu.live.data.y;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.tieba.ala.tasklist.a.b;
import com.baidu.tieba.ala.tasklist.model.a;
/* loaded from: classes7.dex */
public class LiveFreeTaskLayer extends LayerChildView {
    private CommonEmptyView bgl;
    private View.OnClickListener eFC;
    private View fmE;
    private a gYR;
    private b gYS;
    private TextView gYT;
    private ImageView gYU;
    private TextView gYV;
    private TextView gYW;
    private LinearLayout gYX;
    private boolean gYY;
    private boolean gYZ;
    private int gZa;
    private boolean gZb;
    private AlertDialog gZc;
    private Dialog gZd;
    private a.InterfaceC0660a gZe;
    private CustomMessageListener gZf;
    private View.OnTouchListener gZg;
    private Context mContext;
    private BdListView mListView;
    private View mRootView;

    public LiveFreeTaskLayer(@NonNull Context context) {
        super(context);
        this.gYY = false;
        this.gZe = new a.InterfaceC0660a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5
            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0660a
            public void a(AlaLiveUserInfoData alaLiveUserInfoData, ae aeVar) {
                if (alaLiveUserInfoData != null) {
                    LiveFreeTaskLayer.this.aA(String.valueOf(alaLiveUserInfoData.petalNum), true);
                    TbadkCoreApplication.getInst().currentAccountFlowerNum = alaLiveUserInfoData.petalNum;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                } else {
                    LiveFreeTaskLayer.this.aA("", false);
                }
                if (aeVar != null) {
                    LiveFreeTaskLayer.this.gYS.setData(aeVar.aHG);
                }
                LiveFreeTaskLayer.this.bZV();
            }

            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0660a
            public void am(int i, String str) {
                LiveFreeTaskLayer.this.bgl.reset();
                LiveFreeTaskLayer.this.bgl.setTitle(a.i.ala_task_empty_msg);
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    LiveFreeTaskLayer.this.bgl.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
                } else {
                    LiveFreeTaskLayer.this.bgl.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LiveFreeTaskLayer.this.buQ();
                        }
                    });
                    LiveFreeTaskLayer.this.bgl.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
                }
                LiveFreeTaskLayer.this.bgl.setVisibility(0);
                if (i != 146021) {
                    if (LiveFreeTaskLayer.this.gYR.bZZ() != null && ListUtils.getCount(LiveFreeTaskLayer.this.gYR.bZZ().aHG) > 0) {
                        BdUtilHelper.showToast(LiveFreeTaskLayer.this.getContext(), str);
                        return;
                    }
                    return;
                }
                LiveFreeTaskLayer.this.bZW();
            }
        };
        this.gZf = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    LiveFreeTaskLayer.this.gYS.k((Integer) customResponsedMessage.getData());
                }
            }
        };
        this.gZg = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (view == LiveFreeTaskLayer.this.gYX) {
                        if (LiveFreeTaskLayer.this.gYY) {
                            LiveFreeTaskLayer.this.hideTip();
                            return true;
                        }
                        return true;
                    }
                    LiveFreeTaskLayer.this.bZX();
                    return true;
                }
                return true;
            }
        };
        this.eFC = new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == LiveFreeTaskLayer.this.gYU) {
                    if (LiveFreeTaskLayer.this.gYY) {
                        LiveFreeTaskLayer.this.hideTip();
                    } else {
                        LiveFreeTaskLayer.this.bZY();
                    }
                }
            }
        };
        init(context);
    }

    public LiveFreeTaskLayer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gYY = false;
        this.gZe = new a.InterfaceC0660a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5
            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0660a
            public void a(AlaLiveUserInfoData alaLiveUserInfoData, ae aeVar) {
                if (alaLiveUserInfoData != null) {
                    LiveFreeTaskLayer.this.aA(String.valueOf(alaLiveUserInfoData.petalNum), true);
                    TbadkCoreApplication.getInst().currentAccountFlowerNum = alaLiveUserInfoData.petalNum;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                } else {
                    LiveFreeTaskLayer.this.aA("", false);
                }
                if (aeVar != null) {
                    LiveFreeTaskLayer.this.gYS.setData(aeVar.aHG);
                }
                LiveFreeTaskLayer.this.bZV();
            }

            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0660a
            public void am(int i, String str) {
                LiveFreeTaskLayer.this.bgl.reset();
                LiveFreeTaskLayer.this.bgl.setTitle(a.i.ala_task_empty_msg);
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    LiveFreeTaskLayer.this.bgl.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
                } else {
                    LiveFreeTaskLayer.this.bgl.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LiveFreeTaskLayer.this.buQ();
                        }
                    });
                    LiveFreeTaskLayer.this.bgl.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
                }
                LiveFreeTaskLayer.this.bgl.setVisibility(0);
                if (i != 146021) {
                    if (LiveFreeTaskLayer.this.gYR.bZZ() != null && ListUtils.getCount(LiveFreeTaskLayer.this.gYR.bZZ().aHG) > 0) {
                        BdUtilHelper.showToast(LiveFreeTaskLayer.this.getContext(), str);
                        return;
                    }
                    return;
                }
                LiveFreeTaskLayer.this.bZW();
            }
        };
        this.gZf = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    LiveFreeTaskLayer.this.gYS.k((Integer) customResponsedMessage.getData());
                }
            }
        };
        this.gZg = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (view == LiveFreeTaskLayer.this.gYX) {
                        if (LiveFreeTaskLayer.this.gYY) {
                            LiveFreeTaskLayer.this.hideTip();
                            return true;
                        }
                        return true;
                    }
                    LiveFreeTaskLayer.this.bZX();
                    return true;
                }
                return true;
            }
        };
        this.eFC = new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == LiveFreeTaskLayer.this.gYU) {
                    if (LiveFreeTaskLayer.this.gYY) {
                        LiveFreeTaskLayer.this.hideTip();
                    } else {
                        LiveFreeTaskLayer.this.bZY();
                    }
                }
            }
        };
        init(context);
    }

    public LiveFreeTaskLayer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gYY = false;
        this.gZe = new a.InterfaceC0660a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5
            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0660a
            public void a(AlaLiveUserInfoData alaLiveUserInfoData, ae aeVar) {
                if (alaLiveUserInfoData != null) {
                    LiveFreeTaskLayer.this.aA(String.valueOf(alaLiveUserInfoData.petalNum), true);
                    TbadkCoreApplication.getInst().currentAccountFlowerNum = alaLiveUserInfoData.petalNum;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                } else {
                    LiveFreeTaskLayer.this.aA("", false);
                }
                if (aeVar != null) {
                    LiveFreeTaskLayer.this.gYS.setData(aeVar.aHG);
                }
                LiveFreeTaskLayer.this.bZV();
            }

            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0660a
            public void am(int i2, String str) {
                LiveFreeTaskLayer.this.bgl.reset();
                LiveFreeTaskLayer.this.bgl.setTitle(a.i.ala_task_empty_msg);
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    LiveFreeTaskLayer.this.bgl.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
                } else {
                    LiveFreeTaskLayer.this.bgl.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LiveFreeTaskLayer.this.buQ();
                        }
                    });
                    LiveFreeTaskLayer.this.bgl.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
                }
                LiveFreeTaskLayer.this.bgl.setVisibility(0);
                if (i2 != 146021) {
                    if (LiveFreeTaskLayer.this.gYR.bZZ() != null && ListUtils.getCount(LiveFreeTaskLayer.this.gYR.bZZ().aHG) > 0) {
                        BdUtilHelper.showToast(LiveFreeTaskLayer.this.getContext(), str);
                        return;
                    }
                    return;
                }
                LiveFreeTaskLayer.this.bZW();
            }
        };
        this.gZf = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    LiveFreeTaskLayer.this.gYS.k((Integer) customResponsedMessage.getData());
                }
            }
        };
        this.gZg = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (view == LiveFreeTaskLayer.this.gYX) {
                        if (LiveFreeTaskLayer.this.gYY) {
                            LiveFreeTaskLayer.this.hideTip();
                            return true;
                        }
                        return true;
                    }
                    LiveFreeTaskLayer.this.bZX();
                    return true;
                }
                return true;
            }
        };
        this.eFC = new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == LiveFreeTaskLayer.this.gYU) {
                    if (LiveFreeTaskLayer.this.gYY) {
                        LiveFreeTaskLayer.this.hideTip();
                    } else {
                        LiveFreeTaskLayer.this.bZY();
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = View.inflate(getContext(), a.h.ala_task_list_layout, this);
        this.gYX = (LinearLayout) this.mRootView.findViewById(a.g.layout_content);
        this.gYT = (TextView) this.mRootView.findViewById(a.g.tv_flower_task_title);
        this.gYU = (ImageView) this.mRootView.findViewById(a.g.img_flower_help);
        this.fmE = this.mRootView.findViewById(a.g.divider);
        this.gYV = (TextView) this.mRootView.findViewById(a.g.tv_flower_count);
        this.gYW = (TextView) this.mRootView.findViewById(a.g.tv_task_help_tips);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.detail_list);
        this.bgl = (CommonEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.gYS = new b(getContext(), new com.baidu.tieba.ala.tasklist.a.a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.1
            @Override // com.baidu.tieba.ala.tasklist.a.a
            public void uY(int i) {
                if (LiveFreeTaskLayer.this.gYR != null) {
                    LiveFreeTaskLayer.this.gYR.uY(i);
                }
            }
        });
        this.mListView.setAdapter((ListAdapter) this.gYS);
        this.mListView.setEmptyView(this.bgl);
        this.mRootView.setOnTouchListener(this.gZg);
        this.gYX.setOnTouchListener(this.gZg);
        this.gYU.setOnClickListener(this.eFC);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
        if (screenDimensions[1] > screenDimensions[0]) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gYX.getLayoutParams();
            layoutParams.height = (int) (screenDimensions[1] * 0.618d);
            this.gYX.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Cf() {
        this.gYR = new com.baidu.tieba.ala.tasklist.model.a();
        this.gYR.a(this.gZe);
        MessageManager.getInstance().registerListener(this.gZf);
        buQ();
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Cg() {
        if (this.gYR != null) {
            this.gYR.onDestroy();
            this.gYR = null;
        }
        MessageManager.getInstance().unRegisterListener(this.gZf);
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Ch() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Ci() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void release() {
        super.release();
        if (this.gYR != null) {
            this.gYR.onDestroy();
            this.gYR = null;
        }
        if (this.gZd != null && this.gZd.isShowing()) {
            this.gZd.dismiss();
            this.gZd = null;
        }
        if (this.gZc != null && this.gZc.isShowing()) {
            this.gZc.dismiss();
            this.gZc = null;
        }
        MessageManager.getInstance().unRegisterListener(this.gZf);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            if (this.gZd != null && this.gZd.isShowing()) {
                this.gZd.dismiss();
                this.gZd = null;
            }
            if (this.gZc != null && this.gZc.isShowing()) {
                this.gZc.dismiss();
                this.gZc = null;
            }
            com.baidu.live.core.layer.b.Cl().e(this);
        }
    }

    public void setIsFromFlowerGuide(boolean z) {
        this.gYZ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buQ() {
        this.bgl.setVisibility(8);
        this.gYR.cac();
    }

    private void uY(int i) {
        this.gYR.uY(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZV() {
        ad CQ;
        if (this.gYZ && this.gZa < 3 && (CQ = this.gYS.CQ()) != null) {
            if (CQ.status == 2) {
                uY(CQ.aHy);
                this.gZa++;
                this.gZb = true;
                return;
            }
            this.gYZ = false;
            if (this.gZb) {
                this.gZb = false;
                uZ(CQ.aHD);
            }
        }
    }

    private void uZ(int i) {
        if (this.gZd != null && this.gZd.isShowing()) {
            this.gZd.dismiss();
        }
        this.gZd = null;
        View inflate = LayoutInflater.from(this.mContext).inflate(a.h.dialog_flower_guide_result, (ViewGroup) null);
        this.gZd = new Dialog(this.mContext, a.j.FlowerGuideResultDialogStyle);
        this.gZd.requestWindowFeature(1);
        this.gZd.setCancelable(false);
        this.gZd.setContentView(inflate);
        this.gZd.setCanceledOnTouchOutside(false);
        ((TextView) inflate.findViewById(a.g.flowerNum_textView)).setText(String.format("恭喜获得%s鲜花", Integer.valueOf(i)));
        ((ImageView) inflate.findViewById(a.g.close_imageView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    LiveFreeTaskLayer.this.gZd.dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((TextView) inflate.findViewById(a.g.toGift_textView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    LiveFreeTaskLayer.this.gZd.dismiss();
                    LiveFreeTaskLayer.this.bIg();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.gZd.show();
    }

    public void bZW() {
        ColorStateList colorStateList;
        if (this.gZc != null && this.gZc.isShowing()) {
            this.gZc.dismiss();
        }
        this.gZc = null;
        this.gZc = new AlertDialog.Builder(this.mContext, a.j.sdk_dialog_window).create();
        this.gZc.show();
        View inflate = LayoutInflater.from(this.mContext).inflate(a.h.ala_flower_over_limit_dialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(a.g.tv_task_failed_content)).setText(getFlowerOverLimitContent());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LiveFreeTaskLayer.this.gZc.dismiss();
            }
        });
        inflate.findViewById(a.g.close_img).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LiveFreeTaskLayer.this.gZc.dismiss();
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
                LiveFreeTaskLayer.this.gZc.dismiss();
                LiveFreeTaskLayer.this.bIg();
            }
        });
        Window window = this.gZc.getWindow();
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
    public void bIg() {
        bq bqVar;
        com.baidu.live.core.layer.b.Cl().e(this);
        int i = -1;
        be beVar = com.baidu.live.w.a.Nk().bka;
        if (beVar != null && beVar.aJy != null && (bqVar = beVar.aJy.aKt) != null) {
            i = bqVar.aKE;
        }
        y yVar = new y();
        yVar.aEz = i;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, yVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZX() {
        com.baidu.live.core.layer.b.Cl().e(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aA(String str, boolean z) {
        this.gYV.setVisibility(z ? 0 : 8);
        this.gYV.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZY() {
        this.gYY = true;
        this.fmE.setVisibility(8);
        this.gYW.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTip() {
        this.gYY = false;
        this.fmE.setVisibility(0);
        this.gYW.setVisibility(8);
    }
}
