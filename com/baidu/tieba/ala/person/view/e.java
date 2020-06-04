package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class e extends c {
    private PlayBackItemView gnV;
    private PlayBackItemView gnW;

    public e(View view, int i) {
        super(view, i);
        this.gnV = (PlayBackItemView) view.findViewById(a.g.playback_item_left);
        this.gnW = (PlayBackItemView) view.findViewById(a.g.playback_item_right);
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void D(Object obj) {
        if (obj instanceof com.baidu.tieba.ala.person.a.a) {
            final com.baidu.tieba.ala.person.a.a aVar = (com.baidu.tieba.ala.person.a.a) obj;
            if (aVar.gkR != null) {
                this.gnV.setVisibility(0);
                this.gnV.setData(aVar.gkR.getMedia_pic(), aVar.gkR.join_count, aVar.gkR.start_time, aVar.gkR.getLiveTitle());
            } else {
                this.gnV.setVisibility(4);
            }
            if (aVar.gkS != null) {
                this.gnW.setVisibility(0);
                this.gnW.setData(aVar.gkS.getMedia_pic(), aVar.gkS.join_count, aVar.gkS.start_time, aVar.gkS.getLiveTitle());
            } else {
                this.gnW.setVisibility(4);
            }
            if (this.gnV != null) {
                this.gnV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.gkP != null) {
                            e.this.gkP.a(aVar.gkR, view);
                        }
                    }
                });
            }
            if (this.gnW != null) {
                this.gnW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.gkP != null) {
                            e.this.gkP.a(aVar.gkS, view);
                        }
                    }
                });
            }
        }
    }
}
