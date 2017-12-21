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
    private i IS;
    private EmotionTabHorizonScrollView cso;
    private ImageView csp;
    private ImageView csq;
    private View csr;

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
        this.cso = (EmotionTabHorizonScrollView) findViewById(d.g.face_tab_scroll_view);
        this.csp = (ImageView) findViewById(d.g.face_tab_delete);
        this.csq = (ImageView) findViewById(d.g.face_tab_setting);
        this.csr = findViewById(d.g.vertical_div_line);
        this.csp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.IS != null) {
                    EmotionTabWidgetView.this.IS.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.csq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.csq.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.cso != null) {
            this.cso.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.cso.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.cso.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.cso.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.cso.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.cso.reset();
    }

    public void onChangeSkinType(int i) {
        aj.e(this, d.C0095d.common_color_10255, i);
        this.cso.dE(i);
        aj.b(this.csp, d.f.emotion_delete, i);
        aj.e(this.csp, d.C0095d.common_color_10255, i);
        aj.b(this.csq, d.f.icon_sett_s, i);
        aj.e(this.csq, d.C0095d.common_color_10255, i);
        aj.e(this.csr, d.C0095d.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.csp.setVisibility(0);
        } else {
            this.csp.setVisibility(8);
        }
    }

    public void m(int i, boolean z) {
        this.cso.m(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.cso.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(i iVar) {
        this.IS = iVar;
        this.cso.setEditorTools(this.IS);
    }
}
