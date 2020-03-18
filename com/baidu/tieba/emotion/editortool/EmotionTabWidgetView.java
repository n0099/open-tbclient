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
    private EmotionTabHorizonScrollView fTL;
    private ImageView fTM;
    private ImageView fTN;
    private View fTO;

    /* loaded from: classes6.dex */
    public interface a {
        void mC(int i);
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
        this.fTL = (EmotionTabHorizonScrollView) findViewById(R.id.face_tab_scroll_view);
        this.fTM = (ImageView) findViewById(R.id.face_tab_delete);
        this.fTN = (ImageView) findViewById(R.id.face_tab_setting);
        this.fTO = findViewById(R.id.vertical_div_line);
        this.fTM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.FO != null) {
                    EmotionTabWidgetView.this.FO.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.fTN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.fTN.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.fTL != null) {
            this.fTL.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.fTL.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.fTL.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.fTL.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.fTL.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.fTL.reset();
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this, R.color.common_color_10255, i);
        this.fTL.onChangeSkin(i);
        am.setImageResource(this.fTM, R.drawable.emotion_delete, i);
        am.setBackgroundColor(this.fTM, R.color.common_color_10255, i);
        am.setImageResource(this.fTN, R.drawable.icon_sett_s, i);
        am.setBackgroundColor(this.fTN, R.color.common_color_10255, i);
        am.setBackgroundColor(this.fTO, R.color.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.fTM.setVisibility(0);
        } else {
            this.fTM.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.fTL.setTabWidgetVisibility(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.fTL.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.FO = editorTools;
        this.fTL.setEditorTools(this.FO);
    }
}
