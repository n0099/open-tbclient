package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class e extends c {
    private PlayBackItemView hxo;
    private PlayBackItemView hxp;

    public e(View view, int i) {
        super(view, i);
        this.hxo = (PlayBackItemView) view.findViewById(a.g.playback_item_left);
        this.hxp = (PlayBackItemView) view.findViewById(a.g.playback_item_right);
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void H(Object obj) {
        if (obj instanceof com.baidu.tieba.ala.person.a.a) {
            final com.baidu.tieba.ala.person.a.a aVar = (com.baidu.tieba.ala.person.a.a) obj;
            if (aVar.hul != null) {
                this.hxo.setVisibility(0);
                this.hxo.setData(aVar.hul.getMedia_pic(), aVar.hul.join_count, aVar.hul.start_time, aVar.hul.getLiveTitle());
            } else {
                this.hxo.setVisibility(4);
            }
            if (aVar.hum != null) {
                this.hxp.setVisibility(0);
                this.hxp.setData(aVar.hum.getMedia_pic(), aVar.hum.join_count, aVar.hum.start_time, aVar.hum.getLiveTitle());
            } else {
                this.hxp.setVisibility(4);
            }
            if (this.hxo != null) {
                this.hxo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.huj != null) {
                            e.this.huj.a(aVar.hul, view);
                        }
                    }
                });
            }
            if (this.hxp != null) {
                this.hxp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.huj != null) {
                            e.this.huj.a(aVar.hum, view);
                        }
                    }
                });
            }
        }
    }
}
