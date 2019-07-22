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
    private EmotionTabHorizonScrollView eUT;
    private ImageView eUU;
    private ImageView eUV;
    private View eUW;

    /* loaded from: classes2.dex */
    public interface a {
        void kA(int i);
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
        this.eUT = (EmotionTabHorizonScrollView) findViewById(R.id.face_tab_scroll_view);
        this.eUU = (ImageView) findViewById(R.id.face_tab_delete);
        this.eUV = (ImageView) findViewById(R.id.face_tab_setting);
        this.eUW = findViewById(R.id.vertical_div_line);
        this.eUU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.TU != null) {
                    EmotionTabWidgetView.this.TU.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.eUV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.eUV.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.eUT != null) {
            this.eUT.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.eUT.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.eUT.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.eUT.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.eUT.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.eUT.reset();
    }

    public void onChangeSkinType(int i) {
        am.h(this, R.color.common_color_10255, i);
        this.eUT.jc(i);
        am.b(this.eUU, (int) R.drawable.emotion_delete, i);
        am.h(this.eUU, R.color.common_color_10255, i);
        am.b(this.eUV, (int) R.drawable.icon_sett_s, i);
        am.h(this.eUV, R.color.common_color_10255, i);
        am.h(this.eUW, R.color.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.eUU.setVisibility(0);
        } else {
            this.eUU.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.eUT.setTabWidgetVisibility(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.eUT.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.TU = editorTools;
        this.eUT.setEditorTools(this.TU);
    }
}
