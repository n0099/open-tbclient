package com.baidu.tieba.im.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.data.PbPostShareData;
import com.baidu.tieba.yz8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/baidu/tieba/im/data/ShareFloatCardData;", "Ljava/io/Serializable;", "mainThread", "Lcom/baidu/tieba/im/data/ShareFloatCardData$MainThread;", "postThread", "Lcom/baidu/tieba/im/data/ShareFloatCardData$PostThread;", "(Lcom/baidu/tieba/im/data/ShareFloatCardData$MainThread;Lcom/baidu/tieba/im/data/ShareFloatCardData$PostThread;)V", "getMainThread", "()Lcom/baidu/tieba/im/data/ShareFloatCardData$MainThread;", "getPostThread", "()Lcom/baidu/tieba/im/data/ShareFloatCardData$PostThread;", "buildShareFloatCardData", "Lcom/baidu/tieba/pb/data/PbPostShareData;", "component1", "component2", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", "hashCode", "", "toString", "", "MainThread", "PostThread", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ShareFloatCardData implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("mainThread")
    public final MainThread mainThread;
    @SerializedName("postThread")
    public final PostThread postThread;

    public static /* synthetic */ ShareFloatCardData copy$default(ShareFloatCardData shareFloatCardData, MainThread mainThread, PostThread postThread, int i, Object obj) {
        if ((i & 1) != 0) {
            mainThread = shareFloatCardData.mainThread;
        }
        if ((i & 2) != 0) {
            postThread = shareFloatCardData.postThread;
        }
        return shareFloatCardData.copy(mainThread, postThread);
    }

    public final MainThread component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mainThread : (MainThread) invokeV.objValue;
    }

    public final PostThread component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.postThread : (PostThread) invokeV.objValue;
    }

    public final ShareFloatCardData copy(MainThread mainThread, PostThread postThread) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, mainThread, postThread)) == null) ? new ShareFloatCardData(mainThread, postThread) : (ShareFloatCardData) invokeLL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ShareFloatCardData) {
                ShareFloatCardData shareFloatCardData = (ShareFloatCardData) obj;
                return Intrinsics.areEqual(this.mainThread, shareFloatCardData.mainThread) && Intrinsics.areEqual(this.postThread, shareFloatCardData.postThread);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            MainThread mainThread = this.mainThread;
            int hashCode = (mainThread == null ? 0 : mainThread.hashCode()) * 31;
            PostThread postThread = this.postThread;
            return hashCode + (postThread != null ? postThread.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "ShareFloatCardData(mainThread=" + this.mainThread + ", postThread=" + this.postThread + ')';
        }
        return (String) invokeV.objValue;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/baidu/tieba/im/data/ShareFloatCardData$MainThread;", "Ljava/io/Serializable;", "title", "", "threadImgUrl", "threadShareUrl", "threadType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getThreadImgUrl", "()Ljava/lang/String;", "getThreadShareUrl", "getThreadType", "getTitle", "component1", "component2", "component3", "component4", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", "hashCode", "", "toString", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class MainThread implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("threadImgUrl")
        public final String threadImgUrl;
        @SerializedName("threadShareUrl")
        public final String threadShareUrl;
        @SerializedName("threadType")
        public final String threadType;
        @SerializedName("title")
        public final String title;

        public static /* synthetic */ MainThread copy$default(MainThread mainThread, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = mainThread.title;
            }
            if ((i & 2) != 0) {
                str2 = mainThread.threadImgUrl;
            }
            if ((i & 4) != 0) {
                str3 = mainThread.threadShareUrl;
            }
            if ((i & 8) != 0) {
                str4 = mainThread.threadType;
            }
            return mainThread.copy(str, str2, str3, str4);
        }

        public final String component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.title : (String) invokeV.objValue;
        }

        public final String component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.threadImgUrl : (String) invokeV.objValue;
        }

        public final String component3() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.threadShareUrl : (String) invokeV.objValue;
        }

        public final String component4() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.threadType : (String) invokeV.objValue;
        }

        public final MainThread copy(String str, String str2, String str3, String str4) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, str, str2, str3, str4)) == null) ? new MainThread(str, str2, str3, str4) : (MainThread) invokeLLLL.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof MainThread) {
                    MainThread mainThread = (MainThread) obj;
                    return Intrinsics.areEqual(this.title, mainThread.title) && Intrinsics.areEqual(this.threadImgUrl, mainThread.threadImgUrl) && Intrinsics.areEqual(this.threadShareUrl, mainThread.threadShareUrl) && Intrinsics.areEqual(this.threadType, mainThread.threadType);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                String str = this.title;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.threadImgUrl;
                int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.threadShareUrl;
                int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.threadType;
                return hashCode3 + (str4 != null ? str4.hashCode() : 0);
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return "MainThread(title=" + this.title + ", threadImgUrl=" + this.threadImgUrl + ", threadShareUrl=" + this.threadShareUrl + ", threadType=" + this.threadType + ')';
            }
            return (String) invokeV.objValue;
        }

        public MainThread(String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.title = str;
            this.threadImgUrl = str2;
            this.threadShareUrl = str3;
            this.threadType = str4;
        }

        public final String getThreadImgUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.threadImgUrl;
            }
            return (String) invokeV.objValue;
        }

        public final String getThreadShareUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.threadShareUrl;
            }
            return (String) invokeV.objValue;
        }

        public final String getThreadType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.threadType;
            }
            return (String) invokeV.objValue;
        }

        public final String getTitle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return this.title;
            }
            return (String) invokeV.objValue;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/baidu/tieba/im/data/ShareFloatCardData$PostThread;", "Ljava/io/Serializable;", "username", "", "postList", "", "", "(Ljava/lang/String;Ljava/util/List;)V", "getPostList", "()Ljava/util/List;", "getUsername", "()Ljava/lang/String;", "component1", "component2", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "hashCode", "", "toString", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class PostThread implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("postList")
        public final List<Object> postList;
        @SerializedName("username")
        public final String username;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.im.data.ShareFloatCardData$PostThread */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PostThread copy$default(PostThread postThread, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = postThread.username;
            }
            if ((i & 2) != 0) {
                list = postThread.postList;
            }
            return postThread.copy(str, list);
        }

        public final String component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.username : (String) invokeV.objValue;
        }

        public final List<Object> component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.postList : (List) invokeV.objValue;
        }

        public final PostThread copy(String str, List<? extends Object> list) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, list)) == null) ? new PostThread(str, list) : (PostThread) invokeLL.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof PostThread) {
                    PostThread postThread = (PostThread) obj;
                    return Intrinsics.areEqual(this.username, postThread.username) && Intrinsics.areEqual(this.postList, postThread.postList);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                String str = this.username;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                List<Object> list = this.postList;
                return hashCode + (list != null ? list.hashCode() : 0);
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return "PostThread(username=" + this.username + ", postList=" + this.postList + ')';
            }
            return (String) invokeV.objValue;
        }

        public PostThread(String str, List<? extends Object> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.username = str;
            this.postList = list;
        }

        public final List<Object> getPostList() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.postList;
            }
            return (List) invokeV.objValue;
        }

        public final String getUsername() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.username;
            }
            return (String) invokeV.objValue;
        }
    }

    public ShareFloatCardData(MainThread mainThread, PostThread postThread) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainThread, postThread};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mainThread = mainThread;
        this.postThread = postThread;
    }

    public final PbPostShareData buildShareFloatCardData() {
        InterceptResult invokeV;
        String str;
        String str2;
        String name;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PbPostShareData pbPostShareData = new PbPostShareData();
            MainThread mainThread = this.mainThread;
            String str3 = null;
            if (mainThread != null) {
                str = mainThread.getTitle();
            } else {
                str = null;
            }
            pbPostShareData.k(str);
            MainThread mainThread2 = this.mainThread;
            if (mainThread2 != null) {
                str2 = mainThread2.getThreadImgUrl();
            } else {
                str2 = null;
            }
            pbPostShareData.o(str2);
            MainThread mainThread3 = this.mainThread;
            if (mainThread3 == null || (name = mainThread3.getThreadType()) == null) {
                name = PbPostShareData.ThreadType.NORMAL.name();
            }
            pbPostShareData.p(PbPostShareData.i(name));
            MainThread mainThread4 = this.mainThread;
            if (mainThread4 != null) {
                str3 = mainThread4.getThreadShareUrl();
            }
            pbPostShareData.m(yz8.a(str3));
            PostThread postThread = this.postThread;
            if (postThread != null) {
                String username = postThread.getUsername();
                if (username != null) {
                    pbPostShareData.q(username);
                }
                List<Object> postList = postThread.getPostList();
                if (postList != null) {
                    pbPostShareData.n(TbRichTextView.Z(new JSONArray(DataExt.toJson(postList)), false));
                }
            }
            return pbPostShareData;
        }
        return (PbPostShareData) invokeV.objValue;
    }

    public final MainThread getMainThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mainThread;
        }
        return (MainThread) invokeV.objValue;
    }

    public final PostThread getPostThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.postThread;
        }
        return (PostThread) invokeV.objValue;
    }
}
