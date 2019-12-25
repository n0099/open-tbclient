package com.baidu.tieba.barselect.data;

import tbclient.ElectionList;
import tbclient.Myrecord;
/* loaded from: classes5.dex */
public class d {
    private String apply_declaration;
    private int fxD;
    private int fxE;
    private int fxF;
    private int fxG;
    private boolean fxH = false;
    private String nickname;
    private String portrait;
    private int post_num;
    private int rank;
    private int thread_num;
    private long tid;
    private long uid;

    public int brl() {
        return this.fxG;
    }

    public int brm() {
        return this.fxD;
    }

    public int brn() {
        return this.fxE;
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

    public int bro() {
        return this.fxF;
    }

    public String brp() {
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

    public boolean brq() {
        return this.fxH;
    }

    public static d a(ElectionList electionList) {
        if (electionList == null) {
            return null;
        }
        d dVar = new d();
        dVar.qS(electionList.vote_num.intValue());
        dVar.setNickname(electionList.name_show);
        dVar.setPortrait(electionList.portrait);
        dVar.qQ(electionList.forum_level.intValue());
        dVar.zn(electionList.apply_declaration);
        dVar.qR(electionList.rank.intValue());
        dVar.qP(electionList.apply_id.intValue());
        dVar.setPost_num(electionList.post_num.intValue());
        dVar.setThread_num(electionList.thread_num.intValue());
        dVar.qO(electionList.agree_num.intValue());
        dVar.setUid(electionList.uid.longValue());
        dVar.setTid(electionList.tid.longValue());
        dVar.jQ(electionList.is_cheat.intValue() == 1);
        return dVar;
    }

    public static d a(Myrecord myrecord) {
        if (myrecord == null) {
            return null;
        }
        d dVar = new d();
        dVar.qS(myrecord.vote_num.intValue());
        dVar.setNickname(myrecord.name_show);
        dVar.setPortrait(myrecord.portrait);
        dVar.qQ(myrecord.forum_level.intValue());
        dVar.zn(myrecord.apply_declaration);
        dVar.qR(myrecord.rank.intValue());
        dVar.qP(myrecord.apply_id.intValue());
        dVar.setPost_num(myrecord.post_num.intValue());
        dVar.setThread_num(myrecord.thread_num.intValue());
        dVar.qO(myrecord.agree_num.intValue());
        dVar.setUid(myrecord.uid.longValue());
        dVar.setTid(myrecord.tid.longValue());
        return dVar;
    }

    public void qO(int i) {
        this.fxG = i;
    }

    public void qP(int i) {
        this.fxD = i;
    }

    public void zn(String str) {
        this.apply_declaration = str;
    }

    public void qQ(int i) {
        this.fxE = i;
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

    public void qR(int i) {
        this.rank = i;
    }

    public void setThread_num(int i) {
        this.thread_num = i;
    }

    public void setUid(long j) {
        this.uid = j;
    }

    public void qS(int i) {
        this.fxF = i;
    }

    public void jQ(boolean z) {
        this.fxH = z;
    }

    public void setTid(long j) {
        this.tid = j;
    }
}
