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
    private i axQ;
    private EmotionTabHorizonScrollView dlJ;
    private ImageView dlK;
    private ImageView dlL;
    private View dlM;

    /* loaded from: classes.dex */
    public interface a {
        void hV(int i);
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
        this.dlJ = (EmotionTabHorizonScrollView) findViewById(d.g.face_tab_scroll_view);
        this.dlK = (ImageView) findViewById(d.g.face_tab_delete);
        this.dlL = (ImageView) findViewById(d.g.face_tab_setting);
        this.dlM = findViewById(d.g.vertical_div_line);
        this.dlK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.axQ != null) {
                    EmotionTabWidgetView.this.axQ.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.dlL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.dlL.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.dlJ != null) {
            this.dlJ.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.dlJ.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.dlJ.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.dlJ.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.dlJ.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.dlJ.reset();
    }

    public void onChangeSkinType(int i) {
        aj.g(this, d.C0108d.common_color_10255, i);
        this.dlJ.gz(i);
        aj.b(this.dlK, d.f.emotion_delete, i);
        aj.g(this.dlK, d.C0108d.common_color_10255, i);
        aj.b(this.dlL, d.f.icon_sett_s, i);
        aj.g(this.dlL, d.C0108d.common_color_10255, i);
        aj.g(this.dlM, d.C0108d.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.dlK.setVisibility(0);
        } else {
            this.dlK.setVisibility(8);
        }
    }

    public void y(int i, boolean z) {
        this.dlJ.y(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.dlJ.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(i iVar) {
        this.axQ = iVar;
        this.dlJ.setEditorTools(this.axQ);
    }
}
