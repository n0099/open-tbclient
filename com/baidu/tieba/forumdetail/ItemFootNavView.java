package com.baidu.tieba.forumdetail;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.forumdetail.ForumDetailActivity;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.model.ax;
import com.baidu.tieba.model.cj;
import com.baidu.tieba.switchs.SwitchKey;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ItemFootNavView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private Context f1321a;
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
        this.f1321a = context;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.forum_detail_foot_nav, (ViewGroup) this, true);
        this.b = (ViewGroup) findViewById(R.id.fn_care_box);
        this.c = (TextView) findViewById(R.id.fn_care_btn);
        this.d = (ImageView) findViewById(R.id.icon_brief_care);
        this.e = (ViewGroup) findViewById(R.id.fn_enter_box);
    }

    public boolean a(ForumDetailData forumDetailData, com.baidu.tieba.j jVar) {
        this.g = jVar.getIntent().getStringExtra("from_type").equals(ForumDetailActivity.FromType.FRS.toString());
        if (forumDetailData == null || forumDetailData.forumInfo == null) {
            return false;
        }
        this.f = forumDetailData;
        String str = forumDetailData.forumInfo.forumName;
        b(forumDetailData.forumInfo.isLike == 1);
        this.b.setOnClickListener(new f(this, jVar));
        this.e.setOnClickListener(new g(this, jVar, str));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.j jVar) {
        boolean z = (TiebaApplication.B() == null || TiebaApplication.G() == null) ? false : true;
        Object tag = this.c.getTag();
        boolean z2 = (tag == null || ((Integer) tag).intValue() != 2) ? true : true;
        if (!z && !z2) {
            this.c.setTag(new Integer(2));
            LoginActivity.a((Activity) jVar, getResources().getString(R.string.login_to_use), true, 11034);
            return;
        }
        this.c.setTag(new Integer(3));
        int intValue = ((Integer) this.b.getTag()).intValue();
        if (intValue == 0) {
            b(jVar, this.g);
        } else if (intValue == 1) {
            a(jVar, this.g);
        }
        if (TiebaApplication.h().t()) {
            StatService.onEvent(this.f1321a, intValue == 1 ? "detail_care_add" : "detail_care_cancel", "click", 1);
        }
    }

    private void a(com.baidu.tieba.j jVar, boolean z) {
        ax axVar = new ax();
        axVar.a(SwitchKey.BAR_DETAIL_DIR);
        axVar.setLoadDataCallBack(new h(this, axVar, jVar, z));
        axVar.a(this.f.forumInfo.forumName, String.valueOf(this.f.forumInfo.forumID));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            FrsActivity.f1356a = !FrsActivity.f1356a;
        }
    }

    private void b(com.baidu.tieba.j jVar, boolean z) {
        cj cjVar = new cj();
        cjVar.a(SwitchKey.BAR_DETAIL_DIR);
        cjVar.a(new i(this, jVar, z));
        cjVar.a(this.f.forumInfo.forumName, this.f.forumInfo.forumID);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        int an = TiebaApplication.h().an();
        if (z) {
            if (an == 1) {
                i4 = R.drawable.icon_brief_cancel_1;
            } else {
                i4 = R.drawable.icon_brief_cancel;
            }
            this.b.setTag(new Integer(0));
            i2 = i4;
            i3 = R.string.forum_detail_fans_cancel;
        } else {
            if (an == 1) {
                i = R.drawable.icon_brief_attention_1;
            } else {
                i = R.drawable.icon_brief_attention;
            }
            this.b.setTag(new Integer(1));
            i2 = i;
            i3 = R.string.forum_detail_fans;
        }
        this.d.setImageResource(i2);
        this.c.setText(this.f1321a.getResources().getString(i3));
    }

    public void a(com.baidu.tieba.j jVar, int i) {
        jVar.getLayoutMode().a(i == 1);
        jVar.getLayoutMode().a(this);
    }

    public void a(com.baidu.tieba.j jVar) {
        Object tag;
        if (this.c != null && (tag = this.c.getTag()) != null && ((Integer) tag).intValue() == 2) {
            b(jVar);
        }
    }
}
