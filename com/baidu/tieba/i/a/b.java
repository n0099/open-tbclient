package com.baidu.tieba.i.a;

import com.baidu.adp.lib.util.f;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b extends a<com.baidu.tieba.play.b.d> {
    private boolean fwt;

    public b(String str) {
        super(str);
        this.fwt = f.lk();
    }

    @Override // com.baidu.tieba.i.a.c
    public String getKey() {
        return "avformat_open_input_json";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.i.a.a
    public void a(com.baidu.tieba.play.b.d dVar) {
        super.a((b) dVar);
        if (aXk() && this.fwt) {
            aXl();
        }
    }

    private boolean aXk() {
        return this.list != null && this.list.size() > 30;
    }

    @Override // com.baidu.tieba.i.a.c
    public void aXl() {
        if (this.list != null && this.list.size() != 0) {
            cI(new ArrayList(this.list));
            this.list.clear();
        }
    }
}
