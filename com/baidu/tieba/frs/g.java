package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
/* loaded from: classes6.dex */
public class g {
    private static UserData mUserData;

    public static UserData aAv() {
        return mUserData;
    }

    private static UserData a(com.baidu.tieba.tbadkCore.l lVar) {
        mUserData = lVar != null ? lVar.getUserData() : null;
        return mUserData;
    }

    public static void a(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout, com.baidu.tieba.tbadkCore.l lVar) {
        if (threadCommentAndPraiseInfoLayout != null) {
            if (lVar != null && lVar.hjZ != 303 && b(a(lVar))) {
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

    public static boolean aAw() {
        UserData aAv = aAv();
        if (aAv == null) {
            return false;
        }
        switch (aAv.getIs_manager()) {
            case 1:
                return true;
            default:
                return false;
        }
    }
}
