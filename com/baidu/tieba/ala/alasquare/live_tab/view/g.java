package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class g {
    private static final float gEP = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] gEQ = {0.0f, 0.0f, 0.0f, 0.0f, gEP, gEP, gEP, gEP};
    private static final float[] gER = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, gEP, gEP};
    private static final float[] gES = {0.0f, 0.0f, 0.0f, 0.0f, gEP, gEP, 0.0f, 0.0f};
    public TextView bFt;
    private SdkLiveInfoData gAu;
    public TextView gBH;
    public TbImageView gEK;
    public TextView gEL;
    private AlphaAnimation gEX;
    public View gGK;
    public ViewGroup gGL;
    public TbImageView gGM;
    public ImageView gGN;
    private com.baidu.tieba.ala.alasquare.a.a gGO;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    private int[] gET = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean gEW = false;
    private boolean gEY = true;
    private boolean mIsAnimating = false;
    private int gGP = 0;
    private boolean gCA = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            if (g.this.gGO != null && g.this.gAu != null) {
                if (g.this.gAu.shouldJumpChushouLiveRoom()) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(g.this.mTbPageContext, g.this.gAu.roomId, String.valueOf(g.this.gAu.liveInfo.liveType));
                } else {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = com.baidu.adp.lib.f.b.toLong(g.this.gAu.roomId, 0L);
                    if (g.this.gAu.liveInfo != null) {
                        alaLiveInfoCoreData.hslUrl = g.this.gAu.liveInfo.hlsUrl;
                        alaLiveInfoCoreData.liveCover = g.this.gAu.liveInfo.cover;
                        alaLiveInfoCoreData.rtmpUrl = g.this.gAu.liveInfo.rtmpUrl;
                        alaLiveInfoCoreData.liveTitle = g.this.gAu.title;
                        alaLiveInfoCoreData.audienceCount = g.this.gAu.liveInfo.audienceCount;
                    }
                    if (g.this.gCA) {
                        str = g.this.gGO != null ? AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_FRIENDLIVE + g.this.gGO.fid : null;
                    } else {
                        str = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MAIN;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(g.this.mTbPageContext.getPageActivity(), alaLiveInfoCoreData, null, str, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
                }
                if (g.this.gGO.eWc) {
                    aq aqVar = new aq("c13611");
                    aqVar.dX("obj_param1", g.this.gAu.roomId);
                    aqVar.dX("fid", g.this.gGO.fid);
                    aqVar.dX("fname", g.this.gGO.fname);
                    aqVar.an("obj_locate", g.this.gGO.position);
                    if (g.this.gAu != null && g.this.gAu.uiTransParam != null) {
                        aqVar.dX("ab_tag", g.this.gAu.uiTransParam.abTag);
                        aqVar.dX("star_id", g.this.gAu.uiTransParam.starId);
                        aqVar.dX("extra", g.this.gAu.uiTransParam.extra);
                        aqVar.dX(VideoPlayActivityConfig.SOURCE_FROM, g.this.gAu.uiTransParam.sourceFrom);
                    }
                    TiebaStatic.log(aqVar);
                    return;
                }
                aq aqVar2 = new aq("c13557");
                aqVar2.dX("obj_param1", g.this.gAu.roomId);
                aqVar2.dX("entryname", "游戏");
                TiebaStatic.log(aqVar2);
            }
        }
    };

    public g(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_game_live_item_view, (ViewGroup) null, false);
        this.gEK = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.gEK.setBorderSurroundContent(true);
        this.gEK.setDrawBorder(true);
        this.gEK.setPlaceHolder(2);
        this.gEK.setBorderWidth(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.gGK = this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.gBH = (TextView) this.mRootView.findViewById(R.id.live_title);
        this.gEL = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.bFt = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.gGL = (ViewGroup) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.gGM = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.gGN = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.gEX = new AlphaAnimation(0.0f, 1.0f);
        this.gEX.setDuration(200L);
        this.gEX.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                g.this.mIsAnimating = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                g.this.mIsAnimating = false;
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
        String str;
        int equipmentWidth = l.getEquipmentWidth(this.mRootView.getContext());
        if (equipmentWidth != this.gGP) {
            ViewGroup.LayoutParams layoutParams = this.gGK.getLayoutParams();
            int equipmentWidth2 = (int) (((l.getEquipmentWidth(this.mRootView.getContext()) - this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds12)) - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 2.0d);
            int i = (int) ((equipmentWidth2 * 9) / 16.0d);
            ViewGroup.LayoutParams layoutParams2 = this.mRootView.getLayoutParams();
            layoutParams2.width = equipmentWidth2;
            this.mRootView.setLayoutParams(layoutParams2);
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(equipmentWidth2, i);
            } else {
                layoutParams.width = equipmentWidth2;
                layoutParams.height = i;
            }
            this.gGK.setLayoutParams(layoutParams);
            this.gGP = equipmentWidth;
        }
        if (aVar == null || aVar.gAu == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gGO = aVar;
        this.gAu = aVar.gAu;
        Object tag = this.gEK.getTag();
        if (this.gEY) {
            this.gEW = true;
            this.gEY = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.gAu.liveInfo.cover) && !((String) tag).equals(this.gAu.liveInfo.cover)) {
            this.gEW = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.gAu.liveInfo.cover) && !this.mCoverUrl.equals(this.gAu.liveInfo.cover)) {
            this.gEW = true;
        } else {
            this.gEW = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.gET);
        this.mCoverUrl = this.gAu.liveInfo.cover;
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
        this.gEK.startLoad(this.gAu.liveInfo.cover, 10, false);
        this.gGL.setBackgroundDrawable(gradientDrawable);
        this.gEK.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str2, boolean z) {
                if (z && g.this.gEW && !g.this.mIsAnimating) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        g.this.gEK.startAnimation(g.this.gEX);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        });
        this.gEL.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, at.dV(this.gAu.liveInfo.audienceCount)));
        this.bFt.setText(this.gAu.liveAuthor.name);
        this.gBH.setText(this.gAu.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.gAu.recom_extra_img_night;
        } else {
            str = this.gAu.recom_extra_img;
        }
        if (!StringUtils.isNull(str) && this.gAu.recom_extra_img_width > 0 && this.gAu.recom_extra_img_height > 0) {
            if (aVar.isLeft) {
                this.gGM.setConrers(1);
            } else if (aVar.isRight) {
                this.gGM.setConrers(0);
            } else if (aVar.gAv) {
                this.gGM.setConrers(1);
            } else {
                this.gGM.setConrers(0);
            }
            this.gGM.setRadius((int) gEP);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gGM.getLayoutParams();
            if (layoutParams3 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                layoutParams3.height = dimensionPixelSize;
                layoutParams3.width = (int) ((this.gAu.recom_extra_img_width / this.gAu.recom_extra_img_height) * dimensionPixelSize);
                this.gGM.setLayoutParams(layoutParams3);
            }
            this.gGM.startLoad(str, 10, false);
            this.gGM.setVisibility(0);
        } else {
            this.gGM.setVisibility(8);
        }
        this.gGN.setVisibility(8);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.eWc) {
            aq aqVar = new aq("c13610");
            aqVar.dX("obj_param1", this.gAu.roomId);
            aqVar.dX("fid", aVar.fid);
            aqVar.dX("fname", aVar.fname);
            aqVar.an("obj_locate", aVar.position);
            if (this.gAu != null && this.gAu.uiTransParam != null) {
                aqVar.dX("ab_tag", this.gAu.uiTransParam.abTag);
                aqVar.dX("star_id", this.gAu.uiTransParam.starId);
                aqVar.dX("extra", this.gAu.uiTransParam.extra);
                aqVar.dX(VideoPlayActivityConfig.SOURCE_FROM, this.gAu.uiTransParam.sourceFrom);
            }
            TiebaStatic.log(aqVar);
            return;
        }
        aq aqVar2 = new aq("c13544");
        aqVar2.dX("obj_param1", this.gAu.roomId);
        aqVar2.dX("entryname", "游戏");
        TiebaStatic.log(aqVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setViewTextColor(this.gEL, R.color.CAM_X0101);
            ao.setViewTextColor(this.bFt, R.color.CAM_X0101);
            ao.setViewTextColor(this.gBH, R.color.CAM_X0105);
            Drawable drawable = ao.getDrawable(this.mTbPageContext.getResources(), R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.gEL.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.gEL.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }

    public void mw(boolean z) {
        this.gCA = z;
    }
}
