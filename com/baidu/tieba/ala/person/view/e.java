package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class e extends c {
    private PlayBackItemView hMB;
    private PlayBackItemView hMC;

    public e(View view, int i) {
        super(view, i);
        this.hMB = (PlayBackItemView) view.findViewById(a.f.playback_item_left);
        this.hMC = (PlayBackItemView) view.findViewById(a.f.playback_item_right);
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void H(Object obj) {
        if (obj instanceof com.baidu.tieba.ala.person.a.a) {
            final com.baidu.tieba.ala.person.a.a aVar = (com.baidu.tieba.ala.person.a.a) obj;
            if (aVar.hJw != null) {
                this.hMB.setVisibility(0);
                this.hMB.setData(aVar.hJw.getMedia_pic(), aVar.hJw.join_count, aVar.hJw.start_time, aVar.hJw.getLiveTitle());
            } else {
                this.hMB.setVisibility(4);
            }
            if (aVar.hJx != null) {
                this.hMC.setVisibility(0);
                this.hMC.setData(aVar.hJx.getMedia_pic(), aVar.hJx.join_count, aVar.hJx.start_time, aVar.hJx.getLiveTitle());
            } else {
                this.hMC.setVisibility(4);
            }
            if (this.hMB != null) {
                this.hMB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.hJu != null) {
                            e.this.hJu.a(aVar.hJw, view);
                        }
                    }
                });
            }
            if (this.hMC != null) {
                this.hMC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.hJu != null) {
                            e.this.hJu.a(aVar.hJx, view);
                        }
                    }
                });
            }
        }
    }
}
