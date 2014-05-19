package com.baidu.tbadk.tbplugin;

import android.util.Xml;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s {
    private com.baidu.tbadk.tbplugin.b.a a;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [75=7, 77=7, 78=5] */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public s(File file) {
        FileInputStream fileInputStream;
        XmlPullParser newPullParser = Xml.newPullParser();
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e2) {
            e = e2;
            fileInputStream = null;
        } catch (IOException e3) {
            e = e3;
            fileInputStream = null;
        } catch (NullPointerException e4) {
            e = e4;
            fileInputStream = null;
        } catch (NumberFormatException e5) {
            e = e5;
            fileInputStream = null;
        } catch (XmlPullParserException e6) {
            e = e6;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            throw th;
        }
        try {
            newPullParser.setInput(fileInputStream, "UTF-8");
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                String name = newPullParser.getName();
                switch (eventType) {
                    case 2:
                        if (name.equals("plugin")) {
                            this.a = new com.baidu.tbadk.tbplugin.b.a();
                            continue;
                        } else if (name.equals("version")) {
                            if (this.a == null) {
                                this.a = new com.baidu.tbadk.tbplugin.b.a();
                            }
                            this.a.b = Integer.parseInt(newPullParser.nextText());
                            continue;
                        } else if (name.equals("name")) {
                            if (this.a == null) {
                                this.a = new com.baidu.tbadk.tbplugin.b.a();
                            }
                            this.a.a = newPullParser.nextText();
                            continue;
                        } else if (name.equals("jar")) {
                            if (this.a == null) {
                                this.a = new com.baidu.tbadk.tbplugin.b.a();
                            }
                            this.a.c = newPullParser.nextText();
                            continue;
                        } else if (name.equals("so")) {
                            if (this.a == null) {
                                this.a = new com.baidu.tbadk.tbplugin.b.a();
                            }
                            if (this.a.d == null) {
                                this.a.d = new ArrayList();
                            }
                            this.a.d.add(newPullParser.nextText());
                            continue;
                        } else if (newPullParser.getName().equals("res")) {
                            if (this.a == null) {
                                this.a = new com.baidu.tbadk.tbplugin.b.a();
                            }
                            this.a.e = newPullParser.nextText();
                            continue;
                        } else {
                            continue;
                        }
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e7) {
                }
            }
        } catch (FileNotFoundException e8) {
            e = e8;
            i.b(com.baidu.adp.base.a.getInst().getContext(), "Xml parse failed: Nested Exception: " + e.getMessage());
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e9) {
                }
            }
        } catch (IOException e10) {
            e = e10;
            i.b(com.baidu.adp.base.a.getInst().getContext(), "Xml parse failed: Nested Exception: " + e.getMessage());
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e11) {
                }
            }
        } catch (NullPointerException e12) {
            e = e12;
            i.b(com.baidu.adp.base.a.getInst().getContext(), "Xml parse failed: Nested Exception: " + e.getMessage());
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e13) {
                }
            }
        } catch (NumberFormatException e14) {
            e = e14;
            i.b(com.baidu.adp.base.a.getInst().getContext(), "Xml parse failed: Nested Exception: " + e.getMessage());
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e15) {
                }
            }
        } catch (XmlPullParserException e16) {
            e = e16;
            i.b(com.baidu.adp.base.a.getInst().getContext(), "Xml parse failed: Nested Exception: " + e.getMessage());
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e17) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        if (this.a == null) {
            return null;
        }
        return this.a.a;
    }

    public String b() {
        if (this.a == null) {
            return null;
        }
        return this.a.c;
    }

    public int c() {
        if (this.a == null) {
            return -1;
        }
        return this.a.b;
    }

    public String d() {
        if (this.a == null) {
            return null;
        }
        return this.a.e;
    }

    public List<String> e() {
        if (this.a == null) {
            return null;
        }
        return this.a.d;
    }

    public static s a(File file) {
        return new s(file);
    }
}
