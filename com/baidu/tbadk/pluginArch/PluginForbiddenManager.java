package com.baidu.tbadk.pluginArch;

import android.text.TextUtils;
import android.util.Xml;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.pluginArch.bean.ForbiddenConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;
/* loaded from: classes.dex */
public class PluginForbiddenManager {
    static final String FORBIDDEN_TAG = "forbidden";
    static final String USER_TAG = "user";
    static PluginForbiddenManager eConfigManager = null;
    private HashMap<String, ForbiddenConfig> mPluginForbiddenConfig = new HashMap<>();

    public static PluginForbiddenManager getInstance() {
        PluginForbiddenManager pluginForbiddenManager;
        synchronized (PluginForbiddenManager.class) {
            if (eConfigManager == null) {
                eConfigManager = new PluginForbiddenManager();
            }
            pluginForbiddenManager = eConfigManager;
        }
        return pluginForbiddenManager;
    }

    private PluginForbiddenManager() {
    }

    public ForbiddenConfig getForbiddenConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ForbiddenConfig forbiddenConfig = this.mPluginForbiddenConfig.get(str);
        if (forbiddenConfig == null) {
            load(str);
            ForbiddenConfig forbiddenConfig2 = this.mPluginForbiddenConfig.get(str);
            if (forbiddenConfig2 == null) {
                ForbiddenConfig forbiddenConfig3 = new ForbiddenConfig();
                forbiddenConfig3.pluginName = str;
                this.mPluginForbiddenConfig.put(str, forbiddenConfig3);
                return forbiddenConfig3;
            }
            return forbiddenConfig2;
        }
        return forbiddenConfig;
    }

    public void setEnabled(String str, boolean z) {
        ForbiddenConfig forbiddenConfig;
        if (str != null && (forbiddenConfig = getForbiddenConfig(str)) != null) {
            String currentUserId = PluginHelper.getCurrentUserId();
            if (TextUtils.isEmpty(currentUserId)) {
                currentUserId = null;
            }
            if (z) {
                if (!forbiddenConfig.forbiddenUsers.contains(currentUserId)) {
                    forbiddenConfig.forbiddenUsers.add(currentUserId);
                }
            } else if (forbiddenConfig.forbiddenUsers.contains(currentUserId)) {
                forbiddenConfig.forbiddenUsers.remove(currentUserId);
            }
            addForbiddenConfig(forbiddenConfig);
            if (TbadkApplication.m251getInst().isMainProcess(false)) {
                RemoteSynchronousDataHelper.getInstance().startOperateForbiddenMsg(str);
            }
        }
    }

    public boolean isEnabled(String str) {
        if (str == null) {
            return false;
        }
        ForbiddenConfig forbiddenConfig = getForbiddenConfig(str);
        if (forbiddenConfig == null) {
            return true;
        }
        if (forbiddenConfig.forbiddenUsers == null || forbiddenConfig.forbiddenUsers.size() == 0) {
            return true;
        }
        String currentUserId = PluginHelper.getCurrentUserId();
        String str2 = TextUtils.isEmpty(currentUserId) ? null : currentUserId;
        for (String str3 : forbiddenConfig.forbiddenUsers) {
            if (TextUtils.isEmpty(str3)) {
                str3 = null;
            }
            if (str3 == null) {
                if (str3 == str2) {
                    return false;
                }
            } else if (str3.equals(str2)) {
                return false;
            }
        }
        return true;
    }

    public void addForbiddenConfig(ForbiddenConfig forbiddenConfig) {
        if (forbiddenConfig != null) {
            this.mPluginForbiddenConfig.put(forbiddenConfig.pluginName, forbiddenConfig);
            save(forbiddenConfig.pluginName);
        }
    }

    public ForbiddenConfig resetForbiddenConfig(String str) {
        if (str == null) {
            return null;
        }
        this.mPluginForbiddenConfig.put(str, null);
        return getForbiddenConfig(str);
    }

    public void load(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        ForbiddenConfig forbiddenConfig = null;
        fileInputStream2 = null;
        if (str != null) {
            File enablePluginXMLPath = PluginFileHelper.enablePluginXMLPath(str);
            try {
                if (enablePluginXMLPath != null) {
                    try {
                        if (enablePluginXMLPath.exists()) {
                            XmlPullParser newPullParser = Xml.newPullParser();
                            fileInputStream = new FileInputStream(enablePluginXMLPath);
                            try {
                                newPullParser.setInput(fileInputStream, "UTF-8");
                                for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                                    switch (eventType) {
                                        case 2:
                                            if (FORBIDDEN_TAG.equals(newPullParser.getName())) {
                                                forbiddenConfig = new ForbiddenConfig();
                                                forbiddenConfig.pluginName = str;
                                            }
                                            if (USER_TAG.equals(newPullParser.getName()) && forbiddenConfig != null) {
                                                forbiddenConfig.forbiddenUsers.add(newPullParser.nextText());
                                                continue;
                                            }
                                            break;
                                        case 3:
                                            if (FORBIDDEN_TAG.equals(newPullParser.getName()) && forbiddenConfig != null && forbiddenConfig.pluginName != null) {
                                                this.mPluginForbiddenConfig.put(str, forbiddenConfig);
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
                        }
                    } catch (Exception e3) {
                        e = e3;
                        fileInputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        if (0 != 0) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
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
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x009f */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v4 */
    private void save(String str) {
        File enablePluginXMLPath;
        FileOutputStream fileOutputStream;
        if (str != null && (enablePluginXMLPath = PluginFileHelper.enablePluginXMLPath(str)) != null) {
            ForbiddenConfig forbiddenConfig = this.mPluginForbiddenConfig.get(str);
            if (forbiddenConfig != null) {
                ?? size = forbiddenConfig.forbiddenUsers.size();
                try {
                    if (size != 0) {
                        try {
                            fileOutputStream = new FileOutputStream(enablePluginXMLPath, false);
                            try {
                                XmlSerializer newSerializer = Xml.newSerializer();
                                newSerializer.setOutput(fileOutputStream, "UTF-8");
                                newSerializer.startDocument("UTF-8", true);
                                newSerializer.startTag(null, FORBIDDEN_TAG);
                                for (String str2 : forbiddenConfig.forbiddenUsers) {
                                    newSerializer.startTag(null, USER_TAG);
                                    newSerializer.text(str2);
                                    newSerializer.endTag(null, USER_TAG);
                                }
                                newSerializer.endTag(null, FORBIDDEN_TAG);
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
            if (enablePluginXMLPath.exists() && enablePluginXMLPath.isFile()) {
                enablePluginXMLPath.delete();
            }
        }
    }
}
