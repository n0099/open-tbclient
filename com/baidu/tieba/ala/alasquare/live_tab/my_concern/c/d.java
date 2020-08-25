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
    private bw fCx;
    private o fFP;
    private String fGE;
    private com.baidu.tieba.ala.alasquare.a.c fGF;
    private AlphaAnimation fGH;
    public TbImageView fGt;
    public TextView fGu;
    public RelativeLayout fGv;
    public TextView fGw;
    public LinearLayout fGx;
    public HeadImageView fGy;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    private static final float fGz = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] fGA = {0.0f, 0.0f, 0.0f, 0.0f, fGz, fGz, fGz, fGz};
    private static final float[] fGB = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, fGz, fGz};
    private static final float[] fGC = {0.0f, 0.0f, 0.0f, 0.0f, fGz, fGz, 0.0f, 0.0f};
    public int mSkinType = 3;
    private int[] fGD = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean fGG = false;
    private boolean fGI = true;
    private boolean mIsAnimating = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (d.this.fGF != null && d.this.fGF.fCx != null && d.this.fFP != null) {
                    d.this.fFP.a(d.this.fGF);
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
        this.fGt = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.fGu = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.fGv = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.fGw = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.fGx = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.fGy = (HeadImageView) this.mRootView.findViewById(R.id.ivUserAvatar);
        this.fGy.setIsRound(true);
        this.fGy.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.fGt.setBorderSurroundContent(true);
        this.fGt.setDrawBorder(true);
        this.fGt.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fGv.getLayoutParams();
        layoutParams.width = ((com.baidu.adp.lib.util.l.getEquipmentWidth(tbPageContext.getPageActivity()) - tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12)) - (tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 2;
        layoutParams.height = layoutParams.width;
        this.fGv.setLayoutParams(layoutParams);
        this.fGH = new AlphaAnimation(0.0f, 1.0f);
        this.fGH.setDuration(200L);
        this.fGH.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.1
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
        this.fFP = oVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        a(cVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.c cVar, int i) {
        if (cVar == null || cVar.fCx == null || cVar.fCx.beY() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.fGF = cVar;
        this.fCx = cVar.fCx;
        this.tabId = cVar.tabId;
        this.fGE = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        Object tag = this.fGt.getTag();
        if (this.fGI) {
            this.fGG = true;
            this.fGI = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.fCx.beY().cover) && !((String) tag).equals(this.fCx.beY().cover)) {
            this.fGG = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.fCx.beY().cover) && !this.mCoverUrl.equals(this.fCx.beY().cover)) {
            this.fGG = true;
        } else {
            this.fGG = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.fGD);
        this.mCoverUrl = this.fCx.beY().cover;
        this.fGt.setTag(this.mCoverUrl);
        if (cVar.isLeft) {
            this.fGt.setConrers(5);
            gradientDrawable.setCornerRadii(fGB);
            this.fGt.setDefaultBgResource(R.drawable.tab_live_card_round_bg_left);
        } else if (cVar.isRight) {
            this.fGt.setConrers(10);
            gradientDrawable.setCornerRadii(fGC);
            this.fGt.setDefaultBgResource(R.drawable.tab_live_card_round_bg_right);
        } else if (cVar.fCv) {
            this.fGt.setConrers(15);
            gradientDrawable.setCornerRadii(fGA);
            this.fGt.setDefaultBgResource(R.drawable.tab_live_card_round_bg_only_left);
        }
        this.fGt.setRadius((int) fGz);
        this.fGt.startLoad(this.fCx.beY().cover, 10, false);
        this.fGx.setBackgroundDrawable(gradientDrawable);
        this.fGt.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && d.this.fGG && !d.this.mIsAnimating) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        d.this.fGt.startAnimation(d.this.fGH);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fGu.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.live_tab_audience_label, at.cP(this.fCx.beY().audience_count)));
        if (this.fCx.beE() != null) {
            String name_show = this.fCx.beE().getName_show();
            if (!StringUtils.isNull(name_show)) {
                this.fGw.setText(name_show);
            }
            this.fGy.startLoad(this.fCx.beE().getPortrait(), 12, false);
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.fGu, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.fGw, (int) R.color.cp_cont_a);
            if (i == 1) {
                this.fGy.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c_1));
            } else {
                this.fGy.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c));
            }
            Drawable drawable = ap.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.fGu.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.fGu.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
