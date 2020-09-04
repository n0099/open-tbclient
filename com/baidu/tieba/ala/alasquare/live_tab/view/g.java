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
    private LinearLayout fHS;
    private HeadImageView fHT;
    private ImageView fHU;
    private TextView fHV;
    private LinearLayout fHW;
    private ImageView fHX;
    private TextView fHY;
    private LinearLayout fHZ;
    private ImageView fIa;
    private TextView fIb;
    private LinearLayout fIc;
    private ImageView fId;
    private TextView fIe;
    private LinearLayout fIf;
    private ImageView fIg;
    private TextView fIh;
    private ImageView fIi;
    private ImageView fIj;
    private ImageView fIk;
    private ObjectAnimator fIl;
    private int fIm;
    private List<h.a> fIn;
    private String fIo;
    private com.baidu.tieba.ueg.d fIp;
    private View mRootView;
    private RotateAnimation mRotateAnimation;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fIm = -1;
        this.fIn = new ArrayList();
        initView();
    }

    private void initView() {
        this.mRootView = getView();
        this.fHS = (LinearLayout) this.mRootView.findViewById(R.id.entrance_follow);
        this.fHW = (LinearLayout) this.mRootView.findViewById(R.id.entrance_ranklist);
        this.fHZ = (LinearLayout) this.mRootView.findViewById(R.id.entrance_discuss);
        this.fIc = (LinearLayout) this.mRootView.findViewById(R.id.entrance_person_center);
        this.fIj = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_img_diandian);
        this.fIf = (LinearLayout) this.mRootView.findViewById(R.id.entrance_start_recorder);
        this.fHT = (HeadImageView) this.mRootView.findViewById(R.id.entrance_follow_img);
        this.fHT.setIsRound(true);
        this.fHT.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fHT.setDefaultResource(17170445);
        this.fHT.setDefaultBgResource(17170445);
        this.fIk = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_circle);
        this.fHU = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_default_img);
        this.fHX = (ImageView) this.mRootView.findViewById(R.id.entrance_ranklist_img);
        this.fIa = (ImageView) this.mRootView.findViewById(R.id.entrance_discuss_img);
        this.fId = (ImageView) this.mRootView.findViewById(R.id.entrance_person_center_img);
        this.fIg = (ImageView) this.mRootView.findViewById(R.id.entrance_start_recorder_img);
        this.fHV = (TextView) this.mRootView.findViewById(R.id.entrance_follow_desc);
        this.fHY = (TextView) this.mRootView.findViewById(R.id.entrance_ranklist_desc);
        this.fIb = (TextView) this.mRootView.findViewById(R.id.entrance_discuss_desc);
        this.fIe = (TextView) this.mRootView.findViewById(R.id.entrance_person_center_desc);
        this.fIh = (TextView) this.mRootView.findViewById(R.id.entrance_start_recorder_desc);
        this.fIi = (ImageView) this.mRootView.findViewById(R.id.entrance_publish_live_red);
        this.fHS.setOnClickListener(this);
        this.fHW.setOnClickListener(this);
        this.fHZ.setOnClickListener(this);
        this.fIc.setOnClickListener(this);
        this.fIf.setOnClickListener(this);
        this.mRotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation.setDuration(6000L);
        this.mRotateAnimation.setRepeatMode(1);
        this.mRotateAnimation.setRepeatCount(-1);
        this.mRotateAnimation.setInterpolator(new LinearInterpolator());
        this.fIl = ObjectAnimator.ofPropertyValuesHolder(this.fHT, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f));
        this.fIl.setInterpolator(new DecelerateInterpolator());
        this.fIl.setTarget(this.fHT);
        this.fIl.setRepeatCount(-1);
        this.fIl.setRepeatMode(1);
        this.fIl.setDuration(2000L);
        this.fIl.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.1
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
                g.this.bGv();
            }
        });
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.fHV, (int) R.drawable.tab_super_entrance_txt_selecor);
        ap.setViewTextColor(this.fHY, (int) R.drawable.tab_super_entrance_txt_selecor);
        ap.setViewTextColor(this.fIb, (int) R.drawable.tab_super_entrance_txt_selecor);
        ap.setViewTextColor(this.fIe, (int) R.drawable.tab_super_entrance_txt_selecor);
        ap.setViewTextColor(this.fIh, (int) R.drawable.tab_super_entrance_txt_selecor);
        ap.setImageResource(this.fHX, R.drawable.super_entrance_ranklist_bg_selector);
        ap.setImageResource(this.fIa, R.drawable.super_entrance_discuss_bg_selector);
        ap.setImageResource(this.fId, R.drawable.super_entrance_person_bg_selector);
        ap.setImageResource(this.fIg, R.drawable.super_entrance_start_recorder_bg_selector);
        ap.setImageResource(this.fIk, R.drawable.pic_live_tab_quan);
        if (8 == this.fIj.getVisibility()) {
            this.fHU.setVisibility(0);
            this.fIk.setVisibility(8);
            ap.setBackgroundResource(this.fHU, R.drawable.super_entrance_follow_bg_selector);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_live_super_enreances_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.i iVar) {
        if (iVar == null || iVar.fEN == null) {
            stopAnim();
            return;
        }
        TiebaStatic.log("c13550");
        TiebaStatic.log("c13549");
        TiebaStatic.log("c13547");
        TiebaStatic.log("c13546");
        this.fIo = iVar.fEN.fEK;
        if (!iVar.fEN.fEI || y.isEmpty(iVar.fEN.fEJ)) {
            stopAnim();
            return;
        }
        this.fIn = iVar.fEN.fEJ;
        if (!y.isEmpty(this.fIn)) {
            startAnim();
            bGv();
        }
    }

    public void kL(boolean z) {
        if (this.fIi != null) {
            if (z) {
                if (!com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), false)) {
                    com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), true);
                    this.fIi.setVisibility(0);
                    return;
                }
                this.fIi.setVisibility(8);
                return;
            }
            this.fIi.setVisibility(8);
        }
    }

    private void startAnim() {
        this.fHU.setVisibility(8);
        this.fIj.setVisibility(0);
        this.fIk.setVisibility(0);
        this.fHT.setVisibility(0);
        this.fIj.clearAnimation();
        if (this.mRotateAnimation != null) {
            this.fIj.startAnimation(this.mRotateAnimation);
        }
        if (this.fIl != null) {
            if (this.fIl.isRunning()) {
                this.fIl.cancel();
            }
            this.fIl.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGv() {
        if (this.fHT != null && !y.isEmpty(this.fIn)) {
            this.fIm++;
            if (this.fIn.size() > this.fIm) {
                this.fHT.startLoad(this.fIn.get(this.fIm).portrait, 12, false);
            } else if (this.fIn.size() > 0) {
                this.fIm = 0;
                this.fHT.startLoad(this.fIn.get(this.fIm).portrait, 12, false);
            }
        }
    }

    private void stopAnim() {
        this.fIj.setVisibility(8);
        this.fIk.setVisibility(8);
        this.fHT.setVisibility(8);
        this.fIj.clearAnimation();
        if (this.fIl != null) {
            this.fIl.cancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fHS) {
            if (bg.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTabMyConcernActivityConfig(getTbPageContext().getPageActivity())));
            }
            TiebaStatic.log("c13552");
        } else if (view == this.fHW) {
            if (!StringUtils.isNull(this.fIo)) {
                com.baidu.tbadk.browser.a.startWebActivity(this.mContext.getApplicationContext(), getContext().getResources().getString(R.string.entrance_ranklist_tip), this.fIo, true, true, true, true, true, true, true);
                TiebaStatic.log("c13553");
            }
        } else if (view == this.fHZ) {
            String string = com.baidu.tbadk.core.sharedPref.b.bik().getString("show_live_forum_url", "http://tieba.baidu.com/f?kw=百度直播");
            string = (StringUtils.isNull(string) || !string.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) ? "http://tieba.baidu.com/f?kw=百度直播" : "http://tieba.baidu.com/f?kw=百度直播";
            if (!string.contains("?")) {
                string = string + "?default_tab_id=1&call_from=15";
            } else if (!string.contains("&default_tab_id=")) {
                string = string + "&default_tab_id=1&call_from=15";
            }
            be.bju().a(this.mTbPageContext, new String[]{string}, true);
            TiebaStatic.log("c13554");
        } else if (view == this.fIc) {
            if (bg.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(this.mTbPageContext.getPageActivity(), String.valueOf(TbadkCoreApplication.getCurrentAccountId()), TbadkCoreApplication.getCurrentAccountName(), TbadkCoreApplication.getCurrentPortrait(), TbadkCoreApplication.getCurrentAccountInfo().getSex(), true)));
            }
            TiebaStatic.log("c13555");
        } else if (view == this.fIf) {
            bGw();
            TiebaStatic.log("c13617");
        }
    }

    private void bGw() {
        Plugin plugin2;
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getTbPageContext().getPageActivity());
            aVar.setAutoNight(false);
            aVar.ns(R.string.prompt);
            aVar.zA(getContext().getResources().getString(R.string.disallow_open_live_by_android_v5_0));
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
            if (this.fIp == null) {
                this.fIp = new com.baidu.tieba.ueg.d(getTbPageContext());
            }
            if (!this.fIp.dAz()) {
                if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                    com.baidu.adp.lib.util.l.showToast(getTbPageContext().getPageActivity(), (int) R.string.plugin_config_not_found);
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), true);
                this.fIi.setVisibility(8);
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
