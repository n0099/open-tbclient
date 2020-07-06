package com.baidu.tieba.ala.tasklist;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.fsg.base.utils.ResUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.ShowUtil;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.ab;
import com.baidu.live.data.ac;
import com.baidu.live.data.bb;
import com.baidu.live.data.bn;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.utils.h;
import com.baidu.megapp.ma.Util;
import com.baidu.tieba.ala.tasklist.model.a;
/* loaded from: classes3.dex */
public class AlaTaskListActivity extends BaseActivity<AlaTaskListActivity> implements View.OnClickListener, View.OnTouchListener {
    private CommonEmptyView baR;
    private View eVD;
    public a gGB;
    private com.baidu.tieba.ala.tasklist.view.a gGC;
    public TextView gGD;
    public ImageView gGE;
    public TextView gGF;
    public TextView gGG;
    private AlertDialog gGI;
    private LinearLayout gGJ;
    private boolean gGK;
    private int gGL;
    private boolean gGM;
    public BdListView mListView;
    private View mRootView;
    private boolean gGH = false;
    a.InterfaceC0601a gGN = new a.InterfaceC0601a() { // from class: com.baidu.tieba.ala.tasklist.AlaTaskListActivity.3
        @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0601a
        public void a(AlaLiveUserInfoData alaLiveUserInfoData, ac acVar) {
            if (alaLiveUserInfoData != null) {
                AlaTaskListActivity.this.ay(String.valueOf(alaLiveUserInfoData.petalNum), true);
                TbadkCoreApplication.getInst().currentAccountFlowerNum = alaLiveUserInfoData.petalNum;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
            } else {
                AlaTaskListActivity.this.ay("", false);
            }
            if (acVar != null) {
                AlaTaskListActivity.this.gGC.setData(acVar.aBj);
            }
            AlaTaskListActivity.this.bMD();
        }

        @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0601a
        public void an(int i, String str) {
            AlaTaskListActivity.this.baR.reset();
            AlaTaskListActivity.this.baR.setTitle(a.i.ala_task_empty_msg);
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                AlaTaskListActivity.this.baR.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
            } else {
                AlaTaskListActivity.this.baR.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.AlaTaskListActivity.3.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaTaskListActivity.this.bis();
                    }
                });
                AlaTaskListActivity.this.baR.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
            }
            AlaTaskListActivity.this.baR.setVisibility(0);
            if (i == 146021) {
                AlaTaskListActivity.this.bMF();
            } else if (AlaTaskListActivity.this.gGB.bMI() != null && ListUtils.getCount(AlaTaskListActivity.this.gGB.bMI().aBj) > 0) {
                AlaTaskListActivity.this.showToast(str);
            }
        }
    };
    CustomMessageListener aHo = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.tasklist.AlaTaskListActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaTaskListActivity.this.closeActivity();
        }
    };
    CustomMessageListener gGO = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.AlaTaskListActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                AlaTaskListActivity.this.gGC.j((Integer) customResponsedMessage.getData());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags(67108864);
        }
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (!isFinishing()) {
            this.gGK = getIntent().getBooleanExtra("is_from_flower_guide", false);
            initView();
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
            if (screenDimensions[1] > screenDimensions[0]) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gGJ.getLayoutParams();
                layoutParams.height = (int) (screenDimensions[1] * 0.618d);
                this.gGJ.setLayoutParams(layoutParams);
            } else {
                finish();
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    h.U(this.mRootView);
                }
                this.gGJ.setPadding(0, getResources().getDimensionPixelSize(a.e.sdk_ds48), 0, 0);
            }
            this.gGB = new com.baidu.tieba.ala.tasklist.model.a(getPageContext());
            this.gGB.a(this.gGN);
            registerListener(this.aHo);
            registerListener(this.gGO);
            bis();
        }
    }

    private void initView() {
        this.mRootView = getPageContext().getPageActivity().getLayoutInflater().inflate(a.h.ala_task_list_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.gGJ = (LinearLayout) this.mRootView.findViewById(a.g.layout_content);
        this.gGD = (TextView) this.mRootView.findViewById(a.g.tv_flower_task_title);
        this.gGE = (ImageView) this.mRootView.findViewById(a.g.img_flower_help);
        this.eVD = this.mRootView.findViewById(a.g.divider);
        this.gGF = (TextView) this.mRootView.findViewById(a.g.tv_flower_count);
        this.gGG = (TextView) this.mRootView.findViewById(a.g.tv_task_help_tips);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.detail_list);
        this.baR = (CommonEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.gGC = new com.baidu.tieba.ala.tasklist.view.a(this);
        this.mListView.setAdapter((ListAdapter) this.gGC);
        this.mListView.setEmptyView(this.baR);
        this.mRootView.setOnTouchListener(this);
        this.gGJ.setOnTouchListener(this);
        this.gGE.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bis() {
        this.baR.setVisibility(8);
        this.gGB.bML();
    }

    public void ss(int i) {
        this.gGB.ss(i);
    }

    public void bMD() {
        ab wL;
        if (this.gGK && this.gGL < 3 && (wL = this.gGC.wL()) != null) {
            if (wL.status == 2) {
                ss(wL.aBb);
                this.gGL++;
                this.gGM = true;
                return;
            }
            this.gGK = false;
            if (this.gGM) {
                this.gGM = false;
                st(wL.aBg);
            }
        }
    }

    private void st(int i) {
        View inflate = LayoutInflater.from(getActivity()).inflate(a.h.dialog_flower_guide_result, (ViewGroup) null);
        final Dialog dialog = new Dialog(getActivity(), a.j.FlowerGuideResultDialogStyle);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(false);
        dialog.setContentView(inflate);
        dialog.setCanceledOnTouchOutside(false);
        ((TextView) inflate.findViewById(a.g.flowerNum_textView)).setText(String.format("恭喜获得%s鲜花", Integer.valueOf(i)));
        ((ImageView) inflate.findViewById(a.g.close_imageView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.AlaTaskListActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    dialog.dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((TextView) inflate.findViewById(a.g.toGift_textView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.AlaTaskListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    dialog.dismiss();
                    AlaTaskListActivity.this.bvU();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Activity activity = getActivity();
        if (Build.VERSION.SDK_INT >= 17) {
            if (!activity.isDestroyed() && !activity.isFinishing()) {
                dialog.show();
            }
        } else if (activity.isFinishing()) {
            dialog.show();
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        if (window != null) {
            View decorView = window.getDecorView();
            window.getDecorView().setOnTouchListener(this);
            WindowManager.LayoutParams attributes = window.getAttributes();
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
            if (screenDimensions[1] <= screenDimensions[0]) {
                attributes.width = getResources().getDimensionPixelSize(a.e.sdk_ds720);
                attributes.height = screenDimensions[1];
                attributes.gravity = 85;
            }
            getWindowManager().updateViewLayout(decorView, attributes);
            window.setBackgroundDrawableResource(17170445);
        }
    }

    private void brI() {
        if (this instanceof Activity) {
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                overridePendingTransition(a.C0176a.sdk_activity_open_translate_from_right, a.C0176a.sdk_activity_close_translate_to_right);
            } else {
                overridePendingTransition(a.C0176a.sdk_activity_open_translate_from_bottom, a.C0176a.sdk_activity_close_translate_from_top);
            }
        } else if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
            overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_in_from_right", ResUtils.ANIM), Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_out_to_right", ResUtils.ANIM));
        } else {
            overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_in_from_bottom", ResUtils.ANIM), Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_out_to_bottom", ResUtils.ANIM));
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity
    public void enterExitAnimation() {
        brI();
    }

    @Override // com.baidu.live.tbadk.BaseActivity
    public void closeAnimation() {
        brI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gGB != null) {
            this.gGB.onDestroy();
        }
    }

    public void bvU() {
        bn bnVar;
        Intent intent = new Intent();
        intent.putExtra("need_show_gift_panel", true);
        bb bbVar = com.baidu.live.v.a.Hm().bdV;
        intent.putExtra("custom_category_id", (bbVar == null || bbVar.aCT == null || (bnVar = bbVar.aCT.aDP) == null) ? -1 : bnVar.aEa);
        setResult(-1, intent);
        finish();
    }

    public void bME() {
        setResult(0, new Intent());
        finish();
    }

    public void ay(String str, boolean z) {
        this.gGF.setVisibility(z ? 0 : 8);
        this.gGF.setText(str);
    }

    public void bMF() {
        ColorStateList colorStateList;
        this.gGI = new AlertDialog.Builder(getPageContext().getPageActivity(), a.j.sdk_dialog_window).create();
        ShowUtil.showDialog(this.gGI, getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_flower_over_limit_dialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(a.g.tv_task_failed_content)).setText(bMG());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.AlaTaskListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaTaskListActivity.this.gGI.dismiss();
            }
        });
        inflate.findViewById(a.g.close_img).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.AlaTaskListActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaTaskListActivity.this.gGI.dismiss();
            }
        });
        TextView textView = (TextView) inflate.findViewById(a.g.btn_to_send_gift);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            colorStateList = getPageContext().getPageActivity().getResources().getColorStateList(a.f.ala_btn_bg_gift_text_color_s_shoubai);
        } else {
            colorStateList = getPageContext().getPageActivity().getResources().getColorStateList(a.f.ala_btn_bg_gift_text_color_s);
        }
        textView.setTextColor(colorStateList);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.AlaTaskListActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaTaskListActivity.this.gGI.dismiss();
                AlaTaskListActivity.this.bvU();
            }
        });
        Window window = this.gGI.getWindow();
        window.setGravity(17);
        window.setBackgroundDrawableResource(17170445);
        window.setContentView(inflate);
    }

    public SpannableStringBuilder bMG() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) SpannableString.valueOf(getPageContext().getString(a.i.get_task_reward_failed_1)));
        SpannableString valueOf = SpannableString.valueOf(getPageContext().getString(a.i.get_task_reward_failed_2));
        valueOf.setSpan(new ForegroundColorSpan(getPageContext().getResources().getColor(a.d.sdk_cp_link_tip_a)), 0, valueOf.length(), 33);
        spannableStringBuilder.append((CharSequence) valueOf);
        spannableStringBuilder.append((CharSequence) SpannableString.valueOf(getPageContext().getString(a.i.get_task_reward_failed_3)));
        return spannableStringBuilder;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z = false;
        if (motionEvent.getAction() == 0) {
            if (view == this.gGJ) {
                z = true;
                if (this.gGH) {
                    hideTip();
                }
            } else {
                bME();
            }
        }
        return z;
    }

    private void hideTip() {
        this.gGH = false;
        this.eVD.setVisibility(0);
        this.gGG.setVisibility(8);
    }

    @Override // com.baidu.live.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gGE) {
            if (this.gGH) {
                hideTip();
            } else {
                bMH();
            }
        }
    }

    private void bMH() {
        this.gGH = true;
        this.eVD.setVisibility(8);
        this.gGG.setVisibility(0);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            finish();
        }
    }
}
