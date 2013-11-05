package com.baidu.tieba.im.data;

import java.io.Serializable;
/* loaded from: classes.dex */
public class GroupPermData implements Serializable {
    private static final long serialVersionUID = 5660832418912851013L;
    private int canCreateNormal;
    private int canCreateOfficial;
    private int canCreatePersonal;
    private String createNormalTip;
    private String createOfficialTip;
    private String createPersonalTip;
    private int isManager;

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
}
