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
/* loaded from: classes4.dex */
public class k {
    private static final float glF = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] glG = {0.0f, 0.0f, 0.0f, 0.0f, glF, glF, glF, glF};
    private static final float[] glH = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, glF, glF};
    private static final float[] glI = {0.0f, 0.0f, 0.0f, 0.0f, glF, glF, 0.0f, 0.0f};
    public TextView bvw;
    private SdkLiveInfoData ghs;
    public TextView gix;
    public TbImageView glA;
    public TextView glB;
    private AlphaAnimation glN;
    public View gnA;
    public ViewGroup gnB;
    public TbImageView gnC;
    public ImageView gnD;
    private com.baidu.tieba.ala.alasquare.a.a gnE;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    private int[] glJ = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean glM = false;
    private boolean glO = true;
    private boolean mIsAnimating = false;
    private int gnF = 0;
    private boolean gjq = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            if (k.this.gnE != null && k.this.ghs != null) {
                if (k.this.ghs.shouldJumpChushouLiveRoom()) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(k.this.mTbPageContext, k.this.ghs.roomId, String.valueOf(k.this.ghs.liveInfo.liveType));
                } else {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = com.baidu.adp.lib.f.b.toLong(k.this.ghs.roomId, 0L);
                    if (k.this.ghs.liveInfo != null) {
                        alaLiveInfoCoreData.hslUrl = k.this.ghs.liveInfo.hlsUrl;
                        alaLiveInfoCoreData.liveCover = k.this.ghs.liveInfo.cover;
                        alaLiveInfoCoreData.rtmpUrl = k.this.ghs.liveInfo.rtmpUrl;
                        alaLiveInfoCoreData.liveTitle = k.this.ghs.title;
                        alaLiveInfoCoreData.audienceCount = k.this.ghs.liveInfo.audienceCount;
                    }
                    if (k.this.gjq) {
                        str = k.this.gnE != null ? AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_FRIENDLIVE + k.this.gnE.fid : null;
                    } else {
                        str = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MAIN;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(k.this.mTbPageContext.getPageActivity(), alaLiveInfoCoreData, null, str, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
                }
                if (k.this.gnE.eFf) {
                    ar arVar = new ar("c13611");
                    arVar.dR("obj_param1", k.this.ghs.roomId);
                    arVar.dR("fid", k.this.gnE.fid);
                    arVar.dR("fname", k.this.gnE.fname);
                    arVar.ak("obj_locate", k.this.gnE.position);
                    if (k.this.ghs != null && k.this.ghs.uiTransParam != null) {
                        arVar.dR("ab_tag", k.this.ghs.uiTransParam.abTag);
                        arVar.dR("star_id", k.this.ghs.uiTransParam.starId);
                        arVar.dR("extra", k.this.ghs.uiTransParam.extra);
                        arVar.dR("source_from", k.this.ghs.uiTransParam.sourceFrom);
                    }
                    TiebaStatic.log(arVar);
                    return;
                }
                ar arVar2 = new ar("c13557");
                arVar2.dR("obj_param1", k.this.ghs.roomId);
                arVar2.dR("entryname", "游戏");
                TiebaStatic.log(arVar2);
            }
        }
    };

    public k(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_game_live_item_view, (ViewGroup) null, false);
        this.glA = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.glA.setBorderSurroundContent(true);
        this.glA.setDrawBorder(true);
        this.glA.setPlaceHolder(2);
        this.glA.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.gnA = this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.gix = (TextView) this.mRootView.findViewById(R.id.live_title);
        this.glB = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.bvw = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.gnB = (ViewGroup) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.gnC = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.gnD = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.glN = new AlphaAnimation(0.0f, 1.0f);
        this.glN.setDuration(200L);
        this.glN.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.1
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
        if (equipmentWidth != this.gnF) {
            ViewGroup.LayoutParams layoutParams = this.gnA.getLayoutParams();
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
            this.gnA.setLayoutParams(layoutParams);
            this.gnF = equipmentWidth;
        }
        if (aVar == null || aVar.ghs == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gnE = aVar;
        this.ghs = aVar.ghs;
        Object tag = this.glA.getTag();
        if (this.glO) {
            this.glM = true;
            this.glO = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.ghs.liveInfo.cover) && !((String) tag).equals(this.ghs.liveInfo.cover)) {
            this.glM = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.ghs.liveInfo.cover) && !this.mCoverUrl.equals(this.ghs.liveInfo.cover)) {
            this.glM = true;
        } else {
            this.glM = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.glJ);
        this.mCoverUrl = this.ghs.liveInfo.cover;
        this.glA.setTag(this.mCoverUrl);
        if (aVar.isLeft) {
            this.glA.setConrers(5);
            gradientDrawable.setCornerRadii(glH);
            this.glA.setPlaceHolder(2);
        } else if (aVar.isRight) {
            this.glA.setConrers(10);
            gradientDrawable.setCornerRadii(glI);
            this.glA.setPlaceHolder(2);
        } else if (aVar.ght) {
            this.glA.setConrers(15);
            gradientDrawable.setCornerRadii(glG);
            this.glA.setPlaceHolder(2);
        }
        this.glA.setRadius((int) glF);
        this.glA.startLoad(this.ghs.liveInfo.cover, 10, false);
        this.gnB.setBackgroundDrawable(gradientDrawable);
        this.glA.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z && k.this.glM && !k.this.mIsAnimating) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        k.this.glA.startAnimation(k.this.glN);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.glB.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, au.dw(this.ghs.liveInfo.audienceCount)));
        this.bvw.setText(this.ghs.liveAuthor.name);
        this.gix.setText(this.ghs.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.ghs.recom_extra_img_night;
        } else {
            str = this.ghs.recom_extra_img;
        }
        if (!StringUtils.isNull(str) && this.ghs.recom_extra_img_width > 0 && this.ghs.recom_extra_img_height > 0) {
            if (aVar.isLeft) {
                this.gnC.setConrers(1);
            } else if (aVar.isRight) {
                this.gnC.setConrers(0);
            } else if (aVar.ght) {
                this.gnC.setConrers(1);
            } else {
                this.gnC.setConrers(0);
            }
            this.gnC.setRadius((int) glF);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gnC.getLayoutParams();
            if (layoutParams3 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                layoutParams3.height = dimensionPixelSize;
                layoutParams3.width = (int) ((this.ghs.recom_extra_img_width / this.ghs.recom_extra_img_height) * dimensionPixelSize);
                this.gnC.setLayoutParams(layoutParams3);
            }
            this.gnC.startLoad(str, 10, false);
            this.gnC.setVisibility(0);
        } else {
            this.gnC.setVisibility(8);
        }
        this.gnD.setVisibility(8);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.eFf) {
            ar arVar = new ar("c13610");
            arVar.dR("obj_param1", this.ghs.roomId);
            arVar.dR("fid", aVar.fid);
            arVar.dR("fname", aVar.fname);
            arVar.ak("obj_locate", aVar.position);
            if (this.ghs != null && this.ghs.uiTransParam != null) {
                arVar.dR("ab_tag", this.ghs.uiTransParam.abTag);
                arVar.dR("star_id", this.ghs.uiTransParam.starId);
                arVar.dR("extra", this.ghs.uiTransParam.extra);
                arVar.dR("source_from", this.ghs.uiTransParam.sourceFrom);
            }
            TiebaStatic.log(arVar);
            return;
        }
        ar arVar2 = new ar("c13544");
        arVar2.dR("obj_param1", this.ghs.roomId);
        arVar2.dR("entryname", "游戏");
        TiebaStatic.log(arVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.glB, R.color.CAM_X0101);
            ap.setViewTextColor(this.bvw, R.color.CAM_X0101);
            ap.setViewTextColor(this.gix, R.color.CAM_X0105);
            Drawable drawable = ap.getDrawable(this.mTbPageContext.getResources(), R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.glB.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.glB.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }

    public void lE(boolean z) {
        this.gjq = z;
    }
}
