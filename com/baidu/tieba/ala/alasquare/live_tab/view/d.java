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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.x;
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
    private ObjectAnimator gGA;
    private int gGB;
    private List<h.a> gGC;
    private String gGD;
    private com.baidu.tieba.ueg.d gGE;
    private LinearLayout gGh;
    private HeadImageView gGi;
    private ImageView gGj;
    private TextView gGk;
    private LinearLayout gGl;
    private ImageView gGm;
    private TextView gGn;
    private LinearLayout gGo;
    private ImageView gGp;
    private TextView gGq;
    private LinearLayout gGr;
    private ImageView gGs;
    private TextView gGt;
    private LinearLayout gGu;
    private ImageView gGv;
    private TextView gGw;
    private ImageView gGx;
    private ImageView gGy;
    private ImageView gGz;
    private View mRootView;
    private RotateAnimation mRotateAnimation;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gGB = -1;
        this.gGC = new ArrayList();
        initView();
    }

    private void initView() {
        this.mRootView = getView();
        this.gGh = (LinearLayout) this.mRootView.findViewById(R.id.entrance_follow);
        this.gGl = (LinearLayout) this.mRootView.findViewById(R.id.entrance_ranklist);
        this.gGo = (LinearLayout) this.mRootView.findViewById(R.id.entrance_discuss);
        this.gGr = (LinearLayout) this.mRootView.findViewById(R.id.entrance_person_center);
        this.gGy = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_img_diandian);
        this.gGu = (LinearLayout) this.mRootView.findViewById(R.id.entrance_start_recorder);
        this.gGi = (HeadImageView) this.mRootView.findViewById(R.id.entrance_follow_img);
        this.gGi.setIsRound(true);
        this.gGi.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gGi.setDefaultResource(17170445);
        this.gGi.setDefaultBgResource(17170445);
        this.gGz = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_circle);
        this.gGj = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_default_img);
        this.gGm = (ImageView) this.mRootView.findViewById(R.id.entrance_ranklist_img);
        this.gGp = (ImageView) this.mRootView.findViewById(R.id.entrance_discuss_img);
        this.gGs = (ImageView) this.mRootView.findViewById(R.id.entrance_person_center_img);
        this.gGv = (ImageView) this.mRootView.findViewById(R.id.entrance_start_recorder_img);
        this.gGk = (TextView) this.mRootView.findViewById(R.id.entrance_follow_desc);
        this.gGn = (TextView) this.mRootView.findViewById(R.id.entrance_ranklist_desc);
        this.gGq = (TextView) this.mRootView.findViewById(R.id.entrance_discuss_desc);
        this.gGt = (TextView) this.mRootView.findViewById(R.id.entrance_person_center_desc);
        this.gGw = (TextView) this.mRootView.findViewById(R.id.entrance_start_recorder_desc);
        this.gGx = (ImageView) this.mRootView.findViewById(R.id.entrance_publish_live_red);
        this.gGh.setOnClickListener(this);
        this.gGl.setOnClickListener(this);
        this.gGo.setOnClickListener(this);
        this.gGr.setOnClickListener(this);
        this.gGu.setOnClickListener(this);
        this.mRotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation.setDuration(6000L);
        this.mRotateAnimation.setRepeatMode(1);
        this.mRotateAnimation.setRepeatCount(-1);
        this.mRotateAnimation.setInterpolator(new LinearInterpolator());
        this.gGA = ObjectAnimator.ofPropertyValuesHolder(this.gGi, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f));
        this.gGA.setInterpolator(new DecelerateInterpolator());
        this.gGA.setTarget(this.gGi);
        this.gGA.setRepeatCount(-1);
        this.gGA.setRepeatMode(1);
        this.gGA.setDuration(2000L);
        this.gGA.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.d.1
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
                d.this.bVg();
            }
        });
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        ao.setViewTextColor(this.gGk, R.drawable.tab_super_entrance_txt_selecor);
        ao.setViewTextColor(this.gGn, R.drawable.tab_super_entrance_txt_selecor);
        ao.setViewTextColor(this.gGq, R.drawable.tab_super_entrance_txt_selecor);
        ao.setViewTextColor(this.gGt, R.drawable.tab_super_entrance_txt_selecor);
        ao.setViewTextColor(this.gGw, R.drawable.tab_super_entrance_txt_selecor);
        ao.setImageResource(this.gGm, R.drawable.super_entrance_ranklist_bg_selector);
        ao.setImageResource(this.gGp, R.drawable.super_entrance_discuss_bg_selector);
        ao.setImageResource(this.gGs, R.drawable.super_entrance_person_bg_selector);
        ao.setImageResource(this.gGv, R.drawable.super_entrance_start_recorder_bg_selector);
        ao.setImageResource(this.gGz, R.drawable.pic_live_tab_quan);
        if (8 == this.gGy.getVisibility()) {
            this.gGj.setVisibility(0);
            this.gGz.setVisibility(8);
            ao.setBackgroundResource(this.gGj, R.drawable.super_entrance_follow_bg_selector);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_live_super_enreances_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(i iVar) {
        if (iVar == null || iVar.gCT == null) {
            stopAnim();
            return;
        }
        TiebaStatic.log("c13550");
        TiebaStatic.log("c13549");
        TiebaStatic.log("c13547");
        TiebaStatic.log("c13546");
        this.gGD = iVar.gCT.gCQ;
        if (!iVar.gCT.gCO || x.isEmpty(iVar.gCT.gCP)) {
            stopAnim();
            return;
        }
        this.gGC = iVar.gCT.gCP;
        if (!x.isEmpty(this.gGC)) {
            startAnim();
            bVg();
        }
    }

    public void mF(boolean z) {
        if (this.gGx != null) {
            if (z) {
                if (!com.baidu.tbadk.core.sharedPref.b.bvq().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), false)) {
                    com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), true);
                    this.gGx.setVisibility(0);
                    return;
                }
                this.gGx.setVisibility(8);
                return;
            }
            this.gGx.setVisibility(8);
        }
    }

    private void startAnim() {
        this.gGj.setVisibility(8);
        this.gGy.setVisibility(0);
        this.gGz.setVisibility(0);
        this.gGi.setVisibility(0);
        this.gGy.clearAnimation();
        if (this.mRotateAnimation != null) {
            this.gGy.startAnimation(this.mRotateAnimation);
        }
        if (this.gGA != null) {
            if (this.gGA.isRunning()) {
                this.gGA.cancel();
            }
            this.gGA.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVg() {
        if (this.gGi != null && !x.isEmpty(this.gGC)) {
            this.gGB++;
            if (this.gGC.size() > this.gGB) {
                this.gGi.startLoad(this.gGC.get(this.gGB).portrait, 12, false);
            } else if (this.gGC.size() > 0) {
                this.gGB = 0;
                this.gGi.startLoad(this.gGC.get(this.gGB).portrait, 12, false);
            }
        }
    }

    private void stopAnim() {
        this.gGy.setVisibility(8);
        this.gGz.setVisibility(8);
        this.gGi.setVisibility(8);
        this.gGy.clearAnimation();
        if (this.gGA != null) {
            this.gGA.cancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gGh) {
            if (bg.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTabMyConcernActivityConfig(getTbPageContext().getPageActivity())));
            }
            TiebaStatic.log("c13552");
        } else if (view == this.gGl) {
            if (!StringUtils.isNull(this.gGD)) {
                com.baidu.tbadk.browser.a.startWebActivity(this.mContext.getApplicationContext(), getContext().getResources().getString(R.string.entrance_ranklist_tip), this.gGD, true, true, true, true, true, true, true);
                TiebaStatic.log("c13553");
            }
        } else if (view == this.gGo) {
            String string = com.baidu.tbadk.core.sharedPref.b.bvq().getString("show_live_forum_url", "http://tieba.baidu.com/f?kw=百度直播");
            string = (StringUtils.isNull(string) || !string.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) ? "http://tieba.baidu.com/f?kw=百度直播" : "http://tieba.baidu.com/f?kw=百度直播";
            if (!string.contains("?")) {
                string = string + "?default_tab_id=1&call_from=15";
            } else if (!string.contains("&default_tab_id=")) {
                string = string + "&default_tab_id=1&call_from=15";
            }
            be.bwu().a(this.mTbPageContext, new String[]{string}, true);
            TiebaStatic.log("c13554");
        } else if (view == this.gGr) {
            if (bg.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(this.mTbPageContext.getPageActivity(), String.valueOf(TbadkCoreApplication.getCurrentAccountId()), TbadkCoreApplication.getCurrentAccountName(), TbadkCoreApplication.getCurrentPortrait(), TbadkCoreApplication.getCurrentAccountInfo().getSex(), true)));
            }
            TiebaStatic.log("c13555");
        } else if (view == this.gGu) {
            bVh();
            TiebaStatic.log("c13617");
        }
    }

    private void bVh() {
        Plugin plugin2;
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getTbPageContext().getPageActivity());
            aVar.setAutoNight(false);
            aVar.oZ(R.string.prompt);
            aVar.Bp(getContext().getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.d.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(getTbPageContext()).btX();
        } else if (bg.checkUpIsLogin(getTbPageContext().getPageActivity())) {
            if (this.gGE == null) {
                this.gGE = new com.baidu.tieba.ueg.d(getTbPageContext());
            }
            if (!this.gGE.dSY()) {
                if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                    l.showToast(getTbPageContext().getPageActivity(), R.string.plugin_config_not_found);
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), true);
                this.gGx.setVisibility(8);
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
                    com.baidu.adp.lib.c.a.lI().getAddress(false);
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
