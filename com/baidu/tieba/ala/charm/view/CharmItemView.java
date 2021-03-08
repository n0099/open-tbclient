package com.baidu.tieba.ala.charm.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.m;
import com.baidu.live.view.ALALevelView;
/* loaded from: classes10.dex */
public class CharmItemView extends LinearLayout {
    public TextView aFm;
    public TextView gRo;
    public ImageView gRp;
    public HeadImageView gRq;
    public TbImageView gRr;
    public ALALevelView gRs;
    public TextView gRt;

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
            this.gRo.setTextColor(-838860801);
            this.gRr.setVisibility(0);
        } else {
            this.gRo.setTextColor(1728053247);
            this.gRr.setVisibility(8);
        }
        if (i == 1 || (i == 2 && i2 >= 1 && j > 0)) {
            this.gRo.setText(i2 <= 100 ? String.valueOf(i2) : "100+");
            this.gRo.setVisibility(0);
            this.gRp.setVisibility(8);
        } else {
            this.gRo.setVisibility(8);
            this.gRp.setVisibility(0);
        }
        if (this.gRo.getText() != null) {
            TextView textView = this.gRo;
            if (this.gRo.getText().length() > 3) {
                dimensionPixelSize = getResources().getDimensionPixelSize(a.d.sdk_fontsize24);
            } else {
                dimensionPixelSize = getResources().getDimensionPixelSize(a.d.sdk_fontsize36);
            }
            textView.setTextSize(0, dimensionPixelSize);
        }
        m.a(this.gRq, str2, true, false);
        if (i == 2 && j > 0) {
            switch (i2) {
                case 1:
                    this.gRr.setImageResource(a.e.pic_live_list_top1);
                    break;
                case 2:
                    this.gRr.setImageResource(a.e.pic_live_list_top2);
                    break;
                case 3:
                    this.gRr.setImageResource(a.e.pic_live_list_top3);
                    break;
            }
        }
        this.aFm.setText(str);
        switch (i) {
            case 1:
                this.gRt.setText(String.format(getResources().getString(a.h.sdk_charm_rank_forward_diff), StringHelper.formatValue(j2)));
                return;
            case 2:
                if (j > 0) {
                    this.gRt.setText(String.format("%s 魅力", StringHelper.formatValue(j)));
                    return;
                } else {
                    this.gRt.setText("");
                    return;
                }
            default:
                return;
        }
    }

    protected final void init() {
        LayoutInflater.from(getContext()).inflate(a.g.sdk_charm_item, (ViewGroup) this, true);
        setOrientation(0);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.sdk_ds8);
        setPadding(getResources().getDimensionPixelOffset(a.d.sdk_ds18), dimensionPixelOffset, getResources().getDimensionPixelOffset(a.d.sdk_ds36), dimensionPixelOffset);
        Gh();
        initView();
    }

    protected void Gh() {
        this.gRo = (TextView) findViewById(a.f.tv_rank);
        this.gRp = (ImageView) findViewById(a.f.iv_rank);
        this.gRq = (HeadImageView) findViewById(a.f.iv_avatar);
        this.gRr = (TbImageView) findViewById(a.f.iv_pendant);
        this.gRs = (ALALevelView) findViewById(a.f.level);
        this.aFm = (TextView) findViewById(a.f.tv_name);
        this.gRt = (TextView) findViewById(a.f.tv_value);
    }

    protected void initView() {
        this.gRq.setAutoChangeStyle(false);
        this.gRq.setDrawBorder(false);
        this.gRq.setIsRound(true);
        this.gRr.setDefaultBgResource(a.c.sdk_transparent);
        this.gRr.setDefaultErrorResource(a.e.sdk_shape_transparent);
    }
}
