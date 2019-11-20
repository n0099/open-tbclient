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
    private LinearLayout dyW;
    private HeadImageView dyX;
    private ImageView dyY;
    private TextView dyZ;
    private LinearLayout dza;
    private ImageView dzb;
    private TextView dzc;
    private LinearLayout dzd;
    private ImageView dze;
    private TextView dzf;
    private LinearLayout dzg;
    private ImageView dzh;
    private TextView dzi;
    private ImageView dzj;
    private ImageView dzk;
    private RotateAnimation dzl;
    private ObjectAnimator dzm;
    private int dzn;
    private List<f.a> dzo;
    private String dzp;
    private View mRootView;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dzn = -1;
        this.dzo = new ArrayList();
        initView();
    }

    public f(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.dzn = -1;
        this.dzo = new ArrayList();
        initView();
    }

    private void initView() {
        this.mRootView = getView();
        this.dyW = (LinearLayout) this.mRootView.findViewById(R.id.entrance_follow);
        this.dza = (LinearLayout) this.mRootView.findViewById(R.id.entrance_ranklist);
        this.dzd = (LinearLayout) this.mRootView.findViewById(R.id.entrance_discuss);
        this.dzg = (LinearLayout) this.mRootView.findViewById(R.id.entrance_person_center);
        this.dzj = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_img_diandian);
        this.dyX = (HeadImageView) this.mRootView.findViewById(R.id.entrance_follow_img);
        this.dyX.setIsRound(true);
        this.dyX.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dyX.setDefaultResource(17170445);
        this.dyX.setDefaultBgResource(17170445);
        this.dzk = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_circle);
        this.dyY = (ImageView) this.mRootView.findViewById(R.id.entrance_follow_default_img);
        this.dzb = (ImageView) this.mRootView.findViewById(R.id.entrance_ranklist_img);
        this.dze = (ImageView) this.mRootView.findViewById(R.id.entrance_discuss_img);
        this.dzh = (ImageView) this.mRootView.findViewById(R.id.entrance_person_center_img);
        this.dyZ = (TextView) this.mRootView.findViewById(R.id.entrance_follow_desc);
        this.dzc = (TextView) this.mRootView.findViewById(R.id.entrance_ranklist_desc);
        this.dzf = (TextView) this.mRootView.findViewById(R.id.entrance_discuss_desc);
        this.dzi = (TextView) this.mRootView.findViewById(R.id.entrance_person_center_desc);
        this.dyW.setOnClickListener(this);
        this.dza.setOnClickListener(this);
        this.dzd.setOnClickListener(this);
        this.dzg.setOnClickListener(this);
        this.dzl = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.dzl.setDuration(6000L);
        this.dzl.setRepeatMode(1);
        this.dzl.setRepeatCount(-1);
        this.dzl.setInterpolator(new LinearInterpolator());
        this.dzm = ObjectAnimator.ofPropertyValuesHolder(this.dyX, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f, 0.9f, 1.0f, 0.9f, 1.0f, 0.0f));
        this.dzm.setInterpolator(new DecelerateInterpolator());
        this.dzm.setTarget(this.dyX);
        this.dzm.setRepeatCount(-1);
        this.dzm.setRepeatMode(1);
        this.dzm.setDuration(2000L);
        this.dzm.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.f.1
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
                f.this.aJK();
            }
        });
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        am.setViewTextColor(this.dyZ, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setViewTextColor(this.dzc, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setViewTextColor(this.dzf, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setViewTextColor(this.dzi, (int) R.drawable.tab_super_entrance_txt_selecor);
        am.setImageResource(this.dzb, R.drawable.super_entrance_ranklist_bg_selector);
        am.setImageResource(this.dze, R.drawable.super_entrance_discuss_bg_selector);
        am.setImageResource(this.dzh, R.drawable.super_entrance_person_bg_selector);
        am.setImageResource(this.dzk, R.drawable.pic_live_tab_quan);
        if (8 == this.dzj.getVisibility()) {
            this.dyY.setVisibility(0);
            this.dzk.setVisibility(8);
            am.setBackgroundResource(this.dyY, R.drawable.super_entrance_follow_bg_selector);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_live_super_enreances_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.g gVar) {
        if (gVar == null || gVar.dwy == null) {
            stopAnim();
            return;
        }
        this.dzp = gVar.dwy.dwv;
        TiebaStatic.log("c13550");
        TiebaStatic.log("c13549");
        TiebaStatic.log("c13547");
        TiebaStatic.log("c13546");
        if (!gVar.dwy.dwt || v.isEmpty(gVar.dwy.dwu)) {
            stopAnim();
            return;
        }
        this.dzo = gVar.dwy.dwu;
        if (!v.isEmpty(this.dzo)) {
            startAnim();
            aJK();
        }
    }

    private void startAnim() {
        this.dyY.setVisibility(8);
        this.dzj.setVisibility(0);
        this.dzk.setVisibility(0);
        this.dyX.setVisibility(0);
        this.dzj.clearAnimation();
        if (this.dzl != null) {
            this.dzj.startAnimation(this.dzl);
        }
        if (this.dzm != null) {
            if (this.dzm.isRunning()) {
                this.dzm.cancel();
            }
            this.dzm.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJK() {
        if (this.dyX != null && !v.isEmpty(this.dzo)) {
            this.dzn++;
            if (this.dzo.size() > this.dzn) {
                this.dyX.startLoad(this.dzo.get(this.dzn).portrait, 12, false);
            } else if (this.dzo.size() > 0) {
                this.dzn = 0;
                this.dyX.startLoad(this.dzo.get(this.dzn).portrait, 12, false);
            }
        }
    }

    private void stopAnim() {
        this.dzj.setVisibility(8);
        this.dzk.setVisibility(8);
        this.dyX.setVisibility(8);
        this.dzj.clearAnimation();
        if (this.dzm != null) {
            this.dzm.cancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dyW) {
            if (bc.checkUpIsLogin(this.mContext)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveTabMyConcernActivityConfig(getTbPageContext().getPageActivity())));
            }
            TiebaStatic.log("c13552");
        } else if (view == this.dza) {
            if (!StringUtils.isNull(this.dzp)) {
                com.baidu.tbadk.browser.a.startWebActivity(this.mContext.getApplicationContext(), getContext().getResources().getString(R.string.entrance_ranklist_tip), this.dzp, true, true, true, true, true, true, true);
                TiebaStatic.log("c13553");
            }
        } else if (view == this.dzd) {
            String string = com.baidu.tbadk.core.sharedPref.b.alP().getString("show_live_forum_url", "http://tieba.baidu.com/f?kw=百度直播");
            string = (StringUtils.isNull(string) || !string.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) ? "http://tieba.baidu.com/f?kw=百度直播" : "http://tieba.baidu.com/f?kw=百度直播";
            if (!string.contains("?")) {
                string = string + "?default_tab_id=1&call_from=15";
            } else if (!string.contains("&default_tab_id=")) {
                string = string + "&default_tab_id=1&call_from=15";
            }
            ba.amO().a(this.mTbPageContext, new String[]{string}, true);
            TiebaStatic.log("c13554");
        } else if (view == this.dzg) {
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
