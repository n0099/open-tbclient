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
    private EditorTools aaS;
    private ImageView hAa;
    private ImageView hAb;
    private View hAc;
    private EmotionTabHorizonScrollView hzZ;

    /* loaded from: classes13.dex */
    public interface a {
        void qF(int i);
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
        this.hzZ = (EmotionTabHorizonScrollView) findViewById(R.id.face_tab_scroll_view);
        this.hAa = (ImageView) findViewById(R.id.face_tab_delete);
        this.hAb = (ImageView) findViewById(R.id.face_tab_setting);
        this.hAc = findViewById(R.id.vertical_div_line);
        this.hAa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.aaS != null) {
                    EmotionTabWidgetView.this.aaS.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.hAb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.hAb.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.hzZ != null) {
            this.hzZ.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.hzZ.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.hzZ.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.hzZ.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.hzZ.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.hzZ.reset();
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this, R.color.common_color_10255, i);
        this.hzZ.onChangeSkin(i);
        ap.setImageResource(this.hAa, R.drawable.emotion_delete, i);
        ap.setBackgroundColor(this.hAa, R.color.common_color_10255, i);
        ap.setImageResource(this.hAb, R.drawable.icon_sett_s, i);
        ap.setBackgroundColor(this.hAb, R.color.common_color_10255, i);
        ap.setBackgroundColor(this.hAc, R.color.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.hAa.setVisibility(0);
        } else {
            this.hAa.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.hzZ.setTabWidgetVisibility(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.hzZ.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.aaS = editorTools;
        this.hzZ.setEditorTools(this.aaS);
    }
}
