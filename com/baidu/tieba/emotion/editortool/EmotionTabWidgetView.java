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
    private EditorTools Qg;
    private EmotionTabHorizonScrollView cRn;
    private ImageView cRo;
    private ImageView cRp;
    private View cRq;

    /* loaded from: classes.dex */
    public interface a {
        void eZ(int i);
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
        this.cRn = (EmotionTabHorizonScrollView) findViewById(d.g.face_tab_scroll_view);
        this.cRo = (ImageView) findViewById(d.g.face_tab_delete);
        this.cRp = (ImageView) findViewById(d.g.face_tab_setting);
        this.cRq = findViewById(d.g.vertical_div_line);
        this.cRo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.Qg != null) {
                    EmotionTabWidgetView.this.Qg.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.cRp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.cRp.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.cRn != null) {
            this.cRn.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.cRn.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.cRn.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.cRn.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.cRn.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.cRn.reset();
    }

    public void onChangeSkinType(int i) {
        am.e(this, d.C0140d.common_color_10255, i);
        this.cRn.dG(i);
        am.b(this.cRo, d.f.emotion_delete, i);
        am.e(this.cRo, d.C0140d.common_color_10255, i);
        am.b(this.cRp, d.f.icon_sett_s, i);
        am.e(this.cRp, d.C0140d.common_color_10255, i);
        am.e(this.cRq, d.C0140d.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.cRo.setVisibility(0);
        } else {
            this.cRo.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.cRn.setTabWidgetVisibility(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.cRn.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.Qg = editorTools;
        this.cRn.setEditorTools(this.Qg);
    }
}
