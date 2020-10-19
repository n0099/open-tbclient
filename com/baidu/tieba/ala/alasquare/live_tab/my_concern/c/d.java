package com.baidu.tieba.ala.alasquare.live_tab.my_concern.c;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class d {
    private static final float fWg = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] fWh = {0.0f, 0.0f, 0.0f, 0.0f, fWg, fWg, fWg, fWg};
    private static final float[] fWi = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, fWg, fWg};
    private static final float[] fWj = {0.0f, 0.0f, 0.0f, 0.0f, fWg, fWg, 0.0f, 0.0f};
    private bw fRW;
    private o fVw;
    public TbImageView fWa;
    public TextView fWb;
    public RelativeLayout fWc;
    public TextView fWd;
    public LinearLayout fWe;
    public HeadImageView fWf;
    private String fWl;
    private com.baidu.tieba.ala.alasquare.a.c fWm;
    private AlphaAnimation fWo;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private int[] fWk = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean fWn = false;
    private boolean fWp = true;
    private boolean mIsAnimating = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (d.this.fWm != null && d.this.fWm.fRW != null && d.this.fVw != null) {
                    d.this.fVw.a(d.this.fWm);
                    return;
                }
                return;
            }
            com.baidu.adp.lib.util.l.showLongToast(d.this.mTbPageContext.getPageActivity(), d.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        }
    };

    public d(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_sub_live_item_view, (ViewGroup) null, false);
        this.fWa = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.fWb = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.fWc = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.fWd = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.fWe = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.fWf = (HeadImageView) this.mRootView.findViewById(R.id.ivUserAvatar);
        this.fWf.setIsRound(true);
        this.fWf.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.fWa.setBorderSurroundContent(true);
        this.fWa.setDrawBorder(true);
        this.fWa.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fWc.getLayoutParams();
        layoutParams.width = ((com.baidu.adp.lib.util.l.getEquipmentWidth(tbPageContext.getPageActivity()) - tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12)) - (tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 2;
        layoutParams.height = layoutParams.width;
        this.fWc.setLayoutParams(layoutParams);
        this.fWo = new AlphaAnimation(0.0f, 1.0f);
        this.fWo.setDuration(200L);
        this.fWo.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                d.this.mIsAnimating = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                d.this.mIsAnimating = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(o oVar) {
        this.fVw = oVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        a(cVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.c cVar, int i) {
        if (cVar == null || cVar.fRW == null || cVar.fRW.biB() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.fWm = cVar;
        this.fRW = cVar.fRW;
        this.tabId = cVar.tabId;
        this.fWl = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        Object tag = this.fWa.getTag();
        if (this.fWp) {
            this.fWn = true;
            this.fWp = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.fRW.biB().cover) && !((String) tag).equals(this.fRW.biB().cover)) {
            this.fWn = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.fRW.biB().cover) && !this.mCoverUrl.equals(this.fRW.biB().cover)) {
            this.fWn = true;
        } else {
            this.fWn = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.fWk);
        this.mCoverUrl = this.fRW.biB().cover;
        this.fWa.setTag(this.mCoverUrl);
        if (cVar.isLeft) {
            this.fWa.setConrers(5);
            gradientDrawable.setCornerRadii(fWi);
            this.fWa.setDefaultBgResource(R.drawable.tab_live_card_round_bg_left);
        } else if (cVar.isRight) {
            this.fWa.setConrers(10);
            gradientDrawable.setCornerRadii(fWj);
            this.fWa.setDefaultBgResource(R.drawable.tab_live_card_round_bg_right);
        } else if (cVar.fRU) {
            this.fWa.setConrers(15);
            gradientDrawable.setCornerRadii(fWh);
            this.fWa.setDefaultBgResource(R.drawable.tab_live_card_round_bg_only_left);
        }
        this.fWa.setRadius((int) fWg);
        this.fWa.startLoad(this.fRW.biB().cover, 10, false);
        this.fWe.setBackgroundDrawable(gradientDrawable);
        this.fWa.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && d.this.fWn && !d.this.mIsAnimating) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        d.this.fWa.startAnimation(d.this.fWo);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fWb.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.live_tab_audience_label, at.cY(this.fRW.biB().audience_count)));
        if (this.fRW.bih() != null) {
            String name_show = this.fRW.bih().getName_show();
            if (!StringUtils.isNull(name_show)) {
                this.fWd.setText(name_show);
            }
            this.fWf.startLoad(this.fRW.bih().getPortrait(), 12, false);
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.fWb, R.color.cp_cont_a);
            ap.setViewTextColor(this.fWd, R.color.cp_cont_a);
            if (i == 1) {
                this.fWf.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c_1));
            } else {
                this.fWf.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c));
            }
            Drawable drawable = ap.getDrawable(this.mTbPageContext.getResources(), R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.fWb.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.fWb.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
