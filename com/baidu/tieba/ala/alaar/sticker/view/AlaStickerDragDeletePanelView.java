package com.baidu.tieba.ala.alaar.sticker.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes4.dex */
public class AlaStickerDragDeletePanelView extends RelativeLayout {
    private RelativeLayout gme;
    private View gmf;
    private ImageView gmg;
    private TextView gmh;
    private TextView gmi;
    private View gmj;
    private View gmk;
    private View gml;

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
        LayoutInflater.from(getContext()).inflate(a.g.ala_sticker_delete_panel, this);
        this.gme = (RelativeLayout) findViewById(a.f.delete_panel_top);
        this.gmf = findViewById(a.f.delete_panel_top_bg);
        this.gmj = findViewById(a.f.delete_panel_delete_info);
        this.gmg = (ImageView) findViewById(a.f.delete_panel_delete_img);
        this.gmh = (TextView) findViewById(a.f.delete_panel_delete_text);
        this.gmk = findViewById(a.f.delete_panel_im);
        this.gml = findViewById(a.f.delete_panel_im_right);
        this.gmi = (TextView) findViewById(a.f.delete_panel_bottom);
    }

    public void lP(boolean z) {
        if (z) {
            this.gmf.setBackgroundResource(a.c.color_live_sticker_red_40);
            this.gmg.setBackgroundResource(a.e.icon_live_paste_delete_on_n);
            this.gmh.setText(a.h.ala_live_sticker_delete);
            return;
        }
        this.gmf.setBackgroundResource(a.c.color_live_sticker_red_50);
        this.gmg.setBackgroundResource(a.e.icon_live_paste_delete_n);
        this.gmh.setText(a.h.ala_live_sticker_delete_move);
    }

    public void setTopDeletePanelHeight(int i) {
        if (i > getResources().getDimensionPixelOffset(a.d.sdk_ds30)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gme.getLayoutParams();
            layoutParams.height = i;
            this.gme.setLayoutParams(layoutParams);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gme.getLayoutParams();
            layoutParams2.height = getTopDeletePanelHeight();
            this.gme.setLayoutParams(layoutParams2);
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gmj.getLayoutParams();
            layoutParams3.addRule(12);
            layoutParams3.bottomMargin = getResources().getDimensionPixelOffset(a.d.sdk_ds40);
            this.gmj.setLayoutParams(layoutParams3);
            return;
        }
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.gmj.getLayoutParams();
        layoutParams4.addRule(15);
        this.gmj.setLayoutParams(layoutParams4);
    }

    public int getTopDeletePanelBottom() {
        return this.gme.getBottom();
    }

    public void setDeleteBottomHeight(int i) {
        if (i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gmi.getLayoutParams();
            layoutParams.height = i;
            this.gmi.setLayoutParams(layoutParams);
        }
    }

    public int getTopDeletePanelHeight() {
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.sdk_ds184);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return getResources().getDimensionPixelOffset(a.d.sdk_ds184) + UtilHelper.getImmersiveStickyBarHeight();
        }
        return dimensionPixelOffset;
    }

    public void setImMsgViewSize(int i, int i2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gmk.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.gmk.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gml.getLayoutParams();
        layoutParams2.width = BdUtilHelper.getEquipmentWidth(getContext()) - i;
        layoutParams2.height = i2;
        this.gml.setLayoutParams(layoutParams2);
    }
}
