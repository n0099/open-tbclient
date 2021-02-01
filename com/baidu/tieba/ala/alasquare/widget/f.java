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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class f extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.a.f> {
    private TextView aYx;
    private int gJH;
    private TextView gJS;
    private TextView gJT;
    private LinearLayout gJU;
    private ImageView gJV;
    private LinearLayout gJW;
    private TextView gJX;
    private RelativeLayout gJY;
    private RelativeLayout gJZ;
    private TbImageView gJc;
    private TextView gJe;
    private RelativeLayout gJf;
    private ClickableHeaderImageView gJg;
    private TextView gJh;
    private ClickableHeaderImageView gKa;
    private TextView gKb;
    private TextView gKc;
    private View gKd;
    private boolean gKe;
    private com.baidu.tieba.ala.alasquare.a.f gKg;
    private a gyq;
    public int mSkinType;
    private int mViewWidth;

    /* loaded from: classes10.dex */
    public interface a {
        void c(com.baidu.tieba.ala.alasquare.a.f fVar);
    }

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mViewWidth = 0;
        this.gJH = 0;
        initView();
    }

    private void initView() {
        this.gJc = (TbImageView) getView().findViewById(R.id.imgSquareView);
        this.gJT = (TextView) getView().findViewById(R.id.tvSquareTip);
        this.gJU = (LinearLayout) getView().findViewById(R.id.llLiveTipPanel);
        this.gJV = (ImageView) getView().findViewById(R.id.imgLiveCountLabel);
        this.gJe = (TextView) getView().findViewById(R.id.tvLiveCount);
        this.gJW = (LinearLayout) getView().findViewById(R.id.llLiveBottomPanel);
        this.gJf = (RelativeLayout) getView().findViewById(R.id.rlSquareLivePanel);
        this.gJg = (ClickableHeaderImageView) getView().findViewById(R.id.imgUserCover);
        this.aYx = (TextView) getView().findViewById(R.id.tvUserName);
        this.gJX = (TextView) getView().findViewById(R.id.tvCreateTime);
        this.gJY = (RelativeLayout) getView().findViewById(R.id.rlSquareUserInfo);
        this.gJh = (TextView) getView().findViewById(R.id.tvSquareTitle);
        this.gKd = getView().findViewById(R.id.llSquareTitlePanel);
        this.gJZ = (RelativeLayout) getView().findViewById(R.id.rlSquareNewUserInfo);
        this.gKa = (ClickableHeaderImageView) getView().findViewById(R.id.imgNewUserCover);
        this.gKb = (TextView) getView().findViewById(R.id.tvNewUserName);
        this.gJS = (TextView) getView().findViewById(R.id.tvNewCount);
        this.gKc = (TextView) getView().findViewById(R.id.tvSquareNewTitle);
        this.gKa.setIsRound(true);
        this.gJS.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(R.drawable.icon_home_card_like_grey), (Drawable) null, (Drawable) null, (Drawable) null);
        this.gJc.setDefaultBgResource(com.baidu.tieba.ala.alasquare.widget.a.bSA());
        this.gJg.setIsRound(true);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gJf.getLayoutParams();
        this.mViewWidth = l.getEquipmentWidth(this.mContext) / 2;
        this.gJH = (this.mViewWidth * 9) / 16;
        layoutParams.width = this.mViewWidth;
        layoutParams.height = this.gJH;
        this.gJf.setLayoutParams(layoutParams);
        this.gJh.setMaxLines(2);
        this.gJV.setImageResource(R.drawable.icon_video_recommend_like);
        getView().setOnClickListener(this);
    }

    public void mO(boolean z) {
        this.gKe = z;
    }

    public void mP(boolean z) {
        this.gJY.setVisibility(z ? 0 : 8);
    }

    public void mQ(boolean z) {
        this.gJZ.setVisibility(z ? 0 : 8);
        this.gKc.setVisibility(z ? 0 : 8);
        if (z) {
            this.gJY.setVisibility(8);
            this.gKd.setVisibility(8);
            this.gJW.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gJf, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gJT, R.color.CAM_X0111);
            ap.setViewTextColor(this.gJe, R.color.CAM_X0111);
            ap.setViewTextColor(this.aYx, R.color.CAM_X0108);
            ap.setViewTextColor(this.gJX, R.color.CAM_X0108);
            ap.setViewTextColor(this.gJh, R.color.CAM_X0105);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.square_record_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    /* renamed from: b */
    public void a(com.baidu.tieba.ala.alasquare.a.f fVar) {
        if (fVar != null && fVar.gyA != null) {
            this.gKg = fVar;
            this.gJU.setVisibility(0);
            this.gJV.setVisibility(0);
            if (this.gKe) {
                int i = this.gJH;
                if (fVar.gyA.boh().thumbnail_width.intValue() > 0) {
                    i = (this.mViewWidth * fVar.gyA.boh().thumbnail_height.intValue()) / fVar.gyA.boh().thumbnail_width.intValue();
                }
                ViewGroup.LayoutParams layoutParams = this.gJf.getLayoutParams();
                layoutParams.width = this.mViewWidth;
                layoutParams.height = i;
                this.gJf.setLayoutParams(layoutParams);
            }
            this.gJT.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_video_direct_seeding_replay, 0, 0, 0);
            this.gJT.setText(this.mContext.getResources().getString(R.string.square_record_tip));
            this.gJc.startLoad(fVar.gyA.boh().thumbnail_url, 10, false);
            String numberUniformFormatExtra = au.numberUniformFormatExtra(fVar.gyA.bpq());
            this.gJe.setText(numberUniformFormatExtra);
            this.gJg.setVisibility(0);
            this.gJg.setData(fVar.gyA);
            this.aYx.setVisibility(0);
            if (fVar.gyA.bnQ() != null && !StringUtils.isNull(fVar.gyA.bnQ().getName_show())) {
                String name_show = fVar.gyA.bnQ().getName_show();
                if (ag.getTextLengthWithEmoji(name_show) > 10) {
                    name_show = ag.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
                }
                this.aYx.setText(name_show);
                this.gKb.setText(name_show);
            }
            this.gJX.setText(au.getFormatTime(fVar.gyA.getCreateTime()));
            this.gJh.setText(fVar.gyA.getTitle());
            this.gKa.setData(fVar.gyA, false);
            this.gJS.setText(numberUniformFormatExtra);
            this.gKc.setText(fVar.gyA.getTitle());
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == getView()) {
            if (this.gyq != null) {
                this.gyq.c(this.gKg);
            }
            com.baidu.tieba.ala.alasquare.b.a.bRX().mG(true);
        }
    }

    public void a(a aVar) {
        this.gyq = aVar;
    }
}
