package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.layout.ForbidParentSwipeBackLinearLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topicdetail.adapter.TopicTimelineAdapter;
import d.a.c.e.p.l;
import d.a.k0.a1.j.a.c.f;
/* loaded from: classes4.dex */
public class TopicTimelineView extends ForbidParentSwipeBackLinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f16700e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f16701f;

    /* renamed from: g  reason: collision with root package name */
    public RecyclerView f16702g;

    /* renamed from: h  reason: collision with root package name */
    public TopicTimelineAdapter f16703h;

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ItemDecoration {

        /* renamed from: a  reason: collision with root package name */
        public int f16704a;

        /* renamed from: b  reason: collision with root package name */
        public int f16705b;

        /* renamed from: c  reason: collision with root package name */
        public int f16706c;

        public a(int i2, int i3, int i4) {
            this.f16704a = i2;
            this.f16705b = i3;
            this.f16706c = i4;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager.getOrientation() == 1) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = this.f16704a;
                } else {
                    rect.top = this.f16705b;
                }
                if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                    rect.bottom = this.f16706c;
                    return;
                }
                return;
            }
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = this.f16704a;
            } else {
                rect.left = this.f16705b;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.right = this.f16706c;
            }
        }
    }

    public TopicTimelineView(Context context) {
        super(context);
        this.f16700e = 3;
        a(context);
    }

    public final void a(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.topic_timeline_view_layout, (ViewGroup) this, true);
        this.f16701f = (TextView) findViewById(R.id.topic_timeline_title);
        this.f16702g = (RecyclerView) findViewById(R.id.topic_timeline_list);
        TopicTimelineAdapter topicTimelineAdapter = new TopicTimelineAdapter(context);
        this.f16703h = topicTimelineAdapter;
        this.f16702g.setAdapter(topicTimelineAdapter);
        this.f16702g.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.f16702g.setItemAnimator(new DefaultItemAnimator());
        this.f16702g.addItemDecoration(new a(l.g(context, R.dimen.tbds44), l.g(context, R.dimen.tbds20), l.g(context, R.dimen.tbds44)));
        b();
    }

    public void b() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.f16700e) {
            return;
        }
        this.f16700e = skinType;
        SkinManager.setViewTextColor(this.f16701f, R.color.CAM_X0105);
        this.f16703h.notifyDataSetChanged();
    }

    public void setData(f fVar) {
        if (fVar != null && !ListUtils.isEmpty(fVar.f51796b)) {
            setVisibility(0);
            this.f16701f.setText(fVar.f51795a);
            this.f16703h.setData(fVar.f51796b);
            this.f16703h.notifyDataSetChanged();
            return;
        }
        setVisibility(8);
    }

    public TopicTimelineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16700e = 3;
        a(context);
    }

    public TopicTimelineView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f16700e = 3;
        a(context);
    }
}
