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
public class es9 {
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
            TbRichTextImageInfo W = tbRichTextData.W();
            if (W == null) {
                return null;
            }
            if (!StringUtils.isNull(W.O())) {
                return W.O();
            }
            if (W.getHeight() * W.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (W.getHeight() * W.getWidth()));
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf((int) (W.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (W.getHeight() * sqrt)));
            } else {
                double width = W.getWidth() / W.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(qd.getUrlEncode(W.U()));
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void b(ura uraVar, AbsPbActivity.e eVar) {
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, uraVar, eVar) != null) || uraVar == null || uraVar.e0() == null || uraVar.e0().Q() == null || eVar == null || eVar.a == null || eVar.b == null || uraVar.e0().Q().size() == 0) {
            return;
        }
        String str = (String) ListUtils.getItem(eVar.a, eVar.j);
        if (StringUtils.isNull(str)) {
            return;
        }
        eVar.a = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = eVar.b;
        eVar.b = new ConcurrentHashMap<>();
        Iterator<TbRichTextData> it = uraVar.e0().Q().iterator();
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

    public static ura c(ds9 ds9Var, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{ds9Var, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (z) {
                if (ds9Var != null && ds9Var.F() != null && ds9Var.F().size() > 0) {
                    ura uraVar = ds9Var.F().get(0);
                    if (uraVar.J() != 1) {
                        return d(ds9Var);
                    }
                    return uraVar;
                }
                return null;
            }
            return d(ds9Var);
        }
        return (ura) invokeCommon.objValue;
    }

    public static ura d(ds9 ds9Var) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, ds9Var)) == null) {
            if (ds9Var != null && ds9Var.O() != null && ds9Var.O().getAuthor() != null) {
                ura uraVar = new ura();
                MetaData author = ds9Var.O().getAuthor();
                String userId = author.getUserId();
                HashMap<String, MetaData> userMap = ds9Var.O().getUserMap();
                if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                    author = metaData;
                }
                uraVar.X0(1);
                uraVar.d1(ds9Var.O().getFirstPostId());
                uraVar.v1(ds9Var.O().getTitle());
                uraVar.u1(ds9Var.O().getCreateTime());
                uraVar.Q0(author);
                return uraVar;
            }
            return null;
        }
        return (ura) invokeL.objValue;
    }
}
