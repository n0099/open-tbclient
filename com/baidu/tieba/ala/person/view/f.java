package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class f extends d {
    private PlayBackItemView hYM;
    private PlayBackItemView hYN;

    public f(View view, int i) {
        super(view, i);
        this.hYM = (PlayBackItemView) view.findViewById(a.f.playback_item_left);
        this.hYN = (PlayBackItemView) view.findViewById(a.f.playback_item_right);
    }

    @Override // com.baidu.tieba.ala.person.view.d
    public void C(Object obj) {
        if (obj instanceof com.baidu.tieba.ala.person.a.a) {
            final com.baidu.tieba.ala.person.a.a aVar = (com.baidu.tieba.ala.person.a.a) obj;
            if (aVar.hVw != null) {
                this.hYM.setVisibility(0);
                this.hYM.setData(aVar.hVw.getMedia_pic(), aVar.hVw.join_count, aVar.hVw.start_time, aVar.hVw.getLiveTitle());
            } else {
                this.hYM.setVisibility(4);
            }
            if (aVar.hVx != null) {
                this.hYN.setVisibility(0);
                this.hYN.setData(aVar.hVx.getMedia_pic(), aVar.hVx.join_count, aVar.hVx.start_time, aVar.hVx.getLiveTitle());
            } else {
                this.hYN.setVisibility(4);
            }
            if (this.hYM != null) {
                this.hYM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.f.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (f.this.hVu != null) {
                            f.this.hVu.a(aVar.hVw, view);
                        }
                    }
                });
            }
            if (this.hYN != null) {
                this.hYN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.f.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (f.this.hVu != null) {
                            f.this.hVu.a(aVar.hVx, view);
                        }
                    }
                });
            }
        }
    }
}
