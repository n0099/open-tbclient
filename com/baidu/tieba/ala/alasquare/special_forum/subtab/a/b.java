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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b {
    private bj ejI;
    public TbImageView enE;
    public TextView enF;
    public RelativeLayout enG;
    public TextView enH;
    private String enP;
    private AlphaAnimation enS;
    public ImageView epB;
    private com.baidu.tieba.ala.alasquare.subtablist.c.i eri;
    public TextView esA;
    public TextView esB;
    public LinearLayout esC;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private boolean enR = false;
    private boolean enT = true;
    private boolean enU = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private int esD = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (b.this.ejI != null && b.this.ejI.aCF() != null && b.this.eri != null) {
                    b.this.eri.a(b.this.tabId, b.this.enP, b.this.ejI);
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
        this.enE = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.esA = (TextView) this.mRootView.findViewById(R.id.tvLiveFrom);
        this.enF = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.enG = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.enH = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.esB = (TextView) this.mRootView.findViewById(R.id.tv_extra);
        this.esC = (LinearLayout) this.mRootView.findViewById(R.id.challenge_root);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.enE.setBorderSurroundContent(true);
        this.enE.setDrawBorder(true);
        this.epB = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.enS = new AlphaAnimation(0.0f, 1.0f);
        this.enS.setDuration(200L);
        this.enS.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                b.this.enU = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                b.this.enU = false;
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
        this.eri = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        a(cVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.c cVar, int i) {
        if (cVar == null || cVar.ejI == null || cVar.ejI.aCF() == null) {
            getView().setVisibility(4);
            return;
        }
        if (this.esD != l.getEquipmentWidth(this.mRootView.getContext())) {
            this.esD = l.getEquipmentWidth(this.mRootView.getContext());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.enG.getLayoutParams();
            layoutParams.width = (this.esD - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
            layoutParams.height = layoutParams.width;
            this.enG.setLayoutParams(layoutParams);
        }
        getView().setVisibility(0);
        this.ejI = cVar.ejI;
        this.tabId = cVar.tabId;
        this.enP = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        Object tag = this.enE.getTag();
        if (this.enT) {
            this.enR = true;
            this.enT = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.ejI.aCF().cover) && !((String) tag).equals(this.ejI.aCF().cover)) {
            this.enR = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.ejI.aCF().cover) && !this.mCoverUrl.equals(this.ejI.aCF().cover)) {
            this.enR = true;
        } else {
            this.enR = false;
        }
        this.mCoverUrl = this.ejI.aCF().cover;
        this.enE.setTag(this.mCoverUrl);
        this.enE.startLoad(this.ejI.aCF().cover, 10, false);
        this.enE.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && b.this.enR && !b.this.enU) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        b.this.enE.startAnimation(b.this.enS);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.enF.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.numberUniformFormatExtra(this.ejI.aCF().audience_count)));
        if (this.ejI.aCm() != null) {
            String name_show = this.ejI.aCm().getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.enH.setText(name_show);
        }
        if (!StringUtils.isNull(this.ejI.mRecomExtra)) {
            this.esB.setVisibility(0);
            this.esC.setVisibility(8);
            this.esB.setText(this.ejI.mRecomExtra);
            GradientDrawable gradientDrawable = new GradientDrawable();
            float dimensionPixelSize = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize, dimensionPixelSize, 0.0f, 0.0f});
            gradientDrawable.setColor(-50901);
            this.esB.setBackgroundDrawable(gradientDrawable);
        } else if (this.ejI.aCF().label != null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            float dimensionPixelSize2 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize2, dimensionPixelSize2, 0.0f, 0.0f});
            if (!StringUtils.isNull(this.ejI.aCF().label.labelColor)) {
                gradientDrawable2.setColor(Color.parseColor(this.ejI.aCF().label.labelColor));
            }
            this.esB.setBackgroundDrawable(gradientDrawable2);
            this.esB.setText(this.ejI.aCF().label.labelName);
            this.esB.setVisibility(0);
            this.esC.setVisibility(8);
        } else if (this.ejI.aCF().mChallengeInfoData != null && this.ejI.aCF().mChallengeInfoData.challenge_id > 0) {
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            float dimensionPixelSize3 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable3.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize3, dimensionPixelSize3, 0.0f, 0.0f});
            gradientDrawable3.setColor(-50901);
            this.esC.setBackground(gradientDrawable3);
            this.esC.setVisibility(0);
            this.esB.setVisibility(8);
        } else {
            this.esB.setVisibility(8);
            this.esC.setVisibility(8);
        }
        if (this.ejI.aCF().haveRedpkg) {
            this.epB.setVisibility(0);
        } else {
            this.epB.setVisibility(8);
        }
        if (this.ejI != null) {
            if (i == 2) {
                TiebaStatic.log(new an("c12899").cy("tid", this.ejI.getTid()));
            } else if (i == 1) {
                TiebaStatic.log(new an("c12903").cy("tid", this.ejI.getTid()));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.enG, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.enF, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.enH, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.esB, R.color.cp_cont_g, 1, 0);
            am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14));
            this.enF.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.icon_video_direct_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
            this.mSkinType = i;
        }
    }
}
