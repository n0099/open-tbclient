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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class l {
    private static final float fpW = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] fpX = {0.0f, 0.0f, 0.0f, 0.0f, fpW, fpW, fpW, fpW};
    private static final float[] fpY = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, fpW, fpW};
    private static final float[] fpZ = {0.0f, 0.0f, 0.0f, 0.0f, fpW, fpW, 0.0f, 0.0f};
    public TbImageView fpQ;
    public TextView fpR;
    public TextView fpT;
    public LinearLayout fpU;
    private AlphaAnimation fqe;
    public TbImageView frT;
    public ImageView frU;
    private com.baidu.tieba.ala.alasquare.a.a frV;
    private SdkLiveInfoData frY;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabType;
    public int mSkinType = 3;
    private int[] fqa = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean fqd = false;
    private boolean fqf = true;
    private boolean fqg = false;
    private int frW = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.ala.alasquare.live_tab.c.a(l.this.mTbPageContext.getPageActivity(), l.this.frY);
            if (l.this.frV != null && l.this.frY != null) {
                if (l.this.frV.dOx) {
                    ao aoVar = new ao("c13611");
                    aoVar.dk("obj_param1", l.this.frY.liveId);
                    aoVar.dk("fid", l.this.frV.fid);
                    aoVar.dk("fname", l.this.frV.fname);
                    aoVar.ag("obj_locate", l.this.frV.position);
                    if (l.this.frY != null && l.this.frY.uiTransParam != null) {
                        aoVar.dk("ab_tag", l.this.frY.uiTransParam.abTag);
                        aoVar.dk("star_id", l.this.frY.uiTransParam.starId);
                        aoVar.dk("extra", l.this.frY.uiTransParam.extra);
                        aoVar.dk("source_from", l.this.frY.uiTransParam.sourceFrom);
                    }
                    TiebaStatic.log(aoVar);
                    return;
                }
                ao aoVar2 = new ao("c13557");
                String str = "";
                if (101 == l.this.tabType) {
                    str = "推荐";
                } else if (102 == l.this.tabType) {
                    str = "颜值";
                }
                aoVar2.dk("obj_param1", l.this.frY.liveId);
                aoVar2.dk("entryname", str);
                TiebaStatic.log(aoVar2);
            }
        }
    };

    public l(TbPageContext<?> tbPageContext, int i) {
        this.mTbPageContext = tbPageContext;
        this.tabType = i;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_live_item_view, (ViewGroup) null, false);
        this.fpQ = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.fpQ.setBorderSurroundContent(true);
        this.fpQ.setDrawBorder(true);
        this.fpQ.setPlaceHolder(2);
        this.fpQ.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.fpR = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.fpT = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.fpU = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.frT = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.frU = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.fqe = new AlphaAnimation(0.0f, 1.0f);
        this.fqe.setDuration(200L);
        this.fqe.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                l.this.fqg = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                l.this.fqg = false;
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
        if (equipmentWidth != this.frW) {
            ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
            int equipmentWidth2 = (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mRootView.getContext()) - this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds12)) - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(equipmentWidth2 / 2, equipmentWidth2 / 2);
            } else {
                layoutParams.width = equipmentWidth2 / 2;
                layoutParams.height = layoutParams.width;
            }
            this.mRootView.setLayoutParams(layoutParams);
            this.frW = equipmentWidth;
        }
        if (aVar == null || aVar.flQ == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.frV = aVar;
        this.frY = aVar.flQ;
        Object tag = this.fpQ.getTag();
        if (this.fqf) {
            this.fqd = true;
            this.fqf = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.frY.liveInfo.cover) && !((String) tag).equals(this.frY.liveInfo.cover)) {
            this.fqd = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.frY.liveInfo.cover) && !this.mCoverUrl.equals(this.frY.liveInfo.cover)) {
            this.fqd = true;
        } else {
            this.fqd = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.fqa);
        this.mCoverUrl = this.frY.liveInfo.cover;
        this.fpQ.setTag(this.mCoverUrl);
        if (aVar.isLeft) {
            this.fpQ.setConrers(5);
            gradientDrawable.setCornerRadii(fpY);
            this.fpQ.setPlaceHolder(2);
        } else if (aVar.isRight) {
            this.fpQ.setConrers(10);
            gradientDrawable.setCornerRadii(fpZ);
            this.fpQ.setPlaceHolder(2);
        } else if (aVar.flR) {
            this.fpQ.setConrers(15);
            gradientDrawable.setCornerRadii(fpX);
            this.fpQ.setPlaceHolder(2);
        }
        this.fpQ.setRadius((int) fpW);
        this.fpQ.startLoad(this.frY.liveInfo.cover, 10, false);
        this.fpU.setBackgroundDrawable(gradientDrawable);
        this.fpQ.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z && l.this.fqd && !l.this.fqg) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        l.this.fpQ.startAnimation(l.this.fqe);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fpR.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, ar.cm(this.frY.liveInfo.audienceCount)));
        this.fpT.setText(this.frY.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.frY.recom_extra_img_night;
        } else {
            str = this.frY.recom_extra_img;
        }
        if (!StringUtils.isNull(str) && this.frY.recom_extra_img_width > 0 && this.frY.recom_extra_img_height > 0) {
            if (aVar.isLeft) {
                this.frT.setConrers(1);
            } else if (aVar.isRight) {
                this.frT.setConrers(0);
            } else if (aVar.flR) {
                this.frT.setConrers(1);
            } else {
                this.frT.setConrers(0);
            }
            this.frT.setRadius((int) fpW);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.frT.getLayoutParams();
            if (layoutParams2 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                layoutParams2.height = dimensionPixelSize;
                layoutParams2.width = (int) ((this.frY.recom_extra_img_width / this.frY.recom_extra_img_height) * dimensionPixelSize);
                this.frT.setLayoutParams(layoutParams2);
            }
            this.frT.startLoad(str, 10, false);
            this.frT.setVisibility(0);
        } else {
            this.frT.setVisibility(8);
        }
        if (this.frY.liveInfo.haveRedpkg) {
            this.frU.setVisibility(0);
        } else {
            this.frU.setVisibility(8);
        }
        if (this.frY != null) {
            if (i == 2) {
                TiebaStatic.log(new ao("c12899").dk("tid", this.frY.tid));
            } else if (i == 1) {
                TiebaStatic.log(new ao("c12903").dk("tid", this.frY.tid));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.dOx) {
            ao aoVar = new ao("c13610");
            aoVar.dk("obj_param1", this.frY != null ? this.frY.liveId : "");
            aoVar.dk("fid", aVar.fid);
            aoVar.dk("fname", aVar.fname);
            aoVar.ag("obj_locate", aVar.position);
            if (this.frY != null && this.frY.uiTransParam != null) {
                aoVar.dk("ab_tag", this.frY.uiTransParam.abTag);
                aoVar.dk("star_id", this.frY.uiTransParam.starId);
                aoVar.dk("extra", this.frY.uiTransParam.extra);
                aoVar.dk("source_from", this.frY.uiTransParam.sourceFrom);
            }
            TiebaStatic.log(aoVar);
            return;
        }
        ao aoVar2 = new ao("c13544");
        String str2 = "";
        if (101 == this.tabType) {
            str2 = "推荐";
        } else if (102 == this.tabType) {
            str2 = "颜值";
        }
        aoVar2.dk("obj_param1", this.frY == null ? "" : this.frY.liveId);
        aoVar2.dk("entryname", str2);
        TiebaStatic.log(aoVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            an.setViewTextColor(this.fpR, (int) R.color.cp_cont_a);
            an.setViewTextColor(this.fpT, (int) R.color.cp_cont_a);
            Drawable drawable = an.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.fpR.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.fpR.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
