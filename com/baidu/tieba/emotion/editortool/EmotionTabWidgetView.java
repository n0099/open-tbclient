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
    private EditorTools abp;
    private EmotionTabHorizonScrollView iig;
    private ImageView iih;
    private ImageView iii;
    private View iij;

    /* loaded from: classes13.dex */
    public interface a {
        void rW(int i);
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
        this.iig = (EmotionTabHorizonScrollView) findViewById(R.id.face_tab_scroll_view);
        this.iih = (ImageView) findViewById(R.id.face_tab_delete);
        this.iii = (ImageView) findViewById(R.id.face_tab_setting);
        this.iij = findViewById(R.id.vertical_div_line);
        this.iih.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EmotionTabWidgetView.this.abp != null) {
                    EmotionTabWidgetView.this.abp.b(new com.baidu.tbadk.editortools.a(3, -1, null));
                }
            }
        });
        this.iii.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
            }
        });
        this.iii.setVisibility(8);
    }

    public void setFrom(int i) {
        if (this.iig != null) {
            this.iig.setFrom(i);
        }
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.iig.setDatas(arrayList);
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.iig.c(cVar);
    }

    public void setCurrentTab(int i) {
        this.iig.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.iig.setOnTabSelectedListener(aVar);
    }

    public void reset() {
        this.iig.reset();
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this, R.color.common_color_10255, i);
        this.iig.onChangeSkin(i);
        ap.setImageResource(this.iih, R.drawable.emotion_delete, i);
        ap.setBackgroundColor(this.iih, R.color.common_color_10255, i);
        ap.setImageResource(this.iii, R.drawable.icon_sett_s, i);
        ap.setBackgroundColor(this.iii, R.color.common_color_10255, i);
        ap.setBackgroundColor(this.iij, R.color.common_color_10288, i);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.iih.setVisibility(0);
        } else {
            this.iih.setVisibility(8);
        }
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.iig.setTabWidgetVisibility(i, z);
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.iig.setTabWidgetBigEmontionVisibility(z);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.abp = editorTools;
        this.iig.setEditorTools(this.abp);
    }
}
