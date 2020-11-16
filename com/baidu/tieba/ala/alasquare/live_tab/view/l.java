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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class l {
    private static final float glF = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] glG = {0.0f, 0.0f, 0.0f, 0.0f, glF, glF, glF, glF};
    private static final float[] glH = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, glF, glF};
    private static final float[] glI = {0.0f, 0.0f, 0.0f, 0.0f, glF, glF, 0.0f, 0.0f};
    public TextView bvw;
    public TbImageView glA;
    public TextView glB;
    public LinearLayout glD;
    private AlphaAnimation glN;
    public TbImageView gnC;
    public ImageView gnD;
    private com.baidu.tieba.ala.alasquare.a.a gnE;
    private SdkLiveInfoData gnH;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabType;
    public int mSkinType = 3;
    private int[] glJ = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean glM = false;
    private boolean glO = true;
    private boolean mIsAnimating = false;
    private int gnF = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.tieba.ala.alasquare.live_tab.c.a(l.this.gnH)) {
                com.baidu.tieba.ala.alasquare.live_tab.c.a(l.this.mTbPageContext, l.this.gnH);
                if (103 == l.this.tabType) {
                    ar arVar = new ar("c14008");
                    arVar.ak("obj_locate", 3);
                    arVar.dR("obj_param1", l.this.gnH.liveId);
                    arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(arVar);
                    return;
                }
                return;
            }
            com.baidu.tieba.ala.alasquare.live_tab.c.a(l.this.mTbPageContext.getPageActivity(), l.this.gnH);
            if (l.this.gnE != null && l.this.gnH != null) {
                if (l.this.gnE.eFf) {
                    ar arVar2 = new ar("c13611");
                    arVar2.dR("obj_param1", l.this.gnH.liveId);
                    arVar2.dR("fid", l.this.gnE.fid);
                    arVar2.dR("fname", l.this.gnE.fname);
                    arVar2.ak("obj_locate", l.this.gnE.position);
                    if (l.this.gnH != null && l.this.gnH.uiTransParam != null) {
                        arVar2.dR("ab_tag", l.this.gnH.uiTransParam.abTag);
                        arVar2.dR("star_id", l.this.gnH.uiTransParam.starId);
                        arVar2.dR("extra", l.this.gnH.uiTransParam.extra);
                        arVar2.dR("source_from", l.this.gnH.uiTransParam.sourceFrom);
                    }
                    TiebaStatic.log(arVar2);
                    return;
                }
                ar arVar3 = new ar("c13557");
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
                arVar3.dR("obj_param1", l.this.gnH.liveId);
                arVar3.dR("entryname", str);
                TiebaStatic.log(arVar3);
            }
        }
    };

    public l(TbPageContext<?> tbPageContext, int i) {
        this.mTbPageContext = tbPageContext;
        this.tabType = i;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_live_item_view, (ViewGroup) null, false);
        this.glA = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.glA.setBorderSurroundContent(true);
        this.glA.setDrawBorder(true);
        this.glA.setPlaceHolder(2);
        this.glA.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.glB = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.bvw = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.glD = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.gnC = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.gnD = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.glN = new AlphaAnimation(0.0f, 1.0f);
        this.glN.setDuration(200L);
        this.glN.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.1
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
        if (equipmentWidth != this.gnF) {
            ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
            int equipmentWidth2 = (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mRootView.getContext()) - this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds12)) - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(equipmentWidth2 / 2, equipmentWidth2 / 2);
            } else {
                layoutParams.width = equipmentWidth2 / 2;
                layoutParams.height = layoutParams.width;
            }
            this.mRootView.setLayoutParams(layoutParams);
            this.gnF = equipmentWidth;
        }
        if (aVar == null || aVar.ghs == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gnE = aVar;
        this.gnH = aVar.ghs;
        Object tag = this.glA.getTag();
        if (this.glO) {
            this.glM = true;
            this.glO = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.gnH.liveInfo.cover) && !((String) tag).equals(this.gnH.liveInfo.cover)) {
            this.glM = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.gnH.liveInfo.cover) && !this.mCoverUrl.equals(this.gnH.liveInfo.cover)) {
            this.glM = true;
        } else {
            this.glM = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.glJ);
        this.mCoverUrl = this.gnH.liveInfo.cover;
        this.glA.setTag(this.mCoverUrl);
        if (aVar.isLeft) {
            this.glA.setConrers(5);
            gradientDrawable.setCornerRadii(glH);
            this.glA.setPlaceHolder(2);
        } else if (aVar.isRight) {
            this.glA.setConrers(10);
            gradientDrawable.setCornerRadii(glI);
            this.glA.setPlaceHolder(2);
        } else if (aVar.ght) {
            this.glA.setConrers(15);
            gradientDrawable.setCornerRadii(glG);
            this.glA.setPlaceHolder(2);
        }
        this.glA.setRadius((int) glF);
        this.glA.startLoad(this.gnH.liveInfo.cover, 10, false);
        this.glD.setBackgroundDrawable(gradientDrawable);
        this.glA.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z && l.this.glM && !l.this.mIsAnimating) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        l.this.glA.startAnimation(l.this.glN);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        if (this.gnH.liveInfo.audienceCount <= 0) {
            this.glB.setVisibility(8);
        } else {
            String dw = au.dw(this.gnH.liveInfo.audienceCount);
            this.glB.setVisibility(0);
            this.glB.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, dw));
        }
        this.bvw.setText(this.gnH.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.gnH.recom_extra_img_night;
        } else {
            str = this.gnH.recom_extra_img;
        }
        if (!StringUtils.isNull(str) && this.gnH.recom_extra_img_width > 0 && this.gnH.recom_extra_img_height > 0) {
            if (aVar.isLeft) {
                this.gnC.setConrers(1);
            } else if (aVar.isRight) {
                this.gnC.setConrers(0);
            } else if (aVar.ght) {
                this.gnC.setConrers(1);
            } else {
                this.gnC.setConrers(0);
            }
            this.gnC.setRadius((int) glF);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gnC.getLayoutParams();
            if (layoutParams2 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                layoutParams2.height = dimensionPixelSize;
                layoutParams2.width = (int) ((this.gnH.recom_extra_img_width / this.gnH.recom_extra_img_height) * dimensionPixelSize);
                this.gnC.setLayoutParams(layoutParams2);
            }
            this.gnC.startLoad(str, 10, false);
            this.gnC.setVisibility(0);
        } else {
            this.gnC.setVisibility(8);
        }
        if (this.gnH.liveInfo.haveRedpkg) {
            this.gnD.setVisibility(0);
        } else {
            this.gnD.setVisibility(8);
        }
        if (this.gnH != null) {
            if (i == 2) {
                TiebaStatic.log(new ar("c12899").dR("tid", this.gnH.tid));
            } else if (i == 1) {
                TiebaStatic.log(new ar("c12903").dR("tid", this.gnH.tid));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.eFf) {
            ar arVar = new ar("c13610");
            arVar.dR("obj_param1", this.gnH != null ? this.gnH.liveId : "");
            arVar.dR("fid", aVar.fid);
            arVar.dR("fname", aVar.fname);
            arVar.ak("obj_locate", aVar.position);
            if (this.gnH != null && this.gnH.uiTransParam != null) {
                arVar.dR("ab_tag", this.gnH.uiTransParam.abTag);
                arVar.dR("star_id", this.gnH.uiTransParam.starId);
                arVar.dR("extra", this.gnH.uiTransParam.extra);
                arVar.dR("source_from", this.gnH.uiTransParam.sourceFrom);
            }
            TiebaStatic.log(arVar);
            return;
        }
        ar arVar2 = new ar("c13544");
        String str2 = "";
        if (101 == this.tabType) {
            str2 = "推荐";
        } else if (102 == this.tabType) {
            str2 = "颜值";
        } else if (103 == this.tabType) {
            str2 = "交友";
            if (com.baidu.tieba.ala.alasquare.live_tab.c.a(this.gnH)) {
                ar arVar3 = new ar("c14007");
                arVar3.ak("obj_locate", 3);
                arVar3.dR("obj_param1", this.gnH.liveId);
                arVar3.w("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(arVar3);
            }
        }
        arVar2.dR("obj_param1", this.gnH == null ? "" : this.gnH.liveId);
        arVar2.dR("entryname", str2);
        TiebaStatic.log(arVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.glB, R.color.CAM_X0101);
            ap.setViewTextColor(this.bvw, R.color.CAM_X0101);
            Drawable drawable = ap.getDrawable(this.mTbPageContext.getResources(), R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.glB.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.glB.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
