package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class e extends c {
    private PlayBackItemView gnK;
    private PlayBackItemView gnL;

    public e(View view, int i) {
        super(view, i);
        this.gnK = (PlayBackItemView) view.findViewById(a.g.playback_item_left);
        this.gnL = (PlayBackItemView) view.findViewById(a.g.playback_item_right);
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void D(Object obj) {
        if (obj instanceof com.baidu.tieba.ala.person.a.a) {
            final com.baidu.tieba.ala.person.a.a aVar = (com.baidu.tieba.ala.person.a.a) obj;
            if (aVar.gkG != null) {
                this.gnK.setVisibility(0);
                this.gnK.setData(aVar.gkG.getMedia_pic(), aVar.gkG.join_count, aVar.gkG.start_time, aVar.gkG.getLiveTitle());
            } else {
                this.gnK.setVisibility(4);
            }
            if (aVar.gkH != null) {
                this.gnL.setVisibility(0);
                this.gnL.setData(aVar.gkH.getMedia_pic(), aVar.gkH.join_count, aVar.gkH.start_time, aVar.gkH.getLiveTitle());
            } else {
                this.gnL.setVisibility(4);
            }
            if (this.gnK != null) {
                this.gnK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.gkE != null) {
                            e.this.gkE.a(aVar.gkG, view);
                        }
                    }
                });
            }
            if (this.gnL != null) {
                this.gnL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.gkE != null) {
                            e.this.gkE.a(aVar.gkH, view);
                        }
                    }
                });
            }
        }
    }
}
