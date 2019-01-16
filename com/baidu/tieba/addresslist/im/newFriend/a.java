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
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@SuppressLint({"UseSparseArrays"})
/* loaded from: classes3.dex */
public class a extends BaseAdapter implements View.OnClickListener {
    private static SparseArray<Integer> bEa = new SparseArray<>();
    private static HashMap<C0190a, Integer> bEb = new HashMap<>();
    private static HashMap<C0190a, Integer> bEc = new HashMap<>();
    private NewFriendsActivity bDZ;
    private b bEd;
    private List<com.baidu.tieba.im.data.a> data;

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i, int i2, View view, com.baidu.tieba.im.data.a aVar);
    }

    static {
        bEa.put(0, Integer.valueOf(e.j.add));
        bEa.put(4, Integer.valueOf(e.j.added));
        bEa.put(1, Integer.valueOf(e.j.pass));
        bEa.put(2, Integer.valueOf(e.j.passed));
        bEa.put(3, Integer.valueOf(e.j.waiting));
        bEb.put(new C0190a(false), Integer.valueOf(e.f.btn_pass));
        bEb.put(new C0190a(true), Integer.valueOf(e.f.btn_all_blue));
        bEc.put(new C0190a(false), Integer.valueOf(e.d.btn_pass_text_color));
        bEc.put(new C0190a(true), Integer.valueOf(e.d.btn_agree_text_color));
    }

    /* renamed from: com.baidu.tieba.addresslist.im.newFriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0190a {
        private boolean bEe;

        public C0190a(boolean z) {
            this.bEe = z;
        }

        public int hashCode() {
            return (this.bEe ? 1231 : 1237) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.bEe == ((C0190a) obj).bEe;
        }
    }

    public a(NewFriendsActivity newFriendsActivity) {
        this.bDZ = newFriendsActivity;
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
    /* renamed from: hN */
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(e.h.add_new_friend_list_item, (ViewGroup) null);
            cVar = new c();
            cVar.bEf = (HeadImageView) view.findViewById(e.g.friend_icon);
            cVar.bEg = (TextView) view.findViewById(e.g.friend_name);
            cVar.bEh = (TextView) view.findViewById(e.g.friend_info);
            cVar.bEi = (TextView) view.findViewById(e.g.friend_add_btn);
            view.setTag(cVar);
        }
        com.baidu.tieba.im.data.a item = getItem(i);
        cVar.c(item);
        cVar.bEi.setTag(Integer.valueOf(i));
        cVar.bEi.setOnClickListener(this);
        this.bDZ.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.bDZ.getLayoutMode().onModeChanged(view);
        Integer num = bEb.get(new C0190a(item.getStatus() == 1));
        if (num != null) {
            al.i(cVar.bEi, num.intValue());
        }
        Integer num2 = bEc.get(new C0190a(item.getStatus() == 1));
        if (num2 != null) {
            al.c(cVar.bEi, num2.intValue(), 1);
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

    public void ah(List<com.baidu.tieba.im.data.a> list) {
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
            int aY = aY(aVar.getId());
            if (aY != -1) {
                this.data.remove(aY);
                this.data.add(0, aVar);
                return;
            }
            this.data.add(0, aVar);
        }
    }

    private int aY(long j) {
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
        HeadImageView bEf;
        TextView bEg;
        TextView bEh;
        TextView bEi;

        private c() {
        }

        public void c(com.baidu.tieba.im.data.a aVar) {
            this.bEf.startLoad(aVar.getPortrait(), 12, false);
            this.bEg.setText(aVar.getName());
            if (!TextUtils.isEmpty(aVar.getContent())) {
                this.bEh.setText(aVar.getContent());
            } else {
                this.bEh.setText("");
            }
            int status = aVar.getStatus();
            this.bEi.setText(((Integer) a.bEa.get(status)).intValue());
            this.bEi.setEnabled(status == 0 || status == 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bEd != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.bEd.a(id, intValue, view, getItem(intValue));
        }
    }

    public void a(b bVar) {
        this.bEd = bVar;
    }
}
