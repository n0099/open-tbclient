package com.baidu.tieba.faceshop.forumpackage.adapter;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.forumpackage.view.ForumEmotionEmptyView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ForumEmotionEmptyViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ForumEmotionEmptyView f50514a;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.q0.y.b.b f50515e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.q0.y.a.a f50516f;

        public a(ForumEmotionEmptyViewHolder forumEmotionEmptyViewHolder, c.a.q0.q0.y.b.b bVar, c.a.q0.q0.y.a.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumEmotionEmptyViewHolder, bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50515e = bVar;
            this.f50516f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.q0.q0.y.b.b bVar = this.f50515e;
                bVar.c(!bVar.b());
                c.a.q0.q0.y.a.a aVar = this.f50516f;
                if (aVar != null) {
                    aVar.b();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.q0.y.b.b f50517e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.q0.y.a.a f50518f;

        public b(ForumEmotionEmptyViewHolder forumEmotionEmptyViewHolder, c.a.q0.q0.y.b.b bVar, c.a.q0.q0.y.a.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumEmotionEmptyViewHolder, bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50517e = bVar;
            this.f50518f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f50517e.c(false);
                this.f50517e.d(0);
                c.a.q0.q0.y.a.a aVar = this.f50518f;
                if (aVar != null) {
                    aVar.a(this.f50517e.a());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.q0.y.b.b f50519e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.q0.y.a.a f50520f;

        public c(ForumEmotionEmptyViewHolder forumEmotionEmptyViewHolder, c.a.q0.q0.y.b.b bVar, c.a.q0.q0.y.a.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumEmotionEmptyViewHolder, bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50519e = bVar;
            this.f50520f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f50519e.c(false);
                this.f50519e.d(1);
                c.a.q0.q0.y.a.a aVar = this.f50520f;
                if (aVar != null) {
                    aVar.a(this.f50519e.a());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumEmotionEmptyViewHolder(TbPageContext tbPageContext, View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view};
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
        this.f50514a = (ForumEmotionEmptyView) view;
    }

    public final void a(c.a.q0.q0.y.b.b bVar, c.a.q0.q0.y.a.a aVar) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, aVar) == null) {
            ViewGroup filterDropDownView = this.f50514a.getFilterDropDownView();
            if (bVar != null) {
                Resources resources = this.f50514a.getResources();
                TextView filterView = this.f50514a.getFilterView();
                filterDropDownView.setVisibility(0);
                if (bVar.a() == 0) {
                    string = resources.getString(R.string.forum_emotion_filter_all_bar);
                } else {
                    string = resources.getString(R.string.forum_emotion_filter_my_bar);
                }
                filterView.setText(string);
                if (bVar.b()) {
                    filterDropDownView.setVisibility(0);
                } else {
                    filterDropDownView.setVisibility(8);
                }
                filterView.setOnClickListener(new a(this, bVar, aVar));
                if (filterDropDownView.getChildCount() >= 2) {
                    filterDropDownView.getChildAt(0).setOnClickListener(new b(this, bVar, aVar));
                    filterDropDownView.getChildAt(1).setOnClickListener(new c(this, bVar, aVar));
                }
            }
        }
    }

    public void setData(c.a.q0.q0.y.b.a aVar, int i2, c.a.q0.q0.y.b.b bVar, c.a.q0.q0.y.a.a aVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, i2, bVar, aVar2) == null) {
            a(bVar, aVar2);
        }
    }
}
