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
import com.baidu.tieba.f;
import com.baidu.tieba.im.model.MembersModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes3.dex */
public class l extends BaseAdapter {
    private final MembersActivity etg;
    private a eth;
    private boolean eti;
    private boolean etk;
    private final Set<Long> etl = new HashSet();
    private final List<UserData> etm = new ArrayList();
    private ArrayList<IconData> etn = null;
    private boolean etj = false;

    /* loaded from: classes3.dex */
    public interface a {
        void of(int i);
    }

    public void a(a aVar) {
        this.eth = aVar;
    }

    public void cn(List<UserData> list) {
        this.etm.addAll(list);
    }

    public void co(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.etm.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void aKw() {
        this.etl.clear();
    }

    public Set<Long> aKx() {
        return this.etl;
    }

    public void f(Long l) {
        if (com.baidu.adp.lib.util.l.jU()) {
            if (this.etl.contains(l)) {
                this.etl.remove(l);
            } else {
                this.etl.add(l);
            }
            notifyDataSetChanged();
            if (this.eth != null) {
                this.eth.of(this.etl.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.etm.clear();
        }
        this.etj = false;
        this.eti = true;
    }

    public l(MembersActivity membersActivity) {
        this.etg = membersActivity;
    }

    public void hx(boolean z) {
        this.eti = z;
    }

    public boolean ajO() {
        return this.eti;
    }

    public void hy(boolean z) {
        this.etj = z;
    }

    public boolean aHC() {
        return this.etk;
    }

    public void hz(boolean z) {
        this.etk = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.etm != null) {
            int size = this.etm.size();
            if (this.etj) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return w.d(this.etm, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.etj && i == getCount() - 1) {
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
        if (this.etm != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.etg.getPageContext().getPageActivity()).inflate(f.h.im_members_list_foot, viewGroup, false);
                    bVar2.etp = (LinearLayout) inflate.findViewById(f.g.list_more);
                    bVar2.etq = (TextView) inflate.findViewById(f.g.more_title);
                    bVar2.etr = (ProgressBar) inflate.findViewById(f.g.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.etg.getPageContext().getPageActivity()).inflate(f.h.im_members_list_item, viewGroup, false);
                    bVar2.ett = (HeadImageView) inflate2.findViewById(f.g.item_head);
                    bVar2.ett.setIsRound(false);
                    bVar2.ett.setAutoChangeStyle(true);
                    bVar2.esg = (TextView) inflate2.findViewById(f.g.item_name);
                    bVar2.etu = (ImageView) inflate2.findViewById(f.g.item_sex);
                    bVar2.etv = (TextView) inflate2.findViewById(f.g.item_time);
                    bVar2.etw = (TextView) inflate2.findViewById(f.g.item_address);
                    bVar2.ets = (ImageView) inflate2.findViewById(f.g.item_check);
                    bVar2.ayu = (UserIconBox) inflate2.findViewById(f.g.user_tshow_icon_box);
                    bVar2.etx = inflate2.findViewById(f.g.list_line);
                    bVar2.ety = inflate2.findViewById(f.g.list_bottom_line);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.etx.setVisibility(i < getCount() + (-1) ? 0 : 8);
            bVar.ety.setVisibility(i < getCount() + (-1) ? 8 : 0);
            if (getItemViewType(i) == 1) {
                if (this.eti) {
                    bVar.etq.setText(f.j.members_load_more_person);
                    bVar.etr.setVisibility(0);
                } else {
                    bVar.etq.setText(f.j.members_no_more_person);
                    bVar.etr.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.ett.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!ap.isEmpty(portrait)) {
                        bVar.ett.startLoad(portrait, 12, false);
                    }
                    bVar.esg.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.etu.setVisibility(0);
                            am.c(bVar.etu, f.C0146f.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.etu.setVisibility(0);
                            am.c(bVar.etu, f.C0146f.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.etu.setVisibility(8);
                            break;
                    }
                    bVar.etv.setText(d(userData));
                    bVar.etw.setText(userData.getPosition());
                    this.etn = userData.getTShowInfo();
                    if (bVar.ayu != null) {
                        bVar.ayu.a(this.etn, 2, this.etg.getResources().getDimensionPixelSize(f.e.ds38), this.etg.getResources().getDimensionPixelSize(f.e.ds38), this.etg.getResources().getDimensionPixelSize(f.e.ds8), true);
                    }
                    if (this.etk) {
                        bVar.ets.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.ets.setTag(valueOf);
                        bVar.ets.setSelected(this.etl.contains(valueOf));
                        bVar.ets.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.etl.add(l);
                                    } else {
                                        l.this.etl.remove(l);
                                    }
                                    if (l.this.eth != null) {
                                        l.this.eth.of(l.this.etl.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.ets.setVisibility(8);
                    }
                    aI(view);
                }
            }
        }
        return view;
    }

    private void aI(View view) {
        this.etg.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.etg.getLayoutMode().onModeChanged(view);
    }

    private String d(UserData userData) {
        long lastReplyTime;
        MembersModel aKq = this.etg.aKq();
        switch (aKq.getOrderType()) {
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
            if (aKq.getOrderType() == 1) {
                return this.etg.getPageContext().getString(f.j.members_no_speak);
            }
            return "";
        }
        return ap.g(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes3.dex */
    static class b {
        UserIconBox ayu = null;
        TextView esg;
        LinearLayout etp;
        TextView etq;
        ProgressBar etr;
        ImageView ets;
        HeadImageView ett;
        ImageView etu;
        TextView etv;
        TextView etw;
        View etx;
        View ety;

        b() {
        }
    }
}
