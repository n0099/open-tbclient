package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private int aXT;
    private int aXU;
    private long aXV;
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

    public void fF(int i) {
        this.aXT = i;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public int MH() {
        return this.aXU;
    }

    public void fG(int i) {
        this.aXU = i;
    }

    public void setCreate_time(long j) {
        this.create_time = j;
    }

    public void T(long j) {
        this.aXV = j;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public List<d> MI() {
        return this.sub_menu;
    }

    public void an(List<d> list) {
        this.sub_menu = list;
    }
}
