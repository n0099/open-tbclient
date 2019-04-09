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
    private EditorTools VO;
    private EmotionTabHorizonScrollView eAp;
    private ImageView eAq;
    private ImageView eAr;
    private View eAs;

    /* loaded from: classes2.dex */
    public interface a {
        void jG(int i);
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
        this.eAp = (EmotionTabHorizonScrollView) findViewById(d.g.face_tab_scroll_view);
        this.eAq = (ImageView) findViewById(d.g.face_tab_delete);
        this.eAr = (ImageView) findViewById(d.g.face_tab_setting);
        this.eAs = findViewById(d.g.vertical_div_line);
        this.eAq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.VO != null) {
                    EmotionTabWidgetView.this.VO.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.eAr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.eAr.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.eAp != null) {
            this.eAp.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.eAp.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.eAp.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.eAp.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.eAp.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.eAp.reset();
    }

    public void onChangeSkinType(int i) {
        al.f(this, d.C0277d.common_color_10255, i);
        this.eAp.ii(i);
        al.b(this.eAq, d.f.emotion_delete, i);
        al.f(this.eAq, d.C0277d.common_color_10255, i);
        al.b(this.eAr, d.f.icon_sett_s, i);
        al.f(this.eAr, d.C0277d.common_color_10255, i);
        al.f(this.eAs, d.C0277d.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.eAq.setVisibility(0);
        } else {
            this.eAq.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.eAp.setTabWidgetVisibility(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.eAp.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.VO = editorTools;
        this.eAp.setEditorTools(this.VO);
    }
}
