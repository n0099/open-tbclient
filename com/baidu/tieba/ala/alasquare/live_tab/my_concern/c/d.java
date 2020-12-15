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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class d {
    private static final float gtQ = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] gtR = {0.0f, 0.0f, 0.0f, 0.0f, gtQ, gtQ, gtQ, gtQ};
    private static final float[] gtS = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, gtQ, gtQ};
    private static final float[] gtT = {0.0f, 0.0f, 0.0f, 0.0f, gtQ, gtQ, 0.0f, 0.0f};
    public TextView bAG;
    private by gpH;
    public TbImageView gtL;
    public TextView gtM;
    public RelativeLayout gtN;
    public LinearLayout gtO;
    public HeadImageView gtP;
    private String gtV;
    private com.baidu.tieba.ala.alasquare.a.c gtW;
    private AlphaAnimation gtY;
    private o gth;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private int[] gtU = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean gtX = false;
    private boolean gtZ = true;
    private boolean mIsAnimating = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (d.this.gtW != null && d.this.gtW.gpH != null && d.this.gth != null) {
                    d.this.gth.a(d.this.gtW);
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
        this.gtL = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.gtM = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.gtN = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.bAG = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.gtO = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.gtP = (HeadImageView) this.mRootView.findViewById(R.id.ivUserAvatar);
        this.gtP.setIsRound(true);
        this.gtP.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.gtL.setBorderSurroundContent(true);
        this.gtL.setDrawBorder(true);
        this.gtL.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gtN.getLayoutParams();
        layoutParams.width = ((com.baidu.adp.lib.util.l.getEquipmentWidth(tbPageContext.getPageActivity()) - tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12)) - (tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 2;
        layoutParams.height = layoutParams.width;
        this.gtN.setLayoutParams(layoutParams);
        this.gtY = new AlphaAnimation(0.0f, 1.0f);
        this.gtY.setDuration(200L);
        this.gtY.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.1
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
        this.gth = oVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        a(cVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.c cVar, int i) {
        if (cVar == null || cVar.gpH == null || cVar.gpH.bpj() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gtW = cVar;
        this.gpH = cVar.gpH;
        this.tabId = cVar.tabId;
        this.gtV = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        Object tag = this.gtL.getTag();
        if (this.gtZ) {
            this.gtX = true;
            this.gtZ = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.gpH.bpj().cover) && !((String) tag).equals(this.gpH.bpj().cover)) {
            this.gtX = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.gpH.bpj().cover) && !this.mCoverUrl.equals(this.gpH.bpj().cover)) {
            this.gtX = true;
        } else {
            this.gtX = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.gtU);
        this.mCoverUrl = this.gpH.bpj().cover;
        this.gtL.setTag(this.mCoverUrl);
        if (cVar.isLeft) {
            this.gtL.setConrers(5);
            gradientDrawable.setCornerRadii(gtS);
            this.gtL.setPlaceHolder(3);
        } else if (cVar.isRight) {
            this.gtL.setConrers(10);
            gradientDrawable.setCornerRadii(gtT);
            this.gtL.setPlaceHolder(3);
        } else if (cVar.gpF) {
            this.gtL.setConrers(15);
            gradientDrawable.setCornerRadii(gtR);
            this.gtL.setPlaceHolder(3);
        }
        this.gtL.setRadius((int) gtQ);
        this.gtL.startLoad(this.gpH.bpj().cover, 10, false);
        this.gtO.setBackgroundDrawable(gradientDrawable);
        this.gtL.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && d.this.gtX && !d.this.mIsAnimating) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        d.this.gtL.startAnimation(d.this.gtY);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.gtM.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.live_tab_audience_label, au.dV(this.gpH.bpj().audience_count)));
        if (this.gpH.boP() != null) {
            String name_show = this.gpH.boP().getName_show();
            if (!StringUtils.isNull(name_show)) {
                this.bAG.setText(name_show);
            }
            this.gtP.startLoad(this.gpH.boP().getPortrait(), 12, false);
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.gtM, (int) R.color.CAM_X0101);
            ap.setViewTextColor(this.bAG, (int) R.color.CAM_X0101);
            if (i == 1) {
                this.gtP.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.CAM_X0903_1));
            } else {
                this.gtP.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.CAM_X0903));
            }
            Drawable drawable = ap.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.gtM.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.gtM.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
