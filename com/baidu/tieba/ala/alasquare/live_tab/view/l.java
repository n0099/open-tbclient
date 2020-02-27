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
    private static final float enK = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] enL = {0.0f, 0.0f, 0.0f, 0.0f, enK, enK, enK, enK};
    private static final float[] enM = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, enK, enK};
    private static final float[] enN = {0.0f, 0.0f, 0.0f, 0.0f, enK, enK, 0.0f, 0.0f};
    public TbImageView enE;
    public TextView enF;
    public TextView enH;
    public LinearLayout enI;
    private AlphaAnimation enS;
    public TbImageView epA;
    public ImageView epB;
    private com.baidu.tieba.ala.alasquare.a.a epC;
    private SdkLiveInfoData epF;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabType;
    public int mSkinType = 3;
    private int[] enO = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean enR = false;
    private boolean enT = true;
    private boolean enU = false;
    private int epD = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.ala.alasquare.live_tab.c.a(l.this.mTbPageContext.getPageActivity(), l.this.epF);
            if (l.this.epC != null && l.this.epF != null) {
                if (l.this.epC.cUp) {
                    an anVar = new an("c13611");
                    anVar.cy("obj_param1", l.this.epF.liveId);
                    anVar.cy("fid", l.this.epC.fid);
                    anVar.cy("fname", l.this.epC.fname);
                    anVar.X("obj_locate", l.this.epC.position);
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
                anVar2.cy("obj_param1", l.this.epF.liveId);
                anVar2.cy("entryname", str);
                TiebaStatic.log(anVar2);
            }
        }
    };

    public l(TbPageContext<?> tbPageContext, int i) {
        this.mTbPageContext = tbPageContext;
        this.tabType = i;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_live_item_view, (ViewGroup) null, false);
        this.enE = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.enE.setBorderSurroundContent(true);
        this.enE.setDrawBorder(true);
        this.enE.setPlaceHolder(2);
        this.enE.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.enF = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.enH = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.enI = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.epA = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.epB = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.enS = new AlphaAnimation(0.0f, 1.0f);
        this.enS.setDuration(200L);
        this.enS.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                l.this.enU = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                l.this.enU = false;
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
        if (equipmentWidth != this.epD) {
            ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
            int equipmentWidth2 = (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mRootView.getContext()) - this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds12)) - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(equipmentWidth2 / 2, equipmentWidth2 / 2);
            } else {
                layoutParams.width = equipmentWidth2 / 2;
                layoutParams.height = layoutParams.width;
            }
            this.mRootView.setLayoutParams(layoutParams);
            this.epD = equipmentWidth;
        }
        if (aVar == null || aVar.ejF == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.epC = aVar;
        this.epF = aVar.ejF;
        Object tag = this.enE.getTag();
        if (this.enT) {
            this.enR = true;
            this.enT = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.epF.liveInfo.cover) && !((String) tag).equals(this.epF.liveInfo.cover)) {
            this.enR = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.epF.liveInfo.cover) && !this.mCoverUrl.equals(this.epF.liveInfo.cover)) {
            this.enR = true;
        } else {
            this.enR = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.enO);
        this.mCoverUrl = this.epF.liveInfo.cover;
        this.enE.setTag(this.mCoverUrl);
        if (aVar.isLeft) {
            this.enE.setConrers(5);
            gradientDrawable.setCornerRadii(enM);
            this.enE.setPlaceHolder(2);
        } else if (aVar.isRight) {
            this.enE.setConrers(10);
            gradientDrawable.setCornerRadii(enN);
            this.enE.setPlaceHolder(2);
        } else if (aVar.ejG) {
            this.enE.setConrers(15);
            gradientDrawable.setCornerRadii(enL);
            this.enE.setPlaceHolder(2);
        }
        this.enE.setRadius((int) enK);
        this.enE.startLoad(this.epF.liveInfo.cover, 10, false);
        this.enI.setBackgroundDrawable(gradientDrawable);
        this.enE.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z && l.this.enR && !l.this.enU) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        l.this.enE.startAnimation(l.this.enS);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.enF.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.bE(this.epF.liveInfo.audienceCount)));
        this.enH.setText(this.epF.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.epF.recom_extra_img_night;
        } else {
            str = this.epF.recom_extra_img;
        }
        if (!StringUtils.isNull(str) && this.epF.recom_extra_img_width > 0 && this.epF.recom_extra_img_height > 0) {
            if (aVar.isLeft) {
                this.epA.setConrers(1);
            } else if (aVar.isRight) {
                this.epA.setConrers(0);
            } else if (aVar.ejG) {
                this.epA.setConrers(1);
            } else {
                this.epA.setConrers(0);
            }
            this.epA.setRadius((int) enK);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.epA.getLayoutParams();
            if (layoutParams2 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                layoutParams2.height = dimensionPixelSize;
                layoutParams2.width = (int) ((this.epF.recom_extra_img_width / this.epF.recom_extra_img_height) * dimensionPixelSize);
                this.epA.setLayoutParams(layoutParams2);
            }
            this.epA.startLoad(str, 10, false);
            this.epA.setVisibility(0);
        } else {
            this.epA.setVisibility(8);
        }
        if (this.epF.liveInfo.haveRedpkg) {
            this.epB.setVisibility(0);
        } else {
            this.epB.setVisibility(8);
        }
        if (this.epF != null) {
            if (i == 2) {
                TiebaStatic.log(new an("c12899").cy("tid", this.epF.tid));
            } else if (i == 1) {
                TiebaStatic.log(new an("c12903").cy("tid", this.epF.tid));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.cUp) {
            an anVar = new an("c13610");
            anVar.cy("obj_param1", this.epF != null ? this.epF.liveId : "");
            anVar.cy("fid", aVar.fid);
            anVar.cy("fname", aVar.fname);
            anVar.X("obj_locate", aVar.position);
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
        anVar2.cy("obj_param1", this.epF == null ? "" : this.epF.liveId);
        anVar2.cy("entryname", str2);
        TiebaStatic.log(anVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.enF, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.enH, (int) R.color.cp_cont_a);
            Drawable drawable = am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.enF.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.enF.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
