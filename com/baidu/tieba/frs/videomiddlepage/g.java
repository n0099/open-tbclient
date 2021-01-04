package com.baidu.tieba.frs.videomiddlepage;

import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes2.dex */
public interface g {

    /* loaded from: classes2.dex */
    public interface a {
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(a aVar);

        void d(List<BaseCardInfo> list, boolean z, boolean z2);

        void hideLoadingView();

        void onLoadFail();

        void showMsg(String str);
    }
}
