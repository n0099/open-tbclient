package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class e extends c {
    private PlayBackItemView hCS;
    private PlayBackItemView hCT;

    public e(View view, int i) {
        super(view, i);
        this.hCS = (PlayBackItemView) view.findViewById(a.f.playback_item_left);
        this.hCT = (PlayBackItemView) view.findViewById(a.f.playback_item_right);
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void H(Object obj) {
        if (obj instanceof com.baidu.tieba.ala.person.a.a) {
            final com.baidu.tieba.ala.person.a.a aVar = (com.baidu.tieba.ala.person.a.a) obj;
            if (aVar.hzP != null) {
                this.hCS.setVisibility(0);
                this.hCS.setData(aVar.hzP.getMedia_pic(), aVar.hzP.join_count, aVar.hzP.start_time, aVar.hzP.getLiveTitle());
            } else {
                this.hCS.setVisibility(4);
            }
            if (aVar.hzQ != null) {
                this.hCT.setVisibility(0);
                this.hCT.setData(aVar.hzQ.getMedia_pic(), aVar.hzQ.join_count, aVar.hzQ.start_time, aVar.hzQ.getLiveTitle());
            } else {
                this.hCT.setVisibility(4);
            }
            if (this.hCS != null) {
                this.hCS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.hzN != null) {
                            e.this.hzN.a(aVar.hzP, view);
                        }
                    }
                });
            }
            if (this.hCT != null) {
                this.hCT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.hzN != null) {
                            e.this.hzN.a(aVar.hzQ, view);
                        }
                    }
                });
            }
        }
    }
}
