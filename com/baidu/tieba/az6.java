package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.cx;
import com.baidu.tieba.ny;
import com.baidu.tieba.yy;
import com.baidu.tieba.zw;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class az6 extends jn<o46, ThreadCardViewHolder<o46>> implements zp5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public boolean d;
    public co e;
    public ng<ImageView> f;
    public ng<GifView> g;
    public z36<o46> h;

    /* loaded from: classes3.dex */
    public class a implements og<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ az6 a;

        public a(az6 az6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {az6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = az6Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.og
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.og
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og
        /* renamed from: f */
        public void b(ImageView imageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, imageView) == null) {
                imageView.setBackgroundDrawable(null);
                imageView.setImageDrawable(null);
                imageView.setTag(null);
                imageView.setOnClickListener(null);
                if (imageView instanceof ForeDrawableImageView) {
                    ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                    foreDrawableImageView.O();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                }
            }
        }

        public ImageView e(ImageView imageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, imageView)) == null) {
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setTag(null);
                    if (ar4.c().g()) {
                        tbImageView.setAdjustViewBounds(false);
                        tbImageView.setInterceptOnClick(false);
                    } else {
                        tbImageView.setDefaultResource(R.drawable.icon_click);
                        tbImageView.setAdjustViewBounds(true);
                        tbImageView.setInterceptOnClick(true);
                    }
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }

        public ImageView h(ImageView imageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, imageView)) == null) {
                imageView.setBackgroundDrawable(null);
                imageView.setImageDrawable(null);
                imageView.setTag(null);
                imageView.setOnClickListener(null);
                if (imageView instanceof ForeDrawableImageView) {
                    ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                    foreDrawableImageView.O();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                    foreDrawableImageView.F();
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.b.getPageActivity());
                boolean g = ar4.c().g();
                foreDrawableImageView.setDefaultBg(SkinManager.getDrawable(R.color.common_color_10220));
                if (g) {
                    foreDrawableImageView.setAdjustViewBounds(false);
                    foreDrawableImageView.setInterceptOnClick(false);
                } else {
                    foreDrawableImageView.setDefaultResource(R.drawable.icon_click);
                    foreDrawableImageView.setAdjustViewBounds(true);
                    foreDrawableImageView.setInterceptOnClick(true);
                }
                return foreDrawableImageView;
            }
            return (ImageView) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements og<GifView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ az6 a;

        public b(az6 az6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {az6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = az6Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.og
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.og
        public /* bridge */ /* synthetic */ GifView c(GifView gifView) {
            GifView gifView2 = gifView;
            h(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og
        /* renamed from: f */
        public void b(GifView gifView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gifView) == null) {
                gifView.setBackgroundDrawable(null);
                gifView.setImageDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                gifView.b0();
            }
        }

        public GifView h(GifView gifView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, gifView)) == null) {
                gifView.e0();
                gifView.b0();
                gifView.setImageDrawable(null);
                gifView.f0();
                gifView.setBackgroundDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                return gifView;
            }
            return (GifView) invokeL.objValue;
        }

        public GifView e(GifView gifView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gifView)) == null) {
                gifView.setTag(null);
                if (ar4.c().g()) {
                    gifView.setAdjustViewBounds(false);
                    gifView.setInterceptOnClick(false);
                } else {
                    gifView.setDefaultResource(R.drawable.icon_click);
                    gifView.setAdjustViewBounds(true);
                    gifView.setInterceptOnClick(true);
                }
                return gifView;
            }
            return (GifView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.b.getPageActivity());
                boolean g = ar4.c().g();
                gifView.setDefaultBg(SkinManager.getDrawable(R.color.common_color_10220));
                if (g) {
                    gifView.setAdjustViewBounds(false);
                    gifView.setInterceptOnClick(false);
                } else {
                    gifView.setDefaultResource(R.drawable.icon_click);
                    gifView.setAdjustViewBounds(true);
                    gifView.setInterceptOnClick(true);
                }
                return gifView;
            }
            return (GifView) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c extends z36<o46> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(az6 az6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {az6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.z36
        /* renamed from: d */
        public void a(View view2, o46 o46Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, o46Var) == null) && view2 != null && o46Var != null && o46Var.getThreadData() != null && !StringUtils.isNull(o46Var.getThreadData().getTid())) {
                int id = view2.getId();
                if (id != R.id.obfuscated_res_0x7f0921d0 && id != R.id.obfuscated_res_0x7f0921e4) {
                    if (id == R.id.obfuscated_res_0x7f0921d2) {
                        iy6.b(view2, o46Var, 6);
                        return;
                    } else if (id != R.id.obfuscated_res_0x7f0924c8 && id != R.id.obfuscated_res_0x7f0924f6) {
                        if (id == R.id.obfuscated_res_0x7f090d02) {
                            StatisticItem statisticItem = new StatisticItem("c13423");
                            statisticItem.param("obj_locate", 4);
                            if (o46Var != null) {
                                statisticItem.param("tid", o46Var.g);
                                ThreadData threadData = o46Var.a;
                                if (threadData != null && threadData.getTopAgreePost() != null) {
                                    statisticItem.param("pid", o46Var.a.getTopAgreePost().M());
                                }
                            }
                            TiebaStatic.log(statisticItem);
                            return;
                        } else if (id == R.id.obfuscated_res_0x7f090cfd) {
                            StatisticItem statisticItem2 = new StatisticItem("c13423");
                            statisticItem2.param("obj_locate", 2);
                            if (o46Var != null) {
                                statisticItem2.param("tid", o46Var.g);
                                ThreadData threadData2 = o46Var.a;
                                if (threadData2 != null && threadData2.getTopAgreePost() != null) {
                                    statisticItem2.param("pid", o46Var.a.getTopAgreePost().M());
                                }
                            }
                            TiebaStatic.log(statisticItem2);
                            return;
                        } else if (id != R.id.obfuscated_res_0x7f090d00 && id != R.id.obfuscated_res_0x7f090d01) {
                            if (id == R.id.obfuscated_res_0x7f090cfc) {
                                StatisticItem statisticItem3 = new StatisticItem("c13423");
                                statisticItem3.param("obj_locate", 5);
                                if (o46Var != null) {
                                    statisticItem3.param("tid", o46Var.g);
                                    ThreadData threadData3 = o46Var.a;
                                    if (threadData3 != null && threadData3.getTopAgreePost() != null) {
                                        statisticItem3.param("pid", o46Var.a.getTopAgreePost().M());
                                    }
                                }
                                TiebaStatic.log(statisticItem3);
                                return;
                            } else if (view2.getId() == R.id.obfuscated_res_0x7f090aac) {
                                iy6.b(view2, o46Var, 7);
                                return;
                            } else if (view2 instanceof TbImageView) {
                                if (view2.getTag(R.id.obfuscated_res_0x7f090cfe) instanceof Integer) {
                                    StatisticItem statisticItem4 = new StatisticItem("c13423");
                                    statisticItem4.param("obj_locate", 3);
                                    if (o46Var != null) {
                                        statisticItem4.param("tid", o46Var.g);
                                        ThreadData threadData4 = o46Var.a;
                                        if (threadData4 != null && threadData4.getTopAgreePost() != null) {
                                            statisticItem4.param("pid", o46Var.a.getTopAgreePost().M());
                                        }
                                    }
                                    TiebaStatic.log(statisticItem4);
                                    return;
                                }
                                iy6.b(view2, o46Var, 6);
                                return;
                            } else {
                                return;
                            }
                        } else {
                            StatisticItem statisticItem5 = new StatisticItem("c13423");
                            statisticItem5.param("obj_locate", 1);
                            if (o46Var != null) {
                                statisticItem5.param("tid", o46Var.g);
                                ThreadData threadData5 = o46Var.a;
                                if (threadData5 != null && threadData5.getTopAgreePost() != null) {
                                    statisticItem5.param("pid", o46Var.a.getTopAgreePost().M());
                                }
                            }
                            TiebaStatic.log(statisticItem5);
                            return;
                        }
                    } else {
                        iy6.b(view2, o46Var, 1);
                        return;
                    }
                }
                iy6.b(view2, o46Var, 2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements cx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ az6 a;

        public d(az6 az6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {az6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = az6Var;
        }

        @Override // com.baidu.tieba.cx.b
        public void a(rr4 rr4Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, rr4Var, view2) == null) && rr4Var != null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f0924f6) {
                    rr4Var.objType = 3;
                } else if (view2.getId() == R.id.obfuscated_res_0x7f0924c8) {
                    rr4Var.objType = 4;
                } else {
                    rr4Var.objType = 1;
                }
                this.a.z(view2, rr4Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends z36<rr4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ az6 b;

        public e(az6 az6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {az6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = az6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.z36
        /* renamed from: d */
        public void a(View view2, rr4 rr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, rr4Var) != null) {
                return;
            }
            this.b.z(view2, rr4Var);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements zw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ox a;
        public final /* synthetic */ az6 b;

        public f(az6 az6Var, ox oxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {az6Var, oxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = az6Var;
            this.a = oxVar;
        }

        @Override // com.baidu.tieba.zw.a
        public void a(rr4 rr4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, rr4Var) == null) && rr4Var != null && rr4Var.getThreadData() != null && rr4Var.getThreadData().originalThreadData != null) {
                ThreadCardUtils.jumpToPB(rr4Var.getThreadData().originalThreadData, this.b.mContext, 1);
                iy6.b(this.a.k(), rr4Var, 6);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements go {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ az6 a;

        public g(az6 az6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {az6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = az6Var;
        }

        @Override // com.baidu.tieba.go
        public void b(View view2, wn wnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, wnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (wnVar instanceof o46) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                o46 o46Var = (o46) wnVar;
                o46Var.f = 1;
                if (this.a.h != null) {
                    this.a.h.a(threadCardViewHolder.getView(), o46Var);
                }
                ThreadCardUtils.jumpToPB((rr4) o46Var, view2.getContext(), 1, false);
                threadCardViewHolder.a().o(new yy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public az6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = true;
        this.f = new ng<>(new a(this), 8, 0);
        this.g = new ng<>(new b(this), 20, 0);
        this.h = new c(this);
        this.b = tbPageContext;
    }

    @Override // com.baidu.tieba.zp5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.c = str;
        }
    }

    public void y(co coVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, coVar) == null) {
            this.e = coVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: w */
    public ThreadCardViewHolder<o46> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            ny.b bVar = new ny.b(this.b.getPageActivity());
            cx cxVar = new cx(this.b.getPageActivity());
            cxVar.x(this.a);
            cxVar.f(128);
            cxVar.g(1024);
            cxVar.w(new d(this));
            bVar.o(cxVar);
            iy iyVar = new iy(this.b);
            iyVar.r(Boolean.FALSE);
            iyVar.z(ImageViewerConfig.FROM_CONCERN);
            bVar.l().h(xi.g(this.mContext, R.dimen.tbds28));
            iyVar.p(new e(this));
            bVar.n(iyVar);
            ox oxVar = new ox(this.b.getPageActivity());
            oxVar.B(ImageViewerConfig.FROM_CONCERN);
            oxVar.D(1);
            oxVar.G(this.f, this.g);
            oxVar.C(this.d);
            oxVar.r(Boolean.TRUE);
            oxVar.z(R.color.CAM_X0206);
            oxVar.I(HomeGroupUbsUIHelper.getTransmitLRMarginByUbs(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), HomeGroupUbsUIHelper.getTransmitLRMarginByUbs(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004));
            oxVar.E(new f(this, oxVar));
            bVar.h(oxVar);
            bVar.h(new ry(this.b.getPageActivity()));
            bVar.h(new jx(this.b.getPageActivity()));
            py pyVar = new py(this.b.getPageActivity());
            xr4 xr4Var = new xr4();
            xr4Var.b = 9;
            xr4Var.h = 9;
            pyVar.z(xr4Var);
            pyVar.B(9);
            pyVar.G(4);
            pyVar.C(1);
            pyVar.f(32);
            pyVar.A(false);
            bVar.m(pyVar);
            ny k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.e);
            k.r(1);
            ThreadCardViewHolder<o46> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new g(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: x */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, o46 o46Var, ThreadCardViewHolder<o46> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, o46Var, threadCardViewHolder})) == null) {
            if (o46Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && o46Var.a != null) {
                o46Var.I(o46Var.position + 1);
                threadCardViewHolder.a().q(i);
                s36.b().a(o46Var.f("c12351"));
                threadCardViewHolder.a().b(this.c);
                threadCardViewHolder.s(true, Align.ALIGN_RIGHT_TOP);
                threadCardViewHolder.j();
                threadCardViewHolder.e(o46Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().p(this.h);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void z(View view2, rr4 rr4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, view2, rr4Var) == null) && view2 != null && rr4Var != null && view2.getId() != -1) {
            int id = view2.getId();
            if (id != R.id.obfuscated_res_0x7f0924f6 && id != R.id.obfuscated_res_0x7f0924c8) {
                if (id == R.id.obfuscated_res_0x7f0921d1 || id == R.id.obfuscated_res_0x7f0921c3 || id == R.id.obfuscated_res_0x7f0921d0) {
                    iy6.b(view2, rr4Var, 2);
                    return;
                }
                return;
            }
            iy6.b(view2, rr4Var, 1);
        }
    }
}
