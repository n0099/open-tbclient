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
    private static final float gDg = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] gDh = {0.0f, 0.0f, 0.0f, 0.0f, gDg, gDg, gDg, gDg};
    private static final float[] gDi = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, gDg, gDg};
    private static final float[] gDj = {0.0f, 0.0f, 0.0f, 0.0f, gDg, gDg, 0.0f, 0.0f};
    public TextView bEn;
    public TbImageView gDb;
    public TextView gDc;
    private AlphaAnimation gDo;
    public View gFc;
    public ViewGroup gFd;
    public TbImageView gFe;
    public ImageView gFf;
    private com.baidu.tieba.ala.alasquare.a.a gFg;
    private SdkLiveInfoData gyL;
    public TextView gzY;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    private int[] gDk = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean gDn = false;
    private boolean gDp = true;
    private boolean gDq = false;
    private int gFh = 0;
    private boolean gAR = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            if (g.this.gFg != null && g.this.gyL != null) {
                if (g.this.gyL.shouldJumpChushouLiveRoom()) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(g.this.mTbPageContext, g.this.gyL.roomId, String.valueOf(g.this.gyL.liveInfo.liveType));
                } else {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = com.baidu.adp.lib.f.b.toLong(g.this.gyL.roomId, 0L);
                    if (g.this.gyL.liveInfo != null) {
                        alaLiveInfoCoreData.hslUrl = g.this.gyL.liveInfo.hlsUrl;
                        alaLiveInfoCoreData.liveCover = g.this.gyL.liveInfo.cover;
                        alaLiveInfoCoreData.rtmpUrl = g.this.gyL.liveInfo.rtmpUrl;
                        alaLiveInfoCoreData.liveTitle = g.this.gyL.title;
                        alaLiveInfoCoreData.audienceCount = g.this.gyL.liveInfo.audienceCount;
                    }
                    if (g.this.gAR) {
                        str = g.this.gFg != null ? AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_FRIENDLIVE + g.this.gFg.fid : null;
                    } else {
                        str = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MAIN;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(g.this.mTbPageContext.getPageActivity(), alaLiveInfoCoreData, null, str, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
                }
                if (g.this.gFg.eTD) {
                    ar arVar = new ar("c13611");
                    arVar.dR("obj_param1", g.this.gyL.roomId);
                    arVar.dR("fid", g.this.gFg.fid);
                    arVar.dR("fname", g.this.gFg.fname);
                    arVar.ap("obj_locate", g.this.gFg.position);
                    if (g.this.gyL != null && g.this.gyL.uiTransParam != null) {
                        arVar.dR("ab_tag", g.this.gyL.uiTransParam.abTag);
                        arVar.dR("star_id", g.this.gyL.uiTransParam.starId);
                        arVar.dR("extra", g.this.gyL.uiTransParam.extra);
                        arVar.dR(VideoPlayActivityConfig.SOURCE_FROM, g.this.gyL.uiTransParam.sourceFrom);
                    }
                    TiebaStatic.log(arVar);
                    return;
                }
                ar arVar2 = new ar("c13557");
                arVar2.dR("obj_param1", g.this.gyL.roomId);
                arVar2.dR("entryname", "游戏");
                TiebaStatic.log(arVar2);
            }
        }
    };

    public g(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_game_live_item_view, (ViewGroup) null, false);
        this.gDb = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.gDb.setBorderSurroundContent(true);
        this.gDb.setDrawBorder(true);
        this.gDb.setPlaceHolder(2);
        this.gDb.setBorderWidth(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.gFc = this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.gzY = (TextView) this.mRootView.findViewById(R.id.live_title);
        this.gDc = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.bEn = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.gFd = (ViewGroup) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.gFe = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.gFf = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.gDo = new AlphaAnimation(0.0f, 1.0f);
        this.gDo.setDuration(200L);
        this.gDo.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                g.this.gDq = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                g.this.gDq = false;
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
        if (equipmentWidth != this.gFh) {
            ViewGroup.LayoutParams layoutParams = this.gFc.getLayoutParams();
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
            this.gFc.setLayoutParams(layoutParams);
            this.gFh = equipmentWidth;
        }
        if (aVar == null || aVar.gyL == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gFg = aVar;
        this.gyL = aVar.gyL;
        Object tag = this.gDb.getTag();
        if (this.gDp) {
            this.gDn = true;
            this.gDp = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.gyL.liveInfo.cover) && !((String) tag).equals(this.gyL.liveInfo.cover)) {
            this.gDn = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.gyL.liveInfo.cover) && !this.mCoverUrl.equals(this.gyL.liveInfo.cover)) {
            this.gDn = true;
        } else {
            this.gDn = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.gDk);
        this.mCoverUrl = this.gyL.liveInfo.cover;
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
        this.gDb.startLoad(this.gyL.liveInfo.cover, 10, false);
        this.gFd.setBackgroundDrawable(gradientDrawable);
        this.gDb.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.g.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str2, boolean z) {
                if (z && g.this.gDn && !g.this.gDq) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        g.this.gDb.startAnimation(g.this.gDo);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        });
        this.gDc.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, au.eb(this.gyL.liveInfo.audienceCount)));
        this.bEn.setText(this.gyL.liveAuthor.name);
        this.gzY.setText(this.gyL.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.gyL.recom_extra_img_night;
        } else {
            str = this.gyL.recom_extra_img;
        }
        if (!StringUtils.isNull(str) && this.gyL.recom_extra_img_width > 0 && this.gyL.recom_extra_img_height > 0) {
            if (aVar.isLeft) {
                this.gFe.setConrers(1);
            } else if (aVar.isRight) {
                this.gFe.setConrers(0);
            } else if (aVar.gyM) {
                this.gFe.setConrers(1);
            } else {
                this.gFe.setConrers(0);
            }
            this.gFe.setRadius((int) gDg);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gFe.getLayoutParams();
            if (layoutParams3 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                layoutParams3.height = dimensionPixelSize;
                layoutParams3.width = (int) ((this.gyL.recom_extra_img_width / this.gyL.recom_extra_img_height) * dimensionPixelSize);
                this.gFe.setLayoutParams(layoutParams3);
            }
            this.gFe.startLoad(str, 10, false);
            this.gFe.setVisibility(0);
        } else {
            this.gFe.setVisibility(8);
        }
        this.gFf.setVisibility(8);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.eTD) {
            ar arVar = new ar("c13610");
            arVar.dR("obj_param1", this.gyL.roomId);
            arVar.dR("fid", aVar.fid);
            arVar.dR("fname", aVar.fname);
            arVar.ap("obj_locate", aVar.position);
            if (this.gyL != null && this.gyL.uiTransParam != null) {
                arVar.dR("ab_tag", this.gyL.uiTransParam.abTag);
                arVar.dR("star_id", this.gyL.uiTransParam.starId);
                arVar.dR("extra", this.gyL.uiTransParam.extra);
                arVar.dR(VideoPlayActivityConfig.SOURCE_FROM, this.gyL.uiTransParam.sourceFrom);
            }
            TiebaStatic.log(arVar);
            return;
        }
        ar arVar2 = new ar("c13544");
        arVar2.dR("obj_param1", this.gyL.roomId);
        arVar2.dR("entryname", "游戏");
        TiebaStatic.log(arVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.gDc, R.color.CAM_X0101);
            ap.setViewTextColor(this.bEn, R.color.CAM_X0101);
            ap.setViewTextColor(this.gzY, R.color.CAM_X0105);
            Drawable drawable = ap.getDrawable(this.mTbPageContext.getResources(), R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.gDc.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.gDc.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }

    public void mw(boolean z) {
        this.gAR = z;
    }
}
