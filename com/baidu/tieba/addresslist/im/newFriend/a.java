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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@SuppressLint({"UseSparseArrays"})
/* loaded from: classes15.dex */
public class a extends BaseAdapter implements View.OnClickListener {
    private static SparseArray<Integer> fff = new SparseArray<>();
    private static HashMap<C0527a, Integer> ffg = new HashMap<>();
    private static HashMap<C0527a, Integer> ffh = new HashMap<>();
    private List<com.baidu.tieba.im.data.a> data;
    private NewFriendsActivity ffe;
    private b ffi;

    /* loaded from: classes15.dex */
    public interface b {
        void a(int i, int i2, View view, com.baidu.tieba.im.data.a aVar);
    }

    static {
        fff.put(0, Integer.valueOf(R.string.add));
        fff.put(4, Integer.valueOf(R.string.added));
        fff.put(1, Integer.valueOf(R.string.pass));
        fff.put(2, Integer.valueOf(R.string.passed));
        fff.put(3, Integer.valueOf(R.string.waiting));
        ffg.put(new C0527a(false), Integer.valueOf(R.drawable.btn_pass));
        ffg.put(new C0527a(true), Integer.valueOf(R.drawable.btn_all_blue));
        ffh.put(new C0527a(false), Integer.valueOf(R.color.btn_pass_text_color));
        ffh.put(new C0527a(true), Integer.valueOf(R.color.btn_agree_text_color));
    }

    /* renamed from: com.baidu.tieba.addresslist.im.newFriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    private static class C0527a {
        private boolean ffj;

        public C0527a(boolean z) {
            this.ffj = z;
        }

        public int hashCode() {
            return (this.ffj ? 1231 : 1237) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.ffj == ((C0527a) obj).ffj;
        }
    }

    public a(NewFriendsActivity newFriendsActivity) {
        this.ffe = newFriendsActivity;
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
    /* renamed from: pW */
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
            cVar.ffk = (HeadImageView) view.findViewById(R.id.friend_icon);
            cVar.ffl = (TextView) view.findViewById(R.id.friend_name);
            cVar.ffm = (TextView) view.findViewById(R.id.friend_info);
            cVar.ffn = (TextView) view.findViewById(R.id.friend_add_btn);
            view.setTag(cVar);
        }
        com.baidu.tieba.im.data.a item = getItem(i);
        cVar.c(item);
        cVar.ffn.setTag(Integer.valueOf(i));
        cVar.ffn.setOnClickListener(this);
        this.ffe.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.ffe.getLayoutMode().onModeChanged(view);
        Integer num = ffg.get(new C0527a(item.getStatus() == 1));
        if (num != null) {
            ao.setBackgroundResource(cVar.ffn, num.intValue());
        }
        Integer num2 = ffh.get(new C0527a(item.getStatus() == 1));
        if (num2 != null) {
            ao.setViewTextColor(cVar.ffn, num2.intValue(), 1);
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

    public void bs(List<com.baidu.tieba.im.data.a> list) {
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
            int dr = dr(aVar.getId());
            if (dr != -1) {
                this.data.remove(dr);
                this.data.add(0, aVar);
                return;
            }
            this.data.add(0, aVar);
        }
    }

    private int dr(long j) {
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

    /* loaded from: classes15.dex */
    private static class c {
        HeadImageView ffk;
        TextView ffl;
        TextView ffm;
        TextView ffn;

        private c() {
        }

        public void c(com.baidu.tieba.im.data.a aVar) {
            this.ffk.startLoad(aVar.getPortrait(), 12, false);
            this.ffl.setText(aVar.getName());
            if (!TextUtils.isEmpty(aVar.getContent())) {
                this.ffm.setText(aVar.getContent());
            } else {
                this.ffm.setText("");
            }
            int status = aVar.getStatus();
            this.ffn.setText(((Integer) a.fff.get(status)).intValue());
            this.ffn.setEnabled(status == 0 || status == 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ffi != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.ffi.a(id, intValue, view, getItem(intValue));
        }
    }

    public void a(b bVar) {
        this.ffi = bVar;
    }
}
