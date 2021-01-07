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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class h {
    public TextView bFt;
    public TbImageView gEK;
    public LinearLayout gEN;
    private AlphaAnimation gEX;
    public TbImageView gGM;
    private com.baidu.tieba.ala.alasquare.a.a gGO;
    public EMTextView gGS;
    private EMTextView gGT;
    public TbImageView gGU;
    private SdkLiveInfoData gGV;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabType;
    private static final int gGR = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds60);
    private static final float gEP = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] gEQ = {0.0f, 0.0f, 0.0f, 0.0f, gEP, gEP, gEP, gEP};
    private static final float[] gER = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, gEP, gEP};
    private static final float[] gES = {0.0f, 0.0f, 0.0f, 0.0f, gEP, gEP, 0.0f, 0.0f};
    public int mSkinType = 3;
    private int[] gET = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean gEW = false;
    private boolean gEY = true;
    private boolean mIsAnimating = false;
    private int gGP = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.h.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.tieba.ala.alasquare.live_tab.c.a(h.this.gGV)) {
                com.baidu.tieba.ala.alasquare.live_tab.c.a(h.this.mTbPageContext.getPageActivity(), h.this.gGV);
                if (h.this.gGO != null && h.this.gGV != null) {
                    if (h.this.gGO.eWc) {
                        aq aqVar = new aq("c13611");
                        aqVar.dX("obj_param1", h.this.gGV.liveId);
                        aqVar.dX("fid", h.this.gGO.fid);
                        aqVar.dX("fname", h.this.gGO.fname);
                        aqVar.an("obj_locate", h.this.gGO.position);
                        if (h.this.gGV != null && h.this.gGV.uiTransParam != null) {
                            aqVar.dX("ab_tag", h.this.gGV.uiTransParam.abTag);
                            aqVar.dX("star_id", h.this.gGV.uiTransParam.starId);
                            aqVar.dX("extra", h.this.gGV.uiTransParam.extra);
                            aqVar.dX(VideoPlayActivityConfig.SOURCE_FROM, h.this.gGV.uiTransParam.sourceFrom);
                        }
                        TiebaStatic.log(aqVar);
                        return;
                    }
                    aq aqVar2 = new aq("c13557");
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
                    aqVar2.dX("obj_param1", h.this.gGV.liveId);
                    aqVar2.dX("entryname", str);
                    TiebaStatic.log(aqVar2);
                    return;
                }
                return;
            }
            String str2 = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MAIN;
            if (103 == h.this.tabType) {
                aq aqVar3 = new aq("c14008");
                aqVar3.an("obj_locate", 3);
                aqVar3.dX("obj_param1", h.this.gGV.liveId);
                aqVar3.w("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(aqVar3);
                str2 = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_FRIEND;
            }
            com.baidu.tieba.ala.alasquare.live_tab.c.a(h.this.mTbPageContext, h.this.gGV, str2);
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
        this.gGS = (EMTextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.bFt = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.gEN = (LinearLayout) this.mRootView.findViewById(R.id.tvInfoWrapper);
        this.gGM = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.gGU = (TbImageView) this.mRootView.findViewById(R.id.live_status_label);
        this.gGT = (EMTextView) this.mRootView.findViewById(R.id.tvLocation);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.gEX = new AlphaAnimation(0.0f, 1.0f);
        this.gEX.setDuration(200L);
        this.gEX.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.h.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                h.this.mIsAnimating = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                h.this.mIsAnimating = false;
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
        if (equipmentWidth != this.gGP) {
            ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
            int equipmentWidth2 = (l.getEquipmentWidth(this.mRootView.getContext()) - this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds12)) - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(equipmentWidth2 / 2, equipmentWidth2 / 2);
            } else {
                layoutParams.width = equipmentWidth2 / 2;
                layoutParams.height = layoutParams.width;
            }
            this.mRootView.setLayoutParams(layoutParams);
            this.gGP = equipmentWidth;
        }
        if (aVar == null || aVar.gAu == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gGO = aVar;
        this.gGV = aVar.gAu;
        Object tag = this.gEK.getTag();
        if (this.gEY) {
            this.gEW = true;
            this.gEY = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.gGV.liveInfo.cover) && !((String) tag).equals(this.gGV.liveInfo.cover)) {
            this.gEW = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.gGV.liveInfo.cover) && !this.mCoverUrl.equals(this.gGV.liveInfo.cover)) {
            this.gEW = true;
        } else {
            this.gEW = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.gET);
        this.mCoverUrl = this.gGV.liveInfo.cover;
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
        this.gEK.startLoad(this.gGV.liveInfo.cover, 10, false);
        this.gEN.setBackgroundDrawable(gradientDrawable);
        this.gEK.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.h.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z && h.this.gEW && !h.this.mIsAnimating) {
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
        if (this.gGV.liveInfo.audienceCount <= 0) {
            this.gGS.setVisibility(8);
            if (this.gGT.getVisibility() == 0) {
                bVj();
            }
        } else {
            String dV = at.dV(this.gGV.liveInfo.audienceCount);
            this.gGS.setVisibility(0);
            this.gGS.setText(dV);
            bVk();
        }
        if (103 == this.tabType) {
            if (!StringUtils.isNull(this.gGV.title)) {
                this.bFt.setText(this.gGV.title);
            }
        } else if (!StringUtils.isNull(this.gGV.liveAuthor.nameShow)) {
            this.bFt.setText(this.gGV.liveAuthor.nameShow);
        }
        if (!StringUtils.isNull(this.gGV.labelUrl)) {
            this.gGM.setVisibility(0);
            this.gGM.startLoad(this.gGV.labelUrl, 10, false);
            this.gGM.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.h.3
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onComplete(String str, boolean z) {
                    if (z) {
                        h.this.gGM.setLayoutParams(new RelativeLayout.LayoutParams(h.this.bE(h.this.gGM.getLoadedHeight(), h.this.gGM.getLoadedWidth()), h.gGR));
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onCancel() {
                }
            });
        } else {
            this.gGM.setVisibility(8);
        }
        if (!StringUtils.isNull(this.gGV.modeUrl)) {
            this.gGU.setVisibility(0);
            this.gGU.startLoad(this.gGV.modeUrl, 10, false);
            this.gGU.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.h.4
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onComplete(String str, boolean z) {
                    if (z) {
                        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(h.this.bE(h.this.gGU.getLoadedHeight(), h.this.gGU.getLoadedWidth()), h.gGR);
                        layoutParams2.addRule(11);
                        layoutParams2.rightMargin = h.this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.M_W_X004);
                        h.this.gGU.setLayoutParams(layoutParams2);
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onCancel() {
                }
            });
        } else {
            this.gGU.setVisibility(8);
        }
        if (!StringUtils.isNull(this.gGV.location)) {
            this.gGT.setVisibility(0);
            this.gGT.setText(this.gGV.location.length() <= 5 ? this.gGV.location : this.gGV.location.substring(0, 5) + StringHelper.STRING_MORE);
        } else {
            this.gGT.setVisibility(8);
        }
        if (this.gGV != null) {
            if (i == 2) {
                TiebaStatic.log(new aq("c12899").dX("tid", this.gGV.tid));
            } else if (i == 1) {
                TiebaStatic.log(new aq("c12903").dX("tid", this.gGV.tid));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.eWc) {
            aq aqVar = new aq("c13610");
            aqVar.dX("obj_param1", this.gGV != null ? this.gGV.liveId : "");
            aqVar.dX("fid", aVar.fid);
            aqVar.dX("fname", aVar.fname);
            aqVar.an("obj_locate", aVar.position);
            if (this.gGV != null && this.gGV.uiTransParam != null) {
                aqVar.dX("ab_tag", this.gGV.uiTransParam.abTag);
                aqVar.dX("star_id", this.gGV.uiTransParam.starId);
                aqVar.dX("extra", this.gGV.uiTransParam.extra);
                aqVar.dX(VideoPlayActivityConfig.SOURCE_FROM, this.gGV.uiTransParam.sourceFrom);
            }
            TiebaStatic.log(aqVar);
            return;
        }
        aq aqVar2 = new aq("c13544");
        String str = "";
        if (101 == this.tabType) {
            str = "推荐";
        } else if (102 == this.tabType) {
            str = "颜值";
        } else if (103 == this.tabType) {
            str = "交友";
            if (com.baidu.tieba.ala.alasquare.live_tab.c.a(this.gGV)) {
                aq aqVar3 = new aq("c14007");
                aqVar3.an("obj_locate", 3);
                aqVar3.dX("obj_param1", this.gGV.liveId);
                aqVar3.w("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(aqVar3);
            }
        }
        aqVar2.dX("obj_param1", this.gGV == null ? "" : this.gGV.liveId);
        aqVar2.dX("entryname", str);
        TiebaStatic.log(aqVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setViewTextColor(this.gGS, R.color.CAM_X0101);
            ao.setViewTextColor(this.bFt, R.color.CAM_X0101);
            ao.setViewTextColor(this.gGT, R.color.CAM_X0101);
            this.mSkinType = i;
        }
    }

    private void bVj() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.M_W_X004);
        layoutParams.bottomMargin = 0;
        this.gGT.setGravity(16);
        this.gGT.setLayoutParams(layoutParams);
    }

    private void bVk() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.M_W_X004);
        layoutParams.bottomMargin = this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.M_H_X002);
        this.gGT.setGravity(16);
        this.gGT.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bE(int i, int i2) {
        return (int) ((i2 / i) * gGR);
    }
}
