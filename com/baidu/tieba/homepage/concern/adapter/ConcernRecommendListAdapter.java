package com.baidu.tieba.homepage.concern.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tieba.R;
import com.baidu.tieba.jq4;
import com.baidu.tieba.pw4;
import com.baidu.tieba.r05;
import com.baidu.tieba.view.DynamicUserLikeButton;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class ConcernRecommendListAdapter extends RecyclerView.Adapter<ForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public TbPageContext b;
    public BdUniqueId c;
    public int d;
    public List<MetaData> e;
    public jq4<MetaData> f;

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class ForumViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout a;
        public TextView b;
        public TextView c;
        public HeadPendantClickableView d;
        public DynamicUserLikeButton e;
        public r05 f;
        public boolean g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ForumViewHolder(ConcernRecommendListAdapter concernRecommendListAdapter, View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernRecommendListAdapter, view2};
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
            this.g = false;
            this.a = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906cf);
            HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) view2.findViewById(R.id.obfuscated_res_0x7f0906d9);
            this.d = headPendantClickableView;
            headPendantClickableView.getHeadView().setIsRound(true);
            this.d.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.d.getHeadView().setDefaultResource(17170445);
            this.d.getHeadView().setPlaceHolder(1);
            this.d.getHeadView().setBorderWidth(yi.g(concernRecommendListAdapter.a, R.dimen.tbds1));
            this.d.getHeadView().setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0906da);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0906d8);
            this.e = (DynamicUserLikeButton) view2.findViewById(R.id.obfuscated_res_0x7f092519);
            this.f = new r05(concernRecommendListAdapter.b, this.e);
        }

        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (!this.g) {
                    SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0105);
                } else {
                    SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0301);
                }
                SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0109);
                this.e.r(i);
                pw4 d = pw4.d(this.a);
                d.n(R.string.J_X05);
                d.f(R.color.CAM_X0206);
            }
        }

        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.g = z;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ ForumViewHolder b;
        public final /* synthetic */ ConcernRecommendListAdapter c;

        public a(ConcernRecommendListAdapter concernRecommendListAdapter, MetaData metaData, ForumViewHolder forumViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernRecommendListAdapter, metaData, forumViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = concernRecommendListAdapter;
            this.a = metaData;
            this.b = forumViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                StatisticItem statisticItem = new StatisticItem("c13566");
                statisticItem.param("obj_locate", 2);
                TiebaStatic.log(statisticItem);
                this.c.j(this.a, this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements DynamicUserLikeButton.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;

        public b(ConcernRecommendListAdapter concernRecommendListAdapter, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernRecommendListAdapter, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = metaData;
        }

        @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
        public void a(View view2) {
            MetaData metaData;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || (metaData = this.a) == null) {
                return;
            }
            if (metaData.getIsLike()) {
                TiebaStatic.log(new StatisticItem("c13571"));
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c13566");
            statisticItem.param("obj_locate", 1);
            statisticItem.param("obj_id", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_param1", this.a.getUserId());
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ ForumViewHolder b;
        public final /* synthetic */ ConcernRecommendListAdapter c;

        public c(ConcernRecommendListAdapter concernRecommendListAdapter, MetaData metaData, ForumViewHolder forumViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernRecommendListAdapter, metaData, forumViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = concernRecommendListAdapter;
            this.a = metaData;
            this.b = forumViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            MetaData metaData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (metaData = this.a) != null && !StringUtils.isNull(metaData.getUserId())) {
                StatisticItem statisticItem = new StatisticItem("c13566");
                statisticItem.param("obj_locate", 2);
                TiebaStatic.log(statisticItem);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.c.a, this.a.getUserId(), this.a.getName_show())));
                this.c.j(this.a, this.b);
            }
        }
    }

    public ConcernRecommendListAdapter(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = 3;
        this.a = context;
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.d = i;
        }
    }

    public void l(jq4<MetaData> jq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jq4Var) == null) {
            this.f = jq4Var;
        }
    }

    public void m(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, tbPageContext) == null) {
            this.b = tbPageContext;
        }
    }

    public void n(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) {
            this.c = bdUniqueId;
        }
    }

    public void setData(List<MetaData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            this.e = list;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public void onBindViewHolder(ForumViewHolder forumViewHolder, int i) {
        List<MetaData> list;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048576, this, forumViewHolder, i) != null) || forumViewHolder == null || (list = this.e) == null || (metaData = list.get(i)) == null) {
            return;
        }
        forumViewHolder.b(metaData.isNewGod());
        o(metaData, forumViewHolder);
        r(metaData, forumViewHolder);
        p(metaData, forumViewHolder);
        q(metaData, forumViewHolder);
        jq4<MetaData> jq4Var = this.f;
        if (jq4Var != null) {
            jq4Var.d(forumViewHolder.itemView, metaData, i, i);
        }
        forumViewHolder.a(this.d);
    }

    public final void r(MetaData metaData, ForumViewHolder forumViewHolder) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, metaData, forumViewHolder) == null) && metaData != null && forumViewHolder != null) {
            if (!StringUtils.isNull(metaData.getName_show())) {
                str = metaData.getName_show();
            } else {
                str = "";
            }
            forumViewHolder.b.setText(str);
            if (metaData.isNewGod()) {
                SkinManager.setViewTextColor(forumViewHolder.b, (int) R.color.CAM_X0301);
            }
            forumViewHolder.b.setOnClickListener(new c(this, metaData, forumViewHolder));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<MetaData> list = this.e;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i */
    public ForumViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, viewGroup, i)) == null) {
            return new ForumViewHolder(this, LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d01f2, (ViewGroup) null));
        }
        return (ForumViewHolder) invokeLI.objValue;
    }

    public final void j(MetaData metaData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, metaData, forumViewHolder) == null) && this.f != null) {
            this.f.c(forumViewHolder.itemView, metaData, forumViewHolder.getAdapterPosition(), forumViewHolder.getItemId());
        }
    }

    public final void o(MetaData metaData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, metaData, forumViewHolder) == null) {
            forumViewHolder.d.setData(metaData, true);
            forumViewHolder.d.setAfterClickListener(new a(this, metaData, forumViewHolder));
        }
    }

    public final void p(MetaData metaData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, metaData, forumViewHolder) == null) && metaData != null && forumViewHolder != null) {
            forumViewHolder.c.setText(UtilHelper.getAuthInfo(metaData, false, 24));
        }
    }

    public final void q(MetaData metaData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, metaData, forumViewHolder) == null) {
            forumViewHolder.e.setOnClickEvent(new b(this, metaData));
            r05 r05Var = forumViewHolder.f;
            if (r05Var != null) {
                r05Var.l(this.c);
                r05Var.n(metaData);
            }
        }
    }
}
