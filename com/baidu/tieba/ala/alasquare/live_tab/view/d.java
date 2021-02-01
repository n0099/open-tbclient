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
import com.baidu.adp.lib.util.l;
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
import com.baidu.tieba.ala.alasquare.live_tab.b.i;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpHost;
/* loaded from: classes10.dex */
public class d extends com.baidu.tieba.card.b<i> {
    private TextView gEA;
    private ImageView gEB;
    private ImageView gEC;
    private ImageView gED;
    private ObjectAnimator gEE;
    private int gEF;
    private List<h.a> gEG;
    private String gEH;
    private com.baidu.tieba.ueg.d gEI;
    private LinearLayout gEl;
    private HeadImageView gEm;
    private ImageView gEn;
    private TextView gEo;
    private LinearLayout gEp;
    private ImageView gEq;
    private TextView gEr;
    private LinearLayout gEs;
    private ImageView gEt;
    private TextView gEu;
    private LinearLayout gEv;
    private ImageView gEw;
    private TextView gEx;
    private LinearLayout gEy;
    private ImageView gEz;
    private View mRootView;
    private RotateAnimation mRotateAnimation;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gEF = -1;
        this.gEG = new ArrayList();
        initView();
    }

    private void initView() {
        this.mRootView = getView();
        this.gEl = (LinearLayout) this.mRootView.findViewById(R.id.entrance_follow);
        this.gEp = (LinearLayout) this.mRootView.findViewById(R.id.entrance_ranklist);
        this.gEs = (LinearLayout) this.mRootView.findViewById(R.id.entrance_discuss);
        this.gEv = (LinearLayout) this.mRootView.findViewById(R.id.entrance_person_center);
        this.gEC = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_img_diandian);
        this.gEy = (LinearLayout) this.mRootView.findViewById(R.id.entrance_start_recorder);
        this.gEm = (HeadImageView) this.mRootView.findViewById(R.id.entrance_follow_img);
        this.gEm.setIsRound(true);
        this.gEm.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gEm.setDefaultResource(17170445);
        this.gEm.setDefaultBgResource(17170445);
        this.gED = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_circle);
        this.gEn = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_default_img);
        this.gEq = (ImageView) this.mRootView.findViewById(R.id.entrance_ranklist_img);
        this.gEt = (ImageView) this.mRootView.findViewById(R.id.entrance_discuss_img);
        this.gEw = (ImageView) this.mRootView.findViewById(R.id.entrance_person_center_img);
        this.gEz = (ImageView) this.mRootView.findViewById(R.id.entrance_start_recorder_img);
        this.gEo = (TextView) this.mRootView.findViewById(R.id.entrance_follow_desc);
        this.gEr = (TextView) this.mRootView.findViewById(R.id.entrance_ranklist_desc);
        this.gEu = (TextView) this.mRootView.findViewById(R.id.entrance_discuss_desc);
        this.gEx = (TextView) this.mRootView.findViewById(R.id.entrance_person_center_desc);
        this.gEA = (TextView) this.mRootView.findViewById(R.id.entrance_start_recorder_desc);
        this.gEB = (ImageView) this.mRootView.findViewById(R.id.entrance_publish_live_red);
        this.gEl.setOnClickListener(this);
        this.gEp.setOnClickListener(this);
        this.gEs.setOnClickListener(this);
        this.gEv.setOnClickListener(this);
        this.gEy.setOnClickListener(this);
        this.mRotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation.setDuration(6000L);
        this.mRotateAnimation.setRepeatMode(1);
        this.mRotateAnimation.setRepeatCount(-1);
        this.mRotateAnimation.setInterpolator(new LinearInterpolator());
        this.gEE = ObjectAnimator.ofPropertyValuesHolder(this.gEm, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f));
        this.gEE.setInterpolator(new DecelerateInterpolator());
        this.gEE.setTarget(this.gEm);
        this.gEE.setRepeatCount(-1);
        this.gEE.setRepeatMode(1);
        this.gEE.setDuration(2000L);
        this.gEE.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.d.1
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
                d.this.bRS();
            }
        });
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        ap.setViewTextColor(this.gEo, R.drawable.tab_super_entrance_txt_selecor);
        ap.setViewTextColor(this.gEr, R.drawable.tab_super_entrance_txt_selecor);
        ap.setViewTextColor(this.gEu, R.drawable.tab_super_entrance_txt_selecor);
        ap.setViewTextColor(this.gEx, R.drawable.tab_super_entrance_txt_selecor);
        ap.setViewTextColor(this.gEA, R.drawable.tab_super_entrance_txt_selecor);
        ap.setImageResource(this.gEq, R.drawable.super_entrance_ranklist_bg_selector);
        ap.setImageResource(this.gEt, R.drawable.super_entrance_discuss_bg_selector);
        ap.setImageResource(this.gEw, R.drawable.super_entrance_person_bg_selector);
        ap.setImageResource(this.gEz, R.drawable.super_entrance_start_recorder_bg_selector);
        ap.setImageResource(this.gED, R.drawable.pic_live_tab_quan);
        if (8 == this.gEC.getVisibility()) {
            this.gEn.setVisibility(0);
            this.gED.setVisibility(8);
            ap.setBackgroundResource(this.gEn, R.drawable.super_entrance_follow_bg_selector);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_live_super_enreances_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(i iVar) {
        if (iVar == null || iVar.gAW == null) {
            stopAnim();
            return;
        }
        TiebaStatic.log("c13550");
        TiebaStatic.log("c13549");
        TiebaStatic.log("c13547");
        TiebaStatic.log("c13546");
        this.gEH = iVar.gAW.gAT;
        if (!iVar.gAW.gAR || y.isEmpty(iVar.gAW.gAS)) {
            stopAnim();
            return;
        }
        this.gEG = iVar.gAW.gAS;
        if (!y.isEmpty(this.gEG)) {
            startAnim();
            bRS();
        }
    }

    public void mF(boolean z) {
        if (this.gEB != null) {
            if (z) {
                if (!com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), false)) {
                    com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), true);
                    this.gEB.setVisibility(0);
                    return;
                }
                this.gEB.setVisibility(8);
                return;
            }
            this.gEB.setVisibility(8);
        }
    }

    private void startAnim() {
        this.gEn.setVisibility(8);
        this.gEC.setVisibility(0);
        this.gED.setVisibility(0);
        this.gEm.setVisibility(0);
        this.gEC.clearAnimation();
        if (this.mRotateAnimation != null) {
            this.gEC.startAnimation(this.mRotateAnimation);
        }
        if (this.gEE != null) {
            if (this.gEE.isRunning()) {
                this.gEE.cancel();
            }
            this.gEE.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRS() {
        if (this.gEm != null && !y.isEmpty(this.gEG)) {
            this.gEF++;
            if (this.gEG.size() > this.gEF) {
                this.gEm.startLoad(this.gEG.get(this.gEF).portrait, 12, false);
            } else if (this.gEG.size() > 0) {
                this.gEF = 0;
                this.gEm.startLoad(this.gEG.get(this.gEF).portrait, 12, false);
            }
        }
    }

    private void stopAnim() {
        this.gEC.setVisibility(8);
        this.gED.setVisibility(8);
        this.gEm.setVisibility(8);
        this.gEC.clearAnimation();
        if (this.gEE != null) {
            this.gEE.cancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gEl) {
            if (bh.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTabMyConcernActivityConfig(getTbPageContext().getPageActivity())));
            }
            TiebaStatic.log("c13552");
        } else if (view == this.gEp) {
            if (!StringUtils.isNull(this.gEH)) {
                com.baidu.tbadk.browser.a.startWebActivity(this.mContext.getApplicationContext(), getContext().getResources().getString(R.string.entrance_ranklist_tip), this.gEH, true, true, true, true, true, true, true);
                TiebaStatic.log("c13553");
            }
        } else if (view == this.gEs) {
            String string = com.baidu.tbadk.core.sharedPref.b.brQ().getString("show_live_forum_url", "http://tieba.baidu.com/f?kw=百度直播");
            string = (StringUtils.isNull(string) || !string.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) ? "http://tieba.baidu.com/f?kw=百度直播" : "http://tieba.baidu.com/f?kw=百度直播";
            if (!string.contains("?")) {
                string = string + "?default_tab_id=1&call_from=15";
            } else if (!string.contains("&default_tab_id=")) {
                string = string + "&default_tab_id=1&call_from=15";
            }
            bf.bsV().a(this.mTbPageContext, new String[]{string}, true);
            TiebaStatic.log("c13554");
        } else if (view == this.gEv) {
            if (bh.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(this.mTbPageContext.getPageActivity(), String.valueOf(TbadkCoreApplication.getCurrentAccountId()), TbadkCoreApplication.getCurrentAccountName(), TbadkCoreApplication.getCurrentPortrait(), TbadkCoreApplication.getCurrentAccountInfo().getSex(), true)));
            }
            TiebaStatic.log("c13555");
        } else if (view == this.gEy) {
            bRT();
            TiebaStatic.log("c13617");
        }
    }

    private void bRT() {
        Plugin plugin2;
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getTbPageContext().getPageActivity());
            aVar.setAutoNight(false);
            aVar.nw(R.string.prompt);
            aVar.Au(getContext().getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.d.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(getTbPageContext()).bqx();
        } else if (bh.checkUpIsLogin(getTbPageContext().getPageActivity())) {
            if (this.gEI == null) {
                this.gEI = new com.baidu.tieba.ueg.d(getTbPageContext());
            }
            if (!this.gEI.dRs()) {
                if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                    l.showToast(getTbPageContext().getPageActivity(), R.string.plugin_config_not_found);
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), true);
                this.gEB.setVisibility(8);
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
            permissionJudgePolicy.a(new PermissionJudgePolicy.b() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.d.3
                @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.b
                public void onPermissionsGranted() {
                    MessageManager.getInstance().sendMessage(new HttpMessage(1003303));
                    com.baidu.adp.lib.c.a.lH().getAddress(false);
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
