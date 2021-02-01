package com.baidu.tbadk.o;

import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import android.provider.Settings;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.plugin.proxy.ContentResolverProxy;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aa;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static boolean fLd = false;
    private static String link = "";

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [77=4, 78=4, 80=4, 81=4, 84=4, 85=4, 87=4, 88=4] */
    public static boolean b(File file, File file2, byte[] bArr) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        InputStream inputStream;
        boolean z = false;
        InputStream inputStream2 = null;
        OutputStream outputStream = null;
        try {
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        try {
                            byte[] bArr2 = new byte[1024];
                            if (bArr != null && bArr.length > 0 && bArr.length < file.length()) {
                                byte[] bArr3 = new byte[bArr.length];
                                fileInputStream.read(bArr3, 0, bArr.length);
                                int i = 0;
                                while (true) {
                                    if (i >= bArr.length) {
                                        break;
                                    } else if (bArr[i] != bArr3[i]) {
                                        fileOutputStream.write(bArr3, 0, bArr.length);
                                        break;
                                    } else {
                                        i++;
                                    }
                                }
                            }
                            while (true) {
                                int read = fileInputStream.read(bArr2);
                                if (read <= 0) {
                                    break;
                                }
                                fileOutputStream.write(bArr2, 0, read);
                            }
                            fileOutputStream.flush();
                            fileInputStream.close();
                            inputStream = null;
                        } catch (Exception e) {
                            e = e;
                        }
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        fileOutputStream.close();
                        OutputStream outputStream2 = null;
                        z = true;
                        if (0 != 0) {
                            try {
                                inputStream.close();
                            } catch (Exception e2) {
                                BdLog.e(e2.toString());
                            }
                        }
                        if (0 != 0) {
                            try {
                                outputStream2.close();
                            } catch (Exception e3) {
                                BdLog.e(e3.toString());
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                        fileInputStream = null;
                        BdLog.e(e.toString());
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e5) {
                                BdLog.e(e5.toString());
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e6) {
                                BdLog.e(e6.toString());
                            }
                        }
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = null;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e7) {
                                BdLog.e(e7.toString());
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e8) {
                                BdLog.e(e8.toString());
                            }
                        }
                        throw th;
                    }
                } catch (Exception e9) {
                    e = e9;
                    fileOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                }
            } else {
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e10) {
                        BdLog.e(e10.toString());
                    }
                }
                if (0 != 0) {
                    try {
                        outputStream.close();
                    } catch (Exception e11) {
                        BdLog.e(e11.toString());
                    }
                }
            }
        } catch (Exception e12) {
            e = e12;
            fileOutputStream = null;
            fileInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            fileInputStream = null;
        }
        return z;
    }

    public static String fu(Context context) {
        String host;
        int port;
        String str = null;
        try {
            if (Build.VERSION.SDK_INT >= 14) {
                host = System.getProperty("http.proxyHost");
                String property = System.getProperty("http.proxyPort");
                if (property == null) {
                    property = "-1";
                }
                port = Integer.parseInt(property);
            } else {
                host = Proxy.getHost(context);
                port = Proxy.getPort(context);
            }
            if (k.isEmpty(host) || port == -1) {
                return null;
            }
            str = host + ":" + port;
            return str;
        } catch (Exception e) {
            return str;
        }
    }

    public static boolean bEw() {
        try {
            return Settings.Secure.getInt(ContentResolverProxy.getContentResolver(), "adb_enabled", 0) > 0;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [169=5, 171=4, 172=4, 173=4] */
    public static String R(File file) {
        FileInputStream fileInputStream;
        String str;
        if (fLd) {
            return "hasSend_" + link;
        }
        String str2 = TbConfig.SERVER_ADDRESS + TbConfig.DEBUG_UPLOAD;
        if (file.length() > 3145728 || !TbadkCoreApplication.isLogin()) {
            return "notLogin";
        }
        try {
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[(int) file.length()];
                    fileInputStream.read(bArr);
                    fileInputStream.close();
                    aa aaVar = new aa(str2 + "?fn=" + file.getName());
                    aaVar.addPostData("debugfile", bArr);
                    aaVar.addPostData("tbs", TbadkCoreApplication.getInst().getTbs());
                    aaVar.addPostData("type", HttpConstants.OS_TYPE_VALUE);
                    str = aaVar.postMultiNetData();
                    if (str != null && !str.isEmpty()) {
                        link = new JSONObject(str).getString("url");
                        fLd = true;
                        String str3 = link;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                return str3;
                            } catch (IOException e) {
                                e.printStackTrace();
                                return str3;
                            }
                        }
                        return str3;
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        String str4 = "uploadfail_" + th;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                return str4;
                            } catch (IOException e2) {
                                e2.printStackTrace();
                                return str4;
                            }
                        }
                        return str4;
                    } catch (Throwable th2) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th2;
                    }
                }
            } else {
                fileInputStream = null;
                str = null;
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                    return str;
                } catch (IOException e4) {
                    e4.printStackTrace();
                    return str;
                }
            }
            return str;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }
}
