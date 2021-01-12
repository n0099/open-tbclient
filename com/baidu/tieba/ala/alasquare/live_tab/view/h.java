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
/* loaded from: classes9.dex */
public class h {
    public TextView bAH;
    public TbImageView gAd;
    public LinearLayout gAg;
    private AlphaAnimation gAq;
    public TbImageView gCg;
    private com.baidu.tieba.ala.alasquare.a.a gCi;
    public EMTextView gCm;
    private EMTextView gCn;
    public TbImageView gCo;
    private SdkLiveInfoData gCp;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabType;
    private static final int gCl = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds60);
    private static final float gAi = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] gAj = {0.0f, 0.0f, 0.0f, 0.0f, gAi, gAi, gAi, gAi};
    private static final float[] gAk = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, gAi, gAi};
    private static final float[] gAl = {0.0f, 0.0f, 0.0f, 0.0f, gAi, gAi, 0.0f, 0.0f};
    public int mSkinType = 3;
    private int[] gAm = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean gAp = false;
    private boolean gAr = true;
    private boolean gAs = false;
    private int gCj = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.h.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.tieba.ala.alasquare.live_tab.c.a(h.this.gCp)) {
                com.baidu.tieba.ala.alasquare.live_tab.c.a(h.this.mTbPageContext.getPageActivity(), h.this.gCp);
                if (h.this.gCi != null && h.this.gCp != null) {
                    if (h.this.gCi.eRr) {
                        aq aqVar = new aq("c13611");
                        aqVar.dW("obj_param1", h.this.gCp.liveId);
                        aqVar.dW("fid", h.this.gCi.fid);
                        aqVar.dW("fname", h.this.gCi.fname);
                        aqVar.an("obj_locate", h.this.gCi.position);
                        if (h.this.gCp != null && h.this.gCp.uiTransParam != null) {
                            aqVar.dW("ab_tag", h.this.gCp.uiTransParam.abTag);
                            aqVar.dW("star_id", h.this.gCp.uiTransParam.starId);
                            aqVar.dW("extra", h.this.gCp.uiTransParam.extra);
                            aqVar.dW(VideoPlayActivityConfig.SOURCE_FROM, h.this.gCp.uiTransParam.sourceFrom);
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
                    aqVar2.dW("obj_param1", h.this.gCp.liveId);
                    aqVar2.dW("entryname", str);
                    TiebaStatic.log(aqVar2);
                    return;
                }
                return;
            }
            String str2 = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MAIN;
            if (103 == h.this.tabType) {
                aq aqVar3 = new aq("c14008");
                aqVar3.an("obj_locate", 3);
                aqVar3.dW("obj_param1", h.this.gCp.liveId);
                aqVar3.w("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(aqVar3);
                str2 = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_FRIEND;
            }
            com.baidu.tieba.ala.alasquare.live_tab.c.a(h.this.mTbPageContext, h.this.gCp, str2);
        }
    };

    public h(TbPageContext<?> tbPageContext, int i) {
        this.mTbPageContext = tbPageContext;
        this.tabType = i;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_live_item_view, (ViewGroup) null, false);
        this.gAd = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.gAd.setBorderSurroundContent(true);
        this.gAd.setDrawBorder(true);
        this.gAd.setPlaceHolder(2);
        this.gAd.setBorderWidth(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.gCm = (EMTextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.bAH = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.gAg = (LinearLayout) this.mRootView.findViewById(R.id.tvInfoWrapper);
        this.gCg = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.gCo = (TbImageView) this.mRootView.findViewById(R.id.live_status_label);
        this.gCn = (EMTextView) this.mRootView.findViewById(R.id.tvLocation);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.gAq = new AlphaAnimation(0.0f, 1.0f);
        this.gAq.setDuration(200L);
        this.gAq.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.h.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                h.this.gAs = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                h.this.gAs = false;
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
        if (equipmentWidth != this.gCj) {
            ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
            int equipmentWidth2 = (l.getEquipmentWidth(this.mRootView.getContext()) - this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds12)) - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(equipmentWidth2 / 2, equipmentWidth2 / 2);
            } else {
                layoutParams.width = equipmentWidth2 / 2;
                layoutParams.height = layoutParams.width;
            }
            this.mRootView.setLayoutParams(layoutParams);
            this.gCj = equipmentWidth;
        }
        if (aVar == null || aVar.gvN == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gCi = aVar;
        this.gCp = aVar.gvN;
        Object tag = this.gAd.getTag();
        if (this.gAr) {
            this.gAp = true;
            this.gAr = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.gCp.liveInfo.cover) && !((String) tag).equals(this.gCp.liveInfo.cover)) {
            this.gAp = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.gCp.liveInfo.cover) && !this.mCoverUrl.equals(this.gCp.liveInfo.cover)) {
            this.gAp = true;
        } else {
            this.gAp = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.gAm);
        this.mCoverUrl = this.gCp.liveInfo.cover;
        this.gAd.setTag(this.mCoverUrl);
        if (aVar.isLeft) {
            this.gAd.setConrers(5);
            gradientDrawable.setCornerRadii(gAk);
            this.gAd.setPlaceHolder(2);
        } else if (aVar.isRight) {
            this.gAd.setConrers(10);
            gradientDrawable.setCornerRadii(gAl);
            this.gAd.setPlaceHolder(2);
        } else if (aVar.gvO) {
            this.gAd.setConrers(15);
            gradientDrawable.setCornerRadii(gAj);
            this.gAd.setPlaceHolder(2);
        }
        this.gAd.setRadius((int) gAi);
        this.gAd.startLoad(this.gCp.liveInfo.cover, 10, false);
        this.gAg.setBackgroundDrawable(gradientDrawable);
        this.gAd.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.h.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z && h.this.gAp && !h.this.gAs) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        h.this.gAd.startAnimation(h.this.gAq);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        });
        if (this.gCp.liveInfo.audienceCount <= 0) {
            this.gCm.setVisibility(8);
            if (this.gCn.getVisibility() == 0) {
                bRr();
            }
        } else {
            String dV = at.dV(this.gCp.liveInfo.audienceCount);
            this.gCm.setVisibility(0);
            this.gCm.setText(dV);
            bRs();
        }
        if (103 == this.tabType) {
            if (!StringUtils.isNull(this.gCp.title)) {
                this.bAH.setText(this.gCp.title);
            }
        } else if (!StringUtils.isNull(this.gCp.liveAuthor.nameShow)) {
            this.bAH.setText(this.gCp.liveAuthor.nameShow);
        }
        if (!StringUtils.isNull(this.gCp.labelUrl)) {
            this.gCg.setVisibility(0);
            this.gCg.startLoad(this.gCp.labelUrl, 10, false);
            this.gCg.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.h.3
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onComplete(String str, boolean z) {
                    if (z) {
                        h.this.gCg.setLayoutParams(new RelativeLayout.LayoutParams(h.this.bE(h.this.gCg.getLoadedHeight(), h.this.gCg.getLoadedWidth()), h.gCl));
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onCancel() {
                }
            });
        } else {
            this.gCg.setVisibility(8);
        }
        if (!StringUtils.isNull(this.gCp.modeUrl)) {
            this.gCo.setVisibility(0);
            this.gCo.startLoad(this.gCp.modeUrl, 10, false);
            this.gCo.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.h.4
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onComplete(String str, boolean z) {
                    if (z) {
                        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(h.this.bE(h.this.gCo.getLoadedHeight(), h.this.gCo.getLoadedWidth()), h.gCl);
                        layoutParams2.addRule(11);
                        layoutParams2.rightMargin = h.this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.M_W_X004);
                        h.this.gCo.setLayoutParams(layoutParams2);
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onCancel() {
                }
            });
        } else {
            this.gCo.setVisibility(8);
        }
        if (!StringUtils.isNull(this.gCp.location)) {
            this.gCn.setVisibility(0);
            this.gCn.setText(this.gCp.location.length() <= 5 ? this.gCp.location : this.gCp.location.substring(0, 5) + StringHelper.STRING_MORE);
        } else {
            this.gCn.setVisibility(8);
        }
        if (this.gCp != null) {
            if (i == 2) {
                TiebaStatic.log(new aq("c12899").dW("tid", this.gCp.tid));
            } else if (i == 1) {
                TiebaStatic.log(new aq("c12903").dW("tid", this.gCp.tid));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.eRr) {
            aq aqVar = new aq("c13610");
            aqVar.dW("obj_param1", this.gCp != null ? this.gCp.liveId : "");
            aqVar.dW("fid", aVar.fid);
            aqVar.dW("fname", aVar.fname);
            aqVar.an("obj_locate", aVar.position);
            if (this.gCp != null && this.gCp.uiTransParam != null) {
                aqVar.dW("ab_tag", this.gCp.uiTransParam.abTag);
                aqVar.dW("star_id", this.gCp.uiTransParam.starId);
                aqVar.dW("extra", this.gCp.uiTransParam.extra);
                aqVar.dW(VideoPlayActivityConfig.SOURCE_FROM, this.gCp.uiTransParam.sourceFrom);
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
            if (com.baidu.tieba.ala.alasquare.live_tab.c.a(this.gCp)) {
                aq aqVar3 = new aq("c14007");
                aqVar3.an("obj_locate", 3);
                aqVar3.dW("obj_param1", this.gCp.liveId);
                aqVar3.w("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(aqVar3);
            }
        }
        aqVar2.dW("obj_param1", this.gCp == null ? "" : this.gCp.liveId);
        aqVar2.dW("entryname", str);
        TiebaStatic.log(aqVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setViewTextColor(this.gCm, R.color.CAM_X0101);
            ao.setViewTextColor(this.bAH, R.color.CAM_X0101);
            ao.setViewTextColor(this.gCn, R.color.CAM_X0101);
            this.mSkinType = i;
        }
    }

    private void bRr() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.M_W_X004);
        layoutParams.bottomMargin = 0;
        this.gCn.setGravity(16);
        this.gCn.setLayoutParams(layoutParams);
    }

    private void bRs() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.M_W_X004);
        layoutParams.bottomMargin = this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.M_H_X002);
        this.gCn.setGravity(16);
        this.gCn.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bE(int i, int i2) {
        return (int) ((i2 / i) * gCl);
    }
}
