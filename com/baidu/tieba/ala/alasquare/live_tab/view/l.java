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
    private static final float fGD = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] fGE = {0.0f, 0.0f, 0.0f, 0.0f, fGD, fGD, fGD, fGD};
    private static final float[] fGF = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, fGD, fGD};
    private static final float[] fGG = {0.0f, 0.0f, 0.0f, 0.0f, fGD, fGD, 0.0f, 0.0f};
    public TextView fGA;
    public LinearLayout fGB;
    private AlphaAnimation fGL;
    public TbImageView fGx;
    public TextView fGy;
    private SdkLiveInfoData fIC;
    public TbImageView fIx;
    public ImageView fIy;
    private com.baidu.tieba.ala.alasquare.a.a fIz;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabType;
    public int mSkinType = 3;
    private int[] fGH = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean fGK = false;
    private boolean fGM = true;
    private boolean mIsAnimating = false;
    private int fIA = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.ala.alasquare.live_tab.c.a(l.this.mTbPageContext.getPageActivity(), l.this.fIC);
            if (l.this.fIz != null && l.this.fIC != null) {
                if (l.this.fIz.eei) {
                    aq aqVar = new aq("c13611");
                    aqVar.dD("obj_param1", l.this.fIC.liveId);
                    aqVar.dD("fid", l.this.fIz.fid);
                    aqVar.dD("fname", l.this.fIz.fname);
                    aqVar.ai("obj_locate", l.this.fIz.position);
                    if (l.this.fIC != null && l.this.fIC.uiTransParam != null) {
                        aqVar.dD("ab_tag", l.this.fIC.uiTransParam.abTag);
                        aqVar.dD("star_id", l.this.fIC.uiTransParam.starId);
                        aqVar.dD("extra", l.this.fIC.uiTransParam.extra);
                        aqVar.dD("source_from", l.this.fIC.uiTransParam.sourceFrom);
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
                aqVar2.dD("obj_param1", l.this.fIC.liveId);
                aqVar2.dD("entryname", str);
                TiebaStatic.log(aqVar2);
            }
        }
    };

    public l(TbPageContext<?> tbPageContext, int i) {
        this.mTbPageContext = tbPageContext;
        this.tabType = i;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_live_item_view, (ViewGroup) null, false);
        this.fGx = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.fGx.setBorderSurroundContent(true);
        this.fGx.setDrawBorder(true);
        this.fGx.setPlaceHolder(2);
        this.fGx.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.fGy = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.fGA = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.fGB = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.fIx = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.fIy = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.fGL = new AlphaAnimation(0.0f, 1.0f);
        this.fGL.setDuration(200L);
        this.fGL.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.1
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
        if (equipmentWidth != this.fIA) {
            ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
            int equipmentWidth2 = (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mRootView.getContext()) - this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds12)) - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(equipmentWidth2 / 2, equipmentWidth2 / 2);
            } else {
                layoutParams.width = equipmentWidth2 / 2;
                layoutParams.height = layoutParams.width;
            }
            this.mRootView.setLayoutParams(layoutParams);
            this.fIA = equipmentWidth;
        }
        if (aVar == null || aVar.fCy == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.fIz = aVar;
        this.fIC = aVar.fCy;
        Object tag = this.fGx.getTag();
        if (this.fGM) {
            this.fGK = true;
            this.fGM = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.fIC.liveInfo.cover) && !((String) tag).equals(this.fIC.liveInfo.cover)) {
            this.fGK = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.fIC.liveInfo.cover) && !this.mCoverUrl.equals(this.fIC.liveInfo.cover)) {
            this.fGK = true;
        } else {
            this.fGK = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.fGH);
        this.mCoverUrl = this.fIC.liveInfo.cover;
        this.fGx.setTag(this.mCoverUrl);
        if (aVar.isLeft) {
            this.fGx.setConrers(5);
            gradientDrawable.setCornerRadii(fGF);
            this.fGx.setPlaceHolder(2);
        } else if (aVar.isRight) {
            this.fGx.setConrers(10);
            gradientDrawable.setCornerRadii(fGG);
            this.fGx.setPlaceHolder(2);
        } else if (aVar.fCz) {
            this.fGx.setConrers(15);
            gradientDrawable.setCornerRadii(fGE);
            this.fGx.setPlaceHolder(2);
        }
        this.fGx.setRadius((int) fGD);
        this.fGx.startLoad(this.fIC.liveInfo.cover, 10, false);
        this.fGB.setBackgroundDrawable(gradientDrawable);
        this.fGx.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z && l.this.fGK && !l.this.mIsAnimating) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        l.this.fGx.startAnimation(l.this.fGL);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fGy.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, at.cP(this.fIC.liveInfo.audienceCount)));
        this.fGA.setText(this.fIC.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.fIC.recom_extra_img_night;
        } else {
            str = this.fIC.recom_extra_img;
        }
        if (!StringUtils.isNull(str) && this.fIC.recom_extra_img_width > 0 && this.fIC.recom_extra_img_height > 0) {
            if (aVar.isLeft) {
                this.fIx.setConrers(1);
            } else if (aVar.isRight) {
                this.fIx.setConrers(0);
            } else if (aVar.fCz) {
                this.fIx.setConrers(1);
            } else {
                this.fIx.setConrers(0);
            }
            this.fIx.setRadius((int) fGD);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fIx.getLayoutParams();
            if (layoutParams2 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                layoutParams2.height = dimensionPixelSize;
                layoutParams2.width = (int) ((this.fIC.recom_extra_img_width / this.fIC.recom_extra_img_height) * dimensionPixelSize);
                this.fIx.setLayoutParams(layoutParams2);
            }
            this.fIx.startLoad(str, 10, false);
            this.fIx.setVisibility(0);
        } else {
            this.fIx.setVisibility(8);
        }
        if (this.fIC.liveInfo.haveRedpkg) {
            this.fIy.setVisibility(0);
        } else {
            this.fIy.setVisibility(8);
        }
        if (this.fIC != null) {
            if (i == 2) {
                TiebaStatic.log(new aq("c12899").dD("tid", this.fIC.tid));
            } else if (i == 1) {
                TiebaStatic.log(new aq("c12903").dD("tid", this.fIC.tid));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.eei) {
            aq aqVar = new aq("c13610");
            aqVar.dD("obj_param1", this.fIC != null ? this.fIC.liveId : "");
            aqVar.dD("fid", aVar.fid);
            aqVar.dD("fname", aVar.fname);
            aqVar.ai("obj_locate", aVar.position);
            if (this.fIC != null && this.fIC.uiTransParam != null) {
                aqVar.dD("ab_tag", this.fIC.uiTransParam.abTag);
                aqVar.dD("star_id", this.fIC.uiTransParam.starId);
                aqVar.dD("extra", this.fIC.uiTransParam.extra);
                aqVar.dD("source_from", this.fIC.uiTransParam.sourceFrom);
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
        aqVar2.dD("obj_param1", this.fIC == null ? "" : this.fIC.liveId);
        aqVar2.dD("entryname", str2);
        TiebaStatic.log(aqVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.fGy, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.fGA, (int) R.color.cp_cont_a);
            Drawable drawable = ap.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.fGy.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.fGy.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
