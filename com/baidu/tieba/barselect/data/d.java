package com.baidu.tieba.barselect.data;

import tbclient.ElectionList;
import tbclient.Myrecord;
/* loaded from: classes8.dex */
public class d {
    private String apply_declaration;
    private int fDo;
    private int fDp;
    private int fDq;
    private int fDr;
    private boolean fDs = false;
    private String nickname;
    private String portrait;
    private int post_num;
    private int rank;
    private int thread_num;
    private long tid;
    private long uid;

    public int btT() {
        return this.fDr;
    }

    public int btU() {
        return this.fDo;
    }

    public int btV() {
        return this.fDp;
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

    public int btW() {
        return this.fDq;
    }

    public String btX() {
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

    public boolean btY() {
        return this.fDs;
    }

    public static d a(ElectionList electionList) {
        if (electionList == null) {
            return null;
        }
        d dVar = new d();
        dVar.re(electionList.vote_num.intValue());
        dVar.setNickname(electionList.name_show);
        dVar.setPortrait(electionList.portrait);
        dVar.rc(electionList.forum_level.intValue());
        dVar.zN(electionList.apply_declaration);
        dVar.rd(electionList.rank.intValue());
        dVar.rb(electionList.apply_id.intValue());
        dVar.setPost_num(electionList.post_num.intValue());
        dVar.setThread_num(electionList.thread_num.intValue());
        dVar.ra(electionList.agree_num.intValue());
        dVar.setUid(electionList.uid.longValue());
        dVar.setTid(electionList.tid.longValue());
        dVar.kd(electionList.is_cheat.intValue() == 1);
        return dVar;
    }

    public static d a(Myrecord myrecord) {
        if (myrecord == null) {
            return null;
        }
        d dVar = new d();
        dVar.re(myrecord.vote_num.intValue());
        dVar.setNickname(myrecord.name_show);
        dVar.setPortrait(myrecord.portrait);
        dVar.rc(myrecord.forum_level.intValue());
        dVar.zN(myrecord.apply_declaration);
        dVar.rd(myrecord.rank.intValue());
        dVar.rb(myrecord.apply_id.intValue());
        dVar.setPost_num(myrecord.post_num.intValue());
        dVar.setThread_num(myrecord.thread_num.intValue());
        dVar.ra(myrecord.agree_num.intValue());
        dVar.setUid(myrecord.uid.longValue());
        dVar.setTid(myrecord.tid.longValue());
        return dVar;
    }

    public void ra(int i) {
        this.fDr = i;
    }

    public void rb(int i) {
        this.fDo = i;
    }

    public void zN(String str) {
        this.apply_declaration = str;
    }

    public void rc(int i) {
        this.fDp = i;
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

    public void rd(int i) {
        this.rank = i;
    }

    public void setThread_num(int i) {
        this.thread_num = i;
    }

    public void setUid(long j) {
        this.uid = j;
    }

    public void re(int i) {
        this.fDq = i;
    }

    public void kd(boolean z) {
        this.fDs = z;
    }

    public void setTid(long j) {
        this.tid = j;
    }
}
