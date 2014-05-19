package com.baidu.tieba.im.live.livelist;

import android.view.View;
import com.baidu.tbadk.core.data.LiveCardData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements s {
    final /* synthetic */ FrsLiveListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsLiveListActivity frsLiveListActivity) {
        this.a = frsLiveListActivity;
    }

    @Override // com.baidu.tieba.im.live.livelist.s
    public void a(View view) {
        Object tag = view.getTag();
        if (tag instanceof LiveCardData) {
            LiveCardData liveCardData = (LiveCardData) tag;
            int flag = liveCardData.getFlag();
            ArrayList arrayList = new ArrayList();
            switch (flag) {
                case 0:
                    arrayList.add(this.a.getString(com.baidu.tieba.u.live_frs_list__operate_top));
                    arrayList.add(this.a.getString(com.baidu.tieba.u.live_frs_list__operate_hide));
                    break;
                case 1:
                    arrayList.add(this.a.getString(com.baidu.tieba.u.live_frs_list__operate_cancel_top));
                    break;
                case 2:
                    arrayList.add(this.a.getString(com.baidu.tieba.u.live_frs_list__operate_cancel_hide));
                    break;
            }
            com.baidu.tieba.im.f.b.a(this.a, (CharSequence[]) arrayList.toArray(new CharSequence[0]), new n(this, flag, liveCardData));
        }
    }
}
