package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class e extends c {
    private PlayBackItemView hDl;
    private PlayBackItemView hDm;

    public e(View view, int i) {
        super(view, i);
        this.hDl = (PlayBackItemView) view.findViewById(a.f.playback_item_left);
        this.hDm = (PlayBackItemView) view.findViewById(a.f.playback_item_right);
    }

    @Override // com.baidu.tieba.ala.person.view.c
    public void H(Object obj) {
        if (obj instanceof com.baidu.tieba.ala.person.a.a) {
            final com.baidu.tieba.ala.person.a.a aVar = (com.baidu.tieba.ala.person.a.a) obj;
            if (aVar.hAi != null) {
                this.hDl.setVisibility(0);
                this.hDl.setData(aVar.hAi.getMedia_pic(), aVar.hAi.join_count, aVar.hAi.start_time, aVar.hAi.getLiveTitle());
            } else {
                this.hDl.setVisibility(4);
            }
            if (aVar.hAj != null) {
                this.hDm.setVisibility(0);
                this.hDm.setData(aVar.hAj.getMedia_pic(), aVar.hAj.join_count, aVar.hAj.start_time, aVar.hAj.getLiveTitle());
            } else {
                this.hDm.setVisibility(4);
            }
            if (this.hDl != null) {
                this.hDl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.hAg != null) {
                            e.this.hAg.a(aVar.hAi, view);
                        }
                    }
                });
            }
            if (this.hDm != null) {
                this.hDm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.hAg != null) {
                            e.this.hAg.a(aVar.hAj, view);
                        }
                    }
                });
            }
        }
    }
}
