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
import d.b.c.e.p.l;
import d.b.i0.a1.j.a.c.f;
/* loaded from: classes4.dex */
public class TopicTimelineView extends ForbidParentSwipeBackLinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f17091e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f17092f;

    /* renamed from: g  reason: collision with root package name */
    public RecyclerView f17093g;

    /* renamed from: h  reason: collision with root package name */
    public TopicTimelineAdapter f17094h;

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ItemDecoration {

        /* renamed from: a  reason: collision with root package name */
        public int f17095a;

        /* renamed from: b  reason: collision with root package name */
        public int f17096b;

        /* renamed from: c  reason: collision with root package name */
        public int f17097c;

        public a(int i, int i2, int i3) {
            this.f17095a = i;
            this.f17096b = i2;
            this.f17097c = i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager.getOrientation() == 1) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = this.f17095a;
                } else {
                    rect.top = this.f17096b;
                }
                if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                    rect.bottom = this.f17097c;
                    return;
                }
                return;
            }
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = this.f17095a;
            } else {
                rect.left = this.f17096b;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.right = this.f17097c;
            }
        }
    }

    public TopicTimelineView(Context context) {
        super(context);
        this.f17091e = 3;
        a(context);
    }

    public final void a(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.topic_timeline_view_layout, (ViewGroup) this, true);
        this.f17092f = (TextView) findViewById(R.id.topic_timeline_title);
        this.f17093g = (RecyclerView) findViewById(R.id.topic_timeline_list);
        TopicTimelineAdapter topicTimelineAdapter = new TopicTimelineAdapter(context);
        this.f17094h = topicTimelineAdapter;
        this.f17093g.setAdapter(topicTimelineAdapter);
        this.f17093g.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.f17093g.setItemAnimator(new DefaultItemAnimator());
        this.f17093g.addItemDecoration(new a(l.g(context, R.dimen.tbds44), l.g(context, R.dimen.tbds20), l.g(context, R.dimen.tbds44)));
        b();
    }

    public void b() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.f17091e) {
            return;
        }
        this.f17091e = skinType;
        SkinManager.setViewTextColor(this.f17092f, R.color.CAM_X0105);
        this.f17094h.notifyDataSetChanged();
    }

    public void setData(f fVar) {
        if (fVar != null && !ListUtils.isEmpty(fVar.f52952b)) {
            setVisibility(0);
            this.f17092f.setText(fVar.f52951a);
            this.f17094h.setData(fVar.f52952b);
            this.f17094h.notifyDataSetChanged();
            return;
        }
        setVisibility(8);
    }

    public TopicTimelineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17091e = 3;
        a(context);
    }

    public TopicTimelineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17091e = 3;
        a(context);
    }
}
