package com.baidu.tbadk.widget.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a aGk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.aGk = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        TbPageContext tbPageContext;
        String str2;
        if (bl.ad(this.aGk.getContext())) {
            String str3 = (String) view.getTag(t.g.tag_forum_name);
            String valueOf = String.valueOf(view.getTag(t.g.tag_forum_id));
            TextView textView = (TextView) view;
            if (ay.aS(str3)) {
                str = this.aGk.aGe;
                if (!TextUtils.isEmpty(str)) {
                    str2 = this.aGk.aGe;
                    TiebaStatic.log(new aw(str2).r("obj_type", 1).ac("fid", valueOf));
                }
                tbPageContext = this.aGk.mTbPageContext;
                w wVar = new w(tbPageContext);
                wVar.setLoadDataCallBack(new e(this, wVar, textView));
                wVar.bC(str3, valueOf);
            }
        }
    }
}
