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
    private static final float eRS = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] eRT = {0.0f, 0.0f, 0.0f, 0.0f, eRS, eRS, eRS, eRS};
    private static final float[] eRU = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, eRS, eRS};
    private static final float[] eRV = {0.0f, 0.0f, 0.0f, 0.0f, eRS, eRS, 0.0f, 0.0f};
    private SdkLiveInfoData eNO;
    public TextView eOS;
    public TbImageView eRM;
    public TextView eRN;
    public TextView eRP;
    private AlphaAnimation eSa;
    public View eTK;
    public ViewGroup eTL;
    public TbImageView eTM;
    public ImageView eTN;
    private com.baidu.tieba.ala.alasquare.a.a eTO;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    private int[] eRW = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean eRZ = false;
    private boolean eSb = true;
    private boolean eSc = false;
    private int eTP = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (k.this.eTO != null && k.this.eNO != null) {
                if (k.this.eNO.shouldJumpChushouLiveRoom()) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(k.this.mTbPageContext, k.this.eNO.roomId, String.valueOf(k.this.eNO.liveInfo.liveType));
                } else {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = com.baidu.adp.lib.f.b.toLong(k.this.eNO.roomId, 0L);
                    if (k.this.eNO.liveInfo != null) {
                        alaLiveInfoCoreData.hslUrl = k.this.eNO.liveInfo.hlsUrl;
                        alaLiveInfoCoreData.liveCover = k.this.eNO.liveInfo.cover;
                        alaLiveInfoCoreData.rtmpUrl = k.this.eNO.liveInfo.rtmpUrl;
                        alaLiveInfoCoreData.liveTitle = k.this.eNO.title;
                        alaLiveInfoCoreData.audienceCount = k.this.eNO.liveInfo.audienceCount;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(k.this.mTbPageContext.getPageActivity(), alaLiveInfoCoreData, null, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MAIN, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
                }
                if (k.this.eTO.dtT) {
                    an anVar = new an("c13611");
                    anVar.cI("obj_param1", k.this.eNO.roomId);
                    anVar.cI("fid", k.this.eTO.fid);
                    anVar.cI("fname", k.this.eTO.fname);
                    anVar.af("obj_locate", k.this.eTO.position);
                    TiebaStatic.log(anVar);
                    return;
                }
                an anVar2 = new an("c13557");
                anVar2.cI("obj_param1", k.this.eNO.roomId);
                anVar2.cI("entryname", "游戏");
                TiebaStatic.log(anVar2);
            }
        }
    };

    public k(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_game_live_item_view, (ViewGroup) null, false);
        this.eRM = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.eRM.setBorderSurroundContent(true);
        this.eRM.setDrawBorder(true);
        this.eRM.setPlaceHolder(2);
        this.eRM.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.eTK = this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.eOS = (TextView) this.mRootView.findViewById(R.id.live_title);
        this.eRN = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.eRP = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.eTL = (ViewGroup) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.eTM = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.eTN = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.eSa = new AlphaAnimation(0.0f, 1.0f);
        this.eSa.setDuration(200L);
        this.eSa.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                k.this.eSc = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                k.this.eSc = false;
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
        if (equipmentWidth != this.eTP) {
            ViewGroup.LayoutParams layoutParams = this.eTK.getLayoutParams();
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
            this.eTK.setLayoutParams(layoutParams);
            this.eTP = equipmentWidth;
        }
        if (aVar == null || aVar.eNO == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.eTO = aVar;
        this.eNO = aVar.eNO;
        Object tag = this.eRM.getTag();
        if (this.eSb) {
            this.eRZ = true;
            this.eSb = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.eNO.liveInfo.cover) && !((String) tag).equals(this.eNO.liveInfo.cover)) {
            this.eRZ = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.eNO.liveInfo.cover) && !this.mCoverUrl.equals(this.eNO.liveInfo.cover)) {
            this.eRZ = true;
        } else {
            this.eRZ = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.eRW);
        this.mCoverUrl = this.eNO.liveInfo.cover;
        this.eRM.setTag(this.mCoverUrl);
        if (aVar.isLeft) {
            this.eRM.setConrers(5);
            gradientDrawable.setCornerRadii(eRU);
            this.eRM.setPlaceHolder(2);
        } else if (aVar.isRight) {
            this.eRM.setConrers(10);
            gradientDrawable.setCornerRadii(eRV);
            this.eRM.setPlaceHolder(2);
        } else if (aVar.eNP) {
            this.eRM.setConrers(15);
            gradientDrawable.setCornerRadii(eRT);
            this.eRM.setPlaceHolder(2);
        }
        this.eRM.setRadius((int) eRS);
        this.eRM.startLoad(this.eNO.liveInfo.cover, 10, false);
        this.eTL.setBackgroundDrawable(gradientDrawable);
        this.eRM.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z && k.this.eRZ && !k.this.eSc) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        k.this.eRM.startAnimation(k.this.eSa);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.eRN.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.ck(this.eNO.liveInfo.audienceCount)));
        this.eRP.setText(this.eNO.liveAuthor.name);
        this.eOS.setText(this.eNO.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.eNO.recom_extra_img_night;
        } else {
            str = this.eNO.recom_extra_img;
        }
        if (!StringUtils.isNull(str) && this.eNO.recom_extra_img_width > 0 && this.eNO.recom_extra_img_height > 0) {
            if (aVar.isLeft) {
                this.eTM.setConrers(1);
            } else if (aVar.isRight) {
                this.eTM.setConrers(0);
            } else if (aVar.eNP) {
                this.eTM.setConrers(1);
            } else {
                this.eTM.setConrers(0);
            }
            this.eTM.setRadius((int) eRS);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.eTM.getLayoutParams();
            if (layoutParams3 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                layoutParams3.height = dimensionPixelSize;
                layoutParams3.width = (int) ((this.eNO.recom_extra_img_width / this.eNO.recom_extra_img_height) * dimensionPixelSize);
                this.eTM.setLayoutParams(layoutParams3);
            }
            this.eTM.startLoad(str, 10, false);
            this.eTM.setVisibility(0);
        } else {
            this.eTM.setVisibility(8);
        }
        this.eTN.setVisibility(8);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.dtT) {
            an anVar = new an("c13610");
            anVar.cI("obj_param1", this.eNO.roomId);
            anVar.cI("fid", aVar.fid);
            anVar.cI("fname", aVar.fname);
            anVar.af("obj_locate", aVar.position);
            TiebaStatic.log(anVar);
            return;
        }
        an anVar2 = new an("c13544");
        anVar2.cI("obj_param1", this.eNO.roomId);
        anVar2.cI("entryname", "游戏");
        TiebaStatic.log(anVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.eRN, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eRP, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eOS, (int) R.color.cp_cont_b);
            Drawable drawable = am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.eRN.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.eRN.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
