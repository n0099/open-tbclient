package com.baidu.tieba.frs.entelechy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
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
import com.baidu.tieba.R;
import com.baidu.tieba.frs.view.UserRecommendItemView;
import com.baidu.tieba.frs.view.UserRecommendLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.aw4;
import com.repackage.bd6;
import com.repackage.bg;
import com.repackage.cg;
import com.repackage.li;
import com.repackage.mi;
import com.repackage.nx5;
import com.repackage.pc6;
import com.repackage.yv4;
/* loaded from: classes3.dex */
public class FrsUserRecommendAdapter extends pc6<bd6, FrsUserRecommendViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean t;
    public String u;
    public bg<UserRecommendItemView> v;

    /* loaded from: classes3.dex */
    public static class FrsUserRecommendViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout a;
        public FlexibleHorizontalScrollView b;
        public UserRecommendLayout c;
        public TextView d;
        public boolean e;
        public final String f;
        public View.OnClickListener g;
        public View.OnClickListener h;

        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FrsUserRecommendViewHolder a;

            public a(FrsUserRecommendViewHolder frsUserRecommendViewHolder) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {frsUserRecommendViewHolder};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = frsUserRecommendViewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FrsUserRecommendViewHolder frsUserRecommendViewHolder;
                FlexibleHorizontalScrollView flexibleHorizontalScrollView;
                UserRecommendLayout userRecommendLayout;
                yv4 j;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (flexibleHorizontalScrollView = (frsUserRecommendViewHolder = this.a).b) == null || (userRecommendLayout = frsUserRecommendViewHolder.c) == null) {
                    return;
                }
                flexibleHorizontalScrollView.smoothScrollBy(userRecommendLayout.getChildItemWidth(), 0);
                if ((view2.getTag() instanceof aw4) && (j = ((aw4) view2.getTag()).j()) != null) {
                    this.a.f(j.getUserId(), 2);
                }
                if (this.a.e) {
                    TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 9).param("fid", this.a.f));
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FrsUserRecommendViewHolder a;

            public b(FrsUserRecommendViewHolder frsUserRecommendViewHolder) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {frsUserRecommendViewHolder};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = frsUserRecommendViewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    if (view2 instanceof ClickableHeaderImageView) {
                        this.a.f(((ClickableHeaderImageView) view2).getUserId(), 1);
                    }
                    if (this.a.e) {
                        TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 9).param("fid", this.a.f));
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FrsUserRecommendViewHolder(View view2, boolean z, String str) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = false;
            this.g = new a(this);
            this.h = new b(this);
            this.e = z;
            this.f = str;
            this.b = (FlexibleHorizontalScrollView) view2.findViewById(R.id.obfuscated_res_0x7f092309);
            UserRecommendLayout userRecommendLayout = (UserRecommendLayout) view2.findViewById(R.id.obfuscated_res_0x7f092303);
            this.c = userRecommendLayout;
            userRecommendLayout.setItemSpace(mi.f(view2.getContext(), R.dimen.obfuscated_res_0x7f0701be));
            this.c.setAfterLikeBtnClickListener(this.g);
            this.c.setAfterHeaderLickListener(this.h);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092304);
            this.a = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f092308);
        }

        public final void f(String str, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) || li.isEmpty(str)) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c12531").param("obj_locate", i).param("obj_id", str));
        }
    }

    /* loaded from: classes3.dex */
    public class a implements cg<UserRecommendItemView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsUserRecommendAdapter a;

        public a(FrsUserRecommendAdapter frsUserRecommendAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsUserRecommendAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsUserRecommendAdapter;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.cg
        public /* bridge */ /* synthetic */ UserRecommendItemView a(UserRecommendItemView userRecommendItemView) {
            UserRecommendItemView userRecommendItemView2 = userRecommendItemView;
            e(userRecommendItemView2);
            return userRecommendItemView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.cg
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
        @Override // com.repackage.cg
        /* renamed from: f */
        public void b(UserRecommendItemView userRecommendItemView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, userRecommendItemView) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.cg
        /* renamed from: g */
        public UserRecommendItemView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new UserRecommendItemView(this.a.a) : (UserRecommendItemView) invokeV.objValue;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = false;
        this.v = new bg<>(new a(this), 10, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: m0 */
    public FrsUserRecommendViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            FrsUserRecommendViewHolder frsUserRecommendViewHolder = new FrsUserRecommendViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d01c2, viewGroup, false), this.t, this.u);
            frsUserRecommendViewHolder.c.setViewPool(this.v);
            return frsUserRecommendViewHolder;
        }
        return (FrsUserRecommendViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.pc6, com.repackage.eo
    /* renamed from: n0 */
    public View S(int i, View view2, ViewGroup viewGroup, bd6 bd6Var, FrsUserRecommendViewHolder frsUserRecommendViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, bd6Var, frsUserRecommendViewHolder})) == null) {
            if (bd6Var != null) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                frsUserRecommendViewHolder.d.setText(bd6Var.b());
                frsUserRecommendViewHolder.c.setPageContext(this.k);
                frsUserRecommendViewHolder.c.setData(bd6Var.e());
                frsUserRecommendViewHolder.b.setMaxOverScrollDistance(frsUserRecommendViewHolder.c.getChildItemWidth());
                frsUserRecommendViewHolder.d.setTextColor(SkinManager.getColor(skinType, (int) R.color.CAM_X0106));
                frsUserRecommendViewHolder.a.setBackgroundColor(SkinManager.getColor(skinType, (int) R.color.CAM_X0205));
                if (!bd6Var.f()) {
                    for (MetaData metaData : bd6Var.e()) {
                        if (metaData != null && !li.isEmpty(metaData.getUserId())) {
                            nx5.b().a(new StatisticItem("c12530").param("obj_id", metaData.getUserId()));
                        }
                    }
                    bd6Var.j(true);
                }
            }
            return frsUserRecommendViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public void o0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.u = str;
        }
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.t = true;
        }
    }
}
