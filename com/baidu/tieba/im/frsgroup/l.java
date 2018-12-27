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
    private final MembersActivity eTi;
    private a eTj;
    private boolean eTk;
    private boolean eTm;
    private final Set<Long> eTn = new HashSet();
    private final List<UserData> eTo = new ArrayList();
    private ArrayList<IconData> eTp = null;
    private boolean eTl = false;

    /* loaded from: classes3.dex */
    public interface a {
        void qh(int i);
    }

    public void a(a aVar) {
        this.eTj = aVar;
    }

    public void cG(List<UserData> list) {
        this.eTo.addAll(list);
    }

    public void cH(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.eTo.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void aSc() {
        this.eTn.clear();
    }

    public Set<Long> aSd() {
        return this.eTn;
    }

    public void h(Long l) {
        if (com.baidu.adp.lib.util.l.lk()) {
            if (this.eTn.contains(l)) {
                this.eTn.remove(l);
            } else {
                this.eTn.add(l);
            }
            notifyDataSetChanged();
            if (this.eTj != null) {
                this.eTj.qh(this.eTn.size());
            }
        }
    }

    public void reset(boolean z) {
        if (z) {
            this.eTo.clear();
        }
        this.eTl = false;
        this.eTk = true;
    }

    public l(MembersActivity membersActivity) {
        this.eTi = membersActivity;
    }

    public void iC(boolean z) {
        this.eTk = z;
    }

    public boolean arf() {
        return this.eTk;
    }

    public void iD(boolean z) {
        this.eTl = z;
    }

    public boolean aPk() {
        return this.eTm;
    }

    public void iE(boolean z) {
        this.eTm = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eTo != null) {
            int size = this.eTo.size();
            if (this.eTl) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.d(this.eTo, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.eTl && i == getCount() - 1) {
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
        if (this.eTo != null) {
            if (view == null) {
                b bVar2 = new b();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.eTi.getPageContext().getPageActivity()).inflate(e.h.im_members_list_foot, viewGroup, false);
                    bVar2.eTr = (LinearLayout) inflate.findViewById(e.g.list_more);
                    bVar2.eTs = (TextView) inflate.findViewById(e.g.more_title);
                    bVar2.eTt = (ProgressBar) inflate.findViewById(e.g.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.eTi.getPageContext().getPageActivity()).inflate(e.h.im_members_list_item, viewGroup, false);
                    bVar2.eTv = (HeadImageView) inflate2.findViewById(e.g.item_head);
                    bVar2.eTv.setIsRound(false);
                    bVar2.eTv.setAutoChangeStyle(true);
                    bVar2.eSj = (TextView) inflate2.findViewById(e.g.item_name);
                    bVar2.eTw = (ImageView) inflate2.findViewById(e.g.item_sex);
                    bVar2.eTx = (TextView) inflate2.findViewById(e.g.item_time);
                    bVar2.eTy = (TextView) inflate2.findViewById(e.g.item_address);
                    bVar2.eTu = (ImageView) inflate2.findViewById(e.g.item_check);
                    bVar2.aKq = (UserIconBox) inflate2.findViewById(e.g.user_tshow_icon_box);
                    bVar2.eTz = inflate2.findViewById(e.g.list_line);
                    bVar2.eTA = inflate2.findViewById(e.g.list_bottom_line);
                    view2 = inflate2;
                }
                view2.setTag(bVar2);
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.eTz.setVisibility(i < getCount() + (-1) ? 0 : 8);
            bVar.eTA.setVisibility(i < getCount() + (-1) ? 8 : 0);
            if (getItemViewType(i) == 1) {
                if (this.eTk) {
                    bVar.eTs.setText(e.j.members_load_more_person);
                    bVar.eTt.setVisibility(0);
                } else {
                    bVar.eTs.setText(e.j.members_no_more_person);
                    bVar.eTt.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                if (userData != null) {
                    bVar.eTv.setTag(null);
                    String portrait = userData.getPortrait();
                    if (!ao.isEmpty(portrait)) {
                        bVar.eTv.startLoad(portrait, 12, false);
                    }
                    bVar.eSj.setText(userData.getName_show());
                    switch (userData.getSex()) {
                        case 1:
                            bVar.eTw.setVisibility(0);
                            al.c(bVar.eTw, e.f.icon_pop_qz_boy);
                            break;
                        case 2:
                            bVar.eTw.setVisibility(0);
                            al.c(bVar.eTw, e.f.icon_pop_qz_girl);
                            break;
                        default:
                            bVar.eTw.setVisibility(8);
                            break;
                    }
                    bVar.eTx.setText(d(userData));
                    bVar.eTy.setText(userData.getPosition());
                    this.eTp = userData.getTShowInfo();
                    if (bVar.aKq != null) {
                        bVar.aKq.a(this.eTp, 2, this.eTi.getResources().getDimensionPixelSize(e.C0210e.ds38), this.eTi.getResources().getDimensionPixelSize(e.C0210e.ds38), this.eTi.getResources().getDimensionPixelSize(e.C0210e.ds8), true);
                    }
                    if (this.eTm) {
                        bVar.eTu.setVisibility(userData.getPermission().isController() ? 4 : 0);
                        Long valueOf = Long.valueOf(userData.getUserIdLong());
                        bVar.eTu.setTag(valueOf);
                        bVar.eTu.setSelected(this.eTn.contains(valueOf));
                        bVar.eTu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.frsgroup.l.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                view3.setSelected(!view3.isSelected());
                                if (view3.getTag() instanceof Long) {
                                    Long l = (Long) view3.getTag();
                                    if (view3.isSelected()) {
                                        l.this.eTn.add(l);
                                    } else {
                                        l.this.eTn.remove(l);
                                    }
                                    if (l.this.eTj != null) {
                                        l.this.eTj.qh(l.this.eTn.size());
                                    }
                                }
                            }
                        });
                    } else {
                        bVar.eTu.setVisibility(8);
                    }
                    bb(view);
                }
            }
        }
        return view;
    }

    private void bb(View view) {
        this.eTi.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eTi.getLayoutMode().onModeChanged(view);
    }

    private String d(UserData userData) {
        long lastReplyTime;
        MembersModel aRW = this.eTi.aRW();
        switch (aRW.getOrderType()) {
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
            if (aRW.getOrderType() == 1) {
                return this.eTi.getPageContext().getString(e.j.members_no_speak);
            }
            return "";
        }
        return ao.g(new Date(lastReplyTime * 1000));
    }

    /* loaded from: classes3.dex */
    static class b {
        UserIconBox aKq = null;
        TextView eSj;
        View eTA;
        LinearLayout eTr;
        TextView eTs;
        ProgressBar eTt;
        ImageView eTu;
        HeadImageView eTv;
        ImageView eTw;
        TextView eTx;
        TextView eTy;
        View eTz;

        b() {
        }
    }
}
