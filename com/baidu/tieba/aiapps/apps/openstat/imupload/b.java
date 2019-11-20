package com.baidu.tieba.aiapps.apps.openstat.imupload;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.baidu.android.imsdk.upload.action.IMPushUploadConstants;
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
    private static b dry;
    private OkHttpClient mOkHttpClient = createOkHttpClient();

    public static b aHP() {
        if (dry == null) {
            dry = new b();
        }
        return dry;
    }

    private b() {
    }

    public void a(@NonNull Map<String, String> map, @NonNull byte[] bArr, String str, c cVar) {
        if (cVar != null) {
            Request a2 = a(map, bArr, str, "" + ((int) ((Math.random() * 100000.0d) + 10000.0d)));
            if (this.mOkHttpClient == null) {
                this.mOkHttpClient = createOkHttpClient();
            }
            try {
                Response execute = this.mOkHttpClient.newCall(a2).execute();
                try {
                    if (execute.body() != null) {
                        String[] parseResponse = parseResponse(execute.body().bytes());
                        cVar.errorCode = Integer.valueOf(parseResponse[0]).intValue();
                        cVar.errMsg = parseResponse[1];
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
    private OkHttpClient createOkHttpClient() {
        return new OkHttpClient.Builder().protocols(Arrays.asList(Protocol.HTTP_2, Protocol.HTTP_1_1)).pingInterval(1000L, TimeUnit.MILLISECONDS).addInterceptor(new a()).connectTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).connectionPool(new ConnectionPool()).build();
    }

    @NonNull
    private Request a(@NonNull Map<String, String> map, @NonNull byte[] bArr, String str, String str2) {
        ArrayMap arrayMap = new ArrayMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayMap.put("ls-" + entry.getKey(), entry.getValue());
        }
        arrayMap.put(IMPushUploadConstants.BIM_LOG_ID, str2);
        return new Request.Builder().addHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE).addHeader("Content-Type", "application/proto").headers(Headers.of(arrayMap)).url("https://pimlog.baidu.com/LogService/Log").post(convertRequestBody(bArr, str)).build();
    }

    @NonNull
    private RequestBody convertRequestBody(@NonNull byte[] bArr, @NonNull String str) {
        return RequestBody.create(MediaType.parse("application/proto"), createLogRequestContent(bArr, str));
    }

    @NonNull
    private byte[] createLogRequestContent(@NonNull byte[] bArr, String str) {
        BIMLogPb.LogRequest.AuthInfo.a newBuilder = BIMLogPb.LogRequest.AuthInfo.newBuilder();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        BIMLogPb.LogRequest.AuthInfo build = newBuilder.su(str).build();
        long currentTimeMillis = System.currentTimeMillis();
        return BIMLogPb.LogRequest.newBuilder().bR(1L).sv("smart_app").b(build).bS(currentTimeMillis).sw(com.baidu.tieba.aiapps.apps.openstat.imupload.a.t("smart_app", currentTimeMillis)).a(ByteString.copyFrom(bArr)).build().toByteArray();
    }

    @NonNull
    private String[] parseResponse(@NonNull byte[] bArr) {
        try {
            BIMLogPb.LogResponse parseFrom = BIMLogPb.LogResponse.parseFrom(bArr);
            if (this.mOkHttpClient.pingIntervalMillis() != parseFrom.getPingIntervalMs()) {
                this.mOkHttpClient.newBuilder().pingInterval(parseFrom.getPingIntervalMs(), TimeUnit.MILLISECONDS);
                this.mOkHttpClient = this.mOkHttpClient.newBuilder().pingInterval(parseFrom.getPingIntervalMs(), TimeUnit.MILLISECONDS).build();
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
            return chain.proceed(request.newBuilder().header(HTTP.CONTENT_ENCODING, "gzip").method(request.method(), gzip(request.body())).build());
        }

        private RequestBody gzip(final RequestBody requestBody) {
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
