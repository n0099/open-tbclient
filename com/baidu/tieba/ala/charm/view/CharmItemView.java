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
    public TextView gFG;
    public ImageView gFH;
    public HeadImageView gFI;
    public TbImageView gFJ;
    public ALALevelView gFK;
    public TextView gFL;

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
            this.gFG.setTextColor(-838860801);
            this.gFJ.setVisibility(0);
        } else {
            this.gFG.setTextColor(1728053247);
            this.gFJ.setVisibility(8);
        }
        if (i == 1 || (i == 2 && i2 >= 1 && j > 0)) {
            this.gFG.setText(i2 <= 100 ? String.valueOf(i2) : "100+");
            this.gFG.setVisibility(0);
            this.gFH.setVisibility(8);
        } else {
            this.gFG.setVisibility(8);
            this.gFH.setVisibility(0);
        }
        if (this.gFG.getText() != null) {
            TextView textView = this.gFG;
            if (this.gFG.getText().length() > 3) {
                dimensionPixelSize = getResources().getDimensionPixelSize(a.d.sdk_fontsize24);
            } else {
                dimensionPixelSize = getResources().getDimensionPixelSize(a.d.sdk_fontsize36);
            }
            textView.setTextSize(0, dimensionPixelSize);
        }
        l.a(this.gFI, str2, true, false);
        if (i == 2 && j > 0) {
            switch (i2) {
                case 1:
                    this.gFJ.setImageResource(a.e.pic_live_list_top1);
                    break;
                case 2:
                    this.gFJ.setImageResource(a.e.pic_live_list_top2);
                    break;
                case 3:
                    this.gFJ.setImageResource(a.e.pic_live_list_top3);
                    break;
            }
        }
        this.aGv.setText(str);
        switch (i) {
            case 1:
                this.gFL.setText(String.format(getResources().getString(a.h.sdk_charm_rank_forward_diff), StringHelper.formatValue(j2)));
                return;
            case 2:
                if (j > 0) {
                    this.gFL.setText(String.format("%s 魅力", StringHelper.formatValue(j)));
                    return;
                } else {
                    this.gFL.setText("");
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
        this.gFG = (TextView) findViewById(a.f.tv_rank);
        this.gFH = (ImageView) findViewById(a.f.iv_rank);
        this.gFI = (HeadImageView) findViewById(a.f.iv_avatar);
        this.gFJ = (TbImageView) findViewById(a.f.iv_pendant);
        this.gFK = (ALALevelView) findViewById(a.f.level);
        this.aGv = (TextView) findViewById(a.f.tv_name);
        this.gFL = (TextView) findViewById(a.f.tv_value);
    }

    protected void initView() {
        this.gFI.setAutoChangeStyle(false);
        this.gFI.setDrawBorder(false);
        this.gFI.setIsRound(true);
        this.gFJ.setDefaultBgResource(a.c.sdk_transparent);
        this.gFJ.setDefaultErrorResource(a.e.sdk_shape_transparent);
    }
}
