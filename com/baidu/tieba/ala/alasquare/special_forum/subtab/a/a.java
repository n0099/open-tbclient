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
    private h dBa;
    public TextView dCe;
    public TextView dCf;
    public LinearLayout dCg;
    private bh dur;
    public TbImageView dxE;
    public TextView dxF;
    public RelativeLayout dxG;
    public TextView dxH;
    private String dxP;
    private AlphaAnimation dxS;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private boolean dxR = false;
    private boolean dxT = true;
    private boolean dxU = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private int dCh = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (a.this.dur != null && a.this.dur.aiX() != null && a.this.dBa != null) {
                    a.this.dBa.a(a.this.tabId, a.this.dxP, a.this.dur);
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
        this.dxE = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.dCe = (TextView) this.mRootView.findViewById(R.id.tvLiveFrom);
        this.dxF = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.dxG = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.dxH = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.dCf = (TextView) this.mRootView.findViewById(R.id.tv_extra);
        this.dCg = (LinearLayout) this.mRootView.findViewById(R.id.challenge_root);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.dxE.setBorderSurroundContent(true);
        this.dxE.setDrawBorder(true);
        this.dxS = new AlphaAnimation(0.0f, 1.0f);
        this.dxS.setDuration(200L);
        this.dxS.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.a.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                a.this.dxU = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                a.this.dxU = false;
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
        this.dBa = hVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.b bVar) {
        a(bVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.b bVar, int i) {
        if (bVar == null || bVar.dur == null || bVar.dur.aiX() == null) {
            getView().setVisibility(4);
            return;
        }
        if (this.dCh != l.getEquipmentWidth(this.mRootView.getContext())) {
            this.dCh = l.getEquipmentWidth(this.mRootView.getContext());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dxG.getLayoutParams();
            layoutParams.width = (this.dCh - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
            layoutParams.height = layoutParams.width;
            this.dxG.setLayoutParams(layoutParams);
        }
        getView().setVisibility(0);
        this.dur = bVar.dur;
        this.tabId = bVar.tabId;
        this.dxP = !TextUtils.isEmpty(bVar.labelName) ? bVar.labelName : bVar.entryName;
        Object tag = this.dxE.getTag();
        if (this.dxT) {
            this.dxR = true;
            this.dxT = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.dur.aiX().cover) && !((String) tag).equals(this.dur.aiX().cover)) {
            this.dxR = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.dur.aiX().cover) && !this.mCoverUrl.equals(this.dur.aiX().cover)) {
            this.dxR = true;
        } else {
            this.dxR = false;
        }
        this.mCoverUrl = this.dur.aiX().cover;
        this.dxE.setTag(this.mCoverUrl);
        this.dxE.startLoad(this.dur.aiX().cover, 10, false);
        this.dxE.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.a.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && a.this.dxR && !a.this.dxU) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        a.this.dxE.startAnimation(a.this.dxS);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.dxF.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.numberUniformFormatExtra(this.dur.aiX().audience_count)));
        if (this.dur.aiE() != null) {
            String name_show = this.dur.aiE().getName_show();
            if (aa.getTextLengthWithEmoji(name_show) > 10) {
                name_show = aa.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.dxH.setText(name_show);
        }
        if (!StringUtils.isNull(this.dur.mRecomExtra)) {
            this.dCf.setVisibility(0);
            this.dCg.setVisibility(8);
            this.dCf.setText(this.dur.mRecomExtra);
            this.dCf.setBackgroundResource(R.drawable.special_live_item_extra_bg);
        } else if (this.dur.aiX().label != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds4));
            if (!StringUtils.isNull(this.dur.aiX().label.labelColor)) {
                gradientDrawable.setColor(Color.parseColor(this.dur.aiX().label.labelColor));
            }
            this.dCf.setBackgroundDrawable(gradientDrawable);
            this.dCf.setText(this.dur.aiX().label.labelName);
            this.dCf.setVisibility(0);
            this.dCg.setVisibility(8);
        } else if (this.dur.aiX().mChallengeInfoData != null && this.dur.aiX().mChallengeInfoData.challenge_id > 0) {
            this.dCg.setVisibility(0);
            this.dCf.setVisibility(8);
        } else {
            this.dCf.setVisibility(8);
            this.dCg.setVisibility(8);
        }
        if (this.dur != null) {
            if (i == 2) {
                TiebaStatic.log(new an("c12899").bS("tid", this.dur.getTid()));
            } else if (i == 1) {
                TiebaStatic.log(new an("c12903").bS("tid", this.dur.getTid()));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.dxG, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.dxF, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dxH, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dCf, R.color.cp_cont_g, 1, 0);
            am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14));
            this.dxF.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.icon_video_direct_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
            this.mSkinType = i;
        }
    }
}
