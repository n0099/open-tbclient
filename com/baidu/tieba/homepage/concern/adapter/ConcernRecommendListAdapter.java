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
import b.a.e.e.p.l;
import b.a.q0.n.f;
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
import com.baidu.tieba.view.DynamicUserLikeButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes9.dex */
public class ConcernRecommendListAdapter extends RecyclerView.Adapter<ForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f49406a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f49407b;

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f49408c;

    /* renamed from: d  reason: collision with root package name */
    public int f49409d;

    /* renamed from: e  reason: collision with root package name */
    public List<MetaData> f49410e;

    /* renamed from: f  reason: collision with root package name */
    public f<MetaData> f49411f;

    /* loaded from: classes9.dex */
    public class ForumViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f49412a;
        public LinearLayout mContainer;
        public DynamicUserLikeButton mLikeButton;
        public TextView mUserDesc;
        public HeadPendantClickableView mUserImage;
        public b.a.q0.s.g0.t.c mUserLikePresenter;
        public TextView mUserName;

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
            this.f49412a = false;
            this.mContainer = (LinearLayout) view.findViewById(R.id.concern_container);
            HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) view.findViewById(R.id.concern_user_image);
            this.mUserImage = headPendantClickableView;
            headPendantClickableView.getHeadView().setIsRound(true);
            this.mUserImage.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.mUserImage.getHeadView().setDefaultResource(17170445);
            this.mUserImage.getHeadView().setPlaceHolder(1);
            this.mUserImage.getHeadView().setBorderWidth(l.g(concernRecommendListAdapter.f49406a, R.dimen.tbds1));
            this.mUserImage.getHeadView().setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.mUserName = (TextView) view.findViewById(R.id.concern_user_name);
            this.mUserDesc = (TextView) view.findViewById(R.id.concern_user_desc);
            this.mLikeButton = (DynamicUserLikeButton) view.findViewById(R.id.user_recommend_like_btn);
            this.mUserLikePresenter = new b.a.q0.s.g0.t.c(concernRecommendListAdapter.f49407b, this.mLikeButton);
        }

        public void onChangeSkinType(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (!this.f49412a) {
                    SkinManager.setViewTextColor(this.mUserName, R.color.CAM_X0105);
                } else {
                    SkinManager.setViewTextColor(this.mUserName, R.color.CAM_X0301);
                }
                SkinManager.setViewTextColor(this.mUserDesc, R.color.CAM_X0109);
                this.mLikeButton.onChangeSkinType(i2);
                b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this.mContainer);
                d2.n(R.string.J_X05);
                d2.f(R.color.CAM_X0206);
            }
        }

        public void setIsNewGod(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.f49412a = z;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f49413e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ForumViewHolder f49414f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ConcernRecommendListAdapter f49415g;

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
            this.f49415g = concernRecommendListAdapter;
            this.f49413e = metaData;
            this.f49414f = forumViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                StatisticItem statisticItem = new StatisticItem("c13566");
                statisticItem.param("obj_locate", 2);
                TiebaStatic.log(statisticItem);
                this.f49415g.d(this.f49413e, this.f49414f);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements DynamicUserLikeButton.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MetaData f49416a;

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
            this.f49416a = metaData;
        }

        @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
        public void a(View view) {
            MetaData metaData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (metaData = this.f49416a) == null) {
                return;
            }
            if (metaData.getIsLike()) {
                TiebaStatic.log(new StatisticItem("c13571"));
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c13566");
            statisticItem.param("obj_locate", 1);
            statisticItem.param("obj_id", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_param1", this.f49416a.getUserId());
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f49417e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ForumViewHolder f49418f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ConcernRecommendListAdapter f49419g;

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
            this.f49419g = concernRecommendListAdapter;
            this.f49417e = metaData;
            this.f49418f = forumViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MetaData metaData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (metaData = this.f49417e) == null || StringUtils.isNull(metaData.getUserId())) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c13566");
            statisticItem.param("obj_locate", 2);
            TiebaStatic.log(statisticItem);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f49419g.f49406a, this.f49417e.getUserId(), this.f49417e.getName_show())));
            this.f49419g.d(this.f49417e, this.f49418f);
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
        this.f49409d = 3;
        this.f49406a = context;
    }

    public final void d(MetaData metaData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, metaData, forumViewHolder) == null) || this.f49411f == null) {
            return;
        }
        this.f49411f.a(forumViewHolder.itemView, metaData, forumViewHolder.getAdapterPosition(), forumViewHolder.getItemId());
    }

    public final void e(MetaData metaData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, metaData, forumViewHolder) == null) {
            forumViewHolder.mUserImage.setData(metaData, true);
            forumViewHolder.mUserImage.setAfterClickListener(new a(this, metaData, forumViewHolder));
        }
    }

    public final void f(MetaData metaData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, metaData, forumViewHolder) == null) || metaData == null || forumViewHolder == null) {
            return;
        }
        forumViewHolder.mUserDesc.setText(UtilHelper.getAuthInfo(metaData, false, 24));
    }

    public final void g(MetaData metaData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, metaData, forumViewHolder) == null) {
            forumViewHolder.mLikeButton.setOnClickEvent(new b(this, metaData));
            b.a.q0.s.g0.t.c cVar = forumViewHolder.mUserLikePresenter;
            if (cVar != null) {
                cVar.l(this.f49408c);
                cVar.n(metaData);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<MetaData> list = this.f49410e;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    public final void h(MetaData metaData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, metaData, forumViewHolder) == null) || metaData == null || forumViewHolder == null) {
            return;
        }
        forumViewHolder.mUserName.setText(!StringUtils.isNull(metaData.getName_show()) ? metaData.getName_show() : "");
        if (metaData.isNewGod()) {
            SkinManager.setViewTextColor(forumViewHolder.mUserName, R.color.CAM_X0301);
        }
        forumViewHolder.mUserName.setOnClickListener(new c(this, metaData, forumViewHolder));
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f49409d = i2;
        }
    }

    public void setData(List<MetaData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            this.f49410e = list;
        }
    }

    public void setHasBorder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
        }
    }

    public void setOnItemCoverListener(f<MetaData> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, fVar) == null) {
            this.f49411f = fVar;
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, tbPageContext) == null) {
            this.f49407b = tbPageContext;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bdUniqueId) == null) {
            this.f49408c = bdUniqueId;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ForumViewHolder forumViewHolder, int i2) {
        List<MetaData> list;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, forumViewHolder, i2) == null) || forumViewHolder == null || (list = this.f49410e) == null || (metaData = list.get(i2)) == null) {
            return;
        }
        forumViewHolder.setIsNewGod(metaData.isNewGod());
        e(metaData, forumViewHolder);
        h(metaData, forumViewHolder);
        f(metaData, forumViewHolder);
        g(metaData, forumViewHolder);
        f<MetaData> fVar = this.f49411f;
        if (fVar != null) {
            fVar.c(forumViewHolder.itemView, metaData, i2, i2);
        }
        forumViewHolder.onChangeSkinType(this.f49409d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ForumViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, viewGroup, i2)) == null) ? new ForumViewHolder(this, LayoutInflater.from(this.f49406a).inflate(R.layout.concern_recommend_item, (ViewGroup) null)) : (ForumViewHolder) invokeLI.objValue;
    }
}
