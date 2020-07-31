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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b {
    public TextView fAa;
    public TextView fAb;
    public LinearLayout fAc;
    private bv frb;
    public TbImageView fva;
    public TextView fvb;
    public RelativeLayout fvc;
    public TextView fvd;
    private String fvl;
    private AlphaAnimation fvo;
    public ImageView fxc;
    private com.baidu.tieba.ala.alasquare.subtablist.c.i fyJ;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private boolean fvn = false;
    private boolean fvp = true;
    private boolean fvq = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private int fAd = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (b.this.frb != null && b.this.frb.aWF() != null && b.this.fyJ != null) {
                    b.this.fyJ.a(b.this.tabId, b.this.fvl, b.this.frb);
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
        this.fva = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.fAa = (TextView) this.mRootView.findViewById(R.id.tvLiveFrom);
        this.fvb = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.fvc = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.fvd = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.fAb = (TextView) this.mRootView.findViewById(R.id.tv_extra);
        this.fAc = (LinearLayout) this.mRootView.findViewById(R.id.challenge_root);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.fva.setBorderSurroundContent(true);
        this.fva.setDrawBorder(true);
        this.fxc = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.fvo = new AlphaAnimation(0.0f, 1.0f);
        this.fvo.setDuration(200L);
        this.fvo.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                b.this.fvq = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                b.this.fvq = false;
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
        this.fyJ = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        a(cVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.c cVar, int i) {
        if (cVar == null || cVar.frb == null || cVar.frb.aWF() == null) {
            getView().setVisibility(4);
            return;
        }
        if (this.fAd != l.getEquipmentWidth(this.mRootView.getContext())) {
            this.fAd = l.getEquipmentWidth(this.mRootView.getContext());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fvc.getLayoutParams();
            layoutParams.width = (this.fAd - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
            layoutParams.height = layoutParams.width;
            this.fvc.setLayoutParams(layoutParams);
        }
        getView().setVisibility(0);
        this.frb = cVar.frb;
        this.tabId = cVar.tabId;
        this.fvl = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        Object tag = this.fva.getTag();
        if (this.fvp) {
            this.fvn = true;
            this.fvp = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.frb.aWF().cover) && !((String) tag).equals(this.frb.aWF().cover)) {
            this.fvn = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.frb.aWF().cover) && !this.mCoverUrl.equals(this.frb.aWF().cover)) {
            this.fvn = true;
        } else {
            this.fvn = false;
        }
        this.mCoverUrl = this.frb.aWF().cover;
        this.fva.setTag(this.mCoverUrl);
        this.fva.startLoad(this.frb.aWF().cover, 10, false);
        this.fva.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && b.this.fvn && !b.this.fvq) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        b.this.fva.startAnimation(b.this.fvo);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fvb.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, as.numberUniformFormatExtra(this.frb.aWF().audience_count)));
        if (this.frb.aWl() != null) {
            String name_show = this.frb.aWl().getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ae.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.fvd.setText(name_show);
        }
        if (!StringUtils.isNull(this.frb.mRecomExtra)) {
            this.fAb.setVisibility(0);
            this.fAc.setVisibility(8);
            this.fAb.setText(this.frb.mRecomExtra);
            GradientDrawable gradientDrawable = new GradientDrawable();
            float dimensionPixelSize = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize, dimensionPixelSize, 0.0f, 0.0f});
            gradientDrawable.setColor(-50901);
            this.fAb.setBackgroundDrawable(gradientDrawable);
        } else if (this.frb.aWF().label != null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            float dimensionPixelSize2 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize2, dimensionPixelSize2, 0.0f, 0.0f});
            if (!StringUtils.isNull(this.frb.aWF().label.labelColor)) {
                gradientDrawable2.setColor(Color.parseColor(this.frb.aWF().label.labelColor));
            }
            this.fAb.setBackgroundDrawable(gradientDrawable2);
            this.fAb.setText(this.frb.aWF().label.labelName);
            this.fAb.setVisibility(0);
            this.fAc.setVisibility(8);
        } else if (this.frb.aWF().mChallengeInfoData != null && this.frb.aWF().mChallengeInfoData.challenge_id > 0) {
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            float dimensionPixelSize3 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable3.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize3, dimensionPixelSize3, 0.0f, 0.0f});
            gradientDrawable3.setColor(-50901);
            this.fAc.setBackground(gradientDrawable3);
            this.fAc.setVisibility(0);
            this.fAb.setVisibility(8);
        } else {
            this.fAb.setVisibility(8);
            this.fAc.setVisibility(8);
        }
        if (this.frb.aWF().haveRedpkg) {
            this.fxc.setVisibility(0);
        } else {
            this.fxc.setVisibility(8);
        }
        if (this.frb != null) {
            if (i == 2) {
                TiebaStatic.log(new ap("c12899").dn("tid", this.frb.getTid()));
            } else if (i == 1) {
                TiebaStatic.log(new ap("c12903").dn("tid", this.frb.getTid()));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.fvc, R.drawable.addresslist_item_bg);
            ao.setViewTextColor(this.fvb, R.color.cp_cont_a);
            ao.setViewTextColor(this.fvd, R.color.cp_cont_a);
            ao.setViewTextColor(this.fAb, R.color.cp_cont_g, 1, 0);
            ao.getDrawable(this.mTbPageContext.getResources(), R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14));
            this.fvb.setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(this.mTbPageContext.getResources(), R.drawable.icon_video_direct_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
            this.mSkinType = i;
        }
    }
}
