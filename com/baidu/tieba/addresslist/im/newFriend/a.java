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
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@SuppressLint({"UseSparseArrays"})
/* loaded from: classes6.dex */
public class a extends BaseAdapter implements View.OnClickListener {
    private static SparseArray<Integer> dXi = new SparseArray<>();
    private static HashMap<C0399a, Integer> dXj = new HashMap<>();
    private static HashMap<C0399a, Integer> dXk = new HashMap<>();
    private NewFriendsActivity dXh;
    private b dXl;
    private List<com.baidu.tieba.im.data.a> data;

    /* loaded from: classes6.dex */
    public interface b {
        void a(int i, int i2, View view, com.baidu.tieba.im.data.a aVar);
    }

    static {
        dXi.put(0, Integer.valueOf((int) R.string.add));
        dXi.put(4, Integer.valueOf((int) R.string.added));
        dXi.put(1, Integer.valueOf((int) R.string.pass));
        dXi.put(2, Integer.valueOf((int) R.string.passed));
        dXi.put(3, Integer.valueOf((int) R.string.waiting));
        dXj.put(new C0399a(false), Integer.valueOf((int) R.drawable.btn_pass));
        dXj.put(new C0399a(true), Integer.valueOf((int) R.drawable.btn_all_blue));
        dXk.put(new C0399a(false), Integer.valueOf((int) R.color.btn_pass_text_color));
        dXk.put(new C0399a(true), Integer.valueOf((int) R.color.btn_agree_text_color));
    }

    /* renamed from: com.baidu.tieba.addresslist.im.newFriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private static class C0399a {
        private boolean dXm;

        public C0399a(boolean z) {
            this.dXm = z;
        }

        public int hashCode() {
            return (this.dXm ? 1231 : 1237) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.dXm == ((C0399a) obj).dXm;
        }
    }

    public a(NewFriendsActivity newFriendsActivity) {
        this.dXh = newFriendsActivity;
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
    /* renamed from: nV */
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.add_new_friend_list_item, (ViewGroup) null);
            cVar = new c();
            cVar.dXn = (HeadImageView) view.findViewById(R.id.friend_icon);
            cVar.dXo = (TextView) view.findViewById(R.id.friend_name);
            cVar.dXp = (TextView) view.findViewById(R.id.friend_info);
            cVar.dXq = (TextView) view.findViewById(R.id.friend_add_btn);
            view.setTag(cVar);
        }
        com.baidu.tieba.im.data.a item = getItem(i);
        cVar.c(item);
        cVar.dXq.setTag(Integer.valueOf(i));
        cVar.dXq.setOnClickListener(this);
        this.dXh.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.dXh.getLayoutMode().onModeChanged(view);
        Integer num = dXj.get(new C0399a(item.getStatus() == 1));
        if (num != null) {
            am.setBackgroundResource(cVar.dXq, num.intValue());
        }
        Integer num2 = dXk.get(new C0399a(item.getStatus() == 1));
        if (num2 != null) {
            am.setViewTextColor(cVar.dXq, num2.intValue(), 1);
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

    public void aZ(List<com.baidu.tieba.im.data.a> list) {
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
            int co = co(aVar.getId());
            if (co != -1) {
                this.data.remove(co);
                this.data.add(0, aVar);
                return;
            }
            this.data.add(0, aVar);
        }
    }

    private int co(long j) {
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

    /* loaded from: classes6.dex */
    private static class c {
        HeadImageView dXn;
        TextView dXo;
        TextView dXp;
        TextView dXq;

        private c() {
        }

        public void c(com.baidu.tieba.im.data.a aVar) {
            this.dXn.startLoad(aVar.getPortrait(), 12, false);
            this.dXo.setText(aVar.getName());
            if (!TextUtils.isEmpty(aVar.getContent())) {
                this.dXp.setText(aVar.getContent());
            } else {
                this.dXp.setText("");
            }
            int status = aVar.getStatus();
            this.dXq.setText(((Integer) a.dXi.get(status)).intValue());
            this.dXq.setEnabled(status == 0 || status == 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dXl != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.dXl.a(id, intValue, view, getItem(intValue));
        }
    }

    public void a(b bVar) {
        this.dXl = bVar;
    }
}
