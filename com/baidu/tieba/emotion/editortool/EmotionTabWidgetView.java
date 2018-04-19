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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private EditorTools JS;
    private EmotionTabHorizonScrollView cGw;
    private ImageView cGx;
    private ImageView cGy;
    private View cGz;

    /* loaded from: classes.dex */
    public interface a {
        void eS(int i);
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
        this.cGw = (EmotionTabHorizonScrollView) findViewById(d.g.face_tab_scroll_view);
        this.cGx = (ImageView) findViewById(d.g.face_tab_delete);
        this.cGy = (ImageView) findViewById(d.g.face_tab_setting);
        this.cGz = findViewById(d.g.vertical_div_line);
        this.cGx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabWidgetView.this.JS != null) {
                    EmotionTabWidgetView.this.JS.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.cGy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.cGy.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.cGw != null) {
            this.cGw.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.cGw.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.cGw.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.cGw.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.cGw.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.cGw.reset();
    }

    public void onChangeSkinType(int i) {
        ak.e(this, d.C0126d.common_color_10255, i);
        this.cGw.dz(i);
        ak.b(this.cGx, d.f.emotion_delete, i);
        ak.e(this.cGx, d.C0126d.common_color_10255, i);
        ak.b(this.cGy, d.f.icon_sett_s, i);
        ak.e(this.cGy, d.C0126d.common_color_10255, i);
        ak.e(this.cGz, d.C0126d.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.cGx.setVisibility(0);
        } else {
            this.cGx.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.cGw.setTabWidgetVisibility(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.cGw.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.JS = editorTools;
        this.cGw.setEditorTools(this.JS);
    }
}
