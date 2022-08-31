package com.baidu.tieba;

import android.content.Intent;
import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.itemcard.download.ItemDownloadExtraData;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class dw4 {
    public static /* synthetic */ Interceptable $ic;
    public static dw4 d;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, DownloadData> a;
    public final HashMap<String, DownloadData> b;
    public final HashMap<String, String> c;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dw4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(dw4 dw4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dw4Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dw4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage)) {
                List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                if (ListUtils.isEmpty(data)) {
                    return;
                }
                for (DownloadData downloadData : data) {
                    if (downloadData != null && (downloadData.getExtra() instanceof ItemDownloadExtraData)) {
                        String str = ((ItemDownloadExtraData) downloadData.getExtra()).pkgName;
                        int status = downloadData.getStatus();
                        if (status == 0) {
                            if (this.a.a.containsKey(str)) {
                                this.a.b.put(str, this.a.a.get(str));
                                this.a.a.remove(str);
                                cw4.a(downloadData, 700);
                                return;
                            }
                            return;
                        } else if (status != 2) {
                            if (status == 4 && this.a.a.containsKey(str)) {
                                this.a.a.remove(str);
                                cw4.a(downloadData, 400);
                                return;
                            }
                            return;
                        } else {
                            cw4.a(downloadData, 600);
                            return;
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dw4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(dw4 dw4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dw4Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dw4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Intent) {
                    Intent intent = (Intent) data;
                    String g = c65.g(intent);
                    if (PackageChangedReceiver.ACTION_INSTALL.equals(intent.getAction()) || "android.intent.action.PACKAGE_REPLACED".equals(intent.getAction())) {
                        if (this.a.b.containsKey(g)) {
                            cw4.a((DownloadData) this.a.b.get(g), 900);
                            this.a.b.remove(g);
                        }
                    } else if (PackageChangedReceiver.ACTION_UNINSTALL.equals(intent.getAction())) {
                        this.a.l(g);
                    }
                }
            }
        }
    }

    public dw4() {
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
        this.a = new HashMap<>();
        this.b = new HashMap<>();
        this.c = new HashMap<>();
        h();
        i();
    }

    public static dw4 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (d == null) {
                d = new dw4();
            }
            return d;
        }
        return (dw4) invokeV.objValue;
    }

    public void d(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, downloadData) == null) && downloadData != null && (downloadData.getExtra() instanceof ItemDownloadExtraData) && ((ItemDownloadExtraData) downloadData.getExtra()).isShouzhuData()) {
            this.a.put(((ItemDownloadExtraData) downloadData.getExtra()).pkgName, downloadData);
        }
    }

    public void e(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) && downloadData != null && (downloadData.getExtra() instanceof ItemDownloadExtraData) && ((ItemDownloadExtraData) downloadData.getExtra()).isShouzhuData()) {
            this.b.put(((ItemDownloadExtraData) downloadData.getExtra()).pkgName, downloadData);
        }
    }

    public String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (this.c.containsKey(str)) {
                return this.c.get(str);
            }
            String string = TbadkCoreApplication.getInst().getSharedPreferences("shouzhu_app_source_sp", 0).getString(str, "");
            this.c.put(str, string);
            return string;
        }
        return (String) invokeL.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            a aVar = new a(this, 2001118);
            aVar.setPriority(-1);
            MessageManager.getInstance().registerListener(aVar);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            b bVar = new b(this, 2002504);
            bVar.setPriority(-1);
            MessageManager.getInstance().registerListener(bVar);
        }
    }

    public void j(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, downloadData) == null) && downloadData != null && (downloadData.getExtra() instanceof ItemDownloadExtraData) && ((ItemDownloadExtraData) downloadData.getExtra()).isShouzhuData()) {
            this.a.remove(((ItemDownloadExtraData) downloadData.getExtra()).pkgName);
        }
    }

    public void k(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, downloadData) == null) && downloadData != null && (downloadData.getExtra() instanceof ItemDownloadExtraData) && ((ItemDownloadExtraData) downloadData.getExtra()).isShouzhuData()) {
            this.b.remove(((ItemDownloadExtraData) downloadData.getExtra()).pkgName);
        }
    }

    public final void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.c.remove(str);
            SharedPreferences.Editor edit = TbadkCoreApplication.getInst().getSharedPreferences("shouzhu_app_source_sp", 0).edit();
            edit.remove(str);
            edit.commit();
        }
    }

    public void m(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) || StringHelper.equals(this.c.get(str), str2)) {
            return;
        }
        this.c.put(str, str2);
        SharedPreferences.Editor edit = TbadkCoreApplication.getInst().getSharedPreferences("shouzhu_app_source_sp", 0).edit();
        edit.putString(str, str2);
        edit.commit();
    }
}
