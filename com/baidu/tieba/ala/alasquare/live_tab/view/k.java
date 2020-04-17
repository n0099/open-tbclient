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
    private static final float eRN = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] eRO = {0.0f, 0.0f, 0.0f, 0.0f, eRN, eRN, eRN, eRN};
    private static final float[] eRP = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, eRN, eRN};
    private static final float[] eRQ = {0.0f, 0.0f, 0.0f, 0.0f, eRN, eRN, 0.0f, 0.0f};
    private SdkLiveInfoData eNJ;
    public TextView eON;
    public TbImageView eRH;
    public TextView eRI;
    public TextView eRK;
    private AlphaAnimation eRV;
    public View eTF;
    public ViewGroup eTG;
    public TbImageView eTH;
    public ImageView eTI;
    private com.baidu.tieba.ala.alasquare.a.a eTJ;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    private int[] eRR = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean eRU = false;
    private boolean eRW = true;
    private boolean eRX = false;
    private int eTK = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (k.this.eTJ != null && k.this.eNJ != null) {
                if (k.this.eNJ.shouldJumpChushouLiveRoom()) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(k.this.mTbPageContext, k.this.eNJ.roomId, String.valueOf(k.this.eNJ.liveInfo.liveType));
                } else {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = com.baidu.adp.lib.f.b.toLong(k.this.eNJ.roomId, 0L);
                    if (k.this.eNJ.liveInfo != null) {
                        alaLiveInfoCoreData.hslUrl = k.this.eNJ.liveInfo.hlsUrl;
                        alaLiveInfoCoreData.liveCover = k.this.eNJ.liveInfo.cover;
                        alaLiveInfoCoreData.rtmpUrl = k.this.eNJ.liveInfo.rtmpUrl;
                        alaLiveInfoCoreData.liveTitle = k.this.eNJ.title;
                        alaLiveInfoCoreData.audienceCount = k.this.eNJ.liveInfo.audienceCount;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(k.this.mTbPageContext.getPageActivity(), alaLiveInfoCoreData, null, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MAIN, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
                }
                if (k.this.eTJ.dtP) {
                    an anVar = new an("c13611");
                    anVar.cI("obj_param1", k.this.eNJ.roomId);
                    anVar.cI("fid", k.this.eTJ.fid);
                    anVar.cI("fname", k.this.eTJ.fname);
                    anVar.af("obj_locate", k.this.eTJ.position);
                    TiebaStatic.log(anVar);
                    return;
                }
                an anVar2 = new an("c13557");
                anVar2.cI("obj_param1", k.this.eNJ.roomId);
                anVar2.cI("entryname", "游戏");
                TiebaStatic.log(anVar2);
            }
        }
    };

    public k(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_game_live_item_view, (ViewGroup) null, false);
        this.eRH = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.eRH.setBorderSurroundContent(true);
        this.eRH.setDrawBorder(true);
        this.eRH.setPlaceHolder(2);
        this.eRH.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.eTF = this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.eON = (TextView) this.mRootView.findViewById(R.id.live_title);
        this.eRI = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.eRK = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.eTG = (ViewGroup) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.eTH = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.eTI = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.eRV = new AlphaAnimation(0.0f, 1.0f);
        this.eRV.setDuration(200L);
        this.eRV.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                k.this.eRX = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                k.this.eRX = false;
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
        if (equipmentWidth != this.eTK) {
            ViewGroup.LayoutParams layoutParams = this.eTF.getLayoutParams();
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
            this.eTF.setLayoutParams(layoutParams);
            this.eTK = equipmentWidth;
        }
        if (aVar == null || aVar.eNJ == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.eTJ = aVar;
        this.eNJ = aVar.eNJ;
        Object tag = this.eRH.getTag();
        if (this.eRW) {
            this.eRU = true;
            this.eRW = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.eNJ.liveInfo.cover) && !((String) tag).equals(this.eNJ.liveInfo.cover)) {
            this.eRU = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.eNJ.liveInfo.cover) && !this.mCoverUrl.equals(this.eNJ.liveInfo.cover)) {
            this.eRU = true;
        } else {
            this.eRU = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.eRR);
        this.mCoverUrl = this.eNJ.liveInfo.cover;
        this.eRH.setTag(this.mCoverUrl);
        if (aVar.isLeft) {
            this.eRH.setConrers(5);
            gradientDrawable.setCornerRadii(eRP);
            this.eRH.setPlaceHolder(2);
        } else if (aVar.isRight) {
            this.eRH.setConrers(10);
            gradientDrawable.setCornerRadii(eRQ);
            this.eRH.setPlaceHolder(2);
        } else if (aVar.eNK) {
            this.eRH.setConrers(15);
            gradientDrawable.setCornerRadii(eRO);
            this.eRH.setPlaceHolder(2);
        }
        this.eRH.setRadius((int) eRN);
        this.eRH.startLoad(this.eNJ.liveInfo.cover, 10, false);
        this.eTG.setBackgroundDrawable(gradientDrawable);
        this.eRH.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z && k.this.eRU && !k.this.eRX) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        k.this.eRH.startAnimation(k.this.eRV);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.eRI.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.ck(this.eNJ.liveInfo.audienceCount)));
        this.eRK.setText(this.eNJ.liveAuthor.name);
        this.eON.setText(this.eNJ.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.eNJ.recom_extra_img_night;
        } else {
            str = this.eNJ.recom_extra_img;
        }
        if (!StringUtils.isNull(str) && this.eNJ.recom_extra_img_width > 0 && this.eNJ.recom_extra_img_height > 0) {
            if (aVar.isLeft) {
                this.eTH.setConrers(1);
            } else if (aVar.isRight) {
                this.eTH.setConrers(0);
            } else if (aVar.eNK) {
                this.eTH.setConrers(1);
            } else {
                this.eTH.setConrers(0);
            }
            this.eTH.setRadius((int) eRN);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.eTH.getLayoutParams();
            if (layoutParams3 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                layoutParams3.height = dimensionPixelSize;
                layoutParams3.width = (int) ((this.eNJ.recom_extra_img_width / this.eNJ.recom_extra_img_height) * dimensionPixelSize);
                this.eTH.setLayoutParams(layoutParams3);
            }
            this.eTH.startLoad(str, 10, false);
            this.eTH.setVisibility(0);
        } else {
            this.eTH.setVisibility(8);
        }
        this.eTI.setVisibility(8);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.dtP) {
            an anVar = new an("c13610");
            anVar.cI("obj_param1", this.eNJ.roomId);
            anVar.cI("fid", aVar.fid);
            anVar.cI("fname", aVar.fname);
            anVar.af("obj_locate", aVar.position);
            TiebaStatic.log(anVar);
            return;
        }
        an anVar2 = new an("c13544");
        anVar2.cI("obj_param1", this.eNJ.roomId);
        anVar2.cI("entryname", "游戏");
        TiebaStatic.log(anVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.eRI, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eRK, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eON, (int) R.color.cp_cont_b);
            Drawable drawable = am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.eRI.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.eRI.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
