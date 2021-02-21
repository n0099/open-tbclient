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
    private int gJV;
    private TbImageView gJq;
    private TextView gJs;
    private RelativeLayout gJt;
    private ClickableHeaderImageView gJu;
    private TextView gJv;
    private TextView gKg;
    private TextView gKh;
    private LinearLayout gKi;
    private ImageView gKj;
    private LinearLayout gKk;
    private TextView gKl;
    private RelativeLayout gKm;
    private RelativeLayout gKn;
    private ClickableHeaderImageView gKo;
    private TextView gKp;
    private TextView gKq;
    private View gKr;
    private boolean gKs;
    private com.baidu.tieba.ala.alasquare.a.f gKu;
    private a gyE;
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
        this.gJV = 0;
        initView();
    }

    private void initView() {
        this.gJq = (TbImageView) getView().findViewById(R.id.imgSquareView);
        this.gKh = (TextView) getView().findViewById(R.id.tvSquareTip);
        this.gKi = (LinearLayout) getView().findViewById(R.id.llLiveTipPanel);
        this.gKj = (ImageView) getView().findViewById(R.id.imgLiveCountLabel);
        this.gJs = (TextView) getView().findViewById(R.id.tvLiveCount);
        this.gKk = (LinearLayout) getView().findViewById(R.id.llLiveBottomPanel);
        this.gJt = (RelativeLayout) getView().findViewById(R.id.rlSquareLivePanel);
        this.gJu = (ClickableHeaderImageView) getView().findViewById(R.id.imgUserCover);
        this.aYx = (TextView) getView().findViewById(R.id.tvUserName);
        this.gKl = (TextView) getView().findViewById(R.id.tvCreateTime);
        this.gKm = (RelativeLayout) getView().findViewById(R.id.rlSquareUserInfo);
        this.gJv = (TextView) getView().findViewById(R.id.tvSquareTitle);
        this.gKr = getView().findViewById(R.id.llSquareTitlePanel);
        this.gKn = (RelativeLayout) getView().findViewById(R.id.rlSquareNewUserInfo);
        this.gKo = (ClickableHeaderImageView) getView().findViewById(R.id.imgNewUserCover);
        this.gKp = (TextView) getView().findViewById(R.id.tvNewUserName);
        this.gKg = (TextView) getView().findViewById(R.id.tvNewCount);
        this.gKq = (TextView) getView().findViewById(R.id.tvSquareNewTitle);
        this.gKo.setIsRound(true);
        this.gKg.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(R.drawable.icon_home_card_like_grey), (Drawable) null, (Drawable) null, (Drawable) null);
        this.gJq.setDefaultBgResource(com.baidu.tieba.ala.alasquare.widget.a.bSH());
        this.gJu.setIsRound(true);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gJt.getLayoutParams();
        this.mViewWidth = l.getEquipmentWidth(this.mContext) / 2;
        this.gJV = (this.mViewWidth * 9) / 16;
        layoutParams.width = this.mViewWidth;
        layoutParams.height = this.gJV;
        this.gJt.setLayoutParams(layoutParams);
        this.gJv.setMaxLines(2);
        this.gKj.setImageResource(R.drawable.icon_video_recommend_like);
        getView().setOnClickListener(this);
    }

    public void mO(boolean z) {
        this.gKs = z;
    }

    public void mP(boolean z) {
        this.gKm.setVisibility(z ? 0 : 8);
    }

    public void mQ(boolean z) {
        this.gKn.setVisibility(z ? 0 : 8);
        this.gKq.setVisibility(z ? 0 : 8);
        if (z) {
            this.gKm.setVisibility(8);
            this.gKr.setVisibility(8);
            this.gKk.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gJt, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gKh, R.color.CAM_X0111);
            ap.setViewTextColor(this.gJs, R.color.CAM_X0111);
            ap.setViewTextColor(this.aYx, R.color.CAM_X0108);
            ap.setViewTextColor(this.gKl, R.color.CAM_X0108);
            ap.setViewTextColor(this.gJv, R.color.CAM_X0105);
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
        if (fVar != null && fVar.gyO != null) {
            this.gKu = fVar;
            this.gKi.setVisibility(0);
            this.gKj.setVisibility(0);
            if (this.gKs) {
                int i = this.gJV;
                if (fVar.gyO.boh().thumbnail_width.intValue() > 0) {
                    i = (this.mViewWidth * fVar.gyO.boh().thumbnail_height.intValue()) / fVar.gyO.boh().thumbnail_width.intValue();
                }
                ViewGroup.LayoutParams layoutParams = this.gJt.getLayoutParams();
                layoutParams.width = this.mViewWidth;
                layoutParams.height = i;
                this.gJt.setLayoutParams(layoutParams);
            }
            this.gKh.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_video_direct_seeding_replay, 0, 0, 0);
            this.gKh.setText(this.mContext.getResources().getString(R.string.square_record_tip));
            this.gJq.startLoad(fVar.gyO.boh().thumbnail_url, 10, false);
            String numberUniformFormatExtra = au.numberUniformFormatExtra(fVar.gyO.bpq());
            this.gJs.setText(numberUniformFormatExtra);
            this.gJu.setVisibility(0);
            this.gJu.setData(fVar.gyO);
            this.aYx.setVisibility(0);
            if (fVar.gyO.bnQ() != null && !StringUtils.isNull(fVar.gyO.bnQ().getName_show())) {
                String name_show = fVar.gyO.bnQ().getName_show();
                if (ag.getTextLengthWithEmoji(name_show) > 10) {
                    name_show = ag.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
                }
                this.aYx.setText(name_show);
                this.gKp.setText(name_show);
            }
            this.gKl.setText(au.getFormatTime(fVar.gyO.getCreateTime()));
            this.gJv.setText(fVar.gyO.getTitle());
            this.gKo.setData(fVar.gyO, false);
            this.gKg.setText(numberUniformFormatExtra);
            this.gKq.setText(fVar.gyO.getTitle());
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == getView()) {
            if (this.gyE != null) {
                this.gyE.c(this.gKu);
            }
            com.baidu.tieba.ala.alasquare.b.a.bSe().mG(true);
        }
    }

    public void a(a aVar) {
        this.gyE = aVar;
    }
}
