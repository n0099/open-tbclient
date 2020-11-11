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
    private static final float glY = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] glZ = {0.0f, 0.0f, 0.0f, 0.0f, glY, glY, glY, glY};
    private static final float[] gma = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, glY, glY};
    private static final float[] gmb = {0.0f, 0.0f, 0.0f, 0.0f, glY, glY, 0.0f, 0.0f};
    public TextView bxh;
    public TbImageView glT;
    public TextView glU;
    public LinearLayout glW;
    private AlphaAnimation gmg;
    public TbImageView gnV;
    public ImageView gnW;
    private com.baidu.tieba.ala.alasquare.a.a gnX;
    private SdkLiveInfoData goa;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabType;
    public int mSkinType = 3;
    private int[] gmc = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean gmf = false;
    private boolean gmh = true;
    private boolean mIsAnimating = false;
    private int gnY = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.tieba.ala.alasquare.live_tab.c.a(l.this.goa)) {
                com.baidu.tieba.ala.alasquare.live_tab.c.a(l.this.mTbPageContext, l.this.goa);
                if (103 == l.this.tabType) {
                    aq aqVar = new aq("c14008");
                    aqVar.al("obj_locate", 3);
                    aqVar.dR("obj_param1", l.this.goa.liveId);
                    aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(aqVar);
                    return;
                }
                return;
            }
            com.baidu.tieba.ala.alasquare.live_tab.c.a(l.this.mTbPageContext.getPageActivity(), l.this.goa);
            if (l.this.gnX != null && l.this.goa != null) {
                if (l.this.gnX.eGN) {
                    aq aqVar2 = new aq("c13611");
                    aqVar2.dR("obj_param1", l.this.goa.liveId);
                    aqVar2.dR("fid", l.this.gnX.fid);
                    aqVar2.dR("fname", l.this.gnX.fname);
                    aqVar2.al("obj_locate", l.this.gnX.position);
                    if (l.this.goa != null && l.this.goa.uiTransParam != null) {
                        aqVar2.dR("ab_tag", l.this.goa.uiTransParam.abTag);
                        aqVar2.dR("star_id", l.this.goa.uiTransParam.starId);
                        aqVar2.dR("extra", l.this.goa.uiTransParam.extra);
                        aqVar2.dR("source_from", l.this.goa.uiTransParam.sourceFrom);
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
                aqVar3.dR("obj_param1", l.this.goa.liveId);
                aqVar3.dR("entryname", str);
                TiebaStatic.log(aqVar3);
            }
        }
    };

    public l(TbPageContext<?> tbPageContext, int i) {
        this.mTbPageContext = tbPageContext;
        this.tabType = i;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_live_item_view, (ViewGroup) null, false);
        this.glT = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.glT.setBorderSurroundContent(true);
        this.glT.setDrawBorder(true);
        this.glT.setPlaceHolder(2);
        this.glT.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.glU = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.bxh = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.glW = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.gnV = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.gnW = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.gmg = new AlphaAnimation(0.0f, 1.0f);
        this.gmg.setDuration(200L);
        this.gmg.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.1
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
        if (equipmentWidth != this.gnY) {
            ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
            int equipmentWidth2 = (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mRootView.getContext()) - this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds12)) - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(equipmentWidth2 / 2, equipmentWidth2 / 2);
            } else {
                layoutParams.width = equipmentWidth2 / 2;
                layoutParams.height = layoutParams.width;
            }
            this.mRootView.setLayoutParams(layoutParams);
            this.gnY = equipmentWidth;
        }
        if (aVar == null || aVar.ghL == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gnX = aVar;
        this.goa = aVar.ghL;
        Object tag = this.glT.getTag();
        if (this.gmh) {
            this.gmf = true;
            this.gmh = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.goa.liveInfo.cover) && !((String) tag).equals(this.goa.liveInfo.cover)) {
            this.gmf = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.goa.liveInfo.cover) && !this.mCoverUrl.equals(this.goa.liveInfo.cover)) {
            this.gmf = true;
        } else {
            this.gmf = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.gmc);
        this.mCoverUrl = this.goa.liveInfo.cover;
        this.glT.setTag(this.mCoverUrl);
        if (aVar.isLeft) {
            this.glT.setConrers(5);
            gradientDrawable.setCornerRadii(gma);
            this.glT.setPlaceHolder(2);
        } else if (aVar.isRight) {
            this.glT.setConrers(10);
            gradientDrawable.setCornerRadii(gmb);
            this.glT.setPlaceHolder(2);
        } else if (aVar.ghM) {
            this.glT.setConrers(15);
            gradientDrawable.setCornerRadii(glZ);
            this.glT.setPlaceHolder(2);
        }
        this.glT.setRadius((int) glY);
        this.glT.startLoad(this.goa.liveInfo.cover, 10, false);
        this.glW.setBackgroundDrawable(gradientDrawable);
        this.glT.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z && l.this.gmf && !l.this.mIsAnimating) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        l.this.glT.startAnimation(l.this.gmg);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        if (this.goa.liveInfo.audienceCount <= 0) {
            this.glU.setVisibility(8);
        } else {
            String dw = at.dw(this.goa.liveInfo.audienceCount);
            this.glU.setVisibility(0);
            this.glU.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, dw));
        }
        this.bxh.setText(this.goa.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.goa.recom_extra_img_night;
        } else {
            str = this.goa.recom_extra_img;
        }
        if (!StringUtils.isNull(str) && this.goa.recom_extra_img_width > 0 && this.goa.recom_extra_img_height > 0) {
            if (aVar.isLeft) {
                this.gnV.setConrers(1);
            } else if (aVar.isRight) {
                this.gnV.setConrers(0);
            } else if (aVar.ghM) {
                this.gnV.setConrers(1);
            } else {
                this.gnV.setConrers(0);
            }
            this.gnV.setRadius((int) glY);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gnV.getLayoutParams();
            if (layoutParams2 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                layoutParams2.height = dimensionPixelSize;
                layoutParams2.width = (int) ((this.goa.recom_extra_img_width / this.goa.recom_extra_img_height) * dimensionPixelSize);
                this.gnV.setLayoutParams(layoutParams2);
            }
            this.gnV.startLoad(str, 10, false);
            this.gnV.setVisibility(0);
        } else {
            this.gnV.setVisibility(8);
        }
        if (this.goa.liveInfo.haveRedpkg) {
            this.gnW.setVisibility(0);
        } else {
            this.gnW.setVisibility(8);
        }
        if (this.goa != null) {
            if (i == 2) {
                TiebaStatic.log(new aq("c12899").dR("tid", this.goa.tid));
            } else if (i == 1) {
                TiebaStatic.log(new aq("c12903").dR("tid", this.goa.tid));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.eGN) {
            aq aqVar = new aq("c13610");
            aqVar.dR("obj_param1", this.goa != null ? this.goa.liveId : "");
            aqVar.dR("fid", aVar.fid);
            aqVar.dR("fname", aVar.fname);
            aqVar.al("obj_locate", aVar.position);
            if (this.goa != null && this.goa.uiTransParam != null) {
                aqVar.dR("ab_tag", this.goa.uiTransParam.abTag);
                aqVar.dR("star_id", this.goa.uiTransParam.starId);
                aqVar.dR("extra", this.goa.uiTransParam.extra);
                aqVar.dR("source_from", this.goa.uiTransParam.sourceFrom);
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
            if (com.baidu.tieba.ala.alasquare.live_tab.c.a(this.goa)) {
                aq aqVar3 = new aq("c14007");
                aqVar3.al("obj_locate", 3);
                aqVar3.dR("obj_param1", this.goa.liveId);
                aqVar3.w("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(aqVar3);
            }
        }
        aqVar2.dR("obj_param1", this.goa == null ? "" : this.goa.liveId);
        aqVar2.dR("entryname", str2);
        TiebaStatic.log(aqVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.glU, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.bxh, (int) R.color.cp_cont_a);
            Drawable drawable = ap.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.glU.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.glU.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
