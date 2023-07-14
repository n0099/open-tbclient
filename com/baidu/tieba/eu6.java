package com.baidu.tieba;

import android.location.Location;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.yt6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class eu6 implements yt6.a {
    public static /* synthetic */ Interceptable $ic;
    public static eu6 j;
    public transient /* synthetic */ FieldHolder $fh;
    public yt6 a;
    public yt6 b;
    public ArrayList<TransmitForumData> c;
    public ArrayList<TransmitForumData> d;
    public boolean e;
    public ArrayList<TransmitForumData> f;
    public boolean g;
    public int h;
    public boolean i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947746883, "Lcom/baidu/tieba/eu6;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947746883, "Lcom/baidu/tieba/eu6;");
        }
    }

    public static Location b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return null;
        }
        return (Location) invokeV.objValue;
    }

    public eu6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new ArrayList<>();
        this.e = false;
        this.g = false;
        this.i = false;
        e();
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016562), yt6.class);
            if (runTask != null) {
                this.b = (yt6) runTask.getData();
            }
            yt6 yt6Var = this.b;
            if (yt6Var != null) {
                yt6Var.a(this);
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001449), yt6.class);
            if (runTask != null) {
                this.a = (yt6) runTask.getData();
            }
            yt6 yt6Var = this.a;
            if (yt6Var != null) {
                yt6Var.a(this);
            }
        }
    }

    public static eu6 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (j == null) {
                synchronized (eu6.class) {
                    if (j == null) {
                        j = new eu6();
                    }
                }
            }
            return j;
        }
        return (eu6) invokeV.objValue;
    }

    public final Location d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return b();
        }
        return (Location) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            g();
            f();
            this.i = false;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.i = true;
            yt6 yt6Var = this.a;
            if (yt6Var != null) {
                yt6Var.b();
            }
            yt6 yt6Var2 = this.b;
            if (yt6Var2 != null) {
                yt6Var2.b();
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016563, this.c));
        }
    }

    @Override // com.baidu.tieba.yt6.a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{arrayList, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            if (i == 1) {
                if (z) {
                    this.f = arrayList;
                }
                this.g = true;
            } else if (i == 2) {
                if (z) {
                    this.d = arrayList;
                    this.h = i2;
                }
                this.e = true;
            }
            j();
        }
    }

    public final boolean h(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
            ArrayList<TransmitForumData> arrayList = this.c;
            if (arrayList == null) {
                return false;
            }
            Iterator<TransmitForumData> it = arrayList.iterator();
            while (it.hasNext()) {
                TransmitForumData next = it.next();
                if (next != null && next.forumId == j2) {
                    return true;
                }
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.a == null || this.e) {
                if (this.b == null || this.g) {
                    this.e = false;
                    this.g = false;
                    this.i = false;
                    this.c.clear();
                    if (!ListUtils.isEmpty(this.d)) {
                        Iterator<TransmitForumData> it = this.d.iterator();
                        while (it.hasNext()) {
                            TransmitForumData next = it.next();
                            if (!h(next.forumId)) {
                                this.c.add(next);
                            }
                        }
                    }
                    if (!ListUtils.isEmpty(this.f)) {
                        Iterator<TransmitForumData> it2 = this.f.iterator();
                        while (it2.hasNext()) {
                            TransmitForumData next2 = it2.next();
                            if (!h(next2.forumId)) {
                                this.c.add(next2);
                            }
                        }
                    }
                    this.d = null;
                    this.f = null;
                    k();
                }
            }
        }
    }

    public void l(ShareDialogConfig shareDialogConfig) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, shareDialogConfig) != null) || shareDialogConfig == null || shareDialogConfig.shareItem == null || vx5.a()) {
            return;
        }
        if (shareDialogConfig.showLocation) {
            shareDialogConfig.shareItem.F = d();
        }
        if (yi.G() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.i && shareDialogConfig.shareItem.l()) {
            i();
        }
        shareDialogConfig.setIsShowTransmitShare(true);
        shareDialogConfig.setTransmitForumList(this.c);
        shareDialogConfig.setPrivateThread(this.h);
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }
}
