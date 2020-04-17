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
    private LinearLayout eTc;
    private HeadImageView eTd;
    private ImageView eTe;
    private TextView eTf;
    private LinearLayout eTg;
    private ImageView eTh;
    private TextView eTi;
    private LinearLayout eTj;
    private ImageView eTk;
    private TextView eTl;
    private LinearLayout eTm;
    private ImageView eTn;
    private TextView eTo;
    private LinearLayout eTp;
    private ImageView eTq;
    private TextView eTr;
    private ImageView eTs;
    private ImageView eTt;
    private ImageView eTu;
    private ObjectAnimator eTv;
    private int eTw;
    private List<h.a> eTx;
    private String eTy;
    private com.baidu.tieba.ueg.d eTz;
    private View mRootView;
    private RotateAnimation mRotateAnimation;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eTw = -1;
        this.eTx = new ArrayList();
        initView();
    }

    private void initView() {
        this.mRootView = getView();
        this.eTc = (LinearLayout) this.mRootView.findViewById(R.id.entrance_follow);
        this.eTg = (LinearLayout) this.mRootView.findViewById(R.id.entrance_ranklist);
        this.eTj = (LinearLayout) this.mRootView.findViewById(R.id.entrance_discuss);
        this.eTm = (LinearLayout) this.mRootView.findViewById(R.id.entrance_person_center);
        this.eTt = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_img_diandian);
        this.eTp = (LinearLayout) this.mRootView.findViewById(R.id.entrance_start_recorder);
        this.eTd = (HeadImageView) this.mRootView.findViewById(R.id.entrance_follow_img);
        this.eTd.setIsRound(true);
        this.eTd.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eTd.setDefaultResource(17170445);
        this.eTd.setDefaultBgResource(17170445);
        this.eTu = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_circle);
        this.eTe = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_default_img);
        this.eTh = (ImageView) this.mRootView.findViewById(R.id.entrance_ranklist_img);
        this.eTk = (ImageView) this.mRootView.findViewById(R.id.entrance_discuss_img);
        this.eTn = (ImageView) this.mRootView.findViewById(R.id.entrance_person_center_img);
        this.eTq = (ImageView) this.mRootView.findViewById(R.id.entrance_start_recorder_img);
        this.eTf = (TextView) this.mRootView.findViewById(R.id.entrance_follow_desc);
        this.eTi = (TextView) this.mRootView.findViewById(R.id.entrance_ranklist_desc);
        this.eTl = (TextView) this.mRootView.findViewById(R.id.entrance_discuss_desc);
        this.eTo = (TextView) this.mRootView.findViewById(R.id.entrance_person_center_desc);
        this.eTr = (TextView) this.mRootView.findViewById(R.id.entrance_start_recorder_desc);
        this.eTs = (ImageView) this.mRootView.findViewById(R.id.entrance_publish_live_red);
        this.eTc.setOnClickListener(this);
        this.eTg.setOnClickListener(this);
        this.eTj.setOnClickListener(this);
        this.eTm.setOnClickListener(this);
        this.eTp.setOnClickListener(this);
        this.mRotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation.setDuration(6000L);
        this.mRotateAnimation.setRepeatMode(1);
        this.mRotateAnimation.setRepeatCount(-1);
        this.mRotateAnimation.setInterpolator(new LinearInterpolator());
        this.eTv = ObjectAnimator.ofPropertyValuesHolder(this.eTd, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f));
        this.eTv.setInterpolator(new DecelerateInterpolator());
        this.eTv.setTarget(this.eTd);
        this.eTv.setRepeatCount(-1);
        this.eTv.setRepeatMode(1);
        this.eTv.setDuration(2000L);
        this.eTv.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.1
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
                g.this.blR();
            }
        });
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        am.setViewTextColor(this.eTf, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setViewTextColor(this.eTi, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setViewTextColor(this.eTl, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setViewTextColor(this.eTo, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setViewTextColor(this.eTr, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setImageResource(this.eTh, R.drawable.super_entrance_ranklist_bg_selector);
        am.setImageResource(this.eTk, R.drawable.super_entrance_discuss_bg_selector);
        am.setImageResource(this.eTn, R.drawable.super_entrance_person_bg_selector);
        am.setImageResource(this.eTq, R.drawable.super_entrance_start_recorder_bg_selector);
        am.setImageResource(this.eTu, R.drawable.pic_live_tab_quan);
        if (8 == this.eTt.getVisibility()) {
            this.eTe.setVisibility(0);
            this.eTu.setVisibility(8);
            am.setBackgroundResource(this.eTe, R.drawable.super_entrance_follow_bg_selector);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_live_super_enreances_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.i iVar) {
        if (iVar == null || iVar.ePX == null) {
            stopAnim();
            return;
        }
        TiebaStatic.log("c13550");
        TiebaStatic.log("c13549");
        TiebaStatic.log("c13547");
        TiebaStatic.log("c13546");
        this.eTy = iVar.ePX.ePU;
        if (!iVar.ePX.ePS || v.isEmpty(iVar.ePX.ePT)) {
            stopAnim();
            return;
        }
        this.eTx = iVar.ePX.ePT;
        if (!v.isEmpty(this.eTx)) {
            startAnim();
            blR();
        }
    }

    public void jc(boolean z) {
        if (this.eTs != null) {
            if (z) {
                if (!com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), false)) {
                    com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), true);
                    this.eTs.setVisibility(0);
                    return;
                }
                this.eTs.setVisibility(8);
                return;
            }
            this.eTs.setVisibility(8);
        }
    }

    private void startAnim() {
        this.eTe.setVisibility(8);
        this.eTt.setVisibility(0);
        this.eTu.setVisibility(0);
        this.eTd.setVisibility(0);
        this.eTt.clearAnimation();
        if (this.mRotateAnimation != null) {
            this.eTt.startAnimation(this.mRotateAnimation);
        }
        if (this.eTv != null) {
            if (this.eTv.isRunning()) {
                this.eTv.cancel();
            }
            this.eTv.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blR() {
        if (this.eTd != null && !v.isEmpty(this.eTx)) {
            this.eTw++;
            if (this.eTx.size() > this.eTw) {
                this.eTd.startLoad(this.eTx.get(this.eTw).portrait, 12, false);
            } else if (this.eTx.size() > 0) {
                this.eTw = 0;
                this.eTd.startLoad(this.eTx.get(this.eTw).portrait, 12, false);
            }
        }
    }

    private void stopAnim() {
        this.eTt.setVisibility(8);
        this.eTu.setVisibility(8);
        this.eTd.setVisibility(8);
        this.eTt.clearAnimation();
        if (this.eTv != null) {
            this.eTv.cancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eTc) {
            if (bc.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTabMyConcernActivityConfig(getTbPageContext().getPageActivity())));
            }
            TiebaStatic.log("c13552");
        } else if (view == this.eTg) {
            if (!StringUtils.isNull(this.eTy)) {
                com.baidu.tbadk.browser.a.startWebActivity(this.mContext.getApplicationContext(), getContext().getResources().getString(R.string.entrance_ranklist_tip), this.eTy, true, true, true, true, true, true, true);
                TiebaStatic.log("c13553");
            }
        } else if (view == this.eTj) {
            String string = com.baidu.tbadk.core.sharedPref.b.aNV().getString("show_live_forum_url", "http://tieba.baidu.com/f?kw=百度直播");
            string = (StringUtils.isNull(string) || !string.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) ? "http://tieba.baidu.com/f?kw=百度直播" : "http://tieba.baidu.com/f?kw=百度直播";
            if (!string.contains("?")) {
                string = string + "?default_tab_id=1&call_from=15";
            } else if (!string.contains("&default_tab_id=")) {
                string = string + "&default_tab_id=1&call_from=15";
            }
            ba.aOY().a(this.mTbPageContext, new String[]{string}, true);
            TiebaStatic.log("c13554");
        } else if (view == this.eTm) {
            if (bc.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(this.mTbPageContext.getPageActivity(), String.valueOf(TbadkCoreApplication.getCurrentAccountId()), TbadkCoreApplication.getCurrentAccountName(), TbadkCoreApplication.getCurrentPortrait(), TbadkCoreApplication.getCurrentAccountInfo().getSex(), true)));
            }
            TiebaStatic.log("c13555");
        } else if (view == this.eTp) {
            blS();
            TiebaStatic.log("c13617");
        }
    }

    private void blS() {
        Plugin plugin2;
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getTbPageContext().getPageActivity());
            aVar.setAutoNight(false);
            aVar.kc(R.string.prompt);
            aVar.uf(getContext().getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(getTbPageContext()).aMU();
        } else if (bc.checkUpIsLogin(getTbPageContext().getPageActivity())) {
            if (this.eTz == null) {
                this.eTz = new com.baidu.tieba.ueg.d(getTbPageContext());
            }
            if (!this.eTz.cZY()) {
                if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                    com.baidu.adp.lib.util.l.showToast(getTbPageContext().getPageActivity(), (int) R.string.plugin_config_not_found);
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), true);
                this.eTs.setVisibility(8);
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
