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
    private EmotionTabHorizonScrollView cju;
    private ImageView cjv;
    private ImageView cjw;
    private View cjx;

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
        LayoutInflater.from(context).inflate(d.h.emotion_tab_widget, (ViewGroup) this, true);
        this.cju = (EmotionTabHorizonScrollView) findViewById(d.g.face_tab_scroll_view);
        this.cjv = (ImageView) findViewById(d.g.face_tab_delete);
        this.cjw = (ImageView) findViewById(d.g.face_tab_setting);
        this.cjx = findViewById(d.g.vertical_div_line);
        this.cjv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.Jb != null) {
                    EmotionTabWidgetView.this.Jb.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.cjw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.cjw.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.cju != null) {
            this.cju.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.cju.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.cju.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.cju.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.cju.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.cju.reset();
    }

    public void onChangeSkinType(int i) {
        aj.e(this, d.C0080d.common_color_10255, i);
        this.cju.dD(i);
        aj.b(this.cjv, d.f.emotion_delete, i);
        aj.e(this.cjv, d.C0080d.common_color_10255, i);
        aj.b(this.cjw, d.f.icon_sett_s, i);
        aj.e(this.cjw, d.C0080d.common_color_10255, i);
        aj.e(this.cjx, d.C0080d.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.cjv.setVisibility(0);
        } else {
            this.cjv.setVisibility(8);
        }
    }

    public void m(int i, boolean z) {
        this.cju.m(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.cju.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(i iVar) {
        this.Jb = iVar;
        this.cju.setEditorTools(this.Jb);
    }
}
