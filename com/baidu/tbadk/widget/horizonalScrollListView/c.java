package com.baidu.tbadk.widget.horizonalScrollListView;

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
public class c implements View.OnClickListener {
    final /* synthetic */ HorizonalScrollListView aCr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(HorizonalScrollListView horizonalScrollListView) {
        this.aCr = horizonalScrollListView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        TbPageContext tbPageContext;
        String str2;
        if (bj.ah(this.aCr.getContext())) {
            String str3 = (String) view.getTag(n.f.tag_forum_name);
            String valueOf = String.valueOf(view.getTag(n.f.tag_forum_id));
            TextView textView = (TextView) view;
            if (ax.aR(str3)) {
                str = this.aCr.aCl;
                if (!TextUtils.isEmpty(str)) {
                    str2 = this.aCr.aCl;
                    TiebaStatic.log(new av(str2).r("obj_type", 1).ab(ImageViewerConfig.FORUM_ID, valueOf));
                }
                tbPageContext = this.aCr.mTbPageContext;
                x xVar = new x(tbPageContext);
                xVar.setLoadDataCallBack(new d(this, xVar, textView));
                xVar.bg(str3, valueOf);
            }
        }
    }
}
