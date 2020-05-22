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
    private static final float feA = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] feB = {0.0f, 0.0f, 0.0f, 0.0f, feA, feA, feA, feA};
    private static final float[] feC = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, feA, feA};
    private static final float[] feD = {0.0f, 0.0f, 0.0f, 0.0f, feA, feA, 0.0f, 0.0f};
    private SdkLiveInfoData fav;
    public TextView fbz;
    private AlphaAnimation feI;
    public TbImageView feu;
    public TextView fev;
    public TextView fex;
    public View fgs;
    public ViewGroup fgt;
    public TbImageView fgu;
    public ImageView fgv;
    private com.baidu.tieba.ala.alasquare.a.a fgw;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    private int[] feE = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean feH = false;
    private boolean feJ = true;
    private boolean feK = false;
    private int fgx = 0;
    private boolean fcs = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            if (k.this.fgw != null && k.this.fav != null) {
                if (k.this.fav.shouldJumpChushouLiveRoom()) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(k.this.mTbPageContext, k.this.fav.roomId, String.valueOf(k.this.fav.liveInfo.liveType));
                } else {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = com.baidu.adp.lib.f.b.toLong(k.this.fav.roomId, 0L);
                    if (k.this.fav.liveInfo != null) {
                        alaLiveInfoCoreData.hslUrl = k.this.fav.liveInfo.hlsUrl;
                        alaLiveInfoCoreData.liveCover = k.this.fav.liveInfo.cover;
                        alaLiveInfoCoreData.rtmpUrl = k.this.fav.liveInfo.rtmpUrl;
                        alaLiveInfoCoreData.liveTitle = k.this.fav.title;
                        alaLiveInfoCoreData.audienceCount = k.this.fav.liveInfo.audienceCount;
                    }
                    if (k.this.fcs) {
                        str = k.this.fgw != null ? AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_FRIENDLIVE + k.this.fgw.fid : null;
                    } else {
                        str = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MAIN;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(k.this.mTbPageContext.getPageActivity(), alaLiveInfoCoreData, null, str, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
                }
                if (k.this.fgw.dHL) {
                    an anVar = new an("c13611");
                    anVar.dh("obj_param1", k.this.fav.roomId);
                    anVar.dh("fid", k.this.fgw.fid);
                    anVar.dh("fname", k.this.fgw.fname);
                    anVar.ag("obj_locate", k.this.fgw.position);
                    if (k.this.fav != null && k.this.fav.uiTransParam != null) {
                        anVar.dh("ab_tag", k.this.fav.uiTransParam.abTag);
                        anVar.dh("star_id", k.this.fav.uiTransParam.starId);
                        anVar.dh("extra", k.this.fav.uiTransParam.extra);
                        anVar.dh("source_from", k.this.fav.uiTransParam.sourceFrom);
                    }
                    TiebaStatic.log(anVar);
                    return;
                }
                an anVar2 = new an("c13557");
                anVar2.dh("obj_param1", k.this.fav.roomId);
                anVar2.dh("entryname", "游戏");
                TiebaStatic.log(anVar2);
            }
        }
    };

    public k(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_game_live_item_view, (ViewGroup) null, false);
        this.feu = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.feu.setBorderSurroundContent(true);
        this.feu.setDrawBorder(true);
        this.feu.setPlaceHolder(2);
        this.feu.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.fgs = this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.fbz = (TextView) this.mRootView.findViewById(R.id.live_title);
        this.fev = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.fex = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.fgt = (ViewGroup) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.fgu = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.fgv = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.feI = new AlphaAnimation(0.0f, 1.0f);
        this.feI.setDuration(200L);
        this.feI.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                k.this.feK = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                k.this.feK = false;
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
        if (equipmentWidth != this.fgx) {
            ViewGroup.LayoutParams layoutParams = this.fgs.getLayoutParams();
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
            this.fgs.setLayoutParams(layoutParams);
            this.fgx = equipmentWidth;
        }
        if (aVar == null || aVar.fav == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.fgw = aVar;
        this.fav = aVar.fav;
        Object tag = this.feu.getTag();
        if (this.feJ) {
            this.feH = true;
            this.feJ = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.fav.liveInfo.cover) && !((String) tag).equals(this.fav.liveInfo.cover)) {
            this.feH = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.fav.liveInfo.cover) && !this.mCoverUrl.equals(this.fav.liveInfo.cover)) {
            this.feH = true;
        } else {
            this.feH = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.feE);
        this.mCoverUrl = this.fav.liveInfo.cover;
        this.feu.setTag(this.mCoverUrl);
        if (aVar.isLeft) {
            this.feu.setConrers(5);
            gradientDrawable.setCornerRadii(feC);
            this.feu.setPlaceHolder(2);
        } else if (aVar.isRight) {
            this.feu.setConrers(10);
            gradientDrawable.setCornerRadii(feD);
            this.feu.setPlaceHolder(2);
        } else if (aVar.faw) {
            this.feu.setConrers(15);
            gradientDrawable.setCornerRadii(feB);
            this.feu.setPlaceHolder(2);
        }
        this.feu.setRadius((int) feA);
        this.feu.startLoad(this.fav.liveInfo.cover, 10, false);
        this.fgt.setBackgroundDrawable(gradientDrawable);
        this.feu.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z && k.this.feH && !k.this.feK) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        k.this.feu.startAnimation(k.this.feI);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fev.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.cl(this.fav.liveInfo.audienceCount)));
        this.fex.setText(this.fav.liveAuthor.name);
        this.fbz.setText(this.fav.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.fav.recom_extra_img_night;
        } else {
            str = this.fav.recom_extra_img;
        }
        if (!StringUtils.isNull(str) && this.fav.recom_extra_img_width > 0 && this.fav.recom_extra_img_height > 0) {
            if (aVar.isLeft) {
                this.fgu.setConrers(1);
            } else if (aVar.isRight) {
                this.fgu.setConrers(0);
            } else if (aVar.faw) {
                this.fgu.setConrers(1);
            } else {
                this.fgu.setConrers(0);
            }
            this.fgu.setRadius((int) feA);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.fgu.getLayoutParams();
            if (layoutParams3 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                layoutParams3.height = dimensionPixelSize;
                layoutParams3.width = (int) ((this.fav.recom_extra_img_width / this.fav.recom_extra_img_height) * dimensionPixelSize);
                this.fgu.setLayoutParams(layoutParams3);
            }
            this.fgu.startLoad(str, 10, false);
            this.fgu.setVisibility(0);
        } else {
            this.fgu.setVisibility(8);
        }
        this.fgv.setVisibility(8);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.dHL) {
            an anVar = new an("c13610");
            anVar.dh("obj_param1", this.fav.roomId);
            anVar.dh("fid", aVar.fid);
            anVar.dh("fname", aVar.fname);
            anVar.ag("obj_locate", aVar.position);
            if (this.fav != null && this.fav.uiTransParam != null) {
                anVar.dh("ab_tag", this.fav.uiTransParam.abTag);
                anVar.dh("star_id", this.fav.uiTransParam.starId);
                anVar.dh("extra", this.fav.uiTransParam.extra);
                anVar.dh("source_from", this.fav.uiTransParam.sourceFrom);
            }
            TiebaStatic.log(anVar);
            return;
        }
        an anVar2 = new an("c13544");
        anVar2.dh("obj_param1", this.fav.roomId);
        anVar2.dh("entryname", "游戏");
        TiebaStatic.log(anVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.fev, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.fex, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.fbz, (int) R.color.cp_cont_b);
            Drawable drawable = am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.fev.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.fev.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }

    public void jl(boolean z) {
        this.fcs = z;
    }
}
