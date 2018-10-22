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
    private final MembersActivity eIk;
    private a eIl;
    private boolean eIm;
    private boolean eIo;
    private final Set<Long> eIp = new HashSet();
    private final List<UserData> eIq = new ArrayList();
    private ArrayList<IconData> eIr = null;
    private boolean eIn = false;

    /* loaded from: classes3.dex */
    public interface a {
        void ph(int i);
    }

    public void a(a aVar) {
        this.eIl = aVar;
    }

    public void cD(List<UserData> list) {
        this.eIq.addAll(list);
    }

    public void cE(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.eIq.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void aQa() {
        this.eIp.clear();
    }

    public Set<Long> aQb() {
        return this.eIp;
    }

    public void g(Long l) {
        if (com.baidu.adp.lib.util.l.ln()) {
            if (this.eIp.contains(l)) {
                this.eIp.remove(l);
            } else {
                this.eIp.add(l);
            }
            notifyDataSetChanged();
            if (this.eIl != null) {
                this.eIl.ph(this.eIp.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.eIq.clear();
        }
        this.eIn = false;
        this.eIm = true;
    }

    public l(MembersActivity membersActivity) {
        this.eIk = membersActivity;
    }

    public void in(boolean z) {
        this.eIm = z;
    }

    public boolean apc() {
        return this.eIm;
    }

    public void io(boolean z) {
        this.eIn = z;
    }

    public boolean aNh() {
        return this.eIo;
    }

    public void ip(boolean z) {
        this.eIo = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eIq != null) {
            int size = this.eIq.size();
            if (this.eIn) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.d(this.eIq, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.eIn && i == getCount() - 1) {
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
        if (this.eIq != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.eIk.getPageContext().getPageActivity()).inflate(e.h.im_members_list_foot, viewGroup, false);
                    bVar2.eIt = (LinearLayout) inflate.findViewById(e.g.list_more);
                    bVar2.eIu = (TextView) inflate.findViewById(e.g.more_title);
                    bVar2.eIv = (ProgressBar) inflate.findViewById(e.g.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.eIk.getPageContext().getPageActivity()).inflate(e.h.im_members_list_item, viewGroup, false);
                    bVar2.eIx = (HeadImageView) inflate2.findViewById(e.g.item_head);
                    bVar2.eIx.setIsRound(false);
                    bVar2.eIx.setAutoChangeStyle(true);
                    bVar2.eHl = (TextView) inflate2.findViewById(e.g.item_name);
                    bVar2.eIy = (ImageView) inflate2.findViewById(e.g.item_sex);
                    bVar2.eIz = (TextView) inflate2.findViewById(e.g.item_time);
                    bVar2.eIA = (TextView) inflate2.findViewById(e.g.item_address);
                    bVar2.eIw = (ImageView) inflate2.findViewById(e.g.item_check);
                    bVar2.aFY = (UserIconBox) inflate2.findViewById(e.g.user_tshow_icon_box);
                    bVar2.eIB = inflate2.findViewById(e.g.list_line);
                    bVar2.eIC = inflate2.findViewById(e.g.list_bottom_line);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.eIB.setVisibility(i < getCount() + (-1) ? 0 : 8);
            bVar.eIC.setVisibility(i < getCount() + (-1) ? 8 : 0);
            if (getItemViewType(i) == 1) {
                if (this.eIm) {
                    bVar.eIu.setText(e.j.members_load_more_person);
                    bVar.eIv.setVisibility(0);
                } else {
                    bVar.eIu.setText(e.j.members_no_more_person);
                    bVar.eIv.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.eIx.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!ao.isEmpty(portrait)) {
                        bVar.eIx.startLoad(portrait, 12, false);
                    }
                    bVar.eHl.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.eIy.setVisibility(0);
                            al.c(bVar.eIy, e.f.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.eIy.setVisibility(0);
                            al.c(bVar.eIy, e.f.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.eIy.setVisibility(8);
                            break;
                    }
                    bVar.eIz.setText(d(userData));
                    bVar.eIA.setText(userData.getPosition());
                    this.eIr = userData.getTShowInfo();
                    if (bVar.aFY != null) {
                        bVar.aFY.a(this.eIr, 2, this.eIk.getResources().getDimensionPixelSize(e.C0175e.ds38), this.eIk.getResources().getDimensionPixelSize(e.C0175e.ds38), this.eIk.getResources().getDimensionPixelSize(e.C0175e.ds8), true);
                    }
                    if (this.eIo) {
                        bVar.eIw.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.eIw.setTag(valueOf);
                        bVar.eIw.setSelected(this.eIp.contains(valueOf));
                        bVar.eIw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.eIp.add(l);
                                    } else {
                                        l.this.eIp.remove(l);
                                    }
                                    if (l.this.eIl != null) {
                                        l.this.eIl.ph(l.this.eIp.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.eIw.setVisibility(8);
                    }
                    aW(view);
                }
            }
        }
        return view;
    }

    private void aW(View view) {
        this.eIk.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eIk.getLayoutMode().onModeChanged(view);
    }

    private String d(UserData userData) {
        long lastReplyTime;
        MembersModel aPU = this.eIk.aPU();
        switch (aPU.getOrderType()) {
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
            if (aPU.getOrderType() == 1) {
                return this.eIk.getPageContext().getString(e.j.members_no_speak);
            }
            return "";
        }
        return ao.g(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes3.dex */
    static class b {
        UserIconBox aFY = null;
        TextView eHl;
        TextView eIA;
        View eIB;
        View eIC;
        LinearLayout eIt;
        TextView eIu;
        ProgressBar eIv;
        ImageView eIw;
        HeadImageView eIx;
        ImageView eIy;
        TextView eIz;

        b() {
        }
    }
}
