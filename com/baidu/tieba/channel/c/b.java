package com.baidu.tieba.channel.c;

import android.view.View;
import android.widget.Toast;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tieba.channel.data.h;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b {
    public static void a(BaseActivity baseActivity, final h hVar, final int i, final com.baidu.tieba.channel.view.b bVar) {
        String string;
        if (hVar != null) {
            if (hVar.zO()) {
                string = baseActivity.getResources().getString(d.j.channel_cancle_set_top);
            } else {
                string = baseActivity.getResources().getString(d.j.channel_set_top_and_cancle_another);
            }
            String[] strArr = {string, baseActivity.getResources().getString(d.j.channel_remove)};
            com.baidu.tbadk.core.dialog.b bVar2 = new com.baidu.tbadk.core.dialog.b(baseActivity.getPageContext().getPageActivity());
            bVar2.a(strArr, new b.InterfaceC0097b() { // from class: com.baidu.tieba.channel.c.b.1
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
                public void a(com.baidu.tbadk.core.dialog.b bVar3, int i2, View view) {
                    switch (i2) {
                        case 0:
                            if (com.baidu.tieba.channel.view.b.this != null) {
                                com.baidu.tieba.channel.view.b.this.a(hVar.zO() ? 13 : 14, view, hVar, i);
                                break;
                            }
                            break;
                        case 1:
                            if (com.baidu.tieba.channel.view.b.this != null) {
                                com.baidu.tieba.channel.view.b.this.a(15, view, hVar, i);
                                break;
                            }
                            break;
                    }
                    bVar3.dismiss();
                }
            });
            bVar2.d(baseActivity.getPageContext());
            bVar2.AX();
        }
    }

    public static void a(final BaseActivity baseActivity, boolean z, final boolean z2, final com.baidu.tieba.channel.view.b bVar) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(baseActivity.getPageContext().getPageActivity());
        if (z) {
            aVar.fb(d.j.channel_close_push_message);
            aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.channel.c.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (com.baidu.tieba.channel.view.b.this != null) {
                        com.baidu.tieba.channel.view.b.this.a(18, null, null, -1);
                    }
                    aVar2.dismiss();
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.channel.c.b.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
        } else {
            aVar.fb(d.j.channel_open_push_message);
            aVar.a(d.j.need_channel_push, new a.b() { // from class: com.baidu.tieba.channel.c.b.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (com.baidu.tieba.channel.view.b.this != null) {
                        com.baidu.tieba.channel.view.b.this.a(18, null, Boolean.valueOf(z2), -1);
                    }
                    aVar2.dismiss();
                }
            });
            aVar.b(d.j.not_need_channel_push, new a.b() { // from class: com.baidu.tieba.channel.c.b.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (z2) {
                        Toast.makeText(baseActivity.getPageContext().getPageActivity(), baseActivity.getPageContext().getResources().getString(d.j.channel_no_push), 1).show();
                    }
                }
            });
        }
        aVar.b(baseActivity.getPageContext());
        aVar.AU();
    }
}
