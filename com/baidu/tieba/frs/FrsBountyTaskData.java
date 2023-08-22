package com.baidu.tieba.frs;

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
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FrsPage.BountyCard;
import tbclient.IconUrlInfo;
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b&\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 :2\u00020\u0001:\u0001:Bu\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000e¢\u0006\u0002\u0010\u000fJ\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u00101\u001a\u00020\fHÆ\u0003J\u0011\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000eHÆ\u0003Jy\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000eHÆ\u0001J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107HÖ\u0003J\t\u00108\u001a\u00020\fHÖ\u0001J\t\u00109\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0015\"\u0004\b%\u0010\u0017R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010\u0017R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0015\"\u0004\b)\u0010\u0017¨\u0006;"}, d2 = {"Lcom/baidu/tieba/frs/FrsBountyTaskData;", "Ljava/io/Serializable;", "icon", "Ltbclient/IconUrlInfo;", "containerBg", "title", "", "subTitle", "subTitleValue", "btnText", "jumpUrl", "awardType", "", "giftImgs", "", "(Ltbclient/IconUrlInfo;Ltbclient/IconUrlInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;)V", "getAwardType", "()I", "setAwardType", "(I)V", "getBtnText", "()Ljava/lang/String;", "setBtnText", "(Ljava/lang/String;)V", "getContainerBg", "()Ltbclient/IconUrlInfo;", "setContainerBg", "(Ltbclient/IconUrlInfo;)V", "getGiftImgs", "()Ljava/util/List;", "setGiftImgs", "(Ljava/util/List;)V", "getIcon", "setIcon", "getJumpUrl", "setJumpUrl", "getSubTitle", "setSubTitle", "getSubTitleValue", "setSubTitleValue", "getTitle", "setTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "toString", "Companion", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FrsBountyTaskData implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final a Companion;
    public transient /* synthetic */ FieldHolder $fh;
    public int awardType;
    public String btnText;
    public IconUrlInfo containerBg;
    public List<String> giftImgs;
    public IconUrlInfo icon;
    public String jumpUrl;
    public String subTitle;
    public String subTitleValue;
    public String title;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(641796112, "Lcom/baidu/tieba/frs/FrsBountyTaskData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(641796112, "Lcom/baidu/tieba/frs/FrsBountyTaskData;");
                return;
            }
        }
        Companion = new a(null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrsBountyTaskData() {
        this(null, null, null, null, null, null, null, 0, null, 511, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this((IconUrlInfo) objArr[0], (IconUrlInfo) objArr[1], (String) objArr[2], (String) objArr[3], (String) objArr[4], (String) objArr[5], (String) objArr[6], ((Integer) objArr[7]).intValue(), (List) objArr[8], ((Integer) objArr[9]).intValue(), (DefaultConstructorMarker) objArr[10]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @JvmStatic
    public static final FrsBountyTaskData parseProto(BountyCard bountyCard) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bountyCard)) == null) ? Companion.a(bountyCard) : (FrsBountyTaskData) invokeL.objValue;
    }

    public final IconUrlInfo component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.icon : (IconUrlInfo) invokeV.objValue;
    }

    public final IconUrlInfo component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.containerBg : (IconUrlInfo) invokeV.objValue;
    }

    public final String component3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.title : (String) invokeV.objValue;
    }

    public final String component4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.subTitle : (String) invokeV.objValue;
    }

    public final String component5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.subTitleValue : (String) invokeV.objValue;
    }

    public final String component6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.btnText : (String) invokeV.objValue;
    }

    public final String component7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.jumpUrl : (String) invokeV.objValue;
    }

    public final int component8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.awardType : invokeV.intValue;
    }

    public final List<String> component9() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.giftImgs : (List) invokeV.objValue;
    }

    public final FrsBountyTaskData copy(IconUrlInfo iconUrlInfo, IconUrlInfo iconUrlInfo2, String str, String str2, String str3, String str4, String str5, int i, List<String> giftImgs) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{iconUrlInfo, iconUrlInfo2, str, str2, str3, str4, str5, Integer.valueOf(i), giftImgs})) == null) {
            Intrinsics.checkNotNullParameter(giftImgs, "giftImgs");
            return new FrsBountyTaskData(iconUrlInfo, iconUrlInfo2, str, str2, str3, str4, str5, i, giftImgs);
        }
        return (FrsBountyTaskData) invokeCommon.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof FrsBountyTaskData) {
                FrsBountyTaskData frsBountyTaskData = (FrsBountyTaskData) obj;
                return Intrinsics.areEqual(this.icon, frsBountyTaskData.icon) && Intrinsics.areEqual(this.containerBg, frsBountyTaskData.containerBg) && Intrinsics.areEqual(this.title, frsBountyTaskData.title) && Intrinsics.areEqual(this.subTitle, frsBountyTaskData.subTitle) && Intrinsics.areEqual(this.subTitleValue, frsBountyTaskData.subTitleValue) && Intrinsics.areEqual(this.btnText, frsBountyTaskData.btnText) && Intrinsics.areEqual(this.jumpUrl, frsBountyTaskData.jumpUrl) && this.awardType == frsBountyTaskData.awardType && Intrinsics.areEqual(this.giftImgs, frsBountyTaskData.giftImgs);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            IconUrlInfo iconUrlInfo = this.icon;
            int hashCode = (iconUrlInfo == null ? 0 : iconUrlInfo.hashCode()) * 31;
            IconUrlInfo iconUrlInfo2 = this.containerBg;
            int hashCode2 = (hashCode + (iconUrlInfo2 == null ? 0 : iconUrlInfo2.hashCode())) * 31;
            String str = this.title;
            int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.subTitle;
            int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.subTitleValue;
            int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.btnText;
            int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.jumpUrl;
            return ((((hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.awardType) * 31) + this.giftImgs.hashCode();
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return "FrsBountyTaskData(icon=" + this.icon + ", containerBg=" + this.containerBg + ", title=" + this.title + ", subTitle=" + this.subTitle + ", subTitleValue=" + this.subTitleValue + ", btnText=" + this.btnText + ", jumpUrl=" + this.jumpUrl + ", awardType=" + this.awardType + ", giftImgs=" + this.giftImgs + ')';
        }
        return (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

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

        @JvmStatic
        public final FrsBountyTaskData a(BountyCard bountyCard) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bountyCard)) == null) {
                if (bountyCard == null) {
                    return null;
                }
                FrsBountyTaskData frsBountyTaskData = new FrsBountyTaskData(null, null, null, null, null, null, null, 0, null, 511, null);
                frsBountyTaskData.setIcon(bountyCard.icon);
                frsBountyTaskData.setTitle(bountyCard.title);
                frsBountyTaskData.setSubTitle(bountyCard.subtitle);
                frsBountyTaskData.setContainerBg(bountyCard.bg_img);
                Integer num = bountyCard.award_type;
                Intrinsics.checkNotNullExpressionValue(num, "card.award_type");
                frsBountyTaskData.setAwardType(num.intValue());
                frsBountyTaskData.setSubTitleValue(bountyCard.bonus);
                List<String> list = bountyCard.gift_imgs;
                Intrinsics.checkNotNullExpressionValue(list, "card.gift_imgs");
                frsBountyTaskData.setGiftImgs(list);
                frsBountyTaskData.setJumpUrl(bountyCard.url);
                frsBountyTaskData.setBtnText(bountyCard.btn_text);
                return frsBountyTaskData;
            }
            return (FrsBountyTaskData) invokeL.objValue;
        }
    }

    public FrsBountyTaskData(IconUrlInfo iconUrlInfo, IconUrlInfo iconUrlInfo2, String str, String str2, String str3, String str4, String str5, int i, List<String> giftImgs) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iconUrlInfo, iconUrlInfo2, str, str2, str3, str4, str5, Integer.valueOf(i), giftImgs};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(giftImgs, "giftImgs");
        this.icon = iconUrlInfo;
        this.containerBg = iconUrlInfo2;
        this.title = str;
        this.subTitle = str2;
        this.subTitleValue = str3;
        this.btnText = str4;
        this.jumpUrl = str5;
        this.awardType = i;
        this.giftImgs = giftImgs;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ FrsBountyTaskData(IconUrlInfo iconUrlInfo, IconUrlInfo iconUrlInfo2, String str, String str2, String str3, String str4, String str5, int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r3, r4, r5, r6, r7, r2, r8, r0);
        IconUrlInfo iconUrlInfo3;
        IconUrlInfo iconUrlInfo4;
        String str6;
        String str7;
        String str8;
        String str9;
        int i3;
        List list2;
        if ((i2 & 1) != 0) {
            iconUrlInfo3 = null;
        } else {
            iconUrlInfo3 = iconUrlInfo;
        }
        if ((i2 & 2) != 0) {
            iconUrlInfo4 = null;
        } else {
            iconUrlInfo4 = iconUrlInfo2;
        }
        if ((i2 & 4) != 0) {
            str6 = null;
        } else {
            str6 = str;
        }
        if ((i2 & 8) != 0) {
            str7 = null;
        } else {
            str7 = str2;
        }
        if ((i2 & 16) != 0) {
            str8 = null;
        } else {
            str8 = str3;
        }
        if ((i2 & 32) != 0) {
            str9 = null;
        } else {
            str9 = str4;
        }
        String str10 = (i2 & 64) == 0 ? str5 : null;
        if ((i2 & 128) != 0) {
            i3 = 0;
        } else {
            i3 = i;
        }
        if ((i2 & 256) != 0) {
            list2 = new ArrayList();
        } else {
            list2 = list;
        }
    }

    public final int getAwardType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.awardType;
        }
        return invokeV.intValue;
    }

    public final String getBtnText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.btnText;
        }
        return (String) invokeV.objValue;
    }

    public final IconUrlInfo getContainerBg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.containerBg;
        }
        return (IconUrlInfo) invokeV.objValue;
    }

    public final List<String> getGiftImgs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.giftImgs;
        }
        return (List) invokeV.objValue;
    }

    public final IconUrlInfo getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.icon;
        }
        return (IconUrlInfo) invokeV.objValue;
    }

    public final String getJumpUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.jumpUrl;
        }
        return (String) invokeV.objValue;
    }

    public final String getSubTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.subTitle;
        }
        return (String) invokeV.objValue;
    }

    public final String getSubTitleValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.subTitleValue;
        }
        return (String) invokeV.objValue;
    }

    public final String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.title;
        }
        return (String) invokeV.objValue;
    }

    public final void setAwardType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.awardType = i;
        }
    }

    public final void setBtnText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.btnText = str;
        }
    }

    public final void setContainerBg(IconUrlInfo iconUrlInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, iconUrlInfo) == null) {
            this.containerBg = iconUrlInfo;
        }
    }

    public final void setGiftImgs(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, list) == null) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.giftImgs = list;
        }
    }

    public final void setIcon(IconUrlInfo iconUrlInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, iconUrlInfo) == null) {
            this.icon = iconUrlInfo;
        }
    }

    public final void setJumpUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.jumpUrl = str;
        }
    }

    public final void setSubTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.subTitle = str;
        }
    }

    public final void setSubTitleValue(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            this.subTitleValue = str;
        }
    }

    public final void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.title = str;
        }
    }
}
