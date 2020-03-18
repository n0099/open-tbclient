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
    private static final float eoq = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] eor = {0.0f, 0.0f, 0.0f, 0.0f, eoq, eoq, eoq, eoq};
    private static final float[] eos = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, eoq, eoq};
    private static final float[] eot = {0.0f, 0.0f, 0.0f, 0.0f, eoq, eoq, 0.0f, 0.0f};
    private bj ekm;
    private o enF;
    public TbImageView eok;
    public TextView eol;
    public RelativeLayout eom;
    public TextView eon;
    public LinearLayout eoo;
    public HeadImageView eop;
    private String eov;
    private com.baidu.tieba.ala.alasquare.a.c eow;
    private AlphaAnimation eoy;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private int[] eou = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean eox = false;
    private boolean eoz = true;
    private boolean eoA = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (d.this.eow != null && d.this.eow.ekm != null && d.this.enF != null) {
                    d.this.enF.a(d.this.eow);
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
        this.eok = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.eol = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.eom = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.eon = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.eoo = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.eop = (HeadImageView) this.mRootView.findViewById(R.id.ivUserAvatar);
        this.eop.setIsRound(true);
        this.eop.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.eok.setBorderSurroundContent(true);
        this.eok.setDrawBorder(true);
        this.eok.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eom.getLayoutParams();
        layoutParams.width = ((com.baidu.adp.lib.util.l.getEquipmentWidth(tbPageContext.getPageActivity()) - tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12)) - (tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 2;
        layoutParams.height = layoutParams.width;
        this.eom.setLayoutParams(layoutParams);
        this.eoy = new AlphaAnimation(0.0f, 1.0f);
        this.eoy.setDuration(200L);
        this.eoy.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                d.this.eoA = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                d.this.eoA = false;
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
        this.enF = oVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        a(cVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.c cVar, int i) {
        if (cVar == null || cVar.ekm == null || cVar.ekm.aCK() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.eow = cVar;
        this.ekm = cVar.ekm;
        this.tabId = cVar.tabId;
        this.eov = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        Object tag = this.eok.getTag();
        if (this.eoz) {
            this.eox = true;
            this.eoz = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.ekm.aCK().cover) && !((String) tag).equals(this.ekm.aCK().cover)) {
            this.eox = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.ekm.aCK().cover) && !this.mCoverUrl.equals(this.ekm.aCK().cover)) {
            this.eox = true;
        } else {
            this.eox = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.eou);
        this.mCoverUrl = this.ekm.aCK().cover;
        this.eok.setTag(this.mCoverUrl);
        if (cVar.isLeft) {
            this.eok.setConrers(5);
            gradientDrawable.setCornerRadii(eos);
            this.eok.setDefaultBgResource(R.drawable.tab_live_card_round_bg_left);
        } else if (cVar.isRight) {
            this.eok.setConrers(10);
            gradientDrawable.setCornerRadii(eot);
            this.eok.setDefaultBgResource(R.drawable.tab_live_card_round_bg_right);
        } else if (cVar.ekk) {
            this.eok.setConrers(15);
            gradientDrawable.setCornerRadii(eor);
            this.eok.setDefaultBgResource(R.drawable.tab_live_card_round_bg_only_left);
        }
        this.eok.setRadius((int) eoq);
        this.eok.startLoad(this.ekm.aCK().cover, 10, false);
        this.eoo.setBackgroundDrawable(gradientDrawable);
        this.eok.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && d.this.eox && !d.this.eoA) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        d.this.eok.startAnimation(d.this.eoy);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.eol.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.live_tab_audience_label, aq.bE(this.ekm.aCK().audience_count)));
        if (this.ekm.aCr() != null) {
            String name_show = this.ekm.aCr().getName_show();
            if (!StringUtils.isNull(name_show)) {
                this.eon.setText(name_show);
            }
            this.eop.startLoad(this.ekm.aCr().getPortrait(), 12, false);
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.eol, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eon, (int) R.color.cp_cont_a);
            if (i == 1) {
                this.eop.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c_1));
            } else {
                this.eop.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c));
            }
            Drawable drawable = am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.eol.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.eol.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
