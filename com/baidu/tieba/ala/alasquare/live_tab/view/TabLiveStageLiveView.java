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
    private static final float dxK = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] dzE = {0.0f, 0.0f, 0.0f, 0.0f, dxK, dxK, dxK, dxK};
    private bh cqG;
    private TextView crw;
    private int[] dxO;
    private View dzA;
    private TextView dzB;
    private View dzC;
    private TabLiveStageLiveZanLottieView dzD;
    private TbImageView dzy;
    private HeadImageView dzz;
    private TextView mTitle;
    private int mType;

    public TabLiveStageLiveView(Context context) {
        super(context);
        this.mType = 101;
        this.dxO = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 101;
        this.dxO = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 101;
        this.dxO = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.tab_stage_view, this);
        setRoundLayoutRadius(new float[]{dxK, dxK, dxK, dxK, dxK, dxK, dxK, dxK});
        this.dzD = (TabLiveStageLiveZanLottieView) findViewById(R.id.zan_lottie_view);
        this.dzD.setForbidAutoUpdateState(true);
        this.dzy = (TbImageView) findViewById(R.id.cover);
        this.dzy.setBackgroundColor(0);
        this.dzy.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.dzy.setConrers(15);
        this.dzz = (HeadImageView) findViewById(R.id.head_img);
        this.dzz.setAutoChangeStyle(false);
        this.dzz.setClickable(true);
        this.dzz.setIsRound(true);
        this.dzz.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds1));
        this.dzA = findViewById(R.id.head_mask_view);
        this.mTitle = (TextView) findViewById(R.id.title);
        this.crw = (TextView) findViewById(R.id.user_name);
        this.dzB = (TextView) findViewById(R.id.audience_count);
        this.dzC = findViewById(R.id.bottom_gradient_bg);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.dxO);
        gradientDrawable.setCornerRadii(dzE);
        this.dzC.setBackgroundDrawable(gradientDrawable);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.TabLiveStageLiveView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.ala.alasquare.live_tab.b.a(TabLiveStageLiveView.this.getContext(), TabLiveStageLiveView.this.cqG);
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
        aJL();
    }

    public void setData(bh bhVar, int i) {
        if (bhVar != null) {
            this.cqG = bhVar;
            this.mType = i;
            this.dzy.setDefaultBgResource(com.baidu.tbadk.util.e.Vj());
            this.dzy.startLoad(bhVar.aiX().cover, 10, false);
            if (bhVar.aiE() != null) {
                String name_show = bhVar.aiE().getName_show();
                if (aa.getTextLengthWithEmoji(name_show) > 16) {
                    name_show = aa.subStringWithEmoji(name_show, 16) + StringHelper.STRING_MORE;
                }
                this.crw.setText(name_show);
                AlaUtilHelper.startLoadPortrait(this.dzz, bhVar.aiE().getPortrait(), false);
                if (1 == TbadkCoreApplication.getInst().getSkinType()) {
                    this.dzA.setVisibility(0);
                } else {
                    this.dzA.setVisibility(8);
                }
            }
            this.mTitle.setText(bhVar.getTitle());
            this.dzB.setText(getContext().getResources().getString(R.string.square_sub_live_audience_label, aq.aS(bhVar.aiX().audience_count)));
        }
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.crw, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.dzB, (int) R.color.cp_cont_a);
        Drawable drawable = am.getDrawable(getContext().getResources(), (int) R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18), getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.dzB.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.dzB.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelOffset(R.dimen.tbds8));
    }

    private void aJL() {
        this.dzD.setAnimation("zan_lottie_anim.json");
        this.dzD.setImageAssetsFolder("images/");
        this.dzD.loop(true);
        this.dzD.playAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.dzD != null && !this.dzD.isAnimating()) {
            this.dzD.playAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.dzD != null && this.dzD.isAnimating()) {
            this.dzD.pauseAnimation();
        }
        super.onDetachedFromWindow();
    }
}
