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
    private static final float fJP = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] fJQ = {0.0f, 0.0f, 0.0f, 0.0f, fJP, fJP, fJP, fJP};
    private static final float[] fJR = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, fJP, fJP};
    private static final float[] fJS = {0.0f, 0.0f, 0.0f, 0.0f, fJP, fJP, 0.0f, 0.0f};
    public TbImageView fJJ;
    public TextView fJK;
    public TextView fJM;
    public LinearLayout fJN;
    private AlphaAnimation fJX;
    public TbImageView fLM;
    public ImageView fLN;
    private com.baidu.tieba.ala.alasquare.a.a fLO;
    private SdkLiveInfoData fLR;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabType;
    public int mSkinType = 3;
    private int[] fJT = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean fJW = false;
    private boolean fJY = true;
    private boolean mIsAnimating = false;
    private int fLP = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.ala.alasquare.live_tab.c.a(l.this.mTbPageContext.getPageActivity(), l.this.fLR);
            if (l.this.fLO != null && l.this.fLR != null) {
                if (l.this.fLO.egs) {
                    aq aqVar = new aq("c13611");
                    aqVar.dF("obj_param1", l.this.fLR.liveId);
                    aqVar.dF("fid", l.this.fLO.fid);
                    aqVar.dF("fname", l.this.fLO.fname);
                    aqVar.ai("obj_locate", l.this.fLO.position);
                    if (l.this.fLR != null && l.this.fLR.uiTransParam != null) {
                        aqVar.dF("ab_tag", l.this.fLR.uiTransParam.abTag);
                        aqVar.dF("star_id", l.this.fLR.uiTransParam.starId);
                        aqVar.dF("extra", l.this.fLR.uiTransParam.extra);
                        aqVar.dF("source_from", l.this.fLR.uiTransParam.sourceFrom);
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
                aqVar2.dF("obj_param1", l.this.fLR.liveId);
                aqVar2.dF("entryname", str);
                TiebaStatic.log(aqVar2);
            }
        }
    };

    public l(TbPageContext<?> tbPageContext, int i) {
        this.mTbPageContext = tbPageContext;
        this.tabType = i;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_live_item_view, (ViewGroup) null, false);
        this.fJJ = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.fJJ.setBorderSurroundContent(true);
        this.fJJ.setDrawBorder(true);
        this.fJJ.setPlaceHolder(2);
        this.fJJ.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.fJK = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.fJM = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.fJN = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.fLM = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.fLN = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.fJX = new AlphaAnimation(0.0f, 1.0f);
        this.fJX.setDuration(200L);
        this.fJX.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.1
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
        if (equipmentWidth != this.fLP) {
            ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
            int equipmentWidth2 = (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mRootView.getContext()) - this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds12)) - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(equipmentWidth2 / 2, equipmentWidth2 / 2);
            } else {
                layoutParams.width = equipmentWidth2 / 2;
                layoutParams.height = layoutParams.width;
            }
            this.mRootView.setLayoutParams(layoutParams);
            this.fLP = equipmentWidth;
        }
        if (aVar == null || aVar.fFK == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.fLO = aVar;
        this.fLR = aVar.fFK;
        Object tag = this.fJJ.getTag();
        if (this.fJY) {
            this.fJW = true;
            this.fJY = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.fLR.liveInfo.cover) && !((String) tag).equals(this.fLR.liveInfo.cover)) {
            this.fJW = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.fLR.liveInfo.cover) && !this.mCoverUrl.equals(this.fLR.liveInfo.cover)) {
            this.fJW = true;
        } else {
            this.fJW = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.fJT);
        this.mCoverUrl = this.fLR.liveInfo.cover;
        this.fJJ.setTag(this.mCoverUrl);
        if (aVar.isLeft) {
            this.fJJ.setConrers(5);
            gradientDrawable.setCornerRadii(fJR);
            this.fJJ.setPlaceHolder(2);
        } else if (aVar.isRight) {
            this.fJJ.setConrers(10);
            gradientDrawable.setCornerRadii(fJS);
            this.fJJ.setPlaceHolder(2);
        } else if (aVar.fFL) {
            this.fJJ.setConrers(15);
            gradientDrawable.setCornerRadii(fJQ);
            this.fJJ.setPlaceHolder(2);
        }
        this.fJJ.setRadius((int) fJP);
        this.fJJ.startLoad(this.fLR.liveInfo.cover, 10, false);
        this.fJN.setBackgroundDrawable(gradientDrawable);
        this.fJJ.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z && l.this.fJW && !l.this.mIsAnimating) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        l.this.fJJ.startAnimation(l.this.fJX);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fJK.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, at.cQ(this.fLR.liveInfo.audienceCount)));
        this.fJM.setText(this.fLR.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.fLR.recom_extra_img_night;
        } else {
            str = this.fLR.recom_extra_img;
        }
        if (!StringUtils.isNull(str) && this.fLR.recom_extra_img_width > 0 && this.fLR.recom_extra_img_height > 0) {
            if (aVar.isLeft) {
                this.fLM.setConrers(1);
            } else if (aVar.isRight) {
                this.fLM.setConrers(0);
            } else if (aVar.fFL) {
                this.fLM.setConrers(1);
            } else {
                this.fLM.setConrers(0);
            }
            this.fLM.setRadius((int) fJP);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fLM.getLayoutParams();
            if (layoutParams2 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                layoutParams2.height = dimensionPixelSize;
                layoutParams2.width = (int) ((this.fLR.recom_extra_img_width / this.fLR.recom_extra_img_height) * dimensionPixelSize);
                this.fLM.setLayoutParams(layoutParams2);
            }
            this.fLM.startLoad(str, 10, false);
            this.fLM.setVisibility(0);
        } else {
            this.fLM.setVisibility(8);
        }
        if (this.fLR.liveInfo.haveRedpkg) {
            this.fLN.setVisibility(0);
        } else {
            this.fLN.setVisibility(8);
        }
        if (this.fLR != null) {
            if (i == 2) {
                TiebaStatic.log(new aq("c12899").dF("tid", this.fLR.tid));
            } else if (i == 1) {
                TiebaStatic.log(new aq("c12903").dF("tid", this.fLR.tid));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.egs) {
            aq aqVar = new aq("c13610");
            aqVar.dF("obj_param1", this.fLR != null ? this.fLR.liveId : "");
            aqVar.dF("fid", aVar.fid);
            aqVar.dF("fname", aVar.fname);
            aqVar.ai("obj_locate", aVar.position);
            if (this.fLR != null && this.fLR.uiTransParam != null) {
                aqVar.dF("ab_tag", this.fLR.uiTransParam.abTag);
                aqVar.dF("star_id", this.fLR.uiTransParam.starId);
                aqVar.dF("extra", this.fLR.uiTransParam.extra);
                aqVar.dF("source_from", this.fLR.uiTransParam.sourceFrom);
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
        aqVar2.dF("obj_param1", this.fLR == null ? "" : this.fLR.liveId);
        aqVar2.dF("entryname", str2);
        TiebaStatic.log(aqVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.fJK, R.color.cp_cont_a);
            ap.setViewTextColor(this.fJM, R.color.cp_cont_a);
            Drawable drawable = ap.getDrawable(this.mTbPageContext.getResources(), R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.fJK.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.fJK.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
