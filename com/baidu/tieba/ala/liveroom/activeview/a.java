package com.baidu.tieba.ala.liveroom.activeview;

import android.view.View;
import com.baidu.live.data.f;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a {
    private TbImageView ePh;
    private View ePi;
    private int mPosition;
    private View mRoot;

    public a(View view, int i) {
        this.mRoot = view;
        this.ePh = (TbImageView) view.findViewById(a.g.ala_live_active_view_img);
        this.ePi = view.findViewById(a.g.new_icon);
        this.ePh.setDefaultErrorResource(0);
        this.ePh.setDefaultBgResource(a.d.sdk_transparent);
        this.ePh.setAutoChangeStyle(false);
        this.mPosition = i;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.mRoot.setTag(a.g.ala_active_view_position, Integer.valueOf(this.mPosition));
            this.mRoot.setTag(a.g.ala_active_view_data, fVar);
            this.ePh.startLoad(fVar.pic_url, 10, false);
            if (fVar.Xt) {
                this.ePi.setVisibility(0);
            } else {
                this.ePi.setVisibility(4);
            }
        }
    }
}
