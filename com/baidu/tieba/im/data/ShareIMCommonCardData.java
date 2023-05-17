package com.baidu.tieba.im.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\b¨\u0006\""}, d2 = {"Lcom/baidu/tieba/im/data/ShareIMCommonCardData;", "Ljava/io/Serializable;", "()V", "avatar", "", "getAvatar", "()Ljava/lang/String;", "setAvatar", "(Ljava/lang/String;)V", "desc", "getDesc", "setDesc", "id", "getId", "setId", "inputPlaceholder", "getInputPlaceholder", "setInputPlaceholder", "jumpLink", "getJumpLink", "setJumpLink", "shareType", "", "getShareType", "()I", "setShareType", "(I)V", "tagName", "getTagName", "setTagName", "title", "getTitle", "setTitle", "Companion", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ShareIMCommonCardData implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final a Companion;
    public static final int TYPE_ALBUM = 2;
    public static final int TYPE_TOPIC = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public String avatar;
    public String desc;
    public String id;
    public String inputPlaceholder;
    public String jumpLink;
    public int shareType;
    public String tagName;
    public String title;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1532707269, "Lcom/baidu/tieba/im/data/ShareIMCommonCardData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1532707269, "Lcom/baidu/tieba/im/data/ShareIMCommonCardData;");
                return;
            }
        }
        Companion = new a(null);
    }

    @JvmStatic
    public static final ShareIMCommonCardData fromJsonH5(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) ? Companion.a(jSONObject) : (ShareIMCommonCardData) invokeL.objValue;
    }

    @JvmStatic
    public static final boolean isValidAlbum(ShareIMCommonCardData shareIMCommonCardData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, shareIMCommonCardData)) == null) ? Companion.b(shareIMCommonCardData) : invokeL.booleanValue;
    }

    @JvmStatic
    public static final boolean isValidTopic(ShareIMCommonCardData shareIMCommonCardData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, shareIMCommonCardData)) == null) ? Companion.c(shareIMCommonCardData) : invokeL.booleanValue;
    }

    /* loaded from: classes6.dex */
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
        public final ShareIMCommonCardData a(JSONObject jsonData) {
            InterceptResult invokeL;
            boolean z;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jsonData)) == null) {
                Intrinsics.checkNotNullParameter(jsonData, "jsonData");
                ShareIMCommonCardData shareIMCommonCardData = new ShareIMCommonCardData();
                String optString = jsonData.optString("img");
                Intrinsics.checkNotNullExpressionValue(optString, "jsonData.optString(\"img\")");
                shareIMCommonCardData.setAvatar(optString);
                String optString2 = jsonData.optString("url");
                Intrinsics.checkNotNullExpressionValue(optString2, "jsonData.optString(\"url\")");
                shareIMCommonCardData.setJumpLink(optString2);
                String topicId = jsonData.optString("topicId");
                JSONObject optJSONObject = jsonData.optJSONObject("shareIMCard");
                if (optJSONObject == null) {
                    return null;
                }
                String albumId = optJSONObject.optString("albumId");
                String optString3 = optJSONObject.optString("tagName");
                Intrinsics.checkNotNullExpressionValue(optString3, "shareIMCardObject.optString(\"tagName\")");
                shareIMCommonCardData.setTagName(optString3);
                int optInt = optJSONObject.optInt("type");
                boolean z3 = false;
                if (1 == optInt) {
                    if (topicId != null && topicId.length() != 0) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (!z2) {
                        Intrinsics.checkNotNullExpressionValue(topicId, "topicId");
                        shareIMCommonCardData.setId(topicId);
                        shareIMCommonCardData.setShareType(1);
                    }
                }
                if (2 == optInt) {
                    if (albumId != null && albumId.length() != 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        Intrinsics.checkNotNullExpressionValue(albumId, "albumId");
                        shareIMCommonCardData.setId(albumId);
                        shareIMCommonCardData.setShareType(2);
                    }
                }
                if (shareIMCommonCardData.getId().length() == 0) {
                    z3 = true;
                }
                if (z3) {
                    return null;
                }
                String optString4 = optJSONObject.optString("dialogTitle");
                Intrinsics.checkNotNullExpressionValue(optString4, "shareIMCardObject.optString(\"dialogTitle\")");
                shareIMCommonCardData.setTitle(optString4);
                String optString5 = optJSONObject.optString("dialogDesc");
                Intrinsics.checkNotNullExpressionValue(optString5, "shareIMCardObject.optString(\"dialogDesc\")");
                shareIMCommonCardData.setDesc(optString5);
                shareIMCommonCardData.setInputPlaceholder(optJSONObject.optString("inputPlaceholder"));
                return shareIMCommonCardData;
            }
            return (ShareIMCommonCardData) invokeL.objValue;
        }

        @JvmStatic
        public final boolean b(ShareIMCommonCardData shareIMCommonCardData) {
            InterceptResult invokeL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shareIMCommonCardData)) == null) {
                if (shareIMCommonCardData != null && shareIMCommonCardData.getShareType() == 2) {
                    if (shareIMCommonCardData.getId().length() > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        return true;
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @JvmStatic
        public final boolean c(ShareIMCommonCardData shareIMCommonCardData) {
            InterceptResult invokeL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, shareIMCommonCardData)) == null) {
                if (shareIMCommonCardData == null || shareIMCommonCardData.getShareType() != 1) {
                    return false;
                }
                if (shareIMCommonCardData.getId().length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    public ShareIMCommonCardData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.shareType = -1;
        this.id = "";
        this.avatar = "";
        this.title = "";
        this.desc = "";
        this.jumpLink = "";
        this.tagName = "";
    }

    public final String getAvatar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.avatar;
        }
        return (String) invokeV.objValue;
    }

    public final String getDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.desc;
        }
        return (String) invokeV.objValue;
    }

    public final String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.id;
        }
        return (String) invokeV.objValue;
    }

    public final String getInputPlaceholder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.inputPlaceholder;
        }
        return (String) invokeV.objValue;
    }

    public final String getJumpLink() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.jumpLink;
        }
        return (String) invokeV.objValue;
    }

    public final int getShareType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.shareType;
        }
        return invokeV.intValue;
    }

    public final String getTagName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.tagName;
        }
        return (String) invokeV.objValue;
    }

    public final String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.title;
        }
        return (String) invokeV.objValue;
    }

    public final void setAvatar(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.avatar = str;
        }
    }

    public final void setDesc(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.desc = str;
        }
    }

    public final void setId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.id = str;
        }
    }

    public final void setInputPlaceholder(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.inputPlaceholder = str;
        }
    }

    public final void setJumpLink(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.jumpLink = str;
        }
    }

    public final void setShareType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.shareType = i;
        }
    }

    public final void setTagName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.tagName = str;
        }
    }

    public final void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.title = str;
        }
    }
}
