package com.baidu.tieba.ala.alasquare.special_forum.subtab.a;

import android.graphics.Color;
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
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.subtablist.c.h;
/* loaded from: classes6.dex */
public class a {
    private h dBR;
    public TextView dCV;
    public TextView dCW;
    public LinearLayout dCX;
    private bh dvi;
    private String dyG;
    private AlphaAnimation dyJ;
    public TbImageView dyv;
    public TextView dyw;
    public RelativeLayout dyx;
    public TextView dyy;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private boolean dyI = false;
    private boolean dyK = true;
    private boolean dyL = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private int dCY = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (a.this.dvi != null && a.this.dvi.aiZ() != null && a.this.dBR != null) {
                    a.this.dBR.a(a.this.tabId, a.this.dyG, a.this.dvi);
                    return;
                }
                return;
            }
            l.showLongToast(a.this.mTbPageContext.getPageActivity(), a.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        }
    };

    public a(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_special_live_item_view, (ViewGroup) null, false);
        this.dyv = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.dCV = (TextView) this.mRootView.findViewById(R.id.tvLiveFrom);
        this.dyw = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.dyx = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.dyy = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.dCW = (TextView) this.mRootView.findViewById(R.id.tv_extra);
        this.dCX = (LinearLayout) this.mRootView.findViewById(R.id.challenge_root);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.dyv.setBorderSurroundContent(true);
        this.dyv.setDrawBorder(true);
        this.dyJ = new AlphaAnimation(0.0f, 1.0f);
        this.dyJ.setDuration(200L);
        this.dyJ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.a.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                a.this.dyL = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                a.this.dyL = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public View getView() {
        return this.mRootView;
    }

    public void c(h hVar) {
        this.dBR = hVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.b bVar) {
        a(bVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.b bVar, int i) {
        if (bVar == null || bVar.dvi == null || bVar.dvi.aiZ() == null) {
            getView().setVisibility(4);
            return;
        }
        if (this.dCY != l.getEquipmentWidth(this.mRootView.getContext())) {
            this.dCY = l.getEquipmentWidth(this.mRootView.getContext());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dyx.getLayoutParams();
            layoutParams.width = (this.dCY - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
            layoutParams.height = layoutParams.width;
            this.dyx.setLayoutParams(layoutParams);
        }
        getView().setVisibility(0);
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
        this.mCoverUrl = this.dvi.aiZ().cover;
        this.dyv.setTag(this.mCoverUrl);
        this.dyv.startLoad(this.dvi.aiZ().cover, 10, false);
        this.dyv.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.a.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && a.this.dyI && !a.this.dyL) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        a.this.dyv.startAnimation(a.this.dyJ);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.dyw.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.numberUniformFormatExtra(this.dvi.aiZ().audience_count)));
        if (this.dvi.aiG() != null) {
            String name_show = this.dvi.aiG().getName_show();
            if (aa.getTextLengthWithEmoji(name_show) > 10) {
                name_show = aa.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.dyy.setText(name_show);
        }
        if (!StringUtils.isNull(this.dvi.mRecomExtra)) {
            this.dCW.setVisibility(0);
            this.dCX.setVisibility(8);
            this.dCW.setText(this.dvi.mRecomExtra);
            this.dCW.setBackgroundResource(R.drawable.special_live_item_extra_bg);
        } else if (this.dvi.aiZ().label != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds4));
            if (!StringUtils.isNull(this.dvi.aiZ().label.labelColor)) {
                gradientDrawable.setColor(Color.parseColor(this.dvi.aiZ().label.labelColor));
            }
            this.dCW.setBackgroundDrawable(gradientDrawable);
            this.dCW.setText(this.dvi.aiZ().label.labelName);
            this.dCW.setVisibility(0);
            this.dCX.setVisibility(8);
        } else if (this.dvi.aiZ().mChallengeInfoData != null && this.dvi.aiZ().mChallengeInfoData.challenge_id > 0) {
            this.dCX.setVisibility(0);
            this.dCW.setVisibility(8);
        } else {
            this.dCW.setVisibility(8);
            this.dCX.setVisibility(8);
        }
        if (this.dvi != null) {
            if (i == 2) {
                TiebaStatic.log(new an("c12899").bS("tid", this.dvi.getTid()));
            } else if (i == 1) {
                TiebaStatic.log(new an("c12903").bS("tid", this.dvi.getTid()));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.dyx, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.dyw, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dyy, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dCW, R.color.cp_cont_g, 1, 0);
            am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14));
            this.dyw.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.icon_video_direct_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
            this.mSkinType = i;
        }
    }
}
