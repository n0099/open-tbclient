package com.baidu.tieba.enterForum.home;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements bi.a {
    final /* synthetic */ e bGG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.bGG = eVar;
    }

    @Override // com.baidu.tbadk.core.util.bi.a
    public int a(TbPageContext<?> tbPageContext, String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return 3;
        }
        String str = strArr[0];
        boolean isInstalledPackage = this.bGG.getBaseFragmentActivity() != null ? UtilHelper.isInstalledPackage(this.bGG.getBaseFragmentActivity().getBaseContext(), "com.baidu.wefan") : false;
        if (!TextUtils.isEmpty(str) && str.startsWith("wefan:") && isInstalledPackage) {
            try {
                Intent intent = new Intent();
                intent.setData(Uri.parse(str));
                this.bGG.getBaseFragmentActivity().startActivity(intent);
                return 0;
            } catch (Exception e) {
                return 3;
            }
        }
        return 3;
    }
}
