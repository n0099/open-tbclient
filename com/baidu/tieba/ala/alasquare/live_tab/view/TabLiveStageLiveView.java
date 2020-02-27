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
    private static final float enK = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] epO = {0.0f, 0.0f, 0.0f, 0.0f, enK, enK, enK, enK};
    private TextView cbJ;
    private int[] enO;
    private TbImageView epH;
    private HeadImageView epI;
    private View epJ;
    private TextView epK;
    private View epL;
    private TabLiveStageLiveZanLottieView epM;
    private SdkLiveInfoData epN;
    private TextView mTitle;
    private int mType;

    public TabLiveStageLiveView(Context context) {
        super(context);
        this.mType = 101;
        this.enO = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 101;
        this.enO = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 101;
        this.enO = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.tab_stage_view, this);
        setRoundLayoutRadius(new float[]{enK, enK, enK, enK, enK, enK, enK, enK});
        this.epM = (TabLiveStageLiveZanLottieView) findViewById(R.id.zan_lottie_view);
        this.epM.setForbidAutoUpdateState(true);
        this.epH = (TbImageView) findViewById(R.id.cover);
        this.epH.setBackgroundColor(0);
        this.epH.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.epH.setConrers(15);
        this.epI = (HeadImageView) findViewById(R.id.head_img);
        this.epI.setAutoChangeStyle(false);
        this.epI.setClickable(true);
        this.epI.setIsRound(true);
        this.epI.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds1));
        this.epJ = findViewById(R.id.head_mask_view);
        this.mTitle = (TextView) findViewById(R.id.title);
        this.cbJ = (TextView) findViewById(R.id.user_name);
        this.epK = (TextView) findViewById(R.id.audience_count);
        this.epL = findViewById(R.id.bottom_gradient_bg);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.enO);
        gradientDrawable.setCornerRadii(epO);
        this.epL.setBackgroundDrawable(gradientDrawable);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.TabLiveStageLiveView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.ala.alasquare.live_tab.c.a(TabLiveStageLiveView.this.getContext(), TabLiveStageLiveView.this.epN);
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
        bcU();
    }

    public void setData(SdkLiveInfoData sdkLiveInfoData, int i) {
        if (sdkLiveInfoData == null || sdkLiveInfoData.liveInfo == null) {
            setVisibility(4);
            return;
        }
        this.epN = sdkLiveInfoData;
        this.mType = i;
        this.epH.setPlaceHolder(3);
        this.epH.startLoad(sdkLiveInfoData.liveInfo.cover, 10, false);
        if (sdkLiveInfoData.liveAuthor != null) {
            String name_show = sdkLiveInfoData.liveAuthor.getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 16) {
                name_show = ad.subStringWithEmoji(name_show, 16) + StringHelper.STRING_MORE;
            }
            this.cbJ.setText(name_show);
            AlaUtilHelper.startLoadPortrait(this.epI, sdkLiveInfoData.liveAuthor.portrait, false);
            if (1 == TbadkCoreApplication.getInst().getSkinType()) {
                this.epJ.setVisibility(0);
            } else {
                this.epJ.setVisibility(8);
            }
        }
        this.mTitle.setText(sdkLiveInfoData.title);
        this.epK.setText(getContext().getResources().getString(R.string.square_sub_live_audience_label, aq.bE(sdkLiveInfoData.liveInfo.audienceCount)));
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.cbJ, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.epK, (int) R.color.cp_cont_a);
        Drawable drawable = am.getDrawable(getContext().getResources(), (int) R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18), getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.epK.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.epK.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelOffset(R.dimen.tbds8));
    }

    private void bcU() {
        try {
            this.epM.setAnimation("zan_lottie_anim.json");
            this.epM.setImageAssetsFolder("images/");
            this.epM.loop(true);
            this.epM.playAnimation();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.epM != null && !this.epM.isAnimating()) {
            this.epM.playAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.epM != null && this.epM.isAnimating()) {
            this.epM.pauseAnimation();
        }
        super.onDetachedFromWindow();
    }
}
