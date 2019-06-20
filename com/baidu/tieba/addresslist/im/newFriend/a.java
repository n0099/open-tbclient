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
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@SuppressLint({"UseSparseArrays"})
/* loaded from: classes3.dex */
public class a extends BaseAdapter implements View.OnClickListener {
    private static SparseArray<Integer> cXv = new SparseArray<>();
    private static HashMap<C0273a, Integer> cXw = new HashMap<>();
    private static HashMap<C0273a, Integer> cXx = new HashMap<>();
    private NewFriendsActivity cXu;
    private b cXy;
    private List<com.baidu.tieba.im.data.a> data;

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i, int i2, View view, com.baidu.tieba.im.data.a aVar);
    }

    static {
        cXv.put(0, Integer.valueOf((int) R.string.add));
        cXv.put(4, Integer.valueOf((int) R.string.added));
        cXv.put(1, Integer.valueOf((int) R.string.pass));
        cXv.put(2, Integer.valueOf((int) R.string.passed));
        cXv.put(3, Integer.valueOf((int) R.string.waiting));
        cXw.put(new C0273a(false), Integer.valueOf((int) R.drawable.btn_pass));
        cXw.put(new C0273a(true), Integer.valueOf((int) R.drawable.btn_all_blue));
        cXx.put(new C0273a(false), Integer.valueOf((int) R.color.btn_pass_text_color));
        cXx.put(new C0273a(true), Integer.valueOf((int) R.color.btn_agree_text_color));
    }

    /* renamed from: com.baidu.tieba.addresslist.im.newFriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0273a {
        private boolean cXz;

        public C0273a(boolean z) {
            this.cXz = z;
        }

        public int hashCode() {
            return (this.cXz ? 1231 : 1237) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.cXz == ((C0273a) obj).cXz;
        }
    }

    public a(NewFriendsActivity newFriendsActivity) {
        this.cXu = newFriendsActivity;
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
    /* renamed from: mr */
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
            cVar.cXA = (HeadImageView) view.findViewById(R.id.friend_icon);
            cVar.cXB = (TextView) view.findViewById(R.id.friend_name);
            cVar.cXC = (TextView) view.findViewById(R.id.friend_info);
            cVar.cXD = (TextView) view.findViewById(R.id.friend_add_btn);
            view.setTag(cVar);
        }
        com.baidu.tieba.im.data.a item = getItem(i);
        cVar.c(item);
        cVar.cXD.setTag(Integer.valueOf(i));
        cVar.cXD.setOnClickListener(this);
        this.cXu.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.cXu.getLayoutMode().onModeChanged(view);
        Integer num = cXw.get(new C0273a(item.getStatus() == 1));
        if (num != null) {
            al.k(cVar.cXD, num.intValue());
        }
        Integer num2 = cXx.get(new C0273a(item.getStatus() == 1));
        if (num2 != null) {
            al.f(cVar.cXD, num2.intValue(), 1);
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

    public void aB(List<com.baidu.tieba.im.data.a> list) {
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
            int bP = bP(aVar.getId());
            if (bP != -1) {
                this.data.remove(bP);
                this.data.add(0, aVar);
                return;
            }
            this.data.add(0, aVar);
        }
    }

    private int bP(long j) {
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
        HeadImageView cXA;
        TextView cXB;
        TextView cXC;
        TextView cXD;

        private c() {
        }

        public void c(com.baidu.tieba.im.data.a aVar) {
            this.cXA.startLoad(aVar.getPortrait(), 12, false);
            this.cXB.setText(aVar.getName());
            if (!TextUtils.isEmpty(aVar.getContent())) {
                this.cXC.setText(aVar.getContent());
            } else {
                this.cXC.setText("");
            }
            int status = aVar.getStatus();
            this.cXD.setText(((Integer) a.cXv.get(status)).intValue());
            this.cXD.setEnabled(status == 0 || status == 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cXy != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.cXy.a(id, intValue, view, getItem(intValue));
        }
    }

    public void a(b bVar) {
        this.cXy = bVar;
    }
}
