package com.baidu.tieba.ala.alasquare.special_forum.subtab.a;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b {
    private bw fCx;
    private String fGE;
    private AlphaAnimation fGH;
    public TbImageView fGt;
    public TextView fGu;
    public RelativeLayout fGv;
    public TextView fGw;
    public ImageView fIu;
    private com.baidu.tieba.ala.alasquare.subtablist.c.i fKb;
    public TextView fLs;
    public TextView fLt;
    public LinearLayout fLu;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private boolean fGG = false;
    private boolean fGI = true;
    private boolean mIsAnimating = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private int fLv = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (b.this.fCx != null && b.this.fCx.beY() != null && b.this.fKb != null) {
                    b.this.fKb.a(b.this.tabId, b.this.fGE, b.this.fCx);
                    return;
                }
                return;
            }
            l.showLongToast(b.this.mTbPageContext.getPageActivity(), b.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        }
    };

    public b(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_special_live_item_view, (ViewGroup) null, false);
        this.fGt = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.fLs = (TextView) this.mRootView.findViewById(R.id.tvLiveFrom);
        this.fGu = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.fGv = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.fGw = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.fLt = (TextView) this.mRootView.findViewById(R.id.tv_extra);
        this.fLu = (LinearLayout) this.mRootView.findViewById(R.id.challenge_root);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.fGt.setBorderSurroundContent(true);
        this.fGt.setDrawBorder(true);
        this.fIu = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.fGH = new AlphaAnimation(0.0f, 1.0f);
        this.fGH.setDuration(200L);
        this.fGH.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                b.this.mIsAnimating = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                b.this.mIsAnimating = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public View getView() {
        return this.mRootView;
    }

    public void c(com.baidu.tieba.ala.alasquare.subtablist.c.i iVar) {
        this.fKb = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        a(cVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.c cVar, int i) {
        if (cVar == null || cVar.fCx == null || cVar.fCx.beY() == null) {
            getView().setVisibility(4);
            return;
        }
        if (this.fLv != l.getEquipmentWidth(this.mRootView.getContext())) {
            this.fLv = l.getEquipmentWidth(this.mRootView.getContext());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fGv.getLayoutParams();
            layoutParams.width = (this.fLv - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
            layoutParams.height = layoutParams.width;
            this.fGv.setLayoutParams(layoutParams);
        }
        getView().setVisibility(0);
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
        this.mCoverUrl = this.fCx.beY().cover;
        this.fGt.setTag(this.mCoverUrl);
        this.fGt.startLoad(this.fCx.beY().cover, 10, false);
        this.fGt.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && b.this.fGG && !b.this.mIsAnimating) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        b.this.fGt.startAnimation(b.this.fGH);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fGu.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, at.numberUniformFormatExtra(this.fCx.beY().audience_count)));
        if (this.fCx.beE() != null) {
            String name_show = this.fCx.beE().getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ae.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.fGw.setText(name_show);
        }
        if (!StringUtils.isNull(this.fCx.mRecomExtra)) {
            this.fLt.setVisibility(0);
            this.fLu.setVisibility(8);
            this.fLt.setText(this.fCx.mRecomExtra);
            GradientDrawable gradientDrawable = new GradientDrawable();
            float dimensionPixelSize = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize, dimensionPixelSize, 0.0f, 0.0f});
            gradientDrawable.setColor(-50901);
            this.fLt.setBackgroundDrawable(gradientDrawable);
        } else if (this.fCx.beY().label != null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            float dimensionPixelSize2 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize2, dimensionPixelSize2, 0.0f, 0.0f});
            if (!StringUtils.isNull(this.fCx.beY().label.labelColor)) {
                gradientDrawable2.setColor(Color.parseColor(this.fCx.beY().label.labelColor));
            }
            this.fLt.setBackgroundDrawable(gradientDrawable2);
            this.fLt.setText(this.fCx.beY().label.labelName);
            this.fLt.setVisibility(0);
            this.fLu.setVisibility(8);
        } else if (this.fCx.beY().mChallengeInfoData != null && this.fCx.beY().mChallengeInfoData.challenge_id > 0) {
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            float dimensionPixelSize3 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable3.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize3, dimensionPixelSize3, 0.0f, 0.0f});
            gradientDrawable3.setColor(-50901);
            this.fLu.setBackground(gradientDrawable3);
            this.fLu.setVisibility(0);
            this.fLt.setVisibility(8);
        } else {
            this.fLt.setVisibility(8);
            this.fLu.setVisibility(8);
        }
        if (this.fCx.beY().haveRedpkg) {
            this.fIu.setVisibility(0);
        } else {
            this.fIu.setVisibility(8);
        }
        if (this.fCx != null) {
            if (i == 2) {
                TiebaStatic.log(new aq("c12899").dD("tid", this.fCx.getTid()));
            } else if (i == 1) {
                TiebaStatic.log(new aq("c12903").dD("tid", this.fCx.getTid()));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.fGv, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.fGu, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.fGw, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.fLt, R.color.cp_cont_g, 1, 0);
            ap.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14));
            this.fGu.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.icon_video_direct_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
            this.mSkinType = i;
        }
    }
}
