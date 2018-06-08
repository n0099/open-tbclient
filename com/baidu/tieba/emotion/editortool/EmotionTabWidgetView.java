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
/* loaded from: classes.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private EditorTools Qh;
    private EmotionTabHorizonScrollView cQJ;
    private ImageView cQK;
    private ImageView cQL;
    private View cQM;

    /* loaded from: classes.dex */
    public interface a {
        void eX(int i);
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
        this.cQJ = (EmotionTabHorizonScrollView) findViewById(d.g.face_tab_scroll_view);
        this.cQK = (ImageView) findViewById(d.g.face_tab_delete);
        this.cQL = (ImageView) findViewById(d.g.face_tab_setting);
        this.cQM = findViewById(d.g.vertical_div_line);
        this.cQK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.Qh != null) {
                    EmotionTabWidgetView.this.Qh.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.cQL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.cQL.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.cQJ != null) {
            this.cQJ.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.cQJ.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.cQJ.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.cQJ.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.cQJ.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.cQJ.reset();
    }

    public void onChangeSkinType(int i) {
        al.e(this, d.C0141d.common_color_10255, i);
        this.cQJ.dC(i);
        al.b(this.cQK, d.f.emotion_delete, i);
        al.e(this.cQK, d.C0141d.common_color_10255, i);
        al.b(this.cQL, d.f.icon_sett_s, i);
        al.e(this.cQL, d.C0141d.common_color_10255, i);
        al.e(this.cQM, d.C0141d.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.cQK.setVisibility(0);
        } else {
            this.cQK.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.cQJ.setTabWidgetVisibility(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.cQJ.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.Qh = editorTools;
        this.cQJ.setEditorTools(this.Qh);
    }
}
