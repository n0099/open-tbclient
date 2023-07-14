package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.resourceLoaderProc.BigImageLoaderProc;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class af9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbRichTextData)) == null) {
            if (tbRichTextData == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder(150);
            TbRichTextImageInfo d0 = tbRichTextData.d0();
            if (d0 == null) {
                return null;
            }
            if (!StringUtils.isNull(d0.V())) {
                return d0.V();
            }
            if (d0.getHeight() * d0.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (d0.getHeight() * d0.getWidth()));
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf((int) (d0.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (d0.getHeight() * sqrt)));
            } else {
                double width = d0.getWidth() / d0.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(xi.getUrlEncode(d0.getSrc()));
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void b(yca ycaVar, AbsPbActivity.e eVar) {
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, ycaVar, eVar) != null) || ycaVar == null || ycaVar.e0() == null || ycaVar.e0().X() == null || eVar == null || eVar.a == null || eVar.b == null || ycaVar.e0().X().size() == 0) {
            return;
        }
        String str = (String) ListUtils.getItem(eVar.a, eVar.j);
        if (StringUtils.isNull(str)) {
            return;
        }
        eVar.a = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = eVar.b;
        eVar.b = new ConcurrentHashMap<>();
        Iterator<TbRichTextData> it = ycaVar.e0().X().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 8) {
                String a = a(next);
                if (!StringUtils.isNull(a) && concurrentHashMap.get(a) != null && (imageUrlData = concurrentHashMap.get(a)) != null) {
                    eVar.a.add(a);
                    eVar.b.put(a, imageUrlData);
                }
            }
        }
        eVar.j = ListUtils.getPosition(eVar.a, str);
    }

    public static yca c(ze9 ze9Var, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{ze9Var, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (z) {
                if (ze9Var != null && ze9Var.F() != null && ze9Var.F().size() > 0) {
                    yca ycaVar = ze9Var.F().get(0);
                    if (ycaVar.I() != 1) {
                        return d(ze9Var);
                    }
                    return ycaVar;
                }
                return null;
            }
            return d(ze9Var);
        }
        return (yca) invokeCommon.objValue;
    }

    public static yca d(ze9 ze9Var) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, ze9Var)) == null) {
            if (ze9Var != null && ze9Var.N() != null && ze9Var.N().getAuthor() != null) {
                yca ycaVar = new yca();
                MetaData author = ze9Var.N().getAuthor();
                String userId = author.getUserId();
                HashMap<String, MetaData> userMap = ze9Var.N().getUserMap();
                if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                    author = metaData;
                }
                ycaVar.S0(1);
                ycaVar.Y0(ze9Var.N().getFirstPostId());
                ycaVar.p1(ze9Var.N().getTitle());
                ycaVar.o1(ze9Var.N().getCreateTime());
                ycaVar.N0(author);
                return ycaVar;
            }
            return null;
        }
        return (yca) invokeL.objValue;
    }
}
