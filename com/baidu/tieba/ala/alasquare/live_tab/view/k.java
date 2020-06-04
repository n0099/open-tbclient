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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class k {
    private static final float feL = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] feM = {0.0f, 0.0f, 0.0f, 0.0f, feL, feL, feL, feL};
    private static final float[] feN = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, feL, feL};
    private static final float[] feO = {0.0f, 0.0f, 0.0f, 0.0f, feL, feL, 0.0f, 0.0f};
    private SdkLiveInfoData faG;
    public TextView fbK;
    public TbImageView feF;
    public TextView feG;
    public TextView feI;
    private AlphaAnimation feT;
    public View fgD;
    public ViewGroup fgE;
    public TbImageView fgF;
    public ImageView fgG;
    private com.baidu.tieba.ala.alasquare.a.a fgH;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    private int[] feP = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean feS = false;
    private boolean feU = true;
    private boolean feV = false;
    private int fgI = 0;
    private boolean fcD = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            if (k.this.fgH != null && k.this.faG != null) {
                if (k.this.faG.shouldJumpChushouLiveRoom()) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(k.this.mTbPageContext, k.this.faG.roomId, String.valueOf(k.this.faG.liveInfo.liveType));
                } else {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = com.baidu.adp.lib.f.b.toLong(k.this.faG.roomId, 0L);
                    if (k.this.faG.liveInfo != null) {
                        alaLiveInfoCoreData.hslUrl = k.this.faG.liveInfo.hlsUrl;
                        alaLiveInfoCoreData.liveCover = k.this.faG.liveInfo.cover;
                        alaLiveInfoCoreData.rtmpUrl = k.this.faG.liveInfo.rtmpUrl;
                        alaLiveInfoCoreData.liveTitle = k.this.faG.title;
                        alaLiveInfoCoreData.audienceCount = k.this.faG.liveInfo.audienceCount;
                    }
                    if (k.this.fcD) {
                        str = k.this.fgH != null ? AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_FRIENDLIVE + k.this.fgH.fid : null;
                    } else {
                        str = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MAIN;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(k.this.mTbPageContext.getPageActivity(), alaLiveInfoCoreData, null, str, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
                }
                if (k.this.fgH.dHL) {
                    an anVar = new an("c13611");
                    anVar.dh("obj_param1", k.this.faG.roomId);
                    anVar.dh("fid", k.this.fgH.fid);
                    anVar.dh("fname", k.this.fgH.fname);
                    anVar.ag("obj_locate", k.this.fgH.position);
                    if (k.this.faG != null && k.this.faG.uiTransParam != null) {
                        anVar.dh("ab_tag", k.this.faG.uiTransParam.abTag);
                        anVar.dh("star_id", k.this.faG.uiTransParam.starId);
                        anVar.dh("extra", k.this.faG.uiTransParam.extra);
                        anVar.dh("source_from", k.this.faG.uiTransParam.sourceFrom);
                    }
                    TiebaStatic.log(anVar);
                    return;
                }
                an anVar2 = new an("c13557");
                anVar2.dh("obj_param1", k.this.faG.roomId);
                anVar2.dh("entryname", "游戏");
                TiebaStatic.log(anVar2);
            }
        }
    };

    public k(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_game_live_item_view, (ViewGroup) null, false);
        this.feF = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.feF.setBorderSurroundContent(true);
        this.feF.setDrawBorder(true);
        this.feF.setPlaceHolder(2);
        this.feF.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.fgD = this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.fbK = (TextView) this.mRootView.findViewById(R.id.live_title);
        this.feG = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.feI = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.fgE = (ViewGroup) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.fgF = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.fgG = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.feT = new AlphaAnimation(0.0f, 1.0f);
        this.feT.setDuration(200L);
        this.feT.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                k.this.feV = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                k.this.feV = false;
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
        if (equipmentWidth != this.fgI) {
            ViewGroup.LayoutParams layoutParams = this.fgD.getLayoutParams();
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
            this.fgD.setLayoutParams(layoutParams);
            this.fgI = equipmentWidth;
        }
        if (aVar == null || aVar.faG == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.fgH = aVar;
        this.faG = aVar.faG;
        Object tag = this.feF.getTag();
        if (this.feU) {
            this.feS = true;
            this.feU = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.faG.liveInfo.cover) && !((String) tag).equals(this.faG.liveInfo.cover)) {
            this.feS = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.faG.liveInfo.cover) && !this.mCoverUrl.equals(this.faG.liveInfo.cover)) {
            this.feS = true;
        } else {
            this.feS = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.feP);
        this.mCoverUrl = this.faG.liveInfo.cover;
        this.feF.setTag(this.mCoverUrl);
        if (aVar.isLeft) {
            this.feF.setConrers(5);
            gradientDrawable.setCornerRadii(feN);
            this.feF.setPlaceHolder(2);
        } else if (aVar.isRight) {
            this.feF.setConrers(10);
            gradientDrawable.setCornerRadii(feO);
            this.feF.setPlaceHolder(2);
        } else if (aVar.faH) {
            this.feF.setConrers(15);
            gradientDrawable.setCornerRadii(feM);
            this.feF.setPlaceHolder(2);
        }
        this.feF.setRadius((int) feL);
        this.feF.startLoad(this.faG.liveInfo.cover, 10, false);
        this.fgE.setBackgroundDrawable(gradientDrawable);
        this.feF.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z && k.this.feS && !k.this.feV) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        k.this.feF.startAnimation(k.this.feT);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.feG.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.cl(this.faG.liveInfo.audienceCount)));
        this.feI.setText(this.faG.liveAuthor.name);
        this.fbK.setText(this.faG.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.faG.recom_extra_img_night;
        } else {
            str = this.faG.recom_extra_img;
        }
        if (!StringUtils.isNull(str) && this.faG.recom_extra_img_width > 0 && this.faG.recom_extra_img_height > 0) {
            if (aVar.isLeft) {
                this.fgF.setConrers(1);
            } else if (aVar.isRight) {
                this.fgF.setConrers(0);
            } else if (aVar.faH) {
                this.fgF.setConrers(1);
            } else {
                this.fgF.setConrers(0);
            }
            this.fgF.setRadius((int) feL);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.fgF.getLayoutParams();
            if (layoutParams3 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                layoutParams3.height = dimensionPixelSize;
                layoutParams3.width = (int) ((this.faG.recom_extra_img_width / this.faG.recom_extra_img_height) * dimensionPixelSize);
                this.fgF.setLayoutParams(layoutParams3);
            }
            this.fgF.startLoad(str, 10, false);
            this.fgF.setVisibility(0);
        } else {
            this.fgF.setVisibility(8);
        }
        this.fgG.setVisibility(8);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.dHL) {
            an anVar = new an("c13610");
            anVar.dh("obj_param1", this.faG.roomId);
            anVar.dh("fid", aVar.fid);
            anVar.dh("fname", aVar.fname);
            anVar.ag("obj_locate", aVar.position);
            if (this.faG != null && this.faG.uiTransParam != null) {
                anVar.dh("ab_tag", this.faG.uiTransParam.abTag);
                anVar.dh("star_id", this.faG.uiTransParam.starId);
                anVar.dh("extra", this.faG.uiTransParam.extra);
                anVar.dh("source_from", this.faG.uiTransParam.sourceFrom);
            }
            TiebaStatic.log(anVar);
            return;
        }
        an anVar2 = new an("c13544");
        anVar2.dh("obj_param1", this.faG.roomId);
        anVar2.dh("entryname", "游戏");
        TiebaStatic.log(anVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.feG, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.feI, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.fbK, (int) R.color.cp_cont_b);
            Drawable drawable = am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.feG.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.feG.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }

    public void jl(boolean z) {
        this.fcD = z;
    }
}
