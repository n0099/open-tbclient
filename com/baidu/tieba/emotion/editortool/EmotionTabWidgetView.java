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
    private EditorTools abj;
    private EmotionTabHorizonScrollView hOU;
    private ImageView hOV;
    private ImageView hOW;
    private View hOX;

    /* loaded from: classes13.dex */
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
        this.hOU = (EmotionTabHorizonScrollView) findViewById(R.id.face_tab_scroll_view);
        this.hOV = (ImageView) findViewById(R.id.face_tab_delete);
        this.hOW = (ImageView) findViewById(R.id.face_tab_setting);
        this.hOX = findViewById(R.id.vertical_div_line);
        this.hOV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.abj != null) {
                    EmotionTabWidgetView.this.abj.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.hOW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.hOW.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.hOU != null) {
            this.hOU.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.hOU.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.hOU.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.hOU.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.hOU.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.hOU.reset();
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this, R.color.common_color_10255, i);
        this.hOU.onChangeSkin(i);
        ap.setImageResource(this.hOV, R.drawable.emotion_delete, i);
        ap.setBackgroundColor(this.hOV, R.color.common_color_10255, i);
        ap.setImageResource(this.hOW, R.drawable.icon_sett_s, i);
        ap.setBackgroundColor(this.hOW, R.color.common_color_10255, i);
        ap.setBackgroundColor(this.hOX, R.color.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.hOV.setVisibility(0);
        } else {
            this.hOV.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.hOU.setTabWidgetVisibility(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.hOU.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.abj = editorTools;
        this.hOU.setEditorTools(this.abj);
    }
}
