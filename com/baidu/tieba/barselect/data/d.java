package com.baidu.tieba.barselect.data;

import tbclient.ElectionList;
import tbclient.Myrecord;
/* loaded from: classes3.dex */
public class d {
    private String apply_declaration;
    private int eqX;
    private String eqY;
    private int eqZ;
    private int era;
    private int erb;
    private boolean erc = false;
    private String portrait;
    private int post_num;
    private int rank;
    private int thread_num;
    private long tid;
    private long uid;

    public int aWD() {
        return this.erb;
    }

    public int aWE() {
        return this.eqX;
    }

    public int aWF() {
        return this.eqZ;
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

    public int aWG() {
        return this.era;
    }

    public String aWH() {
        return this.apply_declaration;
    }

    public String aWI() {
        return this.eqY;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public long getTid() {
        return this.tid;
    }

    public boolean aWJ() {
        return this.erc;
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
        this.erb = i;
    }

    public void oY(int i) {
        this.eqX = i;
    }

    public void uM(String str) {
        this.apply_declaration = str;
    }

    public void oZ(int i) {
        this.eqZ = i;
    }

    public void uN(String str) {
        this.eqY = str;
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
        this.era = i;
    }

    public void ik(boolean z) {
        this.erc = z;
    }

    public void setTid(long j) {
        this.tid = j;
    }
}
