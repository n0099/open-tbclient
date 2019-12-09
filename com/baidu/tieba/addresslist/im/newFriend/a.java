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
/* loaded from: classes3.dex */
public class a extends BaseAdapter implements View.OnClickListener {
    private static SparseArray<Integer> djq = new SparseArray<>();
    private static HashMap<C0311a, Integer> djr = new HashMap<>();
    private static HashMap<C0311a, Integer> djs = new HashMap<>();
    private List<com.baidu.tieba.im.data.a> data;
    private NewFriendsActivity djp;
    private b djt;

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i, int i2, View view, com.baidu.tieba.im.data.a aVar);
    }

    static {
        djq.put(0, Integer.valueOf((int) R.string.add));
        djq.put(4, Integer.valueOf((int) R.string.added));
        djq.put(1, Integer.valueOf((int) R.string.pass));
        djq.put(2, Integer.valueOf((int) R.string.passed));
        djq.put(3, Integer.valueOf((int) R.string.waiting));
        djr.put(new C0311a(false), Integer.valueOf((int) R.drawable.btn_pass));
        djr.put(new C0311a(true), Integer.valueOf((int) R.drawable.btn_all_blue));
        djs.put(new C0311a(false), Integer.valueOf((int) R.color.btn_pass_text_color));
        djs.put(new C0311a(true), Integer.valueOf((int) R.color.btn_agree_text_color));
    }

    /* renamed from: com.baidu.tieba.addresslist.im.newFriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0311a {
        private boolean dju;

        public C0311a(boolean z) {
            this.dju = z;
        }

        public int hashCode() {
            return (this.dju ? 1231 : 1237) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.dju == ((C0311a) obj).dju;
        }
    }

    public a(NewFriendsActivity newFriendsActivity) {
        this.djp = newFriendsActivity;
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
    /* renamed from: lH */
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
            cVar.djv = (HeadImageView) view.findViewById(R.id.friend_icon);
            cVar.djw = (TextView) view.findViewById(R.id.friend_name);
            cVar.djx = (TextView) view.findViewById(R.id.friend_info);
            cVar.djy = (TextView) view.findViewById(R.id.friend_add_btn);
            view.setTag(cVar);
        }
        com.baidu.tieba.im.data.a item = getItem(i);
        cVar.c(item);
        cVar.djy.setTag(Integer.valueOf(i));
        cVar.djy.setOnClickListener(this);
        this.djp.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.djp.getLayoutMode().onModeChanged(view);
        Integer num = djr.get(new C0311a(item.getStatus() == 1));
        if (num != null) {
            am.setBackgroundResource(cVar.djy, num.intValue());
        }
        Integer num2 = djs.get(new C0311a(item.getStatus() == 1));
        if (num2 != null) {
            am.setViewTextColor(cVar.djy, num2.intValue(), 1);
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

    public void aT(List<com.baidu.tieba.im.data.a> list) {
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
            int bH = bH(aVar.getId());
            if (bH != -1) {
                this.data.remove(bH);
                this.data.add(0, aVar);
                return;
            }
            this.data.add(0, aVar);
        }
    }

    private int bH(long j) {
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

    /* loaded from: classes3.dex */
    private static class c {
        HeadImageView djv;
        TextView djw;
        TextView djx;
        TextView djy;

        private c() {
        }

        public void c(com.baidu.tieba.im.data.a aVar) {
            this.djv.startLoad(aVar.getPortrait(), 12, false);
            this.djw.setText(aVar.getName());
            if (!TextUtils.isEmpty(aVar.getContent())) {
                this.djx.setText(aVar.getContent());
            } else {
                this.djx.setText("");
            }
            int status = aVar.getStatus();
            this.djy.setText(((Integer) a.djq.get(status)).intValue());
            this.djy.setEnabled(status == 0 || status == 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.djt != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.djt.a(id, intValue, view, getItem(intValue));
        }
    }

    public void a(b bVar) {
        this.djt = bVar;
    }
}
