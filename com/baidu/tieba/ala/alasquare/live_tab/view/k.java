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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class k {
    private static final float fpW = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] fpX = {0.0f, 0.0f, 0.0f, 0.0f, fpW, fpW, fpW, fpW};
    private static final float[] fpY = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, fpW, fpW};
    private static final float[] fpZ = {0.0f, 0.0f, 0.0f, 0.0f, fpW, fpW, 0.0f, 0.0f};
    private SdkLiveInfoData flQ;
    public TextView fmU;
    public TbImageView fpQ;
    public TextView fpR;
    public TextView fpT;
    private AlphaAnimation fqe;
    public View frR;
    public ViewGroup frS;
    public TbImageView frT;
    public ImageView frU;
    private com.baidu.tieba.ala.alasquare.a.a frV;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    private int[] fqa = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean fqd = false;
    private boolean fqf = true;
    private boolean fqg = false;
    private int frW = 0;
    private boolean fnN = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            if (k.this.frV != null && k.this.flQ != null) {
                if (k.this.flQ.shouldJumpChushouLiveRoom()) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(k.this.mTbPageContext, k.this.flQ.roomId, String.valueOf(k.this.flQ.liveInfo.liveType));
                } else {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = com.baidu.adp.lib.f.b.toLong(k.this.flQ.roomId, 0L);
                    if (k.this.flQ.liveInfo != null) {
                        alaLiveInfoCoreData.hslUrl = k.this.flQ.liveInfo.hlsUrl;
                        alaLiveInfoCoreData.liveCover = k.this.flQ.liveInfo.cover;
                        alaLiveInfoCoreData.rtmpUrl = k.this.flQ.liveInfo.rtmpUrl;
                        alaLiveInfoCoreData.liveTitle = k.this.flQ.title;
                        alaLiveInfoCoreData.audienceCount = k.this.flQ.liveInfo.audienceCount;
                    }
                    if (k.this.fnN) {
                        str = k.this.frV != null ? AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_FRIENDLIVE + k.this.frV.fid : null;
                    } else {
                        str = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MAIN;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(k.this.mTbPageContext.getPageActivity(), alaLiveInfoCoreData, null, str, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
                }
                if (k.this.frV.dOx) {
                    ao aoVar = new ao("c13611");
                    aoVar.dk("obj_param1", k.this.flQ.roomId);
                    aoVar.dk("fid", k.this.frV.fid);
                    aoVar.dk("fname", k.this.frV.fname);
                    aoVar.ag("obj_locate", k.this.frV.position);
                    if (k.this.flQ != null && k.this.flQ.uiTransParam != null) {
                        aoVar.dk("ab_tag", k.this.flQ.uiTransParam.abTag);
                        aoVar.dk("star_id", k.this.flQ.uiTransParam.starId);
                        aoVar.dk("extra", k.this.flQ.uiTransParam.extra);
                        aoVar.dk("source_from", k.this.flQ.uiTransParam.sourceFrom);
                    }
                    TiebaStatic.log(aoVar);
                    return;
                }
                ao aoVar2 = new ao("c13557");
                aoVar2.dk("obj_param1", k.this.flQ.roomId);
                aoVar2.dk("entryname", "游戏");
                TiebaStatic.log(aoVar2);
            }
        }
    };

    public k(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_game_live_item_view, (ViewGroup) null, false);
        this.fpQ = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.fpQ.setBorderSurroundContent(true);
        this.fpQ.setDrawBorder(true);
        this.fpQ.setPlaceHolder(2);
        this.fpQ.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.frR = this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.fmU = (TextView) this.mRootView.findViewById(R.id.live_title);
        this.fpR = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.fpT = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.frS = (ViewGroup) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.frT = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.frU = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.fqe = new AlphaAnimation(0.0f, 1.0f);
        this.fqe.setDuration(200L);
        this.fqe.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                k.this.fqg = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                k.this.fqg = false;
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
        if (equipmentWidth != this.frW) {
            ViewGroup.LayoutParams layoutParams = this.frR.getLayoutParams();
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
            this.frR.setLayoutParams(layoutParams);
            this.frW = equipmentWidth;
        }
        if (aVar == null || aVar.flQ == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.frV = aVar;
        this.flQ = aVar.flQ;
        Object tag = this.fpQ.getTag();
        if (this.fqf) {
            this.fqd = true;
            this.fqf = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.flQ.liveInfo.cover) && !((String) tag).equals(this.flQ.liveInfo.cover)) {
            this.fqd = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.flQ.liveInfo.cover) && !this.mCoverUrl.equals(this.flQ.liveInfo.cover)) {
            this.fqd = true;
        } else {
            this.fqd = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.fqa);
        this.mCoverUrl = this.flQ.liveInfo.cover;
        this.fpQ.setTag(this.mCoverUrl);
        if (aVar.isLeft) {
            this.fpQ.setConrers(5);
            gradientDrawable.setCornerRadii(fpY);
            this.fpQ.setPlaceHolder(2);
        } else if (aVar.isRight) {
            this.fpQ.setConrers(10);
            gradientDrawable.setCornerRadii(fpZ);
            this.fpQ.setPlaceHolder(2);
        } else if (aVar.flR) {
            this.fpQ.setConrers(15);
            gradientDrawable.setCornerRadii(fpX);
            this.fpQ.setPlaceHolder(2);
        }
        this.fpQ.setRadius((int) fpW);
        this.fpQ.startLoad(this.flQ.liveInfo.cover, 10, false);
        this.frS.setBackgroundDrawable(gradientDrawable);
        this.fpQ.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.k.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z && k.this.fqd && !k.this.fqg) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        k.this.fpQ.startAnimation(k.this.fqe);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fpR.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, ar.cm(this.flQ.liveInfo.audienceCount)));
        this.fpT.setText(this.flQ.liveAuthor.name);
        this.fmU.setText(this.flQ.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.flQ.recom_extra_img_night;
        } else {
            str = this.flQ.recom_extra_img;
        }
        if (!StringUtils.isNull(str) && this.flQ.recom_extra_img_width > 0 && this.flQ.recom_extra_img_height > 0) {
            if (aVar.isLeft) {
                this.frT.setConrers(1);
            } else if (aVar.isRight) {
                this.frT.setConrers(0);
            } else if (aVar.flR) {
                this.frT.setConrers(1);
            } else {
                this.frT.setConrers(0);
            }
            this.frT.setRadius((int) fpW);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.frT.getLayoutParams();
            if (layoutParams3 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                layoutParams3.height = dimensionPixelSize;
                layoutParams3.width = (int) ((this.flQ.recom_extra_img_width / this.flQ.recom_extra_img_height) * dimensionPixelSize);
                this.frT.setLayoutParams(layoutParams3);
            }
            this.frT.startLoad(str, 10, false);
            this.frT.setVisibility(0);
        } else {
            this.frT.setVisibility(8);
        }
        this.frU.setVisibility(8);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.dOx) {
            ao aoVar = new ao("c13610");
            aoVar.dk("obj_param1", this.flQ.roomId);
            aoVar.dk("fid", aVar.fid);
            aoVar.dk("fname", aVar.fname);
            aoVar.ag("obj_locate", aVar.position);
            if (this.flQ != null && this.flQ.uiTransParam != null) {
                aoVar.dk("ab_tag", this.flQ.uiTransParam.abTag);
                aoVar.dk("star_id", this.flQ.uiTransParam.starId);
                aoVar.dk("extra", this.flQ.uiTransParam.extra);
                aoVar.dk("source_from", this.flQ.uiTransParam.sourceFrom);
            }
            TiebaStatic.log(aoVar);
            return;
        }
        ao aoVar2 = new ao("c13544");
        aoVar2.dk("obj_param1", this.flQ.roomId);
        aoVar2.dk("entryname", "游戏");
        TiebaStatic.log(aoVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            an.setViewTextColor(this.fpR, (int) R.color.cp_cont_a);
            an.setViewTextColor(this.fpT, (int) R.color.cp_cont_a);
            an.setViewTextColor(this.fmU, (int) R.color.cp_cont_b);
            Drawable drawable = an.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.fpR.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.fpR.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }

    public void jy(boolean z) {
        this.fnN = z;
    }
}
