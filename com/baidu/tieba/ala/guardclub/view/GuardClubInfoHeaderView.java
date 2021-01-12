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
/* loaded from: classes10.dex */
public class GuardClubInfoHeaderView extends LinearLayout {
    public TextView aBZ;
    public TextView gML;
    public TextView gWc;
    public HeadImageView gYH;
    public TbImageView gYI;
    public ImageView gYJ;
    public ImageView gYK;
    public ImageView gYL;
    public TextView gYM;
    public ProgressBar gYN;
    public TextView gYO;
    public LinearLayout gYP;
    public TextView gYQ;
    public TextView gYR;
    public LinearLayout gYS;
    public TextView gYT;
    public View gYU;
    public TextView gYV;
    public ImageView gYW;

    public GuardClubInfoHeaderView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setStyle(int i) {
        switch (i) {
            case 0:
                setBackgroundColor(0);
                setPadding(0, 0, 0, 0);
                if (this.aBZ != null) {
                    this.aBZ.setTypeface(Typeface.defaultFromStyle(0));
                }
                if (this.gWc != null) {
                    this.gWc.setTypeface(Typeface.defaultFromStyle(0));
                }
                if (this.gYO != null) {
                    this.gYO.setTextColor(getResources().getColor(a.c.sdk_white_alpha60));
                }
                if (this.gYR != null) {
                    this.gYR.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
                }
                if (this.gML != null) {
                    this.gML.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
                }
                if (this.gYL != null) {
                    this.gYL.setVisibility(0);
                    return;
                }
                return;
            case 1:
                setBackgroundResource(a.e.guard_club_info_header_card_bg);
                setPadding(getResources().getDimensionPixelOffset(a.d.sdk_ds30), getResources().getDimensionPixelOffset(a.d.sdk_ds32), getResources().getDimensionPixelOffset(a.d.sdk_ds56), getResources().getDimensionPixelOffset(a.d.sdk_ds30));
                if (this.aBZ != null) {
                    this.aBZ.setTypeface(Typeface.defaultFromStyle(1));
                }
                if (this.gWc != null) {
                    this.gWc.setTypeface(Typeface.defaultFromStyle(1));
                }
                if (this.gYO != null) {
                    this.gYO.setTextColor(getResources().getColor(a.c.sdk_white_alpha80));
                }
                if (this.gYR != null) {
                    this.gYR.setTextColor(-11337753);
                }
                if (this.gML != null) {
                    this.gML.setTextColor(-11337753);
                }
                if (this.gYK != null) {
                    this.gYK.setVisibility(0);
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
        this.gYH = (HeadImageView) findViewById(a.f.header_imageView);
        this.gYI = (TbImageView) findViewById(a.f.headwear_imageView);
        this.aBZ = (TextView) findViewById(a.f.name_textView);
        this.gWc = (TextView) findViewById(a.f.nameSuffix_textView);
        this.gYJ = (ImageView) findViewById(a.f.edit_imageView);
        this.gYK = (ImageView) findViewById(a.f.explain_imageView_left);
        this.gYL = (ImageView) findViewById(a.f.explain_imageView_right);
        this.gYM = (TextView) findViewById(a.f.score_textView);
        this.gYN = (ProgressBar) findViewById(a.f.score_progressBar);
        this.gYO = (TextView) findViewById(a.f.next_textView);
        this.gYP = (LinearLayout) findViewById(a.f.memberNum_layout);
        this.gYQ = (TextView) findViewById(a.f.memberNumTitle_textView);
        this.gYR = (TextView) findViewById(a.f.memberNum_textView);
        this.gYS = (LinearLayout) findViewById(a.f.rank_layout);
        this.gYT = (TextView) findViewById(a.f.rankTitle_textView);
        this.gML = (TextView) findViewById(a.f.rank_textView);
        this.gYU = findViewById(a.f.modify_clubname);
        this.gYW = (ImageView) findViewById(a.f.rename_pen);
        this.gYV = (TextView) findViewById(a.f.rename_text);
    }
}
