package com.baidu.tieba.im.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private int aVh;
    private int aVi;
    private long aVj;
    private String content;
    private long create_time;
    private String forum_id;
    private String id;
    private int level;
    private String name;
    private List<f> sub_menu = new ArrayList();

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

    public void fx(int i) {
        this.aVh = i;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public int Ms() {
        return this.aVi;
    }

    public void fy(int i) {
        this.aVi = i;
    }

    public void setCreate_time(long j) {
        this.create_time = j;
    }

    public void M(long j) {
        this.aVj = j;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public List<f> Mt() {
        return this.sub_menu;
    }

    public void Q(List<f> list) {
        this.sub_menu = list;
    }
}
