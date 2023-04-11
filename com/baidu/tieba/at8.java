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
/* loaded from: classes3.dex */
public class at8 {
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
            TbRichTextImageInfo Y = tbRichTextData.Y();
            if (Y == null) {
                return null;
            }
            if (!StringUtils.isNull(Y.Q())) {
                return Y.Q();
            }
            if (Y.getHeight() * Y.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (Y.getHeight() * Y.getWidth()));
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf((int) (Y.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (Y.getHeight() * sqrt)));
            } else {
                double width = Y.getWidth() / Y.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(hi.getUrlEncode(Y.getSrc()));
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void b(sl9 sl9Var, AbsPbActivity.e eVar) {
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, sl9Var, eVar) != null) || sl9Var == null || sl9Var.a0() == null || sl9Var.a0().S() == null || eVar == null || eVar.a == null || eVar.b == null || sl9Var.a0().S().size() == 0) {
            return;
        }
        String str = (String) ListUtils.getItem(eVar.a, eVar.j);
        if (StringUtils.isNull(str)) {
            return;
        }
        eVar.a = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = eVar.b;
        eVar.b = new ConcurrentHashMap<>();
        Iterator<TbRichTextData> it = sl9Var.a0().S().iterator();
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

    public static sl9 c(zs8 zs8Var, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{zs8Var, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (z) {
                if (zs8Var != null && zs8Var.F() != null && zs8Var.F().size() > 0) {
                    sl9 sl9Var = zs8Var.F().get(0);
                    if (sl9Var.E() != 1) {
                        return d(zs8Var);
                    }
                    return sl9Var;
                }
                return null;
            }
            return d(zs8Var);
        }
        return (sl9) invokeCommon.objValue;
    }

    public static sl9 d(zs8 zs8Var) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, zs8Var)) == null) {
            if (zs8Var != null && zs8Var.M() != null && zs8Var.M().getAuthor() != null) {
                sl9 sl9Var = new sl9();
                MetaData author = zs8Var.M().getAuthor();
                String userId = author.getUserId();
                HashMap<String, MetaData> userMap = zs8Var.M().getUserMap();
                if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                    author = metaData;
                }
                sl9Var.K0(1);
                sl9Var.Q0(zs8Var.M().getFirstPostId());
                sl9Var.h1(zs8Var.M().getTitle());
                sl9Var.g1(zs8Var.M().getCreateTime());
                sl9Var.H0(author);
                return sl9Var;
            }
            return null;
        }
        return (sl9) invokeL.objValue;
    }
}
