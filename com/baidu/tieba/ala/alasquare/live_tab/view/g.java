package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
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
import com.baidu.tieba.ala.alasquare.live_tab.b.h;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpHost;
/* loaded from: classes3.dex */
public class g extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.live_tab.b.i> {
    private LinearLayout epa;
    private HeadImageView epb;
    private ImageView epc;
    private TextView epd;
    private LinearLayout epe;
    private ImageView epf;
    private TextView epg;
    private LinearLayout eph;
    private ImageView epi;
    private TextView epj;
    private LinearLayout epk;
    private ImageView epl;
    private TextView epm;
    private ImageView epn;
    private ImageView epo;
    private ObjectAnimator epp;
    private int epq;
    private List<h.a> epr;
    private String eps;
    private View mRootView;
    private RotateAnimation mRotateAnimation;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.epq = -1;
        this.epr = new ArrayList();
        initView();
    }

    private void initView() {
        this.mRootView = getView();
        this.epa = (LinearLayout) this.mRootView.findViewById(R.id.entrance_follow);
        this.epe = (LinearLayout) this.mRootView.findViewById(R.id.entrance_ranklist);
        this.eph = (LinearLayout) this.mRootView.findViewById(R.id.entrance_discuss);
        this.epk = (LinearLayout) this.mRootView.findViewById(R.id.entrance_person_center);
        this.epn = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_img_diandian);
        this.epb = (HeadImageView) this.mRootView.findViewById(R.id.entrance_follow_img);
        this.epb.setIsRound(true);
        this.epb.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.epb.setDefaultResource(17170445);
        this.epb.setDefaultBgResource(17170445);
        this.epo = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_circle);
        this.epc = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_default_img);
        this.epf = (ImageView) this.mRootView.findViewById(R.id.entrance_ranklist_img);
        this.epi = (ImageView) this.mRootView.findViewById(R.id.entrance_discuss_img);
        this.epl = (ImageView) this.mRootView.findViewById(R.id.entrance_person_center_img);
        this.epd = (TextView) this.mRootView.findViewById(R.id.entrance_follow_desc);
        this.epg = (TextView) this.mRootView.findViewById(R.id.entrance_ranklist_desc);
        this.epj = (TextView) this.mRootView.findViewById(R.id.entrance_discuss_desc);
        this.epm = (TextView) this.mRootView.findViewById(R.id.entrance_person_center_desc);
        this.epa.setOnClickListener(this);
        this.epe.setOnClickListener(this);
        this.eph.setOnClickListener(this);
        this.epk.setOnClickListener(this);
        this.mRotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation.setDuration(6000L);
        this.mRotateAnimation.setRepeatMode(1);
        this.mRotateAnimation.setRepeatCount(-1);
        this.mRotateAnimation.setInterpolator(new LinearInterpolator());
        this.epp = ObjectAnimator.ofPropertyValuesHolder(this.epb, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f));
        this.epp.setInterpolator(new DecelerateInterpolator());
        this.epp.setTarget(this.epb);
        this.epp.setRepeatCount(-1);
        this.epp.setRepeatMode(1);
        this.epp.setDuration(2000L);
        this.epp.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.1
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
                g.this.bcT();
            }
        });
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        am.setViewTextColor(this.epd, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setViewTextColor(this.epg, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setViewTextColor(this.epj, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setViewTextColor(this.epm, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setImageResource(this.epf, R.drawable.super_entrance_ranklist_bg_selector);
        am.setImageResource(this.epi, R.drawable.super_entrance_discuss_bg_selector);
        am.setImageResource(this.epl, R.drawable.super_entrance_person_bg_selector);
        am.setImageResource(this.epo, R.drawable.pic_live_tab_quan);
        if (8 == this.epn.getVisibility()) {
            this.epc.setVisibility(0);
            this.epo.setVisibility(8);
            am.setBackgroundResource(this.epc, R.drawable.super_entrance_follow_bg_selector);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_live_super_enreances_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.i iVar) {
        if (iVar == null || iVar.elS == null) {
            stopAnim();
            return;
        }
        TiebaStatic.log("c13550");
        TiebaStatic.log("c13549");
        TiebaStatic.log("c13547");
        TiebaStatic.log("c13546");
        this.eps = iVar.elS.elP;
        if (!iVar.elS.elN || v.isEmpty(iVar.elS.elO)) {
            stopAnim();
            return;
        }
        this.epr = iVar.elS.elO;
        if (!v.isEmpty(this.epr)) {
            startAnim();
            bcT();
        }
    }

    private void startAnim() {
        this.epc.setVisibility(8);
        this.epn.setVisibility(0);
        this.epo.setVisibility(0);
        this.epb.setVisibility(0);
        this.epn.clearAnimation();
        if (this.mRotateAnimation != null) {
            this.epn.startAnimation(this.mRotateAnimation);
        }
        if (this.epp != null) {
            if (this.epp.isRunning()) {
                this.epp.cancel();
            }
            this.epp.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcT() {
        if (this.epb != null && !v.isEmpty(this.epr)) {
            this.epq++;
            if (this.epr.size() > this.epq) {
                this.epb.startLoad(this.epr.get(this.epq).portrait, 12, false);
            } else if (this.epr.size() > 0) {
                this.epq = 0;
                this.epb.startLoad(this.epr.get(this.epq).portrait, 12, false);
            }
        }
    }

    private void stopAnim() {
        this.epn.setVisibility(8);
        this.epo.setVisibility(8);
        this.epb.setVisibility(8);
        this.epn.clearAnimation();
        if (this.epp != null) {
            this.epp.cancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.epa) {
            if (bc.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTabMyConcernActivityConfig(getTbPageContext().getPageActivity())));
            }
            TiebaStatic.log("c13552");
        } else if (view == this.epe) {
            if (!StringUtils.isNull(this.eps)) {
                com.baidu.tbadk.browser.a.startWebActivity(this.mContext.getApplicationContext(), getContext().getResources().getString(R.string.entrance_ranklist_tip), this.eps, true, true, true, true, true, true, true);
                TiebaStatic.log("c13553");
            }
        } else if (view == this.eph) {
            String string = com.baidu.tbadk.core.sharedPref.b.aFB().getString("show_live_forum_url", "http://tieba.baidu.com/f?kw=百度直播");
            string = (StringUtils.isNull(string) || !string.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) ? "http://tieba.baidu.com/f?kw=百度直播" : "http://tieba.baidu.com/f?kw=百度直播";
            if (!string.contains("?")) {
                string = string + "?default_tab_id=1&call_from=15";
            } else if (!string.contains("&default_tab_id=")) {
                string = string + "&default_tab_id=1&call_from=15";
            }
            ba.aGE().a(this.mTbPageContext, new String[]{string}, true);
            TiebaStatic.log("c13554");
        } else if (view == this.epk) {
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
