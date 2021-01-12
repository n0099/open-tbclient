package com.baidu.tieba.ala.alasquare.special_forum.subtab.view;

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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.a.e;
import com.baidu.tieba.ala.alasquare.subtablist.view.g;
/* loaded from: classes9.dex */
public class b {
    public TextView bAH;
    public TbImageView gAd;
    public TextView gAe;
    public RelativeLayout gAf;
    private String gAn;
    private AlphaAnimation gAq;
    public ImageView gCh;
    private g gDR;
    public TextView gFi;
    public TextView gFj;
    public LinearLayout gFk;
    private bz gvQ;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private boolean gAp = false;
    private boolean gAr = true;
    private boolean gAs = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private int gFl = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.view.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (b.this.gvQ != null && b.this.gvQ.bnQ() != null && b.this.gDR != null) {
                    b.this.gDR.a(b.this.tabId, b.this.gAn, b.this.gvQ);
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
        this.gAd = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.gFi = (TextView) this.mRootView.findViewById(R.id.tvLiveFrom);
        this.gAe = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.gAf = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.bAH = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.gFj = (TextView) this.mRootView.findViewById(R.id.tv_extra);
        this.gFk = (LinearLayout) this.mRootView.findViewById(R.id.challenge_root);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.gAd.setBorderSurroundContent(true);
        this.gAd.setDrawBorder(true);
        this.gCh = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.gAq = new AlphaAnimation(0.0f, 1.0f);
        this.gAq.setDuration(200L);
        this.gAq.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.view.b.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                b.this.gAs = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                b.this.gAs = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public View getView() {
        return this.mRootView;
    }

    public void c(g gVar) {
        this.gDR = gVar;
    }

    public void b(e eVar) {
        a(eVar, -1);
    }

    public void a(e eVar, int i) {
        if (eVar == null || eVar.gvQ == null || eVar.gvQ.bnQ() == null) {
            getView().setVisibility(4);
            return;
        }
        if (this.gFl != l.getEquipmentWidth(this.mRootView.getContext())) {
            this.gFl = l.getEquipmentWidth(this.mRootView.getContext());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gAf.getLayoutParams();
            layoutParams.width = (this.gFl - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
            layoutParams.height = layoutParams.width;
            this.gAf.setLayoutParams(layoutParams);
        }
        getView().setVisibility(0);
        this.gvQ = eVar.gvQ;
        this.tabId = eVar.tabId;
        this.gAn = !TextUtils.isEmpty(eVar.labelName) ? eVar.labelName : eVar.entryName;
        Object tag = this.gAd.getTag();
        if (this.gAr) {
            this.gAp = true;
            this.gAr = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.gvQ.bnQ().cover) && !((String) tag).equals(this.gvQ.bnQ().cover)) {
            this.gAp = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.gvQ.bnQ().cover) && !this.mCoverUrl.equals(this.gvQ.bnQ().cover)) {
            this.gAp = true;
        } else {
            this.gAp = false;
        }
        this.mCoverUrl = this.gvQ.bnQ().cover;
        this.gAd.setTag(this.mCoverUrl);
        this.gAd.startLoad(this.gvQ.bnQ().cover, 10, false);
        this.gAd.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.view.b.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z && b.this.gAp && !b.this.gAs) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        b.this.gAd.startAnimation(b.this.gAq);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        });
        this.gAe.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, at.numberUniformFormatExtra(this.gvQ.bnQ().audience_count)));
        if (this.gvQ.bnx() != null) {
            String name_show = this.gvQ.bnx().getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.bAH.setText(name_show);
        }
        if (!StringUtils.isNull(this.gvQ.mRecomExtra)) {
            this.gFj.setVisibility(0);
            this.gFk.setVisibility(8);
            this.gFj.setText(this.gvQ.mRecomExtra);
            GradientDrawable gradientDrawable = new GradientDrawable();
            float dimensionPixelSize = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize, dimensionPixelSize, 0.0f, 0.0f});
            gradientDrawable.setColor(-50901);
            this.gFj.setBackgroundDrawable(gradientDrawable);
        } else if (this.gvQ.bnQ().label != null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            float dimensionPixelSize2 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize2, dimensionPixelSize2, 0.0f, 0.0f});
            if (!StringUtils.isNull(this.gvQ.bnQ().label.labelColor)) {
                gradientDrawable2.setColor(Color.parseColor(this.gvQ.bnQ().label.labelColor));
            }
            this.gFj.setBackgroundDrawable(gradientDrawable2);
            this.gFj.setText(this.gvQ.bnQ().label.labelName);
            this.gFj.setVisibility(0);
            this.gFk.setVisibility(8);
        } else if (this.gvQ.bnQ().mChallengeInfoData != null && this.gvQ.bnQ().mChallengeInfoData.challenge_id > 0) {
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            float dimensionPixelSize3 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable3.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize3, dimensionPixelSize3, 0.0f, 0.0f});
            gradientDrawable3.setColor(-50901);
            this.gFk.setBackground(gradientDrawable3);
            this.gFk.setVisibility(0);
            this.gFj.setVisibility(8);
        } else {
            this.gFj.setVisibility(8);
            this.gFk.setVisibility(8);
        }
        if (this.gvQ.bnQ().haveRedpkg) {
            this.gCh.setVisibility(0);
        } else {
            this.gCh.setVisibility(8);
        }
        if (this.gvQ != null) {
            if (i == 2) {
                TiebaStatic.log(new aq("c12899").dW("tid", this.gvQ.getTid()));
            } else if (i == 1) {
                TiebaStatic.log(new aq("c12903").dW("tid", this.gvQ.getTid()));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.gAf, R.drawable.addresslist_item_bg);
            ao.setViewTextColor(this.gAe, R.color.CAM_X0101);
            ao.setViewTextColor(this.bAH, R.color.CAM_X0101);
            ao.setViewTextColor(this.gFj, R.color.CAM_X0111, 1, 0);
            ao.getDrawable(this.mTbPageContext.getResources(), R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14));
            this.gAe.setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(this.mTbPageContext.getResources(), R.drawable.icon_video_direct_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
            this.mSkinType = i;
        }
    }
}
