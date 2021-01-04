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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private EditorTools acZ;
    private EmotionTabHorizonScrollView iFo;
    private ImageView iFp;
    private ImageView iFq;
    private View iFr;

    /* loaded from: classes8.dex */
    public interface a {
        void sJ(int i);
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
        this.iFo = (EmotionTabHorizonScrollView) findViewById(R.id.face_tab_scroll_view);
        this.iFp = (ImageView) findViewById(R.id.face_tab_delete);
        this.iFq = (ImageView) findViewById(R.id.face_tab_setting);
        this.iFr = findViewById(R.id.vertical_div_line);
        this.iFp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.acZ != null) {
                    EmotionTabWidgetView.this.acZ.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.iFq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.iFq.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.iFo != null) {
            this.iFo.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.iFo.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.iFo.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.iFo.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.iFo.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.iFo.reset();
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this, R.color.common_color_10255, i);
        this.iFo.onChangeSkin(i);
        ao.setImageResource(this.iFp, R.drawable.emotion_delete, i);
        ao.setBackgroundColor(this.iFp, R.color.common_color_10255, i);
        ao.setImageResource(this.iFq, R.drawable.icon_sett_s, i);
        ao.setBackgroundColor(this.iFq, R.color.common_color_10255, i);
        ao.setBackgroundColor(this.iFr, R.color.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.iFp.setVisibility(0);
        } else {
            this.iFp.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.iFo.setTabWidgetVisibility(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.iFo.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.acZ = editorTools;
        this.iFo.setEditorTools(this.acZ);
    }
}
