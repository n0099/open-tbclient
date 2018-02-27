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
    private i axG;
    private EmotionTabHorizonScrollView doo;
    private ImageView dop;
    private ImageView doq;
    private View dor;

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
        this.doo = (EmotionTabHorizonScrollView) findViewById(d.g.face_tab_scroll_view);
        this.dop = (ImageView) findViewById(d.g.face_tab_delete);
        this.doq = (ImageView) findViewById(d.g.face_tab_setting);
        this.dor = findViewById(d.g.vertical_div_line);
        this.dop.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.axG != null) {
                    EmotionTabWidgetView.this.axG.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.doq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.doq.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.doo != null) {
            this.doo.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.doo.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.doo.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.doo.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.doo.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.doo.reset();
    }

    public void onChangeSkinType(int i) {
        aj.g(this, d.C0141d.common_color_10255, i);
        this.doo.gB(i);
        aj.b(this.dop, d.f.emotion_delete, i);
        aj.g(this.dop, d.C0141d.common_color_10255, i);
        aj.b(this.doq, d.f.icon_sett_s, i);
        aj.g(this.doq, d.C0141d.common_color_10255, i);
        aj.g(this.dor, d.C0141d.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.dop.setVisibility(0);
        } else {
            this.dop.setVisibility(8);
        }
    }

    public void C(int i, boolean z) {
        this.doo.C(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.doo.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(i iVar) {
        this.axG = iVar;
        this.doo.setEditorTools(this.axG);
    }
}
