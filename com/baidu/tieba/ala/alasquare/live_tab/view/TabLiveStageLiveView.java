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
    private static final float fWg = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] fYr = {0.0f, 0.0f, 0.0f, 0.0f, fWg, fWg, fWg, fWg};
    private TextView eig;
    private int[] fWk;
    private TbImageView fYk;
    private HeadImageView fYl;
    private View fYm;
    private TextView fYn;
    private View fYo;
    private TabLiveStageLiveZanLottieView fYp;
    private SdkLiveInfoData fYq;
    private TextView mTitle;
    private int mType;

    public TabLiveStageLiveView(Context context) {
        super(context);
        this.mType = 101;
        this.fWk = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 101;
        this.fWk = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 101;
        this.fWk = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.tab_stage_view, this);
        setRoundLayoutRadius(new float[]{fWg, fWg, fWg, fWg, fWg, fWg, fWg, fWg});
        this.fYp = (TabLiveStageLiveZanLottieView) findViewById(R.id.zan_lottie_view);
        this.fYp.setForbidAutoUpdateState(true);
        this.fYk = (TbImageView) findViewById(R.id.cover);
        this.fYk.setBackgroundColor(0);
        this.fYk.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.fYk.setConrers(15);
        this.fYl = (HeadImageView) findViewById(R.id.head_img);
        this.fYl.setAutoChangeStyle(false);
        this.fYl.setClickable(true);
        this.fYl.setIsRound(true);
        this.fYl.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds1));
        this.fYm = findViewById(R.id.head_mask_view);
        this.mTitle = (TextView) findViewById(R.id.title);
        this.eig = (TextView) findViewById(R.id.user_name);
        this.fYn = (TextView) findViewById(R.id.audience_count);
        this.fYo = findViewById(R.id.bottom_gradient_bg);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.fWk);
        gradientDrawable.setCornerRadii(fYr);
        this.fYo.setBackgroundDrawable(gradientDrawable);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.TabLiveStageLiveView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.ala.alasquare.live_tab.c.a(TabLiveStageLiveView.this.getContext(), TabLiveStageLiveView.this.fYq);
                if (TabLiveStageLiveView.this.mType != 101) {
                    if (TabLiveStageLiveView.this.mType == 102) {
                        aq aqVar = new aq("c13559");
                        aqVar.dK("entryname", "推荐");
                        TiebaStatic.log(aqVar);
                        return;
                    }
                    return;
                }
                aq aqVar2 = new aq("c13556");
                aqVar2.dK("entryname", "推荐");
                TiebaStatic.log(aqVar2);
            }
        });
        bKz();
    }

    public void setData(SdkLiveInfoData sdkLiveInfoData, int i) {
        if (sdkLiveInfoData == null || sdkLiveInfoData.liveInfo == null) {
            setVisibility(4);
            return;
        }
        this.fYq = sdkLiveInfoData;
        this.mType = i;
        this.fYk.setPlaceHolder(3);
        this.fYk.startLoad(sdkLiveInfoData.liveInfo.cover, 10, false);
        if (sdkLiveInfoData.liveAuthor != null) {
            String name_show = sdkLiveInfoData.liveAuthor.getName_show();
            if (af.getTextLengthWithEmoji(name_show) > 16) {
                name_show = af.subStringWithEmoji(name_show, 16) + StringHelper.STRING_MORE;
            }
            this.eig.setText(name_show);
            AlaUtilHelper.startLoadPortrait(this.fYl, sdkLiveInfoData.liveAuthor.portrait, false);
            if (1 == TbadkCoreApplication.getInst().getSkinType()) {
                this.fYm.setVisibility(0);
            } else {
                this.fYm.setVisibility(8);
            }
        }
        this.mTitle.setText(sdkLiveInfoData.title);
        this.fYn.setText(getContext().getResources().getString(R.string.square_sub_live_audience_label, at.cY(sdkLiveInfoData.liveInfo.audienceCount)));
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mTitle, R.color.cp_cont_a);
        ap.setViewTextColor(this.eig, R.color.cp_cont_a);
        ap.setViewTextColor(this.fYn, R.color.cp_cont_a);
        Drawable drawable = ap.getDrawable(getContext().getResources(), R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18), getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.fYn.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.fYn.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelOffset(R.dimen.tbds8));
    }

    private void bKz() {
        try {
            this.fYp.setAnimation("zan_lottie_anim.json");
            this.fYp.setImageAssetsFolder("images/");
            this.fYp.loop(true);
            this.fYp.playAnimation();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.fYp != null && !this.fYp.isAnimating()) {
            this.fYp.playAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.fYp != null && this.fYp.isAnimating()) {
            this.fYp.pauseAnimation();
        }
        super.onDetachedFromWindow();
    }
}
