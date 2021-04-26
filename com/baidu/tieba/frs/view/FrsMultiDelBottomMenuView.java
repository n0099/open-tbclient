package com.baidu.tieba.frs.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import d.a.i0.r.q.a2;
import d.a.i0.r.q.v0;
import d.a.j0.h.e;
import d.a.j0.h.f;
import d.a.j0.q0.b;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes4.dex */
public class FrsMultiDelBottomMenuView extends RelativeLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public final e f16641e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f16642f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16643g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16644h;

    /* renamed from: i  reason: collision with root package name */
    public View f16645i;
    public View j;
    public f k;
    public TbPageContext l;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public void a() {
        f fVar = this.k;
        if (fVar == null) {
            return;
        }
        fVar.p();
    }

    public void b() {
        f fVar = this.k;
        if (fVar == null) {
            return;
        }
        fVar.q();
    }

    public final void c() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_multi_delete_menu_layout, this);
        TextView textView = (TextView) findViewById(R.id.multi_del_cancel_btn);
        this.f16642f = textView;
        textView.setText(R.string.cancel);
        TextView textView2 = (TextView) findViewById(R.id.multi_del_btn);
        this.f16643g = textView2;
        textView2.setText(R.string.delete);
        TextView textView3 = (TextView) findViewById(R.id.multi_del_forbidden_btn);
        this.f16644h = textView3;
        textView3.setText(R.string.delete_and_forbidden_one_day);
        this.f16645i = findViewById(R.id.divider_top_line);
        this.j = findViewById(R.id.divider);
        this.f16642f.setOnClickListener(this);
        this.f16643g.setOnClickListener(this);
        this.f16644h.setOnClickListener(this);
        d();
        setClickable(true);
    }

    public void d() {
        SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.f16642f, R.color.CAM_X0105);
        SkinManager.setBackgroundResource(this.f16642f, R.drawable.bg_bottom_up_list_dialog_item);
        SkinManager.setViewTextColor(this.f16644h, R.color.CAM_X0105);
        SkinManager.setBackgroundResource(this.f16644h, R.drawable.bg_bottom_up_list_dialog_item);
        SkinManager.setViewTextColor(this.f16643g, R.color.CAM_X0301);
        SkinManager.setBackgroundResource(this.f16643g, R.drawable.bg_bottom_up_list_dialog_item);
        SkinManager.setBackgroundColor(this.f16645i, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.j, R.color.CAM_X0204);
    }

    public void e() {
        e eVar = this.f16641e;
        if (eVar != null) {
            eVar.f(null);
            this.f16641e.d();
        }
    }

    public final void f(String str) {
        TbPageContext tbPageContext = this.l;
        if (tbPageContext == null) {
            return;
        }
        if (this.k == null) {
            this.k = new f(tbPageContext, this);
        }
        this.k.z(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f16641e.e();
        if (view == this.f16642f) {
            b.e().k();
        } else if (view == this.f16643g) {
            if (ListUtils.isEmpty(b.e().f())) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13122").param("obj_type", 1));
            setData(1);
            f("2");
        } else if (view != this.f16644h || ListUtils.isEmpty(b.e().f())) {
        } else {
            TiebaStatic.log(new StatisticItem("c13122").param("obj_type", 2));
            setData(2);
            f("2");
        }
    }

    public void setData(int i2) {
        TbPageContext tbPageContext = this.l;
        if (tbPageContext == null) {
            return;
        }
        if (this.k == null) {
            this.k = new f(tbPageContext, this);
        }
        SparseArray<String> sparseArray = new SparseArray<>();
        AntiData c2 = b.e().c();
        if (c2 != null && c2.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = c2.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        JSONArray jSONArray = new JSONArray();
        List<a2> f2 = b.e().f();
        for (int i4 = 0; i4 < f2.size(); i4++) {
            jSONArray.put(f2.get(i4).w1());
        }
        v0 v0Var = new v0();
        v0Var.j(sparseArray);
        v0Var.i(i2);
        v0Var.o(jSONArray);
        v0Var.l(b.e().d());
        this.k.x(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
        this.k.w(v0Var);
    }

    public void setDeleteCallback(e.c cVar) {
        e eVar = this.f16641e;
        if (eVar == null) {
            return;
        }
        eVar.f(cVar);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.l = tbPageContext;
    }

    public void setSelectNumber(int i2) {
        String string = getContext().getString(R.string.delete);
        if (i2 > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i2));
        }
        this.f16643g.setText(string);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
        this.f16641e = new e("0");
    }
}
