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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class TabLiveStageLiveView extends AlaRoundRelativeLayout {
    private static final float eiM = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] ekE = {0.0f, 0.0f, 0.0f, 0.0f, eiM, eiM, eiM, eiM};
    private bj Nl;
    private TextView bXt;
    private int[] eiQ;
    private View ekA;
    private TextView ekB;
    private View ekC;
    private TabLiveStageLiveZanLottieView ekD;
    private TbImageView eky;
    private HeadImageView ekz;
    private TextView mTitle;
    private int mType;

    public TabLiveStageLiveView(Context context) {
        super(context);
        this.mType = 101;
        this.eiQ = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 101;
        this.eiQ = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 101;
        this.eiQ = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.tab_stage_view, this);
        setRoundLayoutRadius(new float[]{eiM, eiM, eiM, eiM, eiM, eiM, eiM, eiM});
        this.ekD = (TabLiveStageLiveZanLottieView) findViewById(R.id.zan_lottie_view);
        this.ekD.setForbidAutoUpdateState(true);
        this.eky = (TbImageView) findViewById(R.id.cover);
        this.eky.setBackgroundColor(0);
        this.eky.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.eky.setConrers(15);
        this.ekz = (HeadImageView) findViewById(R.id.head_img);
        this.ekz.setAutoChangeStyle(false);
        this.ekz.setClickable(true);
        this.ekz.setIsRound(true);
        this.ekz.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds1));
        this.ekA = findViewById(R.id.head_mask_view);
        this.mTitle = (TextView) findViewById(R.id.title);
        this.bXt = (TextView) findViewById(R.id.user_name);
        this.ekB = (TextView) findViewById(R.id.audience_count);
        this.ekC = findViewById(R.id.bottom_gradient_bg);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.eiQ);
        gradientDrawable.setCornerRadii(ekE);
        this.ekC.setBackgroundDrawable(gradientDrawable);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.TabLiveStageLiveView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.ala.alasquare.live_tab.b.a(TabLiveStageLiveView.this.getContext(), TabLiveStageLiveView.this.Nl);
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
        bak();
    }

    public void setData(bj bjVar, int i) {
        if (bjVar != null) {
            this.Nl = bjVar;
            this.mType = i;
            this.eky.setPlaceHolder(3);
            this.eky.startLoad(bjVar.azX().cover, 10, false);
            if (bjVar.azE() != null) {
                String name_show = bjVar.azE().getName_show();
                if (ad.getTextLengthWithEmoji(name_show) > 16) {
                    name_show = ad.subStringWithEmoji(name_show, 16) + StringHelper.STRING_MORE;
                }
                this.bXt.setText(name_show);
                AlaUtilHelper.startLoadPortrait(this.ekz, bjVar.azE().getPortrait(), false);
                if (1 == TbadkCoreApplication.getInst().getSkinType()) {
                    this.ekA.setVisibility(0);
                } else {
                    this.ekA.setVisibility(8);
                }
            }
            this.mTitle.setText(bjVar.getTitle());
            this.ekB.setText(getContext().getResources().getString(R.string.square_sub_live_audience_label, aq.bx(bjVar.azX().audience_count)));
        }
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.bXt, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.ekB, (int) R.color.cp_cont_a);
        Drawable drawable = am.getDrawable(getContext().getResources(), (int) R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18), getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.ekB.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.ekB.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelOffset(R.dimen.tbds8));
    }

    private void bak() {
        this.ekD.setAnimation("zan_lottie_anim.json");
        this.ekD.setImageAssetsFolder("images/");
        this.ekD.loop(true);
        this.ekD.playAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.ekD != null && !this.ekD.isAnimating()) {
            this.ekD.playAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.ekD != null && this.ekD.isAnimating()) {
            this.ekD.pauseAnimation();
        }
        super.onDetachedFromWindow();
    }
}
