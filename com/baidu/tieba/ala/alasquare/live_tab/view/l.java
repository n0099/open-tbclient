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
    private static final float enY = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] enZ = {0.0f, 0.0f, 0.0f, 0.0f, enY, enY, enY, enY};
    private static final float[] eoa = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, enY, enY};
    private static final float[] eob = {0.0f, 0.0f, 0.0f, 0.0f, enY, enY, 0.0f, 0.0f};
    public TbImageView enS;
    public TextView enT;
    public TextView enV;
    public LinearLayout enW;
    private AlphaAnimation eoh;
    public TbImageView epO;
    public ImageView epP;
    private com.baidu.tieba.ala.alasquare.a.a epQ;
    private SdkLiveInfoData epT;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabType;
    public int mSkinType = 3;
    private int[] eoc = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean eog = false;
    private boolean eoi = true;
    private boolean eoj = false;
    private int epR = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.ala.alasquare.live_tab.c.a(l.this.mTbPageContext.getPageActivity(), l.this.epT);
            if (l.this.epQ != null && l.this.epT != null) {
                if (l.this.epQ.cUr) {
                    an anVar = new an("c13611");
                    anVar.cy("obj_param1", l.this.epT.liveId);
                    anVar.cy("fid", l.this.epQ.fid);
                    anVar.cy("fname", l.this.epQ.fname);
                    anVar.X("obj_locate", l.this.epQ.position);
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
                anVar2.cy("obj_param1", l.this.epT.liveId);
                anVar2.cy("entryname", str);
                TiebaStatic.log(anVar2);
            }
        }
    };

    public l(TbPageContext<?> tbPageContext, int i) {
        this.mTbPageContext = tbPageContext;
        this.tabType = i;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_live_item_view, (ViewGroup) null, false);
        this.enS = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.enS.setBorderSurroundContent(true);
        this.enS.setDrawBorder(true);
        this.enS.setPlaceHolder(2);
        this.enS.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.enT = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.enV = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.enW = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.epO = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.epP = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.eoh = new AlphaAnimation(0.0f, 1.0f);
        this.eoh.setDuration(200L);
        this.eoh.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                l.this.eoj = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                l.this.eoj = false;
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
        if (equipmentWidth != this.epR) {
            ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
            int equipmentWidth2 = (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mRootView.getContext()) - this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds12)) - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(equipmentWidth2 / 2, equipmentWidth2 / 2);
            } else {
                layoutParams.width = equipmentWidth2 / 2;
                layoutParams.height = layoutParams.width;
            }
            this.mRootView.setLayoutParams(layoutParams);
            this.epR = equipmentWidth;
        }
        if (aVar == null || aVar.ejT == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.epQ = aVar;
        this.epT = aVar.ejT;
        Object tag = this.enS.getTag();
        if (this.eoi) {
            this.eog = true;
            this.eoi = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.epT.liveInfo.cover) && !((String) tag).equals(this.epT.liveInfo.cover)) {
            this.eog = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.epT.liveInfo.cover) && !this.mCoverUrl.equals(this.epT.liveInfo.cover)) {
            this.eog = true;
        } else {
            this.eog = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.eoc);
        this.mCoverUrl = this.epT.liveInfo.cover;
        this.enS.setTag(this.mCoverUrl);
        if (aVar.isLeft) {
            this.enS.setConrers(5);
            gradientDrawable.setCornerRadii(eoa);
            this.enS.setPlaceHolder(2);
        } else if (aVar.isRight) {
            this.enS.setConrers(10);
            gradientDrawable.setCornerRadii(eob);
            this.enS.setPlaceHolder(2);
        } else if (aVar.ejU) {
            this.enS.setConrers(15);
            gradientDrawable.setCornerRadii(enZ);
            this.enS.setPlaceHolder(2);
        }
        this.enS.setRadius((int) enY);
        this.enS.startLoad(this.epT.liveInfo.cover, 10, false);
        this.enW.setBackgroundDrawable(gradientDrawable);
        this.enS.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z && l.this.eog && !l.this.eoj) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        l.this.enS.startAnimation(l.this.eoh);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.enT.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.bE(this.epT.liveInfo.audienceCount)));
        this.enV.setText(this.epT.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.epT.recom_extra_img_night;
        } else {
            str = this.epT.recom_extra_img;
        }
        if (!StringUtils.isNull(str) && this.epT.recom_extra_img_width > 0 && this.epT.recom_extra_img_height > 0) {
            if (aVar.isLeft) {
                this.epO.setConrers(1);
            } else if (aVar.isRight) {
                this.epO.setConrers(0);
            } else if (aVar.ejU) {
                this.epO.setConrers(1);
            } else {
                this.epO.setConrers(0);
            }
            this.epO.setRadius((int) enY);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.epO.getLayoutParams();
            if (layoutParams2 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                layoutParams2.height = dimensionPixelSize;
                layoutParams2.width = (int) ((this.epT.recom_extra_img_width / this.epT.recom_extra_img_height) * dimensionPixelSize);
                this.epO.setLayoutParams(layoutParams2);
            }
            this.epO.startLoad(str, 10, false);
            this.epO.setVisibility(0);
        } else {
            this.epO.setVisibility(8);
        }
        if (this.epT.liveInfo.haveRedpkg) {
            this.epP.setVisibility(0);
        } else {
            this.epP.setVisibility(8);
        }
        if (this.epT != null) {
            if (i == 2) {
                TiebaStatic.log(new an("c12899").cy("tid", this.epT.tid));
            } else if (i == 1) {
                TiebaStatic.log(new an("c12903").cy("tid", this.epT.tid));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.cUr) {
            an anVar = new an("c13610");
            anVar.cy("obj_param1", this.epT != null ? this.epT.liveId : "");
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
        anVar2.cy("obj_param1", this.epT == null ? "" : this.epT.liveId);
        anVar2.cy("entryname", str2);
        TiebaStatic.log(anVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.enT, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.enV, (int) R.color.cp_cont_a);
            Drawable drawable = am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.enT.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.enT.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
