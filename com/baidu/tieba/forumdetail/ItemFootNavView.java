package com.baidu.tieba.forumdetail;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.forumdetail.ForumDetailActivity;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.model.ba;
import com.baidu.tieba.model.cp;
import com.baidu.tieba.switchs.SwitchKey;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ItemFootNavView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private Context f1211a;
    private ViewGroup b;
    private TextView c;
    private ViewGroup d;
    private ForumDetailData e;

    public ItemFootNavView(Context context) {
        super(context);
        a(context);
    }

    public ItemFootNavView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public void a(Context context) {
        this.f1211a = context;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.forum_detail_foot_nav, (ViewGroup) this, true);
        this.b = (ViewGroup) findViewById(R.id.fn_care_box);
        this.c = (TextView) findViewById(R.id.fn_care_btn);
        this.d = (ViewGroup) findViewById(R.id.fn_enter_box);
    }

    public boolean a(ForumDetailData forumDetailData, com.baidu.tieba.j jVar) {
        boolean equals = jVar.getIntent().getStringExtra("from_type").equals(ForumDetailActivity.FromType.FRS.toString());
        if (forumDetailData == null || forumDetailData.forumInfo == null) {
            return false;
        }
        this.e = forumDetailData;
        String str = forumDetailData.forumInfo.forumName;
        b(forumDetailData.forumInfo.isLike == 1);
        this.b.setOnClickListener(new f(this, jVar, equals));
        this.d.setOnClickListener(new g(this, equals, jVar, str));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.j jVar, boolean z) {
        ba baVar = new ba();
        baVar.a(SwitchKey.BAR_DETAIL_DIR);
        baVar.setLoadDataCallBack(new h(this, baVar, jVar, z));
        baVar.a(this.e.forumInfo.forumName, String.valueOf(this.e.forumInfo.forumID));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            FrsActivity.f1243a = !FrsActivity.f1243a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.j jVar, boolean z) {
        cp cpVar = new cp();
        cpVar.a(SwitchKey.BAR_DETAIL_DIR);
        cpVar.a(new i(this, jVar, z));
        cpVar.a(this.e.forumInfo.forumName, this.e.forumInfo.forumID);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        int i;
        int i2;
        int as = TiebaApplication.g().as();
        if (z) {
            if (as == 1) {
                i = R.drawable.icon_brief_cancel_1;
            } else {
                i = R.drawable.icon_brief_cancel;
            }
            i2 = R.string.forum_detail_fans_cancel;
            this.b.setTag(new Integer(1));
        } else {
            if (as == 1) {
                i = R.drawable.icon_brief_attention_1;
            } else {
                i = R.drawable.icon_brief_attention;
            }
            i2 = R.string.forum_detail_fans;
            this.b.setTag(new Integer(0));
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) this.f1211a.getResources().getDrawable(i);
        bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        this.c.setCompoundDrawables(bitmapDrawable, null, null, null);
        this.c.setText(this.f1211a.getResources().getString(i2));
    }
}
