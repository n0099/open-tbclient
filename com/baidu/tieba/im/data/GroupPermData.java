package com.baidu.tieba.im.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class GroupPermData implements m, Serializable {
    public static final BdUniqueId TYPE_FRS_CREATE_GROUP = BdUniqueId.gen();
    private static final long serialVersionUID = 5660832418912851013L;
    private int canCreateNormal;
    private int canCreateNormalNum;
    private int canCreateOfficial;
    private int canCreateOfficialNum;
    private int canCreatePersonal;
    private int canCreatePersonalNum;
    private String createNormalTip;
    private String createOfficialTip;
    private String createPersonalTip;
    private String forumId;
    private int isManager;

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public int getIsManager() {
        return this.isManager;
    }

    public boolean isManager() {
        return this.isManager == 1;
    }

    public void setIsManager(int i) {
        this.isManager = i;
    }

    public int getCanCreateNormal() {
        return this.canCreateNormal;
    }

    public boolean isCreateNormal() {
        return this.canCreateNormal == 1;
    }

    public boolean isCreatePersonal() {
        return this.canCreatePersonal == 1;
    }

    public void setCanCreatePersonal(int i) {
        this.canCreatePersonal = i;
    }

    public void setCanCreateNormal(int i) {
        this.canCreateNormal = i;
    }

    public int getCanCreateOfficial() {
        return this.canCreateOfficial;
    }

    public boolean isCreateOfficial() {
        return this.canCreateOfficial == 1;
    }

    public void setCanCreateOfficial(int i) {
        this.canCreateOfficial = i;
    }

    public String getCreateNormalTip() {
        return this.createNormalTip;
    }

    public void setCreateNormalTip(String str) {
        this.createNormalTip = str;
    }

    public String getCreateOfficialTip() {
        return this.createOfficialTip;
    }

    public void setCreateOfficialTip(String str) {
        this.createOfficialTip = str;
    }

    public String getCreatePersonalTip() {
        return this.createPersonalTip;
    }

    public void setCreatePersonalTip(String str) {
        this.createPersonalTip = str;
    }

    public int getCanCreateNormalNum() {
        return this.canCreateNormalNum;
    }

    public void setCanCreateNormalNum(int i) {
        this.canCreateNormalNum = i;
    }

    public int getCanCreateOfficialNum() {
        return this.canCreateOfficialNum;
    }

    public void setCanCreateOfficialNum(int i) {
        this.canCreateOfficialNum = i;
    }

    public int getCanCreatePersonalNum() {
        return this.canCreatePersonalNum;
    }

    public void setCanCreatePersonalNum(int i) {
        this.canCreatePersonalNum = i;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return TYPE_FRS_CREATE_GROUP;
    }
}
