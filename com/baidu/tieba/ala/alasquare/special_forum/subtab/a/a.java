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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.subtablist.c.h;
/* loaded from: classes2.dex */
public class a {
    private bj eft;
    public TbImageView eiG;
    public TextView eiH;
    public RelativeLayout eiI;
    public TextView eiJ;
    private String eiR;
    private AlphaAnimation eiU;
    public ImageView ekv;
    private h elY;
    public TextView enc;
    public TextView ene;
    public LinearLayout enf;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private boolean eiT = false;
    private boolean eiV = true;
    private boolean eiW = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private int eng = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (a.this.eft != null && a.this.eft.azX() != null && a.this.elY != null) {
                    a.this.elY.a(a.this.tabId, a.this.eiR, a.this.eft);
                    return;
                }
                return;
            }
            l.showLongToast(a.this.mTbPageContext.getPageActivity(), a.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        }
    };

    public a(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_special_live_item_view, (ViewGroup) null, false);
        this.eiG = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.enc = (TextView) this.mRootView.findViewById(R.id.tvLiveFrom);
        this.eiH = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.eiI = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.eiJ = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.ene = (TextView) this.mRootView.findViewById(R.id.tv_extra);
        this.enf = (LinearLayout) this.mRootView.findViewById(R.id.challenge_root);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.eiG.setBorderSurroundContent(true);
        this.eiG.setDrawBorder(true);
        this.ekv = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.eiU = new AlphaAnimation(0.0f, 1.0f);
        this.eiU.setDuration(200L);
        this.eiU.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.a.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                a.this.eiW = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                a.this.eiW = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public View getView() {
        return this.mRootView;
    }

    public void c(h hVar) {
        this.elY = hVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.b bVar) {
        a(bVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.b bVar, int i) {
        if (bVar == null || bVar.eft == null || bVar.eft.azX() == null) {
            getView().setVisibility(4);
            return;
        }
        if (this.eng != l.getEquipmentWidth(this.mRootView.getContext())) {
            this.eng = l.getEquipmentWidth(this.mRootView.getContext());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eiI.getLayoutParams();
            layoutParams.width = (this.eng - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
            layoutParams.height = layoutParams.width;
            this.eiI.setLayoutParams(layoutParams);
        }
        getView().setVisibility(0);
        this.eft = bVar.eft;
        this.tabId = bVar.tabId;
        this.eiR = !TextUtils.isEmpty(bVar.labelName) ? bVar.labelName : bVar.entryName;
        Object tag = this.eiG.getTag();
        if (this.eiV) {
            this.eiT = true;
            this.eiV = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.eft.azX().cover) && !((String) tag).equals(this.eft.azX().cover)) {
            this.eiT = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.eft.azX().cover) && !this.mCoverUrl.equals(this.eft.azX().cover)) {
            this.eiT = true;
        } else {
            this.eiT = false;
        }
        this.mCoverUrl = this.eft.azX().cover;
        this.eiG.setTag(this.mCoverUrl);
        this.eiG.startLoad(this.eft.azX().cover, 10, false);
        this.eiG.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.a.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && a.this.eiT && !a.this.eiW) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        a.this.eiG.startAnimation(a.this.eiU);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.eiH.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.numberUniformFormatExtra(this.eft.azX().audience_count)));
        if (this.eft.azE() != null) {
            String name_show = this.eft.azE().getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.eiJ.setText(name_show);
        }
        if (!StringUtils.isNull(this.eft.mRecomExtra)) {
            this.ene.setVisibility(0);
            this.enf.setVisibility(8);
            this.ene.setText(this.eft.mRecomExtra);
            GradientDrawable gradientDrawable = new GradientDrawable();
            float dimensionPixelSize = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize, dimensionPixelSize, 0.0f, 0.0f});
            gradientDrawable.setColor(-50901);
            this.ene.setBackgroundDrawable(gradientDrawable);
        } else if (this.eft.azX().label != null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            float dimensionPixelSize2 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize2, dimensionPixelSize2, 0.0f, 0.0f});
            if (!StringUtils.isNull(this.eft.azX().label.labelColor)) {
                gradientDrawable2.setColor(Color.parseColor(this.eft.azX().label.labelColor));
            }
            this.ene.setBackgroundDrawable(gradientDrawable2);
            this.ene.setText(this.eft.azX().label.labelName);
            this.ene.setVisibility(0);
            this.enf.setVisibility(8);
        } else if (this.eft.azX().mChallengeInfoData != null && this.eft.azX().mChallengeInfoData.challenge_id > 0) {
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            float dimensionPixelSize3 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable3.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize3, dimensionPixelSize3, 0.0f, 0.0f});
            gradientDrawable3.setColor(-50901);
            this.enf.setBackground(gradientDrawable3);
            this.enf.setVisibility(0);
            this.ene.setVisibility(8);
        } else {
            this.ene.setVisibility(8);
            this.enf.setVisibility(8);
        }
        if (this.eft.azX().haveRedpkg) {
            this.ekv.setVisibility(0);
        } else {
            this.ekv.setVisibility(8);
        }
        if (this.eft != null) {
            if (i == 2) {
                TiebaStatic.log(new an("c12899").cp("tid", this.eft.getTid()));
            } else if (i == 1) {
                TiebaStatic.log(new an("c12903").cp("tid", this.eft.getTid()));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eiI, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.eiH, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eiJ, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.ene, R.color.cp_cont_g, 1, 0);
            am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14));
            this.eiH.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.icon_video_direct_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
            this.mSkinType = i;
        }
    }
}
