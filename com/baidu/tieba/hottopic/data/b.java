package com.baidu.tieba.hottopic.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.data.o;
import com.baidu.tbadk.core.data.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.Hottopic.DataRes;
import tbclient.Hottopic.MagicPostList;
/* loaded from: classes.dex */
public class b {
    private ArrayList<u> bpw;
    private c bpx = null;
    private List<e> bpy = null;
    private g bpz = null;
    private a bpA = null;
    private o bpv = null;

    public b() {
        this.bpw = null;
        this.bpw = new ArrayList<>();
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.topic_info != null) {
                this.bpx = new c();
                this.bpx.a(dataRes.topic_info);
            }
            if (dataRes.magic_post != null && dataRes.magic_post.mc_post_list != null && dataRes.magic_post.mc_post_list.size() != 0 && !StringUtils.isNull(dataRes.magic_post.magic_title)) {
                this.bpy = new ArrayList();
                e eVar = new e();
                eVar.a(dataRes.magic_post);
                this.bpy.add(eVar);
                for (MagicPostList magicPostList : dataRes.magic_post.mc_post_list) {
                    if (magicPostList.user_info != null && !StringUtils.isNull(magicPostList.user_info.user_name) && !StringUtils.isNull(magicPostList.content_text)) {
                        e eVar2 = new e();
                        eVar2.a(magicPostList);
                        this.bpy.add(eVar2);
                    }
                }
            }
            if (dataRes.relate_forum != null && dataRes.relate_forum.size() != 0) {
                this.bpz = new g();
                this.bpz.aE(dataRes.relate_forum);
            }
            if (dataRes.hot_thread != null && dataRes.hot_thread.thread_list != null && dataRes.hot_thread.thread_list.size() != 0 && !StringUtils.isNull(dataRes.hot_thread.hot_title)) {
                this.bpA = new a();
                this.bpA.a(dataRes.hot_thread);
                if (dataRes.hot_thread.page != null) {
                    this.bpv = new o();
                    this.bpv.a(dataRes.hot_thread.page);
                }
            }
            Ro();
        }
    }

    public void a(a aVar) {
        if (aVar != null && aVar.aTI != null && aVar.aTI.size() != 0) {
            for (w wVar : aVar.aTI) {
                this.bpw.add(wVar);
            }
        }
    }

    public g Rl() {
        return this.bpz;
    }

    public ArrayList<u> Rm() {
        return this.bpw;
    }

    public o Rn() {
        return this.bpv;
    }

    private ArrayList<u> Ro() {
        if (this.bpx != null && !StringUtils.isNull(this.bpx.bpj) && !StringUtils.isNull(this.bpx.bpC)) {
            this.bpw.add(this.bpx);
        }
        if (this.bpz != null && this.bpz.getCount() > 0) {
            this.bpw.add(this.bpz);
        }
        if (this.bpy != null && this.bpy.size() != 0) {
            if (this.bpy.size() > 5) {
                this.bpy = this.bpy.subList(0, 5);
            }
            for (e eVar : this.bpy) {
                this.bpw.add(eVar);
            }
        }
        if (this.bpA != null && this.bpA.aTI != null && this.bpA.aTI.size() > 0) {
            this.bpw.add(this.bpA);
            for (w wVar : this.bpA.aTI) {
                this.bpw.add(wVar);
            }
        }
        return this.bpw;
    }
}
