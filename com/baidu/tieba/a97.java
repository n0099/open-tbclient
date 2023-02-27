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
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
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
/* loaded from: classes3.dex */
public class a97 {
    public static /* synthetic */ Interceptable $ic;
    public static a97 b;
    public transient /* synthetic */ FieldHolder $fh;
    public f a;

    /* loaded from: classes3.dex */
    public interface f {
        void a(String str);

        void b(Activity activity, String str, int i, h hVar, g gVar);

        void c(ImageView imageView, Object obj);

        void d(Context context, String str, int i, int i2, h hVar, g gVar);

        void destroyAd(String str);

        ViewGroup e(@NonNull Context context);

        View f(Object obj);

        void g(Activity activity, String str, ViewGroup viewGroup, i iVar, g gVar);

        boolean h(Object obj);

        Object i(@NonNull Activity activity, @NonNull String str);

        boolean isAdReady(String str);

        void j(Object obj, j jVar);

        void k(Application application, l lVar);

        @NonNull
        List<z87> l(String str);

        void m(Activity activity, @NonNull Object obj, i iVar, ViewGroup viewGroup, List<View> list, List<View> list2, g gVar, String str);

        void n(Activity activity, String str, ViewGroup viewGroup, i iVar, g gVar);

        le9 o(Object obj);
    }

    /* loaded from: classes3.dex */
    public interface h {
        void a(String str, int i);

        void onError(String str);
    }

    /* loaded from: classes3.dex */
    public interface i {
        void a(String str);

        void onAdClicked(String str, String str2, String str3);

        void onAdClose(String str);

        void onAdError(String str);

        void onAdShow(String str, String str2, String str3);
    }

    /* loaded from: classes3.dex */
    public interface j {
        void a(long j, long j2);
    }

    /* loaded from: classes3.dex */
    public interface l {
        void initComplete();
    }

    /* loaded from: classes3.dex */
    public class a implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(a97 a97Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a97Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.a97.h
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                FunAdRecordHttpMessage.uploadRequestRecord("a002", "0", null, null, null);
                StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a002").param("obj_locate", 0).eventStat();
            }
        }

        @Override // com.baidu.tieba.a97.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                FunAdRecordHttpMessage.uploadRequestRecord("a002", "1", null, null, "0");
                StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a002").param("obj_locate", 1).param("resource_id", 0).eventStat();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public b(a97 a97Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a97Var, str};
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

        @Override // com.baidu.tieba.a97.h
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                FunAdRecordHttpMessage.uploadRequestRecord("a006", "0", null, this.a, null);
                StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a006").param("obj_locate", 0).param("resource_id", i).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param("fid", c97.c("a006")).eventStat();
            }
        }

        @Override // com.baidu.tieba.a97.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                FunAdRecordHttpMessage.uploadRequestRecord("a006", "1", null, this.a, "0");
                StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a006").param("obj_locate", 1).param("resource_id", 0).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param("fid", c97.c("a006")).eventStat();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;
        public final /* synthetic */ String b;

        public c(a97 a97Var, h hVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a97Var, hVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
            this.b = str;
        }

        @Override // com.baidu.tieba.a97.h
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                h hVar = this.a;
                if (hVar != null) {
                    hVar.a(str, i);
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", this.b).param("obj_locate", 0).param("resource_id", i));
            }
        }

        @Override // com.baidu.tieba.a97.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                h hVar = this.a;
                if (hVar != null) {
                    hVar.onError(str);
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", this.b).param("obj_locate", 1).param("resource_id", 0));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;
        public final /* synthetic */ String b;
        public final /* synthetic */ a97 c;

        public d(a97 a97Var, h hVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a97Var, hVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = a97Var;
            this.a = hVar;
            this.b = str;
        }

        @Override // com.baidu.tieba.a97.h
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                h hVar = this.a;
                if (hVar != null) {
                    hVar.a(str, i);
                }
                this.c.H(0, this.b, String.valueOf(1));
            }
        }

        @Override // com.baidu.tieba.a97.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                h hVar = this.a;
                if (hVar != null) {
                    hVar.onError(str);
                }
                this.c.H(1, this.b, String.valueOf(0));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public e(a97 a97Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a97Var, str, str2};
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

        @Override // com.baidu.tieba.a97.h
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                FunAdRecordHttpMessage.uploadRequestRecord("a005", "0", this.a, this.b, null);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a005").param("obj_locate", 0));
            }
        }

        @Override // com.baidu.tieba.a97.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                FunAdRecordHttpMessage.uploadRequestRecord("a005", "1", this.a, this.b, "0");
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a005").param("obj_locate", 1).param("resource_id", 0));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;

        public g() {
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

    /* loaded from: classes3.dex */
    public static abstract class k implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.a97.i
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        public k() {
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

    public a97() {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            String s = b55.m().s("key_server_frs_bear_sid", "");
            if (StringUtils.isNull(s)) {
                s = "6051001001-2043781376";
            }
            A("frs广告位", s);
            return s;
        }
        return (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            String s = b55.m().s("key_server_pb_comment_bear_sid", "");
            if (StringUtils.isNull(s)) {
                s = "6051002523-210422477";
            }
            A("pb评论区广告位", s);
            return s;
        }
        return (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            String s = b55.m().s("key_server_homepage_bear_sid", "");
            if (StringUtils.isNull(s)) {
                s = "6051001980-1210572494";
            }
            A("首页推荐personalize-信息流广告位", s);
            return s;
        }
        return (String) invokeV.objValue;
    }

    public static String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            String s = b55.m().s("key_server_pb_banner_bear_sid", "");
            if (StringUtils.isNull(s)) {
                s = "6051001308-627527144";
            }
            A("pb-banner广告位", s);
            return s;
        }
        return (String) invokeV.objValue;
    }

    public static String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            String s = b55.m().s("key_server_picpage_bear_sid", "");
            if (StringUtils.isNull(s)) {
                s = "6051001643-679358748";
            }
            A("贴吧大图页广告位", s);
            return s;
        }
        return (String) invokeV.objValue;
    }

    public static String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            String s = b55.m().s("key_server_videoflow_bear_sid", "");
            if (StringUtils.isNull(s)) {
                s = "6061002410-390177882";
            }
            A("沉浸态", s);
            return s;
        }
        return (String) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return x75.g();
        }
        return invokeV.intValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return x75.h();
        }
        return invokeV.intValue;
    }

    public static void A(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (TbadkCoreApplication.getInst().isDebugMode() || zw4.h()) {
                PrintStream printStream = System.out;
                printStream.println("FunAdSdk，" + str + "， sid is: " + str2);
            }
        }
    }

    public void x(Activity activity, String str, h hVar, g gVar) {
        f fVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048599, this, activity, str, hVar, gVar) == null) && (fVar = this.a) != null) {
            fVar.b(activity, str, 1, hVar, gVar);
        }
    }

    public static g b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            g gVar = new g();
            gVar.a = str;
            gVar.b = str2;
            return gVar;
        }
        return (g) invokeLL.objValue;
    }

    public void B(ImageView imageView, Object obj) {
        f fVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, imageView, obj) != null) || (fVar = this.a) == null) {
            return;
        }
        fVar.c(imageView, obj);
    }

    public void C(Object obj, j jVar) {
        f fVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, jVar) != null) || (fVar = this.a) == null) {
            return;
        }
        fVar.j(obj, jVar);
    }

    public Object n(@NonNull Activity activity, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, activity, str)) == null) {
            f fVar = this.a;
            if (fVar != null) {
                return fVar.i(activity, str);
            }
            return null;
        }
        return invokeLL.objValue;
    }

    public static a97 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (b == null) {
                synchronized (a97.class) {
                    if (b == null) {
                        b = new a97();
                    }
                }
            }
            if (b.a == null && PermissionUtil.isAgreePrivacyPolicy()) {
                b = new a97();
            }
            return b;
        }
        return (a97) invokeV.objValue;
    }

    public static String p() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (!b55.m().i("key_splash_shake_ad_open", true)) {
                str = "6021005334-1052188080";
            } else {
                str = null;
            }
            if (StringUtils.isNull(str)) {
                str = b55.m().s("key_server_splash_bear_sid", "");
            }
            if (StringUtils.isNull(str)) {
                str = "6021002119-1732188456";
            }
            A("贴吧开屏广告位(先审后播广告)", str);
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static String q() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (!b55.m().i("key_splash_shake_ad_open", true)) {
                str = "6021005321-1773936643";
            } else {
                str = null;
            }
            if (StringUtils.isNull(str)) {
                str = b55.m().s("key_server_splash_bear_sid", "");
            }
            if (StringUtils.isNull(str)) {
                str = "6021002118-283136489";
            }
            A("贴吧开屏广告位(先播后审广告)", str);
            return str;
        }
        return (String) invokeV.objValue;
    }

    public final f k() {
        InterceptResult invokeV;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (!PermissionUtil.isAgreePrivacyPolicy() || !FunSdkInitSwitch.isOn() || (runTask = MessageManager.getInstance().runTask(2921525, f.class)) == null) {
                return null;
            }
            return (f) runTask.getData();
        }
        return (f) invokeV.objValue;
    }

    public boolean D(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            f fVar = this.a;
            if (fVar == null) {
                return false;
            }
            return fVar.h(obj);
        }
        return invokeL.booleanValue;
    }

    public le9 I(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            f fVar = this.a;
            if (fVar == null) {
                return null;
            }
            return fVar.o(obj);
        }
        return (le9) invokeL.objValue;
    }

    public void c(String str) {
        f fVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, str) == null) && (fVar = this.a) != null) {
            fVar.a(str);
        }
    }

    public void d(String str) {
        f fVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, str) == null) && (fVar = this.a) != null) {
            fVar.destroyAd(str);
        }
    }

    public List<z87> j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            f fVar = this.a;
            if (fVar != null) {
                return fVar.l(str);
            }
            return new ArrayList(0);
        }
        return (List) invokeL.objValue;
    }

    public ViewGroup l(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, context)) == null) {
            f fVar = this.a;
            if (fVar != null) {
                return fVar.e(context);
            }
            return null;
        }
        return (ViewGroup) invokeL.objValue;
    }

    public View t(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, obj)) == null) {
            f fVar = this.a;
            if (fVar == null) {
                return null;
            }
            return fVar.f(obj);
        }
        return (View) invokeL.objValue;
    }

    public void u(l lVar) {
        f fVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, lVar) != null) || (fVar = this.a) == null) {
            return;
        }
        fVar.k(TbadkCoreApplication.getInst(), lVar);
    }

    public boolean v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            f fVar = this.a;
            if (fVar != null && fVar.isAdReady(str)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void E(Activity activity, String str, ViewGroup viewGroup, i iVar, g gVar) {
        f fVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLLL(1048579, this, activity, str, viewGroup, iVar, gVar) == null) && (fVar = this.a) != null) {
            fVar.n(activity, str, viewGroup, iVar, gVar);
        }
    }

    public void G(Activity activity, String str, ViewGroup viewGroup, i iVar, g gVar) {
        f fVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLLL(1048581, this, activity, str, viewGroup, iVar, gVar) == null) && (fVar = this.a) != null) {
            fVar.g(activity, str, viewGroup, iVar, gVar);
        }
    }

    public void F(Activity activity, @NonNull Object obj, i iVar, ViewGroup viewGroup, List<View> list, List<View> list2, g gVar, String str) {
        f fVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{activity, obj, iVar, viewGroup, list, list2, gVar, str}) == null) && (fVar = this.a) != null) {
            fVar.m(activity, obj, iVar, viewGroup, list, list2, gVar, str);
        }
    }

    public final void H(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048582, this, i2, str, str2) == null) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_locate", i2).param("tid", "").param("fid", "").param("obj_type", str).param("resource_id", str2));
        }
    }

    public void y(Activity activity, h hVar, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048600, this, activity, hVar, str) != null) || this.a == null) {
            return;
        }
        H(2, str, "");
        f fVar = this.a;
        String s = s();
        d dVar = new d(this, hVar, str);
        if (VideoMiddleAdSwitch.isOn() && UbsABTestHelper.isVideoAdDrawABTestB()) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        fVar.b(activity, s, 1, dVar, b(str, str2));
    }

    public boolean J(Activity activity, String str, g gVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, str, gVar)) == null) {
            if (this.a != null && !TextUtils.isEmpty(str) && gVar != null) {
                boolean isAdReady = this.a.isAdReady(str);
                StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a002").eventStat();
                System.currentTimeMillis();
                FunAdRecordHttpMessage.uploadRequestRecord("a002", null, null, null, null);
                this.a.b(activity, str, 1, new a(this), gVar);
                return isAdReady;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public void z(Activity activity, h hVar, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048601, this, activity, hVar, str) != null) || this.a == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_locate", 2).param("tid", "").param("fid", "").param("obj_type", str));
        f fVar = this.a;
        c cVar = new c(this, hVar, str);
        if (VideoMiddleAdSwitch.isOn()) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        fVar.b(activity, "6061002332-203360688", 1, cVar, b(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_MIDDLE, str2));
    }

    public boolean K(Activity activity, String str, g gVar, String str2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{activity, str, gVar, str2, Integer.valueOf(i2)})) == null) {
            if (this.a != null && !TextUtils.isEmpty(str) && gVar != null) {
                boolean isAdReady = this.a.isAdReady(str);
                StatisticItem.make(TbadkCoreStatisticKey.REQUEST_AD_TIME).param("obj_source", 6).param("fid", str2).param(TiebaStatic.Params.OBJ_PARAM2, i2).param("obj_type", "a006").param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param("fid", c97.c("a006")).eventStat();
                FunAdRecordHttpMessage.uploadRequestRecord("a006", null, null, str2, null);
                this.a.b(activity, str, i2, new b(this, str2), gVar);
                return isAdReady;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public boolean L(Activity activity, String str, g gVar, String str2, String str3) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048586, this, activity, str, gVar, str2, str3)) == null) {
            if (this.a != null && !TextUtils.isEmpty(str) && gVar != null) {
                boolean isAdReady = this.a.isAdReady(str);
                FunAdRecordHttpMessage.uploadRequestRecord("a005", null, str2, str3, null);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("tid", str2).param("fid", str3).param("obj_type", "a005").param("obj_param1", "2"));
                this.a.b(activity, str, 1, new e(this, str2, str3), gVar);
                return isAdReady;
            }
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    public void w(Context context, String str, int i2, h hVar, g gVar) {
        f fVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{context, str, Integer.valueOf(i2), hVar, gVar}) == null) && (fVar = this.a) != null) {
            fVar.d(context, str, 1, i2, hVar, gVar);
        }
    }
}
