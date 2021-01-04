package com.baidu.tieba.ala.person.view;

import android.view.View;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class f extends d {
    private PlayBackItemView hYY;
    private PlayBackItemView hYZ;

    public f(View view, int i) {
        super(view, i);
        this.hYY = (PlayBackItemView) view.findViewById(a.f.playback_item_left);
        this.hYZ = (PlayBackItemView) view.findViewById(a.f.playback_item_right);
    }

    @Override // com.baidu.tieba.ala.person.view.d
    public void D(Object obj) {
        if (obj instanceof com.baidu.tieba.ala.person.a.a) {
            final com.baidu.tieba.ala.person.a.a aVar = (com.baidu.tieba.ala.person.a.a) obj;
            if (aVar.hVI != null) {
                this.hYY.setVisibility(0);
                this.hYY.setData(aVar.hVI.getMedia_pic(), aVar.hVI.join_count, aVar.hVI.start_time, aVar.hVI.getLiveTitle());
            } else {
                this.hYY.setVisibility(4);
            }
            if (aVar.hVJ != null) {
                this.hYZ.setVisibility(0);
                this.hYZ.setData(aVar.hVJ.getMedia_pic(), aVar.hVJ.join_count, aVar.hVJ.start_time, aVar.hVJ.getLiveTitle());
            } else {
                this.hYZ.setVisibility(4);
            }
            if (this.hYY != null) {
                this.hYY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.f.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (f.this.hVG != null) {
                            f.this.hVG.a(aVar.hVI, view);
                        }
                    }
                });
            }
            if (this.hYZ != null) {
                this.hYZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.f.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (f.this.hVG != null) {
                            f.this.hVG.a(aVar.hVJ, view);
                        }
                    }
                });
            }
        }
    }
}
