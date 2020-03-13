package com.baidu.tieba.barselect.data;

import tbclient.ElectionList;
import tbclient.Myrecord;
/* loaded from: classes8.dex */
public class d {
    private String apply_declaration;
    private int fDB;
    private int fDC;
    private int fDD;
    private int fDE;
    private boolean fDF = false;
    private String nickname;
    private String portrait;
    private int post_num;
    private int rank;
    private int thread_num;
    private long tid;
    private long uid;

    public int btU() {
        return this.fDE;
    }

    public int btV() {
        return this.fDB;
    }

    public int btW() {
        return this.fDC;
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

    public int btX() {
        return this.fDD;
    }

    public String btY() {
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

    public boolean btZ() {
        return this.fDF;
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
        dVar.zO(electionList.apply_declaration);
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
        dVar.zO(myrecord.apply_declaration);
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
        this.fDE = i;
    }

    public void rb(int i) {
        this.fDB = i;
    }

    public void zO(String str) {
        this.apply_declaration = str;
    }

    public void rc(int i) {
        this.fDC = i;
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
        this.fDD = i;
    }

    public void kd(boolean z) {
        this.fDF = z;
    }

    public void setTid(long j) {
        this.tid = j;
    }
}
