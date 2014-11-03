package com.baidu.tbadk.pluginArch;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.m;
/* loaded from: classes.dex */
public class Plugin {
    private static final int RE_VALIDATE = 1;
    private static final int RE_VALIDATE_DELAY = 500;
    private String mName;
    private PluginXMLInfo mXmlInfo;
    private boolean mIsLoaded = false;
    private MyHandler mHandler = new MyHandler(Looper.getMainLooper());

    public Plugin(PluginXMLInfo pluginXMLInfo) {
        this.mXmlInfo = pluginXMLInfo;
        this.mName = pluginXMLInfo.mPluginName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class MyHandler extends Handler {
        public MyHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    Plugin.this.mHandler.removeMessages(1);
                    if (Plugin.this.validateClass()) {
                        Plugin.this.mIsLoaded = true;
                        PluginLogger.logSuccess(PluginLogger.WORKFLOW_NODE_LOAD, Plugin.this.mName);
                        return;
                    }
                    PluginLogger.logFailure(PluginLogger.WORKFLOW_NODE_LOAD, "second validate class fail", Plugin.this.mName);
                    return;
                default:
                    return;
            }
        }
    }

    public String getName() {
        return this.mName;
    }

    public boolean loadPlugin(boolean z) {
        m.ft();
        if (this.mIsLoaded) {
            return true;
        }
        if (!validateFile()) {
            PluginLogger.logFailure(PluginLogger.WORKFLOW_NODE_LOAD, "file not exist", this.mName);
            return false;
        } else if (!loadResource()) {
            PluginLogger.logFailure(PluginLogger.WORKFLOW_NODE_LOAD, "load resources fail", this.mName);
            return false;
        } else if (!validatelibSo()) {
            PluginLogger.logFailure(PluginLogger.WORKFLOW_NODE_LOAD, "validate so lib fail", this.mName);
            return false;
        } else {
            if (z) {
                PluginCenter.getInstance().getClassLoader().add(PluginFileHelper.libraryDir(this.mName), PluginFileHelper.nativeDir(this.mName));
            }
            if (!validateClass()) {
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 500L);
                PluginLogger.logFailure(PluginLogger.WORKFLOW_NODE_LOAD, "first validate class fail", this.mName);
                return false;
            }
            this.mIsLoaded = true;
            PluginLogger.logSuccess(PluginLogger.WORKFLOW_NODE_LOAD, this.mName);
            return true;
        }
    }

    private boolean loadResource() {
        if (this.mXmlInfo.mResourceLoadType == 0) {
            return PluginResourcesManager.getInstance().registerGlobalRes(this.mName);
        }
        return true;
    }

    private boolean validatelibSo() {
        return true;
    }

    public boolean checkEnable() {
        if (this.mName == null) {
            return false;
        }
        return PluginCenter.getInstance().isEnabled(this.mName);
    }

    public <P> P getClassInstance(Class<P> cls) {
        if (cls == null) {
            return null;
        }
        if (this.mXmlInfo == null || this.mXmlInfo.mImplClassName == null) {
            PluginLogger.logFailure(PluginLogger.WORKFLOW_NODE_GETINSTANCE, "xml class name is null", this.mName);
            return null;
        } else if (!this.mIsLoaded && !loadPlugin(true)) {
            PluginLogger.logFailure(PluginLogger.WORKFLOW_NODE_GETINSTANCE, "plugin load fail", this.mName);
            return null;
        } else {
            try {
                P p = (P) PluginCenter.getInstance().getClassLoader().getPluginClassLoader().loadClass(this.mXmlInfo.mImplClassName).getConstructor(new Class[0]).newInstance(new Object[0]);
                PluginLogger.logSuccess(PluginLogger.WORKFLOW_NODE_GETINSTANCE, this.mName);
                return p;
            } catch (Throwable th) {
                th.printStackTrace();
                if (!validateFile()) {
                    PluginLogger.logFailure(PluginLogger.WORKFLOW_NODE_GETINSTANCE, String.valueOf(th.getClass().getName()) + " file not exist", this.mName);
                    return null;
                }
                PluginLogger.logFailure(PluginLogger.WORKFLOW_NODE_GETINSTANCE, String.valueOf(th.getClass().getName()) + " " + th.getMessage(), this.mName);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean validateClass() {
        if (this.mXmlInfo.mInterfaceName == null) {
            return false;
        }
        try {
            ClassLoader pluginClassLoader = PluginCenter.getInstance().getClassLoader().getPluginClassLoader();
            if (pluginClassLoader != null) {
                Class<?> loadClass = pluginClassLoader.loadClass(this.mXmlInfo.mImplClassName);
                if (loadClass != null) {
                    Class<?>[] interfaces = loadClass.getInterfaces();
                    if (interfaces == null || interfaces.length == 0) {
                        PluginLogger.logFailure(PluginLogger.WORKFLOW_NODE_LOAD, "no interface", this.mName);
                        return false;
                    }
                    for (Class<?> cls : interfaces) {
                        if (cls.getName().equals(this.mXmlInfo.mInterfaceName)) {
                            return true;
                        }
                    }
                    PluginLogger.logFailure(PluginLogger.WORKFLOW_NODE_LOAD, "no valid interface " + this.mXmlInfo.mInterfaceName, this.mName);
                    return false;
                }
                PluginLogger.logFailure(PluginLogger.WORKFLOW_NODE_LOAD, "load class fail " + this.mXmlInfo.mImplClassName, this.mName);
                return false;
            }
            PluginLogger.logFailure(PluginLogger.WORKFLOW_NODE_LOAD, "no classloader", this.mName);
            return false;
        } catch (ClassNotFoundException e) {
            BdLog.e(e);
            PluginLogger.logFailure(PluginLogger.WORKFLOW_NODE_LOAD, String.valueOf(e.getClass().getName()) + " class not found " + this.mXmlInfo.mImplClassName + " " + e.getMessage(), this.mName);
            return false;
        } catch (Exception e2) {
            BdLog.e(e2);
            PluginLogger.logFailure(PluginLogger.WORKFLOW_NODE_LOAD, String.valueOf(e2.getClass().getName()) + " load class exception " + this.mXmlInfo.mImplClassName + " " + e2.getMessage(), this.mName);
            return false;
        }
    }

    public int getVersion() {
        if (this.mXmlInfo == null) {
            return -1;
        }
        return this.mXmlInfo.mVersion;
    }

    private boolean validateFile() {
        return this.mName != null && PluginFileHelper.apkDir(this.mName).exists() && PluginFileHelper.pluginXML(this.mName).exists();
    }
}
