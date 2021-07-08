package com.baidu.tieba.flutter.plugin.tiebaShare;

import androidx.core.view.InputDeviceCompat;
import androidx.transition.Transition;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class TiebaShareAuto {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class GameDetailsParam {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String content;
        public String iconUrl;
        public String itemId;
        public String itemName;
        public String url;

        public GameDetailsParam() {
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

        public static GameDetailsParam fromMap(HashMap hashMap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hashMap)) == null) {
                GameDetailsParam gameDetailsParam = new GameDetailsParam();
                gameDetailsParam.url = (String) hashMap.get("url");
                gameDetailsParam.itemId = (String) hashMap.get(Transition.MATCH_ITEM_ID_STR);
                gameDetailsParam.itemName = (String) hashMap.get("itemName");
                gameDetailsParam.content = (String) hashMap.get("content");
                gameDetailsParam.iconUrl = (String) hashMap.get("iconUrl");
                return gameDetailsParam;
            }
            return (GameDetailsParam) invokeL.objValue;
        }

        public String getContent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.content : (String) invokeV.objValue;
        }

        public String getIconUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.iconUrl : (String) invokeV.objValue;
        }

        public String getItemId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.itemId : (String) invokeV.objValue;
        }

        public String getItemName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.itemName : (String) invokeV.objValue;
        }

        public String getUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.url : (String) invokeV.objValue;
        }

        public void setContent(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                this.content = str;
            }
        }

        public void setIconUrl(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                this.iconUrl = str;
            }
        }

        public void setItemId(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
                this.itemId = str;
            }
        }

        public void setItemName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
                this.itemName = str;
            }
        }

        public void setUrl(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
                this.url = str;
            }
        }

        public HashMap toMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("url", this.url);
                hashMap.put(Transition.MATCH_ITEM_ID_STR, this.itemId);
                hashMap.put("itemName", this.itemName);
                hashMap.put("content", this.content);
                hashMap.put("iconUrl", this.iconUrl);
                return hashMap;
            }
            return (HashMap) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public interface HostTiebaShare {
        void shareGameItemDetails(GameDetailsParam gameDetailsParam);

        void shareThread(ShareThreadParam shareThreadParam);
    }

    /* loaded from: classes4.dex */
    public static class ShareThreadParam {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HashMap threadInfo;

        public ShareThreadParam() {
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

        public static ShareThreadParam fromMap(HashMap hashMap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hashMap)) == null) {
                ShareThreadParam shareThreadParam = new ShareThreadParam();
                shareThreadParam.threadInfo = (HashMap) hashMap.get("threadInfo");
                return shareThreadParam;
            }
            return (ShareThreadParam) invokeL.objValue;
        }

        public HashMap getThreadInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.threadInfo : (HashMap) invokeV.objValue;
        }

        public void setThreadInfo(HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap) == null) {
                this.threadInfo = hashMap;
            }
        }

        public HashMap toMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("threadInfo", this.threadInfo);
                return hashMap;
            }
            return (HashMap) invokeV.objValue;
        }
    }

    public TiebaShareAuto() {
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

    public static HashMap wrapError(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, exc)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("message", exc.toString());
            hashMap.put("code", exc.getClass().getSimpleName());
            hashMap.put("details", null);
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}
