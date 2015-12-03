package com.baidu.tieba.addresslist.im.newFriend;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class ai extends BaseAdapter implements View.OnClickListener {
    private static SparseArray<Integer> aIG = new SparseArray<>();
    private static HashMap<a, Integer> aIH = new HashMap<>();
    private static HashMap<a, Integer> aII = new HashMap<>();
    private NewFriendsActivity aIE;
    private List<com.baidu.tieba.im.data.b> aIF;
    private b aIJ;

    /* loaded from: classes.dex */
    public interface b {
        void a(int i, int i2, View view, com.baidu.tieba.im.data.b bVar);
    }

    static {
        aIG.put(0, Integer.valueOf(n.i.add));
        aIG.put(4, Integer.valueOf(n.i.added));
        aIG.put(1, Integer.valueOf(n.i.pass));
        aIG.put(2, Integer.valueOf(n.i.passed));
        aIG.put(3, Integer.valueOf(n.i.waiting));
        aIH.put(new a(false), Integer.valueOf(n.e.btn_pass));
        aIH.put(new a(true), Integer.valueOf(n.e.btn_all_blue));
        aII.put(new a(false), Integer.valueOf(n.c.btn_pass_text_color));
        aII.put(new a(true), Integer.valueOf(n.c.btn_agree_text_color));
    }

    /* loaded from: classes.dex */
    private static class a {
        private boolean aIK;

        public a(boolean z) {
            this.aIK = z;
        }

        public int hashCode() {
            return (this.aIK ? 1231 : 1237) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.aIK == ((a) obj).aIK;
        }
    }

    public ai(NewFriendsActivity newFriendsActivity) {
        this.aIE = newFriendsActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aIF == null) {
            return 0;
        }
        return this.aIF.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ff */
    public com.baidu.tieba.im.data.b getItem(int i) {
        return this.aIF.get(i);
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(n.g.add_new_friend_list_item, (ViewGroup) null);
            cVar = new c(null);
            cVar.aIL = (HeadImageView) view.findViewById(n.f.friend_icon);
            cVar.aIM = (TextView) view.findViewById(n.f.friend_name);
            cVar.aIN = (TextView) view.findViewById(n.f.friend_info);
            cVar.aIO = (TextView) view.findViewById(n.f.friend_add_btn);
            view.setTag(cVar);
        }
        com.baidu.tieba.im.data.b item = getItem(i);
        cVar.c(item);
        cVar.aIO.setTag(Integer.valueOf(i));
        cVar.aIO.setOnClickListener(this);
        this.aIE.getLayoutMode().af(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.aIE.getLayoutMode().k(view);
        Integer num = aIH.get(new a(item.getStatus() == 1));
        if (num != null) {
            com.baidu.tbadk.core.util.as.i((View) cVar.aIO, num.intValue());
        }
        Integer num2 = aII.get(new a(item.getStatus() == 1));
        if (num2 != null) {
            com.baidu.tbadk.core.util.as.b(cVar.aIO, num2.intValue(), 1);
        }
        return view;
    }

    public void setData(List<com.baidu.tieba.im.data.b> list) {
        this.aIF = list;
    }

    public synchronized void a(com.baidu.tieba.im.data.b bVar) {
        if (this.aIF != null) {
            this.aIF.remove(bVar);
        }
    }

    public void x(List<com.baidu.tieba.im.data.b> list) {
        if (this.aIF == null) {
            this.aIF = new ArrayList();
        }
        if (list != null) {
            for (com.baidu.tieba.im.data.b bVar : list) {
                b(bVar);
            }
        }
    }

    public void b(com.baidu.tieba.im.data.b bVar) {
        if (this.aIF == null) {
            this.aIF = new ArrayList();
        }
        if (bVar != null && bVar.getId() != 0) {
            int ah = ah(bVar.getId());
            if (ah != -1) {
                this.aIF.remove(ah);
                this.aIF.add(0, bVar);
                return;
            }
            this.aIF.add(0, bVar);
        }
    }

    private int ah(long j) {
        if (this.aIF != null) {
            int size = this.aIF.size();
            for (int i = 0; i < size; i++) {
                if (j == this.aIF.get(i).getId()) {
                    return i;
                }
            }
        }
        return -1;
    }

    /* loaded from: classes.dex */
    private static class c {
        HeadImageView aIL;
        TextView aIM;
        TextView aIN;
        TextView aIO;

        private c() {
        }

        /* synthetic */ c(c cVar) {
            this();
        }

        public void c(com.baidu.tieba.im.data.b bVar) {
            this.aIL.d(bVar.getPortrait(), 12, false);
            this.aIM.setText(bVar.getName());
            if (!TextUtils.isEmpty(bVar.getContent())) {
                this.aIN.setText(bVar.getContent());
            } else {
                this.aIN.setText("");
            }
            int status = bVar.getStatus();
            this.aIO.setText(((Integer) ai.aIG.get(status)).intValue());
            this.aIO.setEnabled(status == 0 || status == 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aIJ != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            this.aIJ.a(id, intValue, view, getItem(intValue));
        }
    }

    public void a(b bVar) {
        this.aIJ = bVar;
    }
}
