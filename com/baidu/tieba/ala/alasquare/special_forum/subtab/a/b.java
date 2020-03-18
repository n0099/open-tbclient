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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b {
    private bj ekm;
    public TbImageView eok;
    public TextView eol;
    public RelativeLayout eom;
    public TextView eon;
    private String eov;
    private AlphaAnimation eoy;
    public ImageView eql;
    private com.baidu.tieba.ala.alasquare.subtablist.c.i erT;
    public TextView etl;
    public TextView etm;
    public LinearLayout etn;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private boolean eox = false;
    private boolean eoz = true;
    private boolean eoA = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private int eto = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (b.this.ekm != null && b.this.ekm.aCK() != null && b.this.erT != null) {
                    b.this.erT.a(b.this.tabId, b.this.eov, b.this.ekm);
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
        this.eok = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.etl = (TextView) this.mRootView.findViewById(R.id.tvLiveFrom);
        this.eol = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.eom = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.eon = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.etm = (TextView) this.mRootView.findViewById(R.id.tv_extra);
        this.etn = (LinearLayout) this.mRootView.findViewById(R.id.challenge_root);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.eok.setBorderSurroundContent(true);
        this.eok.setDrawBorder(true);
        this.eql = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.eoy = new AlphaAnimation(0.0f, 1.0f);
        this.eoy.setDuration(200L);
        this.eoy.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                b.this.eoA = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                b.this.eoA = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public View getView() {
        return this.mRootView;
    }

    public void c(com.baidu.tieba.ala.alasquare.subtablist.c.i iVar) {
        this.erT = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        a(cVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.c cVar, int i) {
        if (cVar == null || cVar.ekm == null || cVar.ekm.aCK() == null) {
            getView().setVisibility(4);
            return;
        }
        if (this.eto != l.getEquipmentWidth(this.mRootView.getContext())) {
            this.eto = l.getEquipmentWidth(this.mRootView.getContext());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eom.getLayoutParams();
            layoutParams.width = (this.eto - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
            layoutParams.height = layoutParams.width;
            this.eom.setLayoutParams(layoutParams);
        }
        getView().setVisibility(0);
        this.ekm = cVar.ekm;
        this.tabId = cVar.tabId;
        this.eov = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        Object tag = this.eok.getTag();
        if (this.eoz) {
            this.eox = true;
            this.eoz = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.ekm.aCK().cover) && !((String) tag).equals(this.ekm.aCK().cover)) {
            this.eox = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.ekm.aCK().cover) && !this.mCoverUrl.equals(this.ekm.aCK().cover)) {
            this.eox = true;
        } else {
            this.eox = false;
        }
        this.mCoverUrl = this.ekm.aCK().cover;
        this.eok.setTag(this.mCoverUrl);
        this.eok.startLoad(this.ekm.aCK().cover, 10, false);
        this.eok.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && b.this.eox && !b.this.eoA) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        b.this.eok.startAnimation(b.this.eoy);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.eol.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.numberUniformFormatExtra(this.ekm.aCK().audience_count)));
        if (this.ekm.aCr() != null) {
            String name_show = this.ekm.aCr().getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.eon.setText(name_show);
        }
        if (!StringUtils.isNull(this.ekm.mRecomExtra)) {
            this.etm.setVisibility(0);
            this.etn.setVisibility(8);
            this.etm.setText(this.ekm.mRecomExtra);
            GradientDrawable gradientDrawable = new GradientDrawable();
            float dimensionPixelSize = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize, dimensionPixelSize, 0.0f, 0.0f});
            gradientDrawable.setColor(-50901);
            this.etm.setBackgroundDrawable(gradientDrawable);
        } else if (this.ekm.aCK().label != null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            float dimensionPixelSize2 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize2, dimensionPixelSize2, 0.0f, 0.0f});
            if (!StringUtils.isNull(this.ekm.aCK().label.labelColor)) {
                gradientDrawable2.setColor(Color.parseColor(this.ekm.aCK().label.labelColor));
            }
            this.etm.setBackgroundDrawable(gradientDrawable2);
            this.etm.setText(this.ekm.aCK().label.labelName);
            this.etm.setVisibility(0);
            this.etn.setVisibility(8);
        } else if (this.ekm.aCK().mChallengeInfoData != null && this.ekm.aCK().mChallengeInfoData.challenge_id > 0) {
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            float dimensionPixelSize3 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable3.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize3, dimensionPixelSize3, 0.0f, 0.0f});
            gradientDrawable3.setColor(-50901);
            this.etn.setBackground(gradientDrawable3);
            this.etn.setVisibility(0);
            this.etm.setVisibility(8);
        } else {
            this.etm.setVisibility(8);
            this.etn.setVisibility(8);
        }
        if (this.ekm.aCK().haveRedpkg) {
            this.eql.setVisibility(0);
        } else {
            this.eql.setVisibility(8);
        }
        if (this.ekm != null) {
            if (i == 2) {
                TiebaStatic.log(new an("c12899").cx("tid", this.ekm.getTid()));
            } else if (i == 1) {
                TiebaStatic.log(new an("c12903").cx("tid", this.ekm.getTid()));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eom, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.eol, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eon, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.etm, R.color.cp_cont_g, 1, 0);
            am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14));
            this.eol.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.icon_video_direct_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
            this.mSkinType = i;
        }
    }
}
