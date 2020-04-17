package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class e extends c {
    private PlayBackItemView fYL;
    private PlayBackItemView fYM;

    public e(View view, int i) {
        super(view, i);
        this.fYL = (PlayBackItemView) view.findViewById(a.g.playback_item_left);
        this.fYM = (PlayBackItemView) view.findViewById(a.g.playback_item_right);
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void A(Object obj) {
        if (obj instanceof com.baidu.tieba.ala.person.a.a) {
            final com.baidu.tieba.ala.person.a.a aVar = (com.baidu.tieba.ala.person.a.a) obj;
            if (aVar.fVG != null) {
                this.fYL.setVisibility(0);
                this.fYL.setData(aVar.fVG.getMedia_pic(), aVar.fVG.join_count, aVar.fVG.start_time, aVar.fVG.getLiveTitle());
            } else {
                this.fYL.setVisibility(4);
            }
            if (aVar.fVH != null) {
                this.fYM.setVisibility(0);
                this.fYM.setData(aVar.fVH.getMedia_pic(), aVar.fVH.join_count, aVar.fVH.start_time, aVar.fVH.getLiveTitle());
            } else {
                this.fYM.setVisibility(4);
            }
            if (this.fYL != null) {
                this.fYL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.fVE != null) {
                            e.this.fVE.a(aVar.fVG, view);
                        }
                    }
                });
            }
            if (this.fYM != null) {
                this.fYM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.fVE != null) {
                            e.this.fVE.a(aVar.fVH, view);
                        }
                    }
                });
            }
        }
    }
}
