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
    private ArrayList<u> bDG;
    private d bDH = null;
    private List<g> bDI = null;
    private List<i> bDJ = null;
    private j bDK = null;
    private e bDL = null;
    private a bDM = null;
    private a bDN = null;
    private b bDO = null;
    private q bDF = null;

    public c() {
        this.bDG = null;
        this.bDG = new ArrayList<>();
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.topic_info != null) {
                this.bDH = new d();
                this.bDH.a(dataRes.topic_info);
            }
            if (dataRes.magic_post != null && dataRes.magic_post.mc_post_list != null && dataRes.magic_post.mc_post_list.size() != 0 && !StringUtils.isNull(dataRes.magic_post.magic_title)) {
                this.bDI = new ArrayList();
                g gVar = new g();
                gVar.a(dataRes.magic_post);
                this.bDI.add(gVar);
                for (MagicPostList magicPostList : dataRes.magic_post.mc_post_list) {
                    if (magicPostList.user_info != null && !StringUtils.isNull(magicPostList.user_info.user_name) && !StringUtils.isNull(magicPostList.content_text)) {
                        g gVar2 = new g();
                        gVar2.a(magicPostList);
                        this.bDI.add(gVar2);
                    }
                }
            }
            if (dataRes.thread_module != null) {
                this.bDJ = new ArrayList();
                if (dataRes.thread_module.thread_module_1 != null && dataRes.thread_module.thread_module_1.thread_list != null && dataRes.thread_module.thread_module_1.thread_list.size() != 0 && !StringUtils.isNull(dataRes.thread_module.thread_module_1.module_name)) {
                    i iVar = new i();
                    iVar.a(dataRes.thread_module.thread_module_1);
                    this.bDJ.add(iVar);
                    int size = dataRes.thread_module.thread_module_1.thread_list.size();
                    int i = size > 3 ? 3 : size;
                    for (int i2 = 0; i2 < i; i2++) {
                        GoodThread goodThread = dataRes.thread_module.thread_module_1.thread_list.get(i2);
                        if (!StringUtils.isNull(goodThread.title)) {
                            i iVar2 = new i();
                            iVar2.a(goodThread);
                            this.bDJ.add(iVar2);
                        }
                    }
                }
                if (dataRes.thread_module.thread_module_2 != null && dataRes.thread_module.thread_module_2.thread_list != null && dataRes.thread_module.thread_module_2.thread_list.size() != 0 && !StringUtils.isNull(dataRes.thread_module.thread_module_2.module_name)) {
                    i iVar3 = new i();
                    iVar3.a(dataRes.thread_module.thread_module_2);
                    this.bDJ.add(iVar3);
                    int size2 = dataRes.thread_module.thread_module_2.thread_list.size();
                    int i3 = size2 > 3 ? 3 : size2;
                    for (int i4 = 0; i4 < i3; i4++) {
                        GoodThread goodThread2 = dataRes.thread_module.thread_module_2.thread_list.get(i4);
                        if (!StringUtils.isNull(goodThread2.title)) {
                            i iVar4 = new i();
                            iVar4.a(goodThread2);
                            this.bDJ.add(iVar4);
                        }
                    }
                }
                if (dataRes.thread_module.thread_module_3 != null && dataRes.thread_module.thread_module_3.thread_list != null && dataRes.thread_module.thread_module_3.thread_list.size() != 0 && !StringUtils.isNull(dataRes.thread_module.thread_module_3.module_name)) {
                    i iVar5 = new i();
                    iVar5.a(dataRes.thread_module.thread_module_3);
                    this.bDJ.add(iVar5);
                    int size3 = dataRes.thread_module.thread_module_3.thread_list.size();
                    int i5 = size3 <= 3 ? size3 : 3;
                    for (int i6 = 0; i6 < i5; i6++) {
                        GoodThread goodThread3 = dataRes.thread_module.thread_module_3.thread_list.get(i6);
                        if (!StringUtils.isNull(goodThread3.title)) {
                            i iVar6 = new i();
                            iVar6.a(goodThread3);
                            this.bDJ.add(iVar6);
                        }
                    }
                }
            }
            if (dataRes.relate_forum != null && dataRes.relate_forum.size() != 0) {
                this.bDK = new j();
                this.bDK.aP(dataRes.relate_forum);
            }
            if (dataRes.pk_module != null && !StringUtils.isNull(dataRes.pk_module.ques_desc)) {
                this.bDL = new e();
                this.bDL.a(dataRes.pk_module);
            }
            if (dataRes.bless_module != null) {
                this.bDM = new a();
                this.bDM.a(dataRes.bless_module);
            }
            if (dataRes.candle_module != null) {
                this.bDN = new a();
                this.bDN.a(dataRes.candle_module);
            }
            if (dataRes.hot_thread != null && dataRes.hot_thread.thread_list != null && dataRes.hot_thread.thread_list.size() != 0 && !StringUtils.isNull(dataRes.hot_thread.hot_title)) {
                this.bDO = new b();
                this.bDO.a(dataRes.hot_thread);
                if (dataRes.hot_thread.page != null) {
                    this.bDF = new q();
                    this.bDF.a(dataRes.hot_thread.page);
                }
            }
            Uz();
        }
    }

    public void a(b bVar) {
        if (bVar != null && bVar.aYW != null && bVar.aYW.size() != 0) {
            for (z zVar : bVar.aYW) {
                this.bDG.add(zVar);
            }
        }
    }

    public d Us() {
        return this.bDH;
    }

    public e Ut() {
        return this.bDL;
    }

    public a Uu() {
        return this.bDM;
    }

    public a Uv() {
        return this.bDN;
    }

    public j Uw() {
        return this.bDK;
    }

    public ArrayList<u> Ux() {
        return this.bDG;
    }

    public q Uy() {
        return this.bDF;
    }

    private ArrayList<u> Uz() {
        if (this.bDH != null && !StringUtils.isNull(this.bDH.bBb) && !StringUtils.isNull(this.bDH.bDQ)) {
            this.bDG.add(this.bDH);
        }
        if (this.bDK != null && this.bDK.getCount() > 0) {
            this.bDG.add(this.bDK);
        }
        if (this.bDL != null) {
            this.bDG.add(this.bDL);
        }
        if (this.bDI != null && this.bDI.size() != 0) {
            if (this.bDI.size() > 8) {
                this.bDI = this.bDI.subList(0, 8);
            }
            for (g gVar : this.bDI) {
                this.bDG.add(gVar);
            }
        }
        if (this.bDJ != null && this.bDJ.size() != 0) {
            for (i iVar : this.bDJ) {
                this.bDG.add(iVar);
            }
        }
        if (this.bDO != null && this.bDO.aYW != null && this.bDO.aYW.size() > 0) {
            this.bDG.add(this.bDO);
            for (z zVar : this.bDO.aYW) {
                this.bDG.add(zVar);
            }
        }
        return this.bDG;
    }
}
