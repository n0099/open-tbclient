package com.baidu.tieba.hottopic.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.data.q;
import com.baidu.tbadk.core.data.z;
import java.util.ArrayList;
import java.util.List;
import tbclient.Hottopic.DataRes;
import tbclient.Hottopic.GoodThread;
import tbclient.Hottopic.MagicPostList;
/* loaded from: classes.dex */
public class c {
    private ArrayList<u> bHk;
    private d bHl = null;
    private List<g> bHm = null;
    private List<i> bHn = null;
    private j bHo = null;
    private e bHp = null;
    private a bHq = null;
    private a bHr = null;
    private b bHs = null;
    private q bHj = null;

    public c() {
        this.bHk = null;
        this.bHk = new ArrayList<>();
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.topic_info != null) {
                this.bHl = new d();
                this.bHl.a(dataRes.topic_info);
            }
            if (dataRes.magic_post != null && dataRes.magic_post.mc_post_list != null && dataRes.magic_post.mc_post_list.size() != 0 && !StringUtils.isNull(dataRes.magic_post.magic_title)) {
                this.bHm = new ArrayList();
                g gVar = new g();
                gVar.a(dataRes.magic_post);
                this.bHm.add(gVar);
                for (MagicPostList magicPostList : dataRes.magic_post.mc_post_list) {
                    if (magicPostList.user_info != null && !StringUtils.isNull(magicPostList.user_info.user_name) && !StringUtils.isNull(magicPostList.content_text)) {
                        g gVar2 = new g();
                        gVar2.a(magicPostList);
                        this.bHm.add(gVar2);
                    }
                }
            }
            if (dataRes.thread_module != null) {
                this.bHn = new ArrayList();
                if (dataRes.thread_module.thread_module_1 != null && dataRes.thread_module.thread_module_1.thread_list != null && dataRes.thread_module.thread_module_1.thread_list.size() != 0 && !StringUtils.isNull(dataRes.thread_module.thread_module_1.module_name)) {
                    i iVar = new i();
                    iVar.a(dataRes.thread_module.thread_module_1);
                    this.bHn.add(iVar);
                    int size = dataRes.thread_module.thread_module_1.thread_list.size();
                    int i = size > 3 ? 3 : size;
                    for (int i2 = 0; i2 < i; i2++) {
                        GoodThread goodThread = dataRes.thread_module.thread_module_1.thread_list.get(i2);
                        if (!StringUtils.isNull(goodThread.title)) {
                            i iVar2 = new i();
                            iVar2.a(goodThread);
                            this.bHn.add(iVar2);
                        }
                    }
                }
                if (dataRes.thread_module.thread_module_2 != null && dataRes.thread_module.thread_module_2.thread_list != null && dataRes.thread_module.thread_module_2.thread_list.size() != 0 && !StringUtils.isNull(dataRes.thread_module.thread_module_2.module_name)) {
                    i iVar3 = new i();
                    iVar3.a(dataRes.thread_module.thread_module_2);
                    this.bHn.add(iVar3);
                    int size2 = dataRes.thread_module.thread_module_2.thread_list.size();
                    int i3 = size2 > 3 ? 3 : size2;
                    for (int i4 = 0; i4 < i3; i4++) {
                        GoodThread goodThread2 = dataRes.thread_module.thread_module_2.thread_list.get(i4);
                        if (!StringUtils.isNull(goodThread2.title)) {
                            i iVar4 = new i();
                            iVar4.a(goodThread2);
                            this.bHn.add(iVar4);
                        }
                    }
                }
                if (dataRes.thread_module.thread_module_3 != null && dataRes.thread_module.thread_module_3.thread_list != null && dataRes.thread_module.thread_module_3.thread_list.size() != 0 && !StringUtils.isNull(dataRes.thread_module.thread_module_3.module_name)) {
                    i iVar5 = new i();
                    iVar5.a(dataRes.thread_module.thread_module_3);
                    this.bHn.add(iVar5);
                    int size3 = dataRes.thread_module.thread_module_3.thread_list.size();
                    int i5 = size3 <= 3 ? size3 : 3;
                    for (int i6 = 0; i6 < i5; i6++) {
                        GoodThread goodThread3 = dataRes.thread_module.thread_module_3.thread_list.get(i6);
                        if (!StringUtils.isNull(goodThread3.title)) {
                            i iVar6 = new i();
                            iVar6.a(goodThread3);
                            this.bHn.add(iVar6);
                        }
                    }
                }
            }
            if (dataRes.relate_forum != null && dataRes.relate_forum.size() != 0) {
                this.bHo = new j();
                this.bHo.aM(dataRes.relate_forum);
            }
            if (dataRes.pk_module != null && !StringUtils.isNull(dataRes.pk_module.ques_desc)) {
                this.bHp = new e();
                this.bHp.a(dataRes.pk_module);
            }
            if (dataRes.bless_module != null) {
                this.bHq = new a();
                this.bHq.a(dataRes.bless_module);
            }
            if (dataRes.candle_module != null) {
                this.bHr = new a();
                this.bHr.a(dataRes.candle_module);
            }
            if (dataRes.hot_thread != null && dataRes.hot_thread.thread_list != null && dataRes.hot_thread.thread_list.size() != 0 && !StringUtils.isNull(dataRes.hot_thread.hot_title)) {
                this.bHs = new b();
                this.bHs.a(dataRes.hot_thread);
                if (dataRes.hot_thread.page != null) {
                    this.bHj = new q();
                    this.bHj.a(dataRes.hot_thread.page);
                }
            }
            VC();
        }
    }

    public void a(b bVar) {
        if (bVar != null && bVar.bcS != null && bVar.bcS.size() != 0) {
            for (z zVar : bVar.bcS) {
                this.bHk.add(zVar);
            }
        }
    }

    public d Vv() {
        return this.bHl;
    }

    public e Vw() {
        return this.bHp;
    }

    public a Vx() {
        return this.bHq;
    }

    public a Vy() {
        return this.bHr;
    }

    public j Vz() {
        return this.bHo;
    }

    public ArrayList<u> VA() {
        return this.bHk;
    }

    public q VB() {
        return this.bHj;
    }

    private ArrayList<u> VC() {
        if (this.bHl != null && !StringUtils.isNull(this.bHl.aQB) && !StringUtils.isNull(this.bHl.bHt)) {
            this.bHk.add(this.bHl);
        }
        if (this.bHo != null && this.bHo.getCount() > 0) {
            this.bHk.add(this.bHo);
        }
        if (this.bHp != null) {
            this.bHk.add(this.bHp);
        }
        if (this.bHm != null && this.bHm.size() != 0) {
            if (this.bHm.size() > 8) {
                this.bHm = this.bHm.subList(0, 8);
            }
            for (g gVar : this.bHm) {
                this.bHk.add(gVar);
            }
        }
        if (this.bHn != null && this.bHn.size() != 0) {
            for (i iVar : this.bHn) {
                this.bHk.add(iVar);
            }
        }
        if (this.bHs != null && this.bHs.bcS != null && this.bHs.bcS.size() > 0) {
            this.bHk.add(this.bHs);
            for (z zVar : this.bHs.bcS) {
                this.bHk.add(zVar);
            }
        }
        return this.bHk;
    }
}
