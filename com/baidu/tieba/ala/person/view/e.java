package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class e extends c {
    private PlayBackItemView ftA;
    private PlayBackItemView ftB;

    public e(View view, int i) {
        super(view, i);
        this.ftA = (PlayBackItemView) view.findViewById(a.g.playback_item_left);
        this.ftB = (PlayBackItemView) view.findViewById(a.g.playback_item_right);
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void A(Object obj) {
        if (obj instanceof com.baidu.tieba.ala.person.a.a) {
            final com.baidu.tieba.ala.person.a.a aVar = (com.baidu.tieba.ala.person.a.a) obj;
            if (aVar.fqx != null) {
                this.ftA.setVisibility(0);
                this.ftA.setData(aVar.fqx.getMedia_pic(), aVar.fqx.join_count, aVar.fqx.start_time, aVar.fqx.getLiveTitle());
            } else {
                this.ftA.setVisibility(4);
            }
            if (aVar.fqy != null) {
                this.ftB.setVisibility(0);
                this.ftB.setData(aVar.fqy.getMedia_pic(), aVar.fqy.join_count, aVar.fqy.start_time, aVar.fqy.getLiveTitle());
            } else {
                this.ftB.setVisibility(4);
            }
            if (this.ftA != null) {
                this.ftA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.fqv != null) {
                            e.this.fqv.a(aVar.fqx, view);
                        }
                    }
                });
            }
            if (this.ftB != null) {
                this.ftB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.fqv != null) {
                            e.this.fqv.a(aVar.fqy, view);
                        }
                    }
                });
            }
        }
    }
}
