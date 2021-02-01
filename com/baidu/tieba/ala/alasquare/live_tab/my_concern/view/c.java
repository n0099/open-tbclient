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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class c {
    private static final float gCS = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] gCT = {0.0f, 0.0f, 0.0f, 0.0f, gCS, gCS, gCS, gCS};
    private static final float[] gCU = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, gCS, gCS};
    private static final float[] gCV = {0.0f, 0.0f, 0.0f, 0.0f, gCS, gCS, 0.0f, 0.0f};
    public TextView bEn;
    public TbImageView gCN;
    public TextView gCO;
    public RelativeLayout gCP;
    public LinearLayout gCQ;
    public HeadImageView gCR;
    private String gCX;
    private com.baidu.tieba.ala.alasquare.a.e gCY;
    private i gCj;
    private AlphaAnimation gDa;
    private cb gyA;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private int[] gCW = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean gCZ = false;
    private boolean gDb = true;
    private boolean gDc = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (c.this.gCY != null && c.this.gCY.gyA != null && c.this.gCj != null) {
                    c.this.gCj.a(c.this.gCY);
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
        this.gCN = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.gCO = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.gCP = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.bEn = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.gCQ = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.gCR = (HeadImageView) this.mRootView.findViewById(R.id.ivUserAvatar);
        this.gCR.setIsRound(true);
        this.gCR.setBorderWidth(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.gCN.setBorderSurroundContent(true);
        this.gCN.setDrawBorder(true);
        this.gCN.setBorderWidth(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gCP.getLayoutParams();
        layoutParams.width = ((l.getEquipmentWidth(tbPageContext.getPageActivity()) - tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12)) - (tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 2;
        layoutParams.height = layoutParams.width;
        this.gCP.setLayoutParams(layoutParams);
        this.gDa = new AlphaAnimation(0.0f, 1.0f);
        this.gDa.setDuration(200L);
        this.gDa.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.c.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                c.this.gDc = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                c.this.gDc = false;
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
        this.gCj = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.e eVar) {
        a(eVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.e eVar, int i) {
        if (eVar == null || eVar.gyA == null || eVar.gyA.boj() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gCY = eVar;
        this.gyA = eVar.gyA;
        this.tabId = eVar.tabId;
        this.gCX = !TextUtils.isEmpty(eVar.labelName) ? eVar.labelName : eVar.entryName;
        Object tag = this.gCN.getTag();
        if (this.gDb) {
            this.gCZ = true;
            this.gDb = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.gyA.boj().cover) && !((String) tag).equals(this.gyA.boj().cover)) {
            this.gCZ = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.gyA.boj().cover) && !this.mCoverUrl.equals(this.gyA.boj().cover)) {
            this.gCZ = true;
        } else {
            this.gCZ = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.gCW);
        this.mCoverUrl = this.gyA.boj().cover;
        this.gCN.setTag(this.mCoverUrl);
        if (eVar.isLeft) {
            this.gCN.setConrers(5);
            gradientDrawable.setCornerRadii(gCU);
            this.gCN.setPlaceHolder(3);
        } else if (eVar.isRight) {
            this.gCN.setConrers(10);
            gradientDrawable.setCornerRadii(gCV);
            this.gCN.setPlaceHolder(3);
        } else if (eVar.gyy) {
            this.gCN.setConrers(15);
            gradientDrawable.setCornerRadii(gCT);
            this.gCN.setPlaceHolder(3);
        }
        this.gCN.setRadius((int) gCS);
        this.gCN.startLoad(this.gyA.boj().cover, 10, false);
        this.gCQ.setBackgroundDrawable(gradientDrawable);
        this.gCN.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.c.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z && c.this.gCZ && !c.this.gDc) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        c.this.gCN.startAnimation(c.this.gDa);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        });
        this.gCO.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.live_tab_audience_label, au.eb(this.gyA.boj().audience_count)));
        if (this.gyA.bnQ() != null) {
            String name_show = this.gyA.bnQ().getName_show();
            if (!StringUtils.isNull(name_show)) {
                this.bEn.setText(name_show);
            }
            this.gCR.startLoad(this.gyA.bnQ().getPortrait(), 12, false);
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.gCO, R.color.CAM_X0101);
            ap.setViewTextColor(this.bEn, R.color.CAM_X0101);
            if (i == 1) {
                this.gCR.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.CAM_X0903_1));
            } else {
                this.gCR.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.CAM_X0903));
            }
            Drawable drawable = ap.getDrawable(this.mTbPageContext.getResources(), R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.gCO.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.gCO.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
