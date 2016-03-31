package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.BarFolderFirstDirActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.a.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ u aSK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.aSK = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        Object tag = view.getTag();
        if (tag instanceof l.a) {
            l.a aVar = (l.a) tag;
            if (aVar.type == 3) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_BAR_FOLDER_FIRST_DIR, new BarFolderFirstDirActivityConfig(this.aSK.getContext(), "")));
            } else if (!TextUtils.isEmpty(aVar.link)) {
                com.baidu.tbadk.core.util.bg wM = com.baidu.tbadk.core.util.bg.wM();
                TbPageContext<?> Lb = this.aSK.Lb();
                String[] strArr = new String[3];
                strArr[0] = aVar.link;
                wM.c(Lb, strArr);
            }
            str = this.aSK.aSI;
            if (!TextUtils.isEmpty(str)) {
                str2 = this.aSK.aSI;
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw(str2).r("obj_locate", aVar.position));
            }
        }
    }
}
