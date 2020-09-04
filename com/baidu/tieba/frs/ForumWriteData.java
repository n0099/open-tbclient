package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.data.PostTopicData;
import java.io.Serializable;
/* loaded from: classes.dex */
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

    public void setMem_type(int i) {
        this.mem_type = i;
    }

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public void setTopicData(PostTopicData postTopicData) {
        this.topicData = postTopicData;
    }

    public void setForumLevel(int i) {
        this.forumLevel = i;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setPrivateThread(int i) {
        this.privateThread = i;
    }

    public void setDefaultZone(int i) {
        this.defaultZone = i;
    }
}
