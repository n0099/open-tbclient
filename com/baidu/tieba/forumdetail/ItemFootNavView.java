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
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.forumdetail.ForumDetailActivity;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.model.ar;
import com.baidu.tieba.model.bx;
import com.baidu.tieba.switchs.SwitchKey;
import com.baidu.tieba.util.cb;
import com.slidingmenu.lib.R;
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
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.forum_detail_foot_nav, (ViewGroup) this, true);
        this.b = (ViewGroup) findViewById(R.id.fn_care_box);
        this.c = (TextView) findViewById(R.id.fn_care_btn);
        this.d = (ImageView) findViewById(R.id.icon_brief_care);
        this.e = (ViewGroup) findViewById(R.id.fn_enter_box);
    }

    public boolean a(ForumDetailData forumDetailData, com.baidu.tieba.f fVar) {
        this.g = fVar.getIntent().getStringExtra("from_type").equals(ForumDetailActivity.FromType.FRS.toString());
        if (forumDetailData == null || forumDetailData.forumInfo == null) {
            return false;
        }
        this.f = forumDetailData;
        String str = forumDetailData.forumInfo.forumName;
        b(forumDetailData.forumInfo.isLike == 1);
        this.b.setOnClickListener(new f(this, fVar));
        this.e.setOnClickListener(new g(this, fVar, str));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.f fVar) {
        boolean z = (TiebaApplication.A() == null || TiebaApplication.F() == null) ? false : true;
        Object tag = this.c.getTag();
        boolean z2 = (tag == null || ((Integer) tag).intValue() != 2) ? true : true;
        if (!z && !z2) {
            this.c.setTag(2);
            LoginActivity.a((Activity) fVar, getResources().getString(R.string.login_to_use), true, 11034);
            return;
        }
        this.c.setTag(3);
        int intValue = ((Integer) this.b.getTag()).intValue();
        if (intValue == 0) {
            b(fVar, this.g);
        } else if (intValue == 1) {
            a(fVar, this.g);
        }
        cb.a(this.a, intValue == 1 ? "detail_care_add" : "detail_care_cancel", "click", 1, new Object[0]);
    }

    private void a(com.baidu.tieba.f fVar, boolean z) {
        ar arVar = new ar();
        arVar.a(SwitchKey.BAR_DETAIL_DIR);
        arVar.setLoadDataCallBack(new h(this, arVar, fVar, z));
        arVar.a(this.f.forumInfo.forumName, String.valueOf(this.f.forumInfo.forumID));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            FrsActivity.b = !FrsActivity.b;
        }
    }

    private void b(com.baidu.tieba.f fVar, boolean z) {
        bx bxVar = new bx();
        bxVar.a(SwitchKey.BAR_DETAIL_DIR);
        bxVar.a(new i(this, fVar, z));
        bxVar.a(this.f.forumInfo.forumName, this.f.forumInfo.forumID);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        int al = TiebaApplication.g().al();
        if (z) {
            if (al == 1) {
                i4 = R.drawable.icon_brief_cancel_1;
            } else {
                i4 = R.drawable.icon_brief_cancel;
            }
            this.b.setTag(0);
            i2 = i4;
            i3 = R.string.forum_detail_fans_cancel;
        } else {
            if (al == 1) {
                i = R.drawable.icon_brief_attention_1;
            } else {
                i = R.drawable.icon_brief_attention;
            }
            this.b.setTag(1);
            i2 = i;
            i3 = R.string.forum_detail_fans;
        }
        this.d.setImageResource(i2);
        this.c.setText(this.a.getResources().getString(i3));
    }

    public void a(com.baidu.tieba.f fVar, int i) {
        fVar.getLayoutMode().a(i == 1);
        fVar.getLayoutMode().a((View) this);
    }

    public void a(com.baidu.tieba.f fVar) {
        Object tag;
        if (this.c != null && (tag = this.c.getTag()) != null && ((Integer) tag).intValue() == 2) {
            b(fVar);
        }
    }
}
