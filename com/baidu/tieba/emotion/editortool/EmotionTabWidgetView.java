package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.UserCollectManageActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.editortools.i;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private i Lt;
    private EmotionTabHorizonScrollView bXZ;
    private ImageView bYa;
    private ImageView bYb;
    private View bYc;
    private boolean bYd;

    /* loaded from: classes.dex */
    public interface a {
        void eT(int i);
    }

    public EmotionTabWidgetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public EmotionTabWidgetView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        removeAllViews();
        LayoutInflater.from(context).inflate(d.j.emotion_tab_widget, (ViewGroup) this, true);
        this.bXZ = (EmotionTabHorizonScrollView) findViewById(d.h.face_tab_scroll_view);
        this.bYa = (ImageView) findViewById(d.h.face_tab_delete);
        this.bYb = (ImageView) findViewById(d.h.face_tab_setting);
        this.bYc = findViewById(d.h.vertical_div_line);
        this.bYa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.Lt != null) {
                    EmotionTabWidgetView.this.Lt.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.bYb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.bYb.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.bXZ != null) {
            this.bXZ.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.bXZ.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.bXZ.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.bXZ.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.bXZ.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.bXZ.reset();
    }

    public void setIsInChat(boolean z) {
        this.bYd = z;
        if (this.bXZ != null) {
            this.bXZ.setIsInChat(z);
        }
    }

    public void onChangeSkinType(int i) {
        ai.e(this, d.e.common_color_10255, i);
        this.bXZ.dt(i);
        ai.c(this.bYa, d.g.emotion_delete, i);
        ai.e(this.bYa, d.e.common_color_10255, i);
        ai.c(this.bYb, d.g.icon_sett_s, i);
        ai.e(this.bYb, d.e.common_color_10255, i);
        ai.e(this.bYc, d.e.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.bYa.setVisibility(0);
        } else {
            this.bYa.setVisibility(8);
        }
    }

    public void n(int i, boolean z) {
        this.bXZ.n(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.bXZ.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(i iVar) {
        this.Lt = iVar;
        this.bXZ.setEditorTools(this.Lt);
    }
}
