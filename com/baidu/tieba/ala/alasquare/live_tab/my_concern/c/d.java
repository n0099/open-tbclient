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
    private static final float glY = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] glZ = {0.0f, 0.0f, 0.0f, 0.0f, glY, glY, glY, glY};
    private static final float[] gma = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, glY, glY};
    private static final float[] gmb = {0.0f, 0.0f, 0.0f, 0.0f, glY, glY, 0.0f, 0.0f};
    public TextView bxh;
    private bw ghO;
    public TbImageView glT;
    public TextView glU;
    public RelativeLayout glV;
    public LinearLayout glW;
    public HeadImageView glX;
    private o glp;
    private String gmd;
    private com.baidu.tieba.ala.alasquare.a.c gme;
    private AlphaAnimation gmg;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private int[] gmc = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean gmf = false;
    private boolean gmh = true;
    private boolean mIsAnimating = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (d.this.gme != null && d.this.gme.ghO != null && d.this.glp != null) {
                    d.this.glp.a(d.this.gme);
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
        this.glT = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.glU = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.glV = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.bxh = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.glW = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.glX = (HeadImageView) this.mRootView.findViewById(R.id.ivUserAvatar);
        this.glX.setIsRound(true);
        this.glX.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.glT.setBorderSurroundContent(true);
        this.glT.setDrawBorder(true);
        this.glT.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.glV.getLayoutParams();
        layoutParams.width = ((com.baidu.adp.lib.util.l.getEquipmentWidth(tbPageContext.getPageActivity()) - tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12)) - (tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 2;
        layoutParams.height = layoutParams.width;
        this.glV.setLayoutParams(layoutParams);
        this.gmg = new AlphaAnimation(0.0f, 1.0f);
        this.gmg.setDuration(200L);
        this.gmg.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.1
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
        this.glp = oVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        a(cVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.c cVar, int i) {
        if (cVar == null || cVar.ghO == null || cVar.ghO.bmU() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gme = cVar;
        this.ghO = cVar.ghO;
        this.tabId = cVar.tabId;
        this.gmd = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        Object tag = this.glT.getTag();
        if (this.gmh) {
            this.gmf = true;
            this.gmh = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.ghO.bmU().cover) && !((String) tag).equals(this.ghO.bmU().cover)) {
            this.gmf = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.ghO.bmU().cover) && !this.mCoverUrl.equals(this.ghO.bmU().cover)) {
            this.gmf = true;
        } else {
            this.gmf = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.gmc);
        this.mCoverUrl = this.ghO.bmU().cover;
        this.glT.setTag(this.mCoverUrl);
        if (cVar.isLeft) {
            this.glT.setConrers(5);
            gradientDrawable.setCornerRadii(gma);
            this.glT.setDefaultBgResource(R.drawable.tab_live_card_round_bg_left);
        } else if (cVar.isRight) {
            this.glT.setConrers(10);
            gradientDrawable.setCornerRadii(gmb);
            this.glT.setDefaultBgResource(R.drawable.tab_live_card_round_bg_right);
        } else if (cVar.ghM) {
            this.glT.setConrers(15);
            gradientDrawable.setCornerRadii(glZ);
            this.glT.setDefaultBgResource(R.drawable.tab_live_card_round_bg_only_left);
        }
        this.glT.setRadius((int) glY);
        this.glT.startLoad(this.ghO.bmU().cover, 10, false);
        this.glW.setBackgroundDrawable(gradientDrawable);
        this.glT.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && d.this.gmf && !d.this.mIsAnimating) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        d.this.glT.startAnimation(d.this.gmg);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.glU.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.live_tab_audience_label, at.dw(this.ghO.bmU().audience_count)));
        if (this.ghO.bmA() != null) {
            String name_show = this.ghO.bmA().getName_show();
            if (!StringUtils.isNull(name_show)) {
                this.bxh.setText(name_show);
            }
            this.glX.startLoad(this.ghO.bmA().getPortrait(), 12, false);
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.glU, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.bxh, (int) R.color.cp_cont_a);
            if (i == 1) {
                this.glX.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c_1));
            } else {
                this.glX.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c));
            }
            Drawable drawable = ap.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.glU.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.glU.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
