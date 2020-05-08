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
    private static final float eRS = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] eRT = {0.0f, 0.0f, 0.0f, 0.0f, eRS, eRS, eRS, eRS};
    private static final float[] eRU = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, eRS, eRS};
    private static final float[] eRV = {0.0f, 0.0f, 0.0f, 0.0f, eRS, eRS, 0.0f, 0.0f};
    public TbImageView eRM;
    public TextView eRN;
    public TextView eRP;
    public LinearLayout eRQ;
    private AlphaAnimation eSa;
    public TbImageView eTM;
    public ImageView eTN;
    private com.baidu.tieba.ala.alasquare.a.a eTO;
    private SdkLiveInfoData eTR;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabType;
    public int mSkinType = 3;
    private int[] eRW = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean eRZ = false;
    private boolean eSb = true;
    private boolean eSc = false;
    private int eTP = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.ala.alasquare.live_tab.c.a(l.this.mTbPageContext.getPageActivity(), l.this.eTR);
            if (l.this.eTO != null && l.this.eTR != null) {
                if (l.this.eTO.dtT) {
                    an anVar = new an("c13611");
                    anVar.cI("obj_param1", l.this.eTR.liveId);
                    anVar.cI("fid", l.this.eTO.fid);
                    anVar.cI("fname", l.this.eTO.fname);
                    anVar.af("obj_locate", l.this.eTO.position);
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
                anVar2.cI("obj_param1", l.this.eTR.liveId);
                anVar2.cI("entryname", str);
                TiebaStatic.log(anVar2);
            }
        }
    };

    public l(TbPageContext<?> tbPageContext, int i) {
        this.mTbPageContext = tbPageContext;
        this.tabType = i;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_live_item_view, (ViewGroup) null, false);
        this.eRM = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.eRM.setBorderSurroundContent(true);
        this.eRM.setDrawBorder(true);
        this.eRM.setPlaceHolder(2);
        this.eRM.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.eRN = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.eRP = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.eRQ = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.eTM = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.eTN = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.eSa = new AlphaAnimation(0.0f, 1.0f);
        this.eSa.setDuration(200L);
        this.eSa.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                l.this.eSc = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                l.this.eSc = false;
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
        if (equipmentWidth != this.eTP) {
            ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
            int equipmentWidth2 = (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mRootView.getContext()) - this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds12)) - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(equipmentWidth2 / 2, equipmentWidth2 / 2);
            } else {
                layoutParams.width = equipmentWidth2 / 2;
                layoutParams.height = layoutParams.width;
            }
            this.mRootView.setLayoutParams(layoutParams);
            this.eTP = equipmentWidth;
        }
        if (aVar == null || aVar.eNO == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.eTO = aVar;
        this.eTR = aVar.eNO;
        Object tag = this.eRM.getTag();
        if (this.eSb) {
            this.eRZ = true;
            this.eSb = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.eTR.liveInfo.cover) && !((String) tag).equals(this.eTR.liveInfo.cover)) {
            this.eRZ = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.eTR.liveInfo.cover) && !this.mCoverUrl.equals(this.eTR.liveInfo.cover)) {
            this.eRZ = true;
        } else {
            this.eRZ = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.eRW);
        this.mCoverUrl = this.eTR.liveInfo.cover;
        this.eRM.setTag(this.mCoverUrl);
        if (aVar.isLeft) {
            this.eRM.setConrers(5);
            gradientDrawable.setCornerRadii(eRU);
            this.eRM.setPlaceHolder(2);
        } else if (aVar.isRight) {
            this.eRM.setConrers(10);
            gradientDrawable.setCornerRadii(eRV);
            this.eRM.setPlaceHolder(2);
        } else if (aVar.eNP) {
            this.eRM.setConrers(15);
            gradientDrawable.setCornerRadii(eRT);
            this.eRM.setPlaceHolder(2);
        }
        this.eRM.setRadius((int) eRS);
        this.eRM.startLoad(this.eTR.liveInfo.cover, 10, false);
        this.eRQ.setBackgroundDrawable(gradientDrawable);
        this.eRM.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z && l.this.eRZ && !l.this.eSc) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        l.this.eRM.startAnimation(l.this.eSa);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.eRN.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.ck(this.eTR.liveInfo.audienceCount)));
        this.eRP.setText(this.eTR.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.eTR.recom_extra_img_night;
        } else {
            str = this.eTR.recom_extra_img;
        }
        if (!StringUtils.isNull(str) && this.eTR.recom_extra_img_width > 0 && this.eTR.recom_extra_img_height > 0) {
            if (aVar.isLeft) {
                this.eTM.setConrers(1);
            } else if (aVar.isRight) {
                this.eTM.setConrers(0);
            } else if (aVar.eNP) {
                this.eTM.setConrers(1);
            } else {
                this.eTM.setConrers(0);
            }
            this.eTM.setRadius((int) eRS);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eTM.getLayoutParams();
            if (layoutParams2 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                layoutParams2.height = dimensionPixelSize;
                layoutParams2.width = (int) ((this.eTR.recom_extra_img_width / this.eTR.recom_extra_img_height) * dimensionPixelSize);
                this.eTM.setLayoutParams(layoutParams2);
            }
            this.eTM.startLoad(str, 10, false);
            this.eTM.setVisibility(0);
        } else {
            this.eTM.setVisibility(8);
        }
        if (this.eTR.liveInfo.haveRedpkg) {
            this.eTN.setVisibility(0);
        } else {
            this.eTN.setVisibility(8);
        }
        if (this.eTR != null) {
            if (i == 2) {
                TiebaStatic.log(new an("c12899").cI("tid", this.eTR.tid));
            } else if (i == 1) {
                TiebaStatic.log(new an("c12903").cI("tid", this.eTR.tid));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.dtT) {
            an anVar = new an("c13610");
            anVar.cI("obj_param1", this.eTR != null ? this.eTR.liveId : "");
            anVar.cI("fid", aVar.fid);
            anVar.cI("fname", aVar.fname);
            anVar.af("obj_locate", aVar.position);
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
        anVar2.cI("obj_param1", this.eTR == null ? "" : this.eTR.liveId);
        anVar2.cI("entryname", str2);
        TiebaStatic.log(anVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.eRN, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eRP, (int) R.color.cp_cont_a);
            Drawable drawable = am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.eRN.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.eRN.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
