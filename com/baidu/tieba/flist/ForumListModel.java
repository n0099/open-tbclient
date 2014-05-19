package com.baidu.tieba.flist;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.gson.GsonBuilder;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.data.ForumInfoData;
import java.io.Serializable;
import java.util.Arrays;
/* loaded from: classes.dex */
public class ForumListModel extends com.baidu.adp.base.d implements Serializable {
    private static boolean a = false;
    private static String b = null;
    private static final long serialVersionUID = -5006585496963439439L;
    public ForumInfoData[] editor_recommend;
    public int error_code;
    public String[] forum_class;
    public List recommend_list_left;
    public List recommend_list_right;
    public long time = 0;
    public long ctime = 0;
    public long logid = 0;

    @Override // com.baidu.adp.base.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.d
    public boolean cancelLoadData() {
        return false;
    }

    public boolean isOk() {
        return a;
    }

    /* loaded from: classes.dex */
    public class List implements Serializable {
        private static final long serialVersionUID = -3206282936395220632L;
        public ForumInfoData[] forum_list;
        public int has_more = 0;

        public String toString() {
            return "List{has_more=" + this.has_more + ", forum_list=" + Arrays.toString(this.forum_list) + '}';
        }
    }

    public String toString() {
        return "DataProvider{error_code=" + this.error_code + ", editor_recommend=" + Arrays.toString(this.editor_recommend) + ", forum_class=" + Arrays.toString(this.forum_class) + ", recommend_list_left=" + this.recommend_list_left + ", recommend_list_right=" + this.recommend_list_right + ", time=" + this.time + ", ctime=" + this.ctime + ", logid=" + this.logid + '}';
    }

    public static ForumListModel new_fetch(Context context, RequestParams requestParams) {
        int i;
        com.baidu.adp.lib.cache.s<String> o;
        if (requestParams.menu_id == 0) {
            i = requestParams.menu_name.equals(requestParams.parent_menu_name) ? 9 : 10;
        } else {
            i = (requestParams.menu_type == 2 || !requestParams.menu_name.equals(requestParams.parent_menu_name)) ? 137 : 136;
        }
        b = requestParams.menu_name;
        al alVar = new al(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/forumrank");
        alVar.a("rn", String.valueOf(requestParams.rn));
        alVar.a("offset", String.valueOf(requestParams.offset));
        alVar.a("recommend_type", String.valueOf(requestParams.recommend_type));
        alVar.a("menu_name", requestParams.menu_name);
        alVar.a("menu_type", String.valueOf(i));
        String i2 = alVar.i();
        a = alVar.c();
        BdLog.d("DataProvider", "fetch", "fetched raw string\n" + i2);
        ForumListModel forumListModel = (ForumListModel) new GsonBuilder().create().fromJson(i2, (Class<Object>) ForumListModel.class);
        if (requestParams.rn == 200 && requestParams.recommend_type == 0 && ((i == 9 || i == 136 || requestParams.menu_type == 2) && forumListModel != null && forumListModel.recommend_list_left != null && forumListModel.recommend_list_right != null && forumListModel.editor_recommend != null && forumListModel.forum_class != null && (o = com.baidu.tbadk.core.a.b.a().o()) != null)) {
            o.a(String.valueOf(TbadkApplication.getCurrentAccount()) + "_" + b + "_list", i2, 86400000L);
        }
        return forumListModel;
    }

    /* loaded from: classes.dex */
    public class RequestParams implements Serializable {
        private static final long serialVersionUID = -8487620337266534315L;
        public int rn = 6;
        public int offset = 0;
        public int recommend_type = 0;
        public String menu_name = "";
        public int menu_id = 0;
        public int menu_type = 0;
        public String parent_menu_name = "";
        public int parent_menu_id = 0;
        public String level_2_name = "";

        public String toString() {
            return "?rn=" + this.rn + "&offset=" + this.offset + "&recommend_type=" + this.recommend_type + "&menu_name=" + this.menu_name + "&menu_id=" + this.menu_id + "&menu_type=" + this.menu_type + "&parent_menu_name=" + this.parent_menu_name + "&parent_menu_id=" + this.parent_menu_id;
        }
    }
}
