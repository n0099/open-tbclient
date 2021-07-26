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
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.DynamicUserLikeButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.k;
import d.a.d.e.p.l;
import d.a.p0.b1.n0;
import d.a.p0.n.f;
import java.util.List;
/* loaded from: classes4.dex */
public class ConcernRecommendListAdapter extends RecyclerView.Adapter<ForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f16537a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f16538b;

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f16539c;

    /* renamed from: d  reason: collision with root package name */
    public int f16540d;

    /* renamed from: e  reason: collision with root package name */
    public List<MetaData> f16541e;

    /* renamed from: f  reason: collision with root package name */
    public f<MetaData> f16542f;

    /* loaded from: classes4.dex */
    public class ForumViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f16543a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f16544b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f16545c;

        /* renamed from: d  reason: collision with root package name */
        public HeadPendantClickableView f16546d;

        /* renamed from: e  reason: collision with root package name */
        public DynamicUserLikeButton f16547e;

        /* renamed from: f  reason: collision with root package name */
        public d.a.p0.s.f0.t.c f16548f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f16549g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ForumViewHolder(ConcernRecommendListAdapter concernRecommendListAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernRecommendListAdapter, view};
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
            this.f16549g = false;
            this.f16543a = (LinearLayout) view.findViewById(R.id.concern_container);
            HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) view.findViewById(R.id.concern_user_image);
            this.f16546d = headPendantClickableView;
            headPendantClickableView.getHeadView().setIsRound(true);
            this.f16546d.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f16546d.getHeadView().setDefaultResource(17170445);
            this.f16546d.getHeadView().setPlaceHolder(1);
            this.f16546d.getHeadView().setBorderWidth(l.g(concernRecommendListAdapter.f16537a, R.dimen.tbds1));
            this.f16546d.getHeadView().setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.f16544b = (TextView) view.findViewById(R.id.concern_user_name);
            this.f16545c = (TextView) view.findViewById(R.id.concern_user_desc);
            this.f16547e = (DynamicUserLikeButton) view.findViewById(R.id.user_recommend_like_btn);
            this.f16548f = new d.a.p0.s.f0.t.c(concernRecommendListAdapter.f16538b, this.f16547e);
        }

        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (!this.f16549g) {
                    SkinManager.setViewTextColor(this.f16544b, R.color.CAM_X0105);
                } else {
                    SkinManager.setViewTextColor(this.f16544b, R.color.CAM_X0301);
                }
                SkinManager.setViewTextColor(this.f16545c, R.color.CAM_X0109);
                this.f16547e.r(i2);
                d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(this.f16543a);
                d2.n(R.string.J_X05);
                d2.f(R.color.CAM_X0206);
            }
        }

        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.f16549g = z;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f16550e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ForumViewHolder f16551f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ConcernRecommendListAdapter f16552g;

        public a(ConcernRecommendListAdapter concernRecommendListAdapter, MetaData metaData, ForumViewHolder forumViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernRecommendListAdapter, metaData, forumViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16552g = concernRecommendListAdapter;
            this.f16550e = metaData;
            this.f16551f = forumViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                StatisticItem statisticItem = new StatisticItem("c13566");
                statisticItem.param("obj_locate", 2);
                TiebaStatic.log(statisticItem);
                this.f16552g.j(this.f16550e, this.f16551f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements DynamicUserLikeButton.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MetaData f16553a;

        public b(ConcernRecommendListAdapter concernRecommendListAdapter, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernRecommendListAdapter, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16553a = metaData;
        }

        @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
        public void a(View view) {
            MetaData metaData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (metaData = this.f16553a) == null) {
                return;
            }
            if (metaData.getIsLike()) {
                TiebaStatic.log(new StatisticItem("c13571"));
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c13566");
            statisticItem.param("obj_locate", 1);
            statisticItem.param("obj_id", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_param1", this.f16553a.getUserId());
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f16554e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ForumViewHolder f16555f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ConcernRecommendListAdapter f16556g;

        public c(ConcernRecommendListAdapter concernRecommendListAdapter, MetaData metaData, ForumViewHolder forumViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernRecommendListAdapter, metaData, forumViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16556g = concernRecommendListAdapter;
            this.f16554e = metaData;
            this.f16555f = forumViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MetaData metaData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (metaData = this.f16554e) == null || StringUtils.isNull(metaData.getUserId())) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c13566");
            statisticItem.param("obj_locate", 2);
            TiebaStatic.log(statisticItem);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f16556g.f16537a, this.f16554e.getUserId(), this.f16554e.getName_show())));
            this.f16556g.j(this.f16554e, this.f16555f);
        }
    }

    public ConcernRecommendListAdapter(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16540d = 3;
        this.f16537a = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public void onBindViewHolder(ForumViewHolder forumViewHolder, int i2) {
        List<MetaData> list;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, forumViewHolder, i2) == null) || forumViewHolder == null || (list = this.f16541e) == null || (metaData = list.get(i2)) == null) {
            return;
        }
        forumViewHolder.b(metaData.isNewGod());
        o(metaData, forumViewHolder);
        r(metaData, forumViewHolder);
        p(metaData, forumViewHolder);
        q(metaData, forumViewHolder);
        f<MetaData> fVar = this.f16542f;
        if (fVar != null) {
            fVar.c(forumViewHolder.itemView, metaData, i2, i2);
        }
        forumViewHolder.a(this.f16540d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<MetaData> list = this.f16541e;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f16540d = i2;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i */
    public ForumViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, viewGroup, i2)) == null) ? new ForumViewHolder(this, LayoutInflater.from(this.f16537a).inflate(R.layout.concern_recommend_item, (ViewGroup) null)) : (ForumViewHolder) invokeLI.objValue;
    }

    public final void j(MetaData metaData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, metaData, forumViewHolder) == null) || this.f16542f == null) {
            return;
        }
        this.f16542f.a(forumViewHolder.itemView, metaData, forumViewHolder.getAdapterPosition(), forumViewHolder.getItemId());
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
        }
    }

    public void l(f<MetaData> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
            this.f16542f = fVar;
        }
    }

    public void m(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, tbPageContext) == null) {
            this.f16538b = tbPageContext;
        }
    }

    public void n(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) {
            this.f16539c = bdUniqueId;
        }
    }

    public final void o(MetaData metaData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, metaData, forumViewHolder) == null) {
            forumViewHolder.f16546d.setData(metaData, true);
            forumViewHolder.f16546d.setAfterClickListener(new a(this, metaData, forumViewHolder));
        }
    }

    public final void p(MetaData metaData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, metaData, forumViewHolder) == null) || metaData == null || forumViewHolder == null) {
            return;
        }
        String str = "";
        if (metaData.isBaijiahaoUser()) {
            String str2 = metaData.getBaijiahaoInfo().auth_desc;
            if (!k.isEmpty(str2)) {
                str = str2;
            }
        } else if (metaData.isNewGod()) {
            String fieldName = metaData.getNewGodData().getFieldName();
            if (!k.isEmpty(fieldName)) {
                str = fieldName + n0.d(metaData.isVideoGod());
            }
        }
        forumViewHolder.f16545c.setText(str);
    }

    public final void q(MetaData metaData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, metaData, forumViewHolder) == null) {
            forumViewHolder.f16547e.setOnClickEvent(new b(this, metaData));
            d.a.p0.s.f0.t.c cVar = forumViewHolder.f16548f;
            if (cVar != null) {
                cVar.l(this.f16539c);
                cVar.n(metaData);
            }
        }
    }

    public final void r(MetaData metaData, ForumViewHolder forumViewHolder) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, metaData, forumViewHolder) == null) || metaData == null || forumViewHolder == null) {
            return;
        }
        if (!StringUtils.isNull(metaData.getName_show())) {
            str = metaData.getName_show();
        } else {
            str = (metaData.getBaijiahaoInfo() == null || StringUtils.isNull(metaData.getBaijiahaoInfo().name)) ? "" : metaData.getBaijiahaoInfo().name;
        }
        forumViewHolder.f16544b.setText(str);
        if (metaData.isNewGod()) {
            SkinManager.setViewTextColor(forumViewHolder.f16544b, R.color.CAM_X0301);
        }
        forumViewHolder.f16544b.setOnClickListener(new c(this, metaData, forumViewHolder));
    }

    public void setData(List<MetaData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            this.f16541e = list;
        }
    }
}
