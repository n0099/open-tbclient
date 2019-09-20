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
    private EditorTools TT;
    private EmotionTabHorizonScrollView eWG;
    private ImageView eWH;
    private ImageView eWI;
    private View eWJ;

    /* loaded from: classes2.dex */
    public interface a {
        void kE(int i);
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
        this.eWG = (EmotionTabHorizonScrollView) findViewById(R.id.face_tab_scroll_view);
        this.eWH = (ImageView) findViewById(R.id.face_tab_delete);
        this.eWI = (ImageView) findViewById(R.id.face_tab_setting);
        this.eWJ = findViewById(R.id.vertical_div_line);
        this.eWH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.TT != null) {
                    EmotionTabWidgetView.this.TT.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.eWI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.eWI.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.eWG != null) {
            this.eWG.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.eWG.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.eWG.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.eWG.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.eWG.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.eWG.reset();
    }

    public void onChangeSkinType(int i) {
        am.h(this, R.color.common_color_10255, i);
        this.eWG.jg(i);
        am.b(this.eWH, (int) R.drawable.emotion_delete, i);
        am.h(this.eWH, R.color.common_color_10255, i);
        am.b(this.eWI, (int) R.drawable.icon_sett_s, i);
        am.h(this.eWI, R.color.common_color_10255, i);
        am.h(this.eWJ, R.color.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.eWH.setVisibility(0);
        } else {
            this.eWH.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.eWG.setTabWidgetVisibility(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.eWG.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.TT = editorTools;
        this.eWG.setEditorTools(this.TT);
    }
}
