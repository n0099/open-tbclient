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
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class TabLiveStageLiveView extends AlaRoundRelativeLayout {
    private static final float enL = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] epP = {0.0f, 0.0f, 0.0f, 0.0f, enL, enL, enL, enL};
    private TextView cbK;
    private int[] enP;
    private TbImageView epI;
    private HeadImageView epJ;
    private View epK;
    private TextView epL;
    private View epM;
    private TabLiveStageLiveZanLottieView epN;
    private SdkLiveInfoData epO;
    private TextView mTitle;
    private int mType;

    public TabLiveStageLiveView(Context context) {
        super(context);
        this.mType = 101;
        this.enP = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 101;
        this.enP = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 101;
        this.enP = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.tab_stage_view, this);
        setRoundLayoutRadius(new float[]{enL, enL, enL, enL, enL, enL, enL, enL});
        this.epN = (TabLiveStageLiveZanLottieView) findViewById(R.id.zan_lottie_view);
        this.epN.setForbidAutoUpdateState(true);
        this.epI = (TbImageView) findViewById(R.id.cover);
        this.epI.setBackgroundColor(0);
        this.epI.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.epI.setConrers(15);
        this.epJ = (HeadImageView) findViewById(R.id.head_img);
        this.epJ.setAutoChangeStyle(false);
        this.epJ.setClickable(true);
        this.epJ.setIsRound(true);
        this.epJ.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds1));
        this.epK = findViewById(R.id.head_mask_view);
        this.mTitle = (TextView) findViewById(R.id.title);
        this.cbK = (TextView) findViewById(R.id.user_name);
        this.epL = (TextView) findViewById(R.id.audience_count);
        this.epM = findViewById(R.id.bottom_gradient_bg);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.enP);
        gradientDrawable.setCornerRadii(epP);
        this.epM.setBackgroundDrawable(gradientDrawable);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.TabLiveStageLiveView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.ala.alasquare.live_tab.c.a(TabLiveStageLiveView.this.getContext(), TabLiveStageLiveView.this.epO);
                if (TabLiveStageLiveView.this.mType != 101) {
                    if (TabLiveStageLiveView.this.mType == 102) {
                        an anVar = new an("c13559");
                        anVar.cy("entryname", "推荐");
                        TiebaStatic.log(anVar);
                        return;
                    }
                    return;
                }
                an anVar2 = new an("c13556");
                anVar2.cy("entryname", "推荐");
                TiebaStatic.log(anVar2);
            }
        });
        bcW();
    }

    public void setData(SdkLiveInfoData sdkLiveInfoData, int i) {
        if (sdkLiveInfoData == null || sdkLiveInfoData.liveInfo == null) {
            setVisibility(4);
            return;
        }
        this.epO = sdkLiveInfoData;
        this.mType = i;
        this.epI.setPlaceHolder(3);
        this.epI.startLoad(sdkLiveInfoData.liveInfo.cover, 10, false);
        if (sdkLiveInfoData.liveAuthor != null) {
            String name_show = sdkLiveInfoData.liveAuthor.getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 16) {
                name_show = ad.subStringWithEmoji(name_show, 16) + StringHelper.STRING_MORE;
            }
            this.cbK.setText(name_show);
            AlaUtilHelper.startLoadPortrait(this.epJ, sdkLiveInfoData.liveAuthor.portrait, false);
            if (1 == TbadkCoreApplication.getInst().getSkinType()) {
                this.epK.setVisibility(0);
            } else {
                this.epK.setVisibility(8);
            }
        }
        this.mTitle.setText(sdkLiveInfoData.title);
        this.epL.setText(getContext().getResources().getString(R.string.square_sub_live_audience_label, aq.bE(sdkLiveInfoData.liveInfo.audienceCount)));
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.cbK, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.epL, (int) R.color.cp_cont_a);
        Drawable drawable = am.getDrawable(getContext().getResources(), (int) R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18), getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.epL.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.epL.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelOffset(R.dimen.tbds8));
    }

    private void bcW() {
        try {
            this.epN.setAnimation("zan_lottie_anim.json");
            this.epN.setImageAssetsFolder("images/");
            this.epN.loop(true);
            this.epN.playAnimation();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.epN != null && !this.epN.isAnimating()) {
            this.epN.playAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.epN != null && this.epN.isAnimating()) {
            this.epN.pauseAnimation();
        }
        super.onDetachedFromWindow();
    }
}
