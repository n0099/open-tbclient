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
    private EditorTools abk;
    private EmotionTabHorizonScrollView ihs;
    private ImageView iht;
    private ImageView ihu;
    private View ihv;

    /* loaded from: classes13.dex */
    public interface a {
        void ry(int i);
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
        this.ihs = (EmotionTabHorizonScrollView) findViewById(R.id.face_tab_scroll_view);
        this.iht = (ImageView) findViewById(R.id.face_tab_delete);
        this.ihu = (ImageView) findViewById(R.id.face_tab_setting);
        this.ihv = findViewById(R.id.vertical_div_line);
        this.iht.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.abk != null) {
                    EmotionTabWidgetView.this.abk.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.ihu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.ihu.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.ihs != null) {
            this.ihs.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.ihs.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.ihs.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.ihs.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.ihs.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.ihs.reset();
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this, R.color.common_color_10255, i);
        this.ihs.onChangeSkin(i);
        ap.setImageResource(this.iht, R.drawable.emotion_delete, i);
        ap.setBackgroundColor(this.iht, R.color.common_color_10255, i);
        ap.setImageResource(this.ihu, R.drawable.icon_sett_s, i);
        ap.setBackgroundColor(this.ihu, R.color.common_color_10255, i);
        ap.setBackgroundColor(this.ihv, R.color.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.iht.setVisibility(0);
        } else {
            this.iht.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.ihs.setTabWidgetVisibility(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.ihs.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.abk = editorTools;
        this.ihs.setEditorTools(this.abk);
    }
}
