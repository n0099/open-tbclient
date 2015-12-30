package com.baidu.tbadk.widget.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bj;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a aDZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.aDZ = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        TbPageContext tbPageContext;
        String str2;
        if (bj.ah(this.aDZ.getContext())) {
            String str3 = (String) view.getTag(n.g.tag_forum_name);
            String valueOf = String.valueOf(view.getTag(n.g.tag_forum_id));
            TextView textView = (TextView) view;
            if (ax.aR(str3)) {
                str = this.aDZ.aDT;
                if (!TextUtils.isEmpty(str)) {
                    str2 = this.aDZ.aDT;
                    TiebaStatic.log(new av(str2).r("obj_type", 1).aa(ImageViewerConfig.FORUM_ID, valueOf));
                }
                tbPageContext = this.aDZ.mTbPageContext;
                x xVar = new x(tbPageContext);
                xVar.setLoadDataCallBack(new e(this, xVar, textView));
                xVar.bc(str3, valueOf);
            }
        }
    }
}
