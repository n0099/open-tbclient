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
/* loaded from: classes2.dex */
public class k {
    private static final float ejA = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] ejB = {0.0f, 0.0f, 0.0f, 0.0f, ejA, ejA, ejA, ejA};
    private static final float[] ejC = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, ejA, ejA};
    private static final float[] ejD = {0.0f, 0.0f, 0.0f, 0.0f, ejA, ejA, 0.0f, 0.0f};
    private SdkLiveInfoData efB;
    public TextView egF;
    private AlphaAnimation ejI;
    public TbImageView eju;
    public TextView ejv;
    public TextView ejx;
    public View eln;
    public ViewGroup elo;
    public TbImageView elp;
    public ImageView elq;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    private int[] ejE = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean ejH = false;
    private boolean ejJ = true;
    private boolean ejK = false;
    private int elr = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (k.this.efB != null) {
                if (k.this.efB.shouldJumpChushouLiveRoom()) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(k.this.mTbPageContext, k.this.efB.roomId, String.valueOf(k.this.efB.liveInfo.liveType));
                } else {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = com.baidu.adp.lib.f.b.toLong(k.this.efB.roomId, 0L);
                    if (k.this.efB.liveInfo != null) {
                        alaLiveInfoCoreData.hslUrl = k.this.efB.liveInfo.hlsUrl;
                        alaLiveInfoCoreData.liveCover = k.this.efB.liveInfo.cover;
                        alaLiveInfoCoreData.rtmpUrl = k.this.efB.liveInfo.rtmpUrl;
                        alaLiveInfoCoreData.liveTitle = k.this.efB.title;
                        alaLiveInfoCoreData.audienceCount = k.this.efB.liveInfo.audienceCount;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(k.this.mTbPageContext.getPageActivity(), alaLiveInfoCoreData, null, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MAIN, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
                }
                an anVar = new an("c13557");
                anVar.cp("obj_param1", k.this.efB.roomId);
                anVar.cp("entryname", "游戏");
                TiebaStatic.log(anVar);
            }
        }
    };

    public k(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_game_live_item_view, (ViewGroup) null, false);
        this.eju = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.eju.setBorderSurroundContent(true);
        this.eju.setDrawBorder(true);
        this.eju.setPlaceHolder(2);
        this.eju.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.eln = this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.egF = (TextView) this.mRootView.findViewById(R.id.live_title);
        this.ejv = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.ejx = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.elo = (ViewGroup) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.elp = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.elq = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.ejI = new AlphaAnimation(0.0f, 1.0f);
        this.ejI.setDuration(200L);
        this.ejI.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                k.this.ejK = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                k.this.ejK = false;
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
        if (equipmentWidth != this.elr) {
            ViewGroup.LayoutParams layoutParams = this.eln.getLayoutParams();
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
            this.eln.setLayoutParams(layoutParams);
            this.elr = equipmentWidth;
        }
        if (aVar == null || aVar.efB == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.efB = aVar.efB;
        Object tag = this.eju.getTag();
        if (this.ejJ) {
            this.ejH = true;
            this.ejJ = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.efB.liveInfo.cover) && !((String) tag).equals(this.efB.liveInfo.cover)) {
            this.ejH = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.efB.liveInfo.cover) && !this.mCoverUrl.equals(this.efB.liveInfo.cover)) {
            this.ejH = true;
        } else {
            this.ejH = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.ejE);
        this.mCoverUrl = this.efB.liveInfo.cover;
        this.eju.setTag(this.mCoverUrl);
        if (aVar.isLeft) {
            this.eju.setConrers(5);
            gradientDrawable.setCornerRadii(ejC);
            this.eju.setPlaceHolder(2);
        } else if (aVar.isRight) {
            this.eju.setConrers(10);
            gradientDrawable.setCornerRadii(ejD);
            this.eju.setPlaceHolder(2);
        } else if (aVar.efC) {
            this.eju.setConrers(15);
            gradientDrawable.setCornerRadii(ejB);
            this.eju.setPlaceHolder(2);
        }
        this.eju.setRadius((int) ejA);
        this.eju.startLoad(this.efB.liveInfo.cover, 10, false);
        this.elo.setBackgroundDrawable(gradientDrawable);
        this.eju.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z && k.this.ejH && !k.this.ejK) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        k.this.eju.startAnimation(k.this.ejI);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.ejv.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.bA(this.efB.liveInfo.audienceCount)));
        this.ejx.setText(this.efB.liveAuthor.name);
        this.egF.setText(this.efB.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.efB.recom_extra_img_night;
        } else {
            str = this.efB.recom_extra_img;
        }
        if (!StringUtils.isNull(str) && this.efB.recom_extra_img_width > 0 && this.efB.recom_extra_img_height > 0) {
            if (aVar.isLeft) {
                this.elp.setConrers(1);
            } else if (aVar.isRight) {
                this.elp.setConrers(0);
            } else if (aVar.efC) {
                this.elp.setConrers(1);
            } else {
                this.elp.setConrers(0);
            }
            this.elp.setRadius((int) ejA);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.elp.getLayoutParams();
            if (layoutParams3 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                layoutParams3.height = dimensionPixelSize;
                layoutParams3.width = (int) ((this.efB.recom_extra_img_width / this.efB.recom_extra_img_height) * dimensionPixelSize);
                this.elp.setLayoutParams(layoutParams3);
            }
            this.elp.startLoad(str, 10, false);
            this.elp.setVisibility(0);
        } else {
            this.elp.setVisibility(8);
        }
        this.elq.setVisibility(8);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        an anVar = new an("c13544");
        anVar.cp("obj_param1", this.efB.roomId);
        anVar.cp("entryname", "游戏");
        TiebaStatic.log(anVar);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.ejv, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.ejx, (int) R.color.cp_cont_a);
            Drawable drawable = am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.ejv.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.ejv.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
