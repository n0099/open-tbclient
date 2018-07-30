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
    private final MembersActivity etk;
    private a etl;
    private boolean etm;
    private boolean eto;
    private final Set<Long> etp = new HashSet();
    private final List<UserData> etq = new ArrayList();
    private ArrayList<IconData> etr = null;
    private boolean etn = false;

    /* loaded from: classes3.dex */
    public interface a {
        void of(int i);
    }

    public void a(a aVar) {
        this.etl = aVar;
    }

    public void cn(List<UserData> list) {
        this.etq.addAll(list);
    }

    public void co(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.etq.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void aKz() {
        this.etp.clear();
    }

    public Set<Long> aKA() {
        return this.etp;
    }

    public void f(Long l) {
        if (com.baidu.adp.lib.util.l.jU()) {
            if (this.etp.contains(l)) {
                this.etp.remove(l);
            } else {
                this.etp.add(l);
            }
            notifyDataSetChanged();
            if (this.etl != null) {
                this.etl.of(this.etp.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.etq.clear();
        }
        this.etn = false;
        this.etm = true;
    }

    public l(MembersActivity membersActivity) {
        this.etk = membersActivity;
    }

    public void hx(boolean z) {
        this.etm = z;
    }

    public boolean ajL() {
        return this.etm;
    }

    public void hy(boolean z) {
        this.etn = z;
    }

    public boolean aHF() {
        return this.eto;
    }

    public void hz(boolean z) {
        this.eto = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.etq != null) {
            int size = this.etq.size();
            if (this.etn) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return w.d(this.etq, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.etn && i == getCount() - 1) {
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
        if (this.etq != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.etk.getPageContext().getPageActivity()).inflate(d.h.im_members_list_foot, viewGroup, false);
                    bVar2.ett = (LinearLayout) inflate.findViewById(d.g.list_more);
                    bVar2.etu = (TextView) inflate.findViewById(d.g.more_title);
                    bVar2.etv = (ProgressBar) inflate.findViewById(d.g.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.etk.getPageContext().getPageActivity()).inflate(d.h.im_members_list_item, viewGroup, false);
                    bVar2.etx = (HeadImageView) inflate2.findViewById(d.g.item_head);
                    bVar2.etx.setIsRound(false);
                    bVar2.etx.setAutoChangeStyle(true);
                    bVar2.esk = (TextView) inflate2.findViewById(d.g.item_name);
                    bVar2.ety = (ImageView) inflate2.findViewById(d.g.item_sex);
                    bVar2.etz = (TextView) inflate2.findViewById(d.g.item_time);
                    bVar2.etA = (TextView) inflate2.findViewById(d.g.item_address);
                    bVar2.etw = (ImageView) inflate2.findViewById(d.g.item_check);
                    bVar2.ayx = (UserIconBox) inflate2.findViewById(d.g.user_tshow_icon_box);
                    bVar2.etB = inflate2.findViewById(d.g.list_line);
                    bVar2.etC = inflate2.findViewById(d.g.list_bottom_line);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.etB.setVisibility(i < getCount() + (-1) ? 0 : 8);
            bVar.etC.setVisibility(i < getCount() + (-1) ? 8 : 0);
            if (getItemViewType(i) == 1) {
                if (this.etm) {
                    bVar.etu.setText(d.j.members_load_more_person);
                    bVar.etv.setVisibility(0);
                } else {
                    bVar.etu.setText(d.j.members_no_more_person);
                    bVar.etv.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.etx.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!ap.isEmpty(portrait)) {
                        bVar.etx.startLoad(portrait, 12, false);
                    }
                    bVar.esk.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.ety.setVisibility(0);
                            am.c(bVar.ety, d.f.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.ety.setVisibility(0);
                            am.c(bVar.ety, d.f.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.ety.setVisibility(8);
                            break;
                    }
                    bVar.etz.setText(d(userData));
                    bVar.etA.setText(userData.getPosition());
                    this.etr = userData.getTShowInfo();
                    if (bVar.ayx != null) {
                        bVar.ayx.a(this.etr, 2, this.etk.getResources().getDimensionPixelSize(d.e.ds38), this.etk.getResources().getDimensionPixelSize(d.e.ds38), this.etk.getResources().getDimensionPixelSize(d.e.ds8), true);
                    }
                    if (this.eto) {
                        bVar.etw.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.etw.setTag(valueOf);
                        bVar.etw.setSelected(this.etp.contains(valueOf));
                        bVar.etw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.etp.add(l);
                                    } else {
                                        l.this.etp.remove(l);
                                    }
                                    if (l.this.etl != null) {
                                        l.this.etl.of(l.this.etp.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.etw.setVisibility(8);
                    }
                    aI(view);
                }
            }
        }
        return view;
    }

    private void aI(View view) {
        this.etk.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.etk.getLayoutMode().onModeChanged(view);
    }

    private String d(UserData userData) {
        long lastReplyTime;
        MembersModel aKt = this.etk.aKt();
        switch (aKt.getOrderType()) {
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
            if (aKt.getOrderType() == 1) {
                return this.etk.getPageContext().getString(d.j.members_no_speak);
            }
            return "";
        }
        return ap.g(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes3.dex */
    static class b {
        UserIconBox ayx = null;
        TextView esk;
        TextView etA;
        View etB;
        View etC;
        LinearLayout ett;
        TextView etu;
        ProgressBar etv;
        ImageView etw;
        HeadImageView etx;
        ImageView ety;
        TextView etz;

        b() {
        }
    }
}
