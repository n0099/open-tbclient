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
    private static SparseArray<Integer> cYR = new SparseArray<>();
    private static HashMap<C0275a, Integer> cYS = new HashMap<>();
    private static HashMap<C0275a, Integer> cYT = new HashMap<>();
    private NewFriendsActivity cYQ;
    private b cYU;
    private List<com.baidu.tieba.im.data.a> data;

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i, int i2, View view, com.baidu.tieba.im.data.a aVar);
    }

    static {
        cYR.put(0, Integer.valueOf((int) R.string.add));
        cYR.put(4, Integer.valueOf((int) R.string.added));
        cYR.put(1, Integer.valueOf((int) R.string.pass));
        cYR.put(2, Integer.valueOf((int) R.string.passed));
        cYR.put(3, Integer.valueOf((int) R.string.waiting));
        cYS.put(new C0275a(false), Integer.valueOf((int) R.drawable.btn_pass));
        cYS.put(new C0275a(true), Integer.valueOf((int) R.drawable.btn_all_blue));
        cYT.put(new C0275a(false), Integer.valueOf((int) R.color.btn_pass_text_color));
        cYT.put(new C0275a(true), Integer.valueOf((int) R.color.btn_agree_text_color));
    }

    /* renamed from: com.baidu.tieba.addresslist.im.newFriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0275a {
        private boolean cYV;

        public C0275a(boolean z) {
            this.cYV = z;
        }

        public int hashCode() {
            return (this.cYV ? 1231 : 1237) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.cYV == ((C0275a) obj).cYV;
        }
    }

    public a(NewFriendsActivity newFriendsActivity) {
        this.cYQ = newFriendsActivity;
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
    /* renamed from: my */
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
            cVar.cYW = (HeadImageView) view.findViewById(R.id.friend_icon);
            cVar.cYX = (TextView) view.findViewById(R.id.friend_name);
            cVar.cYY = (TextView) view.findViewById(R.id.friend_info);
            cVar.cYZ = (TextView) view.findViewById(R.id.friend_add_btn);
            view.setTag(cVar);
        }
        com.baidu.tieba.im.data.a item = getItem(i);
        cVar.c(item);
        cVar.cYZ.setTag(Integer.valueOf(i));
        cVar.cYZ.setOnClickListener(this);
        this.cYQ.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.cYQ.getLayoutMode().onModeChanged(view);
        Integer num = cYS.get(new C0275a(item.getStatus() == 1));
        if (num != null) {
            am.k(cVar.cYZ, num.intValue());
        }
        Integer num2 = cYT.get(new C0275a(item.getStatus() == 1));
        if (num2 != null) {
            am.f(cVar.cYZ, num2.intValue(), 1);
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
        HeadImageView cYW;
        TextView cYX;
        TextView cYY;
        TextView cYZ;

        private c() {
        }

        public void c(com.baidu.tieba.im.data.a aVar) {
            this.cYW.startLoad(aVar.getPortrait(), 12, false);
            this.cYX.setText(aVar.getName());
            if (!TextUtils.isEmpty(aVar.getContent())) {
                this.cYY.setText(aVar.getContent());
            } else {
                this.cYY.setText("");
            }
            int status = aVar.getStatus();
            this.cYZ.setText(((Integer) a.cYR.get(status)).intValue());
            this.cYZ.setEnabled(status == 0 || status == 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cYU != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.cYU.a(id, intValue, view, getItem(intValue));
        }
    }

    public void a(b bVar) {
        this.cYU = bVar;
    }
}
