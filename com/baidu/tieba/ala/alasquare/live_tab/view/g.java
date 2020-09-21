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
    private ObjectAnimator fLA;
    private int fLB;
    private List<h.a> fLC;
    private String fLD;
    private com.baidu.tieba.ueg.d fLE;
    private LinearLayout fLh;
    private HeadImageView fLi;
    private ImageView fLj;
    private TextView fLk;
    private LinearLayout fLl;
    private ImageView fLm;
    private TextView fLn;
    private LinearLayout fLo;
    private ImageView fLp;
    private TextView fLq;
    private LinearLayout fLr;
    private ImageView fLs;
    private TextView fLt;
    private LinearLayout fLu;
    private ImageView fLv;
    private TextView fLw;
    private ImageView fLx;
    private ImageView fLy;
    private ImageView fLz;
    private View mRootView;
    private RotateAnimation mRotateAnimation;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fLB = -1;
        this.fLC = new ArrayList();
        initView();
    }

    private void initView() {
        this.mRootView = getView();
        this.fLh = (LinearLayout) this.mRootView.findViewById(R.id.entrance_follow);
        this.fLl = (LinearLayout) this.mRootView.findViewById(R.id.entrance_ranklist);
        this.fLo = (LinearLayout) this.mRootView.findViewById(R.id.entrance_discuss);
        this.fLr = (LinearLayout) this.mRootView.findViewById(R.id.entrance_person_center);
        this.fLy = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_img_diandian);
        this.fLu = (LinearLayout) this.mRootView.findViewById(R.id.entrance_start_recorder);
        this.fLi = (HeadImageView) this.mRootView.findViewById(R.id.entrance_follow_img);
        this.fLi.setIsRound(true);
        this.fLi.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fLi.setDefaultResource(17170445);
        this.fLi.setDefaultBgResource(17170445);
        this.fLz = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_circle);
        this.fLj = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_default_img);
        this.fLm = (ImageView) this.mRootView.findViewById(R.id.entrance_ranklist_img);
        this.fLp = (ImageView) this.mRootView.findViewById(R.id.entrance_discuss_img);
        this.fLs = (ImageView) this.mRootView.findViewById(R.id.entrance_person_center_img);
        this.fLv = (ImageView) this.mRootView.findViewById(R.id.entrance_start_recorder_img);
        this.fLk = (TextView) this.mRootView.findViewById(R.id.entrance_follow_desc);
        this.fLn = (TextView) this.mRootView.findViewById(R.id.entrance_ranklist_desc);
        this.fLq = (TextView) this.mRootView.findViewById(R.id.entrance_discuss_desc);
        this.fLt = (TextView) this.mRootView.findViewById(R.id.entrance_person_center_desc);
        this.fLw = (TextView) this.mRootView.findViewById(R.id.entrance_start_recorder_desc);
        this.fLx = (ImageView) this.mRootView.findViewById(R.id.entrance_publish_live_red);
        this.fLh.setOnClickListener(this);
        this.fLl.setOnClickListener(this);
        this.fLo.setOnClickListener(this);
        this.fLr.setOnClickListener(this);
        this.fLu.setOnClickListener(this);
        this.mRotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation.setDuration(6000L);
        this.mRotateAnimation.setRepeatMode(1);
        this.mRotateAnimation.setRepeatCount(-1);
        this.mRotateAnimation.setInterpolator(new LinearInterpolator());
        this.fLA = ObjectAnimator.ofPropertyValuesHolder(this.fLi, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f));
        this.fLA.setInterpolator(new DecelerateInterpolator());
        this.fLA.setTarget(this.fLi);
        this.fLA.setRepeatCount(-1);
        this.fLA.setRepeatMode(1);
        this.fLA.setDuration(2000L);
        this.fLA.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.1
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
                g.this.bHL();
            }
        });
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.fLk, R.drawable.tab_super_entrance_txt_selecor);
        ap.setViewTextColor(this.fLn, R.drawable.tab_super_entrance_txt_selecor);
        ap.setViewTextColor(this.fLq, R.drawable.tab_super_entrance_txt_selecor);
        ap.setViewTextColor(this.fLt, R.drawable.tab_super_entrance_txt_selecor);
        ap.setViewTextColor(this.fLw, R.drawable.tab_super_entrance_txt_selecor);
        ap.setImageResource(this.fLm, R.drawable.super_entrance_ranklist_bg_selector);
        ap.setImageResource(this.fLp, R.drawable.super_entrance_discuss_bg_selector);
        ap.setImageResource(this.fLs, R.drawable.super_entrance_person_bg_selector);
        ap.setImageResource(this.fLv, R.drawable.super_entrance_start_recorder_bg_selector);
        ap.setImageResource(this.fLz, R.drawable.pic_live_tab_quan);
        if (8 == this.fLy.getVisibility()) {
            this.fLj.setVisibility(0);
            this.fLz.setVisibility(8);
            ap.setBackgroundResource(this.fLj, R.drawable.super_entrance_follow_bg_selector);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_live_super_enreances_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.i iVar) {
        if (iVar == null || iVar.fHZ == null) {
            stopAnim();
            return;
        }
        TiebaStatic.log("c13550");
        TiebaStatic.log("c13549");
        TiebaStatic.log("c13547");
        TiebaStatic.log("c13546");
        this.fLD = iVar.fHZ.fHW;
        if (!iVar.fHZ.fHU || y.isEmpty(iVar.fHZ.fHV)) {
            stopAnim();
            return;
        }
        this.fLC = iVar.fHZ.fHV;
        if (!y.isEmpty(this.fLC)) {
            startAnim();
            bHL();
        }
    }

    public void kN(boolean z) {
        if (this.fLx != null) {
            if (z) {
                if (!com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), false)) {
                    com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), true);
                    this.fLx.setVisibility(0);
                    return;
                }
                this.fLx.setVisibility(8);
                return;
            }
            this.fLx.setVisibility(8);
        }
    }

    private void startAnim() {
        this.fLj.setVisibility(8);
        this.fLy.setVisibility(0);
        this.fLz.setVisibility(0);
        this.fLi.setVisibility(0);
        this.fLy.clearAnimation();
        if (this.mRotateAnimation != null) {
            this.fLy.startAnimation(this.mRotateAnimation);
        }
        if (this.fLA != null) {
            if (this.fLA.isRunning()) {
                this.fLA.cancel();
            }
            this.fLA.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHL() {
        if (this.fLi != null && !y.isEmpty(this.fLC)) {
            this.fLB++;
            if (this.fLC.size() > this.fLB) {
                this.fLi.startLoad(this.fLC.get(this.fLB).portrait, 12, false);
            } else if (this.fLC.size() > 0) {
                this.fLB = 0;
                this.fLi.startLoad(this.fLC.get(this.fLB).portrait, 12, false);
            }
        }
    }

    private void stopAnim() {
        this.fLy.setVisibility(8);
        this.fLz.setVisibility(8);
        this.fLi.setVisibility(8);
        this.fLy.clearAnimation();
        if (this.fLA != null) {
            this.fLA.cancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fLh) {
            if (bg.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTabMyConcernActivityConfig(getTbPageContext().getPageActivity())));
            }
            TiebaStatic.log("c13552");
        } else if (view == this.fLl) {
            if (!StringUtils.isNull(this.fLD)) {
                com.baidu.tbadk.browser.a.startWebActivity(this.mContext.getApplicationContext(), getContext().getResources().getString(R.string.entrance_ranklist_tip), this.fLD, true, true, true, true, true, true, true);
                TiebaStatic.log("c13553");
            }
        } else if (view == this.fLo) {
            String string = com.baidu.tbadk.core.sharedPref.b.bjf().getString("show_live_forum_url", "http://tieba.baidu.com/f?kw=百度直播");
            string = (StringUtils.isNull(string) || !string.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) ? "http://tieba.baidu.com/f?kw=百度直播" : "http://tieba.baidu.com/f?kw=百度直播";
            if (!string.contains("?")) {
                string = string + "?default_tab_id=1&call_from=15";
            } else if (!string.contains("&default_tab_id=")) {
                string = string + "&default_tab_id=1&call_from=15";
            }
            be.bkp().a(this.mTbPageContext, new String[]{string}, true);
            TiebaStatic.log("c13554");
        } else if (view == this.fLr) {
            if (bg.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(this.mTbPageContext.getPageActivity(), String.valueOf(TbadkCoreApplication.getCurrentAccountId()), TbadkCoreApplication.getCurrentAccountName(), TbadkCoreApplication.getCurrentPortrait(), TbadkCoreApplication.getCurrentAccountInfo().getSex(), true)));
            }
            TiebaStatic.log("c13555");
        } else if (view == this.fLu) {
            bHM();
            TiebaStatic.log("c13617");
        }
    }

    private void bHM() {
        Plugin plugin2;
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getTbPageContext().getPageActivity());
            aVar.setAutoNight(false);
            aVar.nD(R.string.prompt);
            aVar.zV(getContext().getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(getTbPageContext()).bia();
        } else if (bg.checkUpIsLogin(getTbPageContext().getPageActivity())) {
            if (this.fLE == null) {
                this.fLE = new com.baidu.tieba.ueg.d(getTbPageContext());
            }
            if (!this.fLE.dEt()) {
                if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                    com.baidu.adp.lib.util.l.showToast(getTbPageContext().getPageActivity(), R.string.plugin_config_not_found);
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), true);
                this.fLx.setVisibility(8);
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
                    com.baidu.adp.lib.c.a.mj().getAddress(false);
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
