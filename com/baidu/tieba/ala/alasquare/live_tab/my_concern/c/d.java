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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class d {
    private static final float dyB = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] dyC = {0.0f, 0.0f, 0.0f, 0.0f, dyB, dyB, dyB, dyB};
    private static final float[] dyD = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, dyB, dyB};
    private static final float[] dyE = {0.0f, 0.0f, 0.0f, 0.0f, dyB, dyB, 0.0f, 0.0f};
    private bh dvi;
    private o dxR;
    public HeadImageView dyA;
    private String dyG;
    private com.baidu.tieba.ala.alasquare.a.b dyH;
    private AlphaAnimation dyJ;
    public TbImageView dyv;
    public TextView dyw;
    public RelativeLayout dyx;
    public TextView dyy;
    public LinearLayout dyz;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private int[] dyF = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean dyI = false;
    private boolean dyK = true;
    private boolean dyL = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (d.this.dyH != null && d.this.dyH.dvi != null && d.this.dxR != null) {
                    d.this.dxR.a(d.this.dyH);
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
        this.dyv = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.dyw = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.dyx = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.dyy = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.dyz = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.dyA = (HeadImageView) this.mRootView.findViewById(R.id.ivUserAvatar);
        this.dyA.setIsRound(true);
        this.dyA.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.dyv.setBorderSurroundContent(true);
        this.dyv.setDrawBorder(true);
        this.dyv.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dyx.getLayoutParams();
        layoutParams.width = ((com.baidu.adp.lib.util.l.getEquipmentWidth(tbPageContext.getPageActivity()) - tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12)) - (tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 2;
        layoutParams.height = layoutParams.width;
        this.dyx.setLayoutParams(layoutParams);
        this.dyJ = new AlphaAnimation(0.0f, 1.0f);
        this.dyJ.setDuration(200L);
        this.dyJ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                d.this.dyL = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                d.this.dyL = false;
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
        this.dxR = oVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.b bVar) {
        a(bVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.b bVar, int i) {
        if (bVar == null || bVar.dvi == null || bVar.dvi.aiZ() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.dyH = bVar;
        this.dvi = bVar.dvi;
        this.tabId = bVar.tabId;
        this.dyG = !TextUtils.isEmpty(bVar.labelName) ? bVar.labelName : bVar.entryName;
        Object tag = this.dyv.getTag();
        if (this.dyK) {
            this.dyI = true;
            this.dyK = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.dvi.aiZ().cover) && !((String) tag).equals(this.dvi.aiZ().cover)) {
            this.dyI = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.dvi.aiZ().cover) && !this.mCoverUrl.equals(this.dvi.aiZ().cover)) {
            this.dyI = true;
        } else {
            this.dyI = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.dyF);
        this.mCoverUrl = this.dvi.aiZ().cover;
        this.dyv.setTag(this.mCoverUrl);
        if (bVar.isLeft) {
            this.dyv.setConrers(5);
            gradientDrawable.setCornerRadii(dyD);
            this.dyv.setDefaultBgResource(R.drawable.tab_live_card_round_bg_left);
        } else if (bVar.isRight) {
            this.dyv.setConrers(10);
            gradientDrawable.setCornerRadii(dyE);
            this.dyv.setDefaultBgResource(R.drawable.tab_live_card_round_bg_right);
        } else if (bVar.dvl) {
            this.dyv.setConrers(15);
            gradientDrawable.setCornerRadii(dyC);
            this.dyv.setDefaultBgResource(R.drawable.tab_live_card_round_bg_only_left);
        }
        this.dyv.setRadius((int) dyB);
        this.dyv.startLoad(this.dvi.aiZ().cover, 10, false);
        this.dyz.setBackgroundDrawable(gradientDrawable);
        this.dyv.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.d.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && d.this.dyI && !d.this.dyL) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        d.this.dyv.startAnimation(d.this.dyJ);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.dyw.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.live_tab_audience_label, aq.aT(this.dvi.aiZ().audience_count)));
        if (this.dvi.aiG() != null) {
            String name_show = this.dvi.aiG().getName_show();
            if (!StringUtils.isNull(name_show)) {
                this.dyy.setText(name_show);
            }
            this.dyA.startLoad(this.dvi.aiG().getPortrait(), 12, false);
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.dyw, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dyy, (int) R.color.cp_cont_a);
            if (i == 1) {
                this.dyA.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c_1));
            } else {
                this.dyA.setBorderColor(this.mTbPageContext.getResources().getColor(R.color.cp_btn_c));
            }
            Drawable drawable = am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.dyw.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.dyw.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
