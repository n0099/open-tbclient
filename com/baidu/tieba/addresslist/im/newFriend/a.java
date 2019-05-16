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
    private static SparseArray<Integer> cXt = new SparseArray<>();
    private static HashMap<C0273a, Integer> cXu = new HashMap<>();
    private static HashMap<C0273a, Integer> cXv = new HashMap<>();
    private NewFriendsActivity cXs;
    private b cXw;
    private List<com.baidu.tieba.im.data.a> data;

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i, int i2, View view, com.baidu.tieba.im.data.a aVar);
    }

    static {
        cXt.put(0, Integer.valueOf((int) R.string.add));
        cXt.put(4, Integer.valueOf((int) R.string.added));
        cXt.put(1, Integer.valueOf((int) R.string.pass));
        cXt.put(2, Integer.valueOf((int) R.string.passed));
        cXt.put(3, Integer.valueOf((int) R.string.waiting));
        cXu.put(new C0273a(false), Integer.valueOf((int) R.drawable.btn_pass));
        cXu.put(new C0273a(true), Integer.valueOf((int) R.drawable.btn_all_blue));
        cXv.put(new C0273a(false), Integer.valueOf((int) R.color.btn_pass_text_color));
        cXv.put(new C0273a(true), Integer.valueOf((int) R.color.btn_agree_text_color));
    }

    /* renamed from: com.baidu.tieba.addresslist.im.newFriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0273a {
        private boolean cXx;

        public C0273a(boolean z) {
            this.cXx = z;
        }

        public int hashCode() {
            return (this.cXx ? 1231 : 1237) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.cXx == ((C0273a) obj).cXx;
        }
    }

    public a(NewFriendsActivity newFriendsActivity) {
        this.cXs = newFriendsActivity;
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
            cVar.cXy = (HeadImageView) view.findViewById(R.id.friend_icon);
            cVar.cXz = (TextView) view.findViewById(R.id.friend_name);
            cVar.cXA = (TextView) view.findViewById(R.id.friend_info);
            cVar.cXB = (TextView) view.findViewById(R.id.friend_add_btn);
            view.setTag(cVar);
        }
        com.baidu.tieba.im.data.a item = getItem(i);
        cVar.c(item);
        cVar.cXB.setTag(Integer.valueOf(i));
        cVar.cXB.setOnClickListener(this);
        this.cXs.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.cXs.getLayoutMode().onModeChanged(view);
        Integer num = cXu.get(new C0273a(item.getStatus() == 1));
        if (num != null) {
            al.k(cVar.cXB, num.intValue());
        }
        Integer num2 = cXv.get(new C0273a(item.getStatus() == 1));
        if (num2 != null) {
            al.f(cVar.cXB, num2.intValue(), 1);
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
        TextView cXA;
        TextView cXB;
        HeadImageView cXy;
        TextView cXz;

        private c() {
        }

        public void c(com.baidu.tieba.im.data.a aVar) {
            this.cXy.startLoad(aVar.getPortrait(), 12, false);
            this.cXz.setText(aVar.getName());
            if (!TextUtils.isEmpty(aVar.getContent())) {
                this.cXA.setText(aVar.getContent());
            } else {
                this.cXA.setText("");
            }
            int status = aVar.getStatus();
            this.cXB.setText(((Integer) a.cXt.get(status)).intValue());
            this.cXB.setEnabled(status == 0 || status == 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cXw != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.cXw.a(id, intValue, view, getItem(intValue));
        }
    }

    public void a(b bVar) {
        this.cXw = bVar;
    }
}
