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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.util.ag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.a.e;
import com.baidu.tieba.ala.alasquare.subtablist.view.g;
/* loaded from: classes10.dex */
public class b {
    public TextView bEn;
    public TbImageView gCN;
    public TextView gCO;
    public RelativeLayout gCP;
    private String gCX;
    private AlphaAnimation gDa;
    public ImageView gER;
    private g gGB;
    public TextView gHS;
    public TextView gHT;
    public LinearLayout gHU;
    private cb gyA;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private boolean gCZ = false;
    private boolean gDb = true;
    private boolean gDc = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private int gHV = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.view.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (b.this.gyA != null && b.this.gyA.boj() != null && b.this.gGB != null) {
                    b.this.gGB.a(b.this.tabId, b.this.gCX, b.this.gyA);
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
        this.gCN = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.gHS = (TextView) this.mRootView.findViewById(R.id.tvLiveFrom);
        this.gCO = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.gCP = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.bEn = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.gHT = (TextView) this.mRootView.findViewById(R.id.tv_extra);
        this.gHU = (LinearLayout) this.mRootView.findViewById(R.id.challenge_root);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.gCN.setBorderSurroundContent(true);
        this.gCN.setDrawBorder(true);
        this.gER = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.gDa = new AlphaAnimation(0.0f, 1.0f);
        this.gDa.setDuration(200L);
        this.gDa.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.view.b.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                b.this.gDc = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                b.this.gDc = false;
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
        this.gGB = gVar;
    }

    public void b(e eVar) {
        a(eVar, -1);
    }

    public void a(e eVar, int i) {
        if (eVar == null || eVar.gyA == null || eVar.gyA.boj() == null) {
            getView().setVisibility(4);
            return;
        }
        if (this.gHV != l.getEquipmentWidth(this.mRootView.getContext())) {
            this.gHV = l.getEquipmentWidth(this.mRootView.getContext());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gCP.getLayoutParams();
            layoutParams.width = (this.gHV - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
            layoutParams.height = layoutParams.width;
            this.gCP.setLayoutParams(layoutParams);
        }
        getView().setVisibility(0);
        this.gyA = eVar.gyA;
        this.tabId = eVar.tabId;
        this.gCX = !TextUtils.isEmpty(eVar.labelName) ? eVar.labelName : eVar.entryName;
        Object tag = this.gCN.getTag();
        if (this.gDb) {
            this.gCZ = true;
            this.gDb = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.gyA.boj().cover) && !((String) tag).equals(this.gyA.boj().cover)) {
            this.gCZ = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.gyA.boj().cover) && !this.mCoverUrl.equals(this.gyA.boj().cover)) {
            this.gCZ = true;
        } else {
            this.gCZ = false;
        }
        this.mCoverUrl = this.gyA.boj().cover;
        this.gCN.setTag(this.mCoverUrl);
        this.gCN.startLoad(this.gyA.boj().cover, 10, false);
        this.gCN.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.view.b.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z && b.this.gCZ && !b.this.gDc) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        b.this.gCN.startAnimation(b.this.gDa);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        });
        this.gCO.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, au.numberUniformFormatExtra(this.gyA.boj().audience_count)));
        if (this.gyA.bnQ() != null) {
            String name_show = this.gyA.bnQ().getName_show();
            if (ag.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ag.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.bEn.setText(name_show);
        }
        if (!StringUtils.isNull(this.gyA.mRecomExtra)) {
            this.gHT.setVisibility(0);
            this.gHU.setVisibility(8);
            this.gHT.setText(this.gyA.mRecomExtra);
            GradientDrawable gradientDrawable = new GradientDrawable();
            float dimensionPixelSize = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize, dimensionPixelSize, 0.0f, 0.0f});
            gradientDrawable.setColor(-50901);
            this.gHT.setBackgroundDrawable(gradientDrawable);
        } else if (this.gyA.boj().label != null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            float dimensionPixelSize2 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize2, dimensionPixelSize2, 0.0f, 0.0f});
            if (!StringUtils.isNull(this.gyA.boj().label.labelColor)) {
                gradientDrawable2.setColor(Color.parseColor(this.gyA.boj().label.labelColor));
            }
            this.gHT.setBackgroundDrawable(gradientDrawable2);
            this.gHT.setText(this.gyA.boj().label.labelName);
            this.gHT.setVisibility(0);
            this.gHU.setVisibility(8);
        } else if (this.gyA.boj().mChallengeInfoData != null && this.gyA.boj().mChallengeInfoData.challenge_id > 0) {
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            float dimensionPixelSize3 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable3.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize3, dimensionPixelSize3, 0.0f, 0.0f});
            gradientDrawable3.setColor(-50901);
            this.gHU.setBackground(gradientDrawable3);
            this.gHU.setVisibility(0);
            this.gHT.setVisibility(8);
        } else {
            this.gHT.setVisibility(8);
            this.gHU.setVisibility(8);
        }
        if (this.gyA.boj().haveRedpkg) {
            this.gER.setVisibility(0);
        } else {
            this.gER.setVisibility(8);
        }
        if (this.gyA != null) {
            if (i == 2) {
                TiebaStatic.log(new ar("c12899").dR("tid", this.gyA.getTid()));
            } else if (i == 1) {
                TiebaStatic.log(new ar("c12903").dR("tid", this.gyA.getTid()));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gCP, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gCO, R.color.CAM_X0101);
            ap.setViewTextColor(this.bEn, R.color.CAM_X0101);
            ap.setViewTextColor(this.gHT, R.color.CAM_X0111, 1, 0);
            ap.getDrawable(this.mTbPageContext.getResources(), R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14));
            this.gCO.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(this.mTbPageContext.getResources(), R.drawable.icon_video_direct_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
            this.mSkinType = i;
        }
    }
}
