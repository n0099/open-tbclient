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
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.b<i> {
    private ImageView gGA;
    private ObjectAnimator gGB;
    private int gGC;
    private List<h.a> gGD;
    private String gGE;
    private com.baidu.tieba.ueg.d gGF;
    private LinearLayout gGi;
    private HeadImageView gGj;
    private ImageView gGk;
    private TextView gGl;
    private LinearLayout gGm;
    private ImageView gGn;
    private TextView gGo;
    private LinearLayout gGp;
    private ImageView gGq;
    private TextView gGr;
    private LinearLayout gGs;
    private ImageView gGt;
    private TextView gGu;
    private LinearLayout gGv;
    private ImageView gGw;
    private TextView gGx;
    private ImageView gGy;
    private ImageView gGz;
    private View mRootView;
    private RotateAnimation mRotateAnimation;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gGC = -1;
        this.gGD = new ArrayList();
        initView();
    }

    private void initView() {
        this.mRootView = getView();
        this.gGi = (LinearLayout) this.mRootView.findViewById(R.id.entrance_follow);
        this.gGm = (LinearLayout) this.mRootView.findViewById(R.id.entrance_ranklist);
        this.gGp = (LinearLayout) this.mRootView.findViewById(R.id.entrance_discuss);
        this.gGs = (LinearLayout) this.mRootView.findViewById(R.id.entrance_person_center);
        this.gGz = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_img_diandian);
        this.gGv = (LinearLayout) this.mRootView.findViewById(R.id.entrance_start_recorder);
        this.gGj = (HeadImageView) this.mRootView.findViewById(R.id.entrance_follow_img);
        this.gGj.setIsRound(true);
        this.gGj.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gGj.setDefaultResource(17170445);
        this.gGj.setDefaultBgResource(17170445);
        this.gGA = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_circle);
        this.gGk = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_default_img);
        this.gGn = (ImageView) this.mRootView.findViewById(R.id.entrance_ranklist_img);
        this.gGq = (ImageView) this.mRootView.findViewById(R.id.entrance_discuss_img);
        this.gGt = (ImageView) this.mRootView.findViewById(R.id.entrance_person_center_img);
        this.gGw = (ImageView) this.mRootView.findViewById(R.id.entrance_start_recorder_img);
        this.gGl = (TextView) this.mRootView.findViewById(R.id.entrance_follow_desc);
        this.gGo = (TextView) this.mRootView.findViewById(R.id.entrance_ranklist_desc);
        this.gGr = (TextView) this.mRootView.findViewById(R.id.entrance_discuss_desc);
        this.gGu = (TextView) this.mRootView.findViewById(R.id.entrance_person_center_desc);
        this.gGx = (TextView) this.mRootView.findViewById(R.id.entrance_start_recorder_desc);
        this.gGy = (ImageView) this.mRootView.findViewById(R.id.entrance_publish_live_red);
        this.gGi.setOnClickListener(this);
        this.gGm.setOnClickListener(this);
        this.gGp.setOnClickListener(this);
        this.gGs.setOnClickListener(this);
        this.gGv.setOnClickListener(this);
        this.mRotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation.setDuration(6000L);
        this.mRotateAnimation.setRepeatMode(1);
        this.mRotateAnimation.setRepeatCount(-1);
        this.mRotateAnimation.setInterpolator(new LinearInterpolator());
        this.gGB = ObjectAnimator.ofPropertyValuesHolder(this.gGj, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f));
        this.gGB.setInterpolator(new DecelerateInterpolator());
        this.gGB.setTarget(this.gGj);
        this.gGB.setRepeatCount(-1);
        this.gGB.setRepeatMode(1);
        this.gGB.setDuration(2000L);
        this.gGB.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.d.1
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
                d.this.bSf();
            }
        });
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        ap.setViewTextColor(this.gGl, R.drawable.tab_super_entrance_txt_selecor);
        ap.setViewTextColor(this.gGo, R.drawable.tab_super_entrance_txt_selecor);
        ap.setViewTextColor(this.gGr, R.drawable.tab_super_entrance_txt_selecor);
        ap.setViewTextColor(this.gGu, R.drawable.tab_super_entrance_txt_selecor);
        ap.setViewTextColor(this.gGx, R.drawable.tab_super_entrance_txt_selecor);
        ap.setImageResource(this.gGn, R.drawable.super_entrance_ranklist_bg_selector);
        ap.setImageResource(this.gGq, R.drawable.super_entrance_discuss_bg_selector);
        ap.setImageResource(this.gGt, R.drawable.super_entrance_person_bg_selector);
        ap.setImageResource(this.gGw, R.drawable.super_entrance_start_recorder_bg_selector);
        ap.setImageResource(this.gGA, R.drawable.pic_live_tab_quan);
        if (8 == this.gGz.getVisibility()) {
            this.gGk.setVisibility(0);
            this.gGA.setVisibility(8);
            ap.setBackgroundResource(this.gGk, R.drawable.super_entrance_follow_bg_selector);
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
        this.gGE = iVar.gCT.gCQ;
        if (!iVar.gCT.gCO || y.isEmpty(iVar.gCT.gCP)) {
            stopAnim();
            return;
        }
        this.gGD = iVar.gCT.gCP;
        if (!y.isEmpty(this.gGD)) {
            startAnim();
            bSf();
        }
    }

    public void mF(boolean z) {
        if (this.gGy != null) {
            if (z) {
                if (!com.baidu.tbadk.core.sharedPref.b.brR().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), false)) {
                    com.baidu.tbadk.core.sharedPref.b.brR().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), true);
                    this.gGy.setVisibility(0);
                    return;
                }
                this.gGy.setVisibility(8);
                return;
            }
            this.gGy.setVisibility(8);
        }
    }

    private void startAnim() {
        this.gGk.setVisibility(8);
        this.gGz.setVisibility(0);
        this.gGA.setVisibility(0);
        this.gGj.setVisibility(0);
        this.gGz.clearAnimation();
        if (this.mRotateAnimation != null) {
            this.gGz.startAnimation(this.mRotateAnimation);
        }
        if (this.gGB != null) {
            if (this.gGB.isRunning()) {
                this.gGB.cancel();
            }
            this.gGB.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSf() {
        if (this.gGj != null && !y.isEmpty(this.gGD)) {
            this.gGC++;
            if (this.gGD.size() > this.gGC) {
                this.gGj.startLoad(this.gGD.get(this.gGC).portrait, 12, false);
            } else if (this.gGD.size() > 0) {
                this.gGC = 0;
                this.gGj.startLoad(this.gGD.get(this.gGC).portrait, 12, false);
            }
        }
    }

    private void stopAnim() {
        this.gGz.setVisibility(8);
        this.gGA.setVisibility(8);
        this.gGj.setVisibility(8);
        this.gGz.clearAnimation();
        if (this.gGB != null) {
            this.gGB.cancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gGi) {
            if (bh.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTabMyConcernActivityConfig(getTbPageContext().getPageActivity())));
            }
            TiebaStatic.log("c13552");
        } else if (view == this.gGm) {
            if (!StringUtils.isNull(this.gGE)) {
                com.baidu.tbadk.browser.a.startWebActivity(this.mContext.getApplicationContext(), getContext().getResources().getString(R.string.entrance_ranklist_tip), this.gGE, true, true, true, true, true, true, true);
                TiebaStatic.log("c13553");
            }
        } else if (view == this.gGp) {
            String string = com.baidu.tbadk.core.sharedPref.b.brR().getString("show_live_forum_url", "http://tieba.baidu.com/f?kw=百度直播");
            string = (StringUtils.isNull(string) || !string.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) ? "http://tieba.baidu.com/f?kw=百度直播" : "http://tieba.baidu.com/f?kw=百度直播";
            if (!string.contains("?")) {
                string = string + "?default_tab_id=1&call_from=15";
            } else if (!string.contains("&default_tab_id=")) {
                string = string + "&default_tab_id=1&call_from=15";
            }
            bf.bsY().a(this.mTbPageContext, new String[]{string}, true);
            TiebaStatic.log("c13554");
        } else if (view == this.gGs) {
            if (bh.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(this.mTbPageContext.getPageActivity(), String.valueOf(TbadkCoreApplication.getCurrentAccountId()), TbadkCoreApplication.getCurrentAccountName(), TbadkCoreApplication.getCurrentPortrait(), TbadkCoreApplication.getCurrentAccountInfo().getSex(), true)));
            }
            TiebaStatic.log("c13555");
        } else if (view == this.gGv) {
            bSg();
            TiebaStatic.log("c13617");
        }
    }

    private void bSg() {
        Plugin plugin2;
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getTbPageContext().getPageActivity());
            aVar.setAutoNight(false);
            aVar.nx(R.string.prompt);
            aVar.AB(getContext().getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.d.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(getTbPageContext()).bqz();
        } else if (bh.checkUpIsLogin(getTbPageContext().getPageActivity())) {
            if (this.gGF == null) {
                this.gGF = new com.baidu.tieba.ueg.d(getTbPageContext());
            }
            if (!this.gGF.dRI()) {
                if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                    l.showToast(getTbPageContext().getPageActivity(), R.string.plugin_config_not_found);
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.brR().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), true);
                this.gGy.setVisibility(8);
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
