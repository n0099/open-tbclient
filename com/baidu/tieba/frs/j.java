package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.List;
import tbclient.ForumToolPerm;
/* loaded from: classes.dex */
public class j {
    private static UserData mUserData;

    public static UserData cCp() {
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
            if (frsViewData != null && (a(a(frsViewData)) || cCs())) {
                aVar.br(4);
            } else {
                aVar.bs(4);
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

    public static boolean cCq() {
        UserData cCp = cCp();
        if (cCp == null) {
            return false;
        }
        switch (cCp.getIs_manager()) {
            case 1:
                return true;
            default:
                return false;
        }
    }

    public static boolean cCr() {
        UserData cCp = cCp();
        return cCp != null && cCp.getIs_manager() == 3;
    }

    public static boolean cCs() {
        List<ForumToolPerm> forumToolAuth;
        UserData cCp = cCp();
        if (cCp == null || (forumToolAuth = cCp.getForumToolAuth()) == null) {
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
