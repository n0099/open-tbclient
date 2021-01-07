package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.List;
import tbclient.ForumToolPerm;
/* loaded from: classes.dex */
public class j {
    private static UserData mUserData;

    public static UserData cEJ() {
        return mUserData;
    }

    private static UserData a(FrsViewData frsViewData) {
        mUserData = frsViewData != null ? frsViewData.getUserData() : null;
        return mUserData;
    }

    public static void a(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout, FrsViewData frsViewData) {
        if (threadCommentAndPraiseInfoLayout != null) {
            if (frsViewData != null && a(a(frsViewData))) {
                threadCommentAndPraiseInfoLayout.setManageVisible(true);
            } else {
                threadCommentAndPraiseInfoLayout.setManageVisible(false);
            }
        }
    }

    public static void a(com.baidu.card.a aVar, FrsViewData frsViewData) {
        if (aVar != null) {
            if (frsViewData != null && (a(a(frsViewData)) || cEM())) {
                aVar.bs(4);
            } else {
                aVar.bt(4);
            }
        }
    }

    public static boolean a(UserData userData) {
        if (userData == null) {
            return false;
        }
        switch (userData.getIs_manager()) {
            case 1:
            case 2:
            case 3:
            case 4:
                return true;
            default:
                return false;
        }
    }

    public static boolean cEK() {
        UserData cEJ = cEJ();
        if (cEJ == null) {
            return false;
        }
        switch (cEJ.getIs_manager()) {
            case 1:
                return true;
            default:
                return false;
        }
    }

    public static boolean cEL() {
        UserData cEJ = cEJ();
        return cEJ != null && cEJ.getIs_manager() == 3;
    }

    public static boolean cEM() {
        List<ForumToolPerm> forumToolAuth;
        UserData cEJ = cEJ();
        if (cEJ == null || (forumToolAuth = cEJ.getForumToolAuth()) == null) {
            return false;
        }
        for (int i = 0; i < forumToolAuth.size(); i++) {
            ForumToolPerm forumToolPerm = forumToolAuth.get(i);
            if (forumToolPerm != null && forumToolPerm.perm.longValue() == 1) {
                return true;
            }
        }
        return false;
    }
}
