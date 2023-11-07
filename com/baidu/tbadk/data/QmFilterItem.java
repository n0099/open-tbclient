package com.baidu.tbadk.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class QmFilterItem extends OrmObject implements Serializable, Parcelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<QmFilterItem> CREATOR;
    public static final String NO_FILTER_ID = "-1";
    public transient /* synthetic */ FieldHolder $fh;
    public String bgurl;
    public String complex;
    public String complexFileUrl;
    public String effect;
    public String fileUrl;
    public String id;
    public boolean isDownLoading;
    public boolean isSelect;
    public String localPath;
    public String name;

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes5.dex */
    public static class a implements Parcelable.Creator<QmFilterItem> {
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
        public QmFilterItem createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) {
                return new QmFilterItem(parcel);
            }
            return (QmFilterItem) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public QmFilterItem[] newArray(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                return new QmFilterItem[i];
            }
            return (QmFilterItem[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-855456974, "Lcom/baidu/tbadk/data/QmFilterItem;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-855456974, "Lcom/baidu/tbadk/data/QmFilterItem;");
                return;
            }
        }
        CREATOR = new a();
    }

    public QmFilterItem() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public QmFilterItem(Parcel parcel) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.id = parcel.readString();
        this.name = parcel.readString();
        this.fileUrl = parcel.readString();
        this.bgurl = parcel.readString();
        this.effect = parcel.readString();
        this.complex = parcel.readString();
        this.complexFileUrl = parcel.readString();
        if (parcel.readByte() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.isSelect = z;
        this.isDownLoading = parcel.readByte() != 0;
        this.localPath = parcel.readString();
    }

    public void parseJson(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        this.id = jSONObject.getString("id");
        this.name = jSONObject.getString("name");
        this.fileUrl = jSONObject.getString("file");
        this.bgurl = jSONObject.getString("bgurl");
        this.effect = jSONObject.getString("effect");
        this.complex = jSONObject.getString("complex");
        this.complexFileUrl = jSONObject.getString("complex_file");
    }

    public void readFromParcel(Parcel parcel) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, parcel) == null) {
            this.id = parcel.readString();
            this.name = parcel.readString();
            this.fileUrl = parcel.readString();
            this.bgurl = parcel.readString();
            this.effect = parcel.readString();
            this.complex = parcel.readString();
            this.complexFileUrl = parcel.readString();
            boolean z2 = true;
            if (parcel.readByte() != 0) {
                z = true;
            } else {
                z = false;
            }
            this.isSelect = z;
            if (parcel.readByte() == 0) {
                z2 = false;
            }
            this.isDownLoading = z2;
            this.localPath = parcel.readString();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, parcel, i) == null) {
            parcel.writeString(this.id);
            parcel.writeString(this.name);
            parcel.writeString(this.fileUrl);
            parcel.writeString(this.bgurl);
            parcel.writeString(this.effect);
            parcel.writeString(this.complex);
            parcel.writeString(this.complexFileUrl);
            parcel.writeByte(this.isSelect ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.isDownLoading ? (byte) 1 : (byte) 0);
            parcel.writeString(this.localPath);
        }
    }
}
