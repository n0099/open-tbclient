package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class e extends c {
    private PlayBackItemView gWw;
    private PlayBackItemView gWx;

    public e(View view, int i) {
        super(view, i);
        this.gWw = (PlayBackItemView) view.findViewById(a.g.playback_item_left);
        this.gWx = (PlayBackItemView) view.findViewById(a.g.playback_item_right);
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void G(Object obj) {
        if (obj instanceof com.baidu.tieba.ala.person.a.a) {
            final com.baidu.tieba.ala.person.a.a aVar = (com.baidu.tieba.ala.person.a.a) obj;
            if (aVar.gTr != null) {
                this.gWw.setVisibility(0);
                this.gWw.setData(aVar.gTr.getMedia_pic(), aVar.gTr.join_count, aVar.gTr.start_time, aVar.gTr.getLiveTitle());
            } else {
                this.gWw.setVisibility(4);
            }
            if (aVar.gTs != null) {
                this.gWx.setVisibility(0);
                this.gWx.setData(aVar.gTs.getMedia_pic(), aVar.gTs.join_count, aVar.gTs.start_time, aVar.gTs.getLiveTitle());
            } else {
                this.gWx.setVisibility(4);
            }
            if (this.gWw != null) {
                this.gWw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.gTp != null) {
                            e.this.gTp.a(aVar.gTr, view);
                        }
                    }
                });
            }
            if (this.gWx != null) {
                this.gWx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.gTp != null) {
                            e.this.gTp.a(aVar.gTs, view);
                        }
                    }
                });
            }
        }
    }
}
