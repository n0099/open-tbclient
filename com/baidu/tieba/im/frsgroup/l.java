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
    private final MembersActivity eIj;
    private a eIk;
    private boolean eIl;
    private boolean eIn;
    private final Set<Long> eIo = new HashSet();
    private final List<UserData> eIp = new ArrayList();
    private ArrayList<IconData> eIq = null;
    private boolean eIm = false;

    /* loaded from: classes3.dex */
    public interface a {
        void ph(int i);
    }

    public void a(a aVar) {
        this.eIk = aVar;
    }

    public void cD(List<UserData> list) {
        this.eIp.addAll(list);
    }

    public void cE(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.eIp.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void aQa() {
        this.eIo.clear();
    }

    public Set<Long> aQb() {
        return this.eIo;
    }

    public void g(Long l) {
        if (com.baidu.adp.lib.util.l.ln()) {
            if (this.eIo.contains(l)) {
                this.eIo.remove(l);
            } else {
                this.eIo.add(l);
            }
            notifyDataSetChanged();
            if (this.eIk != null) {
                this.eIk.ph(this.eIo.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.eIp.clear();
        }
        this.eIm = false;
        this.eIl = true;
    }

    public l(MembersActivity membersActivity) {
        this.eIj = membersActivity;
    }

    public void in(boolean z) {
        this.eIl = z;
    }

    public boolean apb() {
        return this.eIl;
    }

    public void io(boolean z) {
        this.eIm = z;
    }

    public boolean aNh() {
        return this.eIn;
    }

    public void ip(boolean z) {
        this.eIn = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eIp != null) {
            int size = this.eIp.size();
            if (this.eIm) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.d(this.eIp, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.eIm && i == getCount() - 1) {
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
        if (this.eIp != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.eIj.getPageContext().getPageActivity()).inflate(e.h.im_members_list_foot, viewGroup, false);
                    bVar2.eIs = (LinearLayout) inflate.findViewById(e.g.list_more);
                    bVar2.eIt = (TextView) inflate.findViewById(e.g.more_title);
                    bVar2.eIu = (ProgressBar) inflate.findViewById(e.g.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.eIj.getPageContext().getPageActivity()).inflate(e.h.im_members_list_item, viewGroup, false);
                    bVar2.eIw = (HeadImageView) inflate2.findViewById(e.g.item_head);
                    bVar2.eIw.setIsRound(false);
                    bVar2.eIw.setAutoChangeStyle(true);
                    bVar2.eHk = (TextView) inflate2.findViewById(e.g.item_name);
                    bVar2.eIx = (ImageView) inflate2.findViewById(e.g.item_sex);
                    bVar2.eIy = (TextView) inflate2.findViewById(e.g.item_time);
                    bVar2.eIz = (TextView) inflate2.findViewById(e.g.item_address);
                    bVar2.eIv = (ImageView) inflate2.findViewById(e.g.item_check);
                    bVar2.aFY = (UserIconBox) inflate2.findViewById(e.g.user_tshow_icon_box);
                    bVar2.eIA = inflate2.findViewById(e.g.list_line);
                    bVar2.eIB = inflate2.findViewById(e.g.list_bottom_line);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.eIA.setVisibility(i < getCount() + (-1) ? 0 : 8);
            bVar.eIB.setVisibility(i < getCount() + (-1) ? 8 : 0);
            if (getItemViewType(i) == 1) {
                if (this.eIl) {
                    bVar.eIt.setText(e.j.members_load_more_person);
                    bVar.eIu.setVisibility(0);
                } else {
                    bVar.eIt.setText(e.j.members_no_more_person);
                    bVar.eIu.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.eIw.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!ao.isEmpty(portrait)) {
                        bVar.eIw.startLoad(portrait, 12, false);
                    }
                    bVar.eHk.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.eIx.setVisibility(0);
                            al.c(bVar.eIx, e.f.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.eIx.setVisibility(0);
                            al.c(bVar.eIx, e.f.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.eIx.setVisibility(8);
                            break;
                    }
                    bVar.eIy.setText(d(userData));
                    bVar.eIz.setText(userData.getPosition());
                    this.eIq = userData.getTShowInfo();
                    if (bVar.aFY != null) {
                        bVar.aFY.a(this.eIq, 2, this.eIj.getResources().getDimensionPixelSize(e.C0175e.ds38), this.eIj.getResources().getDimensionPixelSize(e.C0175e.ds38), this.eIj.getResources().getDimensionPixelSize(e.C0175e.ds8), true);
                    }
                    if (this.eIn) {
                        bVar.eIv.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.eIv.setTag(valueOf);
                        bVar.eIv.setSelected(this.eIo.contains(valueOf));
                        bVar.eIv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.eIo.add(l);
                                    } else {
                                        l.this.eIo.remove(l);
                                    }
                                    if (l.this.eIk != null) {
                                        l.this.eIk.ph(l.this.eIo.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.eIv.setVisibility(8);
                    }
                    aW(view);
                }
            }
        }
        return view;
    }

    private void aW(View view) {
        this.eIj.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eIj.getLayoutMode().onModeChanged(view);
    }

    private String d(UserData userData) {
        long lastReplyTime;
        MembersModel aPU = this.eIj.aPU();
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
                return this.eIj.getPageContext().getString(e.j.members_no_speak);
            }
            return "";
        }
        return ao.g(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes3.dex */
    static class b {
        UserIconBox aFY = null;
        TextView eHk;
        View eIA;
        View eIB;
        LinearLayout eIs;
        TextView eIt;
        ProgressBar eIu;
        ImageView eIv;
        HeadImageView eIw;
        ImageView eIx;
        TextView eIy;
        TextView eIz;

        b() {
        }
    }
}
