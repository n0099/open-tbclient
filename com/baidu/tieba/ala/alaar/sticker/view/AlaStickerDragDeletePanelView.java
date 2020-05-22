package com.baidu.tieba.ala.alaar.sticker.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class AlaStickerDragDeletePanelView extends RelativeLayout {
    private RelativeLayout eYf;
    private View eYg;
    private ImageView eYh;
    private TextView eYi;
    private TextView eYj;
    private View eYk;

    public AlaStickerDragDeletePanelView(Context context) {
        super(context);
        init(context);
    }

    public AlaStickerDragDeletePanelView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public AlaStickerDragDeletePanelView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(getContext()).inflate(a.h.ala_sticker_delete_panel, this);
        this.eYf = (RelativeLayout) findViewById(a.g.delete_panel_top);
        this.eYg = findViewById(a.g.delete_panel_top_bg);
        this.eYk = findViewById(a.g.delete_panel_delete_info);
        this.eYh = (ImageView) findViewById(a.g.delete_panel_delete_img);
        this.eYi = (TextView) findViewById(a.g.delete_panel_delete_text);
        this.eYj = (TextView) findViewById(a.g.delete_panel_bottom);
    }

    public void jf(boolean z) {
        if (z) {
            this.eYg.setBackgroundResource(a.d.color_live_sticker_red_40);
            this.eYh.setBackgroundResource(a.f.icon_live_paste_delete_on_n);
            this.eYi.setText(a.i.ala_live_sticker_delete);
            return;
        }
        this.eYg.setBackgroundResource(a.d.color_live_sticker_red_50);
        this.eYh.setBackgroundResource(a.f.icon_live_paste_delete_n);
        this.eYi.setText(a.i.ala_live_sticker_delete_move);
    }

    public void setTopDeletePanelHeight(int i) {
        if (i > getResources().getDimensionPixelOffset(a.e.sdk_ds30)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eYf.getLayoutParams();
            layoutParams.height = i;
            this.eYf.setLayoutParams(layoutParams);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eYf.getLayoutParams();
            layoutParams2.height = getTopDeletePanelHeight();
            this.eYf.setLayoutParams(layoutParams2);
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.eYk.getLayoutParams();
            layoutParams3.addRule(12);
            layoutParams3.bottomMargin = getResources().getDimensionPixelOffset(a.e.sdk_ds40);
            this.eYk.setLayoutParams(layoutParams3);
            return;
        }
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.eYk.getLayoutParams();
        layoutParams4.addRule(15);
        this.eYk.setLayoutParams(layoutParams4);
    }

    public int getTopDeletePanelBottom() {
        return this.eYf.getBottom();
    }

    public void setDeleteBottomHeight(int i) {
        if (i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eYj.getLayoutParams();
            layoutParams.height = i;
            this.eYj.setLayoutParams(layoutParams);
        }
    }

    public int getTopDeletePanelHeight() {
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.e.sdk_ds184);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return getResources().getDimensionPixelOffset(a.e.sdk_ds184) + UtilHelper.getImmersiveStickyBarHeight();
        }
        return dimensionPixelOffset;
    }
}
