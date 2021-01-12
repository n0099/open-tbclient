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
/* loaded from: classes9.dex */
public class g extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.a.g> {
    private TextView aVp;
    private int gGX;
    private TbImageView gGs;
    private TextView gGu;
    private RelativeLayout gGv;
    private ClickableHeaderImageView gGw;
    private TextView gGx;
    private TextView gHA;
    private TextView gHi;
    private TextView gHj;
    private LinearLayout gHk;
    private ImageView gHl;
    private LinearLayout gHm;
    private TextView gHn;
    private RelativeLayout gHo;
    private RelativeLayout gHp;
    private ClickableHeaderImageView gHq;
    private TextView gHr;
    private TextView gHs;
    private View gHt;
    private boolean gHu;
    private com.baidu.tieba.ala.alasquare.a.g gHx;
    private cg gHy;
    private a gHz;
    private b gvJ;
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
        this.gGX = 0;
        initView();
    }

    private void initView() {
        this.gGs = (TbImageView) getView().findViewById(R.id.imgSquareView);
        this.gHj = (TextView) getView().findViewById(R.id.tvSquareTip);
        this.gHk = (LinearLayout) getView().findViewById(R.id.llLiveTipPanel);
        this.gHl = (ImageView) getView().findViewById(R.id.imgLiveCountLabel);
        this.gGu = (TextView) getView().findViewById(R.id.tvLiveCount);
        this.gHm = (LinearLayout) getView().findViewById(R.id.llLiveBottomPanel);
        this.gGv = (RelativeLayout) getView().findViewById(R.id.rlSquareLivePanel);
        this.gGw = (ClickableHeaderImageView) getView().findViewById(R.id.imgUserCover);
        this.aVp = (TextView) getView().findViewById(R.id.tvUserName);
        this.gHn = (TextView) getView().findViewById(R.id.tvCreateTime);
        this.gHo = (RelativeLayout) getView().findViewById(R.id.rlSquareUserInfo);
        this.gGx = (TextView) getView().findViewById(R.id.tvSquareTitle);
        this.gHA = (TextView) getView().findViewById(R.id.good_video_label);
        this.gHt = getView().findViewById(R.id.llSquareTitlePanel);
        this.gHp = (RelativeLayout) getView().findViewById(R.id.rlSquareNewUserInfo);
        this.gHq = (ClickableHeaderImageView) getView().findViewById(R.id.imgNewUserCover);
        this.gHr = (TextView) getView().findViewById(R.id.tvNewUserName);
        this.gHi = (TextView) getView().findViewById(R.id.tvNewCount);
        this.gHs = (TextView) getView().findViewById(R.id.tvSquareNewTitle);
        this.gHq.setIsRound(true);
        this.gHi.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(R.drawable.icon_home_card_like_grey), (Drawable) null, (Drawable) null, (Drawable) null);
        this.gGs.setDefaultBgResource(com.baidu.tieba.ala.alasquare.widget.a.bRX());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gGv.getLayoutParams();
        this.mViewWidth = l.getEquipmentWidth(this.mContext) / 2;
        this.gGX = (this.mViewWidth * 9) / 16;
        layoutParams.width = this.mViewWidth;
        layoutParams.height = this.gGX;
        this.gGv.setLayoutParams(layoutParams);
        this.gHl.setImageResource(R.drawable.icon_video_recommend_like);
        getView().setOnClickListener(this);
    }

    public void mK(boolean z) {
        this.gHu = z;
    }

    public void mL(boolean z) {
        this.gHo.setVisibility(z ? 0 : 8);
        if (z) {
            this.gHt.setVisibility(0);
            this.gHm.setVisibility(0);
            this.gHp.setVisibility(8);
            this.gHs.setVisibility(8);
        }
    }

    public void mM(boolean z) {
        this.gHp.setVisibility(z ? 0 : 8);
        this.gHs.setVisibility(z ? 0 : 8);
        if (z) {
            this.gHo.setVisibility(8);
            this.gHt.setVisibility(8);
            this.gHm.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.gGv, R.drawable.addresslist_item_bg);
            ao.setViewTextColor(this.gHj, R.color.CAM_X0111);
            ao.setViewTextColor(this.gGu, R.color.CAM_X0111);
            ao.setViewTextColor(this.aVp, R.color.CAM_X0108);
            ao.setViewTextColor(this.gHn, R.color.CAM_X0108);
            ao.setViewTextColor(this.gGx, R.color.CAM_X0105);
            ao.setViewTextColor(this.gHr, R.color.CAM_X0106);
            ao.setViewTextColor(this.gHs, R.color.CAM_X0111);
            ao.setViewTextColor(this.gHi, R.color.CAM_X0106);
            ao.setBackgroundResource(this.gHA, R.drawable.good_video_label_bg);
            ao.setViewTextColor(this.gHA, R.color.CAM_X0111);
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
        if (gVar != null && gVar.gvQ != null) {
            this.gHx = gVar;
            this.gHk.setVisibility(8);
            this.gHl.setVisibility(0);
            if (this.gHu) {
                int i = this.gGX;
                if (gVar != null && gVar.gvQ != null && gVar.gvQ.bnO() != null && gVar.gvQ.bnO().thumbnail_width != null && gVar.gvQ.bnO().thumbnail_width.intValue() > 0) {
                    i = (this.mViewWidth * gVar.gvQ.bnO().thumbnail_height.intValue()) / gVar.gvQ.bnO().thumbnail_width.intValue();
                }
                ViewGroup.LayoutParams layoutParams = this.gGv.getLayoutParams();
                layoutParams.width = this.mViewWidth;
                layoutParams.height = i;
                this.gGv.setLayoutParams(layoutParams);
            }
            String numberUniformFormatExtra = at.numberUniformFormatExtra(gVar.gvQ.boY());
            this.gGu.setText(numberUniformFormatExtra);
            this.gGw.setVisibility(0);
            this.gGw.setData(gVar.gvQ);
            this.gGw.setIsRound(true);
            this.gGx.setText(gVar.gvQ.getTitle());
            this.gGs.startLoad(gVar.gvQ.bnO().thumbnail_url, 10, false);
            this.aVp.setVisibility(0);
            this.gHy = gVar.gvQ.boQ();
            this.gHn.setText(at.getFormatTime(gVar.gvQ.getCreateTime()));
            if (this.gHy != null) {
                String str = this.gHy.channelName;
                if (ad.getTextLengthWithEmoji(str) > 10) {
                    str = ad.subStringWithEmoji(str, 10) + StringHelper.STRING_MORE;
                }
                this.aVp.setText(str);
                this.gHr.setText(str);
            } else if (gVar.gvQ.bnx() != null && !StringUtils.isNull(gVar.gvQ.bnx().getName_show())) {
                String name_show = gVar.gvQ.bnx().getName_show();
                if (ad.getTextLengthWithEmoji(name_show) > 10) {
                    name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
                }
                this.aVp.setText(name_show);
                this.gHr.setText(name_show);
            }
            this.gHq.setData(gVar.gvQ, false);
            this.gHi.setText(numberUniformFormatExtra);
            this.gHs.setText(gVar.gvQ.getTitle());
            if (gVar.bQv()) {
                this.gHA.setVisibility(0);
            } else {
                this.gHA.setVisibility(8);
            }
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == getView()) {
            if (this.gHz != null) {
                this.gHz.c(this.gHx);
            }
            if (this.gvJ != null) {
                this.gvJ.a(this.gHx, view);
            }
            com.baidu.tieba.ala.alasquare.b.a.bRu().mC(true);
        }
    }

    public void a(b bVar) {
        this.gvJ = bVar;
    }
}
