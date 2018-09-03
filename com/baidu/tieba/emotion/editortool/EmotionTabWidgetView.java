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
import com.baidu.tieba.f;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private EditorTools Qg;
    private EmotionTabHorizonScrollView cRk;
    private ImageView cRl;
    private ImageView cRm;
    private View cRn;

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
        LayoutInflater.from(context).inflate(f.h.emotion_tab_widget, (ViewGroup) this, true);
        this.cRk = (EmotionTabHorizonScrollView) findViewById(f.g.face_tab_scroll_view);
        this.cRl = (ImageView) findViewById(f.g.face_tab_delete);
        this.cRm = (ImageView) findViewById(f.g.face_tab_setting);
        this.cRn = findViewById(f.g.vertical_div_line);
        this.cRl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.Qg != null) {
                    EmotionTabWidgetView.this.Qg.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.cRm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.cRm.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.cRk != null) {
            this.cRk.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.cRk.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.cRk.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.cRk.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.cRk.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.cRk.reset();
    }

    public void onChangeSkinType(int i) {
        am.e(this, f.d.common_color_10255, i);
        this.cRk.dF(i);
        am.b(this.cRl, f.C0146f.emotion_delete, i);
        am.e(this.cRl, f.d.common_color_10255, i);
        am.b(this.cRm, f.C0146f.icon_sett_s, i);
        am.e(this.cRm, f.d.common_color_10255, i);
        am.e(this.cRn, f.d.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.cRl.setVisibility(0);
        } else {
            this.cRl.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.cRk.setTabWidgetVisibility(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.cRk.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.Qg = editorTools;
        this.cRk.setEditorTools(this.Qg);
    }
}
