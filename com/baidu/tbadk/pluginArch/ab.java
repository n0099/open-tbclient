package com.baidu.tbadk.pluginArch;

import android.util.Xml;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public class ab {
    public aa a;
    private File b;

    public ab(File file) {
        this.b = null;
        this.b = file;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [100=7, 102=7, 103=5] */
    public void a() {
        FileInputStream fileInputStream;
        XmlPullParser newPullParser = Xml.newPullParser();
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(this.b);
        } catch (FileNotFoundException e) {
            fileInputStream = null;
        } catch (IOException e2) {
            fileInputStream = null;
        } catch (NullPointerException e3) {
            fileInputStream = null;
        } catch (NumberFormatException e4) {
            fileInputStream = null;
        } catch (XmlPullParserException e5) {
            fileInputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            newPullParser.setInput(fileInputStream, "UTF-8");
            this.a = new aa();
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                String name = newPullParser.getName();
                switch (eventType) {
                    case 2:
                        if (name.equals("plugin")) {
                            continue;
                        } else if (name.equals("version")) {
                            this.a.e = Integer.parseInt(newPullParser.nextText());
                            continue;
                        } else if (name.equals("name")) {
                            this.a.a = newPullParser.nextText();
                            continue;
                        } else if (name.equals("jar")) {
                            this.a.b = newPullParser.nextText();
                            continue;
                        } else if (name.equals("so")) {
                            if (this.a.c == null) {
                                this.a.c = new ArrayList();
                            }
                            this.a.c.add(newPullParser.nextText());
                            continue;
                        } else if (newPullParser.getName().equals("res")) {
                            this.a.d = newPullParser.nextText();
                            continue;
                        } else if (newPullParser.getName().equals("resourceloadtype")) {
                            this.a.f = Integer.parseInt(newPullParser.nextText());
                            continue;
                        } else if (newPullParser.getName().equals("interfacename")) {
                            this.a.g = newPullParser.nextText();
                            continue;
                        } else if (newPullParser.getName().equals("implclassname")) {
                            this.a.h = newPullParser.nextText();
                            continue;
                        } else {
                            continue;
                        }
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e6) {
                }
            }
        } catch (FileNotFoundException e7) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e8) {
                }
            }
        } catch (IOException e9) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e10) {
                }
            }
        } catch (NullPointerException e11) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e12) {
                }
            }
        } catch (NumberFormatException e13) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e14) {
                }
            }
        } catch (XmlPullParserException e15) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e16) {
                }
            }
        } catch (Throwable th2) {
            fileInputStream2 = fileInputStream;
            th = th2;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e17) {
                }
            }
            throw th;
        }
    }
}
