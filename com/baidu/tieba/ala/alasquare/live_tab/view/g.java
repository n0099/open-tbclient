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
    private LinearLayout epb;
    private HeadImageView epc;
    private ImageView epd;
    private TextView epe;
    private LinearLayout epf;
    private ImageView epg;
    private TextView eph;
    private LinearLayout epi;
    private ImageView epj;
    private TextView epk;
    private LinearLayout epl;
    private ImageView epm;
    private TextView epn;
    private ImageView epo;
    private ImageView epp;
    private ObjectAnimator epq;
    private int epr;
    private List<h.a> eps;
    private String ept;
    private View mRootView;
    private RotateAnimation mRotateAnimation;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.epr = -1;
        this.eps = new ArrayList();
        initView();
    }

    private void initView() {
        this.mRootView = getView();
        this.epb = (LinearLayout) this.mRootView.findViewById(R.id.entrance_follow);
        this.epf = (LinearLayout) this.mRootView.findViewById(R.id.entrance_ranklist);
        this.epi = (LinearLayout) this.mRootView.findViewById(R.id.entrance_discuss);
        this.epl = (LinearLayout) this.mRootView.findViewById(R.id.entrance_person_center);
        this.epo = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_img_diandian);
        this.epc = (HeadImageView) this.mRootView.findViewById(R.id.entrance_follow_img);
        this.epc.setIsRound(true);
        this.epc.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.epc.setDefaultResource(17170445);
        this.epc.setDefaultBgResource(17170445);
        this.epp = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_circle);
        this.epd = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_default_img);
        this.epg = (ImageView) this.mRootView.findViewById(R.id.entrance_ranklist_img);
        this.epj = (ImageView) this.mRootView.findViewById(R.id.entrance_discuss_img);
        this.epm = (ImageView) this.mRootView.findViewById(R.id.entrance_person_center_img);
        this.epe = (TextView) this.mRootView.findViewById(R.id.entrance_follow_desc);
        this.eph = (TextView) this.mRootView.findViewById(R.id.entrance_ranklist_desc);
        this.epk = (TextView) this.mRootView.findViewById(R.id.entrance_discuss_desc);
        this.epn = (TextView) this.mRootView.findViewById(R.id.entrance_person_center_desc);
        this.epb.setOnClickListener(this);
        this.epf.setOnClickListener(this);
        this.epi.setOnClickListener(this);
        this.epl.setOnClickListener(this);
        this.mRotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation.setDuration(6000L);
        this.mRotateAnimation.setRepeatMode(1);
        this.mRotateAnimation.setRepeatCount(-1);
        this.mRotateAnimation.setInterpolator(new LinearInterpolator());
        this.epq = ObjectAnimator.ofPropertyValuesHolder(this.epc, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f));
        this.epq.setInterpolator(new DecelerateInterpolator());
        this.epq.setTarget(this.epc);
        this.epq.setRepeatCount(-1);
        this.epq.setRepeatMode(1);
        this.epq.setDuration(2000L);
        this.epq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.1
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
                g.this.bcV();
            }
        });
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        am.setViewTextColor(this.epe, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setViewTextColor(this.eph, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setViewTextColor(this.epk, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setViewTextColor(this.epn, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setImageResource(this.epg, R.drawable.super_entrance_ranklist_bg_selector);
        am.setImageResource(this.epj, R.drawable.super_entrance_discuss_bg_selector);
        am.setImageResource(this.epm, R.drawable.super_entrance_person_bg_selector);
        am.setImageResource(this.epp, R.drawable.pic_live_tab_quan);
        if (8 == this.epo.getVisibility()) {
            this.epd.setVisibility(0);
            this.epp.setVisibility(8);
            am.setBackgroundResource(this.epd, R.drawable.super_entrance_follow_bg_selector);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_live_super_enreances_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.i iVar) {
        if (iVar == null || iVar.elT == null) {
            stopAnim();
            return;
        }
        TiebaStatic.log("c13550");
        TiebaStatic.log("c13549");
        TiebaStatic.log("c13547");
        TiebaStatic.log("c13546");
        this.ept = iVar.elT.elQ;
        if (!iVar.elT.elO || v.isEmpty(iVar.elT.elP)) {
            stopAnim();
            return;
        }
        this.eps = iVar.elT.elP;
        if (!v.isEmpty(this.eps)) {
            startAnim();
            bcV();
        }
    }

    private void startAnim() {
        this.epd.setVisibility(8);
        this.epo.setVisibility(0);
        this.epp.setVisibility(0);
        this.epc.setVisibility(0);
        this.epo.clearAnimation();
        if (this.mRotateAnimation != null) {
            this.epo.startAnimation(this.mRotateAnimation);
        }
        if (this.epq != null) {
            if (this.epq.isRunning()) {
                this.epq.cancel();
            }
            this.epq.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcV() {
        if (this.epc != null && !v.isEmpty(this.eps)) {
            this.epr++;
            if (this.eps.size() > this.epr) {
                this.epc.startLoad(this.eps.get(this.epr).portrait, 12, false);
            } else if (this.eps.size() > 0) {
                this.epr = 0;
                this.epc.startLoad(this.eps.get(this.epr).portrait, 12, false);
            }
        }
    }

    private void stopAnim() {
        this.epo.setVisibility(8);
        this.epp.setVisibility(8);
        this.epc.setVisibility(8);
        this.epo.clearAnimation();
        if (this.epq != null) {
            this.epq.cancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.epb) {
            if (bc.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTabMyConcernActivityConfig(getTbPageContext().getPageActivity())));
            }
            TiebaStatic.log("c13552");
        } else if (view == this.epf) {
            if (!StringUtils.isNull(this.ept)) {
                com.baidu.tbadk.browser.a.startWebActivity(this.mContext.getApplicationContext(), getContext().getResources().getString(R.string.entrance_ranklist_tip), this.ept, true, true, true, true, true, true, true);
                TiebaStatic.log("c13553");
            }
        } else if (view == this.epi) {
            String string = com.baidu.tbadk.core.sharedPref.b.aFD().getString("show_live_forum_url", "http://tieba.baidu.com/f?kw=百度直播");
            string = (StringUtils.isNull(string) || !string.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) ? "http://tieba.baidu.com/f?kw=百度直播" : "http://tieba.baidu.com/f?kw=百度直播";
            if (!string.contains("?")) {
                string = string + "?default_tab_id=1&call_from=15";
            } else if (!string.contains("&default_tab_id=")) {
                string = string + "&default_tab_id=1&call_from=15";
            }
            ba.aGG().a(this.mTbPageContext, new String[]{string}, true);
            TiebaStatic.log("c13554");
        } else if (view == this.epl) {
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
