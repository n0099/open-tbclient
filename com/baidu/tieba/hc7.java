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
import com.baidu.tieba.cy;
import com.baidu.tieba.ny;
import com.baidu.tieba.rw;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class hc7 extends tm<sf6, ThreadCardViewHolder<sf6>> implements jx5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public mn d;
    public boolean e;
    public xf<ImageView> f;
    public xf<GifView> g;
    public lf6<sf6> h;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: C */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            return null;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: H */
    public View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, sf6 sf6Var, ThreadCardViewHolder<sf6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, sf6Var, threadCardViewHolder})) == null) {
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    /* loaded from: classes4.dex */
    public class a implements yf<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hc7 a;

        public a(hc7 hc7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hc7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hc7Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf
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
                    foreDrawableImageView.Q();
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
                    if (pv4.c().g()) {
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
                    foreDrawableImageView.Q();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                    foreDrawableImageView.H();
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.b.getPageActivity());
                boolean g = pv4.c().g();
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

    /* loaded from: classes4.dex */
    public class b implements yf<GifView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hc7 a;

        public b(hc7 hc7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hc7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hc7Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ GifView c(GifView gifView) {
            GifView gifView2 = gifView;
            h(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf
        /* renamed from: f */
        public void b(GifView gifView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gifView) == null) {
                gifView.setBackgroundDrawable(null);
                gifView.setImageDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                gifView.d0();
            }
        }

        public GifView h(GifView gifView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, gifView)) == null) {
                gifView.g0();
                gifView.d0();
                gifView.setImageDrawable(null);
                gifView.h0();
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
                if (pv4.c().g()) {
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
        @Override // com.baidu.tieba.yf
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.b.getPageActivity());
                boolean g = pv4.c().g();
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

    /* loaded from: classes4.dex */
    public class c extends lf6<sf6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hc7 b;

        public c(hc7 hc7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hc7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hc7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lf6
        /* renamed from: d */
        public void a(View view2, sf6 sf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, sf6Var) != null) {
                return;
            }
            this.b.I(view2, sf6Var);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements rw.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(hc7 hc7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hc7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.rw.b
        public void a(hw4 hw4Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, hw4Var, view2) == null) && hw4Var != null) {
                if (view2.getId() == R.id.user_name) {
                    hw4Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    hw4Var.objType = 4;
                } else {
                    hw4Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements qn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hc7 a;

        public e(hc7 hc7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hc7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hc7Var;
        }

        @Override // com.baidu.tieba.qn
        public void b(View view2, gn gnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, gnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (gnVar instanceof zm) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                zm zmVar = (zm) gnVar;
                if (!(zmVar.c() instanceof sf6)) {
                    return;
                }
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                sf6 sf6Var = (sf6) zmVar.c();
                sf6Var.f = 1;
                if (this.a.h != null) {
                    this.a.h.a(threadCardViewHolder.getView(), sf6Var);
                }
                if (!qi7.a(this.a.b, zmVar.c())) {
                    ThreadCardUtils.jumpToPB((hw4) sf6Var, view2.getContext(), 1, false, sw.a((mn) viewGroup, view2, i));
                    threadCardViewHolder.a().p(new ny.a(1));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements qn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hc7 a;

        public f(hc7 hc7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hc7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hc7Var;
        }

        @Override // com.baidu.tieba.qn
        public void b(View view2, gn gnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, gnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (gnVar instanceof zm) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                zm zmVar = (zm) gnVar;
                if (!(zmVar.c() instanceof sf6)) {
                    return;
                }
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                sf6 sf6Var = (sf6) zmVar.c();
                sf6Var.f = 1;
                if (this.a.h != null) {
                    this.a.h.a(threadCardViewHolder.getView(), sf6Var);
                }
                ThreadCardUtils.jumpToPB((hw4) sf6Var, view2.getContext(), 1, false);
                threadCardViewHolder.a().p(new ny.a(1));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements qn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jx a;
        public final /* synthetic */ hc7 b;

        public g(hc7 hc7Var, jx jxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hc7Var, jxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hc7Var;
            this.a = jxVar;
        }

        @Override // com.baidu.tieba.qn
        public void b(View view2, gn gnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            sf6 sf6Var;
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, gnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                boolean z = gnVar instanceof zm;
                int i2 = 0;
                if (z) {
                    zm zmVar = (zm) gnVar;
                    if ((zmVar.c() instanceof sf6) && gnVar != null && zmVar.c() != null && (sf6Var = (sf6) zmVar.c()) != null && (threadData = sf6Var.a) != null && sf6Var.u && threadData.getItem() != null) {
                        if (sf6Var.a.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                            BdToast b = BdToast.b(this.b.b.getContext(), this.b.b.getString(R.string.video_is_checking));
                            b.g(BdToast.ToastIcon.FAILURE);
                            b.k();
                            return;
                        }
                        int intValue = sf6Var.a.getItem().button_link_type.intValue();
                        if (sf6Var.a.getItem().apk_detail != null) {
                            i2 = sf6Var.a.getItem().apk_detail.pkg_source.intValue();
                        }
                        int a = t45.a(intValue, i2);
                        ItemData itemData = new ItemData();
                        itemData.parseProto(sf6Var.a.getItem());
                        ItemCardHelper.q(this.a.y(), sf6Var.a.getItem().item_id.longValue(), this.a.x(itemData), sf6Var.a.getTid(), a, "", 2);
                        ItemClickJumpUtil.itemClickJump(sf6Var.a.getItem().forum_name, String.valueOf(sf6Var.a.getItem().item_id), 2, 2);
                        return;
                    }
                }
                if (z && (view2.getTag() instanceof ThreadCardViewHolder)) {
                    zm zmVar2 = (zm) gnVar;
                    if (!(zmVar2.c() instanceof sf6)) {
                        return;
                    }
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    sf6 sf6Var2 = (sf6) zmVar2.c();
                    sf6Var2.f = 1;
                    if (this.b.h != null) {
                        this.b.h.a(threadCardViewHolder.getView(), sf6Var2);
                    }
                    ThreadCardUtils.jumpToPB((hw4) sf6Var2, view2.getContext(), 1, false, sw.a((mn) viewGroup, view2, i));
                    threadCardViewHolder.a().p(new ny.a(1));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements qn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hc7 a;

        public h(hc7 hc7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hc7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hc7Var;
        }

        @Override // com.baidu.tieba.qn
        public void b(View view2, gn gnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, gnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (gnVar instanceof zm) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                zm zmVar = (zm) gnVar;
                if (!(zmVar.c() instanceof sf6)) {
                    return;
                }
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                sf6 sf6Var = (sf6) zmVar.c();
                sf6Var.f = 1;
                if (this.a.h != null) {
                    this.a.h.a(threadCardViewHolder.getView(), sf6Var);
                }
                ThreadCardUtils.jumpToPB((hw4) sf6Var, view2.getContext(), 1, false, sw.a((mn) viewGroup, view2, i));
                threadCardViewHolder.a().p(new ny.a(1));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements ThreadCommentAndPraiseInfoLayout.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;

        public i(hc7 hc7Var, ViewGroup viewGroup, View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hc7Var, viewGroup, view2, Integer.valueOf(i)};
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
                ((PbActivityConfig) intentConfig).setVideoOriginArea(sw.a((mn) this.a, this.b, this.c));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hc7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.f = new xf<>(new a(this), 12, 0);
        this.g = new xf<>(new b(this), 20, 0);
        this.h = new c(this);
        this.b = tbPageContext;
        x();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: B */
    public ThreadCardViewHolder<sf6> onCreateHeaderViewHolder(ViewGroup viewGroup, sf6 sf6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, sf6Var)) == null) {
            if (sf6Var == null) {
                return null;
            }
            cy.b bVar = new cy.b(this.b.getPageActivity());
            if (sf6Var.m) {
                rw rwVar = new rw(this.b.getPageActivity());
                rwVar.x(this.a);
                rwVar.f(128);
                rwVar.g(1024);
                rwVar.w(new d(this));
                bVar.o(rwVar);
            } else if (sf6Var.n) {
                bVar.o(new ax(this.b.getPageActivity()));
            }
            cy k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.d);
            k.s(1);
            ThreadCardViewHolder<sf6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new e(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: y */
    public ThreadCardViewHolder<sf6> onCreateBottomViewHolder(ViewGroup viewGroup, sf6 sf6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048602, this, viewGroup, sf6Var)) == null) {
            cy.b bVar = new cy.b(this.b.getPageActivity(), false);
            ey eyVar = new ey(this.b.getPageActivity());
            nw4 nw4Var = new nw4();
            nw4Var.b = 9;
            nw4Var.h = 9;
            eyVar.z(nw4Var);
            eyVar.B(9);
            eyVar.H("personalize_page");
            eyVar.G(4);
            eyVar.C(1);
            eyVar.f(32);
            eyVar.A(false);
            bVar.m(eyVar);
            cy k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.d);
            k.s(1);
            ThreadCardViewHolder<sf6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new h(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    public void J(mn mnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, mnVar) == null) {
            this.d = mnVar;
        }
    }

    @Override // com.baidu.tieba.jx5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.c = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: A */
    public ThreadCardViewHolder<sf6> onCreateExtendViewHolder(ViewGroup viewGroup, sf6 sf6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, viewGroup, sf6Var)) == null) {
            cy.b bVar = new cy.b(this.b.getPageActivity(), false);
            jx jxVar = new jx(this.b.getPageActivity());
            jxVar.D(2);
            jxVar.w();
            jxVar.A(true);
            bVar.h(jxVar);
            bVar.h(new yx(this.b.getPageActivity()));
            bVar.h(new rx(this.b.getPageActivity()));
            yw ywVar = new yw(this.b.getPageActivity());
            ywVar.x();
            bVar.h(ywVar);
            cx cxVar = new cx(this.b.getPageActivity());
            cxVar.B(this.e);
            cxVar.A(ImageViewerConfig.FROM_CONCERN);
            bVar.h(cxVar);
            cy k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.d);
            k.s(1);
            ThreadCardViewHolder<sf6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new g(this, jxVar));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: z */
    public ThreadCardViewHolder<sf6> onCreateContentViewHolder(ViewGroup viewGroup, sf6 sf6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, viewGroup, sf6Var)) == null) {
            cy.b bVar = new cy.b(this.b.getPageActivity(), false);
            if (sf6Var.o) {
                dx dxVar = new dx(this.b.getPageActivity());
                dxVar.G(this.f, this.g);
                dxVar.B(ImageViewerConfig.FROM_CONCERN);
                dxVar.D(1);
                dxVar.C(this.e);
                dxVar.A(1);
                bVar.n(dxVar);
            } else if (sf6Var.p) {
                px pxVar = new px(this.b.getPageActivity());
                pxVar.u(ImageViewerConfig.FROM_CONCERN);
                pxVar.v(this.e);
                bVar.n(pxVar);
            } else if (sf6Var.q) {
                mx mxVar = new mx(this.b.getPageActivity());
                mxVar.w(ImageViewerConfig.FROM_CONCERN);
                mxVar.x(this.e);
                bVar.n(mxVar);
            } else if (sf6Var.r) {
                qx qxVar = new qx(this.b.getPageActivity());
                qxVar.v(ImageViewerConfig.FROM_CONCERN);
                qxVar.w(this.e);
                bVar.n(qxVar);
            }
            cy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.d);
            k.s(1);
            ThreadCardViewHolder<sf6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new f(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: D */
    public View onFillBottomViewHolder(int i2, View view2, ViewGroup viewGroup, sf6 sf6Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, sf6Var, threadCardViewHolder})) == null) {
            if (sf6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && sf6Var.a != null) {
                sf6Var.E(sf6Var.position + 1);
                threadCardViewHolder.a().r(i2);
                if (threadCardViewHolder.a().f() instanceof ey) {
                    ((ey) threadCardViewHolder.a().f()).F(new i(this, viewGroup, view2, i2));
                }
                if (threadCardViewHolder.a() instanceof ix5) {
                    threadCardViewHolder.a().b(this.c);
                }
                threadCardViewHolder.s(false, Align.ALIGN_RIGHT_BOTTOM);
                threadCardViewHolder.e(sf6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.h);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: E */
    public View onFillContentViewHolder(int i2, View view2, ViewGroup viewGroup, sf6 sf6Var, ThreadCardViewHolder<sf6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, sf6Var, threadCardViewHolder})) == null) {
            if (sf6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && sf6Var.a != null) {
                sf6Var.E(sf6Var.position + 1);
                ef6.b().a(sf6Var.f("c12351"));
                threadCardViewHolder.a().r(i2);
                if (threadCardViewHolder.a() instanceof ix5) {
                    threadCardViewHolder.a().b(this.c);
                }
                if (sf6Var.p) {
                    px pxVar = (px) threadCardViewHolder.a().g();
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pxVar.f.d.getLayoutParams();
                    layoutParams.width = sf6Var.j;
                    layoutParams.height = sf6Var.k;
                    if (pxVar.f.d.getVisibility() != 8) {
                        pxVar.f.d.setLayoutParams(layoutParams);
                    }
                }
                threadCardViewHolder.e(sf6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.h);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: G */
    public View onFillHeaderViewHolder(int i2, View view2, ViewGroup viewGroup, sf6 sf6Var, ThreadCardViewHolder<sf6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, sf6Var, threadCardViewHolder})) == null) {
            if (sf6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && sf6Var.a != null) {
                sf6Var.E(sf6Var.position + 1);
                threadCardViewHolder.a().r(i2);
                if (threadCardViewHolder.a() instanceof ix5) {
                    threadCardViewHolder.a().b(this.c);
                }
                if (sf6Var.m) {
                    threadCardViewHolder.s(true, Align.ALIGN_RIGHT_TOP);
                } else if (sf6Var.n) {
                    ef6.b().a(sf6Var.u());
                    hx5.c().a(sf6Var.u());
                    pi7.p(sf6Var.a, this.a, sf6Var.k());
                }
                threadCardViewHolder.e(sf6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.h);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: F */
    public View onFillExtendViewHolder(int i2, View view2, ViewGroup viewGroup, sf6 sf6Var, ThreadCardViewHolder<sf6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, sf6Var, threadCardViewHolder})) == null) {
            if (sf6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && sf6Var.a != null) {
                sf6Var.E(sf6Var.position + 1);
                threadCardViewHolder.a().r(i2);
                if (threadCardViewHolder.a() instanceof ix5) {
                    threadCardViewHolder.a().b(this.c);
                }
                if (sf6Var.y) {
                    ef6.b().a(new StatisticItem("c13424"));
                }
                threadCardViewHolder.e(sf6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.h);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void I(View view2, sf6 sf6Var) {
        StatisticItem t;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, sf6Var) == null) && view2 != null && sf6Var != null && sf6Var.getThreadData() != null && !StringUtils.isNull(sf6Var.getThreadData().getTid())) {
            int id = view2.getId();
            int i2 = 1;
            if (sf6Var.m) {
                if (id == R.id.thread_card_root) {
                    cc7.b(view2, sf6Var, 2);
                } else if (id != R.id.user_avatar && id != R.id.user_name) {
                    if (view2 instanceof TbImageView) {
                        cc7.b(view2, sf6Var, 3);
                    }
                } else {
                    cc7.b(view2, sf6Var, 1);
                }
            } else if (sf6Var.n) {
                ef6.b().d(true);
                if (id != R.id.forum_head_image && id != R.id.forum_head_barname && id != R.id.forum_head_info_attention && id != R.id.forum_head_info_thread) {
                    if (sf6Var.isVideoThreadType()) {
                        t = sf6Var.v();
                    } else {
                        t = sf6Var.t();
                    }
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(t));
                    hx5.c().i("page_concern", "clk_", t);
                } else {
                    TiebaStatic.log(sf6Var.h());
                    hx5.c().i("page_concern", "clk_", sf6Var.h());
                    i2 = 9;
                }
                pi7.d(sf6Var.a, this.a, sf6Var.k(), i2);
            } else if (!sf6Var.o && !sf6Var.p && !sf6Var.q && !sf6Var.r) {
                if (sf6Var.v) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    if (threadCardViewHolder != null) {
                        ThreadCardUtils.jumpToPB((hw4) sf6Var.getThreadData(), view2.getContext(), 1, false);
                        threadCardViewHolder.a().p(new ny.a(1));
                    }
                } else if (sf6Var.x) {
                    if (view2.getId() == R.id.thread_card_root) {
                        cc7.b(view2, sf6Var, 2);
                    } else if (id == R.id.forum_name_text) {
                        cc7.b(view2, sf6Var, 7);
                    }
                } else if (sf6Var.y) {
                    if (view2.getId() == R.id.thread_card_root) {
                        cc7.b(view2, sf6Var, 2);
                    } else if (id == R.id.god_reply_voice_btn) {
                        StatisticItem statisticItem = new StatisticItem("c13423");
                        statisticItem.param("obj_locate", 4);
                        statisticItem.param("tid", sf6Var.g);
                        ThreadData threadData = sf6Var.a;
                        if (threadData != null && threadData.getTopAgreePost() != null) {
                            statisticItem.param("pid", sf6Var.a.getTopAgreePost().O());
                        }
                        TiebaStatic.log(statisticItem);
                    } else if (id == R.id.god_reply_content) {
                        StatisticItem statisticItem2 = new StatisticItem("c13423");
                        statisticItem2.param("obj_locate", 2);
                        statisticItem2.param("tid", sf6Var.g);
                        ThreadData threadData2 = sf6Var.a;
                        if (threadData2 != null && threadData2.getTopAgreePost() != null) {
                            statisticItem2.param("pid", sf6Var.a.getTopAgreePost().O());
                        }
                        TiebaStatic.log(statisticItem2);
                    } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                        if (id == R.id.god_reply_agree_view) {
                            StatisticItem statisticItem3 = new StatisticItem("c13423");
                            statisticItem3.param("obj_locate", 5);
                            statisticItem3.param("tid", sf6Var.g);
                            ThreadData threadData3 = sf6Var.a;
                            if (threadData3 != null && threadData3.getTopAgreePost() != null) {
                                statisticItem3.param("pid", sf6Var.a.getTopAgreePost().O());
                            }
                            TiebaStatic.log(statisticItem3);
                        } else if ((view2 instanceof TbImageView) && (view2.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
                            StatisticItem statisticItem4 = new StatisticItem("c13423");
                            statisticItem4.param("obj_locate", 3);
                            statisticItem4.param("tid", sf6Var.g);
                            ThreadData threadData4 = sf6Var.a;
                            if (threadData4 != null && threadData4.getTopAgreePost() != null) {
                                statisticItem4.param("pid", sf6Var.a.getTopAgreePost().O());
                            }
                            TiebaStatic.log(statisticItem4);
                        }
                    } else {
                        StatisticItem statisticItem5 = new StatisticItem("c13423");
                        statisticItem5.param("obj_locate", 1);
                        statisticItem5.param("tid", sf6Var.g);
                        ThreadData threadData5 = sf6Var.a;
                        if (threadData5 != null && threadData5.getTopAgreePost() != null) {
                            statisticItem5.param("pid", sf6Var.a.getTopAgreePost().O());
                        }
                        TiebaStatic.log(statisticItem5);
                    }
                } else if (sf6Var.A && (view2.getId() == R.id.thread_card_root || view2.getId() == R.id.thread_info_commont_container)) {
                    cc7.b(view2, sf6Var, 2);
                }
            } else if (view2.getId() == R.id.thread_card_root) {
                cc7.b(view2, sf6Var, 2);
            } else if (view2 instanceof TbImageView) {
                cc7.b(view2, sf6Var, 3);
            } else if (view2.getId() == R.id.thread_card_title || view2.getId() == R.id.thread_card_abstract) {
                cc7.b(view2, sf6Var, 2);
            }
            if (id == R.id.thread_info_commont_container || id == R.id.thread_info_commont_img || id == R.id.thread_info_commont_num) {
                cc7.b(view2, sf6Var, 8);
            }
        }
    }

    @Override // com.baidu.tieba.tm
    public BdUniqueId getBottomId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return sf6.M;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tm
    public BdUniqueId getContentId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return sf6.I;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tm
    public BdUniqueId getExtendId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return sf6.L;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tm
    public BdUniqueId getHeaderId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return sf6.D;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            ag6.S = "c10705";
            ag6.T = "c10730";
            ag6.U = "c10731";
            ag6.V = "c10704";
            ag6.W = "c10755";
            ag6.X = "c10710";
            ag6.Y = "c10736";
            ag6.Z = "c10737";
            ag6.a0 = "c10711";
            ag6.b0 = "c10758";
            ag6.c0 = "c10757";
        }
    }
}
