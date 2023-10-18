package com.baidu.tieba;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import org.java_websocket.WebSocket;
import org.java_websocket.drafts.Draft;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes5.dex */
public interface c5c {
    InetSocketAddress getLocalSocketAddress(WebSocket webSocket);

    InetSocketAddress getRemoteSocketAddress(WebSocket webSocket);

    void onWebsocketClose(WebSocket webSocket, int i, String str, boolean z);

    void onWebsocketCloseInitiated(WebSocket webSocket, int i, String str);

    void onWebsocketClosing(WebSocket webSocket, int i, String str, boolean z);

    void onWebsocketError(WebSocket webSocket, Exception exc);

    void onWebsocketHandshakeReceivedAsClient(WebSocket webSocket, q5c q5cVar, x5c x5cVar) throws InvalidDataException;

    y5c onWebsocketHandshakeReceivedAsServer(WebSocket webSocket, Draft draft, q5c q5cVar) throws InvalidDataException;

    void onWebsocketHandshakeSentAsClient(WebSocket webSocket, q5c q5cVar) throws InvalidDataException;

    void onWebsocketMessage(WebSocket webSocket, String str);

    void onWebsocketMessage(WebSocket webSocket, ByteBuffer byteBuffer);

    void onWebsocketOpen(WebSocket webSocket, v5c v5cVar);

    void onWebsocketPing(WebSocket webSocket, Framedata framedata);

    void onWebsocketPong(WebSocket webSocket, Framedata framedata);

    void onWriteDemand(WebSocket webSocket);
}
