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
    private RelativeLayout eLD;
    private View eLE;
    private ImageView eLF;
    private TextView eLG;
    private TextView eLH;
    private View eLI;

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
        this.eLD = (RelativeLayout) findViewById(a.g.delete_panel_top);
        this.eLE = findViewById(a.g.delete_panel_top_bg);
        this.eLI = findViewById(a.g.delete_panel_delete_info);
        this.eLF = (ImageView) findViewById(a.g.delete_panel_delete_img);
        this.eLG = (TextView) findViewById(a.g.delete_panel_delete_text);
        this.eLH = (TextView) findViewById(a.g.delete_panel_bottom);
    }

    public void iN(boolean z) {
        if (z) {
            this.eLE.setBackgroundResource(a.d.color_live_sticker_red_40);
            this.eLF.setBackgroundResource(a.f.icon_live_paste_delete_on_n);
            this.eLG.setText(a.i.ala_live_sticker_delete);
            return;
        }
        this.eLE.setBackgroundResource(a.d.color_live_sticker_red_50);
        this.eLF.setBackgroundResource(a.f.icon_live_paste_delete_n);
        this.eLG.setText(a.i.ala_live_sticker_delete_move);
    }

    public void setTopDeletePanelHeight(int i) {
        if (i > getResources().getDimensionPixelOffset(a.e.sdk_ds30)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eLD.getLayoutParams();
            layoutParams.height = i;
            this.eLD.setLayoutParams(layoutParams);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eLD.getLayoutParams();
            layoutParams2.height = getTopDeletePanelHeight();
            this.eLD.setLayoutParams(layoutParams2);
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.eLI.getLayoutParams();
            layoutParams3.addRule(12);
            layoutParams3.bottomMargin = getResources().getDimensionPixelOffset(a.e.sdk_ds40);
            this.eLI.setLayoutParams(layoutParams3);
            return;
        }
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.eLI.getLayoutParams();
        layoutParams4.addRule(15);
        this.eLI.setLayoutParams(layoutParams4);
    }

    public int getTopDeletePanelBottom() {
        return this.eLD.getBottom();
    }

    public void setDeleteBottomHeight(int i) {
        if (i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eLH.getLayoutParams();
            layoutParams.height = i;
            this.eLH.setLayoutParams(layoutParams);
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
