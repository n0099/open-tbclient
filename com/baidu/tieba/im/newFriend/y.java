package com.baidu.tieba.im.newFriend;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@SuppressLint({"UseSparseArrays"})
/* loaded from: classes.dex */
public class y extends BaseAdapter implements View.OnClickListener {
    private static SparseArray<Integer> c = new SparseArray<>();
    private static HashMap<z, Integer> d = new HashMap<>();
    private static HashMap<z, Integer> e = new HashMap<>();
    private BaseActivity a;
    private List<com.baidu.tieba.im.data.k> b;
    private aa f;

    static {
        c.put(0, Integer.valueOf(com.baidu.tieba.y.add));
        c.put(4, Integer.valueOf(com.baidu.tieba.y.added));
        c.put(1, Integer.valueOf(com.baidu.tieba.y.pass));
        c.put(2, Integer.valueOf(com.baidu.tieba.y.passed));
        c.put(3, Integer.valueOf(com.baidu.tieba.y.waiting));
        d.put(new z(false, 0), Integer.valueOf(com.baidu.tieba.u.btn_pass));
        d.put(new z(false, 1), Integer.valueOf(com.baidu.tieba.u.btn_pass_1));
        d.put(new z(true, 0), Integer.valueOf(com.baidu.tieba.u.btn_agree));
        d.put(new z(true, 1), Integer.valueOf(com.baidu.tieba.u.btn_agree_1));
        e.put(new z(false, 0), Integer.valueOf(com.baidu.tieba.s.btn_pass_text_color));
        e.put(new z(false, 1), Integer.valueOf(com.baidu.tieba.s.btn_pass_text_color_1));
        e.put(new z(true, 0), Integer.valueOf(com.baidu.tieba.s.btn_agree_text_color));
        e.put(new z(true, 1), Integer.valueOf(com.baidu.tieba.s.btn_agree_text_color_1));
    }

    public y(BaseActivity baseActivity) {
        this.a = baseActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b == null) {
            return 0;
        }
        return this.b.size();
    }

    @Override // android.widget.Adapter
    /* renamed from: a */
    public com.baidu.tieba.im.data.k getItem(int i) {
        return this.b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ab abVar;
        if (view != null && view.getTag() != null && (view.getTag() instanceof ab)) {
            abVar = (ab) view.getTag();
        } else {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(com.baidu.tieba.w.add_new_friend_list_item, (ViewGroup) null);
            abVar = new ab(null);
            abVar.a = (HeadImageView) view.findViewById(com.baidu.tieba.v.friend_icon);
            abVar.b = (TextView) view.findViewById(com.baidu.tieba.v.friend_name);
            abVar.c = (TextView) view.findViewById(com.baidu.tieba.v.friend_info);
            abVar.d = (TextView) view.findViewById(com.baidu.tieba.v.friend_add_btn);
            view.setTag(abVar);
        }
        com.baidu.tieba.im.data.k item = getItem(i);
        abVar.a(item);
        abVar.d.setTag(Integer.valueOf(i));
        abVar.d.setOnClickListener(this);
        this.a.getLayoutMode().a(TbadkApplication.m252getInst().getSkinType() == 1);
        this.a.getLayoutMode().a(view);
        Integer num = d.get(new z(item.e() == 1, TbadkApplication.m252getInst().getSkinType()));
        if (num != null) {
            abVar.d.setBackgroundResource(num.intValue());
        }
        Integer num2 = e.get(new z(item.e() == 1, TbadkApplication.m252getInst().getSkinType()));
        if (num2 != null) {
            abVar.d.setTextColor(this.a.getResources().getColorStateList(num2.intValue()));
        }
        return view;
    }

    public void a(List<com.baidu.tieba.im.data.k> list) {
        this.b = list;
    }

    public synchronized void a(com.baidu.tieba.im.data.k kVar) {
        if (this.b != null) {
            this.b.remove(kVar);
        }
    }

    public void b(List<com.baidu.tieba.im.data.k> list) {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        if (list != null) {
            for (com.baidu.tieba.im.data.k kVar : list) {
                b(kVar);
            }
        }
    }

    public void b(com.baidu.tieba.im.data.k kVar) {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        if (kVar != null && kVar.a() != 0) {
            int a = a(kVar.a());
            if (a != -1) {
                this.b.set(a, kVar);
            } else {
                this.b.add(0, kVar);
            }
        }
    }

    private int a(long j) {
        if (this.b != null) {
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                if (j == this.b.get(i).a()) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.f.a(id, intValue, view, getItem(intValue));
        }
    }

    public void a(aa aaVar) {
        this.f = aaVar;
    }
}
