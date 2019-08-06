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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private EditorTools TU;
    private EmotionTabHorizonScrollView eVa;
    private ImageView eVb;
    private ImageView eVc;
    private View eVd;

    /* loaded from: classes2.dex */
    public interface a {
        void kB(int i);
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
        LayoutInflater.from(context).inflate(R.layout.emotion_tab_widget, (ViewGroup) this, true);
        this.eVa = (EmotionTabHorizonScrollView) findViewById(R.id.face_tab_scroll_view);
        this.eVb = (ImageView) findViewById(R.id.face_tab_delete);
        this.eVc = (ImageView) findViewById(R.id.face_tab_setting);
        this.eVd = findViewById(R.id.vertical_div_line);
        this.eVb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.TU != null) {
                    EmotionTabWidgetView.this.TU.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.eVc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.eVc.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.eVa != null) {
            this.eVa.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.eVa.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.eVa.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.eVa.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.eVa.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.eVa.reset();
    }

    public void onChangeSkinType(int i) {
        am.h(this, R.color.common_color_10255, i);
        this.eVa.jd(i);
        am.b(this.eVb, (int) R.drawable.emotion_delete, i);
        am.h(this.eVb, R.color.common_color_10255, i);
        am.b(this.eVc, (int) R.drawable.icon_sett_s, i);
        am.h(this.eVc, R.color.common_color_10255, i);
        am.h(this.eVd, R.color.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.eVb.setVisibility(0);
        } else {
            this.eVb.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.eVa.setTabWidgetVisibility(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.eVa.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.TU = editorTools;
        this.eVa.setEditorTools(this.TU);
    }
}
