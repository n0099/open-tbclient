package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class e extends c {
    private PlayBackItemView ftO;
    private PlayBackItemView ftP;

    public e(View view, int i) {
        super(view, i);
        this.ftO = (PlayBackItemView) view.findViewById(a.g.playback_item_left);
        this.ftP = (PlayBackItemView) view.findViewById(a.g.playback_item_right);
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void A(Object obj) {
        if (obj instanceof com.baidu.tieba.ala.person.a.a) {
            final com.baidu.tieba.ala.person.a.a aVar = (com.baidu.tieba.ala.person.a.a) obj;
            if (aVar.fqL != null) {
                this.ftO.setVisibility(0);
                this.ftO.setData(aVar.fqL.getMedia_pic(), aVar.fqL.join_count, aVar.fqL.start_time, aVar.fqL.getLiveTitle());
            } else {
                this.ftO.setVisibility(4);
            }
            if (aVar.fqM != null) {
                this.ftP.setVisibility(0);
                this.ftP.setData(aVar.fqM.getMedia_pic(), aVar.fqM.join_count, aVar.fqM.start_time, aVar.fqM.getLiveTitle());
            } else {
                this.ftP.setVisibility(4);
            }
            if (this.ftO != null) {
                this.ftO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.fqJ != null) {
                            e.this.fqJ.a(aVar.fqL, view);
                        }
                    }
                });
            }
            if (this.ftP != null) {
                this.ftP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.fqJ != null) {
                            e.this.fqJ.a(aVar.fqM, view);
                        }
                    }
                });
            }
        }
    }
}
