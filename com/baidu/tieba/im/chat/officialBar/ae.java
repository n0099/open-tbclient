package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.OfficialHistoryImageActivityConfig;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements View.OnClickListener {
    final /* synthetic */ ad this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar) {
        this.this$0 = adVar;
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
        aq aqVar = (aq) list2.get(intValue);
        String s = com.baidu.tieba.im.util.i.s("[" + aqVar.content + "]", true);
        if (s != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialHistoryImageActivityConfig(this.this$0.mContext, s, String.valueOf(aqVar.id))));
        }
    }
}
