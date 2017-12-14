package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
/* loaded from: classes.dex */
public class d {
    private static UserData mUserData;

    public static UserData ala() {
        return mUserData;
    }

    private static UserData a(com.baidu.tieba.tbadkCore.k kVar) {
        mUserData = kVar != null ? kVar.getUserData() : null;
        return mUserData;
    }

    public static void a(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout, com.baidu.tieba.tbadkCore.k kVar) {
        if (threadCommentAndPraiseInfoLayout != null) {
            if (b(a(kVar))) {
                threadCommentAndPraiseInfoLayout.setManageVisible(true);
            } else {
                threadCommentAndPraiseInfoLayout.setManageVisible(false);
            }
        }
    }

    public static boolean b(UserData userData) {
        if (userData == null) {
            return false;
        }
        switch (userData.getIs_manager()) {
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    public static boolean alb() {
        UserData ala = ala();
        if (ala == null) {
            return false;
        }
        switch (ala.getIs_manager()) {
            case 1:
                return true;
            default:
                return false;
        }
    }
}
