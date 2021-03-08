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
/* loaded from: classes7.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private EditorTools ael;
    private EmotionTabHorizonScrollView iIo;
    private ImageView iIp;
    private ImageView iIq;
    private View iIr;

    /* loaded from: classes7.dex */
    public interface a {
        void rj(int i);
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
        this.iIo = (EmotionTabHorizonScrollView) findViewById(R.id.face_tab_scroll_view);
        this.iIp = (ImageView) findViewById(R.id.face_tab_delete);
        this.iIq = (ImageView) findViewById(R.id.face_tab_setting);
        this.iIr = findViewById(R.id.vertical_div_line);
        this.iIp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.ael != null) {
                    EmotionTabWidgetView.this.ael.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.iIq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.iIq.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.iIo != null) {
            this.iIo.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.iIo.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.iIo.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.iIo.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.iIo.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.iIo.reset();
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this, R.color.common_color_10255, i);
        this.iIo.onChangeSkin(i);
        ap.setImageResource(this.iIp, R.drawable.emotion_delete, i);
        ap.setBackgroundColor(this.iIp, R.color.common_color_10255, i);
        ap.setImageResource(this.iIq, R.drawable.icon_sett_s, i);
        ap.setBackgroundColor(this.iIq, R.color.common_color_10255, i);
        ap.setBackgroundColor(this.iIr, R.color.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.iIp.setVisibility(0);
        } else {
            this.iIp.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.iIo.setTabWidgetVisibility(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.iIo.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.ael = editorTools;
        this.iIo.setEditorTools(this.ael);
    }
}
