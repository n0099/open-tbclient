package com.baidu.tbplugin;

import android.util.Xml;
import com.baidu.cloudsdk.social.core.SocialConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
class k {
    private com.baidu.tbplugin.b.a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(File file) {
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
                            this.a.b = newPullParser.nextText();
                            continue;
                        } else if (name.equals(SocialConstants.PARAM_MEDIA_UNAME)) {
                            this.a.a = newPullParser.nextText();
                            continue;
                        } else if (name.equals("jar")) {
                            this.a.c = newPullParser.nextText();
                            continue;
                        } else if (name.equals("so")) {
                            if (this.a.d == null) {
                                this.a.d = new ArrayList();
                            }
                            this.a.d.add(newPullParser.nextText());
                            continue;
                        } else if (newPullParser.getName().equals("res")) {
                            this.a.e = newPullParser.nextText();
                            continue;
                        } else {
                            continue;
                        }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        return this.a.a;
    }

    public String b() {
        return this.a.c;
    }

    public String c() {
        return this.a.e;
    }

    public List<String> d() {
        return this.a.d;
    }
}
