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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.b.h;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpHost;
/* loaded from: classes3.dex */
public class g extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.b.i> {
    private TextView frA;
    private LinearLayout frB;
    private ImageView frC;
    private TextView frD;
    private ImageView frE;
    private ImageView frF;
    private ImageView frG;
    private ObjectAnimator frH;
    private int frI;
    private List<h.a> frJ;
    private String frK;
    private com.baidu.tieba.ueg.d frL;
    private LinearLayout frn;
    private HeadImageView fro;
    private ImageView frp;
    private TextView frq;
    private LinearLayout frr;
    private ImageView frt;
    private TextView fru;
    private LinearLayout frv;
    private ImageView frw;
    private TextView frx;
    private LinearLayout fry;
    private ImageView frz;
    private View mRootView;
    private RotateAnimation mRotateAnimation;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.frI = -1;
        this.frJ = new ArrayList();
        initView();
    }

    private void initView() {
        this.mRootView = getView();
        this.frn = (LinearLayout) this.mRootView.findViewById(R.id.entrance_follow);
        this.frr = (LinearLayout) this.mRootView.findViewById(R.id.entrance_ranklist);
        this.frv = (LinearLayout) this.mRootView.findViewById(R.id.entrance_discuss);
        this.fry = (LinearLayout) this.mRootView.findViewById(R.id.entrance_person_center);
        this.frF = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_img_diandian);
        this.frB = (LinearLayout) this.mRootView.findViewById(R.id.entrance_start_recorder);
        this.fro = (HeadImageView) this.mRootView.findViewById(R.id.entrance_follow_img);
        this.fro.setIsRound(true);
        this.fro.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fro.setDefaultResource(17170445);
        this.fro.setDefaultBgResource(17170445);
        this.frG = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_circle);
        this.frp = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_default_img);
        this.frt = (ImageView) this.mRootView.findViewById(R.id.entrance_ranklist_img);
        this.frw = (ImageView) this.mRootView.findViewById(R.id.entrance_discuss_img);
        this.frz = (ImageView) this.mRootView.findViewById(R.id.entrance_person_center_img);
        this.frC = (ImageView) this.mRootView.findViewById(R.id.entrance_start_recorder_img);
        this.frq = (TextView) this.mRootView.findViewById(R.id.entrance_follow_desc);
        this.fru = (TextView) this.mRootView.findViewById(R.id.entrance_ranklist_desc);
        this.frx = (TextView) this.mRootView.findViewById(R.id.entrance_discuss_desc);
        this.frA = (TextView) this.mRootView.findViewById(R.id.entrance_person_center_desc);
        this.frD = (TextView) this.mRootView.findViewById(R.id.entrance_start_recorder_desc);
        this.frE = (ImageView) this.mRootView.findViewById(R.id.entrance_publish_live_red);
        this.frn.setOnClickListener(this);
        this.frr.setOnClickListener(this);
        this.frv.setOnClickListener(this);
        this.fry.setOnClickListener(this);
        this.frB.setOnClickListener(this);
        this.mRotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation.setDuration(6000L);
        this.mRotateAnimation.setRepeatMode(1);
        this.mRotateAnimation.setRepeatCount(-1);
        this.mRotateAnimation.setInterpolator(new LinearInterpolator());
        this.frH = ObjectAnimator.ofPropertyValuesHolder(this.fro, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f));
        this.frH.setInterpolator(new DecelerateInterpolator());
        this.frH.setTarget(this.fro);
        this.frH.setRepeatCount(-1);
        this.frH.setRepeatMode(1);
        this.frH.setDuration(2000L);
        this.frH.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.1
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
                g.this.bul();
            }
        });
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        an.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        an.setViewTextColor(this.frq, (int) R.drawable.tab_super_entrance_txt_selecor);
        an.setViewTextColor(this.fru, (int) R.drawable.tab_super_entrance_txt_selecor);
        an.setViewTextColor(this.frx, (int) R.drawable.tab_super_entrance_txt_selecor);
        an.setViewTextColor(this.frA, (int) R.drawable.tab_super_entrance_txt_selecor);
        an.setViewTextColor(this.frD, (int) R.drawable.tab_super_entrance_txt_selecor);
        an.setImageResource(this.frt, R.drawable.super_entrance_ranklist_bg_selector);
        an.setImageResource(this.frw, R.drawable.super_entrance_discuss_bg_selector);
        an.setImageResource(this.frz, R.drawable.super_entrance_person_bg_selector);
        an.setImageResource(this.frC, R.drawable.super_entrance_start_recorder_bg_selector);
        an.setImageResource(this.frG, R.drawable.pic_live_tab_quan);
        if (8 == this.frF.getVisibility()) {
            this.frp.setVisibility(0);
            this.frG.setVisibility(8);
            an.setBackgroundResource(this.frp, R.drawable.super_entrance_follow_bg_selector);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_live_super_enreances_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.i iVar) {
        if (iVar == null || iVar.fog == null) {
            stopAnim();
            return;
        }
        TiebaStatic.log("c13550");
        TiebaStatic.log("c13549");
        TiebaStatic.log("c13547");
        TiebaStatic.log("c13546");
        this.frK = iVar.fog.fod;
        if (!iVar.fog.fob || w.isEmpty(iVar.fog.foc)) {
            stopAnim();
            return;
        }
        this.frJ = iVar.fog.foc;
        if (!w.isEmpty(this.frJ)) {
            startAnim();
            bul();
        }
    }

    public void jH(boolean z) {
        if (this.frE != null) {
            if (z) {
                if (!com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), false)) {
                    com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), true);
                    this.frE.setVisibility(0);
                    return;
                }
                this.frE.setVisibility(8);
                return;
            }
            this.frE.setVisibility(8);
        }
    }

    private void startAnim() {
        this.frp.setVisibility(8);
        this.frF.setVisibility(0);
        this.frG.setVisibility(0);
        this.fro.setVisibility(0);
        this.frF.clearAnimation();
        if (this.mRotateAnimation != null) {
            this.frF.startAnimation(this.mRotateAnimation);
        }
        if (this.frH != null) {
            if (this.frH.isRunning()) {
                this.frH.cancel();
            }
            this.frH.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bul() {
        if (this.fro != null && !w.isEmpty(this.frJ)) {
            this.frI++;
            if (this.frJ.size() > this.frI) {
                this.fro.startLoad(this.frJ.get(this.frI).portrait, 12, false);
            } else if (this.frJ.size() > 0) {
                this.frI = 0;
                this.fro.startLoad(this.frJ.get(this.frI).portrait, 12, false);
            }
        }
    }

    private void stopAnim() {
        this.frF.setVisibility(8);
        this.frG.setVisibility(8);
        this.fro.setVisibility(8);
        this.frF.clearAnimation();
        if (this.frH != null) {
            this.frH.cancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.frn) {
            if (be.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTabMyConcernActivityConfig(getTbPageContext().getPageActivity())));
            }
            TiebaStatic.log("c13552");
        } else if (view == this.frr) {
            if (!StringUtils.isNull(this.frK)) {
                com.baidu.tbadk.browser.a.startWebActivity(this.mContext.getApplicationContext(), getContext().getResources().getString(R.string.entrance_ranklist_tip), this.frK, true, true, true, true, true, true, true);
                TiebaStatic.log("c13553");
            }
        } else if (view == this.frv) {
            String string = com.baidu.tbadk.core.sharedPref.b.aVP().getString("show_live_forum_url", "http://tieba.baidu.com/f?kw=百度直播");
            string = (StringUtils.isNull(string) || !string.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) ? "http://tieba.baidu.com/f?kw=百度直播" : "http://tieba.baidu.com/f?kw=百度直播";
            if (!string.contains("?")) {
                string = string + "?default_tab_id=1&call_from=15";
            } else if (!string.contains("&default_tab_id=")) {
                string = string + "&default_tab_id=1&call_from=15";
            }
            bc.aWU().a(this.mTbPageContext, new String[]{string}, true);
            TiebaStatic.log("c13554");
        } else if (view == this.fry) {
            if (be.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(this.mTbPageContext.getPageActivity(), String.valueOf(TbadkCoreApplication.getCurrentAccountId()), TbadkCoreApplication.getCurrentAccountName(), TbadkCoreApplication.getCurrentPortrait(), TbadkCoreApplication.getCurrentAccountInfo().getSex(), true)));
            }
            TiebaStatic.log("c13555");
        } else if (view == this.frB) {
            bum();
            TiebaStatic.log("c13617");
        }
    }

    private void bum() {
        Plugin plugin2;
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getTbPageContext().getPageActivity());
            aVar.setAutoNight(false);
            aVar.kS(R.string.prompt);
            aVar.we(getContext().getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(getTbPageContext()).aUN();
        } else if (be.checkUpIsLogin(getTbPageContext().getPageActivity())) {
            if (this.frL == null) {
                this.frL = new com.baidu.tieba.ueg.d(getTbPageContext());
            }
            if (!this.frL.dlH()) {
                if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                    com.baidu.adp.lib.util.l.showToast(getTbPageContext().getPageActivity(), (int) R.string.plugin_config_not_found);
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), true);
                this.frE.setVisibility(8);
                p(getTbPageContext());
            }
        }
    }

    private void p(final TbPageContext tbPageContext) {
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
                    com.baidu.adp.lib.c.a.kG().getAddress(false);
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
