package com.baidu.tieba.im.nearbygroups;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class k implements a {
    private NearbyGroupsActivity bgr;
    private LinearLayout mParent = null;
    private TextView bgx = null;
    private TextView Hm = null;
    private View ay = null;

    public k(NearbyGroupsActivity nearbyGroupsActivity) {
        this.bgr = null;
        this.bgr = nearbyGroupsActivity;
        init();
    }

    @Override // com.baidu.tieba.im.nearbygroups.a
    public View getView() {
        return this.ay;
    }

    @Override // com.baidu.tieba.im.nearbygroups.a
    public void b(int i, Object obj) {
        if (obj instanceof com.baidu.tieba.im.data.b) {
            this.Hm.setText(((com.baidu.tieba.im.data.b) obj).getName());
            this.bgx.setVisibility(8);
        }
    }

    public void init() {
        this.ay = com.baidu.adp.lib.g.b.ek().inflate(this.bgr, w.im_group_list_group, null);
        this.bgx = (TextView) this.ay.findViewById(v.tv_group_line_top);
        this.mParent = (LinearLayout) this.ay.findViewById(v.list_group);
        this.Hm = (TextView) this.ay.findViewById(v.tv_group_name);
        Rc();
    }

    public void onChangeSkinType(int i) {
        this.bgr.getLayoutMode().L(i == 1);
        this.bgr.getLayoutMode().h(this.mParent);
        aw.b(this.Hm, s.common_list_text, 1);
        gh(u.icon_list_small_lbs);
    }

    private void gh(int i) {
        Drawable drawable = aw.getDrawable(i);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.Hm.setCompoundDrawables(drawable, null, null, null);
    }

    public void Rc() {
        onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
    }
}
