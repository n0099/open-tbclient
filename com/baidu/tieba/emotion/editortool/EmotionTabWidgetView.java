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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private EditorTools ZX;
    private EmotionTabHorizonScrollView haq;
    private ImageView har;
    private ImageView has;
    private View hat;

    /* loaded from: classes6.dex */
    public interface a {
        void nL(int i);
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
        this.haq = (EmotionTabHorizonScrollView) findViewById(R.id.face_tab_scroll_view);
        this.har = (ImageView) findViewById(R.id.face_tab_delete);
        this.has = (ImageView) findViewById(R.id.face_tab_setting);
        this.hat = findViewById(R.id.vertical_div_line);
        this.har.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.ZX != null) {
                    EmotionTabWidgetView.this.ZX.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.has.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.has.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.haq != null) {
            this.haq.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.haq.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.haq.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.haq.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.haq.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.haq.reset();
    }

    public void onChangeSkinType(int i) {
        an.setBackgroundColor(this, R.color.common_color_10255, i);
        this.haq.onChangeSkin(i);
        an.setImageResource(this.har, R.drawable.emotion_delete, i);
        an.setBackgroundColor(this.har, R.color.common_color_10255, i);
        an.setImageResource(this.has, R.drawable.icon_sett_s, i);
        an.setBackgroundColor(this.has, R.color.common_color_10255, i);
        an.setBackgroundColor(this.hat, R.color.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.har.setVisibility(0);
        } else {
            this.har.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.haq.setTabWidgetVisibility(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.haq.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.ZX = editorTools;
        this.haq.setEditorTools(this.ZX);
    }
}
