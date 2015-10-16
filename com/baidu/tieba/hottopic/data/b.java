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
    private ArrayList<u> boS;
    private c boT = null;
    private List<e> boU = null;
    private g boV = null;
    private a boW = null;
    private o boR = null;

    public b() {
        this.boS = null;
        this.boS = new ArrayList<>();
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.topic_info != null) {
                this.boT = new c();
                this.boT.a(dataRes.topic_info);
            }
            if (dataRes.magic_post != null && dataRes.magic_post.mc_post_list != null && dataRes.magic_post.mc_post_list.size() != 0 && !StringUtils.isNull(dataRes.magic_post.magic_title)) {
                this.boU = new ArrayList();
                e eVar = new e();
                eVar.a(dataRes.magic_post);
                this.boU.add(eVar);
                for (MagicPostList magicPostList : dataRes.magic_post.mc_post_list) {
                    if (magicPostList.user_info != null && !StringUtils.isNull(magicPostList.user_info.user_name) && !StringUtils.isNull(magicPostList.content_text)) {
                        e eVar2 = new e();
                        eVar2.a(magicPostList);
                        this.boU.add(eVar2);
                    }
                }
            }
            if (dataRes.relate_forum != null && dataRes.relate_forum.size() != 0) {
                this.boV = new g();
                this.boV.aA(dataRes.relate_forum);
            }
            if (dataRes.hot_thread != null && dataRes.hot_thread.thread_list != null && dataRes.hot_thread.thread_list.size() != 0 && !StringUtils.isNull(dataRes.hot_thread.hot_title)) {
                this.boW = new a();
                this.boW.a(dataRes.hot_thread);
                if (dataRes.hot_thread.page != null) {
                    this.boR = new o();
                    this.boR.a(dataRes.hot_thread.page);
                }
            }
            QW();
        }
    }

    public void a(a aVar) {
        if (aVar != null && aVar.aTA != null && aVar.aTA.size() != 0) {
            for (w wVar : aVar.aTA) {
                this.boS.add(wVar);
            }
        }
    }

    public g QT() {
        return this.boV;
    }

    public ArrayList<u> QU() {
        return this.boS;
    }

    public o QV() {
        return this.boR;
    }

    private ArrayList<u> QW() {
        if (this.boT != null && !StringUtils.isNull(this.boT.boF) && !StringUtils.isNull(this.boT.boY)) {
            this.boS.add(this.boT);
        }
        if (this.boV != null && this.boV.getCount() > 0) {
            this.boS.add(this.boV);
        }
        if (this.boU != null && this.boU.size() != 0) {
            if (this.boU.size() > 5) {
                this.boU = this.boU.subList(0, 5);
            }
            for (e eVar : this.boU) {
                this.boS.add(eVar);
            }
        }
        if (this.boW != null && this.boW.aTA != null && this.boW.aTA.size() > 0) {
            this.boS.add(this.boW);
            for (w wVar : this.boW.aTA) {
                this.boS.add(wVar);
            }
        }
        return this.boS;
    }
}
