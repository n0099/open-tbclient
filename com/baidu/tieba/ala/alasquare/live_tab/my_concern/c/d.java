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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class d {
    private static final float fJP = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] fJQ = {0.0f, 0.0f, 0.0f, 0.0f, fJP, fJP, fJP, fJP};
    private static final float[] fJR = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, fJP, fJP};
    private static final float[] fJS = {0.0f, 0.0f, 0.0f, 0.0f, fJP, fJP, 0.0f, 0.0f};
    private bw fFN;
    public TbImageView fJJ;
    public TextView fJK;
    public RelativeLayout fJL;
    public TextView fJM;
    public LinearLayout fJN;
    public HeadImageView fJO;
    private String fJU;
    private com.baidu.tieba.ala.alasquare.a.c fJV;
    private AlphaAnimation fJX;
    private o fJf;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private int[] fJT = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean fJW = false;
    private boolean fJY = true;
    private boolean mIsAnimating = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (d.this.fJV != null && d.this.fJV.fFN != null && d.this.fJf != null) {
                    d.this.fJf.a(d.this.fJV);
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
        this.fJJ = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.fJK = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.fJL = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.fJM = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.fJN = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.fJO = (HeadImageView) this.mRootView.findViewById(R.id.ivUserAvatar);
        this.fJO.setIsRound(true);
        this.fJO.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.fJJ.setBorderSurroundContent(true);
        this.fJJ.setDrawBorder(true);
        this.fJJ.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fJL.getLayoutParams();
        layoutParams.width = ((com.baidu.adp.lib.util.l.getEquipmentWidth(tbPageContext.getPageActivity()) - tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12)) - (tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 2;
        layoutParams.height = layoutParams.width;
        this.fJL.setLayoutParams(layoutParams);
        this.fJX = new AlphaAnimation(0.0f, 1.0f);
        this.fJX.setDuration(200L);
        this.fJX.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                d.this.mIsAnimating = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                d.this.mIsAnimating = false;
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
        this.fJf = oVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        a(cVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.c cVar, int i) {
        if (cVar == null || cVar.fFN == null || cVar.fFN.bfS() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.fJV = cVar;
        this.fFN = cVar.fFN;
        this.tabId = cVar.tabId;
        this.fJU = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        Object tag = this.fJJ.getTag();
        if (this.fJY) {
            this.fJW = true;
            this.fJY = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.fFN.bfS().cover) && !((String) tag).equals(this.fFN.bfS().cover)) {
            this.fJW = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.fFN.bfS().cover) && !this.mCoverUrl.equals(this.fFN.bfS().cover)) {
            this.fJW = true;
        } else {
            this.fJW = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.fJT);
        this.mCoverUrl = this.fFN.bfS().cover;
        this.fJJ.setTag(this.mCoverUrl);
        if (cVar.isLeft) {
            this.fJJ.setConrers(5);
            gradientDrawable.setCornerRadii(fJR);
            this.fJJ.setDefaultBgResource(R.drawable.tab_live_card_round_bg_left);
        } else if (cVar.isRight) {
            this.fJJ.setConrers(10);
            gradientDrawable.setCornerRadii(fJS);
            this.fJJ.setDefaultBgResource(R.drawable.tab_live_card_round_bg_right);
        } else if (cVar.fFL) {
            this.fJJ.setConrers(15);
            gradientDrawable.setCornerRadii(fJQ);
            this.fJJ.setDefaultBgResource(R.drawable.tab_live_card_round_bg_only_left);
        }
        this.fJJ.setRadius((int) fJP);
        this.fJJ.startLoad(this.fFN.bfS().cover, 10, false);
        this.fJN.setBackgroundDrawable(gradientDrawable);
        this.fJJ.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && d.this.fJW && !d.this.mIsAnimating) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        d.this.fJJ.startAnimation(d.this.fJX);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fJK.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.live_tab_audience_label, at.cQ(this.fFN.bfS().audience_count)));
        if (this.fFN.bfy() != null) {
            String name_show = this.fFN.bfy().getName_show();
            if (!StringUtils.isNull(name_show)) {
                this.fJM.setText(name_show);
            }
            this.fJO.startLoad(this.fFN.bfy().getPortrait(), 12, false);
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.fJK, R.color.cp_cont_a);
            ap.setViewTextColor(this.fJM, R.color.cp_cont_a);
            if (i == 1) {
                this.fJO.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c_1));
            } else {
                this.fJO.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c));
            }
            Drawable drawable = ap.getDrawable(this.mTbPageContext.getResources(), R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.fJK.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.fJK.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
