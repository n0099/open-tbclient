package com.baidu.tieba.c;

import android.util.Log;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;
/* loaded from: classes.dex */
public class af {
    private static int a = 0;
    private static int b = 0;
    private static int c = 0;
    private static int d = 0;

    public static int a(String str, String str2, String str3) {
        if (com.baidu.tieba.a.i.n()) {
            StringBuffer stringBuffer = new StringBuffer(100);
            stringBuffer.append(str);
            stringBuffer.append(":");
            stringBuffer.append(str2);
            stringBuffer.append(":");
            stringBuffer.append(str3);
            return Log.i("TiebaLog", stringBuffer.toString());
        }
        return 0;
    }

    public static int b(String str, String str2, String str3) {
        if (com.baidu.tieba.a.i.n()) {
            StringBuffer stringBuffer = new StringBuffer(100);
            stringBuffer.append(str);
            stringBuffer.append(":");
            stringBuffer.append(str2);
            stringBuffer.append(":");
            stringBuffer.append(str3);
            return Log.e("TiebaLog", stringBuffer.toString());
        }
        return 0;
    }

    public static int c(String str, String str2, String str3) {
        if (com.baidu.tieba.a.i.n()) {
            StringBuffer stringBuffer = new StringBuffer(100);
            stringBuffer.append(str);
            stringBuffer.append(":");
            stringBuffer.append(str2);
            stringBuffer.append(":");
            stringBuffer.append(str3);
            return Log.w("TiebaLog", stringBuffer.toString());
        }
        return 0;
    }

    public static int d(String str, String str2, String str3) {
        if (com.baidu.tieba.a.i.n()) {
            StringBuffer stringBuffer = new StringBuffer(100);
            stringBuffer.append(str);
            stringBuffer.append(":");
            stringBuffer.append(str2);
            stringBuffer.append(":");
            stringBuffer.append(str3);
            return Log.v("TiebaLog", stringBuffer.toString());
        }
        return 0;
    }

    public static int e(String str, String str2, String str3) {
        if (com.baidu.tieba.a.i.n()) {
            StringBuffer stringBuffer = new StringBuffer(100);
            stringBuffer.append(str);
            stringBuffer.append(":");
            stringBuffer.append(str2);
            stringBuffer.append(":");
            stringBuffer.append(str3);
            return Log.d("TiebaLog", stringBuffer.toString());
        }
        return 0;
    }

    public static int a(int i, String str) {
        if (com.baidu.tieba.a.i.n()) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace.length < 4) {
                return -1;
            }
            StackTraceElement stackTraceElement = stackTrace[3];
            String methodName = stackTraceElement.getMethodName();
            String className = stackTraceElement.getClassName();
            if (i == 0) {
                b(className, methodName, str);
            } else if (i == 1) {
                c(className, methodName, str);
            } else if (i == 2) {
                a(className, methodName, str);
            } else if (i == 3) {
                e(className, methodName, str);
            } else {
                d(className, methodName, str);
            }
            return 0;
        }
        return -1;
    }

    public static int a(String str) {
        return a(0, str);
    }

    public static int b(String str) {
        return a(2, str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void a(int i, String str, String str2, String str3) {
        FileWriter fileWriter;
        Throwable th;
        boolean z = true;
        FileWriter fileWriter2 = null;
        switch (i) {
            case 1:
                if (a < 10) {
                    a++;
                    break;
                }
                z = false;
                break;
            case 2:
                if (b < 10) {
                    b++;
                    break;
                }
                z = false;
                break;
            case 3:
                if (c < 10) {
                    c++;
                    break;
                }
                z = false;
                break;
            case 4:
                if (d < 10) {
                    d++;
                    break;
                }
                z = false;
                break;
            default:
                z = false;
                break;
        }
        try {
            if (com.baidu.tieba.a.i.n() || z) {
                StringBuffer stringBuffer = new StringBuffer(100);
                stringBuffer.append(new Date().getTime() / 1000);
                stringBuffer.append("\t");
                stringBuffer.append(i);
                stringBuffer.append("\t");
                stringBuffer.append(str2);
                if (str3 != null) {
                    stringBuffer.append(":");
                    stringBuffer.append(str3.replace("\n", " ").replace("\t", " "));
                }
                stringBuffer.append("\t");
                stringBuffer.append(str);
                stringBuffer.append("\t");
                stringBuffer.append(0);
                stringBuffer.append("\n");
                String stringBuffer2 = stringBuffer.toString();
                if (com.baidu.tieba.a.i.n()) {
                    Log.e("TiebaLog", stringBuffer2);
                }
                if (z) {
                    File f = o.f("log_error.log");
                    if (stringBuffer2 != null && f != null && f.length() < 204800) {
                        fileWriter = new FileWriter(f, true);
                        try {
                            fileWriter.append((CharSequence) stringBuffer2);
                            fileWriter.flush();
                            fileWriter2 = fileWriter;
                        } catch (Exception e) {
                            fileWriter2 = fileWriter;
                            if (fileWriter2 != null) {
                                try {
                                    fileWriter2.close();
                                    return;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    return;
                                }
                            }
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileWriter != null) {
                                try {
                                    fileWriter.close();
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                }
            }
            if (fileWriter2 != null) {
                try {
                    fileWriter2.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        } catch (Exception e5) {
        } catch (Throwable th3) {
            fileWriter = null;
            th = th3;
        }
    }
}
