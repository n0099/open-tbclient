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
    private static SparseArray<Integer> bgW = new SparseArray<>();
    private static HashMap<ai, Integer> bgX = new HashMap<>();
    private static HashMap<ai, Integer> bgY = new HashMap<>();
    private List<com.baidu.tieba.im.data.e> bgV;
    private aj bgZ;
    private BaseActivity mActivity;

    static {
        bgW.put(0, Integer.valueOf(com.baidu.tieba.y.add));
        bgW.put(4, Integer.valueOf(com.baidu.tieba.y.added));
        bgW.put(1, Integer.valueOf(com.baidu.tieba.y.pass));
        bgW.put(2, Integer.valueOf(com.baidu.tieba.y.passed));
        bgW.put(3, Integer.valueOf(com.baidu.tieba.y.waiting));
        bgX.put(new ai(false), Integer.valueOf(com.baidu.tieba.u.btn_pass));
        bgX.put(new ai(true), Integer.valueOf(com.baidu.tieba.u.btn_agree));
        bgY.put(new ai(false), Integer.valueOf(com.baidu.tieba.s.btn_pass_text_color));
        bgY.put(new ai(true), Integer.valueOf(com.baidu.tieba.s.btn_agree_text_color));
    }

    public ah(BaseActivity baseActivity) {
        this.mActivity = baseActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bgV == null) {
            return 0;
        }
        return this.bgV.size();
    }

    @Override // android.widget.Adapter
    /* renamed from: gj */
    public com.baidu.tieba.im.data.e getItem(int i) {
        return this.bgV.get(i);
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
            akVar.bhb = (HeadImageView) view.findViewById(com.baidu.tieba.v.friend_icon);
            akVar.bhc = (TextView) view.findViewById(com.baidu.tieba.v.friend_name);
            akVar.bhd = (TextView) view.findViewById(com.baidu.tieba.v.friend_info);
            akVar.bhe = (TextView) view.findViewById(com.baidu.tieba.v.friend_add_btn);
            view.setTag(akVar);
        }
        com.baidu.tieba.im.data.e item = getItem(i);
        akVar.e(item);
        akVar.bhe.setTag(Integer.valueOf(i));
        akVar.bhe.setOnClickListener(this);
        this.mActivity.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
        this.mActivity.getLayoutMode().h(view);
        Integer num = bgX.get(new ai(item.getStatus() == 1));
        if (num != null) {
            com.baidu.tbadk.core.util.aw.h((View) akVar.bhe, num.intValue());
        }
        Integer num2 = bgY.get(new ai(item.getStatus() == 1));
        if (num2 != null) {
            com.baidu.tbadk.core.util.aw.b(akVar.bhe, num2.intValue(), 1);
        }
        return view;
    }

    public void setData(List<com.baidu.tieba.im.data.e> list) {
        this.bgV = list;
    }

    public synchronized void c(com.baidu.tieba.im.data.e eVar) {
        if (this.bgV != null) {
            this.bgV.remove(eVar);
        }
    }

    public void ab(List<com.baidu.tieba.im.data.e> list) {
        if (this.bgV == null) {
            this.bgV = new ArrayList();
        }
        if (list != null) {
            for (com.baidu.tieba.im.data.e eVar : list) {
                d(eVar);
            }
        }
    }

    public void d(com.baidu.tieba.im.data.e eVar) {
        if (this.bgV == null) {
            this.bgV = new ArrayList();
        }
        if (eVar != null && eVar.getId() != 0) {
            int U = U(eVar.getId());
            if (U != -1) {
                this.bgV.remove(U);
                this.bgV.add(0, eVar);
                return;
            }
            this.bgV.add(0, eVar);
        }
    }

    private int U(long j) {
        if (this.bgV != null) {
            int size = this.bgV.size();
            for (int i = 0; i < size; i++) {
                if (j == this.bgV.get(i).getId()) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bgZ != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.bgZ.a(id, intValue, view, getItem(intValue));
        }
    }

    public void a(aj ajVar) {
        this.bgZ = ajVar;
    }
}
