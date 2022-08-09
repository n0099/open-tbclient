package com.baidu.tbadk.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ForumTagInfo;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class SelectForumData implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<SelectForumData> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public String avatarUrl;
    public String blockInfo;
    public String firstCategory;
    public String forumId;
    public String forumName;
    public ForumTagInfo forumTagInfo;
    public int index;
    public boolean isCanPost;
    public boolean isForumBusinessAccount;
    public boolean isInterestForumSelected;
    public boolean isLately;
    public int level;
    public PostPrefixData postPrefix;
    public List<FrsTabItemData> tabInfoList;

    /* loaded from: classes3.dex */
    public static class a implements Parcelable.Creator<SelectForumData> {
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
        public SelectForumData createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? new SelectForumData(parcel) : (SelectForumData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SelectForumData[] newArray(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? new SelectForumData[i] : (SelectForumData[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1646196366, "Lcom/baidu/tbadk/data/SelectForumData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1646196366, "Lcom/baidu/tbadk/data/SelectForumData;");
                return;
            }
        }
        CREATOR = new a();
    }

    public SelectForumData() {
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

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public void readFromParcel(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel) == null) {
            this.forumId = parcel.readString();
            this.avatarUrl = parcel.readString();
            this.forumName = parcel.readString();
            this.level = parcel.readInt();
            this.isLately = parcel.readByte() != 0;
            this.isCanPost = parcel.readByte() != 0;
            this.blockInfo = parcel.readString();
            ArrayList arrayList = new ArrayList();
            this.tabInfoList = arrayList;
            parcel.readList(arrayList, FrsTabItemData.class.getClassLoader());
            this.postPrefix = (PostPrefixData) parcel.readSerializable();
            this.isForumBusinessAccount = parcel.readByte() != 0;
            this.forumTagInfo = (ForumTagInfo) parcel.readSerializable();
            this.firstCategory = parcel.readString();
            this.isInterestForumSelected = parcel.readByte() != 0;
            this.index = parcel.readInt();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, parcel, i) == null) {
            parcel.writeString(this.forumId);
            parcel.writeString(this.avatarUrl);
            parcel.writeString(this.forumName);
            parcel.writeInt(this.level);
            parcel.writeByte(this.isLately ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.isCanPost ? (byte) 1 : (byte) 0);
            parcel.writeString(this.blockInfo);
            parcel.writeList(this.tabInfoList);
            parcel.writeSerializable(this.postPrefix);
            parcel.writeByte(this.isForumBusinessAccount ? (byte) 1 : (byte) 0);
            parcel.writeSerializable(this.forumTagInfo);
            parcel.writeString(this.firstCategory);
            parcel.writeByte(this.isInterestForumSelected ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.index);
        }
    }

    public SelectForumData(Parcel parcel) {
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
        this.forumId = parcel.readString();
        this.avatarUrl = parcel.readString();
        this.forumName = parcel.readString();
        this.level = parcel.readInt();
        this.isLately = parcel.readByte() != 0;
        this.isCanPost = parcel.readByte() != 0;
        this.blockInfo = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.tabInfoList = arrayList;
        parcel.readList(arrayList, FrsTabItemData.class.getClassLoader());
        this.postPrefix = (PostPrefixData) parcel.readSerializable();
        this.isForumBusinessAccount = parcel.readByte() != 0;
        this.forumTagInfo = (ForumTagInfo) parcel.readSerializable();
        this.firstCategory = parcel.readString();
        this.isInterestForumSelected = parcel.readByte() != 0;
        this.index = parcel.readInt();
    }
}
