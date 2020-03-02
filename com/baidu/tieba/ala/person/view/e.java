package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class e extends c {
    private PlayBackItemView ftB;
    private PlayBackItemView ftC;

    public e(View view, int i) {
        super(view, i);
        this.ftB = (PlayBackItemView) view.findViewById(a.g.playback_item_left);
        this.ftC = (PlayBackItemView) view.findViewById(a.g.playback_item_right);
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void A(Object obj) {
        if (obj instanceof com.baidu.tieba.ala.person.a.a) {
            final com.baidu.tieba.ala.person.a.a aVar = (com.baidu.tieba.ala.person.a.a) obj;
            if (aVar.fqy != null) {
                this.ftB.setVisibility(0);
                this.ftB.setData(aVar.fqy.getMedia_pic(), aVar.fqy.join_count, aVar.fqy.start_time, aVar.fqy.getLiveTitle());
            } else {
                this.ftB.setVisibility(4);
            }
            if (aVar.fqz != null) {
                this.ftC.setVisibility(0);
                this.ftC.setData(aVar.fqz.getMedia_pic(), aVar.fqz.join_count, aVar.fqz.start_time, aVar.fqz.getLiveTitle());
            } else {
                this.ftC.setVisibility(4);
            }
            if (this.ftB != null) {
                this.ftB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.fqw != null) {
                            e.this.fqw.a(aVar.fqy, view);
                        }
                    }
                });
            }
            if (this.ftC != null) {
                this.ftC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.fqw != null) {
                            e.this.fqw.a(aVar.fqz, view);
                        }
                    }
                });
            }
        }
    }
}
