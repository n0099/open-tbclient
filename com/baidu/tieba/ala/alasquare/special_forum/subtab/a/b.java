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
    private bj eNM;
    public TbImageView eRH;
    public TextView eRI;
    public RelativeLayout eRJ;
    public TextView eRK;
    private String eRS;
    private AlphaAnimation eRV;
    public ImageView eTI;
    private com.baidu.tieba.ala.alasquare.subtablist.c.i eVp;
    public TextView eWG;
    public TextView eWH;
    public LinearLayout eWI;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private boolean eRU = false;
    private boolean eRW = true;
    private boolean eRX = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private int eWJ = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (b.this.eNM != null && b.this.eNM.aKX() != null && b.this.eVp != null) {
                    b.this.eVp.a(b.this.tabId, b.this.eRS, b.this.eNM);
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
        this.eRH = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.eWG = (TextView) this.mRootView.findViewById(R.id.tvLiveFrom);
        this.eRI = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.eRJ = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.eRK = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.eWH = (TextView) this.mRootView.findViewById(R.id.tv_extra);
        this.eWI = (LinearLayout) this.mRootView.findViewById(R.id.challenge_root);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.eRH.setBorderSurroundContent(true);
        this.eRH.setDrawBorder(true);
        this.eTI = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.eRV = new AlphaAnimation(0.0f, 1.0f);
        this.eRV.setDuration(200L);
        this.eRV.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                b.this.eRX = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                b.this.eRX = false;
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
        this.eVp = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        a(cVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.c cVar, int i) {
        if (cVar == null || cVar.eNM == null || cVar.eNM.aKX() == null) {
            getView().setVisibility(4);
            return;
        }
        if (this.eWJ != l.getEquipmentWidth(this.mRootView.getContext())) {
            this.eWJ = l.getEquipmentWidth(this.mRootView.getContext());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eRJ.getLayoutParams();
            layoutParams.width = (this.eWJ - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
            layoutParams.height = layoutParams.width;
            this.eRJ.setLayoutParams(layoutParams);
        }
        getView().setVisibility(0);
        this.eNM = cVar.eNM;
        this.tabId = cVar.tabId;
        this.eRS = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        Object tag = this.eRH.getTag();
        if (this.eRW) {
            this.eRU = true;
            this.eRW = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.eNM.aKX().cover) && !((String) tag).equals(this.eNM.aKX().cover)) {
            this.eRU = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.eNM.aKX().cover) && !this.mCoverUrl.equals(this.eNM.aKX().cover)) {
            this.eRU = true;
        } else {
            this.eRU = false;
        }
        this.mCoverUrl = this.eNM.aKX().cover;
        this.eRH.setTag(this.mCoverUrl);
        this.eRH.startLoad(this.eNM.aKX().cover, 10, false);
        this.eRH.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && b.this.eRU && !b.this.eRX) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        b.this.eRH.startAnimation(b.this.eRV);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.eRI.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.numberUniformFormatExtra(this.eNM.aKX().audience_count)));
        if (this.eNM.aKE() != null) {
            String name_show = this.eNM.aKE().getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.eRK.setText(name_show);
        }
        if (!StringUtils.isNull(this.eNM.mRecomExtra)) {
            this.eWH.setVisibility(0);
            this.eWI.setVisibility(8);
            this.eWH.setText(this.eNM.mRecomExtra);
            GradientDrawable gradientDrawable = new GradientDrawable();
            float dimensionPixelSize = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize, dimensionPixelSize, 0.0f, 0.0f});
            gradientDrawable.setColor(-50901);
            this.eWH.setBackgroundDrawable(gradientDrawable);
        } else if (this.eNM.aKX().label != null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            float dimensionPixelSize2 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize2, dimensionPixelSize2, 0.0f, 0.0f});
            if (!StringUtils.isNull(this.eNM.aKX().label.labelColor)) {
                gradientDrawable2.setColor(Color.parseColor(this.eNM.aKX().label.labelColor));
            }
            this.eWH.setBackgroundDrawable(gradientDrawable2);
            this.eWH.setText(this.eNM.aKX().label.labelName);
            this.eWH.setVisibility(0);
            this.eWI.setVisibility(8);
        } else if (this.eNM.aKX().mChallengeInfoData != null && this.eNM.aKX().mChallengeInfoData.challenge_id > 0) {
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            float dimensionPixelSize3 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable3.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize3, dimensionPixelSize3, 0.0f, 0.0f});
            gradientDrawable3.setColor(-50901);
            this.eWI.setBackground(gradientDrawable3);
            this.eWI.setVisibility(0);
            this.eWH.setVisibility(8);
        } else {
            this.eWH.setVisibility(8);
            this.eWI.setVisibility(8);
        }
        if (this.eNM.aKX().haveRedpkg) {
            this.eTI.setVisibility(0);
        } else {
            this.eTI.setVisibility(8);
        }
        if (this.eNM != null) {
            if (i == 2) {
                TiebaStatic.log(new an("c12899").cI("tid", this.eNM.getTid()));
            } else if (i == 1) {
                TiebaStatic.log(new an("c12903").cI("tid", this.eNM.getTid()));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eRJ, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.eRI, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eRK, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eWH, R.color.cp_cont_g, 1, 0);
            am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14));
            this.eRI.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.icon_video_direct_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
            this.mSkinType = i;
        }
    }
}
