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
    private static SparseArray<Integer> cPf = new SparseArray<>();
    private static HashMap<C0258a, Integer> cPg = new HashMap<>();
    private static HashMap<C0258a, Integer> cPh = new HashMap<>();
    private NewFriendsActivity cPe;
    private b cPi;
    private List<com.baidu.tieba.im.data.a> data;

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i, int i2, View view, com.baidu.tieba.im.data.a aVar);
    }

    static {
        cPf.put(0, Integer.valueOf(d.j.add));
        cPf.put(4, Integer.valueOf(d.j.added));
        cPf.put(1, Integer.valueOf(d.j.pass));
        cPf.put(2, Integer.valueOf(d.j.passed));
        cPf.put(3, Integer.valueOf(d.j.waiting));
        cPg.put(new C0258a(false), Integer.valueOf(d.f.btn_pass));
        cPg.put(new C0258a(true), Integer.valueOf(d.f.btn_all_blue));
        cPh.put(new C0258a(false), Integer.valueOf(d.C0277d.btn_pass_text_color));
        cPh.put(new C0258a(true), Integer.valueOf(d.C0277d.btn_agree_text_color));
    }

    /* renamed from: com.baidu.tieba.addresslist.im.newFriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0258a {
        private boolean cPj;

        public C0258a(boolean z) {
            this.cPj = z;
        }

        public int hashCode() {
            return (this.cPj ? 1231 : 1237) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.cPj == ((C0258a) obj).cPj;
        }
    }

    public a(NewFriendsActivity newFriendsActivity) {
        this.cPe = newFriendsActivity;
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
    /* renamed from: lD */
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
            cVar.cPk = (HeadImageView) view.findViewById(d.g.friend_icon);
            cVar.cPl = (TextView) view.findViewById(d.g.friend_name);
            cVar.cPm = (TextView) view.findViewById(d.g.friend_info);
            cVar.cPn = (TextView) view.findViewById(d.g.friend_add_btn);
            view.setTag(cVar);
        }
        com.baidu.tieba.im.data.a item = getItem(i);
        cVar.c(item);
        cVar.cPn.setTag(Integer.valueOf(i));
        cVar.cPn.setOnClickListener(this);
        this.cPe.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.cPe.getLayoutMode().onModeChanged(view);
        Integer num = cPg.get(new C0258a(item.getStatus() == 1));
        if (num != null) {
            al.k(cVar.cPn, num.intValue());
        }
        Integer num2 = cPh.get(new C0258a(item.getStatus() == 1));
        if (num2 != null) {
            al.d(cVar.cPn, num2.intValue(), 1);
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
        HeadImageView cPk;
        TextView cPl;
        TextView cPm;
        TextView cPn;

        private c() {
        }

        public void c(com.baidu.tieba.im.data.a aVar) {
            this.cPk.startLoad(aVar.getPortrait(), 12, false);
            this.cPl.setText(aVar.getName());
            if (!TextUtils.isEmpty(aVar.getContent())) {
                this.cPm.setText(aVar.getContent());
            } else {
                this.cPm.setText("");
            }
            int status = aVar.getStatus();
            this.cPn.setText(((Integer) a.cPf.get(status)).intValue());
            this.cPn.setEnabled(status == 0 || status == 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cPi != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.cPi.a(id, intValue, view, getItem(intValue));
        }
    }

    public void a(b bVar) {
        this.cPi = bVar;
    }
}
