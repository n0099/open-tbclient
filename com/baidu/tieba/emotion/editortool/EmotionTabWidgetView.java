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
    private EditorTools Zt;
    private EmotionTabHorizonScrollView gNj;
    private ImageView gNk;
    private ImageView gNl;
    private View gNm;

    /* loaded from: classes6.dex */
    public interface a {
        void np(int i);
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
        this.gNj = (EmotionTabHorizonScrollView) findViewById(R.id.face_tab_scroll_view);
        this.gNk = (ImageView) findViewById(R.id.face_tab_delete);
        this.gNl = (ImageView) findViewById(R.id.face_tab_setting);
        this.gNm = findViewById(R.id.vertical_div_line);
        this.gNk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.Zt != null) {
                    EmotionTabWidgetView.this.Zt.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.gNl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.gNl.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.gNj != null) {
            this.gNj.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.gNj.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.gNj.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.gNj.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.gNj.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.gNj.reset();
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this, R.color.common_color_10255, i);
        this.gNj.onChangeSkin(i);
        am.setImageResource(this.gNk, R.drawable.emotion_delete, i);
        am.setBackgroundColor(this.gNk, R.color.common_color_10255, i);
        am.setImageResource(this.gNl, R.drawable.icon_sett_s, i);
        am.setBackgroundColor(this.gNl, R.color.common_color_10255, i);
        am.setBackgroundColor(this.gNm, R.color.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.gNk.setVisibility(0);
        } else {
            this.gNk.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.gNj.setTabWidgetVisibility(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.gNj.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.Zt = editorTools;
        this.gNj.setEditorTools(this.Zt);
    }
}
