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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class g {
    private static final float gCS = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] gCT = {0.0f, 0.0f, 0.0f, 0.0f, gCS, gCS, gCS, gCS};
    private static final float[] gCU = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, gCS, gCS};
    private static final float[] gCV = {0.0f, 0.0f, 0.0f, 0.0f, gCS, gCS, 0.0f, 0.0f};
    public TextView bEn;
    public TbImageView gCN;
    public TextView gCO;
    private AlphaAnimation gDa;
    public View gEO;
    public ViewGroup gEP;
    public TbImageView gEQ;
    public ImageView gER;
    private com.baidu.tieba.ala.alasquare.a.a gES;
    private SdkLiveInfoData gyx;
    public TextView gzK;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    private int[] gCW = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean gCZ = false;
    private boolean gDb = true;
    private boolean gDc = false;
    private int gET = 0;
    private boolean gAD = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            if (g.this.gES != null && g.this.gyx != null) {
                if (g.this.gyx.shouldJumpChushouLiveRoom()) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(g.this.mTbPageContext, g.this.gyx.roomId, String.valueOf(g.this.gyx.liveInfo.liveType));
                } else {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = com.baidu.adp.lib.f.b.toLong(g.this.gyx.roomId, 0L);
                    if (g.this.gyx.liveInfo != null) {
                        alaLiveInfoCoreData.hslUrl = g.this.gyx.liveInfo.hlsUrl;
                        alaLiveInfoCoreData.liveCover = g.this.gyx.liveInfo.cover;
                        alaLiveInfoCoreData.rtmpUrl = g.this.gyx.liveInfo.rtmpUrl;
                        alaLiveInfoCoreData.liveTitle = g.this.gyx.title;
                        alaLiveInfoCoreData.audienceCount = g.this.gyx.liveInfo.audienceCount;
                    }
                    if (g.this.gAD) {
                        str = g.this.gES != null ? AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_FRIENDLIVE + g.this.gES.fid : null;
                    } else {
                        str = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MAIN;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(g.this.mTbPageContext.getPageActivity(), alaLiveInfoCoreData, null, str, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
                }
                if (g.this.gES.eTD) {
                    ar arVar = new ar("c13611");
                    arVar.dR("obj_param1", g.this.gyx.roomId);
                    arVar.dR("fid", g.this.gES.fid);
                    arVar.dR("fname", g.this.gES.fname);
                    arVar.ap("obj_locate", g.this.gES.position);
                    if (g.this.gyx != null && g.this.gyx.uiTransParam != null) {
                        arVar.dR("ab_tag", g.this.gyx.uiTransParam.abTag);
                        arVar.dR("star_id", g.this.gyx.uiTransParam.starId);
                        arVar.dR("extra", g.this.gyx.uiTransParam.extra);
                        arVar.dR(VideoPlayActivityConfig.SOURCE_FROM, g.this.gyx.uiTransParam.sourceFrom);
                    }
                    TiebaStatic.log(arVar);
                    return;
                }
                ar arVar2 = new ar("c13557");
                arVar2.dR("obj_param1", g.this.gyx.roomId);
                arVar2.dR("entryname", "游戏");
                TiebaStatic.log(arVar2);
            }
        }
    };

    public g(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_game_live_item_view, (ViewGroup) null, false);
        this.gCN = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.gCN.setBorderSurroundContent(true);
        this.gCN.setDrawBorder(true);
        this.gCN.setPlaceHolder(2);
        this.gCN.setBorderWidth(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.gEO = this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.gzK = (TextView) this.mRootView.findViewById(R.id.live_title);
        this.gCO = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.bEn = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.gEP = (ViewGroup) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.gEQ = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.gER = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.gDa = new AlphaAnimation(0.0f, 1.0f);
        this.gDa.setDuration(200L);
        this.gDa.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                g.this.gDc = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                g.this.gDc = false;
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
        if (equipmentWidth != this.gET) {
            ViewGroup.LayoutParams layoutParams = this.gEO.getLayoutParams();
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
            this.gEO.setLayoutParams(layoutParams);
            this.gET = equipmentWidth;
        }
        if (aVar == null || aVar.gyx == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gES = aVar;
        this.gyx = aVar.gyx;
        Object tag = this.gCN.getTag();
        if (this.gDb) {
            this.gCZ = true;
            this.gDb = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.gyx.liveInfo.cover) && !((String) tag).equals(this.gyx.liveInfo.cover)) {
            this.gCZ = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.gyx.liveInfo.cover) && !this.mCoverUrl.equals(this.gyx.liveInfo.cover)) {
            this.gCZ = true;
        } else {
            this.gCZ = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.gCW);
        this.mCoverUrl = this.gyx.liveInfo.cover;
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
        this.gCN.startLoad(this.gyx.liveInfo.cover, 10, false);
        this.gEP.setBackgroundDrawable(gradientDrawable);
        this.gCN.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str2, boolean z) {
                if (z && g.this.gCZ && !g.this.gDc) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        g.this.gCN.startAnimation(g.this.gDa);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        });
        this.gCO.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, au.eb(this.gyx.liveInfo.audienceCount)));
        this.bEn.setText(this.gyx.liveAuthor.name);
        this.gzK.setText(this.gyx.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.gyx.recom_extra_img_night;
        } else {
            str = this.gyx.recom_extra_img;
        }
        if (!StringUtils.isNull(str) && this.gyx.recom_extra_img_width > 0 && this.gyx.recom_extra_img_height > 0) {
            if (aVar.isLeft) {
                this.gEQ.setConrers(1);
            } else if (aVar.isRight) {
                this.gEQ.setConrers(0);
            } else if (aVar.gyy) {
                this.gEQ.setConrers(1);
            } else {
                this.gEQ.setConrers(0);
            }
            this.gEQ.setRadius((int) gCS);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gEQ.getLayoutParams();
            if (layoutParams3 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                layoutParams3.height = dimensionPixelSize;
                layoutParams3.width = (int) ((this.gyx.recom_extra_img_width / this.gyx.recom_extra_img_height) * dimensionPixelSize);
                this.gEQ.setLayoutParams(layoutParams3);
            }
            this.gEQ.startLoad(str, 10, false);
            this.gEQ.setVisibility(0);
        } else {
            this.gEQ.setVisibility(8);
        }
        this.gER.setVisibility(8);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.eTD) {
            ar arVar = new ar("c13610");
            arVar.dR("obj_param1", this.gyx.roomId);
            arVar.dR("fid", aVar.fid);
            arVar.dR("fname", aVar.fname);
            arVar.ap("obj_locate", aVar.position);
            if (this.gyx != null && this.gyx.uiTransParam != null) {
                arVar.dR("ab_tag", this.gyx.uiTransParam.abTag);
                arVar.dR("star_id", this.gyx.uiTransParam.starId);
                arVar.dR("extra", this.gyx.uiTransParam.extra);
                arVar.dR(VideoPlayActivityConfig.SOURCE_FROM, this.gyx.uiTransParam.sourceFrom);
            }
            TiebaStatic.log(arVar);
            return;
        }
        ar arVar2 = new ar("c13544");
        arVar2.dR("obj_param1", this.gyx.roomId);
        arVar2.dR("entryname", "游戏");
        TiebaStatic.log(arVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.gCO, R.color.CAM_X0101);
            ap.setViewTextColor(this.bEn, R.color.CAM_X0101);
            ap.setViewTextColor(this.gzK, R.color.CAM_X0105);
            Drawable drawable = ap.getDrawable(this.mTbPageContext.getResources(), R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.gCO.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.gCO.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }

    public void mw(boolean z) {
        this.gAD = z;
    }
}
