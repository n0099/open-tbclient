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
/* loaded from: classes15.dex */
public class a extends BaseAdapter implements View.OnClickListener {
    private List<com.baidu.tieba.im.data.a> data;
    private b fqB;
    private NewFriendsActivity fqx;
    private static SparseArray<Integer> fqy = new SparseArray<>();
    private static HashMap<C0573a, Integer> fqz = new HashMap<>();
    private static HashMap<C0573a, Integer> fqA = new HashMap<>();

    /* loaded from: classes15.dex */
    public interface b {
        void a(int i, int i2, View view, com.baidu.tieba.im.data.a aVar);
    }

    static {
        fqy.put(0, Integer.valueOf(R.string.add));
        fqy.put(4, Integer.valueOf(R.string.added));
        fqy.put(1, Integer.valueOf(R.string.pass));
        fqy.put(2, Integer.valueOf(R.string.passed));
        fqy.put(3, Integer.valueOf(R.string.waiting));
        fqz.put(new C0573a(false), Integer.valueOf(R.drawable.btn_pass));
        fqz.put(new C0573a(true), Integer.valueOf(R.drawable.btn_all_blue));
        fqA.put(new C0573a(false), Integer.valueOf(R.color.btn_pass_text_color));
        fqA.put(new C0573a(true), Integer.valueOf(R.color.btn_agree_text_color));
    }

    /* renamed from: com.baidu.tieba.addresslist.im.newFriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    private static class C0573a {
        private boolean fqC;

        public C0573a(boolean z) {
            this.fqC = z;
        }

        public int hashCode() {
            return (this.fqC ? 1231 : 1237) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.fqC == ((C0573a) obj).fqC;
        }
    }

    public a(NewFriendsActivity newFriendsActivity) {
        this.fqx = newFriendsActivity;
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
    /* renamed from: si */
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
            cVar.fqD = (HeadImageView) view.findViewById(R.id.friend_icon);
            cVar.fqE = (TextView) view.findViewById(R.id.friend_name);
            cVar.fqF = (TextView) view.findViewById(R.id.friend_info);
            cVar.fqG = (TextView) view.findViewById(R.id.friend_add_btn);
            view.setTag(cVar);
        }
        com.baidu.tieba.im.data.a item = getItem(i);
        cVar.c(item);
        cVar.fqG.setTag(Integer.valueOf(i));
        cVar.fqG.setOnClickListener(this);
        this.fqx.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.fqx.getLayoutMode().onModeChanged(view);
        Integer num = fqz.get(new C0573a(item.getStatus() == 1));
        if (num != null) {
            ap.setBackgroundResource(cVar.fqG, num.intValue());
        }
        Integer num2 = fqA.get(new C0573a(item.getStatus() == 1));
        if (num2 != null) {
            ap.setViewTextColor(cVar.fqG, num2.intValue(), 1);
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

    public void bs(List<com.baidu.tieba.im.data.a> list) {
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
            int dC = dC(aVar.getId());
            if (dC != -1) {
                this.data.remove(dC);
                this.data.add(0, aVar);
                return;
            }
            this.data.add(0, aVar);
        }
    }

    private int dC(long j) {
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

    /* loaded from: classes15.dex */
    private static class c {
        HeadImageView fqD;
        TextView fqE;
        TextView fqF;
        TextView fqG;

        private c() {
        }

        public void c(com.baidu.tieba.im.data.a aVar) {
            this.fqD.startLoad(aVar.getPortrait(), 12, false);
            this.fqE.setText(aVar.getName());
            if (!TextUtils.isEmpty(aVar.getContent())) {
                this.fqF.setText(aVar.getContent());
            } else {
                this.fqF.setText("");
            }
            int status = aVar.getStatus();
            this.fqG.setText(((Integer) a.fqy.get(status)).intValue());
            this.fqG.setEnabled(status == 0 || status == 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fqB != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.fqB.a(id, intValue, view, getItem(intValue));
        }
    }

    public void a(b bVar) {
        this.fqB = bVar;
    }
}
