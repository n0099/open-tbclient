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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class l {
    private static final float feL = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] feM = {0.0f, 0.0f, 0.0f, 0.0f, feL, feL, feL, feL};
    private static final float[] feN = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, feL, feL};
    private static final float[] feO = {0.0f, 0.0f, 0.0f, 0.0f, feL, feL, 0.0f, 0.0f};
    public TbImageView feF;
    public TextView feG;
    public TextView feI;
    public LinearLayout feJ;
    private AlphaAnimation feT;
    public TbImageView fgF;
    public ImageView fgG;
    private com.baidu.tieba.ala.alasquare.a.a fgH;
    private SdkLiveInfoData fgK;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabType;
    public int mSkinType = 3;
    private int[] feP = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean feS = false;
    private boolean feU = true;
    private boolean feV = false;
    private int fgI = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.ala.alasquare.live_tab.c.a(l.this.mTbPageContext.getPageActivity(), l.this.fgK);
            if (l.this.fgH != null && l.this.fgK != null) {
                if (l.this.fgH.dHL) {
                    an anVar = new an("c13611");
                    anVar.dh("obj_param1", l.this.fgK.liveId);
                    anVar.dh("fid", l.this.fgH.fid);
                    anVar.dh("fname", l.this.fgH.fname);
                    anVar.ag("obj_locate", l.this.fgH.position);
                    if (l.this.fgK != null && l.this.fgK.uiTransParam != null) {
                        anVar.dh("ab_tag", l.this.fgK.uiTransParam.abTag);
                        anVar.dh("star_id", l.this.fgK.uiTransParam.starId);
                        anVar.dh("extra", l.this.fgK.uiTransParam.extra);
                        anVar.dh("source_from", l.this.fgK.uiTransParam.sourceFrom);
                    }
                    TiebaStatic.log(anVar);
                    return;
                }
                an anVar2 = new an("c13557");
                String str = "";
                if (101 == l.this.tabType) {
                    str = "推荐";
                } else if (102 == l.this.tabType) {
                    str = "颜值";
                }
                anVar2.dh("obj_param1", l.this.fgK.liveId);
                anVar2.dh("entryname", str);
                TiebaStatic.log(anVar2);
            }
        }
    };

    public l(TbPageContext<?> tbPageContext, int i) {
        this.mTbPageContext = tbPageContext;
        this.tabType = i;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_live_item_view, (ViewGroup) null, false);
        this.feF = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.feF.setBorderSurroundContent(true);
        this.feF.setDrawBorder(true);
        this.feF.setPlaceHolder(2);
        this.feF.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.feG = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.feI = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.feJ = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.fgF = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.fgG = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.feT = new AlphaAnimation(0.0f, 1.0f);
        this.feT.setDuration(200L);
        this.feT.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                l.this.feV = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                l.this.feV = false;
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
        if (equipmentWidth != this.fgI) {
            ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
            int equipmentWidth2 = (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mRootView.getContext()) - this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds12)) - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(equipmentWidth2 / 2, equipmentWidth2 / 2);
            } else {
                layoutParams.width = equipmentWidth2 / 2;
                layoutParams.height = layoutParams.width;
            }
            this.mRootView.setLayoutParams(layoutParams);
            this.fgI = equipmentWidth;
        }
        if (aVar == null || aVar.faG == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.fgH = aVar;
        this.fgK = aVar.faG;
        Object tag = this.feF.getTag();
        if (this.feU) {
            this.feS = true;
            this.feU = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.fgK.liveInfo.cover) && !((String) tag).equals(this.fgK.liveInfo.cover)) {
            this.feS = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.fgK.liveInfo.cover) && !this.mCoverUrl.equals(this.fgK.liveInfo.cover)) {
            this.feS = true;
        } else {
            this.feS = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.feP);
        this.mCoverUrl = this.fgK.liveInfo.cover;
        this.feF.setTag(this.mCoverUrl);
        if (aVar.isLeft) {
            this.feF.setConrers(5);
            gradientDrawable.setCornerRadii(feN);
            this.feF.setPlaceHolder(2);
        } else if (aVar.isRight) {
            this.feF.setConrers(10);
            gradientDrawable.setCornerRadii(feO);
            this.feF.setPlaceHolder(2);
        } else if (aVar.faH) {
            this.feF.setConrers(15);
            gradientDrawable.setCornerRadii(feM);
            this.feF.setPlaceHolder(2);
        }
        this.feF.setRadius((int) feL);
        this.feF.startLoad(this.fgK.liveInfo.cover, 10, false);
        this.feJ.setBackgroundDrawable(gradientDrawable);
        this.feF.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z && l.this.feS && !l.this.feV) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        l.this.feF.startAnimation(l.this.feT);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.feG.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.cl(this.fgK.liveInfo.audienceCount)));
        this.feI.setText(this.fgK.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.fgK.recom_extra_img_night;
        } else {
            str = this.fgK.recom_extra_img;
        }
        if (!StringUtils.isNull(str) && this.fgK.recom_extra_img_width > 0 && this.fgK.recom_extra_img_height > 0) {
            if (aVar.isLeft) {
                this.fgF.setConrers(1);
            } else if (aVar.isRight) {
                this.fgF.setConrers(0);
            } else if (aVar.faH) {
                this.fgF.setConrers(1);
            } else {
                this.fgF.setConrers(0);
            }
            this.fgF.setRadius((int) feL);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fgF.getLayoutParams();
            if (layoutParams2 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                layoutParams2.height = dimensionPixelSize;
                layoutParams2.width = (int) ((this.fgK.recom_extra_img_width / this.fgK.recom_extra_img_height) * dimensionPixelSize);
                this.fgF.setLayoutParams(layoutParams2);
            }
            this.fgF.startLoad(str, 10, false);
            this.fgF.setVisibility(0);
        } else {
            this.fgF.setVisibility(8);
        }
        if (this.fgK.liveInfo.haveRedpkg) {
            this.fgG.setVisibility(0);
        } else {
            this.fgG.setVisibility(8);
        }
        if (this.fgK != null) {
            if (i == 2) {
                TiebaStatic.log(new an("c12899").dh("tid", this.fgK.tid));
            } else if (i == 1) {
                TiebaStatic.log(new an("c12903").dh("tid", this.fgK.tid));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.dHL) {
            an anVar = new an("c13610");
            anVar.dh("obj_param1", this.fgK != null ? this.fgK.liveId : "");
            anVar.dh("fid", aVar.fid);
            anVar.dh("fname", aVar.fname);
            anVar.ag("obj_locate", aVar.position);
            if (this.fgK != null && this.fgK.uiTransParam != null) {
                anVar.dh("ab_tag", this.fgK.uiTransParam.abTag);
                anVar.dh("star_id", this.fgK.uiTransParam.starId);
                anVar.dh("extra", this.fgK.uiTransParam.extra);
                anVar.dh("source_from", this.fgK.uiTransParam.sourceFrom);
            }
            TiebaStatic.log(anVar);
            return;
        }
        an anVar2 = new an("c13544");
        String str2 = "";
        if (101 == this.tabType) {
            str2 = "推荐";
        } else if (102 == this.tabType) {
            str2 = "颜值";
        }
        anVar2.dh("obj_param1", this.fgK == null ? "" : this.fgK.liveId);
        anVar2.dh("entryname", str2);
        TiebaStatic.log(anVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.feG, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.feI, (int) R.color.cp_cont_a);
            Drawable drawable = am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.feG.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.feG.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
