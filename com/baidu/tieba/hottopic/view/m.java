package com.baidu.tieba.hottopic.view;

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
public class m implements View.OnClickListener {
    final /* synthetic */ j bNo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.bNo = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        TbPageContext tbPageContext;
        String str2;
        if (bi.ah(this.bNo.getContext())) {
            String str3 = (String) view.getTag(t.g.tag_forum_name);
            String valueOf = String.valueOf(view.getTag(t.g.tag_forum_id));
            TextView textView = (TextView) view;
            if (aw.aQ(str3)) {
                str = this.bNo.aEJ;
                if (!TextUtils.isEmpty(str)) {
                    str2 = this.bNo.aEJ;
                    TiebaStatic.log(new au(str2).r("obj_type", 1).aa(ImageViewerConfig.FORUM_ID, valueOf));
                }
                tbPageContext = this.bNo.mTbPageContext;
                w wVar = new w(tbPageContext);
                wVar.setLoadDataCallBack(new n(this, wVar, textView));
                wVar.bl(str3, valueOf);
            }
        }
    }
}
