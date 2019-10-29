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
    private EditorTools Dl;
    private EmotionTabHorizonScrollView eZs;
    private ImageView eZt;
    private ImageView eZu;
    private View eZv;

    /* loaded from: classes2.dex */
    public interface a {
        void jW(int i);
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
        this.eZs = (EmotionTabHorizonScrollView) findViewById(R.id.face_tab_scroll_view);
        this.eZt = (ImageView) findViewById(R.id.face_tab_delete);
        this.eZu = (ImageView) findViewById(R.id.face_tab_setting);
        this.eZv = findViewById(R.id.vertical_div_line);
        this.eZt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.Dl != null) {
                    EmotionTabWidgetView.this.Dl.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.eZu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.eZu.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.eZs != null) {
            this.eZs.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.eZs.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.eZs.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.eZs.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.eZs.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.eZs.reset();
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this, R.color.common_color_10255, i);
        this.eZs.onChangeSkin(i);
        am.setImageResource(this.eZt, R.drawable.emotion_delete, i);
        am.setBackgroundColor(this.eZt, R.color.common_color_10255, i);
        am.setImageResource(this.eZu, R.drawable.icon_sett_s, i);
        am.setBackgroundColor(this.eZu, R.color.common_color_10255, i);
        am.setBackgroundColor(this.eZv, R.color.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.eZt.setVisibility(0);
        } else {
            this.eZt.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.eZs.setTabWidgetVisibility(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.eZs.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.Dl = editorTools;
        this.eZs.setEditorTools(this.Dl);
    }
}
