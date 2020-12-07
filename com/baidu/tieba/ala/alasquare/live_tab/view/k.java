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
    private static final float gtO = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] gtP = {0.0f, 0.0f, 0.0f, 0.0f, gtO, gtO, gtO, gtO};
    private static final float[] gtQ = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, gtO, gtO};
    private static final float[] gtR = {0.0f, 0.0f, 0.0f, 0.0f, gtO, gtO, 0.0f, 0.0f};
    public TextView bAG;
    private SdkLiveInfoData gpC;
    public TextView gqG;
    public TbImageView gtJ;
    public TextView gtK;
    private AlphaAnimation gtW;
    public View gvJ;
    public ViewGroup gvK;
    public TbImageView gvL;
    public ImageView gvM;
    private com.baidu.tieba.ala.alasquare.a.a gvN;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    private int[] gtS = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean gtV = false;
    private boolean gtX = true;
    private boolean mIsAnimating = false;
    private int gvO = 0;
    private boolean grz = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            if (k.this.gvN != null && k.this.gpC != null) {
                if (k.this.gpC.shouldJumpChushouLiveRoom()) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(k.this.mTbPageContext, k.this.gpC.roomId, String.valueOf(k.this.gpC.liveInfo.liveType));
                } else {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = com.baidu.adp.lib.f.b.toLong(k.this.gpC.roomId, 0L);
                    if (k.this.gpC.liveInfo != null) {
                        alaLiveInfoCoreData.hslUrl = k.this.gpC.liveInfo.hlsUrl;
                        alaLiveInfoCoreData.liveCover = k.this.gpC.liveInfo.cover;
                        alaLiveInfoCoreData.rtmpUrl = k.this.gpC.liveInfo.rtmpUrl;
                        alaLiveInfoCoreData.liveTitle = k.this.gpC.title;
                        alaLiveInfoCoreData.audienceCount = k.this.gpC.liveInfo.audienceCount;
                    }
                    if (k.this.grz) {
                        str = k.this.gvN != null ? AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_FRIENDLIVE + k.this.gvN.fid : null;
                    } else {
                        str = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MAIN;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(k.this.mTbPageContext.getPageActivity(), alaLiveInfoCoreData, null, str, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
                }
                if (k.this.gvN.eMh) {
                    ar arVar = new ar("c13611");
                    arVar.dY("obj_param1", k.this.gpC.roomId);
                    arVar.dY("fid", k.this.gvN.fid);
                    arVar.dY("fname", k.this.gvN.fname);
                    arVar.al("obj_locate", k.this.gvN.position);
                    if (k.this.gpC != null && k.this.gpC.uiTransParam != null) {
                        arVar.dY("ab_tag", k.this.gpC.uiTransParam.abTag);
                        arVar.dY("star_id", k.this.gpC.uiTransParam.starId);
                        arVar.dY("extra", k.this.gpC.uiTransParam.extra);
                        arVar.dY("source_from", k.this.gpC.uiTransParam.sourceFrom);
                    }
                    TiebaStatic.log(arVar);
                    return;
                }
                ar arVar2 = new ar("c13557");
                arVar2.dY("obj_param1", k.this.gpC.roomId);
                arVar2.dY("entryname", "游戏");
                TiebaStatic.log(arVar2);
            }
        }
    };

    public k(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_game_live_item_view, (ViewGroup) null, false);
        this.gtJ = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.gtJ.setBorderSurroundContent(true);
        this.gtJ.setDrawBorder(true);
        this.gtJ.setPlaceHolder(2);
        this.gtJ.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.gvJ = this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.gqG = (TextView) this.mRootView.findViewById(R.id.live_title);
        this.gtK = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.bAG = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.gvK = (ViewGroup) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.gvL = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.gvM = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.gtW = new AlphaAnimation(0.0f, 1.0f);
        this.gtW.setDuration(200L);
        this.gtW.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.1
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
        if (equipmentWidth != this.gvO) {
            ViewGroup.LayoutParams layoutParams = this.gvJ.getLayoutParams();
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
            this.gvJ.setLayoutParams(layoutParams);
            this.gvO = equipmentWidth;
        }
        if (aVar == null || aVar.gpC == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gvN = aVar;
        this.gpC = aVar.gpC;
        Object tag = this.gtJ.getTag();
        if (this.gtX) {
            this.gtV = true;
            this.gtX = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.gpC.liveInfo.cover) && !((String) tag).equals(this.gpC.liveInfo.cover)) {
            this.gtV = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.gpC.liveInfo.cover) && !this.mCoverUrl.equals(this.gpC.liveInfo.cover)) {
            this.gtV = true;
        } else {
            this.gtV = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.gtS);
        this.mCoverUrl = this.gpC.liveInfo.cover;
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
        this.gtJ.startLoad(this.gpC.liveInfo.cover, 10, false);
        this.gvK.setBackgroundDrawable(gradientDrawable);
        this.gtJ.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z && k.this.gtV && !k.this.mIsAnimating) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        k.this.gtJ.startAnimation(k.this.gtW);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.gtK.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, au.dV(this.gpC.liveInfo.audienceCount)));
        this.bAG.setText(this.gpC.liveAuthor.name);
        this.gqG.setText(this.gpC.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.gpC.recom_extra_img_night;
        } else {
            str = this.gpC.recom_extra_img;
        }
        if (!StringUtils.isNull(str) && this.gpC.recom_extra_img_width > 0 && this.gpC.recom_extra_img_height > 0) {
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
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gvL.getLayoutParams();
            if (layoutParams3 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                layoutParams3.height = dimensionPixelSize;
                layoutParams3.width = (int) ((this.gpC.recom_extra_img_width / this.gpC.recom_extra_img_height) * dimensionPixelSize);
                this.gvL.setLayoutParams(layoutParams3);
            }
            this.gvL.startLoad(str, 10, false);
            this.gvL.setVisibility(0);
        } else {
            this.gvL.setVisibility(8);
        }
        this.gvM.setVisibility(8);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.eMh) {
            ar arVar = new ar("c13610");
            arVar.dY("obj_param1", this.gpC.roomId);
            arVar.dY("fid", aVar.fid);
            arVar.dY("fname", aVar.fname);
            arVar.al("obj_locate", aVar.position);
            if (this.gpC != null && this.gpC.uiTransParam != null) {
                arVar.dY("ab_tag", this.gpC.uiTransParam.abTag);
                arVar.dY("star_id", this.gpC.uiTransParam.starId);
                arVar.dY("extra", this.gpC.uiTransParam.extra);
                arVar.dY("source_from", this.gpC.uiTransParam.sourceFrom);
            }
            TiebaStatic.log(arVar);
            return;
        }
        ar arVar2 = new ar("c13544");
        arVar2.dY("obj_param1", this.gpC.roomId);
        arVar2.dY("entryname", "游戏");
        TiebaStatic.log(arVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.gtK, R.color.CAM_X0101);
            ap.setViewTextColor(this.bAG, R.color.CAM_X0101);
            ap.setViewTextColor(this.gqG, R.color.CAM_X0105);
            Drawable drawable = ap.getDrawable(this.mTbPageContext.getResources(), R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.gtK.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.gtK.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }

    public void lZ(boolean z) {
        this.grz = z;
    }
}
