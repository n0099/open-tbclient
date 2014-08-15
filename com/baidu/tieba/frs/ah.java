package com.baidu.tieba.frs;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements com.baidu.tbadk.core.util.bi {
    Pattern a = Pattern.compile("http://tieba.baidu.com/f\\?kw=([^&]+)");

    @Override // com.baidu.tbadk.core.util.bi
    public boolean a(Context context, String[] strArr) {
        String str;
        String substring;
        if (strArr == null || strArr[0] == null) {
            return false;
        }
        String lowerCase = strArr[0].toLowerCase();
        Matcher matcher = this.a.matcher(lowerCase);
        if (strArr.length <= 1) {
            str = null;
        } else {
            str = strArr[1];
        }
        if (matcher.find()) {
            substring = matcher.group(1);
        } else if (!lowerCase.startsWith("frs:")) {
            return false;
        } else {
            substring = lowerCase.substring(4);
        }
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).sendMessage(new CustomMessage(2003000, new com.baidu.tbadk.core.atomData.s(context).a(substring, str)));
            return true;
        } else if (context instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) context).a(new CustomMessage(2003000, new com.baidu.tbadk.core.atomData.s(context).a(substring, str)));
            return true;
        } else {
            return false;
        }
    }
}
