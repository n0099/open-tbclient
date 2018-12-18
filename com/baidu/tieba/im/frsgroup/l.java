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
    private final MembersActivity eQr;
    private a eQs;
    private boolean eQt;
    private boolean eQv;
    private final Set<Long> eQw = new HashSet();
    private final List<UserData> eQx = new ArrayList();
    private ArrayList<IconData> eQy = null;
    private boolean eQu = false;

    /* loaded from: classes3.dex */
    public interface a {
        void pU(int i);
    }

    public void a(a aVar) {
        this.eQs = aVar;
    }

    public void cF(List<UserData> list) {
        this.eQx.addAll(list);
    }

    public void cG(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.eQx.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void aRo() {
        this.eQw.clear();
    }

    public Set<Long> aRp() {
        return this.eQw;
    }

    public void h(Long l) {
        if (com.baidu.adp.lib.util.l.lk()) {
            if (this.eQw.contains(l)) {
                this.eQw.remove(l);
            } else {
                this.eQw.add(l);
            }
            notifyDataSetChanged();
            if (this.eQs != null) {
                this.eQs.pU(this.eQw.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.eQx.clear();
        }
        this.eQu = false;
        this.eQt = true;
    }

    public l(MembersActivity membersActivity) {
        this.eQr = membersActivity;
    }

    public void iz(boolean z) {
        this.eQt = z;
    }

    public boolean aqq() {
        return this.eQt;
    }

    public void iA(boolean z) {
        this.eQu = z;
    }

    public boolean aOw() {
        return this.eQv;
    }

    public void iB(boolean z) {
        this.eQv = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eQx != null) {
            int size = this.eQx.size();
            if (this.eQu) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.d(this.eQx, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.eQu && i == getCount() - 1) {
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
        if (this.eQx != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.eQr.getPageContext().getPageActivity()).inflate(e.h.im_members_list_foot, viewGroup, false);
                    bVar2.eQA = (LinearLayout) inflate.findViewById(e.g.list_more);
                    bVar2.eQB = (TextView) inflate.findViewById(e.g.more_title);
                    bVar2.eQC = (ProgressBar) inflate.findViewById(e.g.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.eQr.getPageContext().getPageActivity()).inflate(e.h.im_members_list_item, viewGroup, false);
                    bVar2.eQE = (HeadImageView) inflate2.findViewById(e.g.item_head);
                    bVar2.eQE.setIsRound(false);
                    bVar2.eQE.setAutoChangeStyle(true);
                    bVar2.ePs = (TextView) inflate2.findViewById(e.g.item_name);
                    bVar2.eQF = (ImageView) inflate2.findViewById(e.g.item_sex);
                    bVar2.eQG = (TextView) inflate2.findViewById(e.g.item_time);
                    bVar2.eQH = (TextView) inflate2.findViewById(e.g.item_address);
                    bVar2.eQD = (ImageView) inflate2.findViewById(e.g.item_check);
                    bVar2.aKo = (UserIconBox) inflate2.findViewById(e.g.user_tshow_icon_box);
                    bVar2.eQI = inflate2.findViewById(e.g.list_line);
                    bVar2.eQJ = inflate2.findViewById(e.g.list_bottom_line);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.eQI.setVisibility(i < getCount() + (-1) ? 0 : 8);
            bVar.eQJ.setVisibility(i < getCount() + (-1) ? 8 : 0);
            if (getItemViewType(i) == 1) {
                if (this.eQt) {
                    bVar.eQB.setText(e.j.members_load_more_person);
                    bVar.eQC.setVisibility(0);
                } else {
                    bVar.eQB.setText(e.j.members_no_more_person);
                    bVar.eQC.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.eQE.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!ao.isEmpty(portrait)) {
                        bVar.eQE.startLoad(portrait, 12, false);
                    }
                    bVar.ePs.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.eQF.setVisibility(0);
                            al.c(bVar.eQF, e.f.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.eQF.setVisibility(0);
                            al.c(bVar.eQF, e.f.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.eQF.setVisibility(8);
                            break;
                    }
                    bVar.eQG.setText(d(userData));
                    bVar.eQH.setText(userData.getPosition());
                    this.eQy = userData.getTShowInfo();
                    if (bVar.aKo != null) {
                        bVar.aKo.a(this.eQy, 2, this.eQr.getResources().getDimensionPixelSize(e.C0210e.ds38), this.eQr.getResources().getDimensionPixelSize(e.C0210e.ds38), this.eQr.getResources().getDimensionPixelSize(e.C0210e.ds8), true);
                    }
                    if (this.eQv) {
                        bVar.eQD.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.eQD.setTag(valueOf);
                        bVar.eQD.setSelected(this.eQw.contains(valueOf));
                        bVar.eQD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.eQw.add(l);
                                    } else {
                                        l.this.eQw.remove(l);
                                    }
                                    if (l.this.eQs != null) {
                                        l.this.eQs.pU(l.this.eQw.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.eQD.setVisibility(8);
                    }
                    aY(view);
                }
            }
        }
        return view;
    }

    private void aY(View view) {
        this.eQr.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eQr.getLayoutMode().onModeChanged(view);
    }

    private String d(UserData userData) {
        long lastReplyTime;
        MembersModel aRi = this.eQr.aRi();
        switch (aRi.getOrderType()) {
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
            if (aRi.getOrderType() == 1) {
                return this.eQr.getPageContext().getString(e.j.members_no_speak);
            }
            return "";
        }
        return ao.g(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes3.dex */
    static class b {
        UserIconBox aKo = null;
        TextView ePs;
        LinearLayout eQA;
        TextView eQB;
        ProgressBar eQC;
        ImageView eQD;
        HeadImageView eQE;
        ImageView eQF;
        TextView eQG;
        TextView eQH;
        View eQI;
        View eQJ;

        b() {
        }
    }
}
