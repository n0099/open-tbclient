package com.baidu.tieba.ala.tasklist;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
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
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.ShowUtil;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.af;
import com.baidu.live.data.an;
import com.baidu.live.data.p;
import com.baidu.live.data.q;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.utils.g;
import com.baidu.megapp.ma.Util;
import com.baidu.tieba.ala.tasklist.model.a;
/* loaded from: classes6.dex */
public class AlaTaskListActivity extends BaseActivity<AlaTaskListActivity> implements View.OnClickListener, View.OnTouchListener {
    private CommonEmptyView dFw;
    private View deR;
    public a eCH;
    private com.baidu.tieba.ala.tasklist.view.a eCI;
    public TextView eCJ;
    public ImageView eCK;
    public TextView eCL;
    public TextView eCM;
    private AlertDialog eCO;
    private LinearLayout eCP;
    private boolean eCQ;
    private int eCR;
    private boolean eCS;
    public BdListView mListView;
    private View mRootView;
    private boolean eCN = false;
    a.InterfaceC0389a eCT = new a.InterfaceC0389a() { // from class: com.baidu.tieba.ala.tasklist.AlaTaskListActivity.3
        @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0389a
        public void a(AlaLiveUserInfoData alaLiveUserInfoData, q qVar) {
            if (alaLiveUserInfoData != null) {
                AlaTaskListActivity.this.Z(String.valueOf(alaLiveUserInfoData.petalNum), true);
                TbadkCoreApplication.getInst().currentAccountFlowerNum = alaLiveUserInfoData.petalNum;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
            } else {
                AlaTaskListActivity.this.Z("", false);
            }
            if (qVar != null) {
                AlaTaskListActivity.this.eCI.setData(qVar.SC);
            }
            AlaTaskListActivity.this.aYJ();
        }

        @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0389a
        public void P(int i, String str) {
            AlaTaskListActivity.this.dFw.reset();
            AlaTaskListActivity.this.dFw.setTitle(a.i.ala_task_empty_msg);
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                AlaTaskListActivity.this.dFw.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
            } else {
                AlaTaskListActivity.this.dFw.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.AlaTaskListActivity.3.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaTaskListActivity.this.aNQ();
                    }
                });
                AlaTaskListActivity.this.dFw.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
            }
            AlaTaskListActivity.this.dFw.setVisibility(0);
            if (i == 146021) {
                AlaTaskListActivity.this.aYL();
            } else if (AlaTaskListActivity.this.eCH.aYO() != null && ListUtils.getCount(AlaTaskListActivity.this.eCH.aYO().SC) > 0) {
                AlaTaskListActivity.this.showToast(str);
            }
        }
    };
    CustomMessageListener agm = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.tasklist.AlaTaskListActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaTaskListActivity.this.closeActivity();
        }
    };
    CustomMessageListener eCU = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.AlaTaskListActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                AlaTaskListActivity.this.eCI.c((Integer) customResponsedMessage.getData());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags(67108864);
            getWindow().addFlags(134217728);
        }
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        this.eCQ = getIntent().getBooleanExtra("is_from_flower_guide", false);
        initView();
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        if (screenDimensions[1] > screenDimensions[0]) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eCP.getLayoutParams();
            layoutParams.height = (int) (screenDimensions[1] * 0.618d);
            this.eCP.setLayoutParams(layoutParams);
        } else {
            finish();
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                g.P(this.mRootView);
            }
            this.eCP.setPadding(0, getResources().getDimensionPixelSize(a.e.sdk_ds48), 0, 0);
        }
        this.eCH = new com.baidu.tieba.ala.tasklist.model.a(getPageContext());
        this.eCH.a(this.eCT);
        registerListener(this.agm);
        registerListener(this.eCU);
        aNQ();
    }

    private void initView() {
        this.mRootView = getPageContext().getPageActivity().getLayoutInflater().inflate(a.h.ala_task_list_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.eCP = (LinearLayout) this.mRootView.findViewById(a.g.layout_content);
        this.eCJ = (TextView) this.mRootView.findViewById(a.g.tv_flower_task_title);
        this.eCK = (ImageView) this.mRootView.findViewById(a.g.img_flower_help);
        this.deR = this.mRootView.findViewById(a.g.divider);
        this.eCL = (TextView) this.mRootView.findViewById(a.g.tv_flower_count);
        this.eCM = (TextView) this.mRootView.findViewById(a.g.tv_task_help_tips);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.detail_list);
        this.dFw = (CommonEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.eCI = new com.baidu.tieba.ala.tasklist.view.a(this);
        this.mListView.setAdapter((ListAdapter) this.eCI);
        this.mListView.setEmptyView(this.dFw);
        this.mRootView.setOnTouchListener(this);
        this.eCP.setOnTouchListener(this);
        this.eCK.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNQ() {
        this.dFw.setVisibility(8);
        this.eCH.aYR();
    }

    public void oo(int i) {
        this.eCH.oo(i);
    }

    public void aYJ() {
        p ot;
        if (this.eCQ && this.eCR < 3 && (ot = this.eCI.ot()) != null) {
            if (ot.status == 2) {
                oo(ot.Su);
                this.eCR++;
                this.eCS = true;
                return;
            }
            this.eCQ = false;
            if (this.eCS) {
                this.eCS = false;
                op(ot.Sz);
            }
        }
    }

    private void op(int i) {
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
                    AlaTaskListActivity.this.aKu();
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

    private void aIH() {
        if (this instanceof Activity) {
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                overridePendingTransition(a.C0068a.sdk_activity_open_translate_from_right, a.C0068a.sdk_activity_close_translate_to_right);
            } else {
                overridePendingTransition(a.C0068a.sdk_activity_open_translate_from_bottom, a.C0068a.sdk_activity_close_translate_from_top);
            }
        } else if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
            overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_in_from_right", "anim"), Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_out_to_right", "anim"));
        } else {
            overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_in_from_bottom", "anim"), Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_out_to_bottom", "anim"));
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity
    public void enterExitAnimation() {
        aIH();
    }

    @Override // com.baidu.live.tbadk.BaseActivity
    public void closeAnimation() {
        aIH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eCH != null) {
            this.eCH.onDestroy();
        }
    }

    public void aKu() {
        an anVar;
        Intent intent = new Intent();
        intent.putExtra("need_show_gift_panel", true);
        af afVar = com.baidu.live.l.a.uA().akM;
        intent.putExtra("custom_category_id", (afVar == null || afVar.Ue == null || (anVar = afVar.Ue.UL) == null) ? -1 : anVar.UV);
        setResult(-1, intent);
        finish();
    }

    public void aYK() {
        setResult(0, new Intent());
        finish();
    }

    public void Z(String str, boolean z) {
        this.eCL.setVisibility(z ? 0 : 8);
        this.eCL.setText(str);
    }

    public void aYL() {
        this.eCO = new AlertDialog.Builder(getPageContext().getPageActivity()).create();
        ShowUtil.showDialog(this.eCO, getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_flower_over_limit_dialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(a.g.tv_task_failed_content)).setText(aYM());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.AlaTaskListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaTaskListActivity.this.eCO.dismiss();
            }
        });
        inflate.findViewById(a.g.close_img).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.AlaTaskListActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaTaskListActivity.this.eCO.dismiss();
            }
        });
        inflate.findViewById(a.g.btn_to_send_gift).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.AlaTaskListActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaTaskListActivity.this.eCO.dismiss();
                AlaTaskListActivity.this.aKu();
            }
        });
        Window window = this.eCO.getWindow();
        window.setWindowAnimations(a.j.sdk_share_dialog_style);
        window.setGravity(17);
        window.setDimAmount(0.0f);
        window.setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.d.sdk_black_alpha35)));
        window.setLayout(-1, -1);
        window.setContentView(inflate);
    }

    public SpannableStringBuilder aYM() {
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
            if (view == this.eCP) {
                z = true;
                if (this.eCN) {
                    hideTip();
                }
            } else {
                aYK();
            }
        }
        return z;
    }

    private void hideTip() {
        this.eCN = false;
        this.deR.setVisibility(0);
        this.eCM.setVisibility(8);
    }

    @Override // com.baidu.live.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eCK) {
            if (this.eCN) {
                hideTip();
            } else {
                aYN();
            }
        }
    }

    private void aYN() {
        this.eCN = true;
        this.deR.setVisibility(8);
        this.eCM.setVisibility(0);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            finish();
        }
    }
}
