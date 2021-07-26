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
import d.a.d.e.p.l;
import d.a.p0.n.f;
import d.a.q0.e1.f.a.e.c;
import d.a.q0.e1.f.a.e.d;
import java.util.List;
/* loaded from: classes4.dex */
public class HotTopicTabRankListLayout extends RecyclerView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f16725e;

    /* renamed from: f  reason: collision with root package name */
    public a f16726f;

    /* loaded from: classes4.dex */
    public static class a extends RecyclerView.Adapter<b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<c> f16727a;

        /* renamed from: b  reason: collision with root package name */
        public f<c> f16728b;

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
        /* renamed from: d */
        public void onBindViewHolder(@NonNull b bVar, int i2) {
            List<c> list;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, bVar, i2) == null) || (list = this.f16727a) == null || list.size() <= i2) {
                return;
            }
            c cVar = list.get(i2);
            bVar.b(cVar);
            bVar.c(TbadkCoreApplication.getInst().getSkinType());
            f<c> fVar = this.f16728b;
            if (fVar != null) {
                fVar.c(bVar.itemView, cVar, i2, i2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: e */
        public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2)) == null) {
                b bVar = new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hot_topic_tab_rank_list_item, viewGroup, false));
                bVar.d(this.f16728b);
                bVar.c(TbadkCoreApplication.getInst().getSkinType());
                return bVar;
            }
            return (b) invokeLI.objValue;
        }

        public void f(f<c> fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) {
                this.f16728b = fVar;
            }
        }

        public void g(@NonNull List<c> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
                this.f16727a = list;
                notifyDataSetChanged();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                List<c> list = this.f16727a;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f16729a;

        /* renamed from: b  reason: collision with root package name */
        public View f16730b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f16731c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f16732d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f16733e;

        /* renamed from: f  reason: collision with root package name */
        public View f16734f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f16735g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f16736h;

        /* renamed from: i  reason: collision with root package name */
        public f<c> f16737i;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f16738e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f16739f;

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
                this.f16739f = bVar;
                this.f16738e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", "all").start();
                    if (this.f16739f.f16737i != null) {
                        int adapterPosition = this.f16739f.getAdapterPosition();
                        this.f16739f.f16737i.a(view, this.f16738e, adapterPosition, adapterPosition);
                    }
                }
            }
        }

        /* renamed from: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC0202b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f16740e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f16741f;

            public View$OnClickListenerC0202b(b bVar, c cVar) {
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
                this.f16741f = bVar;
                this.f16740e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    HotTopicActivityConfig hotTopicActivityConfig = new HotTopicActivityConfig(view.getContext());
                    hotTopicActivityConfig.createNormalConfig("" + this.f16740e.f55934a, null, "3").start();
                    if (this.f16741f.f16737i != null) {
                        int adapterPosition = this.f16741f.getAdapterPosition();
                        this.f16741f.f16737i.a(view, this.f16740e, adapterPosition, adapterPosition);
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
            this.f16729a = 3;
            this.f16730b = view.findViewById(R.id.itemLayout);
            this.f16731c = (TextView) view.findViewById(R.id.indexView);
            this.f16732d = (TextView) view.findViewById(R.id.titleView);
            this.f16733e = (TextView) view.findViewById(R.id.tagView);
            this.f16734f = view.findViewById(R.id.moreLayout);
            this.f16735g = (TextView) view.findViewById(R.id.moreText);
            this.f16736h = (ImageView) view.findViewById(R.id.moreIcon);
        }

        public void b(c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null) {
                return;
            }
            if (cVar.f55938e) {
                this.f16730b.setVisibility(8);
                this.f16734f.setVisibility(0);
                this.f16734f.setOnClickListener(new a(this, cVar));
                return;
            }
            this.f16730b.setVisibility(0);
            this.f16730b.setOnClickListener(new View$OnClickListenerC0202b(this, cVar));
            this.f16734f.setVisibility(8);
            int i2 = cVar.f55937d;
            if (i2 > 0) {
                this.f16731c.setText(String.valueOf(i2));
                this.f16731c.setVisibility(0);
            } else {
                this.f16731c.setVisibility(8);
            }
            this.f16732d.setText(cVar.f55935b);
            String hotTopicTagStr = TagTextHelper.getHotTopicTagStr(this.f16733e.getContext(), cVar.f55936c);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f16732d.getLayoutParams();
            if (TextUtils.isEmpty(hotTopicTagStr)) {
                this.f16733e.setVisibility(8);
                marginLayoutParams.rightMargin = l.g(this.f16733e.getContext(), R.dimen.tbds22);
                this.f16732d.setLayoutParams(marginLayoutParams);
            } else {
                marginLayoutParams.rightMargin = l.g(this.f16733e.getContext(), R.dimen.tbds74);
                this.f16732d.setLayoutParams(marginLayoutParams);
                this.f16733e.setVisibility(0);
                this.f16733e.setText(hotTopicTagStr);
            }
            int indexTextColorRes = TagTextHelper.getIndexTextColorRes(cVar.f55937d);
            d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(this.f16731c);
            d2.n(R.string.J_X04);
            d2.f(indexTextColorRes);
            int hotTopicTagColorRes = TagTextHelper.getHotTopicTagColorRes(cVar.f55936c);
            d.a.p0.s.u.c d3 = d.a.p0.s.u.c.d(this.f16733e);
            d3.n(R.string.J_X04);
            d3.e(R.string.A_X12);
            d3.f(hotTopicTagColorRes);
        }

        public void c(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f16729a == i2) {
                return;
            }
            int i3 = R.color.CAM_X0204;
            TBSelector.setViewBackgroundColorWithPressedState(this.f16730b, R.color.CAM_X0205, i3);
            TBSelector.setViewBackgroundColorWithPressedState(this.f16734f, R.color.CAM_X0205, i3);
            SkinManager.setViewTextColor(this.f16732d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f16733e, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f16731c, R.color.CAM_X0101);
            if (this.f16734f.getVisibility() == 0) {
                SkinManager.setViewTextColor(this.f16735g, R.color.CAM_X0304);
                int color = SkinManager.getColor(R.color.CAM_X0304);
                Drawable drawable = this.f16736h.getDrawable();
                DrawableCompat.setTint(drawable, color);
                this.f16736h.setImageDrawable(drawable);
            }
            this.f16729a = i2;
        }

        public void d(f<c> fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) {
                this.f16737i = fVar;
            }
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
        this.f16725e = 3;
        c();
    }

    public void b(d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) || dVar == null || dVar.c() == null) {
            return;
        }
        this.f16726f.g(dVar.c());
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setLayoutManager(new GridLayoutManager(getContext(), 2));
            setOverScrollMode(2);
            a aVar = new a();
            this.f16726f = aVar;
            setAdapter(aVar);
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f16725e == i2) {
            return;
        }
        this.f16726f.notifyDataSetChanged();
        this.f16725e = i2;
    }

    public void setOnItemCoverListener(f<c> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f16726f.f(fVar);
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
        this.f16725e = 3;
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
        this.f16725e = 3;
        c();
    }
}
