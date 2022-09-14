package com.baidu.tieba.enterForum.hotuserrank;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.e96;
import com.baidu.tieba.ej;
import com.baidu.tieba.enterForum.hotuserrank.view.HotUserRankLikeButton;
import com.baidu.tieba.enterForum.hotuserrank.view.UserHeadCoverView;
import com.baidu.tieba.ez4;
import com.baidu.tieba.g96;
import com.baidu.tieba.h96;
import com.baidu.tieba.view.DynamicUserLikeButton;
import com.baidu.tieba.wh5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class RankListViewController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdRecyclerView a;
    public List<h96> b;
    public e96 c;
    public PbListView d;
    public String e;
    public long f;
    public BdRecyclerView.i g;
    public RecyclerView.Adapter h;

    /* loaded from: classes3.dex */
    public static class RankListViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public HeadImageView b;
        public UserHeadCoverView c;
        public TextView d;
        public TextView e;
        public ImageView f;
        public TextView g;
        public HotUserRankLikeButton h;
        public ez4 i;
        public TbPageContext j;
        public int k;
        public String l;
        public long m;
        public int n;
        public boolean o;

        /* loaded from: classes3.dex */
        public class a implements DynamicUserLikeButton.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h96 a;
            public final /* synthetic */ RankListViewHolder b;

            public a(RankListViewHolder rankListViewHolder, h96 h96Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {rankListViewHolder, h96Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = rankListViewHolder;
                this.a = h96Var;
            }

            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void a(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    if (!TextUtils.isEmpty(this.b.l)) {
                        StatisticItem statisticItem = new StatisticItem("c13661");
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.b.l);
                        statisticItem.param(TiebaStatic.Params.FRIEND_UID, this.a.a);
                        statisticItem.param("obj_type", this.a.f.getIsLike() ? 2 : 1);
                        TiebaStatic.log(statisticItem);
                        return;
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13672");
                    statisticItem2.param("obj_id", this.a.f.getUserId());
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param(TiebaStatic.Params.RESOURCE_ID, this.b.l);
                    statisticItem2.param("fid", this.b.m);
                    statisticItem2.param(TiebaStatic.Params.FRIEND_UID, this.a.a);
                    statisticItem2.param("obj_type", this.a.f.getIsLike() ? 2 : 1);
                    TiebaStatic.log(statisticItem2);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RankListViewHolder(View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
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
            this.k = 3;
            this.l = "";
            this.n = 0;
            this.j = d(view2.getContext());
            TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b50);
            this.a = textView;
            textView.getPaint().setFakeBoldText(true);
            HeadImageView headImageView = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f090d2d);
            this.b = headImageView;
            headImageView.setIsRound(true);
            this.b.setPlaceHolder(1);
            this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.c = (UserHeadCoverView) view2.findViewById(R.id.obfuscated_res_0x7f090d2c);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924b4);
            this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924ae);
            this.f = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090ce7);
            this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924a8);
            this.h = (HotUserRankLikeButton) view2.findViewById(R.id.obfuscated_res_0x7f0912ff);
        }

        public void c(h96 h96Var) {
            int i;
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, h96Var) == null) || h96Var == null) {
                return;
            }
            if (!TextUtils.isEmpty(h96Var.a)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.getLayoutParams();
                int dimension = (int) this.j.getResources().getDimension(R.dimen.tbds44);
                this.a.setText(h96Var.a);
                if (this.n == 1) {
                    dimension = (int) this.j.getResources().getDimension(R.dimen.tbds26);
                    layoutParams.width = (int) this.j.getResources().getDimension(R.dimen.tbds129);
                }
                layoutParams.setMargins(dimension, 0, 0, 0);
                this.a.setLayoutParams(layoutParams);
            }
            if ("1".equals(this.a.getText())) {
                i = R.color.CAM_X0314;
            } else if ("2".equals(this.a.getText())) {
                i = R.color.CAM_X0315;
            } else {
                i = "3".equals(this.a.getText()) ? R.color.CAM_X0316 : R.color.CAM_X0105;
            }
            SkinManager.setViewTextColor(this.a, i);
            this.b.K(h96Var.b, 10, false);
            this.c.setData(h96Var);
            String str = h96Var.c;
            if (wh5.d(str) > 12) {
                str = wh5.n(str, 10) + StringHelper.STRING_MORE;
            }
            this.d.setText(str);
            boolean z = h96Var.h;
            this.o = z;
            if (z) {
                SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0301);
            }
            if (TextUtils.isEmpty(h96Var.d)) {
                this.e.setVisibility(8);
            } else {
                this.e.setVisibility(0);
                this.e.setText(StringHelper.cutStringWithEllipsisStrict(h96Var.d, 26));
            }
            if (h96Var.f.getLevel_id() == 0) {
                this.f.setVisibility(8);
            } else {
                this.f.setVisibility(0);
                SkinManager.setImageResource(this.f, BitmapHelper.getGradeResourceIdInEnterForum(h96Var.f.getLevel_id()));
            }
            if (TextUtils.isEmpty(h96Var.e)) {
                this.g.setVisibility(8);
            } else {
                this.g.setVisibility(0);
                this.g.setText(h96Var.e);
            }
            if (this.i == null && (tbPageContext = this.j) != null) {
                ez4 ez4Var = new ez4(tbPageContext, this.h);
                this.i = ez4Var;
                ez4Var.l(this.j.getUniqueId());
            }
            this.i.n(h96Var.f);
            this.h.setOnClickEvent(new a(this, h96Var));
            MetaData metaData = h96Var.f;
            if (metaData != null && metaData.getUserId() != null && h96Var.f.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.h.setVisibility(8);
            } else {
                this.h.setVisibility(0);
            }
            f(TbadkCoreApplication.getInst().getSkinType());
        }

        public final TbPageContext d(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                if (context instanceof BaseActivity) {
                    return ((BaseActivity) context).getPageContext();
                }
                if (context instanceof BaseFragmentActivity) {
                    return ((BaseFragmentActivity) context).getPageContext();
                }
                return null;
            }
            return (TbPageContext) invokeL.objValue;
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.e.setVisibility(8);
                this.h.setVisibility(8);
            }
        }

        public void f(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || this.k == i) {
                return;
            }
            this.k = i;
            if (!this.o) {
                SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
            } else {
                SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0301);
            }
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0109);
            this.h.r(this.k);
        }

        public void g(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.l = str;
            }
        }

        public void h(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
                this.m = j;
            }
        }

        public void i(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
                this.n = i;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a implements BdRecyclerView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RankListViewController a;

        public a(RankListViewController rankListViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rankListViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rankListViewController;
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
        public void b(ViewGroup viewGroup, View view2, Object obj, int i, long j) {
            h96 h96Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view2, obj, Integer.valueOf(i), Long.valueOf(j)}) == null) || (h96Var = (h96) this.a.b.get(i)) == null || h96Var.f == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.a.getContext(), h96Var.f.getUserId(), h96Var.f.getName_show())));
            if (!TextUtils.isEmpty(this.a.e)) {
                StatisticItem statisticItem = new StatisticItem("c13660");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.a.e);
                statisticItem.param(TiebaStatic.Params.FRIEND_UID, h96Var.a);
                TiebaStatic.log(statisticItem);
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("c13668");
            statisticItem2.param("uid", h96Var.f.getUserId());
            statisticItem2.param("fid", this.a.f);
            TiebaStatic.log(statisticItem2);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends RecyclerView.Adapter<RankListViewHolder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RankListViewController a;

        public b(RankListViewController rankListViewController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rankListViewController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rankListViewController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: d */
        public void onBindViewHolder(RankListViewHolder rankListViewHolder, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, rankListViewHolder, i) == null) {
                rankListViewHolder.c((h96) this.a.b.get(i));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: e */
        public RankListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i)) == null) {
                RankListViewHolder rankListViewHolder = new RankListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d03b6, (ViewGroup) null));
                rankListViewHolder.i(0);
                rankListViewHolder.g(this.a.e);
                rankListViewHolder.h(this.a.f);
                return rankListViewHolder;
            }
            return (RankListViewHolder) invokeLI.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.b.size() : invokeV.intValue;
        }
    }

    public RankListViewController(View view2, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, str, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new ArrayList();
        this.g = new a(this);
        this.h = new b(this);
        this.e = str;
        this.f = j;
        BdRecyclerView bdRecyclerView = (BdRecyclerView) view2;
        this.a = bdRecyclerView;
        bdRecyclerView.setLayoutManager(new LinearLayoutManager(view2.getContext()));
        this.a.setAdapter(this.h);
        View inflate = LayoutInflater.from(view2.getContext()).inflate(R.layout.obfuscated_res_0x7f0d03b7, (ViewGroup) null);
        this.c = new e96(inflate, this.e, this.f);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.a.s(inflate);
        PbListView pbListView = new PbListView(view2.getContext());
        this.d = pbListView;
        pbListView.a();
        this.d.p(R.color.CAM_X0205);
        this.d.y();
        this.d.F(SkinManager.getColor(R.color.CAM_X0107));
        this.d.H(R.dimen.tbfontsize33);
        this.d.B(R.color.CAM_X0110);
        this.a.setNextPage(this.d);
        this.a.setOnItemClickListener(this.g);
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.c.j(i);
            this.h.notifyDataSetChanged();
            PbListView pbListView = this.d;
            if (pbListView != null) {
                pbListView.F(SkinManager.getColor(R.color.CAM_X0109));
                this.d.d(i);
            }
        }
    }

    public void f(g96 g96Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, g96Var, z) == null) {
            this.c.k(g96Var, z);
        }
    }

    public void g(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pVar) == null) {
            this.a.setOnSrollToBottomListener(pVar);
        }
    }

    public void h(List<h96> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || list == null) {
            return;
        }
        this.b.clear();
        this.b.addAll(list);
        this.h.notifyDataSetChanged();
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.d.K();
            this.d.R();
            this.d.D(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0a00));
            this.d.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void j(String str) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.d.Q(ej.f(this.a.getContext(), R.dimen.tbds96));
            if (!TextUtils.isEmpty(str)) {
                string = String.format(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f08b5), str);
            } else {
                string = this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0694);
            }
            this.d.E(string, ej.f(this.a.getContext(), R.dimen.tbds156));
            this.d.f();
            this.d.M(ej.f(this.a.getContext(), R.dimen.tbds44));
        }
    }
}
