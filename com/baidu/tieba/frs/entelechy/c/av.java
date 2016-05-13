package com.baidu.tieba.frs.entelechy.c;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements View.OnClickListener {
    final /* synthetic */ au bqr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(au auVar) {
        this.bqr = auVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        String str;
        String str2;
        baseActivity = this.bqr.boS;
        if (baseActivity.checkUpIsLogin()) {
            String str3 = null;
            if (view.getTag() instanceof String) {
                str3 = (String) view.getTag();
            }
            if (!TextUtils.isEmpty(str3)) {
                bg ut = bg.ut();
                baseActivity2 = this.bqr.boS;
                ut.c(baseActivity2.getPageContext(), new String[]{str3});
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                aw awVar = new aw("show_picture");
                str = this.bqr.mForumId;
                aw ac = awVar.ac("fid", str);
                str2 = this.bqr.bqq;
                TiebaStatic.log(ac.ac("tid", str2).ac("uid", currentAccount));
            }
        }
    }
}
