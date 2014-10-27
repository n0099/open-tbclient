package com.baidu.tieba.game;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.GameCenterActivityConfig;
/* loaded from: classes.dex */
class o implements com.baidu.tbadk.core.util.bh {
    @Override // com.baidu.tbadk.core.util.bh
    public boolean a(Context context, String[] strArr) {
        if (strArr == null || strArr.length == 0 || !strArr[0].equals("gamecenter:")) {
            return false;
        }
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).sendMessage(new CustomMessage(2002001, new GameCenterActivityConfig(context)));
            return true;
        } else if (context instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) context).sendMessage(new CustomMessage(2002001, new GameCenterActivityConfig(context)));
            return true;
        } else {
            return false;
        }
    }
}
