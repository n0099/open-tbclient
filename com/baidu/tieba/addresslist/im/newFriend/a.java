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
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@SuppressLint({"UseSparseArrays"})
/* loaded from: classes3.dex */
public class a extends BaseAdapter implements View.OnClickListener {
    private static SparseArray<Integer> boB = new SparseArray<>();
    private static HashMap<C0134a, Integer> boC = new HashMap<>();
    private static HashMap<C0134a, Integer> boD = new HashMap<>();
    private NewFriendsActivity boA;
    private b boE;
    private List<com.baidu.tieba.im.data.a> data;

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i, int i2, View view, com.baidu.tieba.im.data.a aVar);
    }

    static {
        boB.put(0, Integer.valueOf(d.k.add));
        boB.put(4, Integer.valueOf(d.k.added));
        boB.put(1, Integer.valueOf(d.k.pass));
        boB.put(2, Integer.valueOf(d.k.passed));
        boB.put(3, Integer.valueOf(d.k.waiting));
        boC.put(new C0134a(false), Integer.valueOf(d.f.btn_pass));
        boC.put(new C0134a(true), Integer.valueOf(d.f.btn_all_blue));
        boD.put(new C0134a(false), Integer.valueOf(d.C0142d.btn_pass_text_color));
        boD.put(new C0134a(true), Integer.valueOf(d.C0142d.btn_agree_text_color));
    }

    /* renamed from: com.baidu.tieba.addresslist.im.newFriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0134a {
        private boolean boF;

        public C0134a(boolean z) {
            this.boF = z;
        }

        public int hashCode() {
            return (this.boF ? 1231 : 1237) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.boF == ((C0134a) obj).boF;
        }
    }

    public a(NewFriendsActivity newFriendsActivity) {
        this.boA = newFriendsActivity;
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
    /* renamed from: gy */
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.i.add_new_friend_list_item, (ViewGroup) null);
            cVar = new c();
            cVar.boG = (HeadImageView) view.findViewById(d.g.friend_icon);
            cVar.boH = (TextView) view.findViewById(d.g.friend_name);
            cVar.boI = (TextView) view.findViewById(d.g.friend_info);
            cVar.boJ = (TextView) view.findViewById(d.g.friend_add_btn);
            view.setTag(cVar);
        }
        com.baidu.tieba.im.data.a item = getItem(i);
        cVar.c(item);
        cVar.boJ.setTag(Integer.valueOf(i));
        cVar.boJ.setOnClickListener(this);
        this.boA.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.boA.getLayoutMode().onModeChanged(view);
        Integer num = boC.get(new C0134a(item.getStatus() == 1));
        if (num != null) {
            am.i(cVar.boJ, num.intValue());
        }
        Integer num2 = boD.get(new C0134a(item.getStatus() == 1));
        if (num2 != null) {
            am.c(cVar.boJ, num2.intValue(), 1);
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

    public void Y(List<com.baidu.tieba.im.data.a> list) {
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
            int aF = aF(aVar.getId());
            if (aF != -1) {
                this.data.remove(aF);
                this.data.add(0, aVar);
                return;
            }
            this.data.add(0, aVar);
        }
    }

    private int aF(long j) {
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
        HeadImageView boG;
        TextView boH;
        TextView boI;
        TextView boJ;

        private c() {
        }

        public void c(com.baidu.tieba.im.data.a aVar) {
            this.boG.startLoad(aVar.getPortrait(), 12, false);
            this.boH.setText(aVar.getName());
            if (!TextUtils.isEmpty(aVar.getContent())) {
                this.boI.setText(aVar.getContent());
            } else {
                this.boI.setText("");
            }
            int status = aVar.getStatus();
            this.boJ.setText(((Integer) a.boB.get(status)).intValue());
            this.boJ.setEnabled(status == 0 || status == 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.boE != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.boE.a(id, intValue, view, getItem(intValue));
        }
    }

    public void a(b bVar) {
        this.boE = bVar;
    }
}
