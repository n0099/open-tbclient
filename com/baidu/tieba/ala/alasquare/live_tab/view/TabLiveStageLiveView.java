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
    private static final float enY = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] eqc = {0.0f, 0.0f, 0.0f, 0.0f, enY, enY, enY, enY};
    private TextView cbL;
    private int[] eoc;
    private TbImageView epV;
    private HeadImageView epW;
    private View epX;
    private TextView epY;
    private View epZ;
    private TabLiveStageLiveZanLottieView eqa;
    private SdkLiveInfoData eqb;
    private TextView mTitle;
    private int mType;

    public TabLiveStageLiveView(Context context) {
        super(context);
        this.mType = 101;
        this.eoc = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 101;
        this.eoc = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 101;
        this.eoc = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.tab_stage_view, this);
        setRoundLayoutRadius(new float[]{enY, enY, enY, enY, enY, enY, enY, enY});
        this.eqa = (TabLiveStageLiveZanLottieView) findViewById(R.id.zan_lottie_view);
        this.eqa.setForbidAutoUpdateState(true);
        this.epV = (TbImageView) findViewById(R.id.cover);
        this.epV.setBackgroundColor(0);
        this.epV.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.epV.setConrers(15);
        this.epW = (HeadImageView) findViewById(R.id.head_img);
        this.epW.setAutoChangeStyle(false);
        this.epW.setClickable(true);
        this.epW.setIsRound(true);
        this.epW.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds1));
        this.epX = findViewById(R.id.head_mask_view);
        this.mTitle = (TextView) findViewById(R.id.title);
        this.cbL = (TextView) findViewById(R.id.user_name);
        this.epY = (TextView) findViewById(R.id.audience_count);
        this.epZ = findViewById(R.id.bottom_gradient_bg);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.eoc);
        gradientDrawable.setCornerRadii(eqc);
        this.epZ.setBackgroundDrawable(gradientDrawable);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.TabLiveStageLiveView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.ala.alasquare.live_tab.c.a(TabLiveStageLiveView.this.getContext(), TabLiveStageLiveView.this.eqb);
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
        bcX();
    }

    public void setData(SdkLiveInfoData sdkLiveInfoData, int i) {
        if (sdkLiveInfoData == null || sdkLiveInfoData.liveInfo == null) {
            setVisibility(4);
            return;
        }
        this.eqb = sdkLiveInfoData;
        this.mType = i;
        this.epV.setPlaceHolder(3);
        this.epV.startLoad(sdkLiveInfoData.liveInfo.cover, 10, false);
        if (sdkLiveInfoData.liveAuthor != null) {
            String name_show = sdkLiveInfoData.liveAuthor.getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 16) {
                name_show = ad.subStringWithEmoji(name_show, 16) + StringHelper.STRING_MORE;
            }
            this.cbL.setText(name_show);
            AlaUtilHelper.startLoadPortrait(this.epW, sdkLiveInfoData.liveAuthor.portrait, false);
            if (1 == TbadkCoreApplication.getInst().getSkinType()) {
                this.epX.setVisibility(0);
            } else {
                this.epX.setVisibility(8);
            }
        }
        this.mTitle.setText(sdkLiveInfoData.title);
        this.epY.setText(getContext().getResources().getString(R.string.square_sub_live_audience_label, aq.bE(sdkLiveInfoData.liveInfo.audienceCount)));
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.cbL, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.epY, (int) R.color.cp_cont_a);
        Drawable drawable = am.getDrawable(getContext().getResources(), (int) R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18), getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.epY.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.epY.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelOffset(R.dimen.tbds8));
    }

    private void bcX() {
        try {
            this.eqa.setAnimation("zan_lottie_anim.json");
            this.eqa.setImageAssetsFolder("images/");
            this.eqa.loop(true);
            this.eqa.playAnimation();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.eqa != null && !this.eqa.isAnimating()) {
            this.eqa.playAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.eqa != null && this.eqa.isAnimating()) {
            this.eqa.pauseAnimation();
        }
        super.onDetachedFromWindow();
    }
}
