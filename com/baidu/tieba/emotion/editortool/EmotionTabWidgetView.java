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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.editortools.i;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private i IT;
    private EmotionTabHorizonScrollView csb;
    private ImageView csc;
    private ImageView csd;
    private View cse;

    /* loaded from: classes.dex */
    public interface a {
        void fb(int i);
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
        this.csb = (EmotionTabHorizonScrollView) findViewById(d.g.face_tab_scroll_view);
        this.csc = (ImageView) findViewById(d.g.face_tab_delete);
        this.csd = (ImageView) findViewById(d.g.face_tab_setting);
        this.cse = findViewById(d.g.vertical_div_line);
        this.csc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.IT != null) {
                    EmotionTabWidgetView.this.IT.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.csd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.csd.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.csb != null) {
            this.csb.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.csb.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.csb.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.csb.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.csb.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.csb.reset();
    }

    public void onChangeSkinType(int i) {
        aj.e(this, d.C0082d.common_color_10255, i);
        this.csb.dE(i);
        aj.b(this.csc, d.f.emotion_delete, i);
        aj.e(this.csc, d.C0082d.common_color_10255, i);
        aj.b(this.csd, d.f.icon_sett_s, i);
        aj.e(this.csd, d.C0082d.common_color_10255, i);
        aj.e(this.cse, d.C0082d.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.csc.setVisibility(0);
        } else {
            this.csc.setVisibility(8);
        }
    }

    public void m(int i, boolean z) {
        this.csb.m(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.csb.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(i iVar) {
        this.IT = iVar;
        this.csb.setEditorTools(this.IT);
    }
}
