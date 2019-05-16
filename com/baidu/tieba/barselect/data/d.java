package com.baidu.tieba.barselect.data;

import tbclient.ElectionList;
import tbclient.Myrecord;
/* loaded from: classes3.dex */
public class d {
    private String apply_declaration;
    private int eqW;
    private String eqX;
    private int eqY;
    private int eqZ;
    private int era;
    private boolean erb = false;
    private String portrait;
    private int post_num;
    private int rank;
    private int thread_num;
    private long tid;
    private long uid;

    public int aWA() {
        return this.era;
    }

    public int aWB() {
        return this.eqW;
    }

    public int aWC() {
        return this.eqY;
    }

    public int getPost_num() {
        return this.post_num;
    }

    public int getRank() {
        return this.rank;
    }

    public int getThread_num() {
        return this.thread_num;
    }

    public long getUid() {
        return this.uid;
    }

    public int aWD() {
        return this.eqZ;
    }

    public String aWE() {
        return this.apply_declaration;
    }

    public String aWF() {
        return this.eqX;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public long getTid() {
        return this.tid;
    }

    public boolean aWG() {
        return this.erb;
    }

    public static d a(ElectionList electionList) {
        if (electionList == null) {
            return null;
        }
        d dVar = new d();
        dVar.pb(electionList.vote_num.intValue());
        dVar.uN(electionList.name_show);
        dVar.setPortrait(electionList.portrait);
        dVar.oZ(electionList.forum_level.intValue());
        dVar.uM(electionList.apply_declaration);
        dVar.pa(electionList.rank.intValue());
        dVar.oY(electionList.apply_id.intValue());
        dVar.setPost_num(electionList.post_num.intValue());
        dVar.setThread_num(electionList.thread_num.intValue());
        dVar.oX(electionList.agree_num.intValue());
        dVar.setUid(electionList.uid.longValue());
        dVar.setTid(electionList.tid.longValue());
        dVar.ik(electionList.is_cheat.intValue() == 1);
        return dVar;
    }

    public static d a(Myrecord myrecord) {
        if (myrecord == null) {
            return null;
        }
        d dVar = new d();
        dVar.pb(myrecord.vote_num.intValue());
        dVar.uN(myrecord.name_show);
        dVar.setPortrait(myrecord.portrait);
        dVar.oZ(myrecord.forum_level.intValue());
        dVar.uM(myrecord.apply_declaration);
        dVar.pa(myrecord.rank.intValue());
        dVar.oY(myrecord.apply_id.intValue());
        dVar.setPost_num(myrecord.post_num.intValue());
        dVar.setThread_num(myrecord.thread_num.intValue());
        dVar.oX(myrecord.agree_num.intValue());
        dVar.setUid(myrecord.uid.longValue());
        dVar.setTid(myrecord.tid.longValue());
        return dVar;
    }

    public void oX(int i) {
        this.era = i;
    }

    public void oY(int i) {
        this.eqW = i;
    }

    public void uM(String str) {
        this.apply_declaration = str;
    }

    public void oZ(int i) {
        this.eqY = i;
    }

    public void uN(String str) {
        this.eqX = str;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public void setPost_num(int i) {
        this.post_num = i;
    }

    public void pa(int i) {
        this.rank = i;
    }

    public void setThread_num(int i) {
        this.thread_num = i;
    }

    public void setUid(long j) {
        this.uid = j;
    }

    public void pb(int i) {
        this.eqZ = i;
    }

    public void ik(boolean z) {
        this.erb = z;
    }

    public void setTid(long j) {
        this.tid = j;
    }
}
