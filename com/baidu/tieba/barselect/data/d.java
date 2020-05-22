package com.baidu.tieba.barselect.data;

import tbclient.ElectionList;
import tbclient.Myrecord;
/* loaded from: classes8.dex */
public class d {
    private String apply_declaration;
    private int gxJ;
    private int gxK;
    private int gxL;
    private int gxM;
    private boolean gxN = false;
    private String nickname;
    private String portrait;
    private int post_num;
    private int rank;
    private int thread_num;
    private long tid;
    private long uid;

    public int bKa() {
        return this.gxM;
    }

    public int bKb() {
        return this.gxJ;
    }

    public int bKc() {
        return this.gxK;
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

    public int bKd() {
        return this.gxL;
    }

    public String bKe() {
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

    public boolean bKf() {
        return this.gxN;
    }

    public static d a(ElectionList electionList) {
        if (electionList == null) {
            return null;
        }
        d dVar = new d();
        dVar.sb(electionList.vote_num.intValue());
        dVar.setNickname(electionList.name_show);
        dVar.setPortrait(electionList.portrait);
        dVar.sa(electionList.forum_level.intValue());
        dVar.Di(electionList.apply_declaration);
        dVar.setRank(electionList.rank.intValue());
        dVar.rZ(electionList.apply_id.intValue());
        dVar.setPost_num(electionList.post_num.intValue());
        dVar.setThread_num(electionList.thread_num.intValue());
        dVar.rY(electionList.agree_num.intValue());
        dVar.setUid(electionList.uid.longValue());
        dVar.setTid(electionList.tid.longValue());
        dVar.lH(electionList.is_cheat.intValue() == 1);
        return dVar;
    }

    public static d a(Myrecord myrecord) {
        if (myrecord == null) {
            return null;
        }
        d dVar = new d();
        dVar.sb(myrecord.vote_num.intValue());
        dVar.setNickname(myrecord.name_show);
        dVar.setPortrait(myrecord.portrait);
        dVar.sa(myrecord.forum_level.intValue());
        dVar.Di(myrecord.apply_declaration);
        dVar.setRank(myrecord.rank.intValue());
        dVar.rZ(myrecord.apply_id.intValue());
        dVar.setPost_num(myrecord.post_num.intValue());
        dVar.setThread_num(myrecord.thread_num.intValue());
        dVar.rY(myrecord.agree_num.intValue());
        dVar.setUid(myrecord.uid.longValue());
        dVar.setTid(myrecord.tid.longValue());
        return dVar;
    }

    public void rY(int i) {
        this.gxM = i;
    }

    public void rZ(int i) {
        this.gxJ = i;
    }

    public void Di(String str) {
        this.apply_declaration = str;
    }

    public void sa(int i) {
        this.gxK = i;
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

    public void sb(int i) {
        this.gxL = i;
    }

    public void lH(boolean z) {
        this.gxN = z;
    }

    public void setTid(long j) {
        this.tid = j;
    }
}
