package com.baidu.tbadk.widget.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a aEP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.aEP = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        TbPageContext tbPageContext;
        String str2;
        if (bi.ah(this.aEP.getContext())) {
            String str3 = (String) view.getTag(t.g.tag_forum_name);
            String valueOf = String.valueOf(view.getTag(t.g.tag_forum_id));
            TextView textView = (TextView) view;
            if (aw.aQ(str3)) {
                str = this.aEP.aEJ;
                if (!TextUtils.isEmpty(str)) {
                    str2 = this.aEP.aEJ;
                    TiebaStatic.log(new au(str2).r("obj_type", 1).aa(ImageViewerConfig.FORUM_ID, valueOf));
                }
                tbPageContext = this.aEP.mTbPageContext;
                w wVar = new w(tbPageContext);
                wVar.setLoadDataCallBack(new e(this, wVar, textView));
                wVar.bl(str3, valueOf);
            }
        }
    }
}
