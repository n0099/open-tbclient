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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class d {
    private static final float glF = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] glG = {0.0f, 0.0f, 0.0f, 0.0f, glF, glF, glF, glF};
    private static final float[] glH = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, glF, glF};
    private static final float[] glI = {0.0f, 0.0f, 0.0f, 0.0f, glF, glF, 0.0f, 0.0f};
    public TextView bvw;
    private bx ghv;
    private o gkW;
    public TbImageView glA;
    public TextView glB;
    public RelativeLayout glC;
    public LinearLayout glD;
    public HeadImageView glE;
    private String glK;
    private com.baidu.tieba.ala.alasquare.a.c glL;
    private AlphaAnimation glN;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private int[] glJ = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean glM = false;
    private boolean glO = true;
    private boolean mIsAnimating = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (d.this.glL != null && d.this.glL.ghv != null && d.this.gkW != null) {
                    d.this.gkW.a(d.this.glL);
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
        this.glA = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.glB = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.glC = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.bvw = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.glD = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.glE = (HeadImageView) this.mRootView.findViewById(R.id.ivUserAvatar);
        this.glE.setIsRound(true);
        this.glE.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.glA.setBorderSurroundContent(true);
        this.glA.setDrawBorder(true);
        this.glA.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.glC.getLayoutParams();
        layoutParams.width = ((com.baidu.adp.lib.util.l.getEquipmentWidth(tbPageContext.getPageActivity()) - tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12)) - (tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 2;
        layoutParams.height = layoutParams.width;
        this.glC.setLayoutParams(layoutParams);
        this.glN = new AlphaAnimation(0.0f, 1.0f);
        this.glN.setDuration(200L);
        this.glN.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.1
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
        this.gkW = oVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        a(cVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.c cVar, int i) {
        if (cVar == null || cVar.ghv == null || cVar.ghv.blW() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.glL = cVar;
        this.ghv = cVar.ghv;
        this.tabId = cVar.tabId;
        this.glK = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        Object tag = this.glA.getTag();
        if (this.glO) {
            this.glM = true;
            this.glO = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.ghv.blW().cover) && !((String) tag).equals(this.ghv.blW().cover)) {
            this.glM = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.ghv.blW().cover) && !this.mCoverUrl.equals(this.ghv.blW().cover)) {
            this.glM = true;
        } else {
            this.glM = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.glJ);
        this.mCoverUrl = this.ghv.blW().cover;
        this.glA.setTag(this.mCoverUrl);
        if (cVar.isLeft) {
            this.glA.setConrers(5);
            gradientDrawable.setCornerRadii(glH);
            this.glA.setPlaceHolder(3);
        } else if (cVar.isRight) {
            this.glA.setConrers(10);
            gradientDrawable.setCornerRadii(glI);
            this.glA.setPlaceHolder(3);
        } else if (cVar.ght) {
            this.glA.setConrers(15);
            gradientDrawable.setCornerRadii(glG);
            this.glA.setPlaceHolder(3);
        }
        this.glA.setRadius((int) glF);
        this.glA.startLoad(this.ghv.blW().cover, 10, false);
        this.glD.setBackgroundDrawable(gradientDrawable);
        this.glA.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && d.this.glM && !d.this.mIsAnimating) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        d.this.glA.startAnimation(d.this.glN);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.glB.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.live_tab_audience_label, au.dw(this.ghv.blW().audience_count)));
        if (this.ghv.blC() != null) {
            String name_show = this.ghv.blC().getName_show();
            if (!StringUtils.isNull(name_show)) {
                this.bvw.setText(name_show);
            }
            this.glE.startLoad(this.ghv.blC().getPortrait(), 12, false);
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.glB, R.color.CAM_X0101);
            ap.setViewTextColor(this.bvw, R.color.CAM_X0101);
            if (i == 1) {
                this.glE.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.CAM_X0903_1));
            } else {
                this.glE.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.CAM_X0903));
            }
            Drawable drawable = ap.getDrawable(this.mTbPageContext.getResources(), R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.glB.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.glB.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
