package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.live.k.a;
/* loaded from: classes6.dex */
public class e extends c {
    private PlayBackItemView ewo;
    private PlayBackItemView ewp;

    public e(View view, int i) {
        super(view, i);
        this.ewo = (PlayBackItemView) view.findViewById(a.g.playback_item_left);
        this.ewp = (PlayBackItemView) view.findViewById(a.g.playback_item_right);
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void z(Object obj) {
        if (obj instanceof com.baidu.tieba.ala.person.a.a) {
            final com.baidu.tieba.ala.person.a.a aVar = (com.baidu.tieba.ala.person.a.a) obj;
            if (aVar.etn != null) {
                this.ewo.setVisibility(0);
                this.ewo.setData(aVar.etn.getMedia_pic(), aVar.etn.join_count, aVar.etn.start_time, aVar.etn.getLiveTitle());
            } else {
                this.ewo.setVisibility(4);
            }
            if (aVar.eto != null) {
                this.ewp.setVisibility(0);
                this.ewp.setData(aVar.eto.getMedia_pic(), aVar.eto.join_count, aVar.eto.start_time, aVar.eto.getLiveTitle());
            } else {
                this.ewp.setVisibility(4);
            }
            if (this.ewo != null) {
                this.ewo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.etl != null) {
                            e.this.etl.a(aVar.etn, view);
                        }
                    }
                });
            }
            if (this.ewp != null) {
                this.ewp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.etl != null) {
                            e.this.etl.a(aVar.eto, view);
                        }
                    }
                });
            }
        }
    }
}
