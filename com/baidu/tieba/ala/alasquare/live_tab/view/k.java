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
    private static final float fJP = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] fJQ = {0.0f, 0.0f, 0.0f, 0.0f, fJP, fJP, fJP, fJP};
    private static final float[] fJR = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, fJP, fJP};
    private static final float[] fJS = {0.0f, 0.0f, 0.0f, 0.0f, fJP, fJP, 0.0f, 0.0f};
    private SdkLiveInfoData fFK;
    public TextView fGO;
    public TbImageView fJJ;
    public TextView fJK;
    public TextView fJM;
    private AlphaAnimation fJX;
    public View fLK;
    public ViewGroup fLL;
    public TbImageView fLM;
    public ImageView fLN;
    private com.baidu.tieba.ala.alasquare.a.a fLO;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    private int[] fJT = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean fJW = false;
    private boolean fJY = true;
    private boolean mIsAnimating = false;
    private int fLP = 0;
    private boolean fHG = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            if (k.this.fLO != null && k.this.fFK != null) {
                if (k.this.fFK.shouldJumpChushouLiveRoom()) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(k.this.mTbPageContext, k.this.fFK.roomId, String.valueOf(k.this.fFK.liveInfo.liveType));
                } else {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = com.baidu.adp.lib.f.b.toLong(k.this.fFK.roomId, 0L);
                    if (k.this.fFK.liveInfo != null) {
                        alaLiveInfoCoreData.hslUrl = k.this.fFK.liveInfo.hlsUrl;
                        alaLiveInfoCoreData.liveCover = k.this.fFK.liveInfo.cover;
                        alaLiveInfoCoreData.rtmpUrl = k.this.fFK.liveInfo.rtmpUrl;
                        alaLiveInfoCoreData.liveTitle = k.this.fFK.title;
                        alaLiveInfoCoreData.audienceCount = k.this.fFK.liveInfo.audienceCount;
                    }
                    if (k.this.fHG) {
                        str = k.this.fLO != null ? AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_FRIENDLIVE + k.this.fLO.fid : null;
                    } else {
                        str = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MAIN;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(k.this.mTbPageContext.getPageActivity(), alaLiveInfoCoreData, null, str, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
                }
                if (k.this.fLO.egs) {
                    aq aqVar = new aq("c13611");
                    aqVar.dF("obj_param1", k.this.fFK.roomId);
                    aqVar.dF("fid", k.this.fLO.fid);
                    aqVar.dF("fname", k.this.fLO.fname);
                    aqVar.ai("obj_locate", k.this.fLO.position);
                    if (k.this.fFK != null && k.this.fFK.uiTransParam != null) {
                        aqVar.dF("ab_tag", k.this.fFK.uiTransParam.abTag);
                        aqVar.dF("star_id", k.this.fFK.uiTransParam.starId);
                        aqVar.dF("extra", k.this.fFK.uiTransParam.extra);
                        aqVar.dF("source_from", k.this.fFK.uiTransParam.sourceFrom);
                    }
                    TiebaStatic.log(aqVar);
                    return;
                }
                aq aqVar2 = new aq("c13557");
                aqVar2.dF("obj_param1", k.this.fFK.roomId);
                aqVar2.dF("entryname", "游戏");
                TiebaStatic.log(aqVar2);
            }
        }
    };

    public k(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_game_live_item_view, (ViewGroup) null, false);
        this.fJJ = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.fJJ.setBorderSurroundContent(true);
        this.fJJ.setDrawBorder(true);
        this.fJJ.setPlaceHolder(2);
        this.fJJ.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.fLK = this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.fGO = (TextView) this.mRootView.findViewById(R.id.live_title);
        this.fJK = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.fJM = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.fLL = (ViewGroup) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.fLM = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.fLN = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.fJX = new AlphaAnimation(0.0f, 1.0f);
        this.fJX.setDuration(200L);
        this.fJX.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.1
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
        if (equipmentWidth != this.fLP) {
            ViewGroup.LayoutParams layoutParams = this.fLK.getLayoutParams();
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
            this.fLK.setLayoutParams(layoutParams);
            this.fLP = equipmentWidth;
        }
        if (aVar == null || aVar.fFK == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.fLO = aVar;
        this.fFK = aVar.fFK;
        Object tag = this.fJJ.getTag();
        if (this.fJY) {
            this.fJW = true;
            this.fJY = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.fFK.liveInfo.cover) && !((String) tag).equals(this.fFK.liveInfo.cover)) {
            this.fJW = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.fFK.liveInfo.cover) && !this.mCoverUrl.equals(this.fFK.liveInfo.cover)) {
            this.fJW = true;
        } else {
            this.fJW = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.fJT);
        this.mCoverUrl = this.fFK.liveInfo.cover;
        this.fJJ.setTag(this.mCoverUrl);
        if (aVar.isLeft) {
            this.fJJ.setConrers(5);
            gradientDrawable.setCornerRadii(fJR);
            this.fJJ.setPlaceHolder(2);
        } else if (aVar.isRight) {
            this.fJJ.setConrers(10);
            gradientDrawable.setCornerRadii(fJS);
            this.fJJ.setPlaceHolder(2);
        } else if (aVar.fFL) {
            this.fJJ.setConrers(15);
            gradientDrawable.setCornerRadii(fJQ);
            this.fJJ.setPlaceHolder(2);
        }
        this.fJJ.setRadius((int) fJP);
        this.fJJ.startLoad(this.fFK.liveInfo.cover, 10, false);
        this.fLL.setBackgroundDrawable(gradientDrawable);
        this.fJJ.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z && k.this.fJW && !k.this.mIsAnimating) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        k.this.fJJ.startAnimation(k.this.fJX);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fJK.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, at.cQ(this.fFK.liveInfo.audienceCount)));
        this.fJM.setText(this.fFK.liveAuthor.name);
        this.fGO.setText(this.fFK.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.fFK.recom_extra_img_night;
        } else {
            str = this.fFK.recom_extra_img;
        }
        if (!StringUtils.isNull(str) && this.fFK.recom_extra_img_width > 0 && this.fFK.recom_extra_img_height > 0) {
            if (aVar.isLeft) {
                this.fLM.setConrers(1);
            } else if (aVar.isRight) {
                this.fLM.setConrers(0);
            } else if (aVar.fFL) {
                this.fLM.setConrers(1);
            } else {
                this.fLM.setConrers(0);
            }
            this.fLM.setRadius((int) fJP);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.fLM.getLayoutParams();
            if (layoutParams3 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                layoutParams3.height = dimensionPixelSize;
                layoutParams3.width = (int) ((this.fFK.recom_extra_img_width / this.fFK.recom_extra_img_height) * dimensionPixelSize);
                this.fLM.setLayoutParams(layoutParams3);
            }
            this.fLM.startLoad(str, 10, false);
            this.fLM.setVisibility(0);
        } else {
            this.fLM.setVisibility(8);
        }
        this.fLN.setVisibility(8);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.egs) {
            aq aqVar = new aq("c13610");
            aqVar.dF("obj_param1", this.fFK.roomId);
            aqVar.dF("fid", aVar.fid);
            aqVar.dF("fname", aVar.fname);
            aqVar.ai("obj_locate", aVar.position);
            if (this.fFK != null && this.fFK.uiTransParam != null) {
                aqVar.dF("ab_tag", this.fFK.uiTransParam.abTag);
                aqVar.dF("star_id", this.fFK.uiTransParam.starId);
                aqVar.dF("extra", this.fFK.uiTransParam.extra);
                aqVar.dF("source_from", this.fFK.uiTransParam.sourceFrom);
            }
            TiebaStatic.log(aqVar);
            return;
        }
        aq aqVar2 = new aq("c13544");
        aqVar2.dF("obj_param1", this.fFK.roomId);
        aqVar2.dF("entryname", "游戏");
        TiebaStatic.log(aqVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.fJK, R.color.cp_cont_a);
            ap.setViewTextColor(this.fJM, R.color.cp_cont_a);
            ap.setViewTextColor(this.fGO, R.color.cp_cont_b);
            Drawable drawable = ap.getDrawable(this.mTbPageContext.getResources(), R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.fJK.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.fJK.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }

    public void kE(boolean z) {
        this.fHG = z;
    }
}
