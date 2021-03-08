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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.layout.ForbidParentSwipeBackLinearLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topicdetail.a.f;
import com.baidu.tieba.homepage.topic.topicdetail.adapter.TopicTimelineAdapter;
/* loaded from: classes2.dex */
public class TopicTimelineView extends ForbidParentSwipeBackLinearLayout {
    private TopicTimelineAdapter ksb;
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
        LayoutInflater.from(context).inflate(R.layout.topic_timeline_view_layout, (ViewGroup) this, true);
        this.mTitleView = (TextView) findViewById(R.id.topic_timeline_title);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.topic_timeline_list);
        this.ksb = new TopicTimelineAdapter(context);
        this.mRecyclerView.setAdapter(this.ksb);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        this.mRecyclerView.addItemDecoration(new a(l.getDimens(context, R.dimen.tbds44), l.getDimens(context, R.dimen.tbds20), l.getDimens(context, R.dimen.tbds44)));
        onChangeSkinType();
    }

    public void setData(f fVar) {
        if (fVar == null || y.isEmpty(fVar.kra)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.mTitleView.setText(fVar.title);
        this.ksb.setData(fVar.kra);
        this.ksb.notifyDataSetChanged();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105);
            this.ksb.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends RecyclerView.ItemDecoration {
        private int Zx;
        private int Zy;
        private int mEnd;

        public a(int i, int i2, int i3) {
            this.Zx = i;
            this.Zy = i2;
            this.mEnd = i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager.getOrientation() == 1) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = this.Zx;
                } else {
                    rect.top = this.Zy;
                }
                if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                    rect.bottom = this.mEnd;
                    return;
                }
                return;
            }
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = this.Zx;
            } else {
                rect.left = this.Zy;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.right = this.mEnd;
            }
        }
    }
}
