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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@SuppressLint({"UseSparseArrays"})
/* loaded from: classes3.dex */
public class a extends BaseAdapter implements View.OnClickListener {
    private static SparseArray<Integer> bpi = new SparseArray<>();
    private static HashMap<C0132a, Integer> bpj = new HashMap<>();
    private static HashMap<C0132a, Integer> bpk = new HashMap<>();
    private NewFriendsActivity bph;
    private b bpl;
    private List<com.baidu.tieba.im.data.a> data;

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i, int i2, View view, com.baidu.tieba.im.data.a aVar);
    }

    static {
        bpi.put(0, Integer.valueOf(d.j.add));
        bpi.put(4, Integer.valueOf(d.j.added));
        bpi.put(1, Integer.valueOf(d.j.pass));
        bpi.put(2, Integer.valueOf(d.j.passed));
        bpi.put(3, Integer.valueOf(d.j.waiting));
        bpj.put(new C0132a(false), Integer.valueOf(d.f.btn_pass));
        bpj.put(new C0132a(true), Integer.valueOf(d.f.btn_all_blue));
        bpk.put(new C0132a(false), Integer.valueOf(d.C0140d.btn_pass_text_color));
        bpk.put(new C0132a(true), Integer.valueOf(d.C0140d.btn_agree_text_color));
    }

    /* renamed from: com.baidu.tieba.addresslist.im.newFriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0132a {
        private boolean bpm;

        public C0132a(boolean z) {
            this.bpm = z;
        }

        public int hashCode() {
            return (this.bpm ? 1231 : 1237) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.bpm == ((C0132a) obj).bpm;
        }
    }

    public a(NewFriendsActivity newFriendsActivity) {
        this.bph = newFriendsActivity;
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
    /* renamed from: gE */
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
            cVar.bpn = (HeadImageView) view.findViewById(d.g.friend_icon);
            cVar.bpo = (TextView) view.findViewById(d.g.friend_name);
            cVar.bpp = (TextView) view.findViewById(d.g.friend_info);
            cVar.bpq = (TextView) view.findViewById(d.g.friend_add_btn);
            view.setTag(cVar);
        }
        com.baidu.tieba.im.data.a item = getItem(i);
        cVar.c(item);
        cVar.bpq.setTag(Integer.valueOf(i));
        cVar.bpq.setOnClickListener(this);
        this.bph.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.bph.getLayoutMode().onModeChanged(view);
        Integer num = bpj.get(new C0132a(item.getStatus() == 1));
        if (num != null) {
            am.i(cVar.bpq, num.intValue());
        }
        Integer num2 = bpk.get(new C0132a(item.getStatus() == 1));
        if (num2 != null) {
            am.c(cVar.bpq, num2.intValue(), 1);
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

    public void X(List<com.baidu.tieba.im.data.a> list) {
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
            int aI = aI(aVar.getId());
            if (aI != -1) {
                this.data.remove(aI);
                this.data.add(0, aVar);
                return;
            }
            this.data.add(0, aVar);
        }
    }

    private int aI(long j) {
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
        HeadImageView bpn;
        TextView bpo;
        TextView bpp;
        TextView bpq;

        private c() {
        }

        public void c(com.baidu.tieba.im.data.a aVar) {
            this.bpn.startLoad(aVar.getPortrait(), 12, false);
            this.bpo.setText(aVar.getName());
            if (!TextUtils.isEmpty(aVar.getContent())) {
                this.bpp.setText(aVar.getContent());
            } else {
                this.bpp.setText("");
            }
            int status = aVar.getStatus();
            this.bpq.setText(((Integer) a.bpi.get(status)).intValue());
            this.bpq.setEnabled(status == 0 || status == 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bpl != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.bpl.a(id, intValue, view, getItem(intValue));
        }
    }

    public void a(b bVar) {
        this.bpl = bVar;
    }
}
