package com.baidu.tieba.barselect.data;

import tbclient.ElectionList;
import tbclient.Myrecord;
/* loaded from: classes3.dex */
public class d {
    private String apply_declaration;
    private int ewc;
    private String ewd;
    private int ewe;
    private int ewf;
    private int ewg;
    private boolean ewh = false;
    private String portrait;
    private int post_num;
    private int rank;
    private int thread_num;
    private long tid;
    private long uid;

    public int aYB() {
        return this.ewg;
    }

    public int aYC() {
        return this.ewc;
    }

    public int aYD() {
        return this.ewe;
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

    public int aYE() {
        return this.ewf;
    }

    public String aYF() {
        return this.apply_declaration;
    }

    public String aYG() {
        return this.ewd;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public long getTid() {
        return this.tid;
    }

    public boolean aYH() {
        return this.ewh;
    }

    public static d a(ElectionList electionList) {
        if (electionList == null) {
            return null;
        }
        d dVar = new d();
        dVar.pt(electionList.vote_num.intValue());
        dVar.vs(electionList.name_show);
        dVar.setPortrait(electionList.portrait);
        dVar.pr(electionList.forum_level.intValue());
        dVar.vr(electionList.apply_declaration);
        dVar.ps(electionList.rank.intValue());
        dVar.pq(electionList.apply_id.intValue());
        dVar.setPost_num(electionList.post_num.intValue());
        dVar.setThread_num(electionList.thread_num.intValue());
        dVar.pp(electionList.agree_num.intValue());
        dVar.setUid(electionList.uid.longValue());
        dVar.setTid(electionList.tid.longValue());
        dVar.it(electionList.is_cheat.intValue() == 1);
        return dVar;
    }

    public static d a(Myrecord myrecord) {
        if (myrecord == null) {
            return null;
        }
        d dVar = new d();
        dVar.pt(myrecord.vote_num.intValue());
        dVar.vs(myrecord.name_show);
        dVar.setPortrait(myrecord.portrait);
        dVar.pr(myrecord.forum_level.intValue());
        dVar.vr(myrecord.apply_declaration);
        dVar.ps(myrecord.rank.intValue());
        dVar.pq(myrecord.apply_id.intValue());
        dVar.setPost_num(myrecord.post_num.intValue());
        dVar.setThread_num(myrecord.thread_num.intValue());
        dVar.pp(myrecord.agree_num.intValue());
        dVar.setUid(myrecord.uid.longValue());
        dVar.setTid(myrecord.tid.longValue());
        return dVar;
    }

    public void pp(int i) {
        this.ewg = i;
    }

    public void pq(int i) {
        this.ewc = i;
    }

    public void vr(String str) {
        this.apply_declaration = str;
    }

    public void pr(int i) {
        this.ewe = i;
    }

    public void vs(String str) {
        this.ewd = str;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public void setPost_num(int i) {
        this.post_num = i;
    }

    public void ps(int i) {
        this.rank = i;
    }

    public void setThread_num(int i) {
        this.thread_num = i;
    }

    public void setUid(long j) {
        this.uid = j;
    }

    public void pt(int i) {
        this.ewf = i;
    }

    public void it(boolean z) {
        this.ewh = z;
    }

    public void setTid(long j) {
        this.tid = j;
    }
}
