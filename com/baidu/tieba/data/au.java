package com.baidu.tieba.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes.dex */
public class au {
    public Error a;
    private ForumData b;
    private int f;
    private int h;
    private AntiData j;
    private com.baidu.tbadk.core.data.n k;
    private int g = 10;
    private int i = -1;
    private boolean l = false;
    private an c = null;
    private ArrayList<an> d = new ArrayList<>();
    private int e = 1;

    public Error a() {
        return this.a;
    }

    public an b() {
        return this.c;
    }

    public void a(an anVar) {
        this.c = anVar;
    }

    public void a(int i) {
        this.i = i;
    }

    public int c() {
        if (this.i == -1) {
            this.i = this.h;
        }
        return this.i;
    }

    public void a(au auVar, boolean z) {
        if (auVar != null) {
            a(auVar.j());
            a(auVar.h());
            a(auVar.i());
            d(auVar.g());
            a(auVar.n());
            c(auVar.f());
            b(auVar.e());
            this.d.addAll(0, auVar.d());
        }
    }

    public void b(au auVar, boolean z) {
        if (auVar != null) {
            a(auVar.j());
            e(auVar.h());
            a(auVar.i());
            d(auVar.g());
            a(auVar.n());
            c(auVar.f());
            b(auVar.e());
            int size = this.d.size();
            if (z && size % this.g != 0) {
                for (int i = 0; i < size % this.g; i++) {
                    this.d.remove(this.d.size() - 1);
                }
            }
            this.d.addAll(auVar.d());
        }
    }

    public ArrayList<an> d() {
        return this.d;
    }

    public void a(ArrayList<an> arrayList) {
        this.d = arrayList;
    }

    public int e() {
        return this.e;
    }

    public void b(int i) {
        this.e = i;
    }

    public int f() {
        return this.f;
    }

    public void c(int i) {
        this.f = i;
    }

    public int g() {
        return this.g;
    }

    public void d(int i) {
        if (i != 0) {
            this.g = i;
        }
    }

    public int h() {
        return this.h;
    }

    public void e(int i) {
        this.h = i;
    }

    public void a(ForumData forumData) {
        this.b = forumData;
    }

    public ForumData i() {
        return this.b;
    }

    public void a(AntiData antiData) {
        this.j = antiData;
    }

    public AntiData j() {
        return this.j;
    }

    public void a(com.baidu.tbadk.core.data.n nVar) {
        this.k = nVar;
    }

    public boolean k() {
        return (this.k == null || this.c == null || this.k.q() == null || this.k.q().getUserId() == null || this.c.g() == null || this.c.g().getUserId() == null || !this.k.q().getUserId().equals(this.c.g().getUserId())) ? false : true;
    }

    public boolean l() {
        return this.l;
    }

    public boolean m() {
        return this.h < this.e && this.h * this.g < 200;
    }

    public com.baidu.tbadk.core.data.n n() {
        return this.k;
    }

    public static au a(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return null;
        }
        try {
            au auVar = new au();
            AntiData antiData = new AntiData();
            antiData.parserProtobuf(dataRes.anti);
            auVar.a(antiData);
            com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
            nVar.a(dataRes.thread);
            auVar.a(nVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            auVar.a(forumData);
            an anVar = new an();
            anVar.a(dataRes.post, context);
            auVar.a(anVar);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<an> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                an anVar2 = new an();
                anVar2.a(list.get(i), context);
                arrayList.add(anVar2);
            }
            auVar.a(arrayList);
            Page page = dataRes.page;
            int intValue = page.total_page.intValue();
            int intValue2 = page.page_size.intValue() == 0 ? page.page_size.intValue() : 10;
            int intValue3 = page.current_page.intValue();
            int intValue4 = page.total_count.intValue();
            auVar.e(intValue3);
            auVar.d(intValue2);
            auVar.c(intValue4);
            auVar.b(intValue);
            return auVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }

    public void a(boolean z) {
        this.l = z;
    }
}
