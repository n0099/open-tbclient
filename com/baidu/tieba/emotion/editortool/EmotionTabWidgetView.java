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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private EditorTools VM;
    private EmotionTabHorizonScrollView eAH;
    private ImageView eAI;
    private ImageView eAJ;
    private View eAK;

    /* loaded from: classes2.dex */
    public interface a {
        void jH(int i);
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
        this.eAH = (EmotionTabHorizonScrollView) findViewById(d.g.face_tab_scroll_view);
        this.eAI = (ImageView) findViewById(d.g.face_tab_delete);
        this.eAJ = (ImageView) findViewById(d.g.face_tab_setting);
        this.eAK = findViewById(d.g.vertical_div_line);
        this.eAI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.VM != null) {
                    EmotionTabWidgetView.this.VM.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.eAJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.eAJ.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.eAH != null) {
            this.eAH.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.eAH.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.eAH.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.eAH.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.eAH.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.eAH.reset();
    }

    public void onChangeSkinType(int i) {
        al.f(this, d.C0236d.common_color_10255, i);
        this.eAH.ij(i);
        al.b(this.eAI, d.f.emotion_delete, i);
        al.f(this.eAI, d.C0236d.common_color_10255, i);
        al.b(this.eAJ, d.f.icon_sett_s, i);
        al.f(this.eAJ, d.C0236d.common_color_10255, i);
        al.f(this.eAK, d.C0236d.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.eAI.setVisibility(0);
        } else {
            this.eAI.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.eAH.setTabWidgetVisibility(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.eAH.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.VM = editorTools;
        this.eAH.setEditorTools(this.VM);
    }
}
