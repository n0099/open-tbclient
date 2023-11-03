package com.baidu.tieba;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
/* loaded from: classes5.dex */
public interface fn8<ChildItemData extends BaseItem<? extends TbBaseMsg>> {
    void a(@NonNull View view2, @NonNull ChildItemData childitemdata, int i);
}
