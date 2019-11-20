package com.baidu.tieba.aiapps.apps.q;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.ubc.UBC;
import com.baidu.ubc.m;
import com.tencent.connect.common.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements m {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.ubc.m
    public boolean a(String str, JSONObject jSONObject, boolean z) {
        String sh = com.baidu.tieba.aiapps.apps.c.d.sh(str + "/tcbox?action=ubc");
        HttpPost httpPost = new HttpPost(sh);
        if (DEBUG) {
            Log.d("UploadManager", sh);
        }
        httpPost.setEntity(bH(jSONObject));
        httpPost.setHeader("Content-type", URLEncodedUtils.CONTENT_TYPE);
        b bVar = new b();
        String bI = bI(jSONObject);
        try {
            try {
                return b(bVar.executeSafely(httpPost), bI);
            } catch (Exception e) {
                if (DEBUG) {
                    Log.d("UploadManager", "requestToServer e:" + e.getMessage());
                }
                if (!DEBUG) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("type", "sendFail");
                        if (!TextUtils.isEmpty(bI)) {
                            jSONObject2.put("md5", bI);
                        }
                        jSONObject2.put("exception", Log.getStackTraceString(e));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    UBC.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, jSONObject2.toString());
                }
                bVar.close();
                return false;
            }
        } finally {
            bVar.close();
        }
    }

    private AbstractHttpEntity bH(JSONObject jSONObject) {
        UrlEncodedFormEntity urlEncodedFormEntity;
        ArrayList arrayList = new ArrayList();
        byte[] x = c.x(jSONObject.toString().getBytes());
        x[0] = 117;
        x[1] = 123;
        arrayList.add(new BasicNameValuePair("data", Base64.encodeToString(x, 0)));
        try {
            urlEncodedFormEntity = new UrlEncodedFormEntity(arrayList, "utf-8");
            try {
                urlEncodedFormEntity.setContentType(URLEncodedUtils.CONTENT_TYPE);
            } catch (UnsupportedEncodingException e) {
                if (DEBUG) {
                    Log.d("UploadManager", "UrlEncodedFormEntity error");
                }
                return urlEncodedFormEntity;
            }
        } catch (UnsupportedEncodingException e2) {
            urlEncodedFormEntity = null;
        }
        return urlEncodedFormEntity;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:105:0x0021 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:55:0x00f5 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:82:0x01a3 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r2v9 */
    private boolean b(HttpResponse httpResponse, String str) {
        HttpEntity entity;
        InputStream inputStream;
        boolean z = false;
        if (httpResponse != null && httpResponse.getStatusLine() != null) {
            ?? r2 = 200;
            if (httpResponse.getStatusLine().getStatusCode() == 200 && (entity = httpResponse.getEntity()) != null) {
                try {
                    inputStream = entity.getContent();
                } catch (Exception e) {
                    boolean z2 = DEBUG;
                    boolean z3 = z2;
                    if (z2) {
                        Log.d("UploadManager", "get content fail:" + e.getMessage());
                        z3 = "UploadManager";
                    }
                    inputStream = null;
                    r2 = z3;
                }
                try {
                    if (inputStream != null) {
                        try {
                            r2 = new ByteArrayOutputStream();
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    try {
                                        int read = inputStream.read(bArr, 0, 1024);
                                        if (read <= 0) {
                                            break;
                                        }
                                        r2.write(bArr, 0, read);
                                    } catch (IOException e2) {
                                        if (DEBUG) {
                                            Log.d("UploadManager", "connect error");
                                        }
                                    }
                                }
                                int i = new JSONObject(new String(r2.toByteArray())).getInt(BdStatsConstant.StatsType.ERROR);
                                if (i != 0) {
                                    if (DEBUG) {
                                        Log.d("UploadManager", "server error");
                                    }
                                    if (!DEBUG) {
                                        JSONObject jSONObject = new JSONObject();
                                        try {
                                            jSONObject.put("type", "sendFail");
                                            jSONObject.put("error_no", i);
                                            if (!TextUtils.isEmpty(str)) {
                                                jSONObject.put("md5", str);
                                            }
                                        } catch (JSONException e3) {
                                            e3.printStackTrace();
                                        }
                                        UBC.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, jSONObject.toString());
                                    }
                                }
                                z = true;
                                try {
                                    inputStream.close();
                                } catch (IOException e4) {
                                    if (DEBUG) {
                                        Log.d("UploadManager", "close error:" + e4.getMessage());
                                    }
                                }
                                if (r2 != 0) {
                                    try {
                                        r2.close();
                                    } catch (IOException e5) {
                                        if (DEBUG) {
                                            Log.d("UploadManager", "close baOs error:" + e5.getMessage());
                                        }
                                    }
                                }
                            } catch (Exception e6) {
                                e = e6;
                                if (DEBUG) {
                                    Log.d("UploadManager", "server error:" + e.getMessage());
                                }
                                if (!DEBUG) {
                                    JSONObject jSONObject2 = new JSONObject();
                                    try {
                                        jSONObject2.put("type", "sendFail");
                                        if (!TextUtils.isEmpty(str)) {
                                            jSONObject2.put("md5", str);
                                        }
                                        jSONObject2.put("exception", Log.getStackTraceString(e));
                                    } catch (JSONException e7) {
                                        e7.printStackTrace();
                                    }
                                    UBC.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, jSONObject2.toString());
                                }
                                try {
                                    inputStream.close();
                                } catch (IOException e8) {
                                    if (DEBUG) {
                                        Log.d("UploadManager", "close error:" + e8.getMessage());
                                    }
                                }
                                if (r2 != 0) {
                                    try {
                                        r2.close();
                                    } catch (IOException e9) {
                                        if (DEBUG) {
                                            Log.d("UploadManager", "close baOs error:" + e9.getMessage());
                                        }
                                    }
                                }
                                return z;
                            }
                        } catch (Exception e10) {
                            e = e10;
                            r2 = 0;
                        } catch (Throwable th) {
                            th = th;
                            r2 = 0;
                            try {
                                inputStream.close();
                            } catch (IOException e11) {
                                if (DEBUG) {
                                    Log.d("UploadManager", "close error:" + e11.getMessage());
                                }
                            }
                            if (r2 != 0) {
                                try {
                                    r2.close();
                                } catch (IOException e12) {
                                    if (DEBUG) {
                                        Log.d("UploadManager", "close baOs error:" + e12.getMessage());
                                    }
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        return z;
    }

    private String bI(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has("metadata")) {
            return "";
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("metadata");
            if (jSONObject2 == null || !jSONObject2.has("md5")) {
                return "";
            }
            return jSONObject2.getString("md5");
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
