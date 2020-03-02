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
    private EditorTools FO;
    private EmotionTabHorizonScrollView fSP;
    private ImageView fSQ;
    private ImageView fSR;
    private View fSS;

    /* loaded from: classes6.dex */
    public interface a {
        void mA(int i);
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
        this.fSP = (EmotionTabHorizonScrollView) findViewById(R.id.face_tab_scroll_view);
        this.fSQ = (ImageView) findViewById(R.id.face_tab_delete);
        this.fSR = (ImageView) findViewById(R.id.face_tab_setting);
        this.fSS = findViewById(R.id.vertical_div_line);
        this.fSQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.FO != null) {
                    EmotionTabWidgetView.this.FO.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.fSR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.fSR.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.fSP != null) {
            this.fSP.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.fSP.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.fSP.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.fSP.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.fSP.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.fSP.reset();
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this, R.color.common_color_10255, i);
        this.fSP.onChangeSkin(i);
        am.setImageResource(this.fSQ, R.drawable.emotion_delete, i);
        am.setBackgroundColor(this.fSQ, R.color.common_color_10255, i);
        am.setImageResource(this.fSR, R.drawable.icon_sett_s, i);
        am.setBackgroundColor(this.fSR, R.color.common_color_10255, i);
        am.setBackgroundColor(this.fSS, R.color.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.fSQ.setVisibility(0);
        } else {
            this.fSQ.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.fSP.setTabWidgetVisibility(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.fSP.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.FO = editorTools;
        this.fSP.setEditorTools(this.FO);
    }
}
