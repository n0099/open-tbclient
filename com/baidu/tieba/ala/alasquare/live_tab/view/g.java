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
public class g extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.live_tab.b.i> {
    private ObjectAnimator eTA;
    private int eTB;
    private List<h.a> eTC;
    private String eTD;
    private com.baidu.tieba.ueg.d eTE;
    private LinearLayout eTh;
    private HeadImageView eTi;
    private ImageView eTj;
    private TextView eTk;
    private LinearLayout eTl;
    private ImageView eTm;
    private TextView eTn;
    private LinearLayout eTo;
    private ImageView eTp;
    private TextView eTq;
    private LinearLayout eTr;
    private ImageView eTs;
    private TextView eTt;
    private LinearLayout eTu;
    private ImageView eTv;
    private TextView eTw;
    private ImageView eTx;
    private ImageView eTy;
    private ImageView eTz;
    private View mRootView;
    private RotateAnimation mRotateAnimation;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eTB = -1;
        this.eTC = new ArrayList();
        initView();
    }

    private void initView() {
        this.mRootView = getView();
        this.eTh = (LinearLayout) this.mRootView.findViewById(R.id.entrance_follow);
        this.eTl = (LinearLayout) this.mRootView.findViewById(R.id.entrance_ranklist);
        this.eTo = (LinearLayout) this.mRootView.findViewById(R.id.entrance_discuss);
        this.eTr = (LinearLayout) this.mRootView.findViewById(R.id.entrance_person_center);
        this.eTy = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_img_diandian);
        this.eTu = (LinearLayout) this.mRootView.findViewById(R.id.entrance_start_recorder);
        this.eTi = (HeadImageView) this.mRootView.findViewById(R.id.entrance_follow_img);
        this.eTi.setIsRound(true);
        this.eTi.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eTi.setDefaultResource(17170445);
        this.eTi.setDefaultBgResource(17170445);
        this.eTz = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_circle);
        this.eTj = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_default_img);
        this.eTm = (ImageView) this.mRootView.findViewById(R.id.entrance_ranklist_img);
        this.eTp = (ImageView) this.mRootView.findViewById(R.id.entrance_discuss_img);
        this.eTs = (ImageView) this.mRootView.findViewById(R.id.entrance_person_center_img);
        this.eTv = (ImageView) this.mRootView.findViewById(R.id.entrance_start_recorder_img);
        this.eTk = (TextView) this.mRootView.findViewById(R.id.entrance_follow_desc);
        this.eTn = (TextView) this.mRootView.findViewById(R.id.entrance_ranklist_desc);
        this.eTq = (TextView) this.mRootView.findViewById(R.id.entrance_discuss_desc);
        this.eTt = (TextView) this.mRootView.findViewById(R.id.entrance_person_center_desc);
        this.eTw = (TextView) this.mRootView.findViewById(R.id.entrance_start_recorder_desc);
        this.eTx = (ImageView) this.mRootView.findViewById(R.id.entrance_publish_live_red);
        this.eTh.setOnClickListener(this);
        this.eTl.setOnClickListener(this);
        this.eTo.setOnClickListener(this);
        this.eTr.setOnClickListener(this);
        this.eTu.setOnClickListener(this);
        this.mRotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation.setDuration(6000L);
        this.mRotateAnimation.setRepeatMode(1);
        this.mRotateAnimation.setRepeatCount(-1);
        this.mRotateAnimation.setInterpolator(new LinearInterpolator());
        this.eTA = ObjectAnimator.ofPropertyValuesHolder(this.eTi, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f));
        this.eTA.setInterpolator(new DecelerateInterpolator());
        this.eTA.setTarget(this.eTi);
        this.eTA.setRepeatCount(-1);
        this.eTA.setRepeatMode(1);
        this.eTA.setDuration(2000L);
        this.eTA.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.1
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
                g.this.blP();
            }
        });
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        am.setViewTextColor(this.eTk, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setViewTextColor(this.eTn, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setViewTextColor(this.eTq, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setViewTextColor(this.eTt, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setViewTextColor(this.eTw, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setImageResource(this.eTm, R.drawable.super_entrance_ranklist_bg_selector);
        am.setImageResource(this.eTp, R.drawable.super_entrance_discuss_bg_selector);
        am.setImageResource(this.eTs, R.drawable.super_entrance_person_bg_selector);
        am.setImageResource(this.eTv, R.drawable.super_entrance_start_recorder_bg_selector);
        am.setImageResource(this.eTz, R.drawable.pic_live_tab_quan);
        if (8 == this.eTy.getVisibility()) {
            this.eTj.setVisibility(0);
            this.eTz.setVisibility(8);
            am.setBackgroundResource(this.eTj, R.drawable.super_entrance_follow_bg_selector);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_live_super_enreances_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.i iVar) {
        if (iVar == null || iVar.eQc == null) {
            stopAnim();
            return;
        }
        TiebaStatic.log("c13550");
        TiebaStatic.log("c13549");
        TiebaStatic.log("c13547");
        TiebaStatic.log("c13546");
        this.eTD = iVar.eQc.ePZ;
        if (!iVar.eQc.ePX || v.isEmpty(iVar.eQc.ePY)) {
            stopAnim();
            return;
        }
        this.eTC = iVar.eQc.ePY;
        if (!v.isEmpty(this.eTC)) {
            startAnim();
            blP();
        }
    }

    public void jc(boolean z) {
        if (this.eTx != null) {
            if (z) {
                if (!com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), false)) {
                    com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), true);
                    this.eTx.setVisibility(0);
                    return;
                }
                this.eTx.setVisibility(8);
                return;
            }
            this.eTx.setVisibility(8);
        }
    }

    private void startAnim() {
        this.eTj.setVisibility(8);
        this.eTy.setVisibility(0);
        this.eTz.setVisibility(0);
        this.eTi.setVisibility(0);
        this.eTy.clearAnimation();
        if (this.mRotateAnimation != null) {
            this.eTy.startAnimation(this.mRotateAnimation);
        }
        if (this.eTA != null) {
            if (this.eTA.isRunning()) {
                this.eTA.cancel();
            }
            this.eTA.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blP() {
        if (this.eTi != null && !v.isEmpty(this.eTC)) {
            this.eTB++;
            if (this.eTC.size() > this.eTB) {
                this.eTi.startLoad(this.eTC.get(this.eTB).portrait, 12, false);
            } else if (this.eTC.size() > 0) {
                this.eTB = 0;
                this.eTi.startLoad(this.eTC.get(this.eTB).portrait, 12, false);
            }
        }
    }

    private void stopAnim() {
        this.eTy.setVisibility(8);
        this.eTz.setVisibility(8);
        this.eTi.setVisibility(8);
        this.eTy.clearAnimation();
        if (this.eTA != null) {
            this.eTA.cancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eTh) {
            if (bc.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTabMyConcernActivityConfig(getTbPageContext().getPageActivity())));
            }
            TiebaStatic.log("c13552");
        } else if (view == this.eTl) {
            if (!StringUtils.isNull(this.eTD)) {
                com.baidu.tbadk.browser.a.startWebActivity(this.mContext.getApplicationContext(), getContext().getResources().getString(R.string.entrance_ranklist_tip), this.eTD, true, true, true, true, true, true, true);
                TiebaStatic.log("c13553");
            }
        } else if (view == this.eTo) {
            String string = com.baidu.tbadk.core.sharedPref.b.aNT().getString("show_live_forum_url", "http://tieba.baidu.com/f?kw=百度直播");
            string = (StringUtils.isNull(string) || !string.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) ? "http://tieba.baidu.com/f?kw=百度直播" : "http://tieba.baidu.com/f?kw=百度直播";
            if (!string.contains("?")) {
                string = string + "?default_tab_id=1&call_from=15";
            } else if (!string.contains("&default_tab_id=")) {
                string = string + "&default_tab_id=1&call_from=15";
            }
            ba.aOV().a(this.mTbPageContext, new String[]{string}, true);
            TiebaStatic.log("c13554");
        } else if (view == this.eTr) {
            if (bc.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(this.mTbPageContext.getPageActivity(), String.valueOf(TbadkCoreApplication.getCurrentAccountId()), TbadkCoreApplication.getCurrentAccountName(), TbadkCoreApplication.getCurrentPortrait(), TbadkCoreApplication.getCurrentAccountInfo().getSex(), true)));
            }
            TiebaStatic.log("c13555");
        } else if (view == this.eTu) {
            blQ();
            TiebaStatic.log("c13617");
        }
    }

    private void blQ() {
        Plugin plugin2;
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getTbPageContext().getPageActivity());
            aVar.setAutoNight(false);
            aVar.kc(R.string.prompt);
            aVar.ui(getContext().getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(getTbPageContext()).aMS();
        } else if (bc.checkUpIsLogin(getTbPageContext().getPageActivity())) {
            if (this.eTE == null) {
                this.eTE = new com.baidu.tieba.ueg.d(getTbPageContext());
            }
            if (!this.eTE.cZW()) {
                if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                    com.baidu.adp.lib.util.l.showToast(getTbPageContext().getPageActivity(), (int) R.string.plugin_config_not_found);
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), true);
                this.eTx.setVisibility(8);
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
            permissionJudgePolicy.a(new PermissionJudgePolicy.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.3
                @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.a
                public void onPermissionsGranted() {
                    MessageManager.getInstance().sendMessage(new HttpMessage(1003303));
                    com.baidu.adp.lib.c.a.ko().getAddress(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaMasterLiveRoomActivityConfig(tbPageContext.getPageActivity(), null, "0", TbadkCoreApplication.getCurrentAccount(), null)));
                }
            });
            permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        super.onDestroy();
        stopAnim();
    }
}
