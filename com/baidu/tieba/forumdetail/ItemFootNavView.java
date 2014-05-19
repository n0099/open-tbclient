package com.baidu.tieba.forumdetail;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tieba.forumdetail.ForumDetailActivity;
import com.baidu.tieba.model.af;
import com.baidu.tieba.model.bc;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.s;
import com.baidu.tieba.switchs.features.BarDetailForDirSwitchStatic;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class ItemFootNavView extends LinearLayout {
    private Context a;
    private ViewGroup b;
    private TextView c;
    private ImageView d;
    private ViewGroup e;
    private ForumDetailData f;
    private boolean g;

    public ItemFootNavView(Context context) {
        super(context);
        this.g = false;
        a(context);
    }

    public ItemFootNavView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = false;
        a(context);
    }

    public void a(Context context) {
        this.a = context;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(s.forum_detail_foot_nav, (ViewGroup) this, true);
        this.b = (ViewGroup) findViewById(r.fn_care_box);
        this.c = (TextView) findViewById(r.fn_care_btn);
        this.d = (ImageView) findViewById(r.icon_brief_care);
        this.e = (ViewGroup) findViewById(r.fn_enter_box);
    }

    public boolean a(ForumDetailData forumDetailData, BaseActivity baseActivity) {
        this.g = baseActivity.getIntent().getStringExtra("from_type").equals(ForumDetailActivity.FromType.FRS.toString());
        if (forumDetailData == null || forumDetailData.forumInfo == null) {
            return false;
        }
        this.f = forumDetailData;
        String str = forumDetailData.forumInfo.forumName;
        b(forumDetailData.forumInfo.isLike == 1);
        this.b.setOnClickListener(new f(this, baseActivity));
        this.e.setOnClickListener(new g(this, baseActivity, str));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(BaseActivity baseActivity) {
        boolean z = (TbadkApplication.getCurrentAccount() == null || TbadkApplication.getCurrentAccountName() == null) ? false : true;
        Object tag = this.c.getTag();
        boolean z2 = (tag == null || ((Integer) tag).intValue() != 2) ? true : true;
        if (!z && !z2) {
            this.c.setTag(2);
            LoginActivity.a((Activity) baseActivity, getResources().getString(u.login_to_use), true, 11034);
            return;
        }
        this.c.setTag(3);
        int intValue = ((Integer) this.b.getTag()).intValue();
        if (intValue == 0) {
            b(baseActivity, this.g);
        } else if (intValue == 1) {
            a(baseActivity, this.g);
        }
        TiebaStatic.eventStat(this.a, intValue == 1 ? "detail_care_add" : "detail_care_cancel", "click", 1, new Object[0]);
    }

    private void a(BaseActivity baseActivity, boolean z) {
        af afVar = new af();
        afVar.a(BarDetailForDirSwitchStatic.BAR_DETAIL_DIR);
        afVar.setLoadDataCallBack(new h(this, afVar, baseActivity, z));
        afVar.a(this.f.forumInfo.forumName, String.valueOf(this.f.forumInfo.forumID));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
    }

    private void b(BaseActivity baseActivity, boolean z) {
        bc bcVar = new bc();
        bcVar.a(BarDetailForDirSwitchStatic.BAR_DETAIL_DIR);
        bcVar.a(new i(this, baseActivity, z));
        bcVar.a(this.f.forumInfo.forumName, this.f.forumInfo.forumID);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        int skinType = TbadkApplication.m252getInst().getSkinType();
        if (z) {
            if (skinType == 1) {
                i4 = q.icon_brief_cancel_1;
            } else {
                i4 = q.icon_brief_cancel;
            }
            int i5 = u.forum_detail_fans_cancel;
            this.b.setTag(0);
            i2 = i4;
            i3 = i5;
        } else {
            if (skinType == 1) {
                i = q.icon_brief_attention_1;
            } else {
                i = q.icon_brief_attention;
            }
            int i6 = u.forum_detail_fans;
            this.b.setTag(1);
            i2 = i;
            i3 = i6;
        }
        this.d.setImageResource(i2);
        this.c.setText(this.a.getResources().getString(i3));
    }

    public void a(BaseActivity baseActivity, int i) {
        baseActivity.getLayoutMode().a(i == 1);
        baseActivity.getLayoutMode().a((View) this);
    }

    public void a(BaseActivity baseActivity) {
        Object tag;
        if (this.c != null && (tag = this.c.getTag()) != null && ((Integer) tag).intValue() == 2) {
            b(baseActivity);
        }
    }
}
