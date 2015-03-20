package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.OfficialHistoryImageActivityConfig;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    final /* synthetic */ ae this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar) {
        this.this$0 = aeVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        List list;
        List list2;
        int intValue = ((Integer) view.getTag()).intValue();
        if (intValue < 0) {
            return;
        }
        list = this.this$0.mList;
        if (intValue >= list.size()) {
            return;
        }
        list2 = this.this$0.mList;
        au auVar = (au) list2.get(intValue);
        String t = com.baidu.tieba.im.util.i.t("[" + auVar.content + "]", true);
        if (t != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialHistoryImageActivityConfig(this.this$0.mContext, t, String.valueOf(auVar.id))));
        }
    }
}
