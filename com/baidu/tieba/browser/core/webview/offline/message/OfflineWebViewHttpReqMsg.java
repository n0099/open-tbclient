package com.baidu.tieba.browser.core.webview.offline.message;

import android.webkit.WebView;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class OfflineWebViewHttpReqMsg extends HttpMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long begin;
    public boolean isFromRequestByNative;
    public String jsCallbackMethod;
    public String module;
    public String url;
    public String urlSign;
    public WeakReference<WebView> webViewRef;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineWebViewHttpReqMsg() {
        super(CmdConfigHttp.CMD_WEB_HTTP_PROXY);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.url = null;
        this.module = null;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "QuickWebViewHttpReqMsg{url='" + this.url + "', module='" + this.module + "', begin=" + this.begin + ", jsCallbackMethod='" + this.jsCallbackMethod + "', isFromRequestByNative=" + this.isFromRequestByNative + '}';
        }
        return (String) invokeV.objValue;
    }
}
