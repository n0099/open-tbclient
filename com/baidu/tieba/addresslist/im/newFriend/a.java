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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@SuppressLint({"UseSparseArrays"})
/* loaded from: classes3.dex */
public class a extends BaseAdapter implements View.OnClickListener {
    private static SparseArray<Integer> beU = new SparseArray<>();
    private static HashMap<C0117a, Integer> beV = new HashMap<>();
    private static HashMap<C0117a, Integer> beW = new HashMap<>();
    private NewFriendsActivity beT;
    private b beX;
    private List<com.baidu.tieba.im.data.a> data;

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i, int i2, View view2, com.baidu.tieba.im.data.a aVar);
    }

    static {
        beU.put(0, Integer.valueOf(d.k.add));
        beU.put(4, Integer.valueOf(d.k.added));
        beU.put(1, Integer.valueOf(d.k.pass));
        beU.put(2, Integer.valueOf(d.k.passed));
        beU.put(3, Integer.valueOf(d.k.waiting));
        beV.put(new C0117a(false), Integer.valueOf(d.f.btn_pass));
        beV.put(new C0117a(true), Integer.valueOf(d.f.btn_all_blue));
        beW.put(new C0117a(false), Integer.valueOf(d.C0126d.btn_pass_text_color));
        beW.put(new C0117a(true), Integer.valueOf(d.C0126d.btn_agree_text_color));
    }

    /* renamed from: com.baidu.tieba.addresslist.im.newFriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0117a {
        private boolean beY;

        public C0117a(boolean z) {
            this.beY = z;
        }

        public int hashCode() {
            return (this.beY ? 1231 : 1237) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.beY == ((C0117a) obj).beY;
        }
    }

    public a(NewFriendsActivity newFriendsActivity) {
        this.beT = newFriendsActivity;
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
    /* renamed from: gw */
    public com.baidu.tieba.im.data.a getItem(int i) {
        return this.data.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        c cVar;
        if (view2 != null && view2.getTag() != null && (view2.getTag() instanceof c)) {
            cVar = (c) view2.getTag();
        } else {
            view2 = LayoutInflater.from(viewGroup.getContext()).inflate(d.i.add_new_friend_list_item, (ViewGroup) null);
            cVar = new c();
            cVar.beZ = (HeadImageView) view2.findViewById(d.g.friend_icon);
            cVar.bfa = (TextView) view2.findViewById(d.g.friend_name);
            cVar.bfc = (TextView) view2.findViewById(d.g.friend_info);
            cVar.bfd = (TextView) view2.findViewById(d.g.friend_add_btn);
            view2.setTag(cVar);
        }
        com.baidu.tieba.im.data.a item = getItem(i);
        cVar.c(item);
        cVar.bfd.setTag(Integer.valueOf(i));
        cVar.bfd.setOnClickListener(this);
        this.beT.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.beT.getLayoutMode().u(view2);
        Integer num = beV.get(new C0117a(item.getStatus() == 1));
        if (num != null) {
            ak.i(cVar.bfd, num.intValue());
        }
        Integer num2 = beW.get(new C0117a(item.getStatus() == 1));
        if (num2 != null) {
            ak.c(cVar.bfd, num2.intValue(), 1);
        }
        return view2;
    }

    public void setData(List<com.baidu.tieba.im.data.a> list) {
        this.data = list;
    }

    public synchronized void a(com.baidu.tieba.im.data.a aVar) {
        if (this.data != null) {
            this.data.remove(aVar);
        }
    }

    public void U(List<com.baidu.tieba.im.data.a> list) {
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
            int aA = aA(aVar.getId());
            if (aA != -1) {
                this.data.remove(aA);
                this.data.add(0, aVar);
                return;
            }
            this.data.add(0, aVar);
        }
    }

    private int aA(long j) {
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
        HeadImageView beZ;
        TextView bfa;
        TextView bfc;
        TextView bfd;

        private c() {
        }

        public void c(com.baidu.tieba.im.data.a aVar) {
            this.beZ.startLoad(aVar.getPortrait(), 12, false);
            this.bfa.setText(aVar.getName());
            if (!TextUtils.isEmpty(aVar.getContent())) {
                this.bfc.setText(aVar.getContent());
            } else {
                this.bfc.setText("");
            }
            int status = aVar.getStatus();
            this.bfd.setText(((Integer) a.beU.get(status)).intValue());
            this.bfd.setEnabled(status == 0 || status == 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.beX != null) {
            int id = view2.getId();
            int intValue = ((Integer) view2.getTag()).intValue();
            this.beX.a(id, intValue, view2, getItem(intValue));
        }
    }

    public void a(b bVar) {
        this.beX = bVar;
    }
}
