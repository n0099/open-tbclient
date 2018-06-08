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
    private final MembersActivity elv;
    private a elw;
    private boolean elx;
    private boolean elz;
    private final Set<Long> elA = new HashSet();
    private final List<UserData> elB = new ArrayList();
    private ArrayList<IconData> elC = null;
    private boolean ely = false;

    /* loaded from: classes3.dex */
    public interface a {
        void nK(int i);
    }

    public void a(a aVar) {
        this.elw = aVar;
    }

    public void cj(List<UserData> list) {
        this.elB.addAll(list);
    }

    public void ck(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.elB.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void aIR() {
        this.elA.clear();
    }

    public Set<Long> aIS() {
        return this.elA;
    }

    public void g(Long l) {
        if (com.baidu.adp.lib.util.l.jT()) {
            if (this.elA.contains(l)) {
                this.elA.remove(l);
            } else {
                this.elA.add(l);
            }
            notifyDataSetChanged();
            if (this.elw != null) {
                this.elw.nK(this.elA.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.elB.clear();
        }
        this.ely = false;
        this.elx = true;
    }

    public l(MembersActivity membersActivity) {
        this.elv = membersActivity;
    }

    public void hk(boolean z) {
        this.elx = z;
    }

    public boolean ajT() {
        return this.elx;
    }

    public void hl(boolean z) {
        this.ely = z;
    }

    public boolean aFX() {
        return this.elz;
    }

    public void hm(boolean z) {
        this.elz = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.elB != null) {
            int size = this.elB.size();
            if (this.ely) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return w.c(this.elB, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.ely && i == getCount() - 1) {
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
        if (this.elB != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.elv.getPageContext().getPageActivity()).inflate(d.i.im_members_list_foot, viewGroup, false);
                    bVar2.elE = (LinearLayout) inflate.findViewById(d.g.list_more);
                    bVar2.elF = (TextView) inflate.findViewById(d.g.more_title);
                    bVar2.elG = (ProgressBar) inflate.findViewById(d.g.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.elv.getPageContext().getPageActivity()).inflate(d.i.im_members_list_item, viewGroup, false);
                    bVar2.elI = (HeadImageView) inflate2.findViewById(d.g.item_head);
                    bVar2.elI.setIsRound(false);
                    bVar2.elI.setAutoChangeStyle(true);
                    bVar2.ekx = (TextView) inflate2.findViewById(d.g.item_name);
                    bVar2.elJ = (ImageView) inflate2.findViewById(d.g.item_sex);
                    bVar2.elK = (TextView) inflate2.findViewById(d.g.item_time);
                    bVar2.elL = (TextView) inflate2.findViewById(d.g.item_address);
                    bVar2.elH = (ImageView) inflate2.findViewById(d.g.item_check);
                    bVar2.axT = (UserIconBox) inflate2.findViewById(d.g.user_tshow_icon_box);
                    bVar2.elM = inflate2.findViewById(d.g.list_line);
                    bVar2.elN = inflate2.findViewById(d.g.list_bottom_line);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.elM.setVisibility(i < getCount() + (-1) ? 0 : 8);
            bVar.elN.setVisibility(i < getCount() + (-1) ? 8 : 0);
            if (getItemViewType(i) == 1) {
                if (this.elx) {
                    bVar.elF.setText(d.k.members_load_more_person);
                    bVar.elG.setVisibility(0);
                } else {
                    bVar.elF.setText(d.k.members_no_more_person);
                    bVar.elG.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.elI.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!ao.isEmpty(portrait)) {
                        bVar.elI.startLoad(portrait, 12, false);
                    }
                    bVar.ekx.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.elJ.setVisibility(0);
                            al.c(bVar.elJ, d.f.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.elJ.setVisibility(0);
                            al.c(bVar.elJ, d.f.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.elJ.setVisibility(8);
                            break;
                    }
                    bVar.elK.setText(d(userData));
                    bVar.elL.setText(userData.getPosition());
                    this.elC = userData.getTShowInfo();
                    if (bVar.axT != null) {
                        bVar.axT.a(this.elC, 2, this.elv.getResources().getDimensionPixelSize(d.e.ds38), this.elv.getResources().getDimensionPixelSize(d.e.ds38), this.elv.getResources().getDimensionPixelSize(d.e.ds8), true);
                    }
                    if (this.elz) {
                        bVar.elH.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.elH.setTag(valueOf);
                        bVar.elH.setSelected(this.elA.contains(valueOf));
                        bVar.elH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.elA.add(l);
                                    } else {
                                        l.this.elA.remove(l);
                                    }
                                    if (l.this.elw != null) {
                                        l.this.elw.nK(l.this.elA.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.elH.setVisibility(8);
                    }
                    aD(view);
                }
            }
        }
        return view;
    }

    private void aD(View view) {
        this.elv.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.elv.getLayoutMode().onModeChanged(view);
    }

    private String d(UserData userData) {
        long lastReplyTime;
        MembersModel aIL = this.elv.aIL();
        switch (aIL.getOrderType()) {
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
            if (aIL.getOrderType() == 1) {
                return this.elv.getPageContext().getString(d.k.members_no_speak);
            }
            return "";
        }
        return ao.h(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes3.dex */
    static class b {
        UserIconBox axT = null;
        TextView ekx;
        LinearLayout elE;
        TextView elF;
        ProgressBar elG;
        ImageView elH;
        HeadImageView elI;
        ImageView elJ;
        TextView elK;
        TextView elL;
        View elM;
        View elN;

        b() {
        }
    }
}
