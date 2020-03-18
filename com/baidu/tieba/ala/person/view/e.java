package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class e extends c {
    private PlayBackItemView fun;
    private PlayBackItemView fuo;

    public e(View view, int i) {
        super(view, i);
        this.fun = (PlayBackItemView) view.findViewById(a.g.playback_item_left);
        this.fuo = (PlayBackItemView) view.findViewById(a.g.playback_item_right);
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void A(Object obj) {
        if (obj instanceof com.baidu.tieba.ala.person.a.a) {
            final com.baidu.tieba.ala.person.a.a aVar = (com.baidu.tieba.ala.person.a.a) obj;
            if (aVar.frk != null) {
                this.fun.setVisibility(0);
                this.fun.setData(aVar.frk.getMedia_pic(), aVar.frk.join_count, aVar.frk.start_time, aVar.frk.getLiveTitle());
            } else {
                this.fun.setVisibility(4);
            }
            if (aVar.frl != null) {
                this.fuo.setVisibility(0);
                this.fuo.setData(aVar.frl.getMedia_pic(), aVar.frl.join_count, aVar.frl.start_time, aVar.frl.getLiveTitle());
            } else {
                this.fuo.setVisibility(4);
            }
            if (this.fun != null) {
                this.fun.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.fri != null) {
                            e.this.fri.a(aVar.frk, view);
                        }
                    }
                });
            }
            if (this.fuo != null) {
                this.fuo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.fri != null) {
                            e.this.fri.a(aVar.frl, view);
                        }
                    }
                });
            }
        }
    }
}
