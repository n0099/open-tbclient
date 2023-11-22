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
/* loaded from: classes6.dex */
public class fs9 {
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

    public static void b(vra vraVar, AbsPbActivity.e eVar) {
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, vraVar, eVar) != null) || vraVar == null || vraVar.e0() == null || vraVar.e0().Q() == null || eVar == null || eVar.a == null || eVar.b == null || vraVar.e0().Q().size() == 0) {
            return;
        }
        String str = (String) ListUtils.getItem(eVar.a, eVar.j);
        if (StringUtils.isNull(str)) {
            return;
        }
        eVar.a = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = eVar.b;
        eVar.b = new ConcurrentHashMap<>();
        Iterator<TbRichTextData> it = vraVar.e0().Q().iterator();
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

    public static vra c(es9 es9Var, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{es9Var, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (z) {
                if (es9Var != null && es9Var.F() != null && es9Var.F().size() > 0) {
                    vra vraVar = es9Var.F().get(0);
                    if (vraVar.J() != 1) {
                        return d(es9Var);
                    }
                    return vraVar;
                }
                return null;
            }
            return d(es9Var);
        }
        return (vra) invokeCommon.objValue;
    }

    public static vra d(es9 es9Var) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, es9Var)) == null) {
            if (es9Var != null && es9Var.O() != null && es9Var.O().getAuthor() != null) {
                vra vraVar = new vra();
                MetaData author = es9Var.O().getAuthor();
                String userId = author.getUserId();
                HashMap<String, MetaData> userMap = es9Var.O().getUserMap();
                if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                    author = metaData;
                }
                vraVar.X0(1);
                vraVar.d1(es9Var.O().getFirstPostId());
                vraVar.v1(es9Var.O().getTitle());
                vraVar.u1(es9Var.O().getCreateTime());
                vraVar.Q0(author);
                return vraVar;
            }
            return null;
        }
        return (vra) invokeL.objValue;
    }
}
