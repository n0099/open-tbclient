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
    private static final float fGD = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] fGE = {0.0f, 0.0f, 0.0f, 0.0f, fGD, fGD, fGD, fGD};
    private static final float[] fGF = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, fGD, fGD};
    private static final float[] fGG = {0.0f, 0.0f, 0.0f, 0.0f, fGD, fGD, 0.0f, 0.0f};
    private bw fCB;
    private o fFT;
    public TextView fGA;
    public LinearLayout fGB;
    public HeadImageView fGC;
    private String fGI;
    private com.baidu.tieba.ala.alasquare.a.c fGJ;
    private AlphaAnimation fGL;
    public TbImageView fGx;
    public TextView fGy;
    public RelativeLayout fGz;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private int[] fGH = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean fGK = false;
    private boolean fGM = true;
    private boolean mIsAnimating = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (d.this.fGJ != null && d.this.fGJ.fCB != null && d.this.fFT != null) {
                    d.this.fFT.a(d.this.fGJ);
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
        this.fGx = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.fGy = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.fGz = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.fGA = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.fGB = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.fGC = (HeadImageView) this.mRootView.findViewById(R.id.ivUserAvatar);
        this.fGC.setIsRound(true);
        this.fGC.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.fGx.setBorderSurroundContent(true);
        this.fGx.setDrawBorder(true);
        this.fGx.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fGz.getLayoutParams();
        layoutParams.width = ((com.baidu.adp.lib.util.l.getEquipmentWidth(tbPageContext.getPageActivity()) - tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12)) - (tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 2;
        layoutParams.height = layoutParams.width;
        this.fGz.setLayoutParams(layoutParams);
        this.fGL = new AlphaAnimation(0.0f, 1.0f);
        this.fGL.setDuration(200L);
        this.fGL.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.1
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
        this.fFT = oVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        a(cVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.c cVar, int i) {
        if (cVar == null || cVar.fCB == null || cVar.fCB.beY() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.fGJ = cVar;
        this.fCB = cVar.fCB;
        this.tabId = cVar.tabId;
        this.fGI = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        Object tag = this.fGx.getTag();
        if (this.fGM) {
            this.fGK = true;
            this.fGM = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.fCB.beY().cover) && !((String) tag).equals(this.fCB.beY().cover)) {
            this.fGK = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.fCB.beY().cover) && !this.mCoverUrl.equals(this.fCB.beY().cover)) {
            this.fGK = true;
        } else {
            this.fGK = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.fGH);
        this.mCoverUrl = this.fCB.beY().cover;
        this.fGx.setTag(this.mCoverUrl);
        if (cVar.isLeft) {
            this.fGx.setConrers(5);
            gradientDrawable.setCornerRadii(fGF);
            this.fGx.setDefaultBgResource(R.drawable.tab_live_card_round_bg_left);
        } else if (cVar.isRight) {
            this.fGx.setConrers(10);
            gradientDrawable.setCornerRadii(fGG);
            this.fGx.setDefaultBgResource(R.drawable.tab_live_card_round_bg_right);
        } else if (cVar.fCz) {
            this.fGx.setConrers(15);
            gradientDrawable.setCornerRadii(fGE);
            this.fGx.setDefaultBgResource(R.drawable.tab_live_card_round_bg_only_left);
        }
        this.fGx.setRadius((int) fGD);
        this.fGx.startLoad(this.fCB.beY().cover, 10, false);
        this.fGB.setBackgroundDrawable(gradientDrawable);
        this.fGx.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && d.this.fGK && !d.this.mIsAnimating) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        d.this.fGx.startAnimation(d.this.fGL);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fGy.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.live_tab_audience_label, at.cP(this.fCB.beY().audience_count)));
        if (this.fCB.beE() != null) {
            String name_show = this.fCB.beE().getName_show();
            if (!StringUtils.isNull(name_show)) {
                this.fGA.setText(name_show);
            }
            this.fGC.startLoad(this.fCB.beE().getPortrait(), 12, false);
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.fGy, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.fGA, (int) R.color.cp_cont_a);
            if (i == 1) {
                this.fGC.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c_1));
            } else {
                this.fGC.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c));
            }
            Drawable drawable = ap.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.fGy.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.fGy.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
