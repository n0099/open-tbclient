package com.baidu.tieba.ala.liveroom.activeview;

import android.view.View;
import com.baidu.live.data.i;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes4.dex */
public class a {
    private TbImageView fYZ;
    private View fZa;
    private int mPosition;
    private View mRoot;

    public a(View view, int i) {
        this.mRoot = view;
        this.fYZ = (TbImageView) view.findViewById(a.g.ala_live_active_view_img);
        this.fZa = view.findViewById(a.g.new_icon);
        this.fYZ.setDefaultErrorResource(0);
        this.fYZ.setDefaultBgResource(a.d.sdk_transparent);
        this.fYZ.setAutoChangeStyle(false);
        this.mPosition = i;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void a(i iVar) {
        if (iVar != null) {
            this.mRoot.setTag(a.g.ala_active_view_position, Integer.valueOf(this.mPosition));
            this.mRoot.setTag(a.g.ala_active_view_data, iVar);
            this.fYZ.startLoad(iVar.pic_url, 10, false);
            if (iVar.ayf) {
                this.fZa.setVisibility(0);
            } else {
                this.fZa.setVisibility(4);
            }
        }
    }
}
