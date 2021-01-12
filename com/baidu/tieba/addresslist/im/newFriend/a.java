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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@SuppressLint({"UseSparseArrays"})
/* loaded from: classes7.dex */
public class a extends BaseAdapter implements View.OnClickListener {
    private static SparseArray<Integer> ggM = new SparseArray<>();
    private static HashMap<C0598a, Integer> ggN = new HashMap<>();
    private static HashMap<C0598a, Integer> ggO = new HashMap<>();
    private List<com.baidu.tieba.im.data.a> data;
    private NewFriendsActivity ggL;
    private b ggP;

    /* loaded from: classes7.dex */
    public interface b {
        void a(int i, int i2, View view, com.baidu.tieba.im.data.a aVar);
    }

    static {
        ggM.put(0, Integer.valueOf(R.string.add));
        ggM.put(4, Integer.valueOf(R.string.added));
        ggM.put(1, Integer.valueOf(R.string.pass));
        ggM.put(2, Integer.valueOf(R.string.passed));
        ggM.put(3, Integer.valueOf(R.string.waiting));
        ggN.put(new C0598a(false), Integer.valueOf(R.drawable.btn_pass));
        ggN.put(new C0598a(true), Integer.valueOf(R.drawable.btn_all_blue));
        ggO.put(new C0598a(false), Integer.valueOf(R.color.btn_pass_text_color));
        ggO.put(new C0598a(true), Integer.valueOf(R.color.btn_agree_text_color));
    }

    /* renamed from: com.baidu.tieba.addresslist.im.newFriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private static class C0598a {
        private boolean ggQ;

        public C0598a(boolean z) {
            this.ggQ = z;
        }

        public int hashCode() {
            return (this.ggQ ? 1231 : 1237) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.ggQ == ((C0598a) obj).ggQ;
        }
    }

    public a(NewFriendsActivity newFriendsActivity) {
        this.ggL = newFriendsActivity;
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
    /* renamed from: ta */
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
            cVar.ggR = (HeadImageView) view.findViewById(R.id.friend_icon);
            cVar.ggS = (TextView) view.findViewById(R.id.friend_name);
            cVar.ggT = (TextView) view.findViewById(R.id.friend_info);
            cVar.ggU = (TextView) view.findViewById(R.id.friend_add_btn);
            view.setTag(cVar);
        }
        com.baidu.tieba.im.data.a item = getItem(i);
        cVar.c(item);
        cVar.ggU.setTag(Integer.valueOf(i));
        cVar.ggU.setOnClickListener(this);
        this.ggL.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.ggL.getLayoutMode().onModeChanged(view);
        Integer num = ggN.get(new C0598a(item.getStatus() == 1));
        if (num != null) {
            ao.setBackgroundResource(cVar.ggU, num.intValue());
        }
        Integer num2 = ggO.get(new C0598a(item.getStatus() == 1));
        if (num2 != null) {
            ao.setViewTextColor(cVar.ggU, num2.intValue(), 1);
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

    public void cb(List<com.baidu.tieba.im.data.a> list) {
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
            int eN = eN(aVar.getId());
            if (eN != -1) {
                this.data.remove(eN);
                this.data.add(0, aVar);
                return;
            }
            this.data.add(0, aVar);
        }
    }

    private int eN(long j) {
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

    /* loaded from: classes7.dex */
    private static class c {
        HeadImageView ggR;
        TextView ggS;
        TextView ggT;
        TextView ggU;

        private c() {
        }

        public void c(com.baidu.tieba.im.data.a aVar) {
            this.ggR.startLoad(aVar.getPortrait(), 12, false);
            this.ggS.setText(aVar.getName());
            if (!TextUtils.isEmpty(aVar.getContent())) {
                this.ggT.setText(aVar.getContent());
            } else {
                this.ggT.setText("");
            }
            int status = aVar.getStatus();
            this.ggU.setText(((Integer) a.ggM.get(status)).intValue());
            this.ggU.setEnabled(status == 0 || status == 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ggP != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.ggP.a(id, intValue, view, getItem(intValue));
        }
    }

    public void a(b bVar) {
        this.ggP = bVar;
    }
}
