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
    private i JT;
    private EmotionTabHorizonScrollView bWg;
    private ImageView bWh;
    private ImageView bWi;
    private View bWj;
    private boolean bWk;

    /* loaded from: classes.dex */
    public interface a {
        void eR(int i);
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
        this.bWg = (EmotionTabHorizonScrollView) findViewById(d.h.face_tab_scroll_view);
        this.bWh = (ImageView) findViewById(d.h.face_tab_delete);
        this.bWi = (ImageView) findViewById(d.h.face_tab_setting);
        this.bWj = findViewById(d.h.vertical_div_line);
        this.bWh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.JT != null) {
                    EmotionTabWidgetView.this.JT.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.bWi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.bWi.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.bWg != null) {
            this.bWg.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.bWg.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.bWg.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.bWg.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.bWg.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.bWg.reset();
    }

    public void setIsInChat(boolean z) {
        this.bWk = z;
        if (this.bWg != null) {
            this.bWg.setIsInChat(z);
        }
    }

    public void onChangeSkinType(int i) {
        ai.e(this, d.e.common_color_10255, i);
        this.bWg.dr(i);
        ai.c(this.bWh, d.g.emotion_delete, i);
        ai.e(this.bWh, d.e.common_color_10255, i);
        ai.c(this.bWi, d.g.icon_sett_s, i);
        ai.e(this.bWi, d.e.common_color_10255, i);
        ai.e(this.bWj, d.e.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.bWh.setVisibility(0);
        } else {
            this.bWh.setVisibility(8);
        }
    }

    public void n(int i, boolean z) {
        this.bWg.n(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.bWg.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(i iVar) {
        this.JT = iVar;
        this.bWg.setEditorTools(this.JT);
    }
}
