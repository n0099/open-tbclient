package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private int aWA;
    private long aWB;
    private int aWz;
    private String content;
    private long create_time;
    private String forum_id;
    private String id;
    private int level;
    private String name;
    private List<c> sub_menu = new ArrayList();

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

    public void fA(int i) {
        this.aWz = i;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public int Ml() {
        return this.aWA;
    }

    public void fB(int i) {
        this.aWA = i;
    }

    public void setCreate_time(long j) {
        this.create_time = j;
    }

    public void T(long j) {
        this.aWB = j;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public List<c> Mm() {
        return this.sub_menu;
    }

    public void al(List<c> list) {
        this.sub_menu = list;
    }
}
