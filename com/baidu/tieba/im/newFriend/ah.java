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
    private static SparseArray<Integer> bll = new SparseArray<>();
    private static HashMap<ai, Integer> blm = new HashMap<>();
    private static HashMap<ai, Integer> bln = new HashMap<>();
    private NewFriendsActivity blk;
    private aj blo;
    private List<com.baidu.tieba.im.data.b> data;

    static {
        bll.put(0, Integer.valueOf(com.baidu.tieba.z.add));
        bll.put(4, Integer.valueOf(com.baidu.tieba.z.added));
        bll.put(1, Integer.valueOf(com.baidu.tieba.z.pass));
        bll.put(2, Integer.valueOf(com.baidu.tieba.z.passed));
        bll.put(3, Integer.valueOf(com.baidu.tieba.z.waiting));
        blm.put(new ai(false), Integer.valueOf(com.baidu.tieba.v.btn_pass));
        blm.put(new ai(true), Integer.valueOf(com.baidu.tieba.v.btn_agree));
        bln.put(new ai(false), Integer.valueOf(com.baidu.tieba.t.btn_pass_text_color));
        bln.put(new ai(true), Integer.valueOf(com.baidu.tieba.t.btn_agree_text_color));
    }

    public ah(NewFriendsActivity newFriendsActivity) {
        this.blk = newFriendsActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.data == null) {
            return 0;
        }
        return this.data.size();
    }

    @Override // android.widget.Adapter
    /* renamed from: gz */
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
            view = com.baidu.adp.lib.g.b.ei().inflate(viewGroup.getContext(), com.baidu.tieba.x.add_new_friend_list_item, null);
            akVar = new ak(null);
            akVar.blq = (HeadImageView) view.findViewById(com.baidu.tieba.w.friend_icon);
            akVar.blr = (TextView) view.findViewById(com.baidu.tieba.w.friend_name);
            akVar.bls = (TextView) view.findViewById(com.baidu.tieba.w.friend_info);
            akVar.blt = (TextView) view.findViewById(com.baidu.tieba.w.friend_add_btn);
            view.setTag(akVar);
        }
        com.baidu.tieba.im.data.b item = getItem(i);
        akVar.f(item);
        akVar.blt.setTag(Integer.valueOf(i));
        akVar.blt.setOnClickListener(this);
        this.blk.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() == 1);
        this.blk.getLayoutMode().h(view);
        Integer num = blm.get(new ai(item.getStatus() == 1));
        if (num != null) {
            com.baidu.tbadk.core.util.bc.i((View) akVar.blt, num.intValue());
        }
        Integer num2 = bln.get(new ai(item.getStatus() == 1));
        if (num2 != null) {
            com.baidu.tbadk.core.util.bc.b(akVar.blt, num2.intValue(), 1);
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

    public void aB(List<com.baidu.tieba.im.data.b> list) {
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
        if (this.blo != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.blo.a(id, intValue, view, getItem(intValue));
        }
    }

    public void a(aj ajVar) {
        this.blo = ajVar;
    }
}
