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
    private int Ui;
    private ForumData amC;
    private int amG;
    private AntiData amJ;
    private com.baidu.tbadk.core.data.q amK;
    public Error amM;
    private int amH = 10;
    private int amI = -1;
    private boolean amL = false;
    private ak amD = null;
    private ArrayList<ak> amE = new ArrayList<>();
    private int amF = 1;

    public Error At() {
        return this.amM;
    }

    public ak Au() {
        return this.amD;
    }

    public void a(ak akVar) {
        this.amD = akVar;
    }

    public int Av() {
        if (this.amI == -1) {
            this.amI = this.Ui;
        }
        return this.amI;
    }

    public void a(ar arVar, boolean z) {
        if (arVar != null) {
            a(arVar.Ap());
            this.amI = arVar.getCurrentPage();
            a(arVar.Ay());
            ej(arVar.Ax());
            a(arVar.AA());
            setTotalCount(arVar.getTotalCount());
            ei(arVar.getTotalPage());
            this.amE.addAll(0, arVar.Aw());
        }
    }

    public void b(ar arVar, boolean z) {
        if (arVar != null) {
            a(arVar.Ap());
            ek(arVar.getCurrentPage());
            a(arVar.Ay());
            ej(arVar.Ax());
            a(arVar.AA());
            setTotalCount(arVar.getTotalCount());
            ei(arVar.getTotalPage());
            int size = this.amE.size();
            if (z && size % this.amH != 0) {
                for (int i = 0; i < size % this.amH; i++) {
                    this.amE.remove(this.amE.size() - 1);
                }
            }
            this.amE.addAll(arVar.Aw());
        }
    }

    public ArrayList<ak> Aw() {
        return this.amE;
    }

    public void m(ArrayList<ak> arrayList) {
        this.amE = arrayList;
    }

    public int getTotalPage() {
        return this.amF;
    }

    public void ei(int i) {
        this.amF = i;
    }

    public int getTotalCount() {
        return this.amG;
    }

    public void setTotalCount(int i) {
        this.amG = i;
    }

    public int Ax() {
        return this.amH;
    }

    public void ej(int i) {
        if (i != 0) {
            this.amH = i;
        }
    }

    public int getCurrentPage() {
        return this.Ui;
    }

    public void ek(int i) {
        this.Ui = i;
    }

    public void a(ForumData forumData) {
        this.amC = forumData;
    }

    public ForumData Ay() {
        return this.amC;
    }

    public void a(AntiData antiData) {
        this.amJ = antiData;
    }

    public AntiData Ap() {
        return this.amJ;
    }

    public void a(com.baidu.tbadk.core.data.q qVar) {
        this.amK = qVar;
    }

    public boolean Az() {
        return (this.amK == null || this.amD == null || this.amK.getAuthor() == null || this.amK.getAuthor().getUserId() == null || this.amD.getAuthor() == null || this.amD.getAuthor().getUserId() == null || !this.amK.getAuthor().getUserId().equals(this.amD.getAuthor().getUserId())) ? false : true;
    }

    public boolean zP() {
        return this.amL;
    }

    public boolean hasMore() {
        return this.Ui < this.amF && this.Ui * this.amH < 200;
    }

    public com.baidu.tbadk.core.data.q AA() {
        return this.amK;
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
            arVar.m(arrayList);
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
        this.amL = z;
    }
}
