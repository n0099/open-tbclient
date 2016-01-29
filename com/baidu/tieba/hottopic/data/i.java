package com.baidu.tieba.hottopic.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.u;
import java.util.ArrayList;
import java.util.List;
import tbclient.HottopicRanklist.DataRes;
/* loaded from: classes.dex */
public class i {
    private ArrayList<u> bKR = null;
    private List<c> bLr;
    private List<b> bLs;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.topic_manual != null && dataRes.topic_manual.topic_list != null && dataRes.topic_manual.topic_list.size() > 0) {
                this.bLs = new ArrayList();
                for (int i = 0; i < dataRes.topic_manual.topic_list.size(); i++) {
                    b bVar = new b();
                    bVar.a(dataRes.topic_manual);
                    bVar.a(dataRes.topic_manual.topic_list.get(i));
                    this.bLs.add(bVar);
                }
            }
            if (dataRes.topic_bang != null && dataRes.topic_bang.topic_list != null && dataRes.topic_bang.topic_list.size() > 0) {
                this.bLr = new ArrayList();
                for (int i2 = 0; i2 < dataRes.topic_bang.topic_list.size(); i2++) {
                    c cVar = new c();
                    cVar.a(dataRes.topic_bang);
                    cVar.a(dataRes.topic_bang.topic_list.get(i2));
                    this.bLr.add(cVar);
                }
            }
        }
    }

    public ArrayList<u> XT() {
        return XW();
    }

    private ArrayList<u> XW() {
        this.bKR = new ArrayList<>();
        if (this.bLs != null && this.bLs.size() > 0) {
            int size = this.bLs.size() == 1 ? this.bLs.size() : 1;
            for (int i = 0; i < size; i++) {
                b bVar = this.bLs.get(i);
                if (bVar != null && (!StringUtils.isNull(bVar.XI()) || !StringUtils.isNull(bVar.XJ()) || !StringUtils.isNull(bVar.getName()))) {
                    this.bKR.add(this.bLs.get(i));
                }
            }
        }
        if (this.bLr != null && this.bLr.size() > 0) {
            int size2 = this.bLr.size() <= 20 ? this.bLr.size() : 20;
            for (int i2 = 0; i2 < size2; i2++) {
                c cVar = this.bLr.get(i2);
                cVar.iz(i2 + 1);
                this.bKR.add(cVar);
            }
        }
        return this.bKR;
    }
}
