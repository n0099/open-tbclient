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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
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
    private final MembersActivity epr;
    private a eps;
    private boolean ept;
    private boolean epv;
    private final Set<Long> epw = new HashSet();
    private final List<UserData> epx = new ArrayList();
    private ArrayList<IconData> epy = null;
    private boolean epu = false;

    /* loaded from: classes3.dex */
    public interface a {
        void nR(int i);
    }

    public void a(a aVar) {
        this.eps = aVar;
    }

    public void cn(List<UserData> list) {
        this.epx.addAll(list);
    }

    public void co(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.epx.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void aJy() {
        this.epw.clear();
    }

    public Set<Long> aJz() {
        return this.epw;
    }

    public void g(Long l) {
        if (com.baidu.adp.lib.util.l.jT()) {
            if (this.epw.contains(l)) {
                this.epw.remove(l);
            } else {
                this.epw.add(l);
            }
            notifyDataSetChanged();
            if (this.eps != null) {
                this.eps.nR(this.epw.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.epx.clear();
        }
        this.epu = false;
        this.ept = true;
    }

    public l(MembersActivity membersActivity) {
        this.epr = membersActivity;
    }

    public void hu(boolean z) {
        this.ept = z;
    }

    public boolean ajn() {
        return this.ept;
    }

    public void hv(boolean z) {
        this.epu = z;
    }

    public boolean aGF() {
        return this.epv;
    }

    public void hw(boolean z) {
        this.epv = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.epx != null) {
            int size = this.epx.size();
            if (this.epu) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return w.d(this.epx, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.epu && i == getCount() - 1) {
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
        if (this.epx != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.epr.getPageContext().getPageActivity()).inflate(d.i.im_members_list_foot, viewGroup, false);
                    bVar2.epA = (LinearLayout) inflate.findViewById(d.g.list_more);
                    bVar2.epB = (TextView) inflate.findViewById(d.g.more_title);
                    bVar2.epC = (ProgressBar) inflate.findViewById(d.g.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.epr.getPageContext().getPageActivity()).inflate(d.i.im_members_list_item, viewGroup, false);
                    bVar2.epE = (HeadImageView) inflate2.findViewById(d.g.item_head);
                    bVar2.epE.setIsRound(false);
                    bVar2.epE.setAutoChangeStyle(true);
                    bVar2.eos = (TextView) inflate2.findViewById(d.g.item_name);
                    bVar2.epF = (ImageView) inflate2.findViewById(d.g.item_sex);
                    bVar2.epG = (TextView) inflate2.findViewById(d.g.item_time);
                    bVar2.epH = (TextView) inflate2.findViewById(d.g.item_address);
                    bVar2.epD = (ImageView) inflate2.findViewById(d.g.item_check);
                    bVar2.ayK = (UserIconBox) inflate2.findViewById(d.g.user_tshow_icon_box);
                    bVar2.epI = inflate2.findViewById(d.g.list_line);
                    bVar2.epJ = inflate2.findViewById(d.g.list_bottom_line);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.epI.setVisibility(i < getCount() + (-1) ? 0 : 8);
            bVar.epJ.setVisibility(i < getCount() + (-1) ? 8 : 0);
            if (getItemViewType(i) == 1) {
                if (this.ept) {
                    bVar.epB.setText(d.k.members_load_more_person);
                    bVar.epC.setVisibility(0);
                } else {
                    bVar.epB.setText(d.k.members_no_more_person);
                    bVar.epC.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.epE.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!ap.isEmpty(portrait)) {
                        bVar.epE.startLoad(portrait, 12, false);
                    }
                    bVar.eos.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.epF.setVisibility(0);
                            am.c(bVar.epF, d.f.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.epF.setVisibility(0);
                            am.c(bVar.epF, d.f.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.epF.setVisibility(8);
                            break;
                    }
                    bVar.epG.setText(d(userData));
                    bVar.epH.setText(userData.getPosition());
                    this.epy = userData.getTShowInfo();
                    if (bVar.ayK != null) {
                        bVar.ayK.a(this.epy, 2, this.epr.getResources().getDimensionPixelSize(d.e.ds38), this.epr.getResources().getDimensionPixelSize(d.e.ds38), this.epr.getResources().getDimensionPixelSize(d.e.ds8), true);
                    }
                    if (this.epv) {
                        bVar.epD.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.epD.setTag(valueOf);
                        bVar.epD.setSelected(this.epw.contains(valueOf));
                        bVar.epD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.epw.add(l);
                                    } else {
                                        l.this.epw.remove(l);
                                    }
                                    if (l.this.eps != null) {
                                        l.this.eps.nR(l.this.epw.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.epD.setVisibility(8);
                    }
                    aF(view);
                }
            }
        }
        return view;
    }

    private void aF(View view) {
        this.epr.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.epr.getLayoutMode().onModeChanged(view);
    }

    private String d(UserData userData) {
        long lastReplyTime;
        MembersModel aJs = this.epr.aJs();
        switch (aJs.getOrderType()) {
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
            if (aJs.getOrderType() == 1) {
                return this.epr.getPageContext().getString(d.k.members_no_speak);
            }
            return "";
        }
        return ap.h(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes3.dex */
    static class b {
        UserIconBox ayK = null;
        TextView eos;
        LinearLayout epA;
        TextView epB;
        ProgressBar epC;
        ImageView epD;
        HeadImageView epE;
        ImageView epF;
        TextView epG;
        TextView epH;
        View epI;
        View epJ;

        b() {
        }
    }
}
