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
import com.baidu.live.data.as;
import com.baidu.live.data.bd;
import com.baidu.live.data.w;
import com.baidu.live.data.x;
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
    private View cDC;
    private CommonEmptyView faG;
    public a geL;
    private com.baidu.tieba.ala.tasklist.view.a geM;
    public TextView geN;
    public ImageView geO;
    public TextView geP;
    public TextView geQ;
    private AlertDialog geS;
    private LinearLayout geT;
    private boolean geU;
    private int geV;
    private boolean geW;
    public BdListView mListView;
    private View mRootView;
    private boolean geR = false;
    a.InterfaceC0542a geX = new a.InterfaceC0542a() { // from class: com.baidu.tieba.ala.tasklist.AlaTaskListActivity.3
        @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0542a
        public void a(AlaLiveUserInfoData alaLiveUserInfoData, x xVar) {
            if (alaLiveUserInfoData != null) {
                AlaTaskListActivity.this.aj(String.valueOf(alaLiveUserInfoData.petalNum), true);
                TbadkCoreApplication.getInst().currentAccountFlowerNum = alaLiveUserInfoData.petalNum;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
            } else {
                AlaTaskListActivity.this.aj("", false);
            }
            if (xVar != null) {
                AlaTaskListActivity.this.geM.setData(xVar.atP);
            }
            AlaTaskListActivity.this.bDd();
        }

        @Override // com.baidu.tieba.ala.tasklist.model.a.InterfaceC0542a
        public void av(int i, String str) {
            AlaTaskListActivity.this.faG.reset();
            AlaTaskListActivity.this.faG.setTitle(a.i.ala_task_empty_msg);
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                AlaTaskListActivity.this.faG.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
            } else {
                AlaTaskListActivity.this.faG.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.AlaTaskListActivity.3.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaTaskListActivity.this.bnh();
                    }
                });
                AlaTaskListActivity.this.faG.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
            }
            AlaTaskListActivity.this.faG.setVisibility(0);
            if (i == 146021) {
                AlaTaskListActivity.this.bDf();
            } else if (AlaTaskListActivity.this.geL.bDi() != null && ListUtils.getCount(AlaTaskListActivity.this.geL.bDi().atP) > 0) {
                AlaTaskListActivity.this.showToast(str);
            }
        }
    };
    CustomMessageListener azA = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.tasklist.AlaTaskListActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaTaskListActivity.this.closeActivity();
        }
    };
    CustomMessageListener geY = new CustomMessageListener(2913035) { // from class: com.baidu.tieba.ala.tasklist.AlaTaskListActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                AlaTaskListActivity.this.geM.i((Integer) customResponsedMessage.getData());
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
            this.geU = getIntent().getBooleanExtra("is_from_flower_guide", false);
            initView();
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
            if (screenDimensions[1] > screenDimensions[0]) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.geT.getLayoutParams();
                layoutParams.height = (int) (screenDimensions[1] * 0.618d);
                this.geT.setLayoutParams(layoutParams);
            } else {
                finish();
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    h.U(this.mRootView);
                }
                this.geT.setPadding(0, getResources().getDimensionPixelSize(a.e.sdk_ds48), 0, 0);
            }
            this.geL = new com.baidu.tieba.ala.tasklist.model.a(getPageContext());
            this.geL.a(this.geX);
            registerListener(this.azA);
            registerListener(this.geY);
            bnh();
        }
    }

    private void initView() {
        this.mRootView = getPageContext().getPageActivity().getLayoutInflater().inflate(a.h.ala_task_list_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.geT = (LinearLayout) this.mRootView.findViewById(a.g.layout_content);
        this.geN = (TextView) this.mRootView.findViewById(a.g.tv_flower_task_title);
        this.geO = (ImageView) this.mRootView.findViewById(a.g.img_flower_help);
        this.cDC = this.mRootView.findViewById(a.g.divider);
        this.geP = (TextView) this.mRootView.findViewById(a.g.tv_flower_count);
        this.geQ = (TextView) this.mRootView.findViewById(a.g.tv_task_help_tips);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.detail_list);
        this.faG = (CommonEmptyView) this.mRootView.findViewById(a.g.emptyView);
        this.geM = new com.baidu.tieba.ala.tasklist.view.a(this);
        this.mListView.setAdapter((ListAdapter) this.geM);
        this.mListView.setEmptyView(this.faG);
        this.mRootView.setOnTouchListener(this);
        this.geT.setOnTouchListener(this);
        this.geO.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnh() {
        this.faG.setVisibility(8);
        this.geL.bDl();
    }

    public void ro(int i) {
        this.geL.ro(i);
    }

    public void bDd() {
        w uY;
        if (this.geU && this.geV < 3 && (uY = this.geM.uY()) != null) {
            if (uY.status == 2) {
                ro(uY.atH);
                this.geV++;
                this.geW = true;
                return;
            }
            this.geU = false;
            if (this.geW) {
                this.geW = false;
                rp(uY.atM);
            }
        }
    }

    private void rp(int i) {
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
                    AlaTaskListActivity.this.bne();
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

    private void bjL() {
        if (this instanceof Activity) {
            if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
                overridePendingTransition(a.C0149a.sdk_activity_open_translate_from_right, a.C0149a.sdk_activity_close_translate_to_right);
            } else {
                overridePendingTransition(a.C0149a.sdk_activity_open_translate_from_bottom, a.C0149a.sdk_activity_close_translate_from_top);
            }
        } else if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
            overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_in_from_right", ResUtils.ANIM), Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_out_to_right", ResUtils.ANIM));
        } else {
            overridePendingTransition(Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_in_from_bottom", ResUtils.ANIM), Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_out_to_bottom", ResUtils.ANIM));
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity
    public void enterExitAnimation() {
        bjL();
    }

    @Override // com.baidu.live.tbadk.BaseActivity
    public void closeAnimation() {
        bjL();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.geL != null) {
            this.geL.onDestroy();
        }
    }

    public void bne() {
        bd bdVar;
        Intent intent = new Intent();
        intent.putExtra("need_show_gift_panel", true);
        as asVar = com.baidu.live.v.a.En().aRB;
        intent.putExtra("custom_category_id", (asVar == null || asVar.avA == null || (bdVar = asVar.avA.awv) == null) ? -1 : bdVar.awF);
        setResult(-1, intent);
        finish();
    }

    public void bDe() {
        setResult(0, new Intent());
        finish();
    }

    public void aj(String str, boolean z) {
        this.geP.setVisibility(z ? 0 : 8);
        this.geP.setText(str);
    }

    public void bDf() {
        ColorStateList colorStateList;
        this.geS = new AlertDialog.Builder(getPageContext().getPageActivity(), a.j.sdk_dialog_window).create();
        ShowUtil.showDialog(this.geS, getPageContext().getPageActivity());
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_flower_over_limit_dialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(a.g.tv_task_failed_content)).setText(bDg());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.AlaTaskListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaTaskListActivity.this.geS.dismiss();
            }
        });
        inflate.findViewById(a.g.close_img).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.tasklist.AlaTaskListActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaTaskListActivity.this.geS.dismiss();
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
                AlaTaskListActivity.this.geS.dismiss();
                AlaTaskListActivity.this.bne();
            }
        });
        Window window = this.geS.getWindow();
        window.setGravity(17);
        window.setBackgroundDrawableResource(17170445);
        window.setContentView(inflate);
    }

    public SpannableStringBuilder bDg() {
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
            if (view == this.geT) {
                z = true;
                if (this.geR) {
                    hideTip();
                }
            } else {
                bDe();
            }
        }
        return z;
    }

    private void hideTip() {
        this.geR = false;
        this.cDC.setVisibility(0);
        this.geQ.setVisibility(8);
    }

    @Override // com.baidu.live.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.geO) {
            if (this.geR) {
                hideTip();
            } else {
                bDh();
            }
        }
    }

    private void bDh() {
        this.geR = true;
        this.cDC.setVisibility(8);
        this.geQ.setVisibility(0);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            finish();
        }
    }
}
