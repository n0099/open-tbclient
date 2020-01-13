package com.baidu.tieba.ala.liveroom.activeview;

import android.view.View;
import com.baidu.live.data.e;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes2.dex */
public class a {
    private TbImageView eLg;
    private View eLh;
    private int mPosition;
    private View mRoot;

    public a(View view, int i) {
        this.mRoot = view;
        this.eLg = (TbImageView) view.findViewById(a.g.ala_live_active_view_img);
        this.eLh = view.findViewById(a.g.new_icon);
        this.eLg.setDefaultErrorResource(0);
        this.eLg.setDefaultBgResource(a.d.sdk_transparent);
        this.eLg.setAutoChangeStyle(false);
        this.mPosition = i;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.mRoot.setTag(a.g.ala_active_view_position, Integer.valueOf(this.mPosition));
            this.mRoot.setTag(a.g.ala_active_view_data, eVar);
            this.eLg.startLoad(eVar.pic_url, 10, false);
            if (eVar.VJ) {
                this.eLh.setVisibility(0);
            } else {
                this.eLh.setVisibility(4);
            }
        }
    }
}
