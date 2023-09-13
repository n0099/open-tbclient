package com.baidu.tbadk.tracker;

import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\u0010\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0000J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/baidu/tbadk/tracker/PvData;", "", "page", "", "source", "pv", "", "pv_lost", "(Ljava/lang/String;Ljava/lang/String;II)V", "getPage", "()Ljava/lang/String;", "getPv", "()I", "setPv", "(I)V", "getPv_lost", "setPv_lost", "getSource", "component1", "component2", "component3", "component4", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", TTDownloadField.TT_HASHCODE, "merge", "", "data", "toString", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PvData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String page;
    public int pv;
    public int pv_lost;
    public final String source;

    public static /* synthetic */ PvData copy$default(PvData pvData, String str, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = pvData.page;
        }
        if ((i3 & 2) != 0) {
            str2 = pvData.source;
        }
        if ((i3 & 4) != 0) {
            i = pvData.pv;
        }
        if ((i3 & 8) != 0) {
            i2 = pvData.pv_lost;
        }
        return pvData.copy(str, str2, i, i2);
    }

    public final String component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.page : (String) invokeV.objValue;
    }

    public final String component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.source : (String) invokeV.objValue;
    }

    public final int component3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.pv : invokeV.intValue;
    }

    public final int component4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.pv_lost : invokeV.intValue;
    }

    public final PvData copy(String page, String source, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048580, this, page, source, i, i2)) == null) {
            Intrinsics.checkNotNullParameter(page, "page");
            Intrinsics.checkNotNullParameter(source, "source");
            return new PvData(page, source, i, i2);
        }
        return (PvData) invokeLLII.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PvData) {
                PvData pvData = (PvData) obj;
                return Intrinsics.areEqual(this.page, pvData.page) && Intrinsics.areEqual(this.source, pvData.source) && this.pv == pvData.pv && this.pv_lost == pvData.pv_lost;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (((((this.page.hashCode() * 31) + this.source.hashCode()) * 31) + this.pv) * 31) + this.pv_lost : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return "PvData(page=" + this.page + ", source=" + this.source + ", pv=" + this.pv + ", pv_lost=" + this.pv_lost + ')';
        }
        return (String) invokeV.objValue;
    }

    public PvData(String page, String source, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {page, source, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(source, "source");
        this.page = page;
        this.source = source;
        this.pv = i;
        this.pv_lost = i2;
    }

    public final String getPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.page;
        }
        return (String) invokeV.objValue;
    }

    public final int getPv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.pv;
        }
        return invokeV.intValue;
    }

    public final int getPv_lost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.pv_lost;
        }
        return invokeV.intValue;
    }

    public final String getSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.source;
        }
        return (String) invokeV.objValue;
    }

    public final void merge(PvData pvData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, pvData) == null) && pvData != null) {
            this.pv += pvData.pv;
            this.pv_lost += pvData.pv_lost;
        }
    }

    public final void setPv(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.pv = i;
        }
    }

    public final void setPv_lost(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.pv_lost = i;
        }
    }
}
