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
import com.baidu.tieba.kt;
import com.baidu.tieba.vt;
import com.baidu.tieba.zr;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class hv7 extends lh<jk6, ThreadCardViewHolder<jk6>> implements yz5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public ei d;
    public boolean e;
    public ya<ImageView> f;
    public ya<GifView> g;
    public bk6<jk6> h;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
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
    @Override // com.baidu.tieba.lh
    /* renamed from: H */
    public View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, jk6 jk6Var, ThreadCardViewHolder<jk6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, jk6Var, threadCardViewHolder})) == null) {
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements za<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hv7 a;

        public a(hv7 hv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hv7Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.za
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.za
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za
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
                    if (uu4.c().g()) {
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
        @Override // com.baidu.tieba.za
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.b.getPageActivity());
                boolean g = uu4.c().g();
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

    /* loaded from: classes6.dex */
    public class b implements za<GifView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hv7 a;

        public b(hv7 hv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hv7Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.za
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.za
        public /* bridge */ /* synthetic */ GifView c(GifView gifView) {
            GifView gifView2 = gifView;
            h(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za
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
                if (uu4.c().g()) {
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
        @Override // com.baidu.tieba.za
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.b.getPageActivity());
                boolean g = uu4.c().g();
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

    /* loaded from: classes6.dex */
    public class c extends bk6<jk6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hv7 b;

        public c(hv7 hv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hv7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bk6
        /* renamed from: d */
        public void a(View view2, jk6 jk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, jk6Var) != null) {
                return;
            }
            this.b.I(view2, jk6Var);
        }
    }

    /* loaded from: classes6.dex */
    public class d implements zr.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(hv7 hv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.zr.b
        public void a(jv4 jv4Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, jv4Var, view2) == null) && jv4Var != null) {
                if (view2.getId() == R.id.user_name) {
                    jv4Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    jv4Var.objType = 4;
                } else {
                    jv4Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements ii {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hv7 a;

        public e(hv7 hv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hv7Var;
        }

        @Override // com.baidu.tieba.ii
        public void b(View view2, yh yhVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, yhVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (yhVar instanceof rh) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                rh rhVar = (rh) yhVar;
                if (!(rhVar.c() instanceof jk6)) {
                    return;
                }
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                jk6 jk6Var = (jk6) rhVar.c();
                jk6Var.f = 1;
                if (this.a.h != null) {
                    this.a.h.a(threadCardViewHolder.getView(), jk6Var);
                }
                if (!m28.b(this.a.b, rhVar.c())) {
                    ThreadCardUtils.jumpToPB((jv4) jk6Var, view2.getContext(), 1, false, as.a((ei) viewGroup, view2, i));
                    threadCardViewHolder.a().q(new vt.a(1));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements ii {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hv7 a;

        public f(hv7 hv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hv7Var;
        }

        @Override // com.baidu.tieba.ii
        public void b(View view2, yh yhVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, yhVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (yhVar instanceof rh) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                rh rhVar = (rh) yhVar;
                if (!(rhVar.c() instanceof jk6)) {
                    return;
                }
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                jk6 jk6Var = (jk6) rhVar.c();
                jk6Var.f = 1;
                if (this.a.h != null) {
                    this.a.h.a(threadCardViewHolder.getView(), jk6Var);
                }
                ThreadCardUtils.jumpToPB((jv4) jk6Var, view2.getContext(), 1, false);
                threadCardViewHolder.a().q(new vt.a(1));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements ii {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ts a;
        public final /* synthetic */ hv7 b;

        public g(hv7 hv7Var, ts tsVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hv7Var, tsVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hv7Var;
            this.a = tsVar;
        }

        @Override // com.baidu.tieba.ii
        public void b(View view2, yh yhVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            jk6 jk6Var;
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, yhVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                boolean z = yhVar instanceof rh;
                int i2 = 0;
                if (z) {
                    rh rhVar = (rh) yhVar;
                    if ((rhVar.c() instanceof jk6) && yhVar != null && rhVar.c() != null && (jk6Var = (jk6) rhVar.c()) != null && (threadData = jk6Var.a) != null && jk6Var.u && threadData.getItem() != null) {
                        if (jk6Var.a.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                            BdToast.makeText(this.b.b.getContext(), this.b.b.getString(R.string.video_is_checking)).setIcon(BdToast.ToastIcon.FAILURE).show();
                            return;
                        }
                        int intValue = jk6Var.a.getItem().button_link_type.intValue();
                        if (jk6Var.a.getItem().apk_detail != null) {
                            i2 = jk6Var.a.getItem().apk_detail.pkg_source.intValue();
                        }
                        int a = i55.a(intValue, i2);
                        ItemData itemData = new ItemData();
                        itemData.parseProto(jk6Var.a.getItem());
                        ItemCardHelper.q(this.a.B(), jk6Var.a.getItem().item_id.longValue(), this.a.A(itemData), jk6Var.a.getTid(), a, "", 2);
                        ItemClickJumpUtil.itemClickJump(jk6Var.a.getItem().forum_name, String.valueOf(jk6Var.a.getItem().item_id), 2, 2);
                        return;
                    }
                }
                if (z && (view2.getTag() instanceof ThreadCardViewHolder)) {
                    rh rhVar2 = (rh) yhVar;
                    if (!(rhVar2.c() instanceof jk6)) {
                        return;
                    }
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    jk6 jk6Var2 = (jk6) rhVar2.c();
                    jk6Var2.f = 1;
                    if (this.b.h != null) {
                        this.b.h.a(threadCardViewHolder.getView(), jk6Var2);
                    }
                    ThreadCardUtils.jumpToPB((jv4) jk6Var2, view2.getContext(), 1, false, as.a((ei) viewGroup, view2, i));
                    threadCardViewHolder.a().q(new vt.a(1));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements ii {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hv7 a;

        public h(hv7 hv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hv7Var;
        }

        @Override // com.baidu.tieba.ii
        public void b(View view2, yh yhVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, yhVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (yhVar instanceof rh) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                rh rhVar = (rh) yhVar;
                if (!(rhVar.c() instanceof jk6)) {
                    return;
                }
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                jk6 jk6Var = (jk6) rhVar.c();
                jk6Var.f = 1;
                if (this.a.h != null) {
                    this.a.h.a(threadCardViewHolder.getView(), jk6Var);
                }
                ThreadCardUtils.jumpToPB((jv4) jk6Var, view2.getContext(), 1, false, as.a((ei) viewGroup, view2, i));
                threadCardViewHolder.a().q(new vt.a(1));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements ThreadCommentAndPraiseInfoLayout.m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;

        public i(hv7 hv7Var, ViewGroup viewGroup, View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hv7Var, viewGroup, view2, Integer.valueOf(i)};
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
                ((PbActivityConfig) intentConfig).setVideoOriginArea(as.a((ei) this.a, this.b, this.c));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hv7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.f = new ya<>(new a(this), 12, 0);
        this.g = new ya<>(new b(this), 20, 0);
        this.h = new c(this);
        this.b = tbPageContext;
        x();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: B */
    public ThreadCardViewHolder<jk6> onCreateHeaderViewHolder(ViewGroup viewGroup, jk6 jk6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, jk6Var)) == null) {
            if (jk6Var == null) {
                return null;
            }
            kt.b bVar = new kt.b(this.b.getPageActivity());
            if (jk6Var.m) {
                zr zrVar = new zr(this.b.getPageActivity());
                zrVar.q(this.a);
                zrVar.e(128);
                zrVar.f(1024);
                zrVar.z(new d(this));
                bVar.o(zrVar);
            } else if (jk6Var.n) {
                bVar.o(new js(this.b.getPageActivity()));
            }
            kt k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.d);
            k.t(1);
            ThreadCardViewHolder<jk6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new e(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: y */
    public ThreadCardViewHolder<jk6> onCreateBottomViewHolder(ViewGroup viewGroup, jk6 jk6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048602, this, viewGroup, jk6Var)) == null) {
            kt.b bVar = new kt.b(this.b.getPageActivity(), false);
            mt mtVar = new mt(this.b.getPageActivity());
            pv4 pv4Var = new pv4();
            pv4Var.b = 9;
            pv4Var.h = 9;
            mtVar.E(pv4Var);
            mtVar.G(9);
            mtVar.M("personalize_page");
            mtVar.L(4);
            mtVar.H(1);
            mtVar.e(32);
            mtVar.F(false);
            bVar.m(mtVar);
            kt k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.d);
            k.t(1);
            ThreadCardViewHolder<jk6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new h(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    public void J(ei eiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, eiVar) == null) {
            this.d = eiVar;
        }
    }

    @Override // com.baidu.tieba.yz5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.c = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: A */
    public ThreadCardViewHolder<jk6> onCreateExtendViewHolder(ViewGroup viewGroup, jk6 jk6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, viewGroup, jk6Var)) == null) {
            kt.b bVar = new kt.b(this.b.getPageActivity(), false);
            ts tsVar = new ts(this.b.getPageActivity());
            tsVar.G(2);
            tsVar.z();
            tsVar.D(true);
            bVar.h(tsVar);
            bVar.h(new gt(this.b.getPageActivity()));
            bVar.h(new at(this.b.getPageActivity()));
            hs hsVar = new hs(this.b.getPageActivity());
            hsVar.A();
            bVar.h(hsVar);
            ls lsVar = new ls(this.b.getPageActivity());
            lsVar.E(this.e);
            lsVar.D(ImageViewerConfig.FROM_CONCERN);
            bVar.h(lsVar);
            kt k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.d);
            k.t(1);
            ThreadCardViewHolder<jk6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new g(this, tsVar));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: z */
    public ThreadCardViewHolder<jk6> onCreateContentViewHolder(ViewGroup viewGroup, jk6 jk6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, viewGroup, jk6Var)) == null) {
            kt.b bVar = new kt.b(this.b.getPageActivity(), false);
            if (jk6Var.o) {
                ms msVar = new ms(this.b.getPageActivity());
                msVar.I(this.f, this.g);
                msVar.setFrom(ImageViewerConfig.FROM_CONCERN);
                msVar.F(1);
                msVar.E(this.e);
                msVar.D(1);
                bVar.n(msVar);
            } else if (jk6Var.p) {
                bVar.n(ys.u(this.b.getPageActivity(), ImageViewerConfig.FROM_CONCERN, this.e));
            } else if (jk6Var.q) {
                ws wsVar = new ws(this.b.getPageActivity());
                wsVar.setFrom(ImageViewerConfig.FROM_CONCERN);
                wsVar.z(this.e);
                bVar.n(wsVar);
            } else if (jk6Var.r) {
                zs zsVar = new zs(this.b.getPageActivity());
                zsVar.setFrom(ImageViewerConfig.FROM_CONCERN);
                zsVar.y(this.e);
                bVar.n(zsVar);
            }
            kt k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.d);
            k.t(1);
            ThreadCardViewHolder<jk6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new f(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: D */
    public View onFillBottomViewHolder(int i2, View view2, ViewGroup viewGroup, jk6 jk6Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, jk6Var, threadCardViewHolder})) == null) {
            if (jk6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && jk6Var.a != null) {
                jk6Var.A(jk6Var.position + 1);
                threadCardViewHolder.a().s(i2);
                if (threadCardViewHolder.a().f() instanceof mt) {
                    ((mt) threadCardViewHolder.a().f()).K(new i(this, viewGroup, view2, i2));
                }
                if (threadCardViewHolder.a() instanceof xz5) {
                    threadCardViewHolder.a().b(this.c);
                }
                threadCardViewHolder.u(false, Align.ALIGN_RIGHT_BOTTOM);
                threadCardViewHolder.e(jk6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().r(this.h);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: E */
    public View onFillContentViewHolder(int i2, View view2, ViewGroup viewGroup, jk6 jk6Var, ThreadCardViewHolder<jk6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, jk6Var, threadCardViewHolder})) == null) {
            if (jk6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && jk6Var.a != null) {
                jk6Var.A(jk6Var.position + 1);
                tj6.b().a(jk6Var.d("c12351"));
                threadCardViewHolder.a().s(i2);
                if (threadCardViewHolder.a() instanceof xz5) {
                    threadCardViewHolder.a().b(this.c);
                }
                if (jk6Var.p) {
                    vj6.a(threadCardViewHolder.a().g(), jk6Var.j, jk6Var.k);
                }
                threadCardViewHolder.e(jk6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().r(this.h);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: G */
    public View onFillHeaderViewHolder(int i2, View view2, ViewGroup viewGroup, jk6 jk6Var, ThreadCardViewHolder<jk6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, jk6Var, threadCardViewHolder})) == null) {
            if (jk6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && jk6Var.a != null) {
                jk6Var.A(jk6Var.position + 1);
                threadCardViewHolder.a().s(i2);
                if (threadCardViewHolder.a() instanceof xz5) {
                    threadCardViewHolder.a().b(this.c);
                }
                if (jk6Var.m) {
                    threadCardViewHolder.u(true, Align.ALIGN_RIGHT_TOP);
                } else if (jk6Var.n) {
                    tj6.b().a(jk6Var.r());
                    wz5.c().a(jk6Var.r());
                    k28.p(jk6Var.a, this.a, jk6Var.h());
                }
                threadCardViewHolder.e(jk6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().r(this.h);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: F */
    public View onFillExtendViewHolder(int i2, View view2, ViewGroup viewGroup, jk6 jk6Var, ThreadCardViewHolder<jk6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, jk6Var, threadCardViewHolder})) == null) {
            if (jk6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && jk6Var.a != null) {
                jk6Var.A(jk6Var.position + 1);
                threadCardViewHolder.a().s(i2);
                if (threadCardViewHolder.a() instanceof xz5) {
                    threadCardViewHolder.a().b(this.c);
                }
                if (jk6Var.y) {
                    tj6.b().a(new StatisticItem("c13424"));
                }
                threadCardViewHolder.e(jk6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().r(this.h);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void I(View view2, jk6 jk6Var) {
        StatisticItem q;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, jk6Var) == null) && view2 != null && jk6Var != null && jk6Var.getThreadData() != null && !StringUtils.isNull(jk6Var.getThreadData().getTid())) {
            int id = view2.getId();
            int i2 = 1;
            if (jk6Var.m) {
                if (id == R.id.thread_card_root) {
                    dv7.b(view2, jk6Var, 2);
                } else if (id != R.id.user_avatar && id != R.id.user_name) {
                    if (view2 instanceof TbImageView) {
                        dv7.b(view2, jk6Var, 3);
                    }
                } else {
                    dv7.b(view2, jk6Var, 1);
                }
            } else if (jk6Var.n) {
                tj6.b().d(true);
                if (id != R.id.forum_head_image && id != R.id.forum_head_barname && id != R.id.forum_head_info_attention && id != R.id.forum_head_info_thread) {
                    if (jk6Var.isVideoThreadType()) {
                        q = jk6Var.t();
                    } else {
                        q = jk6Var.q();
                    }
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(q));
                    wz5.c().i("page_concern", "clk_", q);
                } else {
                    TiebaStatic.log(jk6Var.f());
                    wz5.c().i("page_concern", "clk_", jk6Var.f());
                    i2 = 9;
                }
                k28.d(jk6Var.a, this.a, jk6Var.h(), i2);
            } else if (!jk6Var.o && !jk6Var.p && !jk6Var.q && !jk6Var.r) {
                if (jk6Var.v) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    if (threadCardViewHolder != null) {
                        ThreadCardUtils.jumpToPB((jv4) jk6Var.getThreadData(), view2.getContext(), 1, false);
                        threadCardViewHolder.a().q(new vt.a(1));
                    }
                } else if (jk6Var.x) {
                    if (view2.getId() == R.id.thread_card_root) {
                        dv7.b(view2, jk6Var, 2);
                    } else if (id == R.id.forum_name_text) {
                        dv7.b(view2, jk6Var, 7);
                    }
                } else if (jk6Var.y) {
                    if (view2.getId() == R.id.thread_card_root) {
                        dv7.b(view2, jk6Var, 2);
                    } else if (id == R.id.god_reply_voice_btn) {
                        StatisticItem statisticItem = new StatisticItem("c13423");
                        statisticItem.param("obj_locate", 4);
                        statisticItem.param("tid", jk6Var.g);
                        ThreadData threadData = jk6Var.a;
                        if (threadData != null && threadData.getTopAgreePost() != null) {
                            statisticItem.param("pid", jk6Var.a.getTopAgreePost().U());
                        }
                        TiebaStatic.log(statisticItem);
                    } else if (id == R.id.god_reply_content) {
                        StatisticItem statisticItem2 = new StatisticItem("c13423");
                        statisticItem2.param("obj_locate", 2);
                        statisticItem2.param("tid", jk6Var.g);
                        ThreadData threadData2 = jk6Var.a;
                        if (threadData2 != null && threadData2.getTopAgreePost() != null) {
                            statisticItem2.param("pid", jk6Var.a.getTopAgreePost().U());
                        }
                        TiebaStatic.log(statisticItem2);
                    } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                        if (id == R.id.god_reply_agree_view) {
                            StatisticItem statisticItem3 = new StatisticItem("c13423");
                            statisticItem3.param("obj_locate", 5);
                            statisticItem3.param("tid", jk6Var.g);
                            ThreadData threadData3 = jk6Var.a;
                            if (threadData3 != null && threadData3.getTopAgreePost() != null) {
                                statisticItem3.param("pid", jk6Var.a.getTopAgreePost().U());
                            }
                            TiebaStatic.log(statisticItem3);
                        } else if ((view2 instanceof TbImageView) && (view2.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
                            StatisticItem statisticItem4 = new StatisticItem("c13423");
                            statisticItem4.param("obj_locate", 3);
                            statisticItem4.param("tid", jk6Var.g);
                            ThreadData threadData4 = jk6Var.a;
                            if (threadData4 != null && threadData4.getTopAgreePost() != null) {
                                statisticItem4.param("pid", jk6Var.a.getTopAgreePost().U());
                            }
                            TiebaStatic.log(statisticItem4);
                        }
                    } else {
                        StatisticItem statisticItem5 = new StatisticItem("c13423");
                        statisticItem5.param("obj_locate", 1);
                        statisticItem5.param("tid", jk6Var.g);
                        ThreadData threadData5 = jk6Var.a;
                        if (threadData5 != null && threadData5.getTopAgreePost() != null) {
                            statisticItem5.param("pid", jk6Var.a.getTopAgreePost().U());
                        }
                        TiebaStatic.log(statisticItem5);
                    }
                } else if (jk6Var.A && (view2.getId() == R.id.thread_card_root || view2.getId() == R.id.thread_info_commont_container)) {
                    dv7.b(view2, jk6Var, 2);
                }
            } else if (view2.getId() == R.id.thread_card_root) {
                dv7.b(view2, jk6Var, 2);
            } else if (view2 instanceof TbImageView) {
                dv7.b(view2, jk6Var, 3);
            } else if (view2.getId() == R.id.thread_card_title || view2.getId() == R.id.thread_card_abstract) {
                dv7.b(view2, jk6Var, 2);
            }
            if (id == R.id.thread_info_commont_container || id == R.id.thread_info_commont_img || id == R.id.thread_info_commont_num) {
                dv7.b(view2, jk6Var, 8);
            }
        }
    }

    @Override // com.baidu.tieba.lh
    public BdUniqueId getBottomId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return jk6.M;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lh
    public BdUniqueId getContentId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return jk6.I;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lh
    public BdUniqueId getExtendId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return jk6.L;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lh
    public BdUniqueId getHeaderId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return jk6.D;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            rk6.f1159T = "c10705";
            rk6.U = "c10730";
            rk6.V = "c10731";
            rk6.W = "c10704";
            rk6.X = "c10755";
            rk6.Y = "c10710";
            rk6.Z = "c10736";
            rk6.a0 = "c10737";
            rk6.b0 = "c10711";
            rk6.c0 = "c10758";
            rk6.d0 = "c10757";
        }
    }
}
