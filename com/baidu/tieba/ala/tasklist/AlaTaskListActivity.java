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
import com.baidu.live.data.ao;
import com.baidu.live.data.ay;
import com.baidu.live.data.t;
import com.baidu.live.data.u;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.utils.h;
import com.baidu.megapp.ma.Util;
import com.baidu.tieba.ala.tasklist.model.a;
/* loaded from: classes2.dex */
public class AlaTaskListActivity extends BaseActivity<AlaTaskListActivity> implements View.OnClickListener, View.OnTouchListener {
    private View caf;
    private CommonEmptyView erG;
    public a fwG;
    private com.baidu.tieba.ala.tasklist.view.a fwH;
    public TextView fwI;
    public ImageView fwJ;
    public TextView fwK;
    public TextView fwL;
    private AlertDialog fwN;
    private LinearLayout fwO;
    private boolean fwP;
    private int fwQ;
    private boolean fwR;
    public BdListView mListView;
    private View mRootView;
    private boolean fwM = false;
    a.InterfaceC0477a fwS = new a.InterfaceC0477a() { // from class: com.baidu.tieba.ala.tasklist.AlaTaskListActivity.3
        @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0477a
        public void a(AlaLiveUserInfoData alaLiveUserInfoData, u uVar) {
            if (alaLiveUserInfoData != null) {
                AlaTaskListActivity.this.ad(String.valueOf(alaLiveUserInfoData.petalNum), true);
                TbadkCoreApplication.getInst().currentAccountFlowerNum = alaLiveUserInfoData.petalNum;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
            } else {
                AlaTaskListActivity.this.ad("", false);
            }
            if (uVar != null) {
                AlaTaskListActivity.this.fwH.setData(uVar.Zm);
            }
            AlaTaskListActivity.this.brK();
        }

        @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0477a
        public void af(int i, String str) {
            AlaTaskListActivity.this.erG.reset();
            AlaTaskListActivity.this.erG.setTitle(a.i.ala_task_empty_msg);
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                AlaTaskListActivity.this.erG.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
            } else {
                AlaTaskListActivity.this.erG.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.AlaTaskListActivity.3.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaTaskListActivity.this.bfI();
                    }
                });
                AlaTaskListActivity.this.erG.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
            }
            AlaTaskListActivity.this.erG.setVisibility(0);
            if (i == 146021) {
                AlaTaskListActivity.this.brM();
            } else if (AlaTaskListActivity.this.fwG.brP() != null && ListUtils.getCount(AlaTaskListActivity.this.fwG.brP().Zm) > 0) {
                AlaTaskListActivity.this.showToast(str);
            }
        }
    };
    CustomMessageListener aeN = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.tasklist.AlaTaskListActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaTaskListActivity.this.closeActivity();
        }
    };
    CustomMessageListener fwT = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.AlaTaskListActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                AlaTaskListActivity.this.fwH.i((Integer) customResponsedMessage.getData());
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
        this.fwP = getIntent().getBooleanExtra("is_from_flower_guide", false);
        initView();
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        if (screenDimensions[1] > screenDimensions[0]) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fwO.getLayoutParams();
            layoutParams.height = (int) (screenDimensions[1] * 0.618d);
            this.fwO.setLayoutParams(layoutParams);
        } else {
            finish();
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                h.S(this.mRootView);
            }
            this.fwO.setPadding(0, getResources().getDimensionPixelSize(a.e.sdk_ds48), 0, 0);
        }
        this.fwG = new com.baidu.tieba.ala.tasklist.model.a(getPageContext());
        this.fwG.a(this.fwS);
        registerListener(this.aeN);
        registerListener(this.fwT);
        bfI();
    }

    private void initView() {
        this.mRootView = getPageContext().getPageActivity().getLayoutInflater().inflate(a.h.ala_task_list_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.fwO = (LinearLayout) this.mRootView.findViewById(a.g.layout_content);
        this.fwI = (TextView) this.mRootView.findViewById(a.g.tv_flower_task_title);
        this.fwJ = (ImageView) this.mRootView.findViewById(a.g.img_flower_help);
        this.caf = this.mRootView.findViewById(a.g.divider);
        this.fwK = (TextView) this.mRootView.findViewById(a.g.tv_flower_count);
        this.fwL = (TextView) this.mRootView.findViewById(a.g.tv_task_help_tips);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.detail_list);
        this.erG = (CommonEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.fwH = new com.baidu.tieba.ala.tasklist.view.a(this);
        this.mListView.setAdapter((ListAdapter) this.fwH);
        this.mListView.setEmptyView(this.erG);
        this.mRootView.setOnTouchListener(this);
        this.fwO.setOnTouchListener(this);
        this.fwJ.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfI() {
        this.erG.setVisibility(8);
        this.fwG.brS();
    }

    public void qM(int i) {
        this.fwG.qM(i);
    }

    public void brK() {
        t pS;
        if (this.fwP && this.fwQ < 3 && (pS = this.fwH.pS()) != null) {
            if (pS.status == 2) {
                qM(pS.Ze);
                this.fwQ++;
                this.fwR = true;
                return;
            }
            this.fwP = false;
            if (this.fwR) {
                this.fwR = false;
                qN(pS.Zj);
            }
        }
    }

    private void qN(int i) {
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
                    AlaTaskListActivity.this.bby();
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

    private void aZo() {
        if (this instanceof Activity) {
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                overridePendingTransition(a.C0086a.sdk_activity_open_translate_from_right, a.C0086a.sdk_activity_close_translate_to_right);
            } else {
                overridePendingTransition(a.C0086a.sdk_activity_open_translate_from_bottom, a.C0086a.sdk_activity_close_translate_from_top);
            }
        } else if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
            overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_in_from_right", ResUtils.ANIM), Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_out_to_right", ResUtils.ANIM));
        } else {
            overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_in_from_bottom", ResUtils.ANIM), Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_out_to_bottom", ResUtils.ANIM));
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity
    public void enterExitAnimation() {
        aZo();
    }

    @Override // com.baidu.live.tbadk.BaseActivity
    public void closeAnimation() {
        aZo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fwG != null) {
            this.fwG.onDestroy();
        }
    }

    public void bby() {
        ay ayVar;
        Intent intent = new Intent();
        intent.putExtra("need_show_gift_panel", true);
        ao aoVar = com.baidu.live.s.a.wR().atk;
        intent.putExtra("custom_category_id", (aoVar == null || aoVar.aaU == null || (ayVar = aoVar.aaU.abJ) == null) ? -1 : ayVar.abU);
        setResult(-1, intent);
        finish();
    }

    public void brL() {
        setResult(0, new Intent());
        finish();
    }

    public void ad(String str, boolean z) {
        this.fwK.setVisibility(z ? 0 : 8);
        this.fwK.setText(str);
    }

    public void brM() {
        ColorStateList colorStateList;
        this.fwN = new AlertDialog.Builder(getPageContext().getPageActivity(), a.j.sdk_dialog_window).create();
        ShowUtil.showDialog(this.fwN, getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_flower_over_limit_dialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(a.g.tv_task_failed_content)).setText(brN());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.AlaTaskListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaTaskListActivity.this.fwN.dismiss();
            }
        });
        inflate.findViewById(a.g.close_img).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.AlaTaskListActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaTaskListActivity.this.fwN.dismiss();
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
                AlaTaskListActivity.this.fwN.dismiss();
                AlaTaskListActivity.this.bby();
            }
        });
        Window window = this.fwN.getWindow();
        window.setGravity(17);
        window.setBackgroundDrawableResource(17170445);
        window.setContentView(inflate);
    }

    public SpannableStringBuilder brN() {
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
            if (view == this.fwO) {
                z = true;
                if (this.fwM) {
                    hideTip();
                }
            } else {
                brL();
            }
        }
        return z;
    }

    private void hideTip() {
        this.fwM = false;
        this.caf.setVisibility(0);
        this.fwL.setVisibility(8);
    }

    @Override // com.baidu.live.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fwJ) {
            if (this.fwM) {
                hideTip();
            } else {
                brO();
            }
        }
    }

    private void brO() {
        this.fwM = true;
        this.caf.setVisibility(8);
        this.fwL.setVisibility(0);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            finish();
        }
    }
}
