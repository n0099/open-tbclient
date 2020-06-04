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
public class g extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.b.i> {
    private LinearLayout fga;
    private HeadImageView fgb;
    private ImageView fgc;
    private TextView fgd;
    private LinearLayout fge;
    private ImageView fgf;
    private TextView fgg;
    private LinearLayout fgh;
    private ImageView fgi;
    private TextView fgj;
    private LinearLayout fgk;
    private ImageView fgl;
    private TextView fgm;
    private LinearLayout fgn;
    private ImageView fgo;
    private TextView fgp;
    private ImageView fgq;
    private ImageView fgr;
    private ImageView fgs;
    private ObjectAnimator fgt;
    private int fgu;
    private List<h.a> fgv;
    private String fgw;
    private com.baidu.tieba.ueg.d fgx;
    private View mRootView;
    private RotateAnimation mRotateAnimation;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fgu = -1;
        this.fgv = new ArrayList();
        initView();
    }

    private void initView() {
        this.mRootView = getView();
        this.fga = (LinearLayout) this.mRootView.findViewById(R.id.entrance_follow);
        this.fge = (LinearLayout) this.mRootView.findViewById(R.id.entrance_ranklist);
        this.fgh = (LinearLayout) this.mRootView.findViewById(R.id.entrance_discuss);
        this.fgk = (LinearLayout) this.mRootView.findViewById(R.id.entrance_person_center);
        this.fgr = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_img_diandian);
        this.fgn = (LinearLayout) this.mRootView.findViewById(R.id.entrance_start_recorder);
        this.fgb = (HeadImageView) this.mRootView.findViewById(R.id.entrance_follow_img);
        this.fgb.setIsRound(true);
        this.fgb.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fgb.setDefaultResource(17170445);
        this.fgb.setDefaultBgResource(17170445);
        this.fgs = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_circle);
        this.fgc = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_default_img);
        this.fgf = (ImageView) this.mRootView.findViewById(R.id.entrance_ranklist_img);
        this.fgi = (ImageView) this.mRootView.findViewById(R.id.entrance_discuss_img);
        this.fgl = (ImageView) this.mRootView.findViewById(R.id.entrance_person_center_img);
        this.fgo = (ImageView) this.mRootView.findViewById(R.id.entrance_start_recorder_img);
        this.fgd = (TextView) this.mRootView.findViewById(R.id.entrance_follow_desc);
        this.fgg = (TextView) this.mRootView.findViewById(R.id.entrance_ranklist_desc);
        this.fgj = (TextView) this.mRootView.findViewById(R.id.entrance_discuss_desc);
        this.fgm = (TextView) this.mRootView.findViewById(R.id.entrance_person_center_desc);
        this.fgp = (TextView) this.mRootView.findViewById(R.id.entrance_start_recorder_desc);
        this.fgq = (ImageView) this.mRootView.findViewById(R.id.entrance_publish_live_red);
        this.fga.setOnClickListener(this);
        this.fge.setOnClickListener(this);
        this.fgh.setOnClickListener(this);
        this.fgk.setOnClickListener(this);
        this.fgn.setOnClickListener(this);
        this.mRotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation.setDuration(6000L);
        this.mRotateAnimation.setRepeatMode(1);
        this.mRotateAnimation.setRepeatCount(-1);
        this.mRotateAnimation.setInterpolator(new LinearInterpolator());
        this.fgt = ObjectAnimator.ofPropertyValuesHolder(this.fgb, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f));
        this.fgt.setInterpolator(new DecelerateInterpolator());
        this.fgt.setTarget(this.fgb);
        this.fgt.setRepeatCount(-1);
        this.fgt.setRepeatMode(1);
        this.fgt.setDuration(2000L);
        this.fgt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.1
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
                g.this.brp();
            }
        });
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        am.setViewTextColor(this.fgd, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setViewTextColor(this.fgg, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setViewTextColor(this.fgj, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setViewTextColor(this.fgm, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setViewTextColor(this.fgp, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setImageResource(this.fgf, R.drawable.super_entrance_ranklist_bg_selector);
        am.setImageResource(this.fgi, R.drawable.super_entrance_discuss_bg_selector);
        am.setImageResource(this.fgl, R.drawable.super_entrance_person_bg_selector);
        am.setImageResource(this.fgo, R.drawable.super_entrance_start_recorder_bg_selector);
        am.setImageResource(this.fgs, R.drawable.pic_live_tab_quan);
        if (8 == this.fgr.getVisibility()) {
            this.fgc.setVisibility(0);
            this.fgs.setVisibility(8);
            am.setBackgroundResource(this.fgc, R.drawable.super_entrance_follow_bg_selector);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_live_super_enreances_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.i iVar) {
        if (iVar == null || iVar.fcW == null) {
            stopAnim();
            return;
        }
        TiebaStatic.log("c13550");
        TiebaStatic.log("c13549");
        TiebaStatic.log("c13547");
        TiebaStatic.log("c13546");
        this.fgw = iVar.fcW.fcT;
        if (!iVar.fcW.fcR || v.isEmpty(iVar.fcW.fcS)) {
            stopAnim();
            return;
        }
        this.fgv = iVar.fcW.fcS;
        if (!v.isEmpty(this.fgv)) {
            startAnim();
            brp();
        }
    }

    public void ju(boolean z) {
        if (this.fgq != null) {
            if (z) {
                if (!com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), false)) {
                    com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), true);
                    this.fgq.setVisibility(0);
                    return;
                }
                this.fgq.setVisibility(8);
                return;
            }
            this.fgq.setVisibility(8);
        }
    }

    private void startAnim() {
        this.fgc.setVisibility(8);
        this.fgr.setVisibility(0);
        this.fgs.setVisibility(0);
        this.fgb.setVisibility(0);
        this.fgr.clearAnimation();
        if (this.mRotateAnimation != null) {
            this.fgr.startAnimation(this.mRotateAnimation);
        }
        if (this.fgt != null) {
            if (this.fgt.isRunning()) {
                this.fgt.cancel();
            }
            this.fgt.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brp() {
        if (this.fgb != null && !v.isEmpty(this.fgv)) {
            this.fgu++;
            if (this.fgv.size() > this.fgu) {
                this.fgb.startLoad(this.fgv.get(this.fgu).portrait, 12, false);
            } else if (this.fgv.size() > 0) {
                this.fgu = 0;
                this.fgb.startLoad(this.fgv.get(this.fgu).portrait, 12, false);
            }
        }
    }

    private void stopAnim() {
        this.fgr.setVisibility(8);
        this.fgs.setVisibility(8);
        this.fgb.setVisibility(8);
        this.fgr.clearAnimation();
        if (this.fgt != null) {
            this.fgt.cancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fga) {
            if (bc.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTabMyConcernActivityConfig(getTbPageContext().getPageActivity())));
            }
            TiebaStatic.log("c13552");
        } else if (view == this.fge) {
            if (!StringUtils.isNull(this.fgw)) {
                com.baidu.tbadk.browser.a.startWebActivity(this.mContext.getApplicationContext(), getContext().getResources().getString(R.string.entrance_ranklist_tip), this.fgw, true, true, true, true, true, true, true);
                TiebaStatic.log("c13553");
            }
        } else if (view == this.fgh) {
            String string = com.baidu.tbadk.core.sharedPref.b.aTX().getString("show_live_forum_url", "http://tieba.baidu.com/f?kw=百度直播");
            string = (StringUtils.isNull(string) || !string.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) ? "http://tieba.baidu.com/f?kw=百度直播" : "http://tieba.baidu.com/f?kw=百度直播";
            if (!string.contains("?")) {
                string = string + "?default_tab_id=1&call_from=15";
            } else if (!string.contains("&default_tab_id=")) {
                string = string + "&default_tab_id=1&call_from=15";
            }
            ba.aVa().a(this.mTbPageContext, new String[]{string}, true);
            TiebaStatic.log("c13554");
        } else if (view == this.fgk) {
            if (bc.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(this.mTbPageContext.getPageActivity(), String.valueOf(TbadkCoreApplication.getCurrentAccountId()), TbadkCoreApplication.getCurrentAccountName(), TbadkCoreApplication.getCurrentPortrait(), TbadkCoreApplication.getCurrentAccountInfo().getSex(), true)));
            }
            TiebaStatic.log("c13555");
        } else if (view == this.fgn) {
            brq();
            TiebaStatic.log("c13617");
        }
    }

    private void brq() {
        Plugin plugin2;
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getTbPageContext().getPageActivity());
            aVar.setAutoNight(false);
            aVar.kE(R.string.prompt);
            aVar.vO(getContext().getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(getTbPageContext()).aST();
        } else if (bc.checkUpIsLogin(getTbPageContext().getPageActivity())) {
            if (this.fgx == null) {
                this.fgx = new com.baidu.tieba.ueg.d(getTbPageContext());
            }
            if (!this.fgx.dhz()) {
                if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                    com.baidu.adp.lib.util.l.showToast(getTbPageContext().getPageActivity(), (int) R.string.plugin_config_not_found);
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), true);
                this.fgq.setVisibility(8);
                m(getTbPageContext());
            }
        }
    }

    private void m(final TbPageContext tbPageContext) {
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
                    com.baidu.adp.lib.c.a.kq().getAddress(false);
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
