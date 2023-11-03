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
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
@Parcelize
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\n\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0013J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u0011\u0010(\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\nHÆ\u0003J\t\u0010*\u001a\u00020\u000fHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0083\u0001\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\n2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\u0013\u0010.\u001a\u00020\u000f2\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\u0006\u00101\u001a\u00020\u000fJ\t\u00102\u001a\u00020\u0003HÖ\u0001J\t\u00103\u001a\u00020\u0005HÖ\u0001J\u0019\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001e¨\u00069"}, d2 = {"Lcom/baidu/tieba/forum/data/ForumTabItem;", "Landroid/os/Parcelable;", "tabId", "", "tabName", "", "tabType", "tabUrl", "netType", "sortItemList", "", "Lcom/baidu/tieba/forum/data/SortItem;", "subTabList", "Lcom/baidu/tieba/forum/data/SubTabItem;", "isGeneralTab", "", "tabNormalPic", "Lcom/baidu/tieba/forum/data/ForumTabPic;", "tabDarkPic", "(ILjava/lang/String;ILjava/lang/String;ILjava/util/List;Ljava/util/List;ZLcom/baidu/tieba/forum/data/ForumTabPic;Lcom/baidu/tieba/forum/data/ForumTabPic;)V", "()Z", "getNetType", "()I", "getSortItemList", "()Ljava/util/List;", "getSubTabList", "getTabDarkPic", "()Lcom/baidu/tieba/forum/data/ForumTabPic;", "getTabId", "getTabName", "()Ljava/lang/String;", "getTabNormalPic", "getTabType", "getTabUrl", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "describeContents", "equals", "other", "", "hasTabPic", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ForumTabItem implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<ForumTabItem> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean isGeneralTab;
    public final int netType;
    public final List<SortItem> sortItemList;
    public final List<SubTabItem> subTabList;
    public final ForumTabPic tabDarkPic;
    public final int tabId;
    public final String tabName;
    public final ForumTabPic tabNormalPic;
    public final int tabType;
    public final String tabUrl;

    /* loaded from: classes6.dex */
    public static final class a implements Parcelable.Creator<ForumTabItem> {
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
        public final ForumTabItem createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            ArrayList arrayList;
            ArrayList arrayList2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                int readInt = parcel.readInt();
                String readString = parcel.readString();
                int readInt2 = parcel.readInt();
                String readString2 = parcel.readString();
                int readInt3 = parcel.readInt();
                if (parcel.readInt() == 0) {
                    arrayList = null;
                } else {
                    int readInt4 = parcel.readInt();
                    arrayList = new ArrayList(readInt4);
                    for (int i = 0; i != readInt4; i++) {
                        arrayList.add(SortItem.CREATOR.createFromParcel(parcel));
                    }
                }
                if (parcel.readInt() == 0) {
                    arrayList2 = null;
                } else {
                    int readInt5 = parcel.readInt();
                    arrayList2 = new ArrayList(readInt5);
                    for (int i2 = 0; i2 != readInt5; i2++) {
                        arrayList2.add(SubTabItem.CREATOR.createFromParcel(parcel));
                    }
                }
                return new ForumTabItem(readInt, readString, readInt2, readString2, readInt3, arrayList, arrayList2, parcel.readInt() != 0, parcel.readInt() == 0 ? null : ForumTabPic.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? ForumTabPic.CREATOR.createFromParcel(parcel) : null);
            }
            return (ForumTabItem) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final ForumTabItem[] newArray(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? new ForumTabItem[i] : (ForumTabItem[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1195675925, "Lcom/baidu/tieba/forum/data/ForumTabItem;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1195675925, "Lcom/baidu/tieba/forum/data/ForumTabItem;");
                return;
            }
        }
        CREATOR = new a();
    }

    public final int component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.tabId : invokeV.intValue;
    }

    public final ForumTabPic component10() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.tabDarkPic : (ForumTabPic) invokeV.objValue;
    }

    public final String component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.tabName : (String) invokeV.objValue;
    }

    public final int component3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.tabType : invokeV.intValue;
    }

    public final String component4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.tabUrl : (String) invokeV.objValue;
    }

    public final int component5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.netType : invokeV.intValue;
    }

    public final List<SortItem> component6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.sortItemList : (List) invokeV.objValue;
    }

    public final List<SubTabItem> component7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.subTabList : (List) invokeV.objValue;
    }

    public final boolean component8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.isGeneralTab : invokeV.booleanValue;
    }

    public final ForumTabPic component9() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.tabNormalPic : (ForumTabPic) invokeV.objValue;
    }

    public final ForumTabItem copy(int i, String tabName, int i2, String str, int i3, List<SortItem> list, List<SubTabItem> list2, boolean z, ForumTabPic forumTabPic, ForumTabPic forumTabPic2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), tabName, Integer.valueOf(i2), str, Integer.valueOf(i3), list, list2, Boolean.valueOf(z), forumTabPic, forumTabPic2})) == null) {
            Intrinsics.checkNotNullParameter(tabName, "tabName");
            return new ForumTabItem(i, tabName, i2, str, i3, list, list2, z, forumTabPic, forumTabPic2);
        }
        return (ForumTabItem) invokeCommon.objValue;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ForumTabItem) {
                ForumTabItem forumTabItem = (ForumTabItem) obj;
                return this.tabId == forumTabItem.tabId && Intrinsics.areEqual(this.tabName, forumTabItem.tabName) && this.tabType == forumTabItem.tabType && Intrinsics.areEqual(this.tabUrl, forumTabItem.tabUrl) && this.netType == forumTabItem.netType && Intrinsics.areEqual(this.sortItemList, forumTabItem.sortItemList) && Intrinsics.areEqual(this.subTabList, forumTabItem.subTabList) && this.isGeneralTab == forumTabItem.isGeneralTab && Intrinsics.areEqual(this.tabNormalPic, forumTabItem.tabNormalPic) && Intrinsics.areEqual(this.tabDarkPic, forumTabItem.tabDarkPic);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v14, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            int hashCode = ((((this.tabId * 31) + this.tabName.hashCode()) * 31) + this.tabType) * 31;
            String str = this.tabUrl;
            int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.netType) * 31;
            List<SortItem> list = this.sortItemList;
            int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
            List<SubTabItem> list2 = this.subTabList;
            int hashCode4 = (hashCode3 + (list2 == null ? 0 : list2.hashCode())) * 31;
            boolean z = this.isGeneralTab;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            int i2 = (hashCode4 + i) * 31;
            ForumTabPic forumTabPic = this.tabNormalPic;
            int hashCode5 = (i2 + (forumTabPic == null ? 0 : forumTabPic.hashCode())) * 31;
            ForumTabPic forumTabPic2 = this.tabDarkPic;
            return hashCode5 + (forumTabPic2 != null ? forumTabPic2.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return "ForumTabItem(tabId=" + this.tabId + ", tabName=" + this.tabName + ", tabType=" + this.tabType + ", tabUrl=" + this.tabUrl + ", netType=" + this.netType + ", sortItemList=" + this.sortItemList + ", subTabList=" + this.subTabList + ", isGeneralTab=" + this.isGeneralTab + ", tabNormalPic=" + this.tabNormalPic + ", tabDarkPic=" + this.tabDarkPic + ')';
        }
        return (String) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048602, this, out, i) == null) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeInt(this.tabId);
            out.writeString(this.tabName);
            out.writeInt(this.tabType);
            out.writeString(this.tabUrl);
            out.writeInt(this.netType);
            List<SortItem> list = this.sortItemList;
            if (list == null) {
                out.writeInt(0);
            } else {
                out.writeInt(1);
                out.writeInt(list.size());
                for (SortItem sortItem : list) {
                    sortItem.writeToParcel(out, i);
                }
            }
            List<SubTabItem> list2 = this.subTabList;
            if (list2 == null) {
                out.writeInt(0);
            } else {
                out.writeInt(1);
                out.writeInt(list2.size());
                for (SubTabItem subTabItem : list2) {
                    subTabItem.writeToParcel(out, i);
                }
            }
            out.writeInt(this.isGeneralTab ? 1 : 0);
            ForumTabPic forumTabPic = this.tabNormalPic;
            if (forumTabPic == null) {
                out.writeInt(0);
            } else {
                out.writeInt(1);
                forumTabPic.writeToParcel(out, i);
            }
            ForumTabPic forumTabPic2 = this.tabDarkPic;
            if (forumTabPic2 == null) {
                out.writeInt(0);
                return;
            }
            out.writeInt(1);
            forumTabPic2.writeToParcel(out, i);
        }
    }

    public ForumTabItem(int i, String tabName, int i2, String str, int i3, List<SortItem> list, List<SubTabItem> list2, boolean z, ForumTabPic forumTabPic, ForumTabPic forumTabPic2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), tabName, Integer.valueOf(i2), str, Integer.valueOf(i3), list, list2, Boolean.valueOf(z), forumTabPic, forumTabPic2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(tabName, "tabName");
        this.tabId = i;
        this.tabName = tabName;
        this.tabType = i2;
        this.tabUrl = str;
        this.netType = i3;
        this.sortItemList = list;
        this.subTabList = list2;
        this.isGeneralTab = z;
        this.tabNormalPic = forumTabPic;
        this.tabDarkPic = forumTabPic2;
    }

    public final int getNetType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.netType;
        }
        return invokeV.intValue;
    }

    public final List<SortItem> getSortItemList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.sortItemList;
        }
        return (List) invokeV.objValue;
    }

    public final List<SubTabItem> getSubTabList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.subTabList;
        }
        return (List) invokeV.objValue;
    }

    public final ForumTabPic getTabDarkPic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.tabDarkPic;
        }
        return (ForumTabPic) invokeV.objValue;
    }

    public final int getTabId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.tabId;
        }
        return invokeV.intValue;
    }

    public final String getTabName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.tabName;
        }
        return (String) invokeV.objValue;
    }

    public final ForumTabPic getTabNormalPic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.tabNormalPic;
        }
        return (ForumTabPic) invokeV.objValue;
    }

    public final int getTabType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.tabType;
        }
        return invokeV.intValue;
    }

    public final String getTabUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.tabUrl;
        }
        return (String) invokeV.objValue;
    }

    public final boolean hasTabPic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.tabNormalPic != null && this.tabDarkPic != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean isGeneralTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.isGeneralTab;
        }
        return invokeV.booleanValue;
    }
}
