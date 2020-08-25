package com.baidu.tieba.ala.liveroom.activeview;

import android.view.View;
import com.baidu.live.data.i;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes7.dex */
public class a {
    private TbImageView gkY;
    private View gkZ;
    private int mPosition;
    private View mRoot;

    public a(View view, int i) {
        this.mRoot = view;
        this.gkY = (TbImageView) view.findViewById(a.g.ala_live_active_view_img);
        this.gkZ = view.findViewById(a.g.new_icon);
        this.gkY.setDefaultErrorResource(0);
        this.gkY.setDefaultBgResource(a.d.sdk_transparent);
        this.gkY.setAutoChangeStyle(false);
        this.mPosition = i;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void a(i iVar) {
        if (iVar != null) {
            this.mRoot.setTag(a.g.ala_active_view_position, Integer.valueOf(this.mPosition));
            this.mRoot.setTag(a.g.ala_active_view_data, iVar);
            this.gkY.startLoad(iVar.pic_url, 10, false);
            if (iVar.aDh) {
                this.gkZ.setVisibility(0);
            } else {
                this.gkZ.setVisibility(4);
            }
        }
    }
}
