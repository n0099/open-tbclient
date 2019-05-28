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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private EditorTools TB;
    private EmotionTabHorizonScrollView ePT;
    private ImageView ePU;
    private ImageView ePV;
    private View ePW;

    /* loaded from: classes2.dex */
    public interface a {
        void ku(int i);
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
        this.ePT = (EmotionTabHorizonScrollView) findViewById(R.id.face_tab_scroll_view);
        this.ePU = (ImageView) findViewById(R.id.face_tab_delete);
        this.ePV = (ImageView) findViewById(R.id.face_tab_setting);
        this.ePW = findViewById(R.id.vertical_div_line);
        this.ePU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.TB != null) {
                    EmotionTabWidgetView.this.TB.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.ePV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.ePV.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.ePT != null) {
            this.ePT.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.ePT.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.ePT.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.ePT.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.ePT.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.ePT.reset();
    }

    public void onChangeSkinType(int i) {
        al.h(this, R.color.common_color_10255, i);
        this.ePT.iW(i);
        al.b(this.ePU, (int) R.drawable.emotion_delete, i);
        al.h(this.ePU, R.color.common_color_10255, i);
        al.b(this.ePV, (int) R.drawable.icon_sett_s, i);
        al.h(this.ePV, R.color.common_color_10255, i);
        al.h(this.ePW, R.color.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.ePU.setVisibility(0);
        } else {
            this.ePU.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.ePT.setTabWidgetVisibility(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.ePT.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.TB = editorTools;
        this.ePT.setEditorTools(this.TB);
    }
}
