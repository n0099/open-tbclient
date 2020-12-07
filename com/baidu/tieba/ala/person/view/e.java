package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class e extends c {
    private PlayBackItemView hMA;
    private PlayBackItemView hMz;

    public e(View view, int i) {
        super(view, i);
        this.hMz = (PlayBackItemView) view.findViewById(a.f.playback_item_left);
        this.hMA = (PlayBackItemView) view.findViewById(a.f.playback_item_right);
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void H(Object obj) {
        if (obj instanceof com.baidu.tieba.ala.person.a.a) {
            final com.baidu.tieba.ala.person.a.a aVar = (com.baidu.tieba.ala.person.a.a) obj;
            if (aVar.hJu != null) {
                this.hMz.setVisibility(0);
                this.hMz.setData(aVar.hJu.getMedia_pic(), aVar.hJu.join_count, aVar.hJu.start_time, aVar.hJu.getLiveTitle());
            } else {
                this.hMz.setVisibility(4);
            }
            if (aVar.hJv != null) {
                this.hMA.setVisibility(0);
                this.hMA.setData(aVar.hJv.getMedia_pic(), aVar.hJv.join_count, aVar.hJv.start_time, aVar.hJv.getLiveTitle());
            } else {
                this.hMA.setVisibility(4);
            }
            if (this.hMz != null) {
                this.hMz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.hJs != null) {
                            e.this.hJs.a(aVar.hJu, view);
                        }
                    }
                });
            }
            if (this.hMA != null) {
                this.hMA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.hJs != null) {
                            e.this.hJs.a(aVar.hJv, view);
                        }
                    }
                });
            }
        }
    }
}
