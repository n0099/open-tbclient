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
    private static SparseArray<Integer> ayq = new SparseArray<>();
    private static HashMap<aj, Integer> ayr = new HashMap<>();
    private static HashMap<aj, Integer> ays = new HashMap<>();
    private NewFriendsActivity ayp;
    private ak ayt;
    private List<com.baidu.tieba.im.data.b> data;

    static {
        ayq.put(0, Integer.valueOf(com.baidu.tieba.y.add));
        ayq.put(4, Integer.valueOf(com.baidu.tieba.y.added));
        ayq.put(1, Integer.valueOf(com.baidu.tieba.y.pass));
        ayq.put(2, Integer.valueOf(com.baidu.tieba.y.passed));
        ayq.put(3, Integer.valueOf(com.baidu.tieba.y.waiting));
        ayr.put(new aj(false), Integer.valueOf(com.baidu.tieba.u.btn_pass));
        ayr.put(new aj(true), Integer.valueOf(com.baidu.tieba.u.btn_agree));
        ays.put(new aj(false), Integer.valueOf(com.baidu.tieba.s.btn_pass_text_color));
        ays.put(new aj(true), Integer.valueOf(com.baidu.tieba.s.btn_agree_text_color));
    }

    public ai(NewFriendsActivity newFriendsActivity) {
        this.ayp = newFriendsActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.data == null) {
            return 0;
        }
        return this.data.size();
    }

    @Override // android.widget.Adapter
    /* renamed from: eo */
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
            view = com.baidu.adp.lib.g.b.hH().inflate(viewGroup.getContext(), com.baidu.tieba.w.add_new_friend_list_item, null);
            alVar = new al(null);
            alVar.ayv = (HeadImageView) view.findViewById(com.baidu.tieba.v.friend_icon);
            alVar.ayw = (TextView) view.findViewById(com.baidu.tieba.v.friend_name);
            alVar.ayx = (TextView) view.findViewById(com.baidu.tieba.v.friend_info);
            alVar.ayy = (TextView) view.findViewById(com.baidu.tieba.v.friend_add_btn);
            view.setTag(alVar);
        }
        com.baidu.tieba.im.data.b item = getItem(i);
        alVar.c(item);
        alVar.ayy.setTag(Integer.valueOf(i));
        alVar.ayy.setOnClickListener(this);
        this.ayp.getLayoutMode().X(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.ayp.getLayoutMode().h(view);
        Integer num = ayr.get(new aj(item.getStatus() == 1));
        if (num != null) {
            com.baidu.tbadk.core.util.ba.i((View) alVar.ayy, num.intValue());
        }
        Integer num2 = ays.get(new aj(item.getStatus() == 1));
        if (num2 != null) {
            com.baidu.tbadk.core.util.ba.b(alVar.ayy, num2.intValue(), 1);
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

    public void w(List<com.baidu.tieba.im.data.b> list) {
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
            int H = H(bVar.getId());
            if (H != -1) {
                this.data.remove(H);
                this.data.add(0, bVar);
                return;
            }
            this.data.add(0, bVar);
        }
    }

    private int H(long j) {
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
        if (this.ayt != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.ayt.a(id, intValue, view, getItem(intValue));
        }
    }

    public void a(ak akVar) {
        this.ayt = akVar;
    }
}
