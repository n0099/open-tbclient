package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class e extends c {
    private PlayBackItemView gGi;
    private PlayBackItemView gGj;

    public e(View view, int i) {
        super(view, i);
        this.gGi = (PlayBackItemView) view.findViewById(a.g.playback_item_left);
        this.gGj = (PlayBackItemView) view.findViewById(a.g.playback_item_right);
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void D(Object obj) {
        if (obj instanceof com.baidu.tieba.ala.person.a.a) {
            final com.baidu.tieba.ala.person.a.a aVar = (com.baidu.tieba.ala.person.a.a) obj;
            if (aVar.gDg != null) {
                this.gGi.setVisibility(0);
                this.gGi.setData(aVar.gDg.getMedia_pic(), aVar.gDg.join_count, aVar.gDg.start_time, aVar.gDg.getLiveTitle());
            } else {
                this.gGi.setVisibility(4);
            }
            if (aVar.gDh != null) {
                this.gGj.setVisibility(0);
                this.gGj.setData(aVar.gDh.getMedia_pic(), aVar.gDh.join_count, aVar.gDh.start_time, aVar.gDh.getLiveTitle());
            } else {
                this.gGj.setVisibility(4);
            }
            if (this.gGi != null) {
                this.gGi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.gDe != null) {
                            e.this.gDe.a(aVar.gDg, view);
                        }
                    }
                });
            }
            if (this.gGj != null) {
                this.gGj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.gDe != null) {
                            e.this.gDe.a(aVar.gDh, view);
                        }
                    }
                });
            }
        }
    }
}
