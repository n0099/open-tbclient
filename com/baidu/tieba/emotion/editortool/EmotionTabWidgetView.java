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
    private EmotionTabHorizonScrollView fSN;
    private ImageView fSO;
    private ImageView fSP;
    private View fSQ;

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
        this.fSN = (EmotionTabHorizonScrollView) findViewById(R.id.face_tab_scroll_view);
        this.fSO = (ImageView) findViewById(R.id.face_tab_delete);
        this.fSP = (ImageView) findViewById(R.id.face_tab_setting);
        this.fSQ = findViewById(R.id.vertical_div_line);
        this.fSO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.FO != null) {
                    EmotionTabWidgetView.this.FO.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.fSP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.fSP.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.fSN != null) {
            this.fSN.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.fSN.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.fSN.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.fSN.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.fSN.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.fSN.reset();
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this, R.color.common_color_10255, i);
        this.fSN.onChangeSkin(i);
        am.setImageResource(this.fSO, R.drawable.emotion_delete, i);
        am.setBackgroundColor(this.fSO, R.color.common_color_10255, i);
        am.setImageResource(this.fSP, R.drawable.icon_sett_s, i);
        am.setBackgroundColor(this.fSP, R.color.common_color_10255, i);
        am.setBackgroundColor(this.fSQ, R.color.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.fSO.setVisibility(0);
        } else {
            this.fSO.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.fSN.setTabWidgetVisibility(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.fSN.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.FO = editorTools;
        this.fSN.setEditorTools(this.FO);
    }
}
