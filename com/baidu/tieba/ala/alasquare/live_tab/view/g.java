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
    private TextView epA;
    private ImageView epB;
    private ImageView epC;
    private ObjectAnimator epD;
    private int epE;
    private List<h.a> epF;
    private String epG;
    private LinearLayout epo;
    private HeadImageView epp;
    private ImageView epq;
    private TextView epr;
    private LinearLayout eps;
    private ImageView ept;
    private TextView epu;
    private LinearLayout epv;
    private ImageView epw;
    private TextView epx;
    private LinearLayout epy;
    private ImageView epz;
    private View mRootView;
    private RotateAnimation mRotateAnimation;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.epE = -1;
        this.epF = new ArrayList();
        initView();
    }

    private void initView() {
        this.mRootView = getView();
        this.epo = (LinearLayout) this.mRootView.findViewById(R.id.entrance_follow);
        this.eps = (LinearLayout) this.mRootView.findViewById(R.id.entrance_ranklist);
        this.epv = (LinearLayout) this.mRootView.findViewById(R.id.entrance_discuss);
        this.epy = (LinearLayout) this.mRootView.findViewById(R.id.entrance_person_center);
        this.epB = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_img_diandian);
        this.epp = (HeadImageView) this.mRootView.findViewById(R.id.entrance_follow_img);
        this.epp.setIsRound(true);
        this.epp.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.epp.setDefaultResource(17170445);
        this.epp.setDefaultBgResource(17170445);
        this.epC = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_circle);
        this.epq = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_default_img);
        this.ept = (ImageView) this.mRootView.findViewById(R.id.entrance_ranklist_img);
        this.epw = (ImageView) this.mRootView.findViewById(R.id.entrance_discuss_img);
        this.epz = (ImageView) this.mRootView.findViewById(R.id.entrance_person_center_img);
        this.epr = (TextView) this.mRootView.findViewById(R.id.entrance_follow_desc);
        this.epu = (TextView) this.mRootView.findViewById(R.id.entrance_ranklist_desc);
        this.epx = (TextView) this.mRootView.findViewById(R.id.entrance_discuss_desc);
        this.epA = (TextView) this.mRootView.findViewById(R.id.entrance_person_center_desc);
        this.epo.setOnClickListener(this);
        this.eps.setOnClickListener(this);
        this.epv.setOnClickListener(this);
        this.epy.setOnClickListener(this);
        this.mRotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation.setDuration(6000L);
        this.mRotateAnimation.setRepeatMode(1);
        this.mRotateAnimation.setRepeatCount(-1);
        this.mRotateAnimation.setInterpolator(new LinearInterpolator());
        this.epD = ObjectAnimator.ofPropertyValuesHolder(this.epp, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f));
        this.epD.setInterpolator(new DecelerateInterpolator());
        this.epD.setTarget(this.epp);
        this.epD.setRepeatCount(-1);
        this.epD.setRepeatMode(1);
        this.epD.setDuration(2000L);
        this.epD.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.1
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
                g.this.bcW();
            }
        });
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        am.setViewTextColor(this.epr, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setViewTextColor(this.epu, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setViewTextColor(this.epx, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setViewTextColor(this.epA, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setImageResource(this.ept, R.drawable.super_entrance_ranklist_bg_selector);
        am.setImageResource(this.epw, R.drawable.super_entrance_discuss_bg_selector);
        am.setImageResource(this.epz, R.drawable.super_entrance_person_bg_selector);
        am.setImageResource(this.epC, R.drawable.pic_live_tab_quan);
        if (8 == this.epB.getVisibility()) {
            this.epq.setVisibility(0);
            this.epC.setVisibility(8);
            am.setBackgroundResource(this.epq, R.drawable.super_entrance_follow_bg_selector);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_live_super_enreances_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.i iVar) {
        if (iVar == null || iVar.emg == null) {
            stopAnim();
            return;
        }
        TiebaStatic.log("c13550");
        TiebaStatic.log("c13549");
        TiebaStatic.log("c13547");
        TiebaStatic.log("c13546");
        this.epG = iVar.emg.emd;
        if (!iVar.emg.emb || v.isEmpty(iVar.emg.emc)) {
            stopAnim();
            return;
        }
        this.epF = iVar.emg.emc;
        if (!v.isEmpty(this.epF)) {
            startAnim();
            bcW();
        }
    }

    private void startAnim() {
        this.epq.setVisibility(8);
        this.epB.setVisibility(0);
        this.epC.setVisibility(0);
        this.epp.setVisibility(0);
        this.epB.clearAnimation();
        if (this.mRotateAnimation != null) {
            this.epB.startAnimation(this.mRotateAnimation);
        }
        if (this.epD != null) {
            if (this.epD.isRunning()) {
                this.epD.cancel();
            }
            this.epD.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcW() {
        if (this.epp != null && !v.isEmpty(this.epF)) {
            this.epE++;
            if (this.epF.size() > this.epE) {
                this.epp.startLoad(this.epF.get(this.epE).portrait, 12, false);
            } else if (this.epF.size() > 0) {
                this.epE = 0;
                this.epp.startLoad(this.epF.get(this.epE).portrait, 12, false);
            }
        }
    }

    private void stopAnim() {
        this.epB.setVisibility(8);
        this.epC.setVisibility(8);
        this.epp.setVisibility(8);
        this.epB.clearAnimation();
        if (this.epD != null) {
            this.epD.cancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.epo) {
            if (bc.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTabMyConcernActivityConfig(getTbPageContext().getPageActivity())));
            }
            TiebaStatic.log("c13552");
        } else if (view == this.eps) {
            if (!StringUtils.isNull(this.epG)) {
                com.baidu.tbadk.browser.a.startWebActivity(this.mContext.getApplicationContext(), getContext().getResources().getString(R.string.entrance_ranklist_tip), this.epG, true, true, true, true, true, true, true);
                TiebaStatic.log("c13553");
            }
        } else if (view == this.epv) {
            String string = com.baidu.tbadk.core.sharedPref.b.aFD().getString("show_live_forum_url", "http://tieba.baidu.com/f?kw=百度直播");
            string = (StringUtils.isNull(string) || !string.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) ? "http://tieba.baidu.com/f?kw=百度直播" : "http://tieba.baidu.com/f?kw=百度直播";
            if (!string.contains("?")) {
                string = string + "?default_tab_id=1&call_from=15";
            } else if (!string.contains("&default_tab_id=")) {
                string = string + "&default_tab_id=1&call_from=15";
            }
            ba.aGG().a(this.mTbPageContext, new String[]{string}, true);
            TiebaStatic.log("c13554");
        } else if (view == this.epy) {
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
