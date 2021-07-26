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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.layout.ForbidParentSwipeBackLinearLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topicdetail.adapter.TopicTimelineAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.q0.e1.k.a.c.f;
/* loaded from: classes4.dex */
public class TopicTimelineView extends ForbidParentSwipeBackLinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f16999e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f17000f;

    /* renamed from: g  reason: collision with root package name */
    public RecyclerView f17001g;

    /* renamed from: h  reason: collision with root package name */
    public TopicTimelineAdapter f17002h;

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ItemDecoration {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f17003a;

        /* renamed from: b  reason: collision with root package name */
        public int f17004b;

        /* renamed from: c  reason: collision with root package name */
        public int f17005c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ TopicTimelineView f17006d;

        public a(TopicTimelineView topicTimelineView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicTimelineView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17006d = topicTimelineView;
            this.f17003a = i2;
            this.f17004b = i3;
            this.f17005c = i4;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, rect, view, recyclerView, state) == null) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                if (linearLayoutManager.getOrientation() == 1) {
                    if (recyclerView.getChildAdapterPosition(view) == 0) {
                        rect.top = this.f17003a;
                    } else {
                        rect.top = this.f17004b;
                    }
                    if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                        rect.bottom = this.f17005c;
                        return;
                    }
                    return;
                }
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.left = this.f17003a;
                } else {
                    rect.left = this.f17004b;
                }
                if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                    rect.right = this.f17005c;
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicTimelineView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16999e = 3;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            setOrientation(1);
            LayoutInflater.from(context).inflate(R.layout.topic_timeline_view_layout, (ViewGroup) this, true);
            this.f17000f = (TextView) findViewById(R.id.topic_timeline_title);
            this.f17001g = (RecyclerView) findViewById(R.id.topic_timeline_list);
            TopicTimelineAdapter topicTimelineAdapter = new TopicTimelineAdapter(context);
            this.f17002h = topicTimelineAdapter;
            this.f17001g.setAdapter(topicTimelineAdapter);
            this.f17001g.setLayoutManager(new LinearLayoutManager(context, 0, false));
            this.f17001g.setItemAnimator(new DefaultItemAnimator());
            this.f17001g.addItemDecoration(new a(this, l.g(context, R.dimen.tbds44), l.g(context, R.dimen.tbds20), l.g(context, R.dimen.tbds44)));
            b();
        }
    }

    public void b() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f16999e) {
            return;
        }
        this.f16999e = skinType;
        SkinManager.setViewTextColor(this.f17000f, R.color.CAM_X0105);
        this.f17002h.notifyDataSetChanged();
    }

    public void setData(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) {
            if (fVar != null && !ListUtils.isEmpty(fVar.f56332b)) {
                setVisibility(0);
                this.f17000f.setText(fVar.f56331a);
                this.f17002h.setData(fVar.f56332b);
                this.f17002h.notifyDataSetChanged();
                return;
            }
            setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicTimelineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f16999e = 3;
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicTimelineView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f16999e = 3;
        a(context);
    }
}
