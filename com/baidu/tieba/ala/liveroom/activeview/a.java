package com.baidu.tieba.ala.liveroom.activeview;

import android.view.View;
import com.baidu.live.data.l;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes4.dex */
public class a {
    private TbImageView gCC;
    private View gCD;
    private int mPosition;
    private View mRoot;

    public a(View view, int i) {
        this.mRoot = view;
        this.gCC = (TbImageView) view.findViewById(a.g.ala_live_active_view_img);
        this.gCD = view.findViewById(a.g.new_icon);
        this.gCC.setDefaultErrorResource(0);
        this.gCC.setDefaultBgResource(a.d.sdk_transparent);
        this.gCC.setAutoChangeStyle(false);
        this.mPosition = i;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void a(l lVar) {
        if (lVar != null) {
            this.mRoot.setTag(a.g.ala_active_view_position, Integer.valueOf(this.mPosition));
            this.mRoot.setTag(a.g.ala_active_view_data, lVar);
            this.gCC.startLoad(lVar.pic_url, 10, false);
            if (lVar.aHg) {
                this.gCD.setVisibility(0);
            } else {
                this.gCD.setVisibility(4);
            }
        }
    }
}
