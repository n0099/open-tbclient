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
import com.baidu.tieba.j98;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class TopicTimelineView extends ForbidParentSwipeBackLinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TextView b;
    public RecyclerView c;
    public TopicTimelineAdapter d;

    /* loaded from: classes6.dex */
    public class a extends RecyclerView.ItemDecoration {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public int c;
        public final /* synthetic */ TopicTimelineView d;

        public a(TopicTimelineView topicTimelineView, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicTimelineView, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = topicTimelineView;
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view2, RecyclerView recyclerView, RecyclerView.State state) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, rect, view2, recyclerView, state) == null) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                if (linearLayoutManager.getOrientation() == 1) {
                    if (recyclerView.getChildAdapterPosition(view2) == 0) {
                        rect.top = this.a;
                    } else {
                        rect.top = this.b;
                    }
                    if (recyclerView.getChildAdapterPosition(view2) == linearLayoutManager.getItemCount() - 1) {
                        rect.bottom = this.c;
                        return;
                    }
                    return;
                }
                if (recyclerView.getChildAdapterPosition(view2) == 0) {
                    rect.left = this.a;
                } else {
                    rect.left = this.b;
                }
                if (recyclerView.getChildAdapterPosition(view2) == linearLayoutManager.getItemCount() - 1) {
                    rect.right = this.c;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        a(context);
    }

    public void setData(j98 j98Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, j98Var) == null) {
            if (j98Var != null && !ListUtils.isEmpty(j98Var.b)) {
                setVisibility(0);
                this.b.setText(j98Var.a);
                this.d.setData(j98Var.b);
                this.d.notifyDataSetChanged();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 3;
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicTimelineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = 3;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            setOrientation(1);
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0997, (ViewGroup) this, true);
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f092650);
            this.c = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f09264f);
            TopicTimelineAdapter topicTimelineAdapter = new TopicTimelineAdapter(context);
            this.d = topicTimelineAdapter;
            this.c.setAdapter(topicTimelineAdapter);
            this.c.setLayoutManager(new LinearLayoutManager(context, 0, false));
            this.c.setItemAnimator(new DefaultItemAnimator());
            this.c.addItemDecoration(new a(this, yi.g(context, R.dimen.tbds44), yi.g(context, R.dimen.tbds20), yi.g(context, R.dimen.tbds44)));
            b();
        }
    }

    public void b() {
        int skinType;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.a) {
            return;
        }
        this.a = skinType;
        SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0105);
        this.d.notifyDataSetChanged();
    }
}
