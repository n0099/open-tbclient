package com.baidu.tieba;

import android.content.res.Resources;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.ApkDetail;
import tbclient.ItemInfo;
/* loaded from: classes3.dex */
public class cr6 extends rr4 {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId b;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<hr6> a;

    @Override // com.baidu.tieba.rr4
    public ot4 getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (ot4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rr4
    public ThreadData getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (ThreadData) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947684418, "Lcom/baidu/tieba/cr6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947684418, "Lcom/baidu/tieba/cr6;");
                return;
            }
        }
        b = BdUniqueId.gen();
    }

    public cr6() {
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
        setSupportType(BaseCardInfo.SupportType.FULL);
    }

    public ArrayList<hr6> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return !ListUtils.isEmpty(this.a);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.tieba.wn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return b;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public void h(ItemInfo itemInfo) {
        ApkDetail apkDetail;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, itemInfo) == null) {
            if (this.a == null) {
                this.a = new ArrayList<>();
            }
            this.a.clear();
            if (itemInfo != null && (apkDetail = itemInfo.apk_detail) != null) {
                if (!wi.isEmpty(apkDetail.developer)) {
                    this.a.add(new hr6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f04f6), itemInfo.apk_detail.developer, null));
                }
                if (!wi.isEmpty(itemInfo.apk_detail.publisher)) {
                    this.a.add(new hr6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0f88), itemInfo.apk_detail.publisher, null));
                }
                if (!wi.isEmpty(itemInfo.apk_detail.version)) {
                    this.a.add(new hr6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f048f), itemInfo.apk_detail.version, null));
                }
                if (!wi.isEmpty(itemInfo.apk_detail.update_time)) {
                    this.a.add(new hr6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1522), itemInfo.apk_detail.update_time, null));
                }
                if (wg.g(itemInfo.apk_detail.size, 0L) > 0) {
                    this.a.add(new hr6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0634), StringHelper.getFormatSize(wg.g(itemInfo.apk_detail.size, 0L)), null));
                }
                int intValue = itemInfo.apk_detail.need_network.intValue();
                int i2 = R.string.obfuscated_res_0x7f0f0549;
                if (intValue > 0) {
                    ArrayList<hr6> arrayList = this.a;
                    String string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09ae);
                    Resources resources = TbadkCoreApplication.getInst().getResources();
                    if (itemInfo.apk_detail.need_network.intValue() == 1) {
                        i = R.string.obfuscated_res_0x7f0f0549;
                    } else {
                        i = R.string.obfuscated_res_0x7f0f0548;
                    }
                    arrayList.add(new hr6(string, resources.getString(i), null));
                }
                if (itemInfo.apk_detail.need_inner_buy.intValue() > 0) {
                    ArrayList<hr6> arrayList2 = this.a;
                    String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0857);
                    Resources resources2 = TbadkCoreApplication.getInst().getResources();
                    if (itemInfo.apk_detail.need_inner_buy.intValue() != 1) {
                        i2 = R.string.obfuscated_res_0x7f0f0548;
                    }
                    arrayList2.add(new hr6(string2, resources2.getString(i2), null));
                }
                if (!wi.isEmpty(itemInfo.apk_detail.authority_url)) {
                    this.a.add(new hr6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e53), TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09b1), itemInfo.apk_detail.authority_url));
                }
                if (!wi.isEmpty(itemInfo.apk_detail.privacy_url)) {
                    this.a.add(new hr6(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0f42), TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09b1), itemInfo.apk_detail.privacy_url));
                }
            }
        }
    }
}
