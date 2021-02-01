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
/* loaded from: classes8.dex */
public class a extends BaseAdapter implements View.OnClickListener {
    private static SparseArray<Integer> gjb = new SparseArray<>();
    private static HashMap<C0595a, Integer> gjc = new HashMap<>();
    private static HashMap<C0595a, Integer> gjd = new HashMap<>();
    private List<com.baidu.tieba.im.data.a> data;
    private NewFriendsActivity gja;
    private b gje;

    /* loaded from: classes8.dex */
    public interface b {
        void a(int i, int i2, View view, com.baidu.tieba.im.data.a aVar);
    }

    static {
        gjb.put(0, Integer.valueOf(R.string.add));
        gjb.put(4, Integer.valueOf(R.string.added));
        gjb.put(1, Integer.valueOf(R.string.pass));
        gjb.put(2, Integer.valueOf(R.string.passed));
        gjb.put(3, Integer.valueOf(R.string.waiting));
        gjc.put(new C0595a(false), Integer.valueOf(R.drawable.btn_pass));
        gjc.put(new C0595a(true), Integer.valueOf(R.drawable.btn_all_blue));
        gjd.put(new C0595a(false), Integer.valueOf(R.color.btn_pass_text_color));
        gjd.put(new C0595a(true), Integer.valueOf(R.color.btn_agree_text_color));
    }

    /* renamed from: com.baidu.tieba.addresslist.im.newFriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private static class C0595a {
        private boolean gjf;

        public C0595a(boolean z) {
            this.gjf = z;
        }

        public int hashCode() {
            return (this.gjf ? 1231 : 1237) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.gjf == ((C0595a) obj).gjf;
        }
    }

    public a(NewFriendsActivity newFriendsActivity) {
        this.gja = newFriendsActivity;
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
    /* renamed from: tf */
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
            cVar.gjg = (HeadImageView) view.findViewById(R.id.friend_icon);
            cVar.gjh = (TextView) view.findViewById(R.id.friend_name);
            cVar.gji = (TextView) view.findViewById(R.id.friend_info);
            cVar.gjj = (TextView) view.findViewById(R.id.friend_add_btn);
            view.setTag(cVar);
        }
        com.baidu.tieba.im.data.a item = getItem(i);
        cVar.c(item);
        cVar.gjj.setTag(Integer.valueOf(i));
        cVar.gjj.setOnClickListener(this);
        this.gja.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gja.getLayoutMode().onModeChanged(view);
        Integer num = gjc.get(new C0595a(item.getStatus() == 1));
        if (num != null) {
            ap.setBackgroundResource(cVar.gjj, num.intValue());
        }
        Integer num2 = gjd.get(new C0595a(item.getStatus() == 1));
        if (num2 != null) {
            ap.setViewTextColor(cVar.gjj, num2.intValue(), 1);
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

    /* loaded from: classes8.dex */
    private static class c {
        HeadImageView gjg;
        TextView gjh;
        TextView gji;
        TextView gjj;

        private c() {
        }

        public void c(com.baidu.tieba.im.data.a aVar) {
            this.gjg.startLoad(aVar.getPortrait(), 12, false);
            this.gjh.setText(aVar.getName());
            if (!TextUtils.isEmpty(aVar.getContent())) {
                this.gji.setText(aVar.getContent());
            } else {
                this.gji.setText("");
            }
            int status = aVar.getStatus();
            this.gjj.setText(((Integer) a.gjb.get(status)).intValue());
            this.gjj.setEnabled(status == 0 || status == 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gje != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.gje.a(id, intValue, view, getItem(intValue));
        }
    }

    public void a(b bVar) {
        this.gje = bVar;
    }
}
