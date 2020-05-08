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
/* loaded from: classes6.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private EditorTools Zd;
    private ImageView gyA;
    private ImageView gyB;
    private View gyC;
    private EmotionTabHorizonScrollView gyz;

    /* loaded from: classes6.dex */
    public interface a {
        void mN(int i);
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
        this.gyz = (EmotionTabHorizonScrollView) findViewById(R.id.face_tab_scroll_view);
        this.gyA = (ImageView) findViewById(R.id.face_tab_delete);
        this.gyB = (ImageView) findViewById(R.id.face_tab_setting);
        this.gyC = findViewById(R.id.vertical_div_line);
        this.gyA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.Zd != null) {
                    EmotionTabWidgetView.this.Zd.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.gyB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.gyB.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.gyz != null) {
            this.gyz.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.gyz.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.gyz.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.gyz.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.gyz.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.gyz.reset();
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this, R.color.common_color_10255, i);
        this.gyz.onChangeSkin(i);
        am.setImageResource(this.gyA, R.drawable.emotion_delete, i);
        am.setBackgroundColor(this.gyA, R.color.common_color_10255, i);
        am.setImageResource(this.gyB, R.drawable.icon_sett_s, i);
        am.setBackgroundColor(this.gyB, R.color.common_color_10255, i);
        am.setBackgroundColor(this.gyC, R.color.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.gyA.setVisibility(0);
        } else {
            this.gyA.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.gyz.setTabWidgetVisibility(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.gyz.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.Zd = editorTools;
        this.gyz.setEditorTools(this.Zd);
    }
}
