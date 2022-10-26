package com.baidu.tieba;

import java.util.List;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
/* loaded from: classes4.dex */
public interface gv7 {
    int getErroCode();

    String getErrorText();

    List getPostList();

    ExcellentPbThreadInfo getThreadInfo();

    UserInfo getUserInfo();

    List getUserList();

    boolean isEmpty();
}
