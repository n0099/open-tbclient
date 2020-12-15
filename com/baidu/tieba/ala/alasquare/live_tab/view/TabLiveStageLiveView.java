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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class TabLiveStageLiveView extends AlaRoundRelativeLayout {
    private static final float gtQ = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] gwb = {0.0f, 0.0f, 0.0f, 0.0f, gtQ, gtQ, gtQ, gtQ};
    private TextView eBQ;
    private int[] gtU;
    private TbImageView gvU;
    private HeadImageView gvV;
    private View gvW;
    private TextView gvX;
    private View gvY;
    private TabLiveStageLiveZanLottieView gvZ;
    private SdkLiveInfoData gwa;
    private TextView mTitle;
    private int mType;

    public TabLiveStageLiveView(Context context) {
        super(context);
        this.mType = 101;
        this.gtU = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 101;
        this.gtU = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 101;
        this.gtU = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.tab_stage_view, this);
        setRoundLayoutRadius(new float[]{gtQ, gtQ, gtQ, gtQ, gtQ, gtQ, gtQ, gtQ});
        this.gvZ = (TabLiveStageLiveZanLottieView) findViewById(R.id.zan_lottie_view);
        this.gvZ.setForbidAutoUpdateState(true);
        this.gvU = (TbImageView) findViewById(R.id.cover);
        this.gvU.setBackgroundColor(0);
        this.gvU.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.gvU.setConrers(15);
        this.gvV = (HeadImageView) findViewById(R.id.head_img);
        this.gvV.setAutoChangeStyle(false);
        this.gvV.setClickable(true);
        this.gvV.setIsRound(true);
        this.gvV.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds1));
        this.gvW = findViewById(R.id.head_mask_view);
        this.mTitle = (TextView) findViewById(R.id.title);
        this.eBQ = (TextView) findViewById(R.id.user_name);
        this.gvX = (TextView) findViewById(R.id.audience_count);
        this.gvY = findViewById(R.id.bottom_gradient_bg);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.gtU);
        gradientDrawable.setCornerRadii(gwb);
        this.gvY.setBackgroundDrawable(gradientDrawable);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.TabLiveStageLiveView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.ala.alasquare.live_tab.c.a(TabLiveStageLiveView.this.getContext(), TabLiveStageLiveView.this.gwa);
                if (TabLiveStageLiveView.this.mType != 101) {
                    if (TabLiveStageLiveView.this.mType == 102) {
                        ar arVar = new ar("c13559");
                        arVar.dY("entryname", "推荐");
                        TiebaStatic.log(arVar);
                        return;
                    }
                    return;
                }
                ar arVar2 = new ar("c13556");
                arVar2.dY("entryname", "推荐");
                TiebaStatic.log(arVar2);
            }
        });
        bSG();
    }

    public void setData(SdkLiveInfoData sdkLiveInfoData, int i) {
        if (sdkLiveInfoData == null || sdkLiveInfoData.liveInfo == null) {
            setVisibility(4);
            return;
        }
        this.gwa = sdkLiveInfoData;
        this.mType = i;
        this.gvU.setPlaceHolder(3);
        this.gvU.startLoad(sdkLiveInfoData.liveInfo.cover, 10, false);
        if (sdkLiveInfoData.liveAuthor != null) {
            String name_show = sdkLiveInfoData.liveAuthor.getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 16) {
                name_show = ae.subStringWithEmoji(name_show, 16) + StringHelper.STRING_MORE;
            }
            this.eBQ.setText(name_show);
            AlaUtilHelper.startLoadPortrait(this.gvV, sdkLiveInfoData.liveAuthor.portrait, false);
            if (1 == TbadkCoreApplication.getInst().getSkinType()) {
                this.gvW.setVisibility(0);
            } else {
                this.gvW.setVisibility(8);
            }
        }
        this.mTitle.setText(sdkLiveInfoData.title);
        this.gvX.setText(getContext().getResources().getString(R.string.square_sub_live_audience_label, au.dV(sdkLiveInfoData.liveInfo.audienceCount)));
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mTitle, (int) R.color.CAM_X0101);
        ap.setViewTextColor(this.eBQ, (int) R.color.CAM_X0101);
        ap.setViewTextColor(this.gvX, (int) R.color.CAM_X0101);
        Drawable drawable = ap.getDrawable(getContext().getResources(), (int) R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18), getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.gvX.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.gvX.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelOffset(R.dimen.tbds8));
    }

    private void bSG() {
        try {
            this.gvZ.setAnimation("zan_lottie_anim.json");
            this.gvZ.setImageAssetsFolder("images/");
            this.gvZ.loop(true);
            this.gvZ.playAnimation();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.gvZ != null && !this.gvZ.isAnimating()) {
            this.gvZ.playAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.gvZ != null && this.gvZ.isAnimating()) {
            this.gvZ.pauseAnimation();
        }
        super.onDetachedFromWindow();
    }
}
