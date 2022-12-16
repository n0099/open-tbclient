package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.java_websocket.WebSocket;
import org.java_websocket.drafts.Draft;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes4.dex */
public abstract class h0a implements j0a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.j0a
    public void onWebsocketHandshakeReceivedAsClient(WebSocket webSocket, x0a x0aVar, e1a e1aVar) throws InvalidDataException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, webSocket, x0aVar, e1aVar) == null) {
        }
    }

    @Override // com.baidu.tieba.j0a
    public void onWebsocketHandshakeSentAsClient(WebSocket webSocket, x0a x0aVar) throws InvalidDataException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webSocket, x0aVar) == null) {
        }
    }

    @Deprecated
    public abstract void onWebsocketMessageFragment(WebSocket webSocket, Framedata framedata);

    @Override // com.baidu.tieba.j0a
    public void onWebsocketPong(WebSocket webSocket, Framedata framedata) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, webSocket, framedata) == null) {
        }
    }

    public h0a() {
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

    @Override // com.baidu.tieba.j0a
    public f1a onWebsocketHandshakeReceivedAsServer(WebSocket webSocket, Draft draft, x0a x0aVar) throws InvalidDataException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webSocket, draft, x0aVar)) == null) {
            return new b1a();
        }
        return (f1a) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.j0a
    public void onWebsocketPing(WebSocket webSocket, Framedata framedata) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, webSocket, framedata) == null) {
            webSocket.sendFrame(new v0a((u0a) framedata));
        }
    }
}
