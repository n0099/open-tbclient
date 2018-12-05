package com.baidu.tieba.aiapps.apps.p;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
/* loaded from: classes4.dex */
public interface e extends HttpClient {
    void close();

    HttpResponse executeSafely(HttpUriRequest httpUriRequest) throws ClientProtocolException, IOException;
}
