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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class d {
    private static final float feL = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] feM = {0.0f, 0.0f, 0.0f, 0.0f, feL, feL, feL, feL};
    private static final float[] feN = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, feL, feL};
    private static final float[] feO = {0.0f, 0.0f, 0.0f, 0.0f, feL, feL, 0.0f, 0.0f};
    private bk faJ;
    public TbImageView feF;
    public TextView feG;
    public RelativeLayout feH;
    public TextView feI;
    public LinearLayout feJ;
    public HeadImageView feK;
    private String feQ;
    private com.baidu.tieba.ala.alasquare.a.c feR;
    private AlphaAnimation feT;
    private o feb;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private int[] feP = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean feS = false;
    private boolean feU = true;
    private boolean feV = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (d.this.feR != null && d.this.feR.faJ != null && d.this.feb != null) {
                    d.this.feb.a(d.this.feR);
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
        this.feF = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.feG = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.feH = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.feI = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.feJ = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.feK = (HeadImageView) this.mRootView.findViewById(R.id.ivUserAvatar);
        this.feK.setIsRound(true);
        this.feK.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.feF.setBorderSurroundContent(true);
        this.feF.setDrawBorder(true);
        this.feF.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.feH.getLayoutParams();
        layoutParams.width = ((com.baidu.adp.lib.util.l.getEquipmentWidth(tbPageContext.getPageActivity()) - tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12)) - (tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 2;
        layoutParams.height = layoutParams.width;
        this.feH.setLayoutParams(layoutParams);
        this.feT = new AlphaAnimation(0.0f, 1.0f);
        this.feT.setDuration(200L);
        this.feT.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                d.this.feV = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                d.this.feV = false;
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
        this.feb = oVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        a(cVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.c cVar, int i) {
        if (cVar == null || cVar.faJ == null || cVar.faJ.aQS() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.feR = cVar;
        this.faJ = cVar.faJ;
        this.tabId = cVar.tabId;
        this.feQ = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        Object tag = this.feF.getTag();
        if (this.feU) {
            this.feS = true;
            this.feU = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.faJ.aQS().cover) && !((String) tag).equals(this.faJ.aQS().cover)) {
            this.feS = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.faJ.aQS().cover) && !this.mCoverUrl.equals(this.faJ.aQS().cover)) {
            this.feS = true;
        } else {
            this.feS = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.feP);
        this.mCoverUrl = this.faJ.aQS().cover;
        this.feF.setTag(this.mCoverUrl);
        if (cVar.isLeft) {
            this.feF.setConrers(5);
            gradientDrawable.setCornerRadii(feN);
            this.feF.setDefaultBgResource(R.drawable.tab_live_card_round_bg_left);
        } else if (cVar.isRight) {
            this.feF.setConrers(10);
            gradientDrawable.setCornerRadii(feO);
            this.feF.setDefaultBgResource(R.drawable.tab_live_card_round_bg_right);
        } else if (cVar.faH) {
            this.feF.setConrers(15);
            gradientDrawable.setCornerRadii(feM);
            this.feF.setDefaultBgResource(R.drawable.tab_live_card_round_bg_only_left);
        }
        this.feF.setRadius((int) feL);
        this.feF.startLoad(this.faJ.aQS().cover, 10, false);
        this.feJ.setBackgroundDrawable(gradientDrawable);
        this.feF.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && d.this.feS && !d.this.feV) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        d.this.feF.startAnimation(d.this.feT);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.feG.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.live_tab_audience_label, aq.cl(this.faJ.aQS().audience_count)));
        if (this.faJ.aQx() != null) {
            String name_show = this.faJ.aQx().getName_show();
            if (!StringUtils.isNull(name_show)) {
                this.feI.setText(name_show);
            }
            this.feK.startLoad(this.faJ.aQx().getPortrait(), 12, false);
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.feG, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.feI, (int) R.color.cp_cont_a);
            if (i == 1) {
                this.feK.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c_1));
            } else {
                this.feK.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c));
            }
            Drawable drawable = am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.feG.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.feG.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
