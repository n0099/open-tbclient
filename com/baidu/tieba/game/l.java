package com.baidu.tieba.game;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.bi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements bi {
    @Override // com.baidu.tbadk.core.util.bi
    public boolean a(Context context, String[] strArr) {
        if (strArr == null || strArr.length == 0 || !strArr[0].equals("gamecenter:")) {
            return false;
        }
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.v(context)));
            return true;
        } else if (context instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) context).a(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.v(context)));
            return true;
        } else {
            return false;
        }
    }
}
