package com.baidu.tieba.forumdetail;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ForumDetailData extends com.baidu.adp.lib.a.b.a.a.i implements Serializable {
    private static final long serialVersionUID = -7426602976779355011L;
    public int errno = 0;
    public String errmsg = "";
    public ForumInfo forum_info = null;
    public BadgeInfo[] badges = new BadgeInfo[0];
    public ForumDirInfo forum_dir = null;
    public ThreadInfo[] thread_list = new ThreadInfo[0];

    /* loaded from: classes.dex */
    public class BadgeInfo extends com.baidu.adp.lib.a.b.a.a.i implements Serializable {
        private static final long serialVersionUID = 1;
        public long badge_id = 0;
        public String badge_url = "";
    }

    /* loaded from: classes.dex */
    public class ForumContent extends com.baidu.adp.lib.a.b.a.a.i implements Serializable {
        private static final long serialVersionUID = 1;
        public int type = 0;
        public String text = "";
    }

    /* loaded from: classes.dex */
    public class ForumDirInfo extends com.baidu.adp.lib.a.b.a.a.i implements Serializable {
        private static final long serialVersionUID = 1;
        public long hot_value;
        public int rank = 0;
        public String level_1_name = "";
        public long level_1_menu_type = 0;
        public long level_1_menu_id = 0;
        public String level_2_name = "";
        public long level_2_menu_type = 0;
        public long level_2_menu_id = 0;
    }

    /* loaded from: classes.dex */
    public class ForumInfo extends com.baidu.adp.lib.a.b.a.a.i implements Serializable {
        private static final long serialVersionUID = 1;
        public int forum_id = 0;
        public String forum_name = "";
        public long member_count = 0;
        public long thread_count = 0;
        public int is_like = 0;
        public String avatar = "";
        public String slogan = "";
        public ForumContent[] content = new ForumContent[0];
    }

    /* loaded from: classes.dex */
    public class ThreadAbstract extends com.baidu.adp.lib.a.b.a.a.i implements Serializable {
        private static final long serialVersionUID = 1;
        public int type = 0;
        public String text = "";
    }

    /* loaded from: classes.dex */
    public class ThreadInfo extends com.baidu.adp.lib.a.b.a.a.i implements Serializable {
        private static final long serialVersionUID = 1;
        public long id = 0;
        public long tid = 0;
        public String title = "";
        public long reply_num = 0;
        public long view_num = 0;
        public String forumName = "";
        public String postAuthor = "";
        public String last_time = "";
        public long last_time_int = 0;
        public ThreadAbstract[] Abstract = new ThreadAbstract[0];
    }
}
