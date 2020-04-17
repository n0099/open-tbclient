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
    private static final float eRN = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] eRO = {0.0f, 0.0f, 0.0f, 0.0f, eRN, eRN, eRN, eRN};
    private static final float[] eRP = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, eRN, eRN};
    private static final float[] eRQ = {0.0f, 0.0f, 0.0f, 0.0f, eRN, eRN, 0.0f, 0.0f};
    private bj eNM;
    public TbImageView eRH;
    public TextView eRI;
    public RelativeLayout eRJ;
    public TextView eRK;
    public LinearLayout eRL;
    public HeadImageView eRM;
    private String eRS;
    private com.baidu.tieba.ala.alasquare.a.c eRT;
    private AlphaAnimation eRV;
    private o eRd;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private int[] eRR = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean eRU = false;
    private boolean eRW = true;
    private boolean eRX = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (d.this.eRT != null && d.this.eRT.eNM != null && d.this.eRd != null) {
                    d.this.eRd.a(d.this.eRT);
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
        this.eRH = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.eRI = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.eRJ = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.eRK = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.eRL = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.eRM = (HeadImageView) this.mRootView.findViewById(R.id.ivUserAvatar);
        this.eRM.setIsRound(true);
        this.eRM.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.eRH.setBorderSurroundContent(true);
        this.eRH.setDrawBorder(true);
        this.eRH.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eRJ.getLayoutParams();
        layoutParams.width = ((com.baidu.adp.lib.util.l.getEquipmentWidth(tbPageContext.getPageActivity()) - tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12)) - (tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 2;
        layoutParams.height = layoutParams.width;
        this.eRJ.setLayoutParams(layoutParams);
        this.eRV = new AlphaAnimation(0.0f, 1.0f);
        this.eRV.setDuration(200L);
        this.eRV.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                d.this.eRX = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                d.this.eRX = false;
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
        this.eRd = oVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        a(cVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.c cVar, int i) {
        if (cVar == null || cVar.eNM == null || cVar.eNM.aKX() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.eRT = cVar;
        this.eNM = cVar.eNM;
        this.tabId = cVar.tabId;
        this.eRS = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        Object tag = this.eRH.getTag();
        if (this.eRW) {
            this.eRU = true;
            this.eRW = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.eNM.aKX().cover) && !((String) tag).equals(this.eNM.aKX().cover)) {
            this.eRU = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.eNM.aKX().cover) && !this.mCoverUrl.equals(this.eNM.aKX().cover)) {
            this.eRU = true;
        } else {
            this.eRU = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.eRR);
        this.mCoverUrl = this.eNM.aKX().cover;
        this.eRH.setTag(this.mCoverUrl);
        if (cVar.isLeft) {
            this.eRH.setConrers(5);
            gradientDrawable.setCornerRadii(eRP);
            this.eRH.setDefaultBgResource(R.drawable.tab_live_card_round_bg_left);
        } else if (cVar.isRight) {
            this.eRH.setConrers(10);
            gradientDrawable.setCornerRadii(eRQ);
            this.eRH.setDefaultBgResource(R.drawable.tab_live_card_round_bg_right);
        } else if (cVar.eNK) {
            this.eRH.setConrers(15);
            gradientDrawable.setCornerRadii(eRO);
            this.eRH.setDefaultBgResource(R.drawable.tab_live_card_round_bg_only_left);
        }
        this.eRH.setRadius((int) eRN);
        this.eRH.startLoad(this.eNM.aKX().cover, 10, false);
        this.eRL.setBackgroundDrawable(gradientDrawable);
        this.eRH.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && d.this.eRU && !d.this.eRX) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        d.this.eRH.startAnimation(d.this.eRV);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.eRI.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.live_tab_audience_label, aq.ck(this.eNM.aKX().audience_count)));
        if (this.eNM.aKE() != null) {
            String name_show = this.eNM.aKE().getName_show();
            if (!StringUtils.isNull(name_show)) {
                this.eRK.setText(name_show);
            }
            this.eRM.startLoad(this.eNM.aKE().getPortrait(), 12, false);
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.eRI, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eRK, (int) R.color.cp_cont_a);
            if (i == 1) {
                this.eRM.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c_1));
            } else {
                this.eRM.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c));
            }
            Drawable drawable = am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.eRI.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.eRI.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
