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
import com.baidu.tieba.a46;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class f46 implements a46.a {
    public static /* synthetic */ Interceptable $ic;
    public static f46 j;
    public transient /* synthetic */ FieldHolder $fh;
    public a46 a;
    public a46 b;
    public ArrayList c;
    public ArrayList d;
    public boolean e;
    public ArrayList f;
    public boolean g;
    public int h;
    public boolean i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947714209, "Lcom/baidu/tieba/f46;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947714209, "Lcom/baidu/tieba/f46;");
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

    public f46() {
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
        this.c = new ArrayList();
        this.e = false;
        this.g = false;
        this.i = false;
        e();
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage(2016562), a46.class);
            if (runTask != null) {
                this.b = (a46) runTask.getData();
            }
            a46 a46Var = this.b;
            if (a46Var != null) {
                a46Var.a(this);
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage(2001449), a46.class);
            if (runTask != null) {
                this.a = (a46) runTask.getData();
            }
            a46 a46Var = this.a;
            if (a46Var != null) {
                a46Var.a(this);
            }
        }
    }

    public static f46 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (j == null) {
                synchronized (f46.class) {
                    if (j == null) {
                        j = new f46();
                    }
                }
            }
            return j;
        }
        return (f46) invokeV.objValue;
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
            a46 a46Var = this.a;
            if (a46Var != null) {
                a46Var.b();
            }
            a46 a46Var2 = this.b;
            if (a46Var2 != null) {
                a46Var2.b();
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016563, this.c));
        }
    }

    @Override // com.baidu.tieba.a46.a
    public void a(ArrayList arrayList, boolean z, int i, int i2) {
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
            ArrayList arrayList = this.c;
            if (arrayList == null) {
                return false;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                TransmitForumData transmitForumData = (TransmitForumData) it.next();
                if (transmitForumData != null && transmitForumData.forumId == j2) {
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
                        Iterator it = this.d.iterator();
                        while (it.hasNext()) {
                            TransmitForumData transmitForumData = (TransmitForumData) it.next();
                            if (!h(transmitForumData.forumId)) {
                                this.c.add(transmitForumData);
                            }
                        }
                    }
                    if (!ListUtils.isEmpty(this.f)) {
                        Iterator it2 = this.f.iterator();
                        while (it2.hasNext()) {
                            TransmitForumData transmitForumData2 = (TransmitForumData) it2.next();
                            if (!h(transmitForumData2.forumId)) {
                                this.c.add(transmitForumData2);
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
        if ((interceptable != null && interceptable.invokeL(1048585, this, shareDialogConfig) != null) || shareDialogConfig == null || shareDialogConfig.shareItem == null || lh5.a()) {
            return;
        }
        if (shareDialogConfig.showLocation) {
            shareDialogConfig.shareItem.F = d();
        }
        if (fj.D() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.i && !shareDialogConfig.shareItem.f()) {
            i();
        }
        shareDialogConfig.setIsShowTransmitShare(true);
        shareDialogConfig.setTransmitForumList(this.c);
        shareDialogConfig.setPrivateThread(this.h);
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }
}
