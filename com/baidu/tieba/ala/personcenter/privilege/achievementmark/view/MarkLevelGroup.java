package com.baidu.tieba.ala.personcenter.privilege.achievementmark.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.ala.utils.AlaStringHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import d.b.i0.t.j.g.c.c.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class MarkLevelGroup extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f14724e;

    /* renamed from: f  reason: collision with root package name */
    public List<View> f14725f;

    /* renamed from: g  reason: collision with root package name */
    public b f14726g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f14727e;

        public a(d dVar) {
            this.f14727e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            for (View view2 : MarkLevelGroup.this.f14725f) {
                if (view == view2) {
                    MarkLevelGroup.this.e((FrameLayout) view2.findViewById(R.id.mark_level_layout), true);
                } else {
                    MarkLevelGroup.this.e((FrameLayout) view2.findViewById(R.id.mark_level_layout), false);
                }
            }
            if (MarkLevelGroup.this.f14726g != null) {
                MarkLevelGroup.this.f14726g.a(this.f14727e.b(), this.f14727e.a());
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(String str, String str2);
    }

    public MarkLevelGroup(Context context) {
        super(context);
        d();
    }

    public final void d() {
        setOrientation(0);
        setGravity(1);
        LayoutInflater.from(getContext()).inflate(R.layout.ala_achievement_mark_level_layout, (ViewGroup) this, true);
        this.f14724e = (LinearLayout) findViewById(R.id.mark_level_list_container);
    }

    public final void e(FrameLayout frameLayout, boolean z) {
        if (z) {
            frameLayout.setBackgroundResource(R.drawable.pic_live_honor_show_s);
        } else {
            frameLayout.setBackgroundResource(0);
        }
    }

    public void f(d.b.i0.t.j.g.c.c.b bVar) {
        if (bVar == null) {
            return;
        }
        List<d> c2 = bVar.c();
        if (ListUtils.isEmpty(c2)) {
            if (getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                layoutParams.height = getContext().getResources().getDimensionPixelSize(R.dimen.ds118);
                setLayoutParams(layoutParams);
            }
            setVisibility(4);
            return;
        }
        setVisibility(0);
        this.f14724e.removeAllViews();
        List<View> list = this.f14725f;
        if (list == null) {
            this.f14725f = new ArrayList();
        } else {
            list.clear();
        }
        int size = c2.size();
        for (int i = 0; i < size; i++) {
            d dVar = c2.get(i);
            if (dVar != null) {
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ala_achievement_mark_level_item_view, (ViewGroup) null);
                FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.mark_level_layout);
                TextView textView = (TextView) inflate.findViewById(R.id.mark_level_tv);
                textView.setText(String.valueOf(i + 1));
                ((TextView) inflate.findViewById(R.id.mark_level_score_tv)).setText(AlaStringHelper.numFormatMarkLevel(dVar.d()));
                this.f14725f.add(inflate);
                boolean z = bVar.j() == 0;
                if (bVar.g() == dVar.c()) {
                    e(frameLayout, true);
                    if (z) {
                        textView.setBackgroundResource(R.drawable.pic_live_honor_show_off);
                    } else {
                        textView.setBackgroundResource(R.drawable.pic_live_honor_show_on);
                    }
                } else if (bVar.g() > dVar.c()) {
                    e(frameLayout, false);
                    if (z) {
                        textView.setBackgroundResource(R.drawable.pic_live_honor_show_off);
                    } else {
                        textView.setBackgroundResource(R.drawable.pic_live_honor_show_on);
                    }
                } else if (bVar.g() < dVar.c()) {
                    e(frameLayout, false);
                    textView.setBackgroundResource(R.drawable.pic_live_honor_show_off);
                }
                inflate.setOnClickListener(new a(dVar));
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) inflate.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.ds82), -2);
                } else {
                    layoutParams2.width = getContext().getResources().getDimensionPixelSize(R.dimen.ds82);
                    layoutParams2.height = -2;
                }
                this.f14724e.addView(inflate, layoutParams2);
            }
        }
    }

    public void setCallback(b bVar) {
        this.f14726g = bVar;
    }

    public MarkLevelGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d();
    }

    public MarkLevelGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        d();
    }
}
