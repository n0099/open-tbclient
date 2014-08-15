package com.baidu.tbadk.pluginArch;

import android.text.TextUtils;
import android.util.Xml;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;
/* loaded from: classes.dex */
public class n {
    static n a = null;
    private HashMap<String, com.baidu.tbadk.pluginArch.bean.a> b = new HashMap<>();

    public static n a() {
        n nVar;
        synchronized (n.class) {
            if (a == null) {
                a = new n();
            }
            nVar = a;
        }
        return nVar;
    }

    private n() {
    }

    public com.baidu.tbadk.pluginArch.bean.a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.baidu.tbadk.pluginArch.bean.a aVar = this.b.get(str);
        if (aVar == null) {
            c(str);
            com.baidu.tbadk.pluginArch.bean.a aVar2 = this.b.get(str);
            if (aVar2 == null) {
                com.baidu.tbadk.pluginArch.bean.a aVar3 = new com.baidu.tbadk.pluginArch.bean.a();
                aVar3.a = str;
                this.b.put(str, aVar3);
                return aVar3;
            }
            return aVar2;
        }
        return aVar;
    }

    public void a(com.baidu.tbadk.pluginArch.bean.a aVar) {
        if (aVar != null) {
            this.b.put(aVar.a, aVar);
            d(aVar.a);
        }
    }

    public com.baidu.tbadk.pluginArch.bean.a b(String str) {
        if (str == null) {
            return null;
        }
        this.b.put(str, null);
        return a(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        com.baidu.tbadk.pluginArch.bean.a aVar = null;
        fileInputStream2 = null;
        if (str != null) {
            File h = m.h(str);
            if (h != null) {
                try {
                    if (h.exists()) {
                        XmlPullParser newPullParser = Xml.newPullParser();
                        fileInputStream = new FileInputStream(h);
                        try {
                            try {
                                newPullParser.setInput(fileInputStream, "UTF-8");
                                for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                                    switch (eventType) {
                                        case 2:
                                            if ("forbidden".equals(newPullParser.getName())) {
                                                aVar = new com.baidu.tbadk.pluginArch.bean.a();
                                                aVar.a = str;
                                            }
                                            if ("user".equals(newPullParser.getName()) && aVar != null) {
                                                aVar.b.add(newPullParser.nextText());
                                                continue;
                                            }
                                            break;
                                        case 3:
                                            if ("forbidden".equals(newPullParser.getName()) && aVar != null && aVar.a != null) {
                                                this.b.put(str, aVar);
                                                continue;
                                            }
                                            break;
                                    }
                                }
                                fileInputStream2 = fileInputStream;
                            } catch (Exception e) {
                                e = e;
                                e.printStackTrace();
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                        return;
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                        return;
                                    }
                                }
                                return;
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                    if (fileInputStream != null) {
                    }
                    throw th;
                }
            }
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x00a5 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v4 */
    private void d(String str) {
        File h;
        FileOutputStream fileOutputStream;
        if (str != null && (h = m.h(str)) != null) {
            com.baidu.tbadk.pluginArch.bean.a aVar = this.b.get(str);
            if (aVar != null) {
                ?? size = aVar.b.size();
                try {
                    if (size != 0) {
                        try {
                            fileOutputStream = new FileOutputStream(h, false);
                            try {
                                XmlSerializer newSerializer = Xml.newSerializer();
                                newSerializer.setOutput(fileOutputStream, "UTF-8");
                                newSerializer.startDocument("UTF-8", true);
                                newSerializer.startTag(null, "forbidden");
                                for (String str2 : aVar.b) {
                                    newSerializer.startTag(null, "user");
                                    newSerializer.text(str2);
                                    newSerializer.endTag(null, "user");
                                }
                                newSerializer.endTag(null, "forbidden");
                                newSerializer.endDocument();
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                        return;
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                        return;
                                    }
                                }
                                return;
                            } catch (Exception e2) {
                                e = e2;
                                e.printStackTrace();
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                        return;
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                        return;
                                    }
                                }
                                return;
                            }
                        } catch (Exception e4) {
                            e = e4;
                            fileOutputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            size = 0;
                            if (size != 0) {
                                try {
                                    size.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (h.exists() && h.isFile()) {
                h.delete();
            }
        }
    }
}
