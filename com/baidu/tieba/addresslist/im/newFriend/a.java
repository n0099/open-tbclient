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
/* loaded from: classes21.dex */
public class a extends BaseAdapter implements View.OnClickListener {
    private static SparseArray<Integer> fUk = new SparseArray<>();
    private static HashMap<C0612a, Integer> fUl = new HashMap<>();
    private static HashMap<C0612a, Integer> fUm = new HashMap<>();
    private List<com.baidu.tieba.im.data.a> data;
    private NewFriendsActivity fUj;
    private b fUn;

    /* loaded from: classes21.dex */
    public interface b {
        void a(int i, int i2, View view, com.baidu.tieba.im.data.a aVar);
    }

    static {
        fUk.put(0, Integer.valueOf(R.string.add));
        fUk.put(4, Integer.valueOf(R.string.added));
        fUk.put(1, Integer.valueOf(R.string.pass));
        fUk.put(2, Integer.valueOf(R.string.passed));
        fUk.put(3, Integer.valueOf(R.string.waiting));
        fUl.put(new C0612a(false), Integer.valueOf(R.drawable.btn_pass));
        fUl.put(new C0612a(true), Integer.valueOf(R.drawable.btn_all_blue));
        fUm.put(new C0612a(false), Integer.valueOf(R.color.btn_pass_text_color));
        fUm.put(new C0612a(true), Integer.valueOf(R.color.btn_agree_text_color));
    }

    /* renamed from: com.baidu.tieba.addresslist.im.newFriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    private static class C0612a {
        private boolean fUo;

        public C0612a(boolean z) {
            this.fUo = z;
        }

        public int hashCode() {
            return (this.fUo ? 1231 : 1237) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.fUo == ((C0612a) obj).fUo;
        }
    }

    public a(NewFriendsActivity newFriendsActivity) {
        this.fUj = newFriendsActivity;
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
    /* renamed from: tt */
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
            cVar.fUp = (HeadImageView) view.findViewById(R.id.friend_icon);
            cVar.fUq = (TextView) view.findViewById(R.id.friend_name);
            cVar.fUr = (TextView) view.findViewById(R.id.friend_info);
            cVar.fUs = (TextView) view.findViewById(R.id.friend_add_btn);
            view.setTag(cVar);
        }
        com.baidu.tieba.im.data.a item = getItem(i);
        cVar.c(item);
        cVar.fUs.setTag(Integer.valueOf(i));
        cVar.fUs.setOnClickListener(this);
        this.fUj.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.fUj.getLayoutMode().onModeChanged(view);
        Integer num = fUl.get(new C0612a(item.getStatus() == 1));
        if (num != null) {
            ap.setBackgroundResource(cVar.fUs, num.intValue());
        }
        Integer num2 = fUm.get(new C0612a(item.getStatus() == 1));
        if (num2 != null) {
            ap.setViewTextColor(cVar.fUs, num2.intValue(), 1);
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

    public void bQ(List<com.baidu.tieba.im.data.a> list) {
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
            int ek = ek(aVar.getId());
            if (ek != -1) {
                this.data.remove(ek);
                this.data.add(0, aVar);
                return;
            }
            this.data.add(0, aVar);
        }
    }

    private int ek(long j) {
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

    /* loaded from: classes21.dex */
    private static class c {
        HeadImageView fUp;
        TextView fUq;
        TextView fUr;
        TextView fUs;

        private c() {
        }

        public void c(com.baidu.tieba.im.data.a aVar) {
            this.fUp.startLoad(aVar.getPortrait(), 12, false);
            this.fUq.setText(aVar.getName());
            if (!TextUtils.isEmpty(aVar.getContent())) {
                this.fUr.setText(aVar.getContent());
            } else {
                this.fUr.setText("");
            }
            int status = aVar.getStatus();
            this.fUs.setText(((Integer) a.fUk.get(status)).intValue());
            this.fUs.setEnabled(status == 0 || status == 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fUn != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.fUn.a(id, intValue, view, getItem(intValue));
        }
    }

    public void a(b bVar) {
        this.fUn = bVar;
    }
}
