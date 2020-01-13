package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.ala.utils.AlaUtilHelper;
import com.baidu.ala.view.AlaRoundRelativeLayout;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class TabLiveStageLiveView extends AlaRoundRelativeLayout {
    private static final float ejA = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] elA = {0.0f, 0.0f, 0.0f, 0.0f, ejA, ejA, ejA, ejA};
    private bj Np;
    private TextView bXF;
    private int[] ejE;
    private TbImageView elu;
    private HeadImageView elv;
    private View elw;
    private TextView elx;
    private View ely;
    private TabLiveStageLiveZanLottieView elz;
    private TextView mTitle;
    private int mType;

    public TabLiveStageLiveView(Context context) {
        super(context);
        this.mType = 101;
        this.ejE = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 101;
        this.ejE = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 101;
        this.ejE = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.tab_stage_view, this);
        setRoundLayoutRadius(new float[]{ejA, ejA, ejA, ejA, ejA, ejA, ejA, ejA});
        this.elz = (TabLiveStageLiveZanLottieView) findViewById(R.id.zan_lottie_view);
        this.elz.setForbidAutoUpdateState(true);
        this.elu = (TbImageView) findViewById(R.id.cover);
        this.elu.setBackgroundColor(0);
        this.elu.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.elu.setConrers(15);
        this.elv = (HeadImageView) findViewById(R.id.head_img);
        this.elv.setAutoChangeStyle(false);
        this.elv.setClickable(true);
        this.elv.setIsRound(true);
        this.elv.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds1));
        this.elw = findViewById(R.id.head_mask_view);
        this.mTitle = (TextView) findViewById(R.id.title);
        this.bXF = (TextView) findViewById(R.id.user_name);
        this.elx = (TextView) findViewById(R.id.audience_count);
        this.ely = findViewById(R.id.bottom_gradient_bg);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.ejE);
        gradientDrawable.setCornerRadii(elA);
        this.ely.setBackgroundDrawable(gradientDrawable);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.TabLiveStageLiveView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.ala.alasquare.live_tab.c.a(TabLiveStageLiveView.this.getContext(), TabLiveStageLiveView.this.Np);
                if (TabLiveStageLiveView.this.mType != 101) {
                    if (TabLiveStageLiveView.this.mType == 102) {
                        an anVar = new an("c13559");
                        anVar.cp("entryname", "推荐");
                        TiebaStatic.log(anVar);
                        return;
                    }
                    return;
                }
                an anVar2 = new an("c13556");
                anVar2.cp("entryname", "推荐");
                TiebaStatic.log(anVar2);
            }
        });
        baF();
    }

    public void setData(bj bjVar, int i) {
        if (bjVar != null) {
            this.Np = bjVar;
            this.mType = i;
            this.elu.setPlaceHolder(3);
            this.elu.startLoad(bjVar.aAq().cover, 10, false);
            if (bjVar.azX() != null) {
                String name_show = bjVar.azX().getName_show();
                if (ad.getTextLengthWithEmoji(name_show) > 16) {
                    name_show = ad.subStringWithEmoji(name_show, 16) + StringHelper.STRING_MORE;
                }
                this.bXF.setText(name_show);
                AlaUtilHelper.startLoadPortrait(this.elv, bjVar.azX().getPortrait(), false);
                if (1 == TbadkCoreApplication.getInst().getSkinType()) {
                    this.elw.setVisibility(0);
                } else {
                    this.elw.setVisibility(8);
                }
            }
            this.mTitle.setText(bjVar.getTitle());
            this.elx.setText(getContext().getResources().getString(R.string.square_sub_live_audience_label, aq.bA(bjVar.aAq().audience_count)));
        }
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.bXF, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.elx, (int) R.color.cp_cont_a);
        Drawable drawable = am.getDrawable(getContext().getResources(), (int) R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18), getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.elx.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.elx.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelOffset(R.dimen.tbds8));
    }

    private void baF() {
        this.elz.setAnimation("zan_lottie_anim.json");
        this.elz.setImageAssetsFolder("images/");
        this.elz.loop(true);
        this.elz.playAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.elz != null && !this.elz.isAnimating()) {
            this.elz.playAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.elz != null && this.elz.isAnimating()) {
            this.elz.pauseAnimation();
        }
        super.onDetachedFromWindow();
    }
}
