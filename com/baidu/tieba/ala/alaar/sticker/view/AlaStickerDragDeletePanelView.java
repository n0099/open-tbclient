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
    private RelativeLayout eYq;
    private View eYr;
    private ImageView eYs;
    private TextView eYt;
    private TextView eYu;
    private View eYv;

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
        this.eYq = (RelativeLayout) findViewById(a.g.delete_panel_top);
        this.eYr = findViewById(a.g.delete_panel_top_bg);
        this.eYv = findViewById(a.g.delete_panel_delete_info);
        this.eYs = (ImageView) findViewById(a.g.delete_panel_delete_img);
        this.eYt = (TextView) findViewById(a.g.delete_panel_delete_text);
        this.eYu = (TextView) findViewById(a.g.delete_panel_bottom);
    }

    public void jf(boolean z) {
        if (z) {
            this.eYr.setBackgroundResource(a.d.color_live_sticker_red_40);
            this.eYs.setBackgroundResource(a.f.icon_live_paste_delete_on_n);
            this.eYt.setText(a.i.ala_live_sticker_delete);
            return;
        }
        this.eYr.setBackgroundResource(a.d.color_live_sticker_red_50);
        this.eYs.setBackgroundResource(a.f.icon_live_paste_delete_n);
        this.eYt.setText(a.i.ala_live_sticker_delete_move);
    }

    public void setTopDeletePanelHeight(int i) {
        if (i > getResources().getDimensionPixelOffset(a.e.sdk_ds30)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eYq.getLayoutParams();
            layoutParams.height = i;
            this.eYq.setLayoutParams(layoutParams);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eYq.getLayoutParams();
            layoutParams2.height = getTopDeletePanelHeight();
            this.eYq.setLayoutParams(layoutParams2);
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.eYv.getLayoutParams();
            layoutParams3.addRule(12);
            layoutParams3.bottomMargin = getResources().getDimensionPixelOffset(a.e.sdk_ds40);
            this.eYv.setLayoutParams(layoutParams3);
            return;
        }
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.eYv.getLayoutParams();
        layoutParams4.addRule(15);
        this.eYv.setLayoutParams(layoutParams4);
    }

    public int getTopDeletePanelBottom() {
        return this.eYq.getBottom();
    }

    public void setDeleteBottomHeight(int i) {
        if (i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eYu.getLayoutParams();
            layoutParams.height = i;
            this.eYu.setLayoutParams(layoutParams);
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
