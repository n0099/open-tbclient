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
    public TbImageView gDb;
    public LinearLayout gDe;
    private AlphaAnimation gDo;
    public TbImageView gFe;
    private com.baidu.tieba.ala.alasquare.a.a gFg;
    public EMTextView gFk;
    private EMTextView gFl;
    public TbImageView gFm;
    private SdkLiveInfoData gFn;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabType;
    private static final int gFj = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds60);
    private static final float gDg = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] gDh = {0.0f, 0.0f, 0.0f, 0.0f, gDg, gDg, gDg, gDg};
    private static final float[] gDi = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, gDg, gDg};
    private static final float[] gDj = {0.0f, 0.0f, 0.0f, 0.0f, gDg, gDg, 0.0f, 0.0f};
    public int mSkinType = 3;
    private int[] gDk = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean gDn = false;
    private boolean gDp = true;
    private boolean gDq = false;
    private int gFh = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.h.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.tieba.ala.alasquare.live_tab.c.a(h.this.gFn)) {
                com.baidu.tieba.ala.alasquare.live_tab.c.a(h.this.mTbPageContext.getPageActivity(), h.this.gFn);
                if (h.this.gFg != null && h.this.gFn != null) {
                    if (h.this.gFg.eTD) {
                        ar arVar = new ar("c13611");
                        arVar.dR("obj_param1", h.this.gFn.liveId);
                        arVar.dR("fid", h.this.gFg.fid);
                        arVar.dR("fname", h.this.gFg.fname);
                        arVar.ap("obj_locate", h.this.gFg.position);
                        if (h.this.gFn != null && h.this.gFn.uiTransParam != null) {
                            arVar.dR("ab_tag", h.this.gFn.uiTransParam.abTag);
                            arVar.dR("star_id", h.this.gFn.uiTransParam.starId);
                            arVar.dR("extra", h.this.gFn.uiTransParam.extra);
                            arVar.dR(VideoPlayActivityConfig.SOURCE_FROM, h.this.gFn.uiTransParam.sourceFrom);
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
                    arVar2.dR("obj_param1", h.this.gFn.liveId);
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
                arVar3.dR("obj_param1", h.this.gFn.liveId);
                arVar3.v("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(arVar3);
                str2 = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_FRIEND;
            }
            com.baidu.tieba.ala.alasquare.live_tab.c.a(h.this.mTbPageContext, h.this.gFn, str2);
        }
    };

    public h(TbPageContext<?> tbPageContext, int i) {
        this.mTbPageContext = tbPageContext;
        this.tabType = i;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_live_item_view, (ViewGroup) null, false);
        this.gDb = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.gDb.setBorderSurroundContent(true);
        this.gDb.setDrawBorder(true);
        this.gDb.setPlaceHolder(2);
        this.gDb.setBorderWidth(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.gFk = (EMTextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.bEn = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.gDe = (LinearLayout) this.mRootView.findViewById(R.id.tvInfoWrapper);
        this.gFe = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.gFm = (TbImageView) this.mRootView.findViewById(R.id.live_status_label);
        this.gFl = (EMTextView) this.mRootView.findViewById(R.id.tvLocation);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.gDo = new AlphaAnimation(0.0f, 1.0f);
        this.gDo.setDuration(200L);
        this.gDo.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.h.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                h.this.gDq = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                h.this.gDq = false;
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
        if (equipmentWidth != this.gFh) {
            ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
            int equipmentWidth2 = (l.getEquipmentWidth(this.mRootView.getContext()) - this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds12)) - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(equipmentWidth2 / 2, equipmentWidth2 / 2);
            } else {
                layoutParams.width = equipmentWidth2 / 2;
                layoutParams.height = layoutParams.width;
            }
            this.mRootView.setLayoutParams(layoutParams);
            this.gFh = equipmentWidth;
        }
        if (aVar == null || aVar.gyL == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gFg = aVar;
        this.gFn = aVar.gyL;
        Object tag = this.gDb.getTag();
        if (this.gDp) {
            this.gDn = true;
            this.gDp = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.gFn.liveInfo.cover) && !((String) tag).equals(this.gFn.liveInfo.cover)) {
            this.gDn = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.gFn.liveInfo.cover) && !this.mCoverUrl.equals(this.gFn.liveInfo.cover)) {
            this.gDn = true;
        } else {
            this.gDn = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.gDk);
        this.mCoverUrl = this.gFn.liveInfo.cover;
        this.gDb.setTag(this.mCoverUrl);
        if (aVar.isLeft) {
            this.gDb.setConrers(5);
            gradientDrawable.setCornerRadii(gDi);
            this.gDb.setPlaceHolder(2);
        } else if (aVar.isRight) {
            this.gDb.setConrers(10);
            gradientDrawable.setCornerRadii(gDj);
            this.gDb.setPlaceHolder(2);
        } else if (aVar.gyM) {
            this.gDb.setConrers(15);
            gradientDrawable.setCornerRadii(gDh);
            this.gDb.setPlaceHolder(2);
        }
        this.gDb.setRadius((int) gDg);
        this.gDb.startLoad(this.gFn.liveInfo.cover, 10, false);
        this.gDe.setBackgroundDrawable(gradientDrawable);
        this.gDb.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.h.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z && h.this.gDn && !h.this.gDq) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        h.this.gDb.startAnimation(h.this.gDo);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        });
        if (this.gFn.liveInfo.audienceCount <= 0) {
            this.gFk.setVisibility(8);
            if (this.gFl.getVisibility() == 0) {
                bSb();
            }
        } else {
            String eb = au.eb(this.gFn.liveInfo.audienceCount);
            this.gFk.setVisibility(0);
            this.gFk.setText(eb);
            bSc();
        }
        if (103 == this.tabType) {
            if (!StringUtils.isNull(this.gFn.title)) {
                this.bEn.setText(this.gFn.title);
            }
        } else if (!StringUtils.isNull(this.gFn.liveAuthor.nameShow)) {
            this.bEn.setText(this.gFn.liveAuthor.nameShow);
        }
        if (!StringUtils.isNull(this.gFn.labelUrl)) {
            this.gFe.setVisibility(0);
            this.gFe.startLoad(this.gFn.labelUrl, 10, false);
            this.gFe.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.h.3
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onComplete(String str, boolean z) {
                    if (z) {
                        h.this.gFe.setLayoutParams(new RelativeLayout.LayoutParams(h.this.bC(h.this.gFe.getLoadedHeight(), h.this.gFe.getLoadedWidth()), h.gFj));
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onCancel() {
                }
            });
        } else {
            this.gFe.setVisibility(8);
        }
        if (!StringUtils.isNull(this.gFn.modeUrl)) {
            this.gFm.setVisibility(0);
            this.gFm.startLoad(this.gFn.modeUrl, 10, false);
            this.gFm.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.h.4
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onComplete(String str, boolean z) {
                    if (z) {
                        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(h.this.bC(h.this.gFm.getLoadedHeight(), h.this.gFm.getLoadedWidth()), h.gFj);
                        layoutParams2.addRule(11);
                        layoutParams2.rightMargin = h.this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.M_W_X004);
                        h.this.gFm.setLayoutParams(layoutParams2);
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onCancel() {
                }
            });
        } else {
            this.gFm.setVisibility(8);
        }
        if (!StringUtils.isNull(this.gFn.location)) {
            this.gFl.setVisibility(0);
            this.gFl.setText(this.gFn.location.length() <= 5 ? this.gFn.location : this.gFn.location.substring(0, 5) + StringHelper.STRING_MORE);
        } else {
            this.gFl.setVisibility(8);
        }
        if (this.gFn != null) {
            if (i == 2) {
                TiebaStatic.log(new ar("c12899").dR("tid", this.gFn.tid));
            } else if (i == 1) {
                TiebaStatic.log(new ar("c12903").dR("tid", this.gFn.tid));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.eTD) {
            ar arVar = new ar("c13610");
            arVar.dR("obj_param1", this.gFn != null ? this.gFn.liveId : "");
            arVar.dR("fid", aVar.fid);
            arVar.dR("fname", aVar.fname);
            arVar.ap("obj_locate", aVar.position);
            if (this.gFn != null && this.gFn.uiTransParam != null) {
                arVar.dR("ab_tag", this.gFn.uiTransParam.abTag);
                arVar.dR("star_id", this.gFn.uiTransParam.starId);
                arVar.dR("extra", this.gFn.uiTransParam.extra);
                arVar.dR(VideoPlayActivityConfig.SOURCE_FROM, this.gFn.uiTransParam.sourceFrom);
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
            if (com.baidu.tieba.ala.alasquare.live_tab.c.a(this.gFn)) {
                ar arVar3 = new ar("c14007");
                arVar3.ap("obj_locate", 3);
                arVar3.dR("obj_param1", this.gFn.liveId);
                arVar3.v("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(arVar3);
            }
        }
        arVar2.dR("obj_param1", this.gFn == null ? "" : this.gFn.liveId);
        arVar2.dR("entryname", str);
        TiebaStatic.log(arVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.gFk, R.color.CAM_X0101);
            ap.setViewTextColor(this.bEn, R.color.CAM_X0101);
            ap.setViewTextColor(this.gFl, R.color.CAM_X0101);
            this.mSkinType = i;
        }
    }

    private void bSb() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.M_W_X004);
        layoutParams.bottomMargin = 0;
        this.gFl.setGravity(16);
        this.gFl.setLayoutParams(layoutParams);
    }

    private void bSc() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.M_W_X004);
        layoutParams.bottomMargin = this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.M_H_X002);
        this.gFl.setGravity(16);
        this.gFl.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bC(int i, int i2) {
        return (int) ((i2 / i) * gFj);
    }
}
