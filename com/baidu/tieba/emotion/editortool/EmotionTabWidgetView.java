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
    private i axN;
    private EmotionTabHorizonScrollView dlo;
    private ImageView dlp;
    private ImageView dlq;
    private View dlr;

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
        this.dlo = (EmotionTabHorizonScrollView) findViewById(d.g.face_tab_scroll_view);
        this.dlp = (ImageView) findViewById(d.g.face_tab_delete);
        this.dlq = (ImageView) findViewById(d.g.face_tab_setting);
        this.dlr = findViewById(d.g.vertical_div_line);
        this.dlp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.axN != null) {
                    EmotionTabWidgetView.this.axN.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.dlq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.dlq.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.dlo != null) {
            this.dlo.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.dlo.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.dlo.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.dlo.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.dlo.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.dlo.reset();
    }

    public void onChangeSkinType(int i) {
        aj.g(this, d.C0107d.common_color_10255, i);
        this.dlo.gz(i);
        aj.b(this.dlp, d.f.emotion_delete, i);
        aj.g(this.dlp, d.C0107d.common_color_10255, i);
        aj.b(this.dlq, d.f.icon_sett_s, i);
        aj.g(this.dlq, d.C0107d.common_color_10255, i);
        aj.g(this.dlr, d.C0107d.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.dlp.setVisibility(0);
        } else {
            this.dlp.setVisibility(8);
        }
    }

    public void y(int i, boolean z) {
        this.dlo.y(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.dlo.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(i iVar) {
        this.axN = iVar;
        this.dlo.setEditorTools(this.axN);
    }
}
