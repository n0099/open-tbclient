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
    private static final float enY = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] enZ = {0.0f, 0.0f, 0.0f, 0.0f, enY, enY, enY, enY};
    private static final float[] eoa = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, enY, enY};
    private static final float[] eob = {0.0f, 0.0f, 0.0f, 0.0f, enY, enY, 0.0f, 0.0f};
    private bj ejW;
    public TbImageView enS;
    public TextView enT;
    public RelativeLayout enU;
    public TextView enV;
    public LinearLayout enW;
    public HeadImageView enX;
    private o enn;
    private String eod;
    private com.baidu.tieba.ala.alasquare.a.c eoe;
    private AlphaAnimation eoh;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private int[] eoc = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean eog = false;
    private boolean eoi = true;
    private boolean eoj = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (d.this.eoe != null && d.this.eoe.ejW != null && d.this.enn != null) {
                    d.this.enn.a(d.this.eoe);
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
        this.enS = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.enT = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.enU = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.enV = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.enW = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.enX = (HeadImageView) this.mRootView.findViewById(R.id.ivUserAvatar);
        this.enX.setIsRound(true);
        this.enX.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.enS.setBorderSurroundContent(true);
        this.enS.setDrawBorder(true);
        this.enS.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.enU.getLayoutParams();
        layoutParams.width = ((com.baidu.adp.lib.util.l.getEquipmentWidth(tbPageContext.getPageActivity()) - tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12)) - (tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 2;
        layoutParams.height = layoutParams.width;
        this.enU.setLayoutParams(layoutParams);
        this.eoh = new AlphaAnimation(0.0f, 1.0f);
        this.eoh.setDuration(200L);
        this.eoh.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                d.this.eoj = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                d.this.eoj = false;
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
        this.enn = oVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        a(cVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.c cVar, int i) {
        if (cVar == null || cVar.ejW == null || cVar.ejW.aCH() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.eoe = cVar;
        this.ejW = cVar.ejW;
        this.tabId = cVar.tabId;
        this.eod = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        Object tag = this.enS.getTag();
        if (this.eoi) {
            this.eog = true;
            this.eoi = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.ejW.aCH().cover) && !((String) tag).equals(this.ejW.aCH().cover)) {
            this.eog = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.ejW.aCH().cover) && !this.mCoverUrl.equals(this.ejW.aCH().cover)) {
            this.eog = true;
        } else {
            this.eog = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.eoc);
        this.mCoverUrl = this.ejW.aCH().cover;
        this.enS.setTag(this.mCoverUrl);
        if (cVar.isLeft) {
            this.enS.setConrers(5);
            gradientDrawable.setCornerRadii(eoa);
            this.enS.setDefaultBgResource(R.drawable.tab_live_card_round_bg_left);
        } else if (cVar.isRight) {
            this.enS.setConrers(10);
            gradientDrawable.setCornerRadii(eob);
            this.enS.setDefaultBgResource(R.drawable.tab_live_card_round_bg_right);
        } else if (cVar.ejU) {
            this.enS.setConrers(15);
            gradientDrawable.setCornerRadii(enZ);
            this.enS.setDefaultBgResource(R.drawable.tab_live_card_round_bg_only_left);
        }
        this.enS.setRadius((int) enY);
        this.enS.startLoad(this.ejW.aCH().cover, 10, false);
        this.enW.setBackgroundDrawable(gradientDrawable);
        this.enS.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && d.this.eog && !d.this.eoj) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        d.this.enS.startAnimation(d.this.eoh);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.enT.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.live_tab_audience_label, aq.bE(this.ejW.aCH().audience_count)));
        if (this.ejW.aCo() != null) {
            String name_show = this.ejW.aCo().getName_show();
            if (!StringUtils.isNull(name_show)) {
                this.enV.setText(name_show);
            }
            this.enX.startLoad(this.ejW.aCo().getPortrait(), 12, false);
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.enT, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.enV, (int) R.color.cp_cont_a);
            if (i == 1) {
                this.enX.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c_1));
            } else {
                this.enX.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c));
            }
            Drawable drawable = am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.enT.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.enT.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
