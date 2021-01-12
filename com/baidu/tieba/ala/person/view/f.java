package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class f extends d {
    private PlayBackItemView hUr;
    private PlayBackItemView hUs;

    public f(View view, int i) {
        super(view, i);
        this.hUr = (PlayBackItemView) view.findViewById(a.f.playback_item_left);
        this.hUs = (PlayBackItemView) view.findViewById(a.f.playback_item_right);
    }

    @Override // com.baidu.tieba.ala.person.view.d
    public void C(Object obj) {
        if (obj instanceof com.baidu.tieba.ala.person.a.a) {
            final com.baidu.tieba.ala.person.a.a aVar = (com.baidu.tieba.ala.person.a.a) obj;
            if (aVar.hRb != null) {
                this.hUr.setVisibility(0);
                this.hUr.setData(aVar.hRb.getMedia_pic(), aVar.hRb.join_count, aVar.hRb.start_time, aVar.hRb.getLiveTitle());
            } else {
                this.hUr.setVisibility(4);
            }
            if (aVar.hRc != null) {
                this.hUs.setVisibility(0);
                this.hUs.setData(aVar.hRc.getMedia_pic(), aVar.hRc.join_count, aVar.hRc.start_time, aVar.hRc.getLiveTitle());
            } else {
                this.hUs.setVisibility(4);
            }
            if (this.hUr != null) {
                this.hUr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.f.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (f.this.hQZ != null) {
                            f.this.hQZ.a(aVar.hRb, view);
                        }
                    }
                });
            }
            if (this.hUs != null) {
                this.hUs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.f.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (f.this.hQZ != null) {
                            f.this.hQZ.a(aVar.hRc, view);
                        }
                    }
                });
            }
        }
    }
}
