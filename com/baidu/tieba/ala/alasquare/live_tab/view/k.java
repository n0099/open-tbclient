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
    private static final float enY = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] enZ = {0.0f, 0.0f, 0.0f, 0.0f, enY, enY, enY, enY};
    private static final float[] eoa = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, enY, enY};
    private static final float[] eob = {0.0f, 0.0f, 0.0f, 0.0f, enY, enY, 0.0f, 0.0f};
    private SdkLiveInfoData ejT;
    public TextView ekX;
    public TbImageView enS;
    public TextView enT;
    public TextView enV;
    private AlphaAnimation eoh;
    public View epM;
    public ViewGroup epN;
    public TbImageView epO;
    public ImageView epP;
    private com.baidu.tieba.ala.alasquare.a.a epQ;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    private int[] eoc = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean eog = false;
    private boolean eoi = true;
    private boolean eoj = false;
    private int epR = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (k.this.epQ != null && k.this.ejT != null) {
                if (k.this.ejT.shouldJumpChushouLiveRoom()) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(k.this.mTbPageContext, k.this.ejT.roomId, String.valueOf(k.this.ejT.liveInfo.liveType));
                } else {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = com.baidu.adp.lib.f.b.toLong(k.this.ejT.roomId, 0L);
                    if (k.this.ejT.liveInfo != null) {
                        alaLiveInfoCoreData.hslUrl = k.this.ejT.liveInfo.hlsUrl;
                        alaLiveInfoCoreData.liveCover = k.this.ejT.liveInfo.cover;
                        alaLiveInfoCoreData.rtmpUrl = k.this.ejT.liveInfo.rtmpUrl;
                        alaLiveInfoCoreData.liveTitle = k.this.ejT.title;
                        alaLiveInfoCoreData.audienceCount = k.this.ejT.liveInfo.audienceCount;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(k.this.mTbPageContext.getPageActivity(), alaLiveInfoCoreData, null, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MAIN, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
                }
                if (k.this.epQ.cUr) {
                    an anVar = new an("c13611");
                    anVar.cy("obj_param1", k.this.ejT.roomId);
                    anVar.cy("fid", k.this.epQ.fid);
                    anVar.cy("fname", k.this.epQ.fname);
                    anVar.X("obj_locate", k.this.epQ.position);
                    TiebaStatic.log(anVar);
                    return;
                }
                an anVar2 = new an("c13557");
                anVar2.cy("obj_param1", k.this.ejT.roomId);
                anVar2.cy("entryname", "游戏");
                TiebaStatic.log(anVar2);
            }
        }
    };

    public k(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_game_live_item_view, (ViewGroup) null, false);
        this.enS = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.enS.setBorderSurroundContent(true);
        this.enS.setDrawBorder(true);
        this.enS.setPlaceHolder(2);
        this.enS.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.epM = this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.ekX = (TextView) this.mRootView.findViewById(R.id.live_title);
        this.enT = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.enV = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.epN = (ViewGroup) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.epO = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.epP = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.eoh = new AlphaAnimation(0.0f, 1.0f);
        this.eoh.setDuration(200L);
        this.eoh.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                k.this.eoj = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                k.this.eoj = false;
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
        if (equipmentWidth != this.epR) {
            ViewGroup.LayoutParams layoutParams = this.epM.getLayoutParams();
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
            this.epM.setLayoutParams(layoutParams);
            this.epR = equipmentWidth;
        }
        if (aVar == null || aVar.ejT == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.epQ = aVar;
        this.ejT = aVar.ejT;
        Object tag = this.enS.getTag();
        if (this.eoi) {
            this.eog = true;
            this.eoi = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.ejT.liveInfo.cover) && !((String) tag).equals(this.ejT.liveInfo.cover)) {
            this.eog = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.ejT.liveInfo.cover) && !this.mCoverUrl.equals(this.ejT.liveInfo.cover)) {
            this.eog = true;
        } else {
            this.eog = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.eoc);
        this.mCoverUrl = this.ejT.liveInfo.cover;
        this.enS.setTag(this.mCoverUrl);
        if (aVar.isLeft) {
            this.enS.setConrers(5);
            gradientDrawable.setCornerRadii(eoa);
            this.enS.setPlaceHolder(2);
        } else if (aVar.isRight) {
            this.enS.setConrers(10);
            gradientDrawable.setCornerRadii(eob);
            this.enS.setPlaceHolder(2);
        } else if (aVar.ejU) {
            this.enS.setConrers(15);
            gradientDrawable.setCornerRadii(enZ);
            this.enS.setPlaceHolder(2);
        }
        this.enS.setRadius((int) enY);
        this.enS.startLoad(this.ejT.liveInfo.cover, 10, false);
        this.epN.setBackgroundDrawable(gradientDrawable);
        this.enS.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z && k.this.eog && !k.this.eoj) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        k.this.enS.startAnimation(k.this.eoh);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.enT.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.bE(this.ejT.liveInfo.audienceCount)));
        this.enV.setText(this.ejT.liveAuthor.name);
        this.ekX.setText(this.ejT.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.ejT.recom_extra_img_night;
        } else {
            str = this.ejT.recom_extra_img;
        }
        if (!StringUtils.isNull(str) && this.ejT.recom_extra_img_width > 0 && this.ejT.recom_extra_img_height > 0) {
            if (aVar.isLeft) {
                this.epO.setConrers(1);
            } else if (aVar.isRight) {
                this.epO.setConrers(0);
            } else if (aVar.ejU) {
                this.epO.setConrers(1);
            } else {
                this.epO.setConrers(0);
            }
            this.epO.setRadius((int) enY);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.epO.getLayoutParams();
            if (layoutParams3 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                layoutParams3.height = dimensionPixelSize;
                layoutParams3.width = (int) ((this.ejT.recom_extra_img_width / this.ejT.recom_extra_img_height) * dimensionPixelSize);
                this.epO.setLayoutParams(layoutParams3);
            }
            this.epO.startLoad(str, 10, false);
            this.epO.setVisibility(0);
        } else {
            this.epO.setVisibility(8);
        }
        this.epP.setVisibility(8);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.cUr) {
            an anVar = new an("c13610");
            anVar.cy("obj_param1", this.ejT.roomId);
            anVar.cy("fid", aVar.fid);
            anVar.cy("fname", aVar.fname);
            anVar.X("obj_locate", aVar.position);
            TiebaStatic.log(anVar);
            return;
        }
        an anVar2 = new an("c13544");
        anVar2.cy("obj_param1", this.ejT.roomId);
        anVar2.cy("entryname", "游戏");
        TiebaStatic.log(anVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.enT, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.enV, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.ekX, (int) R.color.cp_cont_b);
            Drawable drawable = am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.enT.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.enT.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
