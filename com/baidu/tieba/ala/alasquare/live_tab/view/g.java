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
    private LinearLayout gnA;
    private ImageView gnB;
    private TextView gnC;
    private LinearLayout gnD;
    private ImageView gnE;
    private TextView gnF;
    private ImageView gnG;
    private ImageView gnH;
    private ImageView gnI;
    private ObjectAnimator gnJ;
    private int gnK;
    private List<h.a> gnL;
    private String gnM;
    private com.baidu.tieba.ueg.d gnN;
    private LinearLayout gnq;
    private HeadImageView gnr;
    private ImageView gns;
    private TextView gnt;
    private LinearLayout gnu;
    private ImageView gnv;
    private TextView gnw;
    private LinearLayout gnx;
    private ImageView gny;
    private TextView gnz;
    private View mRootView;
    private RotateAnimation mRotateAnimation;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gnK = -1;
        this.gnL = new ArrayList();
        initView();
    }

    private void initView() {
        this.mRootView = getView();
        this.gnq = (LinearLayout) this.mRootView.findViewById(R.id.entrance_follow);
        this.gnu = (LinearLayout) this.mRootView.findViewById(R.id.entrance_ranklist);
        this.gnx = (LinearLayout) this.mRootView.findViewById(R.id.entrance_discuss);
        this.gnA = (LinearLayout) this.mRootView.findViewById(R.id.entrance_person_center);
        this.gnH = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_img_diandian);
        this.gnD = (LinearLayout) this.mRootView.findViewById(R.id.entrance_start_recorder);
        this.gnr = (HeadImageView) this.mRootView.findViewById(R.id.entrance_follow_img);
        this.gnr.setIsRound(true);
        this.gnr.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gnr.setDefaultResource(17170445);
        this.gnr.setDefaultBgResource(17170445);
        this.gnI = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_circle);
        this.gns = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_default_img);
        this.gnv = (ImageView) this.mRootView.findViewById(R.id.entrance_ranklist_img);
        this.gny = (ImageView) this.mRootView.findViewById(R.id.entrance_discuss_img);
        this.gnB = (ImageView) this.mRootView.findViewById(R.id.entrance_person_center_img);
        this.gnE = (ImageView) this.mRootView.findViewById(R.id.entrance_start_recorder_img);
        this.gnt = (TextView) this.mRootView.findViewById(R.id.entrance_follow_desc);
        this.gnw = (TextView) this.mRootView.findViewById(R.id.entrance_ranklist_desc);
        this.gnz = (TextView) this.mRootView.findViewById(R.id.entrance_discuss_desc);
        this.gnC = (TextView) this.mRootView.findViewById(R.id.entrance_person_center_desc);
        this.gnF = (TextView) this.mRootView.findViewById(R.id.entrance_start_recorder_desc);
        this.gnG = (ImageView) this.mRootView.findViewById(R.id.entrance_publish_live_red);
        this.gnq.setOnClickListener(this);
        this.gnu.setOnClickListener(this);
        this.gnx.setOnClickListener(this);
        this.gnA.setOnClickListener(this);
        this.gnD.setOnClickListener(this);
        this.mRotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation.setDuration(6000L);
        this.mRotateAnimation.setRepeatMode(1);
        this.mRotateAnimation.setRepeatCount(-1);
        this.mRotateAnimation.setInterpolator(new LinearInterpolator());
        this.gnJ = ObjectAnimator.ofPropertyValuesHolder(this.gnr, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f));
        this.gnJ.setInterpolator(new DecelerateInterpolator());
        this.gnJ.setTarget(this.gnr);
        this.gnJ.setRepeatCount(-1);
        this.gnJ.setRepeatMode(1);
        this.gnJ.setDuration(2000L);
        this.gnJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.1
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
                g.this.bPz();
            }
        });
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.gnt, (int) R.drawable.tab_super_entrance_txt_selecor);
        ap.setViewTextColor(this.gnw, (int) R.drawable.tab_super_entrance_txt_selecor);
        ap.setViewTextColor(this.gnz, (int) R.drawable.tab_super_entrance_txt_selecor);
        ap.setViewTextColor(this.gnC, (int) R.drawable.tab_super_entrance_txt_selecor);
        ap.setViewTextColor(this.gnF, (int) R.drawable.tab_super_entrance_txt_selecor);
        ap.setImageResource(this.gnv, R.drawable.super_entrance_ranklist_bg_selector);
        ap.setImageResource(this.gny, R.drawable.super_entrance_discuss_bg_selector);
        ap.setImageResource(this.gnB, R.drawable.super_entrance_person_bg_selector);
        ap.setImageResource(this.gnE, R.drawable.super_entrance_start_recorder_bg_selector);
        ap.setImageResource(this.gnI, R.drawable.pic_live_tab_quan);
        if (8 == this.gnH.getVisibility()) {
            this.gns.setVisibility(0);
            this.gnI.setVisibility(8);
            ap.setBackgroundResource(this.gns, R.drawable.super_entrance_follow_bg_selector);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_live_super_enreances_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.i iVar) {
        if (iVar == null || iVar.gkc == null) {
            stopAnim();
            return;
        }
        TiebaStatic.log("c13550");
        TiebaStatic.log("c13549");
        TiebaStatic.log("c13547");
        TiebaStatic.log("c13546");
        this.gnM = iVar.gkc.gjZ;
        if (!iVar.gkc.gjX || y.isEmpty(iVar.gkc.gjY)) {
            stopAnim();
            return;
        }
        this.gnL = iVar.gkc.gjY;
        if (!y.isEmpty(this.gnL)) {
            startAnim();
            bPz();
        }
    }

    public void lM(boolean z) {
        if (this.gnG != null) {
            if (z) {
                if (!com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), false)) {
                    com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), true);
                    this.gnG.setVisibility(0);
                    return;
                }
                this.gnG.setVisibility(8);
                return;
            }
            this.gnG.setVisibility(8);
        }
    }

    private void startAnim() {
        this.gns.setVisibility(8);
        this.gnH.setVisibility(0);
        this.gnI.setVisibility(0);
        this.gnr.setVisibility(0);
        this.gnH.clearAnimation();
        if (this.mRotateAnimation != null) {
            this.gnH.startAnimation(this.mRotateAnimation);
        }
        if (this.gnJ != null) {
            if (this.gnJ.isRunning()) {
                this.gnJ.cancel();
            }
            this.gnJ.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPz() {
        if (this.gnr != null && !y.isEmpty(this.gnL)) {
            this.gnK++;
            if (this.gnL.size() > this.gnK) {
                this.gnr.startLoad(this.gnL.get(this.gnK).portrait, 12, false);
            } else if (this.gnL.size() > 0) {
                this.gnK = 0;
                this.gnr.startLoad(this.gnL.get(this.gnK).portrait, 12, false);
            }
        }
    }

    private void stopAnim() {
        this.gnH.setVisibility(8);
        this.gnI.setVisibility(8);
        this.gnr.setVisibility(8);
        this.gnH.clearAnimation();
        if (this.gnJ != null) {
            this.gnJ.cancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gnq) {
            if (bg.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTabMyConcernActivityConfig(getTbPageContext().getPageActivity())));
            }
            TiebaStatic.log("c13552");
        } else if (view == this.gnu) {
            if (!StringUtils.isNull(this.gnM)) {
                com.baidu.tbadk.browser.a.startWebActivity(this.mContext.getApplicationContext(), getContext().getResources().getString(R.string.entrance_ranklist_tip), this.gnM, true, true, true, true, true, true, true);
                TiebaStatic.log("c13553");
            }
        } else if (view == this.gnx) {
            String string = com.baidu.tbadk.core.sharedPref.b.bqh().getString("show_live_forum_url", "http://tieba.baidu.com/f?kw=百度直播");
            string = (StringUtils.isNull(string) || !string.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) ? "http://tieba.baidu.com/f?kw=百度直播" : "http://tieba.baidu.com/f?kw=百度直播";
            if (!string.contains("?")) {
                string = string + "?default_tab_id=1&call_from=15";
            } else if (!string.contains("&default_tab_id=")) {
                string = string + "&default_tab_id=1&call_from=15";
            }
            be.brr().a(this.mTbPageContext, new String[]{string}, true);
            TiebaStatic.log("c13554");
        } else if (view == this.gnA) {
            if (bg.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(this.mTbPageContext.getPageActivity(), String.valueOf(TbadkCoreApplication.getCurrentAccountId()), TbadkCoreApplication.getCurrentAccountName(), TbadkCoreApplication.getCurrentPortrait(), TbadkCoreApplication.getCurrentAccountInfo().getSex(), true)));
            }
            TiebaStatic.log("c13555");
        } else if (view == this.gnD) {
            bPA();
            TiebaStatic.log("c13617");
        }
    }

    private void bPA() {
        Plugin plugin2;
        if (Build.VERSION.SDK_INT < 21) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getTbPageContext().getPageActivity());
            aVar.setAutoNight(false);
            aVar.ov(R.string.prompt);
            aVar.Bo(getContext().getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(getTbPageContext()).bpc();
        } else if (bg.checkUpIsLogin(getTbPageContext().getPageActivity())) {
            if (this.gnN == null) {
                this.gnN = new com.baidu.tieba.ueg.d(getTbPageContext());
            }
            if (!this.gnN.dNP()) {
                if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                    com.baidu.adp.lib.util.l.showToast(getTbPageContext().getPageActivity(), (int) R.string.plugin_config_not_found);
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("square_live_publish_live_has_showed"), true);
                this.gnG.setVisibility(8);
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
