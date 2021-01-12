package com.baidu.tieba.ala.alaar.sticker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes10.dex */
public class AlaStickerDragDeletePanelView extends RelativeLayout {
    private RelativeLayout grX;
    private View grY;
    private ImageView grZ;
    private TextView gsa;
    private TextView gsb;
    private View gsc;
    private View gsd;
    private View gse;

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
        this.grX = (RelativeLayout) findViewById(a.f.delete_panel_top);
        this.grY = findViewById(a.f.delete_panel_top_bg);
        this.gsc = findViewById(a.f.delete_panel_delete_info);
        this.grZ = (ImageView) findViewById(a.f.delete_panel_delete_img);
        this.gsa = (TextView) findViewById(a.f.delete_panel_delete_text);
        this.gsd = findViewById(a.f.delete_panel_im);
        this.gse = findViewById(a.f.delete_panel_im_right);
        this.gsb = (TextView) findViewById(a.f.delete_panel_bottom);
    }

    public void mi(boolean z) {
        if (z) {
            this.grY.setBackgroundResource(a.c.color_live_sticker_red_40);
            this.grZ.setBackgroundResource(a.e.icon_live_paste_delete_on_n);
            this.gsa.setText(a.h.ala_live_sticker_delete);
            return;
        }
        this.grY.setBackgroundResource(a.c.color_live_sticker_red_50);
        this.grZ.setBackgroundResource(a.e.icon_live_paste_delete_n);
        this.gsa.setText(a.h.ala_live_sticker_delete_move);
    }

    public void setTopDeletePanelHeight(int i) {
        if (i > getResources().getDimensionPixelOffset(a.d.sdk_ds30)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.grX.getLayoutParams();
            layoutParams.height = i;
            this.grX.setLayoutParams(layoutParams);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.grX.getLayoutParams();
            layoutParams2.height = getTopDeletePanelHeight();
            this.grX.setLayoutParams(layoutParams2);
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gsc.getLayoutParams();
            layoutParams3.addRule(12);
            layoutParams3.bottomMargin = getResources().getDimensionPixelOffset(a.d.sdk_ds40);
            this.gsc.setLayoutParams(layoutParams3);
            return;
        }
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.gsc.getLayoutParams();
        layoutParams4.addRule(15);
        this.gsc.setLayoutParams(layoutParams4);
    }

    public int getTopDeletePanelBottom() {
        return this.grX.getBottom();
    }

    public void setDeleteBottomHeight(int i) {
        if (i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gsb.getLayoutParams();
            layoutParams.height = i;
            this.gsb.setLayoutParams(layoutParams);
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
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gsd.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.gsd.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gse.getLayoutParams();
        layoutParams2.width = BdUtilHelper.getEquipmentWidth(getContext()) - i;
        layoutParams2.height = i2;
        this.gse.setLayoutParams(layoutParams2);
    }
}
