package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class e extends c {
    private PlayBackItemView hlt;
    private PlayBackItemView hlu;

    public e(View view, int i) {
        super(view, i);
        this.hlt = (PlayBackItemView) view.findViewById(a.g.playback_item_left);
        this.hlu = (PlayBackItemView) view.findViewById(a.g.playback_item_right);
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void H(Object obj) {
        if (obj instanceof com.baidu.tieba.ala.person.a.a) {
            final com.baidu.tieba.ala.person.a.a aVar = (com.baidu.tieba.ala.person.a.a) obj;
            if (aVar.hip != null) {
                this.hlt.setVisibility(0);
                this.hlt.setData(aVar.hip.getMedia_pic(), aVar.hip.join_count, aVar.hip.start_time, aVar.hip.getLiveTitle());
            } else {
                this.hlt.setVisibility(4);
            }
            if (aVar.hiq != null) {
                this.hlu.setVisibility(0);
                this.hlu.setData(aVar.hiq.getMedia_pic(), aVar.hiq.join_count, aVar.hiq.start_time, aVar.hiq.getLiveTitle());
            } else {
                this.hlu.setVisibility(4);
            }
            if (this.hlt != null) {
                this.hlt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.hin != null) {
                            e.this.hin.a(aVar.hip, view);
                        }
                    }
                });
            }
            if (this.hlu != null) {
                this.hlu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.hin != null) {
                            e.this.hin.a(aVar.hiq, view);
                        }
                    }
                });
            }
        }
    }
}
