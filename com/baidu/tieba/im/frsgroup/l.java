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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.e;
import com.baidu.tieba.im.model.MembersModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes3.dex */
public class l extends BaseAdapter {
    private final MembersActivity eTV;
    private a eTW;
    private boolean eTX;
    private boolean eTZ;
    private final Set<Long> eUa = new HashSet();
    private final List<UserData> eUb = new ArrayList();
    private ArrayList<IconData> eUc = null;
    private boolean eTY = false;

    /* loaded from: classes3.dex */
    public interface a {
        void qi(int i);
    }

    public void a(a aVar) {
        this.eTW = aVar;
    }

    public void cH(List<UserData> list) {
        this.eUb.addAll(list);
    }

    public void cI(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.eUb.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void aSC() {
        this.eUa.clear();
    }

    public Set<Long> aSD() {
        return this.eUa;
    }

    public void h(Long l) {
        if (com.baidu.adp.lib.util.l.lk()) {
            if (this.eUa.contains(l)) {
                this.eUa.remove(l);
            } else {
                this.eUa.add(l);
            }
            notifyDataSetChanged();
            if (this.eTW != null) {
                this.eTW.qi(this.eUa.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.eUb.clear();
        }
        this.eTY = false;
        this.eTX = true;
    }

    public l(MembersActivity membersActivity) {
        this.eTV = membersActivity;
    }

    public void iC(boolean z) {
        this.eTX = z;
    }

    public boolean arD() {
        return this.eTX;
    }

    public void iD(boolean z) {
        this.eTY = z;
    }

    public boolean aPK() {
        return this.eTZ;
    }

    public void iE(boolean z) {
        this.eTZ = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eUb != null) {
            int size = this.eUb.size();
            if (this.eTY) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.d(this.eUb, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.eTY && i == getCount() - 1) {
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        View view2;
        if (this.eUb != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.eTV.getPageContext().getPageActivity()).inflate(e.h.im_members_list_foot, viewGroup, false);
                    bVar2.eUe = (LinearLayout) inflate.findViewById(e.g.list_more);
                    bVar2.eUf = (TextView) inflate.findViewById(e.g.more_title);
                    bVar2.eUg = (ProgressBar) inflate.findViewById(e.g.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.eTV.getPageContext().getPageActivity()).inflate(e.h.im_members_list_item, viewGroup, false);
                    bVar2.eUi = (HeadImageView) inflate2.findViewById(e.g.item_head);
                    bVar2.eUi.setIsRound(false);
                    bVar2.eUi.setAutoChangeStyle(true);
                    bVar2.eSW = (TextView) inflate2.findViewById(e.g.item_name);
                    bVar2.eUj = (ImageView) inflate2.findViewById(e.g.item_sex);
                    bVar2.eUk = (TextView) inflate2.findViewById(e.g.item_time);
                    bVar2.eUl = (TextView) inflate2.findViewById(e.g.item_address);
                    bVar2.eUh = (ImageView) inflate2.findViewById(e.g.item_check);
                    bVar2.aKS = (UserIconBox) inflate2.findViewById(e.g.user_tshow_icon_box);
                    bVar2.eUm = inflate2.findViewById(e.g.list_line);
                    bVar2.eUn = inflate2.findViewById(e.g.list_bottom_line);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.eUm.setVisibility(i < getCount() + (-1) ? 0 : 8);
            bVar.eUn.setVisibility(i < getCount() + (-1) ? 8 : 0);
            if (getItemViewType(i) == 1) {
                if (this.eTX) {
                    bVar.eUf.setText(e.j.members_load_more_person);
                    bVar.eUg.setVisibility(0);
                } else {
                    bVar.eUf.setText(e.j.members_no_more_person);
                    bVar.eUg.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.eUi.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!ao.isEmpty(portrait)) {
                        bVar.eUi.startLoad(portrait, 12, false);
                    }
                    bVar.eSW.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.eUj.setVisibility(0);
                            al.c(bVar.eUj, e.f.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.eUj.setVisibility(0);
                            al.c(bVar.eUj, e.f.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.eUj.setVisibility(8);
                            break;
                    }
                    bVar.eUk.setText(d(userData));
                    bVar.eUl.setText(userData.getPosition());
                    this.eUc = userData.getTShowInfo();
                    if (bVar.aKS != null) {
                        bVar.aKS.a(this.eUc, 2, this.eTV.getResources().getDimensionPixelSize(e.C0210e.ds38), this.eTV.getResources().getDimensionPixelSize(e.C0210e.ds38), this.eTV.getResources().getDimensionPixelSize(e.C0210e.ds8), true);
                    }
                    if (this.eTZ) {
                        bVar.eUh.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.eUh.setTag(valueOf);
                        bVar.eUh.setSelected(this.eUa.contains(valueOf));
                        bVar.eUh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.eUa.add(l);
                                    } else {
                                        l.this.eUa.remove(l);
                                    }
                                    if (l.this.eTW != null) {
                                        l.this.eTW.qi(l.this.eUa.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.eUh.setVisibility(8);
                    }
                    bb(view);
                }
            }
        }
        return view;
    }

    private void bb(View view) {
        this.eTV.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eTV.getLayoutMode().onModeChanged(view);
    }

    private String d(UserData userData) {
        long lastReplyTime;
        MembersModel aSw = this.eTV.aSw();
        switch (aSw.getOrderType()) {
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
            if (aSw.getOrderType() == 1) {
                return this.eTV.getPageContext().getString(e.j.members_no_speak);
            }
            return "";
        }
        return ao.g(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes3.dex */
    static class b {
        UserIconBox aKS = null;
        TextView eSW;
        LinearLayout eUe;
        TextView eUf;
        ProgressBar eUg;
        ImageView eUh;
        HeadImageView eUi;
        ImageView eUj;
        TextView eUk;
        TextView eUl;
        View eUm;
        View eUn;

        b() {
        }
    }
}
