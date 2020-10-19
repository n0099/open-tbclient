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
    private static SparseArray<Integer> fFZ = new SparseArray<>();
    private static HashMap<C0586a, Integer> fGa = new HashMap<>();
    private static HashMap<C0586a, Integer> fGb = new HashMap<>();
    private List<com.baidu.tieba.im.data.a> data;
    private NewFriendsActivity fFY;
    private b fGc;

    /* loaded from: classes21.dex */
    public interface b {
        void a(int i, int i2, View view, com.baidu.tieba.im.data.a aVar);
    }

    static {
        fFZ.put(0, Integer.valueOf(R.string.add));
        fFZ.put(4, Integer.valueOf(R.string.added));
        fFZ.put(1, Integer.valueOf(R.string.pass));
        fFZ.put(2, Integer.valueOf(R.string.passed));
        fFZ.put(3, Integer.valueOf(R.string.waiting));
        fGa.put(new C0586a(false), Integer.valueOf(R.drawable.btn_pass));
        fGa.put(new C0586a(true), Integer.valueOf(R.drawable.btn_all_blue));
        fGb.put(new C0586a(false), Integer.valueOf(R.color.btn_pass_text_color));
        fGb.put(new C0586a(true), Integer.valueOf(R.color.btn_agree_text_color));
    }

    /* renamed from: com.baidu.tieba.addresslist.im.newFriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    private static class C0586a {
        private boolean fGd;

        public C0586a(boolean z) {
            this.fGd = z;
        }

        public int hashCode() {
            return (this.fGd ? 1231 : 1237) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.fGd == ((C0586a) obj).fGd;
        }
    }

    public a(NewFriendsActivity newFriendsActivity) {
        this.fFY = newFriendsActivity;
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
    /* renamed from: sY */
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
            cVar.fGe = (HeadImageView) view.findViewById(R.id.friend_icon);
            cVar.fGf = (TextView) view.findViewById(R.id.friend_name);
            cVar.fGg = (TextView) view.findViewById(R.id.friend_info);
            cVar.fGh = (TextView) view.findViewById(R.id.friend_add_btn);
            view.setTag(cVar);
        }
        com.baidu.tieba.im.data.a item = getItem(i);
        cVar.c(item);
        cVar.fGh.setTag(Integer.valueOf(i));
        cVar.fGh.setOnClickListener(this);
        this.fFY.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.fFY.getLayoutMode().onModeChanged(view);
        Integer num = fGa.get(new C0586a(item.getStatus() == 1));
        if (num != null) {
            ap.setBackgroundResource(cVar.fGh, num.intValue());
        }
        Integer num2 = fGb.get(new C0586a(item.getStatus() == 1));
        if (num2 != null) {
            ap.setViewTextColor(cVar.fGh, num2.intValue(), 1);
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

    public void bA(List<com.baidu.tieba.im.data.a> list) {
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
            int dM = dM(aVar.getId());
            if (dM != -1) {
                this.data.remove(dM);
                this.data.add(0, aVar);
                return;
            }
            this.data.add(0, aVar);
        }
    }

    private int dM(long j) {
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
        HeadImageView fGe;
        TextView fGf;
        TextView fGg;
        TextView fGh;

        private c() {
        }

        public void c(com.baidu.tieba.im.data.a aVar) {
            this.fGe.startLoad(aVar.getPortrait(), 12, false);
            this.fGf.setText(aVar.getName());
            if (!TextUtils.isEmpty(aVar.getContent())) {
                this.fGg.setText(aVar.getContent());
            } else {
                this.fGg.setText("");
            }
            int status = aVar.getStatus();
            this.fGh.setText(((Integer) a.fFZ.get(status)).intValue());
            this.fGh.setEnabled(status == 0 || status == 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fGc != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.fGc.a(id, intValue, view, getItem(intValue));
        }
    }

    public void a(b bVar) {
        this.fGc = bVar;
    }
}
