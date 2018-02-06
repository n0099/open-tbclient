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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.editortools.i;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private i axP;
    private EmotionTabHorizonScrollView doA;
    private ImageView doB;
    private ImageView doC;
    private View doD;

    /* loaded from: classes.dex */
    public interface a {
        void hT(int i);
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
        this.doA = (EmotionTabHorizonScrollView) findViewById(d.g.face_tab_scroll_view);
        this.doB = (ImageView) findViewById(d.g.face_tab_delete);
        this.doC = (ImageView) findViewById(d.g.face_tab_setting);
        this.doD = findViewById(d.g.vertical_div_line);
        this.doB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.axP != null) {
                    EmotionTabWidgetView.this.axP.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.doC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.doC.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.doA != null) {
            this.doA.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.doA.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.doA.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.doA.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.doA.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.doA.reset();
    }

    public void onChangeSkinType(int i) {
        aj.g(this, d.C0140d.common_color_10255, i);
        this.doA.gB(i);
        aj.b(this.doB, d.f.emotion_delete, i);
        aj.g(this.doB, d.C0140d.common_color_10255, i);
        aj.b(this.doC, d.f.icon_sett_s, i);
        aj.g(this.doC, d.C0140d.common_color_10255, i);
        aj.g(this.doD, d.C0140d.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.doB.setVisibility(0);
        } else {
            this.doB.setVisibility(8);
        }
    }

    public void C(int i, boolean z) {
        this.doA.C(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.doA.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(i iVar) {
        this.axP = iVar;
        this.doA.setEditorTools(this.axP);
    }
}
