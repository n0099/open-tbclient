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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class d {
    private static final float enL = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] enM = {0.0f, 0.0f, 0.0f, 0.0f, enL, enL, enL, enL};
    private static final float[] enN = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, enL, enL};
    private static final float[] enO = {0.0f, 0.0f, 0.0f, 0.0f, enL, enL, 0.0f, 0.0f};
    private bj ejJ;
    private o emZ;
    public TbImageView enF;
    public TextView enG;
    public RelativeLayout enH;
    public TextView enI;
    public LinearLayout enJ;
    public HeadImageView enK;
    private String enQ;
    private com.baidu.tieba.ala.alasquare.a.c enR;
    private AlphaAnimation enT;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private int[] enP = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean enS = false;
    private boolean enU = true;
    private boolean enV = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (d.this.enR != null && d.this.enR.ejJ != null && d.this.emZ != null) {
                    d.this.emZ.a(d.this.enR);
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
        this.enF = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.enG = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.enH = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.enI = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.enJ = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.enK = (HeadImageView) this.mRootView.findViewById(R.id.ivUserAvatar);
        this.enK.setIsRound(true);
        this.enK.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.enF.setBorderSurroundContent(true);
        this.enF.setDrawBorder(true);
        this.enF.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.enH.getLayoutParams();
        layoutParams.width = ((com.baidu.adp.lib.util.l.getEquipmentWidth(tbPageContext.getPageActivity()) - tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12)) - (tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 2;
        layoutParams.height = layoutParams.width;
        this.enH.setLayoutParams(layoutParams);
        this.enT = new AlphaAnimation(0.0f, 1.0f);
        this.enT.setDuration(200L);
        this.enT.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                d.this.enV = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                d.this.enV = false;
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
        this.emZ = oVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        a(cVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.c cVar, int i) {
        if (cVar == null || cVar.ejJ == null || cVar.ejJ.aCH() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.enR = cVar;
        this.ejJ = cVar.ejJ;
        this.tabId = cVar.tabId;
        this.enQ = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        Object tag = this.enF.getTag();
        if (this.enU) {
            this.enS = true;
            this.enU = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.ejJ.aCH().cover) && !((String) tag).equals(this.ejJ.aCH().cover)) {
            this.enS = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.ejJ.aCH().cover) && !this.mCoverUrl.equals(this.ejJ.aCH().cover)) {
            this.enS = true;
        } else {
            this.enS = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.enP);
        this.mCoverUrl = this.ejJ.aCH().cover;
        this.enF.setTag(this.mCoverUrl);
        if (cVar.isLeft) {
            this.enF.setConrers(5);
            gradientDrawable.setCornerRadii(enN);
            this.enF.setDefaultBgResource(R.drawable.tab_live_card_round_bg_left);
        } else if (cVar.isRight) {
            this.enF.setConrers(10);
            gradientDrawable.setCornerRadii(enO);
            this.enF.setDefaultBgResource(R.drawable.tab_live_card_round_bg_right);
        } else if (cVar.ejH) {
            this.enF.setConrers(15);
            gradientDrawable.setCornerRadii(enM);
            this.enF.setDefaultBgResource(R.drawable.tab_live_card_round_bg_only_left);
        }
        this.enF.setRadius((int) enL);
        this.enF.startLoad(this.ejJ.aCH().cover, 10, false);
        this.enJ.setBackgroundDrawable(gradientDrawable);
        this.enF.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && d.this.enS && !d.this.enV) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        d.this.enF.startAnimation(d.this.enT);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.enG.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.live_tab_audience_label, aq.bE(this.ejJ.aCH().audience_count)));
        if (this.ejJ.aCo() != null) {
            String name_show = this.ejJ.aCo().getName_show();
            if (!StringUtils.isNull(name_show)) {
                this.enI.setText(name_show);
            }
            this.enK.startLoad(this.ejJ.aCo().getPortrait(), 12, false);
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.enG, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.enI, (int) R.color.cp_cont_a);
            if (i == 1) {
                this.enK.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c_1));
            } else {
                this.enK.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c));
            }
            Drawable drawable = am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.enG.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.enG.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
