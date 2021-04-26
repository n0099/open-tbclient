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
import com.baidu.tbadk.core.atomData.UserCollectManageActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class EmotionTabWidgetView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public EmotionTabHorizonScrollView f15139e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f15140f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f15141g;

    /* renamed from: h  reason: collision with root package name */
    public View f15142h;

    /* renamed from: i  reason: collision with root package name */
    public EditorTools f15143i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (EmotionTabWidgetView.this.f15143i != null) {
                EmotionTabWidgetView.this.f15143i.A(new d.a.i0.w.a(3, -1, null));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabWidgetView.this.getContext())));
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(int i2);
    }

    public EmotionTabWidgetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context);
    }

    public void b(d.a.i0.w.p.c cVar) {
        this.f15139e.j(cVar);
    }

    public final void c(Context context) {
        removeAllViews();
        LayoutInflater.from(context).inflate(R.layout.emotion_tab_widget, (ViewGroup) this, true);
        this.f15139e = (EmotionTabHorizonScrollView) findViewById(R.id.face_tab_scroll_view);
        this.f15140f = (ImageView) findViewById(R.id.face_tab_delete);
        this.f15141g = (ImageView) findViewById(R.id.face_tab_setting);
        this.f15142h = findViewById(R.id.vertical_div_line);
        this.f15140f.setOnClickListener(new a());
        this.f15141g.setOnClickListener(new b());
        this.f15141g.setVisibility(8);
    }

    public void d(int i2) {
        SkinManager.setBackgroundColor(this, R.color.common_color_10255, i2);
        this.f15139e.n(i2);
        SkinManager.setImageResource(this.f15140f, R.drawable.emotion_delete, i2);
        SkinManager.setBackgroundColor(this.f15140f, R.color.common_color_10255, i2);
        SkinManager.setImageResource(this.f15141g, R.drawable.icon_sett_s, i2);
        SkinManager.setBackgroundColor(this.f15141g, R.color.common_color_10255, i2);
        SkinManager.setBackgroundColor(this.f15142h, R.color.common_color_10288, i2);
    }

    public void e() {
        this.f15139e.o();
    }

    public void setCurrentTab(int i2) {
        this.f15139e.setCurrentTab(i2);
    }

    public void setDatas(ArrayList<d.a.i0.w.p.c> arrayList) {
        this.f15139e.setDatas(arrayList);
    }

    public void setFrom(int i2) {
        EmotionTabHorizonScrollView emotionTabHorizonScrollView = this.f15139e;
        if (emotionTabHorizonScrollView != null) {
            emotionTabHorizonScrollView.setFrom(i2);
        }
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.f15143i = editorTools;
        this.f15139e.setEditorTools(editorTools);
    }

    public void setOnTabSelectedListener(c cVar) {
        this.f15139e.setOnTabSelectedListener(cVar);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.f15140f.setVisibility(0);
        } else {
            this.f15140f.setVisibility(8);
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.f15139e.setTabWidgetBigEmontionVisibility(z);
    }

    public void setTabWidgetVisibility(int i2, boolean z) {
        this.f15139e.setTabWidgetVisibility(i2, z);
    }

    public EmotionTabWidgetView(Context context) {
        super(context);
        c(context);
    }
}
