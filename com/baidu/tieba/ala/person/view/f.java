package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class f extends d {
    private PlayBackItemView hZa;
    private PlayBackItemView hZb;

    public f(View view, int i) {
        super(view, i);
        this.hZa = (PlayBackItemView) view.findViewById(a.f.playback_item_left);
        this.hZb = (PlayBackItemView) view.findViewById(a.f.playback_item_right);
    }

    @Override // com.baidu.tieba.ala.person.view.d
    public void C(Object obj) {
        if (obj instanceof com.baidu.tieba.ala.person.a.a) {
            final com.baidu.tieba.ala.person.a.a aVar = (com.baidu.tieba.ala.person.a.a) obj;
            if (aVar.hVK != null) {
                this.hZa.setVisibility(0);
                this.hZa.setData(aVar.hVK.getMedia_pic(), aVar.hVK.join_count, aVar.hVK.start_time, aVar.hVK.getLiveTitle());
            } else {
                this.hZa.setVisibility(4);
            }
            if (aVar.hVL != null) {
                this.hZb.setVisibility(0);
                this.hZb.setData(aVar.hVL.getMedia_pic(), aVar.hVL.join_count, aVar.hVL.start_time, aVar.hVL.getLiveTitle());
            } else {
                this.hZb.setVisibility(4);
            }
            if (this.hZa != null) {
                this.hZa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.f.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (f.this.hVI != null) {
                            f.this.hVI.a(aVar.hVK, view);
                        }
                    }
                });
            }
            if (this.hZb != null) {
                this.hZb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.f.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (f.this.hVI != null) {
                            f.this.hVI.a(aVar.hVL, view);
                        }
                    }
                });
            }
        }
    }
}
