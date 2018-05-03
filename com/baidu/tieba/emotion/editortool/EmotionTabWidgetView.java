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
    private EmotionTabHorizonScrollView cGt;
    private ImageView cGu;
    private ImageView cGv;
    private View cGw;

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
        this.cGt = (EmotionTabHorizonScrollView) findViewById(d.g.face_tab_scroll_view);
        this.cGu = (ImageView) findViewById(d.g.face_tab_delete);
        this.cGv = (ImageView) findViewById(d.g.face_tab_setting);
        this.cGw = findViewById(d.g.vertical_div_line);
        this.cGu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabWidgetView.this.JS != null) {
                    EmotionTabWidgetView.this.JS.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.cGv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.cGv.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.cGt != null) {
            this.cGt.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.cGt.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.cGt.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.cGt.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.cGt.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.cGt.reset();
    }

    public void onChangeSkinType(int i) {
        ak.e(this, d.C0126d.common_color_10255, i);
        this.cGt.dz(i);
        ak.b(this.cGu, d.f.emotion_delete, i);
        ak.e(this.cGu, d.C0126d.common_color_10255, i);
        ak.b(this.cGv, d.f.icon_sett_s, i);
        ak.e(this.cGv, d.C0126d.common_color_10255, i);
        ak.e(this.cGw, d.C0126d.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.cGu.setVisibility(0);
        } else {
            this.cGu.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.cGt.setTabWidgetVisibility(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.cGt.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.JS = editorTools;
        this.cGt.setEditorTools(this.JS);
    }
}
