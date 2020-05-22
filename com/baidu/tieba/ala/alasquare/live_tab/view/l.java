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
    private static final float feA = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] feB = {0.0f, 0.0f, 0.0f, 0.0f, feA, feA, feA, feA};
    private static final float[] feC = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, feA, feA};
    private static final float[] feD = {0.0f, 0.0f, 0.0f, 0.0f, feA, feA, 0.0f, 0.0f};
    private AlphaAnimation feI;
    public TbImageView feu;
    public TextView fev;
    public TextView fex;
    public LinearLayout fey;
    public TbImageView fgu;
    public ImageView fgv;
    private com.baidu.tieba.ala.alasquare.a.a fgw;
    private SdkLiveInfoData fgz;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabType;
    public int mSkinType = 3;
    private int[] feE = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean feH = false;
    private boolean feJ = true;
    private boolean feK = false;
    private int fgx = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.ala.alasquare.live_tab.c.a(l.this.mTbPageContext.getPageActivity(), l.this.fgz);
            if (l.this.fgw != null && l.this.fgz != null) {
                if (l.this.fgw.dHL) {
                    an anVar = new an("c13611");
                    anVar.dh("obj_param1", l.this.fgz.liveId);
                    anVar.dh("fid", l.this.fgw.fid);
                    anVar.dh("fname", l.this.fgw.fname);
                    anVar.ag("obj_locate", l.this.fgw.position);
                    if (l.this.fgz != null && l.this.fgz.uiTransParam != null) {
                        anVar.dh("ab_tag", l.this.fgz.uiTransParam.abTag);
                        anVar.dh("star_id", l.this.fgz.uiTransParam.starId);
                        anVar.dh("extra", l.this.fgz.uiTransParam.extra);
                        anVar.dh("source_from", l.this.fgz.uiTransParam.sourceFrom);
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
                anVar2.dh("obj_param1", l.this.fgz.liveId);
                anVar2.dh("entryname", str);
                TiebaStatic.log(anVar2);
            }
        }
    };

    public l(TbPageContext<?> tbPageContext, int i) {
        this.mTbPageContext = tbPageContext;
        this.tabType = i;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_live_item_view, (ViewGroup) null, false);
        this.feu = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.feu.setBorderSurroundContent(true);
        this.feu.setDrawBorder(true);
        this.feu.setPlaceHolder(2);
        this.feu.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.fev = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.fex = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.fey = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.fgu = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.fgv = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.feI = new AlphaAnimation(0.0f, 1.0f);
        this.feI.setDuration(200L);
        this.feI.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                l.this.feK = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                l.this.feK = false;
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
        if (equipmentWidth != this.fgx) {
            ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
            int equipmentWidth2 = (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mRootView.getContext()) - this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds12)) - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(equipmentWidth2 / 2, equipmentWidth2 / 2);
            } else {
                layoutParams.width = equipmentWidth2 / 2;
                layoutParams.height = layoutParams.width;
            }
            this.mRootView.setLayoutParams(layoutParams);
            this.fgx = equipmentWidth;
        }
        if (aVar == null || aVar.fav == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.fgw = aVar;
        this.fgz = aVar.fav;
        Object tag = this.feu.getTag();
        if (this.feJ) {
            this.feH = true;
            this.feJ = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.fgz.liveInfo.cover) && !((String) tag).equals(this.fgz.liveInfo.cover)) {
            this.feH = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.fgz.liveInfo.cover) && !this.mCoverUrl.equals(this.fgz.liveInfo.cover)) {
            this.feH = true;
        } else {
            this.feH = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.feE);
        this.mCoverUrl = this.fgz.liveInfo.cover;
        this.feu.setTag(this.mCoverUrl);
        if (aVar.isLeft) {
            this.feu.setConrers(5);
            gradientDrawable.setCornerRadii(feC);
            this.feu.setPlaceHolder(2);
        } else if (aVar.isRight) {
            this.feu.setConrers(10);
            gradientDrawable.setCornerRadii(feD);
            this.feu.setPlaceHolder(2);
        } else if (aVar.faw) {
            this.feu.setConrers(15);
            gradientDrawable.setCornerRadii(feB);
            this.feu.setPlaceHolder(2);
        }
        this.feu.setRadius((int) feA);
        this.feu.startLoad(this.fgz.liveInfo.cover, 10, false);
        this.fey.setBackgroundDrawable(gradientDrawable);
        this.feu.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z && l.this.feH && !l.this.feK) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        l.this.feu.startAnimation(l.this.feI);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fev.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.cl(this.fgz.liveInfo.audienceCount)));
        this.fex.setText(this.fgz.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.fgz.recom_extra_img_night;
        } else {
            str = this.fgz.recom_extra_img;
        }
        if (!StringUtils.isNull(str) && this.fgz.recom_extra_img_width > 0 && this.fgz.recom_extra_img_height > 0) {
            if (aVar.isLeft) {
                this.fgu.setConrers(1);
            } else if (aVar.isRight) {
                this.fgu.setConrers(0);
            } else if (aVar.faw) {
                this.fgu.setConrers(1);
            } else {
                this.fgu.setConrers(0);
            }
            this.fgu.setRadius((int) feA);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fgu.getLayoutParams();
            if (layoutParams2 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                layoutParams2.height = dimensionPixelSize;
                layoutParams2.width = (int) ((this.fgz.recom_extra_img_width / this.fgz.recom_extra_img_height) * dimensionPixelSize);
                this.fgu.setLayoutParams(layoutParams2);
            }
            this.fgu.startLoad(str, 10, false);
            this.fgu.setVisibility(0);
        } else {
            this.fgu.setVisibility(8);
        }
        if (this.fgz.liveInfo.haveRedpkg) {
            this.fgv.setVisibility(0);
        } else {
            this.fgv.setVisibility(8);
        }
        if (this.fgz != null) {
            if (i == 2) {
                TiebaStatic.log(new an("c12899").dh("tid", this.fgz.tid));
            } else if (i == 1) {
                TiebaStatic.log(new an("c12903").dh("tid", this.fgz.tid));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.dHL) {
            an anVar = new an("c13610");
            anVar.dh("obj_param1", this.fgz != null ? this.fgz.liveId : "");
            anVar.dh("fid", aVar.fid);
            anVar.dh("fname", aVar.fname);
            anVar.ag("obj_locate", aVar.position);
            if (this.fgz != null && this.fgz.uiTransParam != null) {
                anVar.dh("ab_tag", this.fgz.uiTransParam.abTag);
                anVar.dh("star_id", this.fgz.uiTransParam.starId);
                anVar.dh("extra", this.fgz.uiTransParam.extra);
                anVar.dh("source_from", this.fgz.uiTransParam.sourceFrom);
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
        anVar2.dh("obj_param1", this.fgz == null ? "" : this.fgz.liveId);
        anVar2.dh("entryname", str2);
        TiebaStatic.log(anVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.fev, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.fex, (int) R.color.cp_cont_a);
            Drawable drawable = am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.fev.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.fev.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
