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
    private final MembersActivity dZe;
    private a dZf;
    private boolean dZg;
    private boolean dZi;
    private final Set<Long> dZj = new HashSet();
    private final List<UserData> dZk = new ArrayList();
    private ArrayList<IconData> dZl = null;
    private boolean dZh = false;

    /* loaded from: classes3.dex */
    public interface a {
        void nA(int i);
    }

    public void a(a aVar) {
        this.dZf = aVar;
    }

    public void cb(List<UserData> list) {
        this.dZk.addAll(list);
    }

    public void cc(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.dZk.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void aDY() {
        this.dZj.clear();
    }

    public Set<Long> aDZ() {
        return this.dZj;
    }

    public void f(Long l) {
        if (com.baidu.adp.lib.util.l.hf()) {
            if (this.dZj.contains(l)) {
                this.dZj.remove(l);
            } else {
                this.dZj.add(l);
            }
            notifyDataSetChanged();
            if (this.dZf != null) {
                this.dZf.nA(this.dZj.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.dZk.clear();
        }
        this.dZh = false;
        this.dZg = true;
    }

    public l(MembersActivity membersActivity) {
        this.dZe = membersActivity;
    }

    public void hd(boolean z) {
        this.dZg = z;
    }

    public boolean agl() {
        return this.dZg;
    }

    public void he(boolean z) {
        this.dZh = z;
    }

    public boolean aBe() {
        return this.dZi;
    }

    public void hf(boolean z) {
        this.dZi = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dZk != null) {
            int size = this.dZk.size();
            if (this.dZh) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.c(this.dZk, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.dZh && i == getCount() - 1) {
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
        if (this.dZk != null) {
            if (view2 == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.dZe.getPageContext().getPageActivity()).inflate(d.i.im_members_list_foot, viewGroup, false);
                    bVar2.dZn = (LinearLayout) inflate.findViewById(d.g.list_more);
                    bVar2.dZo = (TextView) inflate.findViewById(d.g.more_title);
                    bVar2.dZp = (ProgressBar) inflate.findViewById(d.g.more_progress);
                    view3 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.dZe.getPageContext().getPageActivity()).inflate(d.i.im_members_list_item, viewGroup, false);
                    bVar2.dZr = (HeadImageView) inflate2.findViewById(d.g.item_head);
                    bVar2.dZr.setIsRound(false);
                    bVar2.dZr.setAutoChangeStyle(true);
                    bVar2.dYg = (TextView) inflate2.findViewById(d.g.item_name);
                    bVar2.dZs = (ImageView) inflate2.findViewById(d.g.item_sex);
                    bVar2.dZt = (TextView) inflate2.findViewById(d.g.item_time);
                    bVar2.dZu = (TextView) inflate2.findViewById(d.g.item_address);
                    bVar2.dZq = (ImageView) inflate2.findViewById(d.g.item_check);
                    bVar2.apM = (UserIconBox) inflate2.findViewById(d.g.user_tshow_icon_box);
                    bVar2.dZv = inflate2.findViewById(d.g.list_line);
                    bVar2.dZw = inflate2.findViewById(d.g.list_bottom_line);
                    view3 = inflate2;
                }
                view3.setTag(bVar2);
                bVar = bVar2;
                view2 = view3;
            } else {
                bVar = (b) view2.getTag();
            }
            bVar.dZv.setVisibility(i < getCount() + (-1) ? 0 : 8);
            bVar.dZw.setVisibility(i < getCount() + (-1) ? 8 : 0);
            if (getItemViewType(i) == 1) {
                if (this.dZg) {
                    bVar.dZo.setText(d.k.members_load_more_person);
                    bVar.dZp.setVisibility(0);
                } else {
                    bVar.dZo.setText(d.k.members_no_more_person);
                    bVar.dZp.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.dZr.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!an.isEmpty(portrait)) {
                        bVar.dZr.startLoad(portrait, 12, false);
                    }
                    bVar.dYg.setText(userData.getUserName());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.dZs.setVisibility(0);
                            ak.c(bVar.dZs, d.f.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.dZs.setVisibility(0);
                            ak.c(bVar.dZs, d.f.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.dZs.setVisibility(8);
                            break;
                    }
                    bVar.dZt.setText(d(userData));
                    bVar.dZu.setText(userData.getPosition());
                    this.dZl = userData.getTShowInfo();
                    if (bVar.apM != null) {
                        bVar.apM.a(this.dZl, 2, this.dZe.getResources().getDimensionPixelSize(d.e.ds38), this.dZe.getResources().getDimensionPixelSize(d.e.ds38), this.dZe.getResources().getDimensionPixelSize(d.e.ds8), true);
                    }
                    if (this.dZi) {
                        bVar.dZq.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.dZq.setTag(valueOf);
                        bVar.dZq.setSelected(this.dZj.contains(valueOf));
                        bVar.dZq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view4) {
                                view4.setSelected(!view4.isSelected());
                                if (view4.getTag() instanceof Long) {
                                    Long l = (Long) view4.getTag();
                                    if (view4.isSelected()) {
                                        l.this.dZj.add(l);
                                    } else {
                                        l.this.dZj.remove(l);
                                    }
                                    if (l.this.dZf != null) {
                                        l.this.dZf.nA(l.this.dZj.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.dZq.setVisibility(8);
                    }
                    aA(view2);
                }
            }
        }
        return view2;
    }

    private void aA(View view2) {
        this.dZe.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.dZe.getLayoutMode().u(view2);
    }

    private String d(UserData userData) {
        long lastReplyTime;
        MembersModel aDS = this.dZe.aDS();
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
                return this.dZe.getPageContext().getString(d.k.members_no_speak);
            }
            return "";
        }
        return an.f(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes3.dex */
    static class b {
        UserIconBox apM = null;
        TextView dYg;
        LinearLayout dZn;
        TextView dZo;
        ProgressBar dZp;
        ImageView dZq;
        HeadImageView dZr;
        ImageView dZs;
        TextView dZt;
        TextView dZu;
        View dZv;
        View dZw;

        b() {
        }
    }
}
