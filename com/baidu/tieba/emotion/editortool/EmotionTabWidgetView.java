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
    private i Jp;
    private EmotionTabHorizonScrollView caV;
    private ImageView caW;
    private ImageView caX;
    private View caY;
    private boolean caZ;

    /* loaded from: classes.dex */
    public interface a {
        void eT(int i);
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
        this.caV = (EmotionTabHorizonScrollView) findViewById(d.h.face_tab_scroll_view);
        this.caW = (ImageView) findViewById(d.h.face_tab_delete);
        this.caX = (ImageView) findViewById(d.h.face_tab_setting);
        this.caY = findViewById(d.h.vertical_div_line);
        this.caW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.Jp != null) {
                    EmotionTabWidgetView.this.Jp.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.caX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.caX.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.caV != null) {
            this.caV.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.caV.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.caV.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.caV.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.caV.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.caV.reset();
    }

    public void setIsInChat(boolean z) {
        this.caZ = z;
        if (this.caV != null) {
            this.caV.setIsInChat(z);
        }
    }

    public void onChangeSkinType(int i) {
        aj.e(this, d.e.common_color_10255, i);
        this.caV.du(i);
        aj.b(this.caW, d.g.emotion_delete, i);
        aj.e(this.caW, d.e.common_color_10255, i);
        aj.b(this.caX, d.g.icon_sett_s, i);
        aj.e(this.caX, d.e.common_color_10255, i);
        aj.e(this.caY, d.e.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.caW.setVisibility(0);
        } else {
            this.caW.setVisibility(8);
        }
    }

    public void m(int i, boolean z) {
        this.caV.m(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.caV.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(i iVar) {
        this.Jp = iVar;
        this.caV.setEditorTools(this.Jp);
    }
}
