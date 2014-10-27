package com.baidu.tbadk.pluginArch;

import android.app.Service;
import android.content.Intent;
import android.os.FileObserver;
import android.os.IBinder;
import android.text.TextUtils;
import java.util.HashMap;
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
                PluginFileObserver pluginFileObserver = this.observerMap.get(stringExtra);
                if (pluginFileObserver == null) {
                    pluginFileObserver = new PluginFileObserver(stringExtra, PluginFileHelper.pluginDir(stringExtra).getAbsolutePath());
                    this.observerMap.put(stringExtra, pluginFileObserver);
                }
                pluginFileObserver.startWatching();
            }
        }
        return super.onStartCommand(intent, i, i2);
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
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    /* loaded from: classes.dex */
    class PluginFileObserver extends FileObserver {
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
