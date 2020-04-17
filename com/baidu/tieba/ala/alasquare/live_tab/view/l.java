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
    private static final float eRN = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] eRO = {0.0f, 0.0f, 0.0f, 0.0f, eRN, eRN, eRN, eRN};
    private static final float[] eRP = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, eRN, eRN};
    private static final float[] eRQ = {0.0f, 0.0f, 0.0f, 0.0f, eRN, eRN, 0.0f, 0.0f};
    public TbImageView eRH;
    public TextView eRI;
    public TextView eRK;
    public LinearLayout eRL;
    private AlphaAnimation eRV;
    public TbImageView eTH;
    public ImageView eTI;
    private com.baidu.tieba.ala.alasquare.a.a eTJ;
    private SdkLiveInfoData eTM;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabType;
    public int mSkinType = 3;
    private int[] eRR = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean eRU = false;
    private boolean eRW = true;
    private boolean eRX = false;
    private int eTK = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.ala.alasquare.live_tab.c.a(l.this.mTbPageContext.getPageActivity(), l.this.eTM);
            if (l.this.eTJ != null && l.this.eTM != null) {
                if (l.this.eTJ.dtP) {
                    an anVar = new an("c13611");
                    anVar.cI("obj_param1", l.this.eTM.liveId);
                    anVar.cI("fid", l.this.eTJ.fid);
                    anVar.cI("fname", l.this.eTJ.fname);
                    anVar.af("obj_locate", l.this.eTJ.position);
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
                anVar2.cI("obj_param1", l.this.eTM.liveId);
                anVar2.cI("entryname", str);
                TiebaStatic.log(anVar2);
            }
        }
    };

    public l(TbPageContext<?> tbPageContext, int i) {
        this.mTbPageContext = tbPageContext;
        this.tabType = i;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_live_item_view, (ViewGroup) null, false);
        this.eRH = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.eRH.setBorderSurroundContent(true);
        this.eRH.setDrawBorder(true);
        this.eRH.setPlaceHolder(2);
        this.eRH.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.eRI = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.eRK = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.eRL = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.eTH = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.eTI = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.eRV = new AlphaAnimation(0.0f, 1.0f);
        this.eRV.setDuration(200L);
        this.eRV.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                l.this.eRX = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                l.this.eRX = false;
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
        if (equipmentWidth != this.eTK) {
            ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
            int equipmentWidth2 = (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mRootView.getContext()) - this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds12)) - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(equipmentWidth2 / 2, equipmentWidth2 / 2);
            } else {
                layoutParams.width = equipmentWidth2 / 2;
                layoutParams.height = layoutParams.width;
            }
            this.mRootView.setLayoutParams(layoutParams);
            this.eTK = equipmentWidth;
        }
        if (aVar == null || aVar.eNJ == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.eTJ = aVar;
        this.eTM = aVar.eNJ;
        Object tag = this.eRH.getTag();
        if (this.eRW) {
            this.eRU = true;
            this.eRW = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.eTM.liveInfo.cover) && !((String) tag).equals(this.eTM.liveInfo.cover)) {
            this.eRU = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.eTM.liveInfo.cover) && !this.mCoverUrl.equals(this.eTM.liveInfo.cover)) {
            this.eRU = true;
        } else {
            this.eRU = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.eRR);
        this.mCoverUrl = this.eTM.liveInfo.cover;
        this.eRH.setTag(this.mCoverUrl);
        if (aVar.isLeft) {
            this.eRH.setConrers(5);
            gradientDrawable.setCornerRadii(eRP);
            this.eRH.setPlaceHolder(2);
        } else if (aVar.isRight) {
            this.eRH.setConrers(10);
            gradientDrawable.setCornerRadii(eRQ);
            this.eRH.setPlaceHolder(2);
        } else if (aVar.eNK) {
            this.eRH.setConrers(15);
            gradientDrawable.setCornerRadii(eRO);
            this.eRH.setPlaceHolder(2);
        }
        this.eRH.setRadius((int) eRN);
        this.eRH.startLoad(this.eTM.liveInfo.cover, 10, false);
        this.eRL.setBackgroundDrawable(gradientDrawable);
        this.eRH.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z && l.this.eRU && !l.this.eRX) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        l.this.eRH.startAnimation(l.this.eRV);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.eRI.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.ck(this.eTM.liveInfo.audienceCount)));
        this.eRK.setText(this.eTM.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.eTM.recom_extra_img_night;
        } else {
            str = this.eTM.recom_extra_img;
        }
        if (!StringUtils.isNull(str) && this.eTM.recom_extra_img_width > 0 && this.eTM.recom_extra_img_height > 0) {
            if (aVar.isLeft) {
                this.eTH.setConrers(1);
            } else if (aVar.isRight) {
                this.eTH.setConrers(0);
            } else if (aVar.eNK) {
                this.eTH.setConrers(1);
            } else {
                this.eTH.setConrers(0);
            }
            this.eTH.setRadius((int) eRN);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eTH.getLayoutParams();
            if (layoutParams2 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                layoutParams2.height = dimensionPixelSize;
                layoutParams2.width = (int) ((this.eTM.recom_extra_img_width / this.eTM.recom_extra_img_height) * dimensionPixelSize);
                this.eTH.setLayoutParams(layoutParams2);
            }
            this.eTH.startLoad(str, 10, false);
            this.eTH.setVisibility(0);
        } else {
            this.eTH.setVisibility(8);
        }
        if (this.eTM.liveInfo.haveRedpkg) {
            this.eTI.setVisibility(0);
        } else {
            this.eTI.setVisibility(8);
        }
        if (this.eTM != null) {
            if (i == 2) {
                TiebaStatic.log(new an("c12899").cI("tid", this.eTM.tid));
            } else if (i == 1) {
                TiebaStatic.log(new an("c12903").cI("tid", this.eTM.tid));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.dtP) {
            an anVar = new an("c13610");
            anVar.cI("obj_param1", this.eTM != null ? this.eTM.liveId : "");
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
        anVar2.cI("obj_param1", this.eTM == null ? "" : this.eTM.liveId);
        anVar2.cI("entryname", str2);
        TiebaStatic.log(anVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.eRI, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eRK, (int) R.color.cp_cont_a);
            Drawable drawable = am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.eRI.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.eRI.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
