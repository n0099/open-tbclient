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
    private LinearLayout fHO;
    private HeadImageView fHP;
    private ImageView fHQ;
    private TextView fHR;
    private LinearLayout fHS;
    private ImageView fHT;
    private TextView fHU;
    private LinearLayout fHV;
    private ImageView fHW;
    private TextView fHX;
    private LinearLayout fHY;
    private ImageView fHZ;
    private TextView fIa;
    private LinearLayout fIb;
    private ImageView fIc;
    private TextView fId;
    private ImageView fIe;
    private ImageView fIf;
    private ImageView fIg;
    private ObjectAnimator fIh;
    private int fIi;
    private List<h.a> fIj;
    private String fIk;
    private com.baidu.tieba.ueg.d fIl;
    private View mRootView;
    private RotateAnimation mRotateAnimation;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fIi = -1;
        this.fIj = new ArrayList();
        initView();
    }

    private void initView() {
        this.mRootView = getView();
        this.fHO = (LinearLayout) this.mRootView.findViewById(R.id.entrance_follow);
        this.fHS = (LinearLayout) this.mRootView.findViewById(R.id.entrance_ranklist);
        this.fHV = (LinearLayout) this.mRootView.findViewById(R.id.entrance_discuss);
        this.fHY = (LinearLayout) this.mRootView.findViewById(R.id.entrance_person_center);
        this.fIf = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_img_diandian);
        this.fIb = (LinearLayout) this.mRootView.findViewById(R.id.entrance_start_recorder);
        this.fHP = (HeadImageView) this.mRootView.findViewById(R.id.entrance_follow_img);
        this.fHP.setIsRound(true);
        this.fHP.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fHP.setDefaultResource(17170445);
        this.fHP.setDefaultBgResource(17170445);
        this.fIg = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_circle);
        this.fHQ = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_default_img);
        this.fHT = (ImageView) this.mRootView.findViewById(R.id.entrance_ranklist_img);
        this.fHW = (ImageView) this.mRootView.findViewById(R.id.entrance_discuss_img);
        this.fHZ = (ImageView) this.mRootView.findViewById(R.id.entrance_person_center_img);
        this.fIc = (ImageView) this.mRootView.findViewById(R.id.entrance_start_recorder_img);
        this.fHR = (TextView) this.mRootView.findViewById(R.id.entrance_follow_desc);
        this.fHU = (TextView) this.mRootView.findViewById(R.id.entrance_ranklist_desc);
        this.fHX = (TextView) this.mRootView.findViewById(R.id.entrance_discuss_desc);
        this.fIa = (TextView) this.mRootView.findViewById(R.id.entrance_person_center_desc);
        this.fId = (TextView) this.mRootView.findViewById(R.id.entrance_start_recorder_desc);
        this.fIe = (ImageView) this.mRootView.findViewById(R.id.entrance_publish_live_red);
        this.fHO.setOnClickListener(this);
        this.fHS.setOnClickListener(this);
        this.fHV.setOnClickListener(this);
        this.fHY.setOnClickListener(this);
        this.fIb.setOnClickListener(this);
        this.mRotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation.setDuration(6000L);
        this.mRotateAnimation.setRepeatMode(1);
        this.mRotateAnimation.setRepeatCount(-1);
        this.mRotateAnimation.setInterpolator(new LinearInterpolator());
        this.fIh = ObjectAnimator.ofPropertyValuesHolder(this.fHP, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f));
        this.fIh.setInterpolator(new DecelerateInterpolator());
        this.fIh.setTarget(this.fHP);
        this.fIh.setRepeatCount(-1);
        this.fIh.setRepeatMode(1);
        this.fIh.setDuration(2000L);
        this.fIh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.1
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
                g.this.bGu();
            }
        });
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.fHR, (int) R.drawable.tab_super_entrance_txt_selecor);
        ap.setViewTextColor(this.fHU, (int) R.drawable.tab_super_entrance_txt_selecor);
        ap.setViewTextColor(this.fHX, (int) R.drawable.tab_super_entrance_txt_selecor);
        ap.setViewTextColor(this.fIa, (int) R.drawable.tab_super_entrance_txt_selecor);
        ap.setViewTextColor(this.fId, (int) R.drawable.tab_super_entrance_txt_selecor);
        ap.setImageResource(this.fHT, R.drawable.super_entrance_ranklist_bg_selector);
        ap.setImageResource(this.fHW, R.drawable.super_entrance_discuss_bg_selector);
        ap.setImageResource(this.fHZ, R.drawable.super_entrance_person_bg_selector);
        ap.setImageResource(this.fIc, R.drawable.super_entrance_start_recorder_bg_selector);
        ap.setImageResource(this.fIg, R.drawable.pic_live_tab_quan);
        if (8 == this.fIf.getVisibility()) {
            this.fHQ.setVisibility(0);
            this.fIg.setVisibility(8);
            ap.setBackgroundResource(this.fHQ, R.drawable.super_entrance_follow_bg_selector);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_live_super_enreances_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.i iVar) {
        if (iVar == null || iVar.fEJ == null) {
            stopAnim();
            return;
        }
        TiebaStatic.log("c13550");
        TiebaStatic.log("c13549");
        TiebaStatic.log("c13547");
        TiebaStatic.log("c13546");
        this.fIk = iVar.fEJ.fEG;
        if (!iVar.fEJ.fEE || y.isEmpty(iVar.fEJ.fEF)) {
            stopAnim();
            return;
        }
        this.fIj = iVar.fEJ.fEF;
        if (!y.isEmpty(this.fIj)) {
            startAnim();
            bGu();
        }
    }

    public void kJ(boolean z) {
        if (this.fIe != null) {
            if (z) {
                if (!com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), false)) {
                    com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), true);
                    this.fIe.setVisibility(0);
                    return;
                }
                this.fIe.setVisibility(8);
                return;
            }
            this.fIe.setVisibility(8);
        }
    }

    private void startAnim() {
        this.fHQ.setVisibility(8);
        this.fIf.setVisibility(0);
        this.fIg.setVisibility(0);
        this.fHP.setVisibility(0);
        this.fIf.clearAnimation();
        if (this.mRotateAnimation != null) {
            this.fIf.startAnimation(this.mRotateAnimation);
        }
        if (this.fIh != null) {
            if (this.fIh.isRunning()) {
                this.fIh.cancel();
            }
            this.fIh.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGu() {
        if (this.fHP != null && !y.isEmpty(this.fIj)) {
            this.fIi++;
            if (this.fIj.size() > this.fIi) {
                this.fHP.startLoad(this.fIj.get(this.fIi).portrait, 12, false);
            } else if (this.fIj.size() > 0) {
                this.fIi = 0;
                this.fHP.startLoad(this.fIj.get(this.fIi).portrait, 12, false);
            }
        }
    }

    private void stopAnim() {
        this.fIf.setVisibility(8);
        this.fIg.setVisibility(8);
        this.fHP.setVisibility(8);
        this.fIf.clearAnimation();
        if (this.fIh != null) {
            this.fIh.cancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fHO) {
            if (bg.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTabMyConcernActivityConfig(getTbPageContext().getPageActivity())));
            }
            TiebaStatic.log("c13552");
        } else if (view == this.fHS) {
            if (!StringUtils.isNull(this.fIk)) {
                com.baidu.tbadk.browser.a.startWebActivity(this.mContext.getApplicationContext(), getContext().getResources().getString(R.string.entrance_ranklist_tip), this.fIk, true, true, true, true, true, true, true);
                TiebaStatic.log("c13553");
            }
        } else if (view == this.fHV) {
            String string = com.baidu.tbadk.core.sharedPref.b.bik().getString("show_live_forum_url", "http://tieba.baidu.com/f?kw=百度直播");
            string = (StringUtils.isNull(string) || !string.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) ? "http://tieba.baidu.com/f?kw=百度直播" : "http://tieba.baidu.com/f?kw=百度直播";
            if (!string.contains("?")) {
                string = string + "?default_tab_id=1&call_from=15";
            } else if (!string.contains("&default_tab_id=")) {
                string = string + "&default_tab_id=1&call_from=15";
            }
            be.bju().a(this.mTbPageContext, new String[]{string}, true);
            TiebaStatic.log("c13554");
        } else if (view == this.fHY) {
            if (bg.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(this.mTbPageContext.getPageActivity(), String.valueOf(TbadkCoreApplication.getCurrentAccountId()), TbadkCoreApplication.getCurrentAccountName(), TbadkCoreApplication.getCurrentPortrait(), TbadkCoreApplication.getCurrentAccountInfo().getSex(), true)));
            }
            TiebaStatic.log("c13555");
        } else if (view == this.fIb) {
            bGv();
            TiebaStatic.log("c13617");
        }
    }

    private void bGv() {
        Plugin plugin2;
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getTbPageContext().getPageActivity());
            aVar.setAutoNight(false);
            aVar.ns(R.string.prompt);
            aVar.zz(getContext().getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(getTbPageContext()).bhg();
        } else if (bg.checkUpIsLogin(getTbPageContext().getPageActivity())) {
            if (this.fIl == null) {
                this.fIl = new com.baidu.tieba.ueg.d(getTbPageContext());
            }
            if (!this.fIl.dAq()) {
                if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                    com.baidu.adp.lib.util.l.showToast(getTbPageContext().getPageActivity(), (int) R.string.plugin_config_not_found);
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), true);
                this.fIe.setVisibility(8);
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
                    com.baidu.adp.lib.c.a.mf().getAddress(false);
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
