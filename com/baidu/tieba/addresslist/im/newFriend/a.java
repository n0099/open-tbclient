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
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@SuppressLint({"UseSparseArrays"})
/* loaded from: classes3.dex */
public class a extends BaseAdapter implements View.OnClickListener {
    private static SparseArray<Integer> bzN = new SparseArray<>();
    private static HashMap<C0180a, Integer> bzO = new HashMap<>();
    private static HashMap<C0180a, Integer> bzP = new HashMap<>();
    private NewFriendsActivity bzM;
    private b bzQ;
    private List<com.baidu.tieba.im.data.a> data;

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i, int i2, View view, com.baidu.tieba.im.data.a aVar);
    }

    static {
        bzN.put(0, Integer.valueOf(e.j.add));
        bzN.put(4, Integer.valueOf(e.j.added));
        bzN.put(1, Integer.valueOf(e.j.pass));
        bzN.put(2, Integer.valueOf(e.j.passed));
        bzN.put(3, Integer.valueOf(e.j.waiting));
        bzO.put(new C0180a(false), Integer.valueOf(e.f.btn_pass));
        bzO.put(new C0180a(true), Integer.valueOf(e.f.btn_all_blue));
        bzP.put(new C0180a(false), Integer.valueOf(e.d.btn_pass_text_color));
        bzP.put(new C0180a(true), Integer.valueOf(e.d.btn_agree_text_color));
    }

    /* renamed from: com.baidu.tieba.addresslist.im.newFriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0180a {
        private boolean bzR;

        public C0180a(boolean z) {
            this.bzR = z;
        }

        public int hashCode() {
            return (this.bzR ? 1231 : 1237) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.bzR == ((C0180a) obj).bzR;
        }
    }

    public a(NewFriendsActivity newFriendsActivity) {
        this.bzM = newFriendsActivity;
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
    /* renamed from: hy */
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(e.h.add_new_friend_list_item, (ViewGroup) null);
            cVar = new c();
            cVar.bzS = (HeadImageView) view.findViewById(e.g.friend_icon);
            cVar.bzT = (TextView) view.findViewById(e.g.friend_name);
            cVar.bzU = (TextView) view.findViewById(e.g.friend_info);
            cVar.bzV = (TextView) view.findViewById(e.g.friend_add_btn);
            view.setTag(cVar);
        }
        com.baidu.tieba.im.data.a item = getItem(i);
        cVar.c(item);
        cVar.bzV.setTag(Integer.valueOf(i));
        cVar.bzV.setOnClickListener(this);
        this.bzM.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.bzM.getLayoutMode().onModeChanged(view);
        Integer num = bzO.get(new C0180a(item.getStatus() == 1));
        if (num != null) {
            al.i(cVar.bzV, num.intValue());
        }
        Integer num2 = bzP.get(new C0180a(item.getStatus() == 1));
        if (num2 != null) {
            al.c(cVar.bzV, num2.intValue(), 1);
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

    public void ag(List<com.baidu.tieba.im.data.a> list) {
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
            int aQ = aQ(aVar.getId());
            if (aQ != -1) {
                this.data.remove(aQ);
                this.data.add(0, aVar);
                return;
            }
            this.data.add(0, aVar);
        }
    }

    private int aQ(long j) {
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
        HeadImageView bzS;
        TextView bzT;
        TextView bzU;
        TextView bzV;

        private c() {
        }

        public void c(com.baidu.tieba.im.data.a aVar) {
            this.bzS.startLoad(aVar.getPortrait(), 12, false);
            this.bzT.setText(aVar.getName());
            if (!TextUtils.isEmpty(aVar.getContent())) {
                this.bzU.setText(aVar.getContent());
            } else {
                this.bzU.setText("");
            }
            int status = aVar.getStatus();
            this.bzV.setText(((Integer) a.bzN.get(status)).intValue());
            this.bzV.setEnabled(status == 0 || status == 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bzQ != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.bzQ.a(id, intValue, view, getItem(intValue));
        }
    }

    public void a(b bVar) {
        this.bzQ = bVar;
    }
}
