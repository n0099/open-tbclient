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
    private static final float gtO = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] gtP = {0.0f, 0.0f, 0.0f, 0.0f, gtO, gtO, gtO, gtO};
    private static final float[] gtQ = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, gtO, gtO};
    private static final float[] gtR = {0.0f, 0.0f, 0.0f, 0.0f, gtO, gtO, 0.0f, 0.0f};
    public TextView bAG;
    private by gpF;
    public TbImageView gtJ;
    public TextView gtK;
    public RelativeLayout gtL;
    public LinearLayout gtM;
    public HeadImageView gtN;
    private String gtT;
    private com.baidu.tieba.ala.alasquare.a.c gtU;
    private AlphaAnimation gtW;
    private o gtf;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private int[] gtS = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean gtV = false;
    private boolean gtX = true;
    private boolean mIsAnimating = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (d.this.gtU != null && d.this.gtU.gpF != null && d.this.gtf != null) {
                    d.this.gtf.a(d.this.gtU);
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
        this.gtJ = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.gtK = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.gtL = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.bAG = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.gtM = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.gtN = (HeadImageView) this.mRootView.findViewById(R.id.ivUserAvatar);
        this.gtN.setIsRound(true);
        this.gtN.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.gtJ.setBorderSurroundContent(true);
        this.gtJ.setDrawBorder(true);
        this.gtJ.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gtL.getLayoutParams();
        layoutParams.width = ((com.baidu.adp.lib.util.l.getEquipmentWidth(tbPageContext.getPageActivity()) - tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12)) - (tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 2;
        layoutParams.height = layoutParams.width;
        this.gtL.setLayoutParams(layoutParams);
        this.gtW = new AlphaAnimation(0.0f, 1.0f);
        this.gtW.setDuration(200L);
        this.gtW.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.1
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
        this.gtf = oVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        a(cVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.c cVar, int i) {
        if (cVar == null || cVar.gpF == null || cVar.gpF.bpj() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gtU = cVar;
        this.gpF = cVar.gpF;
        this.tabId = cVar.tabId;
        this.gtT = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        Object tag = this.gtJ.getTag();
        if (this.gtX) {
            this.gtV = true;
            this.gtX = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.gpF.bpj().cover) && !((String) tag).equals(this.gpF.bpj().cover)) {
            this.gtV = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.gpF.bpj().cover) && !this.mCoverUrl.equals(this.gpF.bpj().cover)) {
            this.gtV = true;
        } else {
            this.gtV = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.gtS);
        this.mCoverUrl = this.gpF.bpj().cover;
        this.gtJ.setTag(this.mCoverUrl);
        if (cVar.isLeft) {
            this.gtJ.setConrers(5);
            gradientDrawable.setCornerRadii(gtQ);
            this.gtJ.setPlaceHolder(3);
        } else if (cVar.isRight) {
            this.gtJ.setConrers(10);
            gradientDrawable.setCornerRadii(gtR);
            this.gtJ.setPlaceHolder(3);
        } else if (cVar.gpD) {
            this.gtJ.setConrers(15);
            gradientDrawable.setCornerRadii(gtP);
            this.gtJ.setPlaceHolder(3);
        }
        this.gtJ.setRadius((int) gtO);
        this.gtJ.startLoad(this.gpF.bpj().cover, 10, false);
        this.gtM.setBackgroundDrawable(gradientDrawable);
        this.gtJ.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && d.this.gtV && !d.this.mIsAnimating) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        d.this.gtJ.startAnimation(d.this.gtW);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.gtK.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.live_tab_audience_label, au.dV(this.gpF.bpj().audience_count)));
        if (this.gpF.boP() != null) {
            String name_show = this.gpF.boP().getName_show();
            if (!StringUtils.isNull(name_show)) {
                this.bAG.setText(name_show);
            }
            this.gtN.startLoad(this.gpF.boP().getPortrait(), 12, false);
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.gtK, (int) R.color.CAM_X0101);
            ap.setViewTextColor(this.bAG, (int) R.color.CAM_X0101);
            if (i == 1) {
                this.gtN.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.CAM_X0903_1));
            } else {
                this.gtN.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.CAM_X0903));
            }
            Drawable drawable = ap.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.gtK.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.gtK.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
