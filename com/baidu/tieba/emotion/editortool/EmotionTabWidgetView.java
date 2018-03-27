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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.editortools.i;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private i axH;
    private EmotionTabHorizonScrollView dor;
    private ImageView dos;
    private ImageView dot;
    private View dou;

    /* loaded from: classes.dex */
    public interface a {
        void hT(int i);
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
        LayoutInflater.from(context).inflate(d.h.emotion_tab_widget, (ViewGroup) this, true);
        this.dor = (EmotionTabHorizonScrollView) findViewById(d.g.face_tab_scroll_view);
        this.dos = (ImageView) findViewById(d.g.face_tab_delete);
        this.dot = (ImageView) findViewById(d.g.face_tab_setting);
        this.dou = findViewById(d.g.vertical_div_line);
        this.dos.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.axH != null) {
                    EmotionTabWidgetView.this.axH.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.dot.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.dot.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.dor != null) {
            this.dor.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.dor.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.dor.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.dor.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.dor.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.dor.reset();
    }

    public void onChangeSkinType(int i) {
        aj.g(this, d.C0141d.common_color_10255, i);
        this.dor.gB(i);
        aj.b(this.dos, d.f.emotion_delete, i);
        aj.g(this.dos, d.C0141d.common_color_10255, i);
        aj.b(this.dot, d.f.icon_sett_s, i);
        aj.g(this.dot, d.C0141d.common_color_10255, i);
        aj.g(this.dou, d.C0141d.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.dos.setVisibility(0);
        } else {
            this.dos.setVisibility(8);
        }
    }

    public void C(int i, boolean z) {
        this.dor.C(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.dor.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(i iVar) {
        this.axH = iVar;
        this.dor.setEditorTools(this.axH);
    }
}
