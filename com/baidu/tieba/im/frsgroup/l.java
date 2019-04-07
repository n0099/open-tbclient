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
    private final MembersActivity gjQ;
    private a gjR;
    private boolean gjS;
    private boolean gjU;
    private final Set<Long> gjV = new HashSet();
    private final List<UserData> gjW = new ArrayList();
    private ArrayList<IconData> gjX = null;
    private boolean gjT = false;

    /* loaded from: classes5.dex */
    public interface a {
        void tO(int i);
    }

    public void a(a aVar) {
        this.gjR = aVar;
    }

    public void cQ(List<UserData> list) {
        this.gjW.addAll(list);
    }

    public void cR(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.gjW.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void bte() {
        this.gjV.clear();
    }

    public Set<Long> btf() {
        return this.gjV;
    }

    public void g(Long l) {
        if (com.baidu.adp.lib.util.l.ln()) {
            if (this.gjV.contains(l)) {
                this.gjV.remove(l);
            } else {
                this.gjV.add(l);
            }
            notifyDataSetChanged();
            if (this.gjR != null) {
                this.gjR.tO(this.gjV.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.gjW.clear();
        }
        this.gjT = false;
        this.gjS = true;
    }

    public l(MembersActivity membersActivity) {
        this.gjQ = membersActivity;
    }

    public void lc(boolean z) {
        this.gjS = z;
    }

    public boolean aRs() {
        return this.gjS;
    }

    public void ld(boolean z) {
        this.gjT = z;
    }

    public boolean bqm() {
        return this.gjU;
    }

    public void le(boolean z) {
        this.gjU = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gjW != null) {
            int size = this.gjW.size();
            if (this.gjT) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.c(this.gjW, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.gjT && i == getCount() - 1) {
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
        if (this.gjW != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.gjQ.getPageContext().getPageActivity()).inflate(d.h.im_members_list_foot, viewGroup, false);
                    bVar2.gjZ = (LinearLayout) inflate.findViewById(d.g.list_more);
                    bVar2.gka = (TextView) inflate.findViewById(d.g.more_title);
                    bVar2.gkb = (ProgressBar) inflate.findViewById(d.g.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.gjQ.getPageContext().getPageActivity()).inflate(d.h.im_members_list_item, viewGroup, false);
                    bVar2.gkd = (HeadImageView) inflate2.findViewById(d.g.item_head);
                    bVar2.gkd.setIsRound(false);
                    bVar2.gkd.setAutoChangeStyle(true);
                    bVar2.giR = (TextView) inflate2.findViewById(d.g.item_name);
                    bVar2.gke = (ImageView) inflate2.findViewById(d.g.item_sex);
                    bVar2.gkf = (TextView) inflate2.findViewById(d.g.item_time);
                    bVar2.gkg = (TextView) inflate2.findViewById(d.g.item_address);
                    bVar2.gkc = (ImageView) inflate2.findViewById(d.g.item_check);
                    bVar2.ZB = (UserIconBox) inflate2.findViewById(d.g.user_tshow_icon_box);
                    bVar2.gkh = inflate2.findViewById(d.g.list_line);
                    bVar2.gki = inflate2.findViewById(d.g.list_bottom_line);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.gkh.setVisibility(i < getCount() + (-1) ? 0 : 8);
            bVar.gki.setVisibility(i < getCount() + (-1) ? 8 : 0);
            if (getItemViewType(i) == 1) {
                if (this.gjS) {
                    bVar.gka.setText(d.j.members_load_more_person);
                    bVar.gkb.setVisibility(0);
                } else {
                    bVar.gka.setText(d.j.members_no_more_person);
                    bVar.gkb.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.gkd.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!ap.isEmpty(portrait)) {
                        bVar.gkd.startLoad(portrait, 12, false);
                    }
                    bVar.giR.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.gke.setVisibility(0);
                            al.c(bVar.gke, d.f.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.gke.setVisibility(0);
                            al.c(bVar.gke, d.f.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.gke.setVisibility(8);
                            break;
                    }
                    bVar.gkf.setText(d(userData));
                    bVar.gkg.setText(userData.getPosition());
                    this.gjX = userData.getTShowInfo();
                    if (bVar.ZB != null) {
                        bVar.ZB.a(this.gjX, 2, this.gjQ.getResources().getDimensionPixelSize(d.e.ds38), this.gjQ.getResources().getDimensionPixelSize(d.e.ds38), this.gjQ.getResources().getDimensionPixelSize(d.e.ds8), true);
                    }
                    if (this.gjU) {
                        bVar.gkc.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.gkc.setTag(valueOf);
                        bVar.gkc.setSelected(this.gjV.contains(valueOf));
                        bVar.gkc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.gjV.add(l);
                                    } else {
                                        l.this.gjV.remove(l);
                                    }
                                    if (l.this.gjR != null) {
                                        l.this.gjR.tO(l.this.gjV.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.gkc.setVisibility(8);
                    }
                    bP(view);
                }
            }
        }
        return view;
    }

    private void bP(View view) {
        this.gjQ.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gjQ.getLayoutMode().onModeChanged(view);
    }

    private String d(UserData userData) {
        long lastReplyTime;
        MembersModel bsY = this.gjQ.bsY();
        switch (bsY.getOrderType()) {
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
            if (bsY.getOrderType() == 1) {
                return this.gjQ.getPageContext().getString(d.j.members_no_speak);
            }
            return "";
        }
        return ap.m(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes5.dex */
    static class b {
        UserIconBox ZB = null;
        TextView giR;
        LinearLayout gjZ;
        TextView gka;
        ProgressBar gkb;
        ImageView gkc;
        HeadImageView gkd;
        ImageView gke;
        TextView gkf;
        TextView gkg;
        View gkh;
        View gki;

        b() {
        }
    }
}
