package com.baidu.tieba.barselect.data;

import tbclient.ElectionList;
import tbclient.Myrecord;
/* loaded from: classes3.dex */
public class d {
    private String apply_declaration;
    private int eFF;
    private int eFG;
    private int eFH;
    private int eFI;
    private boolean eFJ = false;
    private String nickname;
    private String portrait;
    private int post_num;
    private int rank;
    private int thread_num;
    private long tid;
    private long uid;

    public int aZh() {
        return this.eFI;
    }

    public int aZi() {
        return this.eFF;
    }

    public int aZj() {
        return this.eFG;
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

    public int aZk() {
        return this.eFH;
    }

    public String aZl() {
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

    public boolean aZm() {
        return this.eFJ;
    }

    public static d a(ElectionList electionList) {
        if (electionList == null) {
            return null;
        }
        d dVar = new d();
        dVar.oy(electionList.vote_num.intValue());
        dVar.uu(electionList.name_show);
        dVar.setPortrait(electionList.portrait);
        dVar.ow(electionList.forum_level.intValue());
        dVar.ut(electionList.apply_declaration);
        dVar.ox(electionList.rank.intValue());
        dVar.ov(electionList.apply_id.intValue());
        dVar.setPost_num(electionList.post_num.intValue());
        dVar.setThread_num(electionList.thread_num.intValue());
        dVar.ou(electionList.agree_num.intValue());
        dVar.setUid(electionList.uid.longValue());
        dVar.setTid(electionList.tid.longValue());
        dVar.iz(electionList.is_cheat.intValue() == 1);
        return dVar;
    }

    public static d a(Myrecord myrecord) {
        if (myrecord == null) {
            return null;
        }
        d dVar = new d();
        dVar.oy(myrecord.vote_num.intValue());
        dVar.uu(myrecord.name_show);
        dVar.setPortrait(myrecord.portrait);
        dVar.ow(myrecord.forum_level.intValue());
        dVar.ut(myrecord.apply_declaration);
        dVar.ox(myrecord.rank.intValue());
        dVar.ov(myrecord.apply_id.intValue());
        dVar.setPost_num(myrecord.post_num.intValue());
        dVar.setThread_num(myrecord.thread_num.intValue());
        dVar.ou(myrecord.agree_num.intValue());
        dVar.setUid(myrecord.uid.longValue());
        dVar.setTid(myrecord.tid.longValue());
        return dVar;
    }

    public void ou(int i) {
        this.eFI = i;
    }

    public void ov(int i) {
        this.eFF = i;
    }

    public void ut(String str) {
        this.apply_declaration = str;
    }

    public void ow(int i) {
        this.eFG = i;
    }

    public void uu(String str) {
        this.nickname = str;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public void setPost_num(int i) {
        this.post_num = i;
    }

    public void ox(int i) {
        this.rank = i;
    }

    public void setThread_num(int i) {
        this.thread_num = i;
    }

    public void setUid(long j) {
        this.uid = j;
    }

    public void oy(int i) {
        this.eFH = i;
    }

    public void iz(boolean z) {
        this.eFJ = z;
    }

    public void setTid(long j) {
        this.tid = j;
    }
}
