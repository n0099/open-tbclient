package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.data.PostTopicData;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class ForumWriteData implements Serializable {
    public final AntiData antiData;
    public String avatar;
    public String firstDir;
    public final String forumId;
    public final String forumName;
    public FrsTabInfoData frsTabInfo;
    public String mFrom;
    public int mem_type;
    public final PostPrefixData prefixData;
    public int privateThread;
    public String secondDir;
    public String specialForumType;
    public int statisticFrom;
    public PostTopicData topicData;
    public String writeCallFrom;
    public int categoryId = -1;
    public int forumLevel = -1;
    public int defaultZone = -1;

    public ForumWriteData(String str, String str2, PostPrefixData postPrefixData, AntiData antiData) {
        this.forumId = str;
        this.forumName = str2;
        this.prefixData = postPrefixData;
        this.antiData = antiData;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setCategoryId(int i2) {
        this.categoryId = i2;
    }

    public void setDefaultZone(int i2) {
        this.defaultZone = i2;
    }

    public void setForumLevel(int i2) {
        this.forumLevel = i2;
    }

    public void setMem_type(int i2) {
        this.mem_type = i2;
    }

    public void setPrivateThread(int i2) {
        this.privateThread = i2;
    }

    public void setTopicData(PostTopicData postTopicData) {
        this.topicData = postTopicData;
    }
}
