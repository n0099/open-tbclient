package com.baidu.tieba.ala.liveroom.activeview;

import android.view.View;
import com.baidu.live.data.i;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a {
    private TbImageView fIo;
    private View fIp;
    private int mPosition;
    private View mRoot;

    public a(View view, int i) {
        this.mRoot = view;
        this.fIo = (TbImageView) view.findViewById(a.g.ala_live_active_view_img);
        this.fIp = view.findViewById(a.g.new_icon);
        this.fIo.setDefaultErrorResource(0);
        this.fIo.setDefaultBgResource(a.d.sdk_transparent);
        this.fIo.setAutoChangeStyle(false);
        this.mPosition = i;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void a(i iVar) {
        if (iVar != null) {
            this.mRoot.setTag(a.g.ala_active_view_position, Integer.valueOf(this.mPosition));
            this.mRoot.setTag(a.g.ala_active_view_data, iVar);
            this.fIo.startLoad(iVar.pic_url, 10, false);
            if (iVar.auM) {
                this.fIp.setVisibility(0);
            } else {
                this.fIp.setVisibility(4);
            }
        }
    }
}
