package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.live.k.a;
/* loaded from: classes6.dex */
public class e extends c {
    private PlayBackItemView exf;
    private PlayBackItemView exg;

    public e(View view, int i) {
        super(view, i);
        this.exf = (PlayBackItemView) view.findViewById(a.g.playback_item_left);
        this.exg = (PlayBackItemView) view.findViewById(a.g.playback_item_right);
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void z(Object obj) {
        if (obj instanceof com.baidu.tieba.ala.person.a.a) {
            final com.baidu.tieba.ala.person.a.a aVar = (com.baidu.tieba.ala.person.a.a) obj;
            if (aVar.eue != null) {
                this.exf.setVisibility(0);
                this.exf.setData(aVar.eue.getMedia_pic(), aVar.eue.join_count, aVar.eue.start_time, aVar.eue.getLiveTitle());
            } else {
                this.exf.setVisibility(4);
            }
            if (aVar.euf != null) {
                this.exg.setVisibility(0);
                this.exg.setData(aVar.euf.getMedia_pic(), aVar.euf.join_count, aVar.euf.start_time, aVar.euf.getLiveTitle());
            } else {
                this.exg.setVisibility(4);
            }
            if (this.exf != null) {
                this.exf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.euc != null) {
                            e.this.euc.a(aVar.eue, view);
                        }
                    }
                });
            }
            if (this.exg != null) {
                this.exg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.euc != null) {
                            e.this.euc.a(aVar.euf, view);
                        }
                    }
                });
            }
        }
    }
}
