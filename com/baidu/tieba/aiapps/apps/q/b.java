package com.baidu.tieba.aiapps.apps.q;

import android.text.TextUtils;
import android.webkit.CookieManager;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.cookie.SM;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.params.AbstractHttpParams;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
/* loaded from: classes4.dex */
public class b implements e {
    private static final MediaType djF = MediaType.parse("application/octet-stream");
    private OkHttpClient client;
    private OkHttpClient.Builder djG = null;
    private OkHttpClient djH = null;
    private final HttpParams params = new AbstractHttpParams() { // from class: com.baidu.tieba.aiapps.apps.q.b.1
        @Override // org.apache.http.params.HttpParams
        public Object getParameter(String str) {
            Proxy proxy;
            if (str.equals(ConnRoutePNames.DEFAULT_PROXY)) {
                if (b.this.djH != null) {
                    proxy = b.this.djH.proxy();
                } else {
                    proxy = b.this.aIm().proxy();
                }
                if (proxy == null) {
                    return null;
                }
                InetSocketAddress inetSocketAddress = (InetSocketAddress) proxy.address();
                return new HttpHost(inetSocketAddress.getHostName(), inetSocketAddress.getPort());
            } else if (str.equals(CoreConnectionPNames.CONNECTION_TIMEOUT)) {
                int connectTimeoutMillis = b.this.aIm().connectTimeoutMillis();
                if (b.this.djH != null) {
                    connectTimeoutMillis = b.this.djH.connectTimeoutMillis();
                }
                return Integer.valueOf(connectTimeoutMillis);
            } else if (str.equals(CoreConnectionPNames.SO_TIMEOUT)) {
                int readTimeoutMillis = b.this.aIm().readTimeoutMillis();
                if (b.this.djH != null) {
                    readTimeoutMillis = b.this.djH.readTimeoutMillis();
                }
                return Integer.valueOf(readTimeoutMillis);
            } else if (str.equals(ClientPNames.HANDLE_REDIRECTS)) {
                boolean followRedirects = b.this.aIm().followRedirects();
                if (b.this.djH != null) {
                    followRedirects = b.this.djH.followRedirects();
                }
                return Boolean.valueOf(followRedirects);
            } else if (str.equals(CoreProtocolPNames.USER_AGENT)) {
                return b.this.userAgent;
            } else {
                if (str.equals(ClientPNames.CONNECTION_MANAGER_FACTORY) || str.equals(ClientPNames.CONNECTION_MANAGER_FACTORY_CLASS_NAME)) {
                    return null;
                }
                throw new IllegalArgumentException(str);
            }
        }

        @Override // org.apache.http.params.HttpParams
        public HttpParams setParameter(String str, Object obj) {
            if (str.equals(ConnRoutePNames.DEFAULT_PROXY)) {
                HttpHost httpHost = (HttpHost) obj;
                Proxy proxy = null;
                if (httpHost != null) {
                    proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(httpHost.getHostName(), httpHost.getPort()));
                }
                b.this.aIn().proxy(proxy);
            } else if (str.equals(CoreConnectionPNames.CONNECTION_TIMEOUT)) {
                b.this.aIn().connectTimeout(((Integer) obj).intValue(), TimeUnit.MILLISECONDS);
            } else if (str.equals(CoreConnectionPNames.SO_TIMEOUT)) {
                int intValue = ((Integer) obj).intValue();
                b.this.aIn().readTimeout(intValue, TimeUnit.MILLISECONDS).writeTimeout(intValue, TimeUnit.MILLISECONDS);
            } else if (str.equals(ClientPNames.HANDLE_REDIRECTS)) {
                boolean booleanValue = ((Boolean) obj).booleanValue();
                b.this.aIn().followRedirects(booleanValue).followSslRedirects(booleanValue);
            } else if (str.equals(CoreProtocolPNames.USER_AGENT)) {
                b.this.userAgent = (String) obj;
            } else {
                throw new IllegalArgumentException(str);
            }
            return this;
        }

        @Override // org.apache.http.params.HttpParams
        public HttpParams copy() {
            throw new UnsupportedOperationException();
        }

        @Override // org.apache.http.params.HttpParams
        public boolean removeParameter(String str) {
            throw new UnsupportedOperationException();
        }
    };
    private String userAgent;

    public b() {
        aIl();
    }

    protected void aIl() {
        this.client = HttpManager.getDefault(AppRuntime.getAppContext()).getOkHttpClient();
    }

    protected OkHttpClient aIm() {
        return this.client;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public OkHttpClient.Builder aIn() {
        if (this.djG == null) {
            this.djG = aIm().newBuilder();
        }
        return this.djG;
    }

    private Request a(HttpRequest httpRequest) {
        RequestBody requestBody;
        String str;
        Request.Builder builder = new Request.Builder();
        RequestLine requestLine = httpRequest.getRequestLine();
        String method = requestLine.getMethod();
        String uri = requestLine.getUri();
        builder.url(uri);
        Header[] allHeaders = httpRequest.getAllHeaders();
        int length = allHeaders.length;
        int i = 0;
        String str2 = null;
        while (i < length) {
            Header header = allHeaders[i];
            String name = header.getName();
            if ("Content-Type".equalsIgnoreCase(name)) {
                str = header.getValue();
            } else {
                builder.header(name, header.getValue());
                str = str2;
            }
            i++;
            str2 = str;
        }
        HttpParams params = httpRequest.getParams();
        if (params != null) {
            if (params.getParameter(CoreProtocolPNames.USER_AGENT) != null) {
                this.userAgent = (String) params.getParameter(CoreProtocolPNames.USER_AGENT);
                builder.header(HTTP.USER_AGENT, this.userAgent);
            } else if (params.getParameter(ClientPNames.COOKIE_POLICY) != null && params.getParameter(ClientPNames.COOKIE_POLICY) == CookiePolicy.BROWSER_COMPATIBILITY) {
                String cookie = CookieManager.getInstance().getCookie(uri);
                if (!TextUtils.isEmpty(cookie)) {
                    builder.addHeader(SM.COOKIE, cookie);
                }
            }
        }
        if (httpRequest instanceof HttpEntityEnclosingRequest) {
            HttpEntity entity = ((HttpEntityEnclosingRequest) httpRequest).getEntity();
            if (entity != null) {
                requestBody = new a(entity, str2);
                Header contentEncoding = entity.getContentEncoding();
                if (contentEncoding != null) {
                    builder.header(contentEncoding.getName(), contentEncoding.getValue());
                }
            } else {
                requestBody = RequestBody.create((MediaType) null, new byte[0]);
            }
        } else {
            requestBody = null;
        }
        builder.tag(httpRequest);
        return builder.method(method, requestBody).build();
    }

    private HttpResponse a(Response response) throws IOException {
        int code = response.code();
        String message = response.message();
        ProtocolVersion protocolVersion = HttpVersion.HTTP_1_1;
        if (response.protocol().equals(Protocol.HTTP_2)) {
            protocolVersion = new ProtocolVersion(Config.EVENT_NATIVE_VIEW_HIERARCHY, 2, 0);
        } else if (response.protocol().equals(Protocol.SPDY_3)) {
            protocolVersion = new ProtocolVersion("spdy", 3, 1);
        }
        BasicHttpResponse basicHttpResponse = new BasicHttpResponse(protocolVersion, code, message);
        ResponseBody body = response.body();
        InputStreamEntity inputStreamEntity = new InputStreamEntity(body.byteStream(), body.contentLength());
        basicHttpResponse.setEntity(inputStreamEntity);
        Headers headers = response.headers();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            String name = headers.name(i);
            String value = headers.value(i);
            basicHttpResponse.addHeader(name, value);
            if ("Content-Type".equalsIgnoreCase(name)) {
                inputStreamEntity.setContentType(value);
            } else if (HTTP.CONTENT_ENCODING.equalsIgnoreCase(name)) {
                inputStreamEntity.setContentEncoding(value);
            }
        }
        return basicHttpResponse;
    }

    @Override // com.baidu.tieba.aiapps.apps.q.e
    public HttpResponse b(HttpUriRequest httpUriRequest) throws ClientProtocolException, IOException {
        return execute(httpUriRequest);
    }

    @Override // com.baidu.tieba.aiapps.apps.q.e
    public void close() {
    }

    public void aIo() throws IOException {
    }

    @Override // org.apache.http.client.HttpClient
    public HttpParams getParams() {
        return this.params;
    }

    @Override // org.apache.http.client.HttpClient
    public ClientConnectionManager getConnectionManager() {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.http.client.HttpClient
    public HttpResponse execute(HttpUriRequest httpUriRequest) throws IOException {
        return execute((HttpHost) null, httpUriRequest, (HttpContext) null);
    }

    @Override // org.apache.http.client.HttpClient
    public HttpResponse execute(HttpUriRequest httpUriRequest, HttpContext httpContext) throws IOException {
        return execute((HttpHost) null, httpUriRequest, httpContext);
    }

    @Override // org.apache.http.client.HttpClient
    public HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest) throws IOException {
        return execute(httpHost, httpRequest, (HttpContext) null);
    }

    @Override // org.apache.http.client.HttpClient
    public HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException {
        Call newCall;
        aIo();
        Request a2 = a(httpRequest);
        if (this.djG == null) {
            newCall = aIm().newCall(a2);
        } else {
            this.djH = this.djG.build();
            newCall = this.djH.newCall(a2);
        }
        return a(newCall.execute());
    }

    @Override // org.apache.http.client.HttpClient
    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler) throws IOException {
        return (T) execute(null, httpUriRequest, responseHandler, null);
    }

    @Override // org.apache.http.client.HttpClient
    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException {
        return (T) execute(null, httpUriRequest, responseHandler, httpContext);
    }

    @Override // org.apache.http.client.HttpClient
    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) throws IOException {
        return (T) execute(httpHost, httpRequest, responseHandler, null);
    }

    @Override // org.apache.http.client.HttpClient
    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException {
        HttpResponse execute = execute(httpHost, httpRequest, httpContext);
        try {
            return responseHandler.handleResponse(execute);
        } finally {
            c(execute);
        }
    }

    private static void c(HttpResponse httpResponse) {
        try {
            httpResponse.getEntity().consumeContent();
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a extends RequestBody {
        private final HttpEntity djJ;
        private final MediaType mediaType;

        a(HttpEntity httpEntity, String str) {
            this.djJ = httpEntity;
            if (str != null) {
                this.mediaType = MediaType.parse(str);
            } else if (httpEntity.getContentType() == null) {
                this.mediaType = b.djF;
            } else {
                this.mediaType = MediaType.parse(httpEntity.getContentType().getValue());
            }
        }

        @Override // okhttp3.RequestBody
        public long contentLength() {
            return this.djJ.getContentLength();
        }

        @Override // okhttp3.RequestBody
        public MediaType contentType() {
            return this.mediaType;
        }

        @Override // okhttp3.RequestBody
        public void writeTo(BufferedSink bufferedSink) throws IOException {
            this.djJ.writeTo(bufferedSink.outputStream());
        }
    }
}
