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
import com.baidu.tieba.ay;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.mz;
import com.baidu.tieba.xz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class e08 extends ln<cq6, ThreadCardViewHolder<cq6>> implements t66 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public eo d;
    public boolean e;
    public ng<ImageView> f;
    public ng<GifView> g;
    public up6<cq6> h;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
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
    @Override // com.baidu.tieba.ln
    /* renamed from: H */
    public View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, cq6 cq6Var, ThreadCardViewHolder<cq6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, cq6Var, threadCardViewHolder})) == null) {
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements og<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e08 a;

        public a(e08 e08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e08Var;
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
                    foreDrawableImageView.R();
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
                    if (a15.c().g()) {
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
                    foreDrawableImageView.R();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                    foreDrawableImageView.H();
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
                boolean g = a15.c().g();
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
    public class b implements og<GifView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e08 a;

        public b(e08 e08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e08Var;
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
                gifView.e0();
            }
        }

        public GifView h(GifView gifView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, gifView)) == null) {
                gifView.h0();
                gifView.e0();
                gifView.setImageDrawable(null);
                gifView.i0();
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
                if (a15.c().g()) {
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
                boolean g = a15.c().g();
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
    public class c extends up6<cq6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e08 b;

        public c(e08 e08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = e08Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.up6
        /* renamed from: d */
        public void a(View view2, cq6 cq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, cq6Var) != null) {
                return;
            }
            this.b.I(view2, cq6Var);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ay.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(e08 e08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.ay.b
        public void a(t15 t15Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, t15Var, view2) == null) && t15Var != null) {
                if (view2.getId() == R.id.user_name) {
                    t15Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    t15Var.objType = 4;
                } else {
                    t15Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements io {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e08 a;

        public e(e08 e08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e08Var;
        }

        @Override // com.baidu.tieba.io
        public void b(View view2, yn ynVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, ynVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (ynVar instanceof rn) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                rn rnVar = (rn) ynVar;
                if (!(rnVar.c() instanceof cq6)) {
                    return;
                }
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                cq6 cq6Var = (cq6) rnVar.c();
                cq6Var.f = 1;
                if (this.a.h != null) {
                    this.a.h.a(threadCardViewHolder.getView(), cq6Var);
                }
                if (!y68.a(this.a.b, rnVar.c())) {
                    ThreadCardUtils.jumpToPB((t15) cq6Var, view2.getContext(), 1, false, by.a((eo) viewGroup, view2, i));
                    threadCardViewHolder.b().p(new xz.a(1));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements io {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e08 a;

        public f(e08 e08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e08Var;
        }

        @Override // com.baidu.tieba.io
        public void b(View view2, yn ynVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, ynVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (ynVar instanceof rn) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                rn rnVar = (rn) ynVar;
                if (!(rnVar.c() instanceof cq6)) {
                    return;
                }
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                cq6 cq6Var = (cq6) rnVar.c();
                cq6Var.f = 1;
                if (this.a.h != null) {
                    this.a.h.a(threadCardViewHolder.getView(), cq6Var);
                }
                ThreadCardUtils.jumpToPB((t15) cq6Var, view2.getContext(), 1, false);
                threadCardViewHolder.b().p(new xz.a(1));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements io {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uy a;
        public final /* synthetic */ e08 b;

        public g(e08 e08Var, uy uyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e08Var, uyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = e08Var;
            this.a = uyVar;
        }

        @Override // com.baidu.tieba.io
        public void b(View view2, yn ynVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            cq6 cq6Var;
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, ynVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                boolean z = ynVar instanceof rn;
                int i2 = 0;
                if (z) {
                    rn rnVar = (rn) ynVar;
                    if ((rnVar.c() instanceof cq6) && ynVar != null && rnVar.c() != null && (cq6Var = (cq6) rnVar.c()) != null && (threadData = cq6Var.a) != null && cq6Var.u && threadData.getItem() != null) {
                        if (cq6Var.a.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                            BdToast b = BdToast.b(this.b.b.getContext(), this.b.b.getString(R.string.video_is_checking));
                            b.g(BdToast.ToastIcon.FAILURE);
                            b.q();
                            return;
                        }
                        int intValue = cq6Var.a.getItem().button_link_type.intValue();
                        if (cq6Var.a.getItem().apk_detail != null) {
                            i2 = cq6Var.a.getItem().apk_detail.pkg_source.intValue();
                        }
                        int a = qb5.a(intValue, i2);
                        ItemData itemData = new ItemData();
                        itemData.parseProto(cq6Var.a.getItem());
                        ItemCardHelper.q(this.a.C(), cq6Var.a.getItem().item_id.longValue(), this.a.B(itemData), cq6Var.a.getTid(), a, "", 2);
                        ItemClickJumpUtil.itemClickJump(cq6Var.a.getItem().forum_name, String.valueOf(cq6Var.a.getItem().item_id), 2, 2);
                        return;
                    }
                }
                if (z && (view2.getTag() instanceof ThreadCardViewHolder)) {
                    rn rnVar2 = (rn) ynVar;
                    if (!(rnVar2.c() instanceof cq6)) {
                        return;
                    }
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    cq6 cq6Var2 = (cq6) rnVar2.c();
                    cq6Var2.f = 1;
                    if (this.b.h != null) {
                        this.b.h.a(threadCardViewHolder.getView(), cq6Var2);
                    }
                    ThreadCardUtils.jumpToPB((t15) cq6Var2, view2.getContext(), 1, false, by.a((eo) viewGroup, view2, i));
                    threadCardViewHolder.b().p(new xz.a(1));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements io {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e08 a;

        public h(e08 e08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e08Var;
        }

        @Override // com.baidu.tieba.io
        public void b(View view2, yn ynVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, ynVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (ynVar instanceof rn) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                rn rnVar = (rn) ynVar;
                if (!(rnVar.c() instanceof cq6)) {
                    return;
                }
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                cq6 cq6Var = (cq6) rnVar.c();
                cq6Var.f = 1;
                if (this.a.h != null) {
                    this.a.h.a(threadCardViewHolder.getView(), cq6Var);
                }
                ThreadCardUtils.jumpToPB((t15) cq6Var, view2.getContext(), 1, false, by.a((eo) viewGroup, view2, i));
                threadCardViewHolder.b().p(new xz.a(1));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements ThreadCommentAndPraiseInfoLayout.m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;

        public i(e08 e08Var, ViewGroup viewGroup, View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e08Var, viewGroup, view2, Integer.valueOf(i)};
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

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.m
        public void a(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, intentConfig) == null) && (intentConfig instanceof PbActivityConfig)) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(by.a((eo) this.a, this.b, this.c));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e08(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.f = new ng<>(new a(this), 12, 0);
        this.g = new ng<>(new b(this), 20, 0);
        this.h = new c(this);
        this.b = tbPageContext;
        x();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: B */
    public ThreadCardViewHolder<cq6> onCreateHeaderViewHolder(ViewGroup viewGroup, cq6 cq6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, cq6Var)) == null) {
            if (cq6Var == null) {
                return null;
            }
            mz.b bVar = new mz.b(this.b.getPageActivity());
            if (cq6Var.m) {
                ay ayVar = new ay(this.b.getPageActivity());
                ayVar.r(this.a);
                ayVar.g(128);
                ayVar.h(1024);
                ayVar.A(new d(this));
                bVar.o(ayVar);
            } else if (cq6Var.n) {
                bVar.o(new ky(this.b.getPageActivity()));
            }
            mz k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.d);
            k.s(1);
            ThreadCardViewHolder<cq6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.j(this.a);
            setOnAdapterItemClickListener(new e(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: y */
    public ThreadCardViewHolder<cq6> onCreateBottomViewHolder(ViewGroup viewGroup, cq6 cq6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048602, this, viewGroup, cq6Var)) == null) {
            mz.b bVar = new mz.b(this.b.getPageActivity(), false);
            oz ozVar = new oz(this.b.getPageActivity());
            z15 z15Var = new z15();
            z15Var.b = 9;
            z15Var.h = 9;
            ozVar.D(z15Var);
            ozVar.F(9);
            ozVar.M("personalize_page");
            ozVar.L(4);
            ozVar.G(1);
            ozVar.g(32);
            ozVar.E(false);
            bVar.m(ozVar);
            mz k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.d);
            k.s(1);
            ThreadCardViewHolder<cq6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.j(this.a);
            setOnAdapterItemClickListener(new h(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    public void J(eo eoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, eoVar) == null) {
            this.d = eoVar;
        }
    }

    @Override // com.baidu.tieba.t66
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.c = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: A */
    public ThreadCardViewHolder<cq6> onCreateExtendViewHolder(ViewGroup viewGroup, cq6 cq6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, viewGroup, cq6Var)) == null) {
            mz.b bVar = new mz.b(this.b.getPageActivity(), false);
            uy uyVar = new uy(this.b.getPageActivity());
            uyVar.H(2);
            uyVar.A();
            uyVar.E(true);
            bVar.h(uyVar);
            bVar.h(new iz(this.b.getPageActivity()));
            bVar.h(new bz(this.b.getPageActivity()));
            iy iyVar = new iy(this.b.getPageActivity());
            iyVar.B();
            bVar.h(iyVar);
            my myVar = new my(this.b.getPageActivity());
            myVar.F(this.e);
            myVar.E(ImageViewerConfig.FROM_CONCERN);
            bVar.h(myVar);
            mz k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.d);
            k.s(1);
            ThreadCardViewHolder<cq6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.j(this.a);
            setOnAdapterItemClickListener(new g(this, uyVar));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: z */
    public ThreadCardViewHolder<cq6> onCreateContentViewHolder(ViewGroup viewGroup, cq6 cq6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, viewGroup, cq6Var)) == null) {
            mz.b bVar = new mz.b(this.b.getPageActivity(), false);
            if (cq6Var.o) {
                ny nyVar = new ny(this.b.getPageActivity());
                nyVar.J(this.f, this.g);
                nyVar.setFrom(ImageViewerConfig.FROM_CONCERN);
                nyVar.G(1);
                nyVar.F(this.e);
                nyVar.E(1);
                bVar.n(nyVar);
            } else if (cq6Var.p) {
                zy zyVar = new zy(this.b.getPageActivity());
                zyVar.setFrom(ImageViewerConfig.FROM_CONCERN);
                zyVar.y(this.e);
                bVar.n(zyVar);
            } else if (cq6Var.q) {
                xy xyVar = new xy(this.b.getPageActivity());
                xyVar.setFrom(ImageViewerConfig.FROM_CONCERN);
                xyVar.A(this.e);
                bVar.n(xyVar);
            } else if (cq6Var.r) {
                az azVar = new az(this.b.getPageActivity());
                azVar.setFrom(ImageViewerConfig.FROM_CONCERN);
                azVar.z(this.e);
                bVar.n(azVar);
            }
            mz k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.d);
            k.s(1);
            ThreadCardViewHolder<cq6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.j(this.a);
            setOnAdapterItemClickListener(new f(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: D */
    public View onFillBottomViewHolder(int i2, View view2, ViewGroup viewGroup, cq6 cq6Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, cq6Var, threadCardViewHolder})) == null) {
            if (cq6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && cq6Var.a != null) {
                cq6Var.B(cq6Var.position + 1);
                threadCardViewHolder.b().r(i2);
                if (threadCardViewHolder.b().f() instanceof oz) {
                    ((oz) threadCardViewHolder.b().f()).J(new i(this, viewGroup, view2, i2));
                }
                if (threadCardViewHolder.b() instanceof s66) {
                    threadCardViewHolder.b().b(this.c);
                }
                threadCardViewHolder.u(false, Align.ALIGN_RIGHT_BOTTOM);
                threadCardViewHolder.f(cq6Var);
                threadCardViewHolder.b().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.b().q(this.h);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: E */
    public View onFillContentViewHolder(int i2, View view2, ViewGroup viewGroup, cq6 cq6Var, ThreadCardViewHolder<cq6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, cq6Var, threadCardViewHolder})) == null) {
            if (cq6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && cq6Var.a != null) {
                cq6Var.B(cq6Var.position + 1);
                np6.b().a(cq6Var.d("c12351"));
                threadCardViewHolder.b().r(i2);
                if (threadCardViewHolder.b() instanceof s66) {
                    threadCardViewHolder.b().b(this.c);
                }
                if (cq6Var.p) {
                    zy zyVar = (zy) threadCardViewHolder.b().g();
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) zyVar.f.d.getLayoutParams();
                    layoutParams.width = cq6Var.j;
                    layoutParams.height = cq6Var.k;
                    if (zyVar.f.d.getVisibility() != 8) {
                        zyVar.f.d.setLayoutParams(layoutParams);
                    }
                }
                threadCardViewHolder.f(cq6Var);
                threadCardViewHolder.b().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.b().q(this.h);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: G */
    public View onFillHeaderViewHolder(int i2, View view2, ViewGroup viewGroup, cq6 cq6Var, ThreadCardViewHolder<cq6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, cq6Var, threadCardViewHolder})) == null) {
            if (cq6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && cq6Var.a != null) {
                cq6Var.B(cq6Var.position + 1);
                threadCardViewHolder.b().r(i2);
                if (threadCardViewHolder.b() instanceof s66) {
                    threadCardViewHolder.b().b(this.c);
                }
                if (cq6Var.m) {
                    threadCardViewHolder.u(true, Align.ALIGN_RIGHT_TOP);
                } else if (cq6Var.n) {
                    np6.b().a(cq6Var.r());
                    r66.c().a(cq6Var.r());
                    x68.p(cq6Var.a, this.a, cq6Var.h());
                }
                threadCardViewHolder.f(cq6Var);
                threadCardViewHolder.b().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.b().q(this.h);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: F */
    public View onFillExtendViewHolder(int i2, View view2, ViewGroup viewGroup, cq6 cq6Var, ThreadCardViewHolder<cq6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, cq6Var, threadCardViewHolder})) == null) {
            if (cq6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && cq6Var.a != null) {
                cq6Var.B(cq6Var.position + 1);
                threadCardViewHolder.b().r(i2);
                if (threadCardViewHolder.b() instanceof s66) {
                    threadCardViewHolder.b().b(this.c);
                }
                if (cq6Var.y) {
                    np6.b().a(new StatisticItem("c13424"));
                }
                threadCardViewHolder.f(cq6Var);
                threadCardViewHolder.b().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.b().q(this.h);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void I(View view2, cq6 cq6Var) {
        StatisticItem p;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, cq6Var) == null) && view2 != null && cq6Var != null && cq6Var.getThreadData() != null && !StringUtils.isNull(cq6Var.getThreadData().getTid())) {
            int id = view2.getId();
            int i2 = 1;
            if (cq6Var.m) {
                if (id == R.id.thread_card_root) {
                    a08.b(view2, cq6Var, 2);
                } else if (id != R.id.user_avatar && id != R.id.user_name) {
                    if (view2 instanceof TbImageView) {
                        a08.b(view2, cq6Var, 3);
                    }
                } else {
                    a08.b(view2, cq6Var, 1);
                }
            } else if (cq6Var.n) {
                np6.b().d(true);
                if (id != R.id.forum_head_image && id != R.id.forum_head_barname && id != R.id.forum_head_info_attention && id != R.id.forum_head_info_thread) {
                    if (cq6Var.isVideoThreadType()) {
                        p = cq6Var.t();
                    } else {
                        p = cq6Var.p();
                    }
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(p));
                    r66.c().i("page_concern", "clk_", p);
                } else {
                    TiebaStatic.log(cq6Var.f());
                    r66.c().i("page_concern", "clk_", cq6Var.f());
                    i2 = 9;
                }
                x68.d(cq6Var.a, this.a, cq6Var.h(), i2);
            } else if (!cq6Var.o && !cq6Var.p && !cq6Var.q && !cq6Var.r) {
                if (cq6Var.v) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    if (threadCardViewHolder != null) {
                        ThreadCardUtils.jumpToPB((t15) cq6Var.getThreadData(), view2.getContext(), 1, false);
                        threadCardViewHolder.b().p(new xz.a(1));
                    }
                } else if (cq6Var.x) {
                    if (view2.getId() == R.id.thread_card_root) {
                        a08.b(view2, cq6Var, 2);
                    } else if (id == R.id.forum_name_text) {
                        a08.b(view2, cq6Var, 7);
                    }
                } else if (cq6Var.y) {
                    if (view2.getId() == R.id.thread_card_root) {
                        a08.b(view2, cq6Var, 2);
                    } else if (id == R.id.god_reply_voice_btn) {
                        StatisticItem statisticItem = new StatisticItem("c13423");
                        statisticItem.param("obj_locate", 4);
                        statisticItem.param("tid", cq6Var.g);
                        ThreadData threadData = cq6Var.a;
                        if (threadData != null && threadData.getTopAgreePost() != null) {
                            statisticItem.param("pid", cq6Var.a.getTopAgreePost().S());
                        }
                        TiebaStatic.log(statisticItem);
                    } else if (id == R.id.god_reply_content) {
                        StatisticItem statisticItem2 = new StatisticItem("c13423");
                        statisticItem2.param("obj_locate", 2);
                        statisticItem2.param("tid", cq6Var.g);
                        ThreadData threadData2 = cq6Var.a;
                        if (threadData2 != null && threadData2.getTopAgreePost() != null) {
                            statisticItem2.param("pid", cq6Var.a.getTopAgreePost().S());
                        }
                        TiebaStatic.log(statisticItem2);
                    } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                        if (id == R.id.god_reply_agree_view) {
                            StatisticItem statisticItem3 = new StatisticItem("c13423");
                            statisticItem3.param("obj_locate", 5);
                            statisticItem3.param("tid", cq6Var.g);
                            ThreadData threadData3 = cq6Var.a;
                            if (threadData3 != null && threadData3.getTopAgreePost() != null) {
                                statisticItem3.param("pid", cq6Var.a.getTopAgreePost().S());
                            }
                            TiebaStatic.log(statisticItem3);
                        } else if ((view2 instanceof TbImageView) && (view2.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
                            StatisticItem statisticItem4 = new StatisticItem("c13423");
                            statisticItem4.param("obj_locate", 3);
                            statisticItem4.param("tid", cq6Var.g);
                            ThreadData threadData4 = cq6Var.a;
                            if (threadData4 != null && threadData4.getTopAgreePost() != null) {
                                statisticItem4.param("pid", cq6Var.a.getTopAgreePost().S());
                            }
                            TiebaStatic.log(statisticItem4);
                        }
                    } else {
                        StatisticItem statisticItem5 = new StatisticItem("c13423");
                        statisticItem5.param("obj_locate", 1);
                        statisticItem5.param("tid", cq6Var.g);
                        ThreadData threadData5 = cq6Var.a;
                        if (threadData5 != null && threadData5.getTopAgreePost() != null) {
                            statisticItem5.param("pid", cq6Var.a.getTopAgreePost().S());
                        }
                        TiebaStatic.log(statisticItem5);
                    }
                } else if (cq6Var.A && (view2.getId() == R.id.thread_card_root || view2.getId() == R.id.thread_info_commont_container)) {
                    a08.b(view2, cq6Var, 2);
                }
            } else if (view2.getId() == R.id.thread_card_root) {
                a08.b(view2, cq6Var, 2);
            } else if (view2 instanceof TbImageView) {
                a08.b(view2, cq6Var, 3);
            } else if (view2.getId() == R.id.thread_card_title || view2.getId() == R.id.thread_card_abstract) {
                a08.b(view2, cq6Var, 2);
            }
            if (id == R.id.thread_info_commont_container || id == R.id.thread_info_commont_img || id == R.id.thread_info_commont_num) {
                a08.b(view2, cq6Var, 8);
            }
        }
    }

    @Override // com.baidu.tieba.ln
    public BdUniqueId getBottomId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return cq6.M;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ln
    public BdUniqueId getContentId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return cq6.I;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ln
    public BdUniqueId getExtendId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return cq6.L;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ln
    public BdUniqueId getHeaderId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return cq6.D;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            kq6.f1135T = "c10705";
            kq6.U = "c10730";
            kq6.V = "c10731";
            kq6.W = "c10704";
            kq6.X = "c10755";
            kq6.Y = "c10710";
            kq6.Z = "c10736";
            kq6.a0 = "c10737";
            kq6.b0 = "c10711";
            kq6.c0 = "c10758";
            kq6.d0 = "c10757";
        }
    }
}
