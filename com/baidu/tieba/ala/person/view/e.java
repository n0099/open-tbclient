package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.live.sdk.a;
/* loaded from: classes7.dex */
public class e extends c {
    private PlayBackItemView gSK;
    private PlayBackItemView gSL;

    public e(View view, int i) {
        super(view, i);
        this.gSK = (PlayBackItemView) view.findViewById(a.g.playback_item_left);
        this.gSL = (PlayBackItemView) view.findViewById(a.g.playback_item_right);
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void F(Object obj) {
        if (obj instanceof com.baidu.tieba.ala.person.a.a) {
            final com.baidu.tieba.ala.person.a.a aVar = (com.baidu.tieba.ala.person.a.a) obj;
            if (aVar.gPF != null) {
                this.gSK.setVisibility(0);
                this.gSK.setData(aVar.gPF.getMedia_pic(), aVar.gPF.join_count, aVar.gPF.start_time, aVar.gPF.getLiveTitle());
            } else {
                this.gSK.setVisibility(4);
            }
            if (aVar.gPG != null) {
                this.gSL.setVisibility(0);
                this.gSL.setData(aVar.gPG.getMedia_pic(), aVar.gPG.join_count, aVar.gPG.start_time, aVar.gPG.getLiveTitle());
            } else {
                this.gSL.setVisibility(4);
            }
            if (this.gSK != null) {
                this.gSK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.gPD != null) {
                            e.this.gPD.a(aVar.gPF, view);
                        }
                    }
                });
            }
            if (this.gSL != null) {
                this.gSL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.gPD != null) {
                            e.this.gPD.a(aVar.gPG, view);
                        }
                    }
                });
            }
        }
    }
}
