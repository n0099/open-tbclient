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
    private static final float fWg = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] fWh = {0.0f, 0.0f, 0.0f, 0.0f, fWg, fWg, fWg, fWg};
    private static final float[] fWi = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, fWg, fWg};
    private static final float[] fWj = {0.0f, 0.0f, 0.0f, 0.0f, fWg, fWg, 0.0f, 0.0f};
    private SdkLiveInfoData fRT;
    public TextView fSX;
    public TbImageView fWa;
    public TextView fWb;
    public TextView fWd;
    private AlphaAnimation fWo;
    public View fYb;
    public ViewGroup fYc;
    public TbImageView fYd;
    public ImageView fYe;
    private com.baidu.tieba.ala.alasquare.a.a fYf;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    private int[] fWk = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean fWn = false;
    private boolean fWp = true;
    private boolean mIsAnimating = false;
    private int fYg = 0;
    private boolean fTQ = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            if (k.this.fYf != null && k.this.fRT != null) {
                if (k.this.fRT.shouldJumpChushouLiveRoom()) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(k.this.mTbPageContext, k.this.fRT.roomId, String.valueOf(k.this.fRT.liveInfo.liveType));
                } else {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = com.baidu.adp.lib.f.b.toLong(k.this.fRT.roomId, 0L);
                    if (k.this.fRT.liveInfo != null) {
                        alaLiveInfoCoreData.hslUrl = k.this.fRT.liveInfo.hlsUrl;
                        alaLiveInfoCoreData.liveCover = k.this.fRT.liveInfo.cover;
                        alaLiveInfoCoreData.rtmpUrl = k.this.fRT.liveInfo.rtmpUrl;
                        alaLiveInfoCoreData.liveTitle = k.this.fRT.title;
                        alaLiveInfoCoreData.audienceCount = k.this.fRT.liveInfo.audienceCount;
                    }
                    if (k.this.fTQ) {
                        str = k.this.fYf != null ? AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_FRIENDLIVE + k.this.fYf.fid : null;
                    } else {
                        str = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MAIN;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(k.this.mTbPageContext.getPageActivity(), alaLiveInfoCoreData, null, str, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
                }
                if (k.this.fYf.esy) {
                    aq aqVar = new aq("c13611");
                    aqVar.dK("obj_param1", k.this.fRT.roomId);
                    aqVar.dK("fid", k.this.fYf.fid);
                    aqVar.dK("fname", k.this.fYf.fname);
                    aqVar.aj("obj_locate", k.this.fYf.position);
                    if (k.this.fRT != null && k.this.fRT.uiTransParam != null) {
                        aqVar.dK("ab_tag", k.this.fRT.uiTransParam.abTag);
                        aqVar.dK("star_id", k.this.fRT.uiTransParam.starId);
                        aqVar.dK("extra", k.this.fRT.uiTransParam.extra);
                        aqVar.dK("source_from", k.this.fRT.uiTransParam.sourceFrom);
                    }
                    TiebaStatic.log(aqVar);
                    return;
                }
                aq aqVar2 = new aq("c13557");
                aqVar2.dK("obj_param1", k.this.fRT.roomId);
                aqVar2.dK("entryname", "游戏");
                TiebaStatic.log(aqVar2);
            }
        }
    };

    public k(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_game_live_item_view, (ViewGroup) null, false);
        this.fWa = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.fWa.setBorderSurroundContent(true);
        this.fWa.setDrawBorder(true);
        this.fWa.setPlaceHolder(2);
        this.fWa.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.fYb = this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.fSX = (TextView) this.mRootView.findViewById(R.id.live_title);
        this.fWb = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.fWd = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.fYc = (ViewGroup) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.fYd = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.fYe = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.fWo = new AlphaAnimation(0.0f, 1.0f);
        this.fWo.setDuration(200L);
        this.fWo.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.1
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
        if (equipmentWidth != this.fYg) {
            ViewGroup.LayoutParams layoutParams = this.fYb.getLayoutParams();
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
            this.fYb.setLayoutParams(layoutParams);
            this.fYg = equipmentWidth;
        }
        if (aVar == null || aVar.fRT == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.fYf = aVar;
        this.fRT = aVar.fRT;
        Object tag = this.fWa.getTag();
        if (this.fWp) {
            this.fWn = true;
            this.fWp = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.fRT.liveInfo.cover) && !((String) tag).equals(this.fRT.liveInfo.cover)) {
            this.fWn = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.fRT.liveInfo.cover) && !this.mCoverUrl.equals(this.fRT.liveInfo.cover)) {
            this.fWn = true;
        } else {
            this.fWn = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.fWk);
        this.mCoverUrl = this.fRT.liveInfo.cover;
        this.fWa.setTag(this.mCoverUrl);
        if (aVar.isLeft) {
            this.fWa.setConrers(5);
            gradientDrawable.setCornerRadii(fWi);
            this.fWa.setPlaceHolder(2);
        } else if (aVar.isRight) {
            this.fWa.setConrers(10);
            gradientDrawable.setCornerRadii(fWj);
            this.fWa.setPlaceHolder(2);
        } else if (aVar.fRU) {
            this.fWa.setConrers(15);
            gradientDrawable.setCornerRadii(fWh);
            this.fWa.setPlaceHolder(2);
        }
        this.fWa.setRadius((int) fWg);
        this.fWa.startLoad(this.fRT.liveInfo.cover, 10, false);
        this.fYc.setBackgroundDrawable(gradientDrawable);
        this.fWa.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z && k.this.fWn && !k.this.mIsAnimating) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        k.this.fWa.startAnimation(k.this.fWo);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fWb.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, at.cY(this.fRT.liveInfo.audienceCount)));
        this.fWd.setText(this.fRT.liveAuthor.name);
        this.fSX.setText(this.fRT.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.fRT.recom_extra_img_night;
        } else {
            str = this.fRT.recom_extra_img;
        }
        if (!StringUtils.isNull(str) && this.fRT.recom_extra_img_width > 0 && this.fRT.recom_extra_img_height > 0) {
            if (aVar.isLeft) {
                this.fYd.setConrers(1);
            } else if (aVar.isRight) {
                this.fYd.setConrers(0);
            } else if (aVar.fRU) {
                this.fYd.setConrers(1);
            } else {
                this.fYd.setConrers(0);
            }
            this.fYd.setRadius((int) fWg);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.fYd.getLayoutParams();
            if (layoutParams3 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                layoutParams3.height = dimensionPixelSize;
                layoutParams3.width = (int) ((this.fRT.recom_extra_img_width / this.fRT.recom_extra_img_height) * dimensionPixelSize);
                this.fYd.setLayoutParams(layoutParams3);
            }
            this.fYd.startLoad(str, 10, false);
            this.fYd.setVisibility(0);
        } else {
            this.fYd.setVisibility(8);
        }
        this.fYe.setVisibility(8);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.esy) {
            aq aqVar = new aq("c13610");
            aqVar.dK("obj_param1", this.fRT.roomId);
            aqVar.dK("fid", aVar.fid);
            aqVar.dK("fname", aVar.fname);
            aqVar.aj("obj_locate", aVar.position);
            if (this.fRT != null && this.fRT.uiTransParam != null) {
                aqVar.dK("ab_tag", this.fRT.uiTransParam.abTag);
                aqVar.dK("star_id", this.fRT.uiTransParam.starId);
                aqVar.dK("extra", this.fRT.uiTransParam.extra);
                aqVar.dK("source_from", this.fRT.uiTransParam.sourceFrom);
            }
            TiebaStatic.log(aqVar);
            return;
        }
        aq aqVar2 = new aq("c13544");
        aqVar2.dK("obj_param1", this.fRT.roomId);
        aqVar2.dK("entryname", "游戏");
        TiebaStatic.log(aqVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.fWb, R.color.cp_cont_a);
            ap.setViewTextColor(this.fWd, R.color.cp_cont_a);
            ap.setViewTextColor(this.fSX, R.color.cp_cont_b);
            Drawable drawable = ap.getDrawable(this.mTbPageContext.getResources(), R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.fWb.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.fWb.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }

    public void lc(boolean z) {
        this.fTQ = z;
    }
}
