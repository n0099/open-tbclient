package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class b {
    private String content;
    private long create_time;
    private String forum_id;
    private String id;
    private int ixU;
    private int ixV;
    private int level;
    private String name;
    private List<b> sub_menu = new ArrayList();
    private long update_time;

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setForum_id(String str) {
        this.forum_id = str;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public void xv(int i) {
        this.ixU = i;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public int clt() {
        return this.ixV;
    }

    public void xw(int i) {
        this.ixV = i;
    }

    public void setCreate_time(long j) {
        this.create_time = j;
    }

    public void setUpdate_time(long j) {
        this.update_time = j;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public List<b> clu() {
        return this.sub_menu;
    }

    public void cX(List<b> list) {
        this.sub_menu = list;
    }
}
