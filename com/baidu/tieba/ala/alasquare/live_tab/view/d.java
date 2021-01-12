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
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.b<i> {
    private LinearLayout gBB;
    private HeadImageView gBC;
    private ImageView gBD;
    private TextView gBE;
    private LinearLayout gBF;
    private ImageView gBG;
    private TextView gBH;
    private LinearLayout gBI;
    private ImageView gBJ;
    private TextView gBK;
    private LinearLayout gBL;
    private ImageView gBM;
    private TextView gBN;
    private LinearLayout gBO;
    private ImageView gBP;
    private TextView gBQ;
    private ImageView gBR;
    private ImageView gBS;
    private ImageView gBT;
    private ObjectAnimator gBU;
    private int gBV;
    private List<h.a> gBW;
    private String gBX;
    private com.baidu.tieba.ueg.d gBY;
    private View mRootView;
    private RotateAnimation mRotateAnimation;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gBV = -1;
        this.gBW = new ArrayList();
        initView();
    }

    private void initView() {
        this.mRootView = getView();
        this.gBB = (LinearLayout) this.mRootView.findViewById(R.id.entrance_follow);
        this.gBF = (LinearLayout) this.mRootView.findViewById(R.id.entrance_ranklist);
        this.gBI = (LinearLayout) this.mRootView.findViewById(R.id.entrance_discuss);
        this.gBL = (LinearLayout) this.mRootView.findViewById(R.id.entrance_person_center);
        this.gBS = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_img_diandian);
        this.gBO = (LinearLayout) this.mRootView.findViewById(R.id.entrance_start_recorder);
        this.gBC = (HeadImageView) this.mRootView.findViewById(R.id.entrance_follow_img);
        this.gBC.setIsRound(true);
        this.gBC.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gBC.setDefaultResource(17170445);
        this.gBC.setDefaultBgResource(17170445);
        this.gBT = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_circle);
        this.gBD = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_default_img);
        this.gBG = (ImageView) this.mRootView.findViewById(R.id.entrance_ranklist_img);
        this.gBJ = (ImageView) this.mRootView.findViewById(R.id.entrance_discuss_img);
        this.gBM = (ImageView) this.mRootView.findViewById(R.id.entrance_person_center_img);
        this.gBP = (ImageView) this.mRootView.findViewById(R.id.entrance_start_recorder_img);
        this.gBE = (TextView) this.mRootView.findViewById(R.id.entrance_follow_desc);
        this.gBH = (TextView) this.mRootView.findViewById(R.id.entrance_ranklist_desc);
        this.gBK = (TextView) this.mRootView.findViewById(R.id.entrance_discuss_desc);
        this.gBN = (TextView) this.mRootView.findViewById(R.id.entrance_person_center_desc);
        this.gBQ = (TextView) this.mRootView.findViewById(R.id.entrance_start_recorder_desc);
        this.gBR = (ImageView) this.mRootView.findViewById(R.id.entrance_publish_live_red);
        this.gBB.setOnClickListener(this);
        this.gBF.setOnClickListener(this);
        this.gBI.setOnClickListener(this);
        this.gBL.setOnClickListener(this);
        this.gBO.setOnClickListener(this);
        this.mRotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation.setDuration(6000L);
        this.mRotateAnimation.setRepeatMode(1);
        this.mRotateAnimation.setRepeatCount(-1);
        this.mRotateAnimation.setInterpolator(new LinearInterpolator());
        this.gBU = ObjectAnimator.ofPropertyValuesHolder(this.gBC, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f));
        this.gBU.setInterpolator(new DecelerateInterpolator());
        this.gBU.setTarget(this.gBC);
        this.gBU.setRepeatCount(-1);
        this.gBU.setRepeatMode(1);
        this.gBU.setDuration(2000L);
        this.gBU.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.d.1
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
                d.this.bRp();
            }
        });
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        ao.setViewTextColor(this.gBE, R.drawable.tab_super_entrance_txt_selecor);
        ao.setViewTextColor(this.gBH, R.drawable.tab_super_entrance_txt_selecor);
        ao.setViewTextColor(this.gBK, R.drawable.tab_super_entrance_txt_selecor);
        ao.setViewTextColor(this.gBN, R.drawable.tab_super_entrance_txt_selecor);
        ao.setViewTextColor(this.gBQ, R.drawable.tab_super_entrance_txt_selecor);
        ao.setImageResource(this.gBG, R.drawable.super_entrance_ranklist_bg_selector);
        ao.setImageResource(this.gBJ, R.drawable.super_entrance_discuss_bg_selector);
        ao.setImageResource(this.gBM, R.drawable.super_entrance_person_bg_selector);
        ao.setImageResource(this.gBP, R.drawable.super_entrance_start_recorder_bg_selector);
        ao.setImageResource(this.gBT, R.drawable.pic_live_tab_quan);
        if (8 == this.gBS.getVisibility()) {
            this.gBD.setVisibility(0);
            this.gBT.setVisibility(8);
            ao.setBackgroundResource(this.gBD, R.drawable.super_entrance_follow_bg_selector);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_live_super_enreances_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(i iVar) {
        if (iVar == null || iVar.gym == null) {
            stopAnim();
            return;
        }
        TiebaStatic.log("c13550");
        TiebaStatic.log("c13549");
        TiebaStatic.log("c13547");
        TiebaStatic.log("c13546");
        this.gBX = iVar.gym.gyj;
        if (!iVar.gym.gyh || x.isEmpty(iVar.gym.gyi)) {
            stopAnim();
            return;
        }
        this.gBW = iVar.gym.gyi;
        if (!x.isEmpty(this.gBW)) {
            startAnim();
            bRp();
        }
    }

    public void mB(boolean z) {
        if (this.gBR != null) {
            if (z) {
                if (!com.baidu.tbadk.core.sharedPref.b.brx().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), false)) {
                    com.baidu.tbadk.core.sharedPref.b.brx().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), true);
                    this.gBR.setVisibility(0);
                    return;
                }
                this.gBR.setVisibility(8);
                return;
            }
            this.gBR.setVisibility(8);
        }
    }

    private void startAnim() {
        this.gBD.setVisibility(8);
        this.gBS.setVisibility(0);
        this.gBT.setVisibility(0);
        this.gBC.setVisibility(0);
        this.gBS.clearAnimation();
        if (this.mRotateAnimation != null) {
            this.gBS.startAnimation(this.mRotateAnimation);
        }
        if (this.gBU != null) {
            if (this.gBU.isRunning()) {
                this.gBU.cancel();
            }
            this.gBU.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRp() {
        if (this.gBC != null && !x.isEmpty(this.gBW)) {
            this.gBV++;
            if (this.gBW.size() > this.gBV) {
                this.gBC.startLoad(this.gBW.get(this.gBV).portrait, 12, false);
            } else if (this.gBW.size() > 0) {
                this.gBV = 0;
                this.gBC.startLoad(this.gBW.get(this.gBV).portrait, 12, false);
            }
        }
    }

    private void stopAnim() {
        this.gBS.setVisibility(8);
        this.gBT.setVisibility(8);
        this.gBC.setVisibility(8);
        this.gBS.clearAnimation();
        if (this.gBU != null) {
            this.gBU.cancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gBB) {
            if (bg.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTabMyConcernActivityConfig(getTbPageContext().getPageActivity())));
            }
            TiebaStatic.log("c13552");
        } else if (view == this.gBF) {
            if (!StringUtils.isNull(this.gBX)) {
                com.baidu.tbadk.browser.a.startWebActivity(this.mContext.getApplicationContext(), getContext().getResources().getString(R.string.entrance_ranklist_tip), this.gBX, true, true, true, true, true, true, true);
                TiebaStatic.log("c13553");
            }
        } else if (view == this.gBI) {
            String string = com.baidu.tbadk.core.sharedPref.b.brx().getString("show_live_forum_url", "http://tieba.baidu.com/f?kw=百度直播");
            string = (StringUtils.isNull(string) || !string.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) ? "http://tieba.baidu.com/f?kw=百度直播" : "http://tieba.baidu.com/f?kw=百度直播";
            if (!string.contains("?")) {
                string = string + "?default_tab_id=1&call_from=15";
            } else if (!string.contains("&default_tab_id=")) {
                string = string + "&default_tab_id=1&call_from=15";
            }
            be.bsB().a(this.mTbPageContext, new String[]{string}, true);
            TiebaStatic.log("c13554");
        } else if (view == this.gBL) {
            if (bg.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(this.mTbPageContext.getPageActivity(), String.valueOf(TbadkCoreApplication.getCurrentAccountId()), TbadkCoreApplication.getCurrentAccountName(), TbadkCoreApplication.getCurrentPortrait(), TbadkCoreApplication.getCurrentAccountInfo().getSex(), true)));
            }
            TiebaStatic.log("c13555");
        } else if (view == this.gBO) {
            bRq();
            TiebaStatic.log("c13617");
        }
    }

    private void bRq() {
        Plugin plugin2;
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getTbPageContext().getPageActivity());
            aVar.setAutoNight(false);
            aVar.nt(R.string.prompt);
            aVar.Ad(getContext().getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.d.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(getTbPageContext()).bqe();
        } else if (bg.checkUpIsLogin(getTbPageContext().getPageActivity())) {
            if (this.gBY == null) {
                this.gBY = new com.baidu.tieba.ueg.d(getTbPageContext());
            }
            if (!this.gBY.dPh()) {
                if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                    l.showToast(getTbPageContext().getPageActivity(), R.string.plugin_config_not_found);
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.brx().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), true);
                this.gBR.setVisibility(8);
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
