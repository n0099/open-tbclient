package com.baidu.tbadk.pluginArch;

import android.text.TextUtils;
import android.util.Xml;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;
/* loaded from: classes.dex */
public class PluginInstalledConfigManager {
    static final String INSAPPVER_TAG = "insappver";
    static final String NAME_TAG = "name";
    static final String PLUGIN_TAG = "Plugin";
    static final String UPDATEVER_TAG = "update";
    static final String VERSION_TAG = "version";
    static PluginInstalledConfigManager sConfigManager = null;
    private HashMap<String, PluginInstalledConfigItem> mPluginInstalledConfig = new HashMap<>();

    public static PluginInstalledConfigManager getInstance() {
        PluginInstalledConfigManager pluginInstalledConfigManager;
        synchronized (PluginInstalledConfigManager.class) {
            if (sConfigManager == null) {
                sConfigManager = new PluginInstalledConfigManager();
                try {
                    try {
                        sConfigManager.load();
                        sConfigManager.checkRealInstall();
                        sConfigManager.save();
                    } catch (XmlPullParserException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                } catch (Error e3) {
                    e3.printStackTrace();
                }
            }
            pluginInstalledConfigManager = sConfigManager;
        }
        return pluginInstalledConfigManager;
    }

    private PluginInstalledConfigManager() {
    }

    public HashMap<String, PluginInstalledConfigItem> getInstalledConfig() {
        return this.mPluginInstalledConfig;
    }

    public PluginInstalledConfigItem getInstalledConfigByName(String str) {
        return this.mPluginInstalledConfig.get(str);
    }

    public HashMap<String, PluginInstalledConfigItem> resetInstalledConfig() {
        try {
            this.mPluginInstalledConfig.clear();
            load();
            return this.mPluginInstalledConfig;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private void checkRealInstall() {
        if (this.mPluginInstalledConfig != null && this.mPluginInstalledConfig.size() != 0) {
            ArrayList<String> arrayList = new ArrayList();
            for (String str : this.mPluginInstalledConfig.keySet()) {
                if (!TextUtils.isEmpty(str)) {
                    File apkDir = PluginFileHelper.apkDir(str);
                    File pluginXML = PluginFileHelper.pluginXML(str);
                    if (!PluginHelper.isFileExist(apkDir) || !PluginHelper.isFileExist(pluginXML)) {
                        arrayList.add(str);
                    }
                }
            }
            for (String str2 : arrayList) {
                this.mPluginInstalledConfig.remove(str2);
            }
        }
    }

    public void addInstalledConfig(PluginInstalledConfigItem pluginInstalledConfigItem) {
        this.mPluginInstalledConfig.put(pluginInstalledConfigItem.mPluginName, pluginInstalledConfigItem);
        try {
            save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeInstalledConfig(String str) {
        this.mPluginInstalledConfig.remove(str);
        try {
            save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void load() {
        File InstalledPluginXMLPath = PluginFileHelper.InstalledPluginXMLPath();
        if (InstalledPluginXMLPath.exists()) {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(new FileInputStream(InstalledPluginXMLPath), "UTF-8");
            PluginInstalledConfigItem pluginInstalledConfigItem = null;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                switch (eventType) {
                    case 2:
                        if (PLUGIN_TAG.equals(newPullParser.getName())) {
                            pluginInstalledConfigItem = new PluginInstalledConfigItem();
                        }
                        if ("name".equals(newPullParser.getName()) && pluginInstalledConfigItem != null) {
                            pluginInstalledConfigItem.mPluginName = newPullParser.nextText();
                        }
                        if (VERSION_TAG.equals(newPullParser.getName()) && pluginInstalledConfigItem != null) {
                            pluginInstalledConfigItem.mPluginVersion = Integer.valueOf(newPullParser.nextText()).intValue();
                        }
                        if (UPDATEVER_TAG.equals(newPullParser.getName()) && pluginInstalledConfigItem != null) {
                            pluginInstalledConfigItem.mPluginUpdateVersion = Integer.valueOf(newPullParser.nextText()).intValue();
                        }
                        if (INSAPPVER_TAG.equals(newPullParser.getName()) && pluginInstalledConfigItem != null) {
                            pluginInstalledConfigItem.mInstalledMainVersion = newPullParser.nextText();
                            break;
                        }
                        break;
                    case 3:
                        if (PLUGIN_TAG.equals(newPullParser.getName()) && pluginInstalledConfigItem != null && pluginInstalledConfigItem.mPluginName != null) {
                            this.mPluginInstalledConfig.put(pluginInstalledConfigItem.mPluginName, pluginInstalledConfigItem);
                            break;
                        }
                        break;
                }
            }
        }
    }

    private void save() {
        FileOutputStream fileOutputStream = new FileOutputStream(PluginFileHelper.InstalledPluginXMLPath(), false);
        XmlSerializer newSerializer = Xml.newSerializer();
        newSerializer.setOutput(fileOutputStream, "UTF-8");
        newSerializer.startDocument("UTF-8", true);
        newSerializer.startTag(null, "InstalledPlugins");
        for (PluginInstalledConfigItem pluginInstalledConfigItem : this.mPluginInstalledConfig.values()) {
            newSerializer.startTag(null, PLUGIN_TAG);
            if (pluginInstalledConfigItem.mPluginName != null) {
                newSerializer.startTag(null, "name");
                newSerializer.text(pluginInstalledConfigItem.mPluginName);
                newSerializer.endTag(null, "name");
            }
            newSerializer.startTag(null, VERSION_TAG);
            newSerializer.text(String.valueOf(pluginInstalledConfigItem.mPluginVersion));
            newSerializer.endTag(null, VERSION_TAG);
            newSerializer.startTag(null, UPDATEVER_TAG);
            newSerializer.text(String.valueOf(pluginInstalledConfigItem.mPluginUpdateVersion));
            newSerializer.endTag(null, UPDATEVER_TAG);
            newSerializer.startTag(null, INSAPPVER_TAG);
            newSerializer.text(pluginInstalledConfigItem.mInstalledMainVersion);
            newSerializer.endTag(null, INSAPPVER_TAG);
            newSerializer.endTag(null, PLUGIN_TAG);
        }
        newSerializer.endTag(null, "InstalledPlugins");
        newSerializer.endDocument();
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}
