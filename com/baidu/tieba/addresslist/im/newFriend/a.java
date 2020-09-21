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
/* loaded from: classes20.dex */
public class a extends BaseAdapter implements View.OnClickListener {
    private static SparseArray<Integer> ftQ = new SparseArray<>();
    private static HashMap<C0569a, Integer> ftR = new HashMap<>();
    private static HashMap<C0569a, Integer> ftS = new HashMap<>();
    private List<com.baidu.tieba.im.data.a> data;
    private NewFriendsActivity ftP;
    private b ftT;

    /* loaded from: classes20.dex */
    public interface b {
        void a(int i, int i2, View view, com.baidu.tieba.im.data.a aVar);
    }

    static {
        ftQ.put(0, Integer.valueOf(R.string.add));
        ftQ.put(4, Integer.valueOf(R.string.added));
        ftQ.put(1, Integer.valueOf(R.string.pass));
        ftQ.put(2, Integer.valueOf(R.string.passed));
        ftQ.put(3, Integer.valueOf(R.string.waiting));
        ftR.put(new C0569a(false), Integer.valueOf(R.drawable.btn_pass));
        ftR.put(new C0569a(true), Integer.valueOf(R.drawable.btn_all_blue));
        ftS.put(new C0569a(false), Integer.valueOf(R.color.btn_pass_text_color));
        ftS.put(new C0569a(true), Integer.valueOf(R.color.btn_agree_text_color));
    }

    /* renamed from: com.baidu.tieba.addresslist.im.newFriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    private static class C0569a {
        private boolean ftU;

        public C0569a(boolean z) {
            this.ftU = z;
        }

        public int hashCode() {
            return (this.ftU ? 1231 : 1237) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.ftU == ((C0569a) obj).ftU;
        }
    }

    public a(NewFriendsActivity newFriendsActivity) {
        this.ftP = newFriendsActivity;
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
    /* renamed from: sA */
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
            cVar.ftV = (HeadImageView) view.findViewById(R.id.friend_icon);
            cVar.ftW = (TextView) view.findViewById(R.id.friend_name);
            cVar.ftX = (TextView) view.findViewById(R.id.friend_info);
            cVar.ftY = (TextView) view.findViewById(R.id.friend_add_btn);
            view.setTag(cVar);
        }
        com.baidu.tieba.im.data.a item = getItem(i);
        cVar.c(item);
        cVar.ftY.setTag(Integer.valueOf(i));
        cVar.ftY.setOnClickListener(this);
        this.ftP.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.ftP.getLayoutMode().onModeChanged(view);
        Integer num = ftR.get(new C0569a(item.getStatus() == 1));
        if (num != null) {
            ap.setBackgroundResource(cVar.ftY, num.intValue());
        }
        Integer num2 = ftS.get(new C0569a(item.getStatus() == 1));
        if (num2 != null) {
            ap.setViewTextColor(cVar.ftY, num2.intValue(), 1);
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

    public void bx(List<com.baidu.tieba.im.data.a> list) {
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
            int dD = dD(aVar.getId());
            if (dD != -1) {
                this.data.remove(dD);
                this.data.add(0, aVar);
                return;
            }
            this.data.add(0, aVar);
        }
    }

    private int dD(long j) {
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

    /* loaded from: classes20.dex */
    private static class c {
        HeadImageView ftV;
        TextView ftW;
        TextView ftX;
        TextView ftY;

        private c() {
        }

        public void c(com.baidu.tieba.im.data.a aVar) {
            this.ftV.startLoad(aVar.getPortrait(), 12, false);
            this.ftW.setText(aVar.getName());
            if (!TextUtils.isEmpty(aVar.getContent())) {
                this.ftX.setText(aVar.getContent());
            } else {
                this.ftX.setText("");
            }
            int status = aVar.getStatus();
            this.ftY.setText(((Integer) a.ftQ.get(status)).intValue());
            this.ftY.setEnabled(status == 0 || status == 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ftT != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.ftT.a(id, intValue, view, getItem(intValue));
        }
    }

    public void a(b bVar) {
        this.ftT = bVar;
    }
}
