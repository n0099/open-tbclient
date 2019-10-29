package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.ala.utils.AlaUtilHelper;
import com.baidu.ala.view.AlaRoundRelativeLayout;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class TabLiveStageLiveView extends AlaRoundRelativeLayout {
    private bh cry;
    private TextView csn;
    private TbImageView dAp;
    private HeadImageView dAq;
    private View dAr;
    private TextView dAs;
    private View dAt;
    private TabLiveStageLiveZanLottieView dAu;
    private int[] dyF;
    private TextView mTitle;
    private int mType;
    private static final float dyB = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] dAv = {0.0f, 0.0f, 0.0f, 0.0f, dyB, dyB, dyB, dyB};

    public TabLiveStageLiveView(Context context) {
        super(context);
        this.mType = 101;
        this.dyF = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 101;
        this.dyF = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 101;
        this.dyF = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.tab_stage_view, this);
        setRoundLayoutRadius(new float[]{dyB, dyB, dyB, dyB, dyB, dyB, dyB, dyB});
        this.dAu = (TabLiveStageLiveZanLottieView) findViewById(R.id.zan_lottie_view);
        this.dAu.setForbidAutoUpdateState(true);
        this.dAp = (TbImageView) findViewById(R.id.cover);
        this.dAp.setBackgroundColor(0);
        this.dAp.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.dAp.setConrers(15);
        this.dAq = (HeadImageView) findViewById(R.id.head_img);
        this.dAq.setAutoChangeStyle(false);
        this.dAq.setClickable(true);
        this.dAq.setIsRound(true);
        this.dAq.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds1));
        this.dAr = findViewById(R.id.head_mask_view);
        this.mTitle = (TextView) findViewById(R.id.title);
        this.csn = (TextView) findViewById(R.id.user_name);
        this.dAs = (TextView) findViewById(R.id.audience_count);
        this.dAt = findViewById(R.id.bottom_gradient_bg);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.dyF);
        gradientDrawable.setCornerRadii(dAv);
        this.dAt.setBackgroundDrawable(gradientDrawable);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.TabLiveStageLiveView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.ala.alasquare.live_tab.b.a(TabLiveStageLiveView.this.getContext(), TabLiveStageLiveView.this.cry);
                if (TabLiveStageLiveView.this.mType != 101) {
                    if (TabLiveStageLiveView.this.mType == 102) {
                        TiebaStatic.log("c13559");
                        return;
                    }
                    return;
                }
                TiebaStatic.log("c13556");
            }
        });
        aJN();
    }

    public void setData(bh bhVar, int i) {
        if (bhVar != null) {
            this.cry = bhVar;
            this.mType = i;
            this.dAp.setDefaultBgResource(com.baidu.tbadk.util.e.Vl());
            this.dAp.startLoad(bhVar.aiZ().cover, 10, false);
            if (bhVar.aiG() != null) {
                String name_show = bhVar.aiG().getName_show();
                if (aa.getTextLengthWithEmoji(name_show) > 16) {
                    name_show = aa.subStringWithEmoji(name_show, 16) + StringHelper.STRING_MORE;
                }
                this.csn.setText(name_show);
                AlaUtilHelper.startLoadPortrait(this.dAq, bhVar.aiG().getPortrait(), false);
                if (1 == TbadkCoreApplication.getInst().getSkinType()) {
                    this.dAr.setVisibility(0);
                } else {
                    this.dAr.setVisibility(8);
                }
            }
            this.mTitle.setText(bhVar.getTitle());
            this.dAs.setText(getContext().getResources().getString(R.string.square_sub_live_audience_label, aq.aT(bhVar.aiZ().audience_count)));
        }
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.csn, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.dAs, (int) R.color.cp_cont_a);
        Drawable drawable = am.getDrawable(getContext().getResources(), (int) R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18), getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.dAs.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.dAs.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelOffset(R.dimen.tbds8));
    }

    private void aJN() {
        this.dAu.setAnimation("zan_lottie_anim.json");
        this.dAu.setImageAssetsFolder("images/");
        this.dAu.loop(true);
        this.dAu.playAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.dAu != null && !this.dAu.isAnimating()) {
            this.dAu.playAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.dAu != null && this.dAu.isAnimating()) {
            this.dAu.pauseAnimation();
        }
        super.onDetachedFromWindow();
    }
}
