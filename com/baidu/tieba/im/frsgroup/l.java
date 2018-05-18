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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
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
/* loaded from: classes3.dex */
public class l extends BaseAdapter {
    private final MembersActivity eai;
    private a eaj;
    private boolean eak;
    private boolean eam;
    private final Set<Long> ean = new HashSet();
    private final List<UserData> eao = new ArrayList();
    private ArrayList<IconData> eap = null;
    private boolean eal = false;

    /* loaded from: classes3.dex */
    public interface a {
        void ny(int i);
    }

    public void a(a aVar) {
        this.eaj = aVar;
    }

    public void ce(List<UserData> list) {
        this.eao.addAll(list);
    }

    public void cf(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.eao.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void aDW() {
        this.ean.clear();
    }

    public Set<Long> aDX() {
        return this.ean;
    }

    public void f(Long l) {
        if (com.baidu.adp.lib.util.l.hf()) {
            if (this.ean.contains(l)) {
                this.ean.remove(l);
            } else {
                this.ean.add(l);
            }
            notifyDataSetChanged();
            if (this.eaj != null) {
                this.eaj.ny(this.ean.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.eao.clear();
        }
        this.eal = false;
        this.eak = true;
    }

    public l(MembersActivity membersActivity) {
        this.eai = membersActivity;
    }

    public void he(boolean z) {
        this.eak = z;
    }

    public boolean agl() {
        return this.eak;
    }

    public void hf(boolean z) {
        this.eal = z;
    }

    public boolean aBc() {
        return this.eam;
    }

    public void hg(boolean z) {
        this.eam = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eao != null) {
            int size = this.eao.size();
            if (this.eal) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.c(this.eao, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.eal && i == getCount() - 1) {
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
    public View getView(int i, View view2, ViewGroup viewGroup) {
        b bVar;
        View view3;
        if (this.eao != null) {
            if (view2 == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.eai.getPageContext().getPageActivity()).inflate(d.i.im_members_list_foot, viewGroup, false);
                    bVar2.ear = (LinearLayout) inflate.findViewById(d.g.list_more);
                    bVar2.eas = (TextView) inflate.findViewById(d.g.more_title);
                    bVar2.eat = (ProgressBar) inflate.findViewById(d.g.more_progress);
                    view3 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.eai.getPageContext().getPageActivity()).inflate(d.i.im_members_list_item, viewGroup, false);
                    bVar2.eav = (HeadImageView) inflate2.findViewById(d.g.item_head);
                    bVar2.eav.setIsRound(false);
                    bVar2.eav.setAutoChangeStyle(true);
                    bVar2.dZk = (TextView) inflate2.findViewById(d.g.item_name);
                    bVar2.eaw = (ImageView) inflate2.findViewById(d.g.item_sex);
                    bVar2.eax = (TextView) inflate2.findViewById(d.g.item_time);
                    bVar2.eay = (TextView) inflate2.findViewById(d.g.item_address);
                    bVar2.eau = (ImageView) inflate2.findViewById(d.g.item_check);
                    bVar2.apM = (UserIconBox) inflate2.findViewById(d.g.user_tshow_icon_box);
                    bVar2.eaz = inflate2.findViewById(d.g.list_line);
                    bVar2.eaA = inflate2.findViewById(d.g.list_bottom_line);
                    view3 = inflate2;
                }
                view3.setTag(bVar2);
                bVar = bVar2;
                view2 = view3;
            } else {
                bVar = (b) view2.getTag();
            }
            bVar.eaz.setVisibility(i < getCount() + (-1) ? 0 : 8);
            bVar.eaA.setVisibility(i < getCount() + (-1) ? 8 : 0);
            if (getItemViewType(i) == 1) {
                if (this.eak) {
                    bVar.eas.setText(d.k.members_load_more_person);
                    bVar.eat.setVisibility(0);
                } else {
                    bVar.eas.setText(d.k.members_no_more_person);
                    bVar.eat.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.eav.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!an.isEmpty(portrait)) {
                        bVar.eav.startLoad(portrait, 12, false);
                    }
                    bVar.dZk.setText(userData.getUserName());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.eaw.setVisibility(0);
                            ak.c(bVar.eaw, d.f.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.eaw.setVisibility(0);
                            ak.c(bVar.eaw, d.f.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.eaw.setVisibility(8);
                            break;
                    }
                    bVar.eax.setText(d(userData));
                    bVar.eay.setText(userData.getPosition());
                    this.eap = userData.getTShowInfo();
                    if (bVar.apM != null) {
                        bVar.apM.a(this.eap, 2, this.eai.getResources().getDimensionPixelSize(d.e.ds38), this.eai.getResources().getDimensionPixelSize(d.e.ds38), this.eai.getResources().getDimensionPixelSize(d.e.ds8), true);
                    }
                    if (this.eam) {
                        bVar.eau.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.eau.setTag(valueOf);
                        bVar.eau.setSelected(this.ean.contains(valueOf));
                        bVar.eau.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view4) {
                                view4.setSelected(!view4.isSelected());
                                if (view4.getTag() instanceof Long) {
                                    Long l = (Long) view4.getTag();
                                    if (view4.isSelected()) {
                                        l.this.ean.add(l);
                                    } else {
                                        l.this.ean.remove(l);
                                    }
                                    if (l.this.eaj != null) {
                                        l.this.eaj.ny(l.this.ean.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.eau.setVisibility(8);
                    }
                    aA(view2);
                }
            }
        }
        return view2;
    }

    private void aA(View view2) {
        this.eai.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eai.getLayoutMode().u(view2);
    }

    private String d(UserData userData) {
        long lastReplyTime;
        MembersModel aDQ = this.eai.aDQ();
        switch (aDQ.getOrderType()) {
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
            if (aDQ.getOrderType() == 1) {
                return this.eai.getPageContext().getString(d.k.members_no_speak);
            }
            return "";
        }
        return an.f(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes3.dex */
    static class b {
        UserIconBox apM = null;
        TextView dZk;
        View eaA;
        LinearLayout ear;
        TextView eas;
        ProgressBar eat;
        ImageView eau;
        HeadImageView eav;
        ImageView eaw;
        TextView eax;
        TextView eay;
        View eaz;

        b() {
        }
    }
}
