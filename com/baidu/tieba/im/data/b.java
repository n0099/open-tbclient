package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class b {
    private String content;
    private long create_time;
    private String forum_id;
    private String id;
    private int kwt;
    private int kwu;
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

    public void Cz(int i) {
        this.kwt = i;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public int cTm() {
        return this.kwu;
    }

    public void CA(int i) {
        this.kwu = i;
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

    public List<b> cTn() {
        return this.sub_menu;
    }

    public void et(List<b> list) {
        this.sub_menu = list;
    }
}
