package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class l {
    private AlphaAnimation fGH;
    public TbImageView fGt;
    public TextView fGu;
    public TextView fGw;
    public LinearLayout fGx;
    public TbImageView fIt;
    public ImageView fIu;
    private com.baidu.tieba.ala.alasquare.a.a fIv;
    private SdkLiveInfoData fIy;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabType;
    private static final float fGz = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] fGA = {0.0f, 0.0f, 0.0f, 0.0f, fGz, fGz, fGz, fGz};
    private static final float[] fGB = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, fGz, fGz};
    private static final float[] fGC = {0.0f, 0.0f, 0.0f, 0.0f, fGz, fGz, 0.0f, 0.0f};
    public int mSkinType = 3;
    private int[] fGD = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean fGG = false;
    private boolean fGI = true;
    private boolean mIsAnimating = false;
    private int fIw = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.ala.alasquare.live_tab.c.a(l.this.mTbPageContext.getPageActivity(), l.this.fIy);
            if (l.this.fIv != null && l.this.fIy != null) {
                if (l.this.fIv.eee) {
                    aq aqVar = new aq("c13611");
                    aqVar.dD("obj_param1", l.this.fIy.liveId);
                    aqVar.dD("fid", l.this.fIv.fid);
                    aqVar.dD("fname", l.this.fIv.fname);
                    aqVar.ai("obj_locate", l.this.fIv.position);
                    if (l.this.fIy != null && l.this.fIy.uiTransParam != null) {
                        aqVar.dD("ab_tag", l.this.fIy.uiTransParam.abTag);
                        aqVar.dD("star_id", l.this.fIy.uiTransParam.starId);
                        aqVar.dD("extra", l.this.fIy.uiTransParam.extra);
                        aqVar.dD("source_from", l.this.fIy.uiTransParam.sourceFrom);
                    }
                    TiebaStatic.log(aqVar);
                    return;
                }
                aq aqVar2 = new aq("c13557");
                String str = "";
                if (101 == l.this.tabType) {
                    str = "推荐";
                } else if (102 == l.this.tabType) {
                    str = "颜值";
                }
                aqVar2.dD("obj_param1", l.this.fIy.liveId);
                aqVar2.dD("entryname", str);
                TiebaStatic.log(aqVar2);
            }
        }
    };

    public l(TbPageContext<?> tbPageContext, int i) {
        this.mTbPageContext = tbPageContext;
        this.tabType = i;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_live_item_view, (ViewGroup) null, false);
        this.fGt = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.fGt.setBorderSurroundContent(true);
        this.fGt.setDrawBorder(true);
        this.fGt.setPlaceHolder(2);
        this.fGt.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.fGu = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.fGw = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.fGx = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.fIt = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.fIu = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.fGH = new AlphaAnimation(0.0f, 1.0f);
        this.fGH.setDuration(200L);
        this.fGH.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                l.this.mIsAnimating = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                l.this.mIsAnimating = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(com.baidu.tieba.ala.alasquare.a.a aVar) {
        a(aVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.a aVar, int i) {
        String str;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mRootView.getContext());
        if (equipmentWidth != this.fIw) {
            ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
            int equipmentWidth2 = (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mRootView.getContext()) - this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds12)) - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(equipmentWidth2 / 2, equipmentWidth2 / 2);
            } else {
                layoutParams.width = equipmentWidth2 / 2;
                layoutParams.height = layoutParams.width;
            }
            this.mRootView.setLayoutParams(layoutParams);
            this.fIw = equipmentWidth;
        }
        if (aVar == null || aVar.fCu == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.fIv = aVar;
        this.fIy = aVar.fCu;
        Object tag = this.fGt.getTag();
        if (this.fGI) {
            this.fGG = true;
            this.fGI = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.fIy.liveInfo.cover) && !((String) tag).equals(this.fIy.liveInfo.cover)) {
            this.fGG = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.fIy.liveInfo.cover) && !this.mCoverUrl.equals(this.fIy.liveInfo.cover)) {
            this.fGG = true;
        } else {
            this.fGG = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.fGD);
        this.mCoverUrl = this.fIy.liveInfo.cover;
        this.fGt.setTag(this.mCoverUrl);
        if (aVar.isLeft) {
            this.fGt.setConrers(5);
            gradientDrawable.setCornerRadii(fGB);
            this.fGt.setPlaceHolder(2);
        } else if (aVar.isRight) {
            this.fGt.setConrers(10);
            gradientDrawable.setCornerRadii(fGC);
            this.fGt.setPlaceHolder(2);
        } else if (aVar.fCv) {
            this.fGt.setConrers(15);
            gradientDrawable.setCornerRadii(fGA);
            this.fGt.setPlaceHolder(2);
        }
        this.fGt.setRadius((int) fGz);
        this.fGt.startLoad(this.fIy.liveInfo.cover, 10, false);
        this.fGx.setBackgroundDrawable(gradientDrawable);
        this.fGt.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z && l.this.fGG && !l.this.mIsAnimating) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        l.this.fGt.startAnimation(l.this.fGH);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fGu.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, at.cP(this.fIy.liveInfo.audienceCount)));
        this.fGw.setText(this.fIy.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.fIy.recom_extra_img_night;
        } else {
            str = this.fIy.recom_extra_img;
        }
        if (!StringUtils.isNull(str) && this.fIy.recom_extra_img_width > 0 && this.fIy.recom_extra_img_height > 0) {
            if (aVar.isLeft) {
                this.fIt.setConrers(1);
            } else if (aVar.isRight) {
                this.fIt.setConrers(0);
            } else if (aVar.fCv) {
                this.fIt.setConrers(1);
            } else {
                this.fIt.setConrers(0);
            }
            this.fIt.setRadius((int) fGz);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fIt.getLayoutParams();
            if (layoutParams2 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                layoutParams2.height = dimensionPixelSize;
                layoutParams2.width = (int) ((this.fIy.recom_extra_img_width / this.fIy.recom_extra_img_height) * dimensionPixelSize);
                this.fIt.setLayoutParams(layoutParams2);
            }
            this.fIt.startLoad(str, 10, false);
            this.fIt.setVisibility(0);
        } else {
            this.fIt.setVisibility(8);
        }
        if (this.fIy.liveInfo.haveRedpkg) {
            this.fIu.setVisibility(0);
        } else {
            this.fIu.setVisibility(8);
        }
        if (this.fIy != null) {
            if (i == 2) {
                TiebaStatic.log(new aq("c12899").dD("tid", this.fIy.tid));
            } else if (i == 1) {
                TiebaStatic.log(new aq("c12903").dD("tid", this.fIy.tid));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.eee) {
            aq aqVar = new aq("c13610");
            aqVar.dD("obj_param1", this.fIy != null ? this.fIy.liveId : "");
            aqVar.dD("fid", aVar.fid);
            aqVar.dD("fname", aVar.fname);
            aqVar.ai("obj_locate", aVar.position);
            if (this.fIy != null && this.fIy.uiTransParam != null) {
                aqVar.dD("ab_tag", this.fIy.uiTransParam.abTag);
                aqVar.dD("star_id", this.fIy.uiTransParam.starId);
                aqVar.dD("extra", this.fIy.uiTransParam.extra);
                aqVar.dD("source_from", this.fIy.uiTransParam.sourceFrom);
            }
            TiebaStatic.log(aqVar);
            return;
        }
        aq aqVar2 = new aq("c13544");
        String str2 = "";
        if (101 == this.tabType) {
            str2 = "推荐";
        } else if (102 == this.tabType) {
            str2 = "颜值";
        }
        aqVar2.dD("obj_param1", this.fIy == null ? "" : this.fIy.liveId);
        aqVar2.dD("entryname", str2);
        TiebaStatic.log(aqVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.fGu, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.fGw, (int) R.color.cp_cont_a);
            Drawable drawable = ap.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.fGu.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.fGu.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
