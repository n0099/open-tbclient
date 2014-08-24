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
public class r {
    static r a = null;
    private HashMap<String, q> b = new HashMap<>();

    public static r a() {
        r rVar;
        synchronized (r.class) {
            if (a == null) {
                a = new r();
                try {
                    a.d();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (XmlPullParserException e2) {
                    e2.printStackTrace();
                }
            }
            rVar = a;
        }
        return rVar;
    }

    private r() {
    }

    public HashMap<String, q> b() {
        return this.b;
    }

    public HashMap<String, q> c() {
        try {
            this.b.clear();
            d();
            return this.b;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void a(q qVar) {
        this.b.put(qVar.a, qVar);
        try {
            e();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void d() {
        File b = n.b();
        if (b.exists()) {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(new FileInputStream(b), "UTF-8");
            q qVar = null;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                switch (eventType) {
                    case 2:
                        if ("Plugin".equals(newPullParser.getName())) {
                            qVar = new q();
                        }
                        if ("name".equals(newPullParser.getName()) && qVar != null) {
                            qVar.a = newPullParser.nextText();
                        }
                        if ("version".equals(newPullParser.getName()) && qVar != null) {
                            qVar.b = Integer.valueOf(newPullParser.nextText()).intValue();
                            break;
                        }
                        break;
                    case 3:
                        if ("Plugin".equals(newPullParser.getName()) && qVar != null && qVar.a != null && !"hao123".equalsIgnoreCase(qVar.a)) {
                            this.b.put(qVar.a, qVar);
                            break;
                        }
                        break;
                }
            }
        }
    }

    private void e() {
        FileOutputStream fileOutputStream = new FileOutputStream(n.b(), false);
        XmlSerializer newSerializer = Xml.newSerializer();
        newSerializer.setOutput(fileOutputStream, "UTF-8");
        newSerializer.startDocument("UTF-8", true);
        newSerializer.startTag(null, "InstalledPlugins");
        for (q qVar : this.b.values()) {
            newSerializer.startTag(null, "Plugin");
            if (qVar.a != null) {
                newSerializer.startTag(null, "name");
                newSerializer.text(qVar.a);
                newSerializer.endTag(null, "name");
            }
            newSerializer.startTag(null, "version");
            newSerializer.text(String.valueOf(qVar.b));
            newSerializer.endTag(null, "version");
            newSerializer.endTag(null, "Plugin");
        }
        newSerializer.endTag(null, "InstalledPlugins");
        newSerializer.endDocument();
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}
