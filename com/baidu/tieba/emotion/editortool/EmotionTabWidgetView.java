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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private EditorTools JO;
    private EmotionTabHorizonScrollView cHC;
    private ImageView cHD;
    private ImageView cHE;
    private View cHF;

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
        LayoutInflater.from(context).inflate(d.i.emotion_tab_widget, (ViewGroup) this, true);
        this.cHC = (EmotionTabHorizonScrollView) findViewById(d.g.face_tab_scroll_view);
        this.cHD = (ImageView) findViewById(d.g.face_tab_delete);
        this.cHE = (ImageView) findViewById(d.g.face_tab_setting);
        this.cHF = findViewById(d.g.vertical_div_line);
        this.cHD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabWidgetView.this.JO != null) {
                    EmotionTabWidgetView.this.JO.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.cHE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.cHE.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.cHC != null) {
            this.cHC.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.cHC.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.cHC.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.cHC.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.cHC.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.cHC.reset();
    }

    public void onChangeSkinType(int i) {
        ak.e(this, d.C0126d.common_color_10255, i);
        this.cHC.dA(i);
        ak.b(this.cHD, d.f.emotion_delete, i);
        ak.e(this.cHD, d.C0126d.common_color_10255, i);
        ak.b(this.cHE, d.f.icon_sett_s, i);
        ak.e(this.cHE, d.C0126d.common_color_10255, i);
        ak.e(this.cHF, d.C0126d.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.cHD.setVisibility(0);
        } else {
            this.cHD.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.cHC.setTabWidgetVisibility(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.cHC.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.JO = editorTools;
        this.cHC.setEditorTools(this.JO);
    }
}
