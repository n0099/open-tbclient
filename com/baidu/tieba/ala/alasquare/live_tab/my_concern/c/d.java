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
    private static final float eiM = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] eiN = {0.0f, 0.0f, 0.0f, 0.0f, eiM, eiM, eiM, eiM};
    private static final float[] eiO = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, eiM, eiM};
    private static final float[] eiP = {0.0f, 0.0f, 0.0f, 0.0f, eiM, eiM, 0.0f, 0.0f};
    private bj eft;
    public TbImageView eiG;
    public TextView eiH;
    public RelativeLayout eiI;
    public TextView eiJ;
    public LinearLayout eiK;
    public HeadImageView eiL;
    private String eiR;
    private com.baidu.tieba.ala.alasquare.a.b eiS;
    private AlphaAnimation eiU;
    private o eic;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private int[] eiQ = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean eiT = false;
    private boolean eiV = true;
    private boolean eiW = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (d.this.eiS != null && d.this.eiS.eft != null && d.this.eic != null) {
                    d.this.eic.a(d.this.eiS);
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
        this.eiG = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.eiH = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.eiI = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.eiJ = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.eiK = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.eiL = (HeadImageView) this.mRootView.findViewById(R.id.ivUserAvatar);
        this.eiL.setIsRound(true);
        this.eiL.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.eiG.setBorderSurroundContent(true);
        this.eiG.setDrawBorder(true);
        this.eiG.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eiI.getLayoutParams();
        layoutParams.width = ((com.baidu.adp.lib.util.l.getEquipmentWidth(tbPageContext.getPageActivity()) - tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12)) - (tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 2;
        layoutParams.height = layoutParams.width;
        this.eiI.setLayoutParams(layoutParams);
        this.eiU = new AlphaAnimation(0.0f, 1.0f);
        this.eiU.setDuration(200L);
        this.eiU.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                d.this.eiW = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                d.this.eiW = false;
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
        this.eic = oVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.b bVar) {
        a(bVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.b bVar, int i) {
        if (bVar == null || bVar.eft == null || bVar.eft.azX() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.eiS = bVar;
        this.eft = bVar.eft;
        this.tabId = bVar.tabId;
        this.eiR = !TextUtils.isEmpty(bVar.labelName) ? bVar.labelName : bVar.entryName;
        Object tag = this.eiG.getTag();
        if (this.eiV) {
            this.eiT = true;
            this.eiV = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.eft.azX().cover) && !((String) tag).equals(this.eft.azX().cover)) {
            this.eiT = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.eft.azX().cover) && !this.mCoverUrl.equals(this.eft.azX().cover)) {
            this.eiT = true;
        } else {
            this.eiT = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.eiQ);
        this.mCoverUrl = this.eft.azX().cover;
        this.eiG.setTag(this.mCoverUrl);
        if (bVar.isLeft) {
            this.eiG.setConrers(5);
            gradientDrawable.setCornerRadii(eiO);
            this.eiG.setDefaultBgResource(R.drawable.tab_live_card_round_bg_left);
        } else if (bVar.isRight) {
            this.eiG.setConrers(10);
            gradientDrawable.setCornerRadii(eiP);
            this.eiG.setDefaultBgResource(R.drawable.tab_live_card_round_bg_right);
        } else if (bVar.efw) {
            this.eiG.setConrers(15);
            gradientDrawable.setCornerRadii(eiN);
            this.eiG.setDefaultBgResource(R.drawable.tab_live_card_round_bg_only_left);
        }
        this.eiG.setRadius((int) eiM);
        this.eiG.startLoad(this.eft.azX().cover, 10, false);
        this.eiK.setBackgroundDrawable(gradientDrawable);
        this.eiG.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && d.this.eiT && !d.this.eiW) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        d.this.eiG.startAnimation(d.this.eiU);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.eiH.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.live_tab_audience_label, aq.bx(this.eft.azX().audience_count)));
        if (this.eft.azE() != null) {
            String name_show = this.eft.azE().getName_show();
            if (!StringUtils.isNull(name_show)) {
                this.eiJ.setText(name_show);
            }
            this.eiL.startLoad(this.eft.azE().getPortrait(), 12, false);
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.eiH, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eiJ, (int) R.color.cp_cont_a);
            if (i == 1) {
                this.eiL.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c_1));
            } else {
                this.eiL.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c));
            }
            Drawable drawable = am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.eiH.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.eiH.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
