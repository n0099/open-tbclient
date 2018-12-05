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
    private static SparseArray<Integer> bDk = new SparseArray<>();
    private static HashMap<C0190a, Integer> bDl = new HashMap<>();
    private static HashMap<C0190a, Integer> bDm = new HashMap<>();
    private NewFriendsActivity bDj;
    private b bDn;
    private List<com.baidu.tieba.im.data.a> data;

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i, int i2, View view, com.baidu.tieba.im.data.a aVar);
    }

    static {
        bDk.put(0, Integer.valueOf(e.j.add));
        bDk.put(4, Integer.valueOf(e.j.added));
        bDk.put(1, Integer.valueOf(e.j.pass));
        bDk.put(2, Integer.valueOf(e.j.passed));
        bDk.put(3, Integer.valueOf(e.j.waiting));
        bDl.put(new C0190a(false), Integer.valueOf(e.f.btn_pass));
        bDl.put(new C0190a(true), Integer.valueOf(e.f.btn_all_blue));
        bDm.put(new C0190a(false), Integer.valueOf(e.d.btn_pass_text_color));
        bDm.put(new C0190a(true), Integer.valueOf(e.d.btn_agree_text_color));
    }

    /* renamed from: com.baidu.tieba.addresslist.im.newFriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0190a {
        private boolean bDo;

        public C0190a(boolean z) {
            this.bDo = z;
        }

        public int hashCode() {
            return (this.bDo ? 1231 : 1237) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.bDo == ((C0190a) obj).bDo;
        }
    }

    public a(NewFriendsActivity newFriendsActivity) {
        this.bDj = newFriendsActivity;
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
    /* renamed from: hM */
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
            cVar.bDp = (HeadImageView) view.findViewById(e.g.friend_icon);
            cVar.bDq = (TextView) view.findViewById(e.g.friend_name);
            cVar.bDr = (TextView) view.findViewById(e.g.friend_info);
            cVar.bDs = (TextView) view.findViewById(e.g.friend_add_btn);
            view.setTag(cVar);
        }
        com.baidu.tieba.im.data.a item = getItem(i);
        cVar.c(item);
        cVar.bDs.setTag(Integer.valueOf(i));
        cVar.bDs.setOnClickListener(this);
        this.bDj.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.bDj.getLayoutMode().onModeChanged(view);
        Integer num = bDl.get(new C0190a(item.getStatus() == 1));
        if (num != null) {
            al.i(cVar.bDs, num.intValue());
        }
        Integer num2 = bDm.get(new C0190a(item.getStatus() == 1));
        if (num2 != null) {
            al.c(cVar.bDs, num2.intValue(), 1);
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

    public void ag(List<com.baidu.tieba.im.data.a> list) {
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
            int aX = aX(aVar.getId());
            if (aX != -1) {
                this.data.remove(aX);
                this.data.add(0, aVar);
                return;
            }
            this.data.add(0, aVar);
        }
    }

    private int aX(long j) {
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
        HeadImageView bDp;
        TextView bDq;
        TextView bDr;
        TextView bDs;

        private c() {
        }

        public void c(com.baidu.tieba.im.data.a aVar) {
            this.bDp.startLoad(aVar.getPortrait(), 12, false);
            this.bDq.setText(aVar.getName());
            if (!TextUtils.isEmpty(aVar.getContent())) {
                this.bDr.setText(aVar.getContent());
            } else {
                this.bDr.setText("");
            }
            int status = aVar.getStatus();
            this.bDs.setText(((Integer) a.bDk.get(status)).intValue());
            this.bDs.setEnabled(status == 0 || status == 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bDn != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.bDn.a(id, intValue, view, getItem(intValue));
        }
    }

    public void a(b bVar) {
        this.bDn = bVar;
    }
}
