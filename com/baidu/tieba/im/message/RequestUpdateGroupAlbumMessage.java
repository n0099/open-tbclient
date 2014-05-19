package com.baidu.tieba.im.message;

import java.util.List;
import protobuf.GroupInfo;
/* loaded from: classes.dex */
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
        int size = list.size();
        String str = null;
        for (int i = 0; i < size; i++) {
            str = String.valueOf(str) + list.get(i);
            if (i != size - 1) {
                str = String.valueOf(str) + ",";
            }
        }
        return str;
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
