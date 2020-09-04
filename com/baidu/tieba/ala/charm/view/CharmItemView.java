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
    public TextView aAR;
    public TextView fRR;
    public ImageView fRS;
    public HeadImageView fRT;
    public TbImageView fRU;
    public ALALevelView fRV;
    public TextView fRW;

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
            this.fRR.setTextColor(-838860801);
            this.fRU.setVisibility(0);
        } else {
            this.fRR.setTextColor(1728053247);
            this.fRU.setVisibility(8);
        }
        if (i == 1 || (i == 2 && i2 >= 1 && j > 0)) {
            this.fRR.setText(i2 <= 100 ? String.valueOf(i2) : "100+");
            this.fRR.setVisibility(0);
            this.fRS.setVisibility(8);
        } else {
            this.fRR.setVisibility(8);
            this.fRS.setVisibility(0);
        }
        if (this.fRR.getText() != null) {
            TextView textView = this.fRR;
            if (this.fRR.getText().length() > 3) {
                dimensionPixelSize = getResources().getDimensionPixelSize(a.e.sdk_fontsize24);
            } else {
                dimensionPixelSize = getResources().getDimensionPixelSize(a.e.sdk_fontsize36);
            }
            textView.setTextSize(0, dimensionPixelSize);
        }
        k.a(this.fRT, str2, true, false);
        if (i == 2 && j > 0) {
            switch (i2) {
                case 1:
                    this.fRU.setImageResource(a.f.pic_live_list_top1);
                    break;
                case 2:
                    this.fRU.setImageResource(a.f.pic_live_list_top2);
                    break;
                case 3:
                    this.fRU.setImageResource(a.f.pic_live_list_top3);
                    break;
            }
        }
        this.aAR.setText(str);
        switch (i) {
            case 1:
                this.fRW.setText(String.format(getResources().getString(a.i.sdk_charm_rank_forward_diff), StringHelper.formatValue(j2)));
                return;
            case 2:
                if (j > 0) {
                    this.fRW.setText(String.format("%s 魅力", StringHelper.formatValue(j)));
                    return;
                } else {
                    this.fRW.setText("");
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
        this.fRR = (TextView) findViewById(a.g.tv_rank);
        this.fRS = (ImageView) findViewById(a.g.iv_rank);
        this.fRT = (HeadImageView) findViewById(a.g.iv_avatar);
        this.fRU = (TbImageView) findViewById(a.g.iv_pendant);
        this.fRV = (ALALevelView) findViewById(a.g.level);
        this.aAR = (TextView) findViewById(a.g.tv_name);
        this.fRW = (TextView) findViewById(a.g.tv_value);
    }

    private void initView() {
        this.fRT.setAutoChangeStyle(false);
        this.fRT.setDrawBorder(false);
        this.fRT.setIsRound(true);
        this.fRU.setDefaultBgResource(a.d.sdk_transparent);
        this.fRU.setDefaultErrorResource(a.f.sdk_shape_transparent);
    }
}
