package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import d.a.i0.w.y.a;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class CommonTabWidgetView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public CommonTabHorizonScrollView f13592e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f13593f;

    /* renamed from: g  reason: collision with root package name */
    public EditorTools f13594g;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CommonTabWidgetView.this.f13594g != null) {
                CommonTabWidgetView.this.f13594g.A(new d.a.i0.w.a(3, 3, null));
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i2);
    }

    public CommonTabWidgetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context);
    }

    public void b(a.b bVar) {
        this.f13592e.b(bVar);
    }

    public final void c(Context context) {
        setVisibility(8);
        removeAllViews();
        LayoutInflater.from(context).inflate(R.layout.common_tab_widget, (ViewGroup) this, true);
        this.f13592e = (CommonTabHorizonScrollView) findViewById(R.id.privilege_tab_scroll_view);
        ImageView imageView = (ImageView) findViewById(R.id.privilege_tab_delete);
        this.f13593f = imageView;
        imageView.setOnClickListener(new a());
    }

    public void d(int i2) {
        SkinManager.setBackgroundColor(this, R.color.common_color_10223, i2);
        this.f13592e.e(i2);
        SkinManager.setImageResource(this.f13593f, R.drawable.but_face_close, i2);
        SkinManager.setBackgroundColor(this.f13593f, R.color.common_color_10224, i2);
    }

    public void e() {
        this.f13592e.f();
    }

    public void setCurrentTab(int i2) {
        this.f13592e.setCurrentTab(i2);
    }

    public void setDatas(ArrayList<d.a.i0.w.y.a> arrayList) {
        this.f13592e.setDatas(arrayList);
        if (arrayList != null && arrayList.size() > 1) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.f13594g = editorTools;
    }

    public void setOnTabSelectedListener(b bVar) {
        this.f13592e.setOnTabSelectedListener(bVar);
    }

    public void setShowDelete(boolean z) {
        if (z) {
            this.f13593f.setVisibility(0);
        } else {
            this.f13593f.setVisibility(8);
        }
    }

    public CommonTabWidgetView(Context context) {
        super(context);
        c(context);
    }
}
