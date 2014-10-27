package com.baidu.tieba.im.newFriend;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class ah extends BaseAdapter implements View.OnClickListener {
    private static SparseArray<Integer> bgI = new SparseArray<>();
    private static HashMap<ai, Integer> bgJ = new HashMap<>();
    private static HashMap<ai, Integer> bgK = new HashMap<>();
    private List<com.baidu.tieba.im.data.e> bgH;
    private aj bgL;
    private BaseActivity mActivity;

    static {
        bgI.put(0, Integer.valueOf(com.baidu.tieba.y.add));
        bgI.put(4, Integer.valueOf(com.baidu.tieba.y.added));
        bgI.put(1, Integer.valueOf(com.baidu.tieba.y.pass));
        bgI.put(2, Integer.valueOf(com.baidu.tieba.y.passed));
        bgI.put(3, Integer.valueOf(com.baidu.tieba.y.waiting));
        bgJ.put(new ai(false), Integer.valueOf(com.baidu.tieba.u.btn_pass));
        bgJ.put(new ai(true), Integer.valueOf(com.baidu.tieba.u.btn_agree));
        bgK.put(new ai(false), Integer.valueOf(com.baidu.tieba.s.btn_pass_text_color));
        bgK.put(new ai(true), Integer.valueOf(com.baidu.tieba.s.btn_agree_text_color));
    }

    public ah(BaseActivity baseActivity) {
        this.mActivity = baseActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bgH == null) {
            return 0;
        }
        return this.bgH.size();
    }

    @Override // android.widget.Adapter
    /* renamed from: gj */
    public com.baidu.tieba.im.data.e getItem(int i) {
        return this.bgH.get(i);
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
            view = com.baidu.adp.lib.g.b.ek().inflate(viewGroup.getContext(), com.baidu.tieba.w.add_new_friend_list_item, null);
            akVar = new ak(null);
            akVar.bgN = (HeadImageView) view.findViewById(com.baidu.tieba.v.friend_icon);
            akVar.bgO = (TextView) view.findViewById(com.baidu.tieba.v.friend_name);
            akVar.bgP = (TextView) view.findViewById(com.baidu.tieba.v.friend_info);
            akVar.bgQ = (TextView) view.findViewById(com.baidu.tieba.v.friend_add_btn);
            view.setTag(akVar);
        }
        com.baidu.tieba.im.data.e item = getItem(i);
        akVar.e(item);
        akVar.bgQ.setTag(Integer.valueOf(i));
        akVar.bgQ.setOnClickListener(this);
        this.mActivity.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
        this.mActivity.getLayoutMode().h(view);
        Integer num = bgJ.get(new ai(item.getStatus() == 1));
        if (num != null) {
            com.baidu.tbadk.core.util.aw.h((View) akVar.bgQ, num.intValue());
        }
        Integer num2 = bgK.get(new ai(item.getStatus() == 1));
        if (num2 != null) {
            com.baidu.tbadk.core.util.aw.b(akVar.bgQ, num2.intValue(), 1);
        }
        return view;
    }

    public void setData(List<com.baidu.tieba.im.data.e> list) {
        this.bgH = list;
    }

    public synchronized void c(com.baidu.tieba.im.data.e eVar) {
        if (this.bgH != null) {
            this.bgH.remove(eVar);
        }
    }

    public void ab(List<com.baidu.tieba.im.data.e> list) {
        if (this.bgH == null) {
            this.bgH = new ArrayList();
        }
        if (list != null) {
            for (com.baidu.tieba.im.data.e eVar : list) {
                d(eVar);
            }
        }
    }

    public void d(com.baidu.tieba.im.data.e eVar) {
        if (this.bgH == null) {
            this.bgH = new ArrayList();
        }
        if (eVar != null && eVar.getId() != 0) {
            int U = U(eVar.getId());
            if (U != -1) {
                this.bgH.remove(U);
                this.bgH.add(0, eVar);
                return;
            }
            this.bgH.add(0, eVar);
        }
    }

    private int U(long j) {
        if (this.bgH != null) {
            int size = this.bgH.size();
            for (int i = 0; i < size; i++) {
                if (j == this.bgH.get(i).getId()) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bgL != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.bgL.a(id, intValue, view, getItem(intValue));
        }
    }

    public void a(aj ajVar) {
        this.bgL = ajVar;
    }
}
