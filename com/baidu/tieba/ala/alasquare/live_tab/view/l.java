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
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class l {
    private static final float gtQ = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] gtR = {0.0f, 0.0f, 0.0f, 0.0f, gtQ, gtQ, gtQ, gtQ};
    private static final float[] gtS = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, gtQ, gtQ};
    private static final float[] gtT = {0.0f, 0.0f, 0.0f, 0.0f, gtQ, gtQ, 0.0f, 0.0f};
    public TextView bAG;
    public TbImageView gtL;
    public TextView gtM;
    public LinearLayout gtO;
    private AlphaAnimation gtY;
    public TbImageView gvN;
    public ImageView gvO;
    private com.baidu.tieba.ala.alasquare.a.a gvP;
    private SdkLiveInfoData gvS;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabType;
    public int mSkinType = 3;
    private int[] gtU = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean gtX = false;
    private boolean gtZ = true;
    private boolean mIsAnimating = false;
    private int gvQ = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.tieba.ala.alasquare.live_tab.c.a(l.this.gvS)) {
                com.baidu.tieba.ala.alasquare.live_tab.c.a(l.this.mTbPageContext.getPageActivity(), l.this.gvS);
                if (l.this.gvP != null && l.this.gvS != null) {
                    if (l.this.gvP.eMh) {
                        ar arVar = new ar("c13611");
                        arVar.dY("obj_param1", l.this.gvS.liveId);
                        arVar.dY("fid", l.this.gvP.fid);
                        arVar.dY("fname", l.this.gvP.fname);
                        arVar.al("obj_locate", l.this.gvP.position);
                        if (l.this.gvS != null && l.this.gvS.uiTransParam != null) {
                            arVar.dY("ab_tag", l.this.gvS.uiTransParam.abTag);
                            arVar.dY("star_id", l.this.gvS.uiTransParam.starId);
                            arVar.dY("extra", l.this.gvS.uiTransParam.extra);
                            arVar.dY("source_from", l.this.gvS.uiTransParam.sourceFrom);
                        }
                        TiebaStatic.log(arVar);
                        return;
                    }
                    ar arVar2 = new ar("c13557");
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
                    arVar2.dY("obj_param1", l.this.gvS.liveId);
                    arVar2.dY("entryname", str);
                    TiebaStatic.log(arVar2);
                    return;
                }
                return;
            }
            String str2 = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MAIN;
            if (103 == l.this.tabType) {
                ar arVar3 = new ar("c14008");
                arVar3.al("obj_locate", 3);
                arVar3.dY("obj_param1", l.this.gvS.liveId);
                arVar3.w("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(arVar3);
                str2 = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_FRIEND;
            }
            com.baidu.tieba.ala.alasquare.live_tab.c.a(l.this.mTbPageContext, l.this.gvS, str2);
        }
    };

    public l(TbPageContext<?> tbPageContext, int i) {
        this.mTbPageContext = tbPageContext;
        this.tabType = i;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_live_item_view, (ViewGroup) null, false);
        this.gtL = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.gtL.setBorderSurroundContent(true);
        this.gtL.setDrawBorder(true);
        this.gtL.setPlaceHolder(2);
        this.gtL.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.gtM = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.bAG = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.gtO = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.gvN = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.gvO = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.gtY = new AlphaAnimation(0.0f, 1.0f);
        this.gtY.setDuration(200L);
        this.gtY.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.1
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
        if (equipmentWidth != this.gvQ) {
            ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
            int equipmentWidth2 = (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mRootView.getContext()) - this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds12)) - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(equipmentWidth2 / 2, equipmentWidth2 / 2);
            } else {
                layoutParams.width = equipmentWidth2 / 2;
                layoutParams.height = layoutParams.width;
            }
            this.mRootView.setLayoutParams(layoutParams);
            this.gvQ = equipmentWidth;
        }
        if (aVar == null || aVar.gpE == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gvP = aVar;
        this.gvS = aVar.gpE;
        Object tag = this.gtL.getTag();
        if (this.gtZ) {
            this.gtX = true;
            this.gtZ = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.gvS.liveInfo.cover) && !((String) tag).equals(this.gvS.liveInfo.cover)) {
            this.gtX = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.gvS.liveInfo.cover) && !this.mCoverUrl.equals(this.gvS.liveInfo.cover)) {
            this.gtX = true;
        } else {
            this.gtX = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.gtU);
        this.mCoverUrl = this.gvS.liveInfo.cover;
        this.gtL.setTag(this.mCoverUrl);
        if (aVar.isLeft) {
            this.gtL.setConrers(5);
            gradientDrawable.setCornerRadii(gtS);
            this.gtL.setPlaceHolder(2);
        } else if (aVar.isRight) {
            this.gtL.setConrers(10);
            gradientDrawable.setCornerRadii(gtT);
            this.gtL.setPlaceHolder(2);
        } else if (aVar.gpF) {
            this.gtL.setConrers(15);
            gradientDrawable.setCornerRadii(gtR);
            this.gtL.setPlaceHolder(2);
        }
        this.gtL.setRadius((int) gtQ);
        this.gtL.startLoad(this.gvS.liveInfo.cover, 10, false);
        this.gtO.setBackgroundDrawable(gradientDrawable);
        this.gtL.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z && l.this.gtX && !l.this.mIsAnimating) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        l.this.gtL.startAnimation(l.this.gtY);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        if (this.gvS.liveInfo.audienceCount <= 0) {
            this.gtM.setVisibility(8);
        } else {
            String dV = au.dV(this.gvS.liveInfo.audienceCount);
            this.gtM.setVisibility(0);
            this.gtM.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, dV));
        }
        this.bAG.setText(this.gvS.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.gvS.recom_extra_img_night;
        } else {
            str = this.gvS.recom_extra_img;
        }
        if (!StringUtils.isNull(str) && this.gvS.recom_extra_img_width > 0 && this.gvS.recom_extra_img_height > 0) {
            if (aVar.isLeft) {
                this.gvN.setConrers(1);
            } else if (aVar.isRight) {
                this.gvN.setConrers(0);
            } else if (aVar.gpF) {
                this.gvN.setConrers(1);
            } else {
                this.gvN.setConrers(0);
            }
            this.gvN.setRadius((int) gtQ);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gvN.getLayoutParams();
            if (layoutParams2 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                layoutParams2.height = dimensionPixelSize;
                layoutParams2.width = (int) ((this.gvS.recom_extra_img_width / this.gvS.recom_extra_img_height) * dimensionPixelSize);
                this.gvN.setLayoutParams(layoutParams2);
            }
            this.gvN.startLoad(str, 10, false);
            this.gvN.setVisibility(0);
        } else {
            this.gvN.setVisibility(8);
        }
        if (this.gvS.liveInfo.haveRedpkg) {
            this.gvO.setVisibility(0);
        } else {
            this.gvO.setVisibility(8);
        }
        if (this.gvS != null) {
            if (i == 2) {
                TiebaStatic.log(new ar("c12899").dY("tid", this.gvS.tid));
            } else if (i == 1) {
                TiebaStatic.log(new ar("c12903").dY("tid", this.gvS.tid));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.eMh) {
            ar arVar = new ar("c13610");
            arVar.dY("obj_param1", this.gvS != null ? this.gvS.liveId : "");
            arVar.dY("fid", aVar.fid);
            arVar.dY("fname", aVar.fname);
            arVar.al("obj_locate", aVar.position);
            if (this.gvS != null && this.gvS.uiTransParam != null) {
                arVar.dY("ab_tag", this.gvS.uiTransParam.abTag);
                arVar.dY("star_id", this.gvS.uiTransParam.starId);
                arVar.dY("extra", this.gvS.uiTransParam.extra);
                arVar.dY("source_from", this.gvS.uiTransParam.sourceFrom);
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
            if (com.baidu.tieba.ala.alasquare.live_tab.c.a(this.gvS)) {
                ar arVar3 = new ar("c14007");
                arVar3.al("obj_locate", 3);
                arVar3.dY("obj_param1", this.gvS.liveId);
                arVar3.w("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(arVar3);
            }
        }
        arVar2.dY("obj_param1", this.gvS == null ? "" : this.gvS.liveId);
        arVar2.dY("entryname", str2);
        TiebaStatic.log(arVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.gtM, (int) R.color.CAM_X0101);
            ap.setViewTextColor(this.bAG, (int) R.color.CAM_X0101);
            Drawable drawable = ap.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.gtM.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.gtM.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
