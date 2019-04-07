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
/* loaded from: classes2.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private EditorTools VN;
    private EmotionTabHorizonScrollView eAo;
    private ImageView eAp;
    private ImageView eAq;
    private View eAr;

    /* loaded from: classes2.dex */
    public interface a {
        void jG(int i);
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
        this.eAo = (EmotionTabHorizonScrollView) findViewById(d.g.face_tab_scroll_view);
        this.eAp = (ImageView) findViewById(d.g.face_tab_delete);
        this.eAq = (ImageView) findViewById(d.g.face_tab_setting);
        this.eAr = findViewById(d.g.vertical_div_line);
        this.eAp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.VN != null) {
                    EmotionTabWidgetView.this.VN.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.eAq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.eAq.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.eAo != null) {
            this.eAo.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.eAo.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.eAo.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.eAo.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.eAo.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.eAo.reset();
    }

    public void onChangeSkinType(int i) {
        al.f(this, d.C0277d.common_color_10255, i);
        this.eAo.ii(i);
        al.b(this.eAp, d.f.emotion_delete, i);
        al.f(this.eAp, d.C0277d.common_color_10255, i);
        al.b(this.eAq, d.f.icon_sett_s, i);
        al.f(this.eAq, d.C0277d.common_color_10255, i);
        al.f(this.eAr, d.C0277d.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.eAp.setVisibility(0);
        } else {
            this.eAp.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.eAo.setTabWidgetVisibility(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.eAo.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.VN = editorTools;
        this.eAo.setEditorTools(this.VN);
    }
}
