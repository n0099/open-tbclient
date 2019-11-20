package com.baidu.tieba.ala.liveroom.activeview;

import android.view.View;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes6.dex */
public class a {
    private TbImageView dUv;
    private View dUw;
    private int mPosition;
    private View mRoot;

    public a(View view, int i) {
        this.mRoot = view;
        this.dUv = (TbImageView) view.findViewById(a.g.ala_live_active_view_img);
        this.dUw = view.findViewById(a.g.new_icon);
        this.dUv.setDefaultErrorResource(0);
        this.dUv.setDefaultBgResource(a.d.sdk_transparent);
        this.dUv.setAutoChangeStyle(false);
        this.mPosition = i;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void a(com.baidu.live.data.c cVar) {
        if (cVar != null) {
            this.mRoot.setTag(a.g.ala_active_view_position, Integer.valueOf(this.mPosition));
            this.mRoot.setTag(a.g.ala_active_view_data, cVar);
            this.dUv.startLoad(cVar.pic_url, 10, false);
            if (cVar.Ot) {
                this.dUw.setVisibility(0);
            } else {
                this.dUw.setVisibility(4);
            }
        }
    }
}
