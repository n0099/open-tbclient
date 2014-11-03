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
    private ForumDetailData axi;
    private ViewGroup axn;
    private TextView axo;
    private ImageView axp;
    private ViewGroup axq;
    private boolean axr;
    private Context mContext;

    public ItemFootNavView(Context context) {
        super(context);
        this.axr = false;
        init(context);
    }

    public ItemFootNavView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.axr = false;
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        com.baidu.adp.lib.g.b.ek().a(context, w.forum_detail_foot_nav, this, true);
        this.axn = (ViewGroup) findViewById(v.fn_care_box);
        this.axo = (TextView) findViewById(v.fn_care_btn);
        this.axp = (ImageView) findViewById(v.icon_brief_care);
        this.axq = (ViewGroup) findViewById(v.fn_enter_box);
    }

    public boolean a(ForumDetailData forumDetailData, BaseActivity baseActivity) {
        this.axr = baseActivity.getIntent().getStringExtra("from_type").equals(ForumDetailActivity.FromType.FRS.toString());
        if (forumDetailData == null || forumDetailData.forum_info == null) {
            return false;
        }
        this.axi = forumDetailData;
        String str = forumDetailData.forum_info.forum_name;
        bI(forumDetailData.forum_info.is_like == 1);
        this.axn.setOnClickListener(new f(this, baseActivity));
        this.axq.setOnClickListener(new g(this, baseActivity, str));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BaseActivity baseActivity) {
        boolean z = (TbadkApplication.getCurrentAccount() == null || TbadkApplication.getCurrentAccountName() == null) ? false : true;
        Object tag = this.axo.getTag();
        boolean z2 = (tag == null || ((Integer) tag).intValue() != 2) ? true : true;
        if (!z && !z2) {
            this.axo.setTag(2);
            LoginActivity.a((Activity) baseActivity, getResources().getString(y.login_to_use), true, 11034);
            return;
        }
        this.axo.setTag(3);
        int intValue = ((Integer) this.axn.getTag()).intValue();
        if (intValue == 0) {
            b(baseActivity, this.axr);
        } else if (intValue == 1) {
            a(baseActivity, this.axr);
        }
        TiebaStatic.eventStat(this.mContext, intValue == 1 ? "detail_care_add" : "detail_care_cancel", "click", 1, new Object[0]);
    }

    private void a(BaseActivity baseActivity, boolean z) {
        ag agVar = new ag(baseActivity);
        agVar.setFrom(BarDetailForDirSwitchStatic.BAR_DETAIL_DIR);
        agVar.setLoadDataCallBack(new h(this, agVar, baseActivity, z));
        agVar.ay(this.axi.forum_info.forum_name, String.valueOf(this.axi.forum_info.forum_id));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bH(boolean z) {
    }

    private void b(BaseActivity baseActivity, boolean z) {
        bc bcVar = new bc();
        bcVar.setFrom(BarDetailForDirSwitchStatic.BAR_DETAIL_DIR);
        bcVar.a(new i(this, baseActivity, z));
        bcVar.g(this.axi.forum_info.forum_name, this.axi.forum_info.forum_id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bI(boolean z) {
        int i;
        if (z) {
            aw.c(this.axp, u.icon_brief_cancel);
            i = y.forum_detail_fans_cancel;
            this.axn.setTag(0);
        } else {
            aw.c(this.axp, u.icon_brief_attention);
            i = y.forum_detail_fans;
            this.axn.setTag(1);
        }
        this.axo.setText(this.mContext.getResources().getString(i));
    }

    public void a(BaseActivity baseActivity, int i) {
        baseActivity.getLayoutMode().L(i == 1);
        baseActivity.getLayoutMode().h(this);
    }

    public void b(BaseActivity baseActivity) {
        Object tag;
        if (this.axo != null && (tag = this.axo.getTag()) != null && ((Integer) tag).intValue() == 2) {
            a(baseActivity);
        }
    }
}
