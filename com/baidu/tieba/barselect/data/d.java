package com.baidu.tieba.barselect.data;

import tbclient.ElectionList;
import tbclient.Myrecord;
/* loaded from: classes8.dex */
public class d {
    private int agree_num;
    private String apply_declaration;
    private int iqD;
    private int iqE;
    private boolean iqF = false;
    private int iqG;
    private String nickname;
    private String portrait;
    private int post_num;
    private int rank;
    private int thread_num;
    private long tid;
    private long uid;
    private int vote_num;

    public int crg() {
        return this.agree_num;
    }

    public int crh() {
        return this.iqD;
    }

    public int cri() {
        return this.iqE;
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

    public int crj() {
        return this.vote_num;
    }

    public String crk() {
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

    public boolean crl() {
        return this.iqF;
    }

    public int crm() {
        return this.iqG;
    }

    public void wL(int i) {
        this.iqG = i;
    }

    public static d a(ElectionList electionList) {
        if (electionList == null) {
            return null;
        }
        d dVar = new d();
        dVar.wO(electionList.vote_num.intValue());
        dVar.setNickname(electionList.name_show);
        dVar.setPortrait(electionList.portrait);
        dVar.wN(electionList.forum_level.intValue());
        dVar.II(electionList.apply_declaration);
        dVar.setRank(electionList.rank.intValue());
        dVar.wM(electionList.apply_id.intValue());
        dVar.setPost_num(electionList.post_num.intValue());
        dVar.setThread_num(electionList.thread_num.intValue());
        dVar.setAgree_num(electionList.agree_num.intValue());
        dVar.setUid(electionList.uid.longValue());
        dVar.setTid(electionList.tid.longValue());
        dVar.pp(electionList.is_cheat.intValue() == 1);
        dVar.wL(electionList.is_pass_audit.intValue());
        return dVar;
    }

    public static d a(Myrecord myrecord) {
        if (myrecord == null) {
            return null;
        }
        d dVar = new d();
        dVar.wO(myrecord.vote_num.intValue());
        dVar.setNickname(myrecord.name_show);
        dVar.setPortrait(myrecord.portrait);
        dVar.wN(myrecord.forum_level.intValue());
        dVar.II(myrecord.apply_declaration);
        dVar.setRank(myrecord.rank.intValue());
        dVar.wM(myrecord.apply_id.intValue());
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

    public void wM(int i) {
        this.iqD = i;
    }

    public void II(String str) {
        this.apply_declaration = str;
    }

    public void wN(int i) {
        this.iqE = i;
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

    public void wO(int i) {
        this.vote_num = i;
    }

    public void pp(boolean z) {
        this.iqF = z;
    }

    public void setTid(long j) {
        this.tid = j;
    }
}
