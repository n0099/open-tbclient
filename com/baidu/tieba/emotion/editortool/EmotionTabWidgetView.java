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
    private EmotionTabHorizonScrollView fTc;
    private ImageView fTd;
    private ImageView fTe;
    private View fTf;

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
        this.fTc = (EmotionTabHorizonScrollView) findViewById(R.id.face_tab_scroll_view);
        this.fTd = (ImageView) findViewById(R.id.face_tab_delete);
        this.fTe = (ImageView) findViewById(R.id.face_tab_setting);
        this.fTf = findViewById(R.id.vertical_div_line);
        this.fTd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.FO != null) {
                    EmotionTabWidgetView.this.FO.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.fTe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.fTe.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.fTc != null) {
            this.fTc.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.fTc.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.fTc.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.fTc.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.fTc.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.fTc.reset();
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this, R.color.common_color_10255, i);
        this.fTc.onChangeSkin(i);
        am.setImageResource(this.fTd, R.drawable.emotion_delete, i);
        am.setBackgroundColor(this.fTd, R.color.common_color_10255, i);
        am.setImageResource(this.fTe, R.drawable.icon_sett_s, i);
        am.setBackgroundColor(this.fTe, R.color.common_color_10255, i);
        am.setBackgroundColor(this.fTf, R.color.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.fTd.setVisibility(0);
        } else {
            this.fTd.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.fTc.setTabWidgetVisibility(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.fTc.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.FO = editorTools;
        this.fTc.setEditorTools(this.FO);
    }
}
