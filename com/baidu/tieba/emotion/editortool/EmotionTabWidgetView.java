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
/* loaded from: classes.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private EditorTools SG;
    private EmotionTabHorizonScrollView cXb;
    private ImageView cXc;
    private ImageView cXd;
    private View cXe;

    /* loaded from: classes.dex */
    public interface a {
        void fk(int i);
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
        this.cXb = (EmotionTabHorizonScrollView) findViewById(e.g.face_tab_scroll_view);
        this.cXc = (ImageView) findViewById(e.g.face_tab_delete);
        this.cXd = (ImageView) findViewById(e.g.face_tab_setting);
        this.cXe = findViewById(e.g.vertical_div_line);
        this.cXc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.SG != null) {
                    EmotionTabWidgetView.this.SG.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.cXd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.cXd.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.cXb != null) {
            this.cXb.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.cXb.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.cXb.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.cXb.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.cXb.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.cXb.reset();
    }

    public void onChangeSkinType(int i) {
        al.e(this, e.d.common_color_10255, i);
        this.cXb.dQ(i);
        al.b(this.cXc, e.f.emotion_delete, i);
        al.e(this.cXc, e.d.common_color_10255, i);
        al.b(this.cXd, e.f.icon_sett_s, i);
        al.e(this.cXd, e.d.common_color_10255, i);
        al.e(this.cXe, e.d.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.cXc.setVisibility(0);
        } else {
            this.cXc.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.cXb.setTabWidgetVisibility(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.cXb.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.SG = editorTools;
        this.cXb.setEditorTools(this.SG);
    }
}
