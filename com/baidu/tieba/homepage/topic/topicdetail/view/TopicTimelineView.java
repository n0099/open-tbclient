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
import d.a.o0.b1.k.a.c.f;
/* loaded from: classes4.dex */
public class TopicTimelineView extends ForbidParentSwipeBackLinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f16768e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f16769f;

    /* renamed from: g  reason: collision with root package name */
    public RecyclerView f16770g;

    /* renamed from: h  reason: collision with root package name */
    public TopicTimelineAdapter f16771h;

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ItemDecoration {

        /* renamed from: a  reason: collision with root package name */
        public int f16772a;

        /* renamed from: b  reason: collision with root package name */
        public int f16773b;

        /* renamed from: c  reason: collision with root package name */
        public int f16774c;

        public a(int i2, int i3, int i4) {
            this.f16772a = i2;
            this.f16773b = i3;
            this.f16774c = i4;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager.getOrientation() == 1) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = this.f16772a;
                } else {
                    rect.top = this.f16773b;
                }
                if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                    rect.bottom = this.f16774c;
                    return;
                }
                return;
            }
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = this.f16772a;
            } else {
                rect.left = this.f16773b;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.right = this.f16774c;
            }
        }
    }

    public TopicTimelineView(Context context) {
        super(context);
        this.f16768e = 3;
        a(context);
    }

    public final void a(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.topic_timeline_view_layout, (ViewGroup) this, true);
        this.f16769f = (TextView) findViewById(R.id.topic_timeline_title);
        this.f16770g = (RecyclerView) findViewById(R.id.topic_timeline_list);
        TopicTimelineAdapter topicTimelineAdapter = new TopicTimelineAdapter(context);
        this.f16771h = topicTimelineAdapter;
        this.f16770g.setAdapter(topicTimelineAdapter);
        this.f16770g.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.f16770g.setItemAnimator(new DefaultItemAnimator());
        this.f16770g.addItemDecoration(new a(l.g(context, R.dimen.tbds44), l.g(context, R.dimen.tbds20), l.g(context, R.dimen.tbds44)));
        b();
    }

    public void b() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.f16768e) {
            return;
        }
        this.f16768e = skinType;
        SkinManager.setViewTextColor(this.f16769f, R.color.CAM_X0105);
        this.f16771h.notifyDataSetChanged();
    }

    public void setData(f fVar) {
        if (fVar != null && !ListUtils.isEmpty(fVar.f55777b)) {
            setVisibility(0);
            this.f16769f.setText(fVar.f55776a);
            this.f16771h.setData(fVar.f55777b);
            this.f16771h.notifyDataSetChanged();
            return;
        }
        setVisibility(8);
    }

    public TopicTimelineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16768e = 3;
        a(context);
    }

    public TopicTimelineView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f16768e = 3;
        a(context);
    }
}
