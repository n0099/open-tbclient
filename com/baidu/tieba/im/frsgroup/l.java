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
    private a eAA;
    private boolean eAB;
    private boolean eAD;
    private final MembersActivity eAz;
    private final Set<Long> eAE = new HashSet();
    private final List<UserData> eAF = new ArrayList();
    private ArrayList<IconData> eAG = null;
    private boolean eAC = false;

    /* loaded from: classes3.dex */
    public interface a {
        void oJ(int i);
    }

    public void a(a aVar) {
        this.eAA = aVar;
    }

    public void co(List<UserData> list) {
        this.eAF.addAll(list);
    }

    public void cp(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.eAF.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void aML() {
        this.eAE.clear();
    }

    public Set<Long> aMM() {
        return this.eAE;
    }

    public void g(Long l) {
        if (com.baidu.adp.lib.util.l.la()) {
            if (this.eAE.contains(l)) {
                this.eAE.remove(l);
            } else {
                this.eAE.add(l);
            }
            notifyDataSetChanged();
            if (this.eAA != null) {
                this.eAA.oJ(this.eAE.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.eAF.clear();
        }
        this.eAC = false;
        this.eAB = true;
    }

    public l(MembersActivity membersActivity) {
        this.eAz = membersActivity;
    }

    public void hV(boolean z) {
        this.eAB = z;
    }

    public boolean alz() {
        return this.eAB;
    }

    public void hW(boolean z) {
        this.eAC = z;
    }

    public boolean aJR() {
        return this.eAD;
    }

    public void hX(boolean z) {
        this.eAD = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eAF != null) {
            int size = this.eAF.size();
            if (this.eAC) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.d(this.eAF, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.eAC && i == getCount() - 1) {
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
        if (this.eAF != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.eAz.getPageContext().getPageActivity()).inflate(e.h.im_members_list_foot, viewGroup, false);
                    bVar2.eAI = (LinearLayout) inflate.findViewById(e.g.list_more);
                    bVar2.eAJ = (TextView) inflate.findViewById(e.g.more_title);
                    bVar2.eAK = (ProgressBar) inflate.findViewById(e.g.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.eAz.getPageContext().getPageActivity()).inflate(e.h.im_members_list_item, viewGroup, false);
                    bVar2.eAM = (HeadImageView) inflate2.findViewById(e.g.item_head);
                    bVar2.eAM.setIsRound(false);
                    bVar2.eAM.setAutoChangeStyle(true);
                    bVar2.ezA = (TextView) inflate2.findViewById(e.g.item_name);
                    bVar2.eAN = (ImageView) inflate2.findViewById(e.g.item_sex);
                    bVar2.eAO = (TextView) inflate2.findViewById(e.g.item_time);
                    bVar2.eAP = (TextView) inflate2.findViewById(e.g.item_address);
                    bVar2.eAL = (ImageView) inflate2.findViewById(e.g.item_check);
                    bVar2.aBs = (UserIconBox) inflate2.findViewById(e.g.user_tshow_icon_box);
                    bVar2.eAQ = inflate2.findViewById(e.g.list_line);
                    bVar2.eAR = inflate2.findViewById(e.g.list_bottom_line);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.eAQ.setVisibility(i < getCount() + (-1) ? 0 : 8);
            bVar.eAR.setVisibility(i < getCount() + (-1) ? 8 : 0);
            if (getItemViewType(i) == 1) {
                if (this.eAB) {
                    bVar.eAJ.setText(e.j.members_load_more_person);
                    bVar.eAK.setVisibility(0);
                } else {
                    bVar.eAJ.setText(e.j.members_no_more_person);
                    bVar.eAK.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.eAM.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!ao.isEmpty(portrait)) {
                        bVar.eAM.startLoad(portrait, 12, false);
                    }
                    bVar.ezA.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.eAN.setVisibility(0);
                            al.c(bVar.eAN, e.f.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.eAN.setVisibility(0);
                            al.c(bVar.eAN, e.f.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.eAN.setVisibility(8);
                            break;
                    }
                    bVar.eAO.setText(d(userData));
                    bVar.eAP.setText(userData.getPosition());
                    this.eAG = userData.getTShowInfo();
                    if (bVar.aBs != null) {
                        bVar.aBs.a(this.eAG, 2, this.eAz.getResources().getDimensionPixelSize(e.C0141e.ds38), this.eAz.getResources().getDimensionPixelSize(e.C0141e.ds38), this.eAz.getResources().getDimensionPixelSize(e.C0141e.ds8), true);
                    }
                    if (this.eAD) {
                        bVar.eAL.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.eAL.setTag(valueOf);
                        bVar.eAL.setSelected(this.eAE.contains(valueOf));
                        bVar.eAL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.eAE.add(l);
                                    } else {
                                        l.this.eAE.remove(l);
                                    }
                                    if (l.this.eAA != null) {
                                        l.this.eAA.oJ(l.this.eAE.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.eAL.setVisibility(8);
                    }
                    aW(view);
                }
            }
        }
        return view;
    }

    private void aW(View view) {
        this.eAz.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eAz.getLayoutMode().onModeChanged(view);
    }

    private String d(UserData userData) {
        long lastReplyTime;
        MembersModel aMF = this.eAz.aMF();
        switch (aMF.getOrderType()) {
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
            if (aMF.getOrderType() == 1) {
                return this.eAz.getPageContext().getString(e.j.members_no_speak);
            }
            return "";
        }
        return ao.g(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes3.dex */
    static class b {
        UserIconBox aBs = null;
        LinearLayout eAI;
        TextView eAJ;
        ProgressBar eAK;
        ImageView eAL;
        HeadImageView eAM;
        ImageView eAN;
        TextView eAO;
        TextView eAP;
        View eAQ;
        View eAR;
        TextView ezA;

        b() {
        }
    }
}
