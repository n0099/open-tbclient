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
    private EmotionTabHorizonScrollView ibr;
    private ImageView ibs;
    private ImageView ibt;
    private View ibu;

    /* loaded from: classes13.dex */
    public interface a {
        void ro(int i);
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
        this.ibr = (EmotionTabHorizonScrollView) findViewById(R.id.face_tab_scroll_view);
        this.ibs = (ImageView) findViewById(R.id.face_tab_delete);
        this.ibt = (ImageView) findViewById(R.id.face_tab_setting);
        this.ibu = findViewById(R.id.vertical_div_line);
        this.ibs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.abk != null) {
                    EmotionTabWidgetView.this.abk.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.ibt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.ibt.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.ibr != null) {
            this.ibr.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.ibr.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.ibr.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.ibr.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.ibr.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.ibr.reset();
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this, R.color.common_color_10255, i);
        this.ibr.onChangeSkin(i);
        ap.setImageResource(this.ibs, R.drawable.emotion_delete, i);
        ap.setBackgroundColor(this.ibs, R.color.common_color_10255, i);
        ap.setImageResource(this.ibt, R.drawable.icon_sett_s, i);
        ap.setBackgroundColor(this.ibt, R.color.common_color_10255, i);
        ap.setBackgroundColor(this.ibu, R.color.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.ibs.setVisibility(0);
        } else {
            this.ibs.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.ibr.setTabWidgetVisibility(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.ibr.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.abk = editorTools;
        this.ibr.setEditorTools(this.abk);
    }
}
