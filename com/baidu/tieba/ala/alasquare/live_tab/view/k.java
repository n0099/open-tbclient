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
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class k {
    private static final float gtQ = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] gtR = {0.0f, 0.0f, 0.0f, 0.0f, gtQ, gtQ, gtQ, gtQ};
    private static final float[] gtS = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, gtQ, gtQ};
    private static final float[] gtT = {0.0f, 0.0f, 0.0f, 0.0f, gtQ, gtQ, 0.0f, 0.0f};
    public TextView bAG;
    private SdkLiveInfoData gpE;
    public TextView gqI;
    public TbImageView gtL;
    public TextView gtM;
    private AlphaAnimation gtY;
    public View gvL;
    public ViewGroup gvM;
    public TbImageView gvN;
    public ImageView gvO;
    private com.baidu.tieba.ala.alasquare.a.a gvP;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    private int[] gtU = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean gtX = false;
    private boolean gtZ = true;
    private boolean mIsAnimating = false;
    private int gvQ = 0;
    private boolean grB = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            if (k.this.gvP != null && k.this.gpE != null) {
                if (k.this.gpE.shouldJumpChushouLiveRoom()) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(k.this.mTbPageContext, k.this.gpE.roomId, String.valueOf(k.this.gpE.liveInfo.liveType));
                } else {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = com.baidu.adp.lib.f.b.toLong(k.this.gpE.roomId, 0L);
                    if (k.this.gpE.liveInfo != null) {
                        alaLiveInfoCoreData.hslUrl = k.this.gpE.liveInfo.hlsUrl;
                        alaLiveInfoCoreData.liveCover = k.this.gpE.liveInfo.cover;
                        alaLiveInfoCoreData.rtmpUrl = k.this.gpE.liveInfo.rtmpUrl;
                        alaLiveInfoCoreData.liveTitle = k.this.gpE.title;
                        alaLiveInfoCoreData.audienceCount = k.this.gpE.liveInfo.audienceCount;
                    }
                    if (k.this.grB) {
                        str = k.this.gvP != null ? AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_FRIENDLIVE + k.this.gvP.fid : null;
                    } else {
                        str = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MAIN;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(k.this.mTbPageContext.getPageActivity(), alaLiveInfoCoreData, null, str, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
                }
                if (k.this.gvP.eMh) {
                    ar arVar = new ar("c13611");
                    arVar.dY("obj_param1", k.this.gpE.roomId);
                    arVar.dY("fid", k.this.gvP.fid);
                    arVar.dY("fname", k.this.gvP.fname);
                    arVar.al("obj_locate", k.this.gvP.position);
                    if (k.this.gpE != null && k.this.gpE.uiTransParam != null) {
                        arVar.dY("ab_tag", k.this.gpE.uiTransParam.abTag);
                        arVar.dY("star_id", k.this.gpE.uiTransParam.starId);
                        arVar.dY("extra", k.this.gpE.uiTransParam.extra);
                        arVar.dY("source_from", k.this.gpE.uiTransParam.sourceFrom);
                    }
                    TiebaStatic.log(arVar);
                    return;
                }
                ar arVar2 = new ar("c13557");
                arVar2.dY("obj_param1", k.this.gpE.roomId);
                arVar2.dY("entryname", "游戏");
                TiebaStatic.log(arVar2);
            }
        }
    };

    public k(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_game_live_item_view, (ViewGroup) null, false);
        this.gtL = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.gtL.setBorderSurroundContent(true);
        this.gtL.setDrawBorder(true);
        this.gtL.setPlaceHolder(2);
        this.gtL.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.gvL = this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.gqI = (TextView) this.mRootView.findViewById(R.id.live_title);
        this.gtM = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.bAG = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.gvM = (ViewGroup) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.gvN = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.gvO = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.gtY = new AlphaAnimation(0.0f, 1.0f);
        this.gtY.setDuration(200L);
        this.gtY.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                k.this.mIsAnimating = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                k.this.mIsAnimating = false;
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
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mRootView.getContext());
        if (equipmentWidth != this.gvQ) {
            ViewGroup.LayoutParams layoutParams = this.gvL.getLayoutParams();
            int equipmentWidth2 = (int) (((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mRootView.getContext()) - this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds12)) - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 2.0d);
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
            this.gvL.setLayoutParams(layoutParams);
            this.gvQ = equipmentWidth;
        }
        if (aVar == null || aVar.gpE == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gvP = aVar;
        this.gpE = aVar.gpE;
        Object tag = this.gtL.getTag();
        if (this.gtZ) {
            this.gtX = true;
            this.gtZ = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.gpE.liveInfo.cover) && !((String) tag).equals(this.gpE.liveInfo.cover)) {
            this.gtX = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.gpE.liveInfo.cover) && !this.mCoverUrl.equals(this.gpE.liveInfo.cover)) {
            this.gtX = true;
        } else {
            this.gtX = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.gtU);
        this.mCoverUrl = this.gpE.liveInfo.cover;
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
        this.gtL.startLoad(this.gpE.liveInfo.cover, 10, false);
        this.gvM.setBackgroundDrawable(gradientDrawable);
        this.gtL.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z && k.this.gtX && !k.this.mIsAnimating) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        k.this.gtL.startAnimation(k.this.gtY);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.gtM.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, au.dV(this.gpE.liveInfo.audienceCount)));
        this.bAG.setText(this.gpE.liveAuthor.name);
        this.gqI.setText(this.gpE.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.gpE.recom_extra_img_night;
        } else {
            str = this.gpE.recom_extra_img;
        }
        if (!StringUtils.isNull(str) && this.gpE.recom_extra_img_width > 0 && this.gpE.recom_extra_img_height > 0) {
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
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gvN.getLayoutParams();
            if (layoutParams3 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                layoutParams3.height = dimensionPixelSize;
                layoutParams3.width = (int) ((this.gpE.recom_extra_img_width / this.gpE.recom_extra_img_height) * dimensionPixelSize);
                this.gvN.setLayoutParams(layoutParams3);
            }
            this.gvN.startLoad(str, 10, false);
            this.gvN.setVisibility(0);
        } else {
            this.gvN.setVisibility(8);
        }
        this.gvO.setVisibility(8);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.eMh) {
            ar arVar = new ar("c13610");
            arVar.dY("obj_param1", this.gpE.roomId);
            arVar.dY("fid", aVar.fid);
            arVar.dY("fname", aVar.fname);
            arVar.al("obj_locate", aVar.position);
            if (this.gpE != null && this.gpE.uiTransParam != null) {
                arVar.dY("ab_tag", this.gpE.uiTransParam.abTag);
                arVar.dY("star_id", this.gpE.uiTransParam.starId);
                arVar.dY("extra", this.gpE.uiTransParam.extra);
                arVar.dY("source_from", this.gpE.uiTransParam.sourceFrom);
            }
            TiebaStatic.log(arVar);
            return;
        }
        ar arVar2 = new ar("c13544");
        arVar2.dY("obj_param1", this.gpE.roomId);
        arVar2.dY("entryname", "游戏");
        TiebaStatic.log(arVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.gtM, (int) R.color.CAM_X0101);
            ap.setViewTextColor(this.bAG, (int) R.color.CAM_X0101);
            ap.setViewTextColor(this.gqI, (int) R.color.CAM_X0105);
            Drawable drawable = ap.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.gtM.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.gtM.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }

    public void lZ(boolean z) {
        this.grB = z;
    }
}
