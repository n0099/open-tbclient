package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.resourceLoaderProc.BigImageLoaderProc;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class bw9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements qb<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public a(Context context) {
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
            this.a = context;
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
                    foreDrawableImageView.setDefaultBgResource(R.color.CAM_X0204);
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
                    foreDrawableImageView.setDefaultBgResource(R.color.CAM_X0204);
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
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a);
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
    public class b implements qb<LinearLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public LinearLayout e(LinearLayout linearLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, linearLayout)) == null) ? linearLayout : (LinearLayout) invokeL.objValue;
        }

        public b(Context context) {
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
            this.a = context;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.qb
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.qb
        public /* bridge */ /* synthetic */ LinearLayout c(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            h(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qb
        /* renamed from: f */
        public void b(LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, linearLayout) == null) {
                linearLayout.removeAllViews();
            }
        }

        public LinearLayout h(LinearLayout linearLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, linearLayout)) == null) {
                linearLayout.removeAllViews();
                return linearLayout;
            }
            return (LinearLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qb
        /* renamed from: g */
        public LinearLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                LinearLayout linearLayout = new LinearLayout(this.a);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                linearLayout.setLayoutParams(layoutParams);
                linearLayout.setGravity(16);
                linearLayout.setBaselineAligned(true);
                linearLayout.setOrientation(1);
                linearLayout.setLayoutParams(layoutParams);
                return linearLayout;
            }
            return (LinearLayout) invokeV.objValue;
        }
    }

    public static String a(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbRichTextData)) == null) {
            if (tbRichTextData == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder(150);
            TbRichTextImageInfo V = tbRichTextData.V();
            if (V == null) {
                return null;
            }
            if (!StringUtils.isNull(V.O())) {
                return V.O();
            }
            if (V.getHeight() * V.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (V.getHeight() * V.getWidth()));
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf((int) (V.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (V.getHeight() * sqrt)));
            } else {
                double width = V.getWidth() / V.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(rd.getUrlEncode(V.U()));
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public static aw9 b(@Nullable ThreadData threadData, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, threadData, str)) == null) {
            aw9 aw9Var = new aw9();
            aw9Var.G0(3);
            if (threadData == null) {
                return null;
            }
            aw9Var.T0(threadData);
            if (threadData.getForumData() != null) {
                aw9Var.H0(threadData.getForumData());
                ForumData n = aw9Var.n();
                n.setId(threadData.getForumData().b());
                n.setName(threadData.getForumData().d());
                n.setUser_level(threadData.getForumData().c());
                n.setImage_url(threadData.getForumData().a());
                n.setPost_num(threadData.getForumData().j);
                n.setMember_num(threadData.getForumData().k);
            } else {
                ForumData n2 = aw9Var.n();
                n2.setId(String.valueOf(threadData.getFid()));
                n2.setName(threadData.getForum_name());
            }
            aw9Var.S0(threadData.getRobotEntrance());
            nwa nwaVar = new nwa();
            nwaVar.Z0(1);
            nwaVar.w1(threadData.getCreateTime());
            nwaVar.T0(threadData.getAuthor());
            MetaData author = threadData.getAuthor();
            if (threadData.isAlaLiveMixThreadType() && threadData.getThreadAlaInfo() != null) {
                AlaInfoData m120clone = threadData.getThreadAlaInfo().m120clone();
                if (!TextUtils.isEmpty(m120clone.mScheme)) {
                    m120clone.mScheme = m120clone.mScheme.replace("home_recommend_livecard", "pb_broadcast").replace("frs_tab_live_newcard", "pb_broadcast");
                }
                author.setAlaInfo(m120clone);
            }
            HashMap<String, MetaData> hashMap = new HashMap<>();
            hashMap.put(author.getUserId(), author);
            nwaVar.z1(hashMap);
            if (threadData.getUserMap() == null) {
                threadData.setUserMap(hashMap);
            }
            nwaVar.r1(TbRichTextView.a0(threadData.getFirstFloorList(), str, false));
            aw9Var.I0(nwaVar);
            aw9Var.I().add(nwaVar);
            aw9Var.P0(new pw9(threadData, null));
            aw9Var.m = true;
            aw9Var.L0(1);
            return aw9Var;
        }
        return (aw9) invokeLL.objValue;
    }

    public static void c(nwa nwaVar, AbsPbActivity.e eVar) {
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, nwaVar, eVar) != null) || nwaVar == null || nwaVar.f0() == null || nwaVar.f0().Q() == null || eVar == null || eVar.a == null || eVar.b == null || nwaVar.f0().Q().size() == 0) {
            return;
        }
        String str = (String) ListUtils.getItem(eVar.a, eVar.j);
        if (StringUtils.isNull(str)) {
            return;
        }
        eVar.a = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = eVar.b;
        eVar.b = new ConcurrentHashMap<>();
        Iterator<TbRichTextData> it = nwaVar.f0().Q().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                String a2 = a(next);
                if (!StringUtils.isNull(a2) && concurrentHashMap.get(a2) != null && (imageUrlData = concurrentHashMap.get(a2)) != null) {
                    eVar.a.add(a2);
                    eVar.b.put(a2, imageUrlData);
                }
            }
        }
        eVar.j = ListUtils.getPosition(eVar.a, str);
    }

    public static void h(@Nullable TbPageContext tbPageContext, @Nullable aw9 aw9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65543, null, tbPageContext, aw9Var) == null) && aw9Var != null && tbPageContext != null) {
            String j = j(aw9Var);
            for (int i = 0; i < aw9Var.I().size(); i++) {
                nwa nwaVar = aw9Var.I().get(i);
                for (int i2 = 0; i2 < nwaVar.k0().size(); i2++) {
                    nwaVar.k0().get(i2).E1(tbPageContext, j.equals(nwaVar.k0().get(i2).u().getUserId()));
                }
            }
            tw9 W = aw9Var.W();
            if (W != null && !ListUtils.isEmpty(W.a)) {
                for (nwa nwaVar2 : W.a) {
                    for (int i3 = 0; i3 < nwaVar2.k0().size(); i3++) {
                        nwaVar2.k0().get(i3).E1(tbPageContext, j.equals(nwaVar2.k0().get(i3).u().getUserId()));
                    }
                }
            }
        }
    }

    public static nwa d(aw9 aw9Var, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{aw9Var, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (z) {
                if (aw9Var != null && aw9Var.I() != null && aw9Var.I().size() > 0) {
                    nwa nwaVar = aw9Var.I().get(0);
                    if (nwaVar.L() != 1) {
                        return g(aw9Var);
                    }
                    return nwaVar;
                }
                return null;
            }
            return g(aw9Var);
        }
        return (nwa) invokeCommon.objValue;
    }

    @NonNull
    public static pb<ImageView> e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            return new pb<>(new a(context), 8, 0);
        }
        return (pb) invokeL.objValue;
    }

    @NonNull
    public static pb<LinearLayout> f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            return new pb<>(new b(context), 15, 0);
        }
        return (pb) invokeL.objValue;
    }

    public static nwa g(aw9 aw9Var) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, aw9Var)) == null) {
            if (aw9Var != null && aw9Var.R() != null && aw9Var.R().getAuthor() != null) {
                nwa nwaVar = new nwa();
                MetaData author = aw9Var.R().getAuthor();
                String userId = author.getUserId();
                HashMap<String, MetaData> userMap = aw9Var.R().getUserMap();
                if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                    author = metaData;
                }
                nwaVar.Z0(1);
                nwaVar.f1(aw9Var.R().getFirstPostId());
                nwaVar.x1(aw9Var.R().getTitle());
                nwaVar.w1(aw9Var.R().getCreateTime());
                nwaVar.T0(author);
                return nwaVar;
            }
            return null;
        }
        return (nwa) invokeL.objValue;
    }

    public static void i(@Nullable aw9 aw9Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65544, null, aw9Var, i) == null) {
            TbPageContext currentPageContext = TbadkCoreApplication.getInst().getCurrentPageContext(TbadkCoreApplication.getInst().getCurrentActivity());
            if (aw9Var != null && currentPageContext != null) {
                String j = j(aw9Var);
                tw9 W = aw9Var.W();
                if (W != null && !ListUtils.isEmpty(W.a)) {
                    List<nwa> list = W.a;
                    for (nwa nwaVar : list.subList(i, list.size())) {
                        for (int i2 = 0; i2 < nwaVar.k0().size(); i2++) {
                            nwaVar.k0().get(i2).E1(currentPageContext, j.equals(nwaVar.k0().get(i2).u().getUserId()));
                        }
                    }
                }
            }
        }
    }

    @NonNull
    public static String j(@Nullable aw9 aw9Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, aw9Var)) == null) {
            if (aw9Var == null) {
                return "";
            }
            if (aw9Var.R() != null && aw9Var.R().getAuthor() != null) {
                str = aw9Var.R().getAuthor().getUserId();
            } else {
                str = null;
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
