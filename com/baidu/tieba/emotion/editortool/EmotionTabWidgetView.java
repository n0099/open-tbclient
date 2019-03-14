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
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private EditorTools VN;
    private EmotionTabHorizonScrollView eAD;
    private ImageView eAE;
    private ImageView eAF;
    private View eAG;

    /* loaded from: classes2.dex */
    public interface a {
        void jH(int i);
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
        this.eAD = (EmotionTabHorizonScrollView) findViewById(d.g.face_tab_scroll_view);
        this.eAE = (ImageView) findViewById(d.g.face_tab_delete);
        this.eAF = (ImageView) findViewById(d.g.face_tab_setting);
        this.eAG = findViewById(d.g.vertical_div_line);
        this.eAE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.VN != null) {
                    EmotionTabWidgetView.this.VN.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.eAF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.eAF.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.eAD != null) {
            this.eAD.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.eAD.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.eAD.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.eAD.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.eAD.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.eAD.reset();
    }

    public void onChangeSkinType(int i) {
        al.f(this, d.C0277d.common_color_10255, i);
        this.eAD.ij(i);
        al.b(this.eAE, d.f.emotion_delete, i);
        al.f(this.eAE, d.C0277d.common_color_10255, i);
        al.b(this.eAF, d.f.icon_sett_s, i);
        al.f(this.eAF, d.C0277d.common_color_10255, i);
        al.f(this.eAG, d.C0277d.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.eAE.setVisibility(0);
        } else {
            this.eAE.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.eAD.setTabWidgetVisibility(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.eAD.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.VN = editorTools;
        this.eAD.setEditorTools(this.VN);
    }
}
