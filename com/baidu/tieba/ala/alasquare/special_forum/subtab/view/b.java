package com.baidu.tieba.ala.alasquare.special_forum.subtab.view;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.util.ag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.a.e;
import com.baidu.tieba.ala.alasquare.subtablist.view.g;
/* loaded from: classes10.dex */
public class b {
    public TextView bEn;
    public TbImageView gDb;
    public TextView gDc;
    public RelativeLayout gDd;
    private String gDl;
    private AlphaAnimation gDo;
    public ImageView gFf;
    private g gGP;
    public TextView gIg;
    public TextView gIh;
    public LinearLayout gIi;
    private cb gyO;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private boolean gDn = false;
    private boolean gDp = true;
    private boolean gDq = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private int gIj = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.view.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (b.this.gyO != null && b.this.gyO.boj() != null && b.this.gGP != null) {
                    b.this.gGP.a(b.this.tabId, b.this.gDl, b.this.gyO);
                    return;
                }
                return;
            }
            l.showLongToast(b.this.mTbPageContext.getPageActivity(), b.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        }
    };

    public b(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_special_live_item_view, (ViewGroup) null, false);
        this.gDb = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.gIg = (TextView) this.mRootView.findViewById(R.id.tvLiveFrom);
        this.gDc = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.gDd = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.bEn = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.gIh = (TextView) this.mRootView.findViewById(R.id.tv_extra);
        this.gIi = (LinearLayout) this.mRootView.findViewById(R.id.challenge_root);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.gDb.setBorderSurroundContent(true);
        this.gDb.setDrawBorder(true);
        this.gFf = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.gDo = new AlphaAnimation(0.0f, 1.0f);
        this.gDo.setDuration(200L);
        this.gDo.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.view.b.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                b.this.gDq = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                b.this.gDq = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public View getView() {
        return this.mRootView;
    }

    public void c(g gVar) {
        this.gGP = gVar;
    }

    public void b(e eVar) {
        a(eVar, -1);
    }

    public void a(e eVar, int i) {
        if (eVar == null || eVar.gyO == null || eVar.gyO.boj() == null) {
            getView().setVisibility(4);
            return;
        }
        if (this.gIj != l.getEquipmentWidth(this.mRootView.getContext())) {
            this.gIj = l.getEquipmentWidth(this.mRootView.getContext());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gDd.getLayoutParams();
            layoutParams.width = (this.gIj - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
            layoutParams.height = layoutParams.width;
            this.gDd.setLayoutParams(layoutParams);
        }
        getView().setVisibility(0);
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
        this.mCoverUrl = this.gyO.boj().cover;
        this.gDb.setTag(this.mCoverUrl);
        this.gDb.startLoad(this.gyO.boj().cover, 10, false);
        this.gDb.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.view.b.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z && b.this.gDn && !b.this.gDq) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        b.this.gDb.startAnimation(b.this.gDo);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        });
        this.gDc.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, au.numberUniformFormatExtra(this.gyO.boj().audience_count)));
        if (this.gyO.bnQ() != null) {
            String name_show = this.gyO.bnQ().getName_show();
            if (ag.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ag.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.bEn.setText(name_show);
        }
        if (!StringUtils.isNull(this.gyO.mRecomExtra)) {
            this.gIh.setVisibility(0);
            this.gIi.setVisibility(8);
            this.gIh.setText(this.gyO.mRecomExtra);
            GradientDrawable gradientDrawable = new GradientDrawable();
            float dimensionPixelSize = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize, dimensionPixelSize, 0.0f, 0.0f});
            gradientDrawable.setColor(-50901);
            this.gIh.setBackgroundDrawable(gradientDrawable);
        } else if (this.gyO.boj().label != null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            float dimensionPixelSize2 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize2, dimensionPixelSize2, 0.0f, 0.0f});
            if (!StringUtils.isNull(this.gyO.boj().label.labelColor)) {
                gradientDrawable2.setColor(Color.parseColor(this.gyO.boj().label.labelColor));
            }
            this.gIh.setBackgroundDrawable(gradientDrawable2);
            this.gIh.setText(this.gyO.boj().label.labelName);
            this.gIh.setVisibility(0);
            this.gIi.setVisibility(8);
        } else if (this.gyO.boj().mChallengeInfoData != null && this.gyO.boj().mChallengeInfoData.challenge_id > 0) {
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            float dimensionPixelSize3 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable3.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize3, dimensionPixelSize3, 0.0f, 0.0f});
            gradientDrawable3.setColor(-50901);
            this.gIi.setBackground(gradientDrawable3);
            this.gIi.setVisibility(0);
            this.gIh.setVisibility(8);
        } else {
            this.gIh.setVisibility(8);
            this.gIi.setVisibility(8);
        }
        if (this.gyO.boj().haveRedpkg) {
            this.gFf.setVisibility(0);
        } else {
            this.gFf.setVisibility(8);
        }
        if (this.gyO != null) {
            if (i == 2) {
                TiebaStatic.log(new ar("c12899").dR("tid", this.gyO.getTid()));
            } else if (i == 1) {
                TiebaStatic.log(new ar("c12903").dR("tid", this.gyO.getTid()));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gDd, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gDc, R.color.CAM_X0101);
            ap.setViewTextColor(this.bEn, R.color.CAM_X0101);
            ap.setViewTextColor(this.gIh, R.color.CAM_X0111, 1, 0);
            ap.getDrawable(this.mTbPageContext.getResources(), R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14));
            this.gDc.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(this.mTbPageContext.getResources(), R.drawable.icon_video_direct_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
            this.mSkinType = i;
        }
    }
}
