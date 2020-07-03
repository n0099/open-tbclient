package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.live.sdk.a;
/* loaded from: classes3.dex */
public class e extends c {
    private PlayBackItemView gAL;
    private PlayBackItemView gAM;

    public e(View view, int i) {
        super(view, i);
        this.gAL = (PlayBackItemView) view.findViewById(a.g.playback_item_left);
        this.gAM = (PlayBackItemView) view.findViewById(a.g.playback_item_right);
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void D(Object obj) {
        if (obj instanceof com.baidu.tieba.ala.person.a.a) {
            final com.baidu.tieba.ala.person.a.a aVar = (com.baidu.tieba.ala.person.a.a) obj;
            if (aVar.gxF != null) {
                this.gAL.setVisibility(0);
                this.gAL.setData(aVar.gxF.getMedia_pic(), aVar.gxF.join_count, aVar.gxF.start_time, aVar.gxF.getLiveTitle());
            } else {
                this.gAL.setVisibility(4);
            }
            if (aVar.gxG != null) {
                this.gAM.setVisibility(0);
                this.gAM.setData(aVar.gxG.getMedia_pic(), aVar.gxG.join_count, aVar.gxG.start_time, aVar.gxG.getLiveTitle());
            } else {
                this.gAM.setVisibility(4);
            }
            if (this.gAL != null) {
                this.gAL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.gxD != null) {
                            e.this.gxD.a(aVar.gxF, view);
                        }
                    }
                });
            }
            if (this.gAM != null) {
                this.gAM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.gxD != null) {
                            e.this.gxD.a(aVar.gxG, view);
                        }
                    }
                });
            }
        }
    }
}
