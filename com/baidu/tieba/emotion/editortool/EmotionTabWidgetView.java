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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes13.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private EditorTools aaA;
    private EmotionTabHorizonScrollView hsU;
    private ImageView hsV;
    private ImageView hsW;
    private View hsX;

    /* loaded from: classes13.dex */
    public interface a {
        void qo(int i);
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
        this.hsU = (EmotionTabHorizonScrollView) findViewById(R.id.face_tab_scroll_view);
        this.hsV = (ImageView) findViewById(R.id.face_tab_delete);
        this.hsW = (ImageView) findViewById(R.id.face_tab_setting);
        this.hsX = findViewById(R.id.vertical_div_line);
        this.hsV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.aaA != null) {
                    EmotionTabWidgetView.this.aaA.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.hsW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.hsW.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.hsU != null) {
            this.hsU.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.hsU.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.hsU.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.hsU.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.hsU.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.hsU.reset();
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this, R.color.common_color_10255, i);
        this.hsU.onChangeSkin(i);
        ap.setImageResource(this.hsV, R.drawable.emotion_delete, i);
        ap.setBackgroundColor(this.hsV, R.color.common_color_10255, i);
        ap.setImageResource(this.hsW, R.drawable.icon_sett_s, i);
        ap.setBackgroundColor(this.hsW, R.color.common_color_10255, i);
        ap.setBackgroundColor(this.hsX, R.color.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.hsV.setVisibility(0);
        } else {
            this.hsV.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.hsU.setTabWidgetVisibility(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.hsU.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.aaA = editorTools;
        this.hsU.setEditorTools(this.aaA);
    }
}
