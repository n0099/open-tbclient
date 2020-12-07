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
    private int gvA;
    private List<h.a> gvB;
    private String gvC;
    private com.baidu.tieba.ueg.d gvD;
    private LinearLayout gvg;
    private HeadImageView gvh;
    private ImageView gvi;
    private TextView gvj;
    private LinearLayout gvk;
    private ImageView gvl;
    private TextView gvm;
    private LinearLayout gvn;
    private ImageView gvo;
    private TextView gvp;
    private LinearLayout gvq;
    private ImageView gvr;
    private TextView gvs;
    private LinearLayout gvt;
    private ImageView gvu;
    private TextView gvv;
    private ImageView gvw;
    private ImageView gvx;
    private ImageView gvy;
    private ObjectAnimator gvz;
    private View mRootView;
    private RotateAnimation mRotateAnimation;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gvA = -1;
        this.gvB = new ArrayList();
        initView();
    }

    private void initView() {
        this.mRootView = getView();
        this.gvg = (LinearLayout) this.mRootView.findViewById(R.id.entrance_follow);
        this.gvk = (LinearLayout) this.mRootView.findViewById(R.id.entrance_ranklist);
        this.gvn = (LinearLayout) this.mRootView.findViewById(R.id.entrance_discuss);
        this.gvq = (LinearLayout) this.mRootView.findViewById(R.id.entrance_person_center);
        this.gvx = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_img_diandian);
        this.gvt = (LinearLayout) this.mRootView.findViewById(R.id.entrance_start_recorder);
        this.gvh = (HeadImageView) this.mRootView.findViewById(R.id.entrance_follow_img);
        this.gvh.setIsRound(true);
        this.gvh.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gvh.setDefaultResource(17170445);
        this.gvh.setDefaultBgResource(17170445);
        this.gvy = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_circle);
        this.gvi = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_default_img);
        this.gvl = (ImageView) this.mRootView.findViewById(R.id.entrance_ranklist_img);
        this.gvo = (ImageView) this.mRootView.findViewById(R.id.entrance_discuss_img);
        this.gvr = (ImageView) this.mRootView.findViewById(R.id.entrance_person_center_img);
        this.gvu = (ImageView) this.mRootView.findViewById(R.id.entrance_start_recorder_img);
        this.gvj = (TextView) this.mRootView.findViewById(R.id.entrance_follow_desc);
        this.gvm = (TextView) this.mRootView.findViewById(R.id.entrance_ranklist_desc);
        this.gvp = (TextView) this.mRootView.findViewById(R.id.entrance_discuss_desc);
        this.gvs = (TextView) this.mRootView.findViewById(R.id.entrance_person_center_desc);
        this.gvv = (TextView) this.mRootView.findViewById(R.id.entrance_start_recorder_desc);
        this.gvw = (ImageView) this.mRootView.findViewById(R.id.entrance_publish_live_red);
        this.gvg.setOnClickListener(this);
        this.gvk.setOnClickListener(this);
        this.gvn.setOnClickListener(this);
        this.gvq.setOnClickListener(this);
        this.gvt.setOnClickListener(this);
        this.mRotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation.setDuration(6000L);
        this.mRotateAnimation.setRepeatMode(1);
        this.mRotateAnimation.setRepeatCount(-1);
        this.mRotateAnimation.setInterpolator(new LinearInterpolator());
        this.gvz = ObjectAnimator.ofPropertyValuesHolder(this.gvh, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f));
        this.gvz.setInterpolator(new DecelerateInterpolator());
        this.gvz.setTarget(this.gvh);
        this.gvz.setRepeatCount(-1);
        this.gvz.setRepeatMode(1);
        this.gvz.setDuration(2000L);
        this.gvz.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.1
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
                g.this.bSD();
            }
        });
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        ap.setViewTextColor(this.gvj, R.drawable.tab_super_entrance_txt_selecor);
        ap.setViewTextColor(this.gvm, R.drawable.tab_super_entrance_txt_selecor);
        ap.setViewTextColor(this.gvp, R.drawable.tab_super_entrance_txt_selecor);
        ap.setViewTextColor(this.gvs, R.drawable.tab_super_entrance_txt_selecor);
        ap.setViewTextColor(this.gvv, R.drawable.tab_super_entrance_txt_selecor);
        ap.setImageResource(this.gvl, R.drawable.super_entrance_ranklist_bg_selector);
        ap.setImageResource(this.gvo, R.drawable.super_entrance_discuss_bg_selector);
        ap.setImageResource(this.gvr, R.drawable.super_entrance_person_bg_selector);
        ap.setImageResource(this.gvu, R.drawable.super_entrance_start_recorder_bg_selector);
        ap.setImageResource(this.gvy, R.drawable.pic_live_tab_quan);
        if (8 == this.gvx.getVisibility()) {
            this.gvi.setVisibility(0);
            this.gvy.setVisibility(8);
            ap.setBackgroundResource(this.gvi, R.drawable.super_entrance_follow_bg_selector);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_live_super_enreances_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.i iVar) {
        if (iVar == null || iVar.grS == null) {
            stopAnim();
            return;
        }
        TiebaStatic.log("c13550");
        TiebaStatic.log("c13549");
        TiebaStatic.log("c13547");
        TiebaStatic.log("c13546");
        this.gvC = iVar.grS.grP;
        if (!iVar.grS.grN || y.isEmpty(iVar.grS.grO)) {
            stopAnim();
            return;
        }
        this.gvB = iVar.grS.grO;
        if (!y.isEmpty(this.gvB)) {
            startAnim();
            bSD();
        }
    }

    public void mi(boolean z) {
        if (this.gvw != null) {
            if (z) {
                if (!com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), false)) {
                    com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), true);
                    this.gvw.setVisibility(0);
                    return;
                }
                this.gvw.setVisibility(8);
                return;
            }
            this.gvw.setVisibility(8);
        }
    }

    private void startAnim() {
        this.gvi.setVisibility(8);
        this.gvx.setVisibility(0);
        this.gvy.setVisibility(0);
        this.gvh.setVisibility(0);
        this.gvx.clearAnimation();
        if (this.mRotateAnimation != null) {
            this.gvx.startAnimation(this.mRotateAnimation);
        }
        if (this.gvz != null) {
            if (this.gvz.isRunning()) {
                this.gvz.cancel();
            }
            this.gvz.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSD() {
        if (this.gvh != null && !y.isEmpty(this.gvB)) {
            this.gvA++;
            if (this.gvB.size() > this.gvA) {
                this.gvh.startLoad(this.gvB.get(this.gvA).portrait, 12, false);
            } else if (this.gvB.size() > 0) {
                this.gvA = 0;
                this.gvh.startLoad(this.gvB.get(this.gvA).portrait, 12, false);
            }
        }
    }

    private void stopAnim() {
        this.gvx.setVisibility(8);
        this.gvy.setVisibility(8);
        this.gvh.setVisibility(8);
        this.gvx.clearAnimation();
        if (this.gvz != null) {
            this.gvz.cancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gvg) {
            if (bh.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTabMyConcernActivityConfig(getTbPageContext().getPageActivity())));
            }
            TiebaStatic.log("c13552");
        } else if (view == this.gvk) {
            if (!StringUtils.isNull(this.gvC)) {
                com.baidu.tbadk.browser.a.startWebActivity(this.mContext.getApplicationContext(), getContext().getResources().getString(R.string.entrance_ranklist_tip), this.gvC, true, true, true, true, true, true, true);
                TiebaStatic.log("c13553");
            }
        } else if (view == this.gvn) {
            String string = com.baidu.tbadk.core.sharedPref.b.bsO().getString("show_live_forum_url", "http://tieba.baidu.com/f?kw=百度直播");
            string = (StringUtils.isNull(string) || !string.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) ? "http://tieba.baidu.com/f?kw=百度直播" : "http://tieba.baidu.com/f?kw=百度直播";
            if (!string.contains("?")) {
                string = string + "?default_tab_id=1&call_from=15";
            } else if (!string.contains("&default_tab_id=")) {
                string = string + "&default_tab_id=1&call_from=15";
            }
            bf.bua().a(this.mTbPageContext, new String[]{string}, true);
            TiebaStatic.log("c13554");
        } else if (view == this.gvq) {
            if (bh.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(this.mTbPageContext.getPageActivity(), String.valueOf(TbadkCoreApplication.getCurrentAccountId()), TbadkCoreApplication.getCurrentAccountName(), TbadkCoreApplication.getCurrentPortrait(), TbadkCoreApplication.getCurrentAccountInfo().getSex(), true)));
            }
            TiebaStatic.log("c13555");
        } else if (view == this.gvt) {
            bSE();
            TiebaStatic.log("c13617");
        }
    }

    private void bSE() {
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
            if (this.gvD == null) {
                this.gvD = new com.baidu.tieba.ueg.d(getTbPageContext());
            }
            if (!this.gvD.dTg()) {
                if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                    com.baidu.adp.lib.util.l.showToast(getTbPageContext().getPageActivity(), R.string.plugin_config_not_found);
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), true);
                this.gvw.setVisibility(8);
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
