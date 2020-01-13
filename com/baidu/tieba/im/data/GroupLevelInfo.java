package com.baidu.tieba.im.data;

import java.io.Serializable;
import java.util.List;
/* loaded from: classes8.dex */
public class GroupLevelInfo implements Serializable {
    private static final long serialVersionUID = -1233726007002267351L;
    private int activeDay;
    private int alreadyCreateMemGroup;
    private boolean canCreateMember;
    private int grade;
    private long groupId;
    private boolean isGroupAuthor;
    private boolean isMemGroup;
    private int leftCreateMemGroup;
    private List<LevelInfo> levelInfos;
    private String name;
    private List<LevelInfo> vipLevelInfos;

    public long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public int getGrade() {
        return this.grade;
    }

    public void setGrade(int i) {
        this.grade = i;
    }

    public int getActiveDay() {
        return this.activeDay;
    }

    public void setActiveDay(int i) {
        this.activeDay = i;
    }

    public List<LevelInfo> getLevelInfos() {
        return this.levelInfos;
    }

    public void setLevelInfos(List<LevelInfo> list) {
        this.levelInfos = list;
    }

    public List<LevelInfo> getVipLevelInfos() {
        return this.vipLevelInfos;
    }

    public void setVipLevelInfos(List<LevelInfo> list) {
        this.vipLevelInfos = list;
    }

    /* loaded from: classes8.dex */
    public static class LevelInfo implements Serializable {
        private static final long serialVersionUID = -3336118486107034728L;
        private int grade;
        private String intro;
        private int maxMemberNum;
        private int thresholdDay;

        public int getGrade() {
            return this.grade;
        }

        public void setGrade(int i) {
            this.grade = i;
        }

        public String getIntro() {
            return this.intro;
        }

        public void setIntro(String str) {
            this.intro = str;
        }

        public int getThresholdDay() {
            return this.thresholdDay;
        }

        public void setThresholdDay(int i) {
            this.thresholdDay = i;
        }

        public int getMaxMemberNum() {
            return this.maxMemberNum;
        }

        public void setMaxMemberNum(int i) {
            this.maxMemberNum = i;
        }
    }

    public boolean isMemGroup() {
        return this.isMemGroup;
    }

    public void setMemGroup(boolean z) {
        this.isMemGroup = z;
    }

    public boolean isGroupAuthor() {
        return this.isGroupAuthor;
    }

    public void setGroupAuthor(boolean z) {
        this.isGroupAuthor = z;
    }

    public boolean isCanCreateMember() {
        return this.canCreateMember;
    }

    public void setCanCreateMember(boolean z) {
        this.canCreateMember = z;
    }

    public int getAlreadyCreateMemGroup() {
        return this.alreadyCreateMemGroup;
    }

    public void setAlreadyCreateMemGroup(int i) {
        this.alreadyCreateMemGroup = i;
    }

    public int getLeftCreateMemGroup() {
        return this.leftCreateMemGroup;
    }

    public void setLeftCreateMemGroup(int i) {
        this.leftCreateMemGroup = i;
    }
}
