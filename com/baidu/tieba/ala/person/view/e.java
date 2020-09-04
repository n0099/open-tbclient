package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.live.sdk.a;
/* loaded from: classes7.dex */
public class e extends c {
    private PlayBackItemView gSO;
    private PlayBackItemView gSP;

    public e(View view, int i) {
        super(view, i);
        this.gSO = (PlayBackItemView) view.findViewById(a.g.playback_item_left);
        this.gSP = (PlayBackItemView) view.findViewById(a.g.playback_item_right);
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void F(Object obj) {
        if (obj instanceof com.baidu.tieba.ala.person.a.a) {
            final com.baidu.tieba.ala.person.a.a aVar = (com.baidu.tieba.ala.person.a.a) obj;
            if (aVar.gPJ != null) {
                this.gSO.setVisibility(0);
                this.gSO.setData(aVar.gPJ.getMedia_pic(), aVar.gPJ.join_count, aVar.gPJ.start_time, aVar.gPJ.getLiveTitle());
            } else {
                this.gSO.setVisibility(4);
            }
            if (aVar.gPK != null) {
                this.gSP.setVisibility(0);
                this.gSP.setData(aVar.gPK.getMedia_pic(), aVar.gPK.join_count, aVar.gPK.start_time, aVar.gPK.getLiveTitle());
            } else {
                this.gSP.setVisibility(4);
            }
            if (this.gSO != null) {
                this.gSO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.gPH != null) {
                            e.this.gPH.a(aVar.gPJ, view);
                        }
                    }
                });
            }
            if (this.gSP != null) {
                this.gSP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.gPH != null) {
                            e.this.gPH.a(aVar.gPK, view);
                        }
                    }
                });
            }
        }
    }
}
