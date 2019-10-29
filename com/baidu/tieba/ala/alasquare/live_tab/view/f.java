package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.atomdata.AlaLiveTabMyConcernActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaPersonCenterActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.b.f;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpHost;
/* loaded from: classes6.dex */
public class f extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.live_tab.b.g> {
    private ImageView dAa;
    private ImageView dAb;
    private RotateAnimation dAc;
    private ObjectAnimator dAd;
    private int dAe;
    private List<f.a> dAf;
    private String dAg;
    private LinearLayout dzN;
    private HeadImageView dzO;
    private ImageView dzP;
    private TextView dzQ;
    private LinearLayout dzR;
    private ImageView dzS;
    private TextView dzT;
    private LinearLayout dzU;
    private ImageView dzV;
    private TextView dzW;
    private LinearLayout dzX;
    private ImageView dzY;
    private TextView dzZ;
    private View mRootView;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dAe = -1;
        this.dAf = new ArrayList();
        initView();
    }

    public f(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.dAe = -1;
        this.dAf = new ArrayList();
        initView();
    }

    private void initView() {
        this.mRootView = getView();
        this.dzN = (LinearLayout) this.mRootView.findViewById(R.id.entrance_follow);
        this.dzR = (LinearLayout) this.mRootView.findViewById(R.id.entrance_ranklist);
        this.dzU = (LinearLayout) this.mRootView.findViewById(R.id.entrance_discuss);
        this.dzX = (LinearLayout) this.mRootView.findViewById(R.id.entrance_person_center);
        this.dAa = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_img_diandian);
        this.dzO = (HeadImageView) this.mRootView.findViewById(R.id.entrance_follow_img);
        this.dzO.setIsRound(true);
        this.dzO.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dzO.setDefaultResource(17170445);
        this.dzO.setDefaultBgResource(17170445);
        this.dAb = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_circle);
        this.dzP = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_default_img);
        this.dzS = (ImageView) this.mRootView.findViewById(R.id.entrance_ranklist_img);
        this.dzV = (ImageView) this.mRootView.findViewById(R.id.entrance_discuss_img);
        this.dzY = (ImageView) this.mRootView.findViewById(R.id.entrance_person_center_img);
        this.dzQ = (TextView) this.mRootView.findViewById(R.id.entrance_follow_desc);
        this.dzT = (TextView) this.mRootView.findViewById(R.id.entrance_ranklist_desc);
        this.dzW = (TextView) this.mRootView.findViewById(R.id.entrance_discuss_desc);
        this.dzZ = (TextView) this.mRootView.findViewById(R.id.entrance_person_center_desc);
        this.dzN.setOnClickListener(this);
        this.dzR.setOnClickListener(this);
        this.dzU.setOnClickListener(this);
        this.dzX.setOnClickListener(this);
        this.dAc = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.dAc.setDuration(6000L);
        this.dAc.setRepeatMode(1);
        this.dAc.setRepeatCount(-1);
        this.dAc.setInterpolator(new LinearInterpolator());
        this.dAd = ObjectAnimator.ofPropertyValuesHolder(this.dzO, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f));
        this.dAd.setInterpolator(new DecelerateInterpolator());
        this.dAd.setTarget(this.dzO);
        this.dAd.setRepeatCount(-1);
        this.dAd.setRepeatMode(1);
        this.dAd.setDuration(2000L);
        this.dAd.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.f.1
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
                f.this.aJM();
            }
        });
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        am.setViewTextColor(this.dzQ, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setViewTextColor(this.dzT, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setViewTextColor(this.dzW, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setViewTextColor(this.dzZ, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setImageResource(this.dzS, R.drawable.super_entrance_ranklist_bg_selector);
        am.setImageResource(this.dzV, R.drawable.super_entrance_discuss_bg_selector);
        am.setImageResource(this.dzY, R.drawable.super_entrance_person_bg_selector);
        am.setImageResource(this.dAb, R.drawable.pic_live_tab_quan);
        if (8 == this.dAa.getVisibility()) {
            this.dzP.setVisibility(0);
            this.dAb.setVisibility(8);
            am.setBackgroundResource(this.dzP, R.drawable.super_entrance_follow_bg_selector);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_live_super_enreances_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.g gVar) {
        if (gVar == null || gVar.dxp == null) {
            stopAnim();
            return;
        }
        this.dAg = gVar.dxp.dxm;
        TiebaStatic.log("c13550");
        TiebaStatic.log("c13549");
        TiebaStatic.log("c13547");
        TiebaStatic.log("c13546");
        if (!gVar.dxp.dxk || v.isEmpty(gVar.dxp.dxl)) {
            stopAnim();
            return;
        }
        this.dAf = gVar.dxp.dxl;
        if (!v.isEmpty(this.dAf)) {
            startAnim();
            aJM();
        }
    }

    private void startAnim() {
        this.dzP.setVisibility(8);
        this.dAa.setVisibility(0);
        this.dAb.setVisibility(0);
        this.dzO.setVisibility(0);
        this.dAa.clearAnimation();
        if (this.dAc != null) {
            this.dAa.startAnimation(this.dAc);
        }
        if (this.dAd != null) {
            if (this.dAd.isRunning()) {
                this.dAd.cancel();
            }
            this.dAd.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJM() {
        if (this.dzO != null && !v.isEmpty(this.dAf)) {
            this.dAe++;
            if (this.dAf.size() > this.dAe) {
                this.dzO.startLoad(this.dAf.get(this.dAe).portrait, 12, false);
            } else if (this.dAf.size() > 0) {
                this.dAe = 0;
                this.dzO.startLoad(this.dAf.get(this.dAe).portrait, 12, false);
            }
        }
    }

    private void stopAnim() {
        this.dAa.setVisibility(8);
        this.dAb.setVisibility(8);
        this.dzO.setVisibility(8);
        this.dAa.clearAnimation();
        if (this.dAd != null) {
            this.dAd.cancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dzN) {
            if (bc.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTabMyConcernActivityConfig(getTbPageContext().getPageActivity())));
            }
            TiebaStatic.log("c13552");
        } else if (view == this.dzR) {
            if (!StringUtils.isNull(this.dAg)) {
                com.baidu.tbadk.browser.a.startWebActivity(this.mContext.getApplicationContext(), getContext().getResources().getString(R.string.entrance_ranklist_tip), this.dAg, true, true, true, true, true, true, true);
                TiebaStatic.log("c13553");
            }
        } else if (view == this.dzU) {
            String string = com.baidu.tbadk.core.sharedPref.b.alR().getString("show_live_forum_url", "http://tieba.baidu.com/f?kw=百度直播");
            string = (StringUtils.isNull(string) || !string.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) ? "http://tieba.baidu.com/f?kw=百度直播" : "http://tieba.baidu.com/f?kw=百度直播";
            if (!string.contains("?")) {
                string = string + "?default_tab_id=1&call_from=15";
            } else if (!string.contains("&default_tab_id=")) {
                string = string + "&default_tab_id=1&call_from=15";
            }
            ba.amQ().a(this.mTbPageContext, new String[]{string}, true);
            TiebaStatic.log("c13554");
        } else if (view == this.dzX) {
            if (bc.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(this.mTbPageContext.getPageActivity(), String.valueOf(TbadkCoreApplication.getCurrentAccountId()), TbadkCoreApplication.getCurrentAccountName(), TbadkCoreApplication.getCurrentPortrait(), TbadkCoreApplication.getCurrentAccountInfo().getSex(), true)));
            }
            TiebaStatic.log("c13555");
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        super.onDestroy();
        stopAnim();
    }
}
