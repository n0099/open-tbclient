package com.baidu.tieba.flutter.plugin.tiebaUtility;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class TiebaUtilityOpenPageAuto {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface HostUtilityOpenPage {
        void accessFollowService(PageStringValue pageStringValue);

        void accessLiveCenterService(PageStringValue pageStringValue);

        void accessWalletService(PageStringValue pageStringValue);

        void goToActivityCenter();

        void goToGameCenter();

        void goToMainTabRefresh(ToWhereParam toWhereParam);

        void goToSearch(SearchParam searchParam);

        void goToSendThread(SendThreadParam sendThreadParam);

        void goToSignIn(SignInParam signInParam);

        void goToTeenagerMode();

        void openAppStore(PageStringValue pageStringValue, Result<OpenPageBoolResult> result);

        void openBBASMAppForItem(SMAppMapParam sMAppMapParam);

        void openBBASMAppForUrl(PageStringValue pageStringValue);

        void postSignProcess(SignProcessParam signProcessParam);

        void redirectTo(PageStringValue pageStringValue);

        void shareFrs(PageStringValue pageStringValue);
    }

    /* loaded from: classes5.dex */
    public static class OpenPageBoolResult {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Boolean result;

        public OpenPageBoolResult() {
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

        public static OpenPageBoolResult fromMap(HashMap hashMap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hashMap)) == null) {
                OpenPageBoolResult openPageBoolResult = new OpenPageBoolResult();
                openPageBoolResult.result = (Boolean) hashMap.get("result");
                return openPageBoolResult;
            }
            return (OpenPageBoolResult) invokeL.objValue;
        }

        public Boolean getResult() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.result : (Boolean) invokeV.objValue;
        }

        public void setResult(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                this.result = bool;
            }
        }

        public HashMap toMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("result", this.result);
                return hashMap;
            }
            return (HashMap) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class PageStringValue {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String result;

        public PageStringValue() {
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

        public static PageStringValue fromMap(HashMap hashMap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hashMap)) == null) {
                PageStringValue pageStringValue = new PageStringValue();
                pageStringValue.result = (String) hashMap.get("result");
                return pageStringValue;
            }
            return (PageStringValue) invokeL.objValue;
        }

        public String getResult() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.result : (String) invokeV.objValue;
        }

        public void setResult(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.result = str;
            }
        }

        public HashMap toMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("result", this.result);
                return hashMap;
            }
            return (HashMap) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public interface Result<T> {
        void success(T t);
    }

    /* loaded from: classes5.dex */
    public static class SMAppMapParam {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HashMap result;

        public SMAppMapParam() {
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

        public static SMAppMapParam fromMap(HashMap hashMap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hashMap)) == null) {
                SMAppMapParam sMAppMapParam = new SMAppMapParam();
                sMAppMapParam.result = (HashMap) hashMap.get("result");
                return sMAppMapParam;
            }
            return (SMAppMapParam) invokeL.objValue;
        }

        public HashMap getResult() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.result : (HashMap) invokeV.objValue;
        }

        public void setResult(HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap) == null) {
                this.result = hashMap;
            }
        }

        public HashMap toMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("result", this.result);
                return hashMap;
            }
            return (HashMap) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class SearchParam {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String search;
        public String searchValue;

        public SearchParam() {
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

        public static SearchParam fromMap(HashMap hashMap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hashMap)) == null) {
                SearchParam searchParam = new SearchParam();
                searchParam.search = (String) hashMap.get("search");
                searchParam.searchValue = (String) hashMap.get(SquareSearchActivityConfig.SEARCH_VALUE);
                return searchParam;
            }
            return (SearchParam) invokeL.objValue;
        }

        public String getSearch() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.search : (String) invokeV.objValue;
        }

        public String getSearchValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.searchValue : (String) invokeV.objValue;
        }

        public void setSearch(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.search = str;
            }
        }

        public void setSearchValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.searchValue = str;
            }
        }

        public HashMap toMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("search", this.search);
                hashMap.put(SquareSearchActivityConfig.SEARCH_VALUE, this.searchValue);
                return hashMap;
            }
            return (HashMap) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class SendThreadParam {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Double dx;
        public Double dy;
        public Double height;
        public Double width;

        public SendThreadParam() {
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

        public static SendThreadParam fromMap(HashMap hashMap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hashMap)) == null) {
                SendThreadParam sendThreadParam = new SendThreadParam();
                sendThreadParam.dx = (Double) hashMap.get("dx");
                sendThreadParam.dy = (Double) hashMap.get("dy");
                sendThreadParam.width = (Double) hashMap.get("width");
                sendThreadParam.height = (Double) hashMap.get("height");
                return sendThreadParam;
            }
            return (SendThreadParam) invokeL.objValue;
        }

        public Double getDx() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.dx : (Double) invokeV.objValue;
        }

        public Double getDy() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.dy : (Double) invokeV.objValue;
        }

        public Double getHeight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.height : (Double) invokeV.objValue;
        }

        public Double getWidth() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.width : (Double) invokeV.objValue;
        }

        public void setDx(Double d2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, d2) == null) {
                this.dx = d2;
            }
        }

        public void setDy(Double d2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, d2) == null) {
                this.dy = d2;
            }
        }

        public void setHeight(Double d2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, d2) == null) {
                this.height = d2;
            }
        }

        public void setWidth(Double d2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, d2) == null) {
                this.width = d2;
            }
        }

        public HashMap toMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("dx", this.dx);
                hashMap.put("dy", this.dy);
                hashMap.put("width", this.width);
                hashMap.put("height", this.height);
                return hashMap;
            }
            return (HashMap) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class SignInParam {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String msignText;
        public String msignValid;

        public SignInParam() {
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

        public static SignInParam fromMap(HashMap hashMap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hashMap)) == null) {
                SignInParam signInParam = new SignInParam();
                signInParam.msignValid = (String) hashMap.get("msignValid");
                signInParam.msignText = (String) hashMap.get("msignText");
                return signInParam;
            }
            return (SignInParam) invokeL.objValue;
        }

        public String getMsignText() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.msignText : (String) invokeV.objValue;
        }

        public String getMsignValid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.msignValid : (String) invokeV.objValue;
        }

        public void setMsignText(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.msignText = str;
            }
        }

        public void setMsignValid(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.msignValid = str;
            }
        }

        public HashMap toMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("msignValid", this.msignValid);
                hashMap.put("msignText", this.msignText);
                return hashMap;
            }
            return (HashMap) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class SignProcessParam {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String bannerHyperLink;
        public String bannerImageUrl;
        public Boolean isVipMember;

        public SignProcessParam() {
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

        public static SignProcessParam fromMap(HashMap hashMap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hashMap)) == null) {
                SignProcessParam signProcessParam = new SignProcessParam();
                signProcessParam.bannerImageUrl = (String) hashMap.get("bannerImageUrl");
                signProcessParam.bannerHyperLink = (String) hashMap.get("bannerHyperLink");
                signProcessParam.isVipMember = (Boolean) hashMap.get("isVipMember");
                return signProcessParam;
            }
            return (SignProcessParam) invokeL.objValue;
        }

        public String getBannerHyperLink() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.bannerHyperLink : (String) invokeV.objValue;
        }

        public String getBannerImageUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.bannerImageUrl : (String) invokeV.objValue;
        }

        public Boolean getIsVipMember() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.isVipMember : (Boolean) invokeV.objValue;
        }

        public void setBannerHyperLink(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.bannerHyperLink = str;
            }
        }

        public void setBannerImageUrl(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.bannerImageUrl = str;
            }
        }

        public void setIsVipMember(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, bool) == null) {
                this.isVipMember = bool;
            }
        }

        public HashMap toMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("bannerImageUrl", this.bannerImageUrl);
                hashMap.put("bannerHyperLink", this.bannerHyperLink);
                hashMap.put("isVipMember", this.isVipMember);
                return hashMap;
            }
            return (HashMap) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class ToWhereParam {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Long result;

        public ToWhereParam() {
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

        public static ToWhereParam fromMap(HashMap hashMap) {
            InterceptResult invokeL;
            Long valueOf;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hashMap)) == null) {
                ToWhereParam toWhereParam = new ToWhereParam();
                Object obj = hashMap.get("result");
                if (obj == null) {
                    valueOf = null;
                } else {
                    valueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
                }
                toWhereParam.result = valueOf;
                return toWhereParam;
            }
            return (ToWhereParam) invokeL.objValue;
        }

        public Long getResult() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.result : (Long) invokeV.objValue;
        }

        public void setResult(Long l) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l) == null) {
                this.result = l;
            }
        }

        public HashMap toMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("result", this.result);
                return hashMap;
            }
            return (HashMap) invokeV.objValue;
        }
    }

    public TiebaUtilityOpenPageAuto() {
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
