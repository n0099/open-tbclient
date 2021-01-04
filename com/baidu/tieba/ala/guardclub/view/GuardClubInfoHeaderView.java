package com.baidu.tieba.ala.guardclub.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes11.dex */
public class GuardClubInfoHeaderView extends LinearLayout {
    public TextView aGM;
    public TextView gRr;
    public TextView haI;
    public View hdA;
    public TextView hdB;
    public ImageView hdC;
    public HeadImageView hdn;
    public TbImageView hdo;
    public ImageView hdp;
    public ImageView hdq;
    public ImageView hdr;
    public TextView hds;
    public ProgressBar hdt;
    public TextView hdu;
    public LinearLayout hdv;
    public TextView hdw;
    public TextView hdx;
    public LinearLayout hdy;
    public TextView hdz;

    public GuardClubInfoHeaderView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setStyle(int i) {
        switch (i) {
            case 0:
                setBackgroundColor(0);
                setPadding(0, 0, 0, 0);
                if (this.aGM != null) {
                    this.aGM.setTypeface(Typeface.defaultFromStyle(0));
                }
                if (this.haI != null) {
                    this.haI.setTypeface(Typeface.defaultFromStyle(0));
                }
                if (this.hdu != null) {
                    this.hdu.setTextColor(getResources().getColor(a.c.sdk_white_alpha60));
                }
                if (this.hdx != null) {
                    this.hdx.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
                }
                if (this.gRr != null) {
                    this.gRr.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
                }
                if (this.hdr != null) {
                    this.hdr.setVisibility(0);
                    return;
                }
                return;
            case 1:
                setBackgroundResource(a.e.guard_club_info_header_card_bg);
                setPadding(getResources().getDimensionPixelOffset(a.d.sdk_ds30), getResources().getDimensionPixelOffset(a.d.sdk_ds32), getResources().getDimensionPixelOffset(a.d.sdk_ds56), getResources().getDimensionPixelOffset(a.d.sdk_ds30));
                if (this.aGM != null) {
                    this.aGM.setTypeface(Typeface.defaultFromStyle(1));
                }
                if (this.haI != null) {
                    this.haI.setTypeface(Typeface.defaultFromStyle(1));
                }
                if (this.hdu != null) {
                    this.hdu.setTextColor(getResources().getColor(a.c.sdk_white_alpha80));
                }
                if (this.hdx != null) {
                    this.hdx.setTextColor(-11337753);
                }
                if (this.gRr != null) {
                    this.gRr.setTextColor(-11337753);
                }
                if (this.hdq != null) {
                    this.hdq.setVisibility(0);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void init() {
        setOrientation(0);
        LayoutInflater.from(getContext()).inflate(a.g.live_guard_club_widget_info_header, (ViewGroup) this, true);
        this.hdn = (HeadImageView) findViewById(a.f.header_imageView);
        this.hdo = (TbImageView) findViewById(a.f.headwear_imageView);
        this.aGM = (TextView) findViewById(a.f.name_textView);
        this.haI = (TextView) findViewById(a.f.nameSuffix_textView);
        this.hdp = (ImageView) findViewById(a.f.edit_imageView);
        this.hdq = (ImageView) findViewById(a.f.explain_imageView_left);
        this.hdr = (ImageView) findViewById(a.f.explain_imageView_right);
        this.hds = (TextView) findViewById(a.f.score_textView);
        this.hdt = (ProgressBar) findViewById(a.f.score_progressBar);
        this.hdu = (TextView) findViewById(a.f.next_textView);
        this.hdv = (LinearLayout) findViewById(a.f.memberNum_layout);
        this.hdw = (TextView) findViewById(a.f.memberNumTitle_textView);
        this.hdx = (TextView) findViewById(a.f.memberNum_textView);
        this.hdy = (LinearLayout) findViewById(a.f.rank_layout);
        this.hdz = (TextView) findViewById(a.f.rankTitle_textView);
        this.gRr = (TextView) findViewById(a.f.rank_textView);
        this.hdA = findViewById(a.f.modify_clubname);
        this.hdC = (ImageView) findViewById(a.f.rename_pen);
        this.hdB = (TextView) findViewById(a.f.rename_text);
    }
}
