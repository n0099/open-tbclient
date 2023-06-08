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
import com.baidu.tieba.o75;
import com.baidu.tieba.ob5;
import com.baidu.tieba.vi;
import com.baidu.tieba.view.DynamicUserLikeButton;
import com.baidu.tieba.vz4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class ConcernRecommendListAdapter extends RecyclerView.Adapter<ForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public TbPageContext b;
    public BdUniqueId c;
    public int d;
    public List<MetaData> e;
    public vz4<MetaData> f;

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class ForumViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout a;
        public TextView b;
        public TextView c;
        public HeadPendantClickableView d;
        public DynamicUserLikeButton e;
        public ob5 f;
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
            this.a = (LinearLayout) view2.findViewById(R.id.concern_container);
            HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) view2.findViewById(R.id.concern_user_image);
            this.d = headPendantClickableView;
            headPendantClickableView.getHeadView().setIsRound(true);
            this.d.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.d.getHeadView().setDefaultResource(17170445);
            this.d.getHeadView().setPlaceHolder(1);
            this.d.getHeadView().setBorderWidth(vi.g(concernRecommendListAdapter.a, R.dimen.tbds1));
            this.d.getHeadView().setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.b = (TextView) view2.findViewById(R.id.concern_user_name);
            this.c = (TextView) view2.findViewById(R.id.concern_user_desc);
            this.e = (DynamicUserLikeButton) view2.findViewById(R.id.user_recommend_like_btn);
            this.f = new ob5(concernRecommendListAdapter.b, this.e);
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
                this.e.onChangeSkinType(i);
                o75 d = o75.d(this.a);
                d.o(R.string.J_X05);
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

    /* loaded from: classes6.dex */
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
                this.c.q(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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
                this.c.q(this.a, this.b);
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

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.d = i;
        }
    }

    public void s(vz4<MetaData> vz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, vz4Var) == null) {
            this.f = vz4Var;
        }
    }

    public void setData(List<MetaData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            this.e = list;
        }
    }

    public void t(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, tbPageContext) == null) {
            this.b = tbPageContext;
        }
    }

    public void u(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bdUniqueId) == null) {
            this.c = bdUniqueId;
        }
    }

    public final void A(MetaData metaData, ForumViewHolder forumViewHolder) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, metaData, forumViewHolder) == null) && metaData != null && forumViewHolder != null) {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n */
    public void onBindViewHolder(ForumViewHolder forumViewHolder, int i) {
        List<MetaData> list;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, forumViewHolder, i) != null) || forumViewHolder == null || (list = this.e) == null || (metaData = list.get(i)) == null) {
            return;
        }
        forumViewHolder.b(metaData.isNewGod());
        x(metaData, forumViewHolder);
        A(metaData, forumViewHolder);
        y(metaData, forumViewHolder);
        z(metaData, forumViewHolder);
        vz4<MetaData> vz4Var = this.f;
        if (vz4Var != null) {
            vz4Var.c(forumViewHolder.itemView, metaData, i, i);
        }
        forumViewHolder.a(this.d);
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
    /* renamed from: p */
    public ForumViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, viewGroup, i)) == null) {
            return new ForumViewHolder(this, LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d021d, (ViewGroup) null));
        }
        return (ForumViewHolder) invokeLI.objValue;
    }

    public final void q(MetaData metaData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, metaData, forumViewHolder) == null) && this.f != null) {
            this.f.d(forumViewHolder.itemView, metaData, forumViewHolder.getAdapterPosition(), forumViewHolder.getItemId());
        }
    }

    public final void x(MetaData metaData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, metaData, forumViewHolder) == null) {
            forumViewHolder.d.setData(metaData, true);
            forumViewHolder.d.setAfterClickListener(new a(this, metaData, forumViewHolder));
        }
    }

    public final void y(MetaData metaData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, metaData, forumViewHolder) == null) && metaData != null && forumViewHolder != null) {
            forumViewHolder.c.setText(UtilHelper.getAuthInfo(metaData, false, 24));
        }
    }

    public final void z(MetaData metaData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, metaData, forumViewHolder) == null) {
            forumViewHolder.e.setOnClickEvent(new b(this, metaData));
            ob5 ob5Var = forumViewHolder.f;
            if (ob5Var != null) {
                ob5Var.l(this.c);
                ob5Var.n(metaData);
            }
        }
    }
}
