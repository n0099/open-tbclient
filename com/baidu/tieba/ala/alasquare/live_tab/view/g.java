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
/* loaded from: classes4.dex */
public class g extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.b.i> {
    private LinearLayout gmX;
    private HeadImageView gmY;
    private ImageView gmZ;
    private TextView gna;
    private LinearLayout gnb;
    private ImageView gnc;
    private TextView gnd;
    private LinearLayout gne;
    private ImageView gnf;
    private TextView gng;
    private LinearLayout gnh;
    private ImageView gni;
    private TextView gnj;
    private LinearLayout gnk;
    private ImageView gnl;
    private TextView gnm;
    private ImageView gnn;
    private ImageView gno;
    private ImageView gnp;
    private ObjectAnimator gnq;
    private int gnr;
    private List<h.a> gns;
    private String gnt;
    private com.baidu.tieba.ueg.d gnu;
    private View mRootView;
    private RotateAnimation mRotateAnimation;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gnr = -1;
        this.gns = new ArrayList();
        initView();
    }

    private void initView() {
        this.mRootView = getView();
        this.gmX = (LinearLayout) this.mRootView.findViewById(R.id.entrance_follow);
        this.gnb = (LinearLayout) this.mRootView.findViewById(R.id.entrance_ranklist);
        this.gne = (LinearLayout) this.mRootView.findViewById(R.id.entrance_discuss);
        this.gnh = (LinearLayout) this.mRootView.findViewById(R.id.entrance_person_center);
        this.gno = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_img_diandian);
        this.gnk = (LinearLayout) this.mRootView.findViewById(R.id.entrance_start_recorder);
        this.gmY = (HeadImageView) this.mRootView.findViewById(R.id.entrance_follow_img);
        this.gmY.setIsRound(true);
        this.gmY.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gmY.setDefaultResource(17170445);
        this.gmY.setDefaultBgResource(17170445);
        this.gnp = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_circle);
        this.gmZ = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_default_img);
        this.gnc = (ImageView) this.mRootView.findViewById(R.id.entrance_ranklist_img);
        this.gnf = (ImageView) this.mRootView.findViewById(R.id.entrance_discuss_img);
        this.gni = (ImageView) this.mRootView.findViewById(R.id.entrance_person_center_img);
        this.gnl = (ImageView) this.mRootView.findViewById(R.id.entrance_start_recorder_img);
        this.gna = (TextView) this.mRootView.findViewById(R.id.entrance_follow_desc);
        this.gnd = (TextView) this.mRootView.findViewById(R.id.entrance_ranklist_desc);
        this.gng = (TextView) this.mRootView.findViewById(R.id.entrance_discuss_desc);
        this.gnj = (TextView) this.mRootView.findViewById(R.id.entrance_person_center_desc);
        this.gnm = (TextView) this.mRootView.findViewById(R.id.entrance_start_recorder_desc);
        this.gnn = (ImageView) this.mRootView.findViewById(R.id.entrance_publish_live_red);
        this.gmX.setOnClickListener(this);
        this.gnb.setOnClickListener(this);
        this.gne.setOnClickListener(this);
        this.gnh.setOnClickListener(this);
        this.gnk.setOnClickListener(this);
        this.mRotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation.setDuration(6000L);
        this.mRotateAnimation.setRepeatMode(1);
        this.mRotateAnimation.setRepeatCount(-1);
        this.mRotateAnimation.setInterpolator(new LinearInterpolator());
        this.gnq = ObjectAnimator.ofPropertyValuesHolder(this.gmY, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f));
        this.gnq.setInterpolator(new DecelerateInterpolator());
        this.gnq.setTarget(this.gmY);
        this.gnq.setRepeatCount(-1);
        this.gnq.setRepeatMode(1);
        this.gnq.setDuration(2000L);
        this.gnq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.1
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
                g.this.bOS();
            }
        });
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        ap.setViewTextColor(this.gna, R.drawable.tab_super_entrance_txt_selecor);
        ap.setViewTextColor(this.gnd, R.drawable.tab_super_entrance_txt_selecor);
        ap.setViewTextColor(this.gng, R.drawable.tab_super_entrance_txt_selecor);
        ap.setViewTextColor(this.gnj, R.drawable.tab_super_entrance_txt_selecor);
        ap.setViewTextColor(this.gnm, R.drawable.tab_super_entrance_txt_selecor);
        ap.setImageResource(this.gnc, R.drawable.super_entrance_ranklist_bg_selector);
        ap.setImageResource(this.gnf, R.drawable.super_entrance_discuss_bg_selector);
        ap.setImageResource(this.gni, R.drawable.super_entrance_person_bg_selector);
        ap.setImageResource(this.gnl, R.drawable.super_entrance_start_recorder_bg_selector);
        ap.setImageResource(this.gnp, R.drawable.pic_live_tab_quan);
        if (8 == this.gno.getVisibility()) {
            this.gmZ.setVisibility(0);
            this.gnp.setVisibility(8);
            ap.setBackgroundResource(this.gmZ, R.drawable.super_entrance_follow_bg_selector);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_live_super_enreances_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.i iVar) {
        if (iVar == null || iVar.gjJ == null) {
            stopAnim();
            return;
        }
        TiebaStatic.log("c13550");
        TiebaStatic.log("c13549");
        TiebaStatic.log("c13547");
        TiebaStatic.log("c13546");
        this.gnt = iVar.gjJ.gjG;
        if (!iVar.gjJ.gjE || y.isEmpty(iVar.gjJ.gjF)) {
            stopAnim();
            return;
        }
        this.gns = iVar.gjJ.gjF;
        if (!y.isEmpty(this.gns)) {
            startAnim();
            bOS();
        }
    }

    public void lN(boolean z) {
        if (this.gnn != null) {
            if (z) {
                if (!com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), false)) {
                    com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), true);
                    this.gnn.setVisibility(0);
                    return;
                }
                this.gnn.setVisibility(8);
                return;
            }
            this.gnn.setVisibility(8);
        }
    }

    private void startAnim() {
        this.gmZ.setVisibility(8);
        this.gno.setVisibility(0);
        this.gnp.setVisibility(0);
        this.gmY.setVisibility(0);
        this.gno.clearAnimation();
        if (this.mRotateAnimation != null) {
            this.gno.startAnimation(this.mRotateAnimation);
        }
        if (this.gnq != null) {
            if (this.gnq.isRunning()) {
                this.gnq.cancel();
            }
            this.gnq.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOS() {
        if (this.gmY != null && !y.isEmpty(this.gns)) {
            this.gnr++;
            if (this.gns.size() > this.gnr) {
                this.gmY.startLoad(this.gns.get(this.gnr).portrait, 12, false);
            } else if (this.gns.size() > 0) {
                this.gnr = 0;
                this.gmY.startLoad(this.gns.get(this.gnr).portrait, 12, false);
            }
        }
    }

    private void stopAnim() {
        this.gno.setVisibility(8);
        this.gnp.setVisibility(8);
        this.gmY.setVisibility(8);
        this.gno.clearAnimation();
        if (this.gnq != null) {
            this.gnq.cancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gmX) {
            if (bh.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTabMyConcernActivityConfig(getTbPageContext().getPageActivity())));
            }
            TiebaStatic.log("c13552");
        } else if (view == this.gnb) {
            if (!StringUtils.isNull(this.gnt)) {
                com.baidu.tbadk.browser.a.startWebActivity(this.mContext.getApplicationContext(), getContext().getResources().getString(R.string.entrance_ranklist_tip), this.gnt, true, true, true, true, true, true, true);
                TiebaStatic.log("c13553");
            }
        } else if (view == this.gne) {
            String string = com.baidu.tbadk.core.sharedPref.b.bpu().getString("show_live_forum_url", "http://tieba.baidu.com/f?kw=百度直播");
            string = (StringUtils.isNull(string) || !string.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) ? "http://tieba.baidu.com/f?kw=百度直播" : "http://tieba.baidu.com/f?kw=百度直播";
            if (!string.contains("?")) {
                string = string + "?default_tab_id=1&call_from=15";
            } else if (!string.contains("&default_tab_id=")) {
                string = string + "&default_tab_id=1&call_from=15";
            }
            bf.bqF().a(this.mTbPageContext, new String[]{string}, true);
            TiebaStatic.log("c13554");
        } else if (view == this.gnh) {
            if (bh.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(this.mTbPageContext.getPageActivity(), String.valueOf(TbadkCoreApplication.getCurrentAccountId()), TbadkCoreApplication.getCurrentAccountName(), TbadkCoreApplication.getCurrentPortrait(), TbadkCoreApplication.getCurrentAccountInfo().getSex(), true)));
            }
            TiebaStatic.log("c13555");
        } else if (view == this.gnk) {
            bOT();
            TiebaStatic.log("c13617");
        }
    }

    private void bOT() {
        Plugin plugin2;
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getTbPageContext().getPageActivity());
            aVar.setAutoNight(false);
            aVar.or(R.string.prompt);
            aVar.AJ(getContext().getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(getTbPageContext()).bog();
        } else if (bh.checkUpIsLogin(getTbPageContext().getPageActivity())) {
            if (this.gnu == null) {
                this.gnu = new com.baidu.tieba.ueg.d(getTbPageContext());
            }
            if (!this.gnu.dNO()) {
                if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                    com.baidu.adp.lib.util.l.showToast(getTbPageContext().getPageActivity(), R.string.plugin_config_not_found);
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), true);
                this.gnn.setVisibility(8);
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
