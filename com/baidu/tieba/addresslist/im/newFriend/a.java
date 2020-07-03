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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@SuppressLint({"UseSparseArrays"})
/* loaded from: classes8.dex */
public class a extends BaseAdapter implements View.OnClickListener {
    private static SparseArray<Integer> faD = new SparseArray<>();
    private static HashMap<C0517a, Integer> faE = new HashMap<>();
    private static HashMap<C0517a, Integer> faF = new HashMap<>();
    private List<com.baidu.tieba.im.data.a> data;
    private NewFriendsActivity faC;
    private b faG;

    /* loaded from: classes8.dex */
    public interface b {
        void a(int i, int i2, View view, com.baidu.tieba.im.data.a aVar);
    }

    static {
        faD.put(0, Integer.valueOf((int) R.string.add));
        faD.put(4, Integer.valueOf((int) R.string.added));
        faD.put(1, Integer.valueOf((int) R.string.pass));
        faD.put(2, Integer.valueOf((int) R.string.passed));
        faD.put(3, Integer.valueOf((int) R.string.waiting));
        faE.put(new C0517a(false), Integer.valueOf((int) R.drawable.btn_pass));
        faE.put(new C0517a(true), Integer.valueOf((int) R.drawable.btn_all_blue));
        faF.put(new C0517a(false), Integer.valueOf((int) R.color.btn_pass_text_color));
        faF.put(new C0517a(true), Integer.valueOf((int) R.color.btn_agree_text_color));
    }

    /* renamed from: com.baidu.tieba.addresslist.im.newFriend.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private static class C0517a {
        private boolean faH;

        public C0517a(boolean z) {
            this.faH = z;
        }

        public int hashCode() {
            return (this.faH ? 1231 : 1237) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.faH == ((C0517a) obj).faH;
        }
    }

    public a(NewFriendsActivity newFriendsActivity) {
        this.faC = newFriendsActivity;
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
    /* renamed from: pJ */
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
            cVar.faI = (HeadImageView) view.findViewById(R.id.friend_icon);
            cVar.faJ = (TextView) view.findViewById(R.id.friend_name);
            cVar.faK = (TextView) view.findViewById(R.id.friend_info);
            cVar.faL = (TextView) view.findViewById(R.id.friend_add_btn);
            view.setTag(cVar);
        }
        com.baidu.tieba.im.data.a item = getItem(i);
        cVar.c(item);
        cVar.faL.setTag(Integer.valueOf(i));
        cVar.faL.setOnClickListener(this);
        this.faC.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.faC.getLayoutMode().onModeChanged(view);
        Integer num = faE.get(new C0517a(item.getStatus() == 1));
        if (num != null) {
            an.setBackgroundResource(cVar.faL, num.intValue());
        }
        Integer num2 = faF.get(new C0517a(item.getStatus() == 1));
        if (num2 != null) {
            an.setViewTextColor(cVar.faL, num2.intValue(), 1);
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

    public void bo(List<com.baidu.tieba.im.data.a> list) {
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
            int dd = dd(aVar.getId());
            if (dd != -1) {
                this.data.remove(dd);
                this.data.add(0, aVar);
                return;
            }
            this.data.add(0, aVar);
        }
    }

    private int dd(long j) {
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
        HeadImageView faI;
        TextView faJ;
        TextView faK;
        TextView faL;

        private c() {
        }

        public void c(com.baidu.tieba.im.data.a aVar) {
            this.faI.startLoad(aVar.getPortrait(), 12, false);
            this.faJ.setText(aVar.getName());
            if (!TextUtils.isEmpty(aVar.getContent())) {
                this.faK.setText(aVar.getContent());
            } else {
                this.faK.setText("");
            }
            int status = aVar.getStatus();
            this.faL.setText(((Integer) a.faD.get(status)).intValue());
            this.faL.setEnabled(status == 0 || status == 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.faG != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.faG.a(id, intValue, view, getItem(intValue));
        }
    }

    public void a(b bVar) {
        this.faG = bVar;
    }
}
