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
    private static final float enL = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] enM = {0.0f, 0.0f, 0.0f, 0.0f, enL, enL, enL, enL};
    private static final float[] enN = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, enL, enL};
    private static final float[] enO = {0.0f, 0.0f, 0.0f, 0.0f, enL, enL, 0.0f, 0.0f};
    public TbImageView enF;
    public TextView enG;
    public TextView enI;
    public LinearLayout enJ;
    private AlphaAnimation enT;
    public TbImageView epB;
    public ImageView epC;
    private com.baidu.tieba.ala.alasquare.a.a epD;
    private SdkLiveInfoData epG;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabType;
    public int mSkinType = 3;
    private int[] enP = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean enS = false;
    private boolean enU = true;
    private boolean enV = false;
    private int epE = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.ala.alasquare.live_tab.c.a(l.this.mTbPageContext.getPageActivity(), l.this.epG);
            if (l.this.epD != null && l.this.epG != null) {
                if (l.this.epD.cUq) {
                    an anVar = new an("c13611");
                    anVar.cy("obj_param1", l.this.epG.liveId);
                    anVar.cy("fid", l.this.epD.fid);
                    anVar.cy("fname", l.this.epD.fname);
                    anVar.X("obj_locate", l.this.epD.position);
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
                anVar2.cy("obj_param1", l.this.epG.liveId);
                anVar2.cy("entryname", str);
                TiebaStatic.log(anVar2);
            }
        }
    };

    public l(TbPageContext<?> tbPageContext, int i) {
        this.mTbPageContext = tbPageContext;
        this.tabType = i;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_live_item_view, (ViewGroup) null, false);
        this.enF = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.enF.setBorderSurroundContent(true);
        this.enF.setDrawBorder(true);
        this.enF.setPlaceHolder(2);
        this.enF.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.enG = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.enI = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.enJ = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.epB = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.epC = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.enT = new AlphaAnimation(0.0f, 1.0f);
        this.enT.setDuration(200L);
        this.enT.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                l.this.enV = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                l.this.enV = false;
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
        if (equipmentWidth != this.epE) {
            ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
            int equipmentWidth2 = (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mRootView.getContext()) - this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds12)) - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(equipmentWidth2 / 2, equipmentWidth2 / 2);
            } else {
                layoutParams.width = equipmentWidth2 / 2;
                layoutParams.height = layoutParams.width;
            }
            this.mRootView.setLayoutParams(layoutParams);
            this.epE = equipmentWidth;
        }
        if (aVar == null || aVar.ejG == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.epD = aVar;
        this.epG = aVar.ejG;
        Object tag = this.enF.getTag();
        if (this.enU) {
            this.enS = true;
            this.enU = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.epG.liveInfo.cover) && !((String) tag).equals(this.epG.liveInfo.cover)) {
            this.enS = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.epG.liveInfo.cover) && !this.mCoverUrl.equals(this.epG.liveInfo.cover)) {
            this.enS = true;
        } else {
            this.enS = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.enP);
        this.mCoverUrl = this.epG.liveInfo.cover;
        this.enF.setTag(this.mCoverUrl);
        if (aVar.isLeft) {
            this.enF.setConrers(5);
            gradientDrawable.setCornerRadii(enN);
            this.enF.setPlaceHolder(2);
        } else if (aVar.isRight) {
            this.enF.setConrers(10);
            gradientDrawable.setCornerRadii(enO);
            this.enF.setPlaceHolder(2);
        } else if (aVar.ejH) {
            this.enF.setConrers(15);
            gradientDrawable.setCornerRadii(enM);
            this.enF.setPlaceHolder(2);
        }
        this.enF.setRadius((int) enL);
        this.enF.startLoad(this.epG.liveInfo.cover, 10, false);
        this.enJ.setBackgroundDrawable(gradientDrawable);
        this.enF.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z && l.this.enS && !l.this.enV) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        l.this.enF.startAnimation(l.this.enT);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.enG.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.bE(this.epG.liveInfo.audienceCount)));
        this.enI.setText(this.epG.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.epG.recom_extra_img_night;
        } else {
            str = this.epG.recom_extra_img;
        }
        if (!StringUtils.isNull(str) && this.epG.recom_extra_img_width > 0 && this.epG.recom_extra_img_height > 0) {
            if (aVar.isLeft) {
                this.epB.setConrers(1);
            } else if (aVar.isRight) {
                this.epB.setConrers(0);
            } else if (aVar.ejH) {
                this.epB.setConrers(1);
            } else {
                this.epB.setConrers(0);
            }
            this.epB.setRadius((int) enL);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.epB.getLayoutParams();
            if (layoutParams2 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                layoutParams2.height = dimensionPixelSize;
                layoutParams2.width = (int) ((this.epG.recom_extra_img_width / this.epG.recom_extra_img_height) * dimensionPixelSize);
                this.epB.setLayoutParams(layoutParams2);
            }
            this.epB.startLoad(str, 10, false);
            this.epB.setVisibility(0);
        } else {
            this.epB.setVisibility(8);
        }
        if (this.epG.liveInfo.haveRedpkg) {
            this.epC.setVisibility(0);
        } else {
            this.epC.setVisibility(8);
        }
        if (this.epG != null) {
            if (i == 2) {
                TiebaStatic.log(new an("c12899").cy("tid", this.epG.tid));
            } else if (i == 1) {
                TiebaStatic.log(new an("c12903").cy("tid", this.epG.tid));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.cUq) {
            an anVar = new an("c13610");
            anVar.cy("obj_param1", this.epG != null ? this.epG.liveId : "");
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
        anVar2.cy("obj_param1", this.epG == null ? "" : this.epG.liveId);
        anVar2.cy("entryname", str2);
        TiebaStatic.log(anVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.enG, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.enI, (int) R.color.cp_cont_a);
            Drawable drawable = am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.enG.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.enG.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
