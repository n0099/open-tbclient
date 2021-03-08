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
import com.baidu.tbadk.core.data.ci;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class g extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.a.g> {
    private TextView aZX;
    private b gAq;
    private TbImageView gKZ;
    private int gLE;
    private TextView gLP;
    private TextView gLQ;
    private LinearLayout gLR;
    private ImageView gLS;
    private LinearLayout gLT;
    private TextView gLU;
    private RelativeLayout gLV;
    private RelativeLayout gLW;
    private ClickableHeaderImageView gLX;
    private TextView gLY;
    private TextView gLZ;
    private TextView gLb;
    private RelativeLayout gLc;
    private ClickableHeaderImageView gLd;
    private TextView gLe;
    private View gMa;
    private boolean gMb;
    private com.baidu.tieba.ala.alasquare.a.g gMe;
    private ci gMf;
    private a gMg;
    private TextView gMh;
    public int mSkinType;
    private int mViewWidth;

    /* loaded from: classes9.dex */
    public interface a {
        void c(com.baidu.tieba.ala.alasquare.a.g gVar);
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a(com.baidu.tieba.ala.alasquare.a.g gVar, View view);
    }

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mViewWidth = 0;
        this.gLE = 0;
        initView();
    }

    private void initView() {
        this.gKZ = (TbImageView) getView().findViewById(R.id.imgSquareView);
        this.gLQ = (TextView) getView().findViewById(R.id.tvSquareTip);
        this.gLR = (LinearLayout) getView().findViewById(R.id.llLiveTipPanel);
        this.gLS = (ImageView) getView().findViewById(R.id.imgLiveCountLabel);
        this.gLb = (TextView) getView().findViewById(R.id.tvLiveCount);
        this.gLT = (LinearLayout) getView().findViewById(R.id.llLiveBottomPanel);
        this.gLc = (RelativeLayout) getView().findViewById(R.id.rlSquareLivePanel);
        this.gLd = (ClickableHeaderImageView) getView().findViewById(R.id.imgUserCover);
        this.aZX = (TextView) getView().findViewById(R.id.tvUserName);
        this.gLU = (TextView) getView().findViewById(R.id.tvCreateTime);
        this.gLV = (RelativeLayout) getView().findViewById(R.id.rlSquareUserInfo);
        this.gLe = (TextView) getView().findViewById(R.id.tvSquareTitle);
        this.gMh = (TextView) getView().findViewById(R.id.good_video_label);
        this.gMa = getView().findViewById(R.id.llSquareTitlePanel);
        this.gLW = (RelativeLayout) getView().findViewById(R.id.rlSquareNewUserInfo);
        this.gLX = (ClickableHeaderImageView) getView().findViewById(R.id.imgNewUserCover);
        this.gLY = (TextView) getView().findViewById(R.id.tvNewUserName);
        this.gLP = (TextView) getView().findViewById(R.id.tvNewCount);
        this.gLZ = (TextView) getView().findViewById(R.id.tvSquareNewTitle);
        this.gLX.setIsRound(true);
        this.gLP.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(R.drawable.icon_home_card_like_grey), (Drawable) null, (Drawable) null, (Drawable) null);
        this.gKZ.setDefaultBgResource(com.baidu.tieba.ala.alasquare.widget.a.bSN());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gLc.getLayoutParams();
        this.mViewWidth = l.getEquipmentWidth(this.mContext) / 2;
        this.gLE = (this.mViewWidth * 9) / 16;
        layoutParams.width = this.mViewWidth;
        layoutParams.height = this.gLE;
        this.gLc.setLayoutParams(layoutParams);
        this.gLS.setImageResource(R.drawable.icon_video_recommend_like);
        getView().setOnClickListener(this);
    }

    public void mO(boolean z) {
        this.gMb = z;
    }

    public void mP(boolean z) {
        this.gLV.setVisibility(z ? 0 : 8);
        if (z) {
            this.gMa.setVisibility(0);
            this.gLT.setVisibility(0);
            this.gLW.setVisibility(8);
            this.gLZ.setVisibility(8);
        }
    }

    public void mQ(boolean z) {
        this.gLW.setVisibility(z ? 0 : 8);
        this.gLZ.setVisibility(z ? 0 : 8);
        if (z) {
            this.gLV.setVisibility(8);
            this.gMa.setVisibility(8);
            this.gLT.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gLc, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gLQ, R.color.CAM_X0111);
            ap.setViewTextColor(this.gLb, R.color.CAM_X0111);
            ap.setViewTextColor(this.aZX, R.color.CAM_X0108);
            ap.setViewTextColor(this.gLU, R.color.CAM_X0108);
            ap.setViewTextColor(this.gLe, R.color.CAM_X0105);
            ap.setViewTextColor(this.gLY, R.color.CAM_X0106);
            ap.setViewTextColor(this.gLZ, R.color.CAM_X0111);
            ap.setViewTextColor(this.gLP, R.color.CAM_X0106);
            ap.setBackgroundResource(this.gMh, R.drawable.good_video_label_bg);
            ap.setViewTextColor(this.gMh, R.color.CAM_X0111);
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
            this.gMe = gVar;
            this.gLR.setVisibility(8);
            this.gLS.setVisibility(0);
            if (this.gMb) {
                int i = this.gLE;
                if (gVar != null && gVar.gAx != null && gVar.gAx.boj() != null && gVar.gAx.boj().thumbnail_width != null && gVar.gAx.boj().thumbnail_width.intValue() > 0) {
                    i = (this.mViewWidth * gVar.gAx.boj().thumbnail_height.intValue()) / gVar.gAx.boj().thumbnail_width.intValue();
                }
                ViewGroup.LayoutParams layoutParams = this.gLc.getLayoutParams();
                layoutParams.width = this.mViewWidth;
                layoutParams.height = i;
                this.gLc.setLayoutParams(layoutParams);
            }
            String numberUniformFormatExtra = au.numberUniformFormatExtra(gVar.gAx.bps());
            this.gLb.setText(numberUniformFormatExtra);
            this.gLd.setVisibility(0);
            this.gLd.setData(gVar.gAx);
            this.gLd.setIsRound(true);
            this.gLe.setText(gVar.gAx.getTitle());
            this.gKZ.startLoad(gVar.gAx.boj().thumbnail_url, 10, false);
            this.aZX.setVisibility(0);
            this.gMf = gVar.gAx.bpk();
            this.gLU.setText(au.getFormatTime(gVar.gAx.getCreateTime()));
            if (this.gMf != null) {
                String str = this.gMf.channelName;
                if (ag.getTextLengthWithEmoji(str) > 10) {
                    str = ag.subStringWithEmoji(str, 10) + StringHelper.STRING_MORE;
                }
                this.aZX.setText(str);
                this.gLY.setText(str);
            } else if (gVar.gAx.bnS() != null && !StringUtils.isNull(gVar.gAx.bnS().getName_show())) {
                String name_show = gVar.gAx.bnS().getName_show();
                if (ag.getTextLengthWithEmoji(name_show) > 10) {
                    name_show = ag.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
                }
                this.aZX.setText(name_show);
                this.gLY.setText(name_show);
            }
            this.gLX.setData(gVar.gAx, false);
            this.gLP.setText(numberUniformFormatExtra);
            this.gLZ.setText(gVar.gAx.getTitle());
            if (gVar.bRm()) {
                this.gMh.setVisibility(0);
            } else {
                this.gMh.setVisibility(8);
            }
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == getView()) {
            if (this.gMg != null) {
                this.gMg.c(this.gMe);
            }
            if (this.gAq != null) {
                this.gAq.a(this.gMe, view);
            }
            com.baidu.tieba.ala.alasquare.b.a.bSk().mG(true);
        }
    }

    public void a(b bVar) {
        this.gAq = bVar;
    }
}
