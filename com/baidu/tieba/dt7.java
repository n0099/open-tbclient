package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.funAd.http.FunAdRecordHttpMessage;
import com.baidu.tieba.vs7;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.fun.ad.sdk.ChannelNativeAds;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class dt7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void H(FunNativeAd2 funNativeAd2, int i, vs7.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65543, null, funNativeAd2, i, iVar) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-850528411, "Lcom/baidu/tieba/dt7$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-850528411, "Lcom/baidu/tieba/dt7$a;");
                    return;
                }
            }
            int[] iArr = new int[FunNativeAd.InteractionType.values().length];
            a = iArr;
            try {
                iArr[FunNativeAd.InteractionType.TYPE_DOWNLOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[FunNativeAd.InteractionType.TYPE_DIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[FunNativeAd.InteractionType.TYPE_BROWSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static void A(FunNativeAd2 funNativeAd2) {
        String str;
        String str2;
        String str3;
        String str4;
        NativeUnifiedADData nativeUnifiedADData;
        View l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, funNativeAd2) == null) && GlobalBuildConfig.isTiebaDebugTool() && funNativeAd2 != null && d(funNativeAd2) != null) {
            ChannelNativeAds d = d(funNativeAd2);
            FunNativeAd.InteractionType f = f(funNativeAd2);
            List<String> list = null;
            if (f != null) {
                str = f.name();
            } else {
                str = null;
            }
            if (funNativeAd2.getNativeInfo() != null) {
                list = funNativeAd2.getNativeInfo().getImageUrls();
                str2 = funNativeAd2.getNativeInfo().getDescription();
                str3 = funNativeAd2.getNativeInfo().getIconUrl();
                str4 = funNativeAd2.getNativeInfo().getTitle();
            } else {
                str2 = null;
                str3 = null;
                str4 = null;
            }
            Log.e(LogPrinter.TAG, "===== Show Fun Ad Type START ===== ");
            Log.e(LogPrinter.TAG, "isDownloadAd = " + str);
            Log.e(LogPrinter.TAG, "ksNative = " + d.ksNative);
            Log.e(LogPrinter.TAG, "gdtNative = " + d.gdtNative);
            Log.e(LogPrinter.TAG, "jyNative = " + d.jyNative);
            Log.e(LogPrinter.TAG, "imageurls = " + list);
            Log.e(LogPrinter.TAG, "videoView = " + l(funNativeAd2));
            Log.e(LogPrinter.TAG, "interactionType = " + str);
            Log.e(LogPrinter.TAG, "description = " + str2);
            Log.e(LogPrinter.TAG, "iconUrl = " + str3);
            Log.e(LogPrinter.TAG, "title = " + str4);
            Object obj = d.ksNative;
            if (obj instanceof KsNativeAd) {
                KsNativeAd ksNativeAd = (KsNativeAd) obj;
                Log.e(LogPrinter.TAG, "AdSourc=" + ksNativeAd.getAdSource());
                Log.e(LogPrinter.TAG, "AppName=" + ksNativeAd.getAppName());
                Log.e(LogPrinter.TAG, "AppScore=" + ksNativeAd.getAppScore());
                Log.e(LogPrinter.TAG, "AppVersion=" + ksNativeAd.getAppVersion());
                Log.e(LogPrinter.TAG, "AppDownloadCountDes=" + ksNativeAd.getAppDownloadCountDes());
                Log.e(LogPrinter.TAG, "CorporationName=" + ksNativeAd.getCorporationName());
                Log.e(LogPrinter.TAG, "PermissionInfo=" + ksNativeAd.getPermissionInfo());
                Log.e(LogPrinter.TAG, "getAppPrivacyUrl=" + ksNativeAd.getAppPrivacyUrl());
                Log.e(LogPrinter.TAG, "getActionDescription=" + ksNativeAd.getActionDescription());
                Log.e(LogPrinter.TAG, "getAdDescription=" + ksNativeAd.getAdDescription());
                List<KsImage> imageList = ksNativeAd.getImageList();
                if (imageList != null) {
                    for (KsImage ksImage : imageList) {
                        System.out.println("Test=>ksImage: height=" + ksImage.getHeight() + " width=" + ksImage.getWidth());
                    }
                }
                System.out.println("Test=>ksVideo[1]: height=" + ksNativeAd.getVideoHeight() + " width=" + ksNativeAd.getVideoWidth());
                if (ksNativeAd.getVideoCoverImage() != null) {
                    System.out.println("Test=>ksVideo[2]: height=" + ksNativeAd.getVideoCoverImage().getHeight() + " width=" + ksNativeAd.getVideoCoverImage().getWidth());
                }
            } else {
                Object obj2 = d.gdtNative;
                if (obj2 instanceof NativeUnifiedADData) {
                    Log.e(LogPrinter.TAG, "CTAText=" + nativeUnifiedADData.getCTAText());
                    Log.e(LogPrinter.TAG, "Title=" + nativeUnifiedADData.getTitle());
                    Log.e(LogPrinter.TAG, "AppScore=" + nativeUnifiedADData.getAppScore());
                    Log.e(LogPrinter.TAG, "DownloadCount=" + nativeUnifiedADData.getDownloadCount());
                    Log.e(LogPrinter.TAG, "ECPM=" + nativeUnifiedADData.getECPM());
                    Log.e(LogPrinter.TAG, "isAppAd=" + nativeUnifiedADData.isAppAd());
                    List<String> imgList = ((NativeUnifiedADData) obj2).getImgList();
                    if (imgList != null) {
                        Iterator<String> it = imgList.iterator();
                        while (it.hasNext()) {
                            System.out.println("Test=>gdtImage: image=" + it.next());
                        }
                    }
                    System.out.println("Test=>gdtImage: height=" + nativeUnifiedADData.getPictureHeight() + " width=" + nativeUnifiedADData.getPictureWidth());
                }
            }
            if (l(funNativeAd2) != null) {
                System.out.println("Test=>mediaView: width=" + l.getWidth() + " height=" + l.getHeight());
            }
            Log.e(LogPrinter.TAG, "===== Show Fun Ad Type END =====\n\n");
        }
    }

    public static void B(FunNativeAd2 funNativeAd2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, funNativeAd2) == null) {
            Object e = e(funNativeAd2);
            if (e instanceof NativeUnifiedADData) {
                ((NativeUnifiedADData) e).setVideoMute(false);
            }
        }
    }

    public static boolean J(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, funNativeAd2)) == null) {
            if (e(funNativeAd2) != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static int b(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, funNativeAd2)) == null) {
            int i = a.a[f(funNativeAd2).ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return 3;
                }
                if (i != 3) {
                    return 1;
                }
                return 4;
            }
            return 2;
        }
        return invokeL.intValue;
    }

    public static ChannelNativeAds d(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, funNativeAd2)) == null) {
            if (funNativeAd2 != null && funNativeAd2.getNativeInfo() != null) {
                return funNativeAd2.getNativeInfo().getChannelNativeAds();
            }
            return null;
        }
        return (ChannelNativeAds) invokeL.objValue;
    }

    public static Object e(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, funNativeAd2)) == null) {
            ChannelNativeAds d = d(funNativeAd2);
            if (d != null) {
                return d.gdtNative;
            }
            return null;
        }
        return invokeL.objValue;
    }

    public static FunNativeAd.InteractionType f(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, funNativeAd2)) == null) {
            if (funNativeAd2 != null && funNativeAd2.getNativeInfo() != null) {
                return funNativeAd2.getNativeInfo().getInteractionType();
            }
            return null;
        }
        return (FunNativeAd.InteractionType) invokeL.objValue;
    }

    public static Object g(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, funNativeAd2)) == null) {
            ChannelNativeAds d = d(funNativeAd2);
            if (d != null) {
                return d.ksNative;
            }
            return null;
        }
        return invokeL.objValue;
    }

    public static String h(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, funNativeAd2)) == null) {
            if (funNativeAd2 != null && funNativeAd2.getNativeInfo() != null) {
                return funNativeAd2.getNativeInfo().getDescription();
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String i(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, funNativeAd2)) == null) {
            if (funNativeAd2 != null && funNativeAd2.getNativeInfo() != null) {
                return funNativeAd2.getNativeInfo().getIconUrl();
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static List<String> j(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, funNativeAd2)) == null) {
            if (funNativeAd2 != null && funNativeAd2.getNativeInfo() != null) {
                return funNativeAd2.getNativeInfo().getImageUrls();
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public static String k(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, funNativeAd2)) == null) {
            if (funNativeAd2 != null && funNativeAd2.getNativeInfo() != null) {
                return funNativeAd2.getNativeInfo().getTitle();
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static View l(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, funNativeAd2)) == null) {
            if (funNativeAd2 != null && funNativeAd2.getNativeInfo() != null) {
                return funNativeAd2.getNativeInfo().getVideoView();
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    public static int p(@DimenRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65562, null, i)) == null) {
            return BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), i);
        }
        return invokeI.intValue;
    }

    public static int q(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        ChannelNativeAds d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, funNativeAd2)) == null) {
            if (funNativeAd2 == null || (d = d(funNativeAd2)) == null) {
                return -1;
            }
            if (d.gdtNative != null) {
                return 1;
            }
            if (d.ksNative == null) {
                return -1;
            }
            return 2;
        }
        return invokeL.intValue;
    }

    public static String r(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        ChannelNativeAds d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, funNativeAd2)) == null) {
            if (funNativeAd2 == null || (d = d(funNativeAd2)) == null) {
                return "";
            }
            if (d.gdtNative != null) {
                return FunAdSdk.PLATFORM_GDT;
            }
            if (d.ksNative == null) {
                return "";
            }
            return FunAdSdk.PLATFORM_KS;
        }
        return (String) invokeL.objValue;
    }

    public static int u(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, funNativeAd2)) == null) {
            if (l(funNativeAd2) != null) {
                return 2;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public static boolean z(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, funNativeAd2)) == null) {
            if (l(funNativeAd2) != null) {
                z = true;
            } else {
                z = false;
            }
            int s = s(funNativeAd2);
            if (z && s == 6) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void C(ImageView imageView, FunNativeAd2 funNativeAd2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, imageView, funNativeAd2) == null) && funNativeAd2 != null && imageView != null) {
            ChannelNativeAds d = d(funNativeAd2);
            if (d == null) {
                imageView.setVisibility(8);
                imageView.setImageDrawable(null);
            } else if (d.gdtNative != null) {
                imageView.setVisibility(0);
                WebPManager.setMaskDrawable(imageView, R.drawable.obfuscated_res_0x7f0809ae, WebPManager.ResourceStateType.NORMAL);
            } else if (d.ksNative != null) {
                imageView.setVisibility(0);
                WebPManager.setMaskDrawable(imageView, R.drawable.obfuscated_res_0x7f0809af, WebPManager.ResourceStateType.NORMAL);
            } else {
                imageView.setVisibility(8);
                imageView.setImageDrawable(null);
            }
        }
    }

    public static void D(View view2, boolean z) {
        int i;
        int p;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65539, null, view2, z) == null) && view2 != null && view2.getLayoutParams() != null) {
            if (z) {
                i = p(R.dimen.tbds447);
                p = p(R.dimen.tbds796);
            } else {
                i = -1;
                p = p(R.dimen.tbds504);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view2.getLayoutParams();
            layoutParams.topMargin = p(R.dimen.M_H_X004);
            if (layoutParams.width != i || layoutParams.height != p) {
                layoutParams.width = i;
                layoutParams.height = p;
                view2.setLayoutParams(layoutParams);
            }
        }
    }

    public static void G(View view2, boolean z) {
        int i;
        int p;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65542, null, view2, z) == null) && view2 != null && view2.getLayoutParams() != null) {
            if (z) {
                i = p(R.dimen.tbds515);
                p = p(R.dimen.tbds915);
            } else {
                i = -1;
                p = p(R.dimen.tbds551);
            }
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams.width != i || layoutParams.height != p) {
                layoutParams.width = i;
                layoutParams.height = p;
                view2.setLayoutParams(layoutParams);
            }
        }
    }

    public static void I(ImageView imageView, FunNativeAd2 funNativeAd2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65544, null, imageView, funNativeAd2) != null) || funNativeAd2 == null) {
            return;
        }
        ChannelNativeAds d = d(funNativeAd2);
        if (d == null) {
            imageView.setVisibility(8);
            imageView.setImageDrawable(null);
        } else if (d.gdtNative != null) {
            WebPManager.setMaskDrawable(imageView, R.drawable.obfuscated_res_0x7f0809b1, WebPManager.ResourceStateType.NORMAL);
            imageView.setVisibility(0);
        } else if (d.ksNative != null) {
            WebPManager.setMaskDrawable(imageView, R.drawable.obfuscated_res_0x7f0809b2, WebPManager.ResourceStateType.NORMAL);
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
            imageView.setImageDrawable(null);
        }
    }

    public static String c(FunNativeAd2 funNativeAd2, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65549, null, funNativeAd2, i)) == null) {
            if (i != 1) {
                if (i != 2) {
                    return "";
                }
                Object g = g(funNativeAd2);
                if (g instanceof KsNativeAd) {
                    KsNativeAd ksNativeAd = (KsNativeAd) g;
                    if (ad.isEmpty(ksNativeAd.getAppIconUrl())) {
                        return ksNativeAd.getProductName();
                    }
                    return ksNativeAd.getAppName();
                }
            } else {
                Object e = e(funNativeAd2);
                if (e instanceof NativeUnifiedADData) {
                    return ((NativeUnifiedADData) e).getTitle();
                }
            }
            return "";
        }
        return (String) invokeLI.objValue;
    }

    public static String t(FunNativeAd2 funNativeAd2, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65566, null, funNativeAd2, i)) == null) {
            if (i != 1) {
                if (i != 2) {
                    return "";
                }
                Object g = g(funNativeAd2);
                if (g instanceof KsNativeAd) {
                    KsNativeAd ksNativeAd = (KsNativeAd) g;
                    if (ad.isEmpty(ksNativeAd.getAppIconUrl())) {
                        return "";
                    }
                    return ksNativeAd.getAppIconUrl();
                }
            } else {
                Object e = e(funNativeAd2);
                if (e instanceof NativeUnifiedADData) {
                    return ((NativeUnifiedADData) e).getIconUrl();
                }
            }
            return "";
        }
        return (String) invokeLI.objValue;
    }

    public static void E(View view2, boolean z, List<String> list) {
        int i;
        int i2;
        int p;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{view2, Boolean.valueOf(z), list}) == null) && view2 != null && view2.getLayoutParams() != null) {
            if (z) {
                i = p(R.dimen.tbds515);
                p = p(R.dimen.tbds915);
            } else {
                i = -1;
                boolean z2 = true;
                if (ListUtils.getCount(list) != 1) {
                    z2 = false;
                }
                if (z2) {
                    i2 = R.dimen.tbds551;
                } else {
                    i2 = R.dimen.tbds213;
                }
                p = p(i2);
            }
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams.width != i || layoutParams.height != p) {
                layoutParams.width = i;
                layoutParams.height = p;
                view2.setLayoutParams(layoutParams);
            }
        }
    }

    public static void F(View view2, boolean z) {
        int p;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65541, null, view2, z) == null) && view2 != null && view2.getLayoutParams() != null) {
            if (z) {
                p = p(R.dimen.tbds33);
            } else {
                p = p(R.dimen.tbds25);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view2.getLayoutParams();
            layoutParams.topMargin = p;
            layoutParams.bottomMargin = 0;
            view2.setLayoutParams(layoutParams);
        }
    }

    public static String o(FunNativeAd2 funNativeAd2, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65561, null, funNativeAd2, i)) == null) {
            if (i != 1) {
                if (i != 2) {
                    return "";
                }
                Object g = g(funNativeAd2);
                if (g instanceof KsNativeAd) {
                    return ((KsNativeAd) g).getAdDescription();
                }
            } else {
                Object e = e(funNativeAd2);
                if (e instanceof NativeUnifiedADData) {
                    return ((NativeUnifiedADData) e).getDesc();
                }
            }
            return "";
        }
        return (String) invokeLI.objValue;
    }

    public static void K(int i, String str, String str2, nea neaVar) {
        List<String> list;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{Integer.valueOf(i), str, str2, neaVar}) == null) && neaVar != null && neaVar.e() != null) {
            FunNativeAd2 funNativeAd2 = (FunNativeAd2) neaVar.e();
            String str5 = null;
            if (funNativeAd2 != null && funNativeAd2.getNativeInfo() != null) {
                String title = funNativeAd2.getNativeInfo().getTitle();
                String description = funNativeAd2.getNativeInfo().getDescription();
                list = funNativeAd2.getNativeInfo().getImageUrls();
                str3 = title;
                str4 = description;
            } else {
                list = null;
                str3 = null;
                str4 = null;
            }
            String valueOf = String.valueOf(i);
            String g = neaVar.g();
            String d = neaVar.d();
            if (list != null) {
                str5 = list.toString();
            }
            FunAdRecordHttpMessage.uploadShowOrClickRecord(str, str2, valueOf, g, d, str3, str4, str5, r(funNativeAd2), String.valueOf(v(funNativeAd2)));
        }
    }

    public static void a(StatisticItem statisticItem, nea neaVar) {
        List<String> list;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65547, null, statisticItem, neaVar) == null) && statisticItem != null && neaVar != null && neaVar.e() != null) {
            FunNativeAd2 funNativeAd2 = (FunNativeAd2) neaVar.e();
            statisticItem.param("tid", neaVar.g());
            statisticItem.param("fid", neaVar.d());
            statisticItem.param(TiebaStatic.Params.AD_TYPE, v(funNativeAd2));
            statisticItem.param(TiebaStatic.Params.AD_SOURCE, r(funNativeAd2));
            String str2 = null;
            if (funNativeAd2 != null && funNativeAd2.getNativeInfo() != null) {
                str2 = funNativeAd2.getNativeInfo().getTitle();
                str = funNativeAd2.getNativeInfo().getDescription();
                list = funNativeAd2.getNativeInfo().getImageUrls();
            } else {
                list = null;
                str = null;
            }
            statisticItem.param(TiebaStatic.Params.AD_TITLE, str2);
            statisticItem.param(TiebaStatic.Params.AD_DESC, str);
            if (list != null) {
                statisticItem.param("ad_pic", list.toString());
            }
        }
    }

    public static String n(@NonNull FunNativeAd2 funNativeAd2, @NonNull Context context) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, funNativeAd2, context)) == null) {
            ChannelNativeAds d = d(funNativeAd2);
            int i2 = R.string.obfuscated_res_0x7f0f00d7;
            if (d == null) {
                return context.getString(R.string.obfuscated_res_0x7f0f00d7);
            }
            Object obj = d.ksNative;
            if (obj instanceof KsNativeAd) {
                return ((KsNativeAd) obj).getActionDescription();
            }
            int i3 = a.a[f(funNativeAd2).ordinal()];
            int i4 = R.string.obfuscated_res_0x7f0f00da;
            if (i3 != 1) {
                if (i3 != 2) {
                    i = R.string.obfuscated_res_0x7f0f00d7;
                } else {
                    i = R.string.obfuscated_res_0x7f0f00d9;
                }
            } else {
                i = R.string.obfuscated_res_0x7f0f00da;
            }
            Object obj2 = d.gdtNative;
            if (!(obj2 instanceof NativeUnifiedADData) || !((NativeUnifiedADData) obj2).isAppAd()) {
                i4 = i;
            }
            if (i4 != 0) {
                i2 = i4;
            }
            return context.getString(i2);
        }
        return (String) invokeLL.objValue;
    }

    public static String m(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, funNativeAd2)) == null) {
            ChannelNativeAds d = d(funNativeAd2);
            if (d == null) {
                return TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f00d7);
            }
            Object obj = d.ksNative;
            if (obj instanceof KsNativeAd) {
                return ((KsNativeAd) obj).getActionDescription();
            }
            int i2 = a.a[f(funNativeAd2).ordinal()];
            int i3 = R.string.obfuscated_res_0x7f0f00d8;
            int i4 = R.string.obfuscated_res_0x7f0f00da;
            if (i2 != 1) {
                if (i2 != 2) {
                    i = R.string.obfuscated_res_0x7f0f00d8;
                } else {
                    i = R.string.obfuscated_res_0x7f0f00d9;
                }
            } else {
                i = R.string.obfuscated_res_0x7f0f00da;
            }
            Object obj2 = d.gdtNative;
            if (!(obj2 instanceof NativeUnifiedADData) || !((NativeUnifiedADData) obj2).isAppAd()) {
                i4 = i;
            }
            if (i4 != 0) {
                i3 = i4;
            }
            return TbadkCoreApplication.getInst().getContext().getString(i3);
        }
        return (String) invokeL.objValue;
    }

    public static int s(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        KsNativeAd ksNativeAd;
        KsImage ksImage;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, funNativeAd2)) == null) {
            if (funNativeAd2 != null && d(funNativeAd2) != null) {
                int q = q(funNativeAd2);
                if (q != 1) {
                    if (q != 2 || (ksNativeAd = (KsNativeAd) g(funNativeAd2)) == null) {
                        return -1;
                    }
                    if (l(funNativeAd2) != null) {
                        if (ksNativeAd.getVideoWidth() > ksNativeAd.getVideoHeight()) {
                            return 5;
                        }
                        return 6;
                    }
                    List<KsImage> imageList = ksNativeAd.getImageList();
                    if (!ListUtils.isEmpty(imageList) && (ksImage = (KsImage) ListUtils.getItem(imageList, 0)) != null) {
                        if (ksImage.getWidth() <= ksImage.getHeight()) {
                            return 4;
                        }
                        return 0;
                    }
                } else {
                    NativeUnifiedADData nativeUnifiedADData = (NativeUnifiedADData) e(funNativeAd2);
                    if (nativeUnifiedADData != null) {
                        if (l(funNativeAd2) != null) {
                            if (nativeUnifiedADData.getPictureWidth() > nativeUnifiedADData.getPictureHeight()) {
                                return 5;
                            }
                            return 6;
                        } else if (nativeUnifiedADData.getPictureWidth() <= nativeUnifiedADData.getPictureHeight()) {
                            return 4;
                        } else {
                            return 0;
                        }
                    }
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static int v(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        ChannelNativeAds d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, funNativeAd2)) == null) {
            if (funNativeAd2 == null || d(funNativeAd2) == null || (d = d(funNativeAd2)) == null) {
                return 0;
            }
            if (d.gdtNative != null) {
                return u(funNativeAd2);
            }
            if (d.ksNative != null) {
                return u(funNativeAd2);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static boolean w(FunNativeAd2 funNativeAd2) {
        InterceptResult invokeL;
        ChannelNativeAds d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, funNativeAd2)) == null) {
            if (funNativeAd2 == null || (d = d(funNativeAd2)) == null || d.gdtNative != null) {
                return false;
            }
            Object obj = d.ksNative;
            if (!(obj instanceof KsNativeAd)) {
                return false;
            }
            return !TextUtils.isEmpty(((KsNativeAd) obj).getAppIconUrl());
        }
        return invokeL.booleanValue;
    }

    public static boolean x(FunNativeAd2 funNativeAd2, List<String> list) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65570, null, funNativeAd2, list)) == null) {
            if (ListUtils.getCount(list) == 1) {
                z = true;
            } else {
                z = false;
            }
            int s = s(funNativeAd2);
            if (!z || s != 2) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean y(FunNativeAd2 funNativeAd2, List<String> list) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65571, null, funNativeAd2, list)) == null) {
            if (ListUtils.getCount(list) == 1) {
                z = true;
            } else {
                z = false;
            }
            int s = s(funNativeAd2);
            if (!z || s != 4) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
