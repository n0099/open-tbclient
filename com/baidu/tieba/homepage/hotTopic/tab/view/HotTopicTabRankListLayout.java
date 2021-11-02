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
import b.a.e.e.p.l;
import b.a.q0.n.f;
import b.a.r0.h1.f.a.e.c;
import b.a.r0.h1.f.a.e.d;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TagTextHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.module.hottopic.HotTopicStat;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes9.dex */
public class HotTopicTabRankListLayout extends RecyclerView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f49587e;

    /* renamed from: f  reason: collision with root package name */
    public a f49588f;

    /* loaded from: classes9.dex */
    public static class a extends RecyclerView.Adapter<b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<c> f49589a;

        /* renamed from: b  reason: collision with root package name */
        public f<c> f49590b;

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
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, bVar, i2) == null) || (list = this.f49589a) == null || list.size() <= i2) {
                return;
            }
            c cVar = list.get(i2);
            bVar.b(cVar);
            bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            f<c> fVar = this.f49590b;
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
                bVar.c(this.f49590b);
                bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                return bVar;
            }
            return (b) invokeLI.objValue;
        }

        public void d(@NonNull List<c> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
                this.f49589a = list;
                notifyDataSetChanged();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                List<c> list = this.f49589a;
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
                this.f49590b = fVar;
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f49591a;

        /* renamed from: b  reason: collision with root package name */
        public View f49592b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f49593c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f49594d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f49595e;

        /* renamed from: f  reason: collision with root package name */
        public View f49596f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f49597g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f49598h;

        /* renamed from: i  reason: collision with root package name */
        public f<c> f49599i;

        /* loaded from: classes9.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f49600e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f49601f;

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
                this.f49601f = bVar;
                this.f49600e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", "all").start();
                    if (this.f49601f.f49599i != null) {
                        int adapterPosition = this.f49601f.getAdapterPosition();
                        this.f49601f.f49599i.a(view, this.f49600e, adapterPosition, adapterPosition);
                    }
                }
            }
        }

        /* renamed from: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout$b$b  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class View$OnClickListenerC1724b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f49602e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f49603f;

            public View$OnClickListenerC1724b(b bVar, c cVar) {
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
                this.f49603f = bVar;
                this.f49602e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    String tryFixDefaultValue = StringUtils.tryFixDefaultValue(String.valueOf(this.f49602e.f17214a));
                    String tryFixDefaultValue2 = StringUtils.tryFixDefaultValue(this.f49602e.f17215b);
                    HotTopicStat.Locate locate = HotTopicStat.Locate.HOT_RANK;
                    if (this.f49602e.b()) {
                        HotTopicStat.a(tryFixDefaultValue, tryFixDefaultValue2, locate, null, null);
                    }
                    new HotTopicActivityConfig(view.getContext()).createNormalConfig(tryFixDefaultValue, null, String.valueOf(this.f49602e.a()), "3", locate).start();
                    if (this.f49603f.f49599i != null) {
                        int adapterPosition = this.f49603f.getAdapterPosition();
                        this.f49603f.f49599i.a(view, this.f49602e, adapterPosition, adapterPosition);
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
            this.f49591a = 3;
            this.f49592b = view.findViewById(R.id.itemLayout);
            this.f49593c = (TextView) view.findViewById(R.id.indexView);
            this.f49594d = (TextView) view.findViewById(R.id.titleView);
            this.f49595e = (TextView) view.findViewById(R.id.tagView);
            this.f49596f = view.findViewById(R.id.moreLayout);
            this.f49597g = (TextView) view.findViewById(R.id.moreText);
            this.f49598h = (ImageView) view.findViewById(R.id.moreIcon);
        }

        public void b(c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null) {
                return;
            }
            if (cVar.f17218e) {
                this.f49592b.setVisibility(8);
                this.f49596f.setVisibility(0);
                this.f49596f.setOnClickListener(new a(this, cVar));
                return;
            }
            this.f49592b.setVisibility(0);
            this.f49592b.setOnClickListener(new View$OnClickListenerC1724b(this, cVar));
            this.f49596f.setVisibility(8);
            int i2 = cVar.f17217d;
            if (i2 > 0) {
                this.f49593c.setText(String.valueOf(i2));
                this.f49593c.setVisibility(0);
            } else {
                this.f49593c.setVisibility(8);
            }
            this.f49594d.setText(cVar.f17215b);
            String hotTopicTagStr = TagTextHelper.getHotTopicTagStr(this.f49595e.getContext(), cVar.f17216c);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f49594d.getLayoutParams();
            if (TextUtils.isEmpty(hotTopicTagStr)) {
                this.f49595e.setVisibility(8);
                marginLayoutParams.rightMargin = l.g(this.f49595e.getContext(), R.dimen.tbds22);
                this.f49594d.setLayoutParams(marginLayoutParams);
            } else {
                marginLayoutParams.rightMargin = l.g(this.f49595e.getContext(), R.dimen.tbds74);
                this.f49594d.setLayoutParams(marginLayoutParams);
                this.f49595e.setVisibility(0);
                this.f49595e.setText(hotTopicTagStr);
            }
            int indexTextColorRes = TagTextHelper.getIndexTextColorRes(cVar.f17217d);
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this.f49593c);
            d2.n(R.string.J_X04);
            d2.f(indexTextColorRes);
            int hotTopicTagColorRes = TagTextHelper.getHotTopicTagColorRes(cVar.f17216c);
            b.a.q0.s.u.c d3 = b.a.q0.s.u.c.d(this.f49595e);
            d3.n(R.string.J_X04);
            d3.e(R.string.A_X12);
            d3.f(hotTopicTagColorRes);
        }

        public void c(f<c> fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
                this.f49599i = fVar;
            }
        }

        public void onChangeSkinType(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f49591a == i2) {
                return;
            }
            int i3 = R.color.CAM_X0204;
            TBSelector.setViewBackgroundColorWithPressedState(this.f49592b, R.color.CAM_X0205, i3);
            TBSelector.setViewBackgroundColorWithPressedState(this.f49596f, R.color.CAM_X0205, i3);
            SkinManager.setViewTextColor(this.f49594d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f49595e, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f49593c, R.color.CAM_X0101);
            if (this.f49596f.getVisibility() == 0) {
                SkinManager.setViewTextColor(this.f49597g, R.color.CAM_X0304);
                int color = SkinManager.getColor(R.color.CAM_X0304);
                Drawable drawable = this.f49598h.getDrawable();
                DrawableCompat.setTint(drawable, color);
                this.f49598h.setImageDrawable(drawable);
            }
            this.f49591a = i2;
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
        this.f49587e = 3;
        c();
    }

    public void bindData(d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) || dVar == null || dVar.g() == null) {
            return;
        }
        this.f49588f.d(dVar.g());
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setLayoutManager(new GridLayoutManager(getContext(), 2));
            setOverScrollMode(2);
            a aVar = new a();
            this.f49588f = aVar;
            setAdapter(aVar);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f49587e == i2) {
            return;
        }
        this.f49588f.notifyDataSetChanged();
        this.f49587e = i2;
    }

    public void setOnItemCoverListener(f<c> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f49588f.setOnItemCoverListener(fVar);
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
        this.f49587e = 3;
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
        this.f49587e = 3;
        c();
    }
}
