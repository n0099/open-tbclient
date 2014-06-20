package com.baidu.tieba.frs;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.core.util.bm {
    @Override // com.baidu.tbadk.core.util.bm
    public boolean a(Context context, String[] strArr) {
        String str;
        String lowerCase = strArr[0].toLowerCase();
        if (strArr.length <= 1) {
            str = null;
        } else {
            str = strArr[1];
        }
        if (lowerCase.startsWith("frs:")) {
            String substring = lowerCase.substring(4);
            if (context instanceof BaseActivity) {
                ((BaseActivity) context).sendMessage(new CustomMessage(2005000, new com.baidu.tbadk.core.atomData.m(context).a(substring, str)));
            } else if (context instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) context).a(new CustomMessage(2005000, new com.baidu.tbadk.core.atomData.m(context).a(substring, str)));
            }
        }
        return false;
    }
}
