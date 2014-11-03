package com.baidu.tbadk.pluginArch;

import android.util.Xml;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public class PluginXMLReader {
    static final String IMPL_TAG = "implclassname";
    static final String INTERFACE_TAG = "interfacename";
    static final String JAR_TAG = "jar";
    static final String NAME_TAG = "name";
    static final String PLUGIN_TAG = "plugin";
    static final String RESLOADTYPE_TAG = "resourceloadtype";
    static final String RES_TAG = "res";
    static final String SO_TAG = "so";
    static final String VERSION_TAG = "version";
    private static BdAsyncTaskParallel parallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    public PluginXMLAsyncCallback mCallback;
    private File mFile;
    public PluginXMLInfo mXmlInfo;

    /* loaded from: classes.dex */
    public interface PluginXMLAsyncCallback {
        void onFinish(PluginXMLReader pluginXMLReader);
    }

    public PluginXMLReader(File file) {
        this.mFile = null;
        this.mFile = file;
    }

    public void asyncParse() {
        PluginXMLAsyncTask pluginXMLAsyncTask = new PluginXMLAsyncTask();
        pluginXMLAsyncTask.setParallel(parallel);
        pluginXMLAsyncTask.execute(new Void[0]);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [119=7, 121=7, 122=5] */
    public void parse() {
        FileInputStream fileInputStream;
        XmlPullParser newPullParser = Xml.newPullParser();
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(this.mFile);
            try {
                newPullParser.setInput(fileInputStream, "UTF-8");
                this.mXmlInfo = new PluginXMLInfo();
                for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                    String name = newPullParser.getName();
                    switch (eventType) {
                        case 2:
                            if (name.equals(PLUGIN_TAG)) {
                                continue;
                            } else if (name.equals(VERSION_TAG)) {
                                this.mXmlInfo.mVersion = Integer.parseInt(newPullParser.nextText());
                                continue;
                            } else if (name.equals("name")) {
                                this.mXmlInfo.mPluginName = newPullParser.nextText();
                                continue;
                            } else if (name.equals(JAR_TAG)) {
                                this.mXmlInfo.mJar = newPullParser.nextText();
                                continue;
                            } else if (name.equals(SO_TAG)) {
                                if (this.mXmlInfo.mSos == null) {
                                    this.mXmlInfo.mSos = new ArrayList();
                                }
                                this.mXmlInfo.mSos.add(newPullParser.nextText());
                                continue;
                            } else if (newPullParser.getName().equals(RES_TAG)) {
                                this.mXmlInfo.mRes = newPullParser.nextText();
                                continue;
                            } else if (newPullParser.getName().equals(RESLOADTYPE_TAG)) {
                                this.mXmlInfo.mResourceLoadType = Integer.parseInt(newPullParser.nextText());
                                continue;
                            } else if (newPullParser.getName().equals(INTERFACE_TAG)) {
                                this.mXmlInfo.mInterfaceName = newPullParser.nextText();
                                continue;
                            } else if (newPullParser.getName().equals(IMPL_TAG)) {
                                this.mXmlInfo.mImplClassName = newPullParser.nextText();
                                continue;
                            } else {
                                continue;
                            }
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                    }
                }
            } catch (FileNotFoundException e2) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (IOException e4) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e5) {
                    }
                }
            } catch (NullPointerException e6) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e7) {
                    }
                }
            } catch (NumberFormatException e8) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e9) {
                    }
                }
            } catch (XmlPullParserException e10) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e11) {
                    }
                }
            } catch (Throwable th) {
                fileInputStream2 = fileInputStream;
                th = th;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e12) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e13) {
            fileInputStream = null;
        } catch (IOException e14) {
            fileInputStream = null;
        } catch (NullPointerException e15) {
            fileInputStream = null;
        } catch (NumberFormatException e16) {
            fileInputStream = null;
        } catch (XmlPullParserException e17) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* loaded from: classes.dex */
    class PluginXMLAsyncTask extends BdAsyncTask<Void, Integer, Void> {
        PluginXMLAsyncTask() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public synchronized Void doInBackground(Void... voidArr) {
            PluginXMLReader.this.parse();
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Void r3) {
            if (PluginXMLReader.this.mCallback != null) {
                PluginXMLReader.this.mCallback.onFinish(PluginXMLReader.this);
            }
            super.onPostExecute((PluginXMLAsyncTask) r3);
        }
    }
}
