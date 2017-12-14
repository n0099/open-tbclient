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
    private i IR;
    private EmotionTabHorizonScrollView csk;
    private ImageView csl;
    private ImageView csm;
    private View csn;

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
        this.csk = (EmotionTabHorizonScrollView) findViewById(d.g.face_tab_scroll_view);
        this.csl = (ImageView) findViewById(d.g.face_tab_delete);
        this.csm = (ImageView) findViewById(d.g.face_tab_setting);
        this.csn = findViewById(d.g.vertical_div_line);
        this.csl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.IR != null) {
                    EmotionTabWidgetView.this.IR.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.csm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.csm.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.csk != null) {
            this.csk.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.csk.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.csk.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.csk.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.csk.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.csk.reset();
    }

    public void onChangeSkinType(int i) {
        aj.e(this, d.C0096d.common_color_10255, i);
        this.csk.dE(i);
        aj.b(this.csl, d.f.emotion_delete, i);
        aj.e(this.csl, d.C0096d.common_color_10255, i);
        aj.b(this.csm, d.f.icon_sett_s, i);
        aj.e(this.csm, d.C0096d.common_color_10255, i);
        aj.e(this.csn, d.C0096d.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.csl.setVisibility(0);
        } else {
            this.csl.setVisibility(8);
        }
    }

    public void m(int i, boolean z) {
        this.csk.m(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.csk.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(i iVar) {
        this.IR = iVar;
        this.csk.setEditorTools(this.IR);
    }
}
