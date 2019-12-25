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
/* loaded from: classes2.dex */
public class f extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.live_tab.b.g> {
    private LinearLayout ejY;
    private HeadImageView ejZ;
    private ImageView eka;
    private TextView ekb;
    private LinearLayout ekc;
    private ImageView ekd;
    private TextView eke;
    private LinearLayout ekf;
    private ImageView ekg;
    private TextView ekh;
    private LinearLayout eki;
    private ImageView ekj;
    private TextView ekk;
    private ImageView ekl;
    private ImageView ekm;
    private ObjectAnimator ekn;
    private int eko;
    private List<f.a> ekp;
    private String ekq;
    private View mRootView;
    private RotateAnimation mRotateAnimation;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eko = -1;
        this.ekp = new ArrayList();
        initView();
    }

    public f(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.eko = -1;
        this.ekp = new ArrayList();
        initView();
    }

    private void initView() {
        this.mRootView = getView();
        this.ejY = (LinearLayout) this.mRootView.findViewById(R.id.entrance_follow);
        this.ekc = (LinearLayout) this.mRootView.findViewById(R.id.entrance_ranklist);
        this.ekf = (LinearLayout) this.mRootView.findViewById(R.id.entrance_discuss);
        this.eki = (LinearLayout) this.mRootView.findViewById(R.id.entrance_person_center);
        this.ekl = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_img_diandian);
        this.ejZ = (HeadImageView) this.mRootView.findViewById(R.id.entrance_follow_img);
        this.ejZ.setIsRound(true);
        this.ejZ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ejZ.setDefaultResource(17170445);
        this.ejZ.setDefaultBgResource(17170445);
        this.ekm = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_circle);
        this.eka = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_default_img);
        this.ekd = (ImageView) this.mRootView.findViewById(R.id.entrance_ranklist_img);
        this.ekg = (ImageView) this.mRootView.findViewById(R.id.entrance_discuss_img);
        this.ekj = (ImageView) this.mRootView.findViewById(R.id.entrance_person_center_img);
        this.ekb = (TextView) this.mRootView.findViewById(R.id.entrance_follow_desc);
        this.eke = (TextView) this.mRootView.findViewById(R.id.entrance_ranklist_desc);
        this.ekh = (TextView) this.mRootView.findViewById(R.id.entrance_discuss_desc);
        this.ekk = (TextView) this.mRootView.findViewById(R.id.entrance_person_center_desc);
        this.ejY.setOnClickListener(this);
        this.ekc.setOnClickListener(this);
        this.ekf.setOnClickListener(this);
        this.eki.setOnClickListener(this);
        this.mRotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation.setDuration(6000L);
        this.mRotateAnimation.setRepeatMode(1);
        this.mRotateAnimation.setRepeatCount(-1);
        this.mRotateAnimation.setInterpolator(new LinearInterpolator());
        this.ekn = ObjectAnimator.ofPropertyValuesHolder(this.ejZ, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f));
        this.ekn.setInterpolator(new DecelerateInterpolator());
        this.ekn.setTarget(this.ejZ);
        this.ekn.setRepeatCount(-1);
        this.ekn.setRepeatMode(1);
        this.ekn.setDuration(2000L);
        this.ekn.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.f.1
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
                f.this.baj();
            }
        });
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        am.setViewTextColor(this.ekb, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setViewTextColor(this.eke, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setViewTextColor(this.ekh, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setViewTextColor(this.ekk, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setImageResource(this.ekd, R.drawable.super_entrance_ranklist_bg_selector);
        am.setImageResource(this.ekg, R.drawable.super_entrance_discuss_bg_selector);
        am.setImageResource(this.ekj, R.drawable.super_entrance_person_bg_selector);
        am.setImageResource(this.ekm, R.drawable.pic_live_tab_quan);
        if (8 == this.ekl.getVisibility()) {
            this.eka.setVisibility(0);
            this.ekm.setVisibility(8);
            am.setBackgroundResource(this.eka, R.drawable.super_entrance_follow_bg_selector);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_live_super_enreances_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.g gVar) {
        if (gVar == null || gVar.ehA == null) {
            stopAnim();
            return;
        }
        TiebaStatic.log("c13550");
        TiebaStatic.log("c13549");
        TiebaStatic.log("c13547");
        TiebaStatic.log("c13546");
        this.ekq = gVar.ehA.ehx;
        if (!gVar.ehA.ehv || v.isEmpty(gVar.ehA.ehw)) {
            stopAnim();
            return;
        }
        this.ekp = gVar.ehA.ehw;
        if (!v.isEmpty(this.ekp)) {
            startAnim();
            baj();
        }
    }

    private void startAnim() {
        this.eka.setVisibility(8);
        this.ekl.setVisibility(0);
        this.ekm.setVisibility(0);
        this.ejZ.setVisibility(0);
        this.ekl.clearAnimation();
        if (this.mRotateAnimation != null) {
            this.ekl.startAnimation(this.mRotateAnimation);
        }
        if (this.ekn != null) {
            if (this.ekn.isRunning()) {
                this.ekn.cancel();
            }
            this.ekn.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baj() {
        if (this.ejZ != null && !v.isEmpty(this.ekp)) {
            this.eko++;
            if (this.ekp.size() > this.eko) {
                this.ejZ.startLoad(this.ekp.get(this.eko).portrait, 12, false);
            } else if (this.ekp.size() > 0) {
                this.eko = 0;
                this.ejZ.startLoad(this.ekp.get(this.eko).portrait, 12, false);
            }
        }
    }

    private void stopAnim() {
        this.ekl.setVisibility(8);
        this.ekm.setVisibility(8);
        this.ejZ.setVisibility(8);
        this.ekl.clearAnimation();
        if (this.ekn != null) {
            this.ekn.cancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ejY) {
            if (bc.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTabMyConcernActivityConfig(getTbPageContext().getPageActivity())));
            }
            TiebaStatic.log("c13552");
        } else if (view == this.ekc) {
            if (!StringUtils.isNull(this.ekq)) {
                com.baidu.tbadk.browser.a.startWebActivity(this.mContext.getApplicationContext(), getContext().getResources().getString(R.string.entrance_ranklist_tip), this.ekq, true, true, true, true, true, true, true);
                TiebaStatic.log("c13553");
            }
        } else if (view == this.ekf) {
            String string = com.baidu.tbadk.core.sharedPref.b.aCY().getString("show_live_forum_url", "http://tieba.baidu.com/f?kw=百度直播");
            string = (StringUtils.isNull(string) || !string.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) ? "http://tieba.baidu.com/f?kw=百度直播" : "http://tieba.baidu.com/f?kw=百度直播";
            if (!string.contains("?")) {
                string = string + "?default_tab_id=1&call_from=15";
            } else if (!string.contains("&default_tab_id=")) {
                string = string + "&default_tab_id=1&call_from=15";
            }
            ba.aEa().a(this.mTbPageContext, new String[]{string}, true);
            TiebaStatic.log("c13554");
        } else if (view == this.eki) {
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
