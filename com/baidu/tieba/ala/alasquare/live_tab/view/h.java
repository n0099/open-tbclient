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
/* loaded from: classes10.dex */
public class h {
    public TextView bEn;
    public TbImageView gCN;
    public LinearLayout gCQ;
    private AlphaAnimation gDa;
    public TbImageView gEQ;
    private com.baidu.tieba.ala.alasquare.a.a gES;
    public EMTextView gEW;
    private EMTextView gEX;
    public TbImageView gEY;
    private SdkLiveInfoData gEZ;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabType;
    private static final int gEV = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds60);
    private static final float gCS = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] gCT = {0.0f, 0.0f, 0.0f, 0.0f, gCS, gCS, gCS, gCS};
    private static final float[] gCU = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, gCS, gCS};
    private static final float[] gCV = {0.0f, 0.0f, 0.0f, 0.0f, gCS, gCS, 0.0f, 0.0f};
    public int mSkinType = 3;
    private int[] gCW = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean gCZ = false;
    private boolean gDb = true;
    private boolean gDc = false;
    private int gET = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.h.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.tieba.ala.alasquare.live_tab.c.a(h.this.gEZ)) {
                com.baidu.tieba.ala.alasquare.live_tab.c.a(h.this.mTbPageContext.getPageActivity(), h.this.gEZ);
                if (h.this.gES != null && h.this.gEZ != null) {
                    if (h.this.gES.eTD) {
                        ar arVar = new ar("c13611");
                        arVar.dR("obj_param1", h.this.gEZ.liveId);
                        arVar.dR("fid", h.this.gES.fid);
                        arVar.dR("fname", h.this.gES.fname);
                        arVar.ap("obj_locate", h.this.gES.position);
                        if (h.this.gEZ != null && h.this.gEZ.uiTransParam != null) {
                            arVar.dR("ab_tag", h.this.gEZ.uiTransParam.abTag);
                            arVar.dR("star_id", h.this.gEZ.uiTransParam.starId);
                            arVar.dR("extra", h.this.gEZ.uiTransParam.extra);
                            arVar.dR(VideoPlayActivityConfig.SOURCE_FROM, h.this.gEZ.uiTransParam.sourceFrom);
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
                    arVar2.dR("obj_param1", h.this.gEZ.liveId);
                    arVar2.dR("entryname", str);
                    TiebaStatic.log(arVar2);
                    return;
                }
                return;
            }
            String str2 = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MAIN;
            if (103 == h.this.tabType) {
                ar arVar3 = new ar("c14008");
                arVar3.ap("obj_locate", 3);
                arVar3.dR("obj_param1", h.this.gEZ.liveId);
                arVar3.v("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(arVar3);
                str2 = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_FRIEND;
            }
            com.baidu.tieba.ala.alasquare.live_tab.c.a(h.this.mTbPageContext, h.this.gEZ, str2);
        }
    };

    public h(TbPageContext<?> tbPageContext, int i) {
        this.mTbPageContext = tbPageContext;
        this.tabType = i;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_live_item_view, (ViewGroup) null, false);
        this.gCN = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.gCN.setBorderSurroundContent(true);
        this.gCN.setDrawBorder(true);
        this.gCN.setPlaceHolder(2);
        this.gCN.setBorderWidth(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.gEW = (EMTextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.bEn = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.gCQ = (LinearLayout) this.mRootView.findViewById(R.id.tvInfoWrapper);
        this.gEQ = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.gEY = (TbImageView) this.mRootView.findViewById(R.id.live_status_label);
        this.gEX = (EMTextView) this.mRootView.findViewById(R.id.tvLocation);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.gDa = new AlphaAnimation(0.0f, 1.0f);
        this.gDa.setDuration(200L);
        this.gDa.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.h.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                h.this.gDc = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                h.this.gDc = false;
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
        if (equipmentWidth != this.gET) {
            ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
            int equipmentWidth2 = (l.getEquipmentWidth(this.mRootView.getContext()) - this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds12)) - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(equipmentWidth2 / 2, equipmentWidth2 / 2);
            } else {
                layoutParams.width = equipmentWidth2 / 2;
                layoutParams.height = layoutParams.width;
            }
            this.mRootView.setLayoutParams(layoutParams);
            this.gET = equipmentWidth;
        }
        if (aVar == null || aVar.gyx == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gES = aVar;
        this.gEZ = aVar.gyx;
        Object tag = this.gCN.getTag();
        if (this.gDb) {
            this.gCZ = true;
            this.gDb = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.gEZ.liveInfo.cover) && !((String) tag).equals(this.gEZ.liveInfo.cover)) {
            this.gCZ = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.gEZ.liveInfo.cover) && !this.mCoverUrl.equals(this.gEZ.liveInfo.cover)) {
            this.gCZ = true;
        } else {
            this.gCZ = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.gCW);
        this.mCoverUrl = this.gEZ.liveInfo.cover;
        this.gCN.setTag(this.mCoverUrl);
        if (aVar.isLeft) {
            this.gCN.setConrers(5);
            gradientDrawable.setCornerRadii(gCU);
            this.gCN.setPlaceHolder(2);
        } else if (aVar.isRight) {
            this.gCN.setConrers(10);
            gradientDrawable.setCornerRadii(gCV);
            this.gCN.setPlaceHolder(2);
        } else if (aVar.gyy) {
            this.gCN.setConrers(15);
            gradientDrawable.setCornerRadii(gCT);
            this.gCN.setPlaceHolder(2);
        }
        this.gCN.setRadius((int) gCS);
        this.gCN.startLoad(this.gEZ.liveInfo.cover, 10, false);
        this.gCQ.setBackgroundDrawable(gradientDrawable);
        this.gCN.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.h.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z && h.this.gCZ && !h.this.gDc) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        h.this.gCN.startAnimation(h.this.gDa);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        });
        if (this.gEZ.liveInfo.audienceCount <= 0) {
            this.gEW.setVisibility(8);
            if (this.gEX.getVisibility() == 0) {
                bRU();
            }
        } else {
            String eb = au.eb(this.gEZ.liveInfo.audienceCount);
            this.gEW.setVisibility(0);
            this.gEW.setText(eb);
            bRV();
        }
        if (103 == this.tabType) {
            if (!StringUtils.isNull(this.gEZ.title)) {
                this.bEn.setText(this.gEZ.title);
            }
        } else if (!StringUtils.isNull(this.gEZ.liveAuthor.nameShow)) {
            this.bEn.setText(this.gEZ.liveAuthor.nameShow);
        }
        if (!StringUtils.isNull(this.gEZ.labelUrl)) {
            this.gEQ.setVisibility(0);
            this.gEQ.startLoad(this.gEZ.labelUrl, 10, false);
            this.gEQ.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.h.3
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onComplete(String str, boolean z) {
                    if (z) {
                        h.this.gEQ.setLayoutParams(new RelativeLayout.LayoutParams(h.this.bB(h.this.gEQ.getLoadedHeight(), h.this.gEQ.getLoadedWidth()), h.gEV));
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onCancel() {
                }
            });
        } else {
            this.gEQ.setVisibility(8);
        }
        if (!StringUtils.isNull(this.gEZ.modeUrl)) {
            this.gEY.setVisibility(0);
            this.gEY.startLoad(this.gEZ.modeUrl, 10, false);
            this.gEY.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.h.4
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onComplete(String str, boolean z) {
                    if (z) {
                        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(h.this.bB(h.this.gEY.getLoadedHeight(), h.this.gEY.getLoadedWidth()), h.gEV);
                        layoutParams2.addRule(11);
                        layoutParams2.rightMargin = h.this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.M_W_X004);
                        h.this.gEY.setLayoutParams(layoutParams2);
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onCancel() {
                }
            });
        } else {
            this.gEY.setVisibility(8);
        }
        if (!StringUtils.isNull(this.gEZ.location)) {
            this.gEX.setVisibility(0);
            this.gEX.setText(this.gEZ.location.length() <= 5 ? this.gEZ.location : this.gEZ.location.substring(0, 5) + StringHelper.STRING_MORE);
        } else {
            this.gEX.setVisibility(8);
        }
        if (this.gEZ != null) {
            if (i == 2) {
                TiebaStatic.log(new ar("c12899").dR("tid", this.gEZ.tid));
            } else if (i == 1) {
                TiebaStatic.log(new ar("c12903").dR("tid", this.gEZ.tid));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.eTD) {
            ar arVar = new ar("c13610");
            arVar.dR("obj_param1", this.gEZ != null ? this.gEZ.liveId : "");
            arVar.dR("fid", aVar.fid);
            arVar.dR("fname", aVar.fname);
            arVar.ap("obj_locate", aVar.position);
            if (this.gEZ != null && this.gEZ.uiTransParam != null) {
                arVar.dR("ab_tag", this.gEZ.uiTransParam.abTag);
                arVar.dR("star_id", this.gEZ.uiTransParam.starId);
                arVar.dR("extra", this.gEZ.uiTransParam.extra);
                arVar.dR(VideoPlayActivityConfig.SOURCE_FROM, this.gEZ.uiTransParam.sourceFrom);
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
            if (com.baidu.tieba.ala.alasquare.live_tab.c.a(this.gEZ)) {
                ar arVar3 = new ar("c14007");
                arVar3.ap("obj_locate", 3);
                arVar3.dR("obj_param1", this.gEZ.liveId);
                arVar3.v("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(arVar3);
            }
        }
        arVar2.dR("obj_param1", this.gEZ == null ? "" : this.gEZ.liveId);
        arVar2.dR("entryname", str);
        TiebaStatic.log(arVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.gEW, R.color.CAM_X0101);
            ap.setViewTextColor(this.bEn, R.color.CAM_X0101);
            ap.setViewTextColor(this.gEX, R.color.CAM_X0101);
            this.mSkinType = i;
        }
    }

    private void bRU() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.M_W_X004);
        layoutParams.bottomMargin = 0;
        this.gEX.setGravity(16);
        this.gEX.setLayoutParams(layoutParams);
    }

    private void bRV() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.M_W_X004);
        layoutParams.bottomMargin = this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.M_H_X002);
        this.gEX.setGravity(16);
        this.gEX.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bB(int i, int i2) {
        return (int) ((i2 / i) * gEV);
    }
}
