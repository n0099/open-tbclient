package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class f extends d {
    private PlayBackItemView iaJ;
    private PlayBackItemView iaK;

    public f(View view, int i) {
        super(view, i);
        this.iaJ = (PlayBackItemView) view.findViewById(a.f.playback_item_left);
        this.iaK = (PlayBackItemView) view.findViewById(a.f.playback_item_right);
    }

    @Override // com.baidu.tieba.ala.person.view.d
    public void E(Object obj) {
        if (obj instanceof com.baidu.tieba.ala.person.a.a) {
            final com.baidu.tieba.ala.person.a.a aVar = (com.baidu.tieba.ala.person.a.a) obj;
            if (aVar.hXt != null) {
                this.iaJ.setVisibility(0);
                this.iaJ.setData(aVar.hXt.getMedia_pic(), aVar.hXt.join_count, aVar.hXt.start_time, aVar.hXt.getLiveTitle());
            } else {
                this.iaJ.setVisibility(4);
            }
            if (aVar.hXu != null) {
                this.iaK.setVisibility(0);
                this.iaK.setData(aVar.hXu.getMedia_pic(), aVar.hXu.join_count, aVar.hXu.start_time, aVar.hXu.getLiveTitle());
            } else {
                this.iaK.setVisibility(4);
            }
            if (this.iaJ != null) {
                this.iaJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.f.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (f.this.hXr != null) {
                            f.this.hXr.a(aVar.hXt, view);
                        }
                    }
                });
            }
            if (this.iaK != null) {
                this.iaK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.f.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (f.this.hXr != null) {
                            f.this.hXr.a(aVar.hXu, view);
                        }
                    }
                });
            }
        }
    }
}
