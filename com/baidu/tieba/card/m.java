package com.baidu.tieba.card;

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
import com.baidu.tieba.card.a.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ l aNM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.aNM = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        Object tag = view.getTag();
        if (tag instanceof h.a) {
            h.a aVar = (h.a) tag;
            if (aVar.type == 3) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_BAR_FOLDER_FIRST_DIR, new BarFolderFirstDirActivityConfig(this.aNM.getContext(), "")));
            } else if (!TextUtils.isEmpty(aVar.link)) {
                bf vn = bf.vn();
                TbPageContext<?> Ie = this.aNM.Ie();
                String[] strArr = new String[3];
                strArr[0] = aVar.link;
                vn.b(Ie, strArr);
            }
            str = this.aNM.aNK;
            if (!TextUtils.isEmpty(str)) {
                str2 = this.aNM.aNK;
                TiebaStatic.log(new av(str2).r("obj_locate", aVar.position));
            }
        }
    }
}
