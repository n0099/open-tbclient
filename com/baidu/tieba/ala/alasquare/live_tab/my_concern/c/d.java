package com.baidu.tieba.ala.alasquare.live_tab.my_concern.c;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class d {
    private static final float enK = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] enL = {0.0f, 0.0f, 0.0f, 0.0f, enK, enK, enK, enK};
    private static final float[] enM = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, enK, enK};
    private static final float[] enN = {0.0f, 0.0f, 0.0f, 0.0f, enK, enK, 0.0f, 0.0f};
    private bj ejI;
    private o emY;
    public TbImageView enE;
    public TextView enF;
    public RelativeLayout enG;
    public TextView enH;
    public LinearLayout enI;
    public HeadImageView enJ;
    private String enP;
    private com.baidu.tieba.ala.alasquare.a.c enQ;
    private AlphaAnimation enS;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private int[] enO = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean enR = false;
    private boolean enT = true;
    private boolean enU = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (d.this.enQ != null && d.this.enQ.ejI != null && d.this.emY != null) {
                    d.this.emY.a(d.this.enQ);
                    return;
                }
                return;
            }
            com.baidu.adp.lib.util.l.showLongToast(d.this.mTbPageContext.getPageActivity(), d.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        }
    };

    public d(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_sub_live_item_view, (ViewGroup) null, false);
        this.enE = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.enF = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.enG = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.enH = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.enI = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.enJ = (HeadImageView) this.mRootView.findViewById(R.id.ivUserAvatar);
        this.enJ.setIsRound(true);
        this.enJ.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.enE.setBorderSurroundContent(true);
        this.enE.setDrawBorder(true);
        this.enE.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.enG.getLayoutParams();
        layoutParams.width = ((com.baidu.adp.lib.util.l.getEquipmentWidth(tbPageContext.getPageActivity()) - tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12)) - (tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 2;
        layoutParams.height = layoutParams.width;
        this.enG.setLayoutParams(layoutParams);
        this.enS = new AlphaAnimation(0.0f, 1.0f);
        this.enS.setDuration(200L);
        this.enS.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                d.this.enU = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                d.this.enU = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(o oVar) {
        this.emY = oVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        a(cVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.c cVar, int i) {
        if (cVar == null || cVar.ejI == null || cVar.ejI.aCF() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.enQ = cVar;
        this.ejI = cVar.ejI;
        this.tabId = cVar.tabId;
        this.enP = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        Object tag = this.enE.getTag();
        if (this.enT) {
            this.enR = true;
            this.enT = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.ejI.aCF().cover) && !((String) tag).equals(this.ejI.aCF().cover)) {
            this.enR = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.ejI.aCF().cover) && !this.mCoverUrl.equals(this.ejI.aCF().cover)) {
            this.enR = true;
        } else {
            this.enR = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.enO);
        this.mCoverUrl = this.ejI.aCF().cover;
        this.enE.setTag(this.mCoverUrl);
        if (cVar.isLeft) {
            this.enE.setConrers(5);
            gradientDrawable.setCornerRadii(enM);
            this.enE.setDefaultBgResource(R.drawable.tab_live_card_round_bg_left);
        } else if (cVar.isRight) {
            this.enE.setConrers(10);
            gradientDrawable.setCornerRadii(enN);
            this.enE.setDefaultBgResource(R.drawable.tab_live_card_round_bg_right);
        } else if (cVar.ejG) {
            this.enE.setConrers(15);
            gradientDrawable.setCornerRadii(enL);
            this.enE.setDefaultBgResource(R.drawable.tab_live_card_round_bg_only_left);
        }
        this.enE.setRadius((int) enK);
        this.enE.startLoad(this.ejI.aCF().cover, 10, false);
        this.enI.setBackgroundDrawable(gradientDrawable);
        this.enE.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && d.this.enR && !d.this.enU) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        d.this.enE.startAnimation(d.this.enS);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.enF.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.live_tab_audience_label, aq.bE(this.ejI.aCF().audience_count)));
        if (this.ejI.aCm() != null) {
            String name_show = this.ejI.aCm().getName_show();
            if (!StringUtils.isNull(name_show)) {
                this.enH.setText(name_show);
            }
            this.enJ.startLoad(this.ejI.aCm().getPortrait(), 12, false);
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.enF, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.enH, (int) R.color.cp_cont_a);
            if (i == 1) {
                this.enJ.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c_1));
            } else {
                this.enJ.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c));
            }
            Drawable drawable = am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.enF.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.enF.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
