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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.UserCollectManageActivityConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private EditorTools Fv;
    private EmotionTabHorizonScrollView fQs;
    private ImageView fQt;
    private ImageView fQu;
    private View fQv;

    /* loaded from: classes5.dex */
    public interface a {
        void mi(int i);
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
        this.fQs = (EmotionTabHorizonScrollView) findViewById(R.id.face_tab_scroll_view);
        this.fQt = (ImageView) findViewById(R.id.face_tab_delete);
        this.fQu = (ImageView) findViewById(R.id.face_tab_setting);
        this.fQv = findViewById(R.id.vertical_div_line);
        this.fQt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.Fv != null) {
                    EmotionTabWidgetView.this.Fv.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.fQu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.fQu.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.fQs != null) {
            this.fQs.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.fQs.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.fQs.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.fQs.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.fQs.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.fQs.reset();
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this, R.color.common_color_10255, i);
        this.fQs.onChangeSkin(i);
        am.setImageResource(this.fQt, R.drawable.emotion_delete, i);
        am.setBackgroundColor(this.fQt, R.color.common_color_10255, i);
        am.setImageResource(this.fQu, R.drawable.icon_sett_s, i);
        am.setBackgroundColor(this.fQu, R.color.common_color_10255, i);
        am.setBackgroundColor(this.fQv, R.color.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.fQt.setVisibility(0);
        } else {
            this.fQt.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.fQs.setTabWidgetVisibility(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.fQs.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.Fv = editorTools;
        this.fQs.setEditorTools(this.Fv);
    }
}
