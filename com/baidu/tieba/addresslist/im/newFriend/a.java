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
/* loaded from: classes8.dex */
public class a extends BaseAdapter implements View.OnClickListener {
    private static SparseArray<Integer> eQh = new SparseArray<>();
    private static HashMap<C0509a, Integer> eQi = new HashMap<>();
    private static HashMap<C0509a, Integer> eQj = new HashMap<>();
    private List<com.baidu.tieba.im.data.a> data;
    private NewFriendsActivity eQg;
    private b eQk;

    /* loaded from: classes8.dex */
    public interface b {
        void a(int i, int i2, View view, com.baidu.tieba.im.data.a aVar);
    }

    static {
        eQh.put(0, Integer.valueOf((int) R.string.add));
        eQh.put(4, Integer.valueOf((int) R.string.added));
        eQh.put(1, Integer.valueOf((int) R.string.pass));
        eQh.put(2, Integer.valueOf((int) R.string.passed));
        eQh.put(3, Integer.valueOf((int) R.string.waiting));
        eQi.put(new C0509a(false), Integer.valueOf((int) R.drawable.btn_pass));
        eQi.put(new C0509a(true), Integer.valueOf((int) R.drawable.btn_all_blue));
        eQj.put(new C0509a(false), Integer.valueOf((int) R.color.btn_pass_text_color));
        eQj.put(new C0509a(true), Integer.valueOf((int) R.color.btn_agree_text_color));
    }

    /* renamed from: com.baidu.tieba.addresslist.im.newFriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private static class C0509a {
        private boolean eQl;

        public C0509a(boolean z) {
            this.eQl = z;
        }

        public int hashCode() {
            return (this.eQl ? 1231 : 1237) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.eQl == ((C0509a) obj).eQl;
        }
    }

    public a(NewFriendsActivity newFriendsActivity) {
        this.eQg = newFriendsActivity;
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
    /* renamed from: pi */
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
            cVar.eQm = (HeadImageView) view.findViewById(R.id.friend_icon);
            cVar.eQn = (TextView) view.findViewById(R.id.friend_name);
            cVar.eQo = (TextView) view.findViewById(R.id.friend_info);
            cVar.eQp = (TextView) view.findViewById(R.id.friend_add_btn);
            view.setTag(cVar);
        }
        com.baidu.tieba.im.data.a item = getItem(i);
        cVar.c(item);
        cVar.eQp.setTag(Integer.valueOf(i));
        cVar.eQp.setOnClickListener(this);
        this.eQg.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.eQg.getLayoutMode().onModeChanged(view);
        Integer num = eQi.get(new C0509a(item.getStatus() == 1));
        if (num != null) {
            am.setBackgroundResource(cVar.eQp, num.intValue());
        }
        Integer num2 = eQj.get(new C0509a(item.getStatus() == 1));
        if (num2 != null) {
            am.setViewTextColor(cVar.eQp, num2.intValue(), 1);
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

    public void be(List<com.baidu.tieba.im.data.a> list) {
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
            int db = db(aVar.getId());
            if (db != -1) {
                this.data.remove(db);
                this.data.add(0, aVar);
                return;
            }
            this.data.add(0, aVar);
        }
    }

    private int db(long j) {
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

    /* loaded from: classes8.dex */
    private static class c {
        HeadImageView eQm;
        TextView eQn;
        TextView eQo;
        TextView eQp;

        private c() {
        }

        public void c(com.baidu.tieba.im.data.a aVar) {
            this.eQm.startLoad(aVar.getPortrait(), 12, false);
            this.eQn.setText(aVar.getName());
            if (!TextUtils.isEmpty(aVar.getContent())) {
                this.eQo.setText(aVar.getContent());
            } else {
                this.eQo.setText("");
            }
            int status = aVar.getStatus();
            this.eQp.setText(((Integer) a.eQh.get(status)).intValue());
            this.eQp.setEnabled(status == 0 || status == 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eQk != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.eQk.a(id, intValue, view, getItem(intValue));
        }
    }

    public void a(b bVar) {
        this.eQk = bVar;
    }
}
