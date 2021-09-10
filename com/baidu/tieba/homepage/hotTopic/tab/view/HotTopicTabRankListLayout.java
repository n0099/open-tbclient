package com.baidu.tieba.homepage.hotTopic.tab.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.e.e.p.l;
import c.a.q0.n.f;
import c.a.r0.g1.f.a.e.c;
import c.a.r0.g1.f.a.e.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TagTextHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class HotTopicTabRankListLayout extends RecyclerView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f52241e;

    /* renamed from: f  reason: collision with root package name */
    public a f52242f;

    /* loaded from: classes7.dex */
    public static class a extends RecyclerView.Adapter<b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<c> f52243a;

        /* renamed from: b  reason: collision with root package name */
        public f<c> f52244b;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(@NonNull b bVar, int i2) {
            List<c> list;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, bVar, i2) == null) || (list = this.f52243a) == null || list.size() <= i2) {
                return;
            }
            c cVar = list.get(i2);
            bVar.b(cVar);
            bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            f<c> fVar = this.f52244b;
            if (fVar != null) {
                fVar.c(bVar.itemView, cVar, i2, i2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: c */
        public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2)) == null) {
                b bVar = new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hot_topic_tab_rank_list_item, viewGroup, false));
                bVar.c(this.f52244b);
                bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                return bVar;
            }
            return (b) invokeLI.objValue;
        }

        public void d(@NonNull List<c> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
                this.f52243a = list;
                notifyDataSetChanged();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                List<c> list = this.f52243a;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }
            return invokeV.intValue;
        }

        public void setOnItemCoverListener(f<c> fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
                this.f52244b = fVar;
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f52245a;

        /* renamed from: b  reason: collision with root package name */
        public View f52246b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f52247c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f52248d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f52249e;

        /* renamed from: f  reason: collision with root package name */
        public View f52250f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f52251g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f52252h;

        /* renamed from: i  reason: collision with root package name */
        public f<c> f52253i;

        /* loaded from: classes7.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f52254e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f52255f;

            public a(b bVar, c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f52255f = bVar;
                this.f52254e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", "all").start();
                    if (this.f52255f.f52253i != null) {
                        int adapterPosition = this.f52255f.getAdapterPosition();
                        this.f52255f.f52253i.a(view, this.f52254e, adapterPosition, adapterPosition);
                    }
                }
            }
        }

        /* renamed from: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class View$OnClickListenerC1761b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f52256e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f52257f;

            public View$OnClickListenerC1761b(b bVar, c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f52257f = bVar;
                this.f52256e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    HotTopicActivityConfig hotTopicActivityConfig = new HotTopicActivityConfig(view.getContext());
                    hotTopicActivityConfig.createNormalConfig("" + this.f52256e.f18097a, null, "3").start();
                    if (this.f52257f.f52253i != null) {
                        int adapterPosition = this.f52257f.getAdapterPosition();
                        this.f52257f.f52253i.a(view, this.f52256e, adapterPosition, adapterPosition);
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52245a = 3;
            this.f52246b = view.findViewById(R.id.itemLayout);
            this.f52247c = (TextView) view.findViewById(R.id.indexView);
            this.f52248d = (TextView) view.findViewById(R.id.titleView);
            this.f52249e = (TextView) view.findViewById(R.id.tagView);
            this.f52250f = view.findViewById(R.id.moreLayout);
            this.f52251g = (TextView) view.findViewById(R.id.moreText);
            this.f52252h = (ImageView) view.findViewById(R.id.moreIcon);
        }

        public void b(c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null) {
                return;
            }
            if (cVar.f18101e) {
                this.f52246b.setVisibility(8);
                this.f52250f.setVisibility(0);
                this.f52250f.setOnClickListener(new a(this, cVar));
                return;
            }
            this.f52246b.setVisibility(0);
            this.f52246b.setOnClickListener(new View$OnClickListenerC1761b(this, cVar));
            this.f52250f.setVisibility(8);
            int i2 = cVar.f18100d;
            if (i2 > 0) {
                this.f52247c.setText(String.valueOf(i2));
                this.f52247c.setVisibility(0);
            } else {
                this.f52247c.setVisibility(8);
            }
            this.f52248d.setText(cVar.f18098b);
            String hotTopicTagStr = TagTextHelper.getHotTopicTagStr(this.f52249e.getContext(), cVar.f18099c);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f52248d.getLayoutParams();
            if (TextUtils.isEmpty(hotTopicTagStr)) {
                this.f52249e.setVisibility(8);
                marginLayoutParams.rightMargin = l.g(this.f52249e.getContext(), R.dimen.tbds22);
                this.f52248d.setLayoutParams(marginLayoutParams);
            } else {
                marginLayoutParams.rightMargin = l.g(this.f52249e.getContext(), R.dimen.tbds74);
                this.f52248d.setLayoutParams(marginLayoutParams);
                this.f52249e.setVisibility(0);
                this.f52249e.setText(hotTopicTagStr);
            }
            int indexTextColorRes = TagTextHelper.getIndexTextColorRes(cVar.f18100d);
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.f52247c);
            d2.o(R.string.J_X04);
            d2.f(indexTextColorRes);
            int hotTopicTagColorRes = TagTextHelper.getHotTopicTagColorRes(cVar.f18099c);
            c.a.q0.s.u.c d3 = c.a.q0.s.u.c.d(this.f52249e);
            d3.o(R.string.J_X04);
            d3.e(R.string.A_X12);
            d3.f(hotTopicTagColorRes);
        }

        public void c(f<c> fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
                this.f52253i = fVar;
            }
        }

        public void onChangeSkinType(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f52245a == i2) {
                return;
            }
            int i3 = R.color.CAM_X0204;
            TBSelector.setViewBackgroundColorWithPressedState(this.f52246b, R.color.CAM_X0205, i3);
            TBSelector.setViewBackgroundColorWithPressedState(this.f52250f, R.color.CAM_X0205, i3);
            SkinManager.setViewTextColor(this.f52248d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f52249e, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f52247c, R.color.CAM_X0101);
            if (this.f52250f.getVisibility() == 0) {
                SkinManager.setViewTextColor(this.f52251g, R.color.CAM_X0304);
                int color = SkinManager.getColor(R.color.CAM_X0304);
                Drawable drawable = this.f52252h.getDrawable();
                DrawableCompat.setTint(drawable, color);
                this.f52252h.setImageDrawable(drawable);
            }
            this.f52245a = i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicTabRankListLayout(Context context) {
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
        this.f52241e = 3;
        c();
    }

    public void bindData(d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) || dVar == null || dVar.g() == null) {
            return;
        }
        this.f52242f.d(dVar.g());
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setLayoutManager(new GridLayoutManager(getContext(), 2));
            setOverScrollMode(2);
            a aVar = new a();
            this.f52242f = aVar;
            setAdapter(aVar);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f52241e == i2) {
            return;
        }
        this.f52242f.notifyDataSetChanged();
        this.f52241e = i2;
    }

    public void setOnItemCoverListener(f<c> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f52242f.setOnItemCoverListener(fVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicTabRankListLayout(Context context, @Nullable AttributeSet attributeSet) {
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
        this.f52241e = 3;
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicTabRankListLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f52241e = 3;
        c();
    }
}
