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
/* loaded from: classes13.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private EditorTools ZS;
    private EmotionTabHorizonScrollView hfV;
    private ImageView hfW;
    private ImageView hfX;
    private View hfY;

    /* loaded from: classes13.dex */
    public interface a {
        void od(int i);
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
        this.hfV = (EmotionTabHorizonScrollView) findViewById(R.id.face_tab_scroll_view);
        this.hfW = (ImageView) findViewById(R.id.face_tab_delete);
        this.hfX = (ImageView) findViewById(R.id.face_tab_setting);
        this.hfY = findViewById(R.id.vertical_div_line);
        this.hfW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.ZS != null) {
                    EmotionTabWidgetView.this.ZS.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.hfX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.hfX.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.hfV != null) {
            this.hfV.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.hfV.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.hfV.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.hfV.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.hfV.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.hfV.reset();
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this, R.color.common_color_10255, i);
        this.hfV.onChangeSkin(i);
        ao.setImageResource(this.hfW, R.drawable.emotion_delete, i);
        ao.setBackgroundColor(this.hfW, R.color.common_color_10255, i);
        ao.setImageResource(this.hfX, R.drawable.icon_sett_s, i);
        ao.setBackgroundColor(this.hfX, R.color.common_color_10255, i);
        ao.setBackgroundColor(this.hfY, R.color.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.hfW.setVisibility(0);
        } else {
            this.hfW.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.hfV.setTabWidgetVisibility(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.hfV.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.ZS = editorTools;
        this.hfV.setEditorTools(this.ZS);
    }
}
