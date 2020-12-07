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
import com.baidu.live.utils.l;
import com.baidu.live.view.ALALevelView;
/* loaded from: classes4.dex */
public class CharmItemView extends LinearLayout {
    public TextView aGv;
    public TextView gFE;
    public ImageView gFF;
    public HeadImageView gFG;
    public TbImageView gFH;
    public ALALevelView gFI;
    public TextView gFJ;

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
            this.gFE.setTextColor(-838860801);
            this.gFH.setVisibility(0);
        } else {
            this.gFE.setTextColor(1728053247);
            this.gFH.setVisibility(8);
        }
        if (i == 1 || (i == 2 && i2 >= 1 && j > 0)) {
            this.gFE.setText(i2 <= 100 ? String.valueOf(i2) : "100+");
            this.gFE.setVisibility(0);
            this.gFF.setVisibility(8);
        } else {
            this.gFE.setVisibility(8);
            this.gFF.setVisibility(0);
        }
        if (this.gFE.getText() != null) {
            TextView textView = this.gFE;
            if (this.gFE.getText().length() > 3) {
                dimensionPixelSize = getResources().getDimensionPixelSize(a.d.sdk_fontsize24);
            } else {
                dimensionPixelSize = getResources().getDimensionPixelSize(a.d.sdk_fontsize36);
            }
            textView.setTextSize(0, dimensionPixelSize);
        }
        l.a(this.gFG, str2, true, false);
        if (i == 2 && j > 0) {
            switch (i2) {
                case 1:
                    this.gFH.setImageResource(a.e.pic_live_list_top1);
                    break;
                case 2:
                    this.gFH.setImageResource(a.e.pic_live_list_top2);
                    break;
                case 3:
                    this.gFH.setImageResource(a.e.pic_live_list_top3);
                    break;
            }
        }
        this.aGv.setText(str);
        switch (i) {
            case 1:
                this.gFJ.setText(String.format(getResources().getString(a.h.sdk_charm_rank_forward_diff), StringHelper.formatValue(j2)));
                return;
            case 2:
                if (j > 0) {
                    this.gFJ.setText(String.format("%s 魅力", StringHelper.formatValue(j)));
                    return;
                } else {
                    this.gFJ.setText("");
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
        Jh();
        initView();
    }

    protected void Jh() {
        this.gFE = (TextView) findViewById(a.f.tv_rank);
        this.gFF = (ImageView) findViewById(a.f.iv_rank);
        this.gFG = (HeadImageView) findViewById(a.f.iv_avatar);
        this.gFH = (TbImageView) findViewById(a.f.iv_pendant);
        this.gFI = (ALALevelView) findViewById(a.f.level);
        this.aGv = (TextView) findViewById(a.f.tv_name);
        this.gFJ = (TextView) findViewById(a.f.tv_value);
    }

    protected void initView() {
        this.gFG.setAutoChangeStyle(false);
        this.gFG.setDrawBorder(false);
        this.gFG.setIsRound(true);
        this.gFH.setDefaultBgResource(a.c.sdk_transparent);
        this.gFH.setDefaultErrorResource(a.e.sdk_shape_transparent);
    }
}
