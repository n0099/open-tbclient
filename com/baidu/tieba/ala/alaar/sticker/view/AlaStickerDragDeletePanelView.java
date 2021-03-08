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
    private RelativeLayout gwE;
    private View gwF;
    private ImageView gwG;
    private TextView gwH;
    private TextView gwI;
    private View gwJ;
    private View gwK;
    private View gwL;

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
        this.gwE = (RelativeLayout) findViewById(a.f.delete_panel_top);
        this.gwF = findViewById(a.f.delete_panel_top_bg);
        this.gwJ = findViewById(a.f.delete_panel_delete_info);
        this.gwG = (ImageView) findViewById(a.f.delete_panel_delete_img);
        this.gwH = (TextView) findViewById(a.f.delete_panel_delete_text);
        this.gwK = findViewById(a.f.delete_panel_im);
        this.gwL = findViewById(a.f.delete_panel_im_right);
        this.gwI = (TextView) findViewById(a.f.delete_panel_bottom);
    }

    public void mm(boolean z) {
        if (z) {
            this.gwF.setBackgroundResource(a.c.color_live_sticker_red_40);
            this.gwG.setBackgroundResource(a.e.icon_live_paste_delete_on_n);
            this.gwH.setText(a.h.ala_live_sticker_delete);
            return;
        }
        this.gwF.setBackgroundResource(a.c.color_live_sticker_red_50);
        this.gwG.setBackgroundResource(a.e.icon_live_paste_delete_n);
        this.gwH.setText(a.h.ala_live_sticker_delete_move);
    }

    public void setTopDeletePanelHeight(int i) {
        if (i > getResources().getDimensionPixelOffset(a.d.sdk_ds30)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gwE.getLayoutParams();
            layoutParams.height = i;
            this.gwE.setLayoutParams(layoutParams);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gwE.getLayoutParams();
            layoutParams2.height = getTopDeletePanelHeight();
            this.gwE.setLayoutParams(layoutParams2);
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gwJ.getLayoutParams();
            layoutParams3.addRule(12);
            layoutParams3.bottomMargin = getResources().getDimensionPixelOffset(a.d.sdk_ds40);
            this.gwJ.setLayoutParams(layoutParams3);
            return;
        }
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.gwJ.getLayoutParams();
        layoutParams4.addRule(15);
        this.gwJ.setLayoutParams(layoutParams4);
    }

    public int getTopDeletePanelBottom() {
        return this.gwE.getBottom();
    }

    public void setDeleteBottomHeight(int i) {
        if (i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gwI.getLayoutParams();
            layoutParams.height = i;
            this.gwI.setLayoutParams(layoutParams);
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
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gwK.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.gwK.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gwL.getLayoutParams();
        layoutParams2.width = BdUtilHelper.getEquipmentWidth(getContext()) - i;
        layoutParams2.height = i2;
        this.gwL.setLayoutParams(layoutParams2);
    }
}
