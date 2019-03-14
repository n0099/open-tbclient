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
import com.baidu.tbadk.core.util.ap;
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
/* loaded from: classes5.dex */
public class l extends BaseAdapter {
    private final MembersActivity gkd;
    private a gke;
    private boolean gkf;
    private boolean gkh;
    private final Set<Long> gki = new HashSet();
    private final List<UserData> gkj = new ArrayList();
    private ArrayList<IconData> gkk = null;
    private boolean gkg = false;

    /* loaded from: classes5.dex */
    public interface a {
        void tS(int i);
    }

    public void a(a aVar) {
        this.gke = aVar;
    }

    public void cT(List<UserData> list) {
        this.gkj.addAll(list);
    }

    public void cU(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.gkj.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void bth() {
        this.gki.clear();
    }

    public Set<Long> bti() {
        return this.gki;
    }

    public void g(Long l) {
        if (com.baidu.adp.lib.util.l.ln()) {
            if (this.gki.contains(l)) {
                this.gki.remove(l);
            } else {
                this.gki.add(l);
            }
            notifyDataSetChanged();
            if (this.gke != null) {
                this.gke.tS(this.gki.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.gkj.clear();
        }
        this.gkg = false;
        this.gkf = true;
    }

    public l(MembersActivity membersActivity) {
        this.gkd = membersActivity;
    }

    public void lc(boolean z) {
        this.gkf = z;
    }

    public boolean aRu() {
        return this.gkf;
    }

    public void ld(boolean z) {
        this.gkg = z;
    }

    public boolean bqp() {
        return this.gkh;
    }

    public void le(boolean z) {
        this.gkh = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gkj != null) {
            int size = this.gkj.size();
            if (this.gkg) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.c(this.gkj, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.gkg && i == getCount() - 1) {
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
        if (this.gkj != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.gkd.getPageContext().getPageActivity()).inflate(d.h.im_members_list_foot, viewGroup, false);
                    bVar2.gkm = (LinearLayout) inflate.findViewById(d.g.list_more);
                    bVar2.gkn = (TextView) inflate.findViewById(d.g.more_title);
                    bVar2.gko = (ProgressBar) inflate.findViewById(d.g.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.gkd.getPageContext().getPageActivity()).inflate(d.h.im_members_list_item, viewGroup, false);
                    bVar2.gkq = (HeadImageView) inflate2.findViewById(d.g.item_head);
                    bVar2.gkq.setIsRound(false);
                    bVar2.gkq.setAutoChangeStyle(true);
                    bVar2.gje = (TextView) inflate2.findViewById(d.g.item_name);
                    bVar2.gkr = (ImageView) inflate2.findViewById(d.g.item_sex);
                    bVar2.gks = (TextView) inflate2.findViewById(d.g.item_time);
                    bVar2.gkt = (TextView) inflate2.findViewById(d.g.item_address);
                    bVar2.gkp = (ImageView) inflate2.findViewById(d.g.item_check);
                    bVar2.ZB = (UserIconBox) inflate2.findViewById(d.g.user_tshow_icon_box);
                    bVar2.gku = inflate2.findViewById(d.g.list_line);
                    bVar2.gkv = inflate2.findViewById(d.g.list_bottom_line);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.gku.setVisibility(i < getCount() + (-1) ? 0 : 8);
            bVar.gkv.setVisibility(i < getCount() + (-1) ? 8 : 0);
            if (getItemViewType(i) == 1) {
                if (this.gkf) {
                    bVar.gkn.setText(d.j.members_load_more_person);
                    bVar.gko.setVisibility(0);
                } else {
                    bVar.gkn.setText(d.j.members_no_more_person);
                    bVar.gko.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.gkq.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!ap.isEmpty(portrait)) {
                        bVar.gkq.startLoad(portrait, 12, false);
                    }
                    bVar.gje.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.gkr.setVisibility(0);
                            al.c(bVar.gkr, d.f.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.gkr.setVisibility(0);
                            al.c(bVar.gkr, d.f.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.gkr.setVisibility(8);
                            break;
                    }
                    bVar.gks.setText(d(userData));
                    bVar.gkt.setText(userData.getPosition());
                    this.gkk = userData.getTShowInfo();
                    if (bVar.ZB != null) {
                        bVar.ZB.a(this.gkk, 2, this.gkd.getResources().getDimensionPixelSize(d.e.ds38), this.gkd.getResources().getDimensionPixelSize(d.e.ds38), this.gkd.getResources().getDimensionPixelSize(d.e.ds8), true);
                    }
                    if (this.gkh) {
                        bVar.gkp.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.gkp.setTag(valueOf);
                        bVar.gkp.setSelected(this.gki.contains(valueOf));
                        bVar.gkp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.gki.add(l);
                                    } else {
                                        l.this.gki.remove(l);
                                    }
                                    if (l.this.gke != null) {
                                        l.this.gke.tS(l.this.gki.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.gkp.setVisibility(8);
                    }
                    bP(view);
                }
            }
        }
        return view;
    }

    private void bP(View view) {
        this.gkd.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gkd.getLayoutMode().onModeChanged(view);
    }

    private String d(UserData userData) {
        long lastReplyTime;
        MembersModel btb = this.gkd.btb();
        switch (btb.getOrderType()) {
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
            if (btb.getOrderType() == 1) {
                return this.gkd.getPageContext().getString(d.j.members_no_speak);
            }
            return "";
        }
        return ap.m(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes5.dex */
    static class b {
        UserIconBox ZB = null;
        TextView gje;
        LinearLayout gkm;
        TextView gkn;
        ProgressBar gko;
        ImageView gkp;
        HeadImageView gkq;
        ImageView gkr;
        TextView gks;
        TextView gkt;
        View gku;
        View gkv;

        b() {
        }
    }
}
