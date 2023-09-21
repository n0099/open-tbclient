package com.baidu.tieba;

import android.content.Intent;
import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.safe.BdCloseHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.itemcard.download.ItemDownloadExtraData;
import com.baidu.tbadk.core.view.itemcard.download.ItemFetchUrlHttpMsg;
import com.baidu.tbadk.core.view.itemcard.download.ItemFetchUrlHttpResponsedMsg;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.WebviewHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.File;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
/* loaded from: classes5.dex */
public class bb5 {
    public static /* synthetic */ Interceptable $ic;
    public static bb5 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashSet<String> a;
    public final HashMap<String, String> b;

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bb5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(bb5 bb5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bb5Var, Integer.valueOf(i)};
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
            this.a = bb5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ItemDownloadExtraData itemDownloadExtraData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003508 && (httpResponsedMessage instanceof ItemFetchUrlHttpResponsedMsg) && (httpResponsedMessage.getOrginalMessage() instanceof ItemFetchUrlHttpMsg)) {
                ItemFetchUrlHttpResponsedMsg itemFetchUrlHttpResponsedMsg = (ItemFetchUrlHttpResponsedMsg) httpResponsedMessage;
                DownloadData downloadData = ((ItemFetchUrlHttpMsg) itemFetchUrlHttpResponsedMsg.getOrginalMessage()).getDownloadData();
                String pkgName = ((ItemFetchUrlHttpMsg) itemFetchUrlHttpResponsedMsg.getOrginalMessage()).getPkgName();
                BdUniqueId buttonTag = ((ItemFetchUrlHttpMsg) itemFetchUrlHttpResponsedMsg.getOrginalMessage()).getButtonTag();
                if (downloadData != null) {
                    if (itemFetchUrlHttpResponsedMsg.getError() != 0 || !itemFetchUrlHttpResponsedMsg.isSuccess() || di.isEmpty(itemFetchUrlHttpResponsedMsg.getDownloadUrl())) {
                        this.a.l(pkgName, downloadData.getUrl());
                        if (sn5.m(downloadData)) {
                            cb5.a(downloadData, 300);
                        }
                    } else {
                        downloadData.setUrl(itemFetchUrlHttpResponsedMsg.getDownloadUrl());
                        this.a.l(pkgName, itemFetchUrlHttpResponsedMsg.getDownloadUrl());
                        if (downloadData.getExtra() instanceof ItemDownloadExtraData) {
                            itemDownloadExtraData = (ItemDownloadExtraData) downloadData.getExtra();
                        } else {
                            itemDownloadExtraData = new ItemDownloadExtraData(1);
                            downloadData.setExtra(itemDownloadExtraData);
                        }
                        itemDownloadExtraData.shouzhuSource = itemFetchUrlHttpResponsedMsg.getSource();
                        if (!di.isEmpty(itemFetchUrlHttpResponsedMsg.getAppname())) {
                            itemDownloadExtraData.appName = itemFetchUrlHttpResponsedMsg.getAppname();
                        }
                        db5.f().m(itemDownloadExtraData.pkgName, itemDownloadExtraData.shouzhuSource);
                        if (sn5.m(downloadData)) {
                            cb5.a(downloadData, 300);
                            if (itemFetchUrlHttpResponsedMsg.isBussinessApk() && !di.isEmpty(itemFetchUrlHttpResponsedMsg.getRcvUrl())) {
                                new c().execute(itemFetchUrlHttpResponsedMsg.getRcvUrl());
                            }
                        }
                    }
                    if (downloadData.getExtra() instanceof ItemDownloadExtraData) {
                        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921609, ((ItemDownloadExtraData) downloadData.getExtra()).shouzhuSource);
                        customResponsedMessage.setOrginalMessage(new CustomMessage(2921609, buttonTag));
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    }
                }
                this.a.a.remove(pkgName);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bb5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(bb5 bb5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bb5Var, Integer.valueOf(i)};
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
            this.a = bb5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Intent) {
                    Intent intent = (Intent) data;
                    String g = sn5.g(intent);
                    if (!PackageChangedReceiver.ACTION_INSTALL.equals(intent.getAction()) && !"android.intent.action.PACKAGE_REPLACED".equals(intent.getAction())) {
                        return;
                    }
                    this.a.k(g);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends BdAsyncTask<String, Integer, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Integer doInBackground(String... strArr) {
            InterceptResult invokeL;
            HttpURLConnection httpURLConnection;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                HttpURLConnection httpURLConnection2 = null;
                if (strArr == null || strArr.length == 0) {
                    return null;
                }
                try {
                    httpURLConnection = (HttpURLConnection) new URL(strArr[0]).openConnection();
                    try {
                        try {
                            httpURLConnection.setRequestMethod("GET");
                            httpURLConnection.setConnectTimeout(kb.d().c().b());
                            httpURLConnection.setReadTimeout(kb.d().b().b());
                            httpURLConnection.addRequestProperty("User-Agent", WebviewHelper.getGlobalUserAgent());
                            if (CookieHandler.getDefault() != null && CookieHandler.getDefault().get(URI.create(strArr[0]), new HashMap()) != null && !ListUtils.isEmpty(CookieHandler.getDefault().get(URI.create(strArr[0]), new HashMap()).get("Cookie"))) {
                                str = CookieHandler.getDefault().get(URI.create(strArr[0]), new HashMap()).get("Cookie").get(0);
                            } else {
                                str = null;
                            }
                            StringBuilder sb = new StringBuilder();
                            if (!di.isEmpty(str)) {
                                if (!str.contains("BAIDUCUID")) {
                                    sb.append("BAIDUCUID=");
                                    sb.append(TbadkCoreApplication.getInst().getCuidGalaxy2());
                                    sb.append(ParamableElem.DIVIDE_PARAM);
                                }
                                if (!str.contains("BAIDUID")) {
                                    sb.append("BAIDUID=");
                                    sb.append(BrowserHelper.getBaiduId());
                                    sb.append(ParamableElem.DIVIDE_PARAM);
                                }
                            }
                            httpURLConnection.addRequestProperty("Cookie", sb.toString());
                            httpURLConnection.getResponseCode();
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            BdCloseHelper.close(httpURLConnection);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        httpURLConnection2 = httpURLConnection;
                        BdCloseHelper.close(httpURLConnection2);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    httpURLConnection = null;
                } catch (Throwable th2) {
                    th = th2;
                    BdCloseHelper.close(httpURLConnection2);
                    throw th;
                }
                BdCloseHelper.close(httpURLConnection);
                return null;
            }
            return (Integer) invokeL.objValue;
        }
    }

    public bb5() {
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
        this.a = new HashSet<>();
        this.b = new HashMap<>();
        j();
        h();
        i();
        CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ITEM_FETCH_URL, TbConfig.SERVER_ADDRESS + "c/s/getCommercialPackage");
            tbHttpMessageTask.setResponsedClass(ItemFetchUrlHttpResponsedMsg.class);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            messageManager.registerTask(tbHttpMessageTask);
        }
    }

    public static bb5 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (c == null) {
                c = new bb5();
            }
            return c;
        }
        return (bb5) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().registerListener(new a(this, CmdConfigHttp.CMD_ITEM_FETCH_URL));
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

    public void d(ItemData itemData, DownloadData downloadData, String str, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048576, this, itemData, downloadData, str, bdUniqueId) == null) && downloadData != null && itemData != null && (downloadData.getExtra() instanceof ItemDownloadExtraData)) {
            String g = g(itemData.pkgName);
            if (di.isEmpty(g)) {
                FileHelper.deleteFile(new File(TbadkCoreApplication.getInst().getApp().getCacheDir() + "/" + downloadData.getId() + "_" + downloadData.getName() + ".tmp"));
                e(itemData, downloadData, str, bdUniqueId);
                return;
            }
            downloadData.setUrl(g);
            sn5.m(downloadData);
        }
    }

    public void e(ItemData itemData, DownloadData downloadData, String str, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, itemData, downloadData, str, bdUniqueId) == null) && itemData != null && downloadData != null) {
            if (this.a.contains(itemData.pkgName)) {
                BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), TbadkCoreApplication.getInst().getResources().getString(R.string.item_downloading_tip));
                return;
            }
            this.a.add(itemData.pkgName);
            MessageManager.getInstance().sendMessage(new ItemFetchUrlHttpMsg(downloadData, itemData, str, bdUniqueId));
        }
    }

    public final String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            String str2 = "url_" + str;
            if (this.b.containsKey(str2)) {
                return this.b.get(str2);
            }
            String string = TbadkCoreApplication.getInst().getSharedPreferences("shouzhu_app_source_sp", 0).getString(str2, "");
            this.b.put(str2, string);
            return string;
        }
        return (String) invokeL.objValue;
    }

    public final void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            String str2 = "url_" + str;
            this.b.remove(str2);
            SharedPreferences.Editor edit = TbadkCoreApplication.getInst().getSharedPreferences("shouzhu_app_source_sp", 0).edit();
            edit.remove(str2);
            edit.commit();
        }
    }

    public final void l(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            String str3 = "url_" + str;
            if (StringHelper.equals(this.b.get(str3), str2)) {
                return;
            }
            this.b.put(str3, str2);
            SharedPreferences.Editor edit = TbadkCoreApplication.getInst().getSharedPreferences("shouzhu_app_source_sp", 0).edit();
            edit.putString(str3, str2);
            edit.commit();
        }
    }
}
