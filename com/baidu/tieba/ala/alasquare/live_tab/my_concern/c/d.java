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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class d {
    private static final float dxK = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] dxL = {0.0f, 0.0f, 0.0f, 0.0f, dxK, dxK, dxK, dxK};
    private static final float[] dxM = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, dxK, dxK};
    private static final float[] dxN = {0.0f, 0.0f, 0.0f, 0.0f, dxK, dxK, 0.0f, 0.0f};
    private bh dur;
    public TbImageView dxE;
    public TextView dxF;
    public RelativeLayout dxG;
    public TextView dxH;
    public LinearLayout dxI;
    public HeadImageView dxJ;
    private String dxP;
    private com.baidu.tieba.ala.alasquare.a.b dxQ;
    private AlphaAnimation dxS;
    private o dxa;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private int[] dxO = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean dxR = false;
    private boolean dxT = true;
    private boolean dxU = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (d.this.dxQ != null && d.this.dxQ.dur != null && d.this.dxa != null) {
                    d.this.dxa.a(d.this.dxQ);
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
        this.dxE = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.dxF = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.dxG = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.dxH = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.dxI = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.dxJ = (HeadImageView) this.mRootView.findViewById(R.id.ivUserAvatar);
        this.dxJ.setIsRound(true);
        this.dxJ.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.dxE.setBorderSurroundContent(true);
        this.dxE.setDrawBorder(true);
        this.dxE.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dxG.getLayoutParams();
        layoutParams.width = ((com.baidu.adp.lib.util.l.getEquipmentWidth(tbPageContext.getPageActivity()) - tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12)) - (tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 2;
        layoutParams.height = layoutParams.width;
        this.dxG.setLayoutParams(layoutParams);
        this.dxS = new AlphaAnimation(0.0f, 1.0f);
        this.dxS.setDuration(200L);
        this.dxS.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                d.this.dxU = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                d.this.dxU = false;
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
        this.dxa = oVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.b bVar) {
        a(bVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.b bVar, int i) {
        if (bVar == null || bVar.dur == null || bVar.dur.aiX() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.dxQ = bVar;
        this.dur = bVar.dur;
        this.tabId = bVar.tabId;
        this.dxP = !TextUtils.isEmpty(bVar.labelName) ? bVar.labelName : bVar.entryName;
        Object tag = this.dxE.getTag();
        if (this.dxT) {
            this.dxR = true;
            this.dxT = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.dur.aiX().cover) && !((String) tag).equals(this.dur.aiX().cover)) {
            this.dxR = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.dur.aiX().cover) && !this.mCoverUrl.equals(this.dur.aiX().cover)) {
            this.dxR = true;
        } else {
            this.dxR = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.dxO);
        this.mCoverUrl = this.dur.aiX().cover;
        this.dxE.setTag(this.mCoverUrl);
        if (bVar.isLeft) {
            this.dxE.setConrers(5);
            gradientDrawable.setCornerRadii(dxM);
            this.dxE.setDefaultBgResource(R.drawable.tab_live_card_round_bg_left);
        } else if (bVar.isRight) {
            this.dxE.setConrers(10);
            gradientDrawable.setCornerRadii(dxN);
            this.dxE.setDefaultBgResource(R.drawable.tab_live_card_round_bg_right);
        } else if (bVar.duu) {
            this.dxE.setConrers(15);
            gradientDrawable.setCornerRadii(dxL);
            this.dxE.setDefaultBgResource(R.drawable.tab_live_card_round_bg_only_left);
        }
        this.dxE.setRadius((int) dxK);
        this.dxE.startLoad(this.dur.aiX().cover, 10, false);
        this.dxI.setBackgroundDrawable(gradientDrawable);
        this.dxE.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && d.this.dxR && !d.this.dxU) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        d.this.dxE.startAnimation(d.this.dxS);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.dxF.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.live_tab_audience_label, aq.aS(this.dur.aiX().audience_count)));
        if (this.dur.aiE() != null) {
            String name_show = this.dur.aiE().getName_show();
            if (!StringUtils.isNull(name_show)) {
                this.dxH.setText(name_show);
            }
            this.dxJ.startLoad(this.dur.aiE().getPortrait(), 12, false);
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.dxF, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dxH, (int) R.color.cp_cont_a);
            if (i == 1) {
                this.dxJ.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c_1));
            } else {
                this.dxJ.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c));
            }
            Drawable drawable = am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.dxF.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.dxF.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
