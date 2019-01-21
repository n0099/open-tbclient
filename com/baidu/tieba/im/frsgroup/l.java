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
    private final MembersActivity eTW;
    private a eTX;
    private boolean eTY;
    private boolean eUa;
    private final Set<Long> eUb = new HashSet();
    private final List<UserData> eUc = new ArrayList();
    private ArrayList<IconData> eUd = null;
    private boolean eTZ = false;

    /* loaded from: classes3.dex */
    public interface a {
        void qi(int i);
    }

    public void a(a aVar) {
        this.eTX = aVar;
    }

    public void cH(List<UserData> list) {
        this.eUc.addAll(list);
    }

    public void cI(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.eUc.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void aSC() {
        this.eUb.clear();
    }

    public Set<Long> aSD() {
        return this.eUb;
    }

    public void h(Long l) {
        if (com.baidu.adp.lib.util.l.lk()) {
            if (this.eUb.contains(l)) {
                this.eUb.remove(l);
            } else {
                this.eUb.add(l);
            }
            notifyDataSetChanged();
            if (this.eTX != null) {
                this.eTX.qi(this.eUb.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.eUc.clear();
        }
        this.eTZ = false;
        this.eTY = true;
    }

    public l(MembersActivity membersActivity) {
        this.eTW = membersActivity;
    }

    public void iC(boolean z) {
        this.eTY = z;
    }

    public boolean arD() {
        return this.eTY;
    }

    public void iD(boolean z) {
        this.eTZ = z;
    }

    public boolean aPK() {
        return this.eUa;
    }

    public void iE(boolean z) {
        this.eUa = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eUc != null) {
            int size = this.eUc.size();
            if (this.eTZ) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.d(this.eUc, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.eTZ && i == getCount() - 1) {
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
        if (this.eUc != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.eTW.getPageContext().getPageActivity()).inflate(e.h.im_members_list_foot, viewGroup, false);
                    bVar2.eUf = (LinearLayout) inflate.findViewById(e.g.list_more);
                    bVar2.eUg = (TextView) inflate.findViewById(e.g.more_title);
                    bVar2.eUh = (ProgressBar) inflate.findViewById(e.g.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.eTW.getPageContext().getPageActivity()).inflate(e.h.im_members_list_item, viewGroup, false);
                    bVar2.eUj = (HeadImageView) inflate2.findViewById(e.g.item_head);
                    bVar2.eUj.setIsRound(false);
                    bVar2.eUj.setAutoChangeStyle(true);
                    bVar2.eSX = (TextView) inflate2.findViewById(e.g.item_name);
                    bVar2.eUk = (ImageView) inflate2.findViewById(e.g.item_sex);
                    bVar2.eUl = (TextView) inflate2.findViewById(e.g.item_time);
                    bVar2.eUm = (TextView) inflate2.findViewById(e.g.item_address);
                    bVar2.eUi = (ImageView) inflate2.findViewById(e.g.item_check);
                    bVar2.aKT = (UserIconBox) inflate2.findViewById(e.g.user_tshow_icon_box);
                    bVar2.eUn = inflate2.findViewById(e.g.list_line);
                    bVar2.eUo = inflate2.findViewById(e.g.list_bottom_line);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.eUn.setVisibility(i < getCount() + (-1) ? 0 : 8);
            bVar.eUo.setVisibility(i < getCount() + (-1) ? 8 : 0);
            if (getItemViewType(i) == 1) {
                if (this.eTY) {
                    bVar.eUg.setText(e.j.members_load_more_person);
                    bVar.eUh.setVisibility(0);
                } else {
                    bVar.eUg.setText(e.j.members_no_more_person);
                    bVar.eUh.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.eUj.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!ao.isEmpty(portrait)) {
                        bVar.eUj.startLoad(portrait, 12, false);
                    }
                    bVar.eSX.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.eUk.setVisibility(0);
                            al.c(bVar.eUk, e.f.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.eUk.setVisibility(0);
                            al.c(bVar.eUk, e.f.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.eUk.setVisibility(8);
                            break;
                    }
                    bVar.eUl.setText(d(userData));
                    bVar.eUm.setText(userData.getPosition());
                    this.eUd = userData.getTShowInfo();
                    if (bVar.aKT != null) {
                        bVar.aKT.a(this.eUd, 2, this.eTW.getResources().getDimensionPixelSize(e.C0210e.ds38), this.eTW.getResources().getDimensionPixelSize(e.C0210e.ds38), this.eTW.getResources().getDimensionPixelSize(e.C0210e.ds8), true);
                    }
                    if (this.eUa) {
                        bVar.eUi.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.eUi.setTag(valueOf);
                        bVar.eUi.setSelected(this.eUb.contains(valueOf));
                        bVar.eUi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.eUb.add(l);
                                    } else {
                                        l.this.eUb.remove(l);
                                    }
                                    if (l.this.eTX != null) {
                                        l.this.eTX.qi(l.this.eUb.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.eUi.setVisibility(8);
                    }
                    bb(view);
                }
            }
        }
        return view;
    }

    private void bb(View view) {
        this.eTW.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eTW.getLayoutMode().onModeChanged(view);
    }

    private String d(UserData userData) {
        long lastReplyTime;
        MembersModel aSw = this.eTW.aSw();
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
                return this.eTW.getPageContext().getString(e.j.members_no_speak);
            }
            return "";
        }
        return ao.g(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes3.dex */
    static class b {
        UserIconBox aKT = null;
        TextView eSX;
        LinearLayout eUf;
        TextView eUg;
        ProgressBar eUh;
        ImageView eUi;
        HeadImageView eUj;
        ImageView eUk;
        TextView eUl;
        TextView eUm;
        View eUn;
        View eUo;

        b() {
        }
    }
}
