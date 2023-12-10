package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import com.baidu.tieba.cu;
import com.baidu.tieba.nu;
import com.baidu.tieba.rs;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class db8 extends ci<um6, ThreadCardViewHolder<um6>> implements e26 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public vi d;
    public boolean e;
    public pb<ImageView> f;
    public pb<GifView> g;
    public mm6<um6> h;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: D */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            return null;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: I */
    public View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, um6 um6Var, ThreadCardViewHolder<um6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, um6Var, threadCardViewHolder})) == null) {
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements qb<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ db8 a;

        public a(db8 db8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {db8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = db8Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.qb
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.qb
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qb
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
                    foreDrawableImageView.stopLoading();
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
                    if (qv4.c().g()) {
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
                    foreDrawableImageView.stopLoading();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                    foreDrawableImageView.reset();
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qb
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.b.getPageActivity());
                boolean g = qv4.c().g();
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

    /* loaded from: classes5.dex */
    public class b implements qb<GifView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ db8 a;

        public b(db8 db8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {db8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = db8Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.qb
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.qb
        public /* bridge */ /* synthetic */ GifView c(GifView gifView) {
            GifView gifView2 = gifView;
            h(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qb
        /* renamed from: f */
        public void b(GifView gifView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gifView) == null) {
                gifView.setBackgroundDrawable(null);
                gifView.setImageDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                gifView.h();
            }
        }

        public GifView h(GifView gifView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, gifView)) == null) {
                gifView.k();
                gifView.h();
                gifView.setImageDrawable(null);
                gifView.l();
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
                if (qv4.c().g()) {
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
        @Override // com.baidu.tieba.qb
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.b.getPageActivity());
                boolean g = qv4.c().g();
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

    /* loaded from: classes5.dex */
    public class c extends mm6<um6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ db8 b;

        public c(db8 db8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {db8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = db8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm6
        /* renamed from: d */
        public void a(View view2, um6 um6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, um6Var) != null) {
                return;
            }
            this.b.J(view2, um6Var);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements rs.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(db8 db8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {db8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.rs.b
        public void a(fw4 fw4Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, fw4Var, view2) == null) && fw4Var != null) {
                if (view2.getId() == R.id.user_name) {
                    fw4Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    fw4Var.objType = 4;
                } else {
                    fw4Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements zi {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ db8 a;

        public e(db8 db8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {db8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = db8Var;
        }

        @Override // com.baidu.tieba.zi
        public void b(View view2, pi piVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, piVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (piVar instanceof ii) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ii iiVar = (ii) piVar;
                if (!(iiVar.c() instanceof um6)) {
                    return;
                }
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                um6 um6Var = (um6) iiVar.c();
                um6Var.f = 1;
                if (this.a.h != null) {
                    this.a.h.a(threadCardViewHolder.getView(), um6Var);
                }
                if (!ki8.b(this.a.b, iiVar.c())) {
                    ThreadCardUtils.jumpToPB((fw4) um6Var, view2.getContext(), 1, false, ss.a((vi) viewGroup, view2, i));
                    threadCardViewHolder.a().q(new nu.a(1));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements zi {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ db8 a;

        public f(db8 db8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {db8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = db8Var;
        }

        @Override // com.baidu.tieba.zi
        public void b(View view2, pi piVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, piVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (piVar instanceof ii) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ii iiVar = (ii) piVar;
                if (!(iiVar.c() instanceof um6)) {
                    return;
                }
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                um6 um6Var = (um6) iiVar.c();
                um6Var.f = 1;
                if (this.a.h != null) {
                    this.a.h.a(threadCardViewHolder.getView(), um6Var);
                }
                ThreadCardUtils.jumpToPB((fw4) um6Var, view2.getContext(), 1, false);
                threadCardViewHolder.a().q(new nu.a(1));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements zi {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lt a;
        public final /* synthetic */ db8 b;

        public g(db8 db8Var, lt ltVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {db8Var, ltVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = db8Var;
            this.a = ltVar;
        }

        @Override // com.baidu.tieba.zi
        public void b(View view2, pi piVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            um6 um6Var;
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, piVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                boolean z = piVar instanceof ii;
                int i2 = 0;
                if (z) {
                    ii iiVar = (ii) piVar;
                    if ((iiVar.c() instanceof um6) && piVar != null && iiVar.c() != null && (um6Var = (um6) iiVar.c()) != null && (threadData = um6Var.a) != null && um6Var.u && threadData.getItem() != null) {
                        if (um6Var.a.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                            BdToast.makeText(this.b.b.getContext(), this.b.b.getString(R.string.video_is_checking)).setIcon(BdToast.ToastIcon.FAILURE).show();
                            return;
                        }
                        int intValue = um6Var.a.getItem().button_link_type.intValue();
                        if (um6Var.a.getItem().apk_detail != null) {
                            i2 = um6Var.a.getItem().apk_detail.pkg_source.intValue();
                        }
                        int a = m65.a(intValue, i2);
                        ItemData itemData = new ItemData();
                        itemData.parseProto(um6Var.a.getItem());
                        ItemCardHelper.q(this.a.z(), um6Var.a.getItem().item_id.longValue(), this.a.y(itemData), um6Var.a.getTid(), a, "", 2);
                        ItemClickJumpUtil.itemClickJump(um6Var.a.getItem().forum_name, String.valueOf(um6Var.a.getItem().item_id), 2, 2);
                        return;
                    }
                }
                if (z && (view2.getTag() instanceof ThreadCardViewHolder)) {
                    ii iiVar2 = (ii) piVar;
                    if (!(iiVar2.c() instanceof um6)) {
                        return;
                    }
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    um6 um6Var2 = (um6) iiVar2.c();
                    um6Var2.f = 1;
                    if (this.b.h != null) {
                        this.b.h.a(threadCardViewHolder.getView(), um6Var2);
                    }
                    ThreadCardUtils.jumpToPB((fw4) um6Var2, view2.getContext(), 1, false, ss.a((vi) viewGroup, view2, i));
                    threadCardViewHolder.a().q(new nu.a(1));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements zi {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ db8 a;

        public h(db8 db8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {db8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = db8Var;
        }

        @Override // com.baidu.tieba.zi
        public void b(View view2, pi piVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, piVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (piVar instanceof ii) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ii iiVar = (ii) piVar;
                if (!(iiVar.c() instanceof um6)) {
                    return;
                }
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                um6 um6Var = (um6) iiVar.c();
                um6Var.f = 1;
                if (this.a.h != null) {
                    this.a.h.a(threadCardViewHolder.getView(), um6Var);
                }
                ThreadCardUtils.jumpToPB((fw4) um6Var, view2.getContext(), 1, false, ss.a((vi) viewGroup, view2, i));
                threadCardViewHolder.a().q(new nu.a(1));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements ThreadCommentAndPraiseInfoLayout.n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;

        public i(db8 db8Var, ViewGroup viewGroup, View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {db8Var, viewGroup, view2, Integer.valueOf(i)};
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

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.n
        public void a(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, intentConfig) == null) && (intentConfig instanceof PbActivityConfig)) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(ss.a((vi) this.a, this.b, this.c));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public db8(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.f = new pb<>(new a(this), 12, 0);
        this.g = new pb<>(new b(this), 20, 0);
        this.h = new c(this);
        this.b = tbPageContext;
        y();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: C */
    public ThreadCardViewHolder<um6> onCreateHeaderViewHolder(ViewGroup viewGroup, um6 um6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, um6Var)) == null) {
            if (um6Var == null) {
                return null;
            }
            cu.b bVar = new cu.b(this.b.getPageActivity());
            if (um6Var.m) {
                rs rsVar = new rs(this.b.getPageActivity());
                rsVar.o(this.a);
                rsVar.b(128);
                rsVar.c(1024);
                rsVar.x(new d(this));
                bVar.o(rsVar);
            } else if (um6Var.n) {
                bVar.o(new bt(this.b.getPageActivity()));
            }
            cu k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.d);
            k.t(1);
            ThreadCardViewHolder<um6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new e(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: z */
    public ThreadCardViewHolder<um6> onCreateBottomViewHolder(ViewGroup viewGroup, um6 um6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, viewGroup, um6Var)) == null) {
            cu.b bVar = new cu.b(this.b.getPageActivity(), false);
            eu euVar = new eu(this.b.getPageActivity());
            lw4 lw4Var = new lw4();
            lw4Var.b = 9;
            lw4Var.h = 9;
            euVar.C(lw4Var);
            euVar.E(9);
            euVar.K("personalize_page");
            euVar.J(4);
            euVar.F(1);
            euVar.b(32);
            euVar.D(false);
            bVar.m(euVar);
            cu k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.d);
            k.t(1);
            ThreadCardViewHolder<um6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new h(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    public void K(vi viVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, viVar) == null) {
            this.d = viVar;
        }
    }

    @Override // com.baidu.tieba.e26
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.c = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: A */
    public ThreadCardViewHolder<um6> onCreateContentViewHolder(ViewGroup viewGroup, um6 um6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, viewGroup, um6Var)) == null) {
            cu.b bVar = new cu.b(this.b.getPageActivity(), false);
            if (um6Var.o) {
                et etVar = new et(this.b.getPageActivity());
                etVar.G(this.f, this.g);
                etVar.setFrom(ImageViewerConfig.FROM_CONCERN);
                etVar.D(1);
                etVar.C(this.e);
                etVar.B(1);
                bVar.n(etVar);
            } else if (um6Var.p) {
                bVar.n(qt.s(this.b.getPageActivity(), ImageViewerConfig.FROM_CONCERN, this.e));
            } else if (um6Var.q) {
                ot otVar = new ot(this.b.getPageActivity());
                otVar.setFrom(ImageViewerConfig.FROM_CONCERN);
                otVar.x(this.e);
                bVar.n(otVar);
            } else if (um6Var.r) {
                rt rtVar = new rt(this.b.getPageActivity());
                rtVar.setFrom(ImageViewerConfig.FROM_CONCERN);
                rtVar.u(this.e);
                bVar.n(rtVar);
            }
            cu k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.d);
            k.t(1);
            ThreadCardViewHolder<um6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new f(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: B */
    public ThreadCardViewHolder<um6> onCreateExtendViewHolder(ViewGroup viewGroup, um6 um6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, um6Var)) == null) {
            cu.b bVar = new cu.b(this.b.getPageActivity(), false);
            lt ltVar = new lt(this.b.getPageActivity());
            ltVar.E(2);
            ltVar.x();
            ltVar.B(true);
            bVar.h(ltVar);
            bVar.h(new yt(this.b.getPageActivity()));
            bVar.h(new st(this.b.getPageActivity()));
            zs zsVar = new zs(this.b.getPageActivity());
            zsVar.y();
            bVar.h(zsVar);
            dt dtVar = new dt(this.b.getPageActivity());
            dtVar.C(this.e);
            dtVar.B(ImageViewerConfig.FROM_CONCERN);
            bVar.h(dtVar);
            cu k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.d);
            k.t(1);
            ThreadCardViewHolder<um6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new g(this, ltVar));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: E */
    public View onFillBottomViewHolder(int i2, View view2, ViewGroup viewGroup, um6 um6Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, um6Var, threadCardViewHolder})) == null) {
            if (um6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && um6Var.a != null) {
                um6Var.B(um6Var.position + 1);
                threadCardViewHolder.a().s(i2);
                if (threadCardViewHolder.a().f() instanceof eu) {
                    ((eu) threadCardViewHolder.a().f()).I(new i(this, viewGroup, view2, i2));
                    if (um6Var.getThreadData() != null && um6Var.getThreadData().getIsManager() != 0) {
                        threadCardViewHolder.a().f().b(4);
                    }
                }
                if (threadCardViewHolder.a() instanceof d26) {
                    threadCardViewHolder.a().b(this.c);
                }
                threadCardViewHolder.x(false, Align.ALIGN_RIGHT_BOTTOM);
                threadCardViewHolder.e(um6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().r(this.h);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: F */
    public View onFillContentViewHolder(int i2, View view2, ViewGroup viewGroup, um6 um6Var, ThreadCardViewHolder<um6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, um6Var, threadCardViewHolder})) == null) {
            if (um6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && um6Var.a != null) {
                um6Var.B(um6Var.position + 1);
                em6.b().a(um6Var.d("c12351"));
                threadCardViewHolder.a().s(i2);
                if (threadCardViewHolder.a() instanceof d26) {
                    threadCardViewHolder.a().b(this.c);
                }
                if (um6Var.p) {
                    gm6.a(threadCardViewHolder.a().g(), um6Var.j, um6Var.k);
                }
                threadCardViewHolder.e(um6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().r(this.h);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: H */
    public View onFillHeaderViewHolder(int i2, View view2, ViewGroup viewGroup, um6 um6Var, ThreadCardViewHolder<um6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, um6Var, threadCardViewHolder})) == null) {
            if (um6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && um6Var.a != null) {
                um6Var.B(um6Var.position + 1);
                threadCardViewHolder.a().s(i2);
                if (threadCardViewHolder.a() instanceof d26) {
                    threadCardViewHolder.a().b(this.c);
                }
                if (um6Var.m) {
                    threadCardViewHolder.x(true, Align.ALIGN_RIGHT_TOP);
                } else if (um6Var.n) {
                    em6.b().a(um6Var.s());
                    c26.c().a(um6Var.s());
                    ii8.p(um6Var.a, this.a, um6Var.h());
                }
                threadCardViewHolder.e(um6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().r(this.h);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: G */
    public View onFillExtendViewHolder(int i2, View view2, ViewGroup viewGroup, um6 um6Var, ThreadCardViewHolder<um6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, um6Var, threadCardViewHolder})) == null) {
            if (um6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && um6Var.a != null) {
                um6Var.B(um6Var.position + 1);
                threadCardViewHolder.a().s(i2);
                if (threadCardViewHolder.a() instanceof d26) {
                    threadCardViewHolder.a().b(this.c);
                }
                if (um6Var.y) {
                    em6.b().a(new StatisticItem("c13424"));
                }
                threadCardViewHolder.e(um6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().r(this.h);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void J(View view2, um6 um6Var) {
        StatisticItem q;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, view2, um6Var) == null) && view2 != null && um6Var != null && um6Var.getThreadData() != null && !StringUtils.isNull(um6Var.getThreadData().getTid())) {
            int id = view2.getId();
            int i2 = 1;
            if (um6Var.m) {
                if (id == R.id.thread_card_root) {
                    za8.b(view2, um6Var, 2);
                } else if (id != R.id.user_avatar && id != R.id.user_name) {
                    if (view2 instanceof TbImageView) {
                        za8.b(view2, um6Var, 3);
                    }
                } else {
                    za8.b(view2, um6Var, 1);
                }
            } else if (um6Var.n) {
                em6.b().d(true);
                if (id != R.id.forum_head_image && id != R.id.forum_head_barname && id != R.id.forum_head_info_attention && id != R.id.forum_head_info_thread) {
                    if (um6Var.isVideoThreadType()) {
                        q = um6Var.t();
                    } else {
                        q = um6Var.q();
                    }
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(q));
                    c26.c().i("page_concern", "clk_", q);
                } else {
                    TiebaStatic.log(um6Var.f());
                    c26.c().i("page_concern", "clk_", um6Var.f());
                    i2 = 9;
                }
                ii8.d(um6Var.a, this.a, um6Var.h(), i2);
            } else if (!um6Var.o && !um6Var.p && !um6Var.q && !um6Var.r) {
                if (um6Var.v) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    if (threadCardViewHolder != null) {
                        ThreadCardUtils.jumpToPB((fw4) um6Var.getThreadData(), view2.getContext(), 1, false);
                        threadCardViewHolder.a().q(new nu.a(1));
                    }
                } else if (um6Var.x) {
                    if (view2.getId() == R.id.thread_card_root) {
                        za8.b(view2, um6Var, 2);
                    } else if (id == R.id.forum_name_text) {
                        za8.b(view2, um6Var, 7);
                    }
                } else if (um6Var.y) {
                    if (view2.getId() == R.id.thread_card_root) {
                        za8.b(view2, um6Var, 2);
                    } else if (id == R.id.god_reply_voice_btn) {
                        StatisticItem statisticItem = new StatisticItem("c13423");
                        statisticItem.param("obj_locate", 4);
                        statisticItem.param("tid", um6Var.g);
                        ThreadData threadData = um6Var.a;
                        if (threadData != null && threadData.getTopAgreePost() != null) {
                            statisticItem.param("pid", um6Var.a.getTopAgreePost().U());
                        }
                        TiebaStatic.log(statisticItem);
                    } else if (id == R.id.god_reply_content) {
                        StatisticItem statisticItem2 = new StatisticItem("c13423");
                        statisticItem2.param("obj_locate", 2);
                        statisticItem2.param("tid", um6Var.g);
                        ThreadData threadData2 = um6Var.a;
                        if (threadData2 != null && threadData2.getTopAgreePost() != null) {
                            statisticItem2.param("pid", um6Var.a.getTopAgreePost().U());
                        }
                        TiebaStatic.log(statisticItem2);
                    } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                        if (id == R.id.god_reply_agree_view) {
                            StatisticItem statisticItem3 = new StatisticItem("c13423");
                            statisticItem3.param("obj_locate", 5);
                            statisticItem3.param("tid", um6Var.g);
                            ThreadData threadData3 = um6Var.a;
                            if (threadData3 != null && threadData3.getTopAgreePost() != null) {
                                statisticItem3.param("pid", um6Var.a.getTopAgreePost().U());
                            }
                            TiebaStatic.log(statisticItem3);
                        } else if ((view2 instanceof TbImageView) && (view2.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
                            StatisticItem statisticItem4 = new StatisticItem("c13423");
                            statisticItem4.param("obj_locate", 3);
                            statisticItem4.param("tid", um6Var.g);
                            ThreadData threadData4 = um6Var.a;
                            if (threadData4 != null && threadData4.getTopAgreePost() != null) {
                                statisticItem4.param("pid", um6Var.a.getTopAgreePost().U());
                            }
                            TiebaStatic.log(statisticItem4);
                        }
                    } else {
                        StatisticItem statisticItem5 = new StatisticItem("c13423");
                        statisticItem5.param("obj_locate", 1);
                        statisticItem5.param("tid", um6Var.g);
                        ThreadData threadData5 = um6Var.a;
                        if (threadData5 != null && threadData5.getTopAgreePost() != null) {
                            statisticItem5.param("pid", um6Var.a.getTopAgreePost().U());
                        }
                        TiebaStatic.log(statisticItem5);
                    }
                } else if (um6Var.A && (view2.getId() == R.id.thread_card_root || view2.getId() == R.id.thread_info_commont_container)) {
                    za8.b(view2, um6Var, 2);
                }
            } else if (view2.getId() == R.id.thread_card_root) {
                za8.b(view2, um6Var, 2);
            } else if (view2 instanceof TbImageView) {
                za8.b(view2, um6Var, 3);
            } else if (view2.getId() == R.id.thread_card_title || view2.getId() == R.id.thread_card_abstract) {
                za8.b(view2, um6Var, 2);
            }
            if (id == R.id.thread_info_commont_container || id == R.id.thread_info_commont_img || id == R.id.thread_info_commont_num) {
                za8.b(view2, um6Var, 8);
            }
        }
    }

    @Override // com.baidu.tieba.ci
    public BdUniqueId getBottomId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return um6.M;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ci
    public BdUniqueId getContentId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return um6.I;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ci
    public BdUniqueId getExtendId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return um6.L;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ci
    public BdUniqueId getHeaderId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return um6.D;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            dn6.f1090T = "c10705";
            dn6.U = "c10730";
            dn6.V = "c10731";
            dn6.W = "c10704";
            dn6.X = "c10755";
            dn6.Y = "c10710";
            dn6.Z = "c10736";
            dn6.a0 = "c10737";
            dn6.b0 = "c10711";
            dn6.c0 = "c10758";
            dn6.d0 = "c10757";
        }
    }
}
