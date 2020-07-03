package com.baidu.tieba.ala.liveroom.activeview;

import android.view.View;
import com.baidu.live.data.i;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes3.dex */
public class a {
    private TbImageView fTH;
    private View fTI;
    private int mPosition;
    private View mRoot;

    public a(View view, int i) {
        this.mRoot = view;
        this.fTH = (TbImageView) view.findViewById(a.g.ala_live_active_view_img);
        this.fTI = view.findViewById(a.g.new_icon);
        this.fTH.setDefaultErrorResource(0);
        this.fTH.setDefaultBgResource(a.d.sdk_transparent);
        this.fTH.setAutoChangeStyle(false);
        this.mPosition = i;
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void a(i iVar) {
        if (iVar != null) {
            this.mRoot.setTag(a.g.ala_active_view_position, Integer.valueOf(this.mPosition));
            this.mRoot.setTag(a.g.ala_active_view_data, iVar);
            this.fTH.startLoad(iVar.pic_url, 10, false);
            if (iVar.awS) {
                this.fTI.setVisibility(0);
            } else {
                this.fTI.setVisibility(4);
            }
        }
    }
}
