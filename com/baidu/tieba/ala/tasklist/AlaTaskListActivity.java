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
import com.baidu.live.data.ap;
import com.baidu.live.data.ba;
import com.baidu.live.data.u;
import com.baidu.live.data.v;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.u.a;
import com.baidu.live.utils.h;
import com.baidu.megapp.ma.Util;
import com.baidu.tieba.ala.tasklist.model.a;
/* loaded from: classes3.dex */
public class AlaTaskListActivity extends BaseActivity<AlaTaskListActivity> implements View.OnClickListener, View.OnTouchListener {
    private View cel;
    private CommonEmptyView evQ;
    public a fzh;
    private com.baidu.tieba.ala.tasklist.view.a fzi;
    public TextView fzj;
    public ImageView fzk;
    public TextView fzl;
    public TextView fzm;
    private AlertDialog fzo;
    private LinearLayout fzp;
    private boolean fzq;
    private int fzr;
    private boolean fzs;
    public BdListView mListView;
    private View mRootView;
    private boolean fzn = false;
    a.InterfaceC0485a fzt = new a.InterfaceC0485a() { // from class: com.baidu.tieba.ala.tasklist.AlaTaskListActivity.3
        @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0485a
        public void a(AlaLiveUserInfoData alaLiveUserInfoData, v vVar) {
            if (alaLiveUserInfoData != null) {
                AlaTaskListActivity.this.ad(String.valueOf(alaLiveUserInfoData.petalNum), true);
                TbadkCoreApplication.getInst().currentAccountFlowerNum = alaLiveUserInfoData.petalNum;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
            } else {
                AlaTaskListActivity.this.ad("", false);
            }
            if (vVar != null) {
                AlaTaskListActivity.this.fzi.setData(vVar.abf);
            }
            AlaTaskListActivity.this.bto();
        }

        @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0485a
        public void ag(int i, String str) {
            AlaTaskListActivity.this.evQ.reset();
            AlaTaskListActivity.this.evQ.setTitle(a.i.ala_task_empty_msg);
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                AlaTaskListActivity.this.evQ.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
            } else {
                AlaTaskListActivity.this.evQ.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.AlaTaskListActivity.3.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaTaskListActivity.this.bhR();
                    }
                });
                AlaTaskListActivity.this.evQ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
            }
            AlaTaskListActivity.this.evQ.setVisibility(0);
            if (i == 146021) {
                AlaTaskListActivity.this.btq();
            } else if (AlaTaskListActivity.this.fzh.btt() != null && ListUtils.getCount(AlaTaskListActivity.this.fzh.btt().abf) > 0) {
                AlaTaskListActivity.this.showToast(str);
            }
        }
    };
    CustomMessageListener agU = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.tasklist.AlaTaskListActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaTaskListActivity.this.closeActivity();
        }
    };
    CustomMessageListener fzu = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.AlaTaskListActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                AlaTaskListActivity.this.fzi.i((Integer) customResponsedMessage.getData());
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
        this.fzq = getIntent().getBooleanExtra("is_from_flower_guide", false);
        initView();
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        if (screenDimensions[1] > screenDimensions[0]) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fzp.getLayoutParams();
            layoutParams.height = (int) (screenDimensions[1] * 0.618d);
            this.fzp.setLayoutParams(layoutParams);
        } else {
            finish();
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                h.S(this.mRootView);
            }
            this.fzp.setPadding(0, getResources().getDimensionPixelSize(a.e.sdk_ds48), 0, 0);
        }
        this.fzh = new com.baidu.tieba.ala.tasklist.model.a(getPageContext());
        this.fzh.a(this.fzt);
        registerListener(this.agU);
        registerListener(this.fzu);
        bhR();
    }

    private void initView() {
        this.mRootView = getPageContext().getPageActivity().getLayoutInflater().inflate(a.h.ala_task_list_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.fzp = (LinearLayout) this.mRootView.findViewById(a.g.layout_content);
        this.fzj = (TextView) this.mRootView.findViewById(a.g.tv_flower_task_title);
        this.fzk = (ImageView) this.mRootView.findViewById(a.g.img_flower_help);
        this.cel = this.mRootView.findViewById(a.g.divider);
        this.fzl = (TextView) this.mRootView.findViewById(a.g.tv_flower_count);
        this.fzm = (TextView) this.mRootView.findViewById(a.g.tv_task_help_tips);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.detail_list);
        this.evQ = (CommonEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.fzi = new com.baidu.tieba.ala.tasklist.view.a(this);
        this.mListView.setAdapter((ListAdapter) this.fzi);
        this.mListView.setEmptyView(this.evQ);
        this.mRootView.setOnTouchListener(this);
        this.fzp.setOnTouchListener(this);
        this.fzk.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhR() {
        this.evQ.setVisibility(8);
        this.fzh.btw();
    }

    public void qT(int i) {
        this.fzh.qT(i);
    }

    public void bto() {
        u qD;
        if (this.fzq && this.fzr < 3 && (qD = this.fzi.qD()) != null) {
            if (qD.status == 2) {
                qT(qD.aaW);
                this.fzr++;
                this.fzs = true;
                return;
            }
            this.fzq = false;
            if (this.fzs) {
                this.fzs = false;
                qU(qD.abb);
            }
        }
    }

    private void qU(int i) {
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
                    AlaTaskListActivity.this.bdN();
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

    private void bbD() {
        if (this instanceof Activity) {
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                overridePendingTransition(a.C0102a.sdk_activity_open_translate_from_right, a.C0102a.sdk_activity_close_translate_to_right);
            } else {
                overridePendingTransition(a.C0102a.sdk_activity_open_translate_from_bottom, a.C0102a.sdk_activity_close_translate_from_top);
            }
        } else if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
            overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_in_from_right", ResUtils.ANIM), Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_out_to_right", ResUtils.ANIM));
        } else {
            overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_in_from_bottom", ResUtils.ANIM), Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_out_to_bottom", ResUtils.ANIM));
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity
    public void enterExitAnimation() {
        bbD();
    }

    @Override // com.baidu.live.tbadk.BaseActivity
    public void closeAnimation() {
        bbD();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fzh != null) {
            this.fzh.onDestroy();
        }
    }

    public void bdN() {
        ba baVar;
        Intent intent = new Intent();
        intent.putExtra("need_show_gift_panel", true);
        ap apVar = com.baidu.live.v.a.zj().axB;
        intent.putExtra("custom_category_id", (apVar == null || apVar.acS == null || (baVar = apVar.acS.adO) == null) ? -1 : baVar.adZ);
        setResult(-1, intent);
        finish();
    }

    public void btp() {
        setResult(0, new Intent());
        finish();
    }

    public void ad(String str, boolean z) {
        this.fzl.setVisibility(z ? 0 : 8);
        this.fzl.setText(str);
    }

    public void btq() {
        ColorStateList colorStateList;
        this.fzo = new AlertDialog.Builder(getPageContext().getPageActivity(), a.j.sdk_dialog_window).create();
        ShowUtil.showDialog(this.fzo, getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_flower_over_limit_dialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(a.g.tv_task_failed_content)).setText(btr());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.AlaTaskListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaTaskListActivity.this.fzo.dismiss();
            }
        });
        inflate.findViewById(a.g.close_img).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.AlaTaskListActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaTaskListActivity.this.fzo.dismiss();
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
                AlaTaskListActivity.this.fzo.dismiss();
                AlaTaskListActivity.this.bdN();
            }
        });
        Window window = this.fzo.getWindow();
        window.setGravity(17);
        window.setBackgroundDrawableResource(17170445);
        window.setContentView(inflate);
    }

    public SpannableStringBuilder btr() {
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
            if (view == this.fzp) {
                z = true;
                if (this.fzn) {
                    hideTip();
                }
            } else {
                btp();
            }
        }
        return z;
    }

    private void hideTip() {
        this.fzn = false;
        this.cel.setVisibility(0);
        this.fzm.setVisibility(8);
    }

    @Override // com.baidu.live.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fzk) {
            if (this.fzn) {
                hideTip();
            } else {
                bts();
            }
        }
    }

    private void bts() {
        this.fzn = true;
        this.cel.setVisibility(8);
        this.fzm.setVisibility(0);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            finish();
        }
    }
}
