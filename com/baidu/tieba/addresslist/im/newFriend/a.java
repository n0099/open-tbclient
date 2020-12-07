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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@SuppressLint({"UseSparseArrays"})
/* loaded from: classes21.dex */
public class a extends BaseAdapter implements View.OnClickListener {
    private static SparseArray<Integer> gcb = new SparseArray<>();
    private static HashMap<C0624a, Integer> gcc = new HashMap<>();
    private static HashMap<C0624a, Integer> gcd = new HashMap<>();
    private List<com.baidu.tieba.im.data.a> data;
    private NewFriendsActivity gca;
    private b gce;

    /* loaded from: classes21.dex */
    public interface b {
        void a(int i, int i2, View view, com.baidu.tieba.im.data.a aVar);
    }

    static {
        gcb.put(0, Integer.valueOf(R.string.add));
        gcb.put(4, Integer.valueOf(R.string.added));
        gcb.put(1, Integer.valueOf(R.string.pass));
        gcb.put(2, Integer.valueOf(R.string.passed));
        gcb.put(3, Integer.valueOf(R.string.waiting));
        gcc.put(new C0624a(false), Integer.valueOf(R.drawable.btn_pass));
        gcc.put(new C0624a(true), Integer.valueOf(R.drawable.btn_all_blue));
        gcd.put(new C0624a(false), Integer.valueOf(R.color.btn_pass_text_color));
        gcd.put(new C0624a(true), Integer.valueOf(R.color.btn_agree_text_color));
    }

    /* renamed from: com.baidu.tieba.addresslist.im.newFriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    private static class C0624a {
        private boolean gcf;

        public C0624a(boolean z) {
            this.gcf = z;
        }

        public int hashCode() {
            return (this.gcf ? 1231 : 1237) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.gcf == ((C0624a) obj).gcf;
        }
    }

    public a(NewFriendsActivity newFriendsActivity) {
        this.gca = newFriendsActivity;
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
    /* renamed from: uv */
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
            cVar.gcg = (HeadImageView) view.findViewById(R.id.friend_icon);
            cVar.gch = (TextView) view.findViewById(R.id.friend_name);
            cVar.gci = (TextView) view.findViewById(R.id.friend_info);
            cVar.gcj = (TextView) view.findViewById(R.id.friend_add_btn);
            view.setTag(cVar);
        }
        com.baidu.tieba.im.data.a item = getItem(i);
        cVar.c(item);
        cVar.gcj.setTag(Integer.valueOf(i));
        cVar.gcj.setOnClickListener(this);
        this.gca.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gca.getLayoutMode().onModeChanged(view);
        Integer num = gcc.get(new C0624a(item.getStatus() == 1));
        if (num != null) {
            ap.setBackgroundResource(cVar.gcj, num.intValue());
        }
        Integer num2 = gcd.get(new C0624a(item.getStatus() == 1));
        if (num2 != null) {
            ap.setViewTextColor(cVar.gcj, num2.intValue(), 1);
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

    public void bU(List<com.baidu.tieba.im.data.a> list) {
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
            int eN = eN(aVar.getId());
            if (eN != -1) {
                this.data.remove(eN);
                this.data.add(0, aVar);
                return;
            }
            this.data.add(0, aVar);
        }
    }

    private int eN(long j) {
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

    /* loaded from: classes21.dex */
    private static class c {
        HeadImageView gcg;
        TextView gch;
        TextView gci;
        TextView gcj;

        private c() {
        }

        public void c(com.baidu.tieba.im.data.a aVar) {
            this.gcg.startLoad(aVar.getPortrait(), 12, false);
            this.gch.setText(aVar.getName());
            if (!TextUtils.isEmpty(aVar.getContent())) {
                this.gci.setText(aVar.getContent());
            } else {
                this.gci.setText("");
            }
            int status = aVar.getStatus();
            this.gcj.setText(((Integer) a.gcb.get(status)).intValue());
            this.gcj.setEnabled(status == 0 || status == 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gce != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.gce.a(id, intValue, view, getItem(intValue));
        }
    }

    public void a(b bVar) {
        this.gce = bVar;
    }
}
