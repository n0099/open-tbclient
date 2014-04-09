package com.baidu.tbplugin;

import android.util.Xml;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
final class l {
    private com.baidu.tbplugin.b.a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(File file) {
        XmlPullParser newPullParser = Xml.newPullParser();
        try {
            newPullParser.setInput(new FileInputStream(file), "UTF-8");
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                String name = newPullParser.getName();
                switch (eventType) {
                    case 2:
                        if (name.equals("plugin")) {
                            this.a = new com.baidu.tbplugin.b.a();
                            continue;
                        } else if (name.equals("version")) {
                            if (this.a == null) {
                                this.a = new com.baidu.tbplugin.b.a();
                            }
                            this.a.b = newPullParser.nextText();
                            continue;
                        } else if (name.equals("name")) {
                            if (this.a == null) {
                                this.a = new com.baidu.tbplugin.b.a();
                            }
                            this.a.a = newPullParser.nextText();
                            continue;
                        } else if (name.equals("jar")) {
                            if (this.a == null) {
                                this.a = new com.baidu.tbplugin.b.a();
                            }
                            this.a.c = newPullParser.nextText();
                            continue;
                        } else if (name.equals("so")) {
                            if (this.a == null) {
                                this.a = new com.baidu.tbplugin.b.a();
                            }
                            if (this.a.d == null) {
                                this.a.d = new ArrayList();
                            }
                            this.a.d.add(newPullParser.nextText());
                            continue;
                        } else if (newPullParser.getName().equals("res")) {
                            if (this.a == null) {
                                this.a = new com.baidu.tbplugin.b.a();
                            }
                            this.a.e = newPullParser.nextText();
                            continue;
                        } else {
                            continue;
                        }
                }
            }
        } catch (FileNotFoundException e) {
            g.a(com.baidu.adp.a.b.a().c(), "Xml parse failed: Nested Exception: " + e.getMessage());
        } catch (IOException e2) {
            g.a(com.baidu.adp.a.b.a().c(), "Xml parse failed: Nested Exception: " + e2.getMessage());
        } catch (NullPointerException e3) {
            g.a(com.baidu.adp.a.b.a().c(), "Xml parse failed: Nested Exception: " + e3.getMessage());
        } catch (XmlPullParserException e4) {
            g.a(com.baidu.adp.a.b.a().c(), "Xml parse failed: Nested Exception: " + e4.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String a() {
        if (this.a == null) {
            return null;
        }
        return this.a.a;
    }

    public final String b() {
        if (this.a == null) {
            return null;
        }
        return this.a.c;
    }

    public final String c() {
        if (this.a == null) {
            return null;
        }
        return this.a.e;
    }

    public final List<String> d() {
        if (this.a == null) {
            return null;
        }
        return this.a.d;
    }
}
