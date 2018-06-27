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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private EditorTools Qj;
    private EmotionTabHorizonScrollView cOE;
    private ImageView cOF;
    private ImageView cOG;
    private View cOH;

    /* loaded from: classes.dex */
    public interface a {
        void eY(int i);
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
        LayoutInflater.from(context).inflate(d.i.emotion_tab_widget, (ViewGroup) this, true);
        this.cOE = (EmotionTabHorizonScrollView) findViewById(d.g.face_tab_scroll_view);
        this.cOF = (ImageView) findViewById(d.g.face_tab_delete);
        this.cOG = (ImageView) findViewById(d.g.face_tab_setting);
        this.cOH = findViewById(d.g.vertical_div_line);
        this.cOF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.Qj != null) {
                    EmotionTabWidgetView.this.Qj.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.cOG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.cOG.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.cOE != null) {
            this.cOE.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.cOE.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.cOE.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.cOE.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.cOE.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.cOE.reset();
    }

    public void onChangeSkinType(int i) {
        am.e(this, d.C0142d.common_color_10255, i);
        this.cOE.dD(i);
        am.b(this.cOF, d.f.emotion_delete, i);
        am.e(this.cOF, d.C0142d.common_color_10255, i);
        am.b(this.cOG, d.f.icon_sett_s, i);
        am.e(this.cOG, d.C0142d.common_color_10255, i);
        am.e(this.cOH, d.C0142d.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.cOF.setVisibility(0);
        } else {
            this.cOF.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.cOE.setTabWidgetVisibility(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.cOE.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.Qj = editorTools;
        this.cOE.setEditorTools(this.Qj);
    }
}
