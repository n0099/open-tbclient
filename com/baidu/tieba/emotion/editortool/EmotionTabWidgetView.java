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
/* loaded from: classes8.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private EditorTools acR;
    private EmotionTabHorizonScrollView iGF;
    private ImageView iGG;
    private ImageView iGH;
    private View iGI;

    /* loaded from: classes8.dex */
    public interface a {
        void ri(int i);
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
        this.iGF = (EmotionTabHorizonScrollView) findViewById(R.id.face_tab_scroll_view);
        this.iGG = (ImageView) findViewById(R.id.face_tab_delete);
        this.iGH = (ImageView) findViewById(R.id.face_tab_setting);
        this.iGI = findViewById(R.id.vertical_div_line);
        this.iGG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.acR != null) {
                    EmotionTabWidgetView.this.acR.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.iGH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.iGH.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.iGF != null) {
            this.iGF.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.iGF.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.iGF.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.iGF.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.iGF.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.iGF.reset();
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this, R.color.common_color_10255, i);
        this.iGF.onChangeSkin(i);
        ap.setImageResource(this.iGG, R.drawable.emotion_delete, i);
        ap.setBackgroundColor(this.iGG, R.color.common_color_10255, i);
        ap.setImageResource(this.iGH, R.drawable.icon_sett_s, i);
        ap.setBackgroundColor(this.iGH, R.color.common_color_10255, i);
        ap.setBackgroundColor(this.iGI, R.color.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.iGG.setVisibility(0);
        } else {
            this.iGG.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.iGF.setTabWidgetVisibility(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.iGF.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.acR = editorTools;
        this.iGF.setEditorTools(this.acR);
    }
}
