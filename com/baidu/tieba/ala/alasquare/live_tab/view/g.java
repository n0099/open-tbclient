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
    private LinearLayout ffP;
    private HeadImageView ffQ;
    private ImageView ffR;
    private TextView ffS;
    private LinearLayout ffT;
    private ImageView ffU;
    private TextView ffV;
    private LinearLayout ffW;
    private ImageView ffX;
    private TextView ffY;
    private LinearLayout ffZ;
    private ImageView fga;
    private TextView fgb;
    private LinearLayout fgc;
    private ImageView fgd;
    private TextView fge;
    private ImageView fgf;
    private ImageView fgg;
    private ImageView fgh;
    private ObjectAnimator fgi;
    private int fgj;
    private List<h.a> fgk;
    private String fgl;
    private com.baidu.tieba.ueg.d fgm;
    private View mRootView;
    private RotateAnimation mRotateAnimation;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fgj = -1;
        this.fgk = new ArrayList();
        initView();
    }

    private void initView() {
        this.mRootView = getView();
        this.ffP = (LinearLayout) this.mRootView.findViewById(R.id.entrance_follow);
        this.ffT = (LinearLayout) this.mRootView.findViewById(R.id.entrance_ranklist);
        this.ffW = (LinearLayout) this.mRootView.findViewById(R.id.entrance_discuss);
        this.ffZ = (LinearLayout) this.mRootView.findViewById(R.id.entrance_person_center);
        this.fgg = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_img_diandian);
        this.fgc = (LinearLayout) this.mRootView.findViewById(R.id.entrance_start_recorder);
        this.ffQ = (HeadImageView) this.mRootView.findViewById(R.id.entrance_follow_img);
        this.ffQ.setIsRound(true);
        this.ffQ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ffQ.setDefaultResource(17170445);
        this.ffQ.setDefaultBgResource(17170445);
        this.fgh = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_circle);
        this.ffR = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_default_img);
        this.ffU = (ImageView) this.mRootView.findViewById(R.id.entrance_ranklist_img);
        this.ffX = (ImageView) this.mRootView.findViewById(R.id.entrance_discuss_img);
        this.fga = (ImageView) this.mRootView.findViewById(R.id.entrance_person_center_img);
        this.fgd = (ImageView) this.mRootView.findViewById(R.id.entrance_start_recorder_img);
        this.ffS = (TextView) this.mRootView.findViewById(R.id.entrance_follow_desc);
        this.ffV = (TextView) this.mRootView.findViewById(R.id.entrance_ranklist_desc);
        this.ffY = (TextView) this.mRootView.findViewById(R.id.entrance_discuss_desc);
        this.fgb = (TextView) this.mRootView.findViewById(R.id.entrance_person_center_desc);
        this.fge = (TextView) this.mRootView.findViewById(R.id.entrance_start_recorder_desc);
        this.fgf = (ImageView) this.mRootView.findViewById(R.id.entrance_publish_live_red);
        this.ffP.setOnClickListener(this);
        this.ffT.setOnClickListener(this);
        this.ffW.setOnClickListener(this);
        this.ffZ.setOnClickListener(this);
        this.fgc.setOnClickListener(this);
        this.mRotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation.setDuration(6000L);
        this.mRotateAnimation.setRepeatMode(1);
        this.mRotateAnimation.setRepeatCount(-1);
        this.mRotateAnimation.setInterpolator(new LinearInterpolator());
        this.fgi = ObjectAnimator.ofPropertyValuesHolder(this.ffQ, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f));
        this.fgi.setInterpolator(new DecelerateInterpolator());
        this.fgi.setTarget(this.ffQ);
        this.fgi.setRepeatCount(-1);
        this.fgi.setRepeatMode(1);
        this.fgi.setDuration(2000L);
        this.fgi.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.1
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
                g.this.brn();
            }
        });
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        am.setViewTextColor(this.ffS, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setViewTextColor(this.ffV, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setViewTextColor(this.ffY, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setViewTextColor(this.fgb, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setViewTextColor(this.fge, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setImageResource(this.ffU, R.drawable.super_entrance_ranklist_bg_selector);
        am.setImageResource(this.ffX, R.drawable.super_entrance_discuss_bg_selector);
        am.setImageResource(this.fga, R.drawable.super_entrance_person_bg_selector);
        am.setImageResource(this.fgd, R.drawable.super_entrance_start_recorder_bg_selector);
        am.setImageResource(this.fgh, R.drawable.pic_live_tab_quan);
        if (8 == this.fgg.getVisibility()) {
            this.ffR.setVisibility(0);
            this.fgh.setVisibility(8);
            am.setBackgroundResource(this.ffR, R.drawable.super_entrance_follow_bg_selector);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_live_super_enreances_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.i iVar) {
        if (iVar == null || iVar.fcL == null) {
            stopAnim();
            return;
        }
        TiebaStatic.log("c13550");
        TiebaStatic.log("c13549");
        TiebaStatic.log("c13547");
        TiebaStatic.log("c13546");
        this.fgl = iVar.fcL.fcI;
        if (!iVar.fcL.fcG || v.isEmpty(iVar.fcL.fcH)) {
            stopAnim();
            return;
        }
        this.fgk = iVar.fcL.fcH;
        if (!v.isEmpty(this.fgk)) {
            startAnim();
            brn();
        }
    }

    public void ju(boolean z) {
        if (this.fgf != null) {
            if (z) {
                if (!com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), false)) {
                    com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), true);
                    this.fgf.setVisibility(0);
                    return;
                }
                this.fgf.setVisibility(8);
                return;
            }
            this.fgf.setVisibility(8);
        }
    }

    private void startAnim() {
        this.ffR.setVisibility(8);
        this.fgg.setVisibility(0);
        this.fgh.setVisibility(0);
        this.ffQ.setVisibility(0);
        this.fgg.clearAnimation();
        if (this.mRotateAnimation != null) {
            this.fgg.startAnimation(this.mRotateAnimation);
        }
        if (this.fgi != null) {
            if (this.fgi.isRunning()) {
                this.fgi.cancel();
            }
            this.fgi.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brn() {
        if (this.ffQ != null && !v.isEmpty(this.fgk)) {
            this.fgj++;
            if (this.fgk.size() > this.fgj) {
                this.ffQ.startLoad(this.fgk.get(this.fgj).portrait, 12, false);
            } else if (this.fgk.size() > 0) {
                this.fgj = 0;
                this.ffQ.startLoad(this.fgk.get(this.fgj).portrait, 12, false);
            }
        }
    }

    private void stopAnim() {
        this.fgg.setVisibility(8);
        this.fgh.setVisibility(8);
        this.ffQ.setVisibility(8);
        this.fgg.clearAnimation();
        if (this.fgi != null) {
            this.fgi.cancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ffP) {
            if (bc.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTabMyConcernActivityConfig(getTbPageContext().getPageActivity())));
            }
            TiebaStatic.log("c13552");
        } else if (view == this.ffT) {
            if (!StringUtils.isNull(this.fgl)) {
                com.baidu.tbadk.browser.a.startWebActivity(this.mContext.getApplicationContext(), getContext().getResources().getString(R.string.entrance_ranklist_tip), this.fgl, true, true, true, true, true, true, true);
                TiebaStatic.log("c13553");
            }
        } else if (view == this.ffW) {
            String string = com.baidu.tbadk.core.sharedPref.b.aTX().getString("show_live_forum_url", "http://tieba.baidu.com/f?kw=百度直播");
            string = (StringUtils.isNull(string) || !string.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) ? "http://tieba.baidu.com/f?kw=百度直播" : "http://tieba.baidu.com/f?kw=百度直播";
            if (!string.contains("?")) {
                string = string + "?default_tab_id=1&call_from=15";
            } else if (!string.contains("&default_tab_id=")) {
                string = string + "&default_tab_id=1&call_from=15";
            }
            ba.aUZ().a(this.mTbPageContext, new String[]{string}, true);
            TiebaStatic.log("c13554");
        } else if (view == this.ffZ) {
            if (bc.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(this.mTbPageContext.getPageActivity(), String.valueOf(TbadkCoreApplication.getCurrentAccountId()), TbadkCoreApplication.getCurrentAccountName(), TbadkCoreApplication.getCurrentPortrait(), TbadkCoreApplication.getCurrentAccountInfo().getSex(), true)));
            }
            TiebaStatic.log("c13555");
        } else if (view == this.fgc) {
            bro();
            TiebaStatic.log("c13617");
        }
    }

    private void bro() {
        Plugin plugin2;
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getTbPageContext().getPageActivity());
            aVar.setAutoNight(false);
            aVar.kC(R.string.prompt);
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
            if (this.fgm == null) {
                this.fgm = new com.baidu.tieba.ueg.d(getTbPageContext());
            }
            if (!this.fgm.dhk()) {
                if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                    com.baidu.adp.lib.util.l.showToast(getTbPageContext().getPageActivity(), (int) R.string.plugin_config_not_found);
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), true);
                this.fgf.setVisibility(8);
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
