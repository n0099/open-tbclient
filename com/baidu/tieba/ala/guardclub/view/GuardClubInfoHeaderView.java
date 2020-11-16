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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes4.dex */
public class GuardClubInfoHeaderView extends LinearLayout {
    public TextView aDP;
    public TextView gFM;
    public TextView gIA;
    public LinearLayout gIB;
    public TextView gIC;
    public HeadImageView gIr;
    public TbImageView gIs;
    public ImageView gIt;
    public ImageView gIu;
    public TextView gIv;
    public ProgressBar gIw;
    public TextView gIx;
    public LinearLayout gIy;
    public TextView gIz;
    public TextView gwT;

    public GuardClubInfoHeaderView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setStyle(int i) {
        switch (i) {
            case 0:
                setBackgroundColor(0);
                setPadding(0, 0, 0, 0);
                this.aDP.setTypeface(Typeface.defaultFromStyle(0));
                this.gFM.setTypeface(Typeface.defaultFromStyle(0));
                this.gIx.setTextColor(getResources().getColor(a.c.sdk_white_alpha60));
                this.gIA.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
                this.gwT.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
                return;
            case 1:
                setBackgroundResource(a.e.guard_club_info_header_card_bg);
                setPadding(getResources().getDimensionPixelOffset(a.d.sdk_ds30), getResources().getDimensionPixelOffset(a.d.sdk_ds32), getResources().getDimensionPixelOffset(a.d.sdk_ds56), getResources().getDimensionPixelOffset(a.d.sdk_ds30));
                this.aDP.setTypeface(Typeface.defaultFromStyle(1));
                this.gFM.setTypeface(Typeface.defaultFromStyle(1));
                this.gIx.setTextColor(getResources().getColor(a.c.sdk_white_alpha80));
                this.gIA.setTextColor(-11337753);
                this.gwT.setTextColor(-11337753);
                return;
            default:
                return;
        }
    }

    private void init() {
        setOrientation(0);
        LayoutInflater.from(getContext()).inflate(a.g.live_guard_club_widget_info_header, (ViewGroup) this, true);
        this.gIr = (HeadImageView) findViewById(a.f.header_imageView);
        this.gIs = (TbImageView) findViewById(a.f.headwear_imageView);
        this.aDP = (TextView) findViewById(a.f.name_textView);
        this.gFM = (TextView) findViewById(a.f.nameSuffix_textView);
        this.gIt = (ImageView) findViewById(a.f.edit_imageView);
        this.gIu = (ImageView) findViewById(a.f.explain_imageView);
        this.gIv = (TextView) findViewById(a.f.score_textView);
        this.gIw = (ProgressBar) findViewById(a.f.score_progressBar);
        this.gIx = (TextView) findViewById(a.f.next_textView);
        this.gIy = (LinearLayout) findViewById(a.f.memberNum_layout);
        this.gIz = (TextView) findViewById(a.f.memberNumTitle_textView);
        this.gIA = (TextView) findViewById(a.f.memberNum_textView);
        this.gIB = (LinearLayout) findViewById(a.f.rank_layout);
        this.gIC = (TextView) findViewById(a.f.rankTitle_textView);
        this.gwT = (TextView) findViewById(a.f.rank_textView);
    }
}
