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
    private EditorTools Tj;
    private EmotionTabHorizonScrollView dqK;
    private ImageView dqL;
    private ImageView dqM;
    private View dqN;

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
        this.dqK = (EmotionTabHorizonScrollView) findViewById(e.g.face_tab_scroll_view);
        this.dqL = (ImageView) findViewById(e.g.face_tab_delete);
        this.dqM = (ImageView) findViewById(e.g.face_tab_setting);
        this.dqN = findViewById(e.g.vertical_div_line);
        this.dqL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.Tj != null) {
                    EmotionTabWidgetView.this.Tj.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.dqM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.dqM.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.dqK != null) {
            this.dqK.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.dqK.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.dqK.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.dqK.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.dqK.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.dqK.reset();
    }

    public void onChangeSkinType(int i) {
        al.e(this, e.d.common_color_10255, i);
        this.dqK.eD(i);
        al.b(this.dqL, e.f.emotion_delete, i);
        al.e(this.dqL, e.d.common_color_10255, i);
        al.b(this.dqM, e.f.icon_sett_s, i);
        al.e(this.dqM, e.d.common_color_10255, i);
        al.e(this.dqN, e.d.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.dqL.setVisibility(0);
        } else {
            this.dqL.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.dqK.setTabWidgetVisibility(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.dqK.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.Tj = editorTools;
        this.dqK.setEditorTools(this.Tj);
    }
}
