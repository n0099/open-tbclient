package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.layout.ForbidParentSwipeBackLinearLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.topic.topicdetail.b.f;
/* loaded from: classes4.dex */
public class TopicTimelineView extends ForbidParentSwipeBackLinearLayout {
    private com.baidu.tieba.homepage.topic.topicdetail.a.d fPK;
    private RecyclerView mRecyclerView;
    private int mSkinType;
    private TextView mTitleView;

    public TopicTimelineView(Context context) {
        super(context);
        this.mSkinType = 3;
        init(context);
    }

    public TopicTimelineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        init(context);
    }

    public TopicTimelineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(d.h.topic_timeline_view_layout, (ViewGroup) this, true);
        this.mTitleView = (TextView) findViewById(d.g.topic_timeline_title);
        this.mRecyclerView = (RecyclerView) findViewById(d.g.topic_timeline_list);
        this.fPK = new com.baidu.tieba.homepage.topic.topicdetail.a.d(context);
        this.mRecyclerView.setAdapter(this.fPK);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        this.mRecyclerView.addItemDecoration(new a(l.h(context, d.e.tbds44), l.h(context, d.e.tbds20), l.h(context, d.e.tbds44)));
        onChangeSkinType();
    }

    public void setData(f fVar) {
        if (fVar == null || v.T(fVar.fOF)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.mTitleView.setText(fVar.title);
        this.fPK.setData(fVar.fOF);
        this.fPK.notifyDataSetChanged();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.j(this.mTitleView, d.C0236d.cp_cont_b);
            this.fPK.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ItemDecoration {
        private int eHA;
        private int eHB;
        private int mEnd;

        public a(int i, int i2, int i3) {
            this.eHA = i;
            this.eHB = i2;
            this.mEnd = i3;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager.getOrientation() == 1) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = this.eHA;
                } else {
                    rect.top = this.eHB;
                }
                if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                    rect.bottom = this.mEnd;
                    return;
                }
                return;
            }
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = this.eHA;
            } else {
                rect.left = this.eHB;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.right = this.mEnd;
            }
        }
    }
}
