package com.baidu.tieba.forum.hybrid.manager;

import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.fh7;
import com.baidu.tieba.gu4;
import com.baidu.tieba.ti7;
import com.baidu.tieba.ui7;
import com.baidu.tieba.vi7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\rH\u0002J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\rH\u0002J\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\bJ\u0006\u0010\u0017\u001a\u00020\tJ\u0006\u0010\u0018\u001a\u00020\tJ\u0006\u0010\u0019\u001a\u00020\tJ\u000e\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\rR\u009b\u0001\u0010\u0003\u001a\u008e\u0001\u0012\u0004\u0012\u00020\u0005\u0012<\u0012:\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t0\u00070\u0006j\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t0\u0007`\n0\u0004jF\u0012\u0004\u0012\u00020\u0005\u0012<\u0012:\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t0\u00070\u0006j\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t0\u0007`\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0006j\b\u0012\u0004\u0012\u00020\r`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/baidu/tieba/forum/hybrid/manager/InteractLayer;", "", "()V", "activityRequestHandlers", "Ljava/util/HashMap;", "", "Ljava/util/ArrayList;", "Lkotlin/Function2;", "Landroid/content/Intent;", "", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "allBiz", "Lcom/baidu/tieba/forum/hybrid/manager/Biz;", "hybridListeners", "", "Lcom/baidu/tbadk/browser/utils/HybridNotifyManager$HybridNotifyListener;", "addActivityResultHandler", "biz", "addHybridKeyListener", "onActivityResultOK", "requestCode", "data", MissionEvent.MESSAGE_DESTROY, MissionEvent.MESSAGE_PAUSE, "onResume", "refreshData", "bottomData", "Lcom/baidu/tieba/forum/data/BottomData;", "register", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class InteractLayer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<gu4.d> a;
    public final ArrayList<ui7> b;
    public final HashMap<Integer, ArrayList<Function2<Integer, Intent, Unit>>> c;

    public InteractLayer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.b = new ArrayList<>();
        this.c = new HashMap<>();
    }

    public final void a(ui7 ui7Var) {
        ti7[] b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, ui7Var) == null) && (b = ui7Var.b()) != null) {
            for (ti7 ti7Var : b) {
                for (Integer num : ti7Var.b()) {
                    int intValue = num.intValue();
                    ArrayList<Function2<Integer, Intent, Unit>> arrayList = this.c.get(Integer.valueOf(intValue));
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    } else {
                        Intrinsics.checkNotNullExpressionValue(arrayList, "activityRequestHandlers[code] ?: ArrayList()");
                    }
                    arrayList.add(new InteractLayer$addActivityResultHandler$1$1(ti7Var));
                    this.c.put(Integer.valueOf(intValue), arrayList);
                }
            }
        }
    }

    public final void b(ui7 ui7Var) {
        WrapListener[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ui7Var) == null) && (a = ui7Var.a()) != null) {
            for (WrapListener wrapListener : a) {
                this.a.add(wrapListener);
                gu4.b.a().c(wrapListener);
            }
        }
    }

    public final void f(ui7 biz) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, biz) == null) {
            Intrinsics.checkNotNullParameter(biz, "biz");
            this.b.add(biz);
            b(biz);
            a(biz);
        }
    }

    public final void c(int i, Intent intent) {
        ArrayList<Function2<Integer, Intent, Unit>> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, intent) == null) && (arrayList = this.c.get(Integer.valueOf(i))) != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                ((Function2) it.next()).invoke(Integer.valueOf(i), intent);
            }
        }
    }

    public final void d() {
        vi7 vi7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Iterator<gu4.d> it = this.a.iterator();
            while (true) {
                vi7 vi7Var2 = null;
                if (!it.hasNext()) {
                    break;
                }
                gu4.d next = it.next();
                gu4.b.a().e(next);
                if (next instanceof vi7) {
                    vi7Var2 = (vi7) next;
                }
                if (vi7Var2 != null) {
                    vi7Var2.onDestroy();
                }
            }
            this.a.clear();
            Iterator<ui7> it2 = this.b.iterator();
            while (it2.hasNext()) {
                ui7 next2 = it2.next();
                if (next2 instanceof vi7) {
                    vi7Var = (vi7) next2;
                } else {
                    vi7Var = null;
                }
                if (vi7Var != null) {
                    vi7Var.onDestroy();
                }
            }
            this.b.clear();
        }
    }

    public final void e(fh7 bottomData) {
        BizBase bizBase;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bottomData) == null) {
            Intrinsics.checkNotNullParameter(bottomData, "bottomData");
            Iterator<ui7> it = this.b.iterator();
            while (it.hasNext()) {
                ui7 next = it.next();
                boolean z = next instanceof BizBase;
                BizBase bizBase2 = null;
                if (z) {
                    bizBase = (BizBase) next;
                } else {
                    bizBase = null;
                }
                if (bizBase != null) {
                    bizBase.j(bottomData);
                }
                if (z) {
                    bizBase2 = (BizBase) next;
                }
                if (bizBase2 != null) {
                    bizBase2.i();
                }
            }
        }
    }
}
