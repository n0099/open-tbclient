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
import d.b.b.e.p.l;
import d.b.i0.z0.j.a.c.f;
/* loaded from: classes4.dex */
public class TopicTimelineView extends ForbidParentSwipeBackLinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f17413e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f17414f;

    /* renamed from: g  reason: collision with root package name */
    public RecyclerView f17415g;

    /* renamed from: h  reason: collision with root package name */
    public TopicTimelineAdapter f17416h;

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ItemDecoration {

        /* renamed from: a  reason: collision with root package name */
        public int f17417a;

        /* renamed from: b  reason: collision with root package name */
        public int f17418b;

        /* renamed from: c  reason: collision with root package name */
        public int f17419c;

        public a(int i, int i2, int i3) {
            this.f17417a = i;
            this.f17418b = i2;
            this.f17419c = i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager.getOrientation() == 1) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = this.f17417a;
                } else {
                    rect.top = this.f17418b;
                }
                if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                    rect.bottom = this.f17419c;
                    return;
                }
                return;
            }
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = this.f17417a;
            } else {
                rect.left = this.f17418b;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.right = this.f17419c;
            }
        }
    }

    public TopicTimelineView(Context context) {
        super(context);
        this.f17413e = 3;
        a(context);
    }

    public final void a(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.topic_timeline_view_layout, (ViewGroup) this, true);
        this.f17414f = (TextView) findViewById(R.id.topic_timeline_title);
        this.f17415g = (RecyclerView) findViewById(R.id.topic_timeline_list);
        TopicTimelineAdapter topicTimelineAdapter = new TopicTimelineAdapter(context);
        this.f17416h = topicTimelineAdapter;
        this.f17415g.setAdapter(topicTimelineAdapter);
        this.f17415g.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.f17415g.setItemAnimator(new DefaultItemAnimator());
        this.f17415g.addItemDecoration(new a(l.g(context, R.dimen.tbds44), l.g(context, R.dimen.tbds20), l.g(context, R.dimen.tbds44)));
        b();
    }

    public void b() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.f17413e) {
            return;
        }
        this.f17413e = skinType;
        SkinManager.setViewTextColor(this.f17414f, R.color.CAM_X0105);
        this.f17416h.notifyDataSetChanged();
    }

    public void setData(f fVar) {
        if (fVar != null && !ListUtils.isEmpty(fVar.f63332b)) {
            setVisibility(0);
            this.f17414f.setText(fVar.f63331a);
            this.f17416h.setData(fVar.f63332b);
            this.f17416h.notifyDataSetChanged();
            return;
        }
        setVisibility(8);
    }

    public TopicTimelineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17413e = 3;
        a(context);
    }

    public TopicTimelineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17413e = 3;
        a(context);
    }
}
