package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import tbclient.ReplyMe.DataReq;
import tbclient.ReplyMe.ReplyMeReqIdl;
/* loaded from: classes4.dex */
public class fg7 implements ad5, xc5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public String c;

    @Override // com.baidu.tieba.wc5
    public String getCacheKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "replyme_cache" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xc5
    public boolean isNeedUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.xc5
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.zc5
    public HashMap<String, String> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xc5
    public String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? "tb_user_replyme" : (String) invokeV.objValue;
    }

    public fg7() {
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
        this.b = 1;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b = 1;
            this.a = 1;
            this.c = null;
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b++;
            this.a = 4;
        }
    }

    public void c(FeedData feedData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, feedData) != null) || feedData == null) {
            return;
        }
        this.c = String.format("%s,%s", feedData.getThread_id(), feedData.getPost_id());
    }

    @Override // com.baidu.tieba.cd5
    public Object g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            try {
                DataReq.Builder builder = new DataReq.Builder();
                builder.pn = Integer.valueOf(this.b);
                builder.ids = this.c;
                builder.q_type = Integer.valueOf(br4.c().e());
                builder.scr_dip = Double.valueOf(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
                builder.scr_h = Integer.valueOf(yi.j(TbadkCoreApplication.getInst().getApp()));
                builder.scr_w = Integer.valueOf(yi.l(TbadkCoreApplication.getInst().getApp()));
                if (z || SocketAddCommonParamSwitch.getIsOn()) {
                    cj5.a(builder, true);
                }
                ReplyMeReqIdl.Builder builder2 = new ReplyMeReqIdl.Builder();
                builder2.data = builder.build(false);
                return builder2.build(false);
            } catch (Exception unused) {
                return null;
            }
        }
        return invokeZ.objValue;
    }

    @Override // com.baidu.tieba.zc5
    public HashMap<String, Object> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            hashMap.put("pn", String.valueOf(this.b));
            hashMap.put("q_type", Integer.valueOf(br4.c().e()));
            hashMap.put("scr_dip", Double.valueOf(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density));
            hashMap.put("scr_h", Integer.valueOf(yi.j(TbadkCoreApplication.getInst().getApp())));
            hashMap.put("scr_w", Integer.valueOf(yi.l(TbadkCoreApplication.getInst().getApp())));
            if (this.a == 4 && !TextUtils.isEmpty(this.c)) {
                hashMap.put("ids", this.c);
            }
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }
}
