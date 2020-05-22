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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class d {
    private static final float feA = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] feB = {0.0f, 0.0f, 0.0f, 0.0f, feA, feA, feA, feA};
    private static final float[] feC = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, feA, feA};
    private static final float[] feD = {0.0f, 0.0f, 0.0f, 0.0f, feA, feA, 0.0f, 0.0f};
    private bk fay;
    private o fdQ;
    private String feF;
    private com.baidu.tieba.ala.alasquare.a.c feG;
    private AlphaAnimation feI;
    public TbImageView feu;
    public TextView fev;
    public RelativeLayout few;
    public TextView fex;
    public LinearLayout fey;
    public HeadImageView fez;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private int[] feE = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean feH = false;
    private boolean feJ = true;
    private boolean feK = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (d.this.feG != null && d.this.feG.fay != null && d.this.fdQ != null) {
                    d.this.fdQ.a(d.this.feG);
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
        this.feu = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.fev = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.few = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.fex = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.fey = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.fez = (HeadImageView) this.mRootView.findViewById(R.id.ivUserAvatar);
        this.fez.setIsRound(true);
        this.fez.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.feu.setBorderSurroundContent(true);
        this.feu.setDrawBorder(true);
        this.feu.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.few.getLayoutParams();
        layoutParams.width = ((com.baidu.adp.lib.util.l.getEquipmentWidth(tbPageContext.getPageActivity()) - tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12)) - (tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 2;
        layoutParams.height = layoutParams.width;
        this.few.setLayoutParams(layoutParams);
        this.feI = new AlphaAnimation(0.0f, 1.0f);
        this.feI.setDuration(200L);
        this.feI.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                d.this.feK = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                d.this.feK = false;
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
        this.fdQ = oVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        a(cVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.c cVar, int i) {
        if (cVar == null || cVar.fay == null || cVar.fay.aQS() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.feG = cVar;
        this.fay = cVar.fay;
        this.tabId = cVar.tabId;
        this.feF = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        Object tag = this.feu.getTag();
        if (this.feJ) {
            this.feH = true;
            this.feJ = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.fay.aQS().cover) && !((String) tag).equals(this.fay.aQS().cover)) {
            this.feH = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.fay.aQS().cover) && !this.mCoverUrl.equals(this.fay.aQS().cover)) {
            this.feH = true;
        } else {
            this.feH = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.feE);
        this.mCoverUrl = this.fay.aQS().cover;
        this.feu.setTag(this.mCoverUrl);
        if (cVar.isLeft) {
            this.feu.setConrers(5);
            gradientDrawable.setCornerRadii(feC);
            this.feu.setDefaultBgResource(R.drawable.tab_live_card_round_bg_left);
        } else if (cVar.isRight) {
            this.feu.setConrers(10);
            gradientDrawable.setCornerRadii(feD);
            this.feu.setDefaultBgResource(R.drawable.tab_live_card_round_bg_right);
        } else if (cVar.faw) {
            this.feu.setConrers(15);
            gradientDrawable.setCornerRadii(feB);
            this.feu.setDefaultBgResource(R.drawable.tab_live_card_round_bg_only_left);
        }
        this.feu.setRadius((int) feA);
        this.feu.startLoad(this.fay.aQS().cover, 10, false);
        this.fey.setBackgroundDrawable(gradientDrawable);
        this.feu.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && d.this.feH && !d.this.feK) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        d.this.feu.startAnimation(d.this.feI);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fev.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.live_tab_audience_label, aq.cl(this.fay.aQS().audience_count)));
        if (this.fay.aQx() != null) {
            String name_show = this.fay.aQx().getName_show();
            if (!StringUtils.isNull(name_show)) {
                this.fex.setText(name_show);
            }
            this.fez.startLoad(this.fay.aQx().getPortrait(), 12, false);
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.fev, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.fex, (int) R.color.cp_cont_a);
            if (i == 1) {
                this.fez.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c_1));
            } else {
                this.fez.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c));
            }
            Drawable drawable = am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.fev.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.fev.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
