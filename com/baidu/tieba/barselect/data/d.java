package com.baidu.tieba.barselect.data;

import tbclient.ElectionList;
import tbclient.Myrecord;
/* loaded from: classes8.dex */
public class d {
    private String apply_declaration;
    private int giN;
    private int giO;
    private int giP;
    private int giQ;
    private boolean giR = false;
    private String nickname;
    private String portrait;
    private int post_num;
    private int rank;
    private int thread_num;
    private long tid;
    private long uid;

    public int bDK() {
        return this.giQ;
    }

    public int bDL() {
        return this.giN;
    }

    public int bDM() {
        return this.giO;
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

    public int bDN() {
        return this.giP;
    }

    public String bDO() {
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

    public boolean bDP() {
        return this.giR;
    }

    public static d a(ElectionList electionList) {
        if (electionList == null) {
            return null;
        }
        d dVar = new d();
        dVar.ry(electionList.vote_num.intValue());
        dVar.setNickname(electionList.name_show);
        dVar.setPortrait(electionList.portrait);
        dVar.rx(electionList.forum_level.intValue());
        dVar.Bw(electionList.apply_declaration);
        dVar.setRank(electionList.rank.intValue());
        dVar.rw(electionList.apply_id.intValue());
        dVar.setPost_num(electionList.post_num.intValue());
        dVar.setThread_num(electionList.thread_num.intValue());
        dVar.rv(electionList.agree_num.intValue());
        dVar.setUid(electionList.uid.longValue());
        dVar.setTid(electionList.tid.longValue());
        dVar.ll(electionList.is_cheat.intValue() == 1);
        return dVar;
    }

    public static d a(Myrecord myrecord) {
        if (myrecord == null) {
            return null;
        }
        d dVar = new d();
        dVar.ry(myrecord.vote_num.intValue());
        dVar.setNickname(myrecord.name_show);
        dVar.setPortrait(myrecord.portrait);
        dVar.rx(myrecord.forum_level.intValue());
        dVar.Bw(myrecord.apply_declaration);
        dVar.setRank(myrecord.rank.intValue());
        dVar.rw(myrecord.apply_id.intValue());
        dVar.setPost_num(myrecord.post_num.intValue());
        dVar.setThread_num(myrecord.thread_num.intValue());
        dVar.rv(myrecord.agree_num.intValue());
        dVar.setUid(myrecord.uid.longValue());
        dVar.setTid(myrecord.tid.longValue());
        return dVar;
    }

    public void rv(int i) {
        this.giQ = i;
    }

    public void rw(int i) {
        this.giN = i;
    }

    public void Bw(String str) {
        this.apply_declaration = str;
    }

    public void rx(int i) {
        this.giO = i;
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

    public void ry(int i) {
        this.giP = i;
    }

    public void ll(boolean z) {
        this.giR = z;
    }

    public void setTid(long j) {
        this.tid = j;
    }
}
