package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class h {
    public TextView bFN;
    public TbImageView gEK;
    public LinearLayout gEN;
    private AlphaAnimation gEX;
    public TbImageView gGN;
    private com.baidu.tieba.ala.alasquare.a.a gGP;
    public EMTextView gGT;
    private EMTextView gGU;
    public TbImageView gGV;
    private SdkLiveInfoData gGW;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabType;
    private static final int gGS = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds60);
    private static final float gEP = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] gEQ = {0.0f, 0.0f, 0.0f, 0.0f, gEP, gEP, gEP, gEP};
    private static final float[] gER = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, gEP, gEP};
    private static final float[] gES = {0.0f, 0.0f, 0.0f, 0.0f, gEP, gEP, 0.0f, 0.0f};
    public int mSkinType = 3;
    private int[] gET = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean gEW = false;
    private boolean gEY = true;
    private boolean gEZ = false;
    private int gGQ = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.h.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.tieba.ala.alasquare.live_tab.c.a(h.this.gGW)) {
                com.baidu.tieba.ala.alasquare.live_tab.c.a(h.this.mTbPageContext.getPageActivity(), h.this.gGW);
                if (h.this.gGP != null && h.this.gGW != null) {
                    if (h.this.gGP.eVe) {
                        ar arVar = new ar("c13611");
                        arVar.dR("obj_param1", h.this.gGW.liveId);
                        arVar.dR("fid", h.this.gGP.fid);
                        arVar.dR("fname", h.this.gGP.fname);
                        arVar.aq("obj_locate", h.this.gGP.position);
                        if (h.this.gGW != null && h.this.gGW.uiTransParam != null) {
                            arVar.dR("ab_tag", h.this.gGW.uiTransParam.abTag);
                            arVar.dR("star_id", h.this.gGW.uiTransParam.starId);
                            arVar.dR("extra", h.this.gGW.uiTransParam.extra);
                            arVar.dR(VideoPlayActivityConfig.SOURCE_FROM, h.this.gGW.uiTransParam.sourceFrom);
                        }
                        TiebaStatic.log(arVar);
                        return;
                    }
                    ar arVar2 = new ar("c13557");
                    String str = "";
                    if (101 == h.this.tabType) {
                        str = "推荐";
                    } else if (102 != h.this.tabType) {
                        if (103 == h.this.tabType) {
                            str = "交友";
                        }
                    } else {
                        str = "颜值";
                    }
                    arVar2.dR("obj_param1", h.this.gGW.liveId);
                    arVar2.dR("entryname", str);
                    TiebaStatic.log(arVar2);
                    return;
                }
                return;
            }
            String str2 = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MAIN;
            if (103 == h.this.tabType) {
                ar arVar3 = new ar("c14008");
                arVar3.aq("obj_locate", 3);
                arVar3.dR("obj_param1", h.this.gGW.liveId);
                arVar3.v("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(arVar3);
                str2 = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_FRIEND;
            }
            com.baidu.tieba.ala.alasquare.live_tab.c.a(h.this.mTbPageContext, h.this.gGW, str2);
        }
    };

    public h(TbPageContext<?> tbPageContext, int i) {
        this.mTbPageContext = tbPageContext;
        this.tabType = i;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_live_item_view, (ViewGroup) null, false);
        this.gEK = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.gEK.setBorderSurroundContent(true);
        this.gEK.setDrawBorder(true);
        this.gEK.setPlaceHolder(2);
        this.gEK.setBorderWidth(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.gGT = (EMTextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.bFN = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.gEN = (LinearLayout) this.mRootView.findViewById(R.id.tvInfoWrapper);
        this.gGN = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.gGV = (TbImageView) this.mRootView.findViewById(R.id.live_status_label);
        this.gGU = (EMTextView) this.mRootView.findViewById(R.id.tvLocation);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.gEX = new AlphaAnimation(0.0f, 1.0f);
        this.gEX.setDuration(200L);
        this.gEX.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.h.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                h.this.gEZ = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                h.this.gEZ = false;
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
        int equipmentWidth = l.getEquipmentWidth(this.mRootView.getContext());
        if (equipmentWidth != this.gGQ) {
            ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
            int equipmentWidth2 = (l.getEquipmentWidth(this.mRootView.getContext()) - this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds12)) - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(equipmentWidth2 / 2, equipmentWidth2 / 2);
            } else {
                layoutParams.width = equipmentWidth2 / 2;
                layoutParams.height = layoutParams.width;
            }
            this.mRootView.setLayoutParams(layoutParams);
            this.gGQ = equipmentWidth;
        }
        if (aVar == null || aVar.gAu == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gGP = aVar;
        this.gGW = aVar.gAu;
        Object tag = this.gEK.getTag();
        if (this.gEY) {
            this.gEW = true;
            this.gEY = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.gGW.liveInfo.cover) && !((String) tag).equals(this.gGW.liveInfo.cover)) {
            this.gEW = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.gGW.liveInfo.cover) && !this.mCoverUrl.equals(this.gGW.liveInfo.cover)) {
            this.gEW = true;
        } else {
            this.gEW = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.gET);
        this.mCoverUrl = this.gGW.liveInfo.cover;
        this.gEK.setTag(this.mCoverUrl);
        if (aVar.isLeft) {
            this.gEK.setConrers(5);
            gradientDrawable.setCornerRadii(gER);
            this.gEK.setPlaceHolder(2);
        } else if (aVar.isRight) {
            this.gEK.setConrers(10);
            gradientDrawable.setCornerRadii(gES);
            this.gEK.setPlaceHolder(2);
        } else if (aVar.gAv) {
            this.gEK.setConrers(15);
            gradientDrawable.setCornerRadii(gEQ);
            this.gEK.setPlaceHolder(2);
        }
        this.gEK.setRadius((int) gEP);
        this.gEK.startLoad(this.gGW.liveInfo.cover, 10, false);
        this.gEN.setBackgroundDrawable(gradientDrawable);
        this.gEK.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.h.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z && h.this.gEW && !h.this.gEZ) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        h.this.gEK.startAnimation(h.this.gEX);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        });
        if (this.gGW.liveInfo.audienceCount <= 0) {
            this.gGT.setVisibility(8);
            if (this.gGU.getVisibility() == 0) {
                bSh();
            }
        } else {
            String eb = au.eb(this.gGW.liveInfo.audienceCount);
            this.gGT.setVisibility(0);
            this.gGT.setText(eb);
            bSi();
        }
        if (103 == this.tabType) {
            if (!StringUtils.isNull(this.gGW.title)) {
                this.bFN.setText(this.gGW.title);
            }
        } else if (!StringUtils.isNull(this.gGW.liveAuthor.nameShow)) {
            this.bFN.setText(this.gGW.liveAuthor.nameShow);
        }
        if (!StringUtils.isNull(this.gGW.labelUrl)) {
            this.gGN.setVisibility(0);
            this.gGN.startLoad(this.gGW.labelUrl, 10, false);
            this.gGN.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.h.3
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onComplete(String str, boolean z) {
                    if (z) {
                        h.this.gGN.setLayoutParams(new RelativeLayout.LayoutParams(h.this.bC(h.this.gGN.getLoadedHeight(), h.this.gGN.getLoadedWidth()), h.gGS));
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onCancel() {
                }
            });
        } else {
            this.gGN.setVisibility(8);
        }
        if (!StringUtils.isNull(this.gGW.modeUrl)) {
            this.gGV.setVisibility(0);
            this.gGV.startLoad(this.gGW.modeUrl, 10, false);
            this.gGV.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.h.4
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onComplete(String str, boolean z) {
                    if (z) {
                        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(h.this.bC(h.this.gGV.getLoadedHeight(), h.this.gGV.getLoadedWidth()), h.gGS);
                        layoutParams2.addRule(11);
                        layoutParams2.rightMargin = h.this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.M_W_X004);
                        h.this.gGV.setLayoutParams(layoutParams2);
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onCancel() {
                }
            });
        } else {
            this.gGV.setVisibility(8);
        }
        if (!StringUtils.isNull(this.gGW.location)) {
            this.gGU.setVisibility(0);
            this.gGU.setText(this.gGW.location.length() <= 5 ? this.gGW.location : this.gGW.location.substring(0, 5) + StringHelper.STRING_MORE);
        } else {
            this.gGU.setVisibility(8);
        }
        if (this.gGW != null) {
            if (i == 2) {
                TiebaStatic.log(new ar("c12899").dR("tid", this.gGW.tid));
            } else if (i == 1) {
                TiebaStatic.log(new ar("c12903").dR("tid", this.gGW.tid));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.eVe) {
            ar arVar = new ar("c13610");
            arVar.dR("obj_param1", this.gGW != null ? this.gGW.liveId : "");
            arVar.dR("fid", aVar.fid);
            arVar.dR("fname", aVar.fname);
            arVar.aq("obj_locate", aVar.position);
            if (this.gGW != null && this.gGW.uiTransParam != null) {
                arVar.dR("ab_tag", this.gGW.uiTransParam.abTag);
                arVar.dR("star_id", this.gGW.uiTransParam.starId);
                arVar.dR("extra", this.gGW.uiTransParam.extra);
                arVar.dR(VideoPlayActivityConfig.SOURCE_FROM, this.gGW.uiTransParam.sourceFrom);
            }
            TiebaStatic.log(arVar);
            return;
        }
        ar arVar2 = new ar("c13544");
        String str = "";
        if (101 == this.tabType) {
            str = "推荐";
        } else if (102 == this.tabType) {
            str = "颜值";
        } else if (103 == this.tabType) {
            str = "交友";
            if (com.baidu.tieba.ala.alasquare.live_tab.c.a(this.gGW)) {
                ar arVar3 = new ar("c14007");
                arVar3.aq("obj_locate", 3);
                arVar3.dR("obj_param1", this.gGW.liveId);
                arVar3.v("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(arVar3);
            }
        }
        arVar2.dR("obj_param1", this.gGW == null ? "" : this.gGW.liveId);
        arVar2.dR("entryname", str);
        TiebaStatic.log(arVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.gGT, R.color.CAM_X0101);
            ap.setViewTextColor(this.bFN, R.color.CAM_X0101);
            ap.setViewTextColor(this.gGU, R.color.CAM_X0101);
            this.mSkinType = i;
        }
    }

    private void bSh() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.M_W_X004);
        layoutParams.bottomMargin = 0;
        this.gGU.setGravity(16);
        this.gGU.setLayoutParams(layoutParams);
    }

    private void bSi() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.M_W_X004);
        layoutParams.bottomMargin = this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.M_H_X002);
        this.gGU.setGravity(16);
        this.gGU.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bC(int i, int i2) {
        return (int) ((i2 / i) * gGS);
    }
}
