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
    private static final float gDg = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] gDh = {0.0f, 0.0f, 0.0f, 0.0f, gDg, gDg, gDg, gDg};
    private static final float[] gDi = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, gDg, gDg};
    private static final float[] gDj = {0.0f, 0.0f, 0.0f, 0.0f, gDg, gDg, 0.0f, 0.0f};
    public TextView bEn;
    private i gCx;
    public TbImageView gDb;
    public TextView gDc;
    public RelativeLayout gDd;
    public LinearLayout gDe;
    public HeadImageView gDf;
    private String gDl;
    private com.baidu.tieba.ala.alasquare.a.e gDm;
    private AlphaAnimation gDo;
    private cb gyO;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private int[] gDk = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean gDn = false;
    private boolean gDp = true;
    private boolean gDq = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (c.this.gDm != null && c.this.gDm.gyO != null && c.this.gCx != null) {
                    c.this.gCx.a(c.this.gDm);
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
        this.gDb = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.gDc = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.gDd = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.bEn = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.gDe = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.gDf = (HeadImageView) this.mRootView.findViewById(R.id.ivUserAvatar);
        this.gDf.setIsRound(true);
        this.gDf.setBorderWidth(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.gDb.setBorderSurroundContent(true);
        this.gDb.setDrawBorder(true);
        this.gDb.setBorderWidth(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gDd.getLayoutParams();
        layoutParams.width = ((l.getEquipmentWidth(tbPageContext.getPageActivity()) - tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12)) - (tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 2;
        layoutParams.height = layoutParams.width;
        this.gDd.setLayoutParams(layoutParams);
        this.gDo = new AlphaAnimation(0.0f, 1.0f);
        this.gDo.setDuration(200L);
        this.gDo.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.c.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                c.this.gDq = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                c.this.gDq = false;
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
        this.gCx = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.e eVar) {
        a(eVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.e eVar, int i) {
        if (eVar == null || eVar.gyO == null || eVar.gyO.boj() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gDm = eVar;
        this.gyO = eVar.gyO;
        this.tabId = eVar.tabId;
        this.gDl = !TextUtils.isEmpty(eVar.labelName) ? eVar.labelName : eVar.entryName;
        Object tag = this.gDb.getTag();
        if (this.gDp) {
            this.gDn = true;
            this.gDp = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.gyO.boj().cover) && !((String) tag).equals(this.gyO.boj().cover)) {
            this.gDn = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.gyO.boj().cover) && !this.mCoverUrl.equals(this.gyO.boj().cover)) {
            this.gDn = true;
        } else {
            this.gDn = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.gDk);
        this.mCoverUrl = this.gyO.boj().cover;
        this.gDb.setTag(this.mCoverUrl);
        if (eVar.isLeft) {
            this.gDb.setConrers(5);
            gradientDrawable.setCornerRadii(gDi);
            this.gDb.setPlaceHolder(3);
        } else if (eVar.isRight) {
            this.gDb.setConrers(10);
            gradientDrawable.setCornerRadii(gDj);
            this.gDb.setPlaceHolder(3);
        } else if (eVar.gyM) {
            this.gDb.setConrers(15);
            gradientDrawable.setCornerRadii(gDh);
            this.gDb.setPlaceHolder(3);
        }
        this.gDb.setRadius((int) gDg);
        this.gDb.startLoad(this.gyO.boj().cover, 10, false);
        this.gDe.setBackgroundDrawable(gradientDrawable);
        this.gDb.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.c.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z && c.this.gDn && !c.this.gDq) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        c.this.gDb.startAnimation(c.this.gDo);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        });
        this.gDc.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.live_tab_audience_label, au.eb(this.gyO.boj().audience_count)));
        if (this.gyO.bnQ() != null) {
            String name_show = this.gyO.bnQ().getName_show();
            if (!StringUtils.isNull(name_show)) {
                this.bEn.setText(name_show);
            }
            this.gDf.startLoad(this.gyO.bnQ().getPortrait(), 12, false);
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.gDc, R.color.CAM_X0101);
            ap.setViewTextColor(this.bEn, R.color.CAM_X0101);
            if (i == 1) {
                this.gDf.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.CAM_X0903_1));
            } else {
                this.gDf.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.CAM_X0903));
            }
            Drawable drawable = ap.getDrawable(this.mTbPageContext.getResources(), R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.gDc.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.gDc.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
