package com.baidu.tieba.frs.entelechy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.e.e.k.b;
import b.a.e.e.p.l;
import b.a.q0.s.g0.t.c;
import b.a.r0.b0.u;
import b.a.r0.x0.b1;
import b.a.r0.x0.c1;
import b.a.r0.x0.e1;
import b.a.r0.x0.f1;
import b.a.r0.x0.k;
import b.a.r0.x0.w;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.frs.view.UserRecommendItemView;
import com.baidu.tieba.frs.view.UserRecommendLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class FrsUserRecommendAdapter extends k<w, FrsUserRecommendViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean x;
    public String y;
    public b<UserRecommendItemView> z;

    /* loaded from: classes9.dex */
    public static class FrsUserRecommendViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f48449a;

        /* renamed from: b  reason: collision with root package name */
        public FlexibleHorizontalScrollView f48450b;

        /* renamed from: c  reason: collision with root package name */
        public UserRecommendLayout f48451c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f48452d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f48453e;

        /* renamed from: f  reason: collision with root package name */
        public final String f48454f;

        /* renamed from: g  reason: collision with root package name */
        public View.OnClickListener f48455g;

        /* renamed from: h  reason: collision with root package name */
        public View.OnClickListener f48456h;

        /* loaded from: classes9.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ FrsUserRecommendViewHolder f48457e;

            public a(FrsUserRecommendViewHolder frsUserRecommendViewHolder) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {frsUserRecommendViewHolder};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48457e = frsUserRecommendViewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsUserRecommendViewHolder frsUserRecommendViewHolder;
                FlexibleHorizontalScrollView flexibleHorizontalScrollView;
                UserRecommendLayout userRecommendLayout;
                b.a.q0.s.g0.t.a j;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (flexibleHorizontalScrollView = (frsUserRecommendViewHolder = this.f48457e).f48450b) == null || (userRecommendLayout = frsUserRecommendViewHolder.f48451c) == null) {
                    return;
                }
                flexibleHorizontalScrollView.smoothScrollBy(userRecommendLayout.getChildItemWidth(), 0);
                if ((view.getTag() instanceof c) && (j = ((c) view.getTag()).j()) != null) {
                    this.f48457e.d(j.getUserId(), 2);
                }
                if (this.f48457e.f48453e) {
                    TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 9).param("fid", this.f48457e.f48454f));
                }
            }
        }

        /* loaded from: classes9.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ FrsUserRecommendViewHolder f48458e;

            public b(FrsUserRecommendViewHolder frsUserRecommendViewHolder) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {frsUserRecommendViewHolder};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48458e = frsUserRecommendViewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (view instanceof ClickableHeaderImageView) {
                        this.f48458e.d(((ClickableHeaderImageView) view).getUserId(), 1);
                    }
                    if (this.f48458e.f48453e) {
                        TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 9).param("fid", this.f48458e.f48454f));
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FrsUserRecommendViewHolder(View view, boolean z, String str) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view, Boolean.valueOf(z), str};
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
            this.f48453e = false;
            this.f48455g = new a(this);
            this.f48456h = new b(this);
            this.f48453e = z;
            this.f48454f = str;
            this.f48450b = (FlexibleHorizontalScrollView) view.findViewById(e1.user_recommend_scroll_container);
            UserRecommendLayout userRecommendLayout = (UserRecommendLayout) view.findViewById(e1.user_recommend_container);
            this.f48451c = userRecommendLayout;
            userRecommendLayout.setItemSpace(l.g(view.getContext(), c1.ds16));
            this.f48451c.setAfterLikeBtnClickListener(this.f48455g);
            this.f48451c.setAfterHeaderLickListener(this.f48456h);
            this.f48452d = (TextView) view.findViewById(e1.user_recommend_document);
            this.f48449a = (LinearLayout) view.findViewById(e1.user_recommend_root);
        }

        public final void d(String str, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) || b.a.e.e.p.k.isEmpty(str)) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c12531").param("obj_locate", i2).param("obj_id", str));
        }
    }

    /* loaded from: classes9.dex */
    public class a implements b.a.e.e.k.c<UserRecommendItemView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsUserRecommendAdapter f48459a;

        public a(FrsUserRecommendAdapter frsUserRecommendAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsUserRecommendAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48459a = frsUserRecommendAdapter;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // b.a.e.e.k.c
        public /* bridge */ /* synthetic */ UserRecommendItemView a(UserRecommendItemView userRecommendItemView) {
            UserRecommendItemView userRecommendItemView2 = userRecommendItemView;
            e(userRecommendItemView2);
            return userRecommendItemView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // b.a.e.e.k.c
        public /* bridge */ /* synthetic */ UserRecommendItemView c(UserRecommendItemView userRecommendItemView) {
            UserRecommendItemView userRecommendItemView2 = userRecommendItemView;
            h(userRecommendItemView2);
            return userRecommendItemView2;
        }

        public UserRecommendItemView e(UserRecommendItemView userRecommendItemView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, userRecommendItemView)) == null) ? userRecommendItemView : (UserRecommendItemView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.k.c
        /* renamed from: f */
        public void b(UserRecommendItemView userRecommendItemView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, userRecommendItemView) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.k.c
        /* renamed from: g */
        public UserRecommendItemView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new UserRecommendItemView(this.f48459a.f2419e) : (UserRecommendItemView) invokeV.objValue;
        }

        public UserRecommendItemView h(UserRecommendItemView userRecommendItemView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, userRecommendItemView)) == null) ? userRecommendItemView : (UserRecommendItemView) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsUserRecommendAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.x = false;
        this.z = new b<>(new a(this), 10, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: u0 */
    public FrsUserRecommendViewHolder T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            FrsUserRecommendViewHolder frsUserRecommendViewHolder = new FrsUserRecommendViewHolder(LayoutInflater.from(this.f2419e).inflate(f1.card_user_recommend_layout, viewGroup, false), this.x, this.y);
            frsUserRecommendViewHolder.f48451c.setViewPool(this.z);
            return frsUserRecommendViewHolder;
        }
        return (FrsUserRecommendViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.x0.k, b.a.e.l.e.a
    /* renamed from: v0 */
    public View Z(int i2, View view, ViewGroup viewGroup, w wVar, FrsUserRecommendViewHolder frsUserRecommendViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, wVar, frsUserRecommendViewHolder})) == null) {
            if (wVar != null) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                frsUserRecommendViewHolder.f48452d.setText(wVar.d());
                frsUserRecommendViewHolder.f48451c.setPageContext(this.o);
                frsUserRecommendViewHolder.f48451c.setData(wVar.e());
                frsUserRecommendViewHolder.f48450b.setMaxOverScrollDistance(frsUserRecommendViewHolder.f48451c.getChildItemWidth());
                frsUserRecommendViewHolder.f48452d.setTextColor(SkinManager.getColor(skinType, b1.CAM_X0106));
                frsUserRecommendViewHolder.f48449a.setBackgroundColor(SkinManager.getColor(skinType, b1.CAM_X0205));
                if (!wVar.g()) {
                    for (MetaData metaData : wVar.e()) {
                        if (metaData != null && !b.a.e.e.p.k.isEmpty(metaData.getUserId())) {
                            u.b().a(new StatisticItem("c12530").param("obj_id", metaData.getUserId()));
                        }
                    }
                    wVar.k(true);
                }
            }
            return frsUserRecommendViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void w0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.y = str;
        }
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.x = true;
        }
    }
}
