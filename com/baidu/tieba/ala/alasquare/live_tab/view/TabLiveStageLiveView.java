package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.ala.utils.AlaUtilHelper;
import com.baidu.ala.view.AlaRoundRelativeLayout;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class TabLiveStageLiveView extends AlaRoundRelativeLayout {
    private static final float feA = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] fgI = {0.0f, 0.0f, 0.0f, 0.0f, feA, feA, feA, feA};
    private TextView dXU;
    private int[] feE;
    private TbImageView fgB;
    private HeadImageView fgC;
    private View fgD;
    private TextView fgE;
    private View fgF;
    private TabLiveStageLiveZanLottieView fgG;
    private SdkLiveInfoData fgH;
    private TextView mTitle;
    private int mType;

    public TabLiveStageLiveView(Context context) {
        super(context);
        this.mType = 101;
        this.feE = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 101;
        this.feE = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 101;
        this.feE = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.tab_stage_view, this);
        setRoundLayoutRadius(new float[]{feA, feA, feA, feA, feA, feA, feA, feA});
        this.fgG = (TabLiveStageLiveZanLottieView) findViewById(R.id.zan_lottie_view);
        this.fgG.setForbidAutoUpdateState(true);
        this.fgB = (TbImageView) findViewById(R.id.cover);
        this.fgB.setBackgroundColor(0);
        this.fgB.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.fgB.setConrers(15);
        this.fgC = (HeadImageView) findViewById(R.id.head_img);
        this.fgC.setAutoChangeStyle(false);
        this.fgC.setClickable(true);
        this.fgC.setIsRound(true);
        this.fgC.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds1));
        this.fgD = findViewById(R.id.head_mask_view);
        this.mTitle = (TextView) findViewById(R.id.title);
        this.dXU = (TextView) findViewById(R.id.user_name);
        this.fgE = (TextView) findViewById(R.id.audience_count);
        this.fgF = findViewById(R.id.bottom_gradient_bg);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.feE);
        gradientDrawable.setCornerRadii(fgI);
        this.fgF.setBackgroundDrawable(gradientDrawable);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.TabLiveStageLiveView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.ala.alasquare.live_tab.c.a(TabLiveStageLiveView.this.getContext(), TabLiveStageLiveView.this.fgH);
                if (TabLiveStageLiveView.this.mType != 101) {
                    if (TabLiveStageLiveView.this.mType == 102) {
                        an anVar = new an("c13559");
                        anVar.dh("entryname", "推荐");
                        TiebaStatic.log(anVar);
                        return;
                    }
                    return;
                }
                an anVar2 = new an("c13556");
                anVar2.dh("entryname", "推荐");
                TiebaStatic.log(anVar2);
            }
        });
        brp();
    }

    public void setData(SdkLiveInfoData sdkLiveInfoData, int i) {
        if (sdkLiveInfoData == null || sdkLiveInfoData.liveInfo == null) {
            setVisibility(4);
            return;
        }
        this.fgH = sdkLiveInfoData;
        this.mType = i;
        this.fgB.setPlaceHolder(3);
        this.fgB.startLoad(sdkLiveInfoData.liveInfo.cover, 10, false);
        if (sdkLiveInfoData.liveAuthor != null) {
            String name_show = sdkLiveInfoData.liveAuthor.getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 16) {
                name_show = ae.subStringWithEmoji(name_show, 16) + StringHelper.STRING_MORE;
            }
            this.dXU.setText(name_show);
            AlaUtilHelper.startLoadPortrait(this.fgC, sdkLiveInfoData.liveAuthor.portrait, false);
            if (1 == TbadkCoreApplication.getInst().getSkinType()) {
                this.fgD.setVisibility(0);
            } else {
                this.fgD.setVisibility(8);
            }
        }
        this.mTitle.setText(sdkLiveInfoData.title);
        this.fgE.setText(getContext().getResources().getString(R.string.square_sub_live_audience_label, aq.cl(sdkLiveInfoData.liveInfo.audienceCount)));
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.dXU, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.fgE, (int) R.color.cp_cont_a);
        Drawable drawable = am.getDrawable(getContext().getResources(), (int) R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18), getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.fgE.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.fgE.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelOffset(R.dimen.tbds8));
    }

    private void brp() {
        try {
            this.fgG.setAnimation("zan_lottie_anim.json");
            this.fgG.setImageAssetsFolder("images/");
            this.fgG.loop(true);
            this.fgG.playAnimation();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.fgG != null && !this.fgG.isAnimating()) {
            this.fgG.playAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.fgG != null && this.fgG.isAnimating()) {
            this.fgG.pauseAnimation();
        }
        super.onDetachedFromWindow();
    }
}
