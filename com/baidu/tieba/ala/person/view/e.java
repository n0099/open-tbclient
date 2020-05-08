package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class e extends c {
    private PlayBackItemView fYQ;
    private PlayBackItemView fYR;

    public e(View view, int i) {
        super(view, i);
        this.fYQ = (PlayBackItemView) view.findViewById(a.g.playback_item_left);
        this.fYR = (PlayBackItemView) view.findViewById(a.g.playback_item_right);
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void B(Object obj) {
        if (obj instanceof com.baidu.tieba.ala.person.a.a) {
            final com.baidu.tieba.ala.person.a.a aVar = (com.baidu.tieba.ala.person.a.a) obj;
            if (aVar.fVL != null) {
                this.fYQ.setVisibility(0);
                this.fYQ.setData(aVar.fVL.getMedia_pic(), aVar.fVL.join_count, aVar.fVL.start_time, aVar.fVL.getLiveTitle());
            } else {
                this.fYQ.setVisibility(4);
            }
            if (aVar.fVM != null) {
                this.fYR.setVisibility(0);
                this.fYR.setData(aVar.fVM.getMedia_pic(), aVar.fVM.join_count, aVar.fVM.start_time, aVar.fVM.getLiveTitle());
            } else {
                this.fYR.setVisibility(4);
            }
            if (this.fYQ != null) {
                this.fYQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.fVJ != null) {
                            e.this.fVJ.a(aVar.fVL, view);
                        }
                    }
                });
            }
            if (this.fYR != null) {
                this.fYR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.fVJ != null) {
                            e.this.fVJ.a(aVar.fVM, view);
                        }
                    }
                });
            }
        }
    }
}
