package com.baidu.tieba.flist;

import android.content.Context;
import com.baidu.gson.GsonBuilder;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tieba.data.ForumInfoData;
import java.io.Serializable;
/* loaded from: classes.dex */
public class ForumListModel extends com.baidu.adp.base.e implements Serializable {
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

    /* loaded from: classes.dex */
    public class List implements Serializable {
        private static final long serialVersionUID = -3206282936395220632L;
        public ForumInfoData[] forum_list;
        public int has_more = 0;
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
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public boolean isOk() {
        return a;
    }

    public static ForumListModel new_fetch(Context context, RequestParams requestParams) {
        int i;
        com.baidu.adp.lib.cache.t<String> b2;
        if (requestParams.menu_id == 0) {
            i = requestParams.menu_name.equals(requestParams.parent_menu_name) ? 9 : 10;
        } else {
            i = (requestParams.menu_type == 2 || !requestParams.menu_name.equals(requestParams.parent_menu_name)) ? 137 : 136;
        }
        b = requestParams.menu_name;
        ae aeVar = new ae(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/forumrank");
        aeVar.a("rn", String.valueOf(requestParams.rn));
        aeVar.a("offset", String.valueOf(requestParams.offset));
        aeVar.a("recommend_type", String.valueOf(requestParams.recommend_type));
        aeVar.a("menu_name", requestParams.menu_name);
        aeVar.a("menu_type", String.valueOf(i));
        String h = aeVar.h();
        a = aeVar.b();
        ForumListModel forumListModel = (ForumListModel) new GsonBuilder().create().fromJson(h, (Class<Object>) ForumListModel.class);
        if (requestParams.rn == 200 && requestParams.recommend_type == 0 && ((i == 9 || i == 136 || requestParams.menu_type == 2) && forumListModel != null && forumListModel.recommend_list_left != null && forumListModel.recommend_list_right != null && forumListModel.editor_recommend != null && forumListModel.forum_class != null && (b2 = com.baidu.tbadk.core.a.a.a().b("tb.my_posts")) != null)) {
            b2.a(String.valueOf(TbadkApplication.getCurrentAccount()) + "_" + b + "_list", h, 86400000L);
        }
        return forumListModel;
    }
}
