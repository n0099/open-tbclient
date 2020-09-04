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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class TabLiveStageLiveView extends AlaRoundRelativeLayout {
    private static final float fGD = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] fIL = {0.0f, 0.0f, 0.0f, 0.0f, fGD, fGD, fGD, fGD};
    private TextView dTU;
    private int[] fGH;
    private TbImageView fIE;
    private HeadImageView fIF;
    private View fIG;
    private TextView fIH;
    private View fII;
    private TabLiveStageLiveZanLottieView fIJ;
    private SdkLiveInfoData fIK;
    private TextView mTitle;
    private int mType;

    public TabLiveStageLiveView(Context context) {
        super(context);
        this.mType = 101;
        this.fGH = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 101;
        this.fGH = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 101;
        this.fGH = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.tab_stage_view, this);
        setRoundLayoutRadius(new float[]{fGD, fGD, fGD, fGD, fGD, fGD, fGD, fGD});
        this.fIJ = (TabLiveStageLiveZanLottieView) findViewById(R.id.zan_lottie_view);
        this.fIJ.setForbidAutoUpdateState(true);
        this.fIE = (TbImageView) findViewById(R.id.cover);
        this.fIE.setBackgroundColor(0);
        this.fIE.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.fIE.setConrers(15);
        this.fIF = (HeadImageView) findViewById(R.id.head_img);
        this.fIF.setAutoChangeStyle(false);
        this.fIF.setClickable(true);
        this.fIF.setIsRound(true);
        this.fIF.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds1));
        this.fIG = findViewById(R.id.head_mask_view);
        this.mTitle = (TextView) findViewById(R.id.title);
        this.dTU = (TextView) findViewById(R.id.user_name);
        this.fIH = (TextView) findViewById(R.id.audience_count);
        this.fII = findViewById(R.id.bottom_gradient_bg);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.fGH);
        gradientDrawable.setCornerRadii(fIL);
        this.fII.setBackgroundDrawable(gradientDrawable);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.TabLiveStageLiveView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.ala.alasquare.live_tab.c.a(TabLiveStageLiveView.this.getContext(), TabLiveStageLiveView.this.fIK);
                if (TabLiveStageLiveView.this.mType != 101) {
                    if (TabLiveStageLiveView.this.mType == 102) {
                        aq aqVar = new aq("c13559");
                        aqVar.dD("entryname", "推荐");
                        TiebaStatic.log(aqVar);
                        return;
                    }
                    return;
                }
                aq aqVar2 = new aq("c13556");
                aqVar2.dD("entryname", "推荐");
                TiebaStatic.log(aqVar2);
            }
        });
        bGx();
    }

    public void setData(SdkLiveInfoData sdkLiveInfoData, int i) {
        if (sdkLiveInfoData == null || sdkLiveInfoData.liveInfo == null) {
            setVisibility(4);
            return;
        }
        this.fIK = sdkLiveInfoData;
        this.mType = i;
        this.fIE.setPlaceHolder(3);
        this.fIE.startLoad(sdkLiveInfoData.liveInfo.cover, 10, false);
        if (sdkLiveInfoData.liveAuthor != null) {
            String name_show = sdkLiveInfoData.liveAuthor.getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 16) {
                name_show = ae.subStringWithEmoji(name_show, 16) + StringHelper.STRING_MORE;
            }
            this.dTU.setText(name_show);
            AlaUtilHelper.startLoadPortrait(this.fIF, sdkLiveInfoData.liveAuthor.portrait, false);
            if (1 == TbadkCoreApplication.getInst().getSkinType()) {
                this.fIG.setVisibility(0);
            } else {
                this.fIG.setVisibility(8);
            }
        }
        this.mTitle.setText(sdkLiveInfoData.title);
        this.fIH.setText(getContext().getResources().getString(R.string.square_sub_live_audience_label, at.cP(sdkLiveInfoData.liveInfo.audienceCount)));
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
        ap.setViewTextColor(this.dTU, (int) R.color.cp_cont_a);
        ap.setViewTextColor(this.fIH, (int) R.color.cp_cont_a);
        Drawable drawable = ap.getDrawable(getContext().getResources(), (int) R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18), getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.fIH.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.fIH.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelOffset(R.dimen.tbds8));
    }

    private void bGx() {
        try {
            this.fIJ.setAnimation("zan_lottie_anim.json");
            this.fIJ.setImageAssetsFolder("images/");
            this.fIJ.loop(true);
            this.fIJ.playAnimation();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.fIJ != null && !this.fIJ.isAnimating()) {
            this.fIJ.playAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.fIJ != null && this.fIJ.isAnimating()) {
            this.fIJ.pauseAnimation();
        }
        super.onDetachedFromWindow();
    }
}
