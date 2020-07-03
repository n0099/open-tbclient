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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class d {
    private static final float fpW = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] fpX = {0.0f, 0.0f, 0.0f, 0.0f, fpW, fpW, fpW, fpW};
    private static final float[] fpY = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, fpW, fpW};
    private static final float[] fpZ = {0.0f, 0.0f, 0.0f, 0.0f, fpW, fpW, 0.0f, 0.0f};
    private bu flT;
    public TbImageView fpQ;
    public TextView fpR;
    public RelativeLayout fpS;
    public TextView fpT;
    public LinearLayout fpU;
    public HeadImageView fpV;
    private o fpl;
    private String fqb;
    private com.baidu.tieba.ala.alasquare.a.c fqc;
    private AlphaAnimation fqe;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private int[] fqa = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean fqd = false;
    private boolean fqf = true;
    private boolean fqg = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (d.this.fqc != null && d.this.fqc.flT != null && d.this.fpl != null) {
                    d.this.fpl.a(d.this.fqc);
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
        this.fpQ = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.fpR = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.fpS = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.fpT = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.fpU = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.fpV = (HeadImageView) this.mRootView.findViewById(R.id.ivUserAvatar);
        this.fpV.setIsRound(true);
        this.fpV.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.fpQ.setBorderSurroundContent(true);
        this.fpQ.setDrawBorder(true);
        this.fpQ.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fpS.getLayoutParams();
        layoutParams.width = ((com.baidu.adp.lib.util.l.getEquipmentWidth(tbPageContext.getPageActivity()) - tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12)) - (tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 2;
        layoutParams.height = layoutParams.width;
        this.fpS.setLayoutParams(layoutParams);
        this.fqe = new AlphaAnimation(0.0f, 1.0f);
        this.fqe.setDuration(200L);
        this.fqe.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                d.this.fqg = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                d.this.fqg = false;
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
        this.fpl = oVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        a(cVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.c cVar, int i) {
        if (cVar == null || cVar.flT == null || cVar.flT.aSJ() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.fqc = cVar;
        this.flT = cVar.flT;
        this.tabId = cVar.tabId;
        this.fqb = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        Object tag = this.fpQ.getTag();
        if (this.fqf) {
            this.fqd = true;
            this.fqf = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.flT.aSJ().cover) && !((String) tag).equals(this.flT.aSJ().cover)) {
            this.fqd = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.flT.aSJ().cover) && !this.mCoverUrl.equals(this.flT.aSJ().cover)) {
            this.fqd = true;
        } else {
            this.fqd = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.fqa);
        this.mCoverUrl = this.flT.aSJ().cover;
        this.fpQ.setTag(this.mCoverUrl);
        if (cVar.isLeft) {
            this.fpQ.setConrers(5);
            gradientDrawable.setCornerRadii(fpY);
            this.fpQ.setDefaultBgResource(R.drawable.tab_live_card_round_bg_left);
        } else if (cVar.isRight) {
            this.fpQ.setConrers(10);
            gradientDrawable.setCornerRadii(fpZ);
            this.fpQ.setDefaultBgResource(R.drawable.tab_live_card_round_bg_right);
        } else if (cVar.flR) {
            this.fpQ.setConrers(15);
            gradientDrawable.setCornerRadii(fpX);
            this.fpQ.setDefaultBgResource(R.drawable.tab_live_card_round_bg_only_left);
        }
        this.fpQ.setRadius((int) fpW);
        this.fpQ.startLoad(this.flT.aSJ().cover, 10, false);
        this.fpU.setBackgroundDrawable(gradientDrawable);
        this.fpQ.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && d.this.fqd && !d.this.fqg) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        d.this.fpQ.startAnimation(d.this.fqe);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fpR.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.live_tab_audience_label, ar.cm(this.flT.aSJ().audience_count)));
        if (this.flT.aSp() != null) {
            String name_show = this.flT.aSp().getName_show();
            if (!StringUtils.isNull(name_show)) {
                this.fpT.setText(name_show);
            }
            this.fpV.startLoad(this.flT.aSp().getPortrait(), 12, false);
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            an.setViewTextColor(this.fpR, (int) R.color.cp_cont_a);
            an.setViewTextColor(this.fpT, (int) R.color.cp_cont_a);
            if (i == 1) {
                this.fpV.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c_1));
            } else {
                this.fpV.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c));
            }
            Drawable drawable = an.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.fpR.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.fpR.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
