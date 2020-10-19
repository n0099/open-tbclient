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
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.b.h;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpHost;
/* loaded from: classes4.dex */
public class g extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.b.i> {
    private ImageView fXA;
    private TextView fXB;
    private LinearLayout fXC;
    private ImageView fXD;
    private TextView fXE;
    private LinearLayout fXF;
    private ImageView fXG;
    private TextView fXH;
    private LinearLayout fXI;
    private ImageView fXJ;
    private TextView fXK;
    private LinearLayout fXL;
    private ImageView fXM;
    private TextView fXN;
    private ImageView fXO;
    private ImageView fXP;
    private ImageView fXQ;
    private ObjectAnimator fXR;
    private int fXS;
    private List<h.a> fXT;
    private String fXU;
    private com.baidu.tieba.ueg.d fXV;
    private LinearLayout fXy;
    private HeadImageView fXz;
    private View mRootView;
    private RotateAnimation mRotateAnimation;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fXS = -1;
        this.fXT = new ArrayList();
        initView();
    }

    private void initView() {
        this.mRootView = getView();
        this.fXy = (LinearLayout) this.mRootView.findViewById(R.id.entrance_follow);
        this.fXC = (LinearLayout) this.mRootView.findViewById(R.id.entrance_ranklist);
        this.fXF = (LinearLayout) this.mRootView.findViewById(R.id.entrance_discuss);
        this.fXI = (LinearLayout) this.mRootView.findViewById(R.id.entrance_person_center);
        this.fXP = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_img_diandian);
        this.fXL = (LinearLayout) this.mRootView.findViewById(R.id.entrance_start_recorder);
        this.fXz = (HeadImageView) this.mRootView.findViewById(R.id.entrance_follow_img);
        this.fXz.setIsRound(true);
        this.fXz.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fXz.setDefaultResource(17170445);
        this.fXz.setDefaultBgResource(17170445);
        this.fXQ = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_circle);
        this.fXA = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_default_img);
        this.fXD = (ImageView) this.mRootView.findViewById(R.id.entrance_ranklist_img);
        this.fXG = (ImageView) this.mRootView.findViewById(R.id.entrance_discuss_img);
        this.fXJ = (ImageView) this.mRootView.findViewById(R.id.entrance_person_center_img);
        this.fXM = (ImageView) this.mRootView.findViewById(R.id.entrance_start_recorder_img);
        this.fXB = (TextView) this.mRootView.findViewById(R.id.entrance_follow_desc);
        this.fXE = (TextView) this.mRootView.findViewById(R.id.entrance_ranklist_desc);
        this.fXH = (TextView) this.mRootView.findViewById(R.id.entrance_discuss_desc);
        this.fXK = (TextView) this.mRootView.findViewById(R.id.entrance_person_center_desc);
        this.fXN = (TextView) this.mRootView.findViewById(R.id.entrance_start_recorder_desc);
        this.fXO = (ImageView) this.mRootView.findViewById(R.id.entrance_publish_live_red);
        this.fXy.setOnClickListener(this);
        this.fXC.setOnClickListener(this);
        this.fXF.setOnClickListener(this);
        this.fXI.setOnClickListener(this);
        this.fXL.setOnClickListener(this);
        this.mRotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation.setDuration(6000L);
        this.mRotateAnimation.setRepeatMode(1);
        this.mRotateAnimation.setRepeatCount(-1);
        this.mRotateAnimation.setInterpolator(new LinearInterpolator());
        this.fXR = ObjectAnimator.ofPropertyValuesHolder(this.fXz, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f));
        this.fXR.setInterpolator(new DecelerateInterpolator());
        this.fXR.setTarget(this.fXz);
        this.fXR.setRepeatCount(-1);
        this.fXR.setRepeatMode(1);
        this.fXR.setDuration(2000L);
        this.fXR.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.1
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
                g.this.bKx();
            }
        });
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.fXB, R.drawable.tab_super_entrance_txt_selecor);
        ap.setViewTextColor(this.fXE, R.drawable.tab_super_entrance_txt_selecor);
        ap.setViewTextColor(this.fXH, R.drawable.tab_super_entrance_txt_selecor);
        ap.setViewTextColor(this.fXK, R.drawable.tab_super_entrance_txt_selecor);
        ap.setViewTextColor(this.fXN, R.drawable.tab_super_entrance_txt_selecor);
        ap.setImageResource(this.fXD, R.drawable.super_entrance_ranklist_bg_selector);
        ap.setImageResource(this.fXG, R.drawable.super_entrance_discuss_bg_selector);
        ap.setImageResource(this.fXJ, R.drawable.super_entrance_person_bg_selector);
        ap.setImageResource(this.fXM, R.drawable.super_entrance_start_recorder_bg_selector);
        ap.setImageResource(this.fXQ, R.drawable.pic_live_tab_quan);
        if (8 == this.fXP.getVisibility()) {
            this.fXA.setVisibility(0);
            this.fXQ.setVisibility(8);
            ap.setBackgroundResource(this.fXA, R.drawable.super_entrance_follow_bg_selector);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_live_super_enreances_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.i iVar) {
        if (iVar == null || iVar.fUj == null) {
            stopAnim();
            return;
        }
        TiebaStatic.log("c13550");
        TiebaStatic.log("c13549");
        TiebaStatic.log("c13547");
        TiebaStatic.log("c13546");
        this.fXU = iVar.fUj.fUg;
        if (!iVar.fUj.fUe || y.isEmpty(iVar.fUj.fUf)) {
            stopAnim();
            return;
        }
        this.fXT = iVar.fUj.fUf;
        if (!y.isEmpty(this.fXT)) {
            startAnim();
            bKx();
        }
    }

    public void ll(boolean z) {
        if (this.fXO != null) {
            if (z) {
                if (!com.baidu.tbadk.core.sharedPref.b.blO().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), false)) {
                    com.baidu.tbadk.core.sharedPref.b.blO().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), true);
                    this.fXO.setVisibility(0);
                    return;
                }
                this.fXO.setVisibility(8);
                return;
            }
            this.fXO.setVisibility(8);
        }
    }

    private void startAnim() {
        this.fXA.setVisibility(8);
        this.fXP.setVisibility(0);
        this.fXQ.setVisibility(0);
        this.fXz.setVisibility(0);
        this.fXP.clearAnimation();
        if (this.mRotateAnimation != null) {
            this.fXP.startAnimation(this.mRotateAnimation);
        }
        if (this.fXR != null) {
            if (this.fXR.isRunning()) {
                this.fXR.cancel();
            }
            this.fXR.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKx() {
        if (this.fXz != null && !y.isEmpty(this.fXT)) {
            this.fXS++;
            if (this.fXT.size() > this.fXS) {
                this.fXz.startLoad(this.fXT.get(this.fXS).portrait, 12, false);
            } else if (this.fXT.size() > 0) {
                this.fXS = 0;
                this.fXz.startLoad(this.fXT.get(this.fXS).portrait, 12, false);
            }
        }
    }

    private void stopAnim() {
        this.fXP.setVisibility(8);
        this.fXQ.setVisibility(8);
        this.fXz.setVisibility(8);
        this.fXP.clearAnimation();
        if (this.fXR != null) {
            this.fXR.cancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fXy) {
            if (bg.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTabMyConcernActivityConfig(getTbPageContext().getPageActivity())));
            }
            TiebaStatic.log("c13552");
        } else if (view == this.fXC) {
            if (!StringUtils.isNull(this.fXU)) {
                com.baidu.tbadk.browser.a.startWebActivity(this.mContext.getApplicationContext(), getContext().getResources().getString(R.string.entrance_ranklist_tip), this.fXU, true, true, true, true, true, true, true);
                TiebaStatic.log("c13553");
            }
        } else if (view == this.fXF) {
            String string = com.baidu.tbadk.core.sharedPref.b.blO().getString("show_live_forum_url", "http://tieba.baidu.com/f?kw=百度直播");
            string = (StringUtils.isNull(string) || !string.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) ? "http://tieba.baidu.com/f?kw=百度直播" : "http://tieba.baidu.com/f?kw=百度直播";
            if (!string.contains("?")) {
                string = string + "?default_tab_id=1&call_from=15";
            } else if (!string.contains("&default_tab_id=")) {
                string = string + "&default_tab_id=1&call_from=15";
            }
            be.bmY().a(this.mTbPageContext, new String[]{string}, true);
            TiebaStatic.log("c13554");
        } else if (view == this.fXI) {
            if (bg.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(this.mTbPageContext.getPageActivity(), String.valueOf(TbadkCoreApplication.getCurrentAccountId()), TbadkCoreApplication.getCurrentAccountName(), TbadkCoreApplication.getCurrentPortrait(), TbadkCoreApplication.getCurrentAccountInfo().getSex(), true)));
            }
            TiebaStatic.log("c13555");
        } else if (view == this.fXL) {
            bKy();
            TiebaStatic.log("c13617");
        }
    }

    private void bKy() {
        Plugin plugin2;
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getTbPageContext().getPageActivity());
            aVar.setAutoNight(false);
            aVar.oa(R.string.prompt);
            aVar.AH(getContext().getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(getTbPageContext()).bkJ();
        } else if (bg.checkUpIsLogin(getTbPageContext().getPageActivity())) {
            if (this.fXV == null) {
                this.fXV = new com.baidu.tieba.ueg.d(getTbPageContext());
            }
            if (!this.fXV.dIf()) {
                if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                    com.baidu.adp.lib.util.l.showToast(getTbPageContext().getPageActivity(), R.string.plugin_config_not_found);
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.blO().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), true);
                this.fXO.setVisibility(8);
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
