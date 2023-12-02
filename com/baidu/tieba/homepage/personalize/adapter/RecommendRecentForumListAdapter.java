package com.baidu.tieba.homepage.personalize.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.homepage.personalize.adapter.RecommendRecentForumListAdapter;
import com.baidu.tieba.homepage.personalize.view.HomePageRecentForumItemLayout;
import com.baidu.tieba.rd;
import com.baidu.tieba.sh8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class RecommendRecentForumListAdapter extends RecyclerView.Adapter<RecentForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public List<sh8> b;

    /* loaded from: classes6.dex */
    public class RecentForumViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HomePageRecentForumItemLayout a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RecentForumViewHolder(RecommendRecentForumListAdapter recommendRecentForumListAdapter, HomePageRecentForumItemLayout homePageRecentForumItemLayout) {
            super(homePageRecentForumItemLayout);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendRecentForumListAdapter, homePageRecentForumItemLayout};
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
            this.a = homePageRecentForumItemLayout;
        }
    }

    public RecommendRecentForumListAdapter(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
    }

    public void setData(List<sh8> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            this.b.clear();
            this.b.addAll(list);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return ListUtils.getCount(this.b);
        }
        return invokeV.intValue;
    }

    public /* synthetic */ void l(sh8 sh8Var, int i, View view2) {
        if (sh8Var != null && !rd.isEmpty(sh8Var.g())) {
            UrlManager.getInstance().dealOneLink(this.a, new String[]{sh8Var.g()});
            p("c15376", i + 1, sh8Var.b(), sh8Var.d(), sh8Var.j());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n */
    public void onBindViewHolder(@NonNull RecentForumViewHolder recentForumViewHolder, final int i) {
        final sh8 sh8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, recentForumViewHolder, i) != null) || ListUtils.isEmpty(this.b) || ListUtils.getCount(this.b) <= i || (sh8Var = this.b.get(i)) == null) {
            return;
        }
        sh8Var.o(i + 1);
        recentForumViewHolder.a.setData(sh8Var);
        recentForumViewHolder.a.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.zf8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    RecommendRecentForumListAdapter.this.l(sh8Var, i, view2);
                }
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: o */
    public RecentForumViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, viewGroup, i)) == null) {
            return new RecentForumViewHolder(this, new HomePageRecentForumItemLayout(this.a.getPageActivity()));
        }
        return (RecentForumViewHolder) invokeLI.objValue;
    }

    public final void p(String str, int i, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, Integer.valueOf(i), str2, str3, Boolean.valueOf(z)}) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", str2);
            statisticItem.param("obj_type", str3);
            statisticItem.param("obj_locate", i);
            statisticItem.param("obj_source", z ? 1 : 0);
            TiebaStatic.log(statisticItem);
        }
    }
}
