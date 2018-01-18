package com.baidu.tieba.i.a;

import com.baidu.adp.lib.util.f;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b extends a<com.baidu.tieba.play.c.d> {
    private boolean fsx;

    public b(String str) {
        super(str);
        this.fsx = f.lk();
    }

    @Override // com.baidu.tieba.i.a.c
    public String getKey() {
        return "avformat_open_input_json";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.i.a.a
    public void a(com.baidu.tieba.play.c.d dVar) {
        super.a((b) dVar);
        if (aVw() && this.fsx) {
            aVx();
        }
    }

    private boolean aVw() {
        return this.list != null && this.list.size() > 30;
    }

    @Override // com.baidu.tieba.i.a.c
    public void aVx() {
        if (this.list != null && this.list.size() != 0) {
            cC(new ArrayList(this.list));
            this.list.clear();
        }
    }
}
