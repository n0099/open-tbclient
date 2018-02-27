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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@SuppressLint({"UseSparseArrays"})
/* loaded from: classes3.dex */
public class a extends BaseAdapter implements View.OnClickListener {
    private static SparseArray<Integer> bUL = new SparseArray<>();
    private static HashMap<C0130a, Integer> bUM = new HashMap<>();
    private static HashMap<C0130a, Integer> bUN = new HashMap<>();
    private NewFriendsActivity bUK;
    private b bUO;
    private List<com.baidu.tieba.im.data.a> data;

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i, int i2, View view, com.baidu.tieba.im.data.a aVar);
    }

    static {
        bUL.put(0, Integer.valueOf(d.j.add));
        bUL.put(4, Integer.valueOf(d.j.added));
        bUL.put(1, Integer.valueOf(d.j.pass));
        bUL.put(2, Integer.valueOf(d.j.passed));
        bUL.put(3, Integer.valueOf(d.j.waiting));
        bUM.put(new C0130a(false), Integer.valueOf(d.f.btn_pass));
        bUM.put(new C0130a(true), Integer.valueOf(d.f.btn_all_blue));
        bUN.put(new C0130a(false), Integer.valueOf(d.C0141d.btn_pass_text_color));
        bUN.put(new C0130a(true), Integer.valueOf(d.C0141d.btn_agree_text_color));
    }

    /* renamed from: com.baidu.tieba.addresslist.im.newFriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0130a {
        private boolean bUP;

        public C0130a(boolean z) {
            this.bUP = z;
        }

        public int hashCode() {
            return (this.bUP ? 1231 : 1237) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.bUP == ((C0130a) obj).bUP;
        }
    }

    public a(NewFriendsActivity newFriendsActivity) {
        this.bUK = newFriendsActivity;
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
    /* renamed from: jr */
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.add_new_friend_list_item, (ViewGroup) null);
            cVar = new c();
            cVar.bUQ = (HeadImageView) view.findViewById(d.g.friend_icon);
            cVar.bUR = (TextView) view.findViewById(d.g.friend_name);
            cVar.bUS = (TextView) view.findViewById(d.g.friend_info);
            cVar.bUT = (TextView) view.findViewById(d.g.friend_add_btn);
            view.setTag(cVar);
        }
        com.baidu.tieba.im.data.a item = getItem(i);
        cVar.c(item);
        cVar.bUT.setTag(Integer.valueOf(i));
        cVar.bUT.setOnClickListener(this);
        this.bUK.getLayoutMode().aQ(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.bUK.getLayoutMode().aM(view);
        Integer num = bUM.get(new C0130a(item.getStatus() == 1));
        if (num != null) {
            aj.s(cVar.bUT, num.intValue());
        }
        Integer num2 = bUN.get(new C0130a(item.getStatus() == 1));
        if (num2 != null) {
            aj.e(cVar.bUT, num2.intValue(), 1);
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

    public void ad(List<com.baidu.tieba.im.data.a> list) {
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
            int aJ = aJ(aVar.getId());
            if (aJ != -1) {
                this.data.remove(aJ);
                this.data.add(0, aVar);
                return;
            }
            this.data.add(0, aVar);
        }
    }

    private int aJ(long j) {
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
        HeadImageView bUQ;
        TextView bUR;
        TextView bUS;
        TextView bUT;

        private c() {
        }

        public void c(com.baidu.tieba.im.data.a aVar) {
            this.bUQ.startLoad(aVar.getPortrait(), 12, false);
            this.bUR.setText(aVar.getName());
            if (!TextUtils.isEmpty(aVar.getContent())) {
                this.bUS.setText(aVar.getContent());
            } else {
                this.bUS.setText("");
            }
            int status = aVar.getStatus();
            this.bUT.setText(((Integer) a.bUL.get(status)).intValue());
            this.bUT.setEnabled(status == 0 || status == 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bUO != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.bUO.a(id, intValue, view, getItem(intValue));
        }
    }

    public void a(b bVar) {
        this.bUO = bVar;
    }
}
