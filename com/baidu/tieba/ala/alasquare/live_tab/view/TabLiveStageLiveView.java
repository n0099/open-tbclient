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
import com.baidu.tbadk.util.af;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class TabLiveStageLiveView extends AlaRoundRelativeLayout {
    private static final float glY = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] goj = {0.0f, 0.0f, 0.0f, 0.0f, glY, glY, glY, glY};
    private TextView ewx;
    private int[] gmc;
    private TbImageView goc;
    private HeadImageView god;
    private View goe;
    private TextView gof;
    private View gog;
    private TabLiveStageLiveZanLottieView goh;
    private SdkLiveInfoData goi;
    private TextView mTitle;
    private int mType;

    public TabLiveStageLiveView(Context context) {
        super(context);
        this.mType = 101;
        this.gmc = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 101;
        this.gmc = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 101;
        this.gmc = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.tab_stage_view, this);
        setRoundLayoutRadius(new float[]{glY, glY, glY, glY, glY, glY, glY, glY});
        this.goh = (TabLiveStageLiveZanLottieView) findViewById(R.id.zan_lottie_view);
        this.goh.setForbidAutoUpdateState(true);
        this.goc = (TbImageView) findViewById(R.id.cover);
        this.goc.setBackgroundColor(0);
        this.goc.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.goc.setConrers(15);
        this.god = (HeadImageView) findViewById(R.id.head_img);
        this.god.setAutoChangeStyle(false);
        this.god.setClickable(true);
        this.god.setIsRound(true);
        this.god.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds1));
        this.goe = findViewById(R.id.head_mask_view);
        this.mTitle = (TextView) findViewById(R.id.title);
        this.ewx = (TextView) findViewById(R.id.user_name);
        this.gof = (TextView) findViewById(R.id.audience_count);
        this.gog = findViewById(R.id.bottom_gradient_bg);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.gmc);
        gradientDrawable.setCornerRadii(goj);
        this.gog.setBackgroundDrawable(gradientDrawable);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.TabLiveStageLiveView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.ala.alasquare.live_tab.c.a(TabLiveStageLiveView.this.getContext(), TabLiveStageLiveView.this.goi);
                if (TabLiveStageLiveView.this.mType != 101) {
                    if (TabLiveStageLiveView.this.mType == 102) {
                        aq aqVar = new aq("c13559");
                        aqVar.dR("entryname", "推荐");
                        TiebaStatic.log(aqVar);
                        return;
                    }
                    return;
                }
                aq aqVar2 = new aq("c13556");
                aqVar2.dR("entryname", "推荐");
                TiebaStatic.log(aqVar2);
            }
        });
        bPB();
    }

    public void setData(SdkLiveInfoData sdkLiveInfoData, int i) {
        if (sdkLiveInfoData == null || sdkLiveInfoData.liveInfo == null) {
            setVisibility(4);
            return;
        }
        this.goi = sdkLiveInfoData;
        this.mType = i;
        this.goc.setPlaceHolder(3);
        this.goc.startLoad(sdkLiveInfoData.liveInfo.cover, 10, false);
        if (sdkLiveInfoData.liveAuthor != null) {
            String name_show = sdkLiveInfoData.liveAuthor.getName_show();
            if (af.getTextLengthWithEmoji(name_show) > 16) {
                name_show = af.subStringWithEmoji(name_show, 16) + StringHelper.STRING_MORE;
            }
            this.ewx.setText(name_show);
            AlaUtilHelper.startLoadPortrait(this.god, sdkLiveInfoData.liveAuthor.portrait, false);
            if (1 == TbadkCoreApplication.getInst().getSkinType()) {
                this.goe.setVisibility(0);
            } else {
                this.goe.setVisibility(8);
            }
        }
        this.mTitle.setText(sdkLiveInfoData.title);
        this.gof.setText(getContext().getResources().getString(R.string.square_sub_live_audience_label, at.dw(sdkLiveInfoData.liveInfo.audienceCount)));
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
        ap.setViewTextColor(this.ewx, (int) R.color.cp_cont_a);
        ap.setViewTextColor(this.gof, (int) R.color.cp_cont_a);
        Drawable drawable = ap.getDrawable(getContext().getResources(), (int) R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18), getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.gof.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.gof.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelOffset(R.dimen.tbds8));
    }

    private void bPB() {
        try {
            this.goh.setAnimation("zan_lottie_anim.json");
            this.goh.setImageAssetsFolder("images/");
            this.goh.loop(true);
            this.goh.playAnimation();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.goh != null && !this.goh.isAnimating()) {
            this.goh.playAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.goh != null && this.goh.isAnimating()) {
            this.goh.pauseAnimation();
        }
        super.onDetachedFromWindow();
    }
}
