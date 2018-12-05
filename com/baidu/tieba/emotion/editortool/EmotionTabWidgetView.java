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
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private EditorTools Ta;
    private EmotionTabHorizonScrollView dnf;
    private ImageView dng;
    private ImageView dnh;
    private View dni;

    /* loaded from: classes5.dex */
    public interface a {
        void fV(int i);
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
        LayoutInflater.from(context).inflate(e.h.emotion_tab_widget, (ViewGroup) this, true);
        this.dnf = (EmotionTabHorizonScrollView) findViewById(e.g.face_tab_scroll_view);
        this.dng = (ImageView) findViewById(e.g.face_tab_delete);
        this.dnh = (ImageView) findViewById(e.g.face_tab_setting);
        this.dni = findViewById(e.g.vertical_div_line);
        this.dng.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.Ta != null) {
                    EmotionTabWidgetView.this.Ta.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.dnh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.dnh.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.dnf != null) {
            this.dnf.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.dnf.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.dnf.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.dnf.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.dnf.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.dnf.reset();
    }

    public void onChangeSkinType(int i) {
        al.e(this, e.d.common_color_10255, i);
        this.dnf.eC(i);
        al.b(this.dng, e.f.emotion_delete, i);
        al.e(this.dng, e.d.common_color_10255, i);
        al.b(this.dnh, e.f.icon_sett_s, i);
        al.e(this.dnh, e.d.common_color_10255, i);
        al.e(this.dni, e.d.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.dng.setVisibility(0);
        } else {
            this.dng.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.dnf.setTabWidgetVisibility(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.dnf.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.Ta = editorTools;
        this.dnf.setEditorTools(this.Ta);
    }
}
