package com.baidu.tieba.im.message;

import java.util.List;
/* loaded from: classes.dex */
public class RequestUpdateGroupAlbumMessage extends RequestUpdateGroupMessage {
    private static final long serialVersionUID = 1284534837795929418L;
    private String album;

    public RequestUpdateGroupAlbumMessage(List<String> list) {
        this.album = null;
        this.album = a(list);
    }

    public RequestUpdateGroupAlbumMessage(String str) {
        this.album = null;
        this.album = str;
    }

    private String a(List<String> list) {
        int size = list.size();
        String str = null;
        for (int i = 0; i < size; i++) {
            str = str + list.get(i);
            if (i != size - 1) {
                str = str + ",";
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
}
