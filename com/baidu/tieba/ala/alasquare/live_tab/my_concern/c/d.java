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
    private static final float eRS = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] eRT = {0.0f, 0.0f, 0.0f, 0.0f, eRS, eRS, eRS, eRS};
    private static final float[] eRU = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, eRS, eRS};
    private static final float[] eRV = {0.0f, 0.0f, 0.0f, 0.0f, eRS, eRS, 0.0f, 0.0f};
    private bj eNR;
    public TbImageView eRM;
    public TextView eRN;
    public RelativeLayout eRO;
    public TextView eRP;
    public LinearLayout eRQ;
    public HeadImageView eRR;
    private String eRX;
    private com.baidu.tieba.ala.alasquare.a.c eRY;
    private o eRi;
    private AlphaAnimation eSa;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private int[] eRW = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean eRZ = false;
    private boolean eSb = true;
    private boolean eSc = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (d.this.eRY != null && d.this.eRY.eNR != null && d.this.eRi != null) {
                    d.this.eRi.a(d.this.eRY);
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
        this.eRM = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.eRN = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.eRO = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.eRP = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.eRQ = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.eRR = (HeadImageView) this.mRootView.findViewById(R.id.ivUserAvatar);
        this.eRR.setIsRound(true);
        this.eRR.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.eRM.setBorderSurroundContent(true);
        this.eRM.setDrawBorder(true);
        this.eRM.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eRO.getLayoutParams();
        layoutParams.width = ((com.baidu.adp.lib.util.l.getEquipmentWidth(tbPageContext.getPageActivity()) - tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12)) - (tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 2;
        layoutParams.height = layoutParams.width;
        this.eRO.setLayoutParams(layoutParams);
        this.eSa = new AlphaAnimation(0.0f, 1.0f);
        this.eSa.setDuration(200L);
        this.eSa.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                d.this.eSc = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                d.this.eSc = false;
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
        this.eRi = oVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        a(cVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.c cVar, int i) {
        if (cVar == null || cVar.eNR == null || cVar.eNR.aKV() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.eRY = cVar;
        this.eNR = cVar.eNR;
        this.tabId = cVar.tabId;
        this.eRX = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        Object tag = this.eRM.getTag();
        if (this.eSb) {
            this.eRZ = true;
            this.eSb = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.eNR.aKV().cover) && !((String) tag).equals(this.eNR.aKV().cover)) {
            this.eRZ = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.eNR.aKV().cover) && !this.mCoverUrl.equals(this.eNR.aKV().cover)) {
            this.eRZ = true;
        } else {
            this.eRZ = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.eRW);
        this.mCoverUrl = this.eNR.aKV().cover;
        this.eRM.setTag(this.mCoverUrl);
        if (cVar.isLeft) {
            this.eRM.setConrers(5);
            gradientDrawable.setCornerRadii(eRU);
            this.eRM.setDefaultBgResource(R.drawable.tab_live_card_round_bg_left);
        } else if (cVar.isRight) {
            this.eRM.setConrers(10);
            gradientDrawable.setCornerRadii(eRV);
            this.eRM.setDefaultBgResource(R.drawable.tab_live_card_round_bg_right);
        } else if (cVar.eNP) {
            this.eRM.setConrers(15);
            gradientDrawable.setCornerRadii(eRT);
            this.eRM.setDefaultBgResource(R.drawable.tab_live_card_round_bg_only_left);
        }
        this.eRM.setRadius((int) eRS);
        this.eRM.startLoad(this.eNR.aKV().cover, 10, false);
        this.eRQ.setBackgroundDrawable(gradientDrawable);
        this.eRM.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && d.this.eRZ && !d.this.eSc) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        d.this.eRM.startAnimation(d.this.eSa);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.eRN.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.live_tab_audience_label, aq.ck(this.eNR.aKV().audience_count)));
        if (this.eNR.aKC() != null) {
            String name_show = this.eNR.aKC().getName_show();
            if (!StringUtils.isNull(name_show)) {
                this.eRP.setText(name_show);
            }
            this.eRR.startLoad(this.eNR.aKC().getPortrait(), 12, false);
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.eRN, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eRP, (int) R.color.cp_cont_a);
            if (i == 1) {
                this.eRR.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c_1));
            } else {
                this.eRR.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c));
            }
            Drawable drawable = am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.eRN.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.eRN.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
