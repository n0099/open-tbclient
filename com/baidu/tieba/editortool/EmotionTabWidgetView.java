package com.baidu.tieba.editortool;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
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
    private aa c;

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
        this.b.setOnClickListener(new y(this));
    }

    public void setFrom(int i) {
        if (this.a != null) {
            this.a.setFrom(i);
        }
    }

    public void setDatas(ArrayList<WritableEmotionGroup> arrayList) {
        this.a.setDatas(arrayList);
    }

    public final void a(WritableEmotionGroup writableEmotionGroup) {
        this.a.a(writableEmotionGroup);
    }

    public void setCurrentTab(int i) {
        this.a.setCurrentTab(i);
    }

    public void setOnTabSelectedListener(z zVar) {
        this.a.setOnTabSelectedListener(zVar);
    }

    public final void a() {
        this.a.a();
    }

    public final void a(int i) {
        setBackgroundColor(getResources().getColor(i == 1 ? R.color.editor_tool_container_bg_1 : R.color.editor_tool_container_bg));
        Resources resources = getContext().getResources();
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

    public final void a(int i, boolean z) {
        this.a.a(i, z);
    }

    public void setOnDataSelected(aa aaVar) {
        this.c = aaVar;
    }
}
