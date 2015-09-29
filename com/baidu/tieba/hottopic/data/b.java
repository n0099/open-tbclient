package com.baidu.tieba.hottopic.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.data.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.Hottopic.DataRes;
import tbclient.Hottopic.MagicPostList;
/* loaded from: classes.dex */
public class b {
    private ArrayList<u> boH;
    private c boI = null;
    private List<e> boJ = null;
    private g boK = null;
    private a boL = null;
    private n boG = null;

    public b() {
        this.boH = null;
        this.boH = new ArrayList<>();
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.topic_info != null) {
                this.boI = new c();
                this.boI.a(dataRes.topic_info);
            }
            if (dataRes.magic_post != null && dataRes.magic_post.mc_post_list != null && dataRes.magic_post.mc_post_list.size() != 0 && !StringUtils.isNull(dataRes.magic_post.magic_title)) {
                this.boJ = new ArrayList();
                e eVar = new e();
                eVar.a(dataRes.magic_post);
                this.boJ.add(eVar);
                for (MagicPostList magicPostList : dataRes.magic_post.mc_post_list) {
                    if (magicPostList.user_info != null && !StringUtils.isNull(magicPostList.user_info.user_name) && !StringUtils.isNull(magicPostList.content_text)) {
                        e eVar2 = new e();
                        eVar2.a(magicPostList);
                        this.boJ.add(eVar2);
                    }
                }
            }
            if (dataRes.relate_forum != null && dataRes.relate_forum.size() != 0) {
                this.boK = new g();
                this.boK.aA(dataRes.relate_forum);
            }
            if (dataRes.hot_thread != null && dataRes.hot_thread.thread_list != null && dataRes.hot_thread.thread_list.size() != 0 && !StringUtils.isNull(dataRes.hot_thread.hot_title)) {
                this.boL = new a();
                this.boL.a(dataRes.hot_thread);
                if (dataRes.hot_thread.page != null) {
                    this.boG = new n();
                    this.boG.a(dataRes.hot_thread.page);
                }
            }
            QW();
        }
    }

    public void a(a aVar) {
        if (aVar != null && aVar.aTp != null && aVar.aTp.size() != 0) {
            for (v vVar : aVar.aTp) {
                this.boH.add(vVar);
            }
        }
    }

    public g QT() {
        return this.boK;
    }

    public ArrayList<u> QU() {
        return this.boH;
    }

    public n QV() {
        return this.boG;
    }

    private ArrayList<u> QW() {
        if (this.boI != null && !StringUtils.isNull(this.boI.bou) && !StringUtils.isNull(this.boI.boN)) {
            this.boH.add(this.boI);
        }
        if (this.boK != null && this.boK.getCount() > 0) {
            this.boH.add(this.boK);
        }
        if (this.boJ != null && this.boJ.size() != 0) {
            if (this.boJ.size() > 5) {
                this.boJ = this.boJ.subList(0, 5);
            }
            for (e eVar : this.boJ) {
                this.boH.add(eVar);
            }
        }
        if (this.boL != null && this.boL.aTp != null && this.boL.aTp.size() > 0) {
            this.boH.add(this.boL);
            for (v vVar : this.boL.aTp) {
                this.boH.add(vVar);
            }
        }
        return this.boH;
    }
}
