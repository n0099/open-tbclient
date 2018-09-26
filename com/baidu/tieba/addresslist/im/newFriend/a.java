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
    private static SparseArray<Integer> bva = new SparseArray<>();
    private static HashMap<C0132a, Integer> bvb = new HashMap<>();
    private static HashMap<C0132a, Integer> bvc = new HashMap<>();
    private NewFriendsActivity buZ;
    private b bvd;
    private List<com.baidu.tieba.im.data.a> data;

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i, int i2, View view, com.baidu.tieba.im.data.a aVar);
    }

    static {
        bva.put(0, Integer.valueOf(e.j.add));
        bva.put(4, Integer.valueOf(e.j.added));
        bva.put(1, Integer.valueOf(e.j.pass));
        bva.put(2, Integer.valueOf(e.j.passed));
        bva.put(3, Integer.valueOf(e.j.waiting));
        bvb.put(new C0132a(false), Integer.valueOf(e.f.btn_pass));
        bvb.put(new C0132a(true), Integer.valueOf(e.f.btn_all_blue));
        bvc.put(new C0132a(false), Integer.valueOf(e.d.btn_pass_text_color));
        bvc.put(new C0132a(true), Integer.valueOf(e.d.btn_agree_text_color));
    }

    /* renamed from: com.baidu.tieba.addresslist.im.newFriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0132a {
        private boolean bve;

        public C0132a(boolean z) {
            this.bve = z;
        }

        public int hashCode() {
            return (this.bve ? 1231 : 1237) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.bve == ((C0132a) obj).bve;
        }
    }

    public a(NewFriendsActivity newFriendsActivity) {
        this.buZ = newFriendsActivity;
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
    /* renamed from: hd */
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
            cVar.bvf = (HeadImageView) view.findViewById(e.g.friend_icon);
            cVar.bvg = (TextView) view.findViewById(e.g.friend_name);
            cVar.bvh = (TextView) view.findViewById(e.g.friend_info);
            cVar.bvi = (TextView) view.findViewById(e.g.friend_add_btn);
            view.setTag(cVar);
        }
        com.baidu.tieba.im.data.a item = getItem(i);
        cVar.c(item);
        cVar.bvi.setTag(Integer.valueOf(i));
        cVar.bvi.setOnClickListener(this);
        this.buZ.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.buZ.getLayoutMode().onModeChanged(view);
        Integer num = bvb.get(new C0132a(item.getStatus() == 1));
        if (num != null) {
            al.i(cVar.bvi, num.intValue());
        }
        Integer num2 = bvc.get(new C0132a(item.getStatus() == 1));
        if (num2 != null) {
            al.c(cVar.bvi, num2.intValue(), 1);
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

    public void Y(List<com.baidu.tieba.im.data.a> list) {
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
            int aM = aM(aVar.getId());
            if (aM != -1) {
                this.data.remove(aM);
                this.data.add(0, aVar);
                return;
            }
            this.data.add(0, aVar);
        }
    }

    private int aM(long j) {
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
        HeadImageView bvf;
        TextView bvg;
        TextView bvh;
        TextView bvi;

        private c() {
        }

        public void c(com.baidu.tieba.im.data.a aVar) {
            this.bvf.startLoad(aVar.getPortrait(), 12, false);
            this.bvg.setText(aVar.getName());
            if (!TextUtils.isEmpty(aVar.getContent())) {
                this.bvh.setText(aVar.getContent());
            } else {
                this.bvh.setText("");
            }
            int status = aVar.getStatus();
            this.bvi.setText(((Integer) a.bva.get(status)).intValue());
            this.bvi.setEnabled(status == 0 || status == 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bvd != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.bvd.a(id, intValue, view, getItem(intValue));
        }
    }

    public void a(b bVar) {
        this.bvd = bVar;
    }
}
