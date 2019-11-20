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
    private CommonEmptyView dEF;
    private View ddZ;
    public a eBQ;
    private com.baidu.tieba.ala.tasklist.view.a eBR;
    public TextView eBS;
    public ImageView eBT;
    public TextView eBU;
    public TextView eBV;
    private AlertDialog eBX;
    private LinearLayout eBY;
    private boolean eBZ;
    private int eCa;
    private boolean eCb;
    public BdListView mListView;
    private View mRootView;
    private boolean eBW = false;
    a.InterfaceC0389a eCc = new a.InterfaceC0389a() { // from class: com.baidu.tieba.ala.tasklist.AlaTaskListActivity.3
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
                AlaTaskListActivity.this.eBR.setData(qVar.Sj);
            }
            AlaTaskListActivity.this.aYH();
        }

        @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0389a
        public void O(int i, String str) {
            AlaTaskListActivity.this.dEF.reset();
            AlaTaskListActivity.this.dEF.setTitle(a.i.ala_task_empty_msg);
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                AlaTaskListActivity.this.dEF.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
            } else {
                AlaTaskListActivity.this.dEF.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.AlaTaskListActivity.3.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaTaskListActivity.this.aNO();
                    }
                });
                AlaTaskListActivity.this.dEF.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
            }
            AlaTaskListActivity.this.dEF.setVisibility(0);
            if (i == 146021) {
                AlaTaskListActivity.this.aYJ();
            } else if (AlaTaskListActivity.this.eBQ.aYM() != null && ListUtils.getCount(AlaTaskListActivity.this.eBQ.aYM().Sj) > 0) {
                AlaTaskListActivity.this.showToast(str);
            }
        }
    };
    CustomMessageListener afT = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.tasklist.AlaTaskListActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaTaskListActivity.this.closeActivity();
        }
    };
    CustomMessageListener eCd = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.AlaTaskListActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                AlaTaskListActivity.this.eBR.c((Integer) customResponsedMessage.getData());
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
        this.eBZ = getIntent().getBooleanExtra("is_from_flower_guide", false);
        initView();
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        if (screenDimensions[1] > screenDimensions[0]) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eBY.getLayoutParams();
            layoutParams.height = (int) (screenDimensions[1] * 0.618d);
            this.eBY.setLayoutParams(layoutParams);
        } else {
            finish();
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                g.P(this.mRootView);
            }
            this.eBY.setPadding(0, getResources().getDimensionPixelSize(a.e.sdk_ds48), 0, 0);
        }
        this.eBQ = new com.baidu.tieba.ala.tasklist.model.a(getPageContext());
        this.eBQ.a(this.eCc);
        registerListener(this.afT);
        registerListener(this.eCd);
        aNO();
    }

    private void initView() {
        this.mRootView = getPageContext().getPageActivity().getLayoutInflater().inflate(a.h.ala_task_list_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.eBY = (LinearLayout) this.mRootView.findViewById(a.g.layout_content);
        this.eBS = (TextView) this.mRootView.findViewById(a.g.tv_flower_task_title);
        this.eBT = (ImageView) this.mRootView.findViewById(a.g.img_flower_help);
        this.ddZ = this.mRootView.findViewById(a.g.divider);
        this.eBU = (TextView) this.mRootView.findViewById(a.g.tv_flower_count);
        this.eBV = (TextView) this.mRootView.findViewById(a.g.tv_task_help_tips);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.detail_list);
        this.dEF = (CommonEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.eBR = new com.baidu.tieba.ala.tasklist.view.a(this);
        this.mListView.setAdapter((ListAdapter) this.eBR);
        this.mListView.setEmptyView(this.dEF);
        this.mRootView.setOnTouchListener(this);
        this.eBY.setOnTouchListener(this);
        this.eBT.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNO() {
        this.dEF.setVisibility(8);
        this.eBQ.aYP();
    }

    public void on(int i) {
        this.eBQ.on(i);
    }

    public void aYH() {
        p ot;
        if (this.eBZ && this.eCa < 3 && (ot = this.eBR.ot()) != null) {
            if (ot.status == 2) {
                on(ot.Sb);
                this.eCa++;
                this.eCb = true;
                return;
            }
            this.eBZ = false;
            if (this.eCb) {
                this.eCb = false;
                oo(ot.Sg);
            }
        }
    }

    private void oo(int i) {
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
                    AlaTaskListActivity.this.aKs();
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

    private void aIF() {
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
        aIF();
    }

    @Override // com.baidu.live.tbadk.BaseActivity
    public void closeAnimation() {
        aIF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eBQ != null) {
            this.eBQ.onDestroy();
        }
    }

    public void aKs() {
        an anVar;
        Intent intent = new Intent();
        intent.putExtra("need_show_gift_panel", true);
        af afVar = com.baidu.live.l.a.uB().aku;
        intent.putExtra("custom_category_id", (afVar == null || afVar.TK == null || (anVar = afVar.TK.Uq) == null) ? -1 : anVar.Uz);
        setResult(-1, intent);
        finish();
    }

    public void aYI() {
        setResult(0, new Intent());
        finish();
    }

    public void Z(String str, boolean z) {
        this.eBU.setVisibility(z ? 0 : 8);
        this.eBU.setText(str);
    }

    public void aYJ() {
        this.eBX = new AlertDialog.Builder(getPageContext().getPageActivity()).create();
        ShowUtil.showDialog(this.eBX, getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_flower_over_limit_dialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(a.g.tv_task_failed_content)).setText(aYK());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.AlaTaskListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaTaskListActivity.this.eBX.dismiss();
            }
        });
        inflate.findViewById(a.g.close_img).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.AlaTaskListActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaTaskListActivity.this.eBX.dismiss();
            }
        });
        inflate.findViewById(a.g.btn_to_send_gift).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.AlaTaskListActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaTaskListActivity.this.eBX.dismiss();
                AlaTaskListActivity.this.aKs();
            }
        });
        Window window = this.eBX.getWindow();
        window.setWindowAnimations(a.j.sdk_share_dialog_style);
        window.setGravity(17);
        window.setDimAmount(0.0f);
        window.setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.d.sdk_black_alpha35)));
        window.setLayout(-1, -1);
        window.setContentView(inflate);
    }

    public SpannableStringBuilder aYK() {
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
            if (view == this.eBY) {
                z = true;
                if (this.eBW) {
                    hideTip();
                }
            } else {
                aYI();
            }
        }
        return z;
    }

    private void hideTip() {
        this.eBW = false;
        this.ddZ.setVisibility(0);
        this.eBV.setVisibility(8);
    }

    @Override // com.baidu.live.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eBT) {
            if (this.eBW) {
                hideTip();
            } else {
                aYL();
            }
        }
    }

    private void aYL() {
        this.eBW = true;
        this.ddZ.setVisibility(8);
        this.eBV.setVisibility(0);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            finish();
        }
    }
}
