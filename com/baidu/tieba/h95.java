package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.data.HotEventData;
import com.baidu.tbadk.mutiprocess.hotevent.HotEvent;
import com.baidu.tieba.e85;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Collections;
/* loaded from: classes4.dex */
public class h95 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static WeakReference<e85> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public interface d {
        void onDismiss();
    }

    /* loaded from: classes4.dex */
    public static class a implements e85.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // com.baidu.tieba.e85.j
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = h95.a = false;
                d dVar = this.a;
                if (dVar != null) {
                    dVar.onDismiss();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements e85.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotEventData a;

        public b(HotEventData hotEventData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotEventData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotEventData;
        }

        @Override // com.baidu.tieba.e85.h
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                UrlManager.getInstance().dealOneLink(TbadkApplication.getInst().getCurrentPageContext(TbadkApplication.getInst().getCurrentActivity()), new String[]{this.a.getBtnSchema()});
                h95.f();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements e85.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotEventData a;

        public c(HotEventData hotEventData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotEventData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotEventData;
        }

        @Override // com.baidu.tieba.e85.i
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                UrlManager.getInstance().dealOneLink(TbadkApplication.getInst().getCurrentPageContext(TbadkApplication.getInst().getCurrentActivity()), new String[]{this.a.getBtnSchema()});
                h95.f();
            }
        }
    }

    public static void i(HotEventData hotEventData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, hotEventData) == null) {
            c(hotEventData);
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity == null) {
                return;
            }
            q05.g(Collections.singletonList(new r05(currentActivity, hotEventData)));
        }
    }

    public static e85 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            WeakReference<e85> weakReference = b;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }
        return (e85) invokeV.objValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return a;
        }
        return invokeV.booleanValue;
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOT_EVENT_CLICK));
        }
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOT_EVENT_SHOW));
        }
    }

    public static void c(HotEventData hotEventData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, hotEventData) == null) {
            Context curGlobalActivity = TbadkCoreApplication.getInst().getCurGlobalActivity();
            if (curGlobalActivity != null && !(curGlobalActivity instanceof TbPageContextSupport)) {
                return;
            }
            if (curGlobalActivity == null) {
                curGlobalActivity = TbadkCoreApplication.getInst();
            }
            if (hotEventData != null && hotEventData.getWindowType() == 3) {
                h39.a(curGlobalActivity, new String[]{hotEventData.getSchemaUrl()});
            }
        }
    }

    public static e85 h(HotEventData hotEventData, d dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, hotEventData, dVar)) == null) {
            if (!TextUtils.isEmpty(hotEventData.getBtnSchema()) && !TextUtils.isEmpty(hotEventData.getTitle())) {
                if (hotEventData.getWindowType() != 1 && hotEventData.getWindowType() != 2) {
                    if (dVar != null) {
                        dVar.onDismiss();
                    }
                    return null;
                }
                Activity currentActivity = TbadkApplication.getInst().getCurrentActivity();
                if (TbadkCoreApplication.getInst().isMainProcess(true) && currentActivity == null) {
                    HotEvent hotEvent = new HotEvent();
                    hotEvent.hotEventData = hotEventData;
                    hotEventData.setSkinType(TbadkCoreApplication.getInst().getSkinType());
                    vh5.i(hotEvent);
                    if (dVar != null) {
                        dVar.onDismiss();
                    }
                    return null;
                }
                if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
                    TbadkCoreApplication.getInst().setSkinType(hotEventData.getSkinType());
                }
                if (a) {
                    if (dVar != null) {
                        dVar.onDismiss();
                    }
                    return null;
                }
                if (hotEventData.getWindowType() == 1) {
                    if (System.currentTimeMillis() - m35.m().o("key_hot_event_tip_show_time", 0L) <= 600000) {
                        if (dVar != null) {
                            dVar.onDismiss();
                        }
                        return null;
                    }
                }
                if (g85.c() && g85.b() != null) {
                    g85.b().t();
                }
                if (TextUtils.isEmpty(hotEventData.getDesc())) {
                    hotEventData.setDesc(TbadkApplication.getInst().getString(R.string.hot_event_desc_text));
                }
                if (TextUtils.isEmpty(hotEventData.getBtnText())) {
                    hotEventData.setBtnText(TbadkApplication.getInst().getString(R.string.hot_event_btn_text));
                } else {
                    String btnText = hotEventData.getBtnText();
                    if (StringHelper.getChineseAndEnglishLength(btnText) > 8) {
                        hotEventData.setBtnText(StringHelper.cutChineseAndEnglishWithEmoji(btnText, 8, null));
                    }
                }
                e85.g gVar = new e85.g(currentActivity);
                gVar.m(hotEventData.getBtnText());
                gVar.u(hotEventData.getTitle());
                gVar.o(hotEventData.getDesc());
                gVar.q(hotEventData.getIcon());
                gVar.n(R.drawable.hot_event_icon);
                gVar.p(5000);
                gVar.s(new c(hotEventData));
                gVar.r(new b(hotEventData));
                gVar.t(new a(dVar));
                e85 l = gVar.l();
                l.p();
                b = new WeakReference<>(l);
                g();
                if (hotEventData.getWindowType() == 1) {
                    m35.m().A("key_hot_event_tip_show_time", System.currentTimeMillis());
                }
                a = true;
                return l;
            }
            if (dVar != null) {
                dVar.onDismiss();
            }
            return null;
        }
        return (e85) invokeLL.objValue;
    }
}
