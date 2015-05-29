package com.baidu.tieba.addresslist.im.newFriend;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class ai extends BaseAdapter implements View.OnClickListener {
    private static SparseArray<Integer> aAb = new SparseArray<>();
    private static HashMap<aj, Integer> aAc = new HashMap<>();
    private static HashMap<aj, Integer> aAd = new HashMap<>();
    private NewFriendsActivity aAa;
    private ak aAe;
    private List<com.baidu.tieba.im.data.b> data;

    static {
        aAb.put(0, Integer.valueOf(com.baidu.tieba.t.add));
        aAb.put(4, Integer.valueOf(com.baidu.tieba.t.added));
        aAb.put(1, Integer.valueOf(com.baidu.tieba.t.pass));
        aAb.put(2, Integer.valueOf(com.baidu.tieba.t.passed));
        aAb.put(3, Integer.valueOf(com.baidu.tieba.t.waiting));
        aAc.put(new aj(false), Integer.valueOf(com.baidu.tieba.p.btn_pass));
        aAc.put(new aj(true), Integer.valueOf(com.baidu.tieba.p.btn_agree));
        aAd.put(new aj(false), Integer.valueOf(com.baidu.tieba.n.btn_pass_text_color));
        aAd.put(new aj(true), Integer.valueOf(com.baidu.tieba.n.btn_agree_text_color));
    }

    public ai(NewFriendsActivity newFriendsActivity) {
        this.aAa = newFriendsActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.data == null) {
            return 0;
        }
        return this.data.size();
    }

    @Override // android.widget.Adapter
    /* renamed from: eA */
    public com.baidu.tieba.im.data.b getItem(int i) {
        return this.data.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        al alVar;
        if (view != null && view.getTag() != null && (view.getTag() instanceof al)) {
            alVar = (al) view.getTag();
        } else {
            view = com.baidu.adp.lib.g.b.hr().inflate(viewGroup.getContext(), com.baidu.tieba.r.add_new_friend_list_item, null);
            alVar = new al(null);
            alVar.aAg = (HeadImageView) view.findViewById(com.baidu.tieba.q.friend_icon);
            alVar.aAh = (TextView) view.findViewById(com.baidu.tieba.q.friend_name);
            alVar.aAi = (TextView) view.findViewById(com.baidu.tieba.q.friend_info);
            alVar.aAj = (TextView) view.findViewById(com.baidu.tieba.q.friend_add_btn);
            view.setTag(alVar);
        }
        com.baidu.tieba.im.data.b item = getItem(i);
        alVar.c(item);
        alVar.aAj.setTag(Integer.valueOf(i));
        alVar.aAj.setOnClickListener(this);
        this.aAa.getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.aAa.getLayoutMode().j(view);
        Integer num = aAc.get(new aj(item.getStatus() == 1));
        if (num != null) {
            com.baidu.tbadk.core.util.ay.i((View) alVar.aAj, num.intValue());
        }
        Integer num2 = aAd.get(new aj(item.getStatus() == 1));
        if (num2 != null) {
            com.baidu.tbadk.core.util.ay.b(alVar.aAj, num2.intValue(), 1);
        }
        return view;
    }

    public void setData(List<com.baidu.tieba.im.data.b> list) {
        this.data = list;
    }

    public synchronized void a(com.baidu.tieba.im.data.b bVar) {
        if (this.data != null) {
            this.data.remove(bVar);
        }
    }

    public void x(List<com.baidu.tieba.im.data.b> list) {
        if (this.data == null) {
            this.data = new ArrayList();
        }
        if (list != null) {
            for (com.baidu.tieba.im.data.b bVar : list) {
                b(bVar);
            }
        }
    }

    public void b(com.baidu.tieba.im.data.b bVar) {
        if (this.data == null) {
            this.data = new ArrayList();
        }
        if (bVar != null && bVar.getId() != 0) {
            int G = G(bVar.getId());
            if (G != -1) {
                this.data.remove(G);
                this.data.add(0, bVar);
                return;
            }
            this.data.add(0, bVar);
        }
    }

    private int G(long j) {
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

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aAe != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.aAe.a(id, intValue, view, getItem(intValue));
        }
    }

    public void a(ak akVar) {
        this.aAe = akVar;
    }
}
