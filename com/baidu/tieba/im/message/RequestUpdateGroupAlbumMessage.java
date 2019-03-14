package com.baidu.tieba.im.message;

import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import protobuf.GroupInfo;
/* loaded from: classes5.dex */
public class RequestUpdateGroupAlbumMessage extends RequestUpdateGroupMessage {
    private String album;

    public RequestUpdateGroupAlbumMessage(List<String> list) {
        this.album = null;
        this.album = generateAlbums(list);
    }

    public RequestUpdateGroupAlbumMessage(String str) {
        this.album = null;
        this.album = str;
    }

    private String generateAlbums(List<String> list) {
        StringBuffer stringBuffer = new StringBuffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            stringBuffer.append(list.get(i));
            if (i != size - 1) {
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
        }
        return stringBuffer.toString();
    }

    public String getAlbum() {
        return this.album;
    }

    public void setAlbum(String str) {
        this.album = str;
    }

    @Override // com.baidu.tieba.im.message.RequestUpdateGroupMessage
    protected void subEncode(GroupInfo.Builder builder) {
        builder.album = getAlbum();
    }
}
