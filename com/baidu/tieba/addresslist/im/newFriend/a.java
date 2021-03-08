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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@SuppressLint({"UseSparseArrays"})
/* loaded from: classes7.dex */
public class a extends BaseAdapter implements View.OnClickListener {
    private static SparseArray<Integer> gkS = new SparseArray<>();
    private static HashMap<C0602a, Integer> gkT = new HashMap<>();
    private static HashMap<C0602a, Integer> gkU = new HashMap<>();
    private List<com.baidu.tieba.im.data.a> data;
    private NewFriendsActivity gkR;
    private b gkV;

    /* loaded from: classes7.dex */
    public interface b {
        void a(int i, int i2, View view, com.baidu.tieba.im.data.a aVar);
    }

    static {
        gkS.put(0, Integer.valueOf(R.string.add));
        gkS.put(4, Integer.valueOf(R.string.added));
        gkS.put(1, Integer.valueOf(R.string.pass));
        gkS.put(2, Integer.valueOf(R.string.passed));
        gkS.put(3, Integer.valueOf(R.string.waiting));
        gkT.put(new C0602a(false), Integer.valueOf(R.drawable.btn_pass));
        gkT.put(new C0602a(true), Integer.valueOf(R.drawable.btn_all_blue));
        gkU.put(new C0602a(false), Integer.valueOf(R.color.btn_pass_text_color));
        gkU.put(new C0602a(true), Integer.valueOf(R.color.btn_agree_text_color));
    }

    /* renamed from: com.baidu.tieba.addresslist.im.newFriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private static class C0602a {
        private boolean gkW;

        public C0602a(boolean z) {
            this.gkW = z;
        }

        public int hashCode() {
            return (this.gkW ? 1231 : 1237) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.gkW == ((C0602a) obj).gkW;
        }
    }

    public a(NewFriendsActivity newFriendsActivity) {
        this.gkR = newFriendsActivity;
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
    /* renamed from: th */
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
            cVar.gkX = (HeadImageView) view.findViewById(R.id.friend_icon);
            cVar.gkY = (TextView) view.findViewById(R.id.friend_name);
            cVar.gkZ = (TextView) view.findViewById(R.id.friend_info);
            cVar.gla = (TextView) view.findViewById(R.id.friend_add_btn);
            view.setTag(cVar);
        }
        com.baidu.tieba.im.data.a item = getItem(i);
        cVar.c(item);
        cVar.gla.setTag(Integer.valueOf(i));
        cVar.gla.setOnClickListener(this);
        this.gkR.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gkR.getLayoutMode().onModeChanged(view);
        Integer num = gkT.get(new C0602a(item.getStatus() == 1));
        if (num != null) {
            ap.setBackgroundResource(cVar.gla, num.intValue());
        }
        Integer num2 = gkU.get(new C0602a(item.getStatus() == 1));
        if (num2 != null) {
            ap.setViewTextColor(cVar.gla, num2.intValue(), 1);
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

    public void bW(List<com.baidu.tieba.im.data.a> list) {
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
            int eT = eT(aVar.getId());
            if (eT != -1) {
                this.data.remove(eT);
                this.data.add(0, aVar);
                return;
            }
            this.data.add(0, aVar);
        }
    }

    private int eT(long j) {
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
        HeadImageView gkX;
        TextView gkY;
        TextView gkZ;
        TextView gla;

        private c() {
        }

        public void c(com.baidu.tieba.im.data.a aVar) {
            this.gkX.startLoad(aVar.getPortrait(), 12, false);
            this.gkY.setText(aVar.getName());
            if (!TextUtils.isEmpty(aVar.getContent())) {
                this.gkZ.setText(aVar.getContent());
            } else {
                this.gkZ.setText("");
            }
            int status = aVar.getStatus();
            this.gla.setText(((Integer) a.gkS.get(status)).intValue());
            this.gla.setEnabled(status == 0 || status == 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gkV != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.gkV.a(id, intValue, view, getItem(intValue));
        }
    }

    public void a(b bVar) {
        this.gkV = bVar;
    }
}
