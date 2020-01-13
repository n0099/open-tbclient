package com.baidu.tieba.ala.guardclub.view;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes2.dex */
public class GuardClubInfoHeaderView extends LinearLayout {
    public TextView aro;
    public TextView eAM;
    public TextView eCj;
    public HeadImageView eDU;
    public TbImageView eDV;
    public ImageView eDW;
    public ImageView eDX;
    public TextView eDY;
    public ProgressBar eDZ;
    public TextView eEa;
    public LinearLayout eEb;
    public TextView eEc;
    public TextView eEd;
    public LinearLayout eEe;
    public TextView eEf;

    public GuardClubInfoHeaderView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setStyle(int i) {
        switch (i) {
            case 0:
                setBackgroundColor(0);
                setPadding(0, 0, 0, 0);
                this.aro.setTypeface(Typeface.defaultFromStyle(0));
                this.eAM.setTypeface(Typeface.defaultFromStyle(0));
                this.eEa.setTextColor(getResources().getColor(a.d.sdk_white_alpha60));
                this.eEd.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.eCj.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                return;
            case 1:
                setBackgroundResource(a.f.guard_club_info_header_card_bg);
                setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds30), getResources().getDimensionPixelOffset(a.e.sdk_ds32), getResources().getDimensionPixelOffset(a.e.sdk_ds56), getResources().getDimensionPixelOffset(a.e.sdk_ds30));
                this.aro.setTypeface(Typeface.defaultFromStyle(1));
                this.eAM.setTypeface(Typeface.defaultFromStyle(1));
                this.eEa.setTextColor(getResources().getColor(a.d.sdk_white_alpha80));
                this.eEd.setTextColor(-11337753);
                this.eCj.setTextColor(-11337753);
                return;
            default:
                return;
        }
    }

    private void init() {
        setOrientation(0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_info_header, (ViewGroup) this, true);
        this.eDU = (HeadImageView) findViewById(a.g.header_imageView);
        this.eDV = (TbImageView) findViewById(a.g.headwear_imageView);
        this.aro = (TextView) findViewById(a.g.name_textView);
        this.eAM = (TextView) findViewById(a.g.nameSuffix_textView);
        this.eDW = (ImageView) findViewById(a.g.edit_imageView);
        this.eDX = (ImageView) findViewById(a.g.explain_imageView);
        this.eDY = (TextView) findViewById(a.g.score_textView);
        this.eDZ = (ProgressBar) findViewById(a.g.score_progressBar);
        this.eEa = (TextView) findViewById(a.g.next_textView);
        this.eEb = (LinearLayout) findViewById(a.g.memberNum_layout);
        this.eEc = (TextView) findViewById(a.g.memberNumTitle_textView);
        this.eEd = (TextView) findViewById(a.g.memberNum_textView);
        this.eEe = (LinearLayout) findViewById(a.g.rank_layout);
        this.eEf = (TextView) findViewById(a.g.rankTitle_textView);
        this.eCj = (TextView) findViewById(a.g.rank_textView);
    }
}
