package com.baidu.tieba;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.FunSdkInitSwitch;
import com.baidu.tbadk.switchs.VideoMiddleAdSwitch;
import com.baidu.tieba.funAd.http.FunAdRecordHttpMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class ft7 {
    public static /* synthetic */ Interceptable $ic;
    public static ft7 b;
    public transient /* synthetic */ FieldHolder $fh;
    public e a;

    /* loaded from: classes5.dex */
    public interface e {
        void a(String str);

        void b(Activity activity, String str, int i, g gVar, f fVar);

        void c(ImageView imageView, Object obj);

        void d(Context context, String str, int i, int i2, g gVar, f fVar);

        void destroyAd(String str);

        ViewGroup e(@NonNull Context context);

        View f(Object obj);

        void g(Activity activity, String str, ViewGroup viewGroup, h hVar, f fVar);

        boolean h(Object obj);

        Object i(@NonNull Activity activity, @NonNull String str);

        boolean isAdReady(String str);

        void j(Object obj, i iVar);

        void k(Application application, k kVar);

        @NonNull
        List<et7> l(String str);

        void m(Activity activity, @NonNull Object obj, h hVar, ViewGroup viewGroup, List<View> list, List<View> list2, f fVar, String str);

        void n(Activity activity, String str, ViewGroup viewGroup, h hVar, f fVar);

        lda o(Object obj);
    }

    /* loaded from: classes5.dex */
    public interface g {
        void a(String str, int i);

        void onError(String str);
    }

    /* loaded from: classes5.dex */
    public interface h {
        void a(String str);

        void onAdClicked(String str, String str2, String str3);

        void onAdClose(String str);

        void onAdError(String str);

        void onAdShow(String str, String str2, String str3);
    }

    /* loaded from: classes5.dex */
    public interface i {
        void a(long j, long j2);
    }

    /* loaded from: classes5.dex */
    public interface k {
        void initComplete();
    }

    /* loaded from: classes5.dex */
    public class a implements g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(ft7 ft7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ft7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.ft7.g
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                FunAdRecordHttpMessage.uploadRequestRecord("a002", "0", null, null, null);
                StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a002").param("obj_locate", 0).eventStat();
            }
        }

        @Override // com.baidu.tieba.ft7.g
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                FunAdRecordHttpMessage.uploadRequestRecord("a002", "1", null, null, "0");
                StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a002").param("obj_locate", 1).param("resource_id", 0).eventStat();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public b(ft7 ft7Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ft7Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        @Override // com.baidu.tieba.ft7.g
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                FunAdRecordHttpMessage.uploadRequestRecord("a006", "0", null, this.a, null);
                StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a006").param("obj_locate", 0).param("resource_id", i).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param("fid", ht7.c("a006")).eventStat();
            }
        }

        @Override // com.baidu.tieba.ft7.g
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                FunAdRecordHttpMessage.uploadRequestRecord("a006", "1", null, this.a, "0");
                StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a006").param("obj_locate", 1).param("resource_id", 0).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param("fid", ht7.c("a006")).eventStat();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ft7 c;

        public c(ft7 ft7Var, g gVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ft7Var, gVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ft7Var;
            this.a = gVar;
            this.b = str;
        }

        @Override // com.baidu.tieba.ft7.g
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                g gVar = this.a;
                if (gVar != null) {
                    gVar.a(str, i);
                }
                this.c.G(0, this.b, String.valueOf(1));
            }
        }

        @Override // com.baidu.tieba.ft7.g
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                g gVar = this.a;
                if (gVar != null) {
                    gVar.onError(str);
                }
                this.c.G(1, this.b, String.valueOf(0));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public d(ft7 ft7Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ft7Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
        }

        @Override // com.baidu.tieba.ft7.g
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                FunAdRecordHttpMessage.uploadRequestRecord("a005", "0", this.a, this.b, null);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a005").param("obj_locate", 0));
            }
        }

        @Override // com.baidu.tieba.ft7.g
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                FunAdRecordHttpMessage.uploadRequestRecord("a005", "1", this.a, this.b, "0");
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a005").param("obj_locate", 1).param("resource_id", 0));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class j implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.ft7.h
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        public j() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public ft7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = k();
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            String w = r95.p().w("key_server_frs_bear_sid", "");
            if (StringUtils.isNull(w)) {
                w = "6051001001-2043781376";
            }
            z("frs广告位", w);
            return w;
        }
        return (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            String w = r95.p().w("key_server_pb_comment_bear_sid", "");
            if (StringUtils.isNull(w)) {
                w = "6051002523-210422477";
            }
            z("pb评论区广告位", w);
            return w;
        }
        return (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            String w = r95.p().w("key_server_homepage_bear_sid", "");
            if (StringUtils.isNull(w)) {
                w = "6051001980-1210572494";
            }
            z("首页推荐personalize-信息流广告位", w);
            return w;
        }
        return (String) invokeV.objValue;
    }

    public static String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            String w = r95.p().w("key_server_pb_banner_bear_sid", "");
            if (StringUtils.isNull(w)) {
                w = "6051001308-627527144";
            }
            z("pb-banner广告位", w);
            return w;
        }
        return (String) invokeV.objValue;
    }

    public static String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            String w = r95.p().w("key_server_picpage_bear_sid", "");
            if (StringUtils.isNull(w)) {
                w = "6051001643-679358748";
            }
            z("贴吧大图页广告位", w);
            return w;
        }
        return (String) invokeV.objValue;
    }

    public static String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            String w = r95.p().w("key_server_videoflow_bear_sid", "");
            if (StringUtils.isNull(w)) {
                w = "6061002410-390177882";
            }
            z("沉浸态", w);
            return w;
        }
        return (String) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return nc5.g();
        }
        return invokeV.intValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return nc5.h();
        }
        return invokeV.intValue;
    }

    public void x(Activity activity, String str, g gVar, f fVar) {
        e eVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048599, this, activity, str, gVar, fVar) == null) && (eVar = this.a) != null) {
            eVar.b(activity, str, 1, gVar, fVar);
        }
    }

    public static f b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            f fVar = new f();
            fVar.a = str;
            fVar.b = str2;
            return fVar;
        }
        return (f) invokeLL.objValue;
    }

    public void A(ImageView imageView, Object obj) {
        e eVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, imageView, obj) != null) || (eVar = this.a) == null) {
            return;
        }
        eVar.c(imageView, obj);
    }

    public void B(Object obj, i iVar) {
        e eVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, iVar) != null) || (eVar = this.a) == null) {
            return;
        }
        eVar.j(obj, iVar);
    }

    public Object n(@NonNull Activity activity, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, activity, str)) == null) {
            e eVar = this.a;
            if (eVar != null) {
                return eVar.i(activity, str);
            }
            return null;
        }
        return invokeLL.objValue;
    }

    public static ft7 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (b == null) {
                synchronized (ft7.class) {
                    if (b == null) {
                        b = new ft7();
                    }
                }
            }
            if (b.a == null && PermissionUtil.isAgreePrivacyPolicy()) {
                b = new ft7();
            }
            return b;
        }
        return (ft7) invokeV.objValue;
    }

    public static String p() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (!r95.p().l("key_splash_shake_ad_open", true)) {
                str = "6021005334-1052188080";
            } else {
                str = null;
            }
            if (StringUtils.isNull(str)) {
                str = r95.p().w("key_server_splash_bear_sid", "");
            }
            if (StringUtils.isNull(str)) {
                str = "6021002119-1732188456";
            }
            z("贴吧开屏广告位(先审后播广告)", str);
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static String q() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (!r95.p().l("key_splash_shake_ad_open", true)) {
                str = "6021005321-1773936643";
            } else {
                str = null;
            }
            if (StringUtils.isNull(str)) {
                str = r95.p().w("key_server_splash_bear_sid", "");
            }
            if (StringUtils.isNull(str)) {
                str = "6021002118-283136489";
            }
            z("贴吧开屏广告位(先播后审广告)", str);
            return str;
        }
        return (String) invokeV.objValue;
    }

    public final e k() {
        InterceptResult invokeV;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (!PermissionUtil.isAgreePrivacyPolicy() || !FunSdkInitSwitch.isOn() || (runTask = MessageManager.getInstance().runTask(2921525, e.class)) == null) {
                return null;
            }
            return (e) runTask.getData();
        }
        return (e) invokeV.objValue;
    }

    public static void z(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, str2) == null) {
            if (TbadkCoreApplication.getInst().isDebugMode() || j05.h()) {
                PrintStream printStream = System.out;
                printStream.println("FunAdSdk，" + str + "， sid is: " + str2);
            }
        }
    }

    public boolean C(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            e eVar = this.a;
            if (eVar == null) {
                return false;
            }
            return eVar.h(obj);
        }
        return invokeL.booleanValue;
    }

    public lda H(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            e eVar = this.a;
            if (eVar == null) {
                return null;
            }
            return eVar.o(obj);
        }
        return (lda) invokeL.objValue;
    }

    public void c(String str) {
        e eVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, str) == null) && (eVar = this.a) != null) {
            eVar.a(str);
        }
    }

    public void d(String str) {
        e eVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, str) == null) && (eVar = this.a) != null) {
            eVar.destroyAd(str);
        }
    }

    public List<et7> j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            e eVar = this.a;
            if (eVar != null) {
                return eVar.l(str);
            }
            return new ArrayList(0);
        }
        return (List) invokeL.objValue;
    }

    public ViewGroup l(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, context)) == null) {
            e eVar = this.a;
            if (eVar != null) {
                return eVar.e(context);
            }
            return null;
        }
        return (ViewGroup) invokeL.objValue;
    }

    public View t(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, obj)) == null) {
            e eVar = this.a;
            if (eVar == null) {
                return null;
            }
            return eVar.f(obj);
        }
        return (View) invokeL.objValue;
    }

    public void u(k kVar) {
        e eVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, kVar) != null) || (eVar = this.a) == null) {
            return;
        }
        eVar.k(TbadkCoreApplication.getInst(), kVar);
    }

    public boolean v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            e eVar = this.a;
            if (eVar != null && eVar.isAdReady(str)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void D(Activity activity, String str, ViewGroup viewGroup, h hVar, f fVar) {
        e eVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLLL(1048579, this, activity, str, viewGroup, hVar, fVar) == null) && (eVar = this.a) != null) {
            eVar.n(activity, str, viewGroup, hVar, fVar);
        }
    }

    public void F(Activity activity, String str, ViewGroup viewGroup, h hVar, f fVar) {
        e eVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLLL(1048581, this, activity, str, viewGroup, hVar, fVar) == null) && (eVar = this.a) != null) {
            eVar.g(activity, str, viewGroup, hVar, fVar);
        }
    }

    public void E(Activity activity, @NonNull Object obj, h hVar, ViewGroup viewGroup, List<View> list, List<View> list2, f fVar, String str) {
        e eVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{activity, obj, hVar, viewGroup, list, list2, fVar, str}) == null) && (eVar = this.a) != null) {
            eVar.m(activity, obj, hVar, viewGroup, list, list2, fVar, str);
        }
    }

    public final void G(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048582, this, i2, str, str2) == null) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_locate", i2).param("tid", "").param("fid", "").param("obj_type", str).param("resource_id", str2));
        }
    }

    public void y(Activity activity, g gVar, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048600, this, activity, gVar, str) != null) || this.a == null) {
            return;
        }
        G(2, str, "");
        e eVar = this.a;
        String s = s();
        c cVar = new c(this, gVar, str);
        if (VideoMiddleAdSwitch.isOn()) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        eVar.b(activity, s, 1, cVar, b(str, str2));
    }

    public boolean I(Activity activity, String str, f fVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, str, fVar)) == null) {
            if (this.a != null && !TextUtils.isEmpty(str) && fVar != null) {
                boolean isAdReady = this.a.isAdReady(str);
                StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a002").eventStat();
                System.currentTimeMillis();
                FunAdRecordHttpMessage.uploadRequestRecord("a002", null, null, null, null);
                this.a.b(activity, str, 1, new a(this), fVar);
                return isAdReady;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public boolean J(Activity activity, String str, f fVar, String str2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{activity, str, fVar, str2, Integer.valueOf(i2)})) == null) {
            if (this.a != null && !TextUtils.isEmpty(str) && fVar != null) {
                boolean isAdReady = this.a.isAdReady(str);
                StatisticItem.make(TbadkCoreStatisticKey.REQUEST_AD_TIME).param("obj_source", 6).param("fid", str2).param(TiebaStatic.Params.OBJ_PARAM2, i2).param("obj_type", "a006").param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param("fid", ht7.c("a006")).eventStat();
                FunAdRecordHttpMessage.uploadRequestRecord("a006", null, null, str2, null);
                this.a.b(activity, str, i2, new b(this, str2), fVar);
                return isAdReady;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public boolean K(Activity activity, String str, f fVar, String str2, String str3) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048586, this, activity, str, fVar, str2, str3)) == null) {
            if (this.a != null && !TextUtils.isEmpty(str) && fVar != null) {
                boolean isAdReady = this.a.isAdReady(str);
                FunAdRecordHttpMessage.uploadRequestRecord("a005", null, str2, str3, null);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("tid", str2).param("fid", str3).param("obj_type", "a005").param("obj_param1", "2"));
                this.a.b(activity, str, 1, new d(this, str2, str3), fVar);
                return isAdReady;
            }
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    public void w(Context context, String str, int i2, g gVar, f fVar) {
        e eVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{context, str, Integer.valueOf(i2), gVar, fVar}) == null) && (eVar = this.a) != null) {
            eVar.d(context, str, 1, i2, gVar, fVar);
        }
    }
}
