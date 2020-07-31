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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.b.h;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpHost;
/* loaded from: classes4.dex */
public class g extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.b.i> {
    private LinearLayout fwA;
    private ImageView fwB;
    private TextView fwC;
    private LinearLayout fwD;
    private ImageView fwE;
    private TextView fwF;
    private LinearLayout fwG;
    private ImageView fwH;
    private TextView fwI;
    private LinearLayout fwJ;
    private ImageView fwK;
    private TextView fwL;
    private ImageView fwM;
    private ImageView fwN;
    private ImageView fwO;
    private ObjectAnimator fwP;
    private int fwQ;
    private List<h.a> fwR;
    private String fwS;
    private com.baidu.tieba.ueg.d fwT;
    private LinearLayout fww;
    private HeadImageView fwx;
    private ImageView fwy;
    private TextView fwz;
    private View mRootView;
    private RotateAnimation mRotateAnimation;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fwQ = -1;
        this.fwR = new ArrayList();
        initView();
    }

    private void initView() {
        this.mRootView = getView();
        this.fww = (LinearLayout) this.mRootView.findViewById(R.id.entrance_follow);
        this.fwA = (LinearLayout) this.mRootView.findViewById(R.id.entrance_ranklist);
        this.fwD = (LinearLayout) this.mRootView.findViewById(R.id.entrance_discuss);
        this.fwG = (LinearLayout) this.mRootView.findViewById(R.id.entrance_person_center);
        this.fwN = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_img_diandian);
        this.fwJ = (LinearLayout) this.mRootView.findViewById(R.id.entrance_start_recorder);
        this.fwx = (HeadImageView) this.mRootView.findViewById(R.id.entrance_follow_img);
        this.fwx.setIsRound(true);
        this.fwx.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fwx.setDefaultResource(17170445);
        this.fwx.setDefaultBgResource(17170445);
        this.fwO = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_circle);
        this.fwy = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_default_img);
        this.fwB = (ImageView) this.mRootView.findViewById(R.id.entrance_ranklist_img);
        this.fwE = (ImageView) this.mRootView.findViewById(R.id.entrance_discuss_img);
        this.fwH = (ImageView) this.mRootView.findViewById(R.id.entrance_person_center_img);
        this.fwK = (ImageView) this.mRootView.findViewById(R.id.entrance_start_recorder_img);
        this.fwz = (TextView) this.mRootView.findViewById(R.id.entrance_follow_desc);
        this.fwC = (TextView) this.mRootView.findViewById(R.id.entrance_ranklist_desc);
        this.fwF = (TextView) this.mRootView.findViewById(R.id.entrance_discuss_desc);
        this.fwI = (TextView) this.mRootView.findViewById(R.id.entrance_person_center_desc);
        this.fwL = (TextView) this.mRootView.findViewById(R.id.entrance_start_recorder_desc);
        this.fwM = (ImageView) this.mRootView.findViewById(R.id.entrance_publish_live_red);
        this.fww.setOnClickListener(this);
        this.fwA.setOnClickListener(this);
        this.fwD.setOnClickListener(this);
        this.fwG.setOnClickListener(this);
        this.fwJ.setOnClickListener(this);
        this.mRotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation.setDuration(6000L);
        this.mRotateAnimation.setRepeatMode(1);
        this.mRotateAnimation.setRepeatCount(-1);
        this.mRotateAnimation.setInterpolator(new LinearInterpolator());
        this.fwP = ObjectAnimator.ofPropertyValuesHolder(this.fwx, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f));
        this.fwP.setInterpolator(new DecelerateInterpolator());
        this.fwP.setTarget(this.fwx);
        this.fwP.setRepeatCount(-1);
        this.fwP.setRepeatMode(1);
        this.fwP.setDuration(2000L);
        this.fwP.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.1
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
                g.this.bxv();
            }
        });
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        ao.setViewTextColor(this.fwz, R.drawable.tab_super_entrance_txt_selecor);
        ao.setViewTextColor(this.fwC, R.drawable.tab_super_entrance_txt_selecor);
        ao.setViewTextColor(this.fwF, R.drawable.tab_super_entrance_txt_selecor);
        ao.setViewTextColor(this.fwI, R.drawable.tab_super_entrance_txt_selecor);
        ao.setViewTextColor(this.fwL, R.drawable.tab_super_entrance_txt_selecor);
        ao.setImageResource(this.fwB, R.drawable.super_entrance_ranklist_bg_selector);
        ao.setImageResource(this.fwE, R.drawable.super_entrance_discuss_bg_selector);
        ao.setImageResource(this.fwH, R.drawable.super_entrance_person_bg_selector);
        ao.setImageResource(this.fwK, R.drawable.super_entrance_start_recorder_bg_selector);
        ao.setImageResource(this.fwO, R.drawable.pic_live_tab_quan);
        if (8 == this.fwN.getVisibility()) {
            this.fwy.setVisibility(0);
            this.fwO.setVisibility(8);
            ao.setBackgroundResource(this.fwy, R.drawable.super_entrance_follow_bg_selector);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_live_super_enreances_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.i iVar) {
        if (iVar == null || iVar.ftq == null) {
            stopAnim();
            return;
        }
        TiebaStatic.log("c13550");
        TiebaStatic.log("c13549");
        TiebaStatic.log("c13547");
        TiebaStatic.log("c13546");
        this.fwS = iVar.ftq.ftm;
        if (!iVar.ftq.ftk || x.isEmpty(iVar.ftq.ftl)) {
            stopAnim();
            return;
        }
        this.fwR = iVar.ftq.ftl;
        if (!x.isEmpty(this.fwR)) {
            startAnim();
            bxv();
        }
    }

    public void kl(boolean z) {
        if (this.fwM != null) {
            if (z) {
                if (!com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), false)) {
                    com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), true);
                    this.fwM.setVisibility(0);
                    return;
                }
                this.fwM.setVisibility(8);
                return;
            }
            this.fwM.setVisibility(8);
        }
    }

    private void startAnim() {
        this.fwy.setVisibility(8);
        this.fwN.setVisibility(0);
        this.fwO.setVisibility(0);
        this.fwx.setVisibility(0);
        this.fwN.clearAnimation();
        if (this.mRotateAnimation != null) {
            this.fwN.startAnimation(this.mRotateAnimation);
        }
        if (this.fwP != null) {
            if (this.fwP.isRunning()) {
                this.fwP.cancel();
            }
            this.fwP.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxv() {
        if (this.fwx != null && !x.isEmpty(this.fwR)) {
            this.fwQ++;
            if (this.fwR.size() > this.fwQ) {
                this.fwx.startLoad(this.fwR.get(this.fwQ).portrait, 12, false);
            } else if (this.fwR.size() > 0) {
                this.fwQ = 0;
                this.fwx.startLoad(this.fwR.get(this.fwQ).portrait, 12, false);
            }
        }
    }

    private void stopAnim() {
        this.fwN.setVisibility(8);
        this.fwO.setVisibility(8);
        this.fwx.setVisibility(8);
        this.fwN.clearAnimation();
        if (this.fwP != null) {
            this.fwP.cancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fww) {
            if (bf.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTabMyConcernActivityConfig(getTbPageContext().getPageActivity())));
            }
            TiebaStatic.log("c13552");
        } else if (view == this.fwA) {
            if (!StringUtils.isNull(this.fwS)) {
                com.baidu.tbadk.browser.a.startWebActivity(this.mContext.getApplicationContext(), getContext().getResources().getString(R.string.entrance_ranklist_tip), this.fwS, true, true, true, true, true, true, true);
                TiebaStatic.log("c13553");
            }
        } else if (view == this.fwD) {
            String string = com.baidu.tbadk.core.sharedPref.b.aZP().getString("show_live_forum_url", "http://tieba.baidu.com/f?kw=百度直播");
            string = (StringUtils.isNull(string) || !string.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) ? "http://tieba.baidu.com/f?kw=百度直播" : "http://tieba.baidu.com/f?kw=百度直播";
            if (!string.contains("?")) {
                string = string + "?default_tab_id=1&call_from=15";
            } else if (!string.contains("&default_tab_id=")) {
                string = string + "&default_tab_id=1&call_from=15";
            }
            bd.baV().a(this.mTbPageContext, new String[]{string}, true);
            TiebaStatic.log("c13554");
        } else if (view == this.fwG) {
            if (bf.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(this.mTbPageContext.getPageActivity(), String.valueOf(TbadkCoreApplication.getCurrentAccountId()), TbadkCoreApplication.getCurrentAccountName(), TbadkCoreApplication.getCurrentPortrait(), TbadkCoreApplication.getCurrentAccountInfo().getSex(), true)));
            }
            TiebaStatic.log("c13555");
        } else if (view == this.fwJ) {
            bxw();
            TiebaStatic.log("c13617");
        }
    }

    private void bxw() {
        Plugin plugin2;
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getTbPageContext().getPageActivity());
            aVar.setAutoNight(false);
            aVar.lm(R.string.prompt);
            aVar.xl(getContext().getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(getTbPageContext()).aYL();
        } else if (bf.checkUpIsLogin(getTbPageContext().getPageActivity())) {
            if (this.fwT == null) {
                this.fwT = new com.baidu.tieba.ueg.d(getTbPageContext());
            }
            if (!this.fwT.doU()) {
                if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                    com.baidu.adp.lib.util.l.showToast(getTbPageContext().getPageActivity(), R.string.plugin_config_not_found);
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), true);
                this.fwM.setVisibility(8);
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
