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
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private EditorTools SY;
    private EmotionTabHorizonScrollView dft;
    private ImageView dfu;
    private ImageView dfv;
    private View dfw;

    /* loaded from: classes5.dex */
    public interface a {
        void ft(int i);
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
        LayoutInflater.from(context).inflate(e.h.emotion_tab_widget, (ViewGroup) this, true);
        this.dft = (EmotionTabHorizonScrollView) findViewById(e.g.face_tab_scroll_view);
        this.dfu = (ImageView) findViewById(e.g.face_tab_delete);
        this.dfv = (ImageView) findViewById(e.g.face_tab_setting);
        this.dfw = findViewById(e.g.vertical_div_line);
        this.dfu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.SY != null) {
                    EmotionTabWidgetView.this.SY.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.dfv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.dfv.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.dft != null) {
            this.dft.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.dft.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.dft.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.dft.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.dft.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.dft.reset();
    }

    public void onChangeSkinType(int i) {
        al.e(this, e.d.common_color_10255, i);
        this.dft.ea(i);
        al.b(this.dfu, e.f.emotion_delete, i);
        al.e(this.dfu, e.d.common_color_10255, i);
        al.b(this.dfv, e.f.icon_sett_s, i);
        al.e(this.dfv, e.d.common_color_10255, i);
        al.e(this.dfw, e.d.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.dfu.setVisibility(0);
        } else {
            this.dfu.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.dft.setTabWidgetVisibility(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.dft.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.SY = editorTools;
        this.dft.setEditorTools(this.SY);
    }
}
