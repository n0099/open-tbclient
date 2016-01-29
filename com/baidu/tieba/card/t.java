package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.BarFolderFirstDirActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.card.a.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ s aPP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.aPP = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        Object tag = view.getTag();
        if (tag instanceof k.a) {
            k.a aVar = (k.a) tag;
            if (aVar.type == 3) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_BAR_FOLDER_FIRST_DIR, new BarFolderFirstDirActivityConfig(this.aPP.getContext(), "")));
            } else if (!TextUtils.isEmpty(aVar.link)) {
                be wt = be.wt();
                TbPageContext<?> JK = this.aPP.JK();
                String[] strArr = new String[3];
                strArr[0] = aVar.link;
                wt.c(JK, strArr);
            }
            str = this.aPP.aPN;
            if (!TextUtils.isEmpty(str)) {
                str2 = this.aPP.aPN;
                TiebaStatic.log(new com.baidu.tbadk.core.util.au(str2).r("obj_locate", aVar.position));
            }
        }
    }
}
