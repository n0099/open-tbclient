package com.baidu.tieba.im.newFriend;

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
public class ah extends BaseAdapter implements View.OnClickListener {
    private static SparseArray<Integer> bjO = new SparseArray<>();
    private static HashMap<ai, Integer> bjP = new HashMap<>();
    private static HashMap<ai, Integer> bjQ = new HashMap<>();
    private NewFriendsActivity bjN;
    private aj bjR;
    private List<com.baidu.tieba.im.data.b> data;

    static {
        bjO.put(0, Integer.valueOf(com.baidu.tieba.z.add));
        bjO.put(4, Integer.valueOf(com.baidu.tieba.z.added));
        bjO.put(1, Integer.valueOf(com.baidu.tieba.z.pass));
        bjO.put(2, Integer.valueOf(com.baidu.tieba.z.passed));
        bjO.put(3, Integer.valueOf(com.baidu.tieba.z.waiting));
        bjP.put(new ai(false), Integer.valueOf(com.baidu.tieba.v.btn_pass));
        bjP.put(new ai(true), Integer.valueOf(com.baidu.tieba.v.btn_agree));
        bjQ.put(new ai(false), Integer.valueOf(com.baidu.tieba.t.btn_pass_text_color));
        bjQ.put(new ai(true), Integer.valueOf(com.baidu.tieba.t.btn_agree_text_color));
    }

    public ah(NewFriendsActivity newFriendsActivity) {
        this.bjN = newFriendsActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.data == null) {
            return 0;
        }
        return this.data.size();
    }

    @Override // android.widget.Adapter
    /* renamed from: gq */
    public com.baidu.tieba.im.data.b getItem(int i) {
        return this.data.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ak akVar;
        if (view != null && view.getTag() != null && (view.getTag() instanceof ak)) {
            akVar = (ak) view.getTag();
        } else {
            view = com.baidu.adp.lib.g.b.ek().inflate(viewGroup.getContext(), com.baidu.tieba.x.add_new_friend_list_item, null);
            akVar = new ak(null);
            akVar.bjT = (HeadImageView) view.findViewById(com.baidu.tieba.w.friend_icon);
            akVar.bjU = (TextView) view.findViewById(com.baidu.tieba.w.friend_name);
            akVar.bjV = (TextView) view.findViewById(com.baidu.tieba.w.friend_info);
            akVar.bjW = (TextView) view.findViewById(com.baidu.tieba.w.friend_add_btn);
            view.setTag(akVar);
        }
        com.baidu.tieba.im.data.b item = getItem(i);
        akVar.f(item);
        akVar.bjW.setTag(Integer.valueOf(i));
        akVar.bjW.setOnClickListener(this);
        this.bjN.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() == 1);
        this.bjN.getLayoutMode().h(view);
        Integer num = bjP.get(new ai(item.getStatus() == 1));
        if (num != null) {
            com.baidu.tbadk.core.util.ax.i((View) akVar.bjW, num.intValue());
        }
        Integer num2 = bjQ.get(new ai(item.getStatus() == 1));
        if (num2 != null) {
            com.baidu.tbadk.core.util.ax.b(akVar.bjW, num2.intValue(), 1);
        }
        return view;
    }

    public void setData(List<com.baidu.tieba.im.data.b> list) {
        this.data = list;
    }

    public synchronized void d(com.baidu.tieba.im.data.b bVar) {
        if (this.data != null) {
            this.data.remove(bVar);
        }
    }

    public void ay(List<com.baidu.tieba.im.data.b> list) {
        if (this.data == null) {
            this.data = new ArrayList();
        }
        if (list != null) {
            for (com.baidu.tieba.im.data.b bVar : list) {
                e(bVar);
            }
        }
    }

    public void e(com.baidu.tieba.im.data.b bVar) {
        if (this.data == null) {
            this.data = new ArrayList();
        }
        if (bVar != null && bVar.getId() != 0) {
            int ad = ad(bVar.getId());
            if (ad != -1) {
                this.data.remove(ad);
                this.data.add(0, bVar);
                return;
            }
            this.data.add(0, bVar);
        }
    }

    private int ad(long j) {
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
        if (this.bjR != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.bjR.a(id, intValue, view, getItem(intValue));
        }
    }

    public void a(aj ajVar) {
        this.bjR = ajVar;
    }
}
