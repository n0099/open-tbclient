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
/* loaded from: classes9.dex */
public class g {
    private static final float gAi = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] gAj = {0.0f, 0.0f, 0.0f, 0.0f, gAi, gAi, gAi, gAi};
    private static final float[] gAk = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, gAi, gAi};
    private static final float[] gAl = {0.0f, 0.0f, 0.0f, 0.0f, gAi, gAi, 0.0f, 0.0f};
    public TextView bAH;
    public TbImageView gAd;
    public TextView gAe;
    private AlphaAnimation gAq;
    public View gCe;
    public ViewGroup gCf;
    public TbImageView gCg;
    public ImageView gCh;
    private com.baidu.tieba.ala.alasquare.a.a gCi;
    private SdkLiveInfoData gvN;
    public TextView gxa;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    private int[] gAm = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean gAp = false;
    private boolean gAr = true;
    private boolean gAs = false;
    private int gCj = 0;
    private boolean gxT = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            if (g.this.gCi != null && g.this.gvN != null) {
                if (g.this.gvN.shouldJumpChushouLiveRoom()) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(g.this.mTbPageContext, g.this.gvN.roomId, String.valueOf(g.this.gvN.liveInfo.liveType));
                } else {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = com.baidu.adp.lib.f.b.toLong(g.this.gvN.roomId, 0L);
                    if (g.this.gvN.liveInfo != null) {
                        alaLiveInfoCoreData.hslUrl = g.this.gvN.liveInfo.hlsUrl;
                        alaLiveInfoCoreData.liveCover = g.this.gvN.liveInfo.cover;
                        alaLiveInfoCoreData.rtmpUrl = g.this.gvN.liveInfo.rtmpUrl;
                        alaLiveInfoCoreData.liveTitle = g.this.gvN.title;
                        alaLiveInfoCoreData.audienceCount = g.this.gvN.liveInfo.audienceCount;
                    }
                    if (g.this.gxT) {
                        str = g.this.gCi != null ? AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_FRIENDLIVE + g.this.gCi.fid : null;
                    } else {
                        str = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MAIN;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(g.this.mTbPageContext.getPageActivity(), alaLiveInfoCoreData, null, str, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
                }
                if (g.this.gCi.eRr) {
                    aq aqVar = new aq("c13611");
                    aqVar.dW("obj_param1", g.this.gvN.roomId);
                    aqVar.dW("fid", g.this.gCi.fid);
                    aqVar.dW("fname", g.this.gCi.fname);
                    aqVar.an("obj_locate", g.this.gCi.position);
                    if (g.this.gvN != null && g.this.gvN.uiTransParam != null) {
                        aqVar.dW("ab_tag", g.this.gvN.uiTransParam.abTag);
                        aqVar.dW("star_id", g.this.gvN.uiTransParam.starId);
                        aqVar.dW("extra", g.this.gvN.uiTransParam.extra);
                        aqVar.dW(VideoPlayActivityConfig.SOURCE_FROM, g.this.gvN.uiTransParam.sourceFrom);
                    }
                    TiebaStatic.log(aqVar);
                    return;
                }
                aq aqVar2 = new aq("c13557");
                aqVar2.dW("obj_param1", g.this.gvN.roomId);
                aqVar2.dW("entryname", "游戏");
                TiebaStatic.log(aqVar2);
            }
        }
    };

    public g(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_game_live_item_view, (ViewGroup) null, false);
        this.gAd = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.gAd.setBorderSurroundContent(true);
        this.gAd.setDrawBorder(true);
        this.gAd.setPlaceHolder(2);
        this.gAd.setBorderWidth(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.gCe = this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.gxa = (TextView) this.mRootView.findViewById(R.id.live_title);
        this.gAe = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.bAH = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.gCf = (ViewGroup) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.gCg = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.gCh = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.gAq = new AlphaAnimation(0.0f, 1.0f);
        this.gAq.setDuration(200L);
        this.gAq.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                g.this.gAs = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                g.this.gAs = false;
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
        if (equipmentWidth != this.gCj) {
            ViewGroup.LayoutParams layoutParams = this.gCe.getLayoutParams();
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
            this.gCe.setLayoutParams(layoutParams);
            this.gCj = equipmentWidth;
        }
        if (aVar == null || aVar.gvN == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gCi = aVar;
        this.gvN = aVar.gvN;
        Object tag = this.gAd.getTag();
        if (this.gAr) {
            this.gAp = true;
            this.gAr = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.gvN.liveInfo.cover) && !((String) tag).equals(this.gvN.liveInfo.cover)) {
            this.gAp = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.gvN.liveInfo.cover) && !this.mCoverUrl.equals(this.gvN.liveInfo.cover)) {
            this.gAp = true;
        } else {
            this.gAp = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.gAm);
        this.mCoverUrl = this.gvN.liveInfo.cover;
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
        this.gAd.startLoad(this.gvN.liveInfo.cover, 10, false);
        this.gCf.setBackgroundDrawable(gradientDrawable);
        this.gAd.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str2, boolean z) {
                if (z && g.this.gAp && !g.this.gAs) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        g.this.gAd.startAnimation(g.this.gAq);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        });
        this.gAe.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, at.dV(this.gvN.liveInfo.audienceCount)));
        this.bAH.setText(this.gvN.liveAuthor.name);
        this.gxa.setText(this.gvN.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.gvN.recom_extra_img_night;
        } else {
            str = this.gvN.recom_extra_img;
        }
        if (!StringUtils.isNull(str) && this.gvN.recom_extra_img_width > 0 && this.gvN.recom_extra_img_height > 0) {
            if (aVar.isLeft) {
                this.gCg.setConrers(1);
            } else if (aVar.isRight) {
                this.gCg.setConrers(0);
            } else if (aVar.gvO) {
                this.gCg.setConrers(1);
            } else {
                this.gCg.setConrers(0);
            }
            this.gCg.setRadius((int) gAi);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gCg.getLayoutParams();
            if (layoutParams3 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                layoutParams3.height = dimensionPixelSize;
                layoutParams3.width = (int) ((this.gvN.recom_extra_img_width / this.gvN.recom_extra_img_height) * dimensionPixelSize);
                this.gCg.setLayoutParams(layoutParams3);
            }
            this.gCg.startLoad(str, 10, false);
            this.gCg.setVisibility(0);
        } else {
            this.gCg.setVisibility(8);
        }
        this.gCh.setVisibility(8);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.eRr) {
            aq aqVar = new aq("c13610");
            aqVar.dW("obj_param1", this.gvN.roomId);
            aqVar.dW("fid", aVar.fid);
            aqVar.dW("fname", aVar.fname);
            aqVar.an("obj_locate", aVar.position);
            if (this.gvN != null && this.gvN.uiTransParam != null) {
                aqVar.dW("ab_tag", this.gvN.uiTransParam.abTag);
                aqVar.dW("star_id", this.gvN.uiTransParam.starId);
                aqVar.dW("extra", this.gvN.uiTransParam.extra);
                aqVar.dW(VideoPlayActivityConfig.SOURCE_FROM, this.gvN.uiTransParam.sourceFrom);
            }
            TiebaStatic.log(aqVar);
            return;
        }
        aq aqVar2 = new aq("c13544");
        aqVar2.dW("obj_param1", this.gvN.roomId);
        aqVar2.dW("entryname", "游戏");
        TiebaStatic.log(aqVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setViewTextColor(this.gAe, R.color.CAM_X0101);
            ao.setViewTextColor(this.bAH, R.color.CAM_X0101);
            ao.setViewTextColor(this.gxa, R.color.CAM_X0105);
            Drawable drawable = ao.getDrawable(this.mTbPageContext.getResources(), R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.gAe.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.gAe.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }

    public void ms(boolean z) {
        this.gxT = z;
    }
}
