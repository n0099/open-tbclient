package com.baidu.tbadk.pluginArch;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.m;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class PluginDexLoader {
    private Context mContext;
    private ClassLoader mContextClassLoader;
    private ClassLoader mPluginClassLoader;
    private LinkedList<File> mDexFiles = new LinkedList<>();
    private LinkedList<File> mSoLibFiles = new LinkedList<>();

    public PluginDexLoader(Context context) {
        this.mContext = context;
        this.mContextClassLoader = this.mContext.getClassLoader();
        this.mPluginClassLoader = this.mContextClassLoader;
    }

    public void add(File file, File file2) {
        m.ft();
        if (file != null) {
            this.mDexFiles.add(file);
        }
        if (file2 != null) {
            this.mSoLibFiles.add(file2);
        }
        if (file != null || file2 != null) {
            load();
        }
    }

    public void add(LinkedList<File> linkedList, LinkedList<File> linkedList2) {
        m.ft();
        if (linkedList != null && linkedList.size() > 0) {
            this.mDexFiles.addAll(linkedList);
        }
        if (linkedList2 != null && linkedList2.size() > 0) {
            this.mSoLibFiles.addAll(linkedList2);
        }
        if ((linkedList != null && linkedList.size() > 0) || (linkedList2 != null && linkedList2.size() > 0)) {
            load();
        }
    }

    public ClassLoader getPluginClassLoader() {
        return this.mPluginClassLoader;
    }

    private void load() {
        String str;
        String str2 = "";
        if (this.mDexFiles.size() > 0) {
            StringBuilder sb = new StringBuilder();
            Iterator<File> it = this.mDexFiles.iterator();
            while (it.hasNext()) {
                sb.append(it.next().getAbsolutePath());
                sb.append(File.pathSeparator);
            }
            if (sb.length() > 0) {
                str2 = sb.substring(0, sb.length() - 1);
            }
        }
        StringBuilder sb2 = new StringBuilder();
        try {
            if (this.mSoLibFiles.size() > 0) {
                Iterator<File> it2 = this.mSoLibFiles.iterator();
                while (it2.hasNext()) {
                    File next = it2.next();
                    File[] listFiles = next.listFiles();
                    if (listFiles != null && listFiles.length != 0) {
                        sb2.append(next);
                        sb2.append(File.pathSeparator);
                    }
                }
                if (sb2.length() > 0) {
                    str = sb2.substring(0, sb2.length() - 1);
                    this.mPluginClassLoader = new DexClassLoader(str2, PluginFileHelper.optimisedDir().getAbsolutePath(), str, this.mPluginClassLoader);
                    hackClassLoader(this.mContext, this.mPluginClassLoader);
                    return;
                }
            }
            this.mPluginClassLoader = new DexClassLoader(str2, PluginFileHelper.optimisedDir().getAbsolutePath(), str, this.mPluginClassLoader);
            hackClassLoader(this.mContext, this.mPluginClassLoader);
            return;
        } catch (Throwable th) {
            BdLog.e(th);
            PluginLogger.logFailure(PluginLogger.WORKFLOW_NODE_DEXLOADER, String.valueOf(th.getClass().getName()) + " new loader err:" + th.getMessage() + " " + str2, null);
            return;
        }
        str = "";
    }

    private void hackClassLoader(Context context, ClassLoader classLoader) {
        Object obj;
        try {
            if (Build.VERSION.SDK_INT <= 7) {
                obj = getField(Class.forName("android.app.ApplicationContext"), "mPackageInfo").get(context.getApplicationContext());
            } else {
                obj = getField(Class.forName("android.app.ContextImpl"), "mPackageInfo").get(getField(ContextWrapper.class, "mBase").get(context.getApplicationContext()));
            }
            getField(obj.getClass(), "mClassLoader").set(obj, classLoader);
            PluginLogger.logSuccess(PluginLogger.WORKFLOW_NODE_DEXLOADER);
        } catch (IllegalAccessException e) {
            BdLog.e("IllegalAccessException");
            PluginLogger.logFailure(PluginLogger.WORKFLOW_NODE_DEXLOADER, String.valueOf(e.getClass().getName()) + " " + e.getMessage(), null);
        } catch (IllegalArgumentException e2) {
            BdLog.e("IllegalArgumentException");
            PluginLogger.logFailure(PluginLogger.WORKFLOW_NODE_DEXLOADER, String.valueOf(e2.getClass().getName()) + " " + e2.getMessage(), null);
        } catch (Throwable th) {
            BdLog.e("Throwable " + th.getMessage());
            PluginLogger.logFailure(PluginLogger.WORKFLOW_NODE_DEXLOADER, String.valueOf(th.getClass().getName()) + " " + th.getMessage(), null);
        }
    }

    private Field getField(Class<?> cls, String str) {
        Field[] declaredFields;
        for (Field field : cls.getDeclaredFields()) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            if (field.getName().equals(str)) {
                return field;
            }
        }
        return null;
    }
}
