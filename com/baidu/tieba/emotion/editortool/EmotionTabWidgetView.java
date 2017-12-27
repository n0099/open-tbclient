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
    private i axO;
    private EmotionTabHorizonScrollView dgM;
    private ImageView dgN;
    private ImageView dgO;
    private View dgP;

    /* loaded from: classes.dex */
    public interface a {
        void hZ(int i);
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
        this.dgM = (EmotionTabHorizonScrollView) findViewById(d.g.face_tab_scroll_view);
        this.dgN = (ImageView) findViewById(d.g.face_tab_delete);
        this.dgO = (ImageView) findViewById(d.g.face_tab_setting);
        this.dgP = findViewById(d.g.vertical_div_line);
        this.dgN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.axO != null) {
                    EmotionTabWidgetView.this.axO.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.dgO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.dgO.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.dgM != null) {
            this.dgM.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.dgM.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.dgM.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.dgM.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.dgM.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.dgM.reset();
    }

    public void onChangeSkinType(int i) {
        aj.g(this, d.C0108d.common_color_10255, i);
        this.dgM.gC(i);
        aj.b(this.dgN, d.f.emotion_delete, i);
        aj.g(this.dgN, d.C0108d.common_color_10255, i);
        aj.b(this.dgO, d.f.icon_sett_s, i);
        aj.g(this.dgO, d.C0108d.common_color_10255, i);
        aj.g(this.dgP, d.C0108d.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.dgN.setVisibility(0);
        } else {
            this.dgN.setVisibility(8);
        }
    }

    public void y(int i, boolean z) {
        this.dgM.y(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.dgM.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(i iVar) {
        this.axO = iVar;
        this.dgM.setEditorTools(this.axO);
    }
}
