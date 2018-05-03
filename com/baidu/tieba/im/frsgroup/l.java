package com.baidu.tieba.im.frsgroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.d;
import com.baidu.tieba.im.model.MembersModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes3.dex */
public class l extends BaseAdapter {
    private final MembersActivity dZb;
    private a dZc;
    private boolean dZd;
    private boolean dZf;
    private final Set<Long> dZg = new HashSet();
    private final List<UserData> dZh = new ArrayList();
    private ArrayList<IconData> dZi = null;
    private boolean dZe = false;

    /* loaded from: classes3.dex */
    public interface a {
        void nz(int i);
    }

    public void a(a aVar) {
        this.dZc = aVar;
    }

    public void cb(List<UserData> list) {
        this.dZh.addAll(list);
    }

    public void cc(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.dZh.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void aDY() {
        this.dZg.clear();
    }

    public Set<Long> aDZ() {
        return this.dZg;
    }

    public void f(Long l) {
        if (com.baidu.adp.lib.util.l.hf()) {
            if (this.dZg.contains(l)) {
                this.dZg.remove(l);
            } else {
                this.dZg.add(l);
            }
            notifyDataSetChanged();
            if (this.dZc != null) {
                this.dZc.nz(this.dZg.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.dZh.clear();
        }
        this.dZe = false;
        this.dZd = true;
    }

    public l(MembersActivity membersActivity) {
        this.dZb = membersActivity;
    }

    public void hd(boolean z) {
        this.dZd = z;
    }

    public boolean agl() {
        return this.dZd;
    }

    public void he(boolean z) {
        this.dZe = z;
    }

    public boolean aBe() {
        return this.dZf;
    }

    public void hf(boolean z) {
        this.dZf = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dZh != null) {
            int size = this.dZh.size();
            if (this.dZe) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.c(this.dZh, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.dZe && i == getCount() - 1) {
            return -2L;
        }
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItemId(i) >= 0 ? 0 : 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        b bVar;
        View view3;
        if (this.dZh != null) {
            if (view2 == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.dZb.getPageContext().getPageActivity()).inflate(d.i.im_members_list_foot, viewGroup, false);
                    bVar2.dZk = (LinearLayout) inflate.findViewById(d.g.list_more);
                    bVar2.dZl = (TextView) inflate.findViewById(d.g.more_title);
                    bVar2.dZm = (ProgressBar) inflate.findViewById(d.g.more_progress);
                    view3 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.dZb.getPageContext().getPageActivity()).inflate(d.i.im_members_list_item, viewGroup, false);
                    bVar2.dZo = (HeadImageView) inflate2.findViewById(d.g.item_head);
                    bVar2.dZo.setIsRound(false);
                    bVar2.dZo.setAutoChangeStyle(true);
                    bVar2.dYd = (TextView) inflate2.findViewById(d.g.item_name);
                    bVar2.dZp = (ImageView) inflate2.findViewById(d.g.item_sex);
                    bVar2.dZq = (TextView) inflate2.findViewById(d.g.item_time);
                    bVar2.dZr = (TextView) inflate2.findViewById(d.g.item_address);
                    bVar2.dZn = (ImageView) inflate2.findViewById(d.g.item_check);
                    bVar2.apM = (UserIconBox) inflate2.findViewById(d.g.user_tshow_icon_box);
                    bVar2.dZs = inflate2.findViewById(d.g.list_line);
                    bVar2.dZt = inflate2.findViewById(d.g.list_bottom_line);
                    view3 = inflate2;
                }
                view3.setTag(bVar2);
                bVar = bVar2;
                view2 = view3;
            } else {
                bVar = (b) view2.getTag();
            }
            bVar.dZs.setVisibility(i < getCount() + (-1) ? 0 : 8);
            bVar.dZt.setVisibility(i < getCount() + (-1) ? 8 : 0);
            if (getItemViewType(i) == 1) {
                if (this.dZd) {
                    bVar.dZl.setText(d.k.members_load_more_person);
                    bVar.dZm.setVisibility(0);
                } else {
                    bVar.dZl.setText(d.k.members_no_more_person);
                    bVar.dZm.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.dZo.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!an.isEmpty(portrait)) {
                        bVar.dZo.startLoad(portrait, 12, false);
                    }
                    bVar.dYd.setText(userData.getUserName());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.dZp.setVisibility(0);
                            ak.c(bVar.dZp, d.f.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.dZp.setVisibility(0);
                            ak.c(bVar.dZp, d.f.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.dZp.setVisibility(8);
                            break;
                    }
                    bVar.dZq.setText(d(userData));
                    bVar.dZr.setText(userData.getPosition());
                    this.dZi = userData.getTShowInfo();
                    if (bVar.apM != null) {
                        bVar.apM.a(this.dZi, 2, this.dZb.getResources().getDimensionPixelSize(d.e.ds38), this.dZb.getResources().getDimensionPixelSize(d.e.ds38), this.dZb.getResources().getDimensionPixelSize(d.e.ds8), true);
                    }
                    if (this.dZf) {
                        bVar.dZn.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.dZn.setTag(valueOf);
                        bVar.dZn.setSelected(this.dZg.contains(valueOf));
                        bVar.dZn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view4) {
                                view4.setSelected(!view4.isSelected());
                                if (view4.getTag() instanceof Long) {
                                    Long l = (Long) view4.getTag();
                                    if (view4.isSelected()) {
                                        l.this.dZg.add(l);
                                    } else {
                                        l.this.dZg.remove(l);
                                    }
                                    if (l.this.dZc != null) {
                                        l.this.dZc.nz(l.this.dZg.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.dZn.setVisibility(8);
                    }
                    aA(view2);
                }
            }
        }
        return view2;
    }

    private void aA(View view2) {
        this.dZb.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.dZb.getLayoutMode().u(view2);
    }

    private String d(UserData userData) {
        long lastReplyTime;
        MembersModel aDS = this.dZb.aDS();
        switch (aDS.getOrderType()) {
            case 0:
                lastReplyTime = userData.getLoginTime();
                break;
            case 1:
                lastReplyTime = userData.getLastReplyTime();
                break;
            case 2:
                lastReplyTime = userData.getInTime();
                break;
            default:
                lastReplyTime = 0;
                break;
        }
        if (lastReplyTime <= 0) {
            if (aDS.getOrderType() == 1) {
                return this.dZb.getPageContext().getString(d.k.members_no_speak);
            }
            return "";
        }
        return an.f(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes3.dex */
    static class b {
        UserIconBox apM = null;
        TextView dYd;
        LinearLayout dZk;
        TextView dZl;
        ProgressBar dZm;
        ImageView dZn;
        HeadImageView dZo;
        ImageView dZp;
        TextView dZq;
        TextView dZr;
        View dZs;
        View dZt;

        b() {
        }
    }
}
