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
    public EmotionTabHorizonScrollView f15348e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f15349f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f15350g;

    /* renamed from: h  reason: collision with root package name */
    public View f15351h;
    public EditorTools i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (EmotionTabWidgetView.this.i != null) {
                EmotionTabWidgetView.this.i.A(new d.b.h0.w.a(3, -1, null));
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
        void a(int i);
    }

    public EmotionTabWidgetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context);
    }

    public void b(d.b.h0.w.p.c cVar) {
        this.f15348e.j(cVar);
    }

    public final void c(Context context) {
        removeAllViews();
        LayoutInflater.from(context).inflate(R.layout.emotion_tab_widget, (ViewGroup) this, true);
        this.f15348e = (EmotionTabHorizonScrollView) findViewById(R.id.face_tab_scroll_view);
        this.f15349f = (ImageView) findViewById(R.id.face_tab_delete);
        this.f15350g = (ImageView) findViewById(R.id.face_tab_setting);
        this.f15351h = findViewById(R.id.vertical_div_line);
        this.f15349f.setOnClickListener(new a());
        this.f15350g.setOnClickListener(new b());
        this.f15350g.setVisibility(8);
    }

    public void d(int i) {
        SkinManager.setBackgroundColor(this, R.color.common_color_10255, i);
        this.f15348e.n(i);
        SkinManager.setImageResource(this.f15349f, R.drawable.emotion_delete, i);
        SkinManager.setBackgroundColor(this.f15349f, R.color.common_color_10255, i);
        SkinManager.setImageResource(this.f15350g, R.drawable.icon_sett_s, i);
        SkinManager.setBackgroundColor(this.f15350g, R.color.common_color_10255, i);
        SkinManager.setBackgroundColor(this.f15351h, R.color.common_color_10288, i);
    }

    public void e() {
        this.f15348e.o();
    }

    public void setCurrentTab(int i) {
        this.f15348e.setCurrentTab(i);
    }

    public void setDatas(ArrayList<d.b.h0.w.p.c> arrayList) {
        this.f15348e.setDatas(arrayList);
    }

    public void setFrom(int i) {
        EmotionTabHorizonScrollView emotionTabHorizonScrollView = this.f15348e;
        if (emotionTabHorizonScrollView != null) {
            emotionTabHorizonScrollView.setFrom(i);
        }
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.i = editorTools;
        this.f15348e.setEditorTools(editorTools);
    }

    public void setOnTabSelectedListener(c cVar) {
        this.f15348e.setOnTabSelectedListener(cVar);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.f15349f.setVisibility(0);
        } else {
            this.f15349f.setVisibility(8);
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        this.f15348e.setTabWidgetBigEmontionVisibility(z);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.f15348e.setTabWidgetVisibility(i, z);
    }

    public EmotionTabWidgetView(Context context) {
        super(context);
        c(context);
    }
}
