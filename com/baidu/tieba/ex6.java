package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ItemClickJumpUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.ez;
import com.baidu.tieba.kx;
import com.baidu.tieba.ty;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ex6 extends rn implements ap5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext b;
    public String c;
    public ko d;
    public boolean e;
    public vg f;
    public vg g;
    public p26 h;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rn
    /* renamed from: A */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            return null;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rn
    /* renamed from: F */
    public View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, w26 w26Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, w26Var, threadCardViewHolder})) == null) {
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    /* loaded from: classes3.dex */
    public class a implements wg {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ex6 a;

        public a(ex6 ex6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ex6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ex6Var;
        }

        @Override // com.baidu.tieba.wg
        public /* bridge */ /* synthetic */ Object a(Object obj) {
            ImageView imageView = (ImageView) obj;
            e(imageView);
            return imageView;
        }

        @Override // com.baidu.tieba.wg
        public /* bridge */ /* synthetic */ Object c(Object obj) {
            ImageView imageView = (ImageView) obj;
            h(imageView);
            return imageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wg
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
                    foreDrawableImageView.P();
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
                    if (jq4.c().g()) {
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
                    foreDrawableImageView.P();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                    foreDrawableImageView.G();
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wg
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.b.getPageActivity());
                boolean g = jq4.c().g();
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
    public class b implements wg {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ex6 a;

        public b(ex6 ex6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ex6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ex6Var;
        }

        @Override // com.baidu.tieba.wg
        public /* bridge */ /* synthetic */ Object a(Object obj) {
            GifView gifView = (GifView) obj;
            e(gifView);
            return gifView;
        }

        @Override // com.baidu.tieba.wg
        public /* bridge */ /* synthetic */ Object c(Object obj) {
            GifView gifView = (GifView) obj;
            h(gifView);
            return gifView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wg
        /* renamed from: f */
        public void b(GifView gifView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gifView) == null) {
                gifView.setBackgroundDrawable(null);
                gifView.setImageDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                gifView.c0();
            }
        }

        public GifView h(GifView gifView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, gifView)) == null) {
                gifView.f0();
                gifView.c0();
                gifView.setImageDrawable(null);
                gifView.g0();
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
                if (jq4.c().g()) {
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
        @Override // com.baidu.tieba.wg
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.b.getPageActivity());
                boolean g = jq4.c().g();
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
    public class c extends p26 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ex6 b;

        public c(ex6 ex6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ex6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ex6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.p26
        /* renamed from: d */
        public void a(View view2, w26 w26Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, w26Var) != null) {
                return;
            }
            this.b.G(view2, w26Var);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements kx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(ex6 ex6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ex6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.kx.b
        public void a(ar4 ar4Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, ar4Var, view2) == null) && ar4Var != null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f0924a1) {
                    ar4Var.objType = 3;
                } else if (view2.getId() == R.id.obfuscated_res_0x7f092473) {
                    ar4Var.objType = 4;
                } else {
                    ar4Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements oo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ex6 a;

        public e(ex6 ex6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ex6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ex6Var;
        }

        @Override // com.baidu.tieba.oo
        public void b(View view2, eo eoVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, eoVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (eoVar instanceof xn) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                xn xnVar = (xn) eoVar;
                if (!(xnVar.c() instanceof w26)) {
                    return;
                }
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                w26 w26Var = (w26) xnVar.c();
                w26Var.f = 1;
                if (this.a.h != null) {
                    this.a.h.a(threadCardViewHolder.getView(), w26Var);
                }
                if (!m37.a(this.a.b, xnVar.c())) {
                    ThreadCardUtils.jumpToPB((ar4) w26Var, view2.getContext(), 1, false, lx.a((ko) viewGroup, view2, i));
                    threadCardViewHolder.a().o(new ez.a(1));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements oo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ex6 a;

        public f(ex6 ex6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ex6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ex6Var;
        }

        @Override // com.baidu.tieba.oo
        public void b(View view2, eo eoVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, eoVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (eoVar instanceof xn) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                xn xnVar = (xn) eoVar;
                if (!(xnVar.c() instanceof w26)) {
                    return;
                }
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                w26 w26Var = (w26) xnVar.c();
                w26Var.f = 1;
                if (this.a.h != null) {
                    this.a.h.a(threadCardViewHolder.getView(), w26Var);
                }
                ThreadCardUtils.jumpToPB((ar4) w26Var, view2.getContext(), 1, false);
                threadCardViewHolder.a().o(new ez.a(1));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements oo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ay a;
        public final /* synthetic */ ex6 b;

        public g(ex6 ex6Var, ay ayVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ex6Var, ayVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ex6Var;
            this.a = ayVar;
        }

        @Override // com.baidu.tieba.oo
        public void b(View view2, eo eoVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            w26 w26Var;
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, eoVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                boolean z = eoVar instanceof xn;
                int i2 = 0;
                if (z) {
                    xn xnVar = (xn) eoVar;
                    if ((xnVar.c() instanceof w26) && eoVar != null && xnVar.c() != null && (w26Var = (w26) xnVar.c()) != null && (threadData = w26Var.a) != null && w26Var.u && threadData.getItem() != null) {
                        if (w26Var.a.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                            BdToast b = BdToast.b(this.b.b.getContext(), this.b.b.getString(R.string.obfuscated_res_0x7f0f1551));
                            b.f(BdToast.ToastIcon.FAILURE);
                            b.i();
                            return;
                        }
                        int intValue = w26Var.a.getItem().button_link_type.intValue();
                        if (w26Var.a.getItem().apk_detail != null) {
                            i2 = w26Var.a.getItem().apk_detail.pkg_source.intValue();
                        }
                        int a = cz4.a(intValue, i2);
                        ItemData itemData = new ItemData();
                        itemData.parseProto(w26Var.a.getItem());
                        ItemCardHelper.q(this.a.y(), w26Var.a.getItem().item_id.longValue(), this.a.x(itemData), w26Var.a.getTid(), a, "", 2);
                        ItemClickJumpUtil.itemClickJump(w26Var.a.getItem().forum_name, String.valueOf(w26Var.a.getItem().item_id), 2, 2);
                        return;
                    }
                }
                if (z && (view2.getTag() instanceof ThreadCardViewHolder)) {
                    xn xnVar2 = (xn) eoVar;
                    if (!(xnVar2.c() instanceof w26)) {
                        return;
                    }
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    w26 w26Var2 = (w26) xnVar2.c();
                    w26Var2.f = 1;
                    if (this.b.h != null) {
                        this.b.h.a(threadCardViewHolder.getView(), w26Var2);
                    }
                    ThreadCardUtils.jumpToPB((ar4) w26Var2, view2.getContext(), 1, false, lx.a((ko) viewGroup, view2, i));
                    threadCardViewHolder.a().o(new ez.a(1));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements oo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ex6 a;

        public h(ex6 ex6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ex6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ex6Var;
        }

        @Override // com.baidu.tieba.oo
        public void b(View view2, eo eoVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, eoVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (eoVar instanceof xn) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                xn xnVar = (xn) eoVar;
                if (!(xnVar.c() instanceof w26)) {
                    return;
                }
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                w26 w26Var = (w26) xnVar.c();
                w26Var.f = 1;
                if (this.a.h != null) {
                    this.a.h.a(threadCardViewHolder.getView(), w26Var);
                }
                ThreadCardUtils.jumpToPB((ar4) w26Var, view2.getContext(), 1, false, lx.a((ko) viewGroup, view2, i));
                threadCardViewHolder.a().o(new ez.a(1));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements ThreadCommentAndPraiseInfoLayout.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;

        public i(ex6 ex6Var, ViewGroup viewGroup, View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ex6Var, viewGroup, view2, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = viewGroup;
            this.b = view2;
            this.c = i;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.l
        public void a(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, intentConfig) == null) && (intentConfig instanceof PbActivityConfig)) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(lx.a((ko) this.a, this.b, this.c));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ex6(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = true;
        this.f = new vg(new a(this), 12, 0);
        this.g = new vg(new b(this), 20, 0);
        this.h = new c(this);
        this.b = tbPageContext;
        v();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rn
    /* renamed from: w */
    public ThreadCardViewHolder onCreateBottomViewHolder(ViewGroup viewGroup, w26 w26Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, viewGroup, w26Var)) == null) {
            ty.b bVar = new ty.b(this.b.getPageActivity(), false);
            vy vyVar = new vy(this.b.getPageActivity());
            gr4 gr4Var = new gr4();
            gr4Var.b = 9;
            gr4Var.h = 9;
            vyVar.z(gr4Var);
            vyVar.B(9);
            vyVar.H("personalize_page");
            vyVar.G(4);
            vyVar.C(1);
            vyVar.f(32);
            vyVar.A(false);
            bVar.m(vyVar);
            ty k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.d);
            k.r(1);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new h(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rn
    /* renamed from: z */
    public ThreadCardViewHolder onCreateHeaderViewHolder(ViewGroup viewGroup, w26 w26Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, viewGroup, w26Var)) == null) {
            if (w26Var == null) {
                return null;
            }
            ty.b bVar = new ty.b(this.b.getPageActivity());
            if (w26Var.m) {
                kx kxVar = new kx(this.b.getPageActivity());
                kxVar.x(this.a);
                kxVar.f(128);
                kxVar.g(1024);
                kxVar.w(new d(this));
                bVar.o(kxVar);
            } else if (w26Var.n) {
                bVar.o(new tx(this.b.getPageActivity()));
            }
            ty k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.d);
            k.r(1);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new e(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    public void H(ko koVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, koVar) == null) {
            this.d = koVar;
        }
    }

    @Override // com.baidu.tieba.ap5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.c = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rn
    /* renamed from: B */
    public View onFillBottomViewHolder(int i2, View view2, ViewGroup viewGroup, w26 w26Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, w26Var, threadCardViewHolder})) == null) {
            if (w26Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && w26Var.a != null) {
                w26Var.I(w26Var.position + 1);
                threadCardViewHolder.a().q(i2);
                if (threadCardViewHolder.a().f() instanceof vy) {
                    ((vy) threadCardViewHolder.a().f()).F(new i(this, viewGroup, view2, i2));
                }
                if (threadCardViewHolder.a() instanceof zo5) {
                    threadCardViewHolder.a().b(this.c);
                }
                threadCardViewHolder.s(false, Align.ALIGN_RIGHT_BOTTOM);
                threadCardViewHolder.e(w26Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().p(this.h);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rn
    /* renamed from: C */
    public View onFillContentViewHolder(int i2, View view2, ViewGroup viewGroup, w26 w26Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, w26Var, threadCardViewHolder})) == null) {
            if (w26Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && w26Var.a != null) {
                w26Var.I(w26Var.position + 1);
                i26.b().a(w26Var.f("c12351"));
                threadCardViewHolder.a().q(i2);
                if (threadCardViewHolder.a() instanceof zo5) {
                    threadCardViewHolder.a().b(this.c);
                }
                if (w26Var.p) {
                    gy gyVar = (gy) threadCardViewHolder.a().g();
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gyVar.f.d.getLayoutParams();
                    layoutParams.width = w26Var.j;
                    layoutParams.height = w26Var.k;
                    if (gyVar.f.d.getVisibility() != 8) {
                        gyVar.f.d.setLayoutParams(layoutParams);
                    }
                }
                threadCardViewHolder.e(w26Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().p(this.h);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rn
    /* renamed from: E */
    public View onFillHeaderViewHolder(int i2, View view2, ViewGroup viewGroup, w26 w26Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, w26Var, threadCardViewHolder})) == null) {
            if (w26Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && w26Var.a != null) {
                w26Var.I(w26Var.position + 1);
                threadCardViewHolder.a().q(i2);
                if (threadCardViewHolder.a() instanceof zo5) {
                    threadCardViewHolder.a().b(this.c);
                }
                if (w26Var.m) {
                    threadCardViewHolder.s(true, Align.ALIGN_RIGHT_TOP);
                } else if (w26Var.n) {
                    i26.b().a(w26Var.B());
                    yo5.c().a(w26Var.B());
                    l37.i(w26Var.a, this.a, w26Var.n());
                }
                threadCardViewHolder.e(w26Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().p(this.h);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rn
    /* renamed from: D */
    public View onFillExtendViewHolder(int i2, View view2, ViewGroup viewGroup, w26 w26Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, w26Var, threadCardViewHolder})) == null) {
            if (w26Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && w26Var.a != null) {
                w26Var.I(w26Var.position + 1);
                threadCardViewHolder.a().q(i2);
                if (threadCardViewHolder.a() instanceof zo5) {
                    threadCardViewHolder.a().b(this.c);
                }
                if (w26Var.y) {
                    i26.b().a(new StatisticItem("c13424"));
                }
                threadCardViewHolder.e(w26Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().p(this.h);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void G(View view2, w26 w26Var) {
        StatisticItem A;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, view2, w26Var) == null) && view2 != null && w26Var != null && w26Var.getThreadData() != null && !StringUtils.isNull(w26Var.getThreadData().getTid())) {
            int id = view2.getId();
            int i2 = 1;
            if (w26Var.m) {
                if (id == R.id.obfuscated_res_0x7f09217d) {
                    zw6.b(view2, w26Var, 2);
                } else if (id != R.id.obfuscated_res_0x7f092473 && id != R.id.obfuscated_res_0x7f0924a1) {
                    if (view2 instanceof TbImageView) {
                        zw6.b(view2, w26Var, 3);
                    }
                } else {
                    zw6.b(view2, w26Var, 1);
                }
            } else if (w26Var.n) {
                i26.b().d(true);
                if (id != R.id.obfuscated_res_0x7f090a7c && id != R.id.obfuscated_res_0x7f090a7b && id != R.id.obfuscated_res_0x7f090a7d && id != R.id.obfuscated_res_0x7f090a7e) {
                    if (w26Var.isVideoThreadType()) {
                        A = w26Var.C();
                    } else {
                        A = w26Var.A();
                    }
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(A));
                    yo5.c().i("page_concern", "clk_", A);
                } else {
                    TiebaStatic.log(w26Var.j());
                    yo5.c().i("page_concern", "clk_", w26Var.j());
                    i2 = 9;
                }
                l37.d(w26Var.a, this.a, w26Var.n(), i2);
            } else if (!w26Var.o && !w26Var.p && !w26Var.q && !w26Var.r) {
                if (w26Var.v) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    if (threadCardViewHolder != null) {
                        ThreadCardUtils.jumpToPB((ar4) w26Var.getThreadData(), view2.getContext(), 1, false);
                        threadCardViewHolder.a().o(new ez.a(1));
                    }
                } else if (w26Var.x) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f09217d) {
                        zw6.b(view2, w26Var, 2);
                    } else if (id == R.id.obfuscated_res_0x7f090a99) {
                        zw6.b(view2, w26Var, 7);
                    }
                } else if (w26Var.y) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f09217d) {
                        zw6.b(view2, w26Var, 2);
                    } else if (id == R.id.obfuscated_res_0x7f090ce3) {
                        StatisticItem statisticItem = new StatisticItem("c13423");
                        statisticItem.param("obj_locate", 4);
                        statisticItem.param("tid", w26Var.g);
                        ThreadData threadData = w26Var.a;
                        if (threadData != null && threadData.getTopAgreePost() != null) {
                            statisticItem.param("pid", w26Var.a.getTopAgreePost().M());
                        }
                        TiebaStatic.log(statisticItem);
                    } else if (id == R.id.obfuscated_res_0x7f090cde) {
                        StatisticItem statisticItem2 = new StatisticItem("c13423");
                        statisticItem2.param("obj_locate", 2);
                        statisticItem2.param("tid", w26Var.g);
                        ThreadData threadData2 = w26Var.a;
                        if (threadData2 != null && threadData2.getTopAgreePost() != null) {
                            statisticItem2.param("pid", w26Var.a.getTopAgreePost().M());
                        }
                        TiebaStatic.log(statisticItem2);
                    } else if (id != R.id.obfuscated_res_0x7f090ce1 && id != R.id.obfuscated_res_0x7f090ce2) {
                        if (id == R.id.obfuscated_res_0x7f090cdd) {
                            StatisticItem statisticItem3 = new StatisticItem("c13423");
                            statisticItem3.param("obj_locate", 5);
                            statisticItem3.param("tid", w26Var.g);
                            ThreadData threadData3 = w26Var.a;
                            if (threadData3 != null && threadData3.getTopAgreePost() != null) {
                                statisticItem3.param("pid", w26Var.a.getTopAgreePost().M());
                            }
                            TiebaStatic.log(statisticItem3);
                        } else if ((view2 instanceof TbImageView) && (view2.getTag(R.id.obfuscated_res_0x7f090cdf) instanceof Integer)) {
                            StatisticItem statisticItem4 = new StatisticItem("c13423");
                            statisticItem4.param("obj_locate", 3);
                            statisticItem4.param("tid", w26Var.g);
                            ThreadData threadData4 = w26Var.a;
                            if (threadData4 != null && threadData4.getTopAgreePost() != null) {
                                statisticItem4.param("pid", w26Var.a.getTopAgreePost().M());
                            }
                            TiebaStatic.log(statisticItem4);
                        }
                    } else {
                        StatisticItem statisticItem5 = new StatisticItem("c13423");
                        statisticItem5.param("obj_locate", 1);
                        statisticItem5.param("tid", w26Var.g);
                        ThreadData threadData5 = w26Var.a;
                        if (threadData5 != null && threadData5.getTopAgreePost() != null) {
                            statisticItem5.param("pid", w26Var.a.getTopAgreePost().M());
                        }
                        TiebaStatic.log(statisticItem5);
                    }
                } else if (w26Var.A && (view2.getId() == R.id.obfuscated_res_0x7f09217d || view2.getId() == R.id.obfuscated_res_0x7f092191)) {
                    zw6.b(view2, w26Var, 2);
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09217d) {
                zw6.b(view2, w26Var, 2);
            } else if (view2 instanceof TbImageView) {
                zw6.b(view2, w26Var, 3);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09217e || view2.getId() == R.id.obfuscated_res_0x7f092170) {
                zw6.b(view2, w26Var, 2);
            }
            if (id == R.id.obfuscated_res_0x7f092191 || id == R.id.obfuscated_res_0x7f092193 || id == R.id.obfuscated_res_0x7f092194) {
                zw6.b(view2, w26Var, 8);
            }
        }
    }

    @Override // com.baidu.tieba.rn
    public BdUniqueId getBottomId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return w26.M;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rn
    public BdUniqueId getContentId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return w26.I;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rn
    public BdUniqueId getExtendId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return w26.L;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rn
    public BdUniqueId getHeaderId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return w26.D;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            e36.R = "c10705";
            e36.S = "c10730";
            e36.T = "c10731";
            e36.U = "c10704";
            e36.V = "c10755";
            e36.W = "c10710";
            e36.X = "c10736";
            e36.Y = "c10737";
            e36.Z = "c10711";
            e36.a0 = "c10758";
            e36.b0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rn
    /* renamed from: x */
    public ThreadCardViewHolder onCreateContentViewHolder(ViewGroup viewGroup, w26 w26Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, viewGroup, w26Var)) == null) {
            ty.b bVar = new ty.b(this.b.getPageActivity(), false);
            if (w26Var.o) {
                wx wxVar = new wx(this.b.getPageActivity());
                wxVar.G(this.f, this.g);
                wxVar.B(ImageViewerConfig.FROM_CONCERN);
                wxVar.D(1);
                wxVar.C(this.e);
                wxVar.A(1);
                bVar.n(wxVar);
            } else if (w26Var.p) {
                gy gyVar = new gy(this.b.getPageActivity());
                gyVar.u(ImageViewerConfig.FROM_CONCERN);
                gyVar.v(this.e);
                bVar.n(gyVar);
            } else if (w26Var.q) {
                dy dyVar = new dy(this.b.getPageActivity());
                dyVar.w(ImageViewerConfig.FROM_CONCERN);
                dyVar.x(this.e);
                bVar.n(dyVar);
            } else if (w26Var.r) {
                hy hyVar = new hy(this.b.getPageActivity());
                hyVar.v(ImageViewerConfig.FROM_CONCERN);
                hyVar.w(this.e);
                bVar.n(hyVar);
            }
            ty k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.d);
            k.r(1);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new f(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rn
    /* renamed from: y */
    public ThreadCardViewHolder onCreateExtendViewHolder(ViewGroup viewGroup, w26 w26Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048602, this, viewGroup, w26Var)) == null) {
            ty.b bVar = new ty.b(this.b.getPageActivity(), false);
            ay ayVar = new ay(this.b.getPageActivity());
            ayVar.D(2);
            ayVar.w();
            ayVar.A(true);
            bVar.h(ayVar);
            bVar.h(new py(this.b.getPageActivity()));
            bVar.h(new iy(this.b.getPageActivity()));
            rx rxVar = new rx(this.b.getPageActivity());
            rxVar.x();
            bVar.h(rxVar);
            vx vxVar = new vx(this.b.getPageActivity());
            vxVar.B(this.e);
            vxVar.A(ImageViewerConfig.FROM_CONCERN);
            bVar.h(vxVar);
            ty k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.d);
            k.r(1);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new g(this, ayVar));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }
}
