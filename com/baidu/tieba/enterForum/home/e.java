package com.baidu.tieba.enterForum.home;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bb;
/* loaded from: classes.dex */
class e implements bb.a {
    @Override // com.baidu.tbadk.core.util.bb.a
    public int a(TbPageContext<?> tbPageContext, String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return 3;
        }
        String str = strArr[0];
        if (TextUtils.isEmpty(str) || !str.startsWith("wefan:")) {
            return 3;
        }
        try {
            Intent intent = new Intent();
            intent.setData(Uri.parse(str));
            tbPageContext.getPageActivity().startActivity(intent);
            return 0;
        } catch (Exception e) {
            return 3;
        }
    }
}
