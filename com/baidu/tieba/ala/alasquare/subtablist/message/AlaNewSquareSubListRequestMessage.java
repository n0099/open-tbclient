package com.baidu.tieba.ala.alasquare.subtablist.message;

import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.j;
import c.a.d.f.p.l;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class AlaNewSquareSubListRequestMessage extends HttpMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String entryName;
    public String lableName;
    public String lat;
    public String lng;
    public int pn;
    public int ps;
    public int refreshCount;
    public int refreshType;
    public long sessionId;
    public String sortType;
    public int tabId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaNewSquareSubListRequestMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_NEW_SQUARE_SUB_LIST);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
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
    }

    public int getPn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.pn : invokeV.intValue;
    }

    public void setEntryName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.entryName = str;
        }
    }

    public void setHttpParams() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int k2 = l.k(TbadkCoreApplication.getInst());
            int i2 = l.i(TbadkCoreApplication.getInst());
            float h2 = l.h(TbadkCoreApplication.getInst());
            addParam("entry_name", this.entryName);
            addParam("pn", this.pn);
            addParam("ps", this.ps);
            addParam("scr_w", k2);
            addParam("scr_h", i2);
            addParam("q_type", 0);
            addParam("scr_dip", String.valueOf(h2));
            addParam("label_name", this.lableName);
            addParam("sort_type", this.sortType);
            addParam(SuggestAddrField.KEY_LAT, this.lat);
            addParam(SuggestAddrField.KEY_LNG, this.lng);
            String str = "N";
            if (j.z()) {
                if (j.H()) {
                    str = "1_0";
                } else if (j.v()) {
                    str = "0_13";
                } else if (j.u()) {
                    str = "0_3";
                } else if (j.t()) {
                    str = "0_2";
                }
            }
            addParam("network", str);
            addParam("ua_str", k2 + "_" + i2 + "_android_" + TbConfig.getVersion());
            addParam("tab_id", this.tabId);
            addParam("refresh_type", this.refreshType);
            addParam("session_id", this.sessionId);
            addParam("big_refresh_count", this.refreshCount);
        }
    }

    public void setLableName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.lableName = str;
        }
    }

    public void setLat(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.lat = str;
        }
    }

    public void setLng(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.lng = str;
        }
    }

    public void setPn(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.pn = i2;
        }
    }

    public void setPs(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.ps = i2;
        }
    }

    public void setSortType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.sortType = str;
        }
    }
}
