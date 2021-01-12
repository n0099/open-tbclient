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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private EditorTools acX;
    private EmotionTabHorizonScrollView iAH;
    private ImageView iAI;
    private ImageView iAJ;
    private View iAK;

    /* loaded from: classes7.dex */
    public interface a {
        void rd(int i);
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
        this.iAH = (EmotionTabHorizonScrollView) findViewById(R.id.face_tab_scroll_view);
        this.iAI = (ImageView) findViewById(R.id.face_tab_delete);
        this.iAJ = (ImageView) findViewById(R.id.face_tab_setting);
        this.iAK = findViewById(R.id.vertical_div_line);
        this.iAI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.acX != null) {
                    EmotionTabWidgetView.this.acX.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.iAJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.iAJ.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.iAH != null) {
            this.iAH.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.iAH.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.iAH.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.iAH.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.iAH.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.iAH.reset();
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this, R.color.common_color_10255, i);
        this.iAH.onChangeSkin(i);
        ao.setImageResource(this.iAI, R.drawable.emotion_delete, i);
        ao.setBackgroundColor(this.iAI, R.color.common_color_10255, i);
        ao.setImageResource(this.iAJ, R.drawable.icon_sett_s, i);
        ao.setBackgroundColor(this.iAJ, R.color.common_color_10255, i);
        ao.setBackgroundColor(this.iAK, R.color.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.iAI.setVisibility(0);
        } else {
            this.iAI.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.iAH.setTabWidgetVisibility(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.iAH.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.acX = editorTools;
        this.iAH.setEditorTools(this.acX);
    }
}
