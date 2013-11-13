package com.baidu.tieba.forumdetail;

import com.google.gson.annotations.SerializedName;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.io.Serializable;
/* loaded from: classes.dex */
public class ForumDetailData implements Serializable {
    private static final long serialVersionUID = -7426602976779355011L;
    @SerializedName("errno")
    public int errorNo = 0;
    @SerializedName("errmsg")
    public String errorMsg = "";
    @SerializedName("forum_info")
    public ForumInfo forumInfo = null;
    @SerializedName("badges")
    public BadgeInfo[] badges = new BadgeInfo[0];
    @SerializedName("forum_dir")
    public ForumDirInfo forumDir = null;
    @SerializedName("thread_list")
    public ThreadInfo[] threads = new ThreadInfo[0];

    /* loaded from: classes.dex */
    public class BadgeInfo implements Serializable {
        @SerializedName("badge_id")
        public long badgeID = 0;
        @SerializedName("badge_url")
        public String badgeURL = "";
    }

    /* loaded from: classes.dex */
    public class ForumContent implements Serializable {
        @SerializedName("type")
        public int type = 0;
        @SerializedName("text")
        public String text = "";
    }

    /* loaded from: classes.dex */
    public class ForumDirInfo implements Serializable {
        @SerializedName("hot_value")
        public long hotValue;
        @SerializedName("rank")
        public int rank = 0;
        @SerializedName("level_1_name")
        public String levelOneName = "";
        @SerializedName("level_1_menu_type")
        public long levelOneMenuType = 0;
        @SerializedName("level_1_menu_id")
        public long levelOneMenuID = 0;
        @SerializedName("level_2_name")
        public String levelTwoName = "";
        @SerializedName("level_2_menu_type")
        public long levelTwoMenuType = 0;
        @SerializedName("level_2_menu_id")
        public long levelTwoMenuID = 0;
    }

    /* loaded from: classes.dex */
    public class ForumInfo implements Serializable {
        @SerializedName("forum_id")
        public int forumID = 0;
        @SerializedName("forum_name")
        public String forumName = "";
        @SerializedName("member_count")
        public long memberCount = 0;
        @SerializedName("thread_count")
        public long threadCount = 0;
        @SerializedName("is_like")
        public int isLike = 0;
        @SerializedName("avatar")
        public String avatar = "";
        @SerializedName("slogan")
        public String slogan = "";
        @SerializedName("content")
        public ForumContent[] contents = new ForumContent[0];
    }

    /* loaded from: classes.dex */
    public class ThreadAbstract implements Serializable {
        @SerializedName("type")
        public int type = 0;
        @SerializedName("text")
        public String text = "";
    }

    /* loaded from: classes.dex */
    public class ThreadInfo implements Serializable {
        @SerializedName(LocaleUtil.INDONESIAN)
        public long id = 0;
        @SerializedName("tid")
        public long tId = 0;
        @SerializedName("title")
        public String title = "";
        @SerializedName("reply_num")
        public long replyNum = 0;
        @SerializedName("view_num")
        public long viewNum = 0;
        public String forumName = "";
        public String postAuthor = "";
        @SerializedName("last_time")
        public String lastTime = "";
        @SerializedName("last_time_int")
        public long lastTimeStamp = 0;
        @SerializedName("abstract")
        public ThreadAbstract[] abstracts = new ThreadAbstract[0];
    }
}
