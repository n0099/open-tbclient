package com.baidu.tieba.barselect.data;

import tbclient.ElectionList;
import tbclient.Myrecord;
/* loaded from: classes7.dex */
public class d {
    private int agree_num;
    private String apply_declaration;
    private int ikH;
    private int ikI;
    private boolean ikJ = false;
    private int ikK;
    private String nickname;
    private String portrait;
    private int post_num;
    private int rank;
    private int thread_num;
    private long tid;
    private long uid;
    private int vote_num;

    public int cpP() {
        return this.agree_num;
    }

    public int cpQ() {
        return this.ikH;
    }

    public int cpR() {
        return this.ikI;
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

    public int cpS() {
        return this.vote_num;
    }

    public String cpT() {
        return this.apply_declaration;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public long getTid() {
        return this.tid;
    }

    public boolean cpU() {
        return this.ikJ;
    }

    public int cpV() {
        return this.ikK;
    }

    public void wA(int i) {
        this.ikK = i;
    }

    public static d a(ElectionList electionList) {
        if (electionList == null) {
            return null;
        }
        d dVar = new d();
        dVar.wD(electionList.vote_num.intValue());
        dVar.setNickname(electionList.name_show);
        dVar.setPortrait(electionList.portrait);
        dVar.wC(electionList.forum_level.intValue());
        dVar.HX(electionList.apply_declaration);
        dVar.setRank(electionList.rank.intValue());
        dVar.wB(electionList.apply_id.intValue());
        dVar.setPost_num(electionList.post_num.intValue());
        dVar.setThread_num(electionList.thread_num.intValue());
        dVar.setAgree_num(electionList.agree_num.intValue());
        dVar.setUid(electionList.uid.longValue());
        dVar.setTid(electionList.tid.longValue());
        dVar.pf(electionList.is_cheat.intValue() == 1);
        dVar.wA(electionList.is_pass_audit.intValue());
        return dVar;
    }

    public static d a(Myrecord myrecord) {
        if (myrecord == null) {
            return null;
        }
        d dVar = new d();
        dVar.wD(myrecord.vote_num.intValue());
        dVar.setNickname(myrecord.name_show);
        dVar.setPortrait(myrecord.portrait);
        dVar.wC(myrecord.forum_level.intValue());
        dVar.HX(myrecord.apply_declaration);
        dVar.setRank(myrecord.rank.intValue());
        dVar.wB(myrecord.apply_id.intValue());
        dVar.setPost_num(myrecord.post_num.intValue());
        dVar.setThread_num(myrecord.thread_num.intValue());
        dVar.setAgree_num(myrecord.agree_num.intValue());
        dVar.setUid(myrecord.uid.longValue());
        dVar.setTid(myrecord.tid.longValue());
        return dVar;
    }

    public void setAgree_num(int i) {
        this.agree_num = i;
    }

    public void wB(int i) {
        this.ikH = i;
    }

    public void HX(String str) {
        this.apply_declaration = str;
    }

    public void wC(int i) {
        this.ikI = i;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public void setPost_num(int i) {
        this.post_num = i;
    }

    public void setRank(int i) {
        this.rank = i;
    }

    public void setThread_num(int i) {
        this.thread_num = i;
    }

    public void setUid(long j) {
        this.uid = j;
    }

    public void wD(int i) {
        this.vote_num = i;
    }

    public void pf(boolean z) {
        this.ikJ = z;
    }

    public void setTid(long j) {
        this.tid = j;
    }
}
