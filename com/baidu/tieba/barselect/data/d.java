package com.baidu.tieba.barselect.data;

import tbclient.ElectionList;
import tbclient.Myrecord;
/* loaded from: classes8.dex */
public class d {
    private int agree_num;
    private String apply_declaration;
    private int ipq;
    private int ipr;
    private boolean ips = false;
    private int ipt;
    private String nickname;
    private String portrait;
    private int post_num;
    private int rank;
    private int thread_num;
    private long tid;
    private long uid;
    private int vote_num;

    public int ctH() {
        return this.agree_num;
    }

    public int ctI() {
        return this.ipq;
    }

    public int ctJ() {
        return this.ipr;
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

    public int ctK() {
        return this.vote_num;
    }

    public String ctL() {
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

    public boolean ctM() {
        return this.ips;
    }

    public int ctN() {
        return this.ipt;
    }

    public void yg(int i) {
        this.ipt = i;
    }

    public static d a(ElectionList electionList) {
        if (electionList == null) {
            return null;
        }
        d dVar = new d();
        dVar.yj(electionList.vote_num.intValue());
        dVar.setNickname(electionList.name_show);
        dVar.setPortrait(electionList.portrait);
        dVar.yi(electionList.forum_level.intValue());
        dVar.Ji(electionList.apply_declaration);
        dVar.setRank(electionList.rank.intValue());
        dVar.yh(electionList.apply_id.intValue());
        dVar.setPost_num(electionList.post_num.intValue());
        dVar.setThread_num(electionList.thread_num.intValue());
        dVar.setAgree_num(electionList.agree_num.intValue());
        dVar.setUid(electionList.uid.longValue());
        dVar.setTid(electionList.tid.longValue());
        dVar.pj(electionList.is_cheat.intValue() == 1);
        dVar.yg(electionList.is_pass_audit.intValue());
        return dVar;
    }

    public static d a(Myrecord myrecord) {
        if (myrecord == null) {
            return null;
        }
        d dVar = new d();
        dVar.yj(myrecord.vote_num.intValue());
        dVar.setNickname(myrecord.name_show);
        dVar.setPortrait(myrecord.portrait);
        dVar.yi(myrecord.forum_level.intValue());
        dVar.Ji(myrecord.apply_declaration);
        dVar.setRank(myrecord.rank.intValue());
        dVar.yh(myrecord.apply_id.intValue());
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

    public void yh(int i) {
        this.ipq = i;
    }

    public void Ji(String str) {
        this.apply_declaration = str;
    }

    public void yi(int i) {
        this.ipr = i;
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

    public void yj(int i) {
        this.vote_num = i;
    }

    public void pj(boolean z) {
        this.ips = z;
    }

    public void setTid(long j) {
        this.tid = j;
    }
}
