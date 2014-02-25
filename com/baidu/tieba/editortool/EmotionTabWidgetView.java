package com.baidu.tieba.editortool;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.data.emotions.WritableEmotionGroup;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabWidgetView extends LinearLayout {
    private EmotionTabHorizonScrollView a;
    private ImageView b;
    private View c;
    private z d;

    public EmotionTabWidgetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public EmotionTabWidgetView(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        removeAllViews();
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.emotion_tab_widget, (ViewGroup) this, true);
        this.a = (EmotionTabHorizonScrollView) findViewById(R.id.face_tab_scroll_view);
        this.b = (ImageView) findViewById(R.id.face_tab_delete);
        this.b.setOnClickListener(new x(this));
        this.c = findViewById(R.id.face_tab_zhanwei);
    }

    public void setFrom(int i) {
        if (this.a != null) {
            this.a.setFrom(i);
        }
    }

    public void setDatas(ArrayList<WritableEmotionGroup> arrayList) {
        this.a.setDatas(arrayList);
    }

    public void a(WritableEmotionGroup writableEmotionGroup) {
        this.a.a(writableEmotionGroup);
    }

    public void setCurrentTab(int i) {
        this.a.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(y yVar) {
        this.a.setOnTabSelectedListener(yVar);
    }

    public void a() {
        this.a.b();
    }

    public void a(int i) {
        setBackgroundColor(getResources().getColor(i == 1 ? R.color.editor_tool_container_bg_1 : R.color.editor_tool_container_bg));
        Resources resources = getContext().getResources();
        this.c.setBackgroundResource(i == 1 ? R.drawable.bg_expression_bar_n_1 : R.drawable.bg_expression_bar_n);
        this.a.a(i);
        int i2 = i == 1 ? R.drawable.but_face_close_1 : R.drawable.but_face_close;
        int i3 = i == 1 ? R.color.emotion_delete_bg_1 : R.color.emotion_delete_bg;
        this.b.setImageResource(i2);
        this.b.setBackgroundColor(resources.getColor(i3));
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.b.setVisibility(0);
        } else {
            this.b.setVisibility(8);
        }
    }

    public void a(int i, boolean z) {
        this.a.a(i, z);
    }

    public void setOnDataSelected(z zVar) {
        this.d = zVar;
    }
}
