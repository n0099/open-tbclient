package com.baidu.tbadk.pluginArch;

import android.util.Xml;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;
/* loaded from: classes.dex */
public class q {
    static q a = null;
    private HashMap<String, p> b = new HashMap<>();

    public static q a() {
        q qVar;
        synchronized (q.class) {
            if (a == null) {
                a = new q();
                try {
                    a.d();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (XmlPullParserException e2) {
                    e2.printStackTrace();
                }
            }
            qVar = a;
        }
        return qVar;
    }

    private q() {
    }

    public HashMap<String, p> b() {
        return this.b;
    }

    public HashMap<String, p> c() {
        try {
            this.b.clear();
            d();
            return this.b;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void a(p pVar) {
        this.b.put(pVar.a, pVar);
        try {
            e();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void d() {
        File b = m.b();
        if (b.exists()) {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(new FileInputStream(b), "UTF-8");
            p pVar = null;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                switch (eventType) {
                    case 2:
                        if ("Plugin".equals(newPullParser.getName())) {
                            pVar = new p();
                        }
                        if ("name".equals(newPullParser.getName()) && pVar != null) {
                            pVar.a = newPullParser.nextText();
                        }
                        if ("version".equals(newPullParser.getName()) && pVar != null) {
                            pVar.b = Integer.valueOf(newPullParser.nextText()).intValue();
                            break;
                        }
                        break;
                    case 3:
                        if ("Plugin".equals(newPullParser.getName()) && pVar != null && pVar.a != null) {
                            this.b.put(pVar.a, pVar);
                            break;
                        }
                        break;
                }
            }
        }
    }

    private void e() {
        FileOutputStream fileOutputStream = new FileOutputStream(m.b(), false);
        XmlSerializer newSerializer = Xml.newSerializer();
        newSerializer.setOutput(fileOutputStream, "UTF-8");
        newSerializer.startDocument("UTF-8", true);
        newSerializer.startTag(null, "InstalledPlugins");
        for (p pVar : this.b.values()) {
            newSerializer.startTag(null, "Plugin");
            if (pVar.a != null) {
                newSerializer.startTag(null, "name");
                newSerializer.text(pVar.a);
                newSerializer.endTag(null, "name");
            }
            newSerializer.startTag(null, "version");
            newSerializer.text(String.valueOf(pVar.b));
            newSerializer.endTag(null, "version");
            newSerializer.endTag(null, "Plugin");
        }
        newSerializer.endTag(null, "InstalledPlugins");
        newSerializer.endDocument();
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}
