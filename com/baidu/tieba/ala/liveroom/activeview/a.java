package com.baidu.tieba.ala.liveroom.activeview;

import android.view.View;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes6.dex */
public class a {
    private TbImageView dVm;
    private View dVn;
    private int mPosition;
    private View mRoot;

    public a(View view, int i) {
        this.mRoot = view;
        this.dVm = (TbImageView) view.findViewById(a.g.ala_live_active_view_img);
        this.dVn = view.findViewById(a.g.new_icon);
        this.dVm.setDefaultErrorResource(0);
        this.dVm.setDefaultBgResource(a.d.sdk_transparent);
        this.dVm.setAutoChangeStyle(false);
        this.mPosition = i;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void a(com.baidu.live.data.c cVar) {
        if (cVar != null) {
            this.mRoot.setTag(a.g.ala_active_view_position, Integer.valueOf(this.mPosition));
            this.mRoot.setTag(a.g.ala_active_view_data, cVar);
            this.dVm.startLoad(cVar.pic_url, 10, false);
            if (cVar.OW) {
                this.dVn.setVisibility(0);
            } else {
                this.dVn.setVisibility(4);
            }
        }
    }
}
