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
    private static SparseArray<Integer> cPi = new SparseArray<>();
    private static HashMap<C0258a, Integer> cPj = new HashMap<>();
    private static HashMap<C0258a, Integer> cPk = new HashMap<>();
    private NewFriendsActivity cPh;
    private b cPl;
    private List<com.baidu.tieba.im.data.a> data;

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i, int i2, View view, com.baidu.tieba.im.data.a aVar);
    }

    static {
        cPi.put(0, Integer.valueOf(d.j.add));
        cPi.put(4, Integer.valueOf(d.j.added));
        cPi.put(1, Integer.valueOf(d.j.pass));
        cPi.put(2, Integer.valueOf(d.j.passed));
        cPi.put(3, Integer.valueOf(d.j.waiting));
        cPj.put(new C0258a(false), Integer.valueOf(d.f.btn_pass));
        cPj.put(new C0258a(true), Integer.valueOf(d.f.btn_all_blue));
        cPk.put(new C0258a(false), Integer.valueOf(d.C0277d.btn_pass_text_color));
        cPk.put(new C0258a(true), Integer.valueOf(d.C0277d.btn_agree_text_color));
    }

    /* renamed from: com.baidu.tieba.addresslist.im.newFriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0258a {
        private boolean cPm;

        public C0258a(boolean z) {
            this.cPm = z;
        }

        public int hashCode() {
            return (this.cPm ? 1231 : 1237) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.cPm == ((C0258a) obj).cPm;
        }
    }

    public a(NewFriendsActivity newFriendsActivity) {
        this.cPh = newFriendsActivity;
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
            cVar.cPn = (HeadImageView) view.findViewById(d.g.friend_icon);
            cVar.cPo = (TextView) view.findViewById(d.g.friend_name);
            cVar.cPp = (TextView) view.findViewById(d.g.friend_info);
            cVar.cPq = (TextView) view.findViewById(d.g.friend_add_btn);
            view.setTag(cVar);
        }
        com.baidu.tieba.im.data.a item = getItem(i);
        cVar.c(item);
        cVar.cPq.setTag(Integer.valueOf(i));
        cVar.cPq.setOnClickListener(this);
        this.cPh.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.cPh.getLayoutMode().onModeChanged(view);
        Integer num = cPj.get(new C0258a(item.getStatus() == 1));
        if (num != null) {
            al.k(cVar.cPq, num.intValue());
        }
        Integer num2 = cPk.get(new C0258a(item.getStatus() == 1));
        if (num2 != null) {
            al.d(cVar.cPq, num2.intValue(), 1);
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
        HeadImageView cPn;
        TextView cPo;
        TextView cPp;
        TextView cPq;

        private c() {
        }

        public void c(com.baidu.tieba.im.data.a aVar) {
            this.cPn.startLoad(aVar.getPortrait(), 12, false);
            this.cPo.setText(aVar.getName());
            if (!TextUtils.isEmpty(aVar.getContent())) {
                this.cPp.setText(aVar.getContent());
            } else {
                this.cPp.setText("");
            }
            int status = aVar.getStatus();
            this.cPq.setText(((Integer) a.cPi.get(status)).intValue());
            this.cPq.setEnabled(status == 0 || status == 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cPl != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.cPl.a(id, intValue, view, getItem(intValue));
        }
    }

    public void a(b bVar) {
        this.cPl = bVar;
    }
}
