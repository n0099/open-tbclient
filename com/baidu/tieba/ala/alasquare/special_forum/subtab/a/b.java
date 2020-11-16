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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b {
    public TextView bvw;
    private bx ghv;
    public TbImageView glA;
    public TextView glB;
    public RelativeLayout glC;
    private String glK;
    private AlphaAnimation glN;
    public ImageView gnD;
    private com.baidu.tieba.ala.alasquare.subtablist.c.i gpj;
    public TextView gqA;
    public TextView gqB;
    public LinearLayout gqC;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private boolean glM = false;
    private boolean glO = true;
    private boolean mIsAnimating = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private int gqD = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (b.this.ghv != null && b.this.ghv.blW() != null && b.this.gpj != null) {
                    b.this.gpj.a(b.this.tabId, b.this.glK, b.this.ghv);
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
        this.glA = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.gqA = (TextView) this.mRootView.findViewById(R.id.tvLiveFrom);
        this.glB = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.glC = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.bvw = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.gqB = (TextView) this.mRootView.findViewById(R.id.tv_extra);
        this.gqC = (LinearLayout) this.mRootView.findViewById(R.id.challenge_root);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.glA.setBorderSurroundContent(true);
        this.glA.setDrawBorder(true);
        this.gnD = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.glN = new AlphaAnimation(0.0f, 1.0f);
        this.glN.setDuration(200L);
        this.glN.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.1
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
        this.gpj = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        a(cVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.c cVar, int i) {
        if (cVar == null || cVar.ghv == null || cVar.ghv.blW() == null) {
            getView().setVisibility(4);
            return;
        }
        if (this.gqD != l.getEquipmentWidth(this.mRootView.getContext())) {
            this.gqD = l.getEquipmentWidth(this.mRootView.getContext());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.glC.getLayoutParams();
            layoutParams.width = (this.gqD - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
            layoutParams.height = layoutParams.width;
            this.glC.setLayoutParams(layoutParams);
        }
        getView().setVisibility(0);
        this.ghv = cVar.ghv;
        this.tabId = cVar.tabId;
        this.glK = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        Object tag = this.glA.getTag();
        if (this.glO) {
            this.glM = true;
            this.glO = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.ghv.blW().cover) && !((String) tag).equals(this.ghv.blW().cover)) {
            this.glM = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.ghv.blW().cover) && !this.mCoverUrl.equals(this.ghv.blW().cover)) {
            this.glM = true;
        } else {
            this.glM = false;
        }
        this.mCoverUrl = this.ghv.blW().cover;
        this.glA.setTag(this.mCoverUrl);
        this.glA.startLoad(this.ghv.blW().cover, 10, false);
        this.glA.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && b.this.glM && !b.this.mIsAnimating) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        b.this.glA.startAnimation(b.this.glN);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.glB.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, au.numberUniformFormatExtra(this.ghv.blW().audience_count)));
        if (this.ghv.blC() != null) {
            String name_show = this.ghv.blC().getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ae.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.bvw.setText(name_show);
        }
        if (!StringUtils.isNull(this.ghv.mRecomExtra)) {
            this.gqB.setVisibility(0);
            this.gqC.setVisibility(8);
            this.gqB.setText(this.ghv.mRecomExtra);
            GradientDrawable gradientDrawable = new GradientDrawable();
            float dimensionPixelSize = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize, dimensionPixelSize, 0.0f, 0.0f});
            gradientDrawable.setColor(-50901);
            this.gqB.setBackgroundDrawable(gradientDrawable);
        } else if (this.ghv.blW().label != null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            float dimensionPixelSize2 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize2, dimensionPixelSize2, 0.0f, 0.0f});
            if (!StringUtils.isNull(this.ghv.blW().label.labelColor)) {
                gradientDrawable2.setColor(Color.parseColor(this.ghv.blW().label.labelColor));
            }
            this.gqB.setBackgroundDrawable(gradientDrawable2);
            this.gqB.setText(this.ghv.blW().label.labelName);
            this.gqB.setVisibility(0);
            this.gqC.setVisibility(8);
        } else if (this.ghv.blW().mChallengeInfoData != null && this.ghv.blW().mChallengeInfoData.challenge_id > 0) {
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            float dimensionPixelSize3 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable3.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize3, dimensionPixelSize3, 0.0f, 0.0f});
            gradientDrawable3.setColor(-50901);
            this.gqC.setBackground(gradientDrawable3);
            this.gqC.setVisibility(0);
            this.gqB.setVisibility(8);
        } else {
            this.gqB.setVisibility(8);
            this.gqC.setVisibility(8);
        }
        if (this.ghv.blW().haveRedpkg) {
            this.gnD.setVisibility(0);
        } else {
            this.gnD.setVisibility(8);
        }
        if (this.ghv != null) {
            if (i == 2) {
                TiebaStatic.log(new ar("c12899").dR("tid", this.ghv.getTid()));
            } else if (i == 1) {
                TiebaStatic.log(new ar("c12903").dR("tid", this.ghv.getTid()));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.glC, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.glB, R.color.CAM_X0101);
            ap.setViewTextColor(this.bvw, R.color.CAM_X0101);
            ap.setViewTextColor(this.gqB, R.color.CAM_X0111, 1, 0);
            ap.getDrawable(this.mTbPageContext.getResources(), R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14));
            this.glB.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(this.mTbPageContext.getResources(), R.drawable.icon_video_direct_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
            this.mSkinType = i;
        }
    }
}
