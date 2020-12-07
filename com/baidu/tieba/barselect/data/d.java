package com.baidu.tieba.barselect.data;

import tbclient.ElectionList;
import tbclient.Myrecord;
/* loaded from: classes21.dex */
public class d {
    private int agree_num;
    private String apply_declaration;
    private int icP;
    private int icQ;
    private boolean icR = false;
    private int icS;
    private String nickname;
    private String portrait;
    private int post_num;
    private int rank;
    private int thread_num;
    private long tid;
    private long uid;
    private int vote_num;

    public int cqM() {
        return this.agree_num;
    }

    public int cqN() {
        return this.icP;
    }

    public int cqO() {
        return this.icQ;
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

    public int cqP() {
        return this.vote_num;
    }

    public String cqQ() {
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

    public boolean cqR() {
        return this.icR;
    }

    public int cqS() {
        return this.icS;
    }

    public void xT(int i) {
        this.icS = i;
    }

    public static d a(ElectionList electionList) {
        if (electionList == null) {
            return null;
        }
        d dVar = new d();
        dVar.xW(electionList.vote_num.intValue());
        dVar.setNickname(electionList.name_show);
        dVar.setPortrait(electionList.portrait);
        dVar.xV(electionList.forum_level.intValue());
        dVar.Jl(electionList.apply_declaration);
        dVar.setRank(electionList.rank.intValue());
        dVar.xU(electionList.apply_id.intValue());
        dVar.setPost_num(electionList.post_num.intValue());
        dVar.setThread_num(electionList.thread_num.intValue());
        dVar.setAgree_num(electionList.agree_num.intValue());
        dVar.setUid(electionList.uid.longValue());
        dVar.setTid(electionList.tid.longValue());
        dVar.oK(electionList.is_cheat.intValue() == 1);
        dVar.xT(electionList.is_pass_audit.intValue());
        return dVar;
    }

    public static d a(Myrecord myrecord) {
        if (myrecord == null) {
            return null;
        }
        d dVar = new d();
        dVar.xW(myrecord.vote_num.intValue());
        dVar.setNickname(myrecord.name_show);
        dVar.setPortrait(myrecord.portrait);
        dVar.xV(myrecord.forum_level.intValue());
        dVar.Jl(myrecord.apply_declaration);
        dVar.setRank(myrecord.rank.intValue());
        dVar.xU(myrecord.apply_id.intValue());
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

    public void xU(int i) {
        this.icP = i;
    }

    public void Jl(String str) {
        this.apply_declaration = str;
    }

    public void xV(int i) {
        this.icQ = i;
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

    public void xW(int i) {
        this.vote_num = i;
    }

    public void oK(boolean z) {
        this.icR = z;
    }

    public void setTid(long j) {
        this.tid = j;
    }
}
