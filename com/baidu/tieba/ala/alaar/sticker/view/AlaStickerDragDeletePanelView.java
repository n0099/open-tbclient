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
    private RelativeLayout gmg;
    private View gmh;
    private ImageView gmi;
    private TextView gmj;
    private TextView gmk;
    private View gml;
    private View gmm;
    private View gmn;

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
        this.gmg = (RelativeLayout) findViewById(a.f.delete_panel_top);
        this.gmh = findViewById(a.f.delete_panel_top_bg);
        this.gml = findViewById(a.f.delete_panel_delete_info);
        this.gmi = (ImageView) findViewById(a.f.delete_panel_delete_img);
        this.gmj = (TextView) findViewById(a.f.delete_panel_delete_text);
        this.gmm = findViewById(a.f.delete_panel_im);
        this.gmn = findViewById(a.f.delete_panel_im_right);
        this.gmk = (TextView) findViewById(a.f.delete_panel_bottom);
    }

    public void lP(boolean z) {
        if (z) {
            this.gmh.setBackgroundResource(a.c.color_live_sticker_red_40);
            this.gmi.setBackgroundResource(a.e.icon_live_paste_delete_on_n);
            this.gmj.setText(a.h.ala_live_sticker_delete);
            return;
        }
        this.gmh.setBackgroundResource(a.c.color_live_sticker_red_50);
        this.gmi.setBackgroundResource(a.e.icon_live_paste_delete_n);
        this.gmj.setText(a.h.ala_live_sticker_delete_move);
    }

    public void setTopDeletePanelHeight(int i) {
        if (i > getResources().getDimensionPixelOffset(a.d.sdk_ds30)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gmg.getLayoutParams();
            layoutParams.height = i;
            this.gmg.setLayoutParams(layoutParams);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gmg.getLayoutParams();
            layoutParams2.height = getTopDeletePanelHeight();
            this.gmg.setLayoutParams(layoutParams2);
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gml.getLayoutParams();
            layoutParams3.addRule(12);
            layoutParams3.bottomMargin = getResources().getDimensionPixelOffset(a.d.sdk_ds40);
            this.gml.setLayoutParams(layoutParams3);
            return;
        }
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.gml.getLayoutParams();
        layoutParams4.addRule(15);
        this.gml.setLayoutParams(layoutParams4);
    }

    public int getTopDeletePanelBottom() {
        return this.gmg.getBottom();
    }

    public void setDeleteBottomHeight(int i) {
        if (i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gmk.getLayoutParams();
            layoutParams.height = i;
            this.gmk.setLayoutParams(layoutParams);
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
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gmm.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.gmm.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gmn.getLayoutParams();
        layoutParams2.width = BdUtilHelper.getEquipmentWidth(getContext()) - i;
        layoutParams2.height = i2;
        this.gmn.setLayoutParams(layoutParams2);
    }
}
