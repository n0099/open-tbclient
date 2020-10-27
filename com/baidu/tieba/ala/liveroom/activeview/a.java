package com.baidu.tieba.ala.liveroom.activeview;

import android.view.View;
import com.baidu.live.data.o;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes4.dex */
public class a {
    private TbImageView gOq;
    private View gOr;
    private int mPosition;
    private View mRoot;

    public a(View view, int i) {
        this.mRoot = view;
        this.gOq = (TbImageView) view.findViewById(a.g.ala_live_active_view_img);
        this.gOr = view.findViewById(a.g.new_icon);
        this.gOq.setDefaultErrorResource(0);
        this.gOq.setDefaultBgResource(a.d.sdk_transparent);
        this.gOq.setAutoChangeStyle(false);
        this.mPosition = i;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void a(o oVar) {
        if (oVar != null) {
            this.mRoot.setTag(a.g.ala_active_view_position, Integer.valueOf(this.mPosition));
            this.mRoot.setTag(a.g.ala_active_view_data, oVar);
            this.gOq.startLoad(oVar.pic_url, 10, false);
            if (oVar.aHH) {
                this.gOr.setVisibility(0);
            } else {
                this.gOr.setVisibility(4);
            }
        }
    }
}
