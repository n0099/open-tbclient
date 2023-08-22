package com.baidu.tieba.frs.banner.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.EngineName;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tieba.frs.FrsBountyTaskData;
import com.baidu.tieba.h75;
import com.baidu.tieba.lea;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u00010B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010$\u001a\u00020\tHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u000bHÆ\u0003JA\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010'\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\b\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020+H\u0016J\t\u0010-\u001a\u00020.HÖ\u0001J\t\u0010/\u001a\u00020+HÖ\u0001R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u00061"}, d2 = {"Lcom/baidu/tieba/frs/banner/data/FrsHeadBannerData;", "Lcom/baidu/tbadk/core/flow/data/CoverFlowData;", "type", "Lcom/baidu/tieba/frs/banner/data/FrsHeadBannerData$BannerType;", "forumData", "Lcom/baidu/tbadk/core/data/ForumData;", "businessPromot", "Lcom/baidu/tieba/tbadkCore/FrsBusinessPromot;", "fromCache", "", "bountyTaskData", "Lcom/baidu/tieba/frs/FrsBountyTaskData;", "(Lcom/baidu/tieba/frs/banner/data/FrsHeadBannerData$BannerType;Lcom/baidu/tbadk/core/data/ForumData;Lcom/baidu/tieba/tbadkCore/FrsBusinessPromot;ZLcom/baidu/tieba/frs/FrsBountyTaskData;)V", "getBountyTaskData", "()Lcom/baidu/tieba/frs/FrsBountyTaskData;", "setBountyTaskData", "(Lcom/baidu/tieba/frs/FrsBountyTaskData;)V", "getBusinessPromot", "()Lcom/baidu/tieba/tbadkCore/FrsBusinessPromot;", "setBusinessPromot", "(Lcom/baidu/tieba/tbadkCore/FrsBusinessPromot;)V", "getForumData", "()Lcom/baidu/tbadk/core/data/ForumData;", "setForumData", "(Lcom/baidu/tbadk/core/data/ForumData;)V", "getFromCache", "()Z", "setFromCache", "(Z)V", "getType", "()Lcom/baidu/tieba/frs/banner/data/FrsHeadBannerData$BannerType;", "setType", "(Lcom/baidu/tieba/frs/banner/data/FrsHeadBannerData$BannerType;)V", "component1", "component2", "component3", "component4", "component5", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "other", "", "getPicLinkUrl", "", "getPicUrl", TTDownloadField.TT_HASHCODE, "", "toString", "BannerType", "frs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FrsHeadBannerData implements h75 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BannerType a;
    public ForumData b;
    public lea c;
    public boolean d;
    public FrsBountyTaskData e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrsHeadBannerData() {
        this(null, null, null, false, null, 31, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this((BannerType) objArr[0], (ForumData) objArr[1], (lea) objArr[2], ((Boolean) objArr[3]).booleanValue(), (FrsBountyTaskData) objArr[4], ((Integer) objArr[5]).intValue(), (DefaultConstructorMarker) objArr[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof FrsHeadBannerData) {
                FrsHeadBannerData frsHeadBannerData = (FrsHeadBannerData) obj;
                return this.a == frsHeadBannerData.a && Intrinsics.areEqual(this.b, frsHeadBannerData.b) && Intrinsics.areEqual(this.c, frsHeadBannerData.c) && this.d == frsHeadBannerData.d && Intrinsics.areEqual(this.e, frsHeadBannerData.e);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.h75
    public String getPicLinkUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h75
    public String getPicUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int hashCode = this.a.hashCode() * 31;
            ForumData forumData = this.b;
            int hashCode2 = (hashCode + (forumData == null ? 0 : forumData.hashCode())) * 31;
            lea leaVar = this.c;
            int hashCode3 = (hashCode2 + (leaVar == null ? 0 : leaVar.hashCode())) * 31;
            boolean z = this.d;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            int i2 = (hashCode3 + i) * 31;
            FrsBountyTaskData frsBountyTaskData = this.e;
            return i2 + (frsBountyTaskData != null ? frsBountyTaskData.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return "FrsHeadBannerData(type=" + this.a + ", forumData=" + this.b + ", businessPromot=" + this.c + ", fromCache=" + this.d + ", bountyTaskData=" + this.e + ')';
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/baidu/tieba/frs/banner/data/FrsHeadBannerData$BannerType;", "", "(Ljava/lang/String;I)V", "AD_PIC", "FORUM_MOUNT", EngineName.DEFAULT_ENGINE, "frs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class BannerType {
        public static final /* synthetic */ BannerType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final BannerType AD_PIC;
        public static final BannerType DEFAULT;
        public static final BannerType FORUM_MOUNT;
        public transient /* synthetic */ FieldHolder $fh;

        public static final /* synthetic */ BannerType[] $values() {
            return new BannerType[]{AD_PIC, FORUM_MOUNT, DEFAULT};
        }

        public static BannerType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (BannerType) Enum.valueOf(BannerType.class, str) : (BannerType) invokeL.objValue;
        }

        public static BannerType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (BannerType[]) $VALUES.clone() : (BannerType[]) invokeV.objValue;
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1568429622, "Lcom/baidu/tieba/frs/banner/data/FrsHeadBannerData$BannerType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1568429622, "Lcom/baidu/tieba/frs/banner/data/FrsHeadBannerData$BannerType;");
                    return;
                }
            }
            AD_PIC = new BannerType("AD_PIC", 0);
            FORUM_MOUNT = new BannerType("FORUM_MOUNT", 1);
            DEFAULT = new BannerType(EngineName.DEFAULT_ENGINE, 2);
            $VALUES = $values();
        }

        public BannerType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                }
            }
        }
    }

    public FrsHeadBannerData(BannerType type, ForumData forumData, lea leaVar, boolean z, FrsBountyTaskData frsBountyTaskData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {type, forumData, leaVar, Boolean.valueOf(z), frsBountyTaskData};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(type, "type");
        this.a = type;
        this.b = forumData;
        this.c = leaVar;
        this.d = z;
        this.e = frsBountyTaskData;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ FrsHeadBannerData(BannerType bannerType, ForumData forumData, lea leaVar, boolean z, FrsBountyTaskData frsBountyTaskData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bannerType, r10, r1, r2, (i & 16) == 0 ? frsBountyTaskData : null);
        ForumData forumData2;
        lea leaVar2;
        boolean z2;
        bannerType = (i & 1) != 0 ? BannerType.DEFAULT : bannerType;
        if ((i & 2) != 0) {
            forumData2 = null;
        } else {
            forumData2 = forumData;
        }
        if ((i & 4) != 0) {
            leaVar2 = null;
        } else {
            leaVar2 = leaVar;
        }
        if ((i & 8) != 0) {
            z2 = false;
        } else {
            z2 = z;
        }
    }

    public final FrsBountyTaskData a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e;
        }
        return (FrsBountyTaskData) invokeV.objValue;
    }

    public final lea b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (lea) invokeV.objValue;
    }

    public final ForumData c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (ForumData) invokeV.objValue;
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    public final BannerType getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.a;
        }
        return (BannerType) invokeV.objValue;
    }

    public final void e(FrsBountyTaskData frsBountyTaskData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, frsBountyTaskData) == null) {
            this.e = frsBountyTaskData;
        }
    }

    public final void f(lea leaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, leaVar) == null) {
            this.c = leaVar;
        }
    }

    public final void g(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, forumData) == null) {
            this.b = forumData;
        }
    }

    public final void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.d = z;
        }
    }

    public final void i(BannerType bannerType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bannerType) == null) {
            Intrinsics.checkNotNullParameter(bannerType, "<set-?>");
            this.a = bannerType;
        }
    }
}
