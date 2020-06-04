package com.baidu.tieba.ala.liveroom.activeview;

import android.view.View;
import com.baidu.live.data.i;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a {
    private View fIA;
    private TbImageView fIz;
    private int mPosition;
    private View mRoot;

    public a(View view, int i) {
        this.mRoot = view;
        this.fIz = (TbImageView) view.findViewById(a.g.ala_live_active_view_img);
        this.fIA = view.findViewById(a.g.new_icon);
        this.fIz.setDefaultErrorResource(0);
        this.fIz.setDefaultBgResource(a.d.sdk_transparent);
        this.fIz.setAutoChangeStyle(false);
        this.mPosition = i;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void a(i iVar) {
        if (iVar != null) {
            this.mRoot.setTag(a.g.ala_active_view_position, Integer.valueOf(this.mPosition));
            this.mRoot.setTag(a.g.ala_active_view_data, iVar);
            this.fIz.startLoad(iVar.pic_url, 10, false);
            if (iVar.auM) {
                this.fIA.setVisibility(0);
            } else {
                this.fIA.setVisibility(4);
            }
        }
    }
}
