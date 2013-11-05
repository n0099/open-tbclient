package com.baidu.tieba.im.data;

import java.io.Serializable;
import java.util.List;
/* loaded from: classes.dex */
public class GroupLevelInfo implements Serializable {
    private static final long serialVersionUID = -1233726007002267351L;
    private int activeDay;
    private int grade;
    private long groupId;
    private List<LevelInfo> levelInfos;
    private String name;

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

    public String toString() {
        return "GroupLevelInfo [groupId=" + this.groupId + ", name=" + this.name + ", grade=" + this.grade + ", activeDay=" + this.activeDay + ", levelInfos=" + this.levelInfos + "]";
    }

    /* loaded from: classes.dex */
    public class LevelInfo implements Serializable {
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

        public String toString() {
            return "LevelInfo [grade=" + this.grade + ", intro=" + this.intro + ", thresholdDay=" + this.thresholdDay + ", maxMemberNum=" + this.maxMemberNum + "]";
        }
    }
}
