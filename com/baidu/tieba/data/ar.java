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
public class ar {
    private int Ue;
    private AntiData amA;
    private com.baidu.tbadk.core.data.q amB;
    public Error amD;
    private ForumData amt;
    private int amx;
    private int amy = 10;
    private int amz = -1;
    private boolean amC = false;
    private ak amu = null;
    private ArrayList<ak> amv = new ArrayList<>();
    private int amw = 1;

    public Error Ar() {
        return this.amD;
    }

    public ak As() {
        return this.amu;
    }

    public void a(ak akVar) {
        this.amu = akVar;
    }

    public int At() {
        if (this.amz == -1) {
            this.amz = this.Ue;
        }
        return this.amz;
    }

    public void a(ar arVar, boolean z) {
        if (arVar != null) {
            a(arVar.An());
            this.amz = arVar.getCurrentPage();
            a(arVar.Aw());
            ej(arVar.Av());
            a(arVar.Ay());
            setTotalCount(arVar.getTotalCount());
            ei(arVar.getTotalPage());
            this.amv.addAll(0, arVar.Au());
        }
    }

    public void b(ar arVar, boolean z) {
        if (arVar != null) {
            a(arVar.An());
            ek(arVar.getCurrentPage());
            a(arVar.Aw());
            ej(arVar.Av());
            a(arVar.Ay());
            setTotalCount(arVar.getTotalCount());
            ei(arVar.getTotalPage());
            int size = this.amv.size();
            if (z && size % this.amy != 0) {
                for (int i = 0; i < size % this.amy; i++) {
                    this.amv.remove(this.amv.size() - 1);
                }
            }
            this.amv.addAll(arVar.Au());
        }
    }

    public ArrayList<ak> Au() {
        return this.amv;
    }

    public void l(ArrayList<ak> arrayList) {
        this.amv = arrayList;
    }

    public int getTotalPage() {
        return this.amw;
    }

    public void ei(int i) {
        this.amw = i;
    }

    public int getTotalCount() {
        return this.amx;
    }

    public void setTotalCount(int i) {
        this.amx = i;
    }

    public int Av() {
        return this.amy;
    }

    public void ej(int i) {
        if (i != 0) {
            this.amy = i;
        }
    }

    public int getCurrentPage() {
        return this.Ue;
    }

    public void ek(int i) {
        this.Ue = i;
    }

    public void a(ForumData forumData) {
        this.amt = forumData;
    }

    public ForumData Aw() {
        return this.amt;
    }

    public void a(AntiData antiData) {
        this.amA = antiData;
    }

    public AntiData An() {
        return this.amA;
    }

    public void a(com.baidu.tbadk.core.data.q qVar) {
        this.amB = qVar;
    }

    public boolean Ax() {
        return (this.amB == null || this.amu == null || this.amB.getAuthor() == null || this.amB.getAuthor().getUserId() == null || this.amu.getAuthor() == null || this.amu.getAuthor().getUserId() == null || !this.amB.getAuthor().getUserId().equals(this.amu.getAuthor().getUserId())) ? false : true;
    }

    public boolean zN() {
        return this.amC;
    }

    public boolean hasMore() {
        return this.Ue < this.amw && this.Ue * this.amy < 200;
    }

    public com.baidu.tbadk.core.data.q Ay() {
        return this.amB;
    }

    public static ar a(DataRes dataRes, Context context) {
        if (dataRes == null) {
            return null;
        }
        try {
            ar arVar = new ar();
            AntiData antiData = new AntiData();
            antiData.parserProtobuf(dataRes.anti);
            arVar.a(antiData);
            com.baidu.tbadk.core.data.q qVar = new com.baidu.tbadk.core.data.q();
            qVar.a(dataRes.thread);
            arVar.a(qVar);
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            arVar.a(forumData);
            ak akVar = new ak();
            akVar.a(dataRes.post, context);
            arVar.a(akVar);
            List<SubPostList> list = dataRes.subpost_list;
            int size = list.size();
            ArrayList<ak> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                ak akVar2 = new ak();
                akVar2.a(list.get(i), context);
                arrayList.add(akVar2);
            }
            arVar.l(arrayList);
            Page page = dataRes.page;
            int intValue = page.total_page.intValue();
            int intValue2 = page.page_size.intValue() == 0 ? page.page_size.intValue() : 10;
            int intValue3 = page.current_page.intValue();
            int intValue4 = page.total_count.intValue();
            arVar.ek(intValue3);
            arVar.ej(intValue2);
            arVar.setTotalCount(intValue4);
            arVar.ei(intValue);
            return arVar;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }

    public void bs(boolean z) {
        this.amC = z;
    }
}
