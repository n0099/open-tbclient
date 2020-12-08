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
    private static final float gtO = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] gvZ = {0.0f, 0.0f, 0.0f, 0.0f, gtO, gtO, gtO, gtO};
    private TextView eBQ;
    private int[] gtS;
    private TbImageView gvS;
    private HeadImageView gvT;
    private View gvU;
    private TextView gvV;
    private View gvW;
    private TabLiveStageLiveZanLottieView gvX;
    private SdkLiveInfoData gvY;
    private TextView mTitle;
    private int mType;

    public TabLiveStageLiveView(Context context) {
        super(context);
        this.mType = 101;
        this.gtS = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 101;
        this.gtS = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 101;
        this.gtS = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.tab_stage_view, this);
        setRoundLayoutRadius(new float[]{gtO, gtO, gtO, gtO, gtO, gtO, gtO, gtO});
        this.gvX = (TabLiveStageLiveZanLottieView) findViewById(R.id.zan_lottie_view);
        this.gvX.setForbidAutoUpdateState(true);
        this.gvS = (TbImageView) findViewById(R.id.cover);
        this.gvS.setBackgroundColor(0);
        this.gvS.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.gvS.setConrers(15);
        this.gvT = (HeadImageView) findViewById(R.id.head_img);
        this.gvT.setAutoChangeStyle(false);
        this.gvT.setClickable(true);
        this.gvT.setIsRound(true);
        this.gvT.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds1));
        this.gvU = findViewById(R.id.head_mask_view);
        this.mTitle = (TextView) findViewById(R.id.title);
        this.eBQ = (TextView) findViewById(R.id.user_name);
        this.gvV = (TextView) findViewById(R.id.audience_count);
        this.gvW = findViewById(R.id.bottom_gradient_bg);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.gtS);
        gradientDrawable.setCornerRadii(gvZ);
        this.gvW.setBackgroundDrawable(gradientDrawable);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.TabLiveStageLiveView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.ala.alasquare.live_tab.c.a(TabLiveStageLiveView.this.getContext(), TabLiveStageLiveView.this.gvY);
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
        bSF();
    }

    public void setData(SdkLiveInfoData sdkLiveInfoData, int i) {
        if (sdkLiveInfoData == null || sdkLiveInfoData.liveInfo == null) {
            setVisibility(4);
            return;
        }
        this.gvY = sdkLiveInfoData;
        this.mType = i;
        this.gvS.setPlaceHolder(3);
        this.gvS.startLoad(sdkLiveInfoData.liveInfo.cover, 10, false);
        if (sdkLiveInfoData.liveAuthor != null) {
            String name_show = sdkLiveInfoData.liveAuthor.getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 16) {
                name_show = ae.subStringWithEmoji(name_show, 16) + StringHelper.STRING_MORE;
            }
            this.eBQ.setText(name_show);
            AlaUtilHelper.startLoadPortrait(this.gvT, sdkLiveInfoData.liveAuthor.portrait, false);
            if (1 == TbadkCoreApplication.getInst().getSkinType()) {
                this.gvU.setVisibility(0);
            } else {
                this.gvU.setVisibility(8);
            }
        }
        this.mTitle.setText(sdkLiveInfoData.title);
        this.gvV.setText(getContext().getResources().getString(R.string.square_sub_live_audience_label, au.dV(sdkLiveInfoData.liveInfo.audienceCount)));
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mTitle, (int) R.color.CAM_X0101);
        ap.setViewTextColor(this.eBQ, (int) R.color.CAM_X0101);
        ap.setViewTextColor(this.gvV, (int) R.color.CAM_X0101);
        Drawable drawable = ap.getDrawable(getContext().getResources(), (int) R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18), getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.gvV.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.gvV.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelOffset(R.dimen.tbds8));
    }

    private void bSF() {
        try {
            this.gvX.setAnimation("zan_lottie_anim.json");
            this.gvX.setImageAssetsFolder("images/");
            this.gvX.loop(true);
            this.gvX.playAnimation();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.gvX != null && !this.gvX.isAnimating()) {
            this.gvX.playAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.gvX != null && this.gvX.isAnimating()) {
            this.gvX.pauseAnimation();
        }
        super.onDetachedFromWindow();
    }
}
