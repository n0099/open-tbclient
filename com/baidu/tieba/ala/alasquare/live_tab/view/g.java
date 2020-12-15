package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Build;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveTabMyConcernActivityConfig;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.AlaPersonCenterActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.b.h;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpHost;
/* loaded from: classes6.dex */
public class g extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.b.i> {
    private ImageView gvA;
    private ObjectAnimator gvB;
    private int gvC;
    private List<h.a> gvD;
    private String gvE;
    private com.baidu.tieba.ueg.d gvF;
    private LinearLayout gvi;
    private HeadImageView gvj;
    private ImageView gvk;
    private TextView gvl;
    private LinearLayout gvm;
    private ImageView gvn;
    private TextView gvo;
    private LinearLayout gvp;
    private ImageView gvq;
    private TextView gvr;
    private LinearLayout gvs;
    private ImageView gvt;
    private TextView gvu;
    private LinearLayout gvv;
    private ImageView gvw;
    private TextView gvx;
    private ImageView gvy;
    private ImageView gvz;
    private View mRootView;
    private RotateAnimation mRotateAnimation;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gvC = -1;
        this.gvD = new ArrayList();
        initView();
    }

    private void initView() {
        this.mRootView = getView();
        this.gvi = (LinearLayout) this.mRootView.findViewById(R.id.entrance_follow);
        this.gvm = (LinearLayout) this.mRootView.findViewById(R.id.entrance_ranklist);
        this.gvp = (LinearLayout) this.mRootView.findViewById(R.id.entrance_discuss);
        this.gvs = (LinearLayout) this.mRootView.findViewById(R.id.entrance_person_center);
        this.gvz = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_img_diandian);
        this.gvv = (LinearLayout) this.mRootView.findViewById(R.id.entrance_start_recorder);
        this.gvj = (HeadImageView) this.mRootView.findViewById(R.id.entrance_follow_img);
        this.gvj.setIsRound(true);
        this.gvj.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gvj.setDefaultResource(17170445);
        this.gvj.setDefaultBgResource(17170445);
        this.gvA = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_circle);
        this.gvk = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_default_img);
        this.gvn = (ImageView) this.mRootView.findViewById(R.id.entrance_ranklist_img);
        this.gvq = (ImageView) this.mRootView.findViewById(R.id.entrance_discuss_img);
        this.gvt = (ImageView) this.mRootView.findViewById(R.id.entrance_person_center_img);
        this.gvw = (ImageView) this.mRootView.findViewById(R.id.entrance_start_recorder_img);
        this.gvl = (TextView) this.mRootView.findViewById(R.id.entrance_follow_desc);
        this.gvo = (TextView) this.mRootView.findViewById(R.id.entrance_ranklist_desc);
        this.gvr = (TextView) this.mRootView.findViewById(R.id.entrance_discuss_desc);
        this.gvu = (TextView) this.mRootView.findViewById(R.id.entrance_person_center_desc);
        this.gvx = (TextView) this.mRootView.findViewById(R.id.entrance_start_recorder_desc);
        this.gvy = (ImageView) this.mRootView.findViewById(R.id.entrance_publish_live_red);
        this.gvi.setOnClickListener(this);
        this.gvm.setOnClickListener(this);
        this.gvp.setOnClickListener(this);
        this.gvs.setOnClickListener(this);
        this.gvv.setOnClickListener(this);
        this.mRotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation.setDuration(6000L);
        this.mRotateAnimation.setRepeatMode(1);
        this.mRotateAnimation.setRepeatCount(-1);
        this.mRotateAnimation.setInterpolator(new LinearInterpolator());
        this.gvB = ObjectAnimator.ofPropertyValuesHolder(this.gvj, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f));
        this.gvB.setInterpolator(new DecelerateInterpolator());
        this.gvB.setTarget(this.gvj);
        this.gvB.setRepeatCount(-1);
        this.gvB.setRepeatMode(1);
        this.gvB.setDuration(2000L);
        this.gvB.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                g.this.bSE();
            }
        });
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        ap.setViewTextColor(this.gvl, (int) R.drawable.tab_super_entrance_txt_selecor);
        ap.setViewTextColor(this.gvo, (int) R.drawable.tab_super_entrance_txt_selecor);
        ap.setViewTextColor(this.gvr, (int) R.drawable.tab_super_entrance_txt_selecor);
        ap.setViewTextColor(this.gvu, (int) R.drawable.tab_super_entrance_txt_selecor);
        ap.setViewTextColor(this.gvx, (int) R.drawable.tab_super_entrance_txt_selecor);
        ap.setImageResource(this.gvn, R.drawable.super_entrance_ranklist_bg_selector);
        ap.setImageResource(this.gvq, R.drawable.super_entrance_discuss_bg_selector);
        ap.setImageResource(this.gvt, R.drawable.super_entrance_person_bg_selector);
        ap.setImageResource(this.gvw, R.drawable.super_entrance_start_recorder_bg_selector);
        ap.setImageResource(this.gvA, R.drawable.pic_live_tab_quan);
        if (8 == this.gvz.getVisibility()) {
            this.gvk.setVisibility(0);
            this.gvA.setVisibility(8);
            ap.setBackgroundResource(this.gvk, R.drawable.super_entrance_follow_bg_selector);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_live_super_enreances_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.i iVar) {
        if (iVar == null || iVar.grU == null) {
            stopAnim();
            return;
        }
        TiebaStatic.log("c13550");
        TiebaStatic.log("c13549");
        TiebaStatic.log("c13547");
        TiebaStatic.log("c13546");
        this.gvE = iVar.grU.grR;
        if (!iVar.grU.grP || y.isEmpty(iVar.grU.grQ)) {
            stopAnim();
            return;
        }
        this.gvD = iVar.grU.grQ;
        if (!y.isEmpty(this.gvD)) {
            startAnim();
            bSE();
        }
    }

    public void mi(boolean z) {
        if (this.gvy != null) {
            if (z) {
                if (!com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), false)) {
                    com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), true);
                    this.gvy.setVisibility(0);
                    return;
                }
                this.gvy.setVisibility(8);
                return;
            }
            this.gvy.setVisibility(8);
        }
    }

    private void startAnim() {
        this.gvk.setVisibility(8);
        this.gvz.setVisibility(0);
        this.gvA.setVisibility(0);
        this.gvj.setVisibility(0);
        this.gvz.clearAnimation();
        if (this.mRotateAnimation != null) {
            this.gvz.startAnimation(this.mRotateAnimation);
        }
        if (this.gvB != null) {
            if (this.gvB.isRunning()) {
                this.gvB.cancel();
            }
            this.gvB.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSE() {
        if (this.gvj != null && !y.isEmpty(this.gvD)) {
            this.gvC++;
            if (this.gvD.size() > this.gvC) {
                this.gvj.startLoad(this.gvD.get(this.gvC).portrait, 12, false);
            } else if (this.gvD.size() > 0) {
                this.gvC = 0;
                this.gvj.startLoad(this.gvD.get(this.gvC).portrait, 12, false);
            }
        }
    }

    private void stopAnim() {
        this.gvz.setVisibility(8);
        this.gvA.setVisibility(8);
        this.gvj.setVisibility(8);
        this.gvz.clearAnimation();
        if (this.gvB != null) {
            this.gvB.cancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gvi) {
            if (bh.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTabMyConcernActivityConfig(getTbPageContext().getPageActivity())));
            }
            TiebaStatic.log("c13552");
        } else if (view == this.gvm) {
            if (!StringUtils.isNull(this.gvE)) {
                com.baidu.tbadk.browser.a.startWebActivity(this.mContext.getApplicationContext(), getContext().getResources().getString(R.string.entrance_ranklist_tip), this.gvE, true, true, true, true, true, true, true);
                TiebaStatic.log("c13553");
            }
        } else if (view == this.gvp) {
            String string = com.baidu.tbadk.core.sharedPref.b.bsO().getString("show_live_forum_url", "http://tieba.baidu.com/f?kw=百度直播");
            string = (StringUtils.isNull(string) || !string.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) ? "http://tieba.baidu.com/f?kw=百度直播" : "http://tieba.baidu.com/f?kw=百度直播";
            if (!string.contains("?")) {
                string = string + "?default_tab_id=1&call_from=15";
            } else if (!string.contains("&default_tab_id=")) {
                string = string + "&default_tab_id=1&call_from=15";
            }
            bf.bua().a(this.mTbPageContext, new String[]{string}, true);
            TiebaStatic.log("c13554");
        } else if (view == this.gvs) {
            if (bh.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(this.mTbPageContext.getPageActivity(), String.valueOf(TbadkCoreApplication.getCurrentAccountId()), TbadkCoreApplication.getCurrentAccountName(), TbadkCoreApplication.getCurrentPortrait(), TbadkCoreApplication.getCurrentAccountInfo().getSex(), true)));
            }
            TiebaStatic.log("c13555");
        } else if (view == this.gvv) {
            bSF();
            TiebaStatic.log("c13617");
        }
    }

    private void bSF() {
        Plugin plugin2;
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getTbPageContext().getPageActivity());
            aVar.setAutoNight(false);
            aVar.oP(R.string.prompt);
            aVar.Bq(getContext().getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(getTbPageContext()).brv();
        } else if (bh.checkUpIsLogin(getTbPageContext().getPageActivity())) {
            if (this.gvF == null) {
                this.gvF = new com.baidu.tieba.ueg.d(getTbPageContext());
            }
            if (!this.gvF.dTh()) {
                if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                    com.baidu.adp.lib.util.l.showToast(getTbPageContext().getPageActivity(), (int) R.string.plugin_config_not_found);
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), true);
                this.gvy.setVisibility(8);
                o(getTbPageContext());
            }
        }
    }

    private void o(final TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.clearRequestPermissionList();
            permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE);
            permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_AUDIO_CAPTURE);
            permissionJudgePolicy.a(new PermissionJudgePolicy.b() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.3
                @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.b
                public void onPermissionsGranted() {
                    MessageManager.getInstance().sendMessage(new HttpMessage(1003303));
                    com.baidu.adp.lib.c.a.mk().getAddress(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaMasterLiveRoomActivityConfig(tbPageContext.getPageActivity(), null, "0", TbadkCoreApplication.getCurrentAccount(), null)));
                }
            });
            permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        super.onDestroy();
        stopAnim();
    }
}
