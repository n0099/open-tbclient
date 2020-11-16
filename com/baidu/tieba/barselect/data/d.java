package com.baidu.tieba.barselect.data;

import tbclient.ElectionList;
import tbclient.Myrecord;
/* loaded from: classes20.dex */
public class d {
    private int agree_num;
    private String apply_declaration;
    private int hRW;
    private int hRX;
    private boolean hRY = false;
    private int hRZ;
    private String nickname;
    private String portrait;
    private int post_num;
    private int rank;
    private int thread_num;
    private long tid;
    private long uid;
    private int vote_num;

    public int cmz() {
        return this.agree_num;
    }

    public int cmA() {
        return this.hRW;
    }

    public int cmB() {
        return this.hRX;
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

    public int cmC() {
        return this.vote_num;
    }

    public String cmD() {
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

    public boolean cmE() {
        return this.hRY;
    }

    public int cmF() {
        return this.hRZ;
    }

    public void xn(int i) {
        this.hRZ = i;
    }

    public static d a(ElectionList electionList) {
        if (electionList == null) {
            return null;
        }
        d dVar = new d();
        dVar.xq(electionList.vote_num.intValue());
        dVar.setNickname(electionList.name_show);
        dVar.setPortrait(electionList.portrait);
        dVar.xp(electionList.forum_level.intValue());
        dVar.Iv(electionList.apply_declaration);
        dVar.setRank(electionList.rank.intValue());
        dVar.xo(electionList.apply_id.intValue());
        dVar.setPost_num(electionList.post_num.intValue());
        dVar.setThread_num(electionList.thread_num.intValue());
        dVar.setAgree_num(electionList.agree_num.intValue());
        dVar.setUid(electionList.uid.longValue());
        dVar.setTid(electionList.tid.longValue());
        dVar.oo(electionList.is_cheat.intValue() == 1);
        dVar.xn(electionList.is_pass_audit.intValue());
        return dVar;
    }

    public static d a(Myrecord myrecord) {
        if (myrecord == null) {
            return null;
        }
        d dVar = new d();
        dVar.xq(myrecord.vote_num.intValue());
        dVar.setNickname(myrecord.name_show);
        dVar.setPortrait(myrecord.portrait);
        dVar.xp(myrecord.forum_level.intValue());
        dVar.Iv(myrecord.apply_declaration);
        dVar.setRank(myrecord.rank.intValue());
        dVar.xo(myrecord.apply_id.intValue());
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

    public void xo(int i) {
        this.hRW = i;
    }

    public void Iv(String str) {
        this.apply_declaration = str;
    }

    public void xp(int i) {
        this.hRX = i;
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

    public void xq(int i) {
        this.vote_num = i;
    }

    public void oo(boolean z) {
        this.hRY = z;
    }

    public void setTid(long j) {
        this.tid = j;
    }
}
