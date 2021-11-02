package com.baidu.tbadk.coreExtra.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.data.QmFilterItem;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes8.dex */
public class TbMultiMediaData extends MultiMediaData implements Parcelable, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<TbMultiMediaData> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public String coverPath;
    public int coverSource;
    @Nullable
    public List<MultiMediaData> coverStickerList;
    public float lastCoverPercent;
    public String orignalCoverPath;
    @Nullable
    public String orignalVideoPath;
    @Nullable
    public QmFilterItem videoFilter;
    public int videoInfoSource;
    public float videoRatio;

    /* loaded from: classes8.dex */
    public static class a implements Parcelable.Creator<TbMultiMediaData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TbMultiMediaData createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? new TbMultiMediaData(parcel) : (TbMultiMediaData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public TbMultiMediaData[] newArray(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new TbMultiMediaData[i2] : (TbMultiMediaData[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1940425868, "Lcom/baidu/tbadk/coreExtra/data/TbMultiMediaData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1940425868, "Lcom/baidu/tbadk/coreExtra/data/TbMultiMediaData;");
                return;
            }
        }
        CREATOR = new a();
    }

    public TbMultiMediaData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.videoInfoSource = 2;
    }

    @Override // com.baidu.ugc.editvideo.data.MultiMediaData, android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Nullable
    public List<MultiMediaData> getCoverStickerList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.coverStickerList : (List) invokeV.objValue;
    }

    @Nullable
    public String getOrignalVideoPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.orignalVideoPath : (String) invokeV.objValue;
    }

    @Nullable
    public QmFilterItem getVideoFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.videoFilter : (QmFilterItem) invokeV.objValue;
    }

    public void setCoverStickerList(@Nullable List<MultiMediaData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.coverStickerList = list;
        }
    }

    public void setOrignalVideoPath(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.orignalVideoPath = str;
        }
    }

    public void setVideoFilter(@Nullable QmFilterItem qmFilterItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, qmFilterItem) == null) {
            this.videoFilter = qmFilterItem;
        }
    }

    @Override // com.baidu.ugc.editvideo.data.MultiMediaData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, parcel, i2) == null) {
            super.writeToParcel(parcel, i2);
            parcel.writeFloat(this.videoRatio);
            parcel.writeString(this.coverPath);
            parcel.writeString(this.orignalCoverPath);
            parcel.writeInt(this.coverSource);
            parcel.writeFloat(this.lastCoverPercent);
            parcel.writeInt(this.videoInfoSource);
            parcel.writeTypedList(this.coverStickerList);
            parcel.writeString(this.orignalVideoPath);
            parcel.writeParcelable(this.videoFilter, i2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbMultiMediaData(Parcel parcel) {
        super(parcel);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Parcel) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.videoInfoSource = 2;
        this.videoRatio = parcel.readFloat();
        this.coverPath = parcel.readString();
        this.orignalCoverPath = parcel.readString();
        this.coverSource = parcel.readInt();
        this.lastCoverPercent = parcel.readFloat();
        this.videoInfoSource = parcel.readInt();
        this.coverStickerList = parcel.createTypedArrayList(MultiMediaData.CREATOR);
        this.orignalVideoPath = parcel.readString();
        this.videoFilter = (QmFilterItem) parcel.readParcelable(QmFilterItem.class.getClassLoader());
    }
}
