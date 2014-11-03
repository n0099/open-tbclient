package com.baidu.tieba.flist;

import android.content.Context;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.data.ForumInfoData;
import java.io.Serializable;
/* loaded from: classes.dex */
public class ForumListModel extends com.baidu.adp.base.e implements Serializable {
    private static boolean avl = false;
    private static String menu_name = null;
    private static final long serialVersionUID = -5006585496963439439L;
    public long ctime;
    public ForumInfoData[] editor_recommend;
    public int error_code;
    public String[] forum_class;
    public long logid;
    public List recommend_list_left;
    public List recommend_list_right;
    public long time;

    /* loaded from: classes.dex */
    public class List extends com.baidu.adp.lib.a.b.a.a.i implements Serializable {
        private static final long serialVersionUID = -3206282936395220632L;
        public ForumInfoData[] forum_list;
        public int has_more = 0;
    }

    /* loaded from: classes.dex */
    public class RequestParams extends com.baidu.adp.lib.a.b.a.a.i implements Serializable {
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

    public ForumListModel() {
        this.time = 0L;
        this.ctime = 0L;
        this.logid = 0L;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public ForumListModel(Context context) {
        super(context);
        this.time = 0L;
        this.ctime = 0L;
        this.logid = 0L;
    }

    public boolean isOk() {
        return avl;
    }

    public static ForumListModel new_fetch(Context context, RequestParams requestParams) {
        int i;
        com.baidu.adp.lib.cache.t<String> bd;
        if (requestParams.menu_id == 0) {
            i = requestParams.menu_name.equals(requestParams.parent_menu_name) ? 9 : 10;
        } else {
            i = (requestParams.menu_type == 2 || !requestParams.menu_name.equals(requestParams.parent_menu_name)) ? 137 : 136;
        }
        menu_name = requestParams.menu_name;
        com.baidu.tbadk.core.util.ac acVar = new com.baidu.tbadk.core.util.ac(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/forumrank");
        acVar.k("rn", String.valueOf(requestParams.rn));
        acVar.k("offset", String.valueOf(requestParams.offset));
        acVar.k("recommend_type", String.valueOf(requestParams.recommend_type));
        acVar.k("menu_name", requestParams.menu_name);
        acVar.k("menu_type", String.valueOf(i));
        String lA = acVar.lA();
        avl = acVar.mf();
        ForumListModel forumListModel = (ForumListModel) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(lA, ForumListModel.class);
        if (requestParams.rn == 200 && requestParams.recommend_type == 0 && ((i == 9 || i == 136 || requestParams.menu_type == 2) && forumListModel != null && forumListModel.recommend_list_left != null && forumListModel.recommend_list_right != null && forumListModel.editor_recommend != null && forumListModel.forum_class != null && (bd = com.baidu.tbadk.core.a.a.kS().bd("tb.my_posts")) != null)) {
            bd.a(String.valueOf(TbadkApplication.getCurrentAccount()) + "_" + menu_name + "_list", lA, 86400000L);
        }
        return forumListModel;
    }
}
