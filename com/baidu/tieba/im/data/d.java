package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private int bcq;
    private int bcr;
    private long bcs;
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

    public void fI(int i) {
        this.bcq = i;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public int PO() {
        return this.bcr;
    }

    public void fJ(int i) {
        this.bcr = i;
    }

    public void setCreate_time(long j) {
        this.create_time = j;
    }

    public void X(long j) {
        this.bcs = j;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public List<d> PP() {
        return this.sub_menu;
    }

    public void az(List<d> list) {
        this.sub_menu = list;
    }
}
