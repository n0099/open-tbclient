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
    private CommonEmptyView bgn;
    private View.OnClickListener eFG;
    private View fmI;
    private a gYV;
    private b gYW;
    private TextView gYX;
    private ImageView gYY;
    private TextView gYZ;
    private TextView gZa;
    private LinearLayout gZb;
    private boolean gZc;
    private boolean gZd;
    private int gZe;
    private boolean gZf;
    private AlertDialog gZg;
    private Dialog gZh;
    private a.InterfaceC0660a gZi;
    private CustomMessageListener gZj;
    private View.OnTouchListener gZk;
    private Context mContext;
    private BdListView mListView;
    private View mRootView;

    public LiveFreeTaskLayer(@NonNull Context context) {
        super(context);
        this.gZc = false;
        this.gZi = new a.InterfaceC0660a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5
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
                    LiveFreeTaskLayer.this.gYW.setData(aeVar.aHI);
                }
                LiveFreeTaskLayer.this.bZW();
            }

            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0660a
            public void am(int i, String str) {
                LiveFreeTaskLayer.this.bgn.reset();
                LiveFreeTaskLayer.this.bgn.setTitle(a.i.ala_task_empty_msg);
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    LiveFreeTaskLayer.this.bgn.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
                } else {
                    LiveFreeTaskLayer.this.bgn.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LiveFreeTaskLayer.this.buR();
                        }
                    });
                    LiveFreeTaskLayer.this.bgn.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
                }
                LiveFreeTaskLayer.this.bgn.setVisibility(0);
                if (i != 146021) {
                    if (LiveFreeTaskLayer.this.gYV.caa() != null && ListUtils.getCount(LiveFreeTaskLayer.this.gYV.caa().aHI) > 0) {
                        BdUtilHelper.showToast(LiveFreeTaskLayer.this.getContext(), str);
                        return;
                    }
                    return;
                }
                LiveFreeTaskLayer.this.bZX();
            }
        };
        this.gZj = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    LiveFreeTaskLayer.this.gYW.k((Integer) customResponsedMessage.getData());
                }
            }
        };
        this.gZk = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (view == LiveFreeTaskLayer.this.gZb) {
                        if (LiveFreeTaskLayer.this.gZc) {
                            LiveFreeTaskLayer.this.hideTip();
                            return true;
                        }
                        return true;
                    }
                    LiveFreeTaskLayer.this.bZY();
                    return true;
                }
                return true;
            }
        };
        this.eFG = new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == LiveFreeTaskLayer.this.gYY) {
                    if (LiveFreeTaskLayer.this.gZc) {
                        LiveFreeTaskLayer.this.hideTip();
                    } else {
                        LiveFreeTaskLayer.this.bZZ();
                    }
                }
            }
        };
        init(context);
    }

    public LiveFreeTaskLayer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gZc = false;
        this.gZi = new a.InterfaceC0660a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5
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
                    LiveFreeTaskLayer.this.gYW.setData(aeVar.aHI);
                }
                LiveFreeTaskLayer.this.bZW();
            }

            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0660a
            public void am(int i, String str) {
                LiveFreeTaskLayer.this.bgn.reset();
                LiveFreeTaskLayer.this.bgn.setTitle(a.i.ala_task_empty_msg);
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    LiveFreeTaskLayer.this.bgn.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
                } else {
                    LiveFreeTaskLayer.this.bgn.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LiveFreeTaskLayer.this.buR();
                        }
                    });
                    LiveFreeTaskLayer.this.bgn.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
                }
                LiveFreeTaskLayer.this.bgn.setVisibility(0);
                if (i != 146021) {
                    if (LiveFreeTaskLayer.this.gYV.caa() != null && ListUtils.getCount(LiveFreeTaskLayer.this.gYV.caa().aHI) > 0) {
                        BdUtilHelper.showToast(LiveFreeTaskLayer.this.getContext(), str);
                        return;
                    }
                    return;
                }
                LiveFreeTaskLayer.this.bZX();
            }
        };
        this.gZj = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    LiveFreeTaskLayer.this.gYW.k((Integer) customResponsedMessage.getData());
                }
            }
        };
        this.gZk = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (view == LiveFreeTaskLayer.this.gZb) {
                        if (LiveFreeTaskLayer.this.gZc) {
                            LiveFreeTaskLayer.this.hideTip();
                            return true;
                        }
                        return true;
                    }
                    LiveFreeTaskLayer.this.bZY();
                    return true;
                }
                return true;
            }
        };
        this.eFG = new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == LiveFreeTaskLayer.this.gYY) {
                    if (LiveFreeTaskLayer.this.gZc) {
                        LiveFreeTaskLayer.this.hideTip();
                    } else {
                        LiveFreeTaskLayer.this.bZZ();
                    }
                }
            }
        };
        init(context);
    }

    public LiveFreeTaskLayer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gZc = false;
        this.gZi = new a.InterfaceC0660a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5
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
                    LiveFreeTaskLayer.this.gYW.setData(aeVar.aHI);
                }
                LiveFreeTaskLayer.this.bZW();
            }

            @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0660a
            public void am(int i2, String str) {
                LiveFreeTaskLayer.this.bgn.reset();
                LiveFreeTaskLayer.this.bgn.setTitle(a.i.ala_task_empty_msg);
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    LiveFreeTaskLayer.this.bgn.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
                } else {
                    LiveFreeTaskLayer.this.bgn.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.5.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LiveFreeTaskLayer.this.buR();
                        }
                    });
                    LiveFreeTaskLayer.this.bgn.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
                }
                LiveFreeTaskLayer.this.bgn.setVisibility(0);
                if (i2 != 146021) {
                    if (LiveFreeTaskLayer.this.gYV.caa() != null && ListUtils.getCount(LiveFreeTaskLayer.this.gYV.caa().aHI) > 0) {
                        BdUtilHelper.showToast(LiveFreeTaskLayer.this.getContext(), str);
                        return;
                    }
                    return;
                }
                LiveFreeTaskLayer.this.bZX();
            }
        };
        this.gZj = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    LiveFreeTaskLayer.this.gYW.k((Integer) customResponsedMessage.getData());
                }
            }
        };
        this.gZk = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (view == LiveFreeTaskLayer.this.gZb) {
                        if (LiveFreeTaskLayer.this.gZc) {
                            LiveFreeTaskLayer.this.hideTip();
                            return true;
                        }
                        return true;
                    }
                    LiveFreeTaskLayer.this.bZY();
                    return true;
                }
                return true;
            }
        };
        this.eFG = new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == LiveFreeTaskLayer.this.gYY) {
                    if (LiveFreeTaskLayer.this.gZc) {
                        LiveFreeTaskLayer.this.hideTip();
                    } else {
                        LiveFreeTaskLayer.this.bZZ();
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRootView = View.inflate(getContext(), a.h.ala_task_list_layout, this);
        this.gZb = (LinearLayout) this.mRootView.findViewById(a.g.layout_content);
        this.gYX = (TextView) this.mRootView.findViewById(a.g.tv_flower_task_title);
        this.gYY = (ImageView) this.mRootView.findViewById(a.g.img_flower_help);
        this.fmI = this.mRootView.findViewById(a.g.divider);
        this.gYZ = (TextView) this.mRootView.findViewById(a.g.tv_flower_count);
        this.gZa = (TextView) this.mRootView.findViewById(a.g.tv_task_help_tips);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.detail_list);
        this.bgn = (CommonEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.gYW = new b(getContext(), new com.baidu.tieba.ala.tasklist.a.a() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.1
            @Override // com.baidu.tieba.ala.tasklist.a.a
            public void uY(int i) {
                if (LiveFreeTaskLayer.this.gYV != null) {
                    LiveFreeTaskLayer.this.gYV.uY(i);
                }
            }
        });
        this.mListView.setAdapter((ListAdapter) this.gYW);
        this.mListView.setEmptyView(this.bgn);
        this.mRootView.setOnTouchListener(this.gZk);
        this.gZb.setOnTouchListener(this.gZk);
        this.gYY.setOnClickListener(this.eFG);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
        if (screenDimensions[1] > screenDimensions[0]) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gZb.getLayoutParams();
            layoutParams.height = (int) (screenDimensions[1] * 0.618d);
            this.gZb.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Cf() {
        this.gYV = new com.baidu.tieba.ala.tasklist.model.a();
        this.gYV.a(this.gZi);
        MessageManager.getInstance().registerListener(this.gZj);
        buR();
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Cg() {
        if (this.gYV != null) {
            this.gYV.onDestroy();
            this.gYV = null;
        }
        MessageManager.getInstance().unRegisterListener(this.gZj);
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
        if (this.gYV != null) {
            this.gYV.onDestroy();
            this.gYV = null;
        }
        if (this.gZh != null && this.gZh.isShowing()) {
            this.gZh.dismiss();
            this.gZh = null;
        }
        if (this.gZg != null && this.gZg.isShowing()) {
            this.gZg.dismiss();
            this.gZg = null;
        }
        MessageManager.getInstance().unRegisterListener(this.gZj);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            if (this.gZh != null && this.gZh.isShowing()) {
                this.gZh.dismiss();
                this.gZh = null;
            }
            if (this.gZg != null && this.gZg.isShowing()) {
                this.gZg.dismiss();
                this.gZg = null;
            }
            com.baidu.live.core.layer.b.Cl().e(this);
        }
    }

    public void setIsFromFlowerGuide(boolean z) {
        this.gZd = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buR() {
        this.bgn.setVisibility(8);
        this.gYV.cad();
    }

    private void uY(int i) {
        this.gYV.uY(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZW() {
        ad CQ;
        if (this.gZd && this.gZe < 3 && (CQ = this.gYW.CQ()) != null) {
            if (CQ.status == 2) {
                uY(CQ.aHA);
                this.gZe++;
                this.gZf = true;
                return;
            }
            this.gZd = false;
            if (this.gZf) {
                this.gZf = false;
                uZ(CQ.aHF);
            }
        }
    }

    private void uZ(int i) {
        if (this.gZh != null && this.gZh.isShowing()) {
            this.gZh.dismiss();
        }
        this.gZh = null;
        View inflate = LayoutInflater.from(this.mContext).inflate(a.h.dialog_flower_guide_result, (ViewGroup) null);
        this.gZh = new Dialog(this.mContext, a.j.FlowerGuideResultDialogStyle);
        this.gZh.requestWindowFeature(1);
        this.gZh.setCancelable(false);
        this.gZh.setContentView(inflate);
        this.gZh.setCanceledOnTouchOutside(false);
        ((TextView) inflate.findViewById(a.g.flowerNum_textView)).setText(String.format("恭喜获得%s鲜花", Integer.valueOf(i)));
        ((ImageView) inflate.findViewById(a.g.close_imageView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    LiveFreeTaskLayer.this.gZh.dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((TextView) inflate.findViewById(a.g.toGift_textView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    LiveFreeTaskLayer.this.gZh.dismiss();
                    LiveFreeTaskLayer.this.bIh();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.gZh.show();
    }

    public void bZX() {
        ColorStateList colorStateList;
        if (this.gZg != null && this.gZg.isShowing()) {
            this.gZg.dismiss();
        }
        this.gZg = null;
        this.gZg = new AlertDialog.Builder(this.mContext, a.j.sdk_dialog_window).create();
        this.gZg.show();
        View inflate = LayoutInflater.from(this.mContext).inflate(a.h.ala_flower_over_limit_dialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(a.g.tv_task_failed_content)).setText(getFlowerOverLimitContent());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LiveFreeTaskLayer.this.gZg.dismiss();
            }
        });
        inflate.findViewById(a.g.close_img).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.layer.LiveFreeTaskLayer.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LiveFreeTaskLayer.this.gZg.dismiss();
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
                LiveFreeTaskLayer.this.gZg.dismiss();
                LiveFreeTaskLayer.this.bIh();
            }
        });
        Window window = this.gZg.getWindow();
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
    public void bIh() {
        bq bqVar;
        com.baidu.live.core.layer.b.Cl().e(this);
        int i = -1;
        be beVar = com.baidu.live.w.a.Nk().bkd;
        if (beVar != null && beVar.aJA != null && (bqVar = beVar.aJA.aKv) != null) {
            i = bqVar.aKG;
        }
        y yVar = new y();
        yVar.aEB = i;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, yVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZY() {
        com.baidu.live.core.layer.b.Cl().e(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aA(String str, boolean z) {
        this.gYZ.setVisibility(z ? 0 : 8);
        this.gYZ.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZZ() {
        this.gZc = true;
        this.fmI.setVisibility(8);
        this.gZa.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTip() {
        this.gZc = false;
        this.fmI.setVisibility(0);
        this.gZa.setVisibility(8);
    }
}
