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
    private final MembersActivity gjR;
    private a gjS;
    private boolean gjT;
    private boolean gjV;
    private final Set<Long> gjW = new HashSet();
    private final List<UserData> gjX = new ArrayList();
    private ArrayList<IconData> gjY = null;
    private boolean gjU = false;

    /* loaded from: classes5.dex */
    public interface a {
        void tO(int i);
    }

    public void a(a aVar) {
        this.gjS = aVar;
    }

    public void cQ(List<UserData> list) {
        this.gjX.addAll(list);
    }

    public void cR(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.gjX.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void bte() {
        this.gjW.clear();
    }

    public Set<Long> btf() {
        return this.gjW;
    }

    public void g(Long l) {
        if (com.baidu.adp.lib.util.l.ln()) {
            if (this.gjW.contains(l)) {
                this.gjW.remove(l);
            } else {
                this.gjW.add(l);
            }
            notifyDataSetChanged();
            if (this.gjS != null) {
                this.gjS.tO(this.gjW.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.gjX.clear();
        }
        this.gjU = false;
        this.gjT = true;
    }

    public l(MembersActivity membersActivity) {
        this.gjR = membersActivity;
    }

    public void lc(boolean z) {
        this.gjT = z;
    }

    public boolean aRs() {
        return this.gjT;
    }

    public void ld(boolean z) {
        this.gjU = z;
    }

    public boolean bqm() {
        return this.gjV;
    }

    public void le(boolean z) {
        this.gjV = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gjX != null) {
            int size = this.gjX.size();
            if (this.gjU) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.c(this.gjX, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.gjU && i == getCount() - 1) {
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
        if (this.gjX != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.gjR.getPageContext().getPageActivity()).inflate(d.h.im_members_list_foot, viewGroup, false);
                    bVar2.gka = (LinearLayout) inflate.findViewById(d.g.list_more);
                    bVar2.gkb = (TextView) inflate.findViewById(d.g.more_title);
                    bVar2.gkc = (ProgressBar) inflate.findViewById(d.g.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.gjR.getPageContext().getPageActivity()).inflate(d.h.im_members_list_item, viewGroup, false);
                    bVar2.gke = (HeadImageView) inflate2.findViewById(d.g.item_head);
                    bVar2.gke.setIsRound(false);
                    bVar2.gke.setAutoChangeStyle(true);
                    bVar2.giS = (TextView) inflate2.findViewById(d.g.item_name);
                    bVar2.gkf = (ImageView) inflate2.findViewById(d.g.item_sex);
                    bVar2.gkg = (TextView) inflate2.findViewById(d.g.item_time);
                    bVar2.gkh = (TextView) inflate2.findViewById(d.g.item_address);
                    bVar2.gkd = (ImageView) inflate2.findViewById(d.g.item_check);
                    bVar2.ZC = (UserIconBox) inflate2.findViewById(d.g.user_tshow_icon_box);
                    bVar2.gki = inflate2.findViewById(d.g.list_line);
                    bVar2.gkj = inflate2.findViewById(d.g.list_bottom_line);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.gki.setVisibility(i < getCount() + (-1) ? 0 : 8);
            bVar.gkj.setVisibility(i < getCount() + (-1) ? 8 : 0);
            if (getItemViewType(i) == 1) {
                if (this.gjT) {
                    bVar.gkb.setText(d.j.members_load_more_person);
                    bVar.gkc.setVisibility(0);
                } else {
                    bVar.gkb.setText(d.j.members_no_more_person);
                    bVar.gkc.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.gke.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!ap.isEmpty(portrait)) {
                        bVar.gke.startLoad(portrait, 12, false);
                    }
                    bVar.giS.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.gkf.setVisibility(0);
                            al.c(bVar.gkf, d.f.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.gkf.setVisibility(0);
                            al.c(bVar.gkf, d.f.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.gkf.setVisibility(8);
                            break;
                    }
                    bVar.gkg.setText(d(userData));
                    bVar.gkh.setText(userData.getPosition());
                    this.gjY = userData.getTShowInfo();
                    if (bVar.ZC != null) {
                        bVar.ZC.a(this.gjY, 2, this.gjR.getResources().getDimensionPixelSize(d.e.ds38), this.gjR.getResources().getDimensionPixelSize(d.e.ds38), this.gjR.getResources().getDimensionPixelSize(d.e.ds8), true);
                    }
                    if (this.gjV) {
                        bVar.gkd.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.gkd.setTag(valueOf);
                        bVar.gkd.setSelected(this.gjW.contains(valueOf));
                        bVar.gkd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.gjW.add(l);
                                    } else {
                                        l.this.gjW.remove(l);
                                    }
                                    if (l.this.gjS != null) {
                                        l.this.gjS.tO(l.this.gjW.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.gkd.setVisibility(8);
                    }
                    bP(view);
                }
            }
        }
        return view;
    }

    private void bP(View view) {
        this.gjR.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gjR.getLayoutMode().onModeChanged(view);
    }

    private String d(UserData userData) {
        long lastReplyTime;
        MembersModel bsY = this.gjR.bsY();
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
                return this.gjR.getPageContext().getString(d.j.members_no_speak);
            }
            return "";
        }
        return ap.m(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes5.dex */
    static class b {
        UserIconBox ZC = null;
        TextView giS;
        LinearLayout gka;
        TextView gkb;
        ProgressBar gkc;
        ImageView gkd;
        HeadImageView gke;
        ImageView gkf;
        TextView gkg;
        TextView gkh;
        View gki;
        View gkj;

        b() {
        }
    }
}
