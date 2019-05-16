package com.baidu.tieba.aiapps.apps.openstat.imupload;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.baidu.tieba.aiapps.apps.openstat.imupload.log.model.BIMLogPb;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;
import org.apache.http.protocol.HTTP;
/* loaded from: classes4.dex */
public class b {
    private static b dfy;
    private OkHttpClient dfx = aFA();

    public static b aFz() {
        if (dfy == null) {
            dfy = new b();
        }
        return dfy;
    }

    private b() {
    }

    public void a(@NonNull Map<String, String> map, @NonNull byte[] bArr, String str, c cVar) {
        if (cVar != null) {
            Request a2 = a(map, bArr, str, "" + ((int) ((Math.random() * 100000.0d) + 10000.0d)));
            if (this.dfx == null) {
                this.dfx = aFA();
            }
            try {
                Response execute = this.dfx.newCall(a2).execute();
                try {
                    if (execute.body() != null) {
                        String[] I = I(execute.body().bytes());
                        cVar.errorCode = Integer.valueOf(I[0]).intValue();
                        cVar.errMsg = I[1];
                    }
                } catch (IOException e) {
                }
            } catch (IOException e2) {
                String str2 = "Request error :" + e2.toString();
                if (e2 instanceof SocketException) {
                    str2 = "Request SocketException :" + e2.toString();
                }
                cVar.errorCode = -1;
                cVar.errMsg = str2;
            }
        }
    }

    @NonNull
    private OkHttpClient aFA() {
        return new OkHttpClient.Builder().protocols(Arrays.asList(Protocol.HTTP_2, Protocol.HTTP_1_1)).pingInterval(1000L, TimeUnit.MILLISECONDS).addInterceptor(new a()).connectTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).connectionPool(new ConnectionPool()).build();
    }

    @NonNull
    private Request a(@NonNull Map<String, String> map, @NonNull byte[] bArr, String str, String str2) {
        ArrayMap arrayMap = new ArrayMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayMap.put("ls-" + entry.getKey(), entry.getValue());
        }
        arrayMap.put("log-id", str2);
        return new Request.Builder().addHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE).addHeader("Content-Type", "application/proto").headers(Headers.of(arrayMap)).url("https://pimlog.baidu.com/LogService/Log").post(d(bArr, str)).build();
    }

    @NonNull
    private RequestBody d(@NonNull byte[] bArr, @NonNull String str) {
        return RequestBody.create(MediaType.parse("application/proto"), e(bArr, str));
    }

    @NonNull
    private byte[] e(@NonNull byte[] bArr, String str) {
        BIMLogPb.LogRequest.AuthInfo.a newBuilder = BIMLogPb.LogRequest.AuthInfo.newBuilder();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        BIMLogPb.LogRequest.AuthInfo build = newBuilder.sQ(str).build();
        long currentTimeMillis = System.currentTimeMillis();
        return BIMLogPb.LogRequest.newBuilder().bZ(1L).sR("smart_app").b(build).ca(currentTimeMillis).sS(com.baidu.tieba.aiapps.apps.openstat.imupload.a.p("smart_app", currentTimeMillis)).a(ByteString.copyFrom(bArr)).build().toByteArray();
    }

    @NonNull
    private String[] I(@NonNull byte[] bArr) {
        try {
            BIMLogPb.LogResponse parseFrom = BIMLogPb.LogResponse.parseFrom(bArr);
            if (this.dfx.pingIntervalMillis() != parseFrom.getPingIntervalMs()) {
                this.dfx.newBuilder().pingInterval(parseFrom.getPingIntervalMs(), TimeUnit.MILLISECONDS);
                this.dfx = this.dfx.newBuilder().pingInterval(parseFrom.getPingIntervalMs(), TimeUnit.MILLISECONDS).build();
            }
            return new String[]{String.valueOf(parseFrom.getErrorCode()), parseFrom.getErrorMsg()};
        } catch (InvalidProtocolBufferException e) {
            return new String[]{String.valueOf(-1), "parseResponse exception"};
        }
    }

    /* loaded from: classes4.dex */
    public class a implements Interceptor {
        public a() {
        }

        @Override // okhttp3.Interceptor
        public Response intercept(@NonNull Interceptor.Chain chain) throws IOException {
            Request request = chain.request();
            if (request.body() == null || request.header(HTTP.CONTENT_ENCODING) != null) {
                return chain.proceed(request);
            }
            return chain.proceed(request.newBuilder().header(HTTP.CONTENT_ENCODING, "gzip").method(request.method(), a(request.body())).build());
        }

        private RequestBody a(final RequestBody requestBody) {
            return new RequestBody() { // from class: com.baidu.tieba.aiapps.apps.openstat.imupload.b.a.1
                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return requestBody.contentType();
                }

                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return -1L;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(@NonNull BufferedSink bufferedSink) {
                    BufferedSink buffer = Okio.buffer(new GzipSink(bufferedSink));
                    try {
                        requestBody.writeTo(buffer);
                        buffer.close();
                    } catch (IOException e) {
                    }
                }
            };
        }
    }
}
