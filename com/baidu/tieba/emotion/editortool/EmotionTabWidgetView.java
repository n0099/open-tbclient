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
/* loaded from: classes2.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private EditorTools CJ;
    private EmotionTabHorizonScrollView eYB;
    private ImageView eYC;
    private ImageView eYD;
    private View eYE;

    /* loaded from: classes2.dex */
    public interface a {
        void jV(int i);
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
        this.eYB = (EmotionTabHorizonScrollView) findViewById(R.id.face_tab_scroll_view);
        this.eYC = (ImageView) findViewById(R.id.face_tab_delete);
        this.eYD = (ImageView) findViewById(R.id.face_tab_setting);
        this.eYE = findViewById(R.id.vertical_div_line);
        this.eYC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.CJ != null) {
                    EmotionTabWidgetView.this.CJ.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.eYD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.eYD.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.eYB != null) {
            this.eYB.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.eYB.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.eYB.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.eYB.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.eYB.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.eYB.reset();
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this, R.color.common_color_10255, i);
        this.eYB.onChangeSkin(i);
        am.setImageResource(this.eYC, R.drawable.emotion_delete, i);
        am.setBackgroundColor(this.eYC, R.color.common_color_10255, i);
        am.setImageResource(this.eYD, R.drawable.icon_sett_s, i);
        am.setBackgroundColor(this.eYD, R.color.common_color_10255, i);
        am.setBackgroundColor(this.eYE, R.color.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.eYC.setVisibility(0);
        } else {
            this.eYC.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.eYB.setTabWidgetVisibility(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.eYB.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.CJ = editorTools;
        this.eYB.setEditorTools(this.CJ);
    }
}
