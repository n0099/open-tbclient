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
    private i Jb;
    private EmotionTabHorizonScrollView cjh;
    private ImageView cji;
    private ImageView cjj;
    private View cjk;

    /* loaded from: classes.dex */
    public interface a {
        void fd(int i);
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
        this.cjh = (EmotionTabHorizonScrollView) findViewById(d.g.face_tab_scroll_view);
        this.cji = (ImageView) findViewById(d.g.face_tab_delete);
        this.cjj = (ImageView) findViewById(d.g.face_tab_setting);
        this.cjk = findViewById(d.g.vertical_div_line);
        this.cji.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.Jb != null) {
                    EmotionTabWidgetView.this.Jb.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.cjj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.cjj.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.cjh != null) {
            this.cjh.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.cjh.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.cjh.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.cjh.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.cjh.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.cjh.reset();
    }

    public void onChangeSkinType(int i) {
        aj.e(this, d.C0080d.common_color_10255, i);
        this.cjh.dE(i);
        aj.b(this.cji, d.f.emotion_delete, i);
        aj.e(this.cji, d.C0080d.common_color_10255, i);
        aj.b(this.cjj, d.f.icon_sett_s, i);
        aj.e(this.cjj, d.C0080d.common_color_10255, i);
        aj.e(this.cjk, d.C0080d.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.cji.setVisibility(0);
        } else {
            this.cji.setVisibility(8);
        }
    }

    public void l(int i, boolean z) {
        this.cjh.l(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.cjh.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(i iVar) {
        this.Jb = iVar;
        this.cjh.setEditorTools(this.Jb);
    }
}
