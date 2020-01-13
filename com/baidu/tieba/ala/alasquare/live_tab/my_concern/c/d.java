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
/* loaded from: classes2.dex */
public class d {
    private static final float ejA = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] ejB = {0.0f, 0.0f, 0.0f, 0.0f, ejA, ejA, ejA, ejA};
    private static final float[] ejC = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, ejA, ejA};
    private static final float[] ejD = {0.0f, 0.0f, 0.0f, 0.0f, ejA, ejA, 0.0f, 0.0f};
    private bj efE;
    private o eiQ;
    private String ejF;
    private com.baidu.tieba.ala.alasquare.a.c ejG;
    private AlphaAnimation ejI;
    public TbImageView eju;
    public TextView ejv;
    public RelativeLayout ejw;
    public TextView ejx;
    public LinearLayout ejy;
    public HeadImageView ejz;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private int[] ejE = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean ejH = false;
    private boolean ejJ = true;
    private boolean ejK = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (d.this.ejG != null && d.this.ejG.efE != null && d.this.eiQ != null) {
                    d.this.eiQ.a(d.this.ejG);
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
        this.eju = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.ejv = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.ejw = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.ejx = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.ejy = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.ejz = (HeadImageView) this.mRootView.findViewById(R.id.ivUserAvatar);
        this.ejz.setIsRound(true);
        this.ejz.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.eju.setBorderSurroundContent(true);
        this.eju.setDrawBorder(true);
        this.eju.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ejw.getLayoutParams();
        layoutParams.width = ((com.baidu.adp.lib.util.l.getEquipmentWidth(tbPageContext.getPageActivity()) - tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12)) - (tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 2;
        layoutParams.height = layoutParams.width;
        this.ejw.setLayoutParams(layoutParams);
        this.ejI = new AlphaAnimation(0.0f, 1.0f);
        this.ejI.setDuration(200L);
        this.ejI.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                d.this.ejK = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                d.this.ejK = false;
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
        this.eiQ = oVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        a(cVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.c cVar, int i) {
        if (cVar == null || cVar.efE == null || cVar.efE.aAq() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.ejG = cVar;
        this.efE = cVar.efE;
        this.tabId = cVar.tabId;
        this.ejF = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        Object tag = this.eju.getTag();
        if (this.ejJ) {
            this.ejH = true;
            this.ejJ = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.efE.aAq().cover) && !((String) tag).equals(this.efE.aAq().cover)) {
            this.ejH = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.efE.aAq().cover) && !this.mCoverUrl.equals(this.efE.aAq().cover)) {
            this.ejH = true;
        } else {
            this.ejH = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.ejE);
        this.mCoverUrl = this.efE.aAq().cover;
        this.eju.setTag(this.mCoverUrl);
        if (cVar.isLeft) {
            this.eju.setConrers(5);
            gradientDrawable.setCornerRadii(ejC);
            this.eju.setDefaultBgResource(R.drawable.tab_live_card_round_bg_left);
        } else if (cVar.isRight) {
            this.eju.setConrers(10);
            gradientDrawable.setCornerRadii(ejD);
            this.eju.setDefaultBgResource(R.drawable.tab_live_card_round_bg_right);
        } else if (cVar.efC) {
            this.eju.setConrers(15);
            gradientDrawable.setCornerRadii(ejB);
            this.eju.setDefaultBgResource(R.drawable.tab_live_card_round_bg_only_left);
        }
        this.eju.setRadius((int) ejA);
        this.eju.startLoad(this.efE.aAq().cover, 10, false);
        this.ejy.setBackgroundDrawable(gradientDrawable);
        this.eju.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && d.this.ejH && !d.this.ejK) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        d.this.eju.startAnimation(d.this.ejI);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.ejv.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.live_tab_audience_label, aq.bA(this.efE.aAq().audience_count)));
        if (this.efE.azX() != null) {
            String name_show = this.efE.azX().getName_show();
            if (!StringUtils.isNull(name_show)) {
                this.ejx.setText(name_show);
            }
            this.ejz.startLoad(this.efE.azX().getPortrait(), 12, false);
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.ejv, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.ejx, (int) R.color.cp_cont_a);
            if (i == 1) {
                this.ejz.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c_1));
            } else {
                this.ejz.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c));
            }
            Drawable drawable = am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.ejv.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.ejv.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
