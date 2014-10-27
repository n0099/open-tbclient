package com.baidu.tbadk.message.http;
/* loaded from: classes.dex */
public class GameHttpResponsedMessage extends TbHttpResponsedMessage {
    private static final String SCREEN_ORIENTATION_ATTR = "screen-orientation";
    private String mScreenOrientation;

    public GameHttpResponsedMessage(int i) {
        super(i);
    }

    protected String extractMetaValue(String str, String str2) {
        int lastIndexOf;
        int indexOf;
        int length;
        int indexOf2;
        int indexOf3 = str.indexOf("name=\"" + str2 + "\"");
        if (indexOf3 == -1 || (lastIndexOf = str.lastIndexOf("<meta ", indexOf3)) == -1 || (indexOf = str.indexOf("content=\"", lastIndexOf)) == -1 || (indexOf2 = str.indexOf("\"", (length = indexOf + "content=\"".length()))) == -1) {
            return null;
        }
        if (length == indexOf2) {
            return "";
        }
        return str.substring(length, indexOf2);
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) {
        this.mScreenOrientation = extractMetaValue(new String(bArr, getCharset()), SCREEN_ORIENTATION_ATTR);
    }

    public String getScreenOrientation() {
        return this.mScreenOrientation;
    }
}
