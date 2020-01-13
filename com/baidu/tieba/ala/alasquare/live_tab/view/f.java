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
/* loaded from: classes2.dex */
public class f extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.live_tab.b.i> {
    private LinearLayout ekP;
    private HeadImageView ekQ;
    private ImageView ekR;
    private TextView ekS;
    private LinearLayout ekT;
    private ImageView ekU;
    private TextView ekV;
    private LinearLayout ekW;
    private ImageView ekX;
    private TextView ekY;
    private LinearLayout ekZ;
    private ImageView ela;
    private TextView elb;
    private ImageView elc;
    private ImageView eld;
    private ObjectAnimator ele;
    private int elf;
    private List<h.a> elg;
    private String elh;
    private View mRootView;
    private RotateAnimation mRotateAnimation;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.elf = -1;
        this.elg = new ArrayList();
        initView();
    }

    private void initView() {
        this.mRootView = getView();
        this.ekP = (LinearLayout) this.mRootView.findViewById(R.id.entrance_follow);
        this.ekT = (LinearLayout) this.mRootView.findViewById(R.id.entrance_ranklist);
        this.ekW = (LinearLayout) this.mRootView.findViewById(R.id.entrance_discuss);
        this.ekZ = (LinearLayout) this.mRootView.findViewById(R.id.entrance_person_center);
        this.elc = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_img_diandian);
        this.ekQ = (HeadImageView) this.mRootView.findViewById(R.id.entrance_follow_img);
        this.ekQ.setIsRound(true);
        this.ekQ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ekQ.setDefaultResource(17170445);
        this.ekQ.setDefaultBgResource(17170445);
        this.eld = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_circle);
        this.ekR = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_default_img);
        this.ekU = (ImageView) this.mRootView.findViewById(R.id.entrance_ranklist_img);
        this.ekX = (ImageView) this.mRootView.findViewById(R.id.entrance_discuss_img);
        this.ela = (ImageView) this.mRootView.findViewById(R.id.entrance_person_center_img);
        this.ekS = (TextView) this.mRootView.findViewById(R.id.entrance_follow_desc);
        this.ekV = (TextView) this.mRootView.findViewById(R.id.entrance_ranklist_desc);
        this.ekY = (TextView) this.mRootView.findViewById(R.id.entrance_discuss_desc);
        this.elb = (TextView) this.mRootView.findViewById(R.id.entrance_person_center_desc);
        this.ekP.setOnClickListener(this);
        this.ekT.setOnClickListener(this);
        this.ekW.setOnClickListener(this);
        this.ekZ.setOnClickListener(this);
        this.mRotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation.setDuration(6000L);
        this.mRotateAnimation.setRepeatMode(1);
        this.mRotateAnimation.setRepeatCount(-1);
        this.mRotateAnimation.setInterpolator(new LinearInterpolator());
        this.ele = ObjectAnimator.ofPropertyValuesHolder(this.ekQ, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f));
        this.ele.setInterpolator(new DecelerateInterpolator());
        this.ele.setTarget(this.ekQ);
        this.ele.setRepeatCount(-1);
        this.ele.setRepeatMode(1);
        this.ele.setDuration(2000L);
        this.ele.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.f.1
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
                f.this.baE();
            }
        });
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        am.setViewTextColor(this.ekS, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setViewTextColor(this.ekV, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setViewTextColor(this.ekY, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setViewTextColor(this.elb, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setImageResource(this.ekU, R.drawable.super_entrance_ranklist_bg_selector);
        am.setImageResource(this.ekX, R.drawable.super_entrance_discuss_bg_selector);
        am.setImageResource(this.ela, R.drawable.super_entrance_person_bg_selector);
        am.setImageResource(this.eld, R.drawable.pic_live_tab_quan);
        if (8 == this.elc.getVisibility()) {
            this.ekR.setVisibility(0);
            this.eld.setVisibility(8);
            am.setBackgroundResource(this.ekR, R.drawable.super_entrance_follow_bg_selector);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_live_super_enreances_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.i iVar) {
        if (iVar == null || iVar.ehN == null) {
            stopAnim();
            return;
        }
        TiebaStatic.log("c13550");
        TiebaStatic.log("c13549");
        TiebaStatic.log("c13547");
        TiebaStatic.log("c13546");
        this.elh = iVar.ehN.ehK;
        if (!iVar.ehN.ehI || v.isEmpty(iVar.ehN.ehJ)) {
            stopAnim();
            return;
        }
        this.elg = iVar.ehN.ehJ;
        if (!v.isEmpty(this.elg)) {
            startAnim();
            baE();
        }
    }

    private void startAnim() {
        this.ekR.setVisibility(8);
        this.elc.setVisibility(0);
        this.eld.setVisibility(0);
        this.ekQ.setVisibility(0);
        this.elc.clearAnimation();
        if (this.mRotateAnimation != null) {
            this.elc.startAnimation(this.mRotateAnimation);
        }
        if (this.ele != null) {
            if (this.ele.isRunning()) {
                this.ele.cancel();
            }
            this.ele.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baE() {
        if (this.ekQ != null && !v.isEmpty(this.elg)) {
            this.elf++;
            if (this.elg.size() > this.elf) {
                this.ekQ.startLoad(this.elg.get(this.elf).portrait, 12, false);
            } else if (this.elg.size() > 0) {
                this.elf = 0;
                this.ekQ.startLoad(this.elg.get(this.elf).portrait, 12, false);
            }
        }
    }

    private void stopAnim() {
        this.elc.setVisibility(8);
        this.eld.setVisibility(8);
        this.ekQ.setVisibility(8);
        this.elc.clearAnimation();
        if (this.ele != null) {
            this.ele.cancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ekP) {
            if (bc.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTabMyConcernActivityConfig(getTbPageContext().getPageActivity())));
            }
            TiebaStatic.log("c13552");
        } else if (view == this.ekT) {
            if (!StringUtils.isNull(this.elh)) {
                com.baidu.tbadk.browser.a.startWebActivity(this.mContext.getApplicationContext(), getContext().getResources().getString(R.string.entrance_ranklist_tip), this.elh, true, true, true, true, true, true, true);
                TiebaStatic.log("c13553");
            }
        } else if (view == this.ekW) {
            String string = com.baidu.tbadk.core.sharedPref.b.aDr().getString("show_live_forum_url", "http://tieba.baidu.com/f?kw=百度直播");
            string = (StringUtils.isNull(string) || !string.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) ? "http://tieba.baidu.com/f?kw=百度直播" : "http://tieba.baidu.com/f?kw=百度直播";
            if (!string.contains("?")) {
                string = string + "?default_tab_id=1&call_from=15";
            } else if (!string.contains("&default_tab_id=")) {
                string = string + "&default_tab_id=1&call_from=15";
            }
            ba.aEt().a(this.mTbPageContext, new String[]{string}, true);
            TiebaStatic.log("c13554");
        } else if (view == this.ekZ) {
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
