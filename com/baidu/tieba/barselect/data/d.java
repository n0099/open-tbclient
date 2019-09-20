package com.baidu.tieba.barselect.data;

import tbclient.ElectionList;
import tbclient.Myrecord;
/* loaded from: classes3.dex */
public class d {
    private String apply_declaration;
    private int exN;
    private int exO;
    private int exP;
    private int exQ;
    private boolean exR = false;
    private String nickname;
    private String portrait;
    private int post_num;
    private int rank;
    private int thread_num;
    private long tid;
    private long uid;

    public int aZf() {
        return this.exQ;
    }

    public int aZg() {
        return this.exN;
    }

    public int aZh() {
        return this.exO;
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

    public int aZi() {
        return this.exP;
    }

    public String aZj() {
        return this.apply_declaration;
    }

    public String aZk() {
        return this.nickname;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public long getTid() {
        return this.tid;
    }

    public boolean aZl() {
        return this.exR;
    }

    public static d a(ElectionList electionList) {
        if (electionList == null) {
            return null;
        }
        d dVar = new d();
        dVar.px(electionList.vote_num.intValue());
        dVar.vR(electionList.name_show);
        dVar.setPortrait(electionList.portrait);
        dVar.pv(electionList.forum_level.intValue());
        dVar.vQ(electionList.apply_declaration);
        dVar.pw(electionList.rank.intValue());
        dVar.pu(electionList.apply_id.intValue());
        dVar.setPost_num(electionList.post_num.intValue());
        dVar.setThread_num(electionList.thread_num.intValue());
        dVar.pt(electionList.agree_num.intValue());
        dVar.setUid(electionList.uid.longValue());
        dVar.setTid(electionList.tid.longValue());
        dVar.iw(electionList.is_cheat.intValue() == 1);
        return dVar;
    }

    public static d a(Myrecord myrecord) {
        if (myrecord == null) {
            return null;
        }
        d dVar = new d();
        dVar.px(myrecord.vote_num.intValue());
        dVar.vR(myrecord.name_show);
        dVar.setPortrait(myrecord.portrait);
        dVar.pv(myrecord.forum_level.intValue());
        dVar.vQ(myrecord.apply_declaration);
        dVar.pw(myrecord.rank.intValue());
        dVar.pu(myrecord.apply_id.intValue());
        dVar.setPost_num(myrecord.post_num.intValue());
        dVar.setThread_num(myrecord.thread_num.intValue());
        dVar.pt(myrecord.agree_num.intValue());
        dVar.setUid(myrecord.uid.longValue());
        dVar.setTid(myrecord.tid.longValue());
        return dVar;
    }

    public void pt(int i) {
        this.exQ = i;
    }

    public void pu(int i) {
        this.exN = i;
    }

    public void vQ(String str) {
        this.apply_declaration = str;
    }

    public void pv(int i) {
        this.exO = i;
    }

    public void vR(String str) {
        this.nickname = str;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public void setPost_num(int i) {
        this.post_num = i;
    }

    public void pw(int i) {
        this.rank = i;
    }

    public void setThread_num(int i) {
        this.thread_num = i;
    }

    public void setUid(long j) {
        this.uid = j;
    }

    public void px(int i) {
        this.exP = i;
    }

    public void iw(boolean z) {
        this.exR = z;
    }

    public void setTid(long j) {
        this.tid = j;
    }
}
