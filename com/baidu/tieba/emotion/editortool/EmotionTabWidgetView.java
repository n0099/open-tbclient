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
    private i JH;
    private EmotionTabHorizonScrollView cbB;
    private ImageView cbC;
    private ImageView cbD;
    private View cbE;
    private boolean cbF;

    /* loaded from: classes.dex */
    public interface a {
        void fc(int i);
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
        LayoutInflater.from(context).inflate(d.j.emotion_tab_widget, (ViewGroup) this, true);
        this.cbB = (EmotionTabHorizonScrollView) findViewById(d.h.face_tab_scroll_view);
        this.cbC = (ImageView) findViewById(d.h.face_tab_delete);
        this.cbD = (ImageView) findViewById(d.h.face_tab_setting);
        this.cbE = findViewById(d.h.vertical_div_line);
        this.cbC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.JH != null) {
                    EmotionTabWidgetView.this.JH.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.cbD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.cbD.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.cbB != null) {
            this.cbB.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.cbB.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.cbB.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.cbB.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.cbB.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.cbB.reset();
    }

    public void setIsInChat(boolean z) {
        this.cbF = z;
        if (this.cbB != null) {
            this.cbB.setIsInChat(z);
        }
    }

    public void onChangeSkinType(int i) {
        aj.e(this, d.e.common_color_10255, i);
        this.cbB.dD(i);
        aj.b(this.cbC, d.g.emotion_delete, i);
        aj.e(this.cbC, d.e.common_color_10255, i);
        aj.b(this.cbD, d.g.icon_sett_s, i);
        aj.e(this.cbD, d.e.common_color_10255, i);
        aj.e(this.cbE, d.e.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.cbC.setVisibility(0);
        } else {
            this.cbC.setVisibility(8);
        }
    }

    public void k(int i, boolean z) {
        this.cbB.k(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.cbB.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(i iVar) {
        this.JH = iVar;
        this.cbB.setEditorTools(this.JH);
    }
}
