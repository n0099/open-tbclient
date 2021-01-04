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
/* loaded from: classes11.dex */
public class CharmItemView extends LinearLayout {
    public TextView aGM;
    public TextView gRr;
    public ImageView gRs;
    public HeadImageView gRt;
    public TbImageView gRu;
    public ALALevelView gRv;
    public TextView gRw;

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
            this.gRr.setTextColor(-838860801);
            this.gRu.setVisibility(0);
        } else {
            this.gRr.setTextColor(1728053247);
            this.gRu.setVisibility(8);
        }
        if (i == 1 || (i == 2 && i2 >= 1 && j > 0)) {
            this.gRr.setText(i2 <= 100 ? String.valueOf(i2) : "100+");
            this.gRr.setVisibility(0);
            this.gRs.setVisibility(8);
        } else {
            this.gRr.setVisibility(8);
            this.gRs.setVisibility(0);
        }
        if (this.gRr.getText() != null) {
            TextView textView = this.gRr;
            if (this.gRr.getText().length() > 3) {
                dimensionPixelSize = getResources().getDimensionPixelSize(a.d.sdk_fontsize24);
            } else {
                dimensionPixelSize = getResources().getDimensionPixelSize(a.d.sdk_fontsize36);
            }
            textView.setTextSize(0, dimensionPixelSize);
        }
        m.a(this.gRt, str2, true, false);
        if (i == 2 && j > 0) {
            switch (i2) {
                case 1:
                    this.gRu.setImageResource(a.e.pic_live_list_top1);
                    break;
                case 2:
                    this.gRu.setImageResource(a.e.pic_live_list_top2);
                    break;
                case 3:
                    this.gRu.setImageResource(a.e.pic_live_list_top3);
                    break;
            }
        }
        this.aGM.setText(str);
        switch (i) {
            case 1:
                this.gRw.setText(String.format(getResources().getString(a.h.sdk_charm_rank_forward_diff), StringHelper.formatValue(j2)));
                return;
            case 2:
                if (j > 0) {
                    this.gRw.setText(String.format("%s 魅力", StringHelper.formatValue(j)));
                    return;
                } else {
                    this.gRw.setText("");
                    return;
                }
            default:
                return;
        }
    }

    protected void init() {
        LayoutInflater.from(getContext()).inflate(a.g.sdk_charm_item, (ViewGroup) this, true);
        setOrientation(0);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.sdk_ds8);
        setPadding(getResources().getDimensionPixelOffset(a.d.sdk_ds18), dimensionPixelOffset, getResources().getDimensionPixelOffset(a.d.sdk_ds36), dimensionPixelOffset);
        IJ();
        initView();
    }

    protected void IJ() {
        this.gRr = (TextView) findViewById(a.f.tv_rank);
        this.gRs = (ImageView) findViewById(a.f.iv_rank);
        this.gRt = (HeadImageView) findViewById(a.f.iv_avatar);
        this.gRu = (TbImageView) findViewById(a.f.iv_pendant);
        this.gRv = (ALALevelView) findViewById(a.f.level);
        this.aGM = (TextView) findViewById(a.f.tv_name);
        this.gRw = (TextView) findViewById(a.f.tv_value);
    }

    protected void initView() {
        this.gRt.setAutoChangeStyle(false);
        this.gRt.setDrawBorder(false);
        this.gRt.setIsRound(true);
        this.gRu.setDefaultBgResource(a.c.sdk_transparent);
        this.gRu.setDefaultErrorResource(a.e.sdk_shape_transparent);
    }
}
