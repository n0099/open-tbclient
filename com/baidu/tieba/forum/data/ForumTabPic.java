package com.baidu.tieba.forum.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
@Parcelize
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006 "}, d2 = {"Lcom/baidu/tieba/forum/data/ForumTabPic;", "Landroid/os/Parcelable;", "selectedPicUrl", "", "unSelectedPicUrl", "picHeight", "", "picWidth", "(Ljava/lang/String;Ljava/lang/String;II)V", "getPicHeight", "()I", "getPicWidth", "getSelectedPicUrl", "()Ljava/lang/String;", "getUnSelectedPicUrl", "component1", "component2", "component3", "component4", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ForumTabPic implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<ForumTabPic> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public final int picHeight;
    public final int picWidth;
    public final String selectedPicUrl;
    public final String unSelectedPicUrl;

    /* loaded from: classes6.dex */
    public static final class a implements Parcelable.Creator<ForumTabPic> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final ForumTabPic createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new ForumTabPic(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt());
            }
            return (ForumTabPic) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final ForumTabPic[] newArray(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? new ForumTabPic[i] : (ForumTabPic[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1070006318, "Lcom/baidu/tieba/forum/data/ForumTabPic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1070006318, "Lcom/baidu/tieba/forum/data/ForumTabPic;");
                return;
            }
        }
        CREATOR = new a();
    }

    public static /* synthetic */ ForumTabPic copy$default(ForumTabPic forumTabPic, String str, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = forumTabPic.selectedPicUrl;
        }
        if ((i3 & 2) != 0) {
            str2 = forumTabPic.unSelectedPicUrl;
        }
        if ((i3 & 4) != 0) {
            i = forumTabPic.picHeight;
        }
        if ((i3 & 8) != 0) {
            i2 = forumTabPic.picWidth;
        }
        return forumTabPic.copy(str, str2, i, i2);
    }

    public final String component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.selectedPicUrl : (String) invokeV.objValue;
    }

    public final String component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.unSelectedPicUrl : (String) invokeV.objValue;
    }

    public final int component3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.picHeight : invokeV.intValue;
    }

    public final int component4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.picWidth : invokeV.intValue;
    }

    public final ForumTabPic copy(String selectedPicUrl, String unSelectedPicUrl, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048580, this, selectedPicUrl, unSelectedPicUrl, i, i2)) == null) {
            Intrinsics.checkNotNullParameter(selectedPicUrl, "selectedPicUrl");
            Intrinsics.checkNotNullParameter(unSelectedPicUrl, "unSelectedPicUrl");
            return new ForumTabPic(selectedPicUrl, unSelectedPicUrl, i, i2);
        }
        return (ForumTabPic) invokeLLII.objValue;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ForumTabPic) {
                ForumTabPic forumTabPic = (ForumTabPic) obj;
                return Intrinsics.areEqual(this.selectedPicUrl, forumTabPic.selectedPicUrl) && Intrinsics.areEqual(this.unSelectedPicUrl, forumTabPic.unSelectedPicUrl) && this.picHeight == forumTabPic.picHeight && this.picWidth == forumTabPic.picWidth;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? (((((this.selectedPicUrl.hashCode() * 31) + this.unSelectedPicUrl.hashCode()) * 31) + this.picHeight) * 31) + this.picWidth : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return "ForumTabPic(selectedPicUrl=" + this.selectedPicUrl + ", unSelectedPicUrl=" + this.unSelectedPicUrl + ", picHeight=" + this.picHeight + ", picWidth=" + this.picWidth + ')';
        }
        return (String) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, out, i) == null) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeString(this.selectedPicUrl);
            out.writeString(this.unSelectedPicUrl);
            out.writeInt(this.picHeight);
            out.writeInt(this.picWidth);
        }
    }

    public ForumTabPic(String selectedPicUrl, String unSelectedPicUrl, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {selectedPicUrl, unSelectedPicUrl, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(selectedPicUrl, "selectedPicUrl");
        Intrinsics.checkNotNullParameter(unSelectedPicUrl, "unSelectedPicUrl");
        this.selectedPicUrl = selectedPicUrl;
        this.unSelectedPicUrl = unSelectedPicUrl;
        this.picHeight = i;
        this.picWidth = i2;
    }

    public final int getPicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.picHeight;
        }
        return invokeV.intValue;
    }

    public final int getPicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.picWidth;
        }
        return invokeV.intValue;
    }

    public final String getSelectedPicUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.selectedPicUrl;
        }
        return (String) invokeV.objValue;
    }

    public final String getUnSelectedPicUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.unSelectedPicUrl;
        }
        return (String) invokeV.objValue;
    }
}
