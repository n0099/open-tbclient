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
    private static final float gtO = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] gtP = {0.0f, 0.0f, 0.0f, 0.0f, gtO, gtO, gtO, gtO};
    private static final float[] gtQ = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, gtO, gtO};
    private static final float[] gtR = {0.0f, 0.0f, 0.0f, 0.0f, gtO, gtO, 0.0f, 0.0f};
    public TextView bAG;
    public TbImageView gtJ;
    public TextView gtK;
    public LinearLayout gtM;
    private AlphaAnimation gtW;
    public TbImageView gvL;
    public ImageView gvM;
    private com.baidu.tieba.ala.alasquare.a.a gvN;
    private SdkLiveInfoData gvQ;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabType;
    public int mSkinType = 3;
    private int[] gtS = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean gtV = false;
    private boolean gtX = true;
    private boolean mIsAnimating = false;
    private int gvO = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.tieba.ala.alasquare.live_tab.c.a(l.this.gvQ)) {
                com.baidu.tieba.ala.alasquare.live_tab.c.a(l.this.mTbPageContext.getPageActivity(), l.this.gvQ);
                if (l.this.gvN != null && l.this.gvQ != null) {
                    if (l.this.gvN.eMh) {
                        ar arVar = new ar("c13611");
                        arVar.dY("obj_param1", l.this.gvQ.liveId);
                        arVar.dY("fid", l.this.gvN.fid);
                        arVar.dY("fname", l.this.gvN.fname);
                        arVar.al("obj_locate", l.this.gvN.position);
                        if (l.this.gvQ != null && l.this.gvQ.uiTransParam != null) {
                            arVar.dY("ab_tag", l.this.gvQ.uiTransParam.abTag);
                            arVar.dY("star_id", l.this.gvQ.uiTransParam.starId);
                            arVar.dY("extra", l.this.gvQ.uiTransParam.extra);
                            arVar.dY("source_from", l.this.gvQ.uiTransParam.sourceFrom);
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
                    arVar2.dY("obj_param1", l.this.gvQ.liveId);
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
                arVar3.dY("obj_param1", l.this.gvQ.liveId);
                arVar3.w("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(arVar3);
                str2 = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_FRIEND;
            }
            com.baidu.tieba.ala.alasquare.live_tab.c.a(l.this.mTbPageContext, l.this.gvQ, str2);
        }
    };

    public l(TbPageContext<?> tbPageContext, int i) {
        this.mTbPageContext = tbPageContext;
        this.tabType = i;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_live_item_view, (ViewGroup) null, false);
        this.gtJ = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.gtJ.setBorderSurroundContent(true);
        this.gtJ.setDrawBorder(true);
        this.gtJ.setPlaceHolder(2);
        this.gtJ.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.gtK = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.bAG = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.gtM = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.gvL = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.gvM = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.gtW = new AlphaAnimation(0.0f, 1.0f);
        this.gtW.setDuration(200L);
        this.gtW.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.1
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
        if (equipmentWidth != this.gvO) {
            ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
            int equipmentWidth2 = (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mRootView.getContext()) - this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds12)) - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(equipmentWidth2 / 2, equipmentWidth2 / 2);
            } else {
                layoutParams.width = equipmentWidth2 / 2;
                layoutParams.height = layoutParams.width;
            }
            this.mRootView.setLayoutParams(layoutParams);
            this.gvO = equipmentWidth;
        }
        if (aVar == null || aVar.gpC == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gvN = aVar;
        this.gvQ = aVar.gpC;
        Object tag = this.gtJ.getTag();
        if (this.gtX) {
            this.gtV = true;
            this.gtX = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.gvQ.liveInfo.cover) && !((String) tag).equals(this.gvQ.liveInfo.cover)) {
            this.gtV = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.gvQ.liveInfo.cover) && !this.mCoverUrl.equals(this.gvQ.liveInfo.cover)) {
            this.gtV = true;
        } else {
            this.gtV = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.gtS);
        this.mCoverUrl = this.gvQ.liveInfo.cover;
        this.gtJ.setTag(this.mCoverUrl);
        if (aVar.isLeft) {
            this.gtJ.setConrers(5);
            gradientDrawable.setCornerRadii(gtQ);
            this.gtJ.setPlaceHolder(2);
        } else if (aVar.isRight) {
            this.gtJ.setConrers(10);
            gradientDrawable.setCornerRadii(gtR);
            this.gtJ.setPlaceHolder(2);
        } else if (aVar.gpD) {
            this.gtJ.setConrers(15);
            gradientDrawable.setCornerRadii(gtP);
            this.gtJ.setPlaceHolder(2);
        }
        this.gtJ.setRadius((int) gtO);
        this.gtJ.startLoad(this.gvQ.liveInfo.cover, 10, false);
        this.gtM.setBackgroundDrawable(gradientDrawable);
        this.gtJ.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z && l.this.gtV && !l.this.mIsAnimating) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        l.this.gtJ.startAnimation(l.this.gtW);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        if (this.gvQ.liveInfo.audienceCount <= 0) {
            this.gtK.setVisibility(8);
        } else {
            String dV = au.dV(this.gvQ.liveInfo.audienceCount);
            this.gtK.setVisibility(0);
            this.gtK.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, dV));
        }
        this.bAG.setText(this.gvQ.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.gvQ.recom_extra_img_night;
        } else {
            str = this.gvQ.recom_extra_img;
        }
        if (!StringUtils.isNull(str) && this.gvQ.recom_extra_img_width > 0 && this.gvQ.recom_extra_img_height > 0) {
            if (aVar.isLeft) {
                this.gvL.setConrers(1);
            } else if (aVar.isRight) {
                this.gvL.setConrers(0);
            } else if (aVar.gpD) {
                this.gvL.setConrers(1);
            } else {
                this.gvL.setConrers(0);
            }
            this.gvL.setRadius((int) gtO);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gvL.getLayoutParams();
            if (layoutParams2 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                layoutParams2.height = dimensionPixelSize;
                layoutParams2.width = (int) ((this.gvQ.recom_extra_img_width / this.gvQ.recom_extra_img_height) * dimensionPixelSize);
                this.gvL.setLayoutParams(layoutParams2);
            }
            this.gvL.startLoad(str, 10, false);
            this.gvL.setVisibility(0);
        } else {
            this.gvL.setVisibility(8);
        }
        if (this.gvQ.liveInfo.haveRedpkg) {
            this.gvM.setVisibility(0);
        } else {
            this.gvM.setVisibility(8);
        }
        if (this.gvQ != null) {
            if (i == 2) {
                TiebaStatic.log(new ar("c12899").dY("tid", this.gvQ.tid));
            } else if (i == 1) {
                TiebaStatic.log(new ar("c12903").dY("tid", this.gvQ.tid));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.eMh) {
            ar arVar = new ar("c13610");
            arVar.dY("obj_param1", this.gvQ != null ? this.gvQ.liveId : "");
            arVar.dY("fid", aVar.fid);
            arVar.dY("fname", aVar.fname);
            arVar.al("obj_locate", aVar.position);
            if (this.gvQ != null && this.gvQ.uiTransParam != null) {
                arVar.dY("ab_tag", this.gvQ.uiTransParam.abTag);
                arVar.dY("star_id", this.gvQ.uiTransParam.starId);
                arVar.dY("extra", this.gvQ.uiTransParam.extra);
                arVar.dY("source_from", this.gvQ.uiTransParam.sourceFrom);
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
            if (com.baidu.tieba.ala.alasquare.live_tab.c.a(this.gvQ)) {
                ar arVar3 = new ar("c14007");
                arVar3.al("obj_locate", 3);
                arVar3.dY("obj_param1", this.gvQ.liveId);
                arVar3.w("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(arVar3);
            }
        }
        arVar2.dY("obj_param1", this.gvQ == null ? "" : this.gvQ.liveId);
        arVar2.dY("entryname", str2);
        TiebaStatic.log(arVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.gtK, (int) R.color.CAM_X0101);
            ap.setViewTextColor(this.bAG, (int) R.color.CAM_X0101);
            Drawable drawable = ap.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.gtK.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.gtK.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
