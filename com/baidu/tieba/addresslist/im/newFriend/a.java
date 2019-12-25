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
/* loaded from: classes5.dex */
public class a extends BaseAdapter implements View.OnClickListener {
    private static SparseArray<Integer> dWZ = new SparseArray<>();
    private static HashMap<C0397a, Integer> dXa = new HashMap<>();
    private static HashMap<C0397a, Integer> dXb = new HashMap<>();
    private NewFriendsActivity dWY;
    private b dXc;
    private List<com.baidu.tieba.im.data.a> data;

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i, int i2, View view, com.baidu.tieba.im.data.a aVar);
    }

    static {
        dWZ.put(0, Integer.valueOf((int) R.string.add));
        dWZ.put(4, Integer.valueOf((int) R.string.added));
        dWZ.put(1, Integer.valueOf((int) R.string.pass));
        dWZ.put(2, Integer.valueOf((int) R.string.passed));
        dWZ.put(3, Integer.valueOf((int) R.string.waiting));
        dXa.put(new C0397a(false), Integer.valueOf((int) R.drawable.btn_pass));
        dXa.put(new C0397a(true), Integer.valueOf((int) R.drawable.btn_all_blue));
        dXb.put(new C0397a(false), Integer.valueOf((int) R.color.btn_pass_text_color));
        dXb.put(new C0397a(true), Integer.valueOf((int) R.color.btn_agree_text_color));
    }

    /* renamed from: com.baidu.tieba.addresslist.im.newFriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private static class C0397a {
        private boolean dXd;

        public C0397a(boolean z) {
            this.dXd = z;
        }

        public int hashCode() {
            return (this.dXd ? 1231 : 1237) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.dXd == ((C0397a) obj).dXd;
        }
    }

    public a(NewFriendsActivity newFriendsActivity) {
        this.dWY = newFriendsActivity;
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
            cVar.dXe = (HeadImageView) view.findViewById(R.id.friend_icon);
            cVar.dXf = (TextView) view.findViewById(R.id.friend_name);
            cVar.dXg = (TextView) view.findViewById(R.id.friend_info);
            cVar.dXh = (TextView) view.findViewById(R.id.friend_add_btn);
            view.setTag(cVar);
        }
        com.baidu.tieba.im.data.a item = getItem(i);
        cVar.c(item);
        cVar.dXh.setTag(Integer.valueOf(i));
        cVar.dXh.setOnClickListener(this);
        this.dWY.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.dWY.getLayoutMode().onModeChanged(view);
        Integer num = dXa.get(new C0397a(item.getStatus() == 1));
        if (num != null) {
            am.setBackgroundResource(cVar.dXh, num.intValue());
        }
        Integer num2 = dXb.get(new C0397a(item.getStatus() == 1));
        if (num2 != null) {
            am.setViewTextColor(cVar.dXh, num2.intValue(), 1);
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

    public void ba(List<com.baidu.tieba.im.data.a> list) {
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
            int cj = cj(aVar.getId());
            if (cj != -1) {
                this.data.remove(cj);
                this.data.add(0, aVar);
                return;
            }
            this.data.add(0, aVar);
        }
    }

    private int cj(long j) {
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

    /* loaded from: classes5.dex */
    private static class c {
        HeadImageView dXe;
        TextView dXf;
        TextView dXg;
        TextView dXh;

        private c() {
        }

        public void c(com.baidu.tieba.im.data.a aVar) {
            this.dXe.startLoad(aVar.getPortrait(), 12, false);
            this.dXf.setText(aVar.getName());
            if (!TextUtils.isEmpty(aVar.getContent())) {
                this.dXg.setText(aVar.getContent());
            } else {
                this.dXg.setText("");
            }
            int status = aVar.getStatus();
            this.dXh.setText(((Integer) a.dWZ.get(status)).intValue());
            this.dXh.setEnabled(status == 0 || status == 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dXc != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.dXc.a(id, intValue, view, getItem(intValue));
        }
    }

    public void a(b bVar) {
        this.dXc = bVar;
    }
}
