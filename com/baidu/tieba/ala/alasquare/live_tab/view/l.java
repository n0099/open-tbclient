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
    private static final float fWg = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] fWh = {0.0f, 0.0f, 0.0f, 0.0f, fWg, fWg, fWg, fWg};
    private static final float[] fWi = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, fWg, fWg};
    private static final float[] fWj = {0.0f, 0.0f, 0.0f, 0.0f, fWg, fWg, 0.0f, 0.0f};
    public TbImageView fWa;
    public TextView fWb;
    public TextView fWd;
    public LinearLayout fWe;
    private AlphaAnimation fWo;
    public TbImageView fYd;
    public ImageView fYe;
    private com.baidu.tieba.ala.alasquare.a.a fYf;
    private SdkLiveInfoData fYi;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabType;
    public int mSkinType = 3;
    private int[] fWk = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean fWn = false;
    private boolean fWp = true;
    private boolean mIsAnimating = false;
    private int fYg = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.ala.alasquare.live_tab.c.a(l.this.mTbPageContext.getPageActivity(), l.this.fYi);
            if (l.this.fYf != null && l.this.fYi != null) {
                if (l.this.fYf.esy) {
                    aq aqVar = new aq("c13611");
                    aqVar.dK("obj_param1", l.this.fYi.liveId);
                    aqVar.dK("fid", l.this.fYf.fid);
                    aqVar.dK("fname", l.this.fYf.fname);
                    aqVar.aj("obj_locate", l.this.fYf.position);
                    if (l.this.fYi != null && l.this.fYi.uiTransParam != null) {
                        aqVar.dK("ab_tag", l.this.fYi.uiTransParam.abTag);
                        aqVar.dK("star_id", l.this.fYi.uiTransParam.starId);
                        aqVar.dK("extra", l.this.fYi.uiTransParam.extra);
                        aqVar.dK("source_from", l.this.fYi.uiTransParam.sourceFrom);
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
                } else if (103 == l.this.tabType) {
                    str = "交友";
                }
                aqVar2.dK("obj_param1", l.this.fYi.liveId);
                aqVar2.dK("entryname", str);
                TiebaStatic.log(aqVar2);
            }
        }
    };

    public l(TbPageContext<?> tbPageContext, int i) {
        this.mTbPageContext = tbPageContext;
        this.tabType = i;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_live_item_view, (ViewGroup) null, false);
        this.fWa = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.fWa.setBorderSurroundContent(true);
        this.fWa.setDrawBorder(true);
        this.fWa.setPlaceHolder(2);
        this.fWa.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.fWb = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.fWd = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.fWe = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.fYd = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.fYe = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.fWo = new AlphaAnimation(0.0f, 1.0f);
        this.fWo.setDuration(200L);
        this.fWo.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.1
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
        if (equipmentWidth != this.fYg) {
            ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
            int equipmentWidth2 = (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mRootView.getContext()) - this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds12)) - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(equipmentWidth2 / 2, equipmentWidth2 / 2);
            } else {
                layoutParams.width = equipmentWidth2 / 2;
                layoutParams.height = layoutParams.width;
            }
            this.mRootView.setLayoutParams(layoutParams);
            this.fYg = equipmentWidth;
        }
        if (aVar == null || aVar.fRT == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.fYf = aVar;
        this.fYi = aVar.fRT;
        Object tag = this.fWa.getTag();
        if (this.fWp) {
            this.fWn = true;
            this.fWp = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.fYi.liveInfo.cover) && !((String) tag).equals(this.fYi.liveInfo.cover)) {
            this.fWn = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.fYi.liveInfo.cover) && !this.mCoverUrl.equals(this.fYi.liveInfo.cover)) {
            this.fWn = true;
        } else {
            this.fWn = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.fWk);
        this.mCoverUrl = this.fYi.liveInfo.cover;
        this.fWa.setTag(this.mCoverUrl);
        if (aVar.isLeft) {
            this.fWa.setConrers(5);
            gradientDrawable.setCornerRadii(fWi);
            this.fWa.setPlaceHolder(2);
        } else if (aVar.isRight) {
            this.fWa.setConrers(10);
            gradientDrawable.setCornerRadii(fWj);
            this.fWa.setPlaceHolder(2);
        } else if (aVar.fRU) {
            this.fWa.setConrers(15);
            gradientDrawable.setCornerRadii(fWh);
            this.fWa.setPlaceHolder(2);
        }
        this.fWa.setRadius((int) fWg);
        this.fWa.startLoad(this.fYi.liveInfo.cover, 10, false);
        this.fWe.setBackgroundDrawable(gradientDrawable);
        this.fWa.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z && l.this.fWn && !l.this.mIsAnimating) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        l.this.fWa.startAnimation(l.this.fWo);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fWb.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, at.cY(this.fYi.liveInfo.audienceCount)));
        this.fWd.setText(this.fYi.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.fYi.recom_extra_img_night;
        } else {
            str = this.fYi.recom_extra_img;
        }
        if (!StringUtils.isNull(str) && this.fYi.recom_extra_img_width > 0 && this.fYi.recom_extra_img_height > 0) {
            if (aVar.isLeft) {
                this.fYd.setConrers(1);
            } else if (aVar.isRight) {
                this.fYd.setConrers(0);
            } else if (aVar.fRU) {
                this.fYd.setConrers(1);
            } else {
                this.fYd.setConrers(0);
            }
            this.fYd.setRadius((int) fWg);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fYd.getLayoutParams();
            if (layoutParams2 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                layoutParams2.height = dimensionPixelSize;
                layoutParams2.width = (int) ((this.fYi.recom_extra_img_width / this.fYi.recom_extra_img_height) * dimensionPixelSize);
                this.fYd.setLayoutParams(layoutParams2);
            }
            this.fYd.startLoad(str, 10, false);
            this.fYd.setVisibility(0);
        } else {
            this.fYd.setVisibility(8);
        }
        if (this.fYi.liveInfo.haveRedpkg) {
            this.fYe.setVisibility(0);
        } else {
            this.fYe.setVisibility(8);
        }
        if (this.fYi != null) {
            if (i == 2) {
                TiebaStatic.log(new aq("c12899").dK("tid", this.fYi.tid));
            } else if (i == 1) {
                TiebaStatic.log(new aq("c12903").dK("tid", this.fYi.tid));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.esy) {
            aq aqVar = new aq("c13610");
            aqVar.dK("obj_param1", this.fYi != null ? this.fYi.liveId : "");
            aqVar.dK("fid", aVar.fid);
            aqVar.dK("fname", aVar.fname);
            aqVar.aj("obj_locate", aVar.position);
            if (this.fYi != null && this.fYi.uiTransParam != null) {
                aqVar.dK("ab_tag", this.fYi.uiTransParam.abTag);
                aqVar.dK("star_id", this.fYi.uiTransParam.starId);
                aqVar.dK("extra", this.fYi.uiTransParam.extra);
                aqVar.dK("source_from", this.fYi.uiTransParam.sourceFrom);
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
        }
        aqVar2.dK("obj_param1", this.fYi == null ? "" : this.fYi.liveId);
        aqVar2.dK("entryname", str2);
        TiebaStatic.log(aqVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.fWb, R.color.cp_cont_a);
            ap.setViewTextColor(this.fWd, R.color.cp_cont_a);
            Drawable drawable = ap.getDrawable(this.mTbPageContext.getResources(), R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.fWb.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.fWb.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
