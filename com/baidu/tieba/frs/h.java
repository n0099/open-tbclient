package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.frsgroup.FrsGroupActivity;
import com.baidu.tieba.pb.NewPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1284a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FrsActivity frsActivity) {
        this.f1284a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ba baVar;
        ba baVar2;
        boolean z;
        int i2;
        com.baidu.tieba.model.ak akVar;
        com.baidu.tieba.model.ak akVar2;
        com.baidu.tieba.model.ak akVar3;
        com.baidu.tieba.model.ak akVar4;
        com.baidu.tieba.model.ak akVar5;
        com.baidu.tieba.model.ak akVar6;
        if (i >= 0) {
            baVar = this.f1284a.o;
            long itemId = baVar.h().getItemId(i);
            if (itemId == -100) {
                akVar = this.f1284a.x;
                if (akVar != null) {
                    akVar2 = this.f1284a.x;
                    if (akVar2.a() != null) {
                        akVar3 = this.f1284a.x;
                        if (!com.baidu.adp.lib.h.e.b(akVar3.a().getId())) {
                            akVar4 = this.f1284a.x;
                            if (akVar4.i() != null) {
                                if (TiebaApplication.g().s()) {
                                    StatService.onEvent(this.f1284a, "im_e_glist_from_frs", "click", 1);
                                }
                                FrsActivity frsActivity = this.f1284a;
                                akVar5 = this.f1284a.x;
                                String id = akVar5.a().getId();
                                akVar6 = this.f1284a.x;
                                FrsGroupActivity.a(frsActivity, id, akVar6.i().b() != 1);
                            }
                        }
                    }
                }
            } else if (itemId == -1) {
                i2 = this.f1284a.j;
                if (i2 > 1) {
                    FrsActivity.i(this.f1284a);
                    this.f1284a.d = 2;
                    this.f1284a.D();
                }
            } else if (itemId != -2) {
                baVar2 = this.f1284a.o;
                com.baidu.tieba.data.bf bfVar = (com.baidu.tieba.data.bf) baVar2.h().getItem(i);
                if (bfVar != null) {
                    com.baidu.tieba.util.at az = TiebaApplication.g().az();
                    if (az != null && !az.b(bfVar.a())) {
                        az.a(bfVar.a());
                    }
                    String i3 = bfVar.i();
                    if (i3 == null || i3.equals("")) {
                        z = false;
                    } else {
                        new Thread(new i(this, i3)).start();
                        z = true;
                    }
                    NewPbActivity.a(this.f1284a, bfVar, null, 18003, true, false, z);
                }
            } else {
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.f1284a, "frs_nextpage", "frsclick", 1);
                }
                FrsActivity.x(this.f1284a);
                this.f1284a.d = 1;
                this.f1284a.D();
            }
        }
    }
}
