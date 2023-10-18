package com.baidu.tieba.homepage.tabfeed.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.yh;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ActivityPage.SpecialColumn;
/* loaded from: classes6.dex */
public class SpecialColumnItemData implements yh, Parcelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<SpecialColumnItemData> CREATOR;
    public static final BdUniqueId TYPE;
    public static final int TYPE_LIVE = 3;
    public static final int TYPE_LIVE_RE = 4;
    public static final int TYPE_NORMAL = 1;
    public static final int TYPE_VIDEO = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public int agree_num;
    public int freq_num;
    public String image;
    public long liveId;
    public int specialType;
    public String text;
    public long threadId;
    public String title;

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes6.dex */
    public class a implements Parcelable.Creator<SpecialColumnItemData> {
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
        public SpecialColumnItemData createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) {
                return new SpecialColumnItemData(parcel);
            }
            return (SpecialColumnItemData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SpecialColumnItemData[] newArray(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                return new SpecialColumnItemData[i];
            }
            return (SpecialColumnItemData[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(673274821, "Lcom/baidu/tieba/homepage/tabfeed/data/SpecialColumnItemData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(673274821, "Lcom/baidu/tieba/homepage/tabfeed/data/SpecialColumnItemData;");
                return;
            }
        }
        TYPE = BdUniqueId.gen();
        CREATOR = new a();
    }

    public SpecialColumnItemData() {
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

    @Override // com.baidu.tieba.yh
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return TYPE;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public SpecialColumnItemData(Parcel parcel) {
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
        this.specialType = parcel.readInt();
        this.threadId = parcel.readLong();
        this.liveId = parcel.readLong();
        this.title = parcel.readString();
        this.image = parcel.readString();
        this.text = parcel.readString();
        this.freq_num = parcel.readInt();
        this.agree_num = parcel.readInt();
    }

    public void parserProtobuf(SpecialColumn specialColumn) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, specialColumn) == null) {
            this.specialType = specialColumn.type.intValue();
            this.threadId = specialColumn.thread_id.longValue();
            this.liveId = specialColumn.live_id.longValue();
            this.title = specialColumn.title;
            this.image = specialColumn.image;
            this.text = specialColumn.text;
            this.freq_num = specialColumn.freq_num.intValue();
            this.agree_num = specialColumn.agree_num.intValue();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, parcel, i) == null) {
            parcel.writeInt(this.specialType);
            parcel.writeLong(this.threadId);
            parcel.writeLong(this.liveId);
            parcel.writeString(this.title);
            parcel.writeString(this.image);
            parcel.writeString(this.text);
            parcel.writeInt(this.freq_num);
            parcel.writeInt(this.agree_num);
        }
    }
}
