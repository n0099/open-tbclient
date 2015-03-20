package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private int bca;
    private int bcb;
    private long bcc;
    private String content;
    private long create_time;
    private String forum_id;
    private String id;
    private int level;
    private String name;
    private List<d> sub_menu = new ArrayList();

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

    public void fG(int i) {
        this.bca = i;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public int PB() {
        return this.bcb;
    }

    public void fH(int i) {
        this.bcb = i;
    }

    public void setCreate_time(long j) {
        this.create_time = j;
    }

    public void X(long j) {
        this.bcc = j;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public List<d> PC() {
        return this.sub_menu;
    }

    public void ax(List<d> list) {
        this.sub_menu = list;
    }
}
