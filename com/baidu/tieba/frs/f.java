package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
/* loaded from: classes.dex */
public class f {
    private static UserData mUserData;

    public static UserData auG() {
        return mUserData;
    }

    private static UserData a(com.baidu.tieba.tbadkCore.m mVar) {
        mUserData = mVar != null ? mVar.getUserData() : null;
        return mUserData;
    }

    public static void a(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout, com.baidu.tieba.tbadkCore.m mVar) {
        if (threadCommentAndPraiseInfoLayout != null) {
            if (b(a(mVar))) {
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

    public static boolean auH() {
        UserData auG = auG();
        if (auG == null) {
            return false;
        }
        switch (auG.getIs_manager()) {
            case 1:
                return true;
            default:
                return false;
        }
    }
}
