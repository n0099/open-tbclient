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
    private static final float enL = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] enM = {0.0f, 0.0f, 0.0f, 0.0f, enL, enL, enL, enL};
    private static final float[] enN = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, enL, enL};
    private static final float[] enO = {0.0f, 0.0f, 0.0f, 0.0f, enL, enL, 0.0f, 0.0f};
    private SdkLiveInfoData ejG;
    public TextView ekK;
    public TbImageView enF;
    public TextView enG;
    public TextView enI;
    private AlphaAnimation enT;
    public ViewGroup epA;
    public TbImageView epB;
    public ImageView epC;
    private com.baidu.tieba.ala.alasquare.a.a epD;
    public View epz;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    private int[] enP = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean enS = false;
    private boolean enU = true;
    private boolean enV = false;
    private int epE = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (k.this.epD != null && k.this.ejG != null) {
                if (k.this.ejG.shouldJumpChushouLiveRoom()) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(k.this.mTbPageContext, k.this.ejG.roomId, String.valueOf(k.this.ejG.liveInfo.liveType));
                } else {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = com.baidu.adp.lib.f.b.toLong(k.this.ejG.roomId, 0L);
                    if (k.this.ejG.liveInfo != null) {
                        alaLiveInfoCoreData.hslUrl = k.this.ejG.liveInfo.hlsUrl;
                        alaLiveInfoCoreData.liveCover = k.this.ejG.liveInfo.cover;
                        alaLiveInfoCoreData.rtmpUrl = k.this.ejG.liveInfo.rtmpUrl;
                        alaLiveInfoCoreData.liveTitle = k.this.ejG.title;
                        alaLiveInfoCoreData.audienceCount = k.this.ejG.liveInfo.audienceCount;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(k.this.mTbPageContext.getPageActivity(), alaLiveInfoCoreData, null, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MAIN, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
                }
                if (k.this.epD.cUq) {
                    an anVar = new an("c13611");
                    anVar.cy("obj_param1", k.this.ejG.roomId);
                    anVar.cy("fid", k.this.epD.fid);
                    anVar.cy("fname", k.this.epD.fname);
                    anVar.X("obj_locate", k.this.epD.position);
                    TiebaStatic.log(anVar);
                    return;
                }
                an anVar2 = new an("c13557");
                anVar2.cy("obj_param1", k.this.ejG.roomId);
                anVar2.cy("entryname", "游戏");
                TiebaStatic.log(anVar2);
            }
        }
    };

    public k(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_game_live_item_view, (ViewGroup) null, false);
        this.enF = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.enF.setBorderSurroundContent(true);
        this.enF.setDrawBorder(true);
        this.enF.setPlaceHolder(2);
        this.enF.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.epz = this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.ekK = (TextView) this.mRootView.findViewById(R.id.live_title);
        this.enG = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.enI = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.epA = (ViewGroup) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.epB = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.epC = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.enT = new AlphaAnimation(0.0f, 1.0f);
        this.enT.setDuration(200L);
        this.enT.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                k.this.enV = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                k.this.enV = false;
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
        if (equipmentWidth != this.epE) {
            ViewGroup.LayoutParams layoutParams = this.epz.getLayoutParams();
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
            this.epz.setLayoutParams(layoutParams);
            this.epE = equipmentWidth;
        }
        if (aVar == null || aVar.ejG == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.epD = aVar;
        this.ejG = aVar.ejG;
        Object tag = this.enF.getTag();
        if (this.enU) {
            this.enS = true;
            this.enU = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.ejG.liveInfo.cover) && !((String) tag).equals(this.ejG.liveInfo.cover)) {
            this.enS = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.ejG.liveInfo.cover) && !this.mCoverUrl.equals(this.ejG.liveInfo.cover)) {
            this.enS = true;
        } else {
            this.enS = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.enP);
        this.mCoverUrl = this.ejG.liveInfo.cover;
        this.enF.setTag(this.mCoverUrl);
        if (aVar.isLeft) {
            this.enF.setConrers(5);
            gradientDrawable.setCornerRadii(enN);
            this.enF.setPlaceHolder(2);
        } else if (aVar.isRight) {
            this.enF.setConrers(10);
            gradientDrawable.setCornerRadii(enO);
            this.enF.setPlaceHolder(2);
        } else if (aVar.ejH) {
            this.enF.setConrers(15);
            gradientDrawable.setCornerRadii(enM);
            this.enF.setPlaceHolder(2);
        }
        this.enF.setRadius((int) enL);
        this.enF.startLoad(this.ejG.liveInfo.cover, 10, false);
        this.epA.setBackgroundDrawable(gradientDrawable);
        this.enF.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z && k.this.enS && !k.this.enV) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        k.this.enF.startAnimation(k.this.enT);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.enG.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.bE(this.ejG.liveInfo.audienceCount)));
        this.enI.setText(this.ejG.liveAuthor.name);
        this.ekK.setText(this.ejG.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.ejG.recom_extra_img_night;
        } else {
            str = this.ejG.recom_extra_img;
        }
        if (!StringUtils.isNull(str) && this.ejG.recom_extra_img_width > 0 && this.ejG.recom_extra_img_height > 0) {
            if (aVar.isLeft) {
                this.epB.setConrers(1);
            } else if (aVar.isRight) {
                this.epB.setConrers(0);
            } else if (aVar.ejH) {
                this.epB.setConrers(1);
            } else {
                this.epB.setConrers(0);
            }
            this.epB.setRadius((int) enL);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.epB.getLayoutParams();
            if (layoutParams3 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                layoutParams3.height = dimensionPixelSize;
                layoutParams3.width = (int) ((this.ejG.recom_extra_img_width / this.ejG.recom_extra_img_height) * dimensionPixelSize);
                this.epB.setLayoutParams(layoutParams3);
            }
            this.epB.startLoad(str, 10, false);
            this.epB.setVisibility(0);
        } else {
            this.epB.setVisibility(8);
        }
        this.epC.setVisibility(8);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.cUq) {
            an anVar = new an("c13610");
            anVar.cy("obj_param1", this.ejG.roomId);
            anVar.cy("fid", aVar.fid);
            anVar.cy("fname", aVar.fname);
            anVar.X("obj_locate", aVar.position);
            TiebaStatic.log(anVar);
            return;
        }
        an anVar2 = new an("c13544");
        anVar2.cy("obj_param1", this.ejG.roomId);
        anVar2.cy("entryname", "游戏");
        TiebaStatic.log(anVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.enG, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.enI, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.ekK, (int) R.color.cp_cont_b);
            Drawable drawable = am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.enG.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.enG.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
