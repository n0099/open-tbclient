package com.baidu.tieba.forumdetail;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tieba.forumdetail.ForumDetailActivity;
import com.baidu.tieba.model.ag;
import com.baidu.tieba.model.bc;
import com.baidu.tieba.switchs.features.BarDetailForDirSwitchStatic;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class ItemFootNavView extends LinearLayout {
    private ForumDetailData awZ;
    private ViewGroup axe;
    private TextView axf;
    private ImageView axg;
    private ViewGroup axh;
    private boolean axi;
    private Context mContext;

    public ItemFootNavView(Context context) {
        super(context);
        this.axi = false;
        init(context);
    }

    public ItemFootNavView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.axi = false;
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        com.baidu.adp.lib.g.b.ek().a(context, w.forum_detail_foot_nav, this, true);
        this.axe = (ViewGroup) findViewById(v.fn_care_box);
        this.axf = (TextView) findViewById(v.fn_care_btn);
        this.axg = (ImageView) findViewById(v.icon_brief_care);
        this.axh = (ViewGroup) findViewById(v.fn_enter_box);
    }

    public boolean a(ForumDetailData forumDetailData, BaseActivity baseActivity) {
        this.axi = baseActivity.getIntent().getStringExtra("from_type").equals(ForumDetailActivity.FromType.FRS.toString());
        if (forumDetailData == null || forumDetailData.forum_info == null) {
            return false;
        }
        this.awZ = forumDetailData;
        String str = forumDetailData.forum_info.forum_name;
        bI(forumDetailData.forum_info.is_like == 1);
        this.axe.setOnClickListener(new f(this, baseActivity));
        this.axh.setOnClickListener(new g(this, baseActivity, str));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BaseActivity baseActivity) {
        boolean z = (TbadkApplication.getCurrentAccount() == null || TbadkApplication.getCurrentAccountName() == null) ? false : true;
        Object tag = this.axf.getTag();
        boolean z2 = (tag == null || ((Integer) tag).intValue() != 2) ? true : true;
        if (!z && !z2) {
            this.axf.setTag(2);
            LoginActivity.a((Activity) baseActivity, getResources().getString(y.login_to_use), true, 11034);
            return;
        }
        this.axf.setTag(3);
        int intValue = ((Integer) this.axe.getTag()).intValue();
        if (intValue == 0) {
            b(baseActivity, this.axi);
        } else if (intValue == 1) {
            a(baseActivity, this.axi);
        }
        TiebaStatic.eventStat(this.mContext, intValue == 1 ? "detail_care_add" : "detail_care_cancel", "click", 1, new Object[0]);
    }

    private void a(BaseActivity baseActivity, boolean z) {
        ag agVar = new ag(baseActivity);
        agVar.setFrom(BarDetailForDirSwitchStatic.BAR_DETAIL_DIR);
        agVar.setLoadDataCallBack(new h(this, agVar, baseActivity, z));
        agVar.ay(this.awZ.forum_info.forum_name, String.valueOf(this.awZ.forum_info.forum_id));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bH(boolean z) {
    }

    private void b(BaseActivity baseActivity, boolean z) {
        bc bcVar = new bc();
        bcVar.setFrom(BarDetailForDirSwitchStatic.BAR_DETAIL_DIR);
        bcVar.a(new i(this, baseActivity, z));
        bcVar.g(this.awZ.forum_info.forum_name, this.awZ.forum_info.forum_id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bI(boolean z) {
        int i;
        if (z) {
            aw.c(this.axg, u.icon_brief_cancel);
            i = y.forum_detail_fans_cancel;
            this.axe.setTag(0);
        } else {
            aw.c(this.axg, u.icon_brief_attention);
            i = y.forum_detail_fans;
            this.axe.setTag(1);
        }
        this.axf.setText(this.mContext.getResources().getString(i));
    }

    public void a(BaseActivity baseActivity, int i) {
        baseActivity.getLayoutMode().L(i == 1);
        baseActivity.getLayoutMode().h(this);
    }

    public void b(BaseActivity baseActivity) {
        Object tag;
        if (this.axf != null && (tag = this.axf.getTag()) != null && ((Integer) tag).intValue() == 2) {
            a(baseActivity);
        }
    }
}
