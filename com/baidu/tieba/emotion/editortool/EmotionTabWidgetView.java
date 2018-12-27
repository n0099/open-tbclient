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
    private EmotionTabHorizonScrollView dpX;
    private ImageView dpY;
    private ImageView dpZ;
    private View dqa;

    /* loaded from: classes5.dex */
    public interface a {
        void fW(int i);
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
        this.dpX = (EmotionTabHorizonScrollView) findViewById(e.g.face_tab_scroll_view);
        this.dpY = (ImageView) findViewById(e.g.face_tab_delete);
        this.dpZ = (ImageView) findViewById(e.g.face_tab_setting);
        this.dqa = findViewById(e.g.vertical_div_line);
        this.dpY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.Ta != null) {
                    EmotionTabWidgetView.this.Ta.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.dpZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.dpZ.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.dpX != null) {
            this.dpX.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.dpX.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.dpX.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.dpX.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.dpX.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.dpX.reset();
    }

    public void onChangeSkinType(int i) {
        al.e(this, e.d.common_color_10255, i);
        this.dpX.eD(i);
        al.b(this.dpY, e.f.emotion_delete, i);
        al.e(this.dpY, e.d.common_color_10255, i);
        al.b(this.dpZ, e.f.icon_sett_s, i);
        al.e(this.dpZ, e.d.common_color_10255, i);
        al.e(this.dqa, e.d.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.dpY.setVisibility(0);
        } else {
            this.dpY.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.dpX.setTabWidgetVisibility(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.dpX.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.Ta = editorTools;
        this.dpX.setEditorTools(this.Ta);
    }
}
