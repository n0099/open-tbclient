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
    private bj ejJ;
    public TbImageView enF;
    public TextView enG;
    public RelativeLayout enH;
    public TextView enI;
    private String enQ;
    private AlphaAnimation enT;
    public ImageView epC;
    private com.baidu.tieba.ala.alasquare.subtablist.c.i erj;
    public TextView esB;
    public TextView esC;
    public LinearLayout esD;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private boolean enS = false;
    private boolean enU = true;
    private boolean enV = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private int esE = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (b.this.ejJ != null && b.this.ejJ.aCH() != null && b.this.erj != null) {
                    b.this.erj.a(b.this.tabId, b.this.enQ, b.this.ejJ);
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
        this.enF = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.esB = (TextView) this.mRootView.findViewById(R.id.tvLiveFrom);
        this.enG = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.enH = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.enI = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.esC = (TextView) this.mRootView.findViewById(R.id.tv_extra);
        this.esD = (LinearLayout) this.mRootView.findViewById(R.id.challenge_root);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.enF.setBorderSurroundContent(true);
        this.enF.setDrawBorder(true);
        this.epC = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.enT = new AlphaAnimation(0.0f, 1.0f);
        this.enT.setDuration(200L);
        this.enT.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                b.this.enV = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                b.this.enV = false;
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
        this.erj = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        a(cVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.c cVar, int i) {
        if (cVar == null || cVar.ejJ == null || cVar.ejJ.aCH() == null) {
            getView().setVisibility(4);
            return;
        }
        if (this.esE != l.getEquipmentWidth(this.mRootView.getContext())) {
            this.esE = l.getEquipmentWidth(this.mRootView.getContext());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.enH.getLayoutParams();
            layoutParams.width = (this.esE - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
            layoutParams.height = layoutParams.width;
            this.enH.setLayoutParams(layoutParams);
        }
        getView().setVisibility(0);
        this.ejJ = cVar.ejJ;
        this.tabId = cVar.tabId;
        this.enQ = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        Object tag = this.enF.getTag();
        if (this.enU) {
            this.enS = true;
            this.enU = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.ejJ.aCH().cover) && !((String) tag).equals(this.ejJ.aCH().cover)) {
            this.enS = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.ejJ.aCH().cover) && !this.mCoverUrl.equals(this.ejJ.aCH().cover)) {
            this.enS = true;
        } else {
            this.enS = false;
        }
        this.mCoverUrl = this.ejJ.aCH().cover;
        this.enF.setTag(this.mCoverUrl);
        this.enF.startLoad(this.ejJ.aCH().cover, 10, false);
        this.enF.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && b.this.enS && !b.this.enV) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        b.this.enF.startAnimation(b.this.enT);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.enG.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.numberUniformFormatExtra(this.ejJ.aCH().audience_count)));
        if (this.ejJ.aCo() != null) {
            String name_show = this.ejJ.aCo().getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.enI.setText(name_show);
        }
        if (!StringUtils.isNull(this.ejJ.mRecomExtra)) {
            this.esC.setVisibility(0);
            this.esD.setVisibility(8);
            this.esC.setText(this.ejJ.mRecomExtra);
            GradientDrawable gradientDrawable = new GradientDrawable();
            float dimensionPixelSize = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize, dimensionPixelSize, 0.0f, 0.0f});
            gradientDrawable.setColor(-50901);
            this.esC.setBackgroundDrawable(gradientDrawable);
        } else if (this.ejJ.aCH().label != null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            float dimensionPixelSize2 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize2, dimensionPixelSize2, 0.0f, 0.0f});
            if (!StringUtils.isNull(this.ejJ.aCH().label.labelColor)) {
                gradientDrawable2.setColor(Color.parseColor(this.ejJ.aCH().label.labelColor));
            }
            this.esC.setBackgroundDrawable(gradientDrawable2);
            this.esC.setText(this.ejJ.aCH().label.labelName);
            this.esC.setVisibility(0);
            this.esD.setVisibility(8);
        } else if (this.ejJ.aCH().mChallengeInfoData != null && this.ejJ.aCH().mChallengeInfoData.challenge_id > 0) {
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            float dimensionPixelSize3 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable3.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize3, dimensionPixelSize3, 0.0f, 0.0f});
            gradientDrawable3.setColor(-50901);
            this.esD.setBackground(gradientDrawable3);
            this.esD.setVisibility(0);
            this.esC.setVisibility(8);
        } else {
            this.esC.setVisibility(8);
            this.esD.setVisibility(8);
        }
        if (this.ejJ.aCH().haveRedpkg) {
            this.epC.setVisibility(0);
        } else {
            this.epC.setVisibility(8);
        }
        if (this.ejJ != null) {
            if (i == 2) {
                TiebaStatic.log(new an("c12899").cy("tid", this.ejJ.getTid()));
            } else if (i == 1) {
                TiebaStatic.log(new an("c12903").cy("tid", this.ejJ.getTid()));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.enH, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.enG, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.enI, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.esC, R.color.cp_cont_g, 1, 0);
            am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14));
            this.enG.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.icon_video_direct_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
            this.mSkinType = i;
        }
    }
}
