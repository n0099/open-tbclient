package com.baidu.tbadk.pluginArch;

import android.app.Service;
import android.content.Intent;
import android.os.FileObserver;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.adp.lib.g.i;
import com.baidu.tbadk.TbadkApplication;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class PluginFileService extends Service {
    public static final String KEY_PLUGIN_NAME = "key_plugin_name";
    private HashMap<String, PluginFileObserver> observerMap = new HashMap<>();

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(KEY_PLUGIN_NAME);
            if (!TextUtils.isEmpty(stringExtra)) {
                addPluginObserver(stringExtra);
                return 1;
            }
            List<Plugin> installedPluginList = PluginCenter.getInstance().getInstalledPluginList();
            if (installedPluginList != null) {
                for (Plugin plugin2 : installedPluginList) {
                    addPluginObserver(plugin2.getName());
                }
                return 1;
            }
            return 1;
        }
        return 1;
    }

    private void addPluginObserver(String str) {
        PluginFileObserver pluginFileObserver = this.observerMap.get(str);
        if (pluginFileObserver == null) {
            pluginFileObserver = new PluginFileObserver(str, PluginFileHelper.pluginDir(str).getAbsolutePath());
            this.observerMap.put(str, pluginFileObserver);
        }
        pluginFileObserver.startWatching();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        for (Map.Entry<String, PluginFileObserver> entry : this.observerMap.entrySet()) {
            PluginFileObserver value = entry.getValue();
            if (value != null) {
                value.stopWatching();
            }
        }
        Intent intent = new Intent();
        intent.setClass(this, PluginFileService.class);
        i.b(TbadkApplication.m251getInst(), intent);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class PluginFileObserver extends FileObserver {
        private String mPluginName;

        public PluginFileObserver(String str, int i) {
            super(str, i);
        }

        public PluginFileObserver(String str) {
            super(str);
        }

        public PluginFileObserver(String str, String str2) {
            super(str2);
            this.mPluginName = str;
        }

        @Override // android.os.FileObserver
        public void onEvent(int i, String str) {
            switch (i & 4095) {
                case 2:
                case 64:
                case 512:
                case 1024:
                    PluginCenter.getInstance().unLoadPlugin(this.mPluginName);
                    stopWatching();
                    PluginFileService.this.observerMap.remove(this.mPluginName);
                    return;
                default:
                    return;
            }
        }
    }
}
