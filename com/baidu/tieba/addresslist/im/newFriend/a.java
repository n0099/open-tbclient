package com.baidu.tieba.addresslist.im.newFriend;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@SuppressLint({"UseSparseArrays"})
/* loaded from: classes3.dex */
public class a extends BaseAdapter implements View.OnClickListener {
    private static SparseArray<Integer> cPh = new SparseArray<>();
    private static HashMap<C0258a, Integer> cPi = new HashMap<>();
    private static HashMap<C0258a, Integer> cPj = new HashMap<>();
    private NewFriendsActivity cPg;
    private b cPk;
    private List<com.baidu.tieba.im.data.a> data;

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i, int i2, View view, com.baidu.tieba.im.data.a aVar);
    }

    static {
        cPh.put(0, Integer.valueOf(d.j.add));
        cPh.put(4, Integer.valueOf(d.j.added));
        cPh.put(1, Integer.valueOf(d.j.pass));
        cPh.put(2, Integer.valueOf(d.j.passed));
        cPh.put(3, Integer.valueOf(d.j.waiting));
        cPi.put(new C0258a(false), Integer.valueOf(d.f.btn_pass));
        cPi.put(new C0258a(true), Integer.valueOf(d.f.btn_all_blue));
        cPj.put(new C0258a(false), Integer.valueOf(d.C0277d.btn_pass_text_color));
        cPj.put(new C0258a(true), Integer.valueOf(d.C0277d.btn_agree_text_color));
    }

    /* renamed from: com.baidu.tieba.addresslist.im.newFriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0258a {
        private boolean cPl;

        public C0258a(boolean z) {
            this.cPl = z;
        }

        public int hashCode() {
            return (this.cPl ? 1231 : 1237) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.cPl == ((C0258a) obj).cPl;
        }
    }

    public a(NewFriendsActivity newFriendsActivity) {
        this.cPg = newFriendsActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.data == null) {
            return 0;
        }
        return this.data.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: lC */
    public com.baidu.tieba.im.data.a getItem(int i) {
        return this.data.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        if (view != null && view.getTag() != null && (view.getTag() instanceof c)) {
            cVar = (c) view.getTag();
        } else {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.add_new_friend_list_item, (ViewGroup) null);
            cVar = new c();
            cVar.cPm = (HeadImageView) view.findViewById(d.g.friend_icon);
            cVar.cPn = (TextView) view.findViewById(d.g.friend_name);
            cVar.cPo = (TextView) view.findViewById(d.g.friend_info);
            cVar.cPp = (TextView) view.findViewById(d.g.friend_add_btn);
            view.setTag(cVar);
        }
        com.baidu.tieba.im.data.a item = getItem(i);
        cVar.c(item);
        cVar.cPp.setTag(Integer.valueOf(i));
        cVar.cPp.setOnClickListener(this);
        this.cPg.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.cPg.getLayoutMode().onModeChanged(view);
        Integer num = cPi.get(new C0258a(item.getStatus() == 1));
        if (num != null) {
            al.k(cVar.cPp, num.intValue());
        }
        Integer num2 = cPj.get(new C0258a(item.getStatus() == 1));
        if (num2 != null) {
            al.d(cVar.cPp, num2.intValue(), 1);
        }
        return view;
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.data = list;
    }

    public synchronized void a(com.baidu.tieba.im.data.a aVar) {
        if (this.data != null) {
            this.data.remove(aVar);
        }
    }

    public void au(List<com.baidu.tieba.im.data.a> list) {
        if (this.data == null) {
            this.data = new ArrayList();
        }
        if (list != null) {
            for (com.baidu.tieba.im.data.a aVar : list) {
                b(aVar);
            }
        }
    }

    public void b(com.baidu.tieba.im.data.a aVar) {
        if (this.data == null) {
            this.data = new ArrayList();
        }
        if (aVar != null && aVar.getId() != 0) {
            int bA = bA(aVar.getId());
            if (bA != -1) {
                this.data.remove(bA);
                this.data.add(0, aVar);
                return;
            }
            this.data.add(0, aVar);
        }
    }

    private int bA(long j) {
        if (this.data != null) {
            int size = this.data.size();
            for (int i = 0; i < size; i++) {
                if (j == this.data.get(i).getId()) {
                    return i;
                }
            }
        }
        return -1;
    }

    /* loaded from: classes3.dex */
    private static class c {
        HeadImageView cPm;
        TextView cPn;
        TextView cPo;
        TextView cPp;

        private c() {
        }

        public void c(com.baidu.tieba.im.data.a aVar) {
            this.cPm.startLoad(aVar.getPortrait(), 12, false);
            this.cPn.setText(aVar.getName());
            if (!TextUtils.isEmpty(aVar.getContent())) {
                this.cPo.setText(aVar.getContent());
            } else {
                this.cPo.setText("");
            }
            int status = aVar.getStatus();
            this.cPp.setText(((Integer) a.cPh.get(status)).intValue());
            this.cPp.setEnabled(status == 0 || status == 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cPk != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.cPk.a(id, intValue, view, getItem(intValue));
        }
    }

    public void a(b bVar) {
        this.cPk = bVar;
    }
}
