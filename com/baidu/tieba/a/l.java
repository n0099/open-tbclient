package com.baidu.tieba.a;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.BarFolderFirstDirActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.a.a.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ k aMl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.aMl = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        Object tag = view.getTag();
        if (tag instanceof f.a) {
            f.a aVar = (f.a) tag;
            if (aVar.type == 3) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_BAR_FOLDER_FIRST_DIR, new BarFolderFirstDirActivityConfig(this.aMl.getContext(), "")));
            } else if (!TextUtils.isEmpty(aVar.link)) {
                bf vD = bf.vD();
                TbPageContext<?> Io = this.aMl.Io();
                String[] strArr = new String[3];
                strArr[0] = aVar.link;
                vD.b(Io, strArr);
            }
            str = this.aMl.aMj;
            if (!TextUtils.isEmpty(str)) {
                str2 = this.aMl.aMj;
                TiebaStatic.log(new av(str2).r("obj_locate", aVar.position));
            }
        }
    }
}
