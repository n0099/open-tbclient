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
    private bw fRW;
    public TbImageView fWa;
    public TextView fWb;
    public RelativeLayout fWc;
    public TextView fWd;
    private String fWl;
    private AlphaAnimation fWo;
    public ImageView fYe;
    private com.baidu.tieba.ala.alasquare.subtablist.c.i fZK;
    public TextView gbc;
    public TextView gbd;
    public LinearLayout gbe;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private boolean fWn = false;
    private boolean fWp = true;
    private boolean mIsAnimating = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private int gbf = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (b.this.fRW != null && b.this.fRW.biB() != null && b.this.fZK != null) {
                    b.this.fZK.a(b.this.tabId, b.this.fWl, b.this.fRW);
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
        this.fWa = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.gbc = (TextView) this.mRootView.findViewById(R.id.tvLiveFrom);
        this.fWb = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.fWc = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.fWd = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.gbd = (TextView) this.mRootView.findViewById(R.id.tv_extra);
        this.gbe = (LinearLayout) this.mRootView.findViewById(R.id.challenge_root);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.fWa.setBorderSurroundContent(true);
        this.fWa.setDrawBorder(true);
        this.fYe = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.fWo = new AlphaAnimation(0.0f, 1.0f);
        this.fWo.setDuration(200L);
        this.fWo.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.1
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
        this.fZK = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        a(cVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.c cVar, int i) {
        if (cVar == null || cVar.fRW == null || cVar.fRW.biB() == null) {
            getView().setVisibility(4);
            return;
        }
        if (this.gbf != l.getEquipmentWidth(this.mRootView.getContext())) {
            this.gbf = l.getEquipmentWidth(this.mRootView.getContext());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fWc.getLayoutParams();
            layoutParams.width = (this.gbf - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
            layoutParams.height = layoutParams.width;
            this.fWc.setLayoutParams(layoutParams);
        }
        getView().setVisibility(0);
        this.fRW = cVar.fRW;
        this.tabId = cVar.tabId;
        this.fWl = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        Object tag = this.fWa.getTag();
        if (this.fWp) {
            this.fWn = true;
            this.fWp = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.fRW.biB().cover) && !((String) tag).equals(this.fRW.biB().cover)) {
            this.fWn = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.fRW.biB().cover) && !this.mCoverUrl.equals(this.fRW.biB().cover)) {
            this.fWn = true;
        } else {
            this.fWn = false;
        }
        this.mCoverUrl = this.fRW.biB().cover;
        this.fWa.setTag(this.mCoverUrl);
        this.fWa.startLoad(this.fRW.biB().cover, 10, false);
        this.fWa.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && b.this.fWn && !b.this.mIsAnimating) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        b.this.fWa.startAnimation(b.this.fWo);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fWb.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, at.numberUniformFormatExtra(this.fRW.biB().audience_count)));
        if (this.fRW.bih() != null) {
            String name_show = this.fRW.bih().getName_show();
            if (af.getTextLengthWithEmoji(name_show) > 10) {
                name_show = af.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.fWd.setText(name_show);
        }
        if (!StringUtils.isNull(this.fRW.mRecomExtra)) {
            this.gbd.setVisibility(0);
            this.gbe.setVisibility(8);
            this.gbd.setText(this.fRW.mRecomExtra);
            GradientDrawable gradientDrawable = new GradientDrawable();
            float dimensionPixelSize = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize, dimensionPixelSize, 0.0f, 0.0f});
            gradientDrawable.setColor(-50901);
            this.gbd.setBackgroundDrawable(gradientDrawable);
        } else if (this.fRW.biB().label != null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            float dimensionPixelSize2 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize2, dimensionPixelSize2, 0.0f, 0.0f});
            if (!StringUtils.isNull(this.fRW.biB().label.labelColor)) {
                gradientDrawable2.setColor(Color.parseColor(this.fRW.biB().label.labelColor));
            }
            this.gbd.setBackgroundDrawable(gradientDrawable2);
            this.gbd.setText(this.fRW.biB().label.labelName);
            this.gbd.setVisibility(0);
            this.gbe.setVisibility(8);
        } else if (this.fRW.biB().mChallengeInfoData != null && this.fRW.biB().mChallengeInfoData.challenge_id > 0) {
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            float dimensionPixelSize3 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable3.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize3, dimensionPixelSize3, 0.0f, 0.0f});
            gradientDrawable3.setColor(-50901);
            this.gbe.setBackground(gradientDrawable3);
            this.gbe.setVisibility(0);
            this.gbd.setVisibility(8);
        } else {
            this.gbd.setVisibility(8);
            this.gbe.setVisibility(8);
        }
        if (this.fRW.biB().haveRedpkg) {
            this.fYe.setVisibility(0);
        } else {
            this.fYe.setVisibility(8);
        }
        if (this.fRW != null) {
            if (i == 2) {
                TiebaStatic.log(new aq("c12899").dK("tid", this.fRW.getTid()));
            } else if (i == 1) {
                TiebaStatic.log(new aq("c12903").dK("tid", this.fRW.getTid()));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.fWc, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.fWb, R.color.cp_cont_a);
            ap.setViewTextColor(this.fWd, R.color.cp_cont_a);
            ap.setViewTextColor(this.gbd, R.color.cp_cont_g, 1, 0);
            ap.getDrawable(this.mTbPageContext.getResources(), R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14));
            this.fWb.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(this.mTbPageContext.getResources(), R.drawable.icon_video_direct_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
            this.mSkinType = i;
        }
    }
}
