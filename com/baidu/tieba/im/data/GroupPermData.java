package com.baidu.tieba.im.data;

import com.baidu.adp.BdUniqueId;
import d.b.b.j.e.n;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class GroupPermData implements n, Serializable {
    public static final int MANAGER = 1;
    public static final int NORMAL = 1;
    public static final int OFFICIAL = 1;
    public static final int PERSONAL = 1;
    public static final BdUniqueId TYPE_FRS_CREATE_GROUP = BdUniqueId.gen();
    public static final long serialVersionUID = 5660832418912851013L;
    public int canCreateNormal;
    public int canCreateNormalNum;
    public int canCreateOfficial;
    public int canCreateOfficialNum;
    public int canCreatePersonal;
    public int canCreatePersonalNum;
    public String createNormalTip;
    public String createOfficialTip;
    public String createPersonalTip;
    public String forumId;
    public int isManager;

    public int getCanCreateNormal() {
        return this.canCreateNormal;
    }

    public int getCanCreateNormalNum() {
        return this.canCreateNormalNum;
    }

    public int getCanCreateOfficial() {
        return this.canCreateOfficial;
    }

    public int getCanCreateOfficialNum() {
        return this.canCreateOfficialNum;
    }

    public int getCanCreatePersonalNum() {
        return this.canCreatePersonalNum;
    }

    public String getCreateNormalTip() {
        return this.createNormalTip;
    }

    public String getCreateOfficialTip() {
        return this.createOfficialTip;
    }

    public String getCreatePersonalTip() {
        return this.createPersonalTip;
    }

    public String getForumId() {
        return this.forumId;
    }

    public int getIsManager() {
        return this.isManager;
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return TYPE_FRS_CREATE_GROUP;
    }

    public boolean isCreateNormal() {
        return this.canCreateNormal == 1;
    }

    public boolean isCreateOfficial() {
        return this.canCreateOfficial == 1;
    }

    public boolean isCreatePersonal() {
        return this.canCreatePersonal == 1;
    }

    public boolean isManager() {
        return this.isManager == 1;
    }

    public void setCanCreateNormal(int i) {
        this.canCreateNormal = i;
    }

    public void setCanCreateNormalNum(int i) {
        this.canCreateNormalNum = i;
    }

    public void setCanCreateOfficial(int i) {
        this.canCreateOfficial = i;
    }

    public void setCanCreateOfficialNum(int i) {
        this.canCreateOfficialNum = i;
    }

    public void setCanCreatePersonal(int i) {
        this.canCreatePersonal = i;
    }

    public void setCanCreatePersonalNum(int i) {
        this.canCreatePersonalNum = i;
    }

    public void setCreateNormalTip(String str) {
        this.createNormalTip = str;
    }

    public void setCreateOfficialTip(String str) {
        this.createOfficialTip = str;
    }

    public void setCreatePersonalTip(String str) {
        this.createPersonalTip = str;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setIsManager(int i) {
        this.isManager = i;
    }
}
