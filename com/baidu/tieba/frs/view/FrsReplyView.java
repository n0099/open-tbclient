package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.FrsPostListData;
import com.baidu.tieba.view.FrsCommonImageLayout;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FrsReplyView extends LinearLayout {
    private Context a;
    private View b;
    private LinearLayout c;
    private TextView d;
    private TextView e;
    private FrsCommonImageLayout f;
    private FrsPostListData g;
    private com.baidu.tbadk.core.data.o h;
    private boolean i;
    private boolean j;
    private String k;
    private String l;
    private String m;

    public FrsReplyView(Context context) {
        this(context, null);
    }

    public FrsReplyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = context;
        this.b = View.inflate(this.a, com.baidu.tieba.a.i.frs_item_reply, this);
        this.c = (LinearLayout) this.b.findViewById(com.baidu.tieba.a.h.frs_item_reply_view);
        this.e = (TextView) this.b.findViewById(com.baidu.tieba.a.h.frs_item_reply_abstract);
        this.d = (TextView) this.b.findViewById(com.baidu.tieba.a.h.frs_item_reply_author);
        this.f = (FrsCommonImageLayout) this.b.findViewById(com.baidu.tieba.a.h.frs_item_reply_img);
        this.d.setOnClickListener(new m(this));
    }

    public final void a(FrsPostListData frsPostListData, com.baidu.tbadk.core.data.o oVar, boolean z, boolean z2, String str, String str2, String str3) {
        int i = 0;
        if (frsPostListData != null) {
            this.h = oVar;
            this.g = frsPostListData;
            this.i = z;
            this.j = z2;
            this.k = str;
            this.l = str2;
            this.m = str3;
            ArrayList<com.baidu.tbadk.core.data.j> arrayList = this.g.getmMedias();
            this.d.setText(String.valueOf(this.g.getAuthor().getName_show()) + ": ");
            this.e.setText(this.g.getAbstract_text());
            if (!com.baidu.tbadk.core.h.a().f()) {
                this.f.setVisibility(8);
            } else if (arrayList != null) {
                if (arrayList.size() <= 0) {
                    this.f.setVisibility(8);
                    return;
                }
                int i2 = 0;
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    if (arrayList.get(i3) != null && (arrayList.get(i3).b() == 3 || arrayList.get(i3).b() == 5)) {
                        i2++;
                    }
                }
                if (i2 > 0) {
                    com.baidu.tbadk.core.data.j[] jVarArr = new com.baidu.tbadk.core.data.j[i2];
                    for (int i4 = 0; i4 < arrayList.size() && i < i2; i4++) {
                        if (arrayList.get(i4).b() == 3 || arrayList.get(i4).b() == 5) {
                            jVarArr[i] = arrayList.get(i4);
                            i++;
                        }
                    }
                    this.f.setShowBig(this.i);
                    this.f.setItemSize(50);
                    this.f.a(jVarArr, arrayList.size());
                    FrsCommonImageLayout frsCommonImageLayout = this.f;
                    com.baidu.tbadk.core.data.o oVar2 = this.h;
                    frsCommonImageLayout.a(this.k, this.l, this.m);
                    this.f.setImageFrom("other");
                    this.f.setFromCDN(this.j);
                }
            }
        }
    }

    public final void a(int i) {
        if (i == 1) {
            this.d.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.cp_link_tip_c_1));
            this.e.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.cp_cont_b_1));
            return;
        }
        this.d.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.cp_link_tip_c));
        this.e.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.cp_cont_b));
    }
}
