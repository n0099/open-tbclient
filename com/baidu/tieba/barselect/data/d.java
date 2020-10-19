package com.baidu.tieba.barselect.data;

import tbclient.ElectionList;
import tbclient.Myrecord;
/* loaded from: classes21.dex */
public class d {
    private int agree_num;
    private String apply_declaration;
    private int hzd;
    private int hze;
    private boolean hzf = false;
    private int hzg;
    private String nickname;
    private String portrait;
    private int post_num;
    private int rank;
    private int thread_num;
    private long tid;
    private long uid;
    private int vote_num;

    public int cho() {
        return this.agree_num;
    }

    public int chp() {
        return this.hzd;
    }

    public int chq() {
        return this.hze;
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

    public int chr() {
        return this.vote_num;
    }

    public String chs() {
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

    public boolean cht() {
        return this.hzf;
    }

    public int chu() {
        return this.hzg;
    }

    public void wj(int i) {
        this.hzg = i;
    }

    public static d a(ElectionList electionList) {
        if (electionList == null) {
            return null;
        }
        d dVar = new d();
        dVar.wm(electionList.vote_num.intValue());
        dVar.setNickname(electionList.name_show);
        dVar.setPortrait(electionList.portrait);
        dVar.wl(electionList.forum_level.intValue());
        dVar.Ie(electionList.apply_declaration);
        dVar.setRank(electionList.rank.intValue());
        dVar.wk(electionList.apply_id.intValue());
        dVar.setPost_num(electionList.post_num.intValue());
        dVar.setThread_num(electionList.thread_num.intValue());
        dVar.setAgree_num(electionList.agree_num.intValue());
        dVar.setUid(electionList.uid.longValue());
        dVar.setTid(electionList.tid.longValue());
        dVar.nL(electionList.is_cheat.intValue() == 1);
        dVar.wj(electionList.is_pass_audit.intValue());
        return dVar;
    }

    public static d a(Myrecord myrecord) {
        if (myrecord == null) {
            return null;
        }
        d dVar = new d();
        dVar.wm(myrecord.vote_num.intValue());
        dVar.setNickname(myrecord.name_show);
        dVar.setPortrait(myrecord.portrait);
        dVar.wl(myrecord.forum_level.intValue());
        dVar.Ie(myrecord.apply_declaration);
        dVar.setRank(myrecord.rank.intValue());
        dVar.wk(myrecord.apply_id.intValue());
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

    public void wk(int i) {
        this.hzd = i;
    }

    public void Ie(String str) {
        this.apply_declaration = str;
    }

    public void wl(int i) {
        this.hze = i;
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

    public void wm(int i) {
        this.vote_num = i;
    }

    public void nL(boolean z) {
        this.hzf = z;
    }

    public void setTid(long j) {
        this.tid = j;
    }
}
