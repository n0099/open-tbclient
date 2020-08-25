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
    private SdkLiveInfoData fCu;
    public TextView fDy;
    private AlphaAnimation fGH;
    public TbImageView fGt;
    public TextView fGu;
    public TextView fGw;
    public View fIr;
    public ViewGroup fIs;
    public TbImageView fIt;
    public ImageView fIu;
    private com.baidu.tieba.ala.alasquare.a.a fIv;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private static final float fGz = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] fGA = {0.0f, 0.0f, 0.0f, 0.0f, fGz, fGz, fGz, fGz};
    private static final float[] fGB = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, fGz, fGz};
    private static final float[] fGC = {0.0f, 0.0f, 0.0f, 0.0f, fGz, fGz, 0.0f, 0.0f};
    public int mSkinType = 3;
    private int[] fGD = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean fGG = false;
    private boolean fGI = true;
    private boolean mIsAnimating = false;
    private int fIw = 0;
    private boolean fEq = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            if (k.this.fIv != null && k.this.fCu != null) {
                if (k.this.fCu.shouldJumpChushouLiveRoom()) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(k.this.mTbPageContext, k.this.fCu.roomId, String.valueOf(k.this.fCu.liveInfo.liveType));
                } else {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = com.baidu.adp.lib.f.b.toLong(k.this.fCu.roomId, 0L);
                    if (k.this.fCu.liveInfo != null) {
                        alaLiveInfoCoreData.hslUrl = k.this.fCu.liveInfo.hlsUrl;
                        alaLiveInfoCoreData.liveCover = k.this.fCu.liveInfo.cover;
                        alaLiveInfoCoreData.rtmpUrl = k.this.fCu.liveInfo.rtmpUrl;
                        alaLiveInfoCoreData.liveTitle = k.this.fCu.title;
                        alaLiveInfoCoreData.audienceCount = k.this.fCu.liveInfo.audienceCount;
                    }
                    if (k.this.fEq) {
                        str = k.this.fIv != null ? AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_FRIENDLIVE + k.this.fIv.fid : null;
                    } else {
                        str = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MAIN;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(k.this.mTbPageContext.getPageActivity(), alaLiveInfoCoreData, null, str, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
                }
                if (k.this.fIv.eee) {
                    aq aqVar = new aq("c13611");
                    aqVar.dD("obj_param1", k.this.fCu.roomId);
                    aqVar.dD("fid", k.this.fIv.fid);
                    aqVar.dD("fname", k.this.fIv.fname);
                    aqVar.ai("obj_locate", k.this.fIv.position);
                    if (k.this.fCu != null && k.this.fCu.uiTransParam != null) {
                        aqVar.dD("ab_tag", k.this.fCu.uiTransParam.abTag);
                        aqVar.dD("star_id", k.this.fCu.uiTransParam.starId);
                        aqVar.dD("extra", k.this.fCu.uiTransParam.extra);
                        aqVar.dD("source_from", k.this.fCu.uiTransParam.sourceFrom);
                    }
                    TiebaStatic.log(aqVar);
                    return;
                }
                aq aqVar2 = new aq("c13557");
                aqVar2.dD("obj_param1", k.this.fCu.roomId);
                aqVar2.dD("entryname", "游戏");
                TiebaStatic.log(aqVar2);
            }
        }
    };

    public k(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_game_live_item_view, (ViewGroup) null, false);
        this.fGt = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.fGt.setBorderSurroundContent(true);
        this.fGt.setDrawBorder(true);
        this.fGt.setPlaceHolder(2);
        this.fGt.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.fIr = this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.fDy = (TextView) this.mRootView.findViewById(R.id.live_title);
        this.fGu = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.fGw = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.fIs = (ViewGroup) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.fIt = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.fIu = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.fGH = new AlphaAnimation(0.0f, 1.0f);
        this.fGH.setDuration(200L);
        this.fGH.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.1
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
        if (equipmentWidth != this.fIw) {
            ViewGroup.LayoutParams layoutParams = this.fIr.getLayoutParams();
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
            this.fIr.setLayoutParams(layoutParams);
            this.fIw = equipmentWidth;
        }
        if (aVar == null || aVar.fCu == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.fIv = aVar;
        this.fCu = aVar.fCu;
        Object tag = this.fGt.getTag();
        if (this.fGI) {
            this.fGG = true;
            this.fGI = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.fCu.liveInfo.cover) && !((String) tag).equals(this.fCu.liveInfo.cover)) {
            this.fGG = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.fCu.liveInfo.cover) && !this.mCoverUrl.equals(this.fCu.liveInfo.cover)) {
            this.fGG = true;
        } else {
            this.fGG = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.fGD);
        this.mCoverUrl = this.fCu.liveInfo.cover;
        this.fGt.setTag(this.mCoverUrl);
        if (aVar.isLeft) {
            this.fGt.setConrers(5);
            gradientDrawable.setCornerRadii(fGB);
            this.fGt.setPlaceHolder(2);
        } else if (aVar.isRight) {
            this.fGt.setConrers(10);
            gradientDrawable.setCornerRadii(fGC);
            this.fGt.setPlaceHolder(2);
        } else if (aVar.fCv) {
            this.fGt.setConrers(15);
            gradientDrawable.setCornerRadii(fGA);
            this.fGt.setPlaceHolder(2);
        }
        this.fGt.setRadius((int) fGz);
        this.fGt.startLoad(this.fCu.liveInfo.cover, 10, false);
        this.fIs.setBackgroundDrawable(gradientDrawable);
        this.fGt.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z && k.this.fGG && !k.this.mIsAnimating) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        k.this.fGt.startAnimation(k.this.fGH);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fGu.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, at.cP(this.fCu.liveInfo.audienceCount)));
        this.fGw.setText(this.fCu.liveAuthor.name);
        this.fDy.setText(this.fCu.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.fCu.recom_extra_img_night;
        } else {
            str = this.fCu.recom_extra_img;
        }
        if (!StringUtils.isNull(str) && this.fCu.recom_extra_img_width > 0 && this.fCu.recom_extra_img_height > 0) {
            if (aVar.isLeft) {
                this.fIt.setConrers(1);
            } else if (aVar.isRight) {
                this.fIt.setConrers(0);
            } else if (aVar.fCv) {
                this.fIt.setConrers(1);
            } else {
                this.fIt.setConrers(0);
            }
            this.fIt.setRadius((int) fGz);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.fIt.getLayoutParams();
            if (layoutParams3 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                layoutParams3.height = dimensionPixelSize;
                layoutParams3.width = (int) ((this.fCu.recom_extra_img_width / this.fCu.recom_extra_img_height) * dimensionPixelSize);
                this.fIt.setLayoutParams(layoutParams3);
            }
            this.fIt.startLoad(str, 10, false);
            this.fIt.setVisibility(0);
        } else {
            this.fIt.setVisibility(8);
        }
        this.fIu.setVisibility(8);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.eee) {
            aq aqVar = new aq("c13610");
            aqVar.dD("obj_param1", this.fCu.roomId);
            aqVar.dD("fid", aVar.fid);
            aqVar.dD("fname", aVar.fname);
            aqVar.ai("obj_locate", aVar.position);
            if (this.fCu != null && this.fCu.uiTransParam != null) {
                aqVar.dD("ab_tag", this.fCu.uiTransParam.abTag);
                aqVar.dD("star_id", this.fCu.uiTransParam.starId);
                aqVar.dD("extra", this.fCu.uiTransParam.extra);
                aqVar.dD("source_from", this.fCu.uiTransParam.sourceFrom);
            }
            TiebaStatic.log(aqVar);
            return;
        }
        aq aqVar2 = new aq("c13544");
        aqVar2.dD("obj_param1", this.fCu.roomId);
        aqVar2.dD("entryname", "游戏");
        TiebaStatic.log(aqVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.fGu, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.fGw, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.fDy, (int) R.color.cp_cont_b);
            Drawable drawable = ap.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.fGu.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.fGu.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }

    public void kA(boolean z) {
        this.fEq = z;
    }
}
