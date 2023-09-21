package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class fp9 {
    public static /* synthetic */ Interceptable $ic;
    public static final fp9 a;
    public static boolean b;
    public static int c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947771962, "Lcom/baidu/tieba/fp9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947771962, "Lcom/baidu/tieba/fp9;");
                return;
            }
        }
        a = new fp9();
    }

    public fp9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return c;
        }
        return invokeV.intValue;
    }

    @JvmStatic
    public static final void e(PbModel pbModel, String str, int i, AbsPbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65539, null, pbModel, str, i, eVar) == null) {
            Intrinsics.checkNotNullParameter(pbModel, "pbModel");
            if (eVar == null) {
                return;
            }
            lk9 r1 = pbModel.r1();
            TbRichText f = f(pbModel, str, i);
            if (f == null || (tbRichTextData = f.O().get(c)) == null) {
                return;
            }
            eVar.f = String.valueOf(f.getPostId());
            eVar.a = new ArrayList<>();
            eVar.b = new ConcurrentHashMap<>();
            boolean z = false;
            if (!tbRichTextData.U().U()) {
                eVar.h = false;
                String a2 = mk9.a(tbRichTextData);
                eVar.a.add(a2);
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.imageUrl = str;
                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                    imageUrlData.urlType = 38;
                } else {
                    Intrinsics.checkNotNull(r1);
                    if (r1.m0()) {
                        i4 = 17;
                    } else {
                        i4 = 18;
                    }
                    imageUrlData.urlType = i4;
                }
                imageUrlData.urlThumbType = imageUrlData.urlType;
                imageUrlData.imageThumbUrl = imageUrlData.imageUrl;
                imageUrlData.originalUrl = pp9.o(tbRichTextData);
                imageUrlData.originalUrl = pp9.o(tbRichTextData);
                imageUrlData.originalSize = pp9.p(tbRichTextData);
                imageUrlData.mIsShowOrigonButton = pp9.l(tbRichTextData);
                imageUrlData.isLongPic = pp9.k(tbRichTextData);
                imageUrlData.postId = f.getPostId();
                imageUrlData.mIsReserver = pbModel.D1();
                imageUrlData.mIsSeeHost = pbModel.U0();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = eVar.b;
                Intrinsics.checkNotNullExpressionValue(concurrentHashMap, "result.assistUrls");
                concurrentHashMap.put(a2, imageUrlData);
                if (r1 != null) {
                    if (r1.k() != null) {
                        eVar.c = r1.k().getName();
                        eVar.d = r1.k().getId();
                    }
                    if (r1.O() != null) {
                        eVar.e = r1.O().getId();
                    }
                    if (r1.r() == 1) {
                        z = true;
                    }
                    eVar.g = z;
                }
                imageUrlData.threadId = JavaTypesHelper.toLong(eVar.e, -1L);
                return;
            }
            eVar.h = true;
            Intrinsics.checkNotNull(r1);
            int size = r1.F().size();
            b = false;
            eVar.j = -1;
            if (r1.i() != null) {
                TbRichText f0 = r1.i().f0();
                fp9 fp9Var = a;
                ArrayList<String> arrayList = eVar.a;
                Intrinsics.checkNotNullExpressionValue(arrayList, "result.urlList");
                i2 = fp9Var.c(pbModel, f0, f, i, i, arrayList, eVar.b);
            } else {
                i2 = i;
            }
            int i5 = i2;
            int i6 = 0;
            while (i6 < size) {
                zja zjaVar = r1.F().get(i6);
                if (zjaVar.U() != null && r1.i() != null && r1.i().U() != null && Intrinsics.areEqual(zjaVar.U(), r1.i().U())) {
                    i3 = i6;
                } else {
                    TbRichText f02 = zjaVar.f0();
                    fp9 fp9Var2 = a;
                    ArrayList<String> arrayList2 = eVar.a;
                    Intrinsics.checkNotNullExpressionValue(arrayList2, "result.urlList");
                    i3 = i6;
                    i5 = fp9Var2.c(pbModel, f02, f, i5, i, arrayList2, eVar.b);
                }
                i6 = i3 + 1;
            }
            if (eVar.a.size() > 0) {
                ArrayList<String> arrayList3 = eVar.a;
                eVar.i = arrayList3.get(arrayList3.size() - 1);
            }
            if (r1.k() != null) {
                eVar.c = r1.k().getName();
                eVar.d = r1.k().getId();
            }
            if (r1.O() != null) {
                eVar.e = r1.O().getId();
            }
            if (r1.r() == 1) {
                z = true;
            }
            eVar.g = z;
            eVar.j = i5;
        }
    }

    @JvmStatic
    public static final TbRichText f(PbModel pbModel, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, pbModel, str, i)) == null) {
            TbRichText tbRichText = null;
            if (pbModel == null || pbModel.r1() == null || str == null || i < 0) {
                return null;
            }
            lk9 r1 = pbModel.r1();
            if (r1.i() != null) {
                ArrayList<zja> arrayList = new ArrayList<>();
                arrayList.add(r1.i());
                tbRichText = a.b(arrayList, str, i);
            }
            if (tbRichText == null) {
                ArrayList<zja> F = r1.F();
                a.a(r1, F);
                return a.b(F, str, i);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLLI.objValue;
    }

    public final void a(lk9 lk9Var, ArrayList<zja> arrayList) {
        List<zja> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, lk9Var, arrayList) == null) && lk9Var != null && lk9Var.T() != null && lk9Var.T().a != null && (list = lk9Var.T().a) != null && arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (list.size() > 0 && arrayList.size() > 0) {
                arrayList3.addAll(list);
                Iterator<zja> it = arrayList.iterator();
                while (it.hasNext()) {
                    zja next = it.next();
                    if (next != null) {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            zja zjaVar = (zja) it2.next();
                            if (zjaVar != null && !TextUtils.isEmpty(next.U()) && !TextUtils.isEmpty(zjaVar.U()) && Intrinsics.areEqual(next.U(), zjaVar.U())) {
                                arrayList2.add(zjaVar);
                            }
                        }
                    }
                }
                if (arrayList2.size() > 0) {
                    arrayList3.removeAll(arrayList2);
                }
                if (arrayList3.size() > 0) {
                    arrayList.addAll(arrayList3);
                }
            }
        }
    }

    public final TbRichText b(ArrayList<zja> arrayList, String str, int i) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> O;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, str, i)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    zja zjaVar = arrayList.get(i2);
                    Intrinsics.checkNotNullExpressionValue(zjaVar, "datas[k]");
                    TbRichText f0 = zjaVar.f0();
                    if (f0 != null && (O = f0.O()) != null) {
                        int size2 = O.size();
                        int i3 = -1;
                        for (int i4 = 0; i4 < size2; i4++) {
                            if (O.get(i4) != null) {
                                TbRichTextData tbRichTextData = O.get(i4);
                                Intrinsics.checkNotNull(tbRichTextData);
                                if (tbRichTextData.getType() == 8) {
                                    i3++;
                                    TbRichTextData tbRichTextData2 = O.get(i4);
                                    Intrinsics.checkNotNull(tbRichTextData2);
                                    if (!Intrinsics.areEqual(tbRichTextData2.U().O(), str)) {
                                        TbRichTextData tbRichTextData3 = O.get(i4);
                                        Intrinsics.checkNotNull(tbRichTextData3);
                                        if (!Intrinsics.areEqual(tbRichTextData3.U().P(), str)) {
                                            if (i3 > i) {
                                                break;
                                            }
                                        }
                                    }
                                    int equipmentDensity = (int) BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst());
                                    TbRichTextData tbRichTextData4 = O.get(i4);
                                    Intrinsics.checkNotNull(tbRichTextData4);
                                    int width = tbRichTextData4.U().getWidth() * equipmentDensity;
                                    TbRichTextData tbRichTextData5 = O.get(i4);
                                    Intrinsics.checkNotNull(tbRichTextData5);
                                    int height = tbRichTextData5.U().getHeight() * equipmentDensity;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    c = i4;
                                    return f0;
                                }
                                continue;
                            }
                        }
                        continue;
                    }
                }
            }
            return null;
        }
        return (TbRichText) invokeLLI.objValue;
    }

    public final int c(PbModel pbModel, TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        boolean z;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{pbModel, tbRichText, tbRichText2, Integer.valueOf(i), Integer.valueOf(i2), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                b = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.O().size();
                int i4 = i;
                int i5 = -1;
                for (int i6 = 0; i6 < size; i6++) {
                    TbRichTextData tbRichTextData = tbRichText.O().get(i6);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i5++;
                        int equipmentDensity = (int) BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.U().getWidth() * equipmentDensity;
                        int height = tbRichTextData.U().getHeight() * equipmentDensity;
                        if (width >= 80 && height >= 80 && width * height >= 10000) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (!z && tbRichTextData.U().U()) {
                            if (tbRichTextData.getType() != 20) {
                                String bigImageUrl = mk9.a(tbRichTextData);
                                if (!TextUtils.isEmpty(bigImageUrl)) {
                                    arrayList.add(bigImageUrl);
                                    TbRichTextImageInfo U = tbRichTextData.U();
                                    if (U != null) {
                                        String O = U.O();
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                            imageUrlData.urlType = 38;
                                            O = U.P();
                                        } else {
                                            lk9 lk9Var = null;
                                            if (pbModel != null && pbModel.r1() != null) {
                                                lk9Var = pbModel.r1();
                                            }
                                            if (lk9Var != null && lk9Var.m0()) {
                                                i3 = 17;
                                            } else {
                                                i3 = 18;
                                            }
                                            imageUrlData.urlType = i3;
                                        }
                                        imageUrlData.imageUrl = O;
                                        imageUrlData.imageThumbUrl = O;
                                        imageUrlData.urlThumbType = imageUrlData.urlType;
                                        imageUrlData.originalUrl = pp9.o(tbRichTextData);
                                        imageUrlData.originalSize = pp9.p(tbRichTextData);
                                        imageUrlData.mIsShowOrigonButton = pp9.l(tbRichTextData);
                                        imageUrlData.isLongPic = pp9.k(tbRichTextData);
                                        imageUrlData.postId = tbRichText.getPostId();
                                        Intrinsics.checkNotNull(pbModel);
                                        imageUrlData.threadId = JavaTypesHelper.toLong(pbModel.L1(), -1L);
                                        imageUrlData.mIsReserver = pbModel.D1();
                                        imageUrlData.mIsSeeHost = pbModel.U0();
                                        if (concurrentHashMap != null) {
                                            Intrinsics.checkNotNullExpressionValue(bigImageUrl, "bigImageUrl");
                                            concurrentHashMap.put(bigImageUrl, imageUrlData);
                                        }
                                    }
                                }
                                if (!b) {
                                    i4++;
                                }
                            }
                        } else if (tbRichText == tbRichText2) {
                            if (i5 <= i2) {
                                i4--;
                            }
                        }
                    }
                }
                return i4;
            }
            return i;
        }
        return invokeCommon.intValue;
    }
}
