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
    private static final float ggk = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] ggl = {0.0f, 0.0f, 0.0f, 0.0f, ggk, ggk, ggk, ggk};
    private static final float[] ggm = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, ggk, ggk};
    private static final float[] ggn = {0.0f, 0.0f, 0.0f, 0.0f, ggk, ggk, 0.0f, 0.0f};
    public TbImageView gge;
    public TextView ggf;
    public TextView ggh;
    public LinearLayout ggi;
    private AlphaAnimation ggs;
    public TbImageView gii;
    public ImageView gij;
    private com.baidu.tieba.ala.alasquare.a.a gik;
    private SdkLiveInfoData gin;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabType;
    public int mSkinType = 3;
    private int[] ggo = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean ggr = false;
    private boolean ggt = true;
    private boolean mIsAnimating = false;
    private int gil = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.tieba.ala.alasquare.live_tab.c.a(l.this.gin)) {
                com.baidu.tieba.ala.alasquare.live_tab.c.a(l.this.mTbPageContext, l.this.gin);
                if (103 == l.this.tabType) {
                    aq aqVar = new aq("c14008");
                    aqVar.aj("obj_locate", 3);
                    aqVar.dR("obj_param1", l.this.gin.liveId);
                    aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(aqVar);
                    return;
                }
                return;
            }
            com.baidu.tieba.ala.alasquare.live_tab.c.a(l.this.mTbPageContext.getPageActivity(), l.this.gin);
            if (l.this.gik != null && l.this.gin != null) {
                if (l.this.gik.eAY) {
                    aq aqVar2 = new aq("c13611");
                    aqVar2.dR("obj_param1", l.this.gin.liveId);
                    aqVar2.dR("fid", l.this.gik.fid);
                    aqVar2.dR("fname", l.this.gik.fname);
                    aqVar2.aj("obj_locate", l.this.gik.position);
                    if (l.this.gin != null && l.this.gin.uiTransParam != null) {
                        aqVar2.dR("ab_tag", l.this.gin.uiTransParam.abTag);
                        aqVar2.dR("star_id", l.this.gin.uiTransParam.starId);
                        aqVar2.dR("extra", l.this.gin.uiTransParam.extra);
                        aqVar2.dR("source_from", l.this.gin.uiTransParam.sourceFrom);
                    }
                    TiebaStatic.log(aqVar2);
                    return;
                }
                aq aqVar3 = new aq("c13557");
                String str = "";
                if (101 == l.this.tabType) {
                    str = "推荐";
                } else if (102 != l.this.tabType) {
                    if (103 == l.this.tabType) {
                        str = "交友";
                    }
                } else {
                    str = "颜值";
                }
                aqVar3.dR("obj_param1", l.this.gin.liveId);
                aqVar3.dR("entryname", str);
                TiebaStatic.log(aqVar3);
            }
        }
    };

    public l(TbPageContext<?> tbPageContext, int i) {
        this.mTbPageContext = tbPageContext;
        this.tabType = i;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_live_item_view, (ViewGroup) null, false);
        this.gge = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.gge.setBorderSurroundContent(true);
        this.gge.setDrawBorder(true);
        this.gge.setPlaceHolder(2);
        this.gge.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.ggf = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.ggh = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.ggi = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.gii = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.gij = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.ggs = new AlphaAnimation(0.0f, 1.0f);
        this.ggs.setDuration(200L);
        this.ggs.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.1
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
        if (equipmentWidth != this.gil) {
            ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
            int equipmentWidth2 = (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mRootView.getContext()) - this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds12)) - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(equipmentWidth2 / 2, equipmentWidth2 / 2);
            } else {
                layoutParams.width = equipmentWidth2 / 2;
                layoutParams.height = layoutParams.width;
            }
            this.mRootView.setLayoutParams(layoutParams);
            this.gil = equipmentWidth;
        }
        if (aVar == null || aVar.gbW == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gik = aVar;
        this.gin = aVar.gbW;
        Object tag = this.gge.getTag();
        if (this.ggt) {
            this.ggr = true;
            this.ggt = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.gin.liveInfo.cover) && !((String) tag).equals(this.gin.liveInfo.cover)) {
            this.ggr = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.gin.liveInfo.cover) && !this.mCoverUrl.equals(this.gin.liveInfo.cover)) {
            this.ggr = true;
        } else {
            this.ggr = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.ggo);
        this.mCoverUrl = this.gin.liveInfo.cover;
        this.gge.setTag(this.mCoverUrl);
        if (aVar.isLeft) {
            this.gge.setConrers(5);
            gradientDrawable.setCornerRadii(ggm);
            this.gge.setPlaceHolder(2);
        } else if (aVar.isRight) {
            this.gge.setConrers(10);
            gradientDrawable.setCornerRadii(ggn);
            this.gge.setPlaceHolder(2);
        } else if (aVar.gbX) {
            this.gge.setConrers(15);
            gradientDrawable.setCornerRadii(ggl);
            this.gge.setPlaceHolder(2);
        }
        this.gge.setRadius((int) ggk);
        this.gge.startLoad(this.gin.liveInfo.cover, 10, false);
        this.ggi.setBackgroundDrawable(gradientDrawable);
        this.gge.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z && l.this.ggr && !l.this.mIsAnimating) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        l.this.gge.startAnimation(l.this.ggs);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        if (this.gin.liveInfo.audienceCount <= 0) {
            this.ggf.setVisibility(8);
        } else {
            String da = at.da(this.gin.liveInfo.audienceCount);
            this.ggf.setVisibility(0);
            this.ggf.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, da));
        }
        this.ggh.setText(this.gin.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.gin.recom_extra_img_night;
        } else {
            str = this.gin.recom_extra_img;
        }
        if (!StringUtils.isNull(str) && this.gin.recom_extra_img_width > 0 && this.gin.recom_extra_img_height > 0) {
            if (aVar.isLeft) {
                this.gii.setConrers(1);
            } else if (aVar.isRight) {
                this.gii.setConrers(0);
            } else if (aVar.gbX) {
                this.gii.setConrers(1);
            } else {
                this.gii.setConrers(0);
            }
            this.gii.setRadius((int) ggk);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gii.getLayoutParams();
            if (layoutParams2 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                layoutParams2.height = dimensionPixelSize;
                layoutParams2.width = (int) ((this.gin.recom_extra_img_width / this.gin.recom_extra_img_height) * dimensionPixelSize);
                this.gii.setLayoutParams(layoutParams2);
            }
            this.gii.startLoad(str, 10, false);
            this.gii.setVisibility(0);
        } else {
            this.gii.setVisibility(8);
        }
        if (this.gin.liveInfo.haveRedpkg) {
            this.gij.setVisibility(0);
        } else {
            this.gij.setVisibility(8);
        }
        if (this.gin != null) {
            if (i == 2) {
                TiebaStatic.log(new aq("c12899").dR("tid", this.gin.tid));
            } else if (i == 1) {
                TiebaStatic.log(new aq("c12903").dR("tid", this.gin.tid));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.eAY) {
            aq aqVar = new aq("c13610");
            aqVar.dR("obj_param1", this.gin != null ? this.gin.liveId : "");
            aqVar.dR("fid", aVar.fid);
            aqVar.dR("fname", aVar.fname);
            aqVar.aj("obj_locate", aVar.position);
            if (this.gin != null && this.gin.uiTransParam != null) {
                aqVar.dR("ab_tag", this.gin.uiTransParam.abTag);
                aqVar.dR("star_id", this.gin.uiTransParam.starId);
                aqVar.dR("extra", this.gin.uiTransParam.extra);
                aqVar.dR("source_from", this.gin.uiTransParam.sourceFrom);
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
        } else if (103 == this.tabType) {
            str2 = "交友";
            if (com.baidu.tieba.ala.alasquare.live_tab.c.a(this.gin)) {
                aq aqVar3 = new aq("c14007");
                aqVar3.aj("obj_locate", 3);
                aqVar3.dR("obj_param1", this.gin.liveId);
                aqVar3.w("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(aqVar3);
            }
        }
        aqVar2.dR("obj_param1", this.gin == null ? "" : this.gin.liveId);
        aqVar2.dR("entryname", str2);
        TiebaStatic.log(aqVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.ggf, R.color.cp_cont_a);
            ap.setViewTextColor(this.ggh, R.color.cp_cont_a);
            Drawable drawable = ap.getDrawable(this.mTbPageContext.getResources(), R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.ggf.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.ggf.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
