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
    private static final float fGD = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] fGE = {0.0f, 0.0f, 0.0f, 0.0f, fGD, fGD, fGD, fGD};
    private static final float[] fGF = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, fGD, fGD};
    private static final float[] fGG = {0.0f, 0.0f, 0.0f, 0.0f, fGD, fGD, 0.0f, 0.0f};
    private SdkLiveInfoData fCy;
    public TextView fDC;
    public TextView fGA;
    private AlphaAnimation fGL;
    public TbImageView fGx;
    public TextView fGy;
    public View fIv;
    public ViewGroup fIw;
    public TbImageView fIx;
    public ImageView fIy;
    private com.baidu.tieba.ala.alasquare.a.a fIz;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    private int[] fGH = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean fGK = false;
    private boolean fGM = true;
    private boolean mIsAnimating = false;
    private int fIA = 0;
    private boolean fEu = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            if (k.this.fIz != null && k.this.fCy != null) {
                if (k.this.fCy.shouldJumpChushouLiveRoom()) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(k.this.mTbPageContext, k.this.fCy.roomId, String.valueOf(k.this.fCy.liveInfo.liveType));
                } else {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = com.baidu.adp.lib.f.b.toLong(k.this.fCy.roomId, 0L);
                    if (k.this.fCy.liveInfo != null) {
                        alaLiveInfoCoreData.hslUrl = k.this.fCy.liveInfo.hlsUrl;
                        alaLiveInfoCoreData.liveCover = k.this.fCy.liveInfo.cover;
                        alaLiveInfoCoreData.rtmpUrl = k.this.fCy.liveInfo.rtmpUrl;
                        alaLiveInfoCoreData.liveTitle = k.this.fCy.title;
                        alaLiveInfoCoreData.audienceCount = k.this.fCy.liveInfo.audienceCount;
                    }
                    if (k.this.fEu) {
                        str = k.this.fIz != null ? AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_FRIENDLIVE + k.this.fIz.fid : null;
                    } else {
                        str = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MAIN;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(k.this.mTbPageContext.getPageActivity(), alaLiveInfoCoreData, null, str, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
                }
                if (k.this.fIz.eei) {
                    aq aqVar = new aq("c13611");
                    aqVar.dD("obj_param1", k.this.fCy.roomId);
                    aqVar.dD("fid", k.this.fIz.fid);
                    aqVar.dD("fname", k.this.fIz.fname);
                    aqVar.ai("obj_locate", k.this.fIz.position);
                    if (k.this.fCy != null && k.this.fCy.uiTransParam != null) {
                        aqVar.dD("ab_tag", k.this.fCy.uiTransParam.abTag);
                        aqVar.dD("star_id", k.this.fCy.uiTransParam.starId);
                        aqVar.dD("extra", k.this.fCy.uiTransParam.extra);
                        aqVar.dD("source_from", k.this.fCy.uiTransParam.sourceFrom);
                    }
                    TiebaStatic.log(aqVar);
                    return;
                }
                aq aqVar2 = new aq("c13557");
                aqVar2.dD("obj_param1", k.this.fCy.roomId);
                aqVar2.dD("entryname", "游戏");
                TiebaStatic.log(aqVar2);
            }
        }
    };

    public k(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_game_live_item_view, (ViewGroup) null, false);
        this.fGx = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.fGx.setBorderSurroundContent(true);
        this.fGx.setDrawBorder(true);
        this.fGx.setPlaceHolder(2);
        this.fGx.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.fIv = this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.fDC = (TextView) this.mRootView.findViewById(R.id.live_title);
        this.fGy = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.fGA = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.fIw = (ViewGroup) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.fIx = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.fIy = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.fGL = new AlphaAnimation(0.0f, 1.0f);
        this.fGL.setDuration(200L);
        this.fGL.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.1
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
        if (equipmentWidth != this.fIA) {
            ViewGroup.LayoutParams layoutParams = this.fIv.getLayoutParams();
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
            this.fIv.setLayoutParams(layoutParams);
            this.fIA = equipmentWidth;
        }
        if (aVar == null || aVar.fCy == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.fIz = aVar;
        this.fCy = aVar.fCy;
        Object tag = this.fGx.getTag();
        if (this.fGM) {
            this.fGK = true;
            this.fGM = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.fCy.liveInfo.cover) && !((String) tag).equals(this.fCy.liveInfo.cover)) {
            this.fGK = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.fCy.liveInfo.cover) && !this.mCoverUrl.equals(this.fCy.liveInfo.cover)) {
            this.fGK = true;
        } else {
            this.fGK = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.fGH);
        this.mCoverUrl = this.fCy.liveInfo.cover;
        this.fGx.setTag(this.mCoverUrl);
        if (aVar.isLeft) {
            this.fGx.setConrers(5);
            gradientDrawable.setCornerRadii(fGF);
            this.fGx.setPlaceHolder(2);
        } else if (aVar.isRight) {
            this.fGx.setConrers(10);
            gradientDrawable.setCornerRadii(fGG);
            this.fGx.setPlaceHolder(2);
        } else if (aVar.fCz) {
            this.fGx.setConrers(15);
            gradientDrawable.setCornerRadii(fGE);
            this.fGx.setPlaceHolder(2);
        }
        this.fGx.setRadius((int) fGD);
        this.fGx.startLoad(this.fCy.liveInfo.cover, 10, false);
        this.fIw.setBackgroundDrawable(gradientDrawable);
        this.fGx.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z && k.this.fGK && !k.this.mIsAnimating) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        k.this.fGx.startAnimation(k.this.fGL);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fGy.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, at.cP(this.fCy.liveInfo.audienceCount)));
        this.fGA.setText(this.fCy.liveAuthor.name);
        this.fDC.setText(this.fCy.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.fCy.recom_extra_img_night;
        } else {
            str = this.fCy.recom_extra_img;
        }
        if (!StringUtils.isNull(str) && this.fCy.recom_extra_img_width > 0 && this.fCy.recom_extra_img_height > 0) {
            if (aVar.isLeft) {
                this.fIx.setConrers(1);
            } else if (aVar.isRight) {
                this.fIx.setConrers(0);
            } else if (aVar.fCz) {
                this.fIx.setConrers(1);
            } else {
                this.fIx.setConrers(0);
            }
            this.fIx.setRadius((int) fGD);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.fIx.getLayoutParams();
            if (layoutParams3 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                layoutParams3.height = dimensionPixelSize;
                layoutParams3.width = (int) ((this.fCy.recom_extra_img_width / this.fCy.recom_extra_img_height) * dimensionPixelSize);
                this.fIx.setLayoutParams(layoutParams3);
            }
            this.fIx.startLoad(str, 10, false);
            this.fIx.setVisibility(0);
        } else {
            this.fIx.setVisibility(8);
        }
        this.fIy.setVisibility(8);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.eei) {
            aq aqVar = new aq("c13610");
            aqVar.dD("obj_param1", this.fCy.roomId);
            aqVar.dD("fid", aVar.fid);
            aqVar.dD("fname", aVar.fname);
            aqVar.ai("obj_locate", aVar.position);
            if (this.fCy != null && this.fCy.uiTransParam != null) {
                aqVar.dD("ab_tag", this.fCy.uiTransParam.abTag);
                aqVar.dD("star_id", this.fCy.uiTransParam.starId);
                aqVar.dD("extra", this.fCy.uiTransParam.extra);
                aqVar.dD("source_from", this.fCy.uiTransParam.sourceFrom);
            }
            TiebaStatic.log(aqVar);
            return;
        }
        aq aqVar2 = new aq("c13544");
        aqVar2.dD("obj_param1", this.fCy.roomId);
        aqVar2.dD("entryname", "游戏");
        TiebaStatic.log(aqVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.fGy, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.fGA, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.fDC, (int) R.color.cp_cont_b);
            Drawable drawable = ap.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.fGy.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.fGy.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }

    public void kC(boolean z) {
        this.fEu = z;
    }
}
