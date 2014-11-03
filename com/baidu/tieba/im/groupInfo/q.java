package com.baidu.tieba.im.groupInfo;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.util.bi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements bi {
    @Override // com.baidu.tbadk.core.util.bi
    public boolean a(Context context, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        String str = strArr[0];
        if (str.contains("tieba.baidu.com/group/index?id=")) {
            int indexOf = str.indexOf("tieba.baidu.com/group/index?id=") + "tieba.baidu.com/group/index?id=".length();
            int lastIndexOf = str.lastIndexOf(38);
            if (lastIndexOf == -1 || lastIndexOf < indexOf) {
                lastIndexOf = str.length();
            }
            long a = com.baidu.adp.lib.g.c.a(str.substring(indexOf, lastIndexOf), 0L);
            if (a <= 0) {
                return false;
            }
            GroupInfoActivityConfig groupInfoActivityConfig = new GroupInfoActivityConfig(context, a, 0);
            if (context instanceof BaseActivity) {
                ((BaseActivity) context).sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
                return true;
            } else if (context instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) context).sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
                return true;
            }
        }
        return false;
    }
}
