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
/* loaded from: classes9.dex */
public class c {
    private static final float gAi = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] gAj = {0.0f, 0.0f, 0.0f, 0.0f, gAi, gAi, gAi, gAi};
    private static final float[] gAk = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, gAi, gAi};
    private static final float[] gAl = {0.0f, 0.0f, 0.0f, 0.0f, gAi, gAi, 0.0f, 0.0f};
    public TextView bAH;
    public TbImageView gAd;
    public TextView gAe;
    public RelativeLayout gAf;
    public LinearLayout gAg;
    public HeadImageView gAh;
    private String gAn;
    private com.baidu.tieba.ala.alasquare.a.e gAo;
    private AlphaAnimation gAq;
    private bz gvQ;
    private i gzz;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private int[] gAm = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean gAp = false;
    private boolean gAr = true;
    private boolean gAs = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (c.this.gAo != null && c.this.gAo.gvQ != null && c.this.gzz != null) {
                    c.this.gzz.a(c.this.gAo);
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
        this.gAd = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.gAe = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.gAf = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.bAH = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.gAg = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.gAh = (HeadImageView) this.mRootView.findViewById(R.id.ivUserAvatar);
        this.gAh.setIsRound(true);
        this.gAh.setBorderWidth(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.gAd.setBorderSurroundContent(true);
        this.gAd.setDrawBorder(true);
        this.gAd.setBorderWidth(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gAf.getLayoutParams();
        layoutParams.width = ((l.getEquipmentWidth(tbPageContext.getPageActivity()) - tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12)) - (tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 2;
        layoutParams.height = layoutParams.width;
        this.gAf.setLayoutParams(layoutParams);
        this.gAq = new AlphaAnimation(0.0f, 1.0f);
        this.gAq.setDuration(200L);
        this.gAq.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.c.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                c.this.gAs = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                c.this.gAs = false;
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
        this.gzz = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.e eVar) {
        a(eVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.e eVar, int i) {
        if (eVar == null || eVar.gvQ == null || eVar.gvQ.bnQ() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gAo = eVar;
        this.gvQ = eVar.gvQ;
        this.tabId = eVar.tabId;
        this.gAn = !TextUtils.isEmpty(eVar.labelName) ? eVar.labelName : eVar.entryName;
        Object tag = this.gAd.getTag();
        if (this.gAr) {
            this.gAp = true;
            this.gAr = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.gvQ.bnQ().cover) && !((String) tag).equals(this.gvQ.bnQ().cover)) {
            this.gAp = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.gvQ.bnQ().cover) && !this.mCoverUrl.equals(this.gvQ.bnQ().cover)) {
            this.gAp = true;
        } else {
            this.gAp = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.gAm);
        this.mCoverUrl = this.gvQ.bnQ().cover;
        this.gAd.setTag(this.mCoverUrl);
        if (eVar.isLeft) {
            this.gAd.setConrers(5);
            gradientDrawable.setCornerRadii(gAk);
            this.gAd.setPlaceHolder(3);
        } else if (eVar.isRight) {
            this.gAd.setConrers(10);
            gradientDrawable.setCornerRadii(gAl);
            this.gAd.setPlaceHolder(3);
        } else if (eVar.gvO) {
            this.gAd.setConrers(15);
            gradientDrawable.setCornerRadii(gAj);
            this.gAd.setPlaceHolder(3);
        }
        this.gAd.setRadius((int) gAi);
        this.gAd.startLoad(this.gvQ.bnQ().cover, 10, false);
        this.gAg.setBackgroundDrawable(gradientDrawable);
        this.gAd.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.c.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z && c.this.gAp && !c.this.gAs) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        c.this.gAd.startAnimation(c.this.gAq);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        });
        this.gAe.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.live_tab_audience_label, at.dV(this.gvQ.bnQ().audience_count)));
        if (this.gvQ.bnx() != null) {
            String name_show = this.gvQ.bnx().getName_show();
            if (!StringUtils.isNull(name_show)) {
                this.bAH.setText(name_show);
            }
            this.gAh.startLoad(this.gvQ.bnx().getPortrait(), 12, false);
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setViewTextColor(this.gAe, R.color.CAM_X0101);
            ao.setViewTextColor(this.bAH, R.color.CAM_X0101);
            if (i == 1) {
                this.gAh.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.CAM_X0903_1));
            } else {
                this.gAh.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.CAM_X0903));
            }
            Drawable drawable = ao.getDrawable(this.mTbPageContext.getResources(), R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.gAe.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.gAe.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
