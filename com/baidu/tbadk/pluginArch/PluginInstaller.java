package com.baidu.tbadk.pluginArch;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.pluginArch.exception.InstallException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class PluginInstaller {
    private static final String PLUGIN_FILE_SUFFIX = ".tbplugin";
    private static final int PROGRESS_DECOMPRESS_FILES = 1;
    private static BdAsyncTaskParallel parallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private Context mContext;
    private InstallCallback mInstallCallback;
    private String mPluginName;
    private String mZipFilePath;

    public PluginInstaller(String str, String str2, InstallCallback installCallback) {
        this.mZipFilePath = str;
        this.mPluginName = str2;
        this.mInstallCallback = installCallback;
    }

    public PluginInstaller(Context context, String str, InstallCallback installCallback) {
        this.mContext = context;
        this.mPluginName = str;
        this.mInstallCallback = installCallback;
    }

    public synchronized void install() {
        InstallWorker installWorker = new InstallWorker();
        installWorker.setParallel(parallel);
        installWorker.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class InstallWorker extends BdAsyncTask<Void, Integer, Void> {
        private String mInstallExceptionMsg = null;
        private int mErrorNum = 0;

        InstallWorker() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public synchronized Void doInBackground(Void... voidArr) {
            try {
                try {
                    decompressFiles(PluginFileHelper.pluginDir(PluginInstaller.this.mPluginName));
                    this.mErrorNum = 0;
                    this.mInstallExceptionMsg = null;
                } catch (InstallException e) {
                    this.mInstallExceptionMsg = e.getMessage();
                    this.mErrorNum = e.getErr();
                }
            } catch (StackOverflowError e2) {
                this.mInstallExceptionMsg = e2.getMessage();
                this.mErrorNum = -1;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Void r4) {
            if (PluginInstaller.this.mInstallCallback != null) {
                PluginInstaller.this.mInstallCallback.onFinish(this.mErrorNum, this.mInstallExceptionMsg);
                if (this.mErrorNum == 0) {
                    PluginLogger.logSuccess(PluginLogger.WORKFLOW_NODE_INSTALL, PluginInstaller.this.mPluginName);
                } else {
                    PluginLogger.logFailure(PluginLogger.WORKFLOW_NODE_INSTALL, this.mInstallExceptionMsg, PluginInstaller.this.mPluginName);
                }
            }
            super.onPostExecute((InstallWorker) r4);
        }

        private void decompressFiles(File file) {
            publishProgress(1, 0);
            InputStream inputStream = null;
            try {
                if (PluginInstaller.this.mContext == null) {
                    if (PluginInstaller.this.mZipFilePath != null) {
                        inputStream = new FileInputStream(new File(PluginInstaller.this.mZipFilePath));
                    }
                } else {
                    inputStream = PluginInstaller.this.mContext.getAssets().open(String.valueOf(PluginInstaller.this.mPluginName) + PluginInstaller.PLUGIN_FILE_SUFFIX);
                }
                if (inputStream != null) {
                    new Decompress(inputStream, file.getAbsolutePath()).unzip();
                    publishProgress(1, Integer.valueOf((int) MotionEventCompat.ACTION_MASK));
                    return;
                }
                throw new InstallException(PluginInstaller.this.mPluginName, 2);
            } catch (IOException e) {
                throw new InstallException(PluginInstaller.this.mPluginName, 3);
            }
        }
    }
}
