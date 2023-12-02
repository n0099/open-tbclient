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
public final class c1a {
    public static /* synthetic */ Interceptable $ic;
    public static final c1a a;
    public static boolean b;
    public static int c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947623286, "Lcom/baidu/tieba/c1a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947623286, "Lcom/baidu/tieba/c1a;");
                return;
            }
        }
        a = new c1a();
    }

    public c1a() {
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
            zv9 s1 = pbModel.s1();
            TbRichText f = f(pbModel, str, i);
            if (f == null || (tbRichTextData = f.Q().get(c)) == null) {
                return;
            }
            eVar.f = String.valueOf(f.getPostId());
            eVar.a = new ArrayList<>();
            eVar.b = new ConcurrentHashMap<>();
            boolean z = false;
            if (!tbRichTextData.V().W()) {
                eVar.h = false;
                String a2 = aw9.a(tbRichTextData);
                eVar.a.add(a2);
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.imageUrl = str;
                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                    imageUrlData.urlType = 38;
                } else {
                    Intrinsics.checkNotNull(s1);
                    if (s1.n0()) {
                        i4 = 17;
                    } else {
                        i4 = 18;
                    }
                    imageUrlData.urlType = i4;
                }
                imageUrlData.urlThumbType = imageUrlData.urlType;
                imageUrlData.imageThumbUrl = imageUrlData.imageUrl;
                imageUrlData.originalUrl = m1a.k(tbRichTextData);
                imageUrlData.originalUrl = m1a.k(tbRichTextData);
                imageUrlData.originalSize = m1a.l(tbRichTextData);
                imageUrlData.mIsShowOrigonButton = m1a.h(tbRichTextData);
                imageUrlData.isLongPic = m1a.g(tbRichTextData);
                imageUrlData.postId = f.getPostId();
                imageUrlData.mIsReserver = pbModel.E1();
                imageUrlData.mIsSeeHost = pbModel.V0();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = eVar.b;
                Intrinsics.checkNotNullExpressionValue(concurrentHashMap, "result.assistUrls");
                concurrentHashMap.put(a2, imageUrlData);
                if (s1 != null) {
                    if (s1.n() != null) {
                        eVar.c = s1.n().getName();
                        eVar.d = s1.n().getId();
                    }
                    if (s1.R() != null) {
                        eVar.e = s1.R().getId();
                    }
                    if (s1.u() == 1) {
                        z = true;
                    }
                    eVar.g = z;
                }
                imageUrlData.threadId = JavaTypesHelper.toLong(eVar.e, -1L);
                return;
            }
            eVar.h = true;
            Intrinsics.checkNotNull(s1);
            int size = s1.I().size();
            b = false;
            eVar.j = -1;
            if (s1.l() != null) {
                TbRichText f0 = s1.l().f0();
                c1a c1aVar = a;
                ArrayList<String> arrayList = eVar.a;
                Intrinsics.checkNotNullExpressionValue(arrayList, "result.urlList");
                i2 = c1aVar.c(pbModel, f0, f, i, i, arrayList, eVar.b);
            } else {
                i2 = i;
            }
            int i5 = i2;
            int i6 = 0;
            while (i6 < size) {
                mwa mwaVar = s1.I().get(i6);
                if (mwaVar.U() != null && s1.l() != null && s1.l().U() != null && Intrinsics.areEqual(mwaVar.U(), s1.l().U())) {
                    i3 = i6;
                } else {
                    TbRichText f02 = mwaVar.f0();
                    c1a c1aVar2 = a;
                    ArrayList<String> arrayList2 = eVar.a;
                    Intrinsics.checkNotNullExpressionValue(arrayList2, "result.urlList");
                    i3 = i6;
                    i5 = c1aVar2.c(pbModel, f02, f, i5, i, arrayList2, eVar.b);
                }
                i6 = i3 + 1;
            }
            if (eVar.a.size() > 0) {
                ArrayList<String> arrayList3 = eVar.a;
                eVar.i = arrayList3.get(arrayList3.size() - 1);
            }
            if (s1.n() != null) {
                eVar.c = s1.n().getName();
                eVar.d = s1.n().getId();
            }
            if (s1.R() != null) {
                eVar.e = s1.R().getId();
            }
            if (s1.u() == 1) {
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
            if (pbModel == null || pbModel.s1() == null || str == null || i < 0) {
                return null;
            }
            zv9 s1 = pbModel.s1();
            if (s1.l() != null) {
                ArrayList<mwa> arrayList = new ArrayList<>();
                arrayList.add(s1.l());
                tbRichText = a.b(arrayList, str, i);
            }
            if (tbRichText == null) {
                ArrayList<mwa> I = s1.I();
                a.a(s1, I);
                return a.b(I, str, i);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLLI.objValue;
    }

    public final void a(zv9 zv9Var, ArrayList<mwa> arrayList) {
        List<mwa> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, zv9Var, arrayList) == null) && zv9Var != null && zv9Var.W() != null && zv9Var.W().a != null && (list = zv9Var.W().a) != null && arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (list.size() > 0 && arrayList.size() > 0) {
                arrayList3.addAll(list);
                Iterator<mwa> it = arrayList.iterator();
                while (it.hasNext()) {
                    mwa next = it.next();
                    if (next != null) {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            mwa mwaVar = (mwa) it2.next();
                            if (mwaVar != null && !TextUtils.isEmpty(next.U()) && !TextUtils.isEmpty(mwaVar.U()) && Intrinsics.areEqual(next.U(), mwaVar.U())) {
                                arrayList2.add(mwaVar);
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

    public final TbRichText b(ArrayList<mwa> arrayList, String str, int i) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> Q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, str, i)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    mwa mwaVar = arrayList.get(i2);
                    Intrinsics.checkNotNullExpressionValue(mwaVar, "datas[k]");
                    TbRichText f0 = mwaVar.f0();
                    if (f0 != null && (Q = f0.Q()) != null) {
                        int size2 = Q.size();
                        int i3 = -1;
                        for (int i4 = 0; i4 < size2; i4++) {
                            if (Q.get(i4) != null) {
                                TbRichTextData tbRichTextData = Q.get(i4);
                                Intrinsics.checkNotNull(tbRichTextData);
                                if (tbRichTextData.getType() == 8) {
                                    i3++;
                                    TbRichTextData tbRichTextData2 = Q.get(i4);
                                    Intrinsics.checkNotNull(tbRichTextData2);
                                    if (!Intrinsics.areEqual(tbRichTextData2.V().Q(), str)) {
                                        TbRichTextData tbRichTextData3 = Q.get(i4);
                                        Intrinsics.checkNotNull(tbRichTextData3);
                                        if (!Intrinsics.areEqual(tbRichTextData3.V().R(), str)) {
                                            if (i3 > i) {
                                                break;
                                            }
                                        }
                                    }
                                    int equipmentDensity = (int) BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst());
                                    TbRichTextData tbRichTextData4 = Q.get(i4);
                                    Intrinsics.checkNotNull(tbRichTextData4);
                                    int width = tbRichTextData4.V().getWidth() * equipmentDensity;
                                    TbRichTextData tbRichTextData5 = Q.get(i4);
                                    Intrinsics.checkNotNull(tbRichTextData5);
                                    int height = tbRichTextData5.V().getHeight() * equipmentDensity;
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
                int size = tbRichText.Q().size();
                int i4 = i;
                int i5 = -1;
                for (int i6 = 0; i6 < size; i6++) {
                    TbRichTextData tbRichTextData = tbRichText.Q().get(i6);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i5++;
                        int equipmentDensity = (int) BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.V().getWidth() * equipmentDensity;
                        int height = tbRichTextData.V().getHeight() * equipmentDensity;
                        if (width >= 80 && height >= 80 && width * height >= 10000) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (!z && tbRichTextData.V().W()) {
                            if (tbRichTextData.getType() != 20) {
                                String bigImageUrl = aw9.a(tbRichTextData);
                                if (!TextUtils.isEmpty(bigImageUrl)) {
                                    arrayList.add(bigImageUrl);
                                    TbRichTextImageInfo V = tbRichTextData.V();
                                    if (V != null) {
                                        String Q = V.Q();
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                            imageUrlData.urlType = 38;
                                            Q = V.R();
                                        } else {
                                            zv9 zv9Var = null;
                                            if (pbModel != null && pbModel.s1() != null) {
                                                zv9Var = pbModel.s1();
                                            }
                                            if (zv9Var != null && zv9Var.n0()) {
                                                i3 = 17;
                                            } else {
                                                i3 = 18;
                                            }
                                            imageUrlData.urlType = i3;
                                        }
                                        imageUrlData.imageUrl = Q;
                                        imageUrlData.imageThumbUrl = Q;
                                        imageUrlData.urlThumbType = imageUrlData.urlType;
                                        imageUrlData.originalUrl = m1a.k(tbRichTextData);
                                        imageUrlData.originalSize = m1a.l(tbRichTextData);
                                        imageUrlData.mIsShowOrigonButton = m1a.h(tbRichTextData);
                                        imageUrlData.isLongPic = m1a.g(tbRichTextData);
                                        imageUrlData.postId = tbRichText.getPostId();
                                        Intrinsics.checkNotNull(pbModel);
                                        imageUrlData.threadId = JavaTypesHelper.toLong(pbModel.M1(), -1L);
                                        imageUrlData.mIsReserver = pbModel.E1();
                                        imageUrlData.mIsSeeHost = pbModel.V0();
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
