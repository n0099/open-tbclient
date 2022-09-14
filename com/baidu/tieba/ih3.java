package com.baidu.tieba;

import android.text.TextUtils;
import android.util.AtomicFile;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ih3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Removed duplicated region for block: B:101:0x015e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0158 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0149  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(@NonNull JSONArray jSONArray, @NonNull File file, int i) {
        InterceptResult invokeLLI;
        FileOutputStream fileOutputStream;
        FileChannel fileChannel;
        FileLock fileLock;
        AtomicFile atomicFile;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLI = interceptable.invokeLLI(65536, null, jSONArray, file, i)) != null) {
            return invokeLLI.booleanValue;
        }
        StringBuilder sb = new StringBuilder();
        AtomicFile atomicFile2 = null;
        r1 = null;
        FileLock fileLock2 = null;
        FileChannel fileChannel2 = null;
        try {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                SparseArray sparseArray = new SparseArray(i);
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < i; i2++) {
                    arrayList.add(bufferedReader.readLine());
                }
                for (int i3 = 0; i3 < i; i3++) {
                    String str = (String) arrayList.get(i3);
                    if (TextUtils.isEmpty(str) || (optJSONArray = new JSONObject(str).optJSONArray("descriptions")) == null) {
                        return false;
                    }
                    HashMap hashMap = new HashMap();
                    for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                        JSONObject jSONObject = (JSONObject) optJSONArray.get(i4);
                        hashMap.put(jSONObject.optString("name"), jSONObject);
                    }
                    sparseArray.put(i3, hashMap);
                }
                for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(i5);
                    String optString = jSONObject2.optString("name");
                    int i6 = 0;
                    while (true) {
                        if (i6 >= i) {
                            break;
                        } else if (((Map) sparseArray.get(i6)).containsKey(optString)) {
                            ((Map) sparseArray.get(i6)).put(optString, jSONObject2);
                            break;
                        } else {
                            if (i6 == i - 1) {
                                ((Map) sparseArray.get(i6)).put(optString, jSONObject2);
                            }
                            i6++;
                        }
                    }
                }
                for (int i7 = 0; i7 < i; i7++) {
                    JSONObject jSONObject3 = new JSONObject((String) arrayList.get(i7));
                    JSONArray jSONArray2 = new JSONArray();
                    jSONObject3.optJSONArray("descriptions");
                    for (Map.Entry entry : ((Map) sparseArray.get(i7)).entrySet()) {
                        jSONArray2.put(entry.getValue());
                    }
                    jSONObject3.put("descriptions", jSONArray2);
                    if (i7 != i - 1) {
                        sb.append(jSONObject3.toString());
                        sb.append("\n");
                    } else {
                        sb.append(jSONObject3.toString());
                    }
                }
                bufferedReader.close();
                atomicFile = new AtomicFile(file);
                try {
                    atomicFile.startWrite();
                    fileOutputStream = atomicFile.startWrite();
                    try {
                        fileChannel = fileOutputStream.getChannel();
                    } catch (IOException | JSONException unused) {
                        fileChannel = null;
                        fileLock = fileChannel;
                        atomicFile2 = atomicFile;
                        if (atomicFile2 != null) {
                            if (fileLock != null) {
                                try {
                                    fileLock.release();
                                } catch (IOException unused2) {
                                }
                            }
                            atomicFile2.failWrite(fileOutputStream);
                        }
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                            } catch (IOException unused3) {
                            }
                        }
                        return false;
                    }
                } catch (IOException | JSONException unused4) {
                    fileOutputStream = null;
                    fileChannel = null;
                }
            } catch (Throwable th) {
                th = th;
                if (fileChannel2 != null) {
                    try {
                        fileChannel2.close();
                    } catch (IOException unused5) {
                    }
                }
                throw th;
            }
            try {
                try {
                    fileLock = fileChannel.lock();
                } catch (IOException | JSONException unused6) {
                    fileLock = fileLock2;
                }
                try {
                    fileOutputStream.write(sb.toString().getBytes());
                    if (fileLock != null) {
                        fileLock.release();
                    } else {
                        fileLock2 = fileLock;
                    }
                    atomicFile.finishWrite(fileOutputStream);
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                            return true;
                        } catch (IOException unused7) {
                            return true;
                        }
                    }
                    return true;
                } catch (IOException | JSONException unused8) {
                    atomicFile2 = atomicFile;
                    if (atomicFile2 != null) {
                    }
                    if (fileChannel != null) {
                    }
                    return false;
                }
            } catch (Throwable th2) {
                th = th2;
                fileChannel2 = fileChannel;
                if (fileChannel2 != null) {
                }
                throw th;
            }
        } catch (IOException | JSONException unused9) {
            fileOutputStream = null;
            fileChannel = null;
            fileLock = null;
        }
    }
}
