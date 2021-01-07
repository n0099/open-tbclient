package com.baidu.tieba.ala.alasquare.live_tab.my_concern.view;

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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class c {
    private static final float gEP = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] gEQ = {0.0f, 0.0f, 0.0f, 0.0f, gEP, gEP, gEP, gEP};
    private static final float[] gER = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, gEP, gEP};
    private static final float[] gES = {0.0f, 0.0f, 0.0f, 0.0f, gEP, gEP, 0.0f, 0.0f};
    public TextView bFt;
    private bz gAx;
    public TbImageView gEK;
    public TextView gEL;
    public RelativeLayout gEM;
    public LinearLayout gEN;
    public HeadImageView gEO;
    private String gEU;
    private com.baidu.tieba.ala.alasquare.a.e gEV;
    private AlphaAnimation gEX;
    private i gEg;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private int[] gET = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean gEW = false;
    private boolean gEY = true;
    private boolean mIsAnimating = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (c.this.gEV != null && c.this.gEV.gAx != null && c.this.gEg != null) {
                    c.this.gEg.a(c.this.gEV);
                    return;
                }
                return;
            }
            l.showLongToast(c.this.mTbPageContext.getPageActivity(), c.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        }
    };

    public c(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_sub_live_item_view, (ViewGroup) null, false);
        this.gEK = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.gEL = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.gEM = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.bFt = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.gEN = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.gEO = (HeadImageView) this.mRootView.findViewById(R.id.ivUserAvatar);
        this.gEO.setIsRound(true);
        this.gEO.setBorderWidth(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.gEK.setBorderSurroundContent(true);
        this.gEK.setDrawBorder(true);
        this.gEK.setBorderWidth(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gEM.getLayoutParams();
        layoutParams.width = ((l.getEquipmentWidth(tbPageContext.getPageActivity()) - tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12)) - (tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 2;
        layoutParams.height = layoutParams.width;
        this.gEM.setLayoutParams(layoutParams);
        this.gEX = new AlphaAnimation(0.0f, 1.0f);
        this.gEX.setDuration(200L);
        this.gEX.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.c.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                c.this.mIsAnimating = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                c.this.mIsAnimating = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(i iVar) {
        this.gEg = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.e eVar) {
        a(eVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.e eVar, int i) {
        if (eVar == null || eVar.gAx == null || eVar.gAx.brK() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gEV = eVar;
        this.gAx = eVar.gAx;
        this.tabId = eVar.tabId;
        this.gEU = !TextUtils.isEmpty(eVar.labelName) ? eVar.labelName : eVar.entryName;
        Object tag = this.gEK.getTag();
        if (this.gEY) {
            this.gEW = true;
            this.gEY = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.gAx.brK().cover) && !((String) tag).equals(this.gAx.brK().cover)) {
            this.gEW = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.gAx.brK().cover) && !this.mCoverUrl.equals(this.gAx.brK().cover)) {
            this.gEW = true;
        } else {
            this.gEW = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.gET);
        this.mCoverUrl = this.gAx.brK().cover;
        this.gEK.setTag(this.mCoverUrl);
        if (eVar.isLeft) {
            this.gEK.setConrers(5);
            gradientDrawable.setCornerRadii(gER);
            this.gEK.setPlaceHolder(3);
        } else if (eVar.isRight) {
            this.gEK.setConrers(10);
            gradientDrawable.setCornerRadii(gES);
            this.gEK.setPlaceHolder(3);
        } else if (eVar.gAv) {
            this.gEK.setConrers(15);
            gradientDrawable.setCornerRadii(gEQ);
            this.gEK.setPlaceHolder(3);
        }
        this.gEK.setRadius((int) gEP);
        this.gEK.startLoad(this.gAx.brK().cover, 10, false);
        this.gEN.setBackgroundDrawable(gradientDrawable);
        this.gEK.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.c.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z && c.this.gEW && !c.this.mIsAnimating) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        c.this.gEK.startAnimation(c.this.gEX);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        });
        this.gEL.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.live_tab_audience_label, at.dV(this.gAx.brK().audience_count)));
        if (this.gAx.brr() != null) {
            String name_show = this.gAx.brr().getName_show();
            if (!StringUtils.isNull(name_show)) {
                this.bFt.setText(name_show);
            }
            this.gEO.startLoad(this.gAx.brr().getPortrait(), 12, false);
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setViewTextColor(this.gEL, R.color.CAM_X0101);
            ao.setViewTextColor(this.bFt, R.color.CAM_X0101);
            if (i == 1) {
                this.gEO.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.CAM_X0903_1));
            } else {
                this.gEO.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.CAM_X0903));
            }
            Drawable drawable = ao.getDrawable(this.mTbPageContext.getResources(), R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.gEL.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.gEL.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
