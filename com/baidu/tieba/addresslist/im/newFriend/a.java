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
    private static SparseArray<Integer> bzc = new SparseArray<>();
    private static HashMap<C0156a, Integer> bzd = new HashMap<>();
    private static HashMap<C0156a, Integer> bze = new HashMap<>();
    private NewFriendsActivity bzb;
    private b bzf;
    private List<com.baidu.tieba.im.data.a> data;

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i, int i2, View view, com.baidu.tieba.im.data.a aVar);
    }

    static {
        bzc.put(0, Integer.valueOf(e.j.add));
        bzc.put(4, Integer.valueOf(e.j.added));
        bzc.put(1, Integer.valueOf(e.j.pass));
        bzc.put(2, Integer.valueOf(e.j.passed));
        bzc.put(3, Integer.valueOf(e.j.waiting));
        bzd.put(new C0156a(false), Integer.valueOf(e.f.btn_pass));
        bzd.put(new C0156a(true), Integer.valueOf(e.f.btn_all_blue));
        bze.put(new C0156a(false), Integer.valueOf(e.d.btn_pass_text_color));
        bze.put(new C0156a(true), Integer.valueOf(e.d.btn_agree_text_color));
    }

    /* renamed from: com.baidu.tieba.addresslist.im.newFriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0156a {
        private boolean bzg;

        public C0156a(boolean z) {
            this.bzg = z;
        }

        public int hashCode() {
            return (this.bzg ? 1231 : 1237) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.bzg == ((C0156a) obj).bzg;
        }
    }

    public a(NewFriendsActivity newFriendsActivity) {
        this.bzb = newFriendsActivity;
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
    /* renamed from: hl */
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
            cVar.bzh = (HeadImageView) view.findViewById(e.g.friend_icon);
            cVar.bzi = (TextView) view.findViewById(e.g.friend_name);
            cVar.bzj = (TextView) view.findViewById(e.g.friend_info);
            cVar.bzk = (TextView) view.findViewById(e.g.friend_add_btn);
            view.setTag(cVar);
        }
        com.baidu.tieba.im.data.a item = getItem(i);
        cVar.c(item);
        cVar.bzk.setTag(Integer.valueOf(i));
        cVar.bzk.setOnClickListener(this);
        this.bzb.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.bzb.getLayoutMode().onModeChanged(view);
        Integer num = bzd.get(new C0156a(item.getStatus() == 1));
        if (num != null) {
            al.i(cVar.bzk, num.intValue());
        }
        Integer num2 = bze.get(new C0156a(item.getStatus() == 1));
        if (num2 != null) {
            al.c(cVar.bzk, num2.intValue(), 1);
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
            int aO = aO(aVar.getId());
            if (aO != -1) {
                this.data.remove(aO);
                this.data.add(0, aVar);
                return;
            }
            this.data.add(0, aVar);
        }
    }

    private int aO(long j) {
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
        HeadImageView bzh;
        TextView bzi;
        TextView bzj;
        TextView bzk;

        private c() {
        }

        public void c(com.baidu.tieba.im.data.a aVar) {
            this.bzh.startLoad(aVar.getPortrait(), 12, false);
            this.bzi.setText(aVar.getName());
            if (!TextUtils.isEmpty(aVar.getContent())) {
                this.bzj.setText(aVar.getContent());
            } else {
                this.bzj.setText("");
            }
            int status = aVar.getStatus();
            this.bzk.setText(((Integer) a.bzc.get(status)).intValue());
            this.bzk.setEnabled(status == 0 || status == 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bzf != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.bzf.a(id, intValue, view, getItem(intValue));
        }
    }

    public void a(b bVar) {
        this.bzf = bVar;
    }
}
