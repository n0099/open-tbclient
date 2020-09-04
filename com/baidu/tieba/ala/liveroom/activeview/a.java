package com.baidu.tieba.ala.liveroom.activeview;

import android.view.View;
import com.baidu.live.data.i;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes7.dex */
public class a {
    private TbImageView glc;
    private View gld;
    private int mPosition;
    private View mRoot;

    public a(View view, int i) {
        this.mRoot = view;
        this.glc = (TbImageView) view.findViewById(a.g.ala_live_active_view_img);
        this.gld = view.findViewById(a.g.new_icon);
        this.glc.setDefaultErrorResource(0);
        this.glc.setDefaultBgResource(a.d.sdk_transparent);
        this.glc.setAutoChangeStyle(false);
        this.mPosition = i;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void a(i iVar) {
        if (iVar != null) {
            this.mRoot.setTag(a.g.ala_active_view_position, Integer.valueOf(this.mPosition));
            this.mRoot.setTag(a.g.ala_active_view_data, iVar);
            this.glc.startLoad(iVar.pic_url, 10, false);
            if (iVar.aDj) {
                this.gld.setVisibility(0);
            } else {
                this.gld.setVisibility(4);
            }
        }
    }
}
