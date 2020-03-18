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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.b.h;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpHost;
/* loaded from: classes3.dex */
public class g extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.live_tab.b.i> {
    private LinearLayout epF;
    private HeadImageView epG;
    private ImageView epH;
    private TextView epI;
    private LinearLayout epJ;
    private ImageView epK;
    private TextView epL;
    private LinearLayout epM;
    private ImageView epN;
    private TextView epO;
    private LinearLayout epP;
    private ImageView epQ;
    private TextView epR;
    private LinearLayout epS;
    private ImageView epT;
    private TextView epU;
    private ImageView epV;
    private ImageView epW;
    private ImageView epX;
    private ObjectAnimator epY;
    private int epZ;
    private List<h.a> eqa;
    private String eqb;
    private com.baidu.tieba.ueg.d eqc;
    private View mRootView;
    private RotateAnimation mRotateAnimation;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.epZ = -1;
        this.eqa = new ArrayList();
        initView();
    }

    private void initView() {
        this.mRootView = getView();
        this.epF = (LinearLayout) this.mRootView.findViewById(R.id.entrance_follow);
        this.epJ = (LinearLayout) this.mRootView.findViewById(R.id.entrance_ranklist);
        this.epM = (LinearLayout) this.mRootView.findViewById(R.id.entrance_discuss);
        this.epP = (LinearLayout) this.mRootView.findViewById(R.id.entrance_person_center);
        this.epW = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_img_diandian);
        this.epS = (LinearLayout) this.mRootView.findViewById(R.id.entrance_start_recorder);
        this.epG = (HeadImageView) this.mRootView.findViewById(R.id.entrance_follow_img);
        this.epG.setIsRound(true);
        this.epG.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.epG.setDefaultResource(17170445);
        this.epG.setDefaultBgResource(17170445);
        this.epX = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_circle);
        this.epH = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_default_img);
        this.epK = (ImageView) this.mRootView.findViewById(R.id.entrance_ranklist_img);
        this.epN = (ImageView) this.mRootView.findViewById(R.id.entrance_discuss_img);
        this.epQ = (ImageView) this.mRootView.findViewById(R.id.entrance_person_center_img);
        this.epT = (ImageView) this.mRootView.findViewById(R.id.entrance_start_recorder_img);
        this.epI = (TextView) this.mRootView.findViewById(R.id.entrance_follow_desc);
        this.epL = (TextView) this.mRootView.findViewById(R.id.entrance_ranklist_desc);
        this.epO = (TextView) this.mRootView.findViewById(R.id.entrance_discuss_desc);
        this.epR = (TextView) this.mRootView.findViewById(R.id.entrance_person_center_desc);
        this.epU = (TextView) this.mRootView.findViewById(R.id.entrance_start_recorder_desc);
        this.epV = (ImageView) this.mRootView.findViewById(R.id.entrance_publish_live_red);
        this.epF.setOnClickListener(this);
        this.epJ.setOnClickListener(this);
        this.epM.setOnClickListener(this);
        this.epP.setOnClickListener(this);
        this.epS.setOnClickListener(this);
        this.mRotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation.setDuration(6000L);
        this.mRotateAnimation.setRepeatMode(1);
        this.mRotateAnimation.setRepeatCount(-1);
        this.mRotateAnimation.setInterpolator(new LinearInterpolator());
        this.epY = ObjectAnimator.ofPropertyValuesHolder(this.epG, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f));
        this.epY.setInterpolator(new DecelerateInterpolator());
        this.epY.setTarget(this.epG);
        this.epY.setRepeatCount(-1);
        this.epY.setRepeatMode(1);
        this.epY.setDuration(2000L);
        this.epY.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.1
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
                g.this.bda();
            }
        });
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        am.setViewTextColor(this.epI, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setViewTextColor(this.epL, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setViewTextColor(this.epO, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setViewTextColor(this.epR, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setViewTextColor(this.epU, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setImageResource(this.epK, R.drawable.super_entrance_ranklist_bg_selector);
        am.setImageResource(this.epN, R.drawable.super_entrance_discuss_bg_selector);
        am.setImageResource(this.epQ, R.drawable.super_entrance_person_bg_selector);
        am.setImageResource(this.epT, R.drawable.super_entrance_start_recorder_bg_selector);
        am.setImageResource(this.epX, R.drawable.pic_live_tab_quan);
        if (8 == this.epW.getVisibility()) {
            this.epH.setVisibility(0);
            this.epX.setVisibility(8);
            am.setBackgroundResource(this.epH, R.drawable.super_entrance_follow_bg_selector);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_live_super_enreances_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.i iVar) {
        if (iVar == null || iVar.emx == null) {
            stopAnim();
            return;
        }
        TiebaStatic.log("c13550");
        TiebaStatic.log("c13549");
        TiebaStatic.log("c13547");
        TiebaStatic.log("c13546");
        this.eqb = iVar.emx.emu;
        if (!iVar.emx.ems || v.isEmpty(iVar.emx.emt)) {
            stopAnim();
            return;
        }
        this.eqa = iVar.emx.emt;
        if (!v.isEmpty(this.eqa)) {
            startAnim();
            bda();
        }
    }

    public void ic(boolean z) {
        if (this.epV != null) {
            if (z) {
                if (!com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), false)) {
                    com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), true);
                    this.epV.setVisibility(0);
                    return;
                }
                this.epV.setVisibility(8);
                return;
            }
            this.epV.setVisibility(8);
        }
    }

    private void startAnim() {
        this.epH.setVisibility(8);
        this.epW.setVisibility(0);
        this.epX.setVisibility(0);
        this.epG.setVisibility(0);
        this.epW.clearAnimation();
        if (this.mRotateAnimation != null) {
            this.epW.startAnimation(this.mRotateAnimation);
        }
        if (this.epY != null) {
            if (this.epY.isRunning()) {
                this.epY.cancel();
            }
            this.epY.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bda() {
        if (this.epG != null && !v.isEmpty(this.eqa)) {
            this.epZ++;
            if (this.eqa.size() > this.epZ) {
                this.epG.startLoad(this.eqa.get(this.epZ).portrait, 12, false);
            } else if (this.eqa.size() > 0) {
                this.epZ = 0;
                this.epG.startLoad(this.eqa.get(this.epZ).portrait, 12, false);
            }
        }
    }

    private void stopAnim() {
        this.epW.setVisibility(8);
        this.epX.setVisibility(8);
        this.epG.setVisibility(8);
        this.epW.clearAnimation();
        if (this.epY != null) {
            this.epY.cancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.epF) {
            if (bc.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTabMyConcernActivityConfig(getTbPageContext().getPageActivity())));
            }
            TiebaStatic.log("c13552");
        } else if (view == this.epJ) {
            if (!StringUtils.isNull(this.eqb)) {
                com.baidu.tbadk.browser.a.startWebActivity(this.mContext.getApplicationContext(), getContext().getResources().getString(R.string.entrance_ranklist_tip), this.eqb, true, true, true, true, true, true, true);
                TiebaStatic.log("c13553");
            }
        } else if (view == this.epM) {
            String string = com.baidu.tbadk.core.sharedPref.b.aFH().getString("show_live_forum_url", "http://tieba.baidu.com/f?kw=百度直播");
            string = (StringUtils.isNull(string) || !string.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) ? "http://tieba.baidu.com/f?kw=百度直播" : "http://tieba.baidu.com/f?kw=百度直播";
            if (!string.contains("?")) {
                string = string + "?default_tab_id=1&call_from=15";
            } else if (!string.contains("&default_tab_id=")) {
                string = string + "&default_tab_id=1&call_from=15";
            }
            ba.aGK().a(this.mTbPageContext, new String[]{string}, true);
            TiebaStatic.log("c13554");
        } else if (view == this.epP) {
            if (bc.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(this.mTbPageContext.getPageActivity(), String.valueOf(TbadkCoreApplication.getCurrentAccountId()), TbadkCoreApplication.getCurrentAccountName(), TbadkCoreApplication.getCurrentPortrait(), TbadkCoreApplication.getCurrentAccountInfo().getSex(), true)));
            }
            TiebaStatic.log("c13555");
        } else if (view == this.epS) {
            bdb();
            TiebaStatic.log("c13617");
        }
    }

    private void bdb() {
        Plugin plugin2;
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getTbPageContext().getPageActivity());
            aVar.setAutoNight(false);
            aVar.jV(R.string.prompt);
            aVar.sR(getContext().getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(getTbPageContext()).aEG();
        } else if (bc.checkUpIsLogin(getTbPageContext().getPageActivity())) {
            if (this.eqc == null) {
                this.eqc = new com.baidu.tieba.ueg.d(getTbPageContext());
            }
            if (!this.eqc.cPb()) {
                if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                    com.baidu.adp.lib.util.l.showToast(getTbPageContext().getPageActivity(), (int) R.string.plugin_config_not_found);
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), true);
                this.epV.setVisibility(8);
                l(getTbPageContext());
            }
        }
    }

    private void l(final TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.clearRequestPermissionList();
            permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE);
            permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_AUDIO_CAPTURE);
            permissionJudgePolicy.a(new PermissionJudgePolicy.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.3
                @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.a
                public void onPermissionsGranted() {
                    MessageManager.getInstance().sendMessage(new HttpMessage(1003303));
                    com.baidu.adp.lib.c.a.fK().getAddress(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaMasterLiveRoomActivityConfig(tbPageContext.getPageActivity(), null, "0", TbadkCoreApplication.getCurrentAccount(), null)));
                }
            });
            permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        super.onDestroy();
        stopAnim();
    }
}
