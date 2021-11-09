package com.baidu.tieba.ala.alasquare.special_forum.subtab.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import b.a.e.a.j;
import b.a.r0.w.f.g.c.c;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerAutoScrollView;
import com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class RecommendActivityView extends b.a.r0.b0.b<c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext m;
    public AlaBannerAutoScrollView<b.a.r0.w.f.g.c.b> n;
    public b.a.r0.w.f.i.h.a o;

    /* loaded from: classes9.dex */
    public static class ViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public RecommendActivityView activityView;
        public View root;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(RecommendActivityView recommendActivityView) {
            super(recommendActivityView.i());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendActivityView};
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
            this.activityView = recommendActivityView;
            this.root = recommendActivityView.i();
        }
    }

    /* loaded from: classes9.dex */
    public class a implements b.a.r0.w.f.i.h.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendActivityView f47064a;

        public a(RecommendActivityView recommendActivityView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendActivityView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47064a = recommendActivityView;
        }

        @Override // b.a.r0.w.f.i.h.b
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && obj != null && (obj instanceof b.a.r0.w.f.g.c.b)) {
                b.a.r0.w.f.g.c.b bVar = (b.a.r0.w.f.g.c.b) obj;
                if (!StringUtils.isNull(bVar.f24821e)) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f47064a.m.getPageActivity()), new String[]{bVar.f24821e}, true);
                }
                TiebaStatic.log("c12902");
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements b.a.r0.w.f.i.h.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendActivityView f47065a;

        /* loaded from: classes9.dex */
        public class a extends AlaBannerViewHolder<b.a.r0.w.f.g.c.b> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public TbImageView f47066a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b bVar, View view) {
                super(view);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, view};
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
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            /* renamed from: a */
            public void bindData(int i2, b.a.r0.w.f.g.c.b bVar) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, bVar) == null) || bVar == null || this.f47066a == null || StringUtils.isNull(bVar.f24822f)) {
                    return;
                }
                this.f47066a.startLoad(bVar.f24822f, 10, false);
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            public void initView(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
                    TbImageView tbImageView = (TbImageView) view.findViewById(R.id.cover);
                    this.f47066a = tbImageView;
                    tbImageView.setDefaultBgResource(R.drawable.pic_bg_video_frs);
                }
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            public void onChangeSkinType(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                }
            }
        }

        public b(RecommendActivityView recommendActivityView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendActivityView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47065a = recommendActivityView;
        }

        @Override // b.a.r0.w.f.i.h.a
        public AlaBannerViewHolder a(ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i2)) == null) ? new a(this, LayoutInflater.from(this.f47065a.m.getPageActivity()).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) : (AlaBannerViewHolder) invokeLI.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendActivityView(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (ViewGroup) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new b(this);
        this.m = tbPageContext;
        AlaBannerAutoScrollView<b.a.r0.w.f.g.c.b> alaBannerAutoScrollView = (AlaBannerAutoScrollView) i().findViewById(R.id.banner_container);
        this.n = alaBannerAutoScrollView;
        alaBannerAutoScrollView.setViewHolderAdapter(this.o);
        this.n.setOnBannerClickListener(new a(this));
        k(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // b.a.r0.b0.b
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.special_bar_recommend_banner : invokeV.intValue;
    }

    @Override // b.a.r0.b0.b
    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? super.i() : (View) invokeV.objValue;
    }

    @Override // b.a.r0.b0.b
    public void k(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) {
            this.n.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.b0.b
    /* renamed from: p */
    public void j(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || cVar == null || ListUtils.isEmpty(cVar.f24824e)) {
            return;
        }
        this.n.bindActivityData(cVar.f24824e, this.o);
        TiebaStatic.log("c12901");
    }
}
