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
    private final MembersActivity eJC;
    private a eJD;
    private boolean eJE;
    private boolean eJG;
    private final Set<Long> eJH = new HashSet();
    private final List<UserData> eJI = new ArrayList();
    private ArrayList<IconData> eJJ = null;
    private boolean eJF = false;

    /* loaded from: classes3.dex */
    public interface a {
        void pA(int i);
    }

    public void a(a aVar) {
        this.eJD = aVar;
    }

    public void cB(List<UserData> list) {
        this.eJI.addAll(list);
    }

    public void cC(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.eJI.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void aPx() {
        this.eJH.clear();
    }

    public Set<Long> aPy() {
        return this.eJH;
    }

    public void h(Long l) {
        if (com.baidu.adp.lib.util.l.ll()) {
            if (this.eJH.contains(l)) {
                this.eJH.remove(l);
            } else {
                this.eJH.add(l);
            }
            notifyDataSetChanged();
            if (this.eJD != null) {
                this.eJD.pA(this.eJH.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.eJI.clear();
        }
        this.eJF = false;
        this.eJE = true;
    }

    public l(MembersActivity membersActivity) {
        this.eJC = membersActivity;
    }

    public void iw(boolean z) {
        this.eJE = z;
    }

    public boolean aoD() {
        return this.eJE;
    }

    public void ix(boolean z) {
        this.eJF = z;
    }

    public boolean aMF() {
        return this.eJG;
    }

    public void iy(boolean z) {
        this.eJG = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eJI != null) {
            int size = this.eJI.size();
            if (this.eJF) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.d(this.eJI, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.eJF && i == getCount() - 1) {
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
        if (this.eJI != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.eJC.getPageContext().getPageActivity()).inflate(e.h.im_members_list_foot, viewGroup, false);
                    bVar2.eJL = (LinearLayout) inflate.findViewById(e.g.list_more);
                    bVar2.eJM = (TextView) inflate.findViewById(e.g.more_title);
                    bVar2.eJN = (ProgressBar) inflate.findViewById(e.g.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.eJC.getPageContext().getPageActivity()).inflate(e.h.im_members_list_item, viewGroup, false);
                    bVar2.eJP = (HeadImageView) inflate2.findViewById(e.g.item_head);
                    bVar2.eJP.setIsRound(false);
                    bVar2.eJP.setAutoChangeStyle(true);
                    bVar2.eID = (TextView) inflate2.findViewById(e.g.item_name);
                    bVar2.eJQ = (ImageView) inflate2.findViewById(e.g.item_sex);
                    bVar2.eJR = (TextView) inflate2.findViewById(e.g.item_time);
                    bVar2.eJS = (TextView) inflate2.findViewById(e.g.item_address);
                    bVar2.eJO = (ImageView) inflate2.findViewById(e.g.item_check);
                    bVar2.aGO = (UserIconBox) inflate2.findViewById(e.g.user_tshow_icon_box);
                    bVar2.eJT = inflate2.findViewById(e.g.list_line);
                    bVar2.eJU = inflate2.findViewById(e.g.list_bottom_line);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.eJT.setVisibility(i < getCount() + (-1) ? 0 : 8);
            bVar.eJU.setVisibility(i < getCount() + (-1) ? 8 : 0);
            if (getItemViewType(i) == 1) {
                if (this.eJE) {
                    bVar.eJM.setText(e.j.members_load_more_person);
                    bVar.eJN.setVisibility(0);
                } else {
                    bVar.eJM.setText(e.j.members_no_more_person);
                    bVar.eJN.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.eJP.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!ao.isEmpty(portrait)) {
                        bVar.eJP.startLoad(portrait, 12, false);
                    }
                    bVar.eID.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.eJQ.setVisibility(0);
                            al.c(bVar.eJQ, e.f.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.eJQ.setVisibility(0);
                            al.c(bVar.eJQ, e.f.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.eJQ.setVisibility(8);
                            break;
                    }
                    bVar.eJR.setText(d(userData));
                    bVar.eJS.setText(userData.getPosition());
                    this.eJJ = userData.getTShowInfo();
                    if (bVar.aGO != null) {
                        bVar.aGO.a(this.eJJ, 2, this.eJC.getResources().getDimensionPixelSize(e.C0200e.ds38), this.eJC.getResources().getDimensionPixelSize(e.C0200e.ds38), this.eJC.getResources().getDimensionPixelSize(e.C0200e.ds8), true);
                    }
                    if (this.eJG) {
                        bVar.eJO.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.eJO.setTag(valueOf);
                        bVar.eJO.setSelected(this.eJH.contains(valueOf));
                        bVar.eJO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.eJH.add(l);
                                    } else {
                                        l.this.eJH.remove(l);
                                    }
                                    if (l.this.eJD != null) {
                                        l.this.eJD.pA(l.this.eJH.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.eJO.setVisibility(8);
                    }
                    aY(view);
                }
            }
        }
        return view;
    }

    private void aY(View view) {
        this.eJC.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eJC.getLayoutMode().onModeChanged(view);
    }

    private String d(UserData userData) {
        long lastReplyTime;
        MembersModel aPr = this.eJC.aPr();
        switch (aPr.getOrderType()) {
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
            if (aPr.getOrderType() == 1) {
                return this.eJC.getPageContext().getString(e.j.members_no_speak);
            }
            return "";
        }
        return ao.g(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes3.dex */
    static class b {
        UserIconBox aGO = null;
        TextView eID;
        LinearLayout eJL;
        TextView eJM;
        ProgressBar eJN;
        ImageView eJO;
        HeadImageView eJP;
        ImageView eJQ;
        TextView eJR;
        TextView eJS;
        View eJT;
        View eJU;

        b() {
        }
    }
}
