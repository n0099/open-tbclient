package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.live.q.a;
/* loaded from: classes2.dex */
public class e extends c {
    private PlayBackItemView fnO;
    private PlayBackItemView fnP;

    public e(View view, int i) {
        super(view, i);
        this.fnO = (PlayBackItemView) view.findViewById(a.g.playback_item_left);
        this.fnP = (PlayBackItemView) view.findViewById(a.g.playback_item_right);
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void A(Object obj) {
        if (obj instanceof com.baidu.tieba.ala.person.a.a) {
            final com.baidu.tieba.ala.person.a.a aVar = (com.baidu.tieba.ala.person.a.a) obj;
            if (aVar.fkJ != null) {
                this.fnO.setVisibility(0);
                this.fnO.setData(aVar.fkJ.getMedia_pic(), aVar.fkJ.join_count, aVar.fkJ.start_time, aVar.fkJ.getLiveTitle());
            } else {
                this.fnO.setVisibility(4);
            }
            if (aVar.fkK != null) {
                this.fnP.setVisibility(0);
                this.fnP.setData(aVar.fkK.getMedia_pic(), aVar.fkK.join_count, aVar.fkK.start_time, aVar.fkK.getLiveTitle());
            } else {
                this.fnP.setVisibility(4);
            }
            if (this.fnO != null) {
                this.fnO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.fkH != null) {
                            e.this.fkH.a(aVar.fkJ, view);
                        }
                    }
                });
            }
            if (this.fnP != null) {
                this.fnP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.fkH != null) {
                            e.this.fkH.a(aVar.fkK, view);
                        }
                    }
                });
            }
        }
    }
}
