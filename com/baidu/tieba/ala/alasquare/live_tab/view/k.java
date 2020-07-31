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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class k {
    private static final float fvg = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] fvh = {0.0f, 0.0f, 0.0f, 0.0f, fvg, fvg, fvg, fvg};
    private static final float[] fvi = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, fvg, fvg};
    private static final float[] fvj = {0.0f, 0.0f, 0.0f, 0.0f, fvg, fvg, 0.0f, 0.0f};
    private SdkLiveInfoData fqY;
    public TextView fse;
    public TbImageView fva;
    public TextView fvb;
    public TextView fvd;
    private AlphaAnimation fvo;
    public View fwZ;
    public ViewGroup fxa;
    public TbImageView fxb;
    public ImageView fxc;
    private com.baidu.tieba.ala.alasquare.a.a fxd;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    private int[] fvk = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean fvn = false;
    private boolean fvp = true;
    private boolean fvq = false;
    private int fxe = 0;
    private boolean fsW = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            if (k.this.fxd != null && k.this.fqY != null) {
                if (k.this.fqY.shouldJumpChushouLiveRoom()) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(k.this.mTbPageContext, k.this.fqY.roomId, String.valueOf(k.this.fqY.liveInfo.liveType));
                } else {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = com.baidu.adp.lib.f.b.toLong(k.this.fqY.roomId, 0L);
                    if (k.this.fqY.liveInfo != null) {
                        alaLiveInfoCoreData.hslUrl = k.this.fqY.liveInfo.hlsUrl;
                        alaLiveInfoCoreData.liveCover = k.this.fqY.liveInfo.cover;
                        alaLiveInfoCoreData.rtmpUrl = k.this.fqY.liveInfo.rtmpUrl;
                        alaLiveInfoCoreData.liveTitle = k.this.fqY.title;
                        alaLiveInfoCoreData.audienceCount = k.this.fqY.liveInfo.audienceCount;
                    }
                    if (k.this.fsW) {
                        str = k.this.fxd != null ? AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_FRIENDLIVE + k.this.fxd.fid : null;
                    } else {
                        str = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MAIN;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(k.this.mTbPageContext.getPageActivity(), alaLiveInfoCoreData, null, str, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
                }
                if (k.this.fxd.dUI) {
                    ap apVar = new ap("c13611");
                    apVar.dn("obj_param1", k.this.fqY.roomId);
                    apVar.dn("fid", k.this.fxd.fid);
                    apVar.dn("fname", k.this.fxd.fname);
                    apVar.ah("obj_locate", k.this.fxd.position);
                    if (k.this.fqY != null && k.this.fqY.uiTransParam != null) {
                        apVar.dn("ab_tag", k.this.fqY.uiTransParam.abTag);
                        apVar.dn("star_id", k.this.fqY.uiTransParam.starId);
                        apVar.dn("extra", k.this.fqY.uiTransParam.extra);
                        apVar.dn("source_from", k.this.fqY.uiTransParam.sourceFrom);
                    }
                    TiebaStatic.log(apVar);
                    return;
                }
                ap apVar2 = new ap("c13557");
                apVar2.dn("obj_param1", k.this.fqY.roomId);
                apVar2.dn("entryname", "游戏");
                TiebaStatic.log(apVar2);
            }
        }
    };

    public k(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_game_live_item_view, (ViewGroup) null, false);
        this.fva = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.fva.setBorderSurroundContent(true);
        this.fva.setDrawBorder(true);
        this.fva.setPlaceHolder(2);
        this.fva.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.fwZ = this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.fse = (TextView) this.mRootView.findViewById(R.id.live_title);
        this.fvb = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.fvd = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.fxa = (ViewGroup) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.fxb = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.fxc = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.fvo = new AlphaAnimation(0.0f, 1.0f);
        this.fvo.setDuration(200L);
        this.fvo.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                k.this.fvq = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                k.this.fvq = false;
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
        if (equipmentWidth != this.fxe) {
            ViewGroup.LayoutParams layoutParams = this.fwZ.getLayoutParams();
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
            this.fwZ.setLayoutParams(layoutParams);
            this.fxe = equipmentWidth;
        }
        if (aVar == null || aVar.fqY == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.fxd = aVar;
        this.fqY = aVar.fqY;
        Object tag = this.fva.getTag();
        if (this.fvp) {
            this.fvn = true;
            this.fvp = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.fqY.liveInfo.cover) && !((String) tag).equals(this.fqY.liveInfo.cover)) {
            this.fvn = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.fqY.liveInfo.cover) && !this.mCoverUrl.equals(this.fqY.liveInfo.cover)) {
            this.fvn = true;
        } else {
            this.fvn = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.fvk);
        this.mCoverUrl = this.fqY.liveInfo.cover;
        this.fva.setTag(this.mCoverUrl);
        if (aVar.isLeft) {
            this.fva.setConrers(5);
            gradientDrawable.setCornerRadii(fvi);
            this.fva.setPlaceHolder(2);
        } else if (aVar.isRight) {
            this.fva.setConrers(10);
            gradientDrawable.setCornerRadii(fvj);
            this.fva.setPlaceHolder(2);
        } else if (aVar.fqZ) {
            this.fva.setConrers(15);
            gradientDrawable.setCornerRadii(fvh);
            this.fva.setPlaceHolder(2);
        }
        this.fva.setRadius((int) fvg);
        this.fva.startLoad(this.fqY.liveInfo.cover, 10, false);
        this.fxa.setBackgroundDrawable(gradientDrawable);
        this.fva.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z && k.this.fvn && !k.this.fvq) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        k.this.fva.startAnimation(k.this.fvo);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fvb.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, as.cE(this.fqY.liveInfo.audienceCount)));
        this.fvd.setText(this.fqY.liveAuthor.name);
        this.fse.setText(this.fqY.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.fqY.recom_extra_img_night;
        } else {
            str = this.fqY.recom_extra_img;
        }
        if (!StringUtils.isNull(str) && this.fqY.recom_extra_img_width > 0 && this.fqY.recom_extra_img_height > 0) {
            if (aVar.isLeft) {
                this.fxb.setConrers(1);
            } else if (aVar.isRight) {
                this.fxb.setConrers(0);
            } else if (aVar.fqZ) {
                this.fxb.setConrers(1);
            } else {
                this.fxb.setConrers(0);
            }
            this.fxb.setRadius((int) fvg);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.fxb.getLayoutParams();
            if (layoutParams3 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                layoutParams3.height = dimensionPixelSize;
                layoutParams3.width = (int) ((this.fqY.recom_extra_img_width / this.fqY.recom_extra_img_height) * dimensionPixelSize);
                this.fxb.setLayoutParams(layoutParams3);
            }
            this.fxb.startLoad(str, 10, false);
            this.fxb.setVisibility(0);
        } else {
            this.fxb.setVisibility(8);
        }
        this.fxc.setVisibility(8);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.dUI) {
            ap apVar = new ap("c13610");
            apVar.dn("obj_param1", this.fqY.roomId);
            apVar.dn("fid", aVar.fid);
            apVar.dn("fname", aVar.fname);
            apVar.ah("obj_locate", aVar.position);
            if (this.fqY != null && this.fqY.uiTransParam != null) {
                apVar.dn("ab_tag", this.fqY.uiTransParam.abTag);
                apVar.dn("star_id", this.fqY.uiTransParam.starId);
                apVar.dn("extra", this.fqY.uiTransParam.extra);
                apVar.dn("source_from", this.fqY.uiTransParam.sourceFrom);
            }
            TiebaStatic.log(apVar);
            return;
        }
        ap apVar2 = new ap("c13544");
        apVar2.dn("obj_param1", this.fqY.roomId);
        apVar2.dn("entryname", "游戏");
        TiebaStatic.log(apVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setViewTextColor(this.fvb, R.color.cp_cont_a);
            ao.setViewTextColor(this.fvd, R.color.cp_cont_a);
            ao.setViewTextColor(this.fse, R.color.cp_cont_b);
            Drawable drawable = ao.getDrawable(this.mTbPageContext.getResources(), R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.fvb.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.fvb.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }

    public void kc(boolean z) {
        this.fsW = z;
    }
}
