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
    private static final float ggk = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] ggl = {0.0f, 0.0f, 0.0f, 0.0f, ggk, ggk, ggk, ggk};
    private static final float[] ggm = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, ggk, ggk};
    private static final float[] ggn = {0.0f, 0.0f, 0.0f, 0.0f, ggk, ggk, 0.0f, 0.0f};
    private bw gbZ;
    private o gfA;
    public TbImageView gge;
    public TextView ggf;
    public RelativeLayout ggg;
    public TextView ggh;
    public LinearLayout ggi;
    public HeadImageView ggj;
    private String ggp;
    private com.baidu.tieba.ala.alasquare.a.c ggq;
    private AlphaAnimation ggs;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private int[] ggo = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean ggr = false;
    private boolean ggt = true;
    private boolean mIsAnimating = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (d.this.ggq != null && d.this.ggq.gbZ != null && d.this.gfA != null) {
                    d.this.gfA.a(d.this.ggq);
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
        this.gge = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.ggf = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.ggg = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.ggh = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.ggi = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.ggj = (HeadImageView) this.mRootView.findViewById(R.id.ivUserAvatar);
        this.ggj.setIsRound(true);
        this.ggj.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.gge.setBorderSurroundContent(true);
        this.gge.setDrawBorder(true);
        this.gge.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ggg.getLayoutParams();
        layoutParams.width = ((com.baidu.adp.lib.util.l.getEquipmentWidth(tbPageContext.getPageActivity()) - tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12)) - (tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 2;
        layoutParams.height = layoutParams.width;
        this.ggg.setLayoutParams(layoutParams);
        this.ggs = new AlphaAnimation(0.0f, 1.0f);
        this.ggs.setDuration(200L);
        this.ggs.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.1
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
        this.gfA = oVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        a(cVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.c cVar, int i) {
        if (cVar == null || cVar.gbZ == null || cVar.gbZ.bku() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.ggq = cVar;
        this.gbZ = cVar.gbZ;
        this.tabId = cVar.tabId;
        this.ggp = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        Object tag = this.gge.getTag();
        if (this.ggt) {
            this.ggr = true;
            this.ggt = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.gbZ.bku().cover) && !((String) tag).equals(this.gbZ.bku().cover)) {
            this.ggr = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.gbZ.bku().cover) && !this.mCoverUrl.equals(this.gbZ.bku().cover)) {
            this.ggr = true;
        } else {
            this.ggr = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.ggo);
        this.mCoverUrl = this.gbZ.bku().cover;
        this.gge.setTag(this.mCoverUrl);
        if (cVar.isLeft) {
            this.gge.setConrers(5);
            gradientDrawable.setCornerRadii(ggm);
            this.gge.setDefaultBgResource(R.drawable.tab_live_card_round_bg_left);
        } else if (cVar.isRight) {
            this.gge.setConrers(10);
            gradientDrawable.setCornerRadii(ggn);
            this.gge.setDefaultBgResource(R.drawable.tab_live_card_round_bg_right);
        } else if (cVar.gbX) {
            this.gge.setConrers(15);
            gradientDrawable.setCornerRadii(ggl);
            this.gge.setDefaultBgResource(R.drawable.tab_live_card_round_bg_only_left);
        }
        this.gge.setRadius((int) ggk);
        this.gge.startLoad(this.gbZ.bku().cover, 10, false);
        this.ggi.setBackgroundDrawable(gradientDrawable);
        this.gge.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && d.this.ggr && !d.this.mIsAnimating) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        d.this.gge.startAnimation(d.this.ggs);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.ggf.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.live_tab_audience_label, at.da(this.gbZ.bku().audience_count)));
        if (this.gbZ.bka() != null) {
            String name_show = this.gbZ.bka().getName_show();
            if (!StringUtils.isNull(name_show)) {
                this.ggh.setText(name_show);
            }
            this.ggj.startLoad(this.gbZ.bka().getPortrait(), 12, false);
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.ggf, R.color.cp_cont_a);
            ap.setViewTextColor(this.ggh, R.color.cp_cont_a);
            if (i == 1) {
                this.ggj.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c_1));
            } else {
                this.ggj.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c));
            }
            Drawable drawable = ap.getDrawable(this.mTbPageContext.getResources(), R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.ggf.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.ggf.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
