package com.baidu.tieba.ala.charm.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.k;
import com.baidu.live.view.ALALevelView;
/* loaded from: classes7.dex */
public class CharmItemView extends LinearLayout {
    public TextView aAP;
    public TextView fRN;
    public ImageView fRO;
    public HeadImageView fRP;
    public TbImageView fRQ;
    public ALALevelView fRR;
    public TextView fRS;

    public CharmItemView(Context context) {
        this(context, null);
    }

    public CharmItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(int i, int i2, String str, String str2, long j, long j2) {
        float dimensionPixelSize;
        if (i == 2 && i2 >= 1 && i2 <= 3 && j > 0) {
            this.fRN.setTextColor(-838860801);
            this.fRQ.setVisibility(0);
        } else {
            this.fRN.setTextColor(1728053247);
            this.fRQ.setVisibility(8);
        }
        if (i == 1 || (i == 2 && i2 >= 1 && j > 0)) {
            this.fRN.setText(i2 <= 100 ? String.valueOf(i2) : "100+");
            this.fRN.setVisibility(0);
            this.fRO.setVisibility(8);
        } else {
            this.fRN.setVisibility(8);
            this.fRO.setVisibility(0);
        }
        if (this.fRN.getText() != null) {
            TextView textView = this.fRN;
            if (this.fRN.getText().length() > 3) {
                dimensionPixelSize = getResources().getDimensionPixelSize(a.e.sdk_fontsize24);
            } else {
                dimensionPixelSize = getResources().getDimensionPixelSize(a.e.sdk_fontsize36);
            }
            textView.setTextSize(0, dimensionPixelSize);
        }
        k.a(this.fRP, str2, true, false);
        if (i == 2 && j > 0) {
            switch (i2) {
                case 1:
                    this.fRQ.setImageResource(a.f.pic_live_list_top1);
                    break;
                case 2:
                    this.fRQ.setImageResource(a.f.pic_live_list_top2);
                    break;
                case 3:
                    this.fRQ.setImageResource(a.f.pic_live_list_top3);
                    break;
            }
        }
        this.aAP.setText(str);
        switch (i) {
            case 1:
                this.fRS.setText(String.format(getResources().getString(a.i.sdk_charm_rank_forward_diff), StringHelper.formatValue(j2)));
                return;
            case 2:
                if (j > 0) {
                    this.fRS.setText(String.format("%s 魅力", StringHelper.formatValue(j)));
                    return;
                } else {
                    this.fRS.setText("");
                    return;
                }
            default:
                return;
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.sdk_charm_item, (ViewGroup) this, true);
        setOrientation(0);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.e.sdk_ds8);
        setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds18), dimensionPixelOffset, getResources().getDimensionPixelOffset(a.e.sdk_ds36), dimensionPixelOffset);
        FG();
        initView();
    }

    private void FG() {
        this.fRN = (TextView) findViewById(a.g.tv_rank);
        this.fRO = (ImageView) findViewById(a.g.iv_rank);
        this.fRP = (HeadImageView) findViewById(a.g.iv_avatar);
        this.fRQ = (TbImageView) findViewById(a.g.iv_pendant);
        this.fRR = (ALALevelView) findViewById(a.g.level);
        this.aAP = (TextView) findViewById(a.g.tv_name);
        this.fRS = (TextView) findViewById(a.g.tv_value);
    }

    private void initView() {
        this.fRP.setAutoChangeStyle(false);
        this.fRP.setDrawBorder(false);
        this.fRP.setIsRound(true);
        this.fRQ.setDefaultBgResource(a.d.sdk_transparent);
        this.fRQ.setDefaultErrorResource(a.f.sdk_shape_transparent);
    }
}
