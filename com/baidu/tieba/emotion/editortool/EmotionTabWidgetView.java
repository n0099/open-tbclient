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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.editortools.i;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private i Lr;
    private EmotionTabHorizonScrollView bXm;
    private ImageView bXn;
    private ImageView bXo;
    private View bXp;
    private boolean bXq;

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
        this.bXm = (EmotionTabHorizonScrollView) findViewById(d.h.face_tab_scroll_view);
        this.bXn = (ImageView) findViewById(d.h.face_tab_delete);
        this.bXo = (ImageView) findViewById(d.h.face_tab_setting);
        this.bXp = findViewById(d.h.vertical_div_line);
        this.bXn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.Lr != null) {
                    EmotionTabWidgetView.this.Lr.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.bXo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.bXo.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.bXm != null) {
            this.bXm.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.bXm.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.bXm.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.bXm.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.bXm.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.bXm.reset();
    }

    public void setIsInChat(boolean z) {
        this.bXq = z;
        if (this.bXm != null) {
            this.bXm.setIsInChat(z);
        }
    }

    public void onChangeSkinType(int i) {
        ai.e(this, d.e.common_color_10255, i);
        this.bXm.dt(i);
        ai.c(this.bXn, d.g.emotion_delete, i);
        ai.e(this.bXn, d.e.common_color_10255, i);
        ai.c(this.bXo, d.g.icon_sett_s, i);
        ai.e(this.bXo, d.e.common_color_10255, i);
        ai.e(this.bXp, d.e.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.bXn.setVisibility(0);
        } else {
            this.bXn.setVisibility(8);
        }
    }

    public void n(int i, boolean z) {
        this.bXm.n(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.bXm.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(i iVar) {
        this.Lr = iVar;
        this.bXm.setEditorTools(this.Lr);
    }
}
