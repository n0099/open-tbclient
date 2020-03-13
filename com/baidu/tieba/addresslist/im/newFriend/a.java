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
    private static SparseArray<Integer> ebA = new SparseArray<>();
    private static HashMap<C0410a, Integer> ebB = new HashMap<>();
    private static HashMap<C0410a, Integer> ebC = new HashMap<>();
    private List<com.baidu.tieba.im.data.a> data;
    private b ebD;
    private NewFriendsActivity ebz;

    /* loaded from: classes8.dex */
    public interface b {
        void a(int i, int i2, View view, com.baidu.tieba.im.data.a aVar);
    }

    static {
        ebA.put(0, Integer.valueOf((int) R.string.add));
        ebA.put(4, Integer.valueOf((int) R.string.added));
        ebA.put(1, Integer.valueOf((int) R.string.pass));
        ebA.put(2, Integer.valueOf((int) R.string.passed));
        ebA.put(3, Integer.valueOf((int) R.string.waiting));
        ebB.put(new C0410a(false), Integer.valueOf((int) R.drawable.btn_pass));
        ebB.put(new C0410a(true), Integer.valueOf((int) R.drawable.btn_all_blue));
        ebC.put(new C0410a(false), Integer.valueOf((int) R.color.btn_pass_text_color));
        ebC.put(new C0410a(true), Integer.valueOf((int) R.color.btn_agree_text_color));
    }

    /* renamed from: com.baidu.tieba.addresslist.im.newFriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private static class C0410a {
        private boolean ebE;

        public C0410a(boolean z) {
            this.ebE = z;
        }

        public int hashCode() {
            return (this.ebE ? 1231 : 1237) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.ebE == ((C0410a) obj).ebE;
        }
    }

    public a(NewFriendsActivity newFriendsActivity) {
        this.ebz = newFriendsActivity;
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
    /* renamed from: om */
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
            cVar.ebF = (HeadImageView) view.findViewById(R.id.friend_icon);
            cVar.ebG = (TextView) view.findViewById(R.id.friend_name);
            cVar.ebH = (TextView) view.findViewById(R.id.friend_info);
            cVar.ebI = (TextView) view.findViewById(R.id.friend_add_btn);
            view.setTag(cVar);
        }
        com.baidu.tieba.im.data.a item = getItem(i);
        cVar.c(item);
        cVar.ebI.setTag(Integer.valueOf(i));
        cVar.ebI.setOnClickListener(this);
        this.ebz.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.ebz.getLayoutMode().onModeChanged(view);
        Integer num = ebB.get(new C0410a(item.getStatus() == 1));
        if (num != null) {
            am.setBackgroundResource(cVar.ebI, num.intValue());
        }
        Integer num2 = ebC.get(new C0410a(item.getStatus() == 1));
        if (num2 != null) {
            am.setViewTextColor(cVar.ebI, num2.intValue(), 1);
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

    public void aZ(List<com.baidu.tieba.im.data.a> list) {
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
            int cs = cs(aVar.getId());
            if (cs != -1) {
                this.data.remove(cs);
                this.data.add(0, aVar);
                return;
            }
            this.data.add(0, aVar);
        }
    }

    private int cs(long j) {
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
        HeadImageView ebF;
        TextView ebG;
        TextView ebH;
        TextView ebI;

        private c() {
        }

        public void c(com.baidu.tieba.im.data.a aVar) {
            this.ebF.startLoad(aVar.getPortrait(), 12, false);
            this.ebG.setText(aVar.getName());
            if (!TextUtils.isEmpty(aVar.getContent())) {
                this.ebH.setText(aVar.getContent());
            } else {
                this.ebH.setText("");
            }
            int status = aVar.getStatus();
            this.ebI.setText(((Integer) a.ebA.get(status)).intValue());
            this.ebI.setEnabled(status == 0 || status == 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ebD != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.ebD.a(id, intValue, view, getItem(intValue));
        }
    }

    public void a(b bVar) {
        this.ebD = bVar;
    }
}
