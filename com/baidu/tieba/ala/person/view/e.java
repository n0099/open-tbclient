package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.live.r.a;
/* loaded from: classes2.dex */
public class e extends c {
    private PlayBackItemView fqX;
    private PlayBackItemView fqY;

    public e(View view, int i) {
        super(view, i);
        this.fqX = (PlayBackItemView) view.findViewById(a.g.playback_item_left);
        this.fqY = (PlayBackItemView) view.findViewById(a.g.playback_item_right);
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void A(Object obj) {
        if (obj instanceof com.baidu.tieba.ala.person.a.a) {
            final com.baidu.tieba.ala.person.a.a aVar = (com.baidu.tieba.ala.person.a.a) obj;
            if (aVar.fnT != null) {
                this.fqX.setVisibility(0);
                this.fqX.setData(aVar.fnT.getMedia_pic(), aVar.fnT.join_count, aVar.fnT.start_time, aVar.fnT.getLiveTitle());
            } else {
                this.fqX.setVisibility(4);
            }
            if (aVar.fnU != null) {
                this.fqY.setVisibility(0);
                this.fqY.setData(aVar.fnU.getMedia_pic(), aVar.fnU.join_count, aVar.fnU.start_time, aVar.fnU.getLiveTitle());
            } else {
                this.fqY.setVisibility(4);
            }
            if (this.fqX != null) {
                this.fqX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.fnR != null) {
                            e.this.fnR.a(aVar.fnT, view);
                        }
                    }
                });
            }
            if (this.fqY != null) {
                this.fqY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.fnR != null) {
                            e.this.fnR.a(aVar.fnU, view);
                        }
                    }
                });
            }
        }
    }
}
