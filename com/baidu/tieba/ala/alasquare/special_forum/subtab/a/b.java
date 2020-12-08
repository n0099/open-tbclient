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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class b {
    public TextView bAG;
    private by gpF;
    public TbImageView gtJ;
    public TextView gtK;
    public RelativeLayout gtL;
    private String gtT;
    private AlphaAnimation gtW;
    public ImageView gvM;
    private com.baidu.tieba.ala.alasquare.subtablist.c.i gxs;
    public TextView gyJ;
    public TextView gyK;
    public LinearLayout gyL;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private boolean gtV = false;
    private boolean gtX = true;
    private boolean mIsAnimating = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private int gyM = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (b.this.gpF != null && b.this.gpF.bpj() != null && b.this.gxs != null) {
                    b.this.gxs.a(b.this.tabId, b.this.gtT, b.this.gpF);
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
        this.gtJ = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.gyJ = (TextView) this.mRootView.findViewById(R.id.tvLiveFrom);
        this.gtK = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.gtL = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.bAG = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.gyK = (TextView) this.mRootView.findViewById(R.id.tv_extra);
        this.gyL = (LinearLayout) this.mRootView.findViewById(R.id.challenge_root);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.gtJ.setBorderSurroundContent(true);
        this.gtJ.setDrawBorder(true);
        this.gvM = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.gtW = new AlphaAnimation(0.0f, 1.0f);
        this.gtW.setDuration(200L);
        this.gtW.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.1
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
        this.gxs = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        a(cVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.c cVar, int i) {
        if (cVar == null || cVar.gpF == null || cVar.gpF.bpj() == null) {
            getView().setVisibility(4);
            return;
        }
        if (this.gyM != l.getEquipmentWidth(this.mRootView.getContext())) {
            this.gyM = l.getEquipmentWidth(this.mRootView.getContext());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gtL.getLayoutParams();
            layoutParams.width = (this.gyM - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
            layoutParams.height = layoutParams.width;
            this.gtL.setLayoutParams(layoutParams);
        }
        getView().setVisibility(0);
        this.gpF = cVar.gpF;
        this.tabId = cVar.tabId;
        this.gtT = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        Object tag = this.gtJ.getTag();
        if (this.gtX) {
            this.gtV = true;
            this.gtX = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.gpF.bpj().cover) && !((String) tag).equals(this.gpF.bpj().cover)) {
            this.gtV = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.gpF.bpj().cover) && !this.mCoverUrl.equals(this.gpF.bpj().cover)) {
            this.gtV = true;
        } else {
            this.gtV = false;
        }
        this.mCoverUrl = this.gpF.bpj().cover;
        this.gtJ.setTag(this.mCoverUrl);
        this.gtJ.startLoad(this.gpF.bpj().cover, 10, false);
        this.gtJ.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && b.this.gtV && !b.this.mIsAnimating) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        b.this.gtJ.startAnimation(b.this.gtW);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.gtK.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, au.numberUniformFormatExtra(this.gpF.bpj().audience_count)));
        if (this.gpF.boP() != null) {
            String name_show = this.gpF.boP().getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ae.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.bAG.setText(name_show);
        }
        if (!StringUtils.isNull(this.gpF.mRecomExtra)) {
            this.gyK.setVisibility(0);
            this.gyL.setVisibility(8);
            this.gyK.setText(this.gpF.mRecomExtra);
            GradientDrawable gradientDrawable = new GradientDrawable();
            float dimensionPixelSize = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize, dimensionPixelSize, 0.0f, 0.0f});
            gradientDrawable.setColor(-50901);
            this.gyK.setBackgroundDrawable(gradientDrawable);
        } else if (this.gpF.bpj().label != null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            float dimensionPixelSize2 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize2, dimensionPixelSize2, 0.0f, 0.0f});
            if (!StringUtils.isNull(this.gpF.bpj().label.labelColor)) {
                gradientDrawable2.setColor(Color.parseColor(this.gpF.bpj().label.labelColor));
            }
            this.gyK.setBackgroundDrawable(gradientDrawable2);
            this.gyK.setText(this.gpF.bpj().label.labelName);
            this.gyK.setVisibility(0);
            this.gyL.setVisibility(8);
        } else if (this.gpF.bpj().mChallengeInfoData != null && this.gpF.bpj().mChallengeInfoData.challenge_id > 0) {
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            float dimensionPixelSize3 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable3.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize3, dimensionPixelSize3, 0.0f, 0.0f});
            gradientDrawable3.setColor(-50901);
            this.gyL.setBackground(gradientDrawable3);
            this.gyL.setVisibility(0);
            this.gyK.setVisibility(8);
        } else {
            this.gyK.setVisibility(8);
            this.gyL.setVisibility(8);
        }
        if (this.gpF.bpj().haveRedpkg) {
            this.gvM.setVisibility(0);
        } else {
            this.gvM.setVisibility(8);
        }
        if (this.gpF != null) {
            if (i == 2) {
                TiebaStatic.log(new ar("c12899").dY("tid", this.gpF.getTid()));
            } else if (i == 1) {
                TiebaStatic.log(new ar("c12903").dY("tid", this.gpF.getTid()));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gtL, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gtK, (int) R.color.CAM_X0101);
            ap.setViewTextColor(this.bAG, (int) R.color.CAM_X0101);
            ap.setViewTextColor(this.gyK, R.color.CAM_X0111, 1, 0);
            ap.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14));
            this.gtK.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.icon_video_direct_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
            this.mSkinType = i;
        }
    }
}
