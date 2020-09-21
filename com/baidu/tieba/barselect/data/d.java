package com.baidu.tieba.barselect.data;

import tbclient.ElectionList;
import tbclient.Myrecord;
/* loaded from: classes20.dex */
public class d {
    private int agree_num;
    private String apply_declaration;
    private int hki;
    private int hkj;
    private boolean hkk = false;
    private int hkl;
    private String nickname;
    private String portrait;
    private int post_num;
    private int rank;
    private int thread_num;
    private long tid;
    private long uid;
    private int vote_num;

    public int cdS() {
        return this.agree_num;
    }

    public int cdT() {
        return this.hki;
    }

    public int cdU() {
        return this.hkj;
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

    public int cdV() {
        return this.vote_num;
    }

    public String cdW() {
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

    public boolean cdX() {
        return this.hkk;
    }

    public int cdY() {
        return this.hkl;
    }

    public void vD(int i) {
        this.hkl = i;
    }

    public static d a(ElectionList electionList) {
        if (electionList == null) {
            return null;
        }
        d dVar = new d();
        dVar.vG(electionList.vote_num.intValue());
        dVar.setNickname(electionList.name_show);
        dVar.setPortrait(electionList.portrait);
        dVar.vF(electionList.forum_level.intValue());
        dVar.Hr(electionList.apply_declaration);
        dVar.setRank(electionList.rank.intValue());
        dVar.vE(electionList.apply_id.intValue());
        dVar.setPost_num(electionList.post_num.intValue());
        dVar.setThread_num(electionList.thread_num.intValue());
        dVar.setAgree_num(electionList.agree_num.intValue());
        dVar.setUid(electionList.uid.longValue());
        dVar.setTid(electionList.tid.longValue());
        dVar.ng(electionList.is_cheat.intValue() == 1);
        dVar.vD(electionList.is_pass_audit.intValue());
        return dVar;
    }

    public static d a(Myrecord myrecord) {
        if (myrecord == null) {
            return null;
        }
        d dVar = new d();
        dVar.vG(myrecord.vote_num.intValue());
        dVar.setNickname(myrecord.name_show);
        dVar.setPortrait(myrecord.portrait);
        dVar.vF(myrecord.forum_level.intValue());
        dVar.Hr(myrecord.apply_declaration);
        dVar.setRank(myrecord.rank.intValue());
        dVar.vE(myrecord.apply_id.intValue());
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

    public void vE(int i) {
        this.hki = i;
    }

    public void Hr(String str) {
        this.apply_declaration = str;
    }

    public void vF(int i) {
        this.hkj = i;
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

    public void vG(int i) {
        this.vote_num = i;
    }

    public void ng(boolean z) {
        this.hkk = z;
    }

    public void setTid(long j) {
        this.tid = j;
    }
}
