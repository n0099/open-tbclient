package com.baidu.tieba.forumdetail;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tieba.forumdetail.ForumDetailActivity;
import com.baidu.tieba.model.af;
import com.baidu.tieba.model.bc;
import com.baidu.tieba.switchs.features.BarDetailForDirSwitchStatic;
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

    private void a(Context context) {
        this.a = context;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(com.baidu.tieba.a.i.forum_detail_foot_nav, (ViewGroup) this, true);
        this.b = (ViewGroup) findViewById(com.baidu.tieba.a.h.fn_care_box);
        this.c = (TextView) findViewById(com.baidu.tieba.a.h.fn_care_btn);
        this.d = (ImageView) findViewById(com.baidu.tieba.a.h.icon_brief_care);
        this.e = (ViewGroup) findViewById(com.baidu.tieba.a.h.fn_enter_box);
    }

    public final boolean a(ForumDetailData forumDetailData, com.baidu.tbadk.a aVar) {
        this.g = aVar.getIntent().getStringExtra("from_type").equals(ForumDetailActivity.FromType.FRS.toString());
        if (forumDetailData == null || forumDetailData.forumInfo == null) {
            return false;
        }
        this.f = forumDetailData;
        String str = forumDetailData.forumInfo.forumName;
        a(forumDetailData.forumInfo.isLike == 1);
        this.b.setOnClickListener(new f(this, aVar));
        this.e.setOnClickListener(new g(this, aVar, str));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.a aVar) {
        boolean z = (TbadkApplication.E() == null || TbadkApplication.O() == null) ? false : true;
        Object tag = this.c.getTag();
        boolean z2 = (tag == null || ((Integer) tag).intValue() != 2) ? true : true;
        if (!z && !z2) {
            this.c.setTag(2);
            LoginActivity.a((Activity) aVar, getResources().getString(com.baidu.tieba.a.k.login_to_use), true, 11034);
            return;
        }
        this.c.setTag(3);
        int intValue = ((Integer) this.b.getTag()).intValue();
        if (intValue == 0) {
            boolean z3 = this.g;
            bc bcVar = new bc();
            bcVar.a(BarDetailForDirSwitchStatic.BAR_DETAIL_DIR);
            bcVar.a(new i(this, aVar, z3));
            bcVar.a(this.f.forumInfo.forumName, this.f.forumInfo.forumID);
        } else if (intValue == 1) {
            boolean z4 = this.g;
            af afVar = new af();
            afVar.a(BarDetailForDirSwitchStatic.BAR_DETAIL_DIR);
            afVar.setLoadDataCallBack(new h(this, afVar, aVar, z4));
            afVar.a(this.f.forumInfo.forumName, String.valueOf(this.f.forumInfo.forumID));
        }
        TiebaStatic.a(this.a, intValue == 1 ? "detail_care_add" : "detail_care_cancel", "click", 1, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(ItemFootNavView itemFootNavView, boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        int l = TbadkApplication.j().l();
        if (z) {
            if (l == 1) {
                i4 = com.baidu.tieba.a.g.icon_brief_cancel_1;
            } else {
                i4 = com.baidu.tieba.a.g.icon_brief_cancel;
            }
            int i5 = com.baidu.tieba.a.k.forum_detail_fans_cancel;
            this.b.setTag(0);
            i2 = i4;
            i3 = i5;
        } else {
            if (l == 1) {
                i = com.baidu.tieba.a.g.icon_brief_attention_1;
            } else {
                i = com.baidu.tieba.a.g.icon_brief_attention;
            }
            int i6 = com.baidu.tieba.a.k.forum_detail_fans;
            this.b.setTag(1);
            i2 = i;
            i3 = i6;
        }
        this.d.setImageResource(i2);
        this.c.setText(this.a.getResources().getString(i3));
    }

    public final void a(com.baidu.tbadk.a aVar, int i) {
        aVar.getLayoutMode().a(i == 1);
        aVar.getLayoutMode().a(this);
    }

    public final void a(com.baidu.tbadk.a aVar) {
        Object tag;
        if (this.c != null && (tag = this.c.getTag()) != null && ((Integer) tag).intValue() == 2) {
            b(aVar);
        }
    }
}
