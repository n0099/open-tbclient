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
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@SuppressLint({"UseSparseArrays"})
/* loaded from: classes8.dex */
public class a extends BaseAdapter implements View.OnClickListener {
    private static SparseArray<Integer> eBD = new SparseArray<>();
    private static HashMap<C0441a, Integer> eBE = new HashMap<>();
    private static HashMap<C0441a, Integer> eBF = new HashMap<>();
    private List<com.baidu.tieba.im.data.a> data;
    private NewFriendsActivity eBC;
    private b eBG;

    /* loaded from: classes8.dex */
    public interface b {
        void a(int i, int i2, View view, com.baidu.tieba.im.data.a aVar);
    }

    static {
        eBD.put(0, Integer.valueOf((int) R.string.add));
        eBD.put(4, Integer.valueOf((int) R.string.added));
        eBD.put(1, Integer.valueOf((int) R.string.pass));
        eBD.put(2, Integer.valueOf((int) R.string.passed));
        eBD.put(3, Integer.valueOf((int) R.string.waiting));
        eBE.put(new C0441a(false), Integer.valueOf((int) R.drawable.btn_pass));
        eBE.put(new C0441a(true), Integer.valueOf((int) R.drawable.btn_all_blue));
        eBF.put(new C0441a(false), Integer.valueOf((int) R.color.btn_pass_text_color));
        eBF.put(new C0441a(true), Integer.valueOf((int) R.color.btn_agree_text_color));
    }

    /* renamed from: com.baidu.tieba.addresslist.im.newFriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private static class C0441a {
        private boolean eBH;

        public C0441a(boolean z) {
            this.eBH = z;
        }

        public int hashCode() {
            return (this.eBH ? 1231 : 1237) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.eBH == ((C0441a) obj).eBH;
        }
    }

    public a(NewFriendsActivity newFriendsActivity) {
        this.eBC = newFriendsActivity;
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
    /* renamed from: oB */
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
            cVar.eBI = (HeadImageView) view.findViewById(R.id.friend_icon);
            cVar.eBJ = (TextView) view.findViewById(R.id.friend_name);
            cVar.eBK = (TextView) view.findViewById(R.id.friend_info);
            cVar.eBL = (TextView) view.findViewById(R.id.friend_add_btn);
            view.setTag(cVar);
        }
        com.baidu.tieba.im.data.a item = getItem(i);
        cVar.c(item);
        cVar.eBL.setTag(Integer.valueOf(i));
        cVar.eBL.setOnClickListener(this);
        this.eBC.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.eBC.getLayoutMode().onModeChanged(view);
        Integer num = eBE.get(new C0441a(item.getStatus() == 1));
        if (num != null) {
            am.setBackgroundResource(cVar.eBL, num.intValue());
        }
        Integer num2 = eBF.get(new C0441a(item.getStatus() == 1));
        if (num2 != null) {
            am.setViewTextColor(cVar.eBL, num2.intValue(), 1);
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

    public void bj(List<com.baidu.tieba.im.data.a> list) {
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
            int cZ = cZ(aVar.getId());
            if (cZ != -1) {
                this.data.remove(cZ);
                this.data.add(0, aVar);
                return;
            }
            this.data.add(0, aVar);
        }
    }

    private int cZ(long j) {
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

    /* loaded from: classes8.dex */
    private static class c {
        HeadImageView eBI;
        TextView eBJ;
        TextView eBK;
        TextView eBL;

        private c() {
        }

        public void c(com.baidu.tieba.im.data.a aVar) {
            this.eBI.startLoad(aVar.getPortrait(), 12, false);
            this.eBJ.setText(aVar.getName());
            if (!TextUtils.isEmpty(aVar.getContent())) {
                this.eBK.setText(aVar.getContent());
            } else {
                this.eBK.setText("");
            }
            int status = aVar.getStatus();
            this.eBL.setText(((Integer) a.eBD.get(status)).intValue());
            this.eBL.setEnabled(status == 0 || status == 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eBG != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.eBG.a(id, intValue, view, getItem(intValue));
        }
    }

    public void a(b bVar) {
        this.eBG = bVar;
    }
}
