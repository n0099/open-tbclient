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
    private static SparseArray<Integer> bnc = new SparseArray<>();
    private static HashMap<C0133a, Integer> bnd = new HashMap<>();
    private static HashMap<C0133a, Integer> bne = new HashMap<>();
    private NewFriendsActivity bnb;
    private b bnf;
    private List<com.baidu.tieba.im.data.a> data;

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i, int i2, View view, com.baidu.tieba.im.data.a aVar);
    }

    static {
        bnc.put(0, Integer.valueOf(d.k.add));
        bnc.put(4, Integer.valueOf(d.k.added));
        bnc.put(1, Integer.valueOf(d.k.pass));
        bnc.put(2, Integer.valueOf(d.k.passed));
        bnc.put(3, Integer.valueOf(d.k.waiting));
        bnd.put(new C0133a(false), Integer.valueOf(d.f.btn_pass));
        bnd.put(new C0133a(true), Integer.valueOf(d.f.btn_all_blue));
        bne.put(new C0133a(false), Integer.valueOf(d.C0141d.btn_pass_text_color));
        bne.put(new C0133a(true), Integer.valueOf(d.C0141d.btn_agree_text_color));
    }

    /* renamed from: com.baidu.tieba.addresslist.im.newFriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0133a {
        private boolean bng;

        public C0133a(boolean z) {
            this.bng = z;
        }

        public int hashCode() {
            return (this.bng ? 1231 : 1237) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.bng == ((C0133a) obj).bng;
        }
    }

    public a(NewFriendsActivity newFriendsActivity) {
        this.bnb = newFriendsActivity;
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
    /* renamed from: gx */
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.i.add_new_friend_list_item, (ViewGroup) null);
            cVar = new c();
            cVar.bnh = (HeadImageView) view.findViewById(d.g.friend_icon);
            cVar.bni = (TextView) view.findViewById(d.g.friend_name);
            cVar.bnj = (TextView) view.findViewById(d.g.friend_info);
            cVar.bnk = (TextView) view.findViewById(d.g.friend_add_btn);
            view.setTag(cVar);
        }
        com.baidu.tieba.im.data.a item = getItem(i);
        cVar.c(item);
        cVar.bnk.setTag(Integer.valueOf(i));
        cVar.bnk.setOnClickListener(this);
        this.bnb.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.bnb.getLayoutMode().onModeChanged(view);
        Integer num = bnd.get(new C0133a(item.getStatus() == 1));
        if (num != null) {
            al.i(cVar.bnk, num.intValue());
        }
        Integer num2 = bne.get(new C0133a(item.getStatus() == 1));
        if (num2 != null) {
            al.c(cVar.bnk, num2.intValue(), 1);
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
            int aE = aE(aVar.getId());
            if (aE != -1) {
                this.data.remove(aE);
                this.data.add(0, aVar);
                return;
            }
            this.data.add(0, aVar);
        }
    }

    private int aE(long j) {
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
        HeadImageView bnh;
        TextView bni;
        TextView bnj;
        TextView bnk;

        private c() {
        }

        public void c(com.baidu.tieba.im.data.a aVar) {
            this.bnh.startLoad(aVar.getPortrait(), 12, false);
            this.bni.setText(aVar.getName());
            if (!TextUtils.isEmpty(aVar.getContent())) {
                this.bnj.setText(aVar.getContent());
            } else {
                this.bnj.setText("");
            }
            int status = aVar.getStatus();
            this.bnk.setText(((Integer) a.bnc.get(status)).intValue());
            this.bnk.setEnabled(status == 0 || status == 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bnf != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.bnf.a(id, intValue, view, getItem(intValue));
        }
    }

    public void a(b bVar) {
        this.bnf = bVar;
    }
}
