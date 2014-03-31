package com.baidu.tbplugin.exceptions;
/* loaded from: classes.dex */
public class InstallException extends Exception {
    public static final int ERR_ALREADY_INSTALLED = 9;
    public static final int ERR_DECOMPRESSED_FAILED = 3;
    public static final int ERR_DELETE_TEMPO_DIR_FAILED = 8;
    public static final int ERR_DIRECTORY_CREATED_FAILED = 2;
    public static final int ERR_MISSING_JAR_FILE = 4;
    public static final int ERR_MISSING_RES_FILE = 5;
    public static final int ERR_MISSING_SO_FILE = 6;
    public static final int ERR_NESTED_EXCEPTION = 7;
    public static final int ERR_NO_NAME = 1;
    public static final int ERR_PARSE_XML_FAILED = 16;
    private static final String[] a = {"Plugin has no name", "Cannot create required directory", "Zip cannot be decompressed", "Missing Jar", "Missing Resource", "Missing So", "Nested Exception", "Delete tempo dir failed", "Already installed", "Parse xml failed"};
    private static final long serialVersionUID = 8243233677679437456L;
    private int mErr;
    private String mMsg;
    private String mPluginName;

    public InstallException(String str, int i) {
        this.mPluginName = str;
        this.mErr = i;
        if (this.mErr > 0 && this.mErr < a.length) {
            this.mMsg = a[this.mErr - 1];
        } else {
            this.mMsg = "Unknown error";
        }
    }

    public int getErr() {
        return this.mErr;
    }

    public String getPluginName() {
        return this.mPluginName;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.mMsg;
    }
}
