package com.baidu.tieba.ala.alasquare.widget;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.cg;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class g extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.a.g> {
    private TextView bac;
    private b gAq;
    private TbImageView gKY;
    private int gLD;
    private TextView gLO;
    private TextView gLP;
    private LinearLayout gLQ;
    private ImageView gLR;
    private LinearLayout gLS;
    private TextView gLT;
    private RelativeLayout gLU;
    private RelativeLayout gLV;
    private ClickableHeaderImageView gLW;
    private TextView gLX;
    private TextView gLY;
    private View gLZ;
    private TextView gLa;
    private RelativeLayout gLb;
    private ClickableHeaderImageView gLc;
    private TextView gLd;
    private boolean gMa;
    private com.baidu.tieba.ala.alasquare.a.g gMd;
    private cg gMe;
    private a gMf;
    private TextView gMg;
    public int mSkinType;
    private int mViewWidth;

    /* loaded from: classes10.dex */
    public interface a {
        void c(com.baidu.tieba.ala.alasquare.a.g gVar);
    }

    /* loaded from: classes10.dex */
    public interface b {
        void a(com.baidu.tieba.ala.alasquare.a.g gVar, View view);
    }

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mViewWidth = 0;
        this.gLD = 0;
        initView();
    }

    private void initView() {
        this.gKY = (TbImageView) getView().findViewById(R.id.imgSquareView);
        this.gLP = (TextView) getView().findViewById(R.id.tvSquareTip);
        this.gLQ = (LinearLayout) getView().findViewById(R.id.llLiveTipPanel);
        this.gLR = (ImageView) getView().findViewById(R.id.imgLiveCountLabel);
        this.gLa = (TextView) getView().findViewById(R.id.tvLiveCount);
        this.gLS = (LinearLayout) getView().findViewById(R.id.llLiveBottomPanel);
        this.gLb = (RelativeLayout) getView().findViewById(R.id.rlSquareLivePanel);
        this.gLc = (ClickableHeaderImageView) getView().findViewById(R.id.imgUserCover);
        this.bac = (TextView) getView().findViewById(R.id.tvUserName);
        this.gLT = (TextView) getView().findViewById(R.id.tvCreateTime);
        this.gLU = (RelativeLayout) getView().findViewById(R.id.rlSquareUserInfo);
        this.gLd = (TextView) getView().findViewById(R.id.tvSquareTitle);
        this.gMg = (TextView) getView().findViewById(R.id.good_video_label);
        this.gLZ = getView().findViewById(R.id.llSquareTitlePanel);
        this.gLV = (RelativeLayout) getView().findViewById(R.id.rlSquareNewUserInfo);
        this.gLW = (ClickableHeaderImageView) getView().findViewById(R.id.imgNewUserCover);
        this.gLX = (TextView) getView().findViewById(R.id.tvNewUserName);
        this.gLO = (TextView) getView().findViewById(R.id.tvNewCount);
        this.gLY = (TextView) getView().findViewById(R.id.tvSquareNewTitle);
        this.gLW.setIsRound(true);
        this.gLO.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(R.drawable.icon_home_card_like_grey), (Drawable) null, (Drawable) null, (Drawable) null);
        this.gKY.setDefaultBgResource(com.baidu.tieba.ala.alasquare.widget.a.bVP());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gLb.getLayoutParams();
        this.mViewWidth = l.getEquipmentWidth(this.mContext) / 2;
        this.gLD = (this.mViewWidth * 9) / 16;
        layoutParams.width = this.mViewWidth;
        layoutParams.height = this.gLD;
        this.gLb.setLayoutParams(layoutParams);
        this.gLR.setImageResource(R.drawable.icon_video_recommend_like);
        getView().setOnClickListener(this);
    }

    public void mO(boolean z) {
        this.gMa = z;
    }

    public void mP(boolean z) {
        this.gLU.setVisibility(z ? 0 : 8);
        if (z) {
            this.gLZ.setVisibility(0);
            this.gLS.setVisibility(0);
            this.gLV.setVisibility(8);
            this.gLY.setVisibility(8);
        }
    }

    public void mQ(boolean z) {
        this.gLV.setVisibility(z ? 0 : 8);
        this.gLY.setVisibility(z ? 0 : 8);
        if (z) {
            this.gLU.setVisibility(8);
            this.gLZ.setVisibility(8);
            this.gLS.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.gLb, R.drawable.addresslist_item_bg);
            ao.setViewTextColor(this.gLP, R.color.CAM_X0111);
            ao.setViewTextColor(this.gLa, R.color.CAM_X0111);
            ao.setViewTextColor(this.bac, R.color.CAM_X0108);
            ao.setViewTextColor(this.gLT, R.color.CAM_X0108);
            ao.setViewTextColor(this.gLd, R.color.CAM_X0105);
            ao.setViewTextColor(this.gLX, R.color.CAM_X0106);
            ao.setViewTextColor(this.gLY, R.color.CAM_X0111);
            ao.setViewTextColor(this.gLO, R.color.CAM_X0106);
            ao.setBackgroundResource(this.gMg, R.drawable.good_video_label_bg);
            ao.setViewTextColor(this.gMg, R.color.CAM_X0111);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.square_video_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    /* renamed from: b */
    public void a(com.baidu.tieba.ala.alasquare.a.g gVar) {
        if (gVar != null && gVar.gAx != null) {
            this.gMd = gVar;
            this.gLQ.setVisibility(8);
            this.gLR.setVisibility(0);
            if (this.gMa) {
                int i = this.gLD;
                if (gVar != null && gVar.gAx != null && gVar.gAx.brI() != null && gVar.gAx.brI().thumbnail_width != null && gVar.gAx.brI().thumbnail_width.intValue() > 0) {
                    i = (this.mViewWidth * gVar.gAx.brI().thumbnail_height.intValue()) / gVar.gAx.brI().thumbnail_width.intValue();
                }
                ViewGroup.LayoutParams layoutParams = this.gLb.getLayoutParams();
                layoutParams.width = this.mViewWidth;
                layoutParams.height = i;
                this.gLb.setLayoutParams(layoutParams);
            }
            String numberUniformFormatExtra = at.numberUniformFormatExtra(gVar.gAx.bsS());
            this.gLa.setText(numberUniformFormatExtra);
            this.gLc.setVisibility(0);
            this.gLc.setData(gVar.gAx);
            this.gLc.setIsRound(true);
            this.gLd.setText(gVar.gAx.getTitle());
            this.gKY.startLoad(gVar.gAx.brI().thumbnail_url, 10, false);
            this.bac.setVisibility(0);
            this.gMe = gVar.gAx.bsK();
            this.gLT.setText(at.getFormatTime(gVar.gAx.getCreateTime()));
            if (this.gMe != null) {
                String str = this.gMe.channelName;
                if (ad.getTextLengthWithEmoji(str) > 10) {
                    str = ad.subStringWithEmoji(str, 10) + StringHelper.STRING_MORE;
                }
                this.bac.setText(str);
                this.gLX.setText(str);
            } else if (gVar.gAx.brr() != null && !StringUtils.isNull(gVar.gAx.brr().getName_show())) {
                String name_show = gVar.gAx.brr().getName_show();
                if (ad.getTextLengthWithEmoji(name_show) > 10) {
                    name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
                }
                this.bac.setText(name_show);
                this.gLX.setText(name_show);
            }
            this.gLW.setData(gVar.gAx, false);
            this.gLO.setText(numberUniformFormatExtra);
            this.gLY.setText(gVar.gAx.getTitle());
            if (gVar.bUn()) {
                this.gMg.setVisibility(0);
            } else {
                this.gMg.setVisibility(8);
            }
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == getView()) {
            if (this.gMf != null) {
                this.gMf.c(this.gMd);
            }
            if (this.gAq != null) {
                this.gAq.a(this.gMd, view);
            }
            com.baidu.tieba.ala.alasquare.b.a.bVm().mG(true);
        }
    }

    public void a(b bVar) {
        this.gAq = bVar;
    }
}
