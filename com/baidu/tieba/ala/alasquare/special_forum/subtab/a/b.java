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
import com.baidu.tbadk.util.af;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b {
    private bw fFN;
    public TbImageView fJJ;
    public TextView fJK;
    public RelativeLayout fJL;
    public TextView fJM;
    private String fJU;
    private AlphaAnimation fJX;
    public ImageView fLN;
    private com.baidu.tieba.ala.alasquare.subtablist.c.i fNt;
    public TextView fOK;
    public TextView fOL;
    public LinearLayout fOM;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private boolean fJW = false;
    private boolean fJY = true;
    private boolean mIsAnimating = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private int fON = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (b.this.fFN != null && b.this.fFN.bfS() != null && b.this.fNt != null) {
                    b.this.fNt.a(b.this.tabId, b.this.fJU, b.this.fFN);
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
        this.fJJ = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.fOK = (TextView) this.mRootView.findViewById(R.id.tvLiveFrom);
        this.fJK = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.fJL = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.fJM = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.fOL = (TextView) this.mRootView.findViewById(R.id.tv_extra);
        this.fOM = (LinearLayout) this.mRootView.findViewById(R.id.challenge_root);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.fJJ.setBorderSurroundContent(true);
        this.fJJ.setDrawBorder(true);
        this.fLN = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.fJX = new AlphaAnimation(0.0f, 1.0f);
        this.fJX.setDuration(200L);
        this.fJX.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.1
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
        this.fNt = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        a(cVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.c cVar, int i) {
        if (cVar == null || cVar.fFN == null || cVar.fFN.bfS() == null) {
            getView().setVisibility(4);
            return;
        }
        if (this.fON != l.getEquipmentWidth(this.mRootView.getContext())) {
            this.fON = l.getEquipmentWidth(this.mRootView.getContext());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fJL.getLayoutParams();
            layoutParams.width = (this.fON - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
            layoutParams.height = layoutParams.width;
            this.fJL.setLayoutParams(layoutParams);
        }
        getView().setVisibility(0);
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
        this.mCoverUrl = this.fFN.bfS().cover;
        this.fJJ.setTag(this.mCoverUrl);
        this.fJJ.startLoad(this.fFN.bfS().cover, 10, false);
        this.fJJ.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && b.this.fJW && !b.this.mIsAnimating) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        b.this.fJJ.startAnimation(b.this.fJX);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fJK.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, at.numberUniformFormatExtra(this.fFN.bfS().audience_count)));
        if (this.fFN.bfy() != null) {
            String name_show = this.fFN.bfy().getName_show();
            if (af.getTextLengthWithEmoji(name_show) > 10) {
                name_show = af.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.fJM.setText(name_show);
        }
        if (!StringUtils.isNull(this.fFN.mRecomExtra)) {
            this.fOL.setVisibility(0);
            this.fOM.setVisibility(8);
            this.fOL.setText(this.fFN.mRecomExtra);
            GradientDrawable gradientDrawable = new GradientDrawable();
            float dimensionPixelSize = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize, dimensionPixelSize, 0.0f, 0.0f});
            gradientDrawable.setColor(-50901);
            this.fOL.setBackgroundDrawable(gradientDrawable);
        } else if (this.fFN.bfS().label != null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            float dimensionPixelSize2 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize2, dimensionPixelSize2, 0.0f, 0.0f});
            if (!StringUtils.isNull(this.fFN.bfS().label.labelColor)) {
                gradientDrawable2.setColor(Color.parseColor(this.fFN.bfS().label.labelColor));
            }
            this.fOL.setBackgroundDrawable(gradientDrawable2);
            this.fOL.setText(this.fFN.bfS().label.labelName);
            this.fOL.setVisibility(0);
            this.fOM.setVisibility(8);
        } else if (this.fFN.bfS().mChallengeInfoData != null && this.fFN.bfS().mChallengeInfoData.challenge_id > 0) {
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            float dimensionPixelSize3 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable3.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize3, dimensionPixelSize3, 0.0f, 0.0f});
            gradientDrawable3.setColor(-50901);
            this.fOM.setBackground(gradientDrawable3);
            this.fOM.setVisibility(0);
            this.fOL.setVisibility(8);
        } else {
            this.fOL.setVisibility(8);
            this.fOM.setVisibility(8);
        }
        if (this.fFN.bfS().haveRedpkg) {
            this.fLN.setVisibility(0);
        } else {
            this.fLN.setVisibility(8);
        }
        if (this.fFN != null) {
            if (i == 2) {
                TiebaStatic.log(new aq("c12899").dF("tid", this.fFN.getTid()));
            } else if (i == 1) {
                TiebaStatic.log(new aq("c12903").dF("tid", this.fFN.getTid()));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.fJL, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.fJK, R.color.cp_cont_a);
            ap.setViewTextColor(this.fJM, R.color.cp_cont_a);
            ap.setViewTextColor(this.fOL, R.color.cp_cont_g, 1, 0);
            ap.getDrawable(this.mTbPageContext.getResources(), R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14));
            this.fJK.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(this.mTbPageContext.getResources(), R.drawable.icon_video_direct_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
            this.mSkinType = i;
        }
    }
}
