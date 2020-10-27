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
    private static final float ggk = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] ggl = {0.0f, 0.0f, 0.0f, 0.0f, ggk, ggk, ggk, ggk};
    private static final float[] ggm = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, ggk, ggk};
    private static final float[] ggn = {0.0f, 0.0f, 0.0f, 0.0f, ggk, ggk, 0.0f, 0.0f};
    private SdkLiveInfoData gbW;
    public TextView gda;
    public TbImageView gge;
    public TextView ggf;
    public TextView ggh;
    private AlphaAnimation ggs;
    public View gig;
    public ViewGroup gih;
    public TbImageView gii;
    public ImageView gij;
    private com.baidu.tieba.ala.alasquare.a.a gik;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    private int[] ggo = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean ggr = false;
    private boolean ggt = true;
    private boolean mIsAnimating = false;
    private int gil = 0;
    private boolean gdT = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            if (k.this.gik != null && k.this.gbW != null) {
                if (k.this.gbW.shouldJumpChushouLiveRoom()) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(k.this.mTbPageContext, k.this.gbW.roomId, String.valueOf(k.this.gbW.liveInfo.liveType));
                } else {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = com.baidu.adp.lib.f.b.toLong(k.this.gbW.roomId, 0L);
                    if (k.this.gbW.liveInfo != null) {
                        alaLiveInfoCoreData.hslUrl = k.this.gbW.liveInfo.hlsUrl;
                        alaLiveInfoCoreData.liveCover = k.this.gbW.liveInfo.cover;
                        alaLiveInfoCoreData.rtmpUrl = k.this.gbW.liveInfo.rtmpUrl;
                        alaLiveInfoCoreData.liveTitle = k.this.gbW.title;
                        alaLiveInfoCoreData.audienceCount = k.this.gbW.liveInfo.audienceCount;
                    }
                    if (k.this.gdT) {
                        str = k.this.gik != null ? AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_FRIENDLIVE + k.this.gik.fid : null;
                    } else {
                        str = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MAIN;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(k.this.mTbPageContext.getPageActivity(), alaLiveInfoCoreData, null, str, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
                }
                if (k.this.gik.eAY) {
                    aq aqVar = new aq("c13611");
                    aqVar.dR("obj_param1", k.this.gbW.roomId);
                    aqVar.dR("fid", k.this.gik.fid);
                    aqVar.dR("fname", k.this.gik.fname);
                    aqVar.aj("obj_locate", k.this.gik.position);
                    if (k.this.gbW != null && k.this.gbW.uiTransParam != null) {
                        aqVar.dR("ab_tag", k.this.gbW.uiTransParam.abTag);
                        aqVar.dR("star_id", k.this.gbW.uiTransParam.starId);
                        aqVar.dR("extra", k.this.gbW.uiTransParam.extra);
                        aqVar.dR("source_from", k.this.gbW.uiTransParam.sourceFrom);
                    }
                    TiebaStatic.log(aqVar);
                    return;
                }
                aq aqVar2 = new aq("c13557");
                aqVar2.dR("obj_param1", k.this.gbW.roomId);
                aqVar2.dR("entryname", "游戏");
                TiebaStatic.log(aqVar2);
            }
        }
    };

    public k(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_game_live_item_view, (ViewGroup) null, false);
        this.gge = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.gge.setBorderSurroundContent(true);
        this.gge.setDrawBorder(true);
        this.gge.setPlaceHolder(2);
        this.gge.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.gig = this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.gda = (TextView) this.mRootView.findViewById(R.id.live_title);
        this.ggf = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.ggh = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.gih = (ViewGroup) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.gii = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.gij = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.ggs = new AlphaAnimation(0.0f, 1.0f);
        this.ggs.setDuration(200L);
        this.ggs.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.1
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
        if (equipmentWidth != this.gil) {
            ViewGroup.LayoutParams layoutParams = this.gig.getLayoutParams();
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
            this.gig.setLayoutParams(layoutParams);
            this.gil = equipmentWidth;
        }
        if (aVar == null || aVar.gbW == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gik = aVar;
        this.gbW = aVar.gbW;
        Object tag = this.gge.getTag();
        if (this.ggt) {
            this.ggr = true;
            this.ggt = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.gbW.liveInfo.cover) && !((String) tag).equals(this.gbW.liveInfo.cover)) {
            this.ggr = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.gbW.liveInfo.cover) && !this.mCoverUrl.equals(this.gbW.liveInfo.cover)) {
            this.ggr = true;
        } else {
            this.ggr = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.ggo);
        this.mCoverUrl = this.gbW.liveInfo.cover;
        this.gge.setTag(this.mCoverUrl);
        if (aVar.isLeft) {
            this.gge.setConrers(5);
            gradientDrawable.setCornerRadii(ggm);
            this.gge.setPlaceHolder(2);
        } else if (aVar.isRight) {
            this.gge.setConrers(10);
            gradientDrawable.setCornerRadii(ggn);
            this.gge.setPlaceHolder(2);
        } else if (aVar.gbX) {
            this.gge.setConrers(15);
            gradientDrawable.setCornerRadii(ggl);
            this.gge.setPlaceHolder(2);
        }
        this.gge.setRadius((int) ggk);
        this.gge.startLoad(this.gbW.liveInfo.cover, 10, false);
        this.gih.setBackgroundDrawable(gradientDrawable);
        this.gge.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z && k.this.ggr && !k.this.mIsAnimating) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        k.this.gge.startAnimation(k.this.ggs);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.ggf.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, at.da(this.gbW.liveInfo.audienceCount)));
        this.ggh.setText(this.gbW.liveAuthor.name);
        this.gda.setText(this.gbW.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.gbW.recom_extra_img_night;
        } else {
            str = this.gbW.recom_extra_img;
        }
        if (!StringUtils.isNull(str) && this.gbW.recom_extra_img_width > 0 && this.gbW.recom_extra_img_height > 0) {
            if (aVar.isLeft) {
                this.gii.setConrers(1);
            } else if (aVar.isRight) {
                this.gii.setConrers(0);
            } else if (aVar.gbX) {
                this.gii.setConrers(1);
            } else {
                this.gii.setConrers(0);
            }
            this.gii.setRadius((int) ggk);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gii.getLayoutParams();
            if (layoutParams3 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                layoutParams3.height = dimensionPixelSize;
                layoutParams3.width = (int) ((this.gbW.recom_extra_img_width / this.gbW.recom_extra_img_height) * dimensionPixelSize);
                this.gii.setLayoutParams(layoutParams3);
            }
            this.gii.startLoad(str, 10, false);
            this.gii.setVisibility(0);
        } else {
            this.gii.setVisibility(8);
        }
        this.gij.setVisibility(8);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.eAY) {
            aq aqVar = new aq("c13610");
            aqVar.dR("obj_param1", this.gbW.roomId);
            aqVar.dR("fid", aVar.fid);
            aqVar.dR("fname", aVar.fname);
            aqVar.aj("obj_locate", aVar.position);
            if (this.gbW != null && this.gbW.uiTransParam != null) {
                aqVar.dR("ab_tag", this.gbW.uiTransParam.abTag);
                aqVar.dR("star_id", this.gbW.uiTransParam.starId);
                aqVar.dR("extra", this.gbW.uiTransParam.extra);
                aqVar.dR("source_from", this.gbW.uiTransParam.sourceFrom);
            }
            TiebaStatic.log(aqVar);
            return;
        }
        aq aqVar2 = new aq("c13544");
        aqVar2.dR("obj_param1", this.gbW.roomId);
        aqVar2.dR("entryname", "游戏");
        TiebaStatic.log(aqVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.ggf, R.color.cp_cont_a);
            ap.setViewTextColor(this.ggh, R.color.cp_cont_a);
            ap.setViewTextColor(this.gda, R.color.cp_cont_b);
            Drawable drawable = ap.getDrawable(this.mTbPageContext.getResources(), R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.ggf.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.ggf.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }

    public void lu(boolean z) {
        this.gdT = z;
    }
}
