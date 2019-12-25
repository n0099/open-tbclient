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
/* loaded from: classes4.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private EditorTools Fq;
    private EmotionTabHorizonScrollView fNj;
    private ImageView fNk;
    private ImageView fNl;
    private View fNm;

    /* loaded from: classes4.dex */
    public interface a {
        void mi(int i);
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
        this.fNj = (EmotionTabHorizonScrollView) findViewById(R.id.face_tab_scroll_view);
        this.fNk = (ImageView) findViewById(R.id.face_tab_delete);
        this.fNl = (ImageView) findViewById(R.id.face_tab_setting);
        this.fNm = findViewById(R.id.vertical_div_line);
        this.fNk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.Fq != null) {
                    EmotionTabWidgetView.this.Fq.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.fNl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.fNl.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.fNj != null) {
            this.fNj.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.fNj.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.fNj.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.fNj.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.fNj.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.fNj.reset();
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this, R.color.common_color_10255, i);
        this.fNj.onChangeSkin(i);
        am.setImageResource(this.fNk, R.drawable.emotion_delete, i);
        am.setBackgroundColor(this.fNk, R.color.common_color_10255, i);
        am.setImageResource(this.fNl, R.drawable.icon_sett_s, i);
        am.setBackgroundColor(this.fNl, R.color.common_color_10255, i);
        am.setBackgroundColor(this.fNm, R.color.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.fNk.setVisibility(0);
        } else {
            this.fNk.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.fNj.setTabWidgetVisibility(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.fNj.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.Fq = editorTools;
        this.fNj.setEditorTools(this.Fq);
    }
}
