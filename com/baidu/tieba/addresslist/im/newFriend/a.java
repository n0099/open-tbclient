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
/* loaded from: classes8.dex */
public class a extends BaseAdapter implements View.OnClickListener {
    private static SparseArray<Integer> glu = new SparseArray<>();
    private static HashMap<C0615a, Integer> glv = new HashMap<>();
    private static HashMap<C0615a, Integer> glw = new HashMap<>();
    private List<com.baidu.tieba.im.data.a> data;
    private NewFriendsActivity glt;
    private b glx;

    /* loaded from: classes8.dex */
    public interface b {
        void a(int i, int i2, View view, com.baidu.tieba.im.data.a aVar);
    }

    static {
        glu.put(0, Integer.valueOf(R.string.add));
        glu.put(4, Integer.valueOf(R.string.added));
        glu.put(1, Integer.valueOf(R.string.pass));
        glu.put(2, Integer.valueOf(R.string.passed));
        glu.put(3, Integer.valueOf(R.string.waiting));
        glv.put(new C0615a(false), Integer.valueOf(R.drawable.btn_pass));
        glv.put(new C0615a(true), Integer.valueOf(R.drawable.btn_all_blue));
        glw.put(new C0615a(false), Integer.valueOf(R.color.btn_pass_text_color));
        glw.put(new C0615a(true), Integer.valueOf(R.color.btn_agree_text_color));
    }

    /* renamed from: com.baidu.tieba.addresslist.im.newFriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private static class C0615a {
        private boolean gly;

        public C0615a(boolean z) {
            this.gly = z;
        }

        public int hashCode() {
            return (this.gly ? 1231 : 1237) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.gly == ((C0615a) obj).gly;
        }
    }

    public a(NewFriendsActivity newFriendsActivity) {
        this.glt = newFriendsActivity;
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
    /* renamed from: uG */
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
            cVar.glz = (HeadImageView) view.findViewById(R.id.friend_icon);
            cVar.glA = (TextView) view.findViewById(R.id.friend_name);
            cVar.glB = (TextView) view.findViewById(R.id.friend_info);
            cVar.glC = (TextView) view.findViewById(R.id.friend_add_btn);
            view.setTag(cVar);
        }
        com.baidu.tieba.im.data.a item = getItem(i);
        cVar.c(item);
        cVar.glC.setTag(Integer.valueOf(i));
        cVar.glC.setOnClickListener(this);
        this.glt.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.glt.getLayoutMode().onModeChanged(view);
        Integer num = glv.get(new C0615a(item.getStatus() == 1));
        if (num != null) {
            ao.setBackgroundResource(cVar.glC, num.intValue());
        }
        Integer num2 = glw.get(new C0615a(item.getStatus() == 1));
        if (num2 != null) {
            ao.setViewTextColor(cVar.glC, num2.intValue(), 1);
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

    /* loaded from: classes8.dex */
    private static class c {
        TextView glA;
        TextView glB;
        TextView glC;
        HeadImageView glz;

        private c() {
        }

        public void c(com.baidu.tieba.im.data.a aVar) {
            this.glz.startLoad(aVar.getPortrait(), 12, false);
            this.glA.setText(aVar.getName());
            if (!TextUtils.isEmpty(aVar.getContent())) {
                this.glB.setText(aVar.getContent());
            } else {
                this.glB.setText("");
            }
            int status = aVar.getStatus();
            this.glC.setText(((Integer) a.glu.get(status)).intValue());
            this.glC.setEnabled(status == 0 || status == 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.glx != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.glx.a(id, intValue, view, getItem(intValue));
        }
    }

    public void a(b bVar) {
        this.glx = bVar;
    }
}
