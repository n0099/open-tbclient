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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class k {
    private static final float glY = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] glZ = {0.0f, 0.0f, 0.0f, 0.0f, glY, glY, glY, glY};
    private static final float[] gma = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, glY, glY};
    private static final float[] gmb = {0.0f, 0.0f, 0.0f, 0.0f, glY, glY, 0.0f, 0.0f};
    public TextView bxh;
    private SdkLiveInfoData ghL;
    public TextView giQ;
    public TbImageView glT;
    public TextView glU;
    private AlphaAnimation gmg;
    public View gnT;
    public ViewGroup gnU;
    public TbImageView gnV;
    public ImageView gnW;
    private com.baidu.tieba.ala.alasquare.a.a gnX;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    private int[] gmc = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean gmf = false;
    private boolean gmh = true;
    private boolean mIsAnimating = false;
    private int gnY = 0;
    private boolean gjJ = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            if (k.this.gnX != null && k.this.ghL != null) {
                if (k.this.ghL.shouldJumpChushouLiveRoom()) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(k.this.mTbPageContext, k.this.ghL.roomId, String.valueOf(k.this.ghL.liveInfo.liveType));
                } else {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = com.baidu.adp.lib.f.b.toLong(k.this.ghL.roomId, 0L);
                    if (k.this.ghL.liveInfo != null) {
                        alaLiveInfoCoreData.hslUrl = k.this.ghL.liveInfo.hlsUrl;
                        alaLiveInfoCoreData.liveCover = k.this.ghL.liveInfo.cover;
                        alaLiveInfoCoreData.rtmpUrl = k.this.ghL.liveInfo.rtmpUrl;
                        alaLiveInfoCoreData.liveTitle = k.this.ghL.title;
                        alaLiveInfoCoreData.audienceCount = k.this.ghL.liveInfo.audienceCount;
                    }
                    if (k.this.gjJ) {
                        str = k.this.gnX != null ? AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_FRIENDLIVE + k.this.gnX.fid : null;
                    } else {
                        str = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MAIN;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(k.this.mTbPageContext.getPageActivity(), alaLiveInfoCoreData, null, str, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
                }
                if (k.this.gnX.eGN) {
                    aq aqVar = new aq("c13611");
                    aqVar.dR("obj_param1", k.this.ghL.roomId);
                    aqVar.dR("fid", k.this.gnX.fid);
                    aqVar.dR("fname", k.this.gnX.fname);
                    aqVar.al("obj_locate", k.this.gnX.position);
                    if (k.this.ghL != null && k.this.ghL.uiTransParam != null) {
                        aqVar.dR("ab_tag", k.this.ghL.uiTransParam.abTag);
                        aqVar.dR("star_id", k.this.ghL.uiTransParam.starId);
                        aqVar.dR("extra", k.this.ghL.uiTransParam.extra);
                        aqVar.dR("source_from", k.this.ghL.uiTransParam.sourceFrom);
                    }
                    TiebaStatic.log(aqVar);
                    return;
                }
                aq aqVar2 = new aq("c13557");
                aqVar2.dR("obj_param1", k.this.ghL.roomId);
                aqVar2.dR("entryname", "游戏");
                TiebaStatic.log(aqVar2);
            }
        }
    };

    public k(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_game_live_item_view, (ViewGroup) null, false);
        this.glT = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.glT.setBorderSurroundContent(true);
        this.glT.setDrawBorder(true);
        this.glT.setPlaceHolder(2);
        this.glT.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.gnT = this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.giQ = (TextView) this.mRootView.findViewById(R.id.live_title);
        this.glU = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.bxh = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.gnU = (ViewGroup) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.gnV = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.gnW = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.gmg = new AlphaAnimation(0.0f, 1.0f);
        this.gmg.setDuration(200L);
        this.gmg.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.1
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
        if (equipmentWidth != this.gnY) {
            ViewGroup.LayoutParams layoutParams = this.gnT.getLayoutParams();
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
            this.gnT.setLayoutParams(layoutParams);
            this.gnY = equipmentWidth;
        }
        if (aVar == null || aVar.ghL == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gnX = aVar;
        this.ghL = aVar.ghL;
        Object tag = this.glT.getTag();
        if (this.gmh) {
            this.gmf = true;
            this.gmh = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.ghL.liveInfo.cover) && !((String) tag).equals(this.ghL.liveInfo.cover)) {
            this.gmf = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.ghL.liveInfo.cover) && !this.mCoverUrl.equals(this.ghL.liveInfo.cover)) {
            this.gmf = true;
        } else {
            this.gmf = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.gmc);
        this.mCoverUrl = this.ghL.liveInfo.cover;
        this.glT.setTag(this.mCoverUrl);
        if (aVar.isLeft) {
            this.glT.setConrers(5);
            gradientDrawable.setCornerRadii(gma);
            this.glT.setPlaceHolder(2);
        } else if (aVar.isRight) {
            this.glT.setConrers(10);
            gradientDrawable.setCornerRadii(gmb);
            this.glT.setPlaceHolder(2);
        } else if (aVar.ghM) {
            this.glT.setConrers(15);
            gradientDrawable.setCornerRadii(glZ);
            this.glT.setPlaceHolder(2);
        }
        this.glT.setRadius((int) glY);
        this.glT.startLoad(this.ghL.liveInfo.cover, 10, false);
        this.gnU.setBackgroundDrawable(gradientDrawable);
        this.glT.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z && k.this.gmf && !k.this.mIsAnimating) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        k.this.glT.startAnimation(k.this.gmg);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.glU.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, at.dw(this.ghL.liveInfo.audienceCount)));
        this.bxh.setText(this.ghL.liveAuthor.name);
        this.giQ.setText(this.ghL.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.ghL.recom_extra_img_night;
        } else {
            str = this.ghL.recom_extra_img;
        }
        if (!StringUtils.isNull(str) && this.ghL.recom_extra_img_width > 0 && this.ghL.recom_extra_img_height > 0) {
            if (aVar.isLeft) {
                this.gnV.setConrers(1);
            } else if (aVar.isRight) {
                this.gnV.setConrers(0);
            } else if (aVar.ghM) {
                this.gnV.setConrers(1);
            } else {
                this.gnV.setConrers(0);
            }
            this.gnV.setRadius((int) glY);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gnV.getLayoutParams();
            if (layoutParams3 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                layoutParams3.height = dimensionPixelSize;
                layoutParams3.width = (int) ((this.ghL.recom_extra_img_width / this.ghL.recom_extra_img_height) * dimensionPixelSize);
                this.gnV.setLayoutParams(layoutParams3);
            }
            this.gnV.startLoad(str, 10, false);
            this.gnV.setVisibility(0);
        } else {
            this.gnV.setVisibility(8);
        }
        this.gnW.setVisibility(8);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.eGN) {
            aq aqVar = new aq("c13610");
            aqVar.dR("obj_param1", this.ghL.roomId);
            aqVar.dR("fid", aVar.fid);
            aqVar.dR("fname", aVar.fname);
            aqVar.al("obj_locate", aVar.position);
            if (this.ghL != null && this.ghL.uiTransParam != null) {
                aqVar.dR("ab_tag", this.ghL.uiTransParam.abTag);
                aqVar.dR("star_id", this.ghL.uiTransParam.starId);
                aqVar.dR("extra", this.ghL.uiTransParam.extra);
                aqVar.dR("source_from", this.ghL.uiTransParam.sourceFrom);
            }
            TiebaStatic.log(aqVar);
            return;
        }
        aq aqVar2 = new aq("c13544");
        aqVar2.dR("obj_param1", this.ghL.roomId);
        aqVar2.dR("entryname", "游戏");
        TiebaStatic.log(aqVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.glU, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.bxh, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.giQ, (int) R.color.cp_cont_b);
            Drawable drawable = ap.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.glU.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.glU.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }

    public void lD(boolean z) {
        this.gjJ = z;
    }
}
