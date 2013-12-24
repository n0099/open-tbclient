package com.baidu.tieba.im.data;

import com.baidu.tieba.util.al;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class a implements al {
    private int a;
    private String b;
    private String c;

    @Override // com.baidu.tieba.util.al
    public LinkedList<String> getImageUrl() {
        return null;
    }

    @Override // com.baidu.tieba.util.al
    public LinkedList<String> getPhotoUrl() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(c());
        return linkedList;
    }

    @Override // com.baidu.tieba.util.al
    public LinkedList<String> getForumPhotoUrl() {
        return null;
    }

    public int a() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    public String b() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public String c() {
        return this.c;
    }

    public void b(String str) {
        this.c = str;
    }
}
