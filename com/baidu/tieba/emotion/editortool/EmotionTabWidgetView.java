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
    private EditorTools aay;
    private EmotionTabHorizonScrollView hsO;
    private ImageView hsP;
    private ImageView hsQ;
    private View hsR;

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
        this.hsO = (EmotionTabHorizonScrollView) findViewById(R.id.face_tab_scroll_view);
        this.hsP = (ImageView) findViewById(R.id.face_tab_delete);
        this.hsQ = (ImageView) findViewById(R.id.face_tab_setting);
        this.hsR = findViewById(R.id.vertical_div_line);
        this.hsP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.aay != null) {
                    EmotionTabWidgetView.this.aay.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.hsQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.hsQ.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.hsO != null) {
            this.hsO.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.hsO.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.hsO.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.hsO.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.hsO.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.hsO.reset();
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this, R.color.common_color_10255, i);
        this.hsO.onChangeSkin(i);
        ap.setImageResource(this.hsP, R.drawable.emotion_delete, i);
        ap.setBackgroundColor(this.hsP, R.color.common_color_10255, i);
        ap.setImageResource(this.hsQ, R.drawable.icon_sett_s, i);
        ap.setBackgroundColor(this.hsQ, R.color.common_color_10255, i);
        ap.setBackgroundColor(this.hsR, R.color.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.hsP.setVisibility(0);
        } else {
            this.hsP.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.hsO.setTabWidgetVisibility(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.hsO.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.aay = editorTools;
        this.hsO.setEditorTools(this.aay);
    }
}
