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
/* loaded from: classes3.dex */
public class a extends BaseAdapter implements View.OnClickListener {
    private static SparseArray<Integer> cYY = new SparseArray<>();
    private static HashMap<C0275a, Integer> cYZ = new HashMap<>();
    private static HashMap<C0275a, Integer> cZa = new HashMap<>();
    private NewFriendsActivity cYX;
    private b cZb;
    private List<com.baidu.tieba.im.data.a> data;

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i, int i2, View view, com.baidu.tieba.im.data.a aVar);
    }

    static {
        cYY.put(0, Integer.valueOf((int) R.string.add));
        cYY.put(4, Integer.valueOf((int) R.string.added));
        cYY.put(1, Integer.valueOf((int) R.string.pass));
        cYY.put(2, Integer.valueOf((int) R.string.passed));
        cYY.put(3, Integer.valueOf((int) R.string.waiting));
        cYZ.put(new C0275a(false), Integer.valueOf((int) R.drawable.btn_pass));
        cYZ.put(new C0275a(true), Integer.valueOf((int) R.drawable.btn_all_blue));
        cZa.put(new C0275a(false), Integer.valueOf((int) R.color.btn_pass_text_color));
        cZa.put(new C0275a(true), Integer.valueOf((int) R.color.btn_agree_text_color));
    }

    /* renamed from: com.baidu.tieba.addresslist.im.newFriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0275a {
        private boolean cZc;

        public C0275a(boolean z) {
            this.cZc = z;
        }

        public int hashCode() {
            return (this.cZc ? 1231 : 1237) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.cZc == ((C0275a) obj).cZc;
        }
    }

    public a(NewFriendsActivity newFriendsActivity) {
        this.cYX = newFriendsActivity;
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
    /* renamed from: mz */
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
            cVar.cZd = (HeadImageView) view.findViewById(R.id.friend_icon);
            cVar.cZe = (TextView) view.findViewById(R.id.friend_name);
            cVar.cZf = (TextView) view.findViewById(R.id.friend_info);
            cVar.cZg = (TextView) view.findViewById(R.id.friend_add_btn);
            view.setTag(cVar);
        }
        com.baidu.tieba.im.data.a item = getItem(i);
        cVar.c(item);
        cVar.cZg.setTag(Integer.valueOf(i));
        cVar.cZg.setOnClickListener(this);
        this.cYX.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.cYX.getLayoutMode().onModeChanged(view);
        Integer num = cYZ.get(new C0275a(item.getStatus() == 1));
        if (num != null) {
            am.k(cVar.cZg, num.intValue());
        }
        Integer num2 = cZa.get(new C0275a(item.getStatus() == 1));
        if (num2 != null) {
            am.f(cVar.cZg, num2.intValue(), 1);
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
            int bQ = bQ(aVar.getId());
            if (bQ != -1) {
                this.data.remove(bQ);
                this.data.add(0, aVar);
                return;
            }
            this.data.add(0, aVar);
        }
    }

    private int bQ(long j) {
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
        HeadImageView cZd;
        TextView cZe;
        TextView cZf;
        TextView cZg;

        private c() {
        }

        public void c(com.baidu.tieba.im.data.a aVar) {
            this.cZd.startLoad(aVar.getPortrait(), 12, false);
            this.cZe.setText(aVar.getName());
            if (!TextUtils.isEmpty(aVar.getContent())) {
                this.cZf.setText(aVar.getContent());
            } else {
                this.cZf.setText("");
            }
            int status = aVar.getStatus();
            this.cZg.setText(((Integer) a.cYY.get(status)).intValue());
            this.cZg.setEnabled(status == 0 || status == 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cZb != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.cZb.a(id, intValue, view, getItem(intValue));
        }
    }

    public void a(b bVar) {
        this.cZb = bVar;
    }
}
