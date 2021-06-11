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
import d.a.n0.b1.k.a.c.f;
/* loaded from: classes4.dex */
public class TopicTimelineView extends ForbidParentSwipeBackLinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f16686e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f16687f;

    /* renamed from: g  reason: collision with root package name */
    public RecyclerView f16688g;

    /* renamed from: h  reason: collision with root package name */
    public TopicTimelineAdapter f16689h;

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ItemDecoration {

        /* renamed from: a  reason: collision with root package name */
        public int f16690a;

        /* renamed from: b  reason: collision with root package name */
        public int f16691b;

        /* renamed from: c  reason: collision with root package name */
        public int f16692c;

        public a(int i2, int i3, int i4) {
            this.f16690a = i2;
            this.f16691b = i3;
            this.f16692c = i4;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager.getOrientation() == 1) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = this.f16690a;
                } else {
                    rect.top = this.f16691b;
                }
                if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                    rect.bottom = this.f16692c;
                    return;
                }
                return;
            }
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = this.f16690a;
            } else {
                rect.left = this.f16691b;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.right = this.f16692c;
            }
        }
    }

    public TopicTimelineView(Context context) {
        super(context);
        this.f16686e = 3;
        a(context);
    }

    public final void a(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.topic_timeline_view_layout, (ViewGroup) this, true);
        this.f16687f = (TextView) findViewById(R.id.topic_timeline_title);
        this.f16688g = (RecyclerView) findViewById(R.id.topic_timeline_list);
        TopicTimelineAdapter topicTimelineAdapter = new TopicTimelineAdapter(context);
        this.f16689h = topicTimelineAdapter;
        this.f16688g.setAdapter(topicTimelineAdapter);
        this.f16688g.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.f16688g.setItemAnimator(new DefaultItemAnimator());
        this.f16688g.addItemDecoration(new a(l.g(context, R.dimen.tbds44), l.g(context, R.dimen.tbds20), l.g(context, R.dimen.tbds44)));
        b();
    }

    public void b() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.f16686e) {
            return;
        }
        this.f16686e = skinType;
        SkinManager.setViewTextColor(this.f16687f, R.color.CAM_X0105);
        this.f16689h.notifyDataSetChanged();
    }

    public void setData(f fVar) {
        if (fVar != null && !ListUtils.isEmpty(fVar.f55652b)) {
            setVisibility(0);
            this.f16687f.setText(fVar.f55651a);
            this.f16689h.setData(fVar.f55652b);
            this.f16689h.notifyDataSetChanged();
            return;
        }
        setVisibility(8);
    }

    public TopicTimelineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16686e = 3;
        a(context);
    }

    public TopicTimelineView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f16686e = 3;
        a(context);
    }
}
