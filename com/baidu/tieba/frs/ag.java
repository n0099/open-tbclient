package com.baidu.tieba.frs;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements com.baidu.tbadk.core.util.bh {
    Pattern frsPattern = Pattern.compile("http://tieba.baidu.com/f\\?kw=([^&]+)");

    @Override // com.baidu.tbadk.core.util.bh
    public boolean a(Context context, String[] strArr) {
        String str;
        String substring;
        if (strArr == null || strArr[0] == null) {
            return false;
        }
        String lowerCase = strArr[0].toLowerCase();
        Matcher matcher = this.frsPattern.matcher(lowerCase);
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
            ((BaseActivity) context).sendMessage(new CustomMessage(2003000, new FrsActivityConfig(context).createNormalCfg(substring, str)));
            return true;
        } else if (context instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) context).sendMessage(new CustomMessage(2003000, new FrsActivityConfig(context).createNormalCfg(substring, str)));
            return true;
        } else {
            return false;
        }
    }
}
